package com.ss.bytertc.engine.data;

/* JADX INFO: loaded from: classes40.dex */
public class AudioEffectPlayerConfig {
    public int pitch;
    public int playCount;
    public int startPos;
    public AudioMixingType type;

    public String toString() {
        return "AudioEffectPlayerConfig{type='" + this.type + "', playCount='" + this.playCount + "', startPos='" + this.startPos + "', pitch='" + this.pitch + "'}";
    }

    public AudioEffectPlayerConfig() {
        this.type = AudioMixingType.AUDIO_MIXING_TYPE_PLAYOUT_AND_PUBLISH;
        this.playCount = 1;
        this.startPos = 0;
        this.pitch = 0;
    }

    public AudioEffectPlayerConfig(AudioMixingType r100, int r101, int r102, int r103) {
        AudioMixingType r104 = AudioMixingType.AUDIO_MIXING_TYPE_PLAYOUT;
        this.type = r100;
        this.playCount = r101;
        this.startPos = r102;
        this.pitch = r103;
    }
}
