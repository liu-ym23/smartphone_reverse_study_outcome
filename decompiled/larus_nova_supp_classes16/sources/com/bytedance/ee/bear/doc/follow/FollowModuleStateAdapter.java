package com.bytedance.ee.bear.doc.follow;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class FollowModuleStateAdapter implements NonProguard {
    public String actionType;
    public JSONObject data;
    public String module;

    public FollowModuleStateAdapter() {
    }

    public static String jsonString(FollowModuleState r3) {
        return JSON.toJSONString(new FollowModuleStateAdapter(r3.module, r3.actionType, JSON.parseObject(r3.data)));
    }

    public FollowModuleStateAdapter(String r1, String r2, JSONObject r3) {
        this.module = r1;
        this.actionType = r2;
        this.data = r3;
    }
}
