package com.bytedance.ug.sdk.luckydog.api.ab;

import r27.a;

/* JADX INFO: loaded from: classes3.dex */
public final enum ABSchemeType extends Enum<ABSchemeType> {
    private static final /* synthetic */ ABSchemeType[] $VALUES = null;
    public static final ABSchemeType DOG = null;
    public static final ABSchemeType FLOWER = null;
    public static final ABSchemeType OLD_DOG = null;
    private final String mSchemeId;

    static {
        ABSchemeType r100 = new ABSchemeType("DOG", 0, "dog");
        DOG = r100;
        ABSchemeType r101 = new ABSchemeType("OLD_DOG", 1, "oldDog");
        OLD_DOG = r101;
        ABSchemeType r102 = new ABSchemeType("FLOWER", 2, "flower");
        FLOWER = r102;
        $VALUES = new ABSchemeType[]{r100, r101, r102};
    }

    public static ABSchemeType[] values() {
        return (ABSchemeType[]) $VALUES.clone();
    }

    public static String getSchemeId(ABSchemeType r100) {
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100.mSchemeId;
    }

    public static ABSchemeType getSchemeType(String r100) {
        ABSchemeType[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        ABSchemeType r104 = r101[r103];
        if (r104.mSchemeId.equals(r100) == true) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static ABSchemeType valueOf(String r100) {
        return (ABSchemeType) a.a(ABSchemeType.class, r100);
    }

    private ABSchemeType(String r100, int r101, String r102) {
        super(r100, r101);
        this.mSchemeId = r102;
    }
}
