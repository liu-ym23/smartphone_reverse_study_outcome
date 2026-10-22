package com.lynx.tasm.resourceprovider.media;

import r27.a;

/* JADX INFO: loaded from: classes32.dex */
public final enum OptionalBool extends Enum<OptionalBool> {
    public static final OptionalBool FALSE = null;
    public static final OptionalBool TRUE = null;
    public static final OptionalBool UNDEFINED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OptionalBool[] f383712a = null;

    static {
        OptionalBool r100 = new OptionalBool("TRUE", 0);
        TRUE = r100;
        OptionalBool r101 = new OptionalBool("FALSE", 1);
        FALSE = r101;
        OptionalBool r102 = new OptionalBool("UNDEFINED", 2);
        UNDEFINED = r102;
        f383712a = new OptionalBool[]{r100, r101, r102};
    }

    public static OptionalBool[] values() {
        return (OptionalBool[]) f383712a.clone();
    }

    public static OptionalBool valueOf(String r100) {
        return (OptionalBool) a.a(OptionalBool.class, r100);
    }

    public OptionalBool(String r100, int r101) {
        super(r100, r101);
    }
}
