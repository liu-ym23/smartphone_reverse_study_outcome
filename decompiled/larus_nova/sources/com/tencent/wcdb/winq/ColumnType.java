package com.tencent.wcdb.winq;

import r27.a;

/* JADX INFO: loaded from: classes41.dex */
public final enum ColumnType extends Enum<ColumnType> {
    private static final /* synthetic */ ColumnType[] $VALUES = null;
    public static final ColumnType BLOB = null;
    public static final ColumnType Float = null;
    public static final ColumnType Integer = null;
    public static final ColumnType Null = null;
    public static final ColumnType Text = null;
    private final int value;

    private static /* synthetic */ ColumnType[] $values() {
        return new ColumnType[]{Null, Integer, Float, Text, BLOB};
    }

    static {
        Null = new ColumnType("Null", 0, 0);
        Integer = new ColumnType("Integer", 1, 1);
        Float = new ColumnType("Float", 2, 2);
        Text = new ColumnType("Text", 3, 3);
        BLOB = new ColumnType("BLOB", 4, 4);
        $VALUES = $values();
    }

    public static ColumnType[] values() {
        return (ColumnType[]) $VALUES.clone();
    }

    public static ColumnType valueOf(int r100) {
        if (r100 == 1) goto L19;
        if (r100 == 2) goto L17;
        if (r100 == 3) goto L15;
        if (r100 == 4) goto L13;
        return Null;
    L13:
        return BLOB;
    L15:
        return Text;
    L17:
        return Float;
    L19:
        return Integer;
    }

    public static ColumnType valueOf(String r100) {
        return (ColumnType) a.a(ColumnType.class, r100);
    }

    private ColumnType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
