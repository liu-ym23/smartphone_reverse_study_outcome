package com.bytedance.sdk.xbridge.cn.auth.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import r27.a;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017¨\u0006\u0018"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/auth/bean/AuthErrorCode;", "", "", "code", "I", "getCode", "()I", "", "msg", "Ljava/lang/String;", "getMsg", "()Ljava/lang/String;", "NO_FE_ID_CONFIG", "NOT_IN_SAFE_URl", "IN_EXCLUDE_METHODS", "SECURE_NOT_INCLUDE", "RULE_DENY_NOT_INCLUDE", "WEB_BOT_IN_URL", "OVER_CALL_FREQ", "OVER_CALL_TIMES", "UN_KNOWN", "URL_EMPTY", "REQUEST_CHECK_DENY", "BLOCK_BY_BIZ_SERVICE", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum AuthErrorCode extends Enum<AuthErrorCode> {
    public static final AuthErrorCode BLOCK_BY_BIZ_SERVICE = null;
    public static final AuthErrorCode IN_EXCLUDE_METHODS = null;
    public static final AuthErrorCode NOT_IN_SAFE_URl = null;
    public static final AuthErrorCode NO_FE_ID_CONFIG = null;
    public static final AuthErrorCode OVER_CALL_FREQ = null;
    public static final AuthErrorCode OVER_CALL_TIMES = null;
    public static final AuthErrorCode REQUEST_CHECK_DENY = null;
    public static final AuthErrorCode RULE_DENY_NOT_INCLUDE = null;
    public static final AuthErrorCode SECURE_NOT_INCLUDE = null;
    public static final AuthErrorCode UN_KNOWN = null;
    public static final AuthErrorCode URL_EMPTY = null;
    public static final AuthErrorCode WEB_BOT_IN_URL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AuthErrorCode[] f269822a = null;
    private final int code;
    private final String msg;

    public static AuthErrorCode valueOf(String r100) {
        return (AuthErrorCode) a.a(AuthErrorCode.class, r100);
    }

    public static AuthErrorCode[] values() {
        return (AuthErrorCode[]) f269822a.clone();
    }

    static {
        AuthErrorCode r100 = new AuthErrorCode("NO_FE_ID_CONFIG", 0, -1, "app id is not legal");
        NO_FE_ID_CONFIG = r100;
        AuthErrorCode r101 = new AuthErrorCode("NOT_IN_SAFE_URl", 1, -2, "not in safe url");
        NOT_IN_SAFE_URl = r101;
        AuthErrorCode r102 = new AuthErrorCode("IN_EXCLUDE_METHODS", 2, -3, "method in exclude methods");
        IN_EXCLUDE_METHODS = r102;
        AuthErrorCode r103 = new AuthErrorCode("SECURE_NOT_INCLUDE", 3, -4, "method is secure,and not in include method,fail");
        SECURE_NOT_INCLUDE = r103;
        AuthErrorCode r104 = new AuthErrorCode("RULE_DENY_NOT_INCLUDE", 4, -5, "method < rule");
        RULE_DENY_NOT_INCLUDE = r104;
        AuthErrorCode r105 = new AuthErrorCode("WEB_BOT_IN_URL", 5, -6, "auth url is not in method secure url");
        WEB_BOT_IN_URL = r105;
        AuthErrorCode r106 = new AuthErrorCode("OVER_CALL_FREQ", 6, -7, "jsb call over call freq limits");
        OVER_CALL_FREQ = r106;
        AuthErrorCode r110 = new AuthErrorCode("OVER_CALL_TIMES", 7, -8, "jsb call over call times limits");
        OVER_CALL_TIMES = r110;
        AuthErrorCode r111 = new AuthErrorCode("UN_KNOWN", 8, -9, "unknown reason");
        UN_KNOWN = r111;
        AuthErrorCode r112 = new AuthErrorCode("URL_EMPTY", 9, -11, "auth url is empty");
        URL_EMPTY = r112;
        AuthErrorCode r113 = new AuthErrorCode("REQUEST_CHECK_DENY", 10, -12, "failed_request_parameters_check_deny");
        REQUEST_CHECK_DENY = r113;
        AuthErrorCode r107 = new AuthErrorCode("BLOCK_BY_BIZ_SERVICE", 11, -13, "block by biz service");
        BLOCK_BY_BIZ_SERVICE = r107;
        f269822a = new AuthErrorCode[]{r100, r101, r102, r103, r104, r105, r106, r110, r111, r112, r113, r107};
    }

    public final int getCode() {
        return this.code;
    }

    public final String getMsg() {
        return this.msg;
    }

    public AuthErrorCode(String r100, int r101, int r102, String r103) {
        super(r100, r101);
        this.code = r102;
        this.msg = r103;
    }

    public /* synthetic */ AuthErrorCode(String r100, int r101, int r102, String r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 2) == 0) goto L5;
        r103 = null;
    L5:
        this(r100, r101, r102, r103);
    }
}
