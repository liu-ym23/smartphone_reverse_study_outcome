package com.ss.bytertc.engine;

/* JADX INFO: loaded from: classes40.dex */
public class UserInfo {
    public String extraInfo;
    public String uid;

    public String getExtraInfo() {
        return this.extraInfo;
    }

    public String getUid() {
        return this.uid;
    }

    public UserInfo(String r100, String r101) {
        this.uid = r100;
        this.extraInfo = r101;
    }

    public static UserInfo create(String r100, String r101) {
        return new UserInfo(r100, r101);
    }
}
