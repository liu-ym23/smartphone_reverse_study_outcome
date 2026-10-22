package com.lynx.canvas;

import r27.a;

/* JADX INFO: loaded from: classes32.dex */
public final enum SurfaceScaleMode extends Enum<SurfaceScaleMode> {
    private static final /* synthetic */ SurfaceScaleMode[] $VALUES = null;
    public static final SurfaceScaleMode SCALE_TO_CENTER = null;
    public static final SurfaceScaleMode SCALE_TO_FILL = null;
    public static final SurfaceScaleMode SCALE_TO_FILL_AND_CROP = null;
    public static final SurfaceScaleMode SCALE_TO_FILL_WITH_SOURCE_CROP = null;
    public final int value;

    static {
        SurfaceScaleMode r100 = new SurfaceScaleMode("SCALE_TO_FILL", 0, 0);
        SCALE_TO_FILL = r100;
        SurfaceScaleMode r101 = new SurfaceScaleMode("SCALE_TO_CENTER", 1, 1);
        SCALE_TO_CENTER = r101;
        SurfaceScaleMode r102 = new SurfaceScaleMode("SCALE_TO_FILL_AND_CROP", 2, 2);
        SCALE_TO_FILL_AND_CROP = r102;
        SurfaceScaleMode r103 = new SurfaceScaleMode("SCALE_TO_FILL_WITH_SOURCE_CROP", 3, 3);
        SCALE_TO_FILL_WITH_SOURCE_CROP = r103;
        $VALUES = new SurfaceScaleMode[]{r100, r101, r102, r103};
    }

    public static SurfaceScaleMode[] values() {
        return (SurfaceScaleMode[]) $VALUES.clone();
    }

    public static SurfaceScaleMode valueOf(String r100) {
        return (SurfaceScaleMode) a.a(SurfaceScaleMode.class, r100);
    }

    private SurfaceScaleMode(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
