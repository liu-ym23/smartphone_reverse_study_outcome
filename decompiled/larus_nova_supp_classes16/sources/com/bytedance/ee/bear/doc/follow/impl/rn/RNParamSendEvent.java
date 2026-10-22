package com.bytedance.ee.bear.doc.follow.impl.rn;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class RNParamSendEvent implements NonProguard {
    public String dataJson;
    public String eventType;
    public String module;
    public String token;

    public RNParamSendEvent() {
    }

    public RNParamSendEvent(String r1, String r2, String r3, String r4) {
        this.token = r1;
        this.module = r2;
        this.eventType = r3;
        this.dataJson = r4;
    }
}
