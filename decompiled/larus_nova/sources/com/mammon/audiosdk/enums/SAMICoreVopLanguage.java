package com.mammon.audiosdk.enums;

import r27.a;

/* JADX INFO: loaded from: classes32.dex */
public final enum SAMICoreVopLanguage extends Enum<SAMICoreVopLanguage> {
    private static final /* synthetic */ SAMICoreVopLanguage[] $VALUES = null;
    public static final SAMICoreVopLanguage CHINESE = null;
    public static final SAMICoreVopLanguage ENGLISH = null;
    public static final SAMICoreVopLanguage JAPANESE = null;
    private int value;

    static {
        SAMICoreVopLanguage r100 = new SAMICoreVopLanguage("JAPANESE", 0, 0);
        JAPANESE = r100;
        SAMICoreVopLanguage r101 = new SAMICoreVopLanguage("ENGLISH", 1, 1);
        ENGLISH = r101;
        SAMICoreVopLanguage r102 = new SAMICoreVopLanguage("CHINESE", 2, 2);
        CHINESE = r102;
        $VALUES = new SAMICoreVopLanguage[]{r100, r101, r102};
    }

    public static SAMICoreVopLanguage[] values() {
        return (SAMICoreVopLanguage[]) $VALUES.clone();
    }

    public int getValue() {
        return this.value;
    }

    public static SAMICoreVopLanguage valueOf(String r100) {
        return (SAMICoreVopLanguage) a.a(SAMICoreVopLanguage.class, r100);
    }

    private SAMICoreVopLanguage(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
