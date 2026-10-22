package com.ss.android.vesdk;

import androidx.camera.video.AudioStats;

/* JADX INFO: loaded from: classes40.dex */
public class LoudnessDetectResult {
    public double avgLoudness;
    public double peakLoudness;
    public int result;

    public String toString() {
        return "LoudnessDetectResult{result=" + this.result + ", avgLoudness=" + this.avgLoudness + ", peakLoudness=" + this.peakLoudness + '}';
    }

    public LoudnessDetectResult() {
        this.result = 0;
        this.avgLoudness = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.peakLoudness = AudioStats.AUDIO_AMPLITUDE_NONE;
    }
}
