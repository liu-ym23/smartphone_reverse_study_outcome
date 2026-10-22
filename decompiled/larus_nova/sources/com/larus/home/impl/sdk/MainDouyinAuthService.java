package com.larus.home.impl.sdk;

import android.os.Bundle;
import com.larus.account.base.api.IDouyinAuthService;
import com.larus.account.base.api.IDouyinHeartBeatService;
import com.larus.account.base.api.ILoginService;
import com.larus.account.base.model.GetOauthTokenTriggerScene;
import com.larus.account.base.model.LoginPlatform;
import com.larus.account.base.provider.IThirdPartyPlatformLoginProvider;
import com.larus.login.api.CommonDouYinLoginUtil;
import com.larus.platform.api.ISdkDouyinAuth;
import com.larus.platform.api.SdkOauthTokenTriggerScene;
import com.larus.platform.api.c5;
import com.larus.platform.api.d5;
import com.larus.platform.api.e5;
import com.larus.platform.api.g5;
import com.larus.platform.api.h5;
import com.larus.platform.api.x4;
import com.larus.platform.api.z4;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0006H\u0016J\n\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J \u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J(\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J0\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J(\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020!H\u0016J(\u0010\"\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J9\u0010#\u001a\u0004\u0018\u00010\t2\u0006\u0010$\u001a\u00020\u00172\u0006\u0010%\u001a\u00020\u00172\u0006\u0010&\u001a\u00020\u00172\u0006\u0010'\u001a\u00020\t2\b\u0010\u0012\u001a\u0004\u0018\u00010(H\u0016¢\u0006\u0002\u0010)J(\u0010*\u001a\u00020\t2\u0006\u0010$\u001a\u00020\u00172\u0006\u0010%\u001a\u00020\u00172\u0006\u0010&\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020+H\u0016J\b\u0010,\u001a\u00020\tH\u0016J*\u0010-\u001a\u00020\t2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u000101H\u0016J\b\u00102\u001a\u00020\tH\u0016J\b\u00103\u001a\u00020\tH\u0016J\n\u00104\u001a\u0004\u0018\u000105H\u0002J\n\u00106\u001a\u0004\u0018\u000107H\u0002J\n\u00108\u001a\u0004\u0018\u000109H\u0002J\n\u0010:\u001a\u0004\u0018\u00010;H\u0002J\f\u0010<\u001a\u00020=*\u00020\u0011H\u0002J\f\u0010>\u001a\u00020\r*\u00020?H\u0002J\f\u0010@\u001a\u00020A*\u00020\u0013H\u0002J\f\u0010B\u001a\u00020C*\u00020\u0015H\u0002J\f\u0010D\u001a\u00020E*\u00020!H\u0002J\f\u0010F\u001a\u00020G*\u00020(H\u0002J\f\u0010H\u001a\u00020I*\u00020+H\u0002J\f\u0010J\u001a\u00020K*\u000201H\u0002R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006L"}, d2 = {"Lcom/larus/home/impl/sdk/MainDouyinAuthService;", "Lcom/larus/platform/api/ISdkDouyinAuth;", "<init>", "()V", "accountBindStatusListenerAdapters", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/larus/platform/api/SdkAccountBindStatusListener;", "Lcom/larus/account/base/api/IAccountBindStatusListener;", "registerAccountBindStatusListener", "", "listener", "unregisterAccountBindStatusListener", "getCachedDouyinToken", "Lcom/larus/platform/api/SdkDouyinToken;", "requestDouyinToken", "forceRequestServer", "triggerScene", "Lcom/larus/platform/api/SdkOauthTokenTriggerScene;", "callback", "Lcom/larus/platform/api/SdkDouyinTokenCallback;", "updateDouyinAccountToken", "Lcom/larus/platform/api/SdkAccountTokenUpdateCallback;", "token", "", "isFromDelete", "extraInfo", "Landroid/os/Bundle;", "updateDouyinProviderToken", "enableBindDirect", "bindDouyin", "platformAppId", "platform", "authCode", "Lcom/larus/platform/api/SdkBindCallback;", "updateDouyinAuthorizeInfo", "startDouyinAuth", "clientKey", "scope", "state", "isMiniApplication", "Lcom/larus/platform/api/SdkDouyinAuthCallback;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLcom/larus/platform/api/SdkDouyinAuthCallback;)Ljava/lang/Boolean;", "checkDouyinAuthStatus", "Lcom/larus/platform/api/SdkDouyinAuthStatusCallback;", "isDouyinHeartbeatImplemented", "tryDouyinHeartbeat", "delay", "", "immediate", "Lcom/larus/platform/api/SdkDouyinHeartbeatCallback;", "clearDouyinHeartbeatTokenCache", "hasDouyinHeartbeatSucceeded", "loginService", "Lcom/larus/account/base/api/ILoginService;", "douyinAuthService", "Lcom/larus/account/base/api/IDouyinAuthService;", "douyinHeartbeatService", "Lcom/larus/account/base/api/IDouyinHeartBeatService;", "douyinLoginProvider", "Lcom/larus/account/base/provider/IThirdPartyPlatformLoginProvider;", "toLegacyScene", "Lcom/larus/account/base/model/GetOauthTokenTriggerScene;", "toSdkToken", "Lcom/larus/account/base/api/DouYinTokenResult;", "toLegacyTokenCallback", "Lcom/larus/account/base/api/IDouYinTokenUpdateCallback;", "toLegacyAccountTokenCallback", "Lcom/larus/account/base/api/IAccountTokenUpdateCallback;", "toLegacyBindCallback", "Lcom/larus/account/base/api/IBindCallback;", "toLegacyAuthCallback", "Lcom/larus/account/base/api/IDouyinAuthCallback;", "toLegacyAuthStatusCallback", "Lcom/larus/account/base/api/IDouyinAuthStatusCheckCallback;", "toLegacyHeartbeatCallback", "Lcom/larus/account/base/api/HeartBeatResultCallback;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MainDouyinAuthService implements ISdkDouyinAuth {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<x4, n38.g> f346126a;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f346127a = null;

        static {
            int[] r100 = new int[SdkOauthTokenTriggerScene.values().length];
            r100[SdkOauthTokenTriggerScene.Request.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[SdkOauthTokenTriggerScene.ForegroundSwitch.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[SdkOauthTokenTriggerScene.ColdStart.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[SdkOauthTokenTriggerScene.Preload.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f346127a = r100;
        }
    }

    public static ILoginService l() {
        return (ILoginService) ServiceManager.get().getService(ILoginService.class);
    }

    @Override // com.larus.platform.api.ISdkDouyinAuth
    public final boolean e() {
        IDouyinHeartBeatService r100 = (IDouyinHeartBeatService) ServiceManager.get().getService(IDouyinHeartBeatService.class);
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.c() != true) goto L7;
        return true;
    }

    public MainDouyinAuthService() {
        this.f346126a = new ConcurrentHashMap();
    }

    @Override // com.larus.platform.api.ISdkDouyinAuth
    public final g5 b() {
        ILoginService r100 = l();
        if (r100 == null) goto L7;
        n38.e r101 = r100.Y(LoginPlatform.DOUYIN);
        if (r101 == null) goto L7;
        return new g5(r101.f516997a, r101.f516998b, r101.f516999c, r101.f517000d, r101.f517001e, r101.f517002f);
    L7:
        return null;
    }

    public static GetOauthTokenTriggerScene m(SdkOauthTokenTriggerScene r100) {
        int r101 = a.f346127a[r100.ordinal()];
        if (r101 == 1) goto L16;
        if (r101 == 2) goto L19;
        if (r101 == 3) goto L18;
        if (r101 != 4) goto L12;
        return GetOauthTokenTriggerScene.Preload;
    L12:
        throw new NoWhenBranchMatchedException();
    L18:
        return GetOauthTokenTriggerScene.ColdStart;
    L19:
        return GetOauthTokenTriggerScene.ForegroundSwitch;
    L16:
        return GetOauthTokenTriggerScene.Request;
    }

    @Override // com.larus.platform.api.ISdkDouyinAuth
    public final boolean c(com.bytedance.applet.impl.w1 r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        ILoginService r101 = l();
        if (r101 != null) goto L6;
        return false;
    L6:
        n38.g r102 = new i0(r100);
        n38.g r103 = this.f346126a.putIfAbsent(r100, r102);
        if (r103 == null) goto L10;
        r102 = r103;
    L10:
        r101.L(r102);
        return true;
    }

    @Override // com.larus.platform.api.ISdkDouyinAuth
    public final boolean g(String r100, z4 r101) {
        Intrinsics.checkNotNullParameter("8943", "platformAppId");
        Intrinsics.checkNotNullParameter("aweme_v2", "platform");
        Intrinsics.checkNotNullParameter(r100, "authCode");
        Intrinsics.checkNotNullParameter(r101, "callback");
        ILoginService r102 = l();
        if (r102 != null) goto L6;
        return false;
    L6:
        r102.q("8943", "aweme_v2", r100, new m0(r101));
        return true;
    }

    @Override // com.larus.platform.api.ISdkDouyinAuth
    public final boolean j(String r100, com.larus.login.api.c0 r101) {
        Intrinsics.checkNotNullParameter("8943", "platformAppId");
        Intrinsics.checkNotNullParameter("aweme_v2", "platform");
        Intrinsics.checkNotNullParameter(r100, "authCode");
        Intrinsics.checkNotNullParameter(r101, "callback");
        ILoginService r102 = l();
        if (r102 != null) goto L6;
        return false;
    L6:
        r102.b(r100, new o0(r101, this));
        return true;
    }

    @Override // com.larus.platform.api.ISdkDouyinAuth
    public final boolean a(boolean r100, SdkOauthTokenTriggerScene r101, h5 r102) {
        Intrinsics.checkNotNullParameter(r101, "triggerScene");
        Intrinsics.checkNotNullParameter(r102, "callback");
        ILoginService r103 = l();
        if (r103 != null) goto L6;
        return false;
    L6:
        r103.w(LoginPlatform.DOUYIN, r100, m(r101), new o0(r102, this));
        return true;
    }

    @Override // com.larus.platform.api.ISdkDouyinAuth
    public final boolean d(long r100, boolean r110, SdkOauthTokenTriggerScene r111, e5 r112) {
        Intrinsics.checkNotNullParameter(r111, "triggerScene");
        IDouyinHeartBeatService r101 = (IDouyinHeartBeatService) ServiceManager.get().getService(IDouyinHeartBeatService.class);
        if (r101 != null) goto L6;
        return false;
    L6:
        GetOauthTokenTriggerScene r102 = m(r111);
        if (r112 == null) goto L9;
        n0 r113 = new n0(r112);
    L10:
        r101.e(r100, r110, r102, r113);
        return true;
    L9:
        r113 = null;
        goto L10
    }

    @Override // com.larus.platform.api.ISdkDouyinAuth
    public final Boolean f(String r100, String r101, String r102, c5 r110) {
        Intrinsics.checkNotNullParameter(r100, "clientKey");
        Intrinsics.checkNotNullParameter(r101, "scope");
        Intrinsics.checkNotNullParameter(r102, "state");
        IDouyinAuthService r103 = (IDouyinAuthService) ServiceManager.get().getService(IDouyinAuthService.class);
        if (r103 != null) goto L7;
        return null;
    L7:
        return Boolean.valueOf(r103.b(r100, r101, r102, false, new k0(r110)));
    }

    @Override // com.larus.platform.api.ISdkDouyinAuth
    public final boolean h(CommonDouYinLoginUtil.k r100, String r101, boolean r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        Intrinsics.checkNotNullParameter(r101, "token");
        Intrinsics.checkNotNullParameter(r111, "extraInfo");
        ILoginService r102 = l();
        if (r102 != null) goto L6;
        return false;
    L6:
        r102.F(LoginPlatform.DOUYIN, new j0(r100), r101, r110, r111);
        return true;
    }

    @Override // com.larus.platform.api.ISdkDouyinAuth
    public final boolean i(String r100, String r101, String r102, d5 r103) {
        Intrinsics.checkNotNullParameter(r100, "clientKey");
        Intrinsics.checkNotNullParameter(r101, "scope");
        Intrinsics.checkNotNullParameter(r102, "state");
        Intrinsics.checkNotNullParameter(r103, "callback");
        IDouyinAuthService r104 = (IDouyinAuthService) ServiceManager.get().getService(IDouyinAuthService.class);
        if (r104 != null) goto L6;
        return false;
    L6:
        r104.a(r100, r101, r102, new l0(r103));
        return true;
    }

    @Override // com.larus.platform.api.ISdkDouyinAuth
    public final boolean k(com.bytedance.applet.aibridge.auth.d r100, String r101, boolean r102, boolean r103, Bundle r104) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        Intrinsics.checkNotNullParameter(r101, "token");
        Intrinsics.checkNotNullParameter(r104, "extraInfo");
        Iterator r105 = ServiceManager.get().getServices(IThirdPartyPlatformLoginProvider.class).iterator();
    L4:
        if (r105.hasNext() == false) goto L8;
        IThirdPartyPlatformLoginProvider r106 = (IThirdPartyPlatformLoginProvider) r105.next();
        if (r106.c() != LoginPlatform.DOUYIN) goto L4;
    L9:
        if (r106 != null) goto L12;
        return false;
    L12:
        r106.z(new j0(r100), r101, r104);
        return true;
    L8:
        r106 = null;
        goto L9
    }
}
