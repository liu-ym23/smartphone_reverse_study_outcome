package com.ss.bytertc.engine.data;

/* JADX INFO: loaded from: classes40.dex */
public class VideoFrameInfo {
    public int height;
    public VideoRotation rotation;
    public int width;

    public String toString() {
        return "VideoFrameInfo{width=" + this.width + ", height=" + this.height + ", rotation=" + this.rotation + '}';
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int r100) {
        this.width = r100;
    }

    public VideoFrameInfo(int r100, int r101, int r102) {
        this.width = 0;
        this.height = 0;
        this.rotation = VideoRotation.VIDEO_ROTATION_0;
        this.width = r100;
        this.height = r101;
        this.rotation = VideoRotation.fromId(r102);
    }
}
