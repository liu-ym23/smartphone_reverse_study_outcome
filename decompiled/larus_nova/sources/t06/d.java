package t06;

import com.amap.api.col.s.ce;
import com.bytedance.pia.core.metrics.ErrorType;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000¸\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0080\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010!\u001a\u0004\u0018\u00010 8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001c\u0010&\u001a\u0004\u0018\u00010%8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u001c\u0010+\u001a\u0004\u0018\u00010*8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u001c\u00100\u001a\u0004\u0018\u00010/8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\u001c\u00105\u001a\u0004\u0018\u0001048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R\u001c\u0010:\u001a\u0004\u0018\u0001098\u0006X\u0087\u0004¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R\u001c\u0010?\u001a\u0004\u0018\u00010>8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010BR\u001c\u0010D\u001a\u0004\u0018\u00010C8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bF\u0010GR\u001c\u0010I\u001a\u0004\u0018\u00010H8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bI\u0010J\u001a\u0004\bK\u0010LR\u001c\u0010N\u001a\u0004\u0018\u00010M8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bN\u0010O\u001a\u0004\bP\u0010QR\u001c\u0010S\u001a\u0004\u0018\u00010R8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bS\u0010T\u001a\u0004\bU\u0010VR\u001c\u0010X\u001a\u0004\u0018\u00010W8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bX\u0010Y\u001a\u0004\bZ\u0010[R\u001c\u0010]\u001a\u0004\u0018\u00010\\8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`R\u001c\u0010b\u001a\u0004\u0018\u00010a8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bb\u0010c\u001a\u0004\bd\u0010eR\u001c\u0010g\u001a\u0004\u0018\u00010f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bg\u0010h\u001a\u0004\bi\u0010jR\u001c\u0010l\u001a\u0004\u0018\u00010k8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bl\u0010m\u001a\u0004\bn\u0010o¨\u0006p"}, d2 = {"Lt06/d;", "", "Lt06/a0;", "webUrlListVerify", "Lt06/a0;", "u", "()Lt06/a0;", "Lt06/j;", "jsbCall", "Lt06/j;", "e", "()Lt06/j;", "Lt06/k;", "jsbRequestCheck", "Lt06/k;", "f", "()Lt06/k;", "Lt06/u;", "thirdRemoveSensitiveInfo", "Lt06/u;", "o", "()Lt06/u;", "Lt06/p;", "lynxSignVerify", "Lt06/p;", ce.f26396k, "()Lt06/p;", "Lt06/r;", ErrorType.PREFETCH, "Lt06/r;", "m", "()Lt06/r;", "Lt06/b;", "csrfProtectConfig", "Lt06/b;", "getCsrfProtectConfig", "()Lt06/b;", "Lt06/n;", "lynxLoadWhiteList", "Lt06/n;", RXScreenCaptureService.KEY_INDEX, "()Lt06/n;", "Lt06/q;", "motionVerify", "Lt06/q;", "l", "()Lt06/q;", "Lt06/o;", "lynxSSRUrlVerify", "Lt06/o;", ce.f26395j, "()Lt06/o;", "Lt06/e;", "fallbackWebMainFrameInterceptConfig", "Lt06/e;", "b", "()Lt06/e;", "Lt06/b0;", "webMainFrameScriptInjectConfig", "Lt06/b0;", "t", "()Lt06/b0;", "Lt06/t;", "requestCookieVerifyConfig", "Lt06/t;", OfficeSDKRequestTag.KEY_NEW_USER, "()Lt06/t;", "Lt06/w;", "webContentVerifyConfig", "Lt06/w;", "q", "()Lt06/w;", "Lt06/z;", "webInjectJSStrategyConfig", "Lt06/z;", "s", "()Lt06/z;", "Lt06/v;", "uploadFileVerifyStrategyConfig", "Lt06/v;", "p", "()Lt06/v;", "Lt06/l;", "jsiVerifyConfig", "Lt06/l;", ce.f26391f, "()Lt06/l;", "Lt06/g;", "globalPropsListVerifyConfig", "Lt06/g;", "c", "()Lt06/g;", "Lt06/c;", "commonParamsAllowListConfig", "Lt06/c;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lt06/c;", "Lt06/m;", "loginStateSourceVerifyConfig", "Lt06/m;", "h", "()Lt06/m;", "Lt06/h;", "globalPropsUrlVerifyConfig", "Lt06/h;", "d", "()Lt06/h;", "Lt06/x;", "webDomMonitorConfig", "Lt06/x;", "r", "()Lt06/x;", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class d {

    @SerializedName("common_params_allow_list_verify")
    private final c commonParamsAllowListConfig;

    @SerializedName("csrf_protect")
    private final b csrfProtectConfig;

    @SerializedName("fallback_web_main_frame_intercept")
    private final e fallbackWebMainFrameInterceptConfig;

    @SerializedName("gp_list_verify")
    private final g globalPropsListVerifyConfig;

    @SerializedName("global_props_url_verify")
    private final h globalPropsUrlVerifyConfig;

    @SerializedName("jsb_auth")
    private final j jsbCall;

    @SerializedName("jsb_request_check")
    private final k jsbRequestCheck;

    @SerializedName("jsi_list_verify")
    private final l jsiVerifyConfig;

    @SerializedName("inject_login_state")
    private final m loginStateSourceVerifyConfig;

    @SerializedName("lynx_load_white_list")
    private final n lynxLoadWhiteList;

    @SerializedName("lynx_ssr_url_verify")
    private final o lynxSSRUrlVerify;

    @SerializedName("lynx_sign_verify")
    private final p lynxSignVerify;

    @SerializedName("motion_verify")
    private final q motionVerify;

    @SerializedName("prefetch_url_list_verify")
    private final r prefetch;

    @SerializedName("request_cookie_verify")
    private final t requestCookieVerifyConfig;

    @SerializedName("third_remove_sensitive_info")
    private final u thirdRemoveSensitiveInfo;

    @SerializedName("upload_file_verify")
    private final v uploadFileVerifyStrategyConfig;

    @SerializedName("web_content_verify")
    private final w webContentVerifyConfig;

    @SerializedName("web_dom_monitor_inject")
    private final x webDomMonitorConfig;

    @SerializedName("web_inject_js")
    private final z webInjectJSStrategyConfig;

    @SerializedName("web_main_frame_script_inject")
    private final b0 webMainFrameScriptInjectConfig;

    @SerializedName("web_url_list_verify")
    private final a0 webUrlListVerify;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.webUrlListVerify, r101.webUrlListVerify) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.jsbCall, r101.jsbCall) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.jsbRequestCheck, r101.jsbRequestCheck) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.thirdRemoveSensitiveInfo, r101.thirdRemoveSensitiveInfo) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.lynxSignVerify, r101.lynxSignVerify) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.prefetch, r101.prefetch) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.csrfProtectConfig, r101.csrfProtectConfig) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.lynxLoadWhiteList, r101.lynxLoadWhiteList) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.motionVerify, r101.motionVerify) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.lynxSSRUrlVerify, r101.lynxSSRUrlVerify) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.fallbackWebMainFrameInterceptConfig, r101.fallbackWebMainFrameInterceptConfig) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.webMainFrameScriptInjectConfig, r101.webMainFrameScriptInjectConfig) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.requestCookieVerifyConfig, r101.requestCookieVerifyConfig) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.webContentVerifyConfig, r101.webContentVerifyConfig) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.webInjectJSStrategyConfig, r101.webInjectJSStrategyConfig) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.uploadFileVerifyStrategyConfig, r101.uploadFileVerifyStrategyConfig) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.jsiVerifyConfig, r101.jsiVerifyConfig) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.globalPropsListVerifyConfig, r101.globalPropsListVerifyConfig) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.commonParamsAllowListConfig, r101.commonParamsAllowListConfig) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.loginStateSourceVerifyConfig, r101.loginStateSourceVerifyConfig) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.globalPropsUrlVerifyConfig, r101.globalPropsUrlVerifyConfig) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.webDomMonitorConfig, r101.webDomMonitorConfig) == true) goto L74;
        return false;
    L74:
        return true;
    }

    public final int hashCode() {
        a0 r100 = this.webUrlListVerify;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        j r104 = this.jsbCall;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        k r107 = this.jsbRequestCheck;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        u r110 = this.thirdRemoveSensitiveInfo;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        p r113 = this.lynxSignVerify;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        r r116 = this.prefetch;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        b r119 = this.csrfProtectConfig;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        n r122 = this.lynxLoadWhiteList;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        q r125 = this.motionVerify;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        o r128 = this.lynxSSRUrlVerify;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        e r131 = this.fallbackWebMainFrameInterceptConfig;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        b0 r134 = this.webMainFrameScriptInjectConfig;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        t r137 = this.requestCookieVerifyConfig;
        if (r137 != null) goto L53;
        int r138 = 0;
    L54:
        int r139 = (r136 + r138) * 31;
        w r140 = this.webContentVerifyConfig;
        if (r140 != null) goto L57;
        int r141 = 0;
    L58:
        int r142 = (r139 + r141) * 31;
        z r143 = this.webInjectJSStrategyConfig;
        if (r143 != null) goto L61;
        int r144 = 0;
    L62:
        int r145 = (r142 + r144) * 31;
        v r146 = this.uploadFileVerifyStrategyConfig;
        if (r146 != null) goto L65;
        int r147 = 0;
    L66:
        int r148 = (r145 + r147) * 31;
        l r149 = this.jsiVerifyConfig;
        if (r149 != null) goto L69;
        int r150 = 0;
    L70:
        int r151 = (r148 + r150) * 31;
        g r152 = this.globalPropsListVerifyConfig;
        if (r152 != null) goto L73;
        int r153 = 0;
    L74:
        int r154 = (r151 + r153) * 31;
        c r155 = this.commonParamsAllowListConfig;
        if (r155 != null) goto L77;
        int r156 = 0;
    L78:
        int r157 = (r154 + r156) * 31;
        m r158 = this.loginStateSourceVerifyConfig;
        if (r158 != null) goto L81;
        int r159 = 0;
    L82:
        int r160 = (r157 + r159) * 31;
        h r161 = this.globalPropsUrlVerifyConfig;
        if (r161 != null) goto L85;
        int r162 = 0;
    L86:
        int r163 = (r160 + r162) * 31;
        x r164 = this.webDomMonitorConfig;
        if (r164 == null) goto L91;
        r101 = r164.hashCode();
    L91:
        return r163 + r101;
    L85:
        r162 = r161.hashCode();
        goto L86
    L81:
        r159 = r158.hashCode();
        goto L82
    L77:
        r156 = r155.hashCode();
        goto L78
    L73:
        r153 = r152.hashCode();
        goto L74
    L69:
        r150 = r149.hashCode();
        goto L70
    L65:
        r147 = r146.hashCode();
        goto L66
    L61:
        r144 = r143.hashCode();
        goto L62
    L57:
        r141 = r140.hashCode();
        goto L58
    L53:
        r138 = r137.hashCode();
        goto L54
    L49:
        r135 = r134.hashCode();
        goto L50
    L45:
        r132 = r131.hashCode();
        goto L46
    L41:
        r129 = r128.hashCode();
        goto L42
    L37:
        r126 = r125.hashCode();
        goto L38
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ContainerStrategyConfig(webUrlListVerify=" + this.webUrlListVerify + ", jsbCall=" + this.jsbCall + ", jsbRequestCheck=" + this.jsbRequestCheck + ", thirdRemoveSensitiveInfo=" + this.thirdRemoveSensitiveInfo + ", lynxSignVerify=" + this.lynxSignVerify + ", prefetch=" + this.prefetch + ", csrfProtectConfig=" + this.csrfProtectConfig + ", lynxLoadWhiteList=" + this.lynxLoadWhiteList + ", motionVerify=" + this.motionVerify + ", lynxSSRUrlVerify=" + this.lynxSSRUrlVerify + ", fallbackWebMainFrameInterceptConfig=" + this.fallbackWebMainFrameInterceptConfig + ", webMainFrameScriptInjectConfig=" + this.webMainFrameScriptInjectConfig + ", requestCookieVerifyConfig=" + this.requestCookieVerifyConfig + ", webContentVerifyConfig=" + this.webContentVerifyConfig + ", webInjectJSStrategyConfig=" + this.webInjectJSStrategyConfig + ", uploadFileVerifyStrategyConfig=" + this.uploadFileVerifyStrategyConfig + ", jsiVerifyConfig=" + this.jsiVerifyConfig + ", globalPropsListVerifyConfig=" + this.globalPropsListVerifyConfig + ", commonParamsAllowListConfig=" + this.commonParamsAllowListConfig + ", loginStateSourceVerifyConfig=" + this.loginStateSourceVerifyConfig + ", globalPropsUrlVerifyConfig=" + this.globalPropsUrlVerifyConfig + ", webDomMonitorConfig=" + this.webDomMonitorConfig + ')';
    }

    public d() {
        this.webUrlListVerify = null;
        this.jsbCall = null;
        this.jsbRequestCheck = null;
        this.thirdRemoveSensitiveInfo = null;
        this.lynxSignVerify = null;
        this.prefetch = null;
        this.csrfProtectConfig = null;
        this.lynxLoadWhiteList = null;
        this.motionVerify = null;
        this.lynxSSRUrlVerify = null;
        this.fallbackWebMainFrameInterceptConfig = null;
        this.webMainFrameScriptInjectConfig = null;
        this.requestCookieVerifyConfig = null;
        this.webContentVerifyConfig = null;
        this.webInjectJSStrategyConfig = null;
        this.uploadFileVerifyStrategyConfig = null;
        this.jsiVerifyConfig = null;
        this.globalPropsListVerifyConfig = null;
        this.commonParamsAllowListConfig = null;
        this.loginStateSourceVerifyConfig = null;
        this.globalPropsUrlVerifyConfig = null;
        this.webDomMonitorConfig = null;
    }

    public final c a() {
        return this.commonParamsAllowListConfig;
    }

    public final e b() {
        return this.fallbackWebMainFrameInterceptConfig;
    }

    public final g c() {
        return this.globalPropsListVerifyConfig;
    }

    public final h d() {
        return this.globalPropsUrlVerifyConfig;
    }

    public final j e() {
        return this.jsbCall;
    }

    public final k f() {
        return this.jsbRequestCheck;
    }

    public final l g() {
        return this.jsiVerifyConfig;
    }

    public final m h() {
        return this.loginStateSourceVerifyConfig;
    }

    public final n i() {
        return this.lynxLoadWhiteList;
    }

    public final o j() {
        return this.lynxSSRUrlVerify;
    }

    public final p k() {
        return this.lynxSignVerify;
    }

    public final q l() {
        return this.motionVerify;
    }

    public final r m() {
        return this.prefetch;
    }

    public final t n() {
        return this.requestCookieVerifyConfig;
    }

    public final u o() {
        return this.thirdRemoveSensitiveInfo;
    }

    public final v p() {
        return this.uploadFileVerifyStrategyConfig;
    }

    public final w q() {
        return this.webContentVerifyConfig;
    }

    public final x r() {
        return this.webDomMonitorConfig;
    }

    public final z s() {
        return this.webInjectJSStrategyConfig;
    }

    public final b0 t() {
        return this.webMainFrameScriptInjectConfig;
    }

    public final a0 u() {
        return this.webUrlListVerify;
    }
}
