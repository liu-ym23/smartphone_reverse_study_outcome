package com.obric.oui.constraintlayout.core.dsl;

import com.alibaba.gaiax.model.GXAnimation;
import r27.a;

/* JADX INFO: loaded from: classes34.dex */
public final enum OnSwipe$Drag extends Enum<OnSwipe$Drag> {
    public static final OnSwipe$Drag ANTICLOCKWISE = null;
    public static final OnSwipe$Drag CLOCKWISE = null;
    public static final OnSwipe$Drag DOWN = null;
    public static final OnSwipe$Drag END = null;
    public static final OnSwipe$Drag LEFT = null;
    public static final OnSwipe$Drag RIGHT = null;
    public static final OnSwipe$Drag START = null;
    public static final OnSwipe$Drag UP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OnSwipe$Drag[] f399673a = null;

    static {
        OnSwipe$Drag r100 = new OnSwipe$Drag("UP", 0);
        UP = r100;
        OnSwipe$Drag r101 = new OnSwipe$Drag("DOWN", 1);
        DOWN = r101;
        OnSwipe$Drag r102 = new OnSwipe$Drag("LEFT", 2);
        LEFT = r102;
        OnSwipe$Drag r103 = new OnSwipe$Drag("RIGHT", 3);
        RIGHT = r103;
        OnSwipe$Drag r104 = new OnSwipe$Drag(GXAnimation.STATE_START, 4);
        START = r104;
        OnSwipe$Drag r105 = new OnSwipe$Drag(GXAnimation.STATE_END, 5);
        END = r105;
        OnSwipe$Drag r110 = new OnSwipe$Drag("CLOCKWISE", 6);
        CLOCKWISE = r110;
        OnSwipe$Drag r111 = new OnSwipe$Drag("ANTICLOCKWISE", 7);
        ANTICLOCKWISE = r111;
        f399673a = new OnSwipe$Drag[]{r100, r101, r102, r103, r104, r105, r110, r111};
    }

    public static OnSwipe$Drag[] values() {
        return (OnSwipe$Drag[]) f399673a.clone();
    }

    public static OnSwipe$Drag valueOf(String r100) {
        return (OnSwipe$Drag) a.a(OnSwipe$Drag.class, r100);
    }

    public OnSwipe$Drag(String r100, int r101) {
        super(r100, r101);
    }
}
