package com.ss.bytertc.engine.live;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum MixedStreamAlternateImageFillMode extends Enum<MixedStreamAlternateImageFillMode> {
    private static final /* synthetic */ MixedStreamAlternateImageFillMode[] $VALUES = null;
    public static final MixedStreamAlternateImageFillMode FILL = null;
    public static final MixedStreamAlternateImageFillMode FIT = null;
    private int imageFillMode;

    static {
        MixedStreamAlternateImageFillMode r100 = new MixedStreamAlternateImageFillMode("FIT", 0, 0);
        FIT = r100;
        MixedStreamAlternateImageFillMode r101 = new MixedStreamAlternateImageFillMode("FILL", 1, 1);
        FILL = r101;
        $VALUES = new MixedStreamAlternateImageFillMode[]{r100, r101};
    }

    public static MixedStreamAlternateImageFillMode[] values() {
        return (MixedStreamAlternateImageFillMode[]) $VALUES.clone();
    }

    public int getValue() {
        return this.imageFillMode;
    }

    public static MixedStreamAlternateImageFillMode valueOf(String r100) {
        return (MixedStreamAlternateImageFillMode) a.a(MixedStreamAlternateImageFillMode.class, r100);
    }

    private MixedStreamAlternateImageFillMode(String r100, int r101, int r102) {
        super(r100, r101);
        this.imageFillMode = r102;
    }
}
