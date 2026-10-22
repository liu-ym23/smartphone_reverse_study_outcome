package com.github.ybq.android.spinkit;

import r27.a;

/* JADX INFO: loaded from: classes23.dex */
public final enum Style extends Enum<Style> {
    public static final Style CHASING_DOTS = null;
    public static final Style CIRCLE = null;
    public static final Style CUBE_GRID = null;
    public static final Style DOUBLE_BOUNCE = null;
    public static final Style FADING_CIRCLE = null;
    public static final Style FOLDING_CUBE = null;
    public static final Style MULTIPLE_PULSE = null;
    public static final Style MULTIPLE_PULSE_RING = null;
    public static final Style PULSE = null;
    public static final Style PULSE_RING = null;
    public static final Style ROTATING_CIRCLE = null;
    public static final Style ROTATING_PLANE = null;
    public static final Style THREE_BOUNCE = null;
    public static final Style WANDERING_CUBES = null;
    public static final Style WAVE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Style[] f274342a = null;
    private int value;

    static {
        Style r100 = new Style("ROTATING_PLANE", 0, 0);
        ROTATING_PLANE = r100;
        Style r101 = new Style("DOUBLE_BOUNCE", 1, 1);
        DOUBLE_BOUNCE = r101;
        Style r102 = new Style("WAVE", 2, 2);
        WAVE = r102;
        Style r103 = new Style("WANDERING_CUBES", 3, 3);
        WANDERING_CUBES = r103;
        Style r104 = new Style("PULSE", 4, 4);
        PULSE = r104;
        Style r105 = new Style("CHASING_DOTS", 5, 5);
        CHASING_DOTS = r105;
        Style r110 = new Style("THREE_BOUNCE", 6, 6);
        THREE_BOUNCE = r110;
        Style r111 = new Style("CIRCLE", 7, 7);
        CIRCLE = r111;
        Style r112 = new Style("CUBE_GRID", 8, 8);
        CUBE_GRID = r112;
        Style r113 = new Style("FADING_CIRCLE", 9, 9);
        FADING_CIRCLE = r113;
        Style r114 = new Style("FOLDING_CUBE", 10, 10);
        FOLDING_CUBE = r114;
        Style r115 = new Style("ROTATING_CIRCLE", 11, 11);
        ROTATING_CIRCLE = r115;
        Style r106 = new Style("MULTIPLE_PULSE", 12, 12);
        MULTIPLE_PULSE = r106;
        Style r107 = new Style("PULSE_RING", 13, 13);
        PULSE_RING = r107;
        Style r108 = new Style("MULTIPLE_PULSE_RING", 14, 14);
        MULTIPLE_PULSE_RING = r108;
        f274342a = new Style[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108};
    }

    public static Style[] values() {
        return (Style[]) f274342a.clone();
    }

    public static Style valueOf(String r100) {
        return (Style) a.a(Style.class, r100);
    }

    public Style(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
