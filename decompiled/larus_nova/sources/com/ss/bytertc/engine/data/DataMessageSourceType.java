package com.ss.bytertc.engine.data;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum DataMessageSourceType extends Enum<DataMessageSourceType> {
    private static final /* synthetic */ DataMessageSourceType[] $VALUES = null;
    public static final DataMessageSourceType DATA_MESSAGE_SOURCE_TYPE_DEFAULT = null;
    public static final DataMessageSourceType DATA_MESSAGE_SOURCE_TYPE_SYSTEM = null;
    private int value;

    static {
        DataMessageSourceType r100 = new DataMessageSourceType("DATA_MESSAGE_SOURCE_TYPE_DEFAULT", 0, 0);
        DATA_MESSAGE_SOURCE_TYPE_DEFAULT = r100;
        DataMessageSourceType r101 = new DataMessageSourceType("DATA_MESSAGE_SOURCE_TYPE_SYSTEM", 1, 1);
        DATA_MESSAGE_SOURCE_TYPE_SYSTEM = r101;
        $VALUES = new DataMessageSourceType[]{r100, r101};
    }

    public static DataMessageSourceType[] values() {
        return (DataMessageSourceType[]) $VALUES.clone();
    }

    public int value() {
        return this.value;
    }

    public static DataMessageSourceType fromId(int r100) {
        DataMessageSourceType[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        DataMessageSourceType r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static DataMessageSourceType valueOf(String r100) {
        return (DataMessageSourceType) a.a(DataMessageSourceType.class, r100);
    }

    private DataMessageSourceType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
