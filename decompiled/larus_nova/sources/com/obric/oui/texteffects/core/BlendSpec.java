package com.obric.oui.texteffects.core;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u001e\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001e¨\u0006\u001f"}, d2 = {"Lcom/obric/oui/texteffects/core/BlendSpec;", "", "CLEAR", "SRC", "DST", "SRC_OVER", "DST_OVER", "SRC_IN", "DST_IN", "SRC_OUT", "DST_OUT", "SRC_ATOP", "DST_ATOP", "XOR", "PLUS", "MODULATE", "SCREEN", "OVERLAY", "DARKEN", "LIGHTEN", "COLOR_DODGE", "COLOR_BURN", "HARD_LIGHT", "SOFT_LIGHT", "DIFFERENCE", "EXCLUSION", "MULTIPLY", "HUE", "SATURATION", "COLOR", "LUMINOSITY", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0})
public final enum BlendSpec extends Enum<BlendSpec> {
    public static final BlendSpec CLEAR = null;
    public static final BlendSpec COLOR = null;
    public static final BlendSpec COLOR_BURN = null;
    public static final BlendSpec COLOR_DODGE = null;
    public static final BlendSpec DARKEN = null;
    public static final BlendSpec DIFFERENCE = null;
    public static final BlendSpec DST = null;
    public static final BlendSpec DST_ATOP = null;
    public static final BlendSpec DST_IN = null;
    public static final BlendSpec DST_OUT = null;
    public static final BlendSpec DST_OVER = null;
    public static final BlendSpec EXCLUSION = null;
    public static final BlendSpec HARD_LIGHT = null;
    public static final BlendSpec HUE = null;
    public static final BlendSpec LIGHTEN = null;
    public static final BlendSpec LUMINOSITY = null;
    public static final BlendSpec MODULATE = null;
    public static final BlendSpec MULTIPLY = null;
    public static final BlendSpec OVERLAY = null;
    public static final BlendSpec PLUS = null;
    public static final BlendSpec SATURATION = null;
    public static final BlendSpec SCREEN = null;
    public static final BlendSpec SOFT_LIGHT = null;
    public static final BlendSpec SRC = null;
    public static final BlendSpec SRC_ATOP = null;
    public static final BlendSpec SRC_IN = null;
    public static final BlendSpec SRC_OUT = null;
    public static final BlendSpec SRC_OVER = null;
    public static final BlendSpec XOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BlendSpec[] f403301a = null;

    public static BlendSpec valueOf(String r100) {
        return (BlendSpec) a.a(BlendSpec.class, r100);
    }

    public static BlendSpec[] values() {
        return (BlendSpec[]) f403301a.clone();
    }

    static {
        BlendSpec r100 = new BlendSpec("CLEAR", 0);
        CLEAR = r100;
        BlendSpec r101 = new BlendSpec("SRC", 1);
        SRC = r101;
        BlendSpec r102 = new BlendSpec("DST", 2);
        DST = r102;
        BlendSpec r103 = new BlendSpec("SRC_OVER", 3);
        SRC_OVER = r103;
        BlendSpec r104 = new BlendSpec("DST_OVER", 4);
        DST_OVER = r104;
        BlendSpec r105 = new BlendSpec("SRC_IN", 5);
        SRC_IN = r105;
        BlendSpec r110 = new BlendSpec("DST_IN", 6);
        DST_IN = r110;
        BlendSpec r111 = new BlendSpec("SRC_OUT", 7);
        SRC_OUT = r111;
        BlendSpec r112 = new BlendSpec("DST_OUT", 8);
        DST_OUT = r112;
        BlendSpec r113 = new BlendSpec("SRC_ATOP", 9);
        SRC_ATOP = r113;
        BlendSpec r114 = new BlendSpec("DST_ATOP", 10);
        DST_ATOP = r114;
        BlendSpec r115 = new BlendSpec("XOR", 11);
        XOR = r115;
        BlendSpec r106 = new BlendSpec("PLUS", 12);
        PLUS = r106;
        BlendSpec r107 = new BlendSpec("MODULATE", 13);
        MODULATE = r107;
        BlendSpec r108 = new BlendSpec("SCREEN", 14);
        SCREEN = r108;
        BlendSpec r109 = new BlendSpec("OVERLAY", 15);
        OVERLAY = r109;
        BlendSpec r116 = new BlendSpec("DARKEN", 16);
        DARKEN = r116;
        BlendSpec r117 = new BlendSpec("LIGHTEN", 17);
        LIGHTEN = r117;
        BlendSpec r118 = new BlendSpec("COLOR_DODGE", 18);
        COLOR_DODGE = r118;
        BlendSpec r119 = new BlendSpec("COLOR_BURN", 19);
        COLOR_BURN = r119;
        BlendSpec r120 = new BlendSpec("HARD_LIGHT", 20);
        HARD_LIGHT = r120;
        BlendSpec r121 = new BlendSpec("SOFT_LIGHT", 21);
        SOFT_LIGHT = r121;
        BlendSpec r122 = new BlendSpec("DIFFERENCE", 22);
        DIFFERENCE = r122;
        BlendSpec r123 = new BlendSpec("EXCLUSION", 23);
        EXCLUSION = r123;
        BlendSpec r124 = new BlendSpec("MULTIPLY", 24);
        MULTIPLY = r124;
        BlendSpec r125 = new BlendSpec("HUE", 25);
        HUE = r125;
        BlendSpec r126 = new BlendSpec("SATURATION", 26);
        SATURATION = r126;
        BlendSpec r127 = new BlendSpec("COLOR", 27);
        COLOR = r127;
        BlendSpec r128 = new BlendSpec("LUMINOSITY", 28);
        LUMINOSITY = r128;
        f403301a = new BlendSpec[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128};
    }

    public BlendSpec(String r100, int r101) {
        super(r100, r101);
    }
}
