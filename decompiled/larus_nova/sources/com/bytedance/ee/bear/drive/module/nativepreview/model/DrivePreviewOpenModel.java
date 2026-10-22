package com.bytedance.ee.bear.drive.module.nativepreview.model;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: classes16.dex */
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

    public void setAppId(String r100) {
        this.appId = r100;
    }

    public void setAuthExtra(String r100) {
        this.authExtra = r100;
    }

    public void setFileId(String r100) {
        this.fileId = r100;
    }

    public void setFileName(String r100) {
        this.fileName = r100;
    }

    public void setFileType(String r100) {
        this.fileType = r100;
    }

    public void setMountNodeToken(String r100) {
        this.mountNodeToken = r100;
    }

    public void setMountPoint(String r100) {
        this.mountPoint = r100;
    }

    public void setPrewiewFrom(String r100) {
        this.prewiewFrom = r100;
    }

    public DrivePreviewOpenModel(String r100, String r101, String r102) {
        this.appId = r100;
        this.fileId = r101;
        this.fileName = r102;
    }
}
