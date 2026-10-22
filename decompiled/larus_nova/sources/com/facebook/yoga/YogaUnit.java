package com.facebook.yoga;

/* JADX INFO: loaded from: classes23.dex */
public final enum YogaUnit extends Enum<YogaUnit> {
    private static final /* synthetic */ YogaUnit[] $VALUES = null;
    public static final YogaUnit AUTO = null;
    public static final YogaUnit PERCENT = null;
    public static final YogaUnit POINT = null;
    public static final YogaUnit UNDEFINED = null;
    private final int mIntValue;

    private static /* synthetic */ YogaUnit[] $values() {
        return new YogaUnit[]{UNDEFINED, POINT, PERCENT, AUTO};
    }

    static {
        UNDEFINED = new YogaUnit("UNDEFINED", 0, 0);
        POINT = new YogaUnit("POINT", 1, 1);
        PERCENT = new YogaUnit("PERCENT", 2, 2);
        AUTO = new YogaUnit("AUTO", 3, 3);
        $VALUES = $values();
    }

    public static YogaUnit[] values() {
        return (YogaUnit[]) $VALUES.clone();
    }

    public int intValue() {
        return this.mIntValue;
    }

    public static YogaUnit fromInt(int r100) {
        if (r100 == 0) goto L18;
        if (r100 == 1) goto L16;
        if (r100 == 2) goto L14;
        if (r100 != 3) goto L12;
        return AUTO;
    L12:
        throw new IllegalArgumentException("Unknown enum value: " + r100);
    L14:
        return PERCENT;
    L16:
        return POINT;
    L18:
        return UNDEFINED;
    }

    public static YogaUnit valueOf(String r100) {
        return (YogaUnit) Enum.valueOf(YogaUnit.class, r100);
    }

    private YogaUnit(String r100, int r101, int r102) {
        super(r100, r101);
        this.mIntValue = r102;
    }
}
