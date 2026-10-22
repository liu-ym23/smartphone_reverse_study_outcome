package com.bytedance.ee.bear.document.offline.file.upload;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: classes16.dex */
public class CancelUploadModel implements NonProguard {
    private String contentType;
    private String fileName;
    private String fileUrl;
    private Boolean needDeleteFile;
    private String token;
    private String uuid;

    public CancelUploadModel() {
    }

    public String getContentType() {
        return this.contentType;
    }

    public String getFileName() {
        return this.fileName;
    }

    public String getFileUrl() {
        return this.fileUrl;
    }

    public Boolean getNeedDeleteFile() {
        return this.needDeleteFile;
    }

    public String getToken() {
        return this.token;
    }

    public String getUuid() {
        return this.uuid;
    }

    public void setContentType(String r100) {
        this.contentType = r100;
    }

    public void setFileName(String r100) {
        this.fileName = r100;
    }

    public void setFileUrl(String r100) {
        this.fileUrl = r100;
    }

    public void setNeedDeleteFile(Boolean r100) {
        this.needDeleteFile = r100;
    }

    public void setToken(String r100) {
        this.token = r100;
    }

    public void setUuid(String r100) {
        this.uuid = r100;
    }
}
