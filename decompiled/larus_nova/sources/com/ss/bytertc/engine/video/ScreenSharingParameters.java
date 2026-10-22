package com.ss.bytertc.engine.video;

/* JADX INFO: loaded from: classes40.dex */
public class ScreenSharingParameters {
    public int bitrate;
    public int frameRate;
    public int maxHeight;
    public int maxWidth;
    public int minBitrate;

    public ScreenSharingParameters() {
        this.maxWidth = 0;
        this.maxHeight = 0;
        this.frameRate = 15;
        this.bitrate = -1;
        this.minBitrate = 0;
    }

    public ScreenSharingParameters(int r100, int r101, int r102, int r103, int r104) {
        this.maxHeight = r101;
        this.maxWidth = r100;
        this.frameRate = r102;
        this.bitrate = r103;
        this.minBitrate = r104;
    }
}
