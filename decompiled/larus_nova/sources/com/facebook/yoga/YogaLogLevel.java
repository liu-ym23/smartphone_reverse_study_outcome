package com.facebook.yoga;

import com.bytedance.speech.speechengine.SpeechEngineDefines;

/* JADX INFO: loaded from: classes23.dex */
public final enum YogaLogLevel extends Enum<YogaLogLevel> {
    private static final /* synthetic */ YogaLogLevel[] $VALUES = null;
    public static final YogaLogLevel DEBUG = null;
    public static final YogaLogLevel ERROR = null;
    public static final YogaLogLevel FATAL = null;
    public static final YogaLogLevel INFO = null;
    public static final YogaLogLevel VERBOSE = null;
    public static final YogaLogLevel WARN = null;
    private final int mIntValue;

    private static /* synthetic */ YogaLogLevel[] $values() {
        return new YogaLogLevel[]{ERROR, WARN, INFO, DEBUG, VERBOSE, FATAL};
    }

    static {
        ERROR = new YogaLogLevel("ERROR", 0, 0);
        WARN = new YogaLogLevel("WARN", 1, 1);
        INFO = new YogaLogLevel("INFO", 2, 2);
        DEBUG = new YogaLogLevel("DEBUG", 3, 3);
        VERBOSE = new YogaLogLevel("VERBOSE", 4, 4);
        FATAL = new YogaLogLevel(SpeechEngineDefines.LOG_LEVEL_FATAL, 5, 5);
        $VALUES = $values();
    }

    public static YogaLogLevel[] values() {
        return (YogaLogLevel[]) $VALUES.clone();
    }

    public int intValue() {
        return this.mIntValue;
    }

    public static YogaLogLevel fromInt(int r100) {
        if (r100 == 0) goto L26;
        if (r100 == 1) goto L24;
        if (r100 == 2) goto L22;
        if (r100 == 3) goto L20;
        if (r100 == 4) goto L18;
        if (r100 != 5) goto L16;
        return FATAL;
    L16:
        throw new IllegalArgumentException("Unknown enum value: " + r100);
    L18:
        return VERBOSE;
    L20:
        return DEBUG;
    L22:
        return INFO;
    L24:
        return WARN;
    L26:
        return ERROR;
    }

    public static YogaLogLevel valueOf(String r100) {
        return (YogaLogLevel) Enum.valueOf(YogaLogLevel.class, r100);
    }

    private YogaLogLevel(String r100, int r101, int r102) {
        super(r100, r101);
        this.mIntValue = r102;
    }
}
