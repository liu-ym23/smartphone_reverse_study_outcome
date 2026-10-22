package com.facebook.yoga;

/* JADX INFO: loaded from: classes23.dex */
public final enum YogaDimension extends Enum<YogaDimension> {
    private static final /* synthetic */ YogaDimension[] $VALUES = null;
    public static final YogaDimension HEIGHT = null;
    public static final YogaDimension WIDTH = null;
    private final int mIntValue;

    private static /* synthetic */ YogaDimension[] $values() {
        return new YogaDimension[]{WIDTH, HEIGHT};
    }

    static {
        WIDTH = new YogaDimension("WIDTH", 0, 0);
        HEIGHT = new YogaDimension("HEIGHT", 1, 1);
        $VALUES = $values();
    }

    public static YogaDimension[] values() {
        return (YogaDimension[]) $VALUES.clone();
    }

    public int intValue() {
        return this.mIntValue;
    }

    public static YogaDimension fromInt(int r100) {
        if (r100 == 0) goto L10;
        if (r100 != 1) goto L8;
        return HEIGHT;
    L8:
        throw new IllegalArgumentException("Unknown enum value: " + r100);
    L10:
        return WIDTH;
    }

    public static YogaDimension valueOf(String r100) {
        return (YogaDimension) Enum.valueOf(YogaDimension.class, r100);
    }

    private YogaDimension(String r100, int r101, int r102) {
        super(r100, r101);
        this.mIntValue = r102;
    }
}
