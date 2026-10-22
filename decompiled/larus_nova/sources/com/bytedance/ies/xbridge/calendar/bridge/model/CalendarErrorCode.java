package com.bytedance.ies.xbridge.calendar.bridge.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0016\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ies/xbridge/calendar/bridge/model/CalendarErrorCode;", "", "", "value", "I", "getValue", "()I", "Failed", "UnauthorizedInvocation", "UnregisteredMethod", "InvalidParameter", "InvalidResult", "UserRejected", "UserDenied", "Success", "UnauthorizedAccess", "OperationCancelled", "OperationTimeout", "ArgumentError", "NoAccount", "NotFound", "NotImplemented", "AlreadyExists", "Unknown", "anniex-deprecated_release"}, k = 1, mv = {1, 4, 3})
public final enum CalendarErrorCode extends Enum<CalendarErrorCode> {
    public static final CalendarErrorCode AlreadyExists = null;
    public static final CalendarErrorCode ArgumentError = null;
    public static final CalendarErrorCode Failed = null;
    public static final CalendarErrorCode InvalidParameter = null;
    public static final CalendarErrorCode InvalidResult = null;
    public static final CalendarErrorCode NoAccount = null;
    public static final CalendarErrorCode NotFound = null;
    public static final CalendarErrorCode NotImplemented = null;
    public static final CalendarErrorCode OperationCancelled = null;
    public static final CalendarErrorCode OperationTimeout = null;
    public static final CalendarErrorCode Success = null;
    public static final CalendarErrorCode UnauthorizedAccess = null;
    public static final CalendarErrorCode UnauthorizedInvocation = null;
    public static final CalendarErrorCode Unknown = null;
    public static final CalendarErrorCode UnregisteredMethod = null;
    public static final CalendarErrorCode UserDenied = null;
    public static final CalendarErrorCode UserRejected = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CalendarErrorCode[] f249463a = null;
    private final int value;

    public static CalendarErrorCode valueOf(String r100) {
        return (CalendarErrorCode) a.a(CalendarErrorCode.class, r100);
    }

    public static CalendarErrorCode[] values() {
        return (CalendarErrorCode[]) f249463a.clone();
    }

    static {
        CalendarErrorCode r100 = new CalendarErrorCode("Failed", 0, 0);
        Failed = r100;
        CalendarErrorCode r101 = new CalendarErrorCode("UnauthorizedInvocation", 1, -1);
        UnauthorizedInvocation = r101;
        CalendarErrorCode r102 = new CalendarErrorCode("UnregisteredMethod", 2, -2);
        UnregisteredMethod = r102;
        CalendarErrorCode r103 = new CalendarErrorCode("InvalidParameter", 3, -3);
        InvalidParameter = r103;
        CalendarErrorCode r104 = new CalendarErrorCode("InvalidResult", 4, -5);
        InvalidResult = r104;
        CalendarErrorCode r105 = new CalendarErrorCode("UserRejected", 5, 2);
        UserRejected = r105;
        CalendarErrorCode r110 = new CalendarErrorCode("UserDenied", 6, 6);
        UserDenied = r110;
        CalendarErrorCode r111 = new CalendarErrorCode("Success", 7, 1);
        Success = r111;
        CalendarErrorCode r112 = new CalendarErrorCode("UnauthorizedAccess", 8, -6);
        UnauthorizedAccess = r112;
        CalendarErrorCode r113 = new CalendarErrorCode("OperationCancelled", 9, -7);
        OperationCancelled = r113;
        CalendarErrorCode r114 = new CalendarErrorCode("OperationTimeout", 10, -8);
        OperationTimeout = r114;
        CalendarErrorCode r106 = new CalendarErrorCode("ArgumentError", 11, 100);
        ArgumentError = r106;
        CalendarErrorCode r107 = new CalendarErrorCode("NoAccount", 12, 1000);
        NoAccount = r107;
        CalendarErrorCode r108 = new CalendarErrorCode("NotFound", 13, -9);
        NotFound = r108;
        CalendarErrorCode r109 = new CalendarErrorCode("NotImplemented", 14, -10);
        NotImplemented = r109;
        CalendarErrorCode r115 = new CalendarErrorCode("AlreadyExists", 15, -11);
        AlreadyExists = r115;
        CalendarErrorCode r116 = new CalendarErrorCode("Unknown", 16, -1000);
        Unknown = r116;
        f249463a = new CalendarErrorCode[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r106, r107, r108, r109, r115, r116};
    }

    public final int getValue() {
        return this.value;
    }

    public CalendarErrorCode(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
