package com.bytedance.ies.argus.bean;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002R\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\t\u001a\u00020\b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001a¨\u0006\u001b"}, d2 = {"Lcom/bytedance/ies/argus/bean/ArgusShouldInterceptResponseVerifyReason;", "", "Lcom/bytedance/ies/argus/bean/o;", "", "code", "I", "getCode", "()I", "", "strValue", "Ljava/lang/String;", "getStrValue", "()Ljava/lang/String;", "BUILD_VERSION_MISMATCH", "STRATEGY_CONFIG_IS_NULL", "FALLBACK_INTERCEPT_REQUEST_ERROR", "ORIGIN_RESPONSE_IS_NOT_NULL", "SHOULD_NOT_INTERCEPT", "FALLBACK_INTERCEPT_REQUEST_SUCCESS", "FALLBACK_INTERCEPT_REDIRECT_SUCCESS", "RESPONSE_IS_NULL_WHEN_INJECT_SCRIPT", "SHOULD_NOT_INJECT_SCRIPT", "INJECT_SCRIPT_SUCCESS", "SKIP_INJECT_FOR_NOT_HANDLE_CSP", "SCRIPT_INJECT_SUCCESS_WITH_HANDLE_CSP", "INJECT_SCRIPT_SUCCESS_NO_SCRIPT_DIRECTIVE", "INJECT_SCRIPT_SUCCESS_UNSAFE_INLINE_ENABLE", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum ArgusShouldInterceptResponseVerifyReason extends Enum<ArgusShouldInterceptResponseVerifyReason> implements o {
    public static final ArgusShouldInterceptResponseVerifyReason BUILD_VERSION_MISMATCH = null;
    public static final ArgusShouldInterceptResponseVerifyReason FALLBACK_INTERCEPT_REDIRECT_SUCCESS = null;
    public static final ArgusShouldInterceptResponseVerifyReason FALLBACK_INTERCEPT_REQUEST_ERROR = null;
    public static final ArgusShouldInterceptResponseVerifyReason FALLBACK_INTERCEPT_REQUEST_SUCCESS = null;
    public static final ArgusShouldInterceptResponseVerifyReason INJECT_SCRIPT_SUCCESS = null;
    public static final ArgusShouldInterceptResponseVerifyReason INJECT_SCRIPT_SUCCESS_NO_SCRIPT_DIRECTIVE = null;
    public static final ArgusShouldInterceptResponseVerifyReason INJECT_SCRIPT_SUCCESS_UNSAFE_INLINE_ENABLE = null;
    public static final ArgusShouldInterceptResponseVerifyReason ORIGIN_RESPONSE_IS_NOT_NULL = null;
    public static final ArgusShouldInterceptResponseVerifyReason RESPONSE_IS_NULL_WHEN_INJECT_SCRIPT = null;
    public static final ArgusShouldInterceptResponseVerifyReason SCRIPT_INJECT_SUCCESS_WITH_HANDLE_CSP = null;
    public static final ArgusShouldInterceptResponseVerifyReason SHOULD_NOT_INJECT_SCRIPT = null;
    public static final ArgusShouldInterceptResponseVerifyReason SHOULD_NOT_INTERCEPT = null;
    public static final ArgusShouldInterceptResponseVerifyReason SKIP_INJECT_FOR_NOT_HANDLE_CSP = null;
    public static final ArgusShouldInterceptResponseVerifyReason STRATEGY_CONFIG_IS_NULL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ArgusShouldInterceptResponseVerifyReason[] f245971a = null;
    private final int code;
    private final String strValue;

    public static ArgusShouldInterceptResponseVerifyReason valueOf(String r100) {
        return (ArgusShouldInterceptResponseVerifyReason) r27.a.a(ArgusShouldInterceptResponseVerifyReason.class, r100);
    }

    public static ArgusShouldInterceptResponseVerifyReason[] values() {
        return (ArgusShouldInterceptResponseVerifyReason[]) f245971a.clone();
    }

    static {
        ArgusShouldInterceptResponseVerifyReason r100 = new ArgusShouldInterceptResponseVerifyReason("BUILD_VERSION_MISMATCH", 0, -1, "build version mismatch");
        BUILD_VERSION_MISMATCH = r100;
        ArgusShouldInterceptResponseVerifyReason r101 = new ArgusShouldInterceptResponseVerifyReason("STRATEGY_CONFIG_IS_NULL", 1, -2, "strategy config is null");
        STRATEGY_CONFIG_IS_NULL = r101;
        ArgusShouldInterceptResponseVerifyReason r102 = new ArgusShouldInterceptResponseVerifyReason("FALLBACK_INTERCEPT_REQUEST_ERROR", 2, -3, "fallback intercept request error");
        FALLBACK_INTERCEPT_REQUEST_ERROR = r102;
        ArgusShouldInterceptResponseVerifyReason r103 = new ArgusShouldInterceptResponseVerifyReason("ORIGIN_RESPONSE_IS_NOT_NULL", 3, 1, "origin response is not null");
        ORIGIN_RESPONSE_IS_NOT_NULL = r103;
        ArgusShouldInterceptResponseVerifyReason r104 = new ArgusShouldInterceptResponseVerifyReason("SHOULD_NOT_INTERCEPT", 4, 2, "should not intercept");
        SHOULD_NOT_INTERCEPT = r104;
        ArgusShouldInterceptResponseVerifyReason r105 = new ArgusShouldInterceptResponseVerifyReason("FALLBACK_INTERCEPT_REQUEST_SUCCESS", 5, 3, "fallback intercept request success");
        FALLBACK_INTERCEPT_REQUEST_SUCCESS = r105;
        ArgusShouldInterceptResponseVerifyReason r110 = new ArgusShouldInterceptResponseVerifyReason("FALLBACK_INTERCEPT_REDIRECT_SUCCESS", 6, 10, "fallback intercept redirect success");
        FALLBACK_INTERCEPT_REDIRECT_SUCCESS = r110;
        ArgusShouldInterceptResponseVerifyReason r111 = new ArgusShouldInterceptResponseVerifyReason("RESPONSE_IS_NULL_WHEN_INJECT_SCRIPT", 7, 4, "response is null when inject script");
        RESPONSE_IS_NULL_WHEN_INJECT_SCRIPT = r111;
        ArgusShouldInterceptResponseVerifyReason r106 = new ArgusShouldInterceptResponseVerifyReason("SHOULD_NOT_INJECT_SCRIPT", 8, 5, "should not inject script");
        SHOULD_NOT_INJECT_SCRIPT = r106;
        ArgusShouldInterceptResponseVerifyReason r112 = new ArgusShouldInterceptResponseVerifyReason("INJECT_SCRIPT_SUCCESS", 9, 6, "script inject success");
        INJECT_SCRIPT_SUCCESS = r112;
        ArgusShouldInterceptResponseVerifyReason r113 = new ArgusShouldInterceptResponseVerifyReason("SKIP_INJECT_FOR_NOT_HANDLE_CSP", 10, 7, "skip inject script for not handle csp");
        SKIP_INJECT_FOR_NOT_HANDLE_CSP = r113;
        ArgusShouldInterceptResponseVerifyReason r114 = new ArgusShouldInterceptResponseVerifyReason("SCRIPT_INJECT_SUCCESS_WITH_HANDLE_CSP", 11, 8, "script inject success with handle csp");
        SCRIPT_INJECT_SUCCESS_WITH_HANDLE_CSP = r114;
        ArgusShouldInterceptResponseVerifyReason r107 = new ArgusShouldInterceptResponseVerifyReason("INJECT_SCRIPT_SUCCESS_NO_SCRIPT_DIRECTIVE", 12, 9, "script inject success with handle csp, no script directive");
        INJECT_SCRIPT_SUCCESS_NO_SCRIPT_DIRECTIVE = r107;
        ArgusShouldInterceptResponseVerifyReason r108 = new ArgusShouldInterceptResponseVerifyReason("INJECT_SCRIPT_SUCCESS_UNSAFE_INLINE_ENABLE", 13, 10, "script inject success with handle csp, unsafe inline enable");
        INJECT_SCRIPT_SUCCESS_UNSAFE_INLINE_ENABLE = r108;
        f245971a = new ArgusShouldInterceptResponseVerifyReason[]{r100, r101, r102, r103, r104, r105, r110, r111, r106, r112, r113, r114, r107, r108};
    }

    @Override // com.bytedance.ies.argus.bean.o
    public int getCode() {
        return this.code;
    }

    @Override // com.bytedance.ies.argus.bean.o
    public String getStrValue() {
        return this.strValue;
    }

    public ArgusShouldInterceptResponseVerifyReason(String r100, int r101, int r102, String r103) {
        super(r100, r101);
        this.code = r102;
        this.strValue = r103;
    }
}
