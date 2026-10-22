package com.facebook.yoga;

import com.alibaba.gaiax.model.GXAnimation;
import com.obric.miniapp.alarm.AccountType;

/* JADX INFO: loaded from: classes23.dex */
public final enum YogaEdge extends Enum<YogaEdge> {
    private static final /* synthetic */ YogaEdge[] $VALUES = null;
    public static final YogaEdge ALL = null;
    public static final YogaEdge BOTTOM = null;
    public static final YogaEdge END = null;
    public static final YogaEdge HORIZONTAL = null;
    public static final YogaEdge LEFT = null;
    public static final YogaEdge RIGHT = null;
    public static final YogaEdge START = null;
    public static final YogaEdge TOP = null;
    public static final YogaEdge VERTICAL = null;
    private final int mIntValue;

    private static /* synthetic */ YogaEdge[] $values() {
        return new YogaEdge[]{LEFT, TOP, RIGHT, BOTTOM, START, END, HORIZONTAL, VERTICAL, ALL};
    }

    static {
        LEFT = new YogaEdge("LEFT", 0, 0);
        TOP = new YogaEdge("TOP", 1, 1);
        RIGHT = new YogaEdge("RIGHT", 2, 2);
        BOTTOM = new YogaEdge("BOTTOM", 3, 3);
        START = new YogaEdge(GXAnimation.STATE_START, 4, 4);
        END = new YogaEdge(GXAnimation.STATE_END, 5, 5);
        HORIZONTAL = new YogaEdge("HORIZONTAL", 6, 6);
        VERTICAL = new YogaEdge("VERTICAL", 7, 7);
        ALL = new YogaEdge(AccountType.ALL, 8, 8);
        $VALUES = $values();
    }

    public static YogaEdge[] values() {
        return (YogaEdge[]) $VALUES.clone();
    }

    public int intValue() {
        return this.mIntValue;
    }

    public static YogaEdge fromInt(int r100) {
        switch(r100) {
            case 0: goto L22;
            case 1: goto L20;
            case 2: goto L18;
            case 3: goto L16;
            case 4: goto L14;
            case 5: goto L12;
            case 6: goto L10;
            case 7: goto L8;
            case 8: goto L6;
            default: goto L4;
        };
    L4:
        throw new IllegalArgumentException("Unknown enum value: " + r100);
    L6:
        return ALL;
    L8:
        return VERTICAL;
    L10:
        return HORIZONTAL;
    L12:
        return END;
    L14:
        return START;
    L16:
        return BOTTOM;
    L18:
        return RIGHT;
    L20:
        return TOP;
    L22:
        return LEFT;
    }

    public static YogaEdge valueOf(String r100) {
        return (YogaEdge) Enum.valueOf(YogaEdge.class, r100);
    }

    private YogaEdge(String r100, int r101, int r102) {
        super(r100, r101);
        this.mIntValue = r102;
    }
}
