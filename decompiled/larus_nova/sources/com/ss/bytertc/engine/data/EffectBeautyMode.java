package com.ss.bytertc.engine.data;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum EffectBeautyMode extends Enum<EffectBeautyMode> {
    private static final /* synthetic */ EffectBeautyMode[] $VALUES = null;
    public static final EffectBeautyMode CLEAR = null;
    public static final EffectBeautyMode SHARPEN = null;
    public static final EffectBeautyMode SMOOTH = null;
    public static final EffectBeautyMode WHITE = null;
    private int value;

    static {
        EffectBeautyMode r100 = new EffectBeautyMode("WHITE", 0, 0);
        WHITE = r100;
        EffectBeautyMode r101 = new EffectBeautyMode("SMOOTH", 1, 1);
        SMOOTH = r101;
        EffectBeautyMode r102 = new EffectBeautyMode("SHARPEN", 2, 2);
        SHARPEN = r102;
        EffectBeautyMode r103 = new EffectBeautyMode("CLEAR", 3, 3);
        CLEAR = r103;
        $VALUES = new EffectBeautyMode[]{r100, r101, r102, r103};
    }

    public static EffectBeautyMode[] values() {
        return (EffectBeautyMode[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        if (this != WHITE) goto L7;
        return "kEffectBeautyWhiteMode";
    L7:
        if (this != SMOOTH) goto L11;
        return "kEffectBeautySmoothMode";
    L11:
        if (this != SHARPEN) goto L15;
        return "kEffectBeautySharpenMode";
    L15:
        if (this != CLEAR) goto L18;
        return "kEffectBeautyClearMode";
    L18:
        return "";
    }

    public int value() {
        return this.value;
    }

    public static EffectBeautyMode fromId(int r100) {
        EffectBeautyMode[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        EffectBeautyMode r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static EffectBeautyMode valueOf(String r100) {
        return (EffectBeautyMode) a.a(EffectBeautyMode.class, r100);
    }

    private EffectBeautyMode(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
