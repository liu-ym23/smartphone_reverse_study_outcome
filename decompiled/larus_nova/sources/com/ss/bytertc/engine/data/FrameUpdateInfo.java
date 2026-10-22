package com.ss.bytertc.engine.data;

/* JADX INFO: loaded from: classes40.dex */
public class FrameUpdateInfo {
    public int frameRate;
    public int pixel;

    public String toString() {
        return "FrameUpdateInfo{pixel='" + this.pixel + "', frameRate='" + this.frameRate + '}';
    }

    public FrameUpdateInfo(int r100, int r101) {
        this.pixel = r100;
        this.frameRate = r101;
    }
}
