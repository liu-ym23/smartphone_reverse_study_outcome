package com.larus.account.base.api;

import android.content.Context;
import android.net.Uri;
import com.alipay.sdk.m.p.e;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.larus.account.base.model.SettingsAccountInfo;
import com.larus.init.task.accountsdk.c;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import n38.b0;
import n38.i;
import org.json.JSONObject;
import r38.b;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u0000 @2\u00020\u0001:\u0001@J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\bH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\bH&J\b\u0010\f\u001a\u00020\bH&J\u0012\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&J\n\u0010\u0010\u001a\u0004\u0018\u00010\u000fH&J\b\u0010\u0011\u001a\u00020\u0003H&J\b\u0010\u0012\u001a\u00020\bH&J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0015H&J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0015H&J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0019H&J\b\u0010\u001a\u001a\u00020\u0019H&J\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\bH&J\b\u0010\u001d\u001a\u00020\bH&J\b\u0010\u001e\u001a\u00020\u001fH&J\b\u0010 \u001a\u00020\u001fH&J\u001a\u0010!\u001a\u00020\u00032\b\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010$\u001a\u00020%H&J\b\u0010&\u001a\u00020\u0003H&J\n\u0010'\u001a\u0004\u0018\u00010(H&J$\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u001f0*2\u0006\u0010+\u001a\u00020\u001f2\u0006\u0010,\u001a\u00020\u001fH&J\u0016\u0010-\u001a\u00020\u00032\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u001f0/H&J\u0012\u00100\u001a\u0004\u0018\u00010\u001f2\u0006\u00101\u001a\u00020\u001fH\u0016J\"\u00102\u001a\u00020\u00032\u0006\u00103\u001a\u00020\u001f2\b\u00104\u001a\u0004\u0018\u00010\u001f2\u0006\u00105\u001a\u00020\u001fH&J\u0010\u00106\u001a\u00020\u00032\u0006\u00107\u001a\u000208H&J\u0010\u00109\u001a\u00020\u00032\u0006\u00107\u001a\u000208H&J \u0010:\u001a\u00020\b2\u0006\u0010;\u001a\u00020\u00192\u0006\u0010+\u001a\u00020\u00192\u0006\u0010<\u001a\u00020\u001fH&J\u0010\u0010=\u001a\u00020\b2\u0006\u0010>\u001a\u00020?H&¨\u0006A"}, d2 = {"Lcom/larus/account/base/api/IAccountService;", "", "initAccount", "", "commonDepend", "Lcom/larus/account/saas/runtime/depend/IFlowAccountSaasCommonDepend;", "setUserWaitPermission", "isHasPermission", "", "getUserWaitPermission", "setAutoShowGoogleOneTap", "needShowGoogleOneTap", "getAutoShowGoogleOneTap", "setSettingAccountInfo", "settingAccountInfo", "Lcom/larus/account/base/model/SettingsAccountInfo;", "getSettingAccountInfo", "recordUserRegistered", "hasRegisterUserInfo", "setUserInfo", "userInfo", "Lcom/larus/account/base/model/profile/UserInfo;", "getUserInfo", "setProfileBotCount", "profileBotCount", "", "getProfileBotCount", "setSkipCheckIndex", "skipCheckIndex", "getSkipCheckIndex", "getTermsOfServiceUrl", "", "getPrivacyPolicyUrl", "phoneOneKey2AccountSettings", "settings", "Lorg/json/JSONObject;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "updateToken", "createAuthorizationInterceptor", "Lcom/bytedance/retrofit2/intercept/Interceptor;", "buildAuthHeadersForUrl", "", e.f25671s, "url", "addTokenManagerConfigHost", "hostList", "", "getLarkQrLoginUrl", "scanResult", "setLarkUserId", "appUserId", "larkUserId", "source", "registerLarkUserIdChangeListener", "listener", "Lcom/larus/account/base/api/OnLarkUserIdChangeListener;", "unregisterLarkUserIdChangeListener", "handleFrontierMessage", "serviceId", WsConstants.KEY_PAYLOAD, "handleDeeplink", "uri", "Landroid/net/Uri;", "Companion", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IAccountService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f286094a = null;

    @Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u000fH\u0016J\b\u0010\u0013\u001a\u00020\u000fH\u0016J\u0012\u0010\u0014\u001a\u00020\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0018\u001a\u00020\nH\u0016J\b\u0010\u0019\u001a\u00020\u000fH\u0016J\u0010\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\n\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016J\u0010\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020 H\u0016J\u0010\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020\u000fH\u0016J\b\u0010$\u001a\u00020\u000fH\u0016J\b\u0010%\u001a\u00020&H\u0016J\b\u0010'\u001a\u00020&H\u0016J\u001a\u0010(\u001a\u00020\n2\b\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010+\u001a\u00020,H\u0016J\b\u0010-\u001a\u00020\nH\u0016J\n\u0010.\u001a\u0004\u0018\u00010/H\u0016J$\u00100\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020&012\u0006\u00102\u001a\u00020&2\u0006\u00103\u001a\u00020&H\u0016J\u0016\u00104\u001a\u00020\n2\f\u00105\u001a\b\u0012\u0004\u0012\u00020&06H\u0016J\u0012\u00107\u001a\u0004\u0018\u00010&2\u0006\u00108\u001a\u00020&H\u0016J\"\u00109\u001a\u00020\n2\u0006\u0010:\u001a\u00020&2\b\u0010;\u001a\u0004\u0018\u00010&2\u0006\u0010<\u001a\u00020&H\u0016J\u0010\u0010=\u001a\u00020\n2\u0006\u0010>\u001a\u00020?H\u0016J\u0010\u0010@\u001a\u00020\n2\u0006\u0010>\u001a\u00020?H\u0016J \u0010A\u001a\u00020\u000f2\u0006\u0010B\u001a\u00020 2\u0006\u00102\u001a\u00020 2\u0006\u0010C\u001a\u00020&H\u0016J\u0010\u0010D\u001a\u00020\u000f2\u0006\u0010E\u001a\u00020FH\u0016R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006G"}, d2 = {"Lcom/larus/account/base/api/IAccountService$Companion;", "Lcom/larus/account/base/api/IAccountService;", "<init>", "()V", "impl", "getImpl", "()Lcom/larus/account/base/api/IAccountService;", "impl$delegate", "Lkotlin/Lazy;", "initAccount", "", "commonDepend", "Lcom/larus/account/saas/runtime/depend/IFlowAccountSaasCommonDepend;", "setUserWaitPermission", "isHasPermission", "", "getUserWaitPermission", "setAutoShowGoogleOneTap", "needShowGoogleOneTap", "getAutoShowGoogleOneTap", "setSettingAccountInfo", "settingAccountInfo", "Lcom/larus/account/base/model/SettingsAccountInfo;", "getSettingAccountInfo", "recordUserRegistered", "hasRegisterUserInfo", "setUserInfo", "userInfo", "Lcom/larus/account/base/model/profile/UserInfo;", "getUserInfo", "setProfileBotCount", "profileBotCount", "", "getProfileBotCount", "setSkipCheckIndex", "skipCheckIndex", "getSkipCheckIndex", "getTermsOfServiceUrl", "", "getPrivacyPolicyUrl", "phoneOneKey2AccountSettings", "settings", "Lorg/json/JSONObject;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "updateToken", "createAuthorizationInterceptor", "Lcom/bytedance/retrofit2/intercept/Interceptor;", "buildAuthHeadersForUrl", "", e.f25671s, "url", "addTokenManagerConfigHost", "hostList", "", "getLarkQrLoginUrl", "scanResult", "setLarkUserId", "appUserId", "larkUserId", "source", "registerLarkUserIdChangeListener", "listener", "Lcom/larus/account/base/api/OnLarkUserIdChangeListener;", "unregisterLarkUserIdChangeListener", "handleFrontierMessage", "serviceId", WsConstants.KEY_PAYLOAD, "handleDeeplink", "uri", "Landroid/net/Uri;", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion implements IAccountService {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ Companion f286095b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Lazy<IAccountService> f286096c = null;

        private Companion() {
        }

        static {
            f286095b = new Companion();
            f286096c = LazyKt.lazy(new i());
        }

        public static IAccountService a() {
            return f286096c.getValue();
        }

        @Override // com.larus.account.base.api.IAccountService
        public final void g() {
            Intrinsics.checkNotNullParameter(c.f351137a, "commonDepend");
            IAccountService r100 = a();
            if (r100 == null) goto L6;
            r100.g();
            return;
        }

        @Override // com.larus.account.base.api.IAccountService
        public final String b() {
            IAccountService r100 = a();
            if (r100 == null) goto L6;
            String r101 = r100.b();
            if (r101 == null) goto L6;
            return r101;
        L6:
            return "";
        }

        @Override // com.larus.account.base.api.IAccountService
        public final String getPrivacyPolicyUrl() {
            IAccountService r100 = a();
            if (r100 == null) goto L6;
            String r101 = r100.getPrivacyPolicyUrl();
            if (r101 == null) goto L6;
            return r101;
        L6:
            return "";
        }

        @Override // com.larus.account.base.api.IAccountService
        public final b getUserInfo() {
            IAccountService r100 = a();
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.getUserInfo();
        }

        @Override // com.larus.account.base.api.IAccountService
        public final boolean h() {
            IAccountService r100 = a();
            if (r100 != null) goto L7;
            return false;
        L7:
            return r100.h();
        }

        @Override // com.larus.account.base.api.IAccountService
        public final void m() {
            IAccountService r100 = a();
            if (r100 == null) goto L6;
            r100.m();
            return;
        }

        @Override // com.larus.account.base.api.IAccountService
        public final void n() {
            IAccountService r100 = a();
            if (r100 == null) goto L6;
            r100.n();
            return;
        }

        @Override // com.larus.account.base.api.IAccountService
        public final boolean p() {
            IAccountService r100 = a();
            if (r100 != null) goto L7;
            return false;
        L7:
            return r100.p();
        }

        @Override // com.larus.account.base.api.IAccountService
        public final boolean r() {
            IAccountService r100 = a();
            if (r100 != null) goto L7;
            return false;
        L7:
            return r100.r();
        }

        @Override // com.larus.account.base.api.IAccountService
        public final Interceptor t() {
            IAccountService r100 = a();
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.t();
        }

        @Override // com.larus.account.base.api.IAccountService
        public final SettingsAccountInfo w() {
            IAccountService r100 = a();
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.w();
        }

        @Override // com.larus.account.base.api.IAccountService
        public final String d(String r100) {
            Intrinsics.checkNotNullParameter(r100, "scanResult");
            IAccountService r101 = a();
            if (r101 != null) goto L7;
            return null;
        L7:
            return r101.d(r100);
        }

        @Override // com.larus.account.base.api.IAccountService
        public final boolean e(Uri r100) {
            Intrinsics.checkNotNullParameter(r100, "uri");
            IAccountService r101 = a();
            if (r101 != null) goto L5;
        L7:
            return false;
        L5:
            if (r101.e(r100) != true) goto L7;
            return true;
        }

        @Override // com.larus.account.base.api.IAccountService
        public final void f(b0 r100) {
            Intrinsics.checkNotNullParameter(r100, "listener");
            IAccountService r101 = a();
            if (r101 == null) goto L6;
            r101.f(r100);
            return;
        }

        @Override // com.larus.account.base.api.IAccountService
        public final void i(SettingsAccountInfo r100) {
            IAccountService r101 = a();
            if (r101 == null) goto L6;
            r101.i(r100);
            return;
        }

        @Override // com.larus.account.base.api.IAccountService
        public final void j(int r100) {
            IAccountService r101 = a();
            if (r101 == null) goto L6;
            r101.j(r100);
            return;
        }

        @Override // com.larus.account.base.api.IAccountService
        public final void k(List<String> r100) {
            Intrinsics.checkNotNullParameter(r100, "hostList");
            IAccountService r101 = a();
            if (r101 == null) goto L6;
            r101.k(r100);
            return;
        }

        @Override // com.larus.account.base.api.IAccountService
        public final void l(b r100) {
            Intrinsics.checkNotNullParameter(r100, "userInfo");
            IAccountService r101 = a();
            if (r101 == null) goto L6;
            r101.l(r100);
            return;
        }

        @Override // com.larus.account.base.api.IAccountService
        public final void q(boolean r100) {
            IAccountService r101 = a();
            if (r101 == null) goto L6;
            r101.q(r100);
            return;
        }

        @Override // com.larus.account.base.api.IAccountService
        public final void s(b0 r100) {
            Intrinsics.checkNotNullParameter(r100, "listener");
            IAccountService r101 = a();
            if (r101 == null) goto L6;
            r101.s(r100);
            return;
        }

        @Override // com.larus.account.base.api.IAccountService
        public final Map u(String r100) {
            Intrinsics.checkNotNullParameter("GET", e.f25671s);
            Intrinsics.checkNotNullParameter(r100, "url");
            IAccountService r101 = a();
            if (r101 == null) goto L7;
            Map r102 = r101.u(r100);
            if (r102 == null) goto L7;
            return r102;
        L7:
            return MapsKt.emptyMap();
        }

        @Override // com.larus.account.base.api.IAccountService
        public final void v(JSONObject r100, Context r101) {
            Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
            IAccountService r102 = a();
            if (r102 == null) goto L6;
            r102.v(r100, r101);
            return;
        }

        @Override // com.larus.account.base.api.IAccountService
        public final boolean c(int r100, int r101, String r102) {
            Intrinsics.checkNotNullParameter(r102, WsConstants.KEY_PAYLOAD);
            IAccountService r103 = a();
            if (r103 != null) goto L5;
        L7:
            return false;
        L5:
            if (r103.c(r100, r101, r102) != true) goto L7;
            return true;
        }

        @Override // com.larus.account.base.api.IAccountService
        public final void o(String r100, String r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "appUserId");
            Intrinsics.checkNotNullParameter(r102, "source");
            IAccountService r103 = a();
            if (r103 == null) goto L6;
            r103.o(r100, r101, r102);
            return;
        }
    }

    static {
        f286094a = Companion.f286095b;
    }

    String b();

    boolean c(int r100, int r101, String r102);

    String d(String r100);

    boolean e(Uri r100);

    void f(b0 r100);

    void g();

    String getPrivacyPolicyUrl();

    b getUserInfo();

    boolean h();

    void i(SettingsAccountInfo r100);

    void j(int r100);

    void k(List<String> r100);

    void l(b r100);

    void m();

    void n();

    void o(String r100, String r101, String r102);

    boolean p();

    void q(boolean r100);

    boolean r();

    void s(b0 r100);

    Interceptor t();

    Map u(String r100);

    void v(JSONObject r100, Context r101);

    SettingsAccountInfo w();
}
