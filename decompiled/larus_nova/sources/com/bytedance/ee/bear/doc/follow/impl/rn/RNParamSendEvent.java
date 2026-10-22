package com.bytedance.ee.bear.doc.follow.impl.rn;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: classes16.dex */
public class RNParamSendEvent implements NonProguard {
    public String dataJson;
    public String eventType;
    public String module;
    public String token;

    public RNParamSendEvent() {
    }

    public RNParamSendEvent(String r100, String r101, String r102, String r103) {
        this.token = r100;
        this.module = r101;
        this.eventType = r102;
        this.dataJson = r103;
    }
}
