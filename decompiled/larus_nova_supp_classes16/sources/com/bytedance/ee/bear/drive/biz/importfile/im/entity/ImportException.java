package com.bytedance.ee.bear.drive.biz.importfile.im.entity;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class ImportException extends Exception {
    private int jobStatus;

    public int getJobStatus() {
        return this.jobStatus;
    }

    public ImportException(int r1) {
        this.jobStatus = r1;
    }

    public void setJobStatus(int r1) {
        this.jobStatus = r1;
    }
}
