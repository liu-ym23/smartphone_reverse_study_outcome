package com.larus.calendar;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/calendar/ErrorCode;", "", "<init>", "(Ljava/lang/String;I)V", "ArgumentError", "NoPermission", "AlreadyExists", "NoAccount", "Unknown", "Success", "NotFound", "NotGetId", "calendar_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ErrorCode extends Enum<ErrorCode> {
    public static final ErrorCode AlreadyExists = null;
    public static final ErrorCode ArgumentError = null;
    public static final ErrorCode NoAccount = null;
    public static final ErrorCode NoPermission = null;
    public static final ErrorCode NotFound = null;
    public static final ErrorCode NotGetId = null;
    public static final ErrorCode Success = null;
    public static final ErrorCode Unknown = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ErrorCode[] f321322a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f321323b = null;

    public static EnumEntries<ErrorCode> getEntries() {
        return f321323b;
    }

    static {
        ErrorCode r100 = new ErrorCode("ArgumentError", 0);
        ArgumentError = r100;
        ErrorCode r101 = new ErrorCode("NoPermission", 1);
        NoPermission = r101;
        ErrorCode r102 = new ErrorCode("AlreadyExists", 2);
        AlreadyExists = r102;
        ErrorCode r103 = new ErrorCode("NoAccount", 3);
        NoAccount = r103;
        ErrorCode r104 = new ErrorCode("Unknown", 4);
        Unknown = r104;
        ErrorCode r105 = new ErrorCode("Success", 5);
        Success = r105;
        ErrorCode r110 = new ErrorCode("NotFound", 6);
        NotFound = r110;
        ErrorCode r111 = new ErrorCode("NotGetId", 7);
        NotGetId = r111;
        ErrorCode[] r112 = {r100, r101, r102, r103, r104, r105, r110, r111};
        f321322a = r112;
        f321323b = EnumEntriesKt.enumEntries(r112);
    }

    public static ErrorCode[] values() {
        return (ErrorCode[]) f321322a.clone();
    }

    public static ErrorCode valueOf(String r100) {
        return (ErrorCode) r27.a.a(ErrorCode.class, r100);
    }

    public ErrorCode(String r100, int r101) {
        super(r100, r101);
    }
}
