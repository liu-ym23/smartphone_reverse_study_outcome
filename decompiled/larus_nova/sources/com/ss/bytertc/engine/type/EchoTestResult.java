package com.ss.bytertc.engine.type;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum EchoTestResult extends Enum<EchoTestResult> {
    private static final /* synthetic */ EchoTestResult[] $VALUES = null;
    public static final EchoTestResult ECHO_TEST_AUDIO_DEVICE_ERROR = null;
    public static final EchoTestResult ECHO_TEST_AUDIO_RECEIVE_ERROR = null;
    public static final EchoTestResult ECHO_TEST_INTERNAL_ERROR = null;
    public static final EchoTestResult ECHO_TEST_INTERVAL_SHORT = null;
    public static final EchoTestResult ECHO_TEST_SUCCESS = null;
    public static final EchoTestResult ECHO_TEST_TIMEOUT = null;
    public static final EchoTestResult ECHO_TEST_VIDEO_DEVICE_ERROR = null;
    public static final EchoTestResult ECHO_TEST_VIDEO_RECEIVE_ERROR = null;
    private final int value;

    static {
        EchoTestResult r100 = new EchoTestResult("ECHO_TEST_SUCCESS", 0, 0);
        ECHO_TEST_SUCCESS = r100;
        EchoTestResult r101 = new EchoTestResult("ECHO_TEST_TIMEOUT", 1, 1);
        ECHO_TEST_TIMEOUT = r101;
        EchoTestResult r102 = new EchoTestResult("ECHO_TEST_INTERVAL_SHORT", 2, 2);
        ECHO_TEST_INTERVAL_SHORT = r102;
        EchoTestResult r103 = new EchoTestResult("ECHO_TEST_AUDIO_DEVICE_ERROR", 3, 3);
        ECHO_TEST_AUDIO_DEVICE_ERROR = r103;
        EchoTestResult r104 = new EchoTestResult("ECHO_TEST_VIDEO_DEVICE_ERROR", 4, 4);
        ECHO_TEST_VIDEO_DEVICE_ERROR = r104;
        EchoTestResult r105 = new EchoTestResult("ECHO_TEST_AUDIO_RECEIVE_ERROR", 5, 5);
        ECHO_TEST_AUDIO_RECEIVE_ERROR = r105;
        EchoTestResult r110 = new EchoTestResult("ECHO_TEST_VIDEO_RECEIVE_ERROR", 6, 6);
        ECHO_TEST_VIDEO_RECEIVE_ERROR = r110;
        EchoTestResult r111 = new EchoTestResult("ECHO_TEST_INTERNAL_ERROR", 7, 7);
        ECHO_TEST_INTERNAL_ERROR = r111;
        $VALUES = new EchoTestResult[]{r100, r101, r102, r103, r104, r105, r110, r111};
    }

    public static EchoTestResult[] values() {
        return (EchoTestResult[]) $VALUES.clone();
    }

    public int value() {
        return this.value;
    }

    public static EchoTestResult fromId(int r100) {
        EchoTestResult[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        EchoTestResult r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L9:
        return ECHO_TEST_SUCCESS;
    }

    public static EchoTestResult valueOf(String r100) {
        return (EchoTestResult) a.a(EchoTestResult.class, r100);
    }

    private EchoTestResult(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
