package com.obric.oui.graphic;

import android.graphics.PorterDuff;
import com.obric.oui.material.OMaterialHelper;
import com.obric.oui.material.j;

/* JADX INFO: loaded from: classes5.dex */
public final enum BlendMode extends Enum<BlendMode> {
    public static final BlendMode[] BLEND_MODES = null;
    public static final BlendMode CLEAR = null;
    public static final BlendMode COLOR = null;
    public static final BlendMode COLOR_BURN = null;
    public static final BlendMode COLOR_DODGE = null;
    public static final BlendMode DARKEN = null;
    public static final BlendMode DIFFERENCE = null;
    public static final BlendMode DST = null;
    public static final BlendMode DST_ATOP = null;
    public static final BlendMode DST_IN = null;
    public static final BlendMode DST_OUT = null;
    public static final BlendMode DST_OVER = null;
    public static final BlendMode EXCLUSION = null;
    public static final BlendMode HARD_LIGHT = null;
    public static final BlendMode HUE = null;
    public static final BlendMode LIGHTEN = null;
    public static final BlendMode LUMINOSITY = null;
    public static final BlendMode MODULATE = null;
    public static final BlendMode MULTIPLY = null;
    public static final BlendMode OVERLAY = null;
    public static final BlendMode PLUS = null;
    public static final BlendMode PLUS_DARKER = null;
    public static final BlendMode PLUS_LIGHTER = null;
    public static final BlendMode SATURATION = null;
    public static final BlendMode SCREEN = null;
    public static final BlendMode SOFT_LIGHT = null;
    public static final BlendMode SRC = null;
    public static final BlendMode SRC_ATOP = null;
    public static final BlendMode SRC_IN = null;
    public static final BlendMode SRC_OUT = null;
    public static final BlendMode SRC_OVER = null;
    public static final BlendMode XOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BlendMode[] f401059a = null;
    public final int porterDuffMode;

    /* JADX INFO: loaded from: classes34.dex */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f401060a = null;

        static {
            int[] r100 = new int[BlendMode.values().length];
            f401060a = r100;
            r100[BlendMode.CLEAR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L22
        L62:
            f401060a[BlendMode.SRC.ordinal()] = 2;     // Catch: NoSuchFieldError -> L23
        L46:
            f401060a[BlendMode.DST.ordinal()] = 3;     // Catch: NoSuchFieldError -> L24
        L58:
            f401060a[BlendMode.SRC_OVER.ordinal()] = 4;     // Catch: NoSuchFieldError -> L25
        L64:
            f401060a[BlendMode.DST_OVER.ordinal()] = 5;     // Catch: NoSuchFieldError -> L26
        L48:
            f401060a[BlendMode.SRC_IN.ordinal()] = 6;     // Catch: NoSuchFieldError -> L27
        L52:
            f401060a[BlendMode.DST_IN.ordinal()] = 7;     // Catch: NoSuchFieldError -> L28
        L74:
            f401060a[BlendMode.SRC_OUT.ordinal()] = 8;     // Catch: NoSuchFieldError -> L29
        L42:
            f401060a[BlendMode.DST_OUT.ordinal()] = 9;     // Catch: NoSuchFieldError -> L30
        L68:
            f401060a[BlendMode.SRC_ATOP.ordinal()] = 10;     // Catch: NoSuchFieldError -> L31
        L70:
            f401060a[BlendMode.DST_ATOP.ordinal()] = 11;     // Catch: NoSuchFieldError -> L32
        L54:
            f401060a[BlendMode.XOR.ordinal()] = 12;     // Catch: NoSuchFieldError -> L33
        L60:
            f401060a[BlendMode.DARKEN.ordinal()] = 13;     // Catch: NoSuchFieldError -> L34
        L44:
            f401060a[BlendMode.LIGHTEN.ordinal()] = 14;     // Catch: NoSuchFieldError -> L35
        L50:
            f401060a[BlendMode.MODULATE.ordinal()] = 15;     // Catch: NoSuchFieldError -> L36
        L72:
            f401060a[BlendMode.SCREEN.ordinal()] = 16;     // Catch: NoSuchFieldError -> L37
        L40:
            f401060a[BlendMode.PLUS.ordinal()] = 17;     // Catch: NoSuchFieldError -> L38
        L66:
            f401060a[BlendMode.OVERLAY.ordinal()] = 18;     // Catch: NoSuchFieldError -> L39
            return;
        }
    }

    static {
        BlendMode r100 = new BlendMode("CLEAR", 0, 0);
        CLEAR = r100;
        BlendMode r101 = new BlendMode("SRC", 1, 1);
        SRC = r101;
        BlendMode r102 = new BlendMode("DST", 2, 2);
        DST = r102;
        BlendMode r103 = new BlendMode("SRC_OVER", 3, 3);
        SRC_OVER = r103;
        BlendMode r104 = new BlendMode("DST_OVER", 4, 4);
        DST_OVER = r104;
        BlendMode r105 = new BlendMode("SRC_IN", 5, 5);
        SRC_IN = r105;
        BlendMode r110 = new BlendMode("DST_IN", 6, 6);
        DST_IN = r110;
        BlendMode r111 = new BlendMode("SRC_OUT", 7, 7);
        SRC_OUT = r111;
        BlendMode r112 = new BlendMode("DST_OUT", 8, 8);
        DST_OUT = r112;
        BlendMode r113 = new BlendMode("SRC_ATOP", 9, 9);
        SRC_ATOP = r113;
        BlendMode r114 = new BlendMode("DST_ATOP", 10, 10);
        DST_ATOP = r114;
        BlendMode r115 = new BlendMode("XOR", 11, 11);
        XOR = r115;
        BlendMode r106 = new BlendMode("PLUS", 12, 12);
        PLUS = r106;
        BlendMode r107 = new BlendMode("MODULATE", 13, 13);
        MODULATE = r107;
        BlendMode r108 = new BlendMode("SCREEN", 14, 14);
        SCREEN = r108;
        BlendMode r109 = new BlendMode("OVERLAY", 15, 15);
        OVERLAY = r109;
        BlendMode r116 = new BlendMode("DARKEN", 16, 16);
        DARKEN = r116;
        BlendMode r117 = new BlendMode("LIGHTEN", 17, 17);
        LIGHTEN = r117;
        BlendMode r118 = new BlendMode("COLOR_DODGE", 18, 18);
        COLOR_DODGE = r118;
        BlendMode r119 = new BlendMode("COLOR_BURN", 19, 19);
        COLOR_BURN = r119;
        BlendMode r120 = new BlendMode("HARD_LIGHT", 20, 20);
        HARD_LIGHT = r120;
        BlendMode r121 = new BlendMode("SOFT_LIGHT", 21, 21);
        SOFT_LIGHT = r121;
        BlendMode r122 = new BlendMode("DIFFERENCE", 22, 22);
        DIFFERENCE = r122;
        BlendMode r123 = new BlendMode("EXCLUSION", 23, 23);
        EXCLUSION = r123;
        BlendMode r124 = new BlendMode("MULTIPLY", 24, 24);
        MULTIPLY = r124;
        BlendMode r125 = new BlendMode("HUE", 25, 25);
        HUE = r125;
        BlendMode r126 = new BlendMode("SATURATION", 26, 26);
        SATURATION = r126;
        BlendMode r127 = new BlendMode("COLOR", 27, 27);
        COLOR = r127;
        BlendMode r128 = new BlendMode("LUMINOSITY", 28, 28);
        LUMINOSITY = r128;
        BlendMode r129 = new BlendMode("PLUS_DARKER", 29, 101);
        PLUS_DARKER = r129;
        BlendMode r130 = new BlendMode("PLUS_LIGHTER", 30, 102);
        PLUS_LIGHTER = r130;
        f401059a = new BlendMode[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130};
        BLEND_MODES = values();
    }

    public static BlendMode[] values() {
        return (BlendMode[]) f401059a.clone();
    }

    public int getPorterDuffMode() {
        return this.porterDuffMode;
    }

    public static PorterDuff.Mode blendModeToPorterDuffMode(BlendMode r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        switch(a.f401060a[r100.ordinal()]) {
            case 1: goto L43;
            case 2: goto L41;
            case 3: goto L39;
            case 4: goto L37;
            case 5: goto L35;
            case 6: goto L33;
            case 7: goto L31;
            case 8: goto L29;
            case 9: goto L27;
            case 10: goto L25;
            case 11: goto L23;
            case 12: goto L21;
            case 13: goto L19;
            case 14: goto L17;
            case 15: goto L15;
            case 16: goto L13;
            case 17: goto L11;
            case 18: goto L9;
            default: goto L7;
        };
    L7:
        return null;
    L9:
        return PorterDuff.Mode.OVERLAY;
    L11:
        return PorterDuff.Mode.ADD;
    L13:
        return PorterDuff.Mode.SCREEN;
    L15:
        return PorterDuff.Mode.MULTIPLY;
    L17:
        return PorterDuff.Mode.LIGHTEN;
    L19:
        return PorterDuff.Mode.DARKEN;
    L21:
        return PorterDuff.Mode.XOR;
    L23:
        return PorterDuff.Mode.DST_ATOP;
    L25:
        return PorterDuff.Mode.SRC_ATOP;
    L27:
        return PorterDuff.Mode.DST_OUT;
    L29:
        return PorterDuff.Mode.SRC_OUT;
    L31:
        return PorterDuff.Mode.DST_IN;
    L33:
        return PorterDuff.Mode.SRC_IN;
    L35:
        return PorterDuff.Mode.DST_OVER;
    L37:
        return PorterDuff.Mode.SRC_OVER;
    L39:
        return PorterDuff.Mode.DST;
    L41:
        return PorterDuff.Mode.SRC;
    L43:
        return PorterDuff.Mode.CLEAR;
    }

    public static BlendMode fromValue(int r100) {
        BlendMode[] r101 = BLEND_MODES;
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        BlendMode r104 = r101[r103];
        if (r104.porterDuffMode == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static int mapToLegacyObricBlend(int r100) {
        return mapToLegacyObricBlend(r100, false);
    }

    public static android.graphics.BlendMode toAndroidBlendMode(BlendMode r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        switch(a.f401060a[r100.ordinal()]) {
            case 1: goto L43;
            case 2: goto L41;
            case 3: goto L39;
            case 4: goto L37;
            case 5: goto L35;
            case 6: goto L33;
            case 7: goto L31;
            case 8: goto L29;
            case 9: goto L27;
            case 10: goto L25;
            case 11: goto L23;
            case 12: goto L21;
            case 13: goto L19;
            case 14: goto L17;
            case 15: goto L15;
            case 16: goto L13;
            case 17: goto L11;
            case 18: goto L9;
            default: goto L7;
        };
    L7:
        return null;
    L9:
        return android.graphics.BlendMode.OVERLAY;
    L11:
        return android.graphics.BlendMode.PLUS;
    L13:
        return android.graphics.BlendMode.SCREEN;
    L15:
        return android.graphics.BlendMode.MULTIPLY;
    L17:
        return android.graphics.BlendMode.LIGHTEN;
    L19:
        return android.graphics.BlendMode.DARKEN;
    L21:
        return android.graphics.BlendMode.XOR;
    L23:
        return android.graphics.BlendMode.DST_ATOP;
    L25:
        return android.graphics.BlendMode.SRC_ATOP;
    L27:
        return android.graphics.BlendMode.DST_OUT;
    L29:
        return android.graphics.BlendMode.SRC_OUT;
    L31:
        return android.graphics.BlendMode.DST_IN;
    L33:
        return android.graphics.BlendMode.SRC_IN;
    L35:
        return android.graphics.BlendMode.DST_OVER;
    L37:
        return android.graphics.BlendMode.SRC_OVER;
    L39:
        return android.graphics.BlendMode.DST;
    L41:
        return android.graphics.BlendMode.SRC;
    L43:
        return android.graphics.BlendMode.CLEAR;
    }

    public static int toValue(BlendMode r100) {
        return r100.porterDuffMode;
    }

    public static BlendMode valueOf(String r100) {
        return (BlendMode) r27.a.a(BlendMode.class, r100);
    }

    public static int mapToLegacyObricBlend(BlendMode r100) {
        return mapToLegacyObricBlend(r100, false);
    }

    public static int mapToLegacyObricBlend(int r100, boolean r101) {
        int r102 = j.f401474a;
        if (r101 == true) goto L6;
        return r100;
    L6:
        if (r100 != SRC_OVER.ordinal()) goto L10;
        return OMaterialHelper.LEGACY_BLEND_MODE.DEFAULT.ordinal();
    L10:
        if (r100 != COLOR_BURN.ordinal()) goto L14;
        return OMaterialHelper.LEGACY_BLEND_MODE.COLOR_BURN.ordinal();
    L14:
        if (r100 != COLOR_DODGE.ordinal()) goto L18;
        return OMaterialHelper.LEGACY_BLEND_MODE.COLOR_DODGE.ordinal();
    L18:
        if (r100 != PLUS_DARKER.ordinal()) goto L22;
        return OMaterialHelper.LEGACY_BLEND_MODE.PLUS_DARKER.ordinal();
    L22:
        if (r100 != PLUS_LIGHTER.ordinal()) goto L26;
        return OMaterialHelper.LEGACY_BLEND_MODE.PLUS_LIGHTER.ordinal();
    L26:
        if (r100 != LUMINOSITY.ordinal()) goto L30;
        return OMaterialHelper.LEGACY_BLEND_MODE.LUMINOSITY.ordinal();
    L30:
        if (r100 != OVERLAY.ordinal()) goto L34;
        return OMaterialHelper.LEGACY_BLEND_MODE.OVERLAY.ordinal();
    L34:
        if (r100 != SOFT_LIGHT.ordinal()) goto L38;
        return OMaterialHelper.LEGACY_BLEND_MODE.SOFT_LIGHT.ordinal();
    L38:
        return OMaterialHelper.LEGACY_BLEND_MODE.DEFAULT.ordinal();
    }

    public static int mapToLegacyObricBlend(BlendMode r100, boolean r101) {
        int r102 = j.f401474a;
        if (r101 == true) goto L10;
        if (r100 != null) goto L8;
        r100 = SRC_OVER;
    L8:
        return r100.porterDuffMode;
    L10:
        if (r100 != SRC_OVER) goto L14;
        return OMaterialHelper.LEGACY_BLEND_MODE.DEFAULT.ordinal();
    L14:
        if (r100 != COLOR_BURN) goto L18;
        return OMaterialHelper.LEGACY_BLEND_MODE.COLOR_BURN.ordinal();
    L18:
        if (r100 != COLOR_DODGE) goto L22;
        return OMaterialHelper.LEGACY_BLEND_MODE.COLOR_DODGE.ordinal();
    L22:
        if (r100 != PLUS_DARKER) goto L26;
        return OMaterialHelper.LEGACY_BLEND_MODE.PLUS_DARKER.ordinal();
    L26:
        if (r100 != PLUS_LIGHTER) goto L30;
        return OMaterialHelper.LEGACY_BLEND_MODE.PLUS_LIGHTER.ordinal();
    L30:
        if (r100 != LUMINOSITY) goto L34;
        return OMaterialHelper.LEGACY_BLEND_MODE.LUMINOSITY.ordinal();
    L34:
        if (r100 != OVERLAY) goto L38;
        return OMaterialHelper.LEGACY_BLEND_MODE.OVERLAY.ordinal();
    L38:
        if (r100 != SOFT_LIGHT) goto L42;
        return OMaterialHelper.LEGACY_BLEND_MODE.SOFT_LIGHT.ordinal();
    L42:
        return OMaterialHelper.LEGACY_BLEND_MODE.DEFAULT.ordinal();
    }

    public BlendMode(String r100, int r101, int r102) {
        super(r100, r101);
        this.porterDuffMode = r102;
    }
}
