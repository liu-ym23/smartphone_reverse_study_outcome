package com.ss.bytertc.engine.type;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum EffectErrorType extends Enum<EffectErrorType> {
    private static final /* synthetic */ EffectErrorType[] $VALUES = null;
    public static final EffectErrorType EFFECT_ERROR_CHILD_PROC_TERMINATE = null;
    public static final EffectErrorType EFFECT_ERROR_VIRTUAL_BACKFROUND_FAILURE = null;
    public static final EffectErrorType OK = null;
    private int value;

    static {
        EffectErrorType r100 = new EffectErrorType("OK", 0, 0);
        OK = r100;
        EffectErrorType r101 = new EffectErrorType("EFFECT_ERROR_VIRTUAL_BACKFROUND_FAILURE", 1, 1);
        EFFECT_ERROR_VIRTUAL_BACKFROUND_FAILURE = r101;
        EffectErrorType r102 = new EffectErrorType("EFFECT_ERROR_CHILD_PROC_TERMINATE", 2, 2);
        EFFECT_ERROR_CHILD_PROC_TERMINATE = r102;
        $VALUES = new EffectErrorType[]{r100, r101, r102};
    }

    public static EffectErrorType[] values() {
        return (EffectErrorType[]) $VALUES.clone();
    }

    public int value() {
        return this.value;
    }

    public static EffectErrorType fromId(int r100) {
        EffectErrorType[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        EffectErrorType r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static EffectErrorType valueOf(String r100) {
        return (EffectErrorType) a.a(EffectErrorType.class, r100);
    }

    private EffectErrorType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
