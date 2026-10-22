package com.ss.android.ugc.bytex.code_shrinker.library;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum ShrinkType extends Enum<ShrinkType> {
    public static final ShrinkType DEFAULT = null;
    public static final ShrinkType DEFINE = null;
    public static final ShrinkType INVOKE = null;
    public static final ShrinkType INVOKE_AND_DEFINE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ShrinkType[] f454358a = null;

    static {
        ShrinkType r100 = new ShrinkType("INVOKE", 0);
        INVOKE = r100;
        ShrinkType r101 = new ShrinkType("DEFINE", 1);
        DEFINE = r101;
        ShrinkType r102 = new ShrinkType("INVOKE_AND_DEFINE", 2);
        INVOKE_AND_DEFINE = r102;
        f454358a = new ShrinkType[]{r100, r101, r102};
        DEFAULT = r100;
    }

    public static ShrinkType[] values() {
        return (ShrinkType[]) f454358a.clone();
    }

    public static ShrinkType parseShrinkType(String r100) throws IllegalArgumentException {
        ShrinkType r101 = INVOKE;
        if (r100.equals(r101.name()) == false) goto L5;
        return r101;
    L5:
        ShrinkType r102 = DEFINE;
        if (r100.equals(r102.name()) == false) goto L8;
        return r102;
    L8:
        ShrinkType r103 = INVOKE_AND_DEFINE;
        if (r100.equals(r103.name()) == false) goto L12;
        return r103;
    L12:
        throw new IllegalArgumentException(r100);
    }

    public static ShrinkType valueOf(String r100) {
        return (ShrinkType) a.a(ShrinkType.class, r100);
    }

    public ShrinkType(String r100, int r101) {
        super(r100, r101);
    }
}
