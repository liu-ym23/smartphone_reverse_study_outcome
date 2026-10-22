package com.facebook.imagepipeline.image;

/* JADX INFO: loaded from: classes23.dex */
public class CalculateColorInfo {
    private int downColor;
    private int upColor;

    public int getDownColor() {
        return this.downColor;
    }

    public int getUpColor() {
        return this.upColor;
    }

    public CalculateColorInfo(int r100, int r101) {
        this.upColor = r100;
        this.downColor = r101;
    }
}
