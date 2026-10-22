package com.lark.kmp.logger;

import com.bytedance.speech.speechengine.SpeechEngineDefines;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/lark/kmp/logger/LogLevel;", "", "<init>", "(Ljava/lang/String;I)V", "STUB", "VERB", "DEBUG", "INFO", "WARN", "ERROR", SpeechEngineDefines.LOG_LEVEL_FATAL, "lark-logger-kmp_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum LogLevel extends Enum<LogLevel> {
    public static final LogLevel DEBUG = null;
    public static final LogLevel ERROR = null;
    public static final LogLevel FATAL = null;
    public static final LogLevel INFO = null;
    public static final LogLevel STUB = null;
    public static final LogLevel VERB = null;
    public static final LogLevel WARN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LogLevel[] f278609a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f278610b = null;

    public static EnumEntries<LogLevel> getEntries() {
        return f278610b;
    }

    static {
        LogLevel r100 = new LogLevel("STUB", 0);
        STUB = r100;
        LogLevel r101 = new LogLevel("VERB", 1);
        VERB = r101;
        LogLevel r102 = new LogLevel("DEBUG", 2);
        DEBUG = r102;
        LogLevel r103 = new LogLevel("INFO", 3);
        INFO = r103;
        LogLevel r104 = new LogLevel("WARN", 4);
        WARN = r104;
        LogLevel r105 = new LogLevel("ERROR", 5);
        ERROR = r105;
        LogLevel r110 = new LogLevel(SpeechEngineDefines.LOG_LEVEL_FATAL, 6);
        FATAL = r110;
        LogLevel[] r111 = {r100, r101, r102, r103, r104, r105, r110};
        f278609a = r111;
        f278610b = EnumEntriesKt.enumEntries(r111);
    }

    public static LogLevel[] values() {
        return (LogLevel[]) f278609a.clone();
    }

    public static LogLevel valueOf(String r100) {
        return (LogLevel) a.a(LogLevel.class, r100);
    }

    public LogLevel(String r100, int r101) {
        super(r100, r101);
    }
}
