package com.facebook.yoga;

/* JADX INFO: loaded from: classes23.dex */
public final enum YogaDirection extends Enum<YogaDirection> {
    private static final /* synthetic */ YogaDirection[] $VALUES = null;
    public static final YogaDirection INHERIT = null;
    public static final YogaDirection LTR = null;
    public static final YogaDirection RTL = null;
    private final int mIntValue;

    private static /* synthetic */ YogaDirection[] $values() {
        return new YogaDirection[]{INHERIT, LTR, RTL};
    }

    static {
        INHERIT = new YogaDirection("INHERIT", 0, 0);
        LTR = new YogaDirection("LTR", 1, 1);
        RTL = new YogaDirection("RTL", 2, 2);
        $VALUES = $values();
    }

    public static YogaDirection[] values() {
        return (YogaDirection[]) $VALUES.clone();
    }

    public int intValue() {
        return this.mIntValue;
    }

    public static YogaDirection fromInt(int r100) {
        if (r100 == 0) goto L14;
        if (r100 == 1) goto L12;
        if (r100 != 2) goto L10;
        return RTL;
    L10:
        throw new IllegalArgumentException("Unknown enum value: " + r100);
    L12:
        return LTR;
    L14:
        return INHERIT;
    }

    public static YogaDirection valueOf(String r100) {
        return (YogaDirection) Enum.valueOf(YogaDirection.class, r100);
    }

    private YogaDirection(String r100, int r101, int r102) {
        super(r100, r101);
        this.mIntValue = r102;
    }
}
