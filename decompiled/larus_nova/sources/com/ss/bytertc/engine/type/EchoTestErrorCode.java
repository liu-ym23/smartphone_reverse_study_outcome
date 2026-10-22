package com.ss.bytertc.engine.type;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum EchoTestErrorCode extends Enum<EchoTestErrorCode> {
    private static final /* synthetic */ EchoTestErrorCode[] $VALUES = null;
    public static final EchoTestErrorCode ECHO_TEST_RESULT_AUDIO_DEVICE_ERROR = null;
    public static final EchoTestErrorCode ECHO_TEST_RESULT_AUDIO_RECEIVE_ERROR = null;
    public static final EchoTestErrorCode ECHO_TEST_RESULT_INTERNAL_ERROR = null;
    public static final EchoTestErrorCode ECHO_TEST_RESULT_SHORT_INTERVAL = null;
    public static final EchoTestErrorCode ECHO_TEST_RESULT_SUCCESS = null;
    public static final EchoTestErrorCode ECHO_TEST_RESULT_TIMEOUT = null;
    public static final EchoTestErrorCode ECHO_TEST_RESULT_VIDEO_DEVICE_ERROR = null;
    public static final EchoTestErrorCode ECHO_TEST_RESULT_VIDEO_RECEIVE_ERROR = null;
    private int value;

    static {
        EchoTestErrorCode r100 = new EchoTestErrorCode("ECHO_TEST_RESULT_SUCCESS", 0, 0);
        ECHO_TEST_RESULT_SUCCESS = r100;
        EchoTestErrorCode r101 = new EchoTestErrorCode("ECHO_TEST_RESULT_TIMEOUT", 1, 1);
        ECHO_TEST_RESULT_TIMEOUT = r101;
        EchoTestErrorCode r102 = new EchoTestErrorCode("ECHO_TEST_RESULT_SHORT_INTERVAL", 2, 2);
        ECHO_TEST_RESULT_SHORT_INTERVAL = r102;
        EchoTestErrorCode r103 = new EchoTestErrorCode("ECHO_TEST_RESULT_AUDIO_DEVICE_ERROR", 3, 3);
        ECHO_TEST_RESULT_AUDIO_DEVICE_ERROR = r103;
        EchoTestErrorCode r104 = new EchoTestErrorCode("ECHO_TEST_RESULT_VIDEO_DEVICE_ERROR", 4, 4);
        ECHO_TEST_RESULT_VIDEO_DEVICE_ERROR = r104;
        EchoTestErrorCode r105 = new EchoTestErrorCode("ECHO_TEST_RESULT_AUDIO_RECEIVE_ERROR", 5, 5);
        ECHO_TEST_RESULT_AUDIO_RECEIVE_ERROR = r105;
        EchoTestErrorCode r110 = new EchoTestErrorCode("ECHO_TEST_RESULT_VIDEO_RECEIVE_ERROR", 6, 6);
        ECHO_TEST_RESULT_VIDEO_RECEIVE_ERROR = r110;
        EchoTestErrorCode r111 = new EchoTestErrorCode("ECHO_TEST_RESULT_INTERNAL_ERROR", 7, 7);
        ECHO_TEST_RESULT_INTERNAL_ERROR = r111;
        $VALUES = new EchoTestErrorCode[]{r100, r101, r102, r103, r104, r105, r110, r111};
    }

    public static EchoTestErrorCode[] values() {
        return (EchoTestErrorCode[]) $VALUES.clone();
    }

    public int value() {
        return this.value;
    }

    public static EchoTestErrorCode fromId(int r100) {
        EchoTestErrorCode[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        EchoTestErrorCode r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L9:
        return ECHO_TEST_RESULT_SUCCESS;
    }

    public static EchoTestErrorCode valueOf(String r100) {
        return (EchoTestErrorCode) a.a(EchoTestErrorCode.class, r100);
    }

    private EchoTestErrorCode(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
