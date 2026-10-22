package com.mammon.audiosdk.enums;

import java.util.HashMap;
import r27.a;

/* JADX INFO: loaded from: classes32.dex */
public final enum SAMICoreHttpPayloadType extends Enum<SAMICoreHttpPayloadType> {
    private static final /* synthetic */ SAMICoreHttpPayloadType[] $VALUES = null;
    public static final SAMICoreHttpPayloadType JsonString = null;
    public static final SAMICoreHttpPayloadType None = null;
    public static final SAMICoreHttpPayloadType StyleConversion = null;
    public static final HashMap<Integer, SAMICoreHttpPayloadType> intToEnumMap = null;
    private int value;

    static {
        int r100 = 0;
        SAMICoreHttpPayloadType r101 = new SAMICoreHttpPayloadType("None", 0, 0);
        None = r101;
        SAMICoreHttpPayloadType r102 = new SAMICoreHttpPayloadType("JsonString", 1, 1);
        JsonString = r102;
        SAMICoreHttpPayloadType r103 = new SAMICoreHttpPayloadType("StyleConversion", 2, 2);
        StyleConversion = r103;
        $VALUES = new SAMICoreHttpPayloadType[]{r101, r102, r103};
        intToEnumMap = new HashMap();
        SAMICoreHttpPayloadType[] r104 = values();
        int r105 = r104.length;
    L3:
        if (r100 >= r105) goto L5;
        SAMICoreHttpPayloadType r106 = r104[r100];
        intToEnumMap.put(Integer.valueOf(r106.getValue()), r106);
        r100 = r100 + 1;
        goto L3
    }

    public static SAMICoreHttpPayloadType[] values() {
        return (SAMICoreHttpPayloadType[]) $VALUES.clone();
    }

    public int getValue() {
        return this.value;
    }

    public static SAMICoreHttpPayloadType fromInt(int r100) {
        return intToEnumMap.get(Integer.valueOf(r100));
    }

    public static SAMICoreHttpPayloadType valueOf(String r100) {
        return (SAMICoreHttpPayloadType) a.a(SAMICoreHttpPayloadType.class, r100);
    }

    private SAMICoreHttpPayloadType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
