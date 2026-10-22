package com.bytedance.ee.bear.doc.follow.impl.rn;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class RNParamInvoke implements NonProguard {
    public String callbackId;
    public String funcName;
    public String metaJson;
    public String paramJson;
    public String token;

    public RNParamInvoke() {
    }

    public RNParamInvoke(String r1, String r2, String r3, String r4, String r5) {
        this.token = r1;
        this.funcName = r2;
        this.paramJson = r3;
        this.metaJson = r4;
        this.callbackId = r5;
    }
}
