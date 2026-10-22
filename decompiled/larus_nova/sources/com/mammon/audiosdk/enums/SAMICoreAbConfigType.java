package com.mammon.audiosdk.enums;

import java.util.HashMap;
import r27.a;

/* JADX INFO: loaded from: classes32.dex */
public final enum SAMICoreAbConfigType extends Enum<SAMICoreAbConfigType> {
    private static final /* synthetic */ SAMICoreAbConfigType[] $VALUES = null;
    public static final SAMICoreAbConfigType BoolType = null;
    public static final SAMICoreAbConfigType FloatType = null;
    public static final SAMICoreAbConfigType IntType = null;
    public static final SAMICoreAbConfigType StringType = null;
    public static final SAMICoreAbConfigType UnknownType = null;
    public static final HashMap<Integer, SAMICoreAbConfigType> intToEnumMap = null;
    private int value;

    static {
        int r100 = 0;
        SAMICoreAbConfigType r101 = new SAMICoreAbConfigType("UnknownType", 0, 0);
        UnknownType = r101;
        SAMICoreAbConfigType r102 = new SAMICoreAbConfigType("IntType", 1, 1);
        IntType = r102;
        SAMICoreAbConfigType r103 = new SAMICoreAbConfigType("FloatType", 2, 2);
        FloatType = r103;
        SAMICoreAbConfigType r104 = new SAMICoreAbConfigType("StringType", 3, 3);
        StringType = r104;
        SAMICoreAbConfigType r105 = new SAMICoreAbConfigType("BoolType", 4, 4);
        BoolType = r105;
        $VALUES = new SAMICoreAbConfigType[]{r101, r102, r103, r104, r105};
        intToEnumMap = new HashMap();
        SAMICoreAbConfigType[] r106 = values();
        int r107 = r106.length;
    L3:
        if (r100 >= r107) goto L5;
        SAMICoreAbConfigType r108 = r106[r100];
        intToEnumMap.put(Integer.valueOf(r108.getValue()), r108);
        r100 = r100 + 1;
        goto L3
    }

    public static SAMICoreAbConfigType[] values() {
        return (SAMICoreAbConfigType[]) $VALUES.clone();
    }

    public int getValue() {
        return this.value;
    }

    public static SAMICoreAbConfigType fromInt(int r100) {
        return intToEnumMap.get(Integer.valueOf(r100));
    }

    public static SAMICoreAbConfigType valueOf(String r100) {
        return (SAMICoreAbConfigType) a.a(SAMICoreAbConfigType.class, r100);
    }

    private SAMICoreAbConfigType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
