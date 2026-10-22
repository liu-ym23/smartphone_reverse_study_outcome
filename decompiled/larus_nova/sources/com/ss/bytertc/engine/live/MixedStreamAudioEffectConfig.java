package com.ss.bytertc.engine.live;

/* JADX INFO: loaded from: classes40.dex */
public class MixedStreamAudioEffectConfig {
    public MixedStreamAudioEffectType mAudioEffectType;

    public String toString() {
        return "MixedStreamAudioEffectConfig:{audioEffectType='" + this.mAudioEffectType.toString() + "'}";
    }

    public MixedStreamAudioEffectConfig() {
        this.mAudioEffectType = MixedStreamAudioEffectType.MIXED_STREAM_AUDIO_EFFECT_TYPE_NONE;
    }
}
