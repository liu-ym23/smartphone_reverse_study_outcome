package com.larus.login.impl.impl;

import com.amap.api.services.district.DistrictSearchQuery;
import com.bytedance.apm.ApmAgent;
import com.bytedance.common.utility.NetworkUtils;
import com.ixigua.lib.track.TrackParams;
import com.larus.account.base.model.NeutralAgeGateStyle;
import com.larus.account.base.provider.agegate.AgeGateManagerService;
import com.larus.applog.api.IApplog;
import com.larus.common.apphost.AppHost;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.login.api.IAccountTrackApi;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.texturerender.TextureRenderKeys;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b&\n\u0002\u0010\t\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u001f\u0010\f\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0002\u0010\u000fJ\b\u0010\u0010\u001a\u00020\u0005H\u0016J\b\u0010\u0011\u001a\u00020\u0005H\u0016J1\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0002\u0010\u0017J=\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0019\u001a\u0004\u0018\u00010\u000b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0002\u0010\u001bJ\u0012\u0010\u001c\u001a\u00020\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u000eH\u0016J\u001a\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u000b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010 \u001a\u00020\u0005H\u0016JB\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020\u000e2\b\u0010(\u001a\u0004\u0018\u00010\u000eH\u0016J\u0018\u0010)\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020\u000eH\u0016Jb\u0010+\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020\u000e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000e2\b\u0010,\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0019\u001a\u0004\u0018\u00010\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u000e2\b\u0010(\u001a\u0004\u0018\u00010\u000e2\u0006\u0010-\u001a\u00020\u000eH\u0016J\b\u0010.\u001a\u00020\u0005H\u0016J,\u0010/\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000e2\b\u0010,\u001a\u0004\u0018\u00010\u000e2\u0006\u00100\u001a\u00020\u000eH\u0016J\b\u00101\u001a\u00020\u0005H\u0016J\b\u00102\u001a\u00020\u0005H\u0016J\u0018\u00103\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u000e2\u0006\u00104\u001a\u000205H\u0016J\u0018\u00106\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u000e2\u0006\u00104\u001a\u000205H\u0016J\b\u00107\u001a\u00020\u0005H\u0016J\u0010\u00108\u001a\u00020\u00052\u0006\u00104\u001a\u000205H\u0016J)\u00109\u001a\u00020\u00052\u0006\u0010:\u001a\u00020\u000e2\b\u0010\u0015\u001a\u0004\u0018\u0001052\b\u0010;\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0002\u0010<J\u001f\u0010=\u001a\u00020\u00052\u0006\u0010:\u001a\u00020\u000e2\b\u0010>\u001a\u0004\u0018\u000105H\u0016¢\u0006\u0002\u0010?J\u0010\u0010@\u001a\u00020\u00052\u0006\u0010:\u001a\u00020\u000eH\u0016J(\u0010A\u001a\u00020\u00052\u0006\u0010B\u001a\u00020\u000e2\u0006\u0010C\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\u000eH\u0016J0\u0010D\u001a\u00020\u00052\u0006\u0010B\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020\u000e2\u0006\u0010E\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\u000eH\u0016J \u0010F\u001a\u00020\u00052\u0006\u0010G\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\u000eH\u0016J \u0010H\u001a\u00020\u00052\u0006\u0010G\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\u000eH\u0016J(\u0010I\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u000e2\u0006\u0010J\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\u000eH\u0016J&\u0010K\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u000b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u000eJ&\u0010L\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u000b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u000eJ\u0016\u0010M\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\u000eJ\u001e\u0010N\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020\u000eJA\u0010O\u001a\u00020\u00052\u0006\u0010P\u001a\u00020Q2\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010R\u001a\u00020\u000e2\u0006\u00100\u001a\u00020\u000e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000b2\b\u0010,\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0002\u0010SJ\n\u0010T\u001a\u0004\u0018\u00010UH\u0016J\u000e\u0010V\u001a\u00020\u00052\u0006\u0010W\u001a\u00020\u000eJ\u0010\u0010X\u001a\u00020\u00052\b\u0010$\u001a\u0004\u0018\u00010\u000eJ\u0010\u0010Y\u001a\u00020\u00052\b\u0010$\u001a\u0004\u0018\u00010\u000eJ\u0010\u0010Z\u001a\u00020\u00052\b\u0010$\u001a\u0004\u0018\u00010\u000eJ\u001a\u0010[\u001a\u00020\u00052\b\u0010$\u001a\u0004\u0018\u00010\u000e2\u0006\u0010G\u001a\u00020\u000eH\u0002¨\u0006\\"}, d2 = {"Lcom/larus/login/impl/impl/AccountTrace;", "Lcom/larus/login/api/IAccountTrackApi;", "<init>", "()V", "clickLoginHomeProtocol", "", "clickLoginHomePrivacy", "clickPhoneLoginBack", "clickPhoneLoginSkip", "clickPhoneLoginRegion", "code", "", "phoneLoginRegionResult", DistrictSearchQuery.KEYWORDS_COUNTRY, "", "(Ljava/lang/Integer;Ljava/lang/String;)V", "clickVerifyCodeBack", "clickVerifyCodeResend", "loginSendCodeResult", "success", "resend", "errorCode", "errorMessage", "(IILjava/lang/Integer;Ljava/lang/String;)V", "loginSendVoiceCodeResult", "originErrorCode", "originErrorMsg", "(ILjava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "privacyWindowShow", "actionTimestamp", "privacyWindowClick", "status", "privacyAcceptException", "clickLogin", "loginType", "position", "currentPage", "previousPage", "enterMethod", "clickFrom", "triggerAppId", "loginRequest", "type", "loginResult", "errorMsg", "accountType", "clickSettingLogout", "logoutResult", "scene", "clickLogoutConfirm", "clickLogoutCancel", "thirdLoginSuccessTime", "duration", "", "thirdLoginInitTime", "startFillVerifyCode", "fillVerifyCodeTime", "reportAppealResult", "secUserId", "tips", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)V", "reportRiskLogout", "statusCode", "(Ljava/lang/String;Ljava/lang/Long;)V", "reportAppealPopupShow", "showModule", TextureRenderKeys.KEY_MODULE_NAME, "showFrom", "clickModule", "clickResult", "showButton", "buttonName", "clickButton", "userLoginAction", "pageStep", "autoFillPhoneNumber", "autoFillSmsCode", "showPhoneCheckPopup", "clickPhoneCheckPopup", "onLogoutResult", "isForce", "", "platform", "(ZILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getLoginInfo", "Lorg/json/JSONObject;", "mobShowPopupPhoneNormalUse", "current_page", "mobClickShutDownOrUnavailable", "mobClickIKnow", "mobClickClose", "mobClickButton", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AccountTrace implements IAccountTrackApi {
    public AccountTrace() {
    }

    @Override // com.larus.login.api.IAccountTrackApi
    public final void e() {
        IApplog.Companion r100 = IApplog.f287053a;
        JSONObject r101 = new JSONObject();
        Unit r102 = Unit.INSTANCE;
        r100.reportEvent("privacy_accept_exception", r101);
    }

    @Override // com.larus.login.api.IAccountTrackApi
    public final JSONObject getLoginInfo() {
        Lazy r100 = com.larus.login.impl.utils.f.f358319a;
        if (((List) r100.getValue()).isEmpty() == false) goto L5;
        JSONObject r101 = null;
    L6:
        ((List) r100.getValue()).clear();
        return r101;
    L5:
        JSONArray r102 = new JSONArray((List) r100.getValue());
        JSONObject r103 = new JSONObject();
        r103.put("login_steps", r102);
        r101 = r103;
        goto L6
    }

    @Override // com.larus.login.api.IAccountTrackApi
    public final void l() {
        IApplog.Companion r100 = IApplog.f287053a;
        JSONObject r101 = new JSONObject();
        Unit r102 = Unit.INSTANCE;
        r100.reportEvent("click_phone_login_back", r101);
    }

    @Override // com.larus.login.api.IAccountTrackApi
    public final void q(String r100) {
        IApplog.Companion r101 = IApplog.f287053a;
        JSONObject r102 = new JSONObject();
        r102.putOpt("action_timestamp", r100);
        Unit r103 = Unit.INSTANCE;
        r101.reportEvent("privacy_window_show", r102);
    }

    public static void t(String r100, String r101) {
        IApplog.Companion r102 = IApplog.f287053a;
        JSONObject r103 = new JSONObject();
        r103.put("current_page", r100);
        r103.put("button_name", r101);
        Unit r104 = Unit.INSTANCE;
        r102.reportEvent(DoraObricDeviceHomeViewModel.ENTER_METHOD_CLICK_BUTTON, r103);
    }

    public static void v(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        IApplog.Companion r102 = IApplog.f287053a;
        JSONObject r103 = new JSONObject();
        r103.put("type", r100);
        r103.put("duration", r101);
        Unit r104 = Unit.INSTANCE;
        r102.reportEvent("third_login_init_time", r103);
    }

    @Override // com.larus.login.api.IAccountTrackApi
    public final void a(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        IApplog.Companion r102 = IApplog.f287053a;
        JSONObject r103 = new JSONObject();
        r103.put("type", r100);
        r103.put("duration", r101);
        Unit r104 = Unit.INSTANCE;
        r102.reportEvent("third_login_success_time", r103);
    }

    @Override // com.larus.login.api.IAccountTrackApi
    public final void b(String r100, Long r101) {
        Intrinsics.checkNotNullParameter(r100, "secUserId");
        IApplog.Companion r102 = IApplog.f287053a;
        JSONObject r103 = new JSONObject();
        r103.put("sec_user_id", r100);
        r103.put("status_code", r101);
        Unit r104 = Unit.INSTANCE;
        r102.reportEvent("risk_logout", r103);
    }

    @Override // com.larus.login.api.IAccountTrackApi
    public final void c(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "currentPage");
        IApplog.Companion r102 = IApplog.f287053a;
        JSONObject r103 = new JSONObject();
        r103.put("type", r100);
        r103.put("current_page", r101);
        Unit r104 = Unit.INSTANCE;
        r102.reportEvent("login_request", r103);
    }

    @Override // com.larus.login.api.IAccountTrackApi
    public final void f(int r100, String r101) {
        IApplog.Companion r102 = IApplog.f287053a;
        JSONObject r103 = new JSONObject();
        r103.put("status", r100);
        r103.putOpt("action_timestamp", r101);
        Unit r104 = Unit.INSTANCE;
        r102.reportEvent("privacy_window_click", r103);
    }

    public static void s(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "currentPage");
        Intrinsics.checkNotNullParameter(r101, "previousPage");
        Intrinsics.checkNotNullParameter(r102, "clickFrom");
        IApplog.Companion r103 = IApplog.f287053a;
        JSONObject r104 = new JSONObject();
        r104.put("current_page", r100);
        r104.put("previous_page", r101);
        r104.put("click_from", r102);
        Unit r105 = Unit.INSTANCE;
        r103.reportEvent("click_phone_check_popup", r104);
    }

    public static void u(String r100, Long r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "secUserId");
        IApplog.Companion r103 = IApplog.f287053a;
        JSONObject r104 = new JSONObject();
        r104.put("sec_user_id", r100);
        r104.put("err_code", r101);
        r104.put("tips", r102);
        Unit r105 = Unit.INSTANCE;
        r103.reportEvent("appeal_result", r104);
    }

    @Override // com.larus.login.api.IAccountTrackApi
    public final void h(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "buttonName");
        Intrinsics.checkNotNullParameter(r101, "currentPage");
        Intrinsics.checkNotNullParameter(r102, "previousPage");
        IApplog.Companion r103 = IApplog.f287053a;
        JSONObject r104 = new JSONObject();
        r104.put("button_name", r100);
        r104.put("current_page", r101);
        r104.put("previous_page", r102);
        Unit r105 = Unit.INSTANCE;
        r103.reportEvent("show_button", r104);
    }

    @Override // com.larus.login.api.IAccountTrackApi
    public final void j(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter("agree_auth", TextureRenderKeys.KEY_MODULE_NAME);
        Intrinsics.checkNotNullParameter(r100, "showFrom");
        Intrinsics.checkNotNullParameter(r101, "currentPage");
        Intrinsics.checkNotNullParameter(r102, "previousPage");
        IApplog.Companion r103 = IApplog.f287053a;
        JSONObject r104 = new JSONObject();
        r104.put("module_name", "agree_auth");
        r104.put("show_from", r100);
        r104.put("current_page", r101);
        r104.put("previous_page", r102);
        Unit r105 = Unit.INSTANCE;
        r103.reportEvent("show_module", r104);
    }

    @Override // com.larus.login.api.IAccountTrackApi
    public final void p(String r110, String r111, String r112) {
        Intrinsics.checkNotNullParameter(r110, "buttonName");
        Intrinsics.checkNotNullParameter(r111, "currentPage");
        Intrinsics.checkNotNullParameter(r112, "previousPage");
        IApplog.Companion r100 = IApplog.f287053a;
        JSONObject r101 = new JSONObject();
        r101.put("button_name", r110);
        r101.put("current_page", r111);
        r101.put("previous_page", r112);
        Unit r102 = Unit.INSTANCE;
        r100.reportEvent(DoraObricDeviceHomeViewModel.ENTER_METHOD_CLICK_BUTTON, r101);
        Lazy r103 = com.larus.login.impl.utils.f.f358319a;
        Intrinsics.checkNotNullParameter(r110, "buttonName");
        Intrinsics.checkNotNullParameter(r111, "currentPage");
        Intrinsics.checkNotNullParameter(r112, "previousPage");
        JSONObject r104 = new JSONObject();
        r104.put("button_name", r110);
        r104.put("current_page", r111);
        r104.put("previous_page", r112);
        com.larus.login.impl.utils.f.c(DoraObricDeviceHomeViewModel.ENTER_METHOD_CLICK_BUTTON, r104);
    }

    @Override // com.larus.login.api.IAccountTrackApi
    public final void d(String r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "loginType");
        Intrinsics.checkNotNullParameter(r101, "pageStep");
        Intrinsics.checkNotNullParameter(r102, "currentPage");
        Intrinsics.checkNotNullParameter(r103, "previousPage");
        IApplog.Companion r104 = IApplog.f287053a;
        JSONObject r105 = new JSONObject();
        r105.put("login_type", r100);
        r105.put("step_type", "user_click");
        r105.put("click_step", "click_login");
        r105.put("page_step", r101);
        r105.put("current_page", r102);
        r105.put("previous_page", r103);
        Unit r106 = Unit.INSTANCE;
        r104.reportEvent("user_login_action", r105);
    }

    @Override // com.larus.login.api.IAccountTrackApi
    public final void m(String r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter("agree_auth", TextureRenderKeys.KEY_MODULE_NAME);
        Intrinsics.checkNotNullParameter(r100, "clickFrom");
        Intrinsics.checkNotNullParameter(r101, "clickResult");
        Intrinsics.checkNotNullParameter(r102, "currentPage");
        Intrinsics.checkNotNullParameter(r103, "previousPage");
        IApplog.Companion r104 = IApplog.f287053a;
        JSONObject r105 = new JSONObject();
        r105.put("module_name", "agree_auth");
        r105.put("click_from", r100);
        r105.put("click_result", r101);
        r105.put("current_page", r102);
        r105.put("previous_page", r103);
        Unit r106 = Unit.INSTANCE;
        r104.reportEvent("click_module", r105);
    }

    @Override // com.larus.login.api.IAccountTrackApi
    public final void n(int r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r103, "scene");
        IApplog.Companion r104 = IApplog.f287053a;
        JSONObject r105 = new JSONObject();
        r105.put("success", r100);
        r105.put("scene", r103);
        if (r100 != 0) goto L5;
        r105.put("err_tips", r102);
        r105.put("err_code", r101);
    L5:
        Unit r106 = Unit.INSTANCE;
        r104.reportEvent("logout_result", r105);
    }

    @Override // com.larus.login.api.IAccountTrackApi
    public final void o(int r100, int r101, Integer r110, String r111) {
        JSONObject r102 = new JSONObject();
        r102.put("success", r100);
        r102.put("resend", r101);
        if (r110 == null) goto L6;
        r102.put("err_code", r110.intValue());
    L6:
        if (r111 == null) goto L8;
        r102.put("err_tips", r111);
    L8:
        IApplog.f287053a.reportEvent("login_send_code_result", r102);
        ApmAgent.monitorEvent("login_send_code_result", r102, null, null);
        Lazy r103 = com.larus.login.impl.utils.f.f358319a;
        JSONObject r104 = new JSONObject();
        r104.put("success", r100);
        r104.put("resend", r101);
        if (r110 == null) goto L11;
        r104.put("err_code", r110.intValue());
    L11:
        if (r111 == null) goto L13;
        r104.put("err_tips", r111);
    L13:
        com.larus.login.impl.utils.f.c("login_send_code_result", r104);
        FLogger.f375446a.w("FLOW_LOGIN", "login_send_code_result:" + r102);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.larus.login.api.IAccountTrackApi
    public final void i(int r100, Integer r101, String r102, Integer r103, String r104) {
        JSONObject r105 = new JSONObject();
        r105.put("success", r100);
        if (r101 == null) goto L5;
        r105.put("err_code", r101.intValue());
    L5:
        if (r102 == null) goto L7;
        r105.put("err_tips", r102);
    L7:
        if (r103 == null) goto L9;
        r105.put("origin_err_code", r103.intValue());
    L9:
        if (r104 == null) goto L11;
        r105.put("origin_err_tips", r104);
    L11:
        if (r100 != 0) goto L13;
        r105.put("login_network", NetworkUtils.isNetworkAvailable(AppHost.f326268a.getApplication()) ? 1 : 0);
    L13:
        IApplog.f287053a.reportEvent("login_send_voice_code_result", r105);
        FLogger.f375446a.w("FLOW_LOGIN", "login_send_voice_code_result:" + r105);
    }

    @Override // com.larus.login.api.IAccountTrackApi
    public final void g(boolean r100, int r101, String r102, String r103, Integer r104, String r110) {
        Intrinsics.checkNotNullParameter(r102, "platform");
        Intrinsics.checkNotNullParameter(r103, "scene");
        JSONObject r105 = new JSONObject();
        r105.put(MonitorConstants.EXTRA_DOWNLOAD_IS_FORCE, r100 ? 1 : 0);
        r105.put("success", r101);
        r105.put("scene", r103);
        r105.put("platform", r102);
        if (r101 != 0) goto L5;
        r105.put("err_tips", r110);
        r105.put("err_code", r104);
    L5:
        IApplog.f287053a.reportEvent("rd_logout_result", r105);
        ApmAgent.monitorEvent("rd_logout_result", r105, null, null);
        FLogger.f375446a.w("FLOW_LOGIN", "rd_logout_result:" + r105);
    }

    public final void r(String r110, int r210, String r211, String r212, String r213, String r214, String r215) {
        Intrinsics.checkNotNullParameter(r110, "loginType");
        Intrinsics.checkNotNullParameter(r211, "currentPage");
        Intrinsics.checkNotNullParameter(r212, "previousPage");
        Intrinsics.checkNotNullParameter(r213, "enterMethod");
        Intrinsics.checkNotNullParameter(r214, "clickFrom");
        if (Intrinsics.areEqual(r110, "login_tel_sdk_confirm") == false) goto L5;
    L8:
        String r100 = "login_tel_sdk_page";
    L9:
        c(r110, r100);
        if (r210 == (-1)) goto L12;
        Long r101 = Long.valueOf(r210);
    L13:
        JSONObject r111 = new JSONObject();
        Intrinsics.checkNotNullParameter(r111, "params");
        if (r211 != null) goto L43;
    L18:
        if (r212 == null) goto L22;
        r111.put("previous_page", r212);     // Catch: JSONException -> L16
    L16:
        JSONException e100 = e;
        String r112 = "currentPage";
        String r113 = "previousPage";
    L38:
        FLogger.f375446a.e("ClickEventHelper", "error in ClickEventHelper clickLogin " + e100.getLocalizedMessage());
    L39:
        TrackParams r102 = new TrackParams().merge(r111);
        by7.a r103 = new by7.a("click_login");
        r103.f21463a.merge(r102);
        r103.b();
        JSONObject r104 = new JSONObject();
        r104.put("current_page", r211);
        r104.put("previous_page", r212);
        r104.put("click_from", r214);
        r104.put("type", r110);
        r104.put("position", r210);
        ApmAgent.monitorEvent("click_login", r104, null, null);
        Lazy r105 = com.larus.login.impl.utils.f.f358319a;
        Intrinsics.checkNotNullParameter(r110, "type");
        Intrinsics.checkNotNullParameter(r214, "clickFrom");
        Intrinsics.checkNotNullParameter(r211, r112);
        Intrinsics.checkNotNullParameter(r212, r113);
        JSONObject r106 = new JSONObject();
        r106.put("type", r110);
        r106.put("click_from", r214);
        r106.put("current_page", r211);
        r106.put("previous_page", r212);
        com.larus.login.impl.utils.f.c("click_login", r106);
        return;
    L22:
        if (r213 == null) goto L28;
        r113 = "previousPage";
        r111.put("enter_method", r213);     // Catch: JSONException -> L26
    L29:
        if (r101 == null) goto L32;
        r112 = "currentPage";
        r111.put("position", r101.longValue());     // Catch: JSONException -> L37
    L33:
        r111.put("type", r110);     // Catch: JSONException -> L37
        r111.put("click_from", r214);     // Catch: JSONException -> L37
        if (o0.d(r215) == false) goto L39;
        r111.put("trigger_app", r215);     // Catch: JSONException -> L37
    L37:
        e100 = e;
        goto L38
    L32:
        r112 = "currentPage";
    L26:
        e100 = e;
        r112 = "currentPage";
        goto L38
    L28:
        r113 = "previousPage";
        goto L29
    L43:
        r111.put("current_page", r211);     // Catch: JSONException -> L16
        goto L18
    L12:
        r101 = null;
        goto L13
    L5:
        if (Intrinsics.areEqual(r110, "login_tel_sdk_confirm_fail") == true) goto L8;
        r100 = "login_home";
        goto L9
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.larus.login.api.IAccountTrackApi
    public final void k(String r110, int r111, String r112, String r210, String r211, String r212, String r213, String r214, String r215, String r216) {
        Intrinsics.checkNotNullParameter(r110, "loginType");
        Intrinsics.checkNotNullParameter(r112, "currentPage");
        Intrinsics.checkNotNullParameter(r210, "enterMethod");
        Intrinsics.checkNotNullParameter(r216, "accountType");
        JSONObject r100 = new JSONObject();
        r100.put("type", r110);
        r100.put("success", r111);
        r100.put("current_page", r112);
        r100.put("enter_method", r210);
        Integer r101 = AgeGateManagerService.f286218a.b();
        if (r101 == null) goto L6;
        int r102 = r101.intValue();
        NeutralAgeGateStyle.Companion.getClass();
        r100.put("age_verification_type", NeutralAgeGateStyle.a.a(r102));
    L6:
        if (o0.d(r215) == false) goto L8;
        r100.put("trigger_app", r215);
    L8:
        r100.put("account_type", r216);
        if (r111 != 0) goto L17;
        r100.put("err_code", r211);
        r100.put("err_tips", r212);
        if (o0.d(r213) == false) goto L14;
        r100.put("origin_err_code", r213);
    L14:
        if (o0.d(r214) == false) goto L16;
        r100.put("origin_err_tips", r214);
    L16:
        r100.put("login_network", NetworkUtils.isNetworkAvailable(AppHost.f326268a.getApplication()) ? 1 : 0);
    L17:
        IApplog.f287053a.reportEvent("login_result", r100);
        ApmAgent.monitorEvent("login_result", r100, null, null);
        FLogger.f375446a.w("FLOW_LOGIN", "login_result:" + r100);
        Lazy r103 = com.larus.login.impl.utils.f.f358319a;
        Intrinsics.checkNotNullParameter(r110, "type");
        Intrinsics.checkNotNullParameter(r112, "currentPage");
        JSONObject r104 = new JSONObject();
        r104.put("type", r110);
        r104.put("success", String.valueOf(r111));
        r104.put("current_page", r112);
        if (r211 == null) goto L20;
        r104.put("err_code", r211);
    L20:
        if (r212 == null) goto L22;
        r104.put("err_tips", r212);
    L22:
        com.larus.login.impl.utils.f.c("login_result", r104);
    }
}
