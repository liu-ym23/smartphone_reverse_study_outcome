package com.larus.login.api;

import com.amap.api.services.district.DistrictSearchQuery;
import com.android.ttcjpaysdk.bdpay.counter.outer.fallback.event.OuterPayFallbackReport;
import com.ss.texturerender.TextureRenderKeys;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b&\n\u0002\u0010\t\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001f\u0010\u0011\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0016¢\u0006\u0002\u0010\u0014J\b\u0010\u0015\u001a\u00020\nH\u0016J\b\u0010\u0016\u001a\u00020\nH\u0016J1\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u00102\b\u0010\u001b\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0002\u0010\u001cJ=\u0010\u001d\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u00102\b\u0010\u001b\u001a\u0004\u0018\u00010\u00132\b\u0010\u001e\u001a\u0004\u0018\u00010\u00102\b\u0010\u001f\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0002\u0010 J\u0012\u0010!\u001a\u00020\n2\b\u0010\"\u001a\u0004\u0018\u00010\u0013H\u0016J\u001a\u0010#\u001a\u00020\n2\u0006\u0010$\u001a\u00020\u00102\b\u0010\"\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010%\u001a\u00020\nH\u0016JB\u0010&\u001a\u00020\n2\u0006\u0010'\u001a\u00020\u00132\u0006\u0010(\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\u00132\u0006\u0010*\u001a\u00020\u00132\u0006\u0010+\u001a\u00020\u00132\u0006\u0010,\u001a\u00020\u00132\b\u0010-\u001a\u0004\u0018\u00010\u0013H\u0016J\u0018\u0010.\u001a\u00020\n2\u0006\u0010/\u001a\u00020\u00132\u0006\u0010)\u001a\u00020\u0013H\u0016Jb\u00100\u001a\u00020\n2\u0006\u0010'\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\u00132\u0006\u0010+\u001a\u00020\u00132\b\u0010\u001a\u001a\u0004\u0018\u00010\u00132\b\u00101\u001a\u0004\u0018\u00010\u00132\b\u0010\u001e\u001a\u0004\u0018\u00010\u00132\b\u0010\u001f\u001a\u0004\u0018\u00010\u00132\b\u0010-\u001a\u0004\u0018\u00010\u00132\u0006\u00102\u001a\u00020\u0013H\u0016J\b\u00103\u001a\u00020\nH\u0016J,\u00104\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u00132\b\u00101\u001a\u0004\u0018\u00010\u00132\u0006\u00105\u001a\u00020\u0013H\u0016J\b\u00106\u001a\u00020\nH\u0016J\b\u00107\u001a\u00020\nH\u0016J\u0018\u00108\u001a\u00020\n2\u0006\u0010/\u001a\u00020\u00132\u0006\u00109\u001a\u00020:H\u0016J\u0018\u0010;\u001a\u00020\n2\u0006\u0010/\u001a\u00020\u00132\u0006\u00109\u001a\u00020:H\u0016J\b\u0010<\u001a\u00020\nH\u0016J\u0010\u0010=\u001a\u00020\n2\u0006\u00109\u001a\u00020:H\u0016J)\u0010>\u001a\u00020\n2\u0006\u0010?\u001a\u00020\u00132\b\u0010\u001a\u001a\u0004\u0018\u00010:2\b\u0010@\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0002\u0010AJ\u001f\u0010B\u001a\u00020\n2\u0006\u0010?\u001a\u00020\u00132\b\u0010C\u001a\u0004\u0018\u00010:H\u0016¢\u0006\u0002\u0010DJ\u0010\u0010E\u001a\u00020\n2\u0006\u0010?\u001a\u00020\u0013H\u0016J(\u0010F\u001a\u00020\n2\u0006\u0010G\u001a\u00020\u00132\u0006\u0010H\u001a\u00020\u00132\u0006\u0010)\u001a\u00020\u00132\u0006\u0010*\u001a\u00020\u0013H\u0016J0\u0010I\u001a\u00020\n2\u0006\u0010G\u001a\u00020\u00132\u0006\u0010,\u001a\u00020\u00132\u0006\u0010J\u001a\u00020\u00132\u0006\u0010)\u001a\u00020\u00132\u0006\u0010*\u001a\u00020\u0013H\u0016J \u0010K\u001a\u00020\n2\u0006\u0010L\u001a\u00020\u00132\u0006\u0010)\u001a\u00020\u00132\u0006\u0010*\u001a\u00020\u0013H\u0016J \u0010M\u001a\u00020\n2\u0006\u0010L\u001a\u00020\u00132\u0006\u0010)\u001a\u00020\u00132\u0006\u0010*\u001a\u00020\u0013H\u0016J(\u0010N\u001a\u00020\n2\u0006\u0010'\u001a\u00020\u00132\u0006\u0010O\u001a\u00020\u00132\u0006\u0010)\u001a\u00020\u00132\u0006\u0010*\u001a\u00020\u0013H\u0016JA\u0010P\u001a\u00020\n2\u0006\u0010Q\u001a\u00020R2\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010S\u001a\u00020\u00132\u0006\u00105\u001a\u00020\u00132\b\u0010\u001a\u001a\u0004\u0018\u00010\u00102\b\u00101\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0002\u0010TJ\n\u0010U\u001a\u0004\u0018\u00010VH\u0016R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006W"}, d2 = {"Lcom/larus/login/api/AccountTrackService;", "Lcom/larus/login/api/IAccountTrackApi;", "<init>", "()V", OuterPayFallbackReport.RETAIN_ACTION_IMP, "getImp", "()Lcom/larus/login/api/IAccountTrackApi;", "imp$delegate", "Lkotlin/Lazy;", "clickLoginHomeProtocol", "", "clickLoginHomePrivacy", "clickPhoneLoginBack", "clickPhoneLoginSkip", "clickPhoneLoginRegion", "code", "", "phoneLoginRegionResult", DistrictSearchQuery.KEYWORDS_COUNTRY, "", "(Ljava/lang/Integer;Ljava/lang/String;)V", "clickVerifyCodeBack", "clickVerifyCodeResend", "loginSendCodeResult", "success", "resend", "errorCode", "errorMessage", "(IILjava/lang/Integer;Ljava/lang/String;)V", "loginSendVoiceCodeResult", "originErrorCode", "originErrorMsg", "(ILjava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "privacyWindowShow", "actionTimestamp", "privacyWindowClick", "status", "privacyAcceptException", "clickLogin", "loginType", "position", "currentPage", "previousPage", "enterMethod", "clickFrom", "triggerAppId", "loginRequest", "type", "loginResult", "errorMsg", "accountType", "clickSettingLogout", "logoutResult", "scene", "clickLogoutConfirm", "clickLogoutCancel", "thirdLoginSuccessTime", "duration", "", "thirdLoginInitTime", "startFillVerifyCode", "fillVerifyCodeTime", "reportAppealResult", "secUserId", "tips", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)V", "reportRiskLogout", "statusCode", "(Ljava/lang/String;Ljava/lang/Long;)V", "reportAppealPopupShow", "showModule", TextureRenderKeys.KEY_MODULE_NAME, "showFrom", "clickModule", "clickResult", "showButton", "buttonName", "clickButton", "userLoginAction", "pageStep", "onLogoutResult", "isForce", "", "platform", "(ZILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getLoginInfo", "Lorg/json/JSONObject;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AccountTrackService implements IAccountTrackApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AccountTrackService f356934a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f356935b = null;

    private AccountTrackService() {
    }

    static {
        f356934a = new AccountTrackService();
        f356935b = LazyKt.lazy(new a());
    }

    public static IAccountTrackApi r() {
        return (IAccountTrackApi) f356935b.getValue();
    }

    @Override // com.larus.login.api.IAccountTrackApi
    public final void e() {
        IAccountTrackApi r100 = r();
        if (r100 == null) goto L6;
        r100.e();
        return;
    }

    @Override // com.larus.login.api.IAccountTrackApi
    public final JSONObject getLoginInfo() {
        IAccountTrackApi r100 = r();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getLoginInfo();
    }

    @Override // com.larus.login.api.IAccountTrackApi
    public final void l() {
        IAccountTrackApi r100 = r();
        if (r100 == null) goto L6;
        r100.l();
        return;
    }

    @Override // com.larus.login.api.IAccountTrackApi
    public final void q(String r100) {
        IAccountTrackApi r101 = r();
        if (r101 == null) goto L6;
        r101.q(r100);
        return;
    }

    @Override // com.larus.login.api.IAccountTrackApi
    public final void a(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        IAccountTrackApi r102 = r();
        if (r102 == null) goto L6;
        r102.a(r100, r101);
        return;
    }

    @Override // com.larus.login.api.IAccountTrackApi
    public final void b(String r100, Long r101) {
        Intrinsics.checkNotNullParameter(r100, "secUserId");
        IAccountTrackApi r102 = r();
        if (r102 == null) goto L6;
        r102.b(r100, r101);
        return;
    }

    @Override // com.larus.login.api.IAccountTrackApi
    public final void c(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "currentPage");
        IAccountTrackApi r102 = r();
        if (r102 == null) goto L6;
        r102.c(r100, r101);
        return;
    }

    @Override // com.larus.login.api.IAccountTrackApi
    public final void f(int r100, String r101) {
        IAccountTrackApi r102 = r();
        if (r102 == null) goto L6;
        r102.f(r100, r101);
        return;
    }

    @Override // com.larus.login.api.IAccountTrackApi
    public final void h(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "buttonName");
        Intrinsics.checkNotNullParameter("login_tel_sdk_page", "currentPage");
        Intrinsics.checkNotNullParameter(r102, "previousPage");
        IAccountTrackApi r103 = r();
        if (r103 == null) goto L6;
        r103.h(r100, "login_tel_sdk_page", r102);
        return;
    }

    @Override // com.larus.login.api.IAccountTrackApi
    public final void j(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter("agree_auth", TextureRenderKeys.KEY_MODULE_NAME);
        Intrinsics.checkNotNullParameter(r100, "showFrom");
        Intrinsics.checkNotNullParameter(r101, "currentPage");
        Intrinsics.checkNotNullParameter(r102, "previousPage");
        IAccountTrackApi r103 = r();
        if (r103 == null) goto L6;
        r103.j(r100, r101, r102);
        return;
    }

    @Override // com.larus.login.api.IAccountTrackApi
    public final void p(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "buttonName");
        Intrinsics.checkNotNullParameter("login_tel_sdk_page", "currentPage");
        Intrinsics.checkNotNullParameter(r102, "previousPage");
        IAccountTrackApi r103 = r();
        if (r103 == null) goto L6;
        r103.p(r100, "login_tel_sdk_page", r102);
        return;
    }

    @Override // com.larus.login.api.IAccountTrackApi
    public final void d(String r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "loginType");
        Intrinsics.checkNotNullParameter(r101, "pageStep");
        Intrinsics.checkNotNullParameter(r102, "currentPage");
        Intrinsics.checkNotNullParameter(r103, "previousPage");
        IAccountTrackApi r104 = r();
        if (r104 == null) goto L6;
        r104.d(r100, r101, r102, r103);
        return;
    }

    @Override // com.larus.login.api.IAccountTrackApi
    public final void m(String r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter("agree_auth", TextureRenderKeys.KEY_MODULE_NAME);
        Intrinsics.checkNotNullParameter(r100, "clickFrom");
        Intrinsics.checkNotNullParameter(r101, "clickResult");
        Intrinsics.checkNotNullParameter(r102, "currentPage");
        Intrinsics.checkNotNullParameter(r103, "previousPage");
        IAccountTrackApi r104 = r();
        if (r104 == null) goto L6;
        r104.m(r100, r101, r102, r103);
        return;
    }

    @Override // com.larus.login.api.IAccountTrackApi
    public final void n(int r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r103, "scene");
        IAccountTrackApi r104 = r();
        if (r104 == null) goto L6;
        r104.n(r100, r101, r102, r103);
        return;
    }

    @Override // com.larus.login.api.IAccountTrackApi
    public final void o(int r100, int r101, Integer r102, String r103) {
        IAccountTrackApi r104 = r();
        if (r104 == null) goto L6;
        r104.o(r100, r101, r102, r103);
        return;
    }

    @Override // com.larus.login.api.IAccountTrackApi
    public final void i(int r100, Integer r101, String r102, Integer r110, String r111) {
        IAccountTrackApi r103 = r();
        if (r103 == null) goto L6;
        r103.i(r100, r101, r102, r110, r111);
        return;
    }

    @Override // com.larus.login.api.IAccountTrackApi
    public final void g(boolean r100, int r110, String r111, String r112, Integer r113, String r114) {
        Intrinsics.checkNotNullParameter(r111, "platform");
        Intrinsics.checkNotNullParameter(r112, "scene");
        IAccountTrackApi r101 = r();
        if (r101 == null) goto L6;
        r101.g(r100, r110, r111, r112, r113, r114);
        return;
    }

    @Override // com.larus.login.api.IAccountTrackApi
    public final void k(String r110, int r111, String r112, String r113, String r114, String r115, String r116, String r210, String r211, String r212) {
        Intrinsics.checkNotNullParameter(r110, "loginType");
        Intrinsics.checkNotNullParameter(r112, "currentPage");
        Intrinsics.checkNotNullParameter(r113, "enterMethod");
        Intrinsics.checkNotNullParameter(r212, "accountType");
        IAccountTrackApi r100 = r();
        if (r100 == null) goto L6;
        r100.k(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212);
        return;
    }
}
