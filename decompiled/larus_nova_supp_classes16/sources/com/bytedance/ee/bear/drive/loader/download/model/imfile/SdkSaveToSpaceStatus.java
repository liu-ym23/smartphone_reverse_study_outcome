package com.bytedance.ee.bear.drive.loader.download.model.imfile;

import com.bytedance.ee.util.io.NonProguard;
import yu5.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class SdkSaveToSpaceStatus implements NonProguard {
    public static final int STATUS_FAILED_CANT_CROSS_TENANT = 90002103;
    public static final int STATUS_SAVED = 0;
    public static final int STATUS_SAVING = 90002101;
    private String fileToken;
    private int status;

    public String toString() {
        return "SdkSaveToSpaceStatus{status=" + this.status + ", fileToken='" + c.j(this.fileToken) + "'}";
    }

    public SdkSaveToSpaceStatus() {
        this.status = -1;
    }

    public String getFileToken() {
        return this.fileToken;
    }

    public int getStatus() {
        return this.status;
    }

    public SdkSaveToSpaceStatus(int r1) {
        this.status = r1;
    }

    public void setFileToken(String r1) {
        this.fileToken = r1;
    }

    public void setStatus(int r1) {
        this.status = r1;
    }

    public SdkSaveToSpaceStatus(int r1, String r2) {
        this.status = r1;
        this.fileToken = r2;
    }
}
