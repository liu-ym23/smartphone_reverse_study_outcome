package com.ss.bytertc.engine.aigc;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum StartSessionResult extends Enum<StartSessionResult> {
    private static final /* synthetic */ StartSessionResult[] $VALUES = null;
    public static final StartSessionResult START_SESSION_RESULT_CONNECTION_FAILED = null;
    public static final StartSessionResult START_SESSION_RESULT_HAS_IN_SESSION = null;
    public static final StartSessionResult START_SESSION_RESULT_JOIN_ROOM_FAILED = null;
    public static final StartSessionResult START_SESSION_RESULT_POST_PROCESS_ERROR = null;
    public static final StartSessionResult START_SESSION_RESULT_SUCCESS = null;
    public static final StartSessionResult START_SESSION_RESULT_TIMEOUT = null;
    public static final StartSessionResult START_SESSION_RESULT_USER_CANCEL = null;
    private final int value;

    static {
        StartSessionResult r100 = new StartSessionResult("START_SESSION_RESULT_SUCCESS", 0, 0);
        START_SESSION_RESULT_SUCCESS = r100;
        StartSessionResult r101 = new StartSessionResult("START_SESSION_RESULT_HAS_IN_SESSION", 1, 1);
        START_SESSION_RESULT_HAS_IN_SESSION = r101;
        StartSessionResult r102 = new StartSessionResult("START_SESSION_RESULT_JOIN_ROOM_FAILED", 2, 2);
        START_SESSION_RESULT_JOIN_ROOM_FAILED = r102;
        StartSessionResult r103 = new StartSessionResult("START_SESSION_RESULT_CONNECTION_FAILED", 3, 3);
        START_SESSION_RESULT_CONNECTION_FAILED = r103;
        StartSessionResult r104 = new StartSessionResult("START_SESSION_RESULT_POST_PROCESS_ERROR", 4, 4);
        START_SESSION_RESULT_POST_PROCESS_ERROR = r104;
        StartSessionResult r105 = new StartSessionResult("START_SESSION_RESULT_TIMEOUT", 5, 5);
        START_SESSION_RESULT_TIMEOUT = r105;
        StartSessionResult r110 = new StartSessionResult("START_SESSION_RESULT_USER_CANCEL", 6, 6);
        START_SESSION_RESULT_USER_CANCEL = r110;
        $VALUES = new StartSessionResult[]{r100, r101, r102, r103, r104, r105, r110};
    }

    public static StartSessionResult[] values() {
        return (StartSessionResult[]) $VALUES.clone();
    }

    public int value() {
        return this.value;
    }

    public static StartSessionResult fromId(int r100) {
        StartSessionResult[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        StartSessionResult r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L9:
        return START_SESSION_RESULT_SUCCESS;
    }

    public static StartSessionResult valueOf(String r100) {
        return (StartSessionResult) a.a(StartSessionResult.class, r100);
    }

    private StartSessionResult(String r100, int r101) {
        super(r100, r101);
        this.value = 0;
    }

    private StartSessionResult(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
