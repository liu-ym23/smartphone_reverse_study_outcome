package com.bytedance.dora.camera.model;

/* JADX INFO: loaded from: classes15.dex */
public class DoraVisionQueryTrackInfo {
    public int preCaptureLatency;
    public int soundLatency;
    public long ttsStartTimestamp;

    public String toString() {
        return "DoraVisionQueryTrackInfo{ttsStartTimestamp=" + this.ttsStartTimestamp + ", preCaptureLatency=" + this.preCaptureLatency + ", soundLatency=" + this.soundLatency + '}';
    }

    public DoraVisionQueryTrackInfo(long r100, int r101, int r102) {
        this.ttsStartTimestamp = r100;
        this.preCaptureLatency = r101;
        this.soundLatency = r102;
    }
}
