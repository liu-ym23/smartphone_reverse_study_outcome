package com.facebook.yoga;

/* JADX INFO: loaded from: classes23.dex */
public final enum YogaAlign extends Enum<YogaAlign> {
    private static final /* synthetic */ YogaAlign[] $VALUES = null;
    public static final YogaAlign AUTO = null;
    public static final YogaAlign BASELINE = null;
    public static final YogaAlign CENTER = null;
    public static final YogaAlign FLEX_END = null;
    public static final YogaAlign FLEX_START = null;
    public static final YogaAlign SPACE_AROUND = null;
    public static final YogaAlign SPACE_BETWEEN = null;
    public static final YogaAlign SPACE_EVENLY = null;
    public static final YogaAlign STRETCH = null;
    private final int mIntValue;

    private static /* synthetic */ YogaAlign[] $values() {
        return new YogaAlign[]{AUTO, FLEX_START, CENTER, FLEX_END, STRETCH, BASELINE, SPACE_BETWEEN, SPACE_AROUND, SPACE_EVENLY};
    }

    static {
        AUTO = new YogaAlign("AUTO", 0, 0);
        FLEX_START = new YogaAlign("FLEX_START", 1, 1);
        CENTER = new YogaAlign("CENTER", 2, 2);
        FLEX_END = new YogaAlign("FLEX_END", 3, 3);
        STRETCH = new YogaAlign("STRETCH", 4, 4);
        BASELINE = new YogaAlign("BASELINE", 5, 5);
        SPACE_BETWEEN = new YogaAlign("SPACE_BETWEEN", 6, 6);
        SPACE_AROUND = new YogaAlign("SPACE_AROUND", 7, 7);
        SPACE_EVENLY = new YogaAlign("SPACE_EVENLY", 8, 8);
        $VALUES = $values();
    }

    public static YogaAlign[] values() {
        return (YogaAlign[]) $VALUES.clone();
    }

    public int intValue() {
        return this.mIntValue;
    }

    public static YogaAlign fromInt(int r100) {
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
        return SPACE_EVENLY;
    L8:
        return SPACE_AROUND;
    L10:
        return SPACE_BETWEEN;
    L12:
        return BASELINE;
    L14:
        return STRETCH;
    L16:
        return FLEX_END;
    L18:
        return CENTER;
    L20:
        return FLEX_START;
    L22:
        return AUTO;
    }

    public static YogaAlign valueOf(String r100) {
        return (YogaAlign) Enum.valueOf(YogaAlign.class, r100);
    }

    private YogaAlign(String r100, int r101, int r102) {
        super(r100, r101);
        this.mIntValue = r102;
    }
}
