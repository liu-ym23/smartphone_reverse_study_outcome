package com.ss.bytertc.engine;

/* JADX INFO: loaded from: classes40.dex */
public class SubscribeVideoBaseline {
    public int acceptableBadVideoFpsBaseline;
    public int acceptableBadVideoPixelBaseline;
    public int acceptableGoodVideoFpsBaseline;
    public int acceptableGoodVideoPixelBaseline;
    public int acceptableMinVideoResolutionHeight;
    public int acceptableMinVideoResolutionWidth;
    public int streamPriority;

    public int getAcceptableBadVideoFpsBaseline() {
        return this.acceptableBadVideoFpsBaseline;
    }

    public int getAcceptableBadVideoPixelBaseline() {
        return this.acceptableBadVideoPixelBaseline;
    }

    public int getAcceptableGoodVideoFpsBaseline() {
        return this.acceptableGoodVideoFpsBaseline;
    }

    public int getAcceptableGoodVideoPixelBaseline() {
        return this.acceptableGoodVideoPixelBaseline;
    }

    public int getAcceptableMinVideoResolutionHeight() {
        return this.acceptableMinVideoResolutionHeight;
    }

    public int getAcceptableMinVideoResolutionWidth() {
        return this.acceptableMinVideoResolutionWidth;
    }

    public int getStreamPriority() {
        return this.streamPriority;
    }

    public SubscribeVideoBaseline(int r100, int r101, int r102, int r103, int r104, int r105, int r106) {
        this.acceptableGoodVideoPixelBaseline = r100;
        this.acceptableGoodVideoFpsBaseline = r101;
        this.acceptableBadVideoPixelBaseline = r102;
        this.acceptableBadVideoFpsBaseline = r103;
        this.acceptableMinVideoResolutionWidth = r104;
        this.acceptableMinVideoResolutionHeight = r105;
        this.streamPriority = r106;
    }
}
