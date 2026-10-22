package com.lynx.tasm;

import com.bytedance.speech.speechengine.SpeechEngineDefines;

/* JADX INFO: loaded from: classes32.dex */
final enum LynxSubErrorCode$Level extends Enum<LynxSubErrorCode$Level> {
    public static final LynxSubErrorCode$Level ERROR = null;
    public static final LynxSubErrorCode$Level FATAL = null;
    public static final LynxSubErrorCode$Level UNDECIDED = null;
    public static final LynxSubErrorCode$Level WARN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LynxSubErrorCode$Level[] f381673a = null;
    public final String value;

    static {
        LynxSubErrorCode$Level r100 = new LynxSubErrorCode$Level(SpeechEngineDefines.LOG_LEVEL_FATAL, 0, "fatal");
        FATAL = r100;
        LynxSubErrorCode$Level r101 = new LynxSubErrorCode$Level("ERROR", 1, "error");
        ERROR = r101;
        LynxSubErrorCode$Level r102 = new LynxSubErrorCode$Level("WARN", 2, "warn");
        WARN = r102;
        LynxSubErrorCode$Level r103 = new LynxSubErrorCode$Level("UNDECIDED", 3, "undecided");
        UNDECIDED = r103;
        f381673a = new LynxSubErrorCode$Level[]{r100, r101, r102, r103};
    }

    public static LynxSubErrorCode$Level[] values() {
        return (LynxSubErrorCode$Level[]) f381673a.clone();
    }

    public static LynxSubErrorCode$Level valueOf(String r100) {
        return (LynxSubErrorCode$Level) r27.a.a(LynxSubErrorCode$Level.class, r100);
    }

    public LynxSubErrorCode$Level(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
