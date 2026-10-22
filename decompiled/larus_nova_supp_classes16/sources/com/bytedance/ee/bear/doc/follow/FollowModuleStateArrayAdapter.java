package com.bytedance.ee.bear.doc.follow;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class FollowModuleStateArrayAdapter implements NonProguard {
    public String actionType;
    public JSONObject data;
    public String module;

    public FollowModuleStateArrayAdapter() {
    }

    public FollowModuleStateArrayAdapter(String r1, String r2, JSONObject r3) {
        this.module = r1;
        this.actionType = r2;
        this.data = r3;
    }

    public static String jsonString(String r2, String r3, FollowModuleState r4) {
        JSONObject r0 = new JSONObject();
        r0.put(r3, JSON.parseObject(r4.data));
        JSONObject r5 = new JSONObject();
        r5.put(r2, r0);
        return JSON.toJSONString(new FollowModuleStateArrayAdapter(r4.module, r4.actionType, r5));
    }
}
