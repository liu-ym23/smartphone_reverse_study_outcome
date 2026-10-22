package com.facebook.yoga;

/* JADX INFO: loaded from: classes23.dex */
public final enum YogaPositionType extends Enum<YogaPositionType> {
    private static final /* synthetic */ YogaPositionType[] $VALUES = null;
    public static final YogaPositionType ABSOLUTE = null;
    public static final YogaPositionType RELATIVE = null;
    public static final YogaPositionType STATIC = null;
    private final int mIntValue;

    private static /* synthetic */ YogaPositionType[] $values() {
        return new YogaPositionType[]{STATIC, RELATIVE, ABSOLUTE};
    }

    static {
        STATIC = new YogaPositionType("STATIC", 0, 0);
        RELATIVE = new YogaPositionType("RELATIVE", 1, 1);
        ABSOLUTE = new YogaPositionType("ABSOLUTE", 2, 2);
        $VALUES = $values();
    }

    public static YogaPositionType[] values() {
        return (YogaPositionType[]) $VALUES.clone();
    }

    public int intValue() {
        return this.mIntValue;
    }

    public static YogaPositionType fromInt(int r100) {
        if (r100 == 0) goto L14;
        if (r100 == 1) goto L12;
        if (r100 != 2) goto L10;
        return ABSOLUTE;
    L10:
        throw new IllegalArgumentException("Unknown enum value: " + r100);
    L12:
        return RELATIVE;
    L14:
        return STATIC;
    }

    public static YogaPositionType valueOf(String r100) {
        return (YogaPositionType) Enum.valueOf(YogaPositionType.class, r100);
    }

    private YogaPositionType(String r100, int r101, int r102) {
        super(r100, r101);
        this.mIntValue = r102;
    }
}
