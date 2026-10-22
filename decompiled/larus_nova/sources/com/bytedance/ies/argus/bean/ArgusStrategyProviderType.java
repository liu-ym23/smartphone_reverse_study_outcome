package com.bytedance.ies.argus.bean;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u001f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b ¨\u0006!"}, d2 = {"Lcom/bytedance/ies/argus/bean/ArgusStrategyProviderType;", "", "", "strategyName", "Ljava/lang/String;", "getStrategyName", "()Ljava/lang/String;", "WebUrlListVerify", "JSBAuth", "JSBRequestCheck", "CSRF_PROTECT", "LynxSignVerify", "PrefetchWhiteList", "TTMACHINE", "LynxLoadWhiteList", "MotionVerify", "HttpsDomain", "LynxSSRUrlVerify", "FallbackWebMainFrameIntercept", "WebMainFrameScriptInject", "RequestCookieVerify", "WebContentVerify", "WebInjectJS", "WebViewCSRFUA", "UploadFileVerify", "JSIVerify", "GlobalPropsListVerify", "CommonParamsAllowList", "LoginStateSourceVerify", "FeSchemaParamVerify", "GlobalPropsUrlVerify", "WebDomMonitorJsbInject", "ThirdRemoveSensitiveInfo", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum ArgusStrategyProviderType extends Enum<ArgusStrategyProviderType> {
    public static final ArgusStrategyProviderType CSRF_PROTECT = null;
    public static final ArgusStrategyProviderType CommonParamsAllowList = null;
    public static final ArgusStrategyProviderType FallbackWebMainFrameIntercept = null;
    public static final ArgusStrategyProviderType FeSchemaParamVerify = null;
    public static final ArgusStrategyProviderType GlobalPropsListVerify = null;
    public static final ArgusStrategyProviderType GlobalPropsUrlVerify = null;
    public static final ArgusStrategyProviderType HttpsDomain = null;
    public static final ArgusStrategyProviderType JSBAuth = null;
    public static final ArgusStrategyProviderType JSBRequestCheck = null;
    public static final ArgusStrategyProviderType JSIVerify = null;
    public static final ArgusStrategyProviderType LoginStateSourceVerify = null;
    public static final ArgusStrategyProviderType LynxLoadWhiteList = null;
    public static final ArgusStrategyProviderType LynxSSRUrlVerify = null;
    public static final ArgusStrategyProviderType LynxSignVerify = null;
    public static final ArgusStrategyProviderType MotionVerify = null;
    public static final ArgusStrategyProviderType PrefetchWhiteList = null;
    public static final ArgusStrategyProviderType RequestCookieVerify = null;
    public static final ArgusStrategyProviderType TTMACHINE = null;
    public static final ArgusStrategyProviderType ThirdRemoveSensitiveInfo = null;
    public static final ArgusStrategyProviderType UploadFileVerify = null;
    public static final ArgusStrategyProviderType WebContentVerify = null;
    public static final ArgusStrategyProviderType WebDomMonitorJsbInject = null;
    public static final ArgusStrategyProviderType WebInjectJS = null;
    public static final ArgusStrategyProviderType WebMainFrameScriptInject = null;
    public static final ArgusStrategyProviderType WebUrlListVerify = null;
    public static final ArgusStrategyProviderType WebViewCSRFUA = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ArgusStrategyProviderType[] f245972a = null;
    private final String strategyName;

    public static ArgusStrategyProviderType valueOf(String r100) {
        return (ArgusStrategyProviderType) r27.a.a(ArgusStrategyProviderType.class, r100);
    }

    public static ArgusStrategyProviderType[] values() {
        return (ArgusStrategyProviderType[]) f245972a.clone();
    }

    static {
        ArgusStrategyProviderType r100 = new ArgusStrategyProviderType("WebUrlListVerify", 0, "web_url_list_verify");
        WebUrlListVerify = r100;
        ArgusStrategyProviderType r101 = new ArgusStrategyProviderType("JSBAuth", 1, "jsb_auth");
        JSBAuth = r101;
        ArgusStrategyProviderType r102 = new ArgusStrategyProviderType("JSBRequestCheck", 2, "jsb_request_check");
        JSBRequestCheck = r102;
        ArgusStrategyProviderType r103 = new ArgusStrategyProviderType("CSRF_PROTECT", 3, "csrf_protect");
        CSRF_PROTECT = r103;
        ArgusStrategyProviderType r104 = new ArgusStrategyProviderType("LynxSignVerify", 4, "lynx_sign_verify");
        LynxSignVerify = r104;
        ArgusStrategyProviderType r105 = new ArgusStrategyProviderType("PrefetchWhiteList", 5, "prefetch_url_list_verify");
        PrefetchWhiteList = r105;
        ArgusStrategyProviderType r110 = new ArgusStrategyProviderType("TTMACHINE", 6, "ttm");
        TTMACHINE = r110;
        ArgusStrategyProviderType r111 = new ArgusStrategyProviderType("LynxLoadWhiteList", 7, "lynx_load_white_list");
        LynxLoadWhiteList = r111;
        ArgusStrategyProviderType r112 = new ArgusStrategyProviderType("MotionVerify", 8, "motion_verify");
        MotionVerify = r112;
        ArgusStrategyProviderType r113 = new ArgusStrategyProviderType("HttpsDomain", 9, "force_https");
        HttpsDomain = r113;
        ArgusStrategyProviderType r114 = new ArgusStrategyProviderType("LynxSSRUrlVerify", 10, "lynx_ssr_url_verify");
        LynxSSRUrlVerify = r114;
        ArgusStrategyProviderType r106 = new ArgusStrategyProviderType("FallbackWebMainFrameIntercept", 11, "fallback_web_main_frame_intercept");
        FallbackWebMainFrameIntercept = r106;
        ArgusStrategyProviderType r107 = new ArgusStrategyProviderType("WebMainFrameScriptInject", 12, "web_main_frame_script_inject");
        WebMainFrameScriptInject = r107;
        ArgusStrategyProviderType r108 = new ArgusStrategyProviderType("RequestCookieVerify", 13, "request_cookie_verify");
        RequestCookieVerify = r108;
        ArgusStrategyProviderType r109 = new ArgusStrategyProviderType("WebContentVerify", 14, "web_content_verify");
        WebContentVerify = r109;
        ArgusStrategyProviderType r115 = new ArgusStrategyProviderType("WebInjectJS", 15, "web_inject_js");
        WebInjectJS = r115;
        ArgusStrategyProviderType r116 = new ArgusStrategyProviderType("WebViewCSRFUA", 16, "webview_csrf_ua");
        WebViewCSRFUA = r116;
        ArgusStrategyProviderType r117 = new ArgusStrategyProviderType("UploadFileVerify", 17, "upload_file_verify");
        UploadFileVerify = r117;
        ArgusStrategyProviderType r118 = new ArgusStrategyProviderType("JSIVerify", 18, "jsi_list_verify");
        JSIVerify = r118;
        ArgusStrategyProviderType r119 = new ArgusStrategyProviderType("GlobalPropsListVerify", 19, "gp_list_verify");
        GlobalPropsListVerify = r119;
        ArgusStrategyProviderType r120 = new ArgusStrategyProviderType("CommonParamsAllowList", 20, "common_params_allow_list_verify");
        CommonParamsAllowList = r120;
        ArgusStrategyProviderType r121 = new ArgusStrategyProviderType("LoginStateSourceVerify", 21, "inject_login_state");
        LoginStateSourceVerify = r121;
        ArgusStrategyProviderType r122 = new ArgusStrategyProviderType("FeSchemaParamVerify", 22, "fe_schema_param_verify");
        FeSchemaParamVerify = r122;
        ArgusStrategyProviderType r123 = new ArgusStrategyProviderType("GlobalPropsUrlVerify", 23, "global_props_url_verify");
        GlobalPropsUrlVerify = r123;
        ArgusStrategyProviderType r124 = new ArgusStrategyProviderType("WebDomMonitorJsbInject", 24, "web_dom_monitor_inject");
        WebDomMonitorJsbInject = r124;
        ArgusStrategyProviderType r125 = new ArgusStrategyProviderType("ThirdRemoveSensitiveInfo", 25, "third_remove_sensitive_info");
        ThirdRemoveSensitiveInfo = r125;
        f245972a = new ArgusStrategyProviderType[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r106, r107, r108, r109, r115, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125};
    }

    public final String getStrategyName() {
        return this.strategyName;
    }

    public ArgusStrategyProviderType(String r100, int r101, String r102) {
        super(r100, r101);
        this.strategyName = r102;
    }
}
