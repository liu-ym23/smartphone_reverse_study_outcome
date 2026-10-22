package com.bytedance.ee.bear.drive.loader.download.model.imfile;

import com.bytedance.ee.bear.drive.loader.download.model.Content;
import yu5.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class SdkPreviewGetModel {
    private final String appFileId;
    private final String appId;
    private final String authExtra;
    private final Content content;
    private final String extra;
    private final int interval;
    private final boolean linearized;
    private final int longPushRetryInterval;
    private final long previewFileSize;
    private final int status;

    public String toString() {
        return "SdkPreviewGetModel{appId='" + c.j(this.appId) + "', appFileId='" + c.j(this.appFileId) + "', authExtra='" + c.j(this.authExtra) + "', status=" + this.status + ", interval=" + this.interval + ", longPushRetryInterval=" + this.longPushRetryInterval + ", content=" + this.content + ", linearized=" + this.linearized + ", previewFileSize=" + this.previewFileSize + ", extra='" + this.extra + "'}";
    }

    public String getAppFileId() {
        return this.appFileId;
    }

    public String getAppId() {
        return this.appId;
    }

    public String getAuthExtra() {
        return this.authExtra;
    }

    public Content getContent() {
        return this.content;
    }

    public String getExtra() {
        return this.extra;
    }

    public int getInterval() {
        return this.interval;
    }

    public int getLongPushRetryInterval() {
        return this.longPushRetryInterval;
    }

    public long getPreviewFileSize() {
        return this.previewFileSize;
    }

    public int getStatus() {
        return this.status;
    }

    public boolean isLinearized() {
        return this.linearized;
    }

    public SdkPreviewGetModel(String r1, String r2, String r3, int r4, int r5, int r6, Content r7, boolean r8, long r9, String r11) {
        this.appId = r1;
        this.appFileId = r2;
        this.authExtra = r3;
        this.status = r4;
        this.interval = r5;
        this.longPushRetryInterval = r6;
        this.content = r7;
        this.linearized = r8;
        this.previewFileSize = r9;
        this.extra = r11;
    }
}
