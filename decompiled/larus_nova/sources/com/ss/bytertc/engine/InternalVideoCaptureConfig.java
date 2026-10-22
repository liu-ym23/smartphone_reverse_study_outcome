package com.ss.bytertc.engine;

/* JADX INFO: loaded from: classes40.dex */
public class InternalVideoCaptureConfig {
    public int capturePreference;
    public int frameRate;
    public int height;
    public int width;

    public int getCapturePreference() {
        return this.capturePreference;
    }

    public int getFrameRate() {
        return this.frameRate;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    public InternalVideoCaptureConfig(int r100, int r101, int r102, int r103) {
        this.capturePreference = r100;
        this.width = r101;
        this.height = r102;
        this.frameRate = r103;
    }
}
