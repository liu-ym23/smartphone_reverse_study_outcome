package com.facebook.yoga;

/* JADX INFO: loaded from: classes23.dex */
public final enum LayoutPassReason extends Enum<LayoutPassReason> {
    private static final /* synthetic */ LayoutPassReason[] $VALUES = null;
    public static final LayoutPassReason ABS_LAYOUT = null;
    public static final LayoutPassReason ABS_MEASURE = null;
    public static final LayoutPassReason FLEX_LAYOUT = null;
    public static final LayoutPassReason FLEX_MEASURE = null;
    public static final LayoutPassReason INITIAL = null;
    public static final LayoutPassReason MEASURE = null;
    public static final LayoutPassReason MULTILINE_STRETCH = null;
    public static final LayoutPassReason STRETCH = null;
    private final int mIntValue;

    private static /* synthetic */ LayoutPassReason[] $values() {
        return new LayoutPassReason[]{INITIAL, ABS_LAYOUT, STRETCH, MULTILINE_STRETCH, FLEX_LAYOUT, MEASURE, ABS_MEASURE, FLEX_MEASURE};
    }

    static {
        INITIAL = new LayoutPassReason("INITIAL", 0, 0);
        ABS_LAYOUT = new LayoutPassReason("ABS_LAYOUT", 1, 1);
        STRETCH = new LayoutPassReason("STRETCH", 2, 2);
        MULTILINE_STRETCH = new LayoutPassReason("MULTILINE_STRETCH", 3, 3);
        FLEX_LAYOUT = new LayoutPassReason("FLEX_LAYOUT", 4, 4);
        MEASURE = new LayoutPassReason("MEASURE", 5, 5);
        ABS_MEASURE = new LayoutPassReason("ABS_MEASURE", 6, 6);
        FLEX_MEASURE = new LayoutPassReason("FLEX_MEASURE", 7, 7);
        $VALUES = $values();
    }

    public static LayoutPassReason[] values() {
        return (LayoutPassReason[]) $VALUES.clone();
    }

    public int intValue() {
        return this.mIntValue;
    }

    public static LayoutPassReason fromInt(int r100) {
        switch(r100) {
            case 0: goto L20;
            case 1: goto L18;
            case 2: goto L16;
            case 3: goto L14;
            case 4: goto L12;
            case 5: goto L10;
            case 6: goto L8;
            case 7: goto L6;
            default: goto L4;
        };
    L4:
        throw new IllegalArgumentException("Unknown enum value: " + r100);
    L6:
        return FLEX_MEASURE;
    L8:
        return ABS_MEASURE;
    L10:
        return MEASURE;
    L12:
        return FLEX_LAYOUT;
    L14:
        return MULTILINE_STRETCH;
    L16:
        return STRETCH;
    L18:
        return ABS_LAYOUT;
    L20:
        return INITIAL;
    }

    public static LayoutPassReason valueOf(String r100) {
        return (LayoutPassReason) Enum.valueOf(LayoutPassReason.class, r100);
    }

    private LayoutPassReason(String r100, int r101, int r102) {
        super(r100, r101);
        this.mIntValue = r102;
    }
}
