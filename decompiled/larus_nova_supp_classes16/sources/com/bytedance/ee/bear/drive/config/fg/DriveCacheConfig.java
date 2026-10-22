package com.bytedance.ee.bear.drive.config.fg;

import com.bytedance.ee.util.io.NonProguard;
import com.ss.android.lark.appsetting.annotation.AppConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
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

    public void setMaxTotalCacheSize(long r1) {
        this.maxTotalCacheSize = r1;
    }

    public void setTotalCacheSizePercent(float r1) {
        this.totalCacheSizePercent = r1;
    }
}
