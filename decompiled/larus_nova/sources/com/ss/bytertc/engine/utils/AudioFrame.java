package com.ss.bytertc.engine.utils;

import com.ss.bytertc.engine.data.AudioChannel;
import com.ss.bytertc.engine.data.AudioSampleRate;

/* JADX INFO: loaded from: classes40.dex */
public class AudioFrame {
    public byte[] buffer;
    public AudioChannel channel;
    public byte[] extraInfo;
    public AudioSampleRate sampleRate;
    public int samples;

    public AudioFrame() {
    }

    public AudioFrame(byte[] r100, int r101, AudioSampleRate r102, AudioChannel r103) {
        this.buffer = r100;
        this.samples = r101;
        this.sampleRate = r102;
        this.channel = r103;
        this.extraInfo = null;
    }

    public AudioFrame(byte[] r100, int r101, AudioSampleRate r102, AudioChannel r103, byte[] r104) {
        this.buffer = r100;
        this.samples = r101;
        this.sampleRate = r102;
        this.channel = r103;
        this.extraInfo = r104;
    }
}
