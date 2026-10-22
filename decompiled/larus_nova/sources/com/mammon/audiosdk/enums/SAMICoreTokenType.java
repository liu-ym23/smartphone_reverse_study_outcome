package com.mammon.audiosdk.enums;

import java.util.HashMap;
import r27.a;

/* JADX INFO: loaded from: classes4.dex */
public final enum SAMICoreTokenType extends Enum<SAMICoreTokenType> {
    private static final /* synthetic */ SAMICoreTokenType[] $VALUES = null;
    public static final SAMICoreTokenType TOKEN_TO_B = null;
    public static final SAMICoreTokenType TOKEN_TO_B_MIXED = null;
    public static final SAMICoreTokenType TOKEN_TO_C_D = null;
    public static final HashMap<Integer, SAMICoreTokenType> intToEnumMap = null;
    private int value;

    static {
        int r100 = 0;
        SAMICoreTokenType r101 = new SAMICoreTokenType("TOKEN_TO_B", 0, 0);
        TOKEN_TO_B = r101;
        SAMICoreTokenType r102 = new SAMICoreTokenType("TOKEN_TO_C_D", 1, 1);
        TOKEN_TO_C_D = r102;
        SAMICoreTokenType r103 = new SAMICoreTokenType("TOKEN_TO_B_MIXED", 2, 2);
        TOKEN_TO_B_MIXED = r103;
        $VALUES = new SAMICoreTokenType[]{r101, r102, r103};
        intToEnumMap = new HashMap();
        SAMICoreTokenType[] r104 = values();
        int r105 = r104.length;
    L3:
        if (r100 >= r105) goto L5;
        SAMICoreTokenType r106 = r104[r100];
        intToEnumMap.put(Integer.valueOf(r106.getValue()), r106);
        r100 = r100 + 1;
        goto L3
    }

    public static SAMICoreTokenType[] values() {
        return (SAMICoreTokenType[]) $VALUES.clone();
    }

    public int getValue() {
        return this.value;
    }

    public static SAMICoreTokenType fromInt(int r100) {
        return intToEnumMap.get(Integer.valueOf(r100));
    }

    public static SAMICoreTokenType valueOf(String r100) {
        return (SAMICoreTokenType) a.a(SAMICoreTokenType.class, r100);
    }

    private SAMICoreTokenType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
