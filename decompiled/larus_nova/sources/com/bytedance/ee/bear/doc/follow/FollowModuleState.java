package com.bytedance.ee.bear.doc.follow;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: classes16.dex */
public class FollowModuleState implements NonProguard {
    public String actionType;
    public String data;
    public String module;

    public String toString() {
        return "FollowModuleState{module='" + this.module + "', actionType='" + this.actionType + "'}";
    }

    public FollowModuleState() {
    }

    public FollowModuleState(String r100, String r101, String r102) {
        this.module = r100;
        this.actionType = r101;
        this.data = r102;
    }
}
