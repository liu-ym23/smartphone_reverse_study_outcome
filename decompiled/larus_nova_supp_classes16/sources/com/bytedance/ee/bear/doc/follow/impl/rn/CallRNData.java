package com.bytedance.ee.bear.doc.follow.impl.rn;

import com.alibaba.fastjson.JSON;
import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class CallRNData implements NonProguard {
    public String business;
    public Data data;

    public static class Data implements NonProguard {
        public NonProguard body;
        public String operation;

        public Data() {
        }
    }

    public CallRNData() {
        this.business = "base";
    }

    public static String buildJson(String r2, NonProguard r3) {
        CallRNData r0 = new CallRNData();
        Data r1 = new Data();
        r0.data = r1;
        r1.operation = r2;
        r1.body = r3;
        return JSON.toJSONString(r0);
    }
}
