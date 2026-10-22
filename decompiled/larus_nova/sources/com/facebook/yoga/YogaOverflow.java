package com.facebook.yoga;

/* JADX INFO: loaded from: classes23.dex */
public final enum YogaOverflow extends Enum<YogaOverflow> {
    private static final /* synthetic */ YogaOverflow[] $VALUES = null;
    public static final YogaOverflow HIDDEN = null;
    public static final YogaOverflow SCROLL = null;
    public static final YogaOverflow VISIBLE = null;
    private final int mIntValue;

    private static /* synthetic */ YogaOverflow[] $values() {
        return new YogaOverflow[]{VISIBLE, HIDDEN, SCROLL};
    }

    static {
        VISIBLE = new YogaOverflow("VISIBLE", 0, 0);
        HIDDEN = new YogaOverflow("HIDDEN", 1, 1);
        SCROLL = new YogaOverflow("SCROLL", 2, 2);
        $VALUES = $values();
    }

    public static YogaOverflow[] values() {
        return (YogaOverflow[]) $VALUES.clone();
    }

    public int intValue() {
        return this.mIntValue;
    }

    public static YogaOverflow fromInt(int r100) {
        if (r100 == 0) goto L14;
        if (r100 == 1) goto L12;
        if (r100 != 2) goto L10;
        return SCROLL;
    L10:
        throw new IllegalArgumentException("Unknown enum value: " + r100);
    L12:
        return HIDDEN;
    L14:
        return VISIBLE;
    }

    public static YogaOverflow valueOf(String r100) {
        return (YogaOverflow) Enum.valueOf(YogaOverflow.class, r100);
    }

    private YogaOverflow(String r100, int r101, int r102) {
        super(r100, r101);
        this.mIntValue = r102;
    }
}
