package com.obric.oui.constraintlayout.core.dsl;

import r27.a;

/* JADX INFO: loaded from: classes34.dex */
public final enum OnSwipe$TouchUp extends Enum<OnSwipe$TouchUp> {
    public static final OnSwipe$TouchUp AUTOCOMPLETE = null;
    public static final OnSwipe$TouchUp DECELERATE = null;
    public static final OnSwipe$TouchUp DECELERATE_COMPLETE = null;
    public static final OnSwipe$TouchUp NEVER_COMPLETE_END = null;
    public static final OnSwipe$TouchUp NEVER_COMPLETE_START = null;
    public static final OnSwipe$TouchUp STOP = null;
    public static final OnSwipe$TouchUp TO_END = null;
    public static final OnSwipe$TouchUp TO_START = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OnSwipe$TouchUp[] f399676a = null;

    static {
        OnSwipe$TouchUp r100 = new OnSwipe$TouchUp("AUTOCOMPLETE", 0);
        AUTOCOMPLETE = r100;
        OnSwipe$TouchUp r101 = new OnSwipe$TouchUp("TO_START", 1);
        TO_START = r101;
        OnSwipe$TouchUp r102 = new OnSwipe$TouchUp("NEVER_COMPLETE_END", 2);
        NEVER_COMPLETE_END = r102;
        OnSwipe$TouchUp r103 = new OnSwipe$TouchUp("TO_END", 3);
        TO_END = r103;
        OnSwipe$TouchUp r104 = new OnSwipe$TouchUp("STOP", 4);
        STOP = r104;
        OnSwipe$TouchUp r105 = new OnSwipe$TouchUp("DECELERATE", 5);
        DECELERATE = r105;
        OnSwipe$TouchUp r110 = new OnSwipe$TouchUp("DECELERATE_COMPLETE", 6);
        DECELERATE_COMPLETE = r110;
        OnSwipe$TouchUp r111 = new OnSwipe$TouchUp("NEVER_COMPLETE_START", 7);
        NEVER_COMPLETE_START = r111;
        f399676a = new OnSwipe$TouchUp[]{r100, r101, r102, r103, r104, r105, r110, r111};
    }

    public static OnSwipe$TouchUp[] values() {
        return (OnSwipe$TouchUp[]) f399676a.clone();
    }

    public static OnSwipe$TouchUp valueOf(String r100) {
        return (OnSwipe$TouchUp) a.a(OnSwipe$TouchUp.class, r100);
    }

    public OnSwipe$TouchUp(String r100, int r101) {
        super(r100, r101);
    }
}
