package com.facebook.yoga;

/* JADX INFO: loaded from: classes23.dex */
public final enum YogaMeasureMode extends Enum<YogaMeasureMode> {
    private static final /* synthetic */ YogaMeasureMode[] $VALUES = null;
    public static final YogaMeasureMode AT_MOST = null;
    public static final YogaMeasureMode EXACTLY = null;
    public static final YogaMeasureMode UNDEFINED = null;
    private final int mIntValue;

    private static /* synthetic */ YogaMeasureMode[] $values() {
        return new YogaMeasureMode[]{UNDEFINED, EXACTLY, AT_MOST};
    }

    static {
        UNDEFINED = new YogaMeasureMode("UNDEFINED", 0, 0);
        EXACTLY = new YogaMeasureMode("EXACTLY", 1, 1);
        AT_MOST = new YogaMeasureMode("AT_MOST", 2, 2);
        $VALUES = $values();
    }

    public static YogaMeasureMode[] values() {
        return (YogaMeasureMode[]) $VALUES.clone();
    }

    public int intValue() {
        return this.mIntValue;
    }

    public static YogaMeasureMode fromInt(int r100) {
        if (r100 == 0) goto L14;
        if (r100 == 1) goto L12;
        if (r100 != 2) goto L10;
        return AT_MOST;
    L10:
        throw new IllegalArgumentException("Unknown enum value: " + r100);
    L12:
        return EXACTLY;
    L14:
        return UNDEFINED;
    }

    public static YogaMeasureMode valueOf(String r100) {
        return (YogaMeasureMode) Enum.valueOf(YogaMeasureMode.class, r100);
    }

    private YogaMeasureMode(String r100, int r101, int r102) {
        super(r100, r101);
        this.mIntValue = r102;
    }
}
