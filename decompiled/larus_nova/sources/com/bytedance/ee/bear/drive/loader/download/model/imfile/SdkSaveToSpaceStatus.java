package com.bytedance.ee.bear.drive.loader.download.model.imfile;

import com.bytedance.ee.util.io.NonProguard;
import yu5.c;

/* JADX INFO: loaded from: classes16.dex */
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

    public SdkSaveToSpaceStatus(int r100) {
        this.status = r100;
    }

    public void setFileToken(String r100) {
        this.fileToken = r100;
    }

    public void setStatus(int r100) {
        this.status = r100;
    }

    public SdkSaveToSpaceStatus(int r100, String r101) {
        this.status = r100;
        this.fileToken = r101;
    }
}
