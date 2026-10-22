package com.facebook.yoga;

/* JADX INFO: loaded from: classes23.dex */
public final enum YogaWrap extends Enum<YogaWrap> {
    private static final /* synthetic */ YogaWrap[] $VALUES = null;
    public static final YogaWrap NO_WRAP = null;
    public static final YogaWrap WRAP = null;
    public static final YogaWrap WRAP_REVERSE = null;
    private final int mIntValue;

    private static /* synthetic */ YogaWrap[] $values() {
        return new YogaWrap[]{NO_WRAP, WRAP, WRAP_REVERSE};
    }

    static {
        NO_WRAP = new YogaWrap("NO_WRAP", 0, 0);
        WRAP = new YogaWrap("WRAP", 1, 1);
        WRAP_REVERSE = new YogaWrap("WRAP_REVERSE", 2, 2);
        $VALUES = $values();
    }

    public static YogaWrap[] values() {
        return (YogaWrap[]) $VALUES.clone();
    }

    public int intValue() {
        return this.mIntValue;
    }

    public static YogaWrap fromInt(int r100) {
        if (r100 == 0) goto L14;
        if (r100 == 1) goto L12;
        if (r100 != 2) goto L10;
        return WRAP_REVERSE;
    L10:
        throw new IllegalArgumentException("Unknown enum value: " + r100);
    L12:
        return WRAP;
    L14:
        return NO_WRAP;
    }

    public static YogaWrap valueOf(String r100) {
        return (YogaWrap) Enum.valueOf(YogaWrap.class, r100);
    }

    private YogaWrap(String r100, int r101, int r102) {
        super(r100, r101);
        this.mIntValue = r102;
    }
}
