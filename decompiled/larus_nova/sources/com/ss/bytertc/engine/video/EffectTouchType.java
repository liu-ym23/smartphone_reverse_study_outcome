package com.ss.bytertc.engine.video;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum EffectTouchType extends Enum<EffectTouchType> {
    private static final /* synthetic */ EffectTouchType[] $VALUES = null;
    public static final EffectTouchType TOUCH_BEGAN = null;
    public static final EffectTouchType TOUCH_CANCELED = null;
    public static final EffectTouchType TOUCH_ENDED = null;
    public static final EffectTouchType TOUCH_MOVED = null;
    public static final EffectTouchType TOUCH_STATIONARY = null;
    private final int value;

    static {
        EffectTouchType r100 = new EffectTouchType("TOUCH_BEGAN", 0, 0);
        TOUCH_BEGAN = r100;
        EffectTouchType r101 = new EffectTouchType("TOUCH_MOVED", 1, 1);
        TOUCH_MOVED = r101;
        EffectTouchType r102 = new EffectTouchType("TOUCH_STATIONARY", 2, 2);
        TOUCH_STATIONARY = r102;
        EffectTouchType r103 = new EffectTouchType("TOUCH_ENDED", 3, 3);
        TOUCH_ENDED = r103;
        EffectTouchType r104 = new EffectTouchType("TOUCH_CANCELED", 4, 4);
        TOUCH_CANCELED = r104;
        $VALUES = new EffectTouchType[]{r100, r101, r102, r103, r104};
    }

    public static EffectTouchType[] values() {
        return (EffectTouchType[]) $VALUES.clone();
    }

    public int getValue() {
        return this.value;
    }

    public static EffectTouchType valueOf(String r100) {
        return (EffectTouchType) a.a(EffectTouchType.class, r100);
    }

    private EffectTouchType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
