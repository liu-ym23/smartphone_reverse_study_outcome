package com.bytedance.ee.bear.doc.follow;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class FollowInvokeResult implements NonProguard {
    public String callbackId;
    public String funcName;
    public String metaJson;
    public String resultJson;
    public String token;

    public FollowInvokeResult() {
    }

    public FollowInvokeResult(String r1, String r2, String r3, String r4) {
        this.token = r1;
        this.resultJson = r2;
        this.callbackId = r3;
        this.metaJson = r4;
    }
}
