package com.ss.bytertc.engine;

/* JADX INFO: loaded from: classes40.dex */
public class InternalLocalVideoStats {
    public int codecType;
    public int encodedBitrate;
    public int encodedFrameCount;
    public int encodedFrameHeight;
    public int encodedFrameWidth;
    public int encoderOutputFrameRate;
    public int inputFrameRate;
    public boolean isScreen;
    public int jitter;
    public int rendererOutputFrameRate;
    public int rtt;
    public int sentFrameRate;
    public float sentKBitrate;
    public int statsInterval;
    public int videoDenoiseMode;
    public float videoLossRate;

    public InternalLocalVideoStats() {
    }

    public InternalLocalVideoStats(float r100, int r101, int r102, int r103, int r104, int r105, float r106, int r110, int r111, int r112, int r113, int r114, int r115, boolean r116, int r117, int r118) {
        this.sentKBitrate = r100;
        this.inputFrameRate = r101;
        this.sentFrameRate = r102;
        this.encoderOutputFrameRate = r103;
        this.rendererOutputFrameRate = r104;
        this.statsInterval = r105;
        this.videoLossRate = r106;
        this.rtt = r110;
        this.encodedBitrate = r111;
        this.encodedFrameWidth = r112;
        this.encodedFrameHeight = r113;
        this.encodedFrameCount = r114;
        this.codecType = r115;
        this.isScreen = r116;
        this.jitter = r117;
        this.videoDenoiseMode = r118;
    }

    private static InternalLocalVideoStats create(float r110, int r111, int r210, int r211, int r212, int r213, float r214, int r215, int r216, int r217, int r218, int r219, int r310, boolean r311, int r312, int r313) {
        return new InternalLocalVideoStats(r110, r111, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, r313);
    }
}
