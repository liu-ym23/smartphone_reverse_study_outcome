package com.bytedance.ee.bear.drive.loader.download.model.drive;

import com.bytedance.ee.bear.drive.loader.download.model.Content;
import yu5.c;

/* JADX INFO: loaded from: classes16.dex */
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

    public DrivePreviewGetModel(String r100, String r101, String r102, int r103, String r104, int r105, int r106, int r107, Content r108, boolean r110, long r111, String r112) {
        this.fileToken = r100;
        this.mountNodeToken = r101;
        this.mountPoint = r102;
        this.previewType = r103;
        this.version = r104;
        this.status = r105;
        this.interval = r106;
        this.longPushRetryInterval = r107;
        this.content = r108;
        this.linearized = r110;
        this.previewFileSize = r111;
        this.extra = r112;
    }
}
