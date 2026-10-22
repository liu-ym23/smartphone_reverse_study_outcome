package com.bytedance.sdk.xbridge.cn.auth.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import r27.a;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016¨\u0006\u0017"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/auth/bean/AuthSuccessCode;", "", "", "code", "I", "getCode", "()I", "", "msg", "Ljava/lang/String;", "getMsg", "()Ljava/lang/String;", "UN_SET", "LEGACY_PUBLIC_METHOD", "LEGACY_PRIVATE_DOMAINS", "METHOD_NOT_FOUND", "DISABLE_AUTH", "MATCH_RECOVERY_CONFIG", "LATCH_SKIP_AUTH", "REQUEST_CHECK_PASSED", "NO_AUTH_PACKAGE", "LOGIC_ERROR", "REQUEST_CHECK_WARNING", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum AuthSuccessCode extends Enum<AuthSuccessCode> {
    public static final AuthSuccessCode DISABLE_AUTH = null;
    public static final AuthSuccessCode LATCH_SKIP_AUTH = null;
    public static final AuthSuccessCode LEGACY_PRIVATE_DOMAINS = null;
    public static final AuthSuccessCode LEGACY_PUBLIC_METHOD = null;
    public static final AuthSuccessCode LOGIC_ERROR = null;
    public static final AuthSuccessCode MATCH_RECOVERY_CONFIG = null;
    public static final AuthSuccessCode METHOD_NOT_FOUND = null;
    public static final AuthSuccessCode NO_AUTH_PACKAGE = null;
    public static final AuthSuccessCode REQUEST_CHECK_PASSED = null;
    public static final AuthSuccessCode REQUEST_CHECK_WARNING = null;
    public static final AuthSuccessCode UN_SET = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AuthSuccessCode[] f269825a = null;
    private final int code;
    private final String msg;

    public static AuthSuccessCode valueOf(String r100) {
        return (AuthSuccessCode) a.a(AuthSuccessCode.class, r100);
    }

    public static AuthSuccessCode[] values() {
        return (AuthSuccessCode[]) f269825a.clone();
    }

    static {
        AuthSuccessCode r100 = new AuthSuccessCode("UN_SET", 0, 0, null, 2, null);
        UN_SET = r100;
        String r110 = null;
        int r111 = 2;
        DefaultConstructorMarker r112 = null;
        AuthSuccessCode r101 = new AuthSuccessCode("LEGACY_PUBLIC_METHOD", 1, 1, r110, r111, r112);
        LEGACY_PUBLIC_METHOD = r101;
        AuthSuccessCode r102 = new AuthSuccessCode("LEGACY_PRIVATE_DOMAINS", 2, 2, null, 2, null);
        LEGACY_PRIVATE_DOMAINS = r102;
        AuthSuccessCode r103 = new AuthSuccessCode("METHOD_NOT_FOUND", 3, 3, r110, r111, r112);
        METHOD_NOT_FOUND = r103;
        AuthSuccessCode r104 = new AuthSuccessCode("DISABLE_AUTH", 4, 9, "XBridge disable auth");
        DISABLE_AUTH = r104;
        AuthSuccessCode r105 = new AuthSuccessCode("MATCH_RECOVERY_CONFIG", 5, 10, "recovery over auth");
        MATCH_RECOVERY_CONFIG = r105;
        AuthSuccessCode r106 = new AuthSuccessCode("LATCH_SKIP_AUTH", 6, 11, "latch skip auth");
        LATCH_SKIP_AUTH = r106;
        AuthSuccessCode r107 = new AuthSuccessCode("REQUEST_CHECK_PASSED", 7, 17, "success_request_parameters_check_passed");
        REQUEST_CHECK_PASSED = r107;
        AuthSuccessCode r113 = new AuthSuccessCode("NO_AUTH_PACKAGE", 8, 101, "all permission config not found");
        NO_AUTH_PACKAGE = r113;
        AuthSuccessCode r114 = new AuthSuccessCode("LOGIC_ERROR", 9, 102, "unexpected error");
        LOGIC_ERROR = r114;
        AuthSuccessCode r108 = new AuthSuccessCode("REQUEST_CHECK_WARNING", 10, 103, "success_request_parameters_warn");
        REQUEST_CHECK_WARNING = r108;
        f269825a = new AuthSuccessCode[]{r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r108};
    }

    public final int getCode() {
        return this.code;
    }

    public final String getMsg() {
        return this.msg;
    }

    public AuthSuccessCode(String r100, int r101, int r102, String r103) {
        super(r100, r101);
        this.code = r102;
        this.msg = r103;
    }

    public /* synthetic */ AuthSuccessCode(String r100, int r101, int r102, String r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 2) == 0) goto L5;
        r103 = null;
    L5:
        this(r100, r101, r102, r103);
    }
}
