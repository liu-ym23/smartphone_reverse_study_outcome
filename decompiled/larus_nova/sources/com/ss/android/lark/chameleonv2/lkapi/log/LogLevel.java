package com.ss.android.lark.chameleonv2.lkapi.log;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/log/LogLevel;", "", "<init>", "(Ljava/lang/String;I)V", "INFO", "WARN", "ERROR", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum LogLevel extends Enum<LogLevel> {
    public static final LogLevel ERROR = null;
    public static final LogLevel INFO = null;
    public static final LogLevel WARN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LogLevel[] f411434a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f411435b = null;

    public static EnumEntries<LogLevel> getEntries() {
        return f411435b;
    }

    static {
        LogLevel r100 = new LogLevel("INFO", 0);
        INFO = r100;
        LogLevel r101 = new LogLevel("WARN", 1);
        WARN = r101;
        LogLevel r102 = new LogLevel("ERROR", 2);
        ERROR = r102;
        LogLevel[] r103 = {r100, r101, r102};
        f411434a = r103;
        f411435b = EnumEntriesKt.enumEntries(r103);
    }

    public static LogLevel[] values() {
        return (LogLevel[]) f411434a.clone();
    }

    public static LogLevel valueOf(String r100) {
        return (LogLevel) a.a(LogLevel.class, r100);
    }

    public LogLevel(String r100, int r101) {
        super(r100, r101);
    }
}
