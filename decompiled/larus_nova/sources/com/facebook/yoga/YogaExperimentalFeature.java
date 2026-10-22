package com.facebook.yoga;

/* JADX INFO: loaded from: classes23.dex */
public final enum YogaExperimentalFeature extends Enum<YogaExperimentalFeature> {
    private static final /* synthetic */ YogaExperimentalFeature[] $VALUES = null;
    public static final YogaExperimentalFeature WEB_FLEX_BASIS = null;
    private final int mIntValue;

    private static /* synthetic */ YogaExperimentalFeature[] $values() {
        return new YogaExperimentalFeature[]{WEB_FLEX_BASIS};
    }

    static {
        WEB_FLEX_BASIS = new YogaExperimentalFeature("WEB_FLEX_BASIS", 0, 0);
        $VALUES = $values();
    }

    public static YogaExperimentalFeature[] values() {
        return (YogaExperimentalFeature[]) $VALUES.clone();
    }

    public int intValue() {
        return this.mIntValue;
    }

    public static YogaExperimentalFeature fromInt(int r100) {
        if (r100 != 0) goto L6;
        return WEB_FLEX_BASIS;
    L6:
        throw new IllegalArgumentException("Unknown enum value: " + r100);
    }

    public static YogaExperimentalFeature valueOf(String r100) {
        return (YogaExperimentalFeature) Enum.valueOf(YogaExperimentalFeature.class, r100);
    }

    private YogaExperimentalFeature(String r100, int r101, int r102) {
        super(r100, r101);
        this.mIntValue = r102;
    }
}
