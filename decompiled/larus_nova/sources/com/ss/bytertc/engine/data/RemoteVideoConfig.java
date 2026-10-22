package com.ss.bytertc.engine.data;

/* JADX INFO: loaded from: classes40.dex */
public class RemoteVideoConfig {
    public int framerate;
    public int height;
    public int width;

    public String toString() {
        return "RemoteVideoConfig{width=" + this.width + ", height=" + this.height + ", framerate=" + this.framerate + '}';
    }

    public int getFrameRate() {
        return this.framerate;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    public RemoteVideoConfig(int r100, int r101, int r102) {
        this.width = r100;
        this.height = r101;
        this.framerate = r102;
    }
}
