package com.bytedance.ee.bear.drive.loader.download.model.drive;

import com.bytedance.ee.bear.drive.loader.download.model.Content;
import yu5.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class DrivePreviewGetModel {
    private final Content content;
    private final String extra;
    private final String fileToken;
    private final int interval;
    private final boolean linearized;
    private final int longPushRetryInterval;
    private final String mountNodeToken;
    private final String mountPoint;
    private final long previewFileSize;
    private final int previewType;
    private final int status;
    private final String version;

    public String toString() {
        return "DrivePreviewGetModel{fileToken='" + c.j(this.fileToken) + "', mountNodeToken='" + c.j(this.mountNodeToken) + "', mountPoint='" + this.mountPoint + "', previewType=" + this.previewType + ", version='" + this.version + "', status=" + this.status + ", interval=" + this.interval + ", longPushRetryInterval=" + this.longPushRetryInterval + ", content=" + this.content + ", linearized=" + this.linearized + ", previewFileSize=" + this.previewFileSize + ", extra='" + this.extra + "'}";
    }

    public Content getContent() {
        return this.content;
    }

    public String getExtra() {
        return this.extra;
    }

    public String getFileToken() {
        return this.fileToken;
    }

    public int getInterval() {
        return this.interval;
    }

    public int getLongPushRetryInterval() {
        return this.longPushRetryInterval;
    }

    public String getMountNodeToken() {
        return this.mountNodeToken;
    }

    public String getMountPoint() {
        return this.mountPoint;
    }

    public long getPreviewFileSize() {
        return this.previewFileSize;
    }

    public int getPreviewType() {
        return this.previewType;
    }

    public int getStatus() {
        return this.status;
    }

    public String getVersion() {
        return this.version;
    }

    public boolean isLinearized() {
        return this.linearized;
    }

    public DrivePreviewGetModel(String r1, String r2, String r3, int r4, String r5, int r6, int r7, int r8, Content r9, boolean r10, long r11, String r13) {
        this.fileToken = r1;
        this.mountNodeToken = r2;
        this.mountPoint = r3;
        this.previewType = r4;
        this.version = r5;
        this.status = r6;
        this.interval = r7;
        this.longPushRetryInterval = r8;
        this.content = r9;
        this.linearized = r10;
        this.previewFileSize = r11;
        this.extra = r13;
    }
}
