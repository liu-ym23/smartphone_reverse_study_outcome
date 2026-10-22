package com.facebook.yoga;

import com.bytedance.ee.bear.sheet.fab.FabItem;
import com.obric.miniapp.alarm.AccountType;

/* JADX INFO: loaded from: classes23.dex */
public final enum YogaGutter extends Enum<YogaGutter> {
    private static final /* synthetic */ YogaGutter[] $VALUES = null;
    public static final YogaGutter ALL = null;
    public static final YogaGutter COLUMN = null;
    public static final YogaGutter ROW = null;
    private final int mIntValue;

    private static /* synthetic */ YogaGutter[] $values() {
        return new YogaGutter[]{COLUMN, ROW, ALL};
    }

    static {
        COLUMN = new YogaGutter("COLUMN", 0, 0);
        ROW = new YogaGutter(FabItem.FabSheetItem.CellType.ROW, 1, 1);
        ALL = new YogaGutter(AccountType.ALL, 2, 2);
        $VALUES = $values();
    }

    public static YogaGutter[] values() {
        return (YogaGutter[]) $VALUES.clone();
    }

    public int intValue() {
        return this.mIntValue;
    }

    public static YogaGutter fromInt(int r100) {
        if (r100 == 0) goto L14;
        if (r100 == 1) goto L12;
        if (r100 != 2) goto L10;
        return ALL;
    L10:
        throw new IllegalArgumentException("Unknown enum value: " + r100);
    L12:
        return ROW;
    L14:
        return COLUMN;
    }

    public static YogaGutter valueOf(String r100) {
        return (YogaGutter) Enum.valueOf(YogaGutter.class, r100);
    }

    private YogaGutter(String r100, int r101, int r102) {
        super(r100, r101);
        this.mIntValue = r102;
    }
}
