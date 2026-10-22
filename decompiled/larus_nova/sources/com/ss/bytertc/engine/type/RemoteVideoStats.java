package com.ss.bytertc.engine.type;

import com.ss.bytertc.engine.InternalRemoteVideoStats;

/* JADX INFO: loaded from: classes40.dex */
public class RemoteVideoStats {
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

    public RemoteVideoStats() {
    }

    public String toString() {
        return "RemoteVideoStats{width='" + this.width + "', height='" + this.height + "', videoLossRate='" + this.videoLossRate + "', receivedKBitrate='" + this.receivedKBitrate + "', decoderOutputFrameRate='" + this.decoderOutputFrameRate + "', rendererOutputFrameRate='" + this.rendererOutputFrameRate + "', stallCount='" + this.stallCount + "', stallDuration='" + this.stallDuration + "', e2eDelay='" + this.e2eDelay + "', isScreen='" + this.isScreen + "', rtt='" + this.rtt + "', frozenRate='" + this.frozenRate + "', videoIndex='" + this.videoIndex + "', jitter='" + this.jitter + "', codecType='" + this.codecType + "', superResolutionMode='" + this.superResolutionMode + "'}";
    }

    public RemoteVideoStats(InternalRemoteVideoStats r100) {
        this.width = r100.width;
        this.height = r100.height;
        this.videoLossRate = r100.videoLossRate;
        this.receivedKBitrate = r100.receivedKBitrate;
        this.decoderOutputFrameRate = r100.decoderOutputFrameRate;
        this.rendererOutputFrameRate = r100.rendererOutputFrameRate;
        this.stallCount = r100.stallCount;
        this.stallDuration = r100.stallDuration;
        this.e2eDelay = r100.e2eDelay;
        this.isScreen = r100.isScreen;
        this.statsInterval = r100.statsInterval;
        this.rtt = r100.rtt;
        this.frozenRate = r100.frozenRate;
        this.codecType = r100.codecType;
        this.videoIndex = r100.videoIndex;
        this.jitter = r100.jitter;
        this.superResolutionMode = r100.superResolutionMode;
    }
}
