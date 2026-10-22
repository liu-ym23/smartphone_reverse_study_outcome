package com.ss.bytertc.engine.live;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum MixedStreamAudioCodecType extends Enum<MixedStreamAudioCodecType> {
    private static final /* synthetic */ MixedStreamAudioCodecType[] $VALUES = null;
    public static final MixedStreamAudioCodecType MIXED_STREAM_AUDIO_CODEC_TYPE_AAC = null;
    private String audioCodecType;

    static {
        MixedStreamAudioCodecType r100 = new MixedStreamAudioCodecType("MIXED_STREAM_AUDIO_CODEC_TYPE_AAC", 0, "AAC");
        MIXED_STREAM_AUDIO_CODEC_TYPE_AAC = r100;
        $VALUES = new MixedStreamAudioCodecType[]{r100};
    }

    public static MixedStreamAudioCodecType[] values() {
        return (MixedStreamAudioCodecType[]) $VALUES.clone();
    }

    public String getValue() {
        return this.audioCodecType;
    }

    public static MixedStreamAudioCodecType valueOf(String r100) {
        return (MixedStreamAudioCodecType) a.a(MixedStreamAudioCodecType.class, r100);
    }

    private MixedStreamAudioCodecType(String r100, int r101, String r102) {
        super(r100, r101);
        this.audioCodecType = r102;
    }
}
