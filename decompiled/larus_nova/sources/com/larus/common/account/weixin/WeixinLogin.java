package com.larus.common.account.weixin;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import c09.c;
import com.bytedance.sdk.account.platform.IPlatformBindAdapter;
import com.bytedance.sdk.account.platform.PlatformBindAdapter;
import com.bytedance.sdk.account.platform.api.IWeixinService;
import com.bytedance.sdk.account.platform.base.AuthorizeFramework;
import com.bytedance.sdk.account.platform.weixin.WeixinServiceIniter;
import com.larus.account.base.impl.n;
import com.larus.account.base.impl.s;
import com.larus.account.base.model.GetOauthTokenTriggerScene;
import com.larus.account.base.model.LoginPlatform;
import com.larus.account.base.provider.IThirdPartyPlatformLoginProvider;
import com.larus.common.apphost.AppHost;
import com.larus.home.impl.sdk.o0;
import com.larus.setting.impl.f3;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import n38.e;
import n38.m;
import n38.p;
import q38.l;
import ta7.i;
import ua7.h;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 B2\u00020\u0001:\u0001BB\u0007¢\u0006\u0004\b\u0002\u0010\u0003JP\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u0011H\u0016JH\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J0\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u00112\u0006\u0010!\u001a\u00020\"H\u0016J\b\u0010#\u001a\u00020\u000bH\u0016J\b\u0010$\u001a\u00020\rH\u0016J$\u0010%\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020\u00112\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\n\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u0010\u0010)\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020*H\u0016J\u0010\u0010+\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020-H\u0016J\u0010\u0010.\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020/H\u0016J \u00100\u001a\u00020\u000b2\u0006\u00101\u001a\u00020\u00112\u0006\u00102\u001a\u0002032\u0006\u0010\u000e\u001a\u000204H\u0016J(\u00105\u001a\u00020\u000b2\u0006\u00106\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u00132\u0006\u00107\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u000204H\u0016J+\u00108\u001a\u00020\u000b2!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b:\u0012\b\b;\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u000b09H\u0016J+\u0010<\u001a\u00020\u000b2!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b:\u0012\b\b;\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u000b09H\u0016J\n\u0010=\u001a\u0004\u0018\u00010>H\u0016J\b\u0010?\u001a\u00020\u000bH\u0016J\u0018\u0010@\u001a\u00020\u000b2\u0006\u0010A\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006C"}, d2 = {"Lcom/larus/common/account/weixin/WeixinLogin;", "Lcom/larus/account/base/provider/IThirdPartyPlatformLoginProvider;", "<init>", "()V", "platformCallback", "Lcom/bytedance/sdk/account/platform/PlatformLoginAdapter;", "getPlatformCallback", "()Lcom/bytedance/sdk/account/platform/PlatformLoginAdapter;", "setPlatformCallback", "(Lcom/bytedance/sdk/account/platform/PlatformLoginAdapter;)V", "login", "", "platform", "Lcom/larus/account/base/model/LoginPlatform;", "callback", "Lcom/larus/account/base/api/IAccountCallback;", "enableAgeGate", "", "businessScene", "", "ageGateManager", "Lcom/larus/account/base/provider/agegate/IAgeGateManagerInterface;", "trackerJson", "Lorg/json/JSONObject;", "activity", "Landroid/app/Activity;", "forceBindMobile", "loginByGoolgOneTap", "updateToken", "Lcom/larus/account/base/api/IAccountTokenUpdateCallback;", "token", "enableBindDirect", "isFromDelete", "extraInfo", "Landroid/os/Bundle;", "init", "providePlatform", "logout", "forceLogout", "getPlatformUserInfo", "Lcom/larus/account/base/model/PlatformUserInfo;", "googleRequestAuth", "Lcom/larus/account/base/api/IGoogleAuthCallback;", "googleSignOut", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "bindPlatform", "Lcom/larus/account/base/api/IBindCallback;", "getDouYinAccessToken", "forceRequestServer", "triggerScene", "Lcom/larus/account/base/model/GetOauthTokenTriggerScene;", "Lcom/larus/account/base/api/IDouYinTokenUpdateCallback;", "updateAuthorizeInfo", "platformAppId", "authCode", "registerTokenAccessCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "unRegisterTokenAccessCallback", "getCacheDouYinAccessToken", "Lcom/larus/account/base/api/DouYinTokenResult;", "forceClearDouYinCacheToken", "loginWithProfileKey", "profileKey", "Companion", "weixinlogin_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WeixinLogin implements IThirdPartyPlatformLoginProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c09.a f326233a;

    public static final class a {
    }

    /* JADX INFO: loaded from: classes27.dex */
    public static final class b extends PlatformBindAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ m f326234a;

        @Override // com.bytedance.sdk.account.platform.IPlatformBindAdapter
        public final void onBindError(h r100) {
            m r101 = this.f326234a;
            if (r100 == null) goto L5;
            int r102 = r100.f549253g;
        L7:
            if (r100 == null) goto L10;
            String r103 = r100.f549280q;
            if (r103 == null) goto L10;
        L16:
            r101.a(r102, r103, null, null);
            return;
        L10:
            if (r100 == null) goto L12;
            String r104 = r100.f549255i;
        L13:
            if (r104 != null) goto L15;
            r104 = "";
        L15:
            r103 = r104;
            goto L16
        L12:
            r104 = null;
            goto L13
        L5:
            r102 = -1;
            goto L7
        }

        @Override // com.bytedance.sdk.account.platform.IPlatformBindAdapter
        public final void onBindSuccess(h r100) {
            this.f326234a.onSuccess(null);
        }

        public b(m r100, Application r101) {
            this.f326234a = r100;
            super(r101, "15210", "weixin");
        }

        @Override // com.bytedance.sdk.account.platform.IPlatformBindAdapter
        public final void onBindExist(h r100, String r101, String r102, String r103, IPlatformBindAdapter.BindController r104) {
            m r105 = this.f326234a;
            if (r100 == null) goto L5;
            int r106 = r100.f549253g;
        L6:
            if (r101 != null) goto L8;
            r101 = "";
        L8:
            r105.a(r106, r101, null, null);
            return;
        L5:
            r106 = -1;
            goto L6
        }
    }

    static {
    }

    public WeixinLogin() {
    }

    @Override // com.larus.account.base.provider.IThirdPartyPlatformLoginProvider
    public final void b(String r100, o0 r101) {
        Intrinsics.checkNotNullParameter("8943", "platformAppId");
        Intrinsics.checkNotNullParameter("aweme_v2", "platform");
        Intrinsics.checkNotNullParameter(r100, "authCode");
        Intrinsics.checkNotNullParameter(r101, "callback");
    }

    @Override // com.larus.account.base.provider.IThirdPartyPlatformLoginProvider
    public final e h() {
        return null;
    }

    @Override // com.larus.account.base.provider.IThirdPartyPlatformLoginProvider
    public final void j(f3 r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
    }

    @Override // com.larus.account.base.provider.IThirdPartyPlatformLoginProvider
    public final void k(boolean r100, GetOauthTokenTriggerScene r101, p r102) {
        Intrinsics.checkNotNullParameter(r101, "triggerScene");
        Intrinsics.checkNotNullParameter(r102, "callback");
    }

    @Override // com.larus.account.base.provider.IThirdPartyPlatformLoginProvider
    public final void n(LoginPlatform r100, n r101) {
        Intrinsics.checkNotNullParameter(r100, "platform");
        Intrinsics.checkNotNullParameter(r101, "callback");
    }

    @Override // com.larus.account.base.provider.IThirdPartyPlatformLoginProvider
    public final void p(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    @Override // com.larus.account.base.provider.IThirdPartyPlatformLoginProvider
    public final void r(com.larus.live.impl.ttlivesdk.e r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
    }

    @Override // com.larus.account.base.provider.IThirdPartyPlatformLoginProvider
    public final void v() {
    }

    @Override // com.larus.account.base.provider.ILoginProvider
    public final void init() {
        FLogger.f375446a.i("WeixinLogin", "init");
        AuthorizeFramework.init(AppHost.f326268a.getApplication(), new WeixinServiceIniter[]{new WeixinServiceIniter("wx75f04c8595ccb9f6")});
    }

    @Override // com.larus.account.base.provider.IThirdPartyPlatformLoginProvider
    public final l x() {
        cra.a r100 = (cra.a) ((HashMap) com.bytedance.sdk.account.impl.h.a().l().f541362c).get("weixin");
        if (r100 != null) goto L7;
        return null;
    L7:
        return new l(r100.f465121c, r100.f465122d);
    }

    @Override // com.larus.account.base.provider.ILoginProvider
    public final LoginPlatform c() {
        return LoginPlatform.WEIXIN;
    }

    @Override // com.larus.account.base.provider.IThirdPartyPlatformLoginProvider
    public final void t(m r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        b r101 = new b(r100, AppHost.f326268a.getApplication());
        IWeixinService r102 = (IWeixinService) AuthorizeFramework.getService(IWeixinService.class);
        if (r102 == null) goto L6;
        r102.authorize(IWeixinService.Scope.WX_SCOPE_INFO, "wx_authorize", r101);
        return;
    }

    @Override // com.larus.account.base.provider.IThirdPartyPlatformLoginProvider
    public final void B(String r100, s r101) {
        Intrinsics.checkNotNullParameter(r100, "profileKey");
        Intrinsics.checkNotNullParameter(r101, "callback");
        i r102 = com.bytedance.sdk.account.impl.p.t();
        com.bytedance.sdk.account.impl.p r103 = (com.bytedance.sdk.account.impl.p) r102;
        r103.v("15210", "weixin", r100, MapsKt.mapOf(TuplesKt.to("app_name", AppHost.f326268a.getAppName())), new c09.b(r101, this));
    }

    @Override // com.larus.account.base.provider.ILoginProvider
    public final void o(n38.h r100, String r101) {
        FLogger.f375446a.i("WeixinLogin", "logout");
        if (r100 == null) goto L6;
        n38.h.a.b(r100, LoginPlatform.WEIXIN, r101);
        return;
    }

    @Override // com.larus.account.base.provider.IThirdPartyPlatformLoginProvider
    public final void z(n38.l r100, String r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        Intrinsics.checkNotNullParameter(r101, "token");
        Intrinsics.checkNotNullParameter(r102, "extraInfo");
        c r103 = new c(r100);
        IWeixinService r104 = (IWeixinService) AuthorizeFramework.getService(IWeixinService.class);
        if (r104 == null) goto L6;
        r104.authorize(IWeixinService.Scope.WX_SCOPE_INFO, "wx_authorize", r103);
        return;
    }

    @Override // com.larus.account.base.provider.IThirdPartyPlatformLoginProvider
    public final void m(LoginPlatform r110, n r111, String r112, FragmentActivity r113, boolean r114) {
        Intrinsics.checkNotNullParameter(r110, "platform");
        Intrinsics.checkNotNullParameter(r111, "callback");
        c09.a r100 = new c09.a(r111, r110, r112, AppHost.f326268a.getApplication().getApplicationContext());
        if (r114 == false) goto L5;
        r100.setLoginAndBindThirdMobileMode(true);
        r100.setLoginMustBindMobile(true);
    L5:
        this.f326233a = r100;
        IWeixinService r115 = (IWeixinService) AuthorizeFramework.getService(IWeixinService.class);
        if (r115 == null) goto L8;
        Boolean r116 = Boolean.valueOf(r115.authorize(IWeixinService.Scope.WX_SCOPE_INFO, "wx_authorize", this.f326233a));
    L10:
        if (Intrinsics.areEqual(r116, Boolean.TRUE) == true) goto L13;
        n38.h.a.a(r111, r110, -1, "IWeixin2Service authorize exception", r112, null, null, null, null, 480);
        return;
    L13:
        return;
    L8:
        r116 = null;
        goto L10
    }
}
