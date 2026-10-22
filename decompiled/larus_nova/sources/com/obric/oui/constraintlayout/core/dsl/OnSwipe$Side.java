package com.obric.oui.constraintlayout.core.dsl;

import com.alibaba.gaiax.model.GXAnimation;
import r27.a;

/* JADX INFO: loaded from: classes34.dex */
public final enum OnSwipe$Side extends Enum<OnSwipe$Side> {
    public static final OnSwipe$Side BOTTOM = null;
    public static final OnSwipe$Side END = null;
    public static final OnSwipe$Side LEFT = null;
    public static final OnSwipe$Side MIDDLE = null;
    public static final OnSwipe$Side RIGHT = null;
    public static final OnSwipe$Side START = null;
    public static final OnSwipe$Side TOP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OnSwipe$Side[] f399675a = null;

    static {
        OnSwipe$Side r100 = new OnSwipe$Side("TOP", 0);
        TOP = r100;
        OnSwipe$Side r101 = new OnSwipe$Side("LEFT", 1);
        LEFT = r101;
        OnSwipe$Side r102 = new OnSwipe$Side("RIGHT", 2);
        RIGHT = r102;
        OnSwipe$Side r103 = new OnSwipe$Side("BOTTOM", 3);
        BOTTOM = r103;
        OnSwipe$Side r104 = new OnSwipe$Side("MIDDLE", 4);
        MIDDLE = r104;
        OnSwipe$Side r105 = new OnSwipe$Side(GXAnimation.STATE_START, 5);
        START = r105;
        OnSwipe$Side r110 = new OnSwipe$Side(GXAnimation.STATE_END, 6);
        END = r110;
        f399675a = new OnSwipe$Side[]{r100, r101, r102, r103, r104, r105, r110};
    }

    public static OnSwipe$Side[] values() {
        return (OnSwipe$Side[]) f399675a.clone();
    }

    public static OnSwipe$Side valueOf(String r100) {
        return (OnSwipe$Side) a.a(OnSwipe$Side.class, r100);
    }

    public OnSwipe$Side(String r100, int r101) {
        super(r100, r101);
    }
}
