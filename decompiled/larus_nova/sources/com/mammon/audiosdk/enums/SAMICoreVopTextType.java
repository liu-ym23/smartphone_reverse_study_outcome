package com.mammon.audiosdk.enums;

import r27.a;

/* JADX INFO: loaded from: classes32.dex */
public final enum SAMICoreVopTextType extends Enum<SAMICoreVopTextType> {
    private static final /* synthetic */ SAMICoreVopTextType[] $VALUES = null;
    public static final SAMICoreVopTextType PRIMARY = null;
    public static final SAMICoreVopTextType STANDARD = null;
    private int value;

    static {
        SAMICoreVopTextType r100 = new SAMICoreVopTextType("PRIMARY", 0, 50);
        PRIMARY = r100;
        SAMICoreVopTextType r101 = new SAMICoreVopTextType("STANDARD", 1, 80);
        STANDARD = r101;
        $VALUES = new SAMICoreVopTextType[]{r100, r101};
    }

    public static SAMICoreVopTextType[] values() {
        return (SAMICoreVopTextType[]) $VALUES.clone();
    }

    public int getValue() {
        return this.value;
    }

    public static SAMICoreVopTextType valueOf(String r100) {
        return (SAMICoreVopTextType) a.a(SAMICoreVopTextType.class, r100);
    }

    private SAMICoreVopTextType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
