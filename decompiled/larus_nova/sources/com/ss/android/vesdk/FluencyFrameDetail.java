package com.ss.android.vesdk;

/* JADX INFO: loaded from: classes40.dex */
public class FluencyFrameDetail {
    private final int frameDuration;
    private final int lagLevel;
    private final long timestamp;

    public long getFrameDuration() {
        return this.frameDuration;
    }

    public String toString() {
        return "FluencyFrameDetail{timestamp=" + this.timestamp + ", lagLevel=" + this.lagLevel + ", frameDuration=" + this.frameDuration + '}';
    }

    public int getLagLevel() {
        return this.lagLevel;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public FluencyFrameDetail(long r100, int r101, int r102) {
        this.timestamp = r100;
        this.lagLevel = r101;
        this.frameDuration = r102;
    }
}
