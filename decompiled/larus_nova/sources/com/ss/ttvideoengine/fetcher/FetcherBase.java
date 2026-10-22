package com.ss.ttvideoengine.fetcher;

/* JADX INFO: loaded from: classes34.dex */
public class FetcherBase {
    private String mFallbackAPI;
    private String mKeyseed;
    private int mVersion;

    public String getFallbackAPI() {
        return this.mFallbackAPI;
    }

    public String getKeyseed() {
        return this.mKeyseed;
    }

    public int getVideoModelVersion() {
        return this.mVersion;
    }

    public FetcherBase(String r100, String r101, int r102) {
        this.mKeyseed = r100;
        this.mFallbackAPI = r101;
        this.mVersion = r102;
    }
}
