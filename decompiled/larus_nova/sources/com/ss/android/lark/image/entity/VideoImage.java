package com.ss.android.lark.image.entity;

import com.bumptech.glide.load.Key;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.Serializable;
import java.security.MessageDigest;
import java.util.Objects;

/* JADX INFO: loaded from: classes36.dex */
public class VideoImage implements Key, Serializable {
    private static final String TAG = "VideoImage";
    private volatile byte[] cacheKeyBytes;
    private long lastModified;
    private String path;

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return Objects.hash(new Object[]{this.path, Long.valueOf(this.lastModified)});
    }

    private byte[] getCacheKeyBytes() {
        if (this.cacheKeyBytes != null) goto L6;
        this.cacheKeyBytes = getKey().getBytes(Key.CHARSET);
    L6:
        return this.cacheKeyBytes;
    }

    public String getKey() {
        return this.path + "_" + this.lastModified;
    }

    public long getLastModified() {
        return this.lastModified;
    }

    public String getPath() {
        return this.path;
    }

    public VideoImage(String r100) {
        this.lastModified = 0;
        this.path = r100;
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100);
        if (r101.exists() == false) goto L6;
        this.lastModified = r101.lastModified();
        return;
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof VideoImage) == true) goto L8;
        return false;
    L8:
        VideoImage r101 = (VideoImage) r100;
        if (this.lastModified == r101.lastModified) goto L11;
    L13:
        return false;
    L11:
        if (Objects.equals(this.path, r101.path) == false) goto L13;
        return true;
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest r100) {
        r100.update(getCacheKeyBytes());
    }
}
