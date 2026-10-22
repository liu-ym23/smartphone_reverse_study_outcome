package com.ss.android.lark.log;

/* JADX INFO: loaded from: classes36.dex */
public final enum LogLevel extends Enum<LogLevel> {
    public static final LogLevel ASSERT = null;
    public static final LogLevel DEBUG = null;
    public static final LogLevel ERROR = null;
    public static final LogLevel INFO = null;
    public static final LogLevel VERBOSE = null;
    public static final LogLevel WARN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LogLevel[] f431381a = null;
    private int value;

    static {
        LogLevel r100 = new LogLevel("VERBOSE", 0, 2);
        VERBOSE = r100;
        LogLevel r101 = new LogLevel("DEBUG", 1, 3);
        DEBUG = r101;
        LogLevel r102 = new LogLevel("INFO", 2, 4);
        INFO = r102;
        LogLevel r103 = new LogLevel("WARN", 3, 5);
        WARN = r103;
        LogLevel r104 = new LogLevel("ERROR", 4, 6);
        ERROR = r104;
        LogLevel r110 = new LogLevel("ASSERT", 5, 7);
        ASSERT = r110;
        f431381a = new LogLevel[]{r100, r101, r102, r103, r104, r110};
    }

    public static LogLevel[] values() {
        return (LogLevel[]) f431381a.clone();
    }

    public int getNumber() {
        return this.value;
    }

    public static LogLevel forNumber(int r100) {
        switch(r100) {
            case 2: goto L16;
            case 3: goto L14;
            case 4: goto L12;
            case 5: goto L10;
            case 6: goto L8;
            case 7: goto L6;
            default: goto L4;
        };
    L4:
        return VERBOSE;
    L6:
        return ASSERT;
    L8:
        return ERROR;
    L10:
        return WARN;
    L12:
        return INFO;
    L14:
        return DEBUG;
    L16:
        return VERBOSE;
    }

    public static LogLevel valueOf(String r100) {
        return (LogLevel) r27.a.a(LogLevel.class, r100);
    }

    public static LogLevel valueOf(int r100) {
        return forNumber(r100);
    }

    public LogLevel(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
