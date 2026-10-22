package com.bytedance.timon.calendar;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/timon/calendar/ResultCode;", "", "", "value", "I", "getValue", "()I", "Unknown", "Success", "NoPermission", "ArgumentError", "NoAccount", "NotFound", "StoreError", "NoRequestPermissionInvoker", "permission-keeper-calendar_release"}, k = 1, mv = {1, 7, 1})
public final enum ResultCode extends Enum<ResultCode> {
    public static final ResultCode ArgumentError = null;
    public static final ResultCode NoAccount = null;
    public static final ResultCode NoPermission = null;
    public static final ResultCode NoRequestPermissionInvoker = null;
    public static final ResultCode NotFound = null;
    public static final ResultCode StoreError = null;
    public static final ResultCode Success = null;
    public static final ResultCode Unknown = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ResultCode[] f270567a = null;
    private final int value;

    public static ResultCode valueOf(String r100) {
        return (ResultCode) r27.a.a(ResultCode.class, r100);
    }

    public static ResultCode[] values() {
        return (ResultCode[]) f270567a.clone();
    }

    static {
        ResultCode r100 = new ResultCode("Unknown", 0, -1);
        Unknown = r100;
        ResultCode r101 = new ResultCode("Success", 1, 1);
        Success = r101;
        ResultCode r102 = new ResultCode("NoPermission", 2, 10000);
        NoPermission = r102;
        ResultCode r103 = new ResultCode("ArgumentError", 3, 10001);
        ArgumentError = r103;
        ResultCode r104 = new ResultCode("NoAccount", 4, 10002);
        NoAccount = r104;
        ResultCode r105 = new ResultCode("NotFound", 5, 10003);
        NotFound = r105;
        ResultCode r110 = new ResultCode("StoreError", 6, 10004);
        StoreError = r110;
        ResultCode r111 = new ResultCode("NoRequestPermissionInvoker", 7, 10005);
        NoRequestPermissionInvoker = r111;
        f270567a = new ResultCode[]{r100, r101, r102, r103, r104, r105, r110, r111};
    }

    public final int getValue() {
        return this.value;
    }

    public ResultCode(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
