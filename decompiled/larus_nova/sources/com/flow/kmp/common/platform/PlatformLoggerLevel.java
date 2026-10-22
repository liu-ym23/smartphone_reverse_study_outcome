package com.flow.kmp.common.platform;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/flow/kmp/common/platform/PlatformLoggerLevel;", "", "<init>", "(Ljava/lang/String;I)V", "DEBUG", "INFO", "WARN", "ERROR", "kmp_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PlatformLoggerLevel extends Enum<PlatformLoggerLevel> {
    public static final PlatformLoggerLevel DEBUG = null;
    public static final PlatformLoggerLevel ERROR = null;
    public static final PlatformLoggerLevel INFO = null;
    public static final PlatformLoggerLevel WARN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PlatformLoggerLevel[] f274140a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f274141b = null;

    public static EnumEntries<PlatformLoggerLevel> getEntries() {
        return f274141b;
    }

    static {
        PlatformLoggerLevel r100 = new PlatformLoggerLevel("DEBUG", 0);
        DEBUG = r100;
        PlatformLoggerLevel r101 = new PlatformLoggerLevel("INFO", 1);
        INFO = r101;
        PlatformLoggerLevel r102 = new PlatformLoggerLevel("WARN", 2);
        WARN = r102;
        PlatformLoggerLevel r103 = new PlatformLoggerLevel("ERROR", 3);
        ERROR = r103;
        PlatformLoggerLevel[] r104 = {r100, r101, r102, r103};
        f274140a = r104;
        f274141b = EnumEntriesKt.enumEntries(r104);
    }

    public static PlatformLoggerLevel[] values() {
        return (PlatformLoggerLevel[]) f274140a.clone();
    }

    public static PlatformLoggerLevel valueOf(String r100) {
        return (PlatformLoggerLevel) a.a(PlatformLoggerLevel.class, r100);
    }

    public PlatformLoggerLevel(String r100, int r101) {
        super(r100, r101);
    }
}
