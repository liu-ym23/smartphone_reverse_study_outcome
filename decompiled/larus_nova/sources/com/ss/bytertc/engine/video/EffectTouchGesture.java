package com.ss.bytertc.engine.video;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum EffectTouchGesture extends Enum<EffectTouchGesture> {
    private static final /* synthetic */ EffectTouchGesture[] $VALUES = null;
    public static final EffectTouchGesture ANY_SUPPORTED = null;
    public static final EffectTouchGesture GESTURE_DOUBLE_CLICK = null;
    public static final EffectTouchGesture GESTURE_DRAG = null;
    public static final EffectTouchGesture GESTURE_DROP = null;
    public static final EffectTouchGesture GESTURE_LONG_TAP = null;
    public static final EffectTouchGesture GESTURE_PINCH = null;
    public static final EffectTouchGesture GESTURE_SWIPE = null;
    public static final EffectTouchGesture GESTURE_TAP = null;
    private final int value;

    static {
        EffectTouchGesture r100 = new EffectTouchGesture("GESTURE_TAP", 0, 0);
        GESTURE_TAP = r100;
        EffectTouchGesture r101 = new EffectTouchGesture("GESTURE_SWIPE", 1, 1);
        GESTURE_SWIPE = r101;
        EffectTouchGesture r102 = new EffectTouchGesture("GESTURE_PINCH", 2, 2);
        GESTURE_PINCH = r102;
        EffectTouchGesture r103 = new EffectTouchGesture("GESTURE_LONG_TAP", 3, 3);
        GESTURE_LONG_TAP = r103;
        EffectTouchGesture r104 = new EffectTouchGesture("GESTURE_DRAG", 4, 4);
        GESTURE_DRAG = r104;
        EffectTouchGesture r105 = new EffectTouchGesture("GESTURE_DROP", 5, 5);
        GESTURE_DROP = r105;
        EffectTouchGesture r110 = new EffectTouchGesture("GESTURE_DOUBLE_CLICK", 6, 6);
        GESTURE_DOUBLE_CLICK = r110;
        EffectTouchGesture r111 = new EffectTouchGesture("ANY_SUPPORTED", 7, -1);
        ANY_SUPPORTED = r111;
        $VALUES = new EffectTouchGesture[]{r100, r101, r102, r103, r104, r105, r110, r111};
    }

    public static EffectTouchGesture[] values() {
        return (EffectTouchGesture[]) $VALUES.clone();
    }

    public int getValue() {
        return this.value;
    }

    public static EffectTouchGesture valueOf(String r100) {
        return (EffectTouchGesture) a.a(EffectTouchGesture.class, r100);
    }

    private EffectTouchGesture(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
