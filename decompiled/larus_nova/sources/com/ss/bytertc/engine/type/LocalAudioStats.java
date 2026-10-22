package com.ss.bytertc.engine.type;

import com.ss.bytertc.engine.InternalLocalAudioStats;

/* JADX INFO: loaded from: classes40.dex */
public class LocalAudioStats {
    public int audioDeviceLoopDelay;
    public float audioLossRate;
    public int jitter;
    public int numChannels;
    public int recordSampleRate;
    public int rtt;
    public float sendKBitrate;
    public int sentSampleRate;
    public int statsInterval;

    public LocalAudioStats() {
    }

    public String toString() {
        return "LocalAudioStats{audioLossRate='" + this.audioLossRate + "', sendKBitrate='" + this.sendKBitrate + "', recordSampleRate='" + this.recordSampleRate + "', statsInterval='" + this.statsInterval + "', rtt='" + this.rtt + "', numChannels='" + this.numChannels + "', sentSampleRate='" + this.sentSampleRate + "', jitter='" + this.jitter + "', audioDeviceLoopDelay='" + this.audioDeviceLoopDelay + "'}";
    }

    public LocalAudioStats(InternalLocalAudioStats r100) {
        this.audioLossRate = r100.audioLossRate;
        this.sendKBitrate = r100.sendKBitrate;
        this.recordSampleRate = r100.recordSampleRate;
        this.statsInterval = r100.statsInterval;
        this.rtt = r100.rtt;
        this.numChannels = r100.numChannels;
        this.sentSampleRate = r100.sentSampleRate;
        this.jitter = r100.jitter;
        this.audioDeviceLoopDelay = r100.audioDeviceLoopDelay;
    }
}
