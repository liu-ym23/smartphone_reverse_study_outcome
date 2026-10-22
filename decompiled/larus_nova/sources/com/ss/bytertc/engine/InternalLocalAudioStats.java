package com.ss.bytertc.engine;

/* JADX INFO: loaded from: classes40.dex */
public class InternalLocalAudioStats {
    public int audioDeviceLoopDelay;
    public float audioLossRate;
    public int jitter;
    public int numChannels;
    public int recordSampleRate;
    public int rtt;
    public int sendKBitrate;
    public int sentSampleRate;
    public int statsInterval;

    public InternalLocalAudioStats() {
    }

    public InternalLocalAudioStats(float r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
        this.audioLossRate = r100;
        this.sendKBitrate = r101;
        this.recordSampleRate = r102;
        this.statsInterval = r103;
        this.rtt = r104;
        this.numChannels = r105;
        this.sentSampleRate = r106;
        this.jitter = r107;
        this.audioDeviceLoopDelay = r108;
    }

    private static InternalLocalAudioStats create(float r110, int r111, int r112, int r113, int r114, int r115, int r116, int r117, int r118) {
        return new InternalLocalAudioStats(r110, r111, r112, r113, r114, r115, r116, r117, r118);
    }
}
