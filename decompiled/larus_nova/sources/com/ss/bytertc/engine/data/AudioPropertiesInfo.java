package com.ss.bytertc.engine.data;

import androidx.camera.video.AudioStats;

/* JADX INFO: loaded from: classes40.dex */
public class AudioPropertiesInfo {
    private static final int SPECTRUM_SIZE = 257;
    public int linearVolume;
    public int nonlinearVolume;
    public float[] spectrum;
    public int vad;
    public double voicePitch;

    public String toString() {
        return "AudioPropertiesInfo{linearVolume='" + this.linearVolume + "'nonlinearVolume='" + this.nonlinearVolume + "'voicePitch='" + this.voicePitch + "'}";
    }

    public AudioPropertiesInfo(int r100, int r101, float[] r102, int r103) {
        float[] r104 = new float[257];
        this.spectrum = r104;
        this.voicePitch = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.linearVolume = r100;
        this.nonlinearVolume = r101;
        System.arraycopy(r102, 0, r104, 0, 257);
        this.vad = r103;
    }
}
