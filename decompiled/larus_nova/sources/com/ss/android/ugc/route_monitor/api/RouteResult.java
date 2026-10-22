package com.ss.android.ugc.route_monitor.api;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0086\u0001\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0010J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000ej\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001c¨\u0006\u001d"}, d2 = {"Lcom/ss/android/ugc/route_monitor/api/RouteResult;", "", "", "isSucceed", "isTimeout", "", "errorCode", "I", "getErrorCode", "()I", "", "errorMsg", "Ljava/lang/String;", "getErrorMsg", "()Ljava/lang/String;", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "UNDEFINED", "SUCCEED", "FAIL_TIMEOUT", "FAIL_TIMEOUT_BY_UNKNOWN_UNDERTAKE_PAGE", "FAIL_TIMEOUT_BY_USER_ALWAYS_BACKGROUND", "FAIL_TIMEOUT_BY_USER_ENTER_BACKGROUND", "FAIL_TIMEOUT_BY_SESSION_INTERRUPTION", "FAIL_TIMEOUT_BY_UNMET_BUSINESS_CONDITION", "FAIL_TIMEOUT_BY_MISS_UNDERTAKE_PAGE_VIEW_SHOW", "FAIL_TIMEOUT_BY_NOT_REACHED_UNDERTAKE_PAGE", "FAIL_TIMEOUT_BY_NOT_CALL_DEEPLINK_END", "FAIL_BUSINESS_ERROR", "route-monitor_release"}, k = 1, mv = {1, 4, 0})
public final enum RouteResult extends Enum<RouteResult> {
    public static final a Companion = null;
    public static final RouteResult FAIL_BUSINESS_ERROR = null;
    public static final RouteResult FAIL_TIMEOUT = null;
    public static final RouteResult FAIL_TIMEOUT_BY_MISS_UNDERTAKE_PAGE_VIEW_SHOW = null;
    public static final RouteResult FAIL_TIMEOUT_BY_NOT_CALL_DEEPLINK_END = null;
    public static final RouteResult FAIL_TIMEOUT_BY_NOT_REACHED_UNDERTAKE_PAGE = null;
    public static final RouteResult FAIL_TIMEOUT_BY_SESSION_INTERRUPTION = null;
    public static final RouteResult FAIL_TIMEOUT_BY_UNKNOWN_UNDERTAKE_PAGE = null;
    public static final RouteResult FAIL_TIMEOUT_BY_UNMET_BUSINESS_CONDITION = null;
    public static final RouteResult FAIL_TIMEOUT_BY_USER_ALWAYS_BACKGROUND = null;
    public static final RouteResult FAIL_TIMEOUT_BY_USER_ENTER_BACKGROUND = null;
    public static final RouteResult SUCCEED = null;
    public static final RouteResult UNDEFINED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RouteResult[] f454389a = null;
    private final int errorCode;
    private final String errorMsg;

    public static final class a {
        public a() {
        }
    }

    public static RouteResult valueOf(String r100) {
        return (RouteResult) r27.a.a(RouteResult.class, r100);
    }

    public static RouteResult[] values() {
        return (RouteResult[]) f454389a.clone();
    }

    static {
        RouteResult r100 = new RouteResult("UNDEFINED", 0, 901, "默认的初始结果，一般为用户杀进程");
        UNDEFINED = r100;
        RouteResult r101 = new RouteResult("SUCCEED", 1, 200, "链路成功触达落地页");
        SUCCEED = r101;
        RouteResult r102 = new RouteResult("FAIL_TIMEOUT", 2, 10001, "链路超时");
        FAIL_TIMEOUT = r102;
        RouteResult r103 = new RouteResult("FAIL_TIMEOUT_BY_UNKNOWN_UNDERTAKE_PAGE", 3, 10002, "没有明确的落地页导致链路超时");
        FAIL_TIMEOUT_BY_UNKNOWN_UNDERTAKE_PAGE = r103;
        RouteResult r104 = new RouteResult("FAIL_TIMEOUT_BY_USER_ALWAYS_BACKGROUND", 4, 10003, "用户一直处于后台导致链路超时");
        FAIL_TIMEOUT_BY_USER_ALWAYS_BACKGROUND = r104;
        RouteResult r105 = new RouteResult("FAIL_TIMEOUT_BY_USER_ENTER_BACKGROUND", 5, 10004, "用户退后台导致链路超时");
        FAIL_TIMEOUT_BY_USER_ENTER_BACKGROUND = r105;
        RouteResult r106 = new RouteResult("FAIL_TIMEOUT_BY_SESSION_INTERRUPTION", 6, 10005, "session中断导致链路超时");
        FAIL_TIMEOUT_BY_SESSION_INTERRUPTION = r106;
        RouteResult r107 = new RouteResult("FAIL_TIMEOUT_BY_UNMET_BUSINESS_CONDITION", 7, 10006, "到达落地页但不满足业务条件导致链路超时");
        FAIL_TIMEOUT_BY_UNMET_BUSINESS_CONDITION = r107;
        RouteResult r108 = new RouteResult("FAIL_TIMEOUT_BY_MISS_UNDERTAKE_PAGE_VIEW_SHOW", 8, 10007, "到达落地页但缺少落地页viewShow导致链路超时");
        FAIL_TIMEOUT_BY_MISS_UNDERTAKE_PAGE_VIEW_SHOW = r108;
        RouteResult r109 = new RouteResult("FAIL_TIMEOUT_BY_NOT_REACHED_UNDERTAKE_PAGE", 9, 10008, "未到达落地页导致链路超时");
        FAIL_TIMEOUT_BY_NOT_REACHED_UNDERTAKE_PAGE = r109;
        RouteResult r110 = new RouteResult("FAIL_TIMEOUT_BY_NOT_CALL_DEEPLINK_END", 10, 10009, "未调用deeplinkEnd方法");
        FAIL_TIMEOUT_BY_NOT_CALL_DEEPLINK_END = r110;
        RouteResult r111 = new RouteResult("FAIL_BUSINESS_ERROR", 11, 500, "业务侧数据出错");
        FAIL_BUSINESS_ERROR = r111;
        f454389a = new RouteResult[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111};
        Companion = new a();
    }

    public final boolean isSucceed() {
        if (this.errorCode != 200) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isTimeout() {
        a r100 = Companion;
        int r101 = this.errorCode;
        r100.getClass();
        if (10001 <= r101) goto L6;
    L8:
        return false;
    L6:
        if (10009 < r101) goto L8;
        return true;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final String getErrorMsg() {
        return this.errorMsg;
    }

    public RouteResult(String r100, int r101, int r102, String r103) {
        super(r100, r101);
        this.errorCode = r102;
        this.errorMsg = r103;
    }
}
