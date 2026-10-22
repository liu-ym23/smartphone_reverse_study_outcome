package com.bytedance.ee.bear.drive.loader.download.model.imfile;

import yu5.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
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

    public SdkPermissionModel(String r1, String r2, String r3, int r4, int r5, int r6) {
        this.appId = r1;
        this.appFileId = r2;
        this.authExtra = r3;
        this.view = r4;
        this.export = r5;
        this.copy = r6;
    }
}
