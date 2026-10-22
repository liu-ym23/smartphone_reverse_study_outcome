package com.bytedance.ee.bear.document.toolbar.media.impl;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class SelectedMediaItem implements NonProguard {
    public String contentType;
    public long duration;
    public String fileName;
    public long fileSize;
    public int height;
    public String mediaFile;
    public String src;
    public String uuid;
    public int width;

    public String encodeFilePath() {
        String r0 = this.src;
        if (r0 == null) goto L5;
        return r0;
    L5:
        String r1 = this.mediaFile;
        return "docsource://com.bytedance.net/file/f/" + this.uuid + r1.substring(r1.lastIndexOf("."));
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
        return this.src;
    }

    public String getUuid() {
        return this.uuid;
    }

    public int getWidth() {
        return this.width;
    }

    public SelectedMediaItem(String r1, String r2, String r3, int r4, int r5, long r6, long r8, String r10) {
        this.contentType = r1;
        this.uuid = r2;
        this.mediaFile = r3;
        this.width = r4;
        this.height = r5;
        this.duration = r6;
        this.fileSize = r8;
        this.fileName = r10;
    }
}
