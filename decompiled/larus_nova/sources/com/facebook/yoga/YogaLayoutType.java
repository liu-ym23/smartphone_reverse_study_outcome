package com.facebook.yoga;

/* JADX INFO: loaded from: classes23.dex */
public final enum YogaLayoutType extends Enum<YogaLayoutType> {
    private static final /* synthetic */ YogaLayoutType[] $VALUES = null;
    public static final YogaLayoutType CACHED_LAYOUT = null;
    public static final YogaLayoutType CACHED_MEASURE = null;
    public static final YogaLayoutType LAYOUT = null;
    public static final YogaLayoutType MEASURE = null;
    private final int mIntValue;

    private static /* synthetic */ YogaLayoutType[] $values() {
        return new YogaLayoutType[]{LAYOUT, MEASURE, CACHED_LAYOUT, CACHED_MEASURE};
    }

    static {
        LAYOUT = new YogaLayoutType("LAYOUT", 0, 0);
        MEASURE = new YogaLayoutType("MEASURE", 1, 1);
        CACHED_LAYOUT = new YogaLayoutType("CACHED_LAYOUT", 2, 2);
        CACHED_MEASURE = new YogaLayoutType("CACHED_MEASURE", 3, 3);
        $VALUES = $values();
    }

    public static YogaLayoutType[] values() {
        return (YogaLayoutType[]) $VALUES.clone();
    }

    public int intValue() {
        return this.mIntValue;
    }

    public static YogaLayoutType fromInt(int r100) {
        if (r100 == 0) goto L18;
        if (r100 == 1) goto L16;
        if (r100 == 2) goto L14;
        if (r100 != 3) goto L12;
        return CACHED_MEASURE;
    L12:
        throw new IllegalArgumentException("Unknown enum value: " + r100);
    L14:
        return CACHED_LAYOUT;
    L16:
        return MEASURE;
    L18:
        return LAYOUT;
    }

    public static YogaLayoutType valueOf(String r100) {
        return (YogaLayoutType) Enum.valueOf(YogaLayoutType.class, r100);
    }

    private YogaLayoutType(String r100, int r101, int r102) {
        super(r100, r101);
        this.mIntValue = r102;
    }
}
