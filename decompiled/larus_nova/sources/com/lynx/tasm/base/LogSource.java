package com.lynx.tasm.base;

/* JADX INFO: loaded from: classes32.dex */
public final enum LogSource extends Enum<LogSource> {
    private static final /* synthetic */ LogSource[] $VALUES = null;
    public static final LogSource JAVA = null;
    public static final LogSource JS = null;
    public static final LogSource JS_EXT = null;
    public static final LogSource Native = null;

    static {
        LogSource r100 = new LogSource("Native", 0);
        Native = r100;
        LogSource r101 = new LogSource("JS", 1);
        JS = r101;
        LogSource r102 = new LogSource("JS_EXT", 2);
        JS_EXT = r102;
        LogSource r103 = new LogSource("JAVA", 3);
        JAVA = r103;
        $VALUES = new LogSource[]{r100, r101, r102, r103};
    }

    public static LogSource[] values() {
        return (LogSource[]) $VALUES.clone();
    }

    public static LogSource valueOf(String r100) {
        return (LogSource) r27.a.a(LogSource.class, r100);
    }

    private LogSource(String r100, int r101) {
        super(r100, r101);
    }
}
