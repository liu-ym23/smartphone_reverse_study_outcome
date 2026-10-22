package com.mammon.audiosdk.enums;

import r27.a;

/* JADX INFO: loaded from: classes32.dex */
public final enum SAMICoreVopRecordingType extends Enum<SAMICoreVopRecordingType> {
    private static final /* synthetic */ SAMICoreVopRecordingType[] $VALUES = null;
    public static final SAMICoreVopRecordingType FILE = null;
    public static final SAMICoreVopRecordingType INTERNAL = null;
    public static final SAMICoreVopRecordingType PCM_S16 = null;
    private int value;

    static {
        SAMICoreVopRecordingType r100 = new SAMICoreVopRecordingType("PCM_S16", 0, 0);
        PCM_S16 = r100;
        SAMICoreVopRecordingType r101 = new SAMICoreVopRecordingType("FILE", 1, 1);
        FILE = r101;
        SAMICoreVopRecordingType r102 = new SAMICoreVopRecordingType("INTERNAL", 2, 2);
        INTERNAL = r102;
        $VALUES = new SAMICoreVopRecordingType[]{r100, r101, r102};
    }

    public static SAMICoreVopRecordingType[] values() {
        return (SAMICoreVopRecordingType[]) $VALUES.clone();
    }

    public int getValue() {
        return this.value;
    }

    public static SAMICoreVopRecordingType valueOf(String r100) {
        return (SAMICoreVopRecordingType) a.a(SAMICoreVopRecordingType.class, r100);
    }

    private SAMICoreVopRecordingType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
