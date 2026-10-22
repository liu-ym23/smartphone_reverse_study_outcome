package com.ss.bytertc.engine.data;

/* JADX INFO: loaded from: classes40.dex */
public class AudioFormat {
    public AudioChannel channel;
    public AudioSampleRate sampleRate;
    public int samplesPerCall;

    public String toString() {
        return "AudioFormat{sampleRate='" + this.sampleRate + "', channel='" + this.channel + "', samplesPerCall=" + this.samplesPerCall + '}';
    }

    public AudioFormat(AudioSampleRate r100, AudioChannel r101) {
        this.sampleRate = r100;
        this.channel = r101;
        this.samplesPerCall = 0;
    }

    public AudioFormat(AudioSampleRate r100, AudioChannel r101, int r102) {
        this.sampleRate = r100;
        this.channel = r101;
        this.samplesPerCall = r102;
    }
}
