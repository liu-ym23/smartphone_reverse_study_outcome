package com.ss.bytertc.engine.data;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum ReturnStatus extends Enum<ReturnStatus> {
    private static final /* synthetic */ ReturnStatus[] $VALUES = null;
    public static final ReturnStatus RETURN_STATUS_AUDIO_DEVICE_CAN_NOT_USE = null;
    public static final ReturnStatus RETURN_STATUS_AUDIO_DEVICE_FORMAT_NOT_SUPPORT = null;
    public static final ReturnStatus RETURN_STATUS_AUDIO_DEVICE_INIT_FAILED = null;
    public static final ReturnStatus RETURN_STATUS_AUDIO_DEVICE_NOT_EXISTS = null;
    public static final ReturnStatus RETURN_STATUS_AUDIO_DEVICE_NO_DEVICE = null;
    public static final ReturnStatus RETURN_STATUS_AUDIO_DEVICE_PROCESS_NOT_EXIST = null;
    public static final ReturnStatus RETURN_STATUS_AUDIO_DEVICE_START_FAILED = null;
    public static final ReturnStatus RETURN_STATUS_AUDIO_NOT_IMPLEMENTED = null;
    public static final ReturnStatus RETURN_STATUS_AUDIO_NO_FRAME = null;
    public static final ReturnStatus RETURN_STATUS_AUDIO_NO_PERMISSION = null;
    public static final ReturnStatus RETURN_STATUS_FAILURE = null;
    public static final ReturnStatus RETURN_STATUS_HAS_IN_ECHO_TEST = null;
    public static final ReturnStatus RETURN_STATUS_HAS_IN_LOGIN = null;
    public static final ReturnStatus RETURN_STATUS_HAS_IN_ROOM = null;
    public static final ReturnStatus RETURN_STATUS_NATIVE_IN_VALID = null;
    public static final ReturnStatus RETURN_STATUS_NEITHER_VIDEO_NOR_AUDIO = null;
    public static final ReturnStatus RETURN_STATUS_NOT_SUPPORT = null;
    public static final ReturnStatus RETURN_STATUS_PARAMETER_ERR = null;
    public static final ReturnStatus RETURN_STATUS_RESOURCE_OVERFLOW = null;
    public static final ReturnStatus RETURN_STATUS_ROOMID_IN_USE = null;
    public static final ReturnStatus RETURN_STATUS_SCREEN_NOT_SUPPORT = null;
    public static final ReturnStatus RETURN_STATUS_SUCCESS = null;
    public static final ReturnStatus RETURN_STATUS_VIDEO_NOT_SUPPORT = null;
    public static final ReturnStatus RETURN_STATUS_VIDEO_TIMESTAMP_WARNING = null;
    public static final ReturnStatus RETURN_STATUS_WRONG_STATE = null;
    private int value;

    static {
        ReturnStatus r100 = new ReturnStatus("RETURN_STATUS_SUCCESS", 0, 0);
        RETURN_STATUS_SUCCESS = r100;
        ReturnStatus r101 = new ReturnStatus("RETURN_STATUS_FAILURE", 1, -1);
        RETURN_STATUS_FAILURE = r101;
        ReturnStatus r102 = new ReturnStatus("RETURN_STATUS_PARAMETER_ERR", 2, -2);
        RETURN_STATUS_PARAMETER_ERR = r102;
        ReturnStatus r103 = new ReturnStatus("RETURN_STATUS_WRONG_STATE", 3, -3);
        RETURN_STATUS_WRONG_STATE = r103;
        ReturnStatus r104 = new ReturnStatus("RETURN_STATUS_HAS_IN_ROOM", 4, -4);
        RETURN_STATUS_HAS_IN_ROOM = r104;
        ReturnStatus r105 = new ReturnStatus("RETURN_STATUS_HAS_IN_LOGIN", 5, -5);
        RETURN_STATUS_HAS_IN_LOGIN = r105;
        ReturnStatus r110 = new ReturnStatus("RETURN_STATUS_HAS_IN_ECHO_TEST", 6, -6);
        RETURN_STATUS_HAS_IN_ECHO_TEST = r110;
        ReturnStatus r111 = new ReturnStatus("RETURN_STATUS_NEITHER_VIDEO_NOR_AUDIO", 7, -7);
        RETURN_STATUS_NEITHER_VIDEO_NOR_AUDIO = r111;
        ReturnStatus r112 = new ReturnStatus("RETURN_STATUS_ROOMID_IN_USE", 8, -8);
        RETURN_STATUS_ROOMID_IN_USE = r112;
        ReturnStatus r113 = new ReturnStatus("RETURN_STATUS_SCREEN_NOT_SUPPORT", 9, -9);
        RETURN_STATUS_SCREEN_NOT_SUPPORT = r113;
        ReturnStatus r114 = new ReturnStatus("RETURN_STATUS_NOT_SUPPORT", 10, -10);
        RETURN_STATUS_NOT_SUPPORT = r114;
        ReturnStatus r106 = new ReturnStatus("RETURN_STATUS_RESOURCE_OVERFLOW", 11, -11);
        RETURN_STATUS_RESOURCE_OVERFLOW = r106;
        ReturnStatus r107 = new ReturnStatus("RETURN_STATUS_VIDEO_NOT_SUPPORT", 12, -12);
        RETURN_STATUS_VIDEO_NOT_SUPPORT = r107;
        ReturnStatus r108 = new ReturnStatus("RETURN_STATUS_AUDIO_NO_FRAME", 13, -101);
        RETURN_STATUS_AUDIO_NO_FRAME = r108;
        ReturnStatus r109 = new ReturnStatus("RETURN_STATUS_AUDIO_NOT_IMPLEMENTED", 14, -102);
        RETURN_STATUS_AUDIO_NOT_IMPLEMENTED = r109;
        ReturnStatus r115 = new ReturnStatus("RETURN_STATUS_AUDIO_NO_PERMISSION", 15, -103);
        RETURN_STATUS_AUDIO_NO_PERMISSION = r115;
        ReturnStatus r116 = new ReturnStatus("RETURN_STATUS_AUDIO_DEVICE_NOT_EXISTS", 16, -104);
        RETURN_STATUS_AUDIO_DEVICE_NOT_EXISTS = r116;
        ReturnStatus r117 = new ReturnStatus("RETURN_STATUS_AUDIO_DEVICE_FORMAT_NOT_SUPPORT", 17, -105);
        RETURN_STATUS_AUDIO_DEVICE_FORMAT_NOT_SUPPORT = r117;
        ReturnStatus r118 = new ReturnStatus("RETURN_STATUS_AUDIO_DEVICE_NO_DEVICE", 18, -106);
        RETURN_STATUS_AUDIO_DEVICE_NO_DEVICE = r118;
        ReturnStatus r119 = new ReturnStatus("RETURN_STATUS_AUDIO_DEVICE_CAN_NOT_USE", 19, -107);
        RETURN_STATUS_AUDIO_DEVICE_CAN_NOT_USE = r119;
        ReturnStatus r120 = new ReturnStatus("RETURN_STATUS_AUDIO_DEVICE_INIT_FAILED", 20, -108);
        RETURN_STATUS_AUDIO_DEVICE_INIT_FAILED = r120;
        ReturnStatus r121 = new ReturnStatus("RETURN_STATUS_AUDIO_DEVICE_START_FAILED", 21, -109);
        RETURN_STATUS_AUDIO_DEVICE_START_FAILED = r121;
        ReturnStatus r122 = new ReturnStatus("RETURN_STATUS_AUDIO_DEVICE_PROCESS_NOT_EXIST", 22, -110);
        RETURN_STATUS_AUDIO_DEVICE_PROCESS_NOT_EXIST = r122;
        ReturnStatus r123 = new ReturnStatus("RETURN_STATUS_NATIVE_IN_VALID", 23, -201);
        RETURN_STATUS_NATIVE_IN_VALID = r123;
        ReturnStatus r124 = new ReturnStatus("RETURN_STATUS_VIDEO_TIMESTAMP_WARNING", 24, -202);
        RETURN_STATUS_VIDEO_TIMESTAMP_WARNING = r124;
        $VALUES = new ReturnStatus[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r106, r107, r108, r109, r115, r116, r117, r118, r119, r120, r121, r122, r123, r124};
    }

    public static ReturnStatus[] values() {
        return (ReturnStatus[]) $VALUES.clone();
    }

    public int value() {
        return this.value;
    }

    public static ReturnStatus fromId(int r100) {
        ReturnStatus[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        ReturnStatus r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static ReturnStatus valueOf(String r100) {
        return (ReturnStatus) a.a(ReturnStatus.class, r100);
    }

    private ReturnStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
