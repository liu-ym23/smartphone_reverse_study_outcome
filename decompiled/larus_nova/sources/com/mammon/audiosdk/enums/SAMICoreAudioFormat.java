package com.mammon.audiosdk.enums;

import java.util.HashMap;
import r27.a;

/* JADX INFO: loaded from: classes32.dex */
public final enum SAMICoreAudioFormat extends Enum<SAMICoreAudioFormat> {
    private static final /* synthetic */ SAMICoreAudioFormat[] $VALUES = null;
    public static final SAMICoreAudioFormat AAC = null;
    public static final SAMICoreAudioFormat OPUS = null;
    public static final SAMICoreAudioFormat PCM = null;
    public static final SAMICoreAudioFormat WAV = null;
    public static final HashMap<Integer, SAMICoreAudioFormat> intToEnumMap = null;
    private int value;

    static {
        int r100 = 0;
        SAMICoreAudioFormat r101 = new SAMICoreAudioFormat("PCM", 0, 0);
        PCM = r101;
        SAMICoreAudioFormat r102 = new SAMICoreAudioFormat("WAV", 1, 1);
        WAV = r102;
        SAMICoreAudioFormat r103 = new SAMICoreAudioFormat("AAC", 2, 2);
        AAC = r103;
        SAMICoreAudioFormat r104 = new SAMICoreAudioFormat("OPUS", 3, 3);
        OPUS = r104;
        $VALUES = new SAMICoreAudioFormat[]{r101, r102, r103, r104};
        intToEnumMap = new HashMap();
        SAMICoreAudioFormat[] r105 = values();
        int r106 = r105.length;
    L3:
        if (r100 >= r106) goto L5;
        SAMICoreAudioFormat r107 = r105[r100];
        intToEnumMap.put(Integer.valueOf(r107.getValue()), r107);
        r100 = r100 + 1;
        goto L3
    }

    public static SAMICoreAudioFormat[] values() {
        return (SAMICoreAudioFormat[]) $VALUES.clone();
    }

    public int getValue() {
        return this.value;
    }

    public static SAMICoreAudioFormat fromInt(int r100) {
        return intToEnumMap.get(Integer.valueOf(r100));
    }

    public static SAMICoreAudioFormat valueOf(String r100) {
        return (SAMICoreAudioFormat) a.a(SAMICoreAudioFormat.class, r100);
    }

    private SAMICoreAudioFormat(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
