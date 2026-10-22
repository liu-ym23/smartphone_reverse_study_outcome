package com.bytedance.ee.bear.api.toolbar.media.impl;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: classes15.dex */
public class SelectedMediaItem implements NonProguard {
    public String contentType;
    public long duration;
    public String fileName;
    public long fileSize;
    public int height;
    public String mediaFile;

    /* JADX INFO: renamed from: src, reason: collision with root package name */
    public String f206229src;
    public String uuid;
    public int width;

    public String encodeFilePath() {
        String r100 = this.f206229src;
        if (r100 == null) goto L5;
        return r100;
    L5:
        String r101 = this.mediaFile;
        return "docsource://com.bytedance.net/file/f/" + this.uuid + r101.substring(r101.lastIndexOf("."));
    }

    public SelectedMediaItem() {
    }

    public String getContentType() {
        return this.contentType;
    }

    public long getDuration() {
        return this.duration;
    }

    public String getFileName() {
        return this.fileName;
    }

    public long getFileSize() {
        return this.fileSize;
    }

    public int getHeight() {
        return this.height;
    }

    public String getMediaFile() {
        return this.mediaFile;
    }

    public String getSrc() {
        return this.f206229src;
    }

    public String getUuid() {
        return this.uuid;
    }

    public int getWidth() {
        return this.width;
    }

    public SelectedMediaItem(String r100, String r101, String r102, int r103, int r104, long r105, long r106, String r110) {
        this.contentType = r100;
        this.uuid = r101;
        this.mediaFile = r102;
        this.width = r103;
        this.height = r104;
        this.duration = r105;
        this.fileSize = r106;
        this.fileName = r110;
    }
}
