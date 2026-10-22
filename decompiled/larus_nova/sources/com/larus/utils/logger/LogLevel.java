package com.larus.utils.logger;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/utils/logger/LogLevel;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "DEBUG", "INFO", "WARN", "ERROR", "utils_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum LogLevel extends Enum<LogLevel> {
    public static final LogLevel DEBUG = null;
    public static final LogLevel ERROR = null;
    public static final LogLevel INFO = null;
    public static final LogLevel WARN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LogLevel[] f375448a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f375449b = null;
    private final String value;

    public static EnumEntries<LogLevel> getEntries() {
        return f375449b;
    }

    static {
        LogLevel r100 = new LogLevel("DEBUG", 0, "D");
        DEBUG = r100;
        LogLevel r101 = new LogLevel("INFO", 1, "I");
        INFO = r101;
        LogLevel r102 = new LogLevel("WARN", 2, ExifInterface.LONGITUDE_WEST);
        WARN = r102;
        LogLevel r103 = new LogLevel("ERROR", 3, ExifInterface.LONGITUDE_EAST);
        ERROR = r103;
        LogLevel[] r104 = {r100, r101, r102, r103};
        f375448a = r104;
        f375449b = EnumEntriesKt.enumEntries(r104);
    }

    public static LogLevel[] values() {
        return (LogLevel[]) f375448a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static LogLevel valueOf(String r100) {
        return (LogLevel) a.a(LogLevel.class, r100);
    }

    public LogLevel(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
