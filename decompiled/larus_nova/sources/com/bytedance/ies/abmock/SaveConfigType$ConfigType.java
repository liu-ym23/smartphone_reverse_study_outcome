package com.bytedance.ies.abmock;

import r27.a;

/* JADX INFO: loaded from: classes6.dex */
public final enum SaveConfigType$ConfigType extends Enum<SaveConfigType$ConfigType> {
    private static final /* synthetic */ SaveConfigType$ConfigType[] $VALUES = null;
    public static final SaveConfigType$ConfigType BOOLEAN = null;
    public static final SaveConfigType$ConfigType DOUBLE = null;
    public static final SaveConfigType$ConfigType FLOAT = null;
    public static final SaveConfigType$ConfigType INT = null;
    public static final SaveConfigType$ConfigType LONG = null;
    public static final SaveConfigType$ConfigType OBJECT = null;
    public static final SaveConfigType$ConfigType STRING = null;
    public static final SaveConfigType$ConfigType STRING_ARRAY = null;

    static {
        SaveConfigType$ConfigType r100 = new SaveConfigType$ConfigType("BOOLEAN", 0);
        BOOLEAN = r100;
        SaveConfigType$ConfigType r101 = new SaveConfigType$ConfigType("INT", 1);
        INT = r101;
        SaveConfigType$ConfigType r102 = new SaveConfigType$ConfigType("LONG", 2);
        LONG = r102;
        SaveConfigType$ConfigType r103 = new SaveConfigType$ConfigType("DOUBLE", 3);
        DOUBLE = r103;
        SaveConfigType$ConfigType r104 = new SaveConfigType$ConfigType("FLOAT", 4);
        FLOAT = r104;
        SaveConfigType$ConfigType r105 = new SaveConfigType$ConfigType("STRING", 5);
        STRING = r105;
        SaveConfigType$ConfigType r110 = new SaveConfigType$ConfigType("STRING_ARRAY", 6);
        STRING_ARRAY = r110;
        SaveConfigType$ConfigType r111 = new SaveConfigType$ConfigType("OBJECT", 7);
        OBJECT = r111;
        $VALUES = new SaveConfigType$ConfigType[]{r100, r101, r102, r103, r104, r105, r110, r111};
    }

    public static SaveConfigType$ConfigType[] values() {
        return (SaveConfigType$ConfigType[]) $VALUES.clone();
    }

    public static SaveConfigType$ConfigType valueOf(String r100) {
        return (SaveConfigType$ConfigType) a.a(SaveConfigType$ConfigType.class, r100);
    }

    private SaveConfigType$ConfigType(String r100, int r101) {
        super(r100, r101);
    }
}
