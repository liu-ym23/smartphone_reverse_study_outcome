package com.lynx.devtoolwrapper;

/* JADX INFO: loaded from: classes32.dex */
public final enum LogBoxLogLevel extends Enum<LogBoxLogLevel> {
    private static final /* synthetic */ LogBoxLogLevel[] $VALUES = null;
    public static final LogBoxLogLevel Error = null;
    public static final LogBoxLogLevel Info = null;
    public static final LogBoxLogLevel Warn = null;
    public final String value;

    static {
        LogBoxLogLevel r100 = new LogBoxLogLevel("Info", 0, "info");
        Info = r100;
        LogBoxLogLevel r101 = new LogBoxLogLevel("Warn", 1, "warn");
        Warn = r101;
        LogBoxLogLevel r102 = new LogBoxLogLevel("Error", 2, "error");
        Error = r102;
        $VALUES = new LogBoxLogLevel[]{r100, r101, r102};
    }

    public static LogBoxLogLevel[] values() {
        return (LogBoxLogLevel[]) $VALUES.clone();
    }

    public static LogBoxLogLevel valueOf(String r100) {
        return (LogBoxLogLevel) r27.a.a(LogBoxLogLevel.class, r100);
    }

    private LogBoxLogLevel(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
