package com.larus.account.base.provider;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.larus.account.base.impl.n;
import com.larus.account.base.impl.s;
import com.larus.account.base.model.GetOauthTokenTriggerScene;
import com.larus.account.base.model.LoginPlatform;
import com.larus.home.impl.sdk.o0;
import com.larus.setting.impl.f3;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import n38.e;
import n38.m;
import n38.p;
import q38.l;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001JR\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\tH&JH\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H&J8\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u000b2\b\b\u0002\u0010\u0017\u001a\u00020\t2\b\b\u0002\u0010\u0018\u001a\u00020\t2\b\b\u0002\u0010\u0019\u001a\u00020\u001aH&J\n\u0010\u001b\u001a\u0004\u0018\u00010\u001cH&J\u0010\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u001eH&J\u0010\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020!H&J\u0010\u0010\"\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020#H&J \u0010$\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\t2\u0006\u0010&\u001a\u00020'2\u0006\u0010\u0006\u001a\u00020(H&J(\u0010)\u001a\u00020\u00032\u0006\u0010*\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020(H&J+\u0010,\u001a\u00020\u00032!\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00030-H&J+\u00100\u001a\u00020\u00032!\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00030-H&J\n\u00101\u001a\u0004\u0018\u000102H&J\b\u00103\u001a\u00020\u0003H&J\u0018\u00104\u001a\u00020\u00032\u0006\u00105\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u00066"}, d2 = {"Lcom/larus/account/base/provider/IThirdPartyPlatformLoginProvider;", "Lcom/larus/account/base/provider/ILoginProvider;", "login", "", "platform", "Lcom/larus/account/base/model/LoginPlatform;", "callback", "Lcom/larus/account/base/api/IAccountCallback;", "enableAgeGate", "", "businessScene", "", "ageGateManager", "Lcom/larus/account/base/provider/agegate/IAgeGateManagerInterface;", "trackerJson", "Lorg/json/JSONObject;", "activity", "Landroid/app/Activity;", "forceBindMobile", "loginByGoolgOneTap", "updateToken", "Lcom/larus/account/base/api/IAccountTokenUpdateCallback;", "token", "enableBindDirect", "isFromDelete", "extraInfo", "Landroid/os/Bundle;", "getPlatformUserInfo", "Lcom/larus/account/base/model/PlatformUserInfo;", "googleRequestAuth", "Lcom/larus/account/base/api/IGoogleAuthCallback;", "googleSignOut", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "bindPlatform", "Lcom/larus/account/base/api/IBindCallback;", "getDouYinAccessToken", "forceRequestServer", "triggerScene", "Lcom/larus/account/base/model/GetOauthTokenTriggerScene;", "Lcom/larus/account/base/api/IDouYinTokenUpdateCallback;", "updateAuthorizeInfo", "platformAppId", "authCode", "registerTokenAccessCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "unRegisterTokenAccessCallback", "getCacheDouYinAccessToken", "Lcom/larus/account/base/api/DouYinTokenResult;", "forceClearDouYinCacheToken", "loginWithProfileKey", "profileKey", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IThirdPartyPlatformLoginProvider extends ILoginProvider {
    void B(String r100, s r101);

    void b(String r100, o0 r101);

    e h();

    void j(f3 r100);

    void k(boolean r100, GetOauthTokenTriggerScene r101, p r102);

    void m(LoginPlatform r100, n r101, String r102, FragmentActivity r103, boolean r104);

    void n(LoginPlatform r100, n r101);

    void p(Context r100);

    void r(com.larus.live.impl.ttlivesdk.e r100);

    void t(m r100);

    void v();

    l x();

    void z(n38.l r100, String r101, Bundle r102);
}
