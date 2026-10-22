package com.ss.bytertc.engine;

/* JADX INFO: loaded from: classes40.dex */
public class InternalRemoteAudioStats {
    public float audioLossRate;
    public int concealedSamples;
    public int concealmentEvent;
    public int decDuration;
    public int decSampleRate;
    public long e2eDelay;
    public int frozenRate;
    public int jitter;
    public int jitterBufferDelay;
    public int numChannels;
    public int playoutSampleRate;
    public int quality;
    public int receivedKBitrate;
    public int receivedSampleRate;
    public int rtt;
    public int stallCount;
    public int stallDuration;
    public int statsInterval;
    public int totalRtt;

    public InternalRemoteAudioStats() {
    }

    public InternalRemoteAudioStats(float r100, int r101, int r102, int r103, long r104, int r110, int r111, int r112, int r113, int r114, int r115, int r116, int r117, int r118, int r119, int r210, int r211, int r212, int r213) {
        this.audioLossRate = r100;
        this.receivedKBitrate = r101;
        this.stallCount = r102;
        this.stallDuration = r103;
        this.e2eDelay = r104;
        this.statsInterval = r111;
        this.rtt = r112;
        this.totalRtt = r113;
        this.quality = r114;
        this.jitterBufferDelay = r115;
        this.numChannels = r116;
        this.receivedSampleRate = r117;
        this.frozenRate = r118;
        this.concealedSamples = r119;
        this.concealmentEvent = r210;
        this.decSampleRate = r211;
        this.decDuration = r212;
        this.jitter = r213;
    }

    private static InternalRemoteAudioStats create(float r210, int r211, int r212, int r213, long r214, int r215, int r216, int r310, int r311, int r312, int r313, int r314, int r315, int r316, int r317, int r318, int r319, int r410, int r411) {
        return new InternalRemoteAudioStats(r210, r211, r212, r213, r214, r215, r216, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, r411);
    }
}
