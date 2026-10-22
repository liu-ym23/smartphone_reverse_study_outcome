package com.obric.common.oea.foundation.blur;

import r27.a;

/* JADX INFO: loaded from: classes33.dex */
public final enum BlurUtils$BLEND_MODE extends Enum<BlurUtils$BLEND_MODE> {
    public static final BlurUtils$BLEND_MODE COLOR_BURN = null;
    public static final BlurUtils$BLEND_MODE COLOR_DODGE = null;
    public static final BlurUtils$BLEND_MODE DEFAULT = null;
    public static final BlurUtils$BLEND_MODE LUMINOSITY = null;
    public static final BlurUtils$BLEND_MODE OVERLAY = null;
    public static final BlurUtils$BLEND_MODE PLUS_DARKER = null;
    public static final BlurUtils$BLEND_MODE PLUS_LIGHTER = null;
    public static final BlurUtils$BLEND_MODE SOFT_LIGHT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BlurUtils$BLEND_MODE[] f396408a = null;

    static {
        BlurUtils$BLEND_MODE r100 = new BlurUtils$BLEND_MODE("DEFAULT", 0);
        DEFAULT = r100;
        BlurUtils$BLEND_MODE r101 = new BlurUtils$BLEND_MODE("COLOR_BURN", 1);
        COLOR_BURN = r101;
        BlurUtils$BLEND_MODE r102 = new BlurUtils$BLEND_MODE("COLOR_DODGE", 2);
        COLOR_DODGE = r102;
        BlurUtils$BLEND_MODE r103 = new BlurUtils$BLEND_MODE("PLUS_DARKER", 3);
        PLUS_DARKER = r103;
        BlurUtils$BLEND_MODE r104 = new BlurUtils$BLEND_MODE("PLUS_LIGHTER", 4);
        PLUS_LIGHTER = r104;
        BlurUtils$BLEND_MODE r105 = new BlurUtils$BLEND_MODE("LUMINOSITY", 5);
        LUMINOSITY = r105;
        BlurUtils$BLEND_MODE r110 = new BlurUtils$BLEND_MODE("OVERLAY", 6);
        OVERLAY = r110;
        BlurUtils$BLEND_MODE r111 = new BlurUtils$BLEND_MODE("SOFT_LIGHT", 7);
        SOFT_LIGHT = r111;
        f396408a = new BlurUtils$BLEND_MODE[]{r100, r101, r102, r103, r104, r105, r110, r111};
    }

    public static BlurUtils$BLEND_MODE[] values() {
        return (BlurUtils$BLEND_MODE[]) f396408a.clone();
    }

    public static BlurUtils$BLEND_MODE valueOf(String r100) {
        return (BlurUtils$BLEND_MODE) a.a(BlurUtils$BLEND_MODE.class, r100);
    }

    public BlurUtils$BLEND_MODE(String r100, int r101) {
        super(r100, r101);
    }
}
