package com.bytedance.ee.bear.doc.follow.impl.rn;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: classes16.dex */
public class RNFollowEvent implements NonProguard {
    public String dataJson;
    public String eventType;
    public String metaJson;
    public String module;
    public String token;

    public String toString() {
        return "RNFollowEvent{token='" + this.token + "', module='" + this.module + "', eventType='" + this.eventType + "', dataJson='" + this.dataJson + "', metaJson='" + this.metaJson + "'}";
    }

    public RNFollowEvent() {
    }

    public RNFollowEvent(String r100, String r101, String r102, String r103, String r104) {
        this.token = r100;
        this.module = r101;
        this.eventType = r102;
        this.dataJson = r103;
        this.metaJson = r104;
    }
}
