package com.bytedance.ee.bear.drive.config.fg;

import com.bytedance.ee.util.io.NonProguard;
import com.ss.android.lark.appsetting.annotation.AppConfig;

/* JADX INFO: loaded from: classes16.dex */
@AppConfig(key = "drive_cache_config")
public class DriveCacheConfig implements NonProguard {
    private long maxTotalCacheSize;
    private float totalCacheSizePercent;

    public DriveCacheConfig() {
    }

    public String toString() {
        return "DriveCacheConfig{maxTotalCacheSize=" + this.maxTotalCacheSize + ", totalCacheSizePercent=" + this.totalCacheSizePercent + '}';
    }

    public long getMaxTotalCacheSize() {
        return this.maxTotalCacheSize;
    }

    public float getTotalCacheSizePercent() {
        return this.totalCacheSizePercent;
    }

    public void setMaxTotalCacheSize(long r100) {
        this.maxTotalCacheSize = r100;
    }

    public void setTotalCacheSizePercent(float r100) {
        this.totalCacheSizePercent = r100;
    }
}
