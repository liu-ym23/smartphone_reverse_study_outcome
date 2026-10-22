package com.ss.bytertc.engine.type;

/* JADX INFO: loaded from: classes40.dex */
public class VoiceEqualizationConfig {
    public VoiceEqualizationBandFrequency frequency;
    public int gain;

    public String toString() {
        return "the frequency: " + this.frequency + ", the gain: " + this.gain;
    }

    public VoiceEqualizationConfig(VoiceEqualizationBandFrequency r100, int r101) {
        this.frequency = r100;
        this.gain = r101;
    }
}
