package com.bytedance.ee.bear.doc.follow;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: classes16.dex */
public class FollowModuleStateArrayAdapter implements NonProguard {
    public String actionType;
    public JSONObject data;
    public String module;

    public FollowModuleStateArrayAdapter() {
    }

    public FollowModuleStateArrayAdapter(String r100, String r101, JSONObject r102) {
        this.module = r100;
        this.actionType = r101;
        this.data = r102;
    }

    public static String jsonString(String r100, String r101, FollowModuleState r102) {
        JSONObject r103 = new JSONObject();
        r103.put2(r101, JSON.parseObject(r102.data));
        JSONObject r104 = new JSONObject();
        r104.put2(r100, r103);
        return JSON.toJSONString(new FollowModuleStateArrayAdapter(r102.module, r102.actionType, r104));
    }
}
