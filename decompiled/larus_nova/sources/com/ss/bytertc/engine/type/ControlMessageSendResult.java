package com.ss.bytertc.engine.type;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum ControlMessageSendResult extends Enum<ControlMessageSendResult> {
    private static final /* synthetic */ ControlMessageSendResult[] $VALUES = null;
    public static final ControlMessageSendResult CONTROL_MESSAGE_SEND_RESULT_EXCEED_MAX_LENGTH = null;
    public static final ControlMessageSendResult CONTROL_MESSAGE_SEND_RESULT_NOT_JOIN = null;
    public static final ControlMessageSendResult CONTROL_MESSAGE_SEND_RESULT_POST_PROCESS_PARSE_ERROR = null;
    public static final ControlMessageSendResult CONTROL_MESSAGE_SEND_RESULT_SUCCESS = null;
    public static final ControlMessageSendResult CONTROL_MESSAGE_SEND_RESULT_TIMEOUT = null;
    public static final ControlMessageSendResult USER_MESSAGE_SEND_RESULT_UNKNOWN = null;
    private int value;

    static {
        ControlMessageSendResult r100 = new ControlMessageSendResult("CONTROL_MESSAGE_SEND_RESULT_SUCCESS", 0, 0);
        CONTROL_MESSAGE_SEND_RESULT_SUCCESS = r100;
        ControlMessageSendResult r101 = new ControlMessageSendResult("CONTROL_MESSAGE_SEND_RESULT_TIMEOUT", 1, 1);
        CONTROL_MESSAGE_SEND_RESULT_TIMEOUT = r101;
        ControlMessageSendResult r102 = new ControlMessageSendResult("CONTROL_MESSAGE_SEND_RESULT_POST_PROCESS_PARSE_ERROR", 2, 2);
        CONTROL_MESSAGE_SEND_RESULT_POST_PROCESS_PARSE_ERROR = r102;
        ControlMessageSendResult r103 = new ControlMessageSendResult("CONTROL_MESSAGE_SEND_RESULT_NOT_JOIN", 3, 100);
        CONTROL_MESSAGE_SEND_RESULT_NOT_JOIN = r103;
        ControlMessageSendResult r104 = new ControlMessageSendResult("CONTROL_MESSAGE_SEND_RESULT_EXCEED_MAX_LENGTH", 4, 103);
        CONTROL_MESSAGE_SEND_RESULT_EXCEED_MAX_LENGTH = r104;
        ControlMessageSendResult r105 = new ControlMessageSendResult("USER_MESSAGE_SEND_RESULT_UNKNOWN", 5, 1000);
        USER_MESSAGE_SEND_RESULT_UNKNOWN = r105;
        $VALUES = new ControlMessageSendResult[]{r100, r101, r102, r103, r104, r105};
    }

    public static ControlMessageSendResult[] values() {
        return (ControlMessageSendResult[]) $VALUES.clone();
    }

    public int value() {
        return this.value;
    }

    public static ControlMessageSendResult fromId(int r100) {
        ControlMessageSendResult[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        ControlMessageSendResult r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static ControlMessageSendResult valueOf(String r100) {
        return (ControlMessageSendResult) a.a(ControlMessageSendResult.class, r100);
    }

    private ControlMessageSendResult(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
