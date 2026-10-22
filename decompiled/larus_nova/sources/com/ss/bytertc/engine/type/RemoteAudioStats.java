package com.ss.bytertc.engine.type;

import com.ss.bytertc.engine.InternalRemoteAudioStats;

/* JADX INFO: loaded from: classes40.dex */
public class RemoteAudioStats {
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
    public float receivedKBitrate;
    public int receivedSampleRate;
    public int rtt;
    public int stallCount;
    public int stallDuration;
    public int statsInterval;
    public int totalRtt;

    public RemoteAudioStats() {
    }

    public String toString() {
        return "RemoteAudioStats{audioLossRate='" + this.audioLossRate + "', receivedKBitrate='" + this.receivedKBitrate + "', stallCount='" + this.stallCount + "', stallDuration='" + this.stallDuration + "', playoutSampleRate='" + this.playoutSampleRate + "', e2eDelay='" + this.e2eDelay + "', rtt='" + this.rtt + "', quality='" + this.quality + "', jitterBufferDelay='" + this.jitterBufferDelay + "', numChannels='" + this.numChannels + "', receivedSampleRate='" + this.receivedSampleRate + "', frozenRate='" + this.frozenRate + "', concealedSamples='" + this.concealedSamples + "', concealmentEvent='" + this.concealmentEvent + "', decSampleRate='" + this.decSampleRate + "', decDuration='" + this.decDuration + "', total_rtt='" + this.totalRtt + "', jitter='" + this.jitter + "'}";
    }

    public RemoteAudioStats(InternalRemoteAudioStats r100) {
        this.audioLossRate = r100.audioLossRate;
        this.receivedKBitrate = r100.receivedKBitrate;
        this.stallCount = r100.stallCount;
        this.stallDuration = r100.stallDuration;
        this.e2eDelay = r100.e2eDelay;
        this.playoutSampleRate = r100.playoutSampleRate;
        this.statsInterval = r100.statsInterval;
        this.rtt = r100.rtt;
        this.totalRtt = r100.totalRtt;
        this.quality = r100.quality;
        this.jitterBufferDelay = r100.jitterBufferDelay;
        this.numChannels = r100.numChannels;
        this.receivedSampleRate = r100.receivedSampleRate;
        this.frozenRate = r100.frozenRate;
        this.concealedSamples = r100.concealedSamples;
        this.concealmentEvent = r100.concealmentEvent;
        this.decSampleRate = r100.decSampleRate;
        this.decDuration = r100.decDuration;
        this.jitter = r100.jitter;
    }
}
