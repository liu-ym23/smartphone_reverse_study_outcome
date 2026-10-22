package com.larus.login.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import androidx.activity.result.ActivityResultLauncher;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.bmhome.bot.CommonSettingFragment;
import com.larus.platform.api.n4;
import com.larus.platform.api.r0;
import com.larus.setting.impl.SettingAccountInfoFragment;
import com.larus.trace.tracknode.TraceFragment;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000ð\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\nH&JD\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00032\u0016\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00122\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000f0\u0014H&J(\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00172\u0016\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0012H&J\b\u0010\u0018\u001a\u00020\bH&J0\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u001a\u001a\u00020\b2\b\b\u0002\u0010\u001b\u001a\u00020\b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0003H&J<\u0010\u0019\u001a\u00020\u000f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u001a\u001a\u00020\b2\b\b\u0002\u0010\u001b\u001a\u00020\b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0003H&J\u0010\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\bH&JB\u0010!\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u001e2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000f0#2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000f0#2\b\u0010%\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0003H&J`\u0010'\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u001e2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000f0#2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u000f0#2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u000f0#2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u000f0#2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u000f0#2\b\u0010%\u001a\u0004\u0018\u00010\u0003H&J\b\u0010,\u001a\u00020\u000fH&J\u0010\u0010-\u001a\u00020\u000f2\u0006\u0010.\u001a\u00020\u0003H&J\u0010\u0010/\u001a\u00020\b2\u0006\u0010.\u001a\u00020\u0003H&J\u001e\u00100\u001a\u00020\u000f2\f\u00101\u001a\b\u0012\u0004\u0012\u000203022\u0006\u00104\u001a\u000205H&JR\u00100\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u00104\u001a\u00020528\u00106\u001a4\u0012\u0013\u0012\u00110\b¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(:\u0012\u0015\u0012\u0013\u0018\u00010\u0003¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(;\u0012\u0004\u0012\u00020\u000f07H&Jb\u0010<\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010=\u001a\u00020\u00032\u0006\u0010>\u001a\u00020\u00032\u0006\u0010?\u001a\u00020\u000328\u00106\u001a4\u0012\u0013\u0012\u00110\b¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(:\u0012\u0015\u0012\u0013\u0018\u00010@¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(A\u0012\u0004\u0012\u00020\u000f07H&J(\u0010B\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\n2\b\u0010C\u001a\u0004\u0018\u00010D2\f\u0010E\u001a\b\u0012\u0004\u0012\u00020\u000f0#H&J\b\u0010F\u001a\u00020\bH&J\u0010\u0010G\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020HH&J\u0010\u0010I\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J\u0012\u0010J\u001a\u00020\u000f2\b\u0010K\u001a\u0004\u0018\u00010\u0003H&J$\u0010L\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020H2\b\u0010%\u001a\u0004\u0018\u00010\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010MH&J$\u0010N\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020H2\b\u0010%\u001a\u0004\u0018\u00010\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010MH&J\u0018\u0010O\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010P\u001a\u00020\bH&J\u0018\u0010Q\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010P\u001a\u00020\bH&J\u0019\u0010R\u001a\u00020\u000f2\n\b\u0002\u0010S\u001a\u0004\u0018\u00010\bH&¢\u0006\u0002\u0010TJ\b\u0010U\u001a\u00020\bH&J \u0010V\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020H2\u0006\u00104\u001a\u0002052\u0006\u0010\u0013\u001a\u00020WH&J\b\u0010X\u001a\u00020\u000fH&J\u0010\u0010Y\u001a\u00020\b2\u0006\u0010Z\u001a\u00020\bH&J\u0010\u0010[\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001eH&J\u0010\u0010\\\u001a\u00020\u000f2\u0006\u0010]\u001a\u00020^H&J\u0010\u0010_\u001a\u00020\u000f2\u0006\u0010]\u001a\u00020^H&J\b\u0010`\u001a\u00020\bH&J\b\u0010a\u001a\u00020\bH&JB\u0010b\u001a\u00020\u000f2\u0006\u0010c\u001a\u00020d2\u0006\u0010\t\u001a\u00020\n2\b\u0010e\u001a\u0004\u0018\u00010f2\b\u0010g\u001a\u0004\u0018\u00010h2\b\b\u0002\u0010\u001b\u001a\u00020\b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0003H&J\u0010\u0010i\u001a\u00020\u000f2\u0006\u0010c\u001a\u00020dH&J\"\u0010j\u001a\u0004\u0018\u00010k2\u0006\u0010l\u001a\u00020m2\u0006\u0010n\u001a\u00020o2\u0006\u0010p\u001a\u00020qH&J\u0010\u0010r\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020HH&J\b\u0010s\u001a\u00020\bH&Ju\u0010t\u001a\u00020\u000f2\u0006\u0010u\u001a\u00020v2O\b\u0002\u0010w\u001aI\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(y\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(z\u0012\u0013\u0012\u00110q¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(p\u0012\u0004\u0012\u00020\u000f\u0018\u00010x2\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020{\u0012\u0004\u0012\u00020\u000f0\u0014H&J\u0018\u0010|\u001a\u00020}2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010~\u001a\u00020\u0003H&¨\u0006\u007f"}, d2 = {"Lcom/larus/login/api/ILoginApi;", "", "getTermsOfServiceUrl", "", "getPrivacyPolicyUrl", "getAccountRiskImpl", "Lcom/larus/login/api/IAccountRiskApi;", "checkPageStatus", "", WidgetService.PARAM_FRAGMENT, "Landroidx/fragment/app/Fragment;", "createMultiAccountUiController", "Lcom/larus/platform/api/MultiAccountUiController;", "hostFragment", "switchAccountFromAccountManagement", "", "secUid", "trackInfo", "", "callback", "Lkotlin/Function1;", "addAccountFromAccountManagement", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "profileFeatureAvailable", "goMainActivity", "isTouristMode", "isFromVerificationCode", "pendingDeeplinkSchema", "activity", "Landroidx/fragment/app/FragmentActivity;", "doAccountBanned", "canShowAppealDialog", "openLogoutDialog", "confirmCallback", "Lkotlin/Function0;", "cancelCallback", "businessScene", "customTips", "openLogoutChooseDialog", "logoutCallback", "logoutAllCallback", "confirmLogoutAllCallback", "cancelLogoutAllCallback", "cleanLoginFailedInfo", "requestLaunchInfo", "from", "completeLoginForActiveAppPage", "goToSwitchBind", "switchBindLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "switchBindParam", "Lcom/larus/login/api/SwitchBindParam;", "onResult", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "success", "latestError", "goToChangeBind", "errorMsg", "authToken", "profileKey", "", "errorCode", "popupForceBind", "bundle", "Landroid/os/Bundle;", "doAfterBind", "needForceBindDouyinExp", "needSaveActivityWhenFinishAll", "Landroid/app/Activity;", "isForceBindDialogShow", "setCustomLogoutMessage", "message", "doLogout", "Lcom/larus/login/api/callback/LogoutCallBack;", "doLogoutAll", "jumpToBindPhoneNumber", "fromH5", "jumpToChangePhoneNumber", "setNeedRegister", "need", "(Ljava/lang/Boolean;)V", "getNeedRegister", "startCommonSwitchBinder", "Lcom/larus/login/api/SwitchBindCallback;", "intConfig", "canSkipCheckTourist", "isActivityEntrance", "showAccountReusedTips", "addLoginShutdownStateListener", "listener", "Lcom/larus/platform/api/ILoginShutdownListener;", "removeLoginShutdownStateListener", "getCurrentShutdownState", "isAccountReusedShowing", "observerLaunchInfoData", "viewLifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "dialog", "Lcom/larus/common_ui/dialog/CommonLoadDialog;", "countDownTimer", "Landroid/os/CountDownTimer;", "removeObserverLaunchInfoData", "showNotifyBinderDialog", "Lcom/larus/login/api/INotifyBinderDialog;", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "binderConfig", "Lcom/larus/login/api/BinderConfig;", "dialogType", "Lcom/larus/login/api/NotifyBinderDialogType;", "isAppSupportDouyinAuthorization", "isHitLoginDialogNewStyle", "tryToBindDouYinForPurchase", "params", "Lcom/larus/platform/model/ecommerce/ECBindDouYinParams;", "onDialogShow", "Lkotlin/Function3;", "page", "source", "Lcom/larus/platform/model/ecommerce/ECBindDouYinResult;", "generateLearnMoreSpan", "Landroid/text/SpannableStringBuilder;", "checkDescText", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ILoginApi {
    f0 A();

    void B();

    void C(FragmentActivity r100, Function0 r101, Function0 r102, Function0 r103, Function0 r104, Function0 r105);

    void D(Fragment r100, Bundle r101, com.larus.bmhome.chat.i0 r102);

    void E(Boolean r100);

    void F(FragmentActivity r100, SwitchBindParam r101, Function2<? super Boolean, ? super String, Unit> r102);

    void G(ActivityResultLauncher<Intent> r100, SwitchBindParam r101);

    void H(Activity r100, String r101, com.larus.xbridge.custom.s r102);

    boolean I(FragmentActivity r100);

    void J(LifecycleOwner r100);

    boolean K(FragmentActivity r100, Map r101);

    boolean L();

    g0 M(FragmentManager r100, h r101, NotifyBinderDialogType r102);

    void N(String r100);

    boolean O();

    boolean P();

    boolean a(Activity r100);

    String b();

    void e();

    void f(r0 r100);

    SpannableStringBuilder g(Context r100, String r101);

    String getPrivacyPolicyUrl();

    n4 h(CommonSettingFragment r100);

    boolean i(Fragment r100);

    void j(r0 r100);

    boolean k();

    boolean l();

    void m(uq9.d r100, com.larus.login.api.ecommerce.f r101, com.larus.login.api.ecommerce.g r102);

    void n();

    void o(Activity r100, String r101, com.larus.xbridge.custom.t r102);

    void p(TraceFragment r100, boolean r101, boolean r102, String r103);

    void q(Context r100, boolean r101);

    boolean r(FragmentActivity r100, String r101, String r102, String r103, CommonDouYinLoginUtil.f r104);

    boolean s(SettingAccountInfoFragment r100);

    void t();

    void u(Fragment r100, String r101, Map r102, com.larus.xbridge.custom.f0 r103);

    void v(FragmentActivity r100);

    void w(Context r100, boolean r101);

    void x(FragmentActivity r100, Function0 r101, Function0 r102, String r103);

    boolean y();

    void z(LifecycleOwner r100, Fragment r101, boolean r102, String r103);
}
