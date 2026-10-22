package com.ss.bytertc.engine.live;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum MixedStreamMediaType extends Enum<MixedStreamMediaType> {
    private static final /* synthetic */ MixedStreamMediaType[] $VALUES = null;
    public static final MixedStreamMediaType MIXED_STREAM_MEDIA_TYPE_AUDIO_AND_VIDEO = null;
    public static final MixedStreamMediaType MIXED_STREAM_MEDIA_TYPE_AUDIO_ONLY = null;
    public static final MixedStreamMediaType MIXED_STREAM_MEDIA_TYPE_VIDEO_ONLY = null;
    private int contentControlType;

    static {
        MixedStreamMediaType r100 = new MixedStreamMediaType("MIXED_STREAM_MEDIA_TYPE_AUDIO_AND_VIDEO", 0, 0);
        MIXED_STREAM_MEDIA_TYPE_AUDIO_AND_VIDEO = r100;
        MixedStreamMediaType r101 = new MixedStreamMediaType("MIXED_STREAM_MEDIA_TYPE_AUDIO_ONLY", 1, 1);
        MIXED_STREAM_MEDIA_TYPE_AUDIO_ONLY = r101;
        MixedStreamMediaType r102 = new MixedStreamMediaType("MIXED_STREAM_MEDIA_TYPE_VIDEO_ONLY", 2, 2);
        MIXED_STREAM_MEDIA_TYPE_VIDEO_ONLY = r102;
        $VALUES = new MixedStreamMediaType[]{r100, r101, r102};
    }

    public static MixedStreamMediaType[] values() {
        return (MixedStreamMediaType[]) $VALUES.clone();
    }

    public int getValue() {
        return this.contentControlType;
    }

    public static MixedStreamMediaType valueOf(String r100) {
        return (MixedStreamMediaType) a.a(MixedStreamMediaType.class, r100);
    }

    private MixedStreamMediaType(String r100, int r101, int r102) {
        super(r100, r101);
        this.contentControlType = r102;
    }
}
