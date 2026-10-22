package com.ss.bytertc.engine.type;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum RecordingErrorCode extends Enum<RecordingErrorCode> {
    private static final /* synthetic */ RecordingErrorCode[] $VALUES = null;
    public static final RecordingErrorCode RECORDING_ERROR_CODE_NOT_SUPPORT = null;
    public static final RecordingErrorCode RECORDING_ERROR_CODE_NO_OTHER = null;
    public static final RecordingErrorCode RECORDING_ERROR_CODE_NO_PERMISSION = null;
    public static final RecordingErrorCode RECORDING_ERROR_CODE_OK = null;
    private int value;

    static {
        RecordingErrorCode r100 = new RecordingErrorCode("RECORDING_ERROR_CODE_OK", 0, 0);
        RECORDING_ERROR_CODE_OK = r100;
        RecordingErrorCode r101 = new RecordingErrorCode("RECORDING_ERROR_CODE_NO_PERMISSION", 1, -1);
        RECORDING_ERROR_CODE_NO_PERMISSION = r101;
        RecordingErrorCode r102 = new RecordingErrorCode("RECORDING_ERROR_CODE_NOT_SUPPORT", 2, -2);
        RECORDING_ERROR_CODE_NOT_SUPPORT = r102;
        RecordingErrorCode r103 = new RecordingErrorCode("RECORDING_ERROR_CODE_NO_OTHER", 3, -3);
        RECORDING_ERROR_CODE_NO_OTHER = r103;
        $VALUES = new RecordingErrorCode[]{r100, r101, r102, r103};
    }

    public static RecordingErrorCode[] values() {
        return (RecordingErrorCode[]) $VALUES.clone();
    }

    public int value() {
        return this.value;
    }

    public static RecordingErrorCode fromId(int r100) {
        RecordingErrorCode[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        RecordingErrorCode r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L9:
        return RECORDING_ERROR_CODE_OK;
    }

    public static RecordingErrorCode valueOf(String r100) {
        return (RecordingErrorCode) a.a(RecordingErrorCode.class, r100);
    }

    private RecordingErrorCode(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
