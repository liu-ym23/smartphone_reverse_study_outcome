package com.facebook.yoga;

import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter;

/* JADX INFO: loaded from: classes23.dex */
public final enum YogaNodeType extends Enum<YogaNodeType> {
    private static final /* synthetic */ YogaNodeType[] $VALUES = null;
    public static final YogaNodeType DEFAULT = null;
    public static final YogaNodeType TEXT = null;
    private final int mIntValue;

    private static /* synthetic */ YogaNodeType[] $values() {
        return new YogaNodeType[]{DEFAULT, TEXT};
    }

    static {
        DEFAULT = new YogaNodeType("DEFAULT", 0, 0);
        TEXT = new YogaNodeType(CardAdapter.TEXT, 1, 1);
        $VALUES = $values();
    }

    public static YogaNodeType[] values() {
        return (YogaNodeType[]) $VALUES.clone();
    }

    public int intValue() {
        return this.mIntValue;
    }

    public static YogaNodeType fromInt(int r100) {
        if (r100 == 0) goto L10;
        if (r100 != 1) goto L8;
        return TEXT;
    L8:
        throw new IllegalArgumentException("Unknown enum value: " + r100);
    L10:
        return DEFAULT;
    }

    public static YogaNodeType valueOf(String r100) {
        return (YogaNodeType) Enum.valueOf(YogaNodeType.class, r100);
    }

    private YogaNodeType(String r100, int r101, int r102) {
        super(r100, r101);
        this.mIntValue = r102;
    }
}
