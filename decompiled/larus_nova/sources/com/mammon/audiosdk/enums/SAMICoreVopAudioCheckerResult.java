package com.mammon.audiosdk.enums;

import r27.a;

/* JADX INFO: loaded from: classes32.dex */
public final enum SAMICoreVopAudioCheckerResult extends Enum<SAMICoreVopAudioCheckerResult> {
    private static final /* synthetic */ SAMICoreVopAudioCheckerResult[] $VALUES = null;
    public static final SAMICoreVopAudioCheckerResult INTERNAL_ERROR = null;
    public static final SAMICoreVopAudioCheckerResult NETWORK_ERROR = null;
    public static final SAMICoreVopAudioCheckerResult PASSED = null;
    public static final SAMICoreVopAudioCheckerResult SNR_FAILED = null;
    public static final SAMICoreVopAudioCheckerResult WER_FAILED = null;
    private int value;

    static {
        SAMICoreVopAudioCheckerResult r100 = new SAMICoreVopAudioCheckerResult("INTERNAL_ERROR", 0, 0);
        INTERNAL_ERROR = r100;
        SAMICoreVopAudioCheckerResult r101 = new SAMICoreVopAudioCheckerResult("NETWORK_ERROR", 1, 1);
        NETWORK_ERROR = r101;
        SAMICoreVopAudioCheckerResult r102 = new SAMICoreVopAudioCheckerResult("PASSED", 2, 2);
        PASSED = r102;
        SAMICoreVopAudioCheckerResult r103 = new SAMICoreVopAudioCheckerResult("SNR_FAILED", 3, 3);
        SNR_FAILED = r103;
        SAMICoreVopAudioCheckerResult r104 = new SAMICoreVopAudioCheckerResult("WER_FAILED", 4, 4);
        WER_FAILED = r104;
        $VALUES = new SAMICoreVopAudioCheckerResult[]{r100, r101, r102, r103, r104};
    }

    public static SAMICoreVopAudioCheckerResult[] values() {
        return (SAMICoreVopAudioCheckerResult[]) $VALUES.clone();
    }

    public int getValue() {
        return this.value;
    }

    public static SAMICoreVopAudioCheckerResult valueOf(String r100) {
        return (SAMICoreVopAudioCheckerResult) a.a(SAMICoreVopAudioCheckerResult.class, r100);
    }

    private SAMICoreVopAudioCheckerResult(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
