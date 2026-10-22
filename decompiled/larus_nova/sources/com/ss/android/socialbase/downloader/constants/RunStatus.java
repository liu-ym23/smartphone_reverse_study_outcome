package com.ss.android.socialbase.downloader.constants;

import r27.a;

/* JADX INFO: loaded from: classes6.dex */
public final enum RunStatus extends Enum<RunStatus> {
    private static final /* synthetic */ RunStatus[] $VALUES = null;
    public static final RunStatus RUN_STATUS_CANCELED = null;
    public static final RunStatus RUN_STATUS_COMPLETED = null;
    public static final RunStatus RUN_STATUS_END_FOR_FILE_EXIST = null;
    public static final RunStatus RUN_STATUS_END_RIGHT_NOW = null;
    public static final RunStatus RUN_STATUS_ERROR = null;
    public static final RunStatus RUN_STATUS_INTERCEPT = null;
    public static final RunStatus RUN_STATUS_NONE = null;
    public static final RunStatus RUN_STATUS_PAUSE = null;
    public static final RunStatus RUN_STATUS_WAITING_ASYNC_HANDLER = null;

    static {
        RunStatus r100 = new RunStatus("RUN_STATUS_NONE", 0);
        RUN_STATUS_NONE = r100;
        RunStatus r101 = new RunStatus("RUN_STATUS_PAUSE", 1);
        RUN_STATUS_PAUSE = r101;
        RunStatus r102 = new RunStatus("RUN_STATUS_CANCELED", 2);
        RUN_STATUS_CANCELED = r102;
        RunStatus r103 = new RunStatus("RUN_STATUS_ERROR", 3);
        RUN_STATUS_ERROR = r103;
        RunStatus r104 = new RunStatus("RUN_STATUS_END_RIGHT_NOW", 4);
        RUN_STATUS_END_RIGHT_NOW = r104;
        RunStatus r105 = new RunStatus("RUN_STATUS_WAITING_ASYNC_HANDLER", 5);
        RUN_STATUS_WAITING_ASYNC_HANDLER = r105;
        RunStatus r110 = new RunStatus("RUN_STATUS_END_FOR_FILE_EXIST", 6);
        RUN_STATUS_END_FOR_FILE_EXIST = r110;
        RunStatus r111 = new RunStatus("RUN_STATUS_INTERCEPT", 7);
        RUN_STATUS_INTERCEPT = r111;
        RunStatus r112 = new RunStatus("RUN_STATUS_COMPLETED", 8);
        RUN_STATUS_COMPLETED = r112;
        $VALUES = new RunStatus[]{r100, r101, r102, r103, r104, r105, r110, r111, r112};
    }

    public static RunStatus[] values() {
        return (RunStatus[]) $VALUES.clone();
    }

    public static RunStatus valueOf(String r100) {
        return (RunStatus) a.a(RunStatus.class, r100);
    }

    private RunStatus(String r100, int r101) {
        super(r100, r101);
    }
}
