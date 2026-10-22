package com.facebook.yoga;

/* JADX INFO: loaded from: classes23.dex */
public final enum YogaJustify extends Enum<YogaJustify> {
    private static final /* synthetic */ YogaJustify[] $VALUES = null;
    public static final YogaJustify CENTER = null;
    public static final YogaJustify FLEX_END = null;
    public static final YogaJustify FLEX_START = null;
    public static final YogaJustify SPACE_AROUND = null;
    public static final YogaJustify SPACE_BETWEEN = null;
    public static final YogaJustify SPACE_EVENLY = null;
    private final int mIntValue;

    private static /* synthetic */ YogaJustify[] $values() {
        return new YogaJustify[]{FLEX_START, CENTER, FLEX_END, SPACE_BETWEEN, SPACE_AROUND, SPACE_EVENLY};
    }

    static {
        FLEX_START = new YogaJustify("FLEX_START", 0, 0);
        CENTER = new YogaJustify("CENTER", 1, 1);
        FLEX_END = new YogaJustify("FLEX_END", 2, 2);
        SPACE_BETWEEN = new YogaJustify("SPACE_BETWEEN", 3, 3);
        SPACE_AROUND = new YogaJustify("SPACE_AROUND", 4, 4);
        SPACE_EVENLY = new YogaJustify("SPACE_EVENLY", 5, 5);
        $VALUES = $values();
    }

    public static YogaJustify[] values() {
        return (YogaJustify[]) $VALUES.clone();
    }

    public int intValue() {
        return this.mIntValue;
    }

    public static YogaJustify fromInt(int r100) {
        if (r100 == 0) goto L26;
        if (r100 == 1) goto L24;
        if (r100 == 2) goto L22;
        if (r100 == 3) goto L20;
        if (r100 == 4) goto L18;
        if (r100 != 5) goto L16;
        return SPACE_EVENLY;
    L16:
        throw new IllegalArgumentException("Unknown enum value: " + r100);
    L18:
        return SPACE_AROUND;
    L20:
        return SPACE_BETWEEN;
    L22:
        return FLEX_END;
    L24:
        return CENTER;
    L26:
        return FLEX_START;
    }

    public static YogaJustify valueOf(String r100) {
        return (YogaJustify) Enum.valueOf(YogaJustify.class, r100);
    }

    private YogaJustify(String r100, int r101, int r102) {
        super(r100, r101);
        this.mIntValue = r102;
    }
}
