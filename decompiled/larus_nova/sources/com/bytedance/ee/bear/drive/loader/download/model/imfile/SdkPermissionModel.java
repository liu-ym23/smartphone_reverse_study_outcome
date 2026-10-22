package com.bytedance.ee.bear.drive.loader.download.model.imfile;

import yu5.c;

/* JADX INFO: loaded from: classes16.dex */
public final class SdkPermissionModel {
    private final String appFileId;
    private final String appId;
    private final String authExtra;
    private final int copy;
    private final int export;
    private final int view;

    public String toString() {
        return "SdkPermissionModel{appId='" + c.j(this.appId) + "', appFileId='" + c.j(this.appFileId) + "', authExtra='" + c.j(this.authExtra) + "', view=" + this.view + ", export=" + this.export + ", copy=" + this.copy + '}';
    }

    public String getAppFileId() {
        return this.appFileId;
    }

    public String getAppId() {
        return this.appId;
    }

    public String getAuthExtra() {
        return this.authExtra;
    }

    public int getCopy() {
        return this.copy;
    }

    public int getExport() {
        return this.export;
    }

    public int getView() {
        return this.view;
    }

    public SdkPermissionModel(String r100, String r101, String r102, int r103, int r104, int r105) {
        this.appId = r100;
        this.appFileId = r101;
        this.authExtra = r102;
        this.view = r103;
        this.export = r104;
        this.copy = r105;
    }
}
