package com.bytedance.ee.bear.doc.follow.impl.rn;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
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

    public RNFollowEvent(String r1, String r2, String r3, String r4, String r5) {
        this.token = r1;
        this.module = r2;
        this.eventType = r3;
        this.dataJson = r4;
        this.metaJson = r5;
    }
}
