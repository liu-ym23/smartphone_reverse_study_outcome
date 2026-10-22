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
import com.android.ttcjpaysdk.bdpay.counter.outer.fallback.event.OuterPayFallbackReport;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.bmhome.bot.CommonSettingFragment;
import com.larus.platform.api.n4;
import com.larus.platform.api.r0;
import com.larus.setting.impl.SettingAccountInfoFragment;
import com.larus.trace.tracknode.TraceFragment;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000ø\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u000fH\u0016JD\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\n2\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0018\u00010\u00172\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00140\u001aH\u0016J(\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u001d2\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0018\u00010\u0017H\u0016J\b\u0010\u001e\u001a\u00020\rH\u0016J*\u0010\u001f\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\r2\b\u0010\"\u001a\u0004\u0018\u00010\nH\u0016J6\u0010\u001f\u001a\u00020\u00142\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\r2\b\u0010\"\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010%\u001a\u00020\u00142\u0006\u0010&\u001a\u00020\rH\u0016J@\u0010'\u001a\u00020\u00142\u0006\u0010#\u001a\u00020$2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00140)2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00140)2\b\u0010+\u001a\u0004\u0018\u00010\n2\b\u0010,\u001a\u0004\u0018\u00010\nH\u0016J`\u0010-\u001a\u00020\u00142\u0006\u0010#\u001a\u00020$2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00140)2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00140)2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00140)2\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u00140)2\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u00140)2\b\u0010+\u001a\u0004\u0018\u00010\nH\u0016J\b\u00102\u001a\u00020\u0014H\u0016J\u0010\u00103\u001a\u00020\u00142\u0006\u00104\u001a\u00020\nH\u0016J\u0010\u00105\u001a\u00020\r2\u0006\u00104\u001a\u00020\nH\u0016J\u001e\u00106\u001a\u00020\u00142\f\u00107\u001a\b\u0012\u0004\u0012\u000209082\u0006\u0010:\u001a\u00020;H\u0016JR\u00106\u001a\u00020\u00142\u0006\u0010#\u001a\u00020$2\u0006\u0010:\u001a\u00020;28\u0010<\u001a4\u0012\u0013\u0012\u00110\r¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(@\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(A\u0012\u0004\u0012\u00020\u00140=H\u0016Jb\u0010B\u001a\u00020\r2\u0006\u0010#\u001a\u00020$2\u0006\u0010C\u001a\u00020\n2\u0006\u0010D\u001a\u00020\n2\u0006\u0010E\u001a\u00020\n28\u0010<\u001a4\u0012\u0013\u0012\u00110\r¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(@\u0012\u0015\u0012\u0013\u0018\u00010F¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(G\u0012\u0004\u0012\u00020\u00140=H\u0016J(\u0010H\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010I\u001a\u0004\u0018\u00010J2\f\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00140)H\u0016J\b\u0010L\u001a\u00020\rH\u0016J\u0010\u0010M\u001a\u00020\r2\u0006\u0010#\u001a\u00020NH\u0016J\u0010\u0010O\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010P\u001a\u00020QH\u0016J\u0012\u0010R\u001a\u00020\u00142\b\u0010S\u001a\u0004\u0018\u00010\nH\u0016J$\u0010T\u001a\u00020\u00142\u0006\u0010#\u001a\u00020N2\b\u0010+\u001a\u0004\u0018\u00010\n2\b\u0010\u0019\u001a\u0004\u0018\u00010UH\u0016J$\u0010V\u001a\u00020\u00142\u0006\u0010#\u001a\u00020N2\b\u0010+\u001a\u0004\u0018\u00010\n2\b\u0010\u0019\u001a\u0004\u0018\u00010UH\u0016J\u0018\u0010W\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010X\u001a\u00020\rH\u0016J\u0018\u0010Y\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010X\u001a\u00020\rH\u0016J\u0017\u0010Z\u001a\u00020\u00142\b\u0010[\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0002\u0010\\J\b\u0010]\u001a\u00020\rH\u0016J \u0010^\u001a\u00020\u00142\u0006\u0010#\u001a\u00020N2\u0006\u0010:\u001a\u00020;2\u0006\u0010\u0019\u001a\u00020_H\u0016J\b\u0010`\u001a\u00020\u0014H\u0016J\u0010\u0010a\u001a\u00020\r2\u0006\u0010b\u001a\u00020\rH\u0016J\u0010\u0010c\u001a\u00020\r2\u0006\u0010#\u001a\u00020$H\u0016J\u0010\u0010d\u001a\u00020\u00142\u0006\u0010e\u001a\u00020fH\u0016J\u0010\u0010g\u001a\u00020\u00142\u0006\u0010e\u001a\u00020fH\u0016J\b\u0010h\u001a\u00020\rH\u0016J\b\u0010i\u001a\u00020\rH\u0016J>\u0010j\u001a\u00020\u00142\u0006\u0010k\u001a\u00020l2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010m\u001a\u0004\u0018\u00010n2\b\u0010o\u001a\u0004\u0018\u00010p2\u0006\u0010!\u001a\u00020\r2\b\u0010\"\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010q\u001a\u00020\u00142\u0006\u0010k\u001a\u00020lH\u0016J\"\u0010r\u001a\u0004\u0018\u00010s2\u0006\u0010t\u001a\u00020u2\u0006\u0010v\u001a\u00020w2\u0006\u0010x\u001a\u00020yH\u0016J\u0010\u0010z\u001a\u00020\r2\u0006\u0010#\u001a\u00020NH\u0016J\b\u0010{\u001a\u00020\rH\u0016Jw\u0010|\u001a\u00020\u00142\u0006\u0010}\u001a\u00020~2P\u0010\u007f\u001aL\u0012\u0014\u0012\u00120\n¢\u0006\r\b>\u0012\t\b?\u0012\u0005\b\b(\u0081\u0001\u0012\u0014\u0012\u00120\n¢\u0006\r\b>\u0012\t\b?\u0012\u0005\b\b(\u0082\u0001\u0012\u0013\u0012\u00110y¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(x\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0080\u00012\u0013\u0010\u0019\u001a\u000f\u0012\u0005\u0012\u00030\u0083\u0001\u0012\u0004\u0012\u00020\u00140\u001aH\u0016J\u001b\u0010\u0084\u0001\u001a\u00030\u0085\u00012\u0006\u0010\u001c\u001a\u00020\u001d2\u0007\u0010\u0086\u0001\u001a\u00020\nH\u0016R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0087\u0001"}, d2 = {"Lcom/larus/login/api/LoginService;", "Lcom/larus/login/api/ILoginApi;", "<init>", "()V", OuterPayFallbackReport.RETAIN_ACTION_IMP, "getImp", "()Lcom/larus/login/api/ILoginApi;", "imp$delegate", "Lkotlin/Lazy;", "getPrivacyPolicyUrl", "", "getTermsOfServiceUrl", "checkPageStatus", "", WidgetService.PARAM_FRAGMENT, "Landroidx/fragment/app/Fragment;", "createMultiAccountUiController", "Lcom/larus/platform/api/MultiAccountUiController;", "hostFragment", "switchAccountFromAccountManagement", "", "secUid", "trackInfo", "", "", "callback", "Lkotlin/Function1;", "addAccountFromAccountManagement", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "profileFeatureAvailable", "goMainActivity", "isTouristMode", "isFromVerificationCode", "pendingDeeplinkSchema", "activity", "Landroidx/fragment/app/FragmentActivity;", "doAccountBanned", "canShowAppealDialog", "openLogoutDialog", "confirmCallback", "Lkotlin/Function0;", "cancelCallback", "businessScene", "customTips", "openLogoutChooseDialog", "logoutCallback", "logoutAllCallback", "confirmLogoutAllCallback", "cancelLogoutAllCallback", "cleanLoginFailedInfo", "requestLaunchInfo", "from", "completeLoginForActiveAppPage", "goToSwitchBind", "switchBindLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "switchBindParam", "Lcom/larus/login/api/SwitchBindParam;", "onResult", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "success", "latestError", "goToChangeBind", "errorMsg", "authToken", "profileKey", "", "errorCode", "popupForceBind", "bundle", "Landroid/os/Bundle;", "doAfterBind", "needForceBindDouyinExp", "needSaveActivityWhenFinishAll", "Landroid/app/Activity;", "isForceBindDialogShow", "getAccountRiskImpl", "Lcom/larus/login/api/IAccountRiskApi;", "setCustomLogoutMessage", "message", "doLogout", "Lcom/larus/login/api/callback/LogoutCallBack;", "doLogoutAll", "jumpToBindPhoneNumber", "fromH5", "jumpToChangePhoneNumber", "setNeedRegister", "need", "(Ljava/lang/Boolean;)V", "getNeedRegister", "startCommonSwitchBinder", "Lcom/larus/login/api/SwitchBindCallback;", "intConfig", "canSkipCheckTourist", "isActivityEntrance", "showAccountReusedTips", "addLoginShutdownStateListener", "listener", "Lcom/larus/platform/api/ILoginShutdownListener;", "removeLoginShutdownStateListener", "getCurrentShutdownState", "isAccountReusedShowing", "observerLaunchInfoData", "viewLifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "dialog", "Lcom/larus/common_ui/dialog/CommonLoadDialog;", "countDownTimer", "Landroid/os/CountDownTimer;", "removeObserverLaunchInfoData", "showNotifyBinderDialog", "Lcom/larus/login/api/INotifyBinderDialog;", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "binderConfig", "Lcom/larus/login/api/BinderConfig;", "dialogType", "Lcom/larus/login/api/NotifyBinderDialogType;", "isAppSupportDouyinAuthorization", "isHitLoginDialogNewStyle", "tryToBindDouYinForPurchase", "params", "Lcom/larus/platform/model/ecommerce/ECBindDouYinParams;", "onDialogShow", "Lkotlin/Function3;", "page", "source", "Lcom/larus/platform/model/ecommerce/ECBindDouYinResult;", "generateLearnMoreSpan", "Landroid/text/SpannableStringBuilder;", "checkDescText", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LoginService implements ILoginApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LoginService f356989a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f356990b = null;

    /* JADX INFO: loaded from: classes30.dex */
    public static final class a implements f0 {
        public a() {
        }

        @Override // com.larus.login.api.f0
        public final void setup() {
        }
    }

    private LoginService() {
    }

    static {
        f356989a = new LoginService();
        f356990b = LazyKt.lazy(new j0());
    }

    public static ILoginApi c() {
        return (ILoginApi) f356990b.getValue();
    }

    @Override // com.larus.login.api.ILoginApi
    public final f0 A() {
        ILoginApi r100 = c();
        if (r100 == null) goto L7;
        f0 r101 = r100.A();
        if (r101 == null) goto L7;
        return r101;
    L7:
        return new a();
    }

    @Override // com.larus.login.api.ILoginApi
    public final void B() {
        Intrinsics.checkNotNullParameter("oneLogin", "from");
        ILoginApi r100 = c();
        if (r100 == null) goto L6;
        r100.B();
        return;
    }

    @Override // com.larus.login.api.ILoginApi
    public final boolean L() {
        ILoginApi r100 = c();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.L();
    }

    @Override // com.larus.login.api.ILoginApi
    public final boolean O() {
        ILoginApi r100 = c();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.O();
    }

    @Override // com.larus.login.api.ILoginApi
    public final boolean P() {
        ILoginApi r100 = c();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.P();
    }

    @Override // com.larus.login.api.ILoginApi
    public final String b() {
        ILoginApi r100 = c();
        if (r100 == null) goto L5;
        String r101 = r100.b();
    L6:
        if (r101 != null) goto L9;
        return "";
    L9:
        return r101;
    L5:
        r101 = null;
        goto L6
    }

    @Override // com.larus.login.api.ILoginApi
    public final void e() {
        ILoginApi r100 = c();
        if (r100 == null) goto L6;
        r100.e();
        return;
    }

    @Override // com.larus.login.api.ILoginApi
    public final String getPrivacyPolicyUrl() {
        ILoginApi r100 = c();
        if (r100 == null) goto L5;
        String r101 = r100.getPrivacyPolicyUrl();
    L6:
        if (r101 != null) goto L9;
        return "";
    L9:
        return r101;
    L5:
        r101 = null;
        goto L6
    }

    @Override // com.larus.login.api.ILoginApi
    public final boolean k() {
        ILoginApi r100 = c();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.k();
    }

    @Override // com.larus.login.api.ILoginApi
    public final boolean l() {
        ILoginApi r100 = c();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.l();
    }

    @Override // com.larus.login.api.ILoginApi
    public final void n() {
        ILoginApi r100 = c();
        if (r100 == null) goto L6;
        r100.n();
        return;
    }

    @Override // com.larus.login.api.ILoginApi
    public final void t() {
        ILoginApi r100 = c();
        if (r100 == null) goto L6;
        r100.t();
        return;
    }

    @Override // com.larus.login.api.ILoginApi
    public final boolean y() {
        ILoginApi r100 = c();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.y();
    }

    @Override // com.larus.login.api.ILoginApi
    public final void E(Boolean r100) {
        ILoginApi r101 = c();
        if (r101 == null) goto L6;
        r101.E(r100);
        return;
    }

    @Override // com.larus.login.api.ILoginApi
    public final boolean I(FragmentActivity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        ILoginApi r101 = c();
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.I(r100);
    }

    @Override // com.larus.login.api.ILoginApi
    public final void J(LifecycleOwner r100) {
        Intrinsics.checkNotNullParameter(r100, "viewLifecycleOwner");
        ILoginApi r101 = c();
        if (r101 == null) goto L6;
        r101.J(r100);
        return;
    }

    @Override // com.larus.login.api.ILoginApi
    public final void N(String r100) {
        ILoginApi r101 = c();
        if (r101 == null) goto L6;
        r101.N(r100);
        return;
    }

    @Override // com.larus.login.api.ILoginApi
    public final boolean a(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        ILoginApi r101 = c();
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.a(r100);
    }

    @Override // com.larus.login.api.ILoginApi
    public final void f(r0 r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        ILoginApi r101 = c();
        if (r101 == null) goto L6;
        r101.f(r100);
        return;
    }

    @Override // com.larus.login.api.ILoginApi
    public final n4 h(CommonSettingFragment r100) {
        Intrinsics.checkNotNullParameter(r100, "hostFragment");
        ILoginApi r101 = c();
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.h(r100);
    }

    @Override // com.larus.login.api.ILoginApi
    public final boolean i(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        ILoginApi r101 = c();
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.i(r100);
    }

    @Override // com.larus.login.api.ILoginApi
    public final void j(r0 r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        ILoginApi r101 = c();
        if (r101 == null) goto L6;
        r101.j(r100);
        return;
    }

    @Override // com.larus.login.api.ILoginApi
    public final boolean s(SettingAccountInfoFragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        ILoginApi r101 = c();
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.s(r100);
    }

    @Override // com.larus.login.api.ILoginApi
    public final void v(FragmentActivity r100) {
        ILoginApi r101 = c();
        if (r101 == null) goto L6;
        r101.v(r100);
        return;
    }

    @Override // com.larus.login.api.ILoginApi
    public final void G(ActivityResultLauncher<Intent> r100, SwitchBindParam r101) {
        Intrinsics.checkNotNullParameter(r100, "switchBindLauncher");
        Intrinsics.checkNotNullParameter(r101, "switchBindParam");
        ILoginApi r102 = c();
        if (r102 == null) goto L6;
        r102.G(r100, r101);
        return;
    }

    @Override // com.larus.login.api.ILoginApi
    public final boolean K(FragmentActivity r100, Map r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        ILoginApi r102 = c();
        if (r102 != null) goto L7;
        return false;
    L7:
        return r102.K(r100, r101);
    }

    @Override // com.larus.login.api.ILoginApi
    public final SpannableStringBuilder g(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "checkDescText");
        ILoginApi r102 = c();
        if (r102 == null) goto L7;
        SpannableStringBuilder r103 = r102.g(r100, r101);
        if (r103 == null) goto L7;
        return r103;
    L7:
        return new SpannableStringBuilder();
    }

    @Override // com.larus.login.api.ILoginApi
    public final void q(Context r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        ILoginApi r102 = c();
        if (r102 == null) goto L6;
        r102.q(r100, r101);
        return;
    }

    @Override // com.larus.login.api.ILoginApi
    public final void w(Context r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        ILoginApi r102 = c();
        if (r102 == null) goto L6;
        r102.w(r100, r101);
        return;
    }

    @Override // com.larus.login.api.ILoginApi
    public final void D(Fragment r100, Bundle r101, com.larus.bmhome.chat.i0 r102) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r102, "doAfterBind");
        ILoginApi r103 = c();
        if (r103 == null) goto L6;
        r103.D(r100, r101, r102);
        return;
    }

    @Override // com.larus.login.api.ILoginApi
    public final void F(FragmentActivity r100, SwitchBindParam r101, Function2<? super Boolean, ? super String, Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "switchBindParam");
        Intrinsics.checkNotNullParameter(r102, "onResult");
        ILoginApi r103 = c();
        if (r103 == null) goto L6;
        r103.F(r100, r101, r102);
        return;
    }

    @Override // com.larus.login.api.ILoginApi
    public final void H(Activity r100, String r101, com.larus.xbridge.custom.s r102) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        ILoginApi r103 = c();
        if (r103 == null) goto L6;
        r103.H(r100, r101, r102);
        return;
    }

    @Override // com.larus.login.api.ILoginApi
    public final g0 M(FragmentManager r100, h r101, NotifyBinderDialogType r102) {
        Intrinsics.checkNotNullParameter(r100, "fragmentManager");
        Intrinsics.checkNotNullParameter(r101, "binderConfig");
        Intrinsics.checkNotNullParameter(r102, "dialogType");
        ILoginApi r103 = c();
        if (r103 != null) goto L7;
        return null;
    L7:
        return r103.M(r100, r101, r102);
    }

    @Override // com.larus.login.api.ILoginApi
    public final void m(uq9.d r100, com.larus.login.api.ecommerce.f r101, com.larus.login.api.ecommerce.g r102) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        ILoginApi r103 = c();
        if (r103 == null) goto L6;
        r103.m(r100, r101, r102);
        return;
    }

    @Override // com.larus.login.api.ILoginApi
    public final void o(Activity r100, String r101, com.larus.xbridge.custom.t r102) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        ILoginApi r103 = c();
        if (r103 == null) goto L6;
        r103.o(r100, r101, r102);
        return;
    }

    @Override // com.larus.login.api.ILoginApi
    public final void p(TraceFragment r100, boolean r101, boolean r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        ILoginApi r104 = c();
        if (r104 == null) goto L6;
        r104.p(r100, r101, r102, r103);
        return;
    }

    @Override // com.larus.login.api.ILoginApi
    public final void u(Fragment r100, String r101, Map r102, com.larus.xbridge.custom.f0 r103) {
        Intrinsics.checkNotNullParameter(r100, "hostFragment");
        Intrinsics.checkNotNullParameter(r101, "secUid");
        Intrinsics.checkNotNullParameter(r103, "callback");
        ILoginApi r104 = c();
        if (r104 != null) goto L6;
        r103.invoke(Boolean.FALSE);
        return;
    L6:
        r104.u(r100, r101, r102, r103);
    }

    @Override // com.larus.login.api.ILoginApi
    public final void x(FragmentActivity r100, Function0 r101, Function0 r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "confirmCallback");
        Intrinsics.checkNotNullParameter(r102, "cancelCallback");
        ILoginApi r104 = c();
        if (r104 == null) goto L6;
        r104.x(r100, r101, r102, r103);
        return;
    }

    @Override // com.larus.login.api.ILoginApi
    public final void z(LifecycleOwner r100, Fragment r101, boolean r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "viewLifecycleOwner");
        Intrinsics.checkNotNullParameter(r101, WidgetService.PARAM_FRAGMENT);
        ILoginApi r104 = c();
        if (r104 == null) goto L6;
        r104.z(r100, r101, r102, r103);
        return;
    }

    @Override // com.larus.login.api.ILoginApi
    public final boolean r(FragmentActivity r100, String r101, String r110, String r111, CommonDouYinLoginUtil.f r112) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "errorMsg");
        Intrinsics.checkNotNullParameter(r110, "authToken");
        Intrinsics.checkNotNullParameter(r111, "profileKey");
        Intrinsics.checkNotNullParameter(r112, "onResult");
        ILoginApi r102 = c();
        if (r102 != null) goto L7;
        return false;
    L7:
        return r102.r(r100, r101, r110, r111, r112);
    }

    @Override // com.larus.login.api.ILoginApi
    public final void C(FragmentActivity r100, Function0 r110, Function0 r111, Function0 r112, Function0 r113, Function0 r114) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r110, "cancelCallback");
        Intrinsics.checkNotNullParameter(r111, "logoutCallback");
        Intrinsics.checkNotNullParameter(r112, "logoutAllCallback");
        Intrinsics.checkNotNullParameter(r113, "confirmLogoutAllCallback");
        Intrinsics.checkNotNullParameter(r114, "cancelLogoutAllCallback");
        ILoginApi r101 = c();
        if (r101 == null) goto L6;
        r101.C(r100, r110, r111, r112, r113, r114);
        return;
    }
}
