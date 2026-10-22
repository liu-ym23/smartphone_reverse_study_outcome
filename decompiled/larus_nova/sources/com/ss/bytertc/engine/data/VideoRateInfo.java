package com.ss.bytertc.engine.data;

/* JADX INFO: loaded from: classes40.dex */
public class VideoRateInfo {
    public int bitrateKbps;
    public int fps;

    public String toString() {
        return "VideoRateInfo{fps='" + this.fps + "', bitrateKbps='" + this.bitrateKbps + "'}";
    }

    public VideoRateInfo(int r100, int r101) {
        this.fps = r100;
        this.bitrateKbps = r101;
    }
}
