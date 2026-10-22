package com.ss.android.rust.molten.ffi;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/ss/android/rust/molten/ffi/LogLevel;", "", "index", "", "<init>", "(Ljava/lang/String;II)V", "getIndex", "()I", "Fatal", "Error", "Warn", "Info", "Debug", "Trace", "molten-log_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum LogLevel extends Enum<LogLevel> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ LogLevel[] $VALUES = null;
    public static final LogLevel Debug = null;
    public static final LogLevel Error = null;
    public static final LogLevel Fatal = null;
    public static final LogLevel Info = null;
    public static final LogLevel Trace = null;
    public static final LogLevel Warn = null;
    private final int index;

    private static final /* synthetic */ LogLevel[] $values() {
        return new LogLevel[]{Fatal, Error, Warn, Info, Debug, Trace};
    }

    public static EnumEntries<LogLevel> getEntries() {
        return $ENTRIES;
    }

    static {
        Fatal = new LogLevel("Fatal", 0, 6);
        Error = new LogLevel("Error", 1, 5);
        Warn = new LogLevel("Warn", 2, 4);
        Info = new LogLevel("Info", 3, 3);
        Debug = new LogLevel("Debug", 4, 2);
        Trace = new LogLevel("Trace", 5, 1);
        LogLevel[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static LogLevel[] values() {
        return (LogLevel[]) $VALUES.clone();
    }

    public final int getIndex() {
        return this.index;
    }

    public static LogLevel valueOf(String r100) {
        return (LogLevel) a.a(LogLevel.class, r100);
    }

    private LogLevel(String r100, int r101, int r102) {
        super(r100, r101);
        this.index = r102;
    }
}
