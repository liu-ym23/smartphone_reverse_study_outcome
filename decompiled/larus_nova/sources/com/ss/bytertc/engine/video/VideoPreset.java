package com.ss.bytertc.engine.video;

/* JADX INFO: loaded from: classes40.dex */
public class VideoPreset {
    private int bandwidth;
    private int fps;
    private int height;
    private int width;

    public int getBandwidth() {
        return this.bandwidth;
    }

    public int getFps() {
        return this.fps;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    public VideoPreset(int r100, int r101, int r102, int r103) {
        this.width = r100;
        this.height = r101;
        this.fps = r102;
        this.bandwidth = r103;
    }
}
