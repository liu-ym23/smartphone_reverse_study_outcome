package com.bytedance.ee.bear.drive.module.nativepreview.model;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class DrivePreviewOpenModel implements NonProguard {
    private String appId;
    private String authExtra;
    private String fileId;
    private String fileName;
    private String fileType;
    private String mountNodeToken;
    private String mountPoint;
    private String prewiewFrom;

    public String getAppId() {
        return this.appId;
    }

    public String getAuthExtra() {
        return this.authExtra;
    }

    public String getFileId() {
        return this.fileId;
    }

    public String getFileName() {
        return this.fileName;
    }

    public String getFileType() {
        return this.fileType;
    }

    public String getMountNodeToken() {
        return this.mountNodeToken;
    }

    public String getMountPoint() {
        return this.mountPoint;
    }

    public String getPrewiewFrom() {
        return this.prewiewFrom;
    }

    public void setAppId(String r1) {
        this.appId = r1;
    }

    public void setAuthExtra(String r1) {
        this.authExtra = r1;
    }

    public void setFileId(String r1) {
        this.fileId = r1;
    }

    public void setFileName(String r1) {
        this.fileName = r1;
    }

    public void setFileType(String r1) {
        this.fileType = r1;
    }

    public void setMountNodeToken(String r1) {
        this.mountNodeToken = r1;
    }

    public void setMountPoint(String r1) {
        this.mountPoint = r1;
    }

    public void setPrewiewFrom(String r1) {
        this.prewiewFrom = r1;
    }

    public DrivePreviewOpenModel(String r1, String r2, String r3) {
        this.appId = r1;
        this.fileId = r2;
        this.fileName = r3;
    }
}
