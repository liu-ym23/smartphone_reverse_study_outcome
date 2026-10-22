package com.ss.bytertc.engine.live;

/* JADX INFO: loaded from: classes40.dex */
public class ChorusCacheSyncConfig {
    private int maxCacheTimeMs;
    private ChorusCacheSyncMode mode;
    private int videoFps;

    public int getChorusCacheSyncConfigMode() {
        return this.mode.value();
    }

    public ChorusCacheSyncConfig() {
        this.maxCacheTimeMs = 2000;
        this.mode = ChorusCacheSyncMode.CHORUS_CACHE_SYNC_MODE_RETRANSMITTER;
        this.videoFps = 15;
    }

    public int getChorusCacheSyncConfigMaxCacheTimeMs() {
        return this.maxCacheTimeMs;
    }

    public int getChorusCacheSyncConfigVideoFps() {
        return this.videoFps;
    }

    public int getMaxCacheTimeMs() {
        return this.maxCacheTimeMs;
    }

    public ChorusCacheSyncMode getMode() {
        return this.mode;
    }

    public int getVideoFps() {
        return this.videoFps;
    }

    public ChorusCacheSyncConfig setMaxCacheTimeMs(int r100) {
        this.maxCacheTimeMs = r100;
        return this;
    }

    public ChorusCacheSyncConfig setMode(ChorusCacheSyncMode r100) {
        this.mode = r100;
        return this;
    }

    public ChorusCacheSyncConfig setVideoFps(int r100) {
        this.videoFps = r100;
        return this;
    }
}
