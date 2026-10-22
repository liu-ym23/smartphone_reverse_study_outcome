package com.bytedance.ee.bear.doc.follow.impl.rn;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: classes16.dex */
public class RNParamInvoke implements NonProguard {
    public String callbackId;
    public String funcName;
    public String metaJson;
    public String paramJson;
    public String token;

    public RNParamInvoke() {
    }

    public RNParamInvoke(String r100, String r101, String r102, String r103, String r104) {
        this.token = r100;
        this.funcName = r101;
        this.paramJson = r102;
        this.metaJson = r103;
        this.callbackId = r104;
    }
}
