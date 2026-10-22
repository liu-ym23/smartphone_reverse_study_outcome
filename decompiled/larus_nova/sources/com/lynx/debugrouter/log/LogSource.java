package com.lynx.debugrouter.log;

import r27.a;

/* JADX INFO: loaded from: classes32.dex */
public final enum LogSource extends Enum<LogSource> {
    private static final /* synthetic */ LogSource[] $VALUES = null;
    public static final LogSource JAVA = null;
    public static final LogSource Native = null;

    static {
        LogSource r100 = new LogSource("Native", 0);
        Native = r100;
        LogSource r101 = new LogSource("JAVA", 1);
        JAVA = r101;
        $VALUES = new LogSource[]{r100, r101};
    }

    public static LogSource[] values() {
        return (LogSource[]) $VALUES.clone();
    }

    public static LogSource valueOf(String r100) {
        return (LogSource) a.a(LogSource.class, r100);
    }

    private LogSource(String r100, int r101) {
        super(r100, r101);
    }
}
