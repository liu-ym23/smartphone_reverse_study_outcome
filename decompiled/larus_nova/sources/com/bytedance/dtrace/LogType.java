package com.bytedance.dtrace;

import r27.a;

/* JADX INFO: loaded from: classes15.dex */
public final enum LogType extends Enum<LogType> {
    private static final /* synthetic */ LogType[] $VALUES = null;
    public static final LogType ArgsContext = null;
    public static final LogType ExceptionInject = null;
    public static final LogType Stack = null;
    public static final LogType TrackingPoint = null;
    public static final LogType ViewTree = null;
    private final int value;

    static {
        LogType r100 = new LogType("ArgsContext", 0, 1);
        ArgsContext = r100;
        LogType r101 = new LogType("Stack", 1, 2);
        Stack = r101;
        LogType r102 = new LogType("ViewTree", 2, 4);
        ViewTree = r102;
        LogType r103 = new LogType("ExceptionInject", 3, 8);
        ExceptionInject = r103;
        LogType r104 = new LogType("TrackingPoint", 4, 16);
        TrackingPoint = r104;
        $VALUES = new LogType[]{r100, r101, r102, r103, r104};
    }

    private LogType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }

    public static boolean hasLogType(int r100, LogType r101) {
        if ((r100 & r101.getValue()) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static LogType valueOf(String r100) {
        return (LogType) a.a(LogType.class, r100);
    }

    public static LogType[] values() {
        return (LogType[]) $VALUES.clone();
    }

    public int getValue() {
        return this.value;
    }
}
