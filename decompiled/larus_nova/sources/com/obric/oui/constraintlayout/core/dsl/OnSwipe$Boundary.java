package com.obric.oui.constraintlayout.core.dsl;

import r27.a;

/* JADX INFO: loaded from: classes34.dex */
public final enum OnSwipe$Boundary extends Enum<OnSwipe$Boundary> {
    public static final OnSwipe$Boundary BOUNCE_BOTH = null;
    public static final OnSwipe$Boundary BOUNCE_END = null;
    public static final OnSwipe$Boundary BOUNCE_START = null;
    public static final OnSwipe$Boundary OVERSHOOT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OnSwipe$Boundary[] f399672a = null;

    static {
        OnSwipe$Boundary r100 = new OnSwipe$Boundary("OVERSHOOT", 0);
        OVERSHOOT = r100;
        OnSwipe$Boundary r101 = new OnSwipe$Boundary("BOUNCE_START", 1);
        BOUNCE_START = r101;
        OnSwipe$Boundary r102 = new OnSwipe$Boundary("BOUNCE_END", 2);
        BOUNCE_END = r102;
        OnSwipe$Boundary r103 = new OnSwipe$Boundary("BOUNCE_BOTH", 3);
        BOUNCE_BOTH = r103;
        f399672a = new OnSwipe$Boundary[]{r100, r101, r102, r103};
    }

    public static OnSwipe$Boundary[] values() {
        return (OnSwipe$Boundary[]) f399672a.clone();
    }

    public static OnSwipe$Boundary valueOf(String r100) {
        return (OnSwipe$Boundary) a.a(OnSwipe$Boundary.class, r100);
    }

    public OnSwipe$Boundary(String r100, int r101) {
        super(r100, r101);
    }
}
