package com.obric.oui.constraintlayout.core.dsl;

import r27.a;

/* JADX INFO: loaded from: classes34.dex */
public final enum Helper$Type extends Enum<Helper$Type> {
    public static final Helper$Type BARRIER = null;
    public static final Helper$Type HORIZONTAL_CHAIN = null;
    public static final Helper$Type HORIZONTAL_GUIDELINE = null;
    public static final Helper$Type VERTICAL_CHAIN = null;
    public static final Helper$Type VERTICAL_GUIDELINE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Helper$Type[] f399663a = null;

    static {
        Helper$Type r100 = new Helper$Type("VERTICAL_GUIDELINE", 0);
        VERTICAL_GUIDELINE = r100;
        Helper$Type r101 = new Helper$Type("HORIZONTAL_GUIDELINE", 1);
        HORIZONTAL_GUIDELINE = r101;
        Helper$Type r102 = new Helper$Type("VERTICAL_CHAIN", 2);
        VERTICAL_CHAIN = r102;
        Helper$Type r103 = new Helper$Type("HORIZONTAL_CHAIN", 3);
        HORIZONTAL_CHAIN = r103;
        Helper$Type r104 = new Helper$Type("BARRIER", 4);
        BARRIER = r104;
        f399663a = new Helper$Type[]{r100, r101, r102, r103, r104};
    }

    public static Helper$Type[] values() {
        return (Helper$Type[]) f399663a.clone();
    }

    public static Helper$Type valueOf(String r100) {
        return (Helper$Type) a.a(Helper$Type.class, r100);
    }

    public Helper$Type(String r100, int r101) {
        super(r100, r101);
    }
}
