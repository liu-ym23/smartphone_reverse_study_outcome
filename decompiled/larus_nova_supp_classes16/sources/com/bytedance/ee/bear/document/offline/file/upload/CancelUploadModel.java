package com.bytedance.ee.bear.document.offline.file.upload;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
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

    public void setContentType(String r1) {
        this.contentType = r1;
    }

    public void setFileName(String r1) {
        this.fileName = r1;
    }

    public void setFileUrl(String r1) {
        this.fileUrl = r1;
    }

    public void setNeedDeleteFile(Boolean r1) {
        this.needDeleteFile = r1;
    }

    public void setToken(String r1) {
        this.token = r1;
    }

    public void setUuid(String r1) {
        this.uuid = r1;
    }
}
