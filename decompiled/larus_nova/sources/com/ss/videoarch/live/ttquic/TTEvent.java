package com.ss.videoarch.live.ttquic;

import android.os.Bundle;

/* JADX INFO: loaded from: classes38.dex */
public class TTEvent {
    public static final int PRELOAD_EVENT_END = 1;
    public static final int PRELOAD_EVENT_FAIL = 2;
    public static final int PRELOAD_EVENT_START = 0;
    public int audioCachedNum;
    public int audioInitSectionCached;
    public Bundle bundle;
    public long cacheDuration;
    public int cacheFrameCount;
    public int cacheMode;
    public long cacheReadBytes;
    public int cacheSize;
    public long cacheWriteBytes;
    public long cancelCostTime;
    public int code;
    public String error;
    public int mode;
    public int optCancelTask;
    public int preloadNum;
    public int subCode;
    public String url;
    public int videoCachedNum;
    public int videoInitSectionCached;
    public int what;

    public TTEvent() {
    }

    public String toString() {
        return "TTEvent{what=" + this.what + ", url='" + this.url + "', error='" + this.error + "', code=" + this.code + ", subCode=" + this.subCode + ", preloadNum=" + this.preloadNum + ", videoCachedNum=" + this.videoCachedNum + ", audioCachedNum=" + this.audioCachedNum + ", videoInitSectionCached=" + this.videoInitSectionCached + ", audioInitSectionCached=" + this.audioInitSectionCached + ", cacheReadBytes=" + this.cacheReadBytes + ", cacheWriteBytes=" + this.cacheWriteBytes + ", cacheMode=" + this.cacheMode + ", cacheFrameCount=" + this.cacheFrameCount + ", cacheDuration=" + this.cacheDuration + ", cacheSize=" + this.cacheSize + ", cancelCostTime=" + this.cancelCostTime + ", mode=" + this.mode + ", optCancelTask=" + this.optCancelTask + '}';
    }
}
