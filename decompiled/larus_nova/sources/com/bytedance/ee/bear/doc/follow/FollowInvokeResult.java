package com.bytedance.ee.bear.doc.follow;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: classes16.dex */
public class FollowInvokeResult implements NonProguard {
    public String callbackId;
    public String funcName;
    public String metaJson;
    public String resultJson;
    public String token;

    public FollowInvokeResult() {
    }

    public FollowInvokeResult(String r100, String r101, String r102, String r103) {
        this.token = r100;
        this.resultJson = r101;
        this.callbackId = r102;
        this.metaJson = r103;
    }
}
