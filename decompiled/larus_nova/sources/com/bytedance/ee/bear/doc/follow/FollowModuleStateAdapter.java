package com.bytedance.ee.bear.doc.follow;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: classes16.dex */
public class FollowModuleStateAdapter implements NonProguard {
    public String actionType;
    public JSONObject data;
    public String module;

    public FollowModuleStateAdapter() {
    }

    public static String jsonString(FollowModuleState r100) {
        return JSON.toJSONString(new FollowModuleStateAdapter(r100.module, r100.actionType, JSON.parseObject(r100.data)));
    }

    public FollowModuleStateAdapter(String r100, String r101, JSONObject r102) {
        this.module = r100;
        this.actionType = r101;
        this.data = r102;
    }
}
