package com.bytedance.ee.bear.attachment.filereader;

import java.io.Serializable;

/* JADX INFO: loaded from: classes15.dex */
public class FileDownloadModel implements Serializable {
    public static final int TYPE_NUT = 0;
    public static final int TYPE_TOS = 1;
    private String downloadPath;
    private String fileDriverKey;
    private String mountNodeToken;
    private String mountPoint;
    private String saveName;
    private String token;
    private int type;

    public String toString() {
        return "NutFileDownloadModel{token='" + du5.b.g(this.token) + "', type=" + this.type + ", mountNodeToken='" + du5.b.g(this.mountNodeToken) + "', mountPoint='" + this.mountPoint + "'}";
    }

    public FileDownloadModel() {
    }

    public String getDownloadPath() {
        return this.downloadPath;
    }

    public String getFileDriverKey() {
        return this.fileDriverKey;
    }

    public String getMountNodeToken() {
        return this.mountNodeToken;
    }

    public String getMountPoint() {
        return this.mountPoint;
    }

    public String getSaveName() {
        return this.saveName;
    }

    public String getToken() {
        return this.token;
    }

    public int getType() {
        return this.type;
    }

    public void setDownloadPath(String r100) {
        this.downloadPath = r100;
    }

    public void setFileDriverKey(String r100) {
        this.fileDriverKey = r100;
    }

    public void setMountNodeToken(String r100) {
        this.mountNodeToken = r100;
    }

    public void setMountPoint(String r100) {
        this.mountPoint = r100;
    }

    public void setSaveName(String r100) {
        this.saveName = r100;
    }

    public void setToken(String r100) {
        this.token = r100;
    }

    public void setType(int r100) {
        this.type = r100;
    }

    public FileDownloadModel(String r100, String r101, String r102, int r103) {
        this.fileDriverKey = r100;
        this.downloadPath = r101;
        this.saveName = r102;
        this.type = r103;
    }
}
