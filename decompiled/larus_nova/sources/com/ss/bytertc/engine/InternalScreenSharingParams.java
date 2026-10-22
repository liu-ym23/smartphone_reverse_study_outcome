package com.ss.bytertc.engine;

import com.ss.bytertc.engine.video.ScreenSharingParameters;

/* JADX INFO: loaded from: classes40.dex */
public class InternalScreenSharingParams {
    public int bitrate;
    public int frameRate;
    public int maxHeight;
    public int maxWidth;
    public int minBitrate;

    public int getBitrate() {
        return this.bitrate;
    }

    public int getFrameRate() {
        return this.frameRate;
    }

    public int getHeight() {
        return this.maxHeight;
    }

    public int getMinBitrate() {
        return this.minBitrate;
    }

    public int getWidth() {
        return this.maxWidth;
    }

    public InternalScreenSharingParams(ScreenSharingParameters r100) {
        this.maxWidth = 0;
        this.maxHeight = 0;
        this.frameRate = 15;
        this.bitrate = -1;
        this.minBitrate = 0;
        if (r100 == null) goto L6;
        this.maxHeight = r100.maxHeight;
        this.maxWidth = r100.maxWidth;
        this.frameRate = r100.frameRate;
        this.bitrate = r100.bitrate;
        this.minBitrate = r100.minBitrate;
        return;
    }

    public InternalScreenSharingParams(int r100, int r101, int r102, int r103, int r104) {
        this.maxHeight = r101;
        this.maxWidth = r100;
        this.frameRate = r102;
        this.bitrate = r103;
        this.minBitrate = r104;
    }
}
