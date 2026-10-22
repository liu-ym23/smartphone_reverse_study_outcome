package com.obric.oui.constraintlayout.core.dsl;

import r27.a;

/* JADX INFO: loaded from: classes34.dex */
public final enum Chain$Style extends Enum<Chain$Style> {
    public static final Chain$Style PACKED = null;
    public static final Chain$Style SPREAD = null;
    public static final Chain$Style SPREAD_INSIDE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Chain$Style[] f399657a = null;

    static {
        Chain$Style r100 = new Chain$Style("PACKED", 0);
        PACKED = r100;
        Chain$Style r101 = new Chain$Style("SPREAD", 1);
        SPREAD = r101;
        Chain$Style r102 = new Chain$Style("SPREAD_INSIDE", 2);
        SPREAD_INSIDE = r102;
        f399657a = new Chain$Style[]{r100, r101, r102};
    }

    public static Chain$Style[] values() {
        return (Chain$Style[]) f399657a.clone();
    }

    public static Chain$Style valueOf(String r100) {
        return (Chain$Style) a.a(Chain$Style.class, r100);
    }

    public Chain$Style(String r100, int r101) {
        super(r100, r101);
    }
}
