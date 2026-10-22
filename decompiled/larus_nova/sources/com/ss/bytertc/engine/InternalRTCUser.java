package com.ss.bytertc.engine;

/* JADX INFO: loaded from: classes40.dex */
public class InternalRTCUser {
    public String metaData;
    public String userId;

    public String toString() {
        return "InternalRtcUser{userId='" + this.userId + "', metaData='" + this.metaData + "'}";
    }

    public InternalRTCUser(String r100, String r101) {
        this.userId = r100;
        this.metaData = r101;
    }

    private static InternalRTCUser create(String r100, String r101) {
        return new InternalRTCUser(r100, r101);
    }
}
