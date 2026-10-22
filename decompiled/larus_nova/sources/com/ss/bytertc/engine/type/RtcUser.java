package com.ss.bytertc.engine.type;

import com.ss.bytertc.engine.InternalRTCUser;

/* JADX INFO: loaded from: classes40.dex */
public class RtcUser {
    public String metaData;
    public String userId;

    public RtcUser() {
    }

    public String toString() {
        return "RtcUser{uid='" + this.userId + "', metaData='" + this.metaData + "'}";
    }

    public RtcUser(InternalRTCUser r100) {
        this.userId = r100.userId;
        this.metaData = r100.metaData;
    }
}
