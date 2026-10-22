package com.bytedance.ee.android.file.picker.lib.media;

import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes15.dex */
public class FileEntry extends BaseFileEntry {
    private Drawable apkIcon;
    private long lastModifyTime;

    public FileEntry() {
    }

    public Drawable getApkIcon() {
        return this.apkIcon;
    }

    public long getLastModifyTime() {
        return this.lastModifyTime;
    }

    public void setApkIcon(Drawable r100) {
        this.apkIcon = r100;
    }

    public void setLastModifyTime(long r100) {
        this.lastModifyTime = r100;
    }
}
