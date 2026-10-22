package com.suite.component.logger.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lcom/suite/component/logger/api/LogLevel;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "VERBOSE", "DEBUG", "INFO", "WARN", "ERROR", "ASSERT", "Companion", "logger-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum LogLevel extends Enum<LogLevel> {
    public static final LogLevel ASSERT = null;
    public static final a Companion = null;
    public static final LogLevel DEBUG = null;
    public static final LogLevel ERROR = null;
    public static final LogLevel INFO = null;
    public static final LogLevel VERBOSE = null;
    public static final LogLevel WARN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LogLevel[] f460097a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f460098b = null;
    private final int value;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static LogLevel a(int r100) {
            switch(r100) {
                case 2: goto L10;
                case 3: goto L16;
                case 4: goto L15;
                case 5: goto L14;
                case 6: goto L13;
                case 7: goto L12;
                default: goto L11;
            };
        L11:
            return LogLevel.INFO;
        L12:
            return LogLevel.ASSERT;
        L13:
            return LogLevel.ERROR;
        L14:
            return LogLevel.WARN;
        L15:
            return LogLevel.INFO;
        L16:
            return LogLevel.DEBUG;
        L10:
            return LogLevel.VERBOSE;
        }
    }

    @JvmStatic
    public static final LogLevel fromValue(int r100) {
        Companion.getClass();
        return a.a(r100);
    }

    public static EnumEntries<LogLevel> getEntries() {
        return f460098b;
    }

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
        LogLevel[] r111 = {r100, r101, r102, r103, r104, r110};
        f460097a = r111;
        f460098b = EnumEntriesKt.enumEntries(r111);
        Companion = new a();
    }

    public static LogLevel[] values() {
        return (LogLevel[]) f460097a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static LogLevel valueOf(String r100) {
        return (LogLevel) r27.a.a(LogLevel.class, r100);
    }

    public LogLevel(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
