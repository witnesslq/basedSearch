/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comm.basedSearch.elasticsearch;

import com.comm.basedSearch.service.UpdateService;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.junit.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 *
 * @author jasstion
 */
public class EsUpdateServiceTest {
   final static  UpdateService updaeService = new EsUpdateService("127.0.0.1:9300","elastic","changeme","elasticsearch");

    public EsUpdateServiceTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {


    }

    @After
    public void tearDown() {

    }

    /**
     * Test of update method, of class EsUpdateService.
     */
    @Test
    public void testUpdate() throws IOException {
        String testId = "11111107";
        Map<String, String> updatedMap = Maps.newHashMap();
        updatedMap.put("age", "1920");
        updatedMap.put("height", "1921");
        updatedMap.put("nickname", "jasstion2");
        updatedMap.put("id", testId);
        updatedMap.put("userID", testId);

        updatedMap.put("type", "user");
        updatedMap.put("index", "demo_user");
        //UpdateService updaeService = new EsUpdateService();
        String registeDate="2012-03-10T09:23:12";
        updatedMap.put("registeDate",registeDate);

        //地理位置
        updatedMap.put("location","31.9886993504,116.4907671752");
        updatedMap.put("isSearchSourceData","1");

        updaeService.update(updatedMap);

       

    }

    /**
     * Test of add method, of class EsUpdateService.
     */
    @Test
    public void testAdd() throws IOException {

        String testId = "11111107";
        Map<String, String> updatedMap = Maps.newHashMap();
        updatedMap.put("age", "1988");
        updatedMap.put("height", "1988");
        updatedMap.put("nickname", "jasstion1");
        updatedMap.put("id", testId);
        updatedMap.put("userID", testId);


        updatedMap.put("type", "user");
        updatedMap.put("index", "demo_user");
        String registeDate="2012-03-10T09:23:12";
        updatedMap.put("registeDate",registeDate);

        //地理位置
        updatedMap.put("location","39.9886993504,116.4907671752");
        //增加没有定义的字段检测 "dynamic": false 是否生效
        updatedMap.put("location1","39.9886993504,116.4907671752");
       //updatedMap.put("isSearchSourceData",null);





        updaeService.add(updatedMap);

//        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
//        searchSourceBuilder.query(QueryBuilders.idsQuery("user").ids(testId));
//        Search search = (Search) new Search.Builder(searchSourceBuilder.toString())
//                // multiple index or types can be added..
//                .addIndex("baihe_user")
//                .build();
//        JestResult result1 =JestMain.client.execute(search);
//        System.out.println(result1.getJsonString());

    }

    /**
     * Test of delete method, of class EsUpdateService.
     */
    @Test
    public void testDelete() {
        String testId = "111111";
        Map<String, String> updatedMap = Maps.newHashMap();


        updatedMap.put("id", testId);
        updatedMap.put("type", "user");
        updatedMap.put("index", "demo_user");





        updaeService.delete(updatedMap);


    }

    /**
     * Test of generateEsUpdateScriptFromMap method, of class EsUpdateService.
     */
    @Test
    public void testGenerateEsUpdateScriptFromMap() {
        Map<String, String> updatedMap = Maps.newHashMap();
        updatedMap.put("age", "1991");
        updatedMap.put("height", "1991");
        updatedMap.put("nickname", "jasstion");

       // String source_json = EsUpdateService.generateEsUpdateScriptFromMap(updatedMap);
       // System.out.print(source_json + "\n");

    }
    @Test
    public void testBulkUpdate()throws Exception{

        List<Map<String, String>> updatedMaps= Lists.newArrayList();
        Map<String, String> updatedMap = Maps.newHashMap();
        //updatedMap.put("nickname", "说好不哭11");
        updatedMap.put("id","11111106");

        // updatedMap.put("height","1988");
        String registeDate="2012-03-11T09:23:12";
        updatedMap.put("registeDate",registeDate);
        //TimeZone.setDefault(TimeZone.getTimeZone("GMT"));


        updatedMap.put("type", "user");
        updatedMap.put("index", "demo_user");
        Map<String, String> updatedMap1 = Maps.newHashMap();
        updatedMap1.put("id","11111107");
        updatedMap1.put("type", "user");
        updatedMap1.put("index", "demo_user");

        updatedMap1.put("nickname", "向阳花1111");
        updatedMap1.put("height","1988");

        updatedMaps.add(updatedMap);
        updatedMaps.add(updatedMap1);
      updaeService.bulkUpdate(updatedMaps);
       // esUpdateService.bulkUpdate(updatedMaps);

    }


}
