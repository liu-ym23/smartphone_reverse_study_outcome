package com.ss.android.ttve.model;

import java.util.Arrays;

/* JADX INFO: loaded from: classes38.dex */
public class VEAudioWavePointInfo {
    public int channels;
    public long endPoint;
    public boolean isFinished;
    public long startPoint;
    public int status;
    public float[] waveDataL;
    public float[] waveDataR;

    public String toString() {
        return "VEAudioWavePointInfo{isFinished=" + this.isFinished + ", status=" + this.status + ", startPoint=" + this.startPoint + ", endPoint=" + this.endPoint + ", channels=" + this.channels + ", waveDataL=" + Arrays.toString(this.waveDataL) + ", waveDataR=" + Arrays.toString(this.waveDataR) + '}';
    }

    public VEAudioWavePointInfo() {
        this.isFinished = false;
        this.status = 0;
        this.startPoint = 0;
        this.endPoint = 0;
        this.channels = 0;
        this.waveDataL = null;
        this.waveDataR = null;
    }
}
