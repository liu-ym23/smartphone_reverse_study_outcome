package com.bytedance.ee.bear.doc.follow;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class FollowModuleState implements NonProguard {
    public String actionType;
    public String data;
    public String module;

    public String toString() {
        return "FollowModuleState{module='" + this.module + "', actionType='" + this.actionType + "'}";
    }

    public FollowModuleState() {
    }

    public FollowModuleState(String r1, String r2, String r3) {
        this.module = r1;
        this.actionType = r2;
        this.data = r3;
    }
}
