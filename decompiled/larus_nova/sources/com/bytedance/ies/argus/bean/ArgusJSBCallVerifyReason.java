package com.bytedance.ies.argus.bean;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u001b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002R\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\t\u001a\u00020\b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"¨\u0006#"}, d2 = {"Lcom/bytedance/ies/argus/bean/ArgusJSBCallVerifyReason;", "", "Lcom/bytedance/ies/argus/bean/o;", "", "code", "I", "getCode", "()I", "", "strValue", "Ljava/lang/String;", "getStrValue", "()Ljava/lang/String;", "NO_FE_ID_CONFIG", "NOT_IN_SAFE_URl", "IN_EXCLUDE_METHODS", "SECURE_NOT_INCLUDE", "RULE_DENY_NOT_INCLUDE", "NOT_IN_SAFE_URL", "OVER_CALL_FREQ", "OVER_CALL_TIMES", "UN_KNOWN", "URL_EMPTY", "REQUEST_CHECK_DENY", "IN_INCLUDE_METHODS", "PASS_GROUP_COMPARE", "REQUEST_CHECK_PASSED", "REQUEST_CHECK_WARNING", "GLOBAL_DISABLE_LYNX_AUTH", "LYNX_INVALID_FE_ID", "LYNX_AUTH_CONFIG_IS_NULL", "AUTH_URL_IS_NULL", "DEBUG_DISABLE_LYNX_JSB_AUTH", "GLOBAL_DISABLE_WEB_AUTH", "SKIP_BY_AUTH_RECOVERY", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum ArgusJSBCallVerifyReason extends Enum<ArgusJSBCallVerifyReason> implements o {
    public static final ArgusJSBCallVerifyReason AUTH_URL_IS_NULL = null;
    public static final ArgusJSBCallVerifyReason DEBUG_DISABLE_LYNX_JSB_AUTH = null;
    public static final ArgusJSBCallVerifyReason GLOBAL_DISABLE_LYNX_AUTH = null;
    public static final ArgusJSBCallVerifyReason GLOBAL_DISABLE_WEB_AUTH = null;
    public static final ArgusJSBCallVerifyReason IN_EXCLUDE_METHODS = null;
    public static final ArgusJSBCallVerifyReason IN_INCLUDE_METHODS = null;
    public static final ArgusJSBCallVerifyReason LYNX_AUTH_CONFIG_IS_NULL = null;
    public static final ArgusJSBCallVerifyReason LYNX_INVALID_FE_ID = null;
    public static final ArgusJSBCallVerifyReason NOT_IN_SAFE_URL = null;
    public static final ArgusJSBCallVerifyReason NOT_IN_SAFE_URl = null;
    public static final ArgusJSBCallVerifyReason NO_FE_ID_CONFIG = null;
    public static final ArgusJSBCallVerifyReason OVER_CALL_FREQ = null;
    public static final ArgusJSBCallVerifyReason OVER_CALL_TIMES = null;
    public static final ArgusJSBCallVerifyReason PASS_GROUP_COMPARE = null;
    public static final ArgusJSBCallVerifyReason REQUEST_CHECK_DENY = null;
    public static final ArgusJSBCallVerifyReason REQUEST_CHECK_PASSED = null;
    public static final ArgusJSBCallVerifyReason REQUEST_CHECK_WARNING = null;
    public static final ArgusJSBCallVerifyReason RULE_DENY_NOT_INCLUDE = null;
    public static final ArgusJSBCallVerifyReason SECURE_NOT_INCLUDE = null;
    public static final ArgusJSBCallVerifyReason SKIP_BY_AUTH_RECOVERY = null;
    public static final ArgusJSBCallVerifyReason UN_KNOWN = null;
    public static final ArgusJSBCallVerifyReason URL_EMPTY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ArgusJSBCallVerifyReason[] f245959a = null;
    private final int code;
    private final String strValue;

    public static ArgusJSBCallVerifyReason valueOf(String r100) {
        return (ArgusJSBCallVerifyReason) r27.a.a(ArgusJSBCallVerifyReason.class, r100);
    }

    public static ArgusJSBCallVerifyReason[] values() {
        return (ArgusJSBCallVerifyReason[]) f245959a.clone();
    }

    static {
        ArgusJSBCallVerifyReason r100 = new ArgusJSBCallVerifyReason("NO_FE_ID_CONFIG", 0, -1, "app id is not legal");
        NO_FE_ID_CONFIG = r100;
        ArgusJSBCallVerifyReason r101 = new ArgusJSBCallVerifyReason("NOT_IN_SAFE_URl", 1, -2, "not in safe url");
        NOT_IN_SAFE_URl = r101;
        ArgusJSBCallVerifyReason r102 = new ArgusJSBCallVerifyReason("IN_EXCLUDE_METHODS", 2, -3, "method in exclude methods");
        IN_EXCLUDE_METHODS = r102;
        ArgusJSBCallVerifyReason r103 = new ArgusJSBCallVerifyReason("SECURE_NOT_INCLUDE", 3, -4, "method is secure, but not in include method");
        SECURE_NOT_INCLUDE = r103;
        ArgusJSBCallVerifyReason r104 = new ArgusJSBCallVerifyReason("RULE_DENY_NOT_INCLUDE", 4, -5, "method < rule");
        RULE_DENY_NOT_INCLUDE = r104;
        ArgusJSBCallVerifyReason r105 = new ArgusJSBCallVerifyReason("NOT_IN_SAFE_URL", 5, -6, "auth url is not in method secure url");
        NOT_IN_SAFE_URL = r105;
        ArgusJSBCallVerifyReason r106 = new ArgusJSBCallVerifyReason("OVER_CALL_FREQ", 6, -7, "jsb call over call freq limit");
        OVER_CALL_FREQ = r106;
        ArgusJSBCallVerifyReason r110 = new ArgusJSBCallVerifyReason("OVER_CALL_TIMES", 7, -8, "jsb call over call times limit");
        OVER_CALL_TIMES = r110;
        ArgusJSBCallVerifyReason r111 = new ArgusJSBCallVerifyReason("UN_KNOWN", 8, -9, "unknown reason");
        UN_KNOWN = r111;
        ArgusJSBCallVerifyReason r112 = new ArgusJSBCallVerifyReason("URL_EMPTY", 9, -11, "auth url is empty");
        URL_EMPTY = r112;
        ArgusJSBCallVerifyReason r107 = new ArgusJSBCallVerifyReason("REQUEST_CHECK_DENY", 10, -12, "failed_request_parameters_check_deny");
        REQUEST_CHECK_DENY = r107;
        ArgusJSBCallVerifyReason r108 = new ArgusJSBCallVerifyReason("IN_INCLUDE_METHODS", 11, 2, "method in included methods");
        IN_INCLUDE_METHODS = r108;
        ArgusJSBCallVerifyReason r113 = new ArgusJSBCallVerifyReason("PASS_GROUP_COMPARE", 12, 3, "pass group compare");
        PASS_GROUP_COMPARE = r113;
        ArgusJSBCallVerifyReason r109 = new ArgusJSBCallVerifyReason("REQUEST_CHECK_PASSED", 13, 17, "success_request_parameters_check_passed");
        REQUEST_CHECK_PASSED = r109;
        ArgusJSBCallVerifyReason r114 = new ArgusJSBCallVerifyReason("REQUEST_CHECK_WARNING", 14, 103, "success_request_parameters_warn");
        REQUEST_CHECK_WARNING = r114;
        ArgusJSBCallVerifyReason r115 = new ArgusJSBCallVerifyReason("GLOBAL_DISABLE_LYNX_AUTH", 15, 1001, "global disable lynx jsb auth");
        GLOBAL_DISABLE_LYNX_AUTH = r115;
        ArgusJSBCallVerifyReason r116 = new ArgusJSBCallVerifyReason("LYNX_INVALID_FE_ID", 16, 1002, "lynx invalid fe id");
        LYNX_INVALID_FE_ID = r116;
        ArgusJSBCallVerifyReason r117 = new ArgusJSBCallVerifyReason("LYNX_AUTH_CONFIG_IS_NULL", 17, 1003, "lynx auth config is null");
        LYNX_AUTH_CONFIG_IS_NULL = r117;
        ArgusJSBCallVerifyReason r118 = new ArgusJSBCallVerifyReason("AUTH_URL_IS_NULL", 18, 1004, "auth url is null");
        AUTH_URL_IS_NULL = r118;
        ArgusJSBCallVerifyReason r119 = new ArgusJSBCallVerifyReason("DEBUG_DISABLE_LYNX_JSB_AUTH", 19, 1005, "disable lynx jsb auth in debug env");
        DEBUG_DISABLE_LYNX_JSB_AUTH = r119;
        ArgusJSBCallVerifyReason r120 = new ArgusJSBCallVerifyReason("GLOBAL_DISABLE_WEB_AUTH", 20, 1006, "global disable web jsb auth");
        GLOBAL_DISABLE_WEB_AUTH = r120;
        ArgusJSBCallVerifyReason r121 = new ArgusJSBCallVerifyReason("SKIP_BY_AUTH_RECOVERY", 21, 1007, "skip by auth recovery");
        SKIP_BY_AUTH_RECOVERY = r121;
        f245959a = new ArgusJSBCallVerifyReason[]{r100, r101, r102, r103, r104, r105, r106, r110, r111, r112, r107, r108, r113, r109, r114, r115, r116, r117, r118, r119, r120, r121};
    }

    @Override // com.bytedance.ies.argus.bean.o
    public int getCode() {
        return this.code;
    }

    @Override // com.bytedance.ies.argus.bean.o
    public String getStrValue() {
        return this.strValue;
    }

    public ArgusJSBCallVerifyReason(String r100, int r101, int r102, String r103) {
        super(r100, r101);
        this.code = r102;
        this.strValue = r103;
    }
}
