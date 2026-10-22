package com.huawei.hms.support.api.client;

/* JADX INFO: loaded from: classes23.dex */
public class SubAppInfo {
    private String subAppID;

    public String getSubAppID() {
        return this.subAppID;
    }

    public SubAppInfo(SubAppInfo r100) {
        if (r100 == null) goto L6;
        this.subAppID = r100.getSubAppID();
        return;
    }

    public void setSubAppInfoID(String r100) {
        this.subAppID = r100;
    }

    public SubAppInfo(String r100) {
        this.subAppID = r100;
    }
}
