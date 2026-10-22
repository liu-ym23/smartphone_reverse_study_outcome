package com.bytedance.hmp;

import r27.a;

/* JADX INFO: loaded from: classes19.dex */
public final enum ScalarType extends Enum<ScalarType> {
    private static final /* synthetic */ ScalarType[] $VALUES = null;
    public static final ScalarType kFloat32 = null;
    public static final ScalarType kFloat64 = null;
    public static final ScalarType kHalf = null;
    public static final ScalarType kInt = null;
    public static final ScalarType kInt16 = null;
    public static final ScalarType kInt32 = null;
    public static final ScalarType kInt64 = null;
    public static final ScalarType kUInt16 = null;
    public static final ScalarType kUInt8 = null;
    int value;

    static {
        ScalarType r100 = new ScalarType("kUInt8", 0, 0);
        kUInt8 = r100;
        ScalarType r101 = new ScalarType("kInt", 1, 1);
        kInt = r101;
        ScalarType r102 = new ScalarType("kUInt16", 2, 2);
        kUInt16 = r102;
        ScalarType r103 = new ScalarType("kInt16", 3, 3);
        kInt16 = r103;
        ScalarType r104 = new ScalarType("kInt32", 4, 4);
        kInt32 = r104;
        ScalarType r105 = new ScalarType("kInt64", 5, 5);
        kInt64 = r105;
        ScalarType r110 = new ScalarType("kFloat32", 6, 6);
        kFloat32 = r110;
        ScalarType r111 = new ScalarType("kFloat64", 7, 7);
        kFloat64 = r111;
        ScalarType r112 = new ScalarType("kHalf", 8, 8);
        kHalf = r112;
        $VALUES = new ScalarType[]{r100, r101, r102, r103, r104, r105, r110, r111, r112};
    }

    public static ScalarType[] values() {
        return (ScalarType[]) $VALUES.clone();
    }

    public int getValue() {
        return this.value;
    }

    public static ScalarType valueOf(String r100) {
        return (ScalarType) a.a(ScalarType.class, r100);
    }

    private ScalarType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
