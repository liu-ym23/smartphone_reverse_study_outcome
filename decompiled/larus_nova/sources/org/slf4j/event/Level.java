package org.slf4j.event;

/* JADX INFO: loaded from: classes42.dex */
public final enum Level extends Enum<Level> {
    public static final Level DEBUG = null;
    public static final Level ERROR = null;
    public static final Level INFO = null;
    public static final Level TRACE = null;
    public static final Level WARN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Level[] f526215a = null;
    private final int levelInt;
    private final String levelStr;

    static {
        Level r100 = new Level("ERROR", 0, 40, "ERROR");
        ERROR = r100;
        Level r101 = new Level("WARN", 1, 30, "WARN");
        WARN = r101;
        Level r102 = new Level("INFO", 2, 20, "INFO");
        INFO = r102;
        Level r103 = new Level("DEBUG", 3, 10, "DEBUG");
        DEBUG = r103;
        Level r104 = new Level("TRACE", 4, 0, "TRACE");
        TRACE = r104;
        f526215a = new Level[]{r100, r101, r102, r103, r104};
    }

    public static Level[] values() {
        return (Level[]) f526215a.clone();
    }

    public int toInt() {
        return this.levelInt;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.levelStr;
    }

    public static Level intToLevel(int r100) {
        if (r100 == 0) goto L22;
        if (r100 == 10) goto L20;
        if (r100 == 20) goto L18;
        if (r100 == 30) goto L16;
        if (r100 != 40) goto L14;
        return ERROR;
    L14:
        throw new IllegalArgumentException("Level integer [" + r100 + "] not recognized.");
    L16:
        return WARN;
    L18:
        return INFO;
    L20:
        return DEBUG;
    L22:
        return TRACE;
    }

    public static Level valueOf(String r100) {
        return (Level) r27.a.a(Level.class, r100);
    }

    public Level(String r100, int r101, int r102, String r103) {
        super(r100, r101);
        this.levelInt = r102;
        this.levelStr = r103;
    }
}
