package com.bytedance.sync.model;

import r27.a;

/* JADX INFO: loaded from: classes22.dex */
public final enum DataType extends Enum<DataType> {
    public static final DataType FILE_PATH = null;
    public static final DataType ORIGIN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DataType[] f270373a = null;
    private final int type;

    static {
        DataType r100 = new DataType("ORIGIN", 0, 0);
        ORIGIN = r100;
        DataType r101 = new DataType("FILE_PATH", 1, 1);
        FILE_PATH = r101;
        f270373a = new DataType[]{r100, r101};
    }

    public static DataType[] values() {
        return (DataType[]) f270373a.clone();
    }

    public int getValue() {
        return this.type;
    }

    public static DataType fromValue(int r100) {
        DataType r101 = ORIGIN;
        if (r100 != r101.getValue()) goto L5;
        return r101;
    L5:
        DataType r102 = FILE_PATH;
        if (r100 != r102.getValue()) goto L8;
        return r102;
    L8:
        return null;
    }

    public static DataType valueOf(String r100) {
        return (DataType) a.a(DataType.class, r100);
    }

    public DataType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
