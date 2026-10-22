package com.ss.bytertc.engine.type;

import com.ss.bytertc.engine.InternalLocalVideoStats;

/* JADX INFO: loaded from: classes40.dex */
public class LocalVideoStats {
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

    public String toString() {
        return "LocalVideoStats{sentKBitrate='" + this.sentKBitrate + "', inputFrameRate='" + this.inputFrameRate + "', sentFrameRate='" + this.sentFrameRate + "', encoderOutputFrameRate='" + this.encoderOutputFrameRate + "', rendererOutputFrameRate='" + this.rendererOutputFrameRate + "', videoLossRate='" + this.videoLossRate + "', rtt='" + this.rtt + "', statsInterval='" + this.statsInterval + "', encodedBitrate='" + this.encodedBitrate + "', encodedFrameWidth='" + this.encodedFrameWidth + "', encodedFrameHeight='" + this.encodedFrameHeight + "', encodedFrameCount='" + this.encodedFrameCount + "', codecType='" + this.codecType + "', isScreen='" + this.isScreen + "', jitter='" + this.jitter + "', videoDenoiseMode" + this.videoDenoiseMode + "'}";
    }

    public LocalVideoStats() {
    }

    public LocalVideoStats(InternalLocalVideoStats r100) {
        this.sentKBitrate = r100.sentKBitrate;
        this.inputFrameRate = r100.inputFrameRate;
        this.sentFrameRate = r100.sentFrameRate;
        this.encoderOutputFrameRate = r100.encoderOutputFrameRate;
        this.rendererOutputFrameRate = r100.rendererOutputFrameRate;
        this.statsInterval = r100.statsInterval;
        this.videoLossRate = r100.videoLossRate;
        this.rtt = r100.rtt;
        this.encodedBitrate = r100.encodedBitrate;
        this.encodedFrameWidth = r100.encodedFrameWidth;
        this.encodedFrameHeight = r100.encodedFrameHeight;
        this.encodedFrameCount = r100.encodedFrameCount;
        this.codecType = r100.codecType;
        this.isScreen = r100.isScreen;
        this.jitter = r100.jitter;
        this.videoDenoiseMode = r100.videoDenoiseMode;
    }
}
