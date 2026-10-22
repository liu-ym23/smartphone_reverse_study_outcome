package com.facebook.yoga;

import com.bytedance.ee.bear.sheet.fab.FabItem;

/* JADX INFO: loaded from: classes23.dex */
public final enum YogaFlexDirection extends Enum<YogaFlexDirection> {
    private static final /* synthetic */ YogaFlexDirection[] $VALUES = null;
    public static final YogaFlexDirection COLUMN = null;
    public static final YogaFlexDirection COLUMN_REVERSE = null;
    public static final YogaFlexDirection ROW = null;
    public static final YogaFlexDirection ROW_REVERSE = null;
    private final int mIntValue;

    private static /* synthetic */ YogaFlexDirection[] $values() {
        return new YogaFlexDirection[]{COLUMN, COLUMN_REVERSE, ROW, ROW_REVERSE};
    }

    static {
        COLUMN = new YogaFlexDirection("COLUMN", 0, 0);
        COLUMN_REVERSE = new YogaFlexDirection("COLUMN_REVERSE", 1, 1);
        ROW = new YogaFlexDirection(FabItem.FabSheetItem.CellType.ROW, 2, 2);
        ROW_REVERSE = new YogaFlexDirection("ROW_REVERSE", 3, 3);
        $VALUES = $values();
    }

    public static YogaFlexDirection[] values() {
        return (YogaFlexDirection[]) $VALUES.clone();
    }

    public int intValue() {
        return this.mIntValue;
    }

    public static YogaFlexDirection fromInt(int r100) {
        if (r100 == 0) goto L18;
        if (r100 == 1) goto L16;
        if (r100 == 2) goto L14;
        if (r100 != 3) goto L12;
        return ROW_REVERSE;
    L12:
        throw new IllegalArgumentException("Unknown enum value: " + r100);
    L14:
        return ROW;
    L16:
        return COLUMN_REVERSE;
    L18:
        return COLUMN;
    }

    public static YogaFlexDirection valueOf(String r100) {
        return (YogaFlexDirection) Enum.valueOf(YogaFlexDirection.class, r100);
    }

    private YogaFlexDirection(String r100, int r101, int r102) {
        super(r100, r101);
        this.mIntValue = r102;
    }
}
