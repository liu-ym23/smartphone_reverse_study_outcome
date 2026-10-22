package com.obric.oui.constraintlayout.core.dsl;

import r27.a;

/* JADX INFO: loaded from: classes34.dex */
public final enum OnSwipe$Mode extends Enum<OnSwipe$Mode> {
    public static final OnSwipe$Mode SPRING = null;
    public static final OnSwipe$Mode VELOCITY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OnSwipe$Mode[] f399674a = null;

    static {
        OnSwipe$Mode r100 = new OnSwipe$Mode("VELOCITY", 0);
        VELOCITY = r100;
        OnSwipe$Mode r101 = new OnSwipe$Mode("SPRING", 1);
        SPRING = r101;
        f399674a = new OnSwipe$Mode[]{r100, r101};
    }

    public static OnSwipe$Mode[] values() {
        return (OnSwipe$Mode[]) f399674a.clone();
    }

    public static OnSwipe$Mode valueOf(String r100) {
        return (OnSwipe$Mode) a.a(OnSwipe$Mode.class, r100);
    }

    public OnSwipe$Mode(String r100, int r101) {
        super(r100, r101);
    }
}
