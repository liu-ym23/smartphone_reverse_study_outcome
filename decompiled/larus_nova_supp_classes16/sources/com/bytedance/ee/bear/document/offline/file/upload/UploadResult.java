package com.bytedance.ee.bear.document.offline.file.upload;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class UploadResult implements NonProguard {
    public static final int UPLOAD_CACELL = 1000;
    public static final int UPLOAD_SUCCESS = 0;
    private String cdn_url;
    private int code;
    private String decrypt_key;
    private String fileToken;
    private String file_key;
    private String message;
    private String thumbnail_url;
    private String url;

    public String toString() {
        return "UploadResult{code=" + this.code + ", message='" + this.message + "', file_token='" + yu5.c.j(this.fileToken) + "', url='" + yu5.c.j(this.url) + "', file_key='" + yu5.c.j(this.file_key) + "', decrypt_key='" + this.decrypt_key + "', cdn_url='" + yu5.c.j(this.cdn_url) + "', thumbnail_url='" + yu5.c.j(this.thumbnail_url) + "'}";
    }

    public UploadResult() {
        this.code = -1;
        this.message = "";
        this.url = "";
        this.file_key = "";
        this.decrypt_key = "";
        this.cdn_url = "";
        this.thumbnail_url = "";
    }

    public String getCdn_url() {
        return this.cdn_url;
    }

    public int getCode() {
        return this.code;
    }

    public String getDecrypt_key() {
        return this.decrypt_key;
    }

    public String getFileToken() {
        return this.fileToken;
    }

    public String getFile_key() {
        return this.file_key;
    }

    public String getMessage() {
        return this.message;
    }

    public String getThumbnail_url() {
        return this.thumbnail_url;
    }

    public String getUrl() {
        return this.url;
    }

    public void setCdn_url(String r1) {
        this.cdn_url = r1;
    }

    public void setCode(int r1) {
        this.code = r1;
    }

    public void setDecrypt_key(String r1) {
        this.decrypt_key = r1;
    }

    public void setFileToken(String r1) {
        this.fileToken = r1;
    }

    public void setFile_key(String r1) {
        this.file_key = r1;
    }

    public void setMessage(String r1) {
        this.message = r1;
    }

    public void setThumbnail_url(String r1) {
        this.thumbnail_url = r1;
    }

    public void setUrl(String r1) {
        this.url = r1;
    }
}
