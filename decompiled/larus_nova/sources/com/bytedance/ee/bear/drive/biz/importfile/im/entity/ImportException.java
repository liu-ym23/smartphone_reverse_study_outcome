package com.bytedance.ee.bear.drive.biz.importfile.im.entity;

/* JADX INFO: loaded from: classes16.dex */
public class ImportException extends Exception {
    private int jobStatus;

    public int getJobStatus() {
        return this.jobStatus;
    }

    public ImportException(int r100) {
        this.jobStatus = r100;
    }

    public void setJobStatus(int r100) {
        this.jobStatus = r100;
    }
}
