package com.facebook.yoga;

/* JADX INFO: loaded from: classes23.dex */
public final enum YogaBoxSizing extends Enum<YogaBoxSizing> {
    private static final /* synthetic */ YogaBoxSizing[] $VALUES = null;
    public static final YogaBoxSizing BORDER_BOX = null;
    public static final YogaBoxSizing CONTENT_BOX = null;
    private final int mIntValue;

    private static /* synthetic */ YogaBoxSizing[] $values() {
        return new YogaBoxSizing[]{BORDER_BOX, CONTENT_BOX};
    }

    static {
        BORDER_BOX = new YogaBoxSizing("BORDER_BOX", 0, 0);
        CONTENT_BOX = new YogaBoxSizing("CONTENT_BOX", 1, 1);
        $VALUES = $values();
    }

    public static YogaBoxSizing[] values() {
        return (YogaBoxSizing[]) $VALUES.clone();
    }

    public int intValue() {
        return this.mIntValue;
    }

    public static YogaBoxSizing fromInt(int r100) {
        if (r100 == 0) goto L10;
        if (r100 != 1) goto L8;
        return CONTENT_BOX;
    L8:
        throw new IllegalArgumentException("Unknown enum value: " + r100);
    L10:
        return BORDER_BOX;
    }

    public static YogaBoxSizing valueOf(String r100) {
        return (YogaBoxSizing) Enum.valueOf(YogaBoxSizing.class, r100);
    }

    private YogaBoxSizing(String r100, int r101, int r102) {
        super(r100, r101);
        this.mIntValue = r102;
    }
}
