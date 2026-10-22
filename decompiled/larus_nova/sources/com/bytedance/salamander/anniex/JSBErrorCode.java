package com.bytedance.salamander.anniex;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0015\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016¨\u0006\u0017"}, d2 = {"Lcom/bytedance/salamander/anniex/JSBErrorCode;", "", "", "value", "I", "getValue", "()I", "SUCCESS", "FAIL", "UNAUTHORIZED", "UNREGISTERED", "INVALID_PARAM", "UNKNOWN_HOST", "INVALID_RESULT", "UNAUTHORIZED_ACCESS", "CANCELLED", "OPERATION_TIMEOUT", "NOT_FOUND", "IDL_ERROR", "HANDLE_ERROR", "EXCEPTION_THROWN", "UNKNOWN_ERROR", "NETWORK_UNREACHABLE", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum JSBErrorCode extends Enum<JSBErrorCode> {
    public static final JSBErrorCode CANCELLED = null;
    public static final JSBErrorCode EXCEPTION_THROWN = null;
    public static final JSBErrorCode FAIL = null;
    public static final JSBErrorCode HANDLE_ERROR = null;
    public static final JSBErrorCode IDL_ERROR = null;
    public static final JSBErrorCode INVALID_PARAM = null;
    public static final JSBErrorCode INVALID_RESULT = null;
    public static final JSBErrorCode NETWORK_UNREACHABLE = null;
    public static final JSBErrorCode NOT_FOUND = null;
    public static final JSBErrorCode OPERATION_TIMEOUT = null;
    public static final JSBErrorCode SUCCESS = null;
    public static final JSBErrorCode UNAUTHORIZED = null;
    public static final JSBErrorCode UNAUTHORIZED_ACCESS = null;
    public static final JSBErrorCode UNKNOWN_ERROR = null;
    public static final JSBErrorCode UNKNOWN_HOST = null;
    public static final JSBErrorCode UNREGISTERED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ JSBErrorCode[] f267885a = null;
    private final int value;

    public static JSBErrorCode valueOf(String r100) {
        return (JSBErrorCode) r27.a.a(JSBErrorCode.class, r100);
    }

    public static JSBErrorCode[] values() {
        return (JSBErrorCode[]) f267885a.clone();
    }

    static {
        JSBErrorCode r100 = new JSBErrorCode("SUCCESS", 0, 1);
        SUCCESS = r100;
        JSBErrorCode r101 = new JSBErrorCode("FAIL", 1, 0);
        FAIL = r101;
        JSBErrorCode r102 = new JSBErrorCode("UNAUTHORIZED", 2, -1);
        UNAUTHORIZED = r102;
        JSBErrorCode r103 = new JSBErrorCode("UNREGISTERED", 3, -2);
        UNREGISTERED = r103;
        JSBErrorCode r104 = new JSBErrorCode("INVALID_PARAM", 4, -3);
        INVALID_PARAM = r104;
        JSBErrorCode r105 = new JSBErrorCode("UNKNOWN_HOST", 5, -4);
        UNKNOWN_HOST = r105;
        JSBErrorCode r110 = new JSBErrorCode("INVALID_RESULT", 6, -5);
        INVALID_RESULT = r110;
        JSBErrorCode r111 = new JSBErrorCode("UNAUTHORIZED_ACCESS", 7, -6);
        UNAUTHORIZED_ACCESS = r111;
        JSBErrorCode r112 = new JSBErrorCode("CANCELLED", 8, -7);
        CANCELLED = r112;
        JSBErrorCode r113 = new JSBErrorCode("OPERATION_TIMEOUT", 9, -8);
        OPERATION_TIMEOUT = r113;
        JSBErrorCode r114 = new JSBErrorCode("NOT_FOUND", 10, -9);
        NOT_FOUND = r114;
        JSBErrorCode r106 = new JSBErrorCode("IDL_ERROR", 11, -10);
        IDL_ERROR = r106;
        JSBErrorCode r107 = new JSBErrorCode("HANDLE_ERROR", 12, -11);
        HANDLE_ERROR = r107;
        JSBErrorCode r108 = new JSBErrorCode("EXCEPTION_THROWN", 13, -999);
        EXCEPTION_THROWN = r108;
        JSBErrorCode r109 = new JSBErrorCode("UNKNOWN_ERROR", 14, -1000);
        UNKNOWN_ERROR = r109;
        JSBErrorCode r115 = new JSBErrorCode("NETWORK_UNREACHABLE", 15, -1001);
        NETWORK_UNREACHABLE = r115;
        f267885a = new JSBErrorCode[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r106, r107, r108, r109, r115};
    }

    public final int getValue() {
        return this.value;
    }

    public JSBErrorCode(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
