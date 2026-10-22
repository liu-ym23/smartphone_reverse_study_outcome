package com.ss.bytertc.engine.live;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum MixedStreamSEIContentMode extends Enum<MixedStreamSEIContentMode> {
    private static final /* synthetic */ MixedStreamSEIContentMode[] $VALUES = null;
    public static final MixedStreamSEIContentMode MIXED_STREAM_SEI_CONTENT_MODE_DEFAULT = null;
    public static final MixedStreamSEIContentMode MIXED_STREAM_SEI_CONTENT_MODE_ENABLE_VOLUME_INDICATION = null;
    private int seiContentMode;

    static {
        MixedStreamSEIContentMode r100 = new MixedStreamSEIContentMode("MIXED_STREAM_SEI_CONTENT_MODE_DEFAULT", 0, 0);
        MIXED_STREAM_SEI_CONTENT_MODE_DEFAULT = r100;
        MixedStreamSEIContentMode r101 = new MixedStreamSEIContentMode("MIXED_STREAM_SEI_CONTENT_MODE_ENABLE_VOLUME_INDICATION", 1, 1);
        MIXED_STREAM_SEI_CONTENT_MODE_ENABLE_VOLUME_INDICATION = r101;
        $VALUES = new MixedStreamSEIContentMode[]{r100, r101};
    }

    public static MixedStreamSEIContentMode[] values() {
        return (MixedStreamSEIContentMode[]) $VALUES.clone();
    }

    public int getValue() {
        return this.seiContentMode;
    }

    public static MixedStreamSEIContentMode valueOf(String r100) {
        return (MixedStreamSEIContentMode) a.a(MixedStreamSEIContentMode.class, r100);
    }

    private MixedStreamSEIContentMode(String r100, int r101, int r102) {
        super(r100, r101);
        this.seiContentMode = r102;
    }
}
