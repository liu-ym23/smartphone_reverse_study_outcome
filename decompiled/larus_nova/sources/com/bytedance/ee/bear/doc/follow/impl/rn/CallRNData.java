package com.bytedance.ee.bear.doc.follow.impl.rn;

import com.alibaba.fastjson.JSON;
import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: classes16.dex */
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

    public static String buildJson(String r100, NonProguard r101) {
        CallRNData r102 = new CallRNData();
        Data r103 = new Data();
        r102.data = r103;
        r103.operation = r100;
        r103.body = r101;
        return JSON.toJSONString(r102);
    }
}
