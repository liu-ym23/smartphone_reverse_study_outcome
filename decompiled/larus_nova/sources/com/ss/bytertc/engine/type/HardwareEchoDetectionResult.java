package com.ss.bytertc.engine.type;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum HardwareEchoDetectionResult extends Enum<HardwareEchoDetectionResult> {
    private static final /* synthetic */ HardwareEchoDetectionResult[] $VALUES = null;
    public static final HardwareEchoDetectionResult HARDWARE_ECHO_RESULT_CANCELED = null;
    public static final HardwareEchoDetectionResult HARDWARE_ECHO_RESULT_NORMAL = null;
    public static final HardwareEchoDetectionResult HARDWARE_ECHO_RESULT_POOR = null;
    public static final HardwareEchoDetectionResult HARDWARE_ECHO_RESULT_UNKNOWN = null;
    private final int value;

    static {
        HardwareEchoDetectionResult r100 = new HardwareEchoDetectionResult("HARDWARE_ECHO_RESULT_CANCELED", 0, 0);
        HARDWARE_ECHO_RESULT_CANCELED = r100;
        HardwareEchoDetectionResult r101 = new HardwareEchoDetectionResult("HARDWARE_ECHO_RESULT_UNKNOWN", 1, 1);
        HARDWARE_ECHO_RESULT_UNKNOWN = r101;
        HardwareEchoDetectionResult r102 = new HardwareEchoDetectionResult("HARDWARE_ECHO_RESULT_NORMAL", 2, 2);
        HARDWARE_ECHO_RESULT_NORMAL = r102;
        HardwareEchoDetectionResult r103 = new HardwareEchoDetectionResult("HARDWARE_ECHO_RESULT_POOR", 3, 3);
        HARDWARE_ECHO_RESULT_POOR = r103;
        $VALUES = new HardwareEchoDetectionResult[]{r100, r101, r102, r103};
    }

    public static HardwareEchoDetectionResult[] values() {
        return (HardwareEchoDetectionResult[]) $VALUES.clone();
    }

    public int value() {
        return this.value;
    }

    public static HardwareEchoDetectionResult fromId(int r100) {
        HardwareEchoDetectionResult[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        HardwareEchoDetectionResult r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L9:
        return HARDWARE_ECHO_RESULT_NORMAL;
    }

    public static HardwareEchoDetectionResult valueOf(String r100) {
        return (HardwareEchoDetectionResult) a.a(HardwareEchoDetectionResult.class, r100);
    }

    private HardwareEchoDetectionResult(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
