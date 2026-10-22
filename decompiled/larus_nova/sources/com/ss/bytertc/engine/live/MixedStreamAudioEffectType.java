package com.ss.bytertc.engine.live;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum MixedStreamAudioEffectType extends Enum<MixedStreamAudioEffectType> {
    private static final /* synthetic */ MixedStreamAudioEffectType[] $VALUES = null;
    public static final MixedStreamAudioEffectType MIXED_STREAM_AUDIO_EFFECT_TYPE_CONCERT_LIVE = null;
    public static final MixedStreamAudioEffectType MIXED_STREAM_AUDIO_EFFECT_TYPE_NONE = null;
    private int type;

    static {
        MixedStreamAudioEffectType r100 = new MixedStreamAudioEffectType("MIXED_STREAM_AUDIO_EFFECT_TYPE_NONE", 0, 0);
        MIXED_STREAM_AUDIO_EFFECT_TYPE_NONE = r100;
        MixedStreamAudioEffectType r101 = new MixedStreamAudioEffectType("MIXED_STREAM_AUDIO_EFFECT_TYPE_CONCERT_LIVE", 1, 1);
        MIXED_STREAM_AUDIO_EFFECT_TYPE_CONCERT_LIVE = r101;
        $VALUES = new MixedStreamAudioEffectType[]{r100, r101};
    }

    public static MixedStreamAudioEffectType[] values() {
        return (MixedStreamAudioEffectType[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        if (this.type != 0) goto L6;
        return "MIXED_STREAM_AUDIO_EFFECT_TYPE_NONE";
    L6:
        return "MIXED_STREAM_AUDIO_EFFECT_TYPE_CONCERT_LIVE";
    }

    public int value() {
        return this.type;
    }

    public static MixedStreamAudioEffectType valueOf(String r100) {
        return (MixedStreamAudioEffectType) a.a(MixedStreamAudioEffectType.class, r100);
    }

    private MixedStreamAudioEffectType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
