package com.ss.bytertc.engine;

/* JADX INFO: loaded from: classes40.dex */
public class InternalRemoteVideoStats {
    public int codecType;
    public int decoderOutputFrameRate;
    public long e2eDelay;
    public int frozenRate;
    public int height;
    public boolean isScreen;
    public int jitter;
    public float receivedKBitrate;
    public int rendererOutputFrameRate;
    public int rtt;
    public int stallCount;
    public int stallDuration;
    public int statsInterval;
    public int superResolutionMode;
    public int videoIndex;
    public float videoLossRate;
    public int width;

    public InternalRemoteVideoStats() {
    }

    public InternalRemoteVideoStats(int r100, int r101, float r102, float r103, int r104, int r105, int r110, int r111, long r112, boolean r113, int r114, int r115, int r116, int r117, int r118, int r210, int r211) {
        this.width = r100;
        this.height = r101;
        this.videoLossRate = r102;
        this.receivedKBitrate = r103;
        this.decoderOutputFrameRate = r104;
        this.rendererOutputFrameRate = r105;
        this.stallCount = r110;
        this.stallDuration = r111;
        this.e2eDelay = r112;
        this.isScreen = r113;
        this.statsInterval = r114;
        this.rtt = r115;
        this.frozenRate = r116;
        this.codecType = r117;
        this.videoIndex = r118;
        this.jitter = r210;
        this.superResolutionMode = r211;
    }

    private static InternalRemoteVideoStats create(int r210, int r211, float r212, float r213, int r214, int r215, int r216, int r217, long r218, boolean r310, int r311, int r312, int r313, int r314, int r315, int r316, int r317) {
        return new InternalRemoteVideoStats(r210, r211, r212, r213, r214, r215, r216, r217, r218, r310, r311, r312, r313, r314, r315, r316, r317);
    }
}
