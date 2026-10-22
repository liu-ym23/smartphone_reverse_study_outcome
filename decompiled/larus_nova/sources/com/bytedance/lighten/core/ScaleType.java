package com.bytedance.lighten.core;

import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum ScaleType extends Enum<ScaleType> {
    public static final ScaleType CENTER = null;
    public static final ScaleType CENTER_CROP = null;
    public static final ScaleType CENTER_INSIDE = null;
    public static final ScaleType FIT_BOTTOM_START = null;
    public static final ScaleType FIT_CENTER = null;
    public static final ScaleType FIT_END = null;
    public static final ScaleType FIT_START = null;
    public static final ScaleType FIT_XY = null;
    public static final ScaleType FOCUS_CROP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ScaleType[] f254614a = null;

    static {
        ScaleType r100 = new ScaleType("FIT_XY", 0);
        FIT_XY = r100;
        ScaleType r101 = new ScaleType("FIT_START", 1);
        FIT_START = r101;
        ScaleType r102 = new ScaleType("FIT_CENTER", 2);
        FIT_CENTER = r102;
        ScaleType r103 = new ScaleType("FIT_END", 3);
        FIT_END = r103;
        ScaleType r104 = new ScaleType("CENTER", 4);
        CENTER = r104;
        ScaleType r105 = new ScaleType("CENTER_INSIDE", 5);
        CENTER_INSIDE = r105;
        ScaleType r110 = new ScaleType("CENTER_CROP", 6);
        CENTER_CROP = r110;
        ScaleType r111 = new ScaleType("FOCUS_CROP", 7);
        FOCUS_CROP = r111;
        ScaleType r112 = new ScaleType("FIT_BOTTOM_START", 8);
        FIT_BOTTOM_START = r112;
        f254614a = new ScaleType[]{r100, r101, r102, r103, r104, r105, r110, r111, r112};
    }

    public static ScaleType[] values() {
        return (ScaleType[]) f254614a.clone();
    }

    public static ScaleType valueOf(String r100) {
        return (ScaleType) a.a(ScaleType.class, r100);
    }

    public ScaleType(String r100, int r101) {
        super(r100, r101);
    }
}
