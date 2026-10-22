package com.larus.login.impl.impl;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import androidx.activity.result.ActivityResultLauncher;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.ee.bear.wikiv2.home2.model.WikiSpaceType;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.ixigua.lib.track.TrackParams;
import com.larus.account.base.api.AccountSwitchReason;
import com.larus.account.base.api.ILoginService;
import com.larus.account.base.api.IMultiAccountService;
import com.larus.bmhome.bot.CommonSettingFragment;
import com.larus.bmhome.chat.i0;
import com.larus.common.apphost.AppHost;
import com.larus.common.pollingconfig.api.PollingConfigService;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.common_ui.dialog.l0;
import com.larus.e_commerce.api.IECommerceService;
import com.larus.login.api.BdauthService;
import com.larus.login.api.CommonDouYinLoginUtil;
import com.larus.login.api.ILoginApi;
import com.larus.login.api.NotifyBinderDialogType;
import com.larus.login.api.SwitchBindParam;
import com.larus.login.api.f0;
import com.larus.login.api.g0;
import com.larus.login.impl.AccountUtils;
import com.larus.login.impl.LogoutDialogFragment;
import com.larus.login.impl.activity.AccountLoginActivity;
import com.larus.login.impl.downgrade.FlowLoginQuotaManager$init$1;
import com.larus.login.impl.forcebind.AccountForceBindFragment;
import com.larus.login.impl.forcebind.NotifyBinderDialogFragment;
import com.larus.login.impl.forcebind.i;
import com.larus.login.impl.multiaccount.MultiAccountOperationCoordinator;
import com.larus.login.impl.multiaccount.h;
import com.larus.login.impl.p;
import com.larus.login.impl.q;
import com.larus.login.impl.riskcontrol.AccountRiskControlHelper;
import com.larus.login.impl.switchbind.SwitchBindActivity;
import com.larus.login.impl.u;
import com.larus.login.impl.utils.j;
import com.larus.login.impl.utils.k;
import com.larus.login.impl.v;
import com.larus.login.impl.w;
import com.larus.network.HttpConst;
import com.larus.nova.R;
import com.larus.platform.api.n4;
import com.larus.platform.api.r0;
import com.larus.platform.service.x1;
import com.larus.platform.service.z2;
import com.larus.setting.impl.SettingAccountInfoFragment;
import com.larus.settings.value.e10;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.larus.utils.t0;
import com.larus.xbridge.custom.s;
import com.larus.xbridge.custom.t;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.bduploader.BDVideoUploaderBase;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import org.json.JSONObject;
import tx9.g2;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000þ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\u0005H\u0016J\b\u0010\r\u001a\u00020\u0005H\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0011H\u0016JD\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00052\u0016\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0018\u00010\u00192\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00160\u001cH\u0016J(\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u001f2\u0016\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0018\u00010\u0019H\u0016J\b\u0010 \u001a\u00020\u000fH\u0002J\b\u0010!\u001a\u00020\u000fH\u0016J\b\u0010\"\u001a\u00020#H\u0016J\u0010\u0010$\u001a\u00020\u00162\u0006\u0010%\u001a\u00020\u000fH\u0016J*\u0010&\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010'\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020\u000f2\b\u0010)\u001a\u0004\u0018\u00010\u0005H\u0016J6\u0010&\u001a\u00020\u00162\b\u0010*\u001a\u0004\u0018\u00010+2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010'\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020\u000f2\b\u0010)\u001a\u0004\u0018\u00010\u0005H\u0016J@\u0010,\u001a\u00020\u00162\u0006\u0010*\u001a\u00020+2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00160.2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00160.2\b\u00100\u001a\u0004\u0018\u00010\u00052\b\u00101\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u00102\u001a\u00020\u00162\b\u00103\u001a\u0004\u0018\u00010\u0005H\u0016J`\u00104\u001a\u00020\u00162\u0006\u0010*\u001a\u00020+2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00160.2\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u00160.2\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u00160.2\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u00160.2\f\u00108\u001a\b\u0012\u0004\u0012\u00020\u00160.2\b\u00100\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u00109\u001a\u00020\u0016H\u0016J\u0010\u0010:\u001a\u00020\u00162\u0006\u0010;\u001a\u00020\u0005H\u0016J\u0010\u0010<\u001a\u00020\u000f2\u0006\u0010;\u001a\u00020\u0005H\u0016J\u001e\u0010=\u001a\u00020\u00162\f\u0010>\u001a\b\u0012\u0004\u0012\u00020@0?2\u0006\u0010A\u001a\u00020BH\u0016JR\u0010=\u001a\u00020\u00162\u0006\u0010*\u001a\u00020+2\u0006\u0010A\u001a\u00020B28\u0010C\u001a4\u0012\u0013\u0012\u00110\u000f¢\u0006\f\bE\u0012\b\bF\u0012\u0004\b\b(G\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\bE\u0012\b\bF\u0012\u0004\b\b(H\u0012\u0004\u0012\u00020\u00160DH\u0016Jb\u0010I\u001a\u00020\u000f2\u0006\u0010*\u001a\u00020+2\u0006\u0010J\u001a\u00020\u00052\u0006\u0010K\u001a\u00020\u00052\u0006\u0010L\u001a\u00020\u000528\u0010C\u001a4\u0012\u0013\u0012\u00110\u000f¢\u0006\f\bE\u0012\b\bF\u0012\u0004\b\b(G\u0012\u0015\u0012\u0013\u0018\u00010M¢\u0006\f\bE\u0012\b\bF\u0012\u0004\b\b(N\u0012\u0004\u0012\u00020\u00160DH\u0016J(\u0010O\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010P\u001a\u0004\u0018\u00010Q2\f\u0010R\u001a\b\u0012\u0004\u0012\u00020\u00160.H\u0016J\b\u0010S\u001a\u00020\u000fH\u0016J\u0010\u0010T\u001a\u00020\u000f2\u0006\u0010*\u001a\u00020UH\u0016J\u0010\u0010V\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J$\u0010W\u001a\u00020\u00162\u0006\u0010*\u001a\u00020U2\b\u00100\u001a\u0004\u0018\u00010\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010XH\u0016J$\u0010Y\u001a\u00020\u00162\u0006\u0010*\u001a\u00020U2\b\u00100\u001a\u0004\u0018\u00010\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010XH\u0016J>\u0010Z\u001a\u00020\u00162\u0006\u0010[\u001a\u00020\\2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010]\u001a\u0004\u0018\u00010^2\b\u0010_\u001a\u0004\u0018\u00010`2\u0006\u0010(\u001a\u00020\u000f2\b\u0010)\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010a\u001a\u00020\u00162\u0006\u0010[\u001a\u00020\\H\u0016J\"\u0010b\u001a\u0004\u0018\u00010c2\u0006\u0010d\u001a\u00020e2\u0006\u0010f\u001a\u00020g2\u0006\u0010h\u001a\u00020iH\u0016J\u0018\u0010j\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010k\u001a\u00020\u000fH\u0016J\u0018\u0010l\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010k\u001a\u00020\u000fH\u0016J\u0017\u0010m\u001a\u00020\u00162\b\u0010n\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0002\u0010oJ\b\u0010p\u001a\u00020\u000fH\u0016J \u0010q\u001a\u00020\u00162\u0006\u0010*\u001a\u00020U2\u0006\u0010A\u001a\u00020B2\u0006\u0010\u001b\u001a\u00020rH\u0016J\b\u0010s\u001a\u00020\u0016H\u0016J\u0010\u0010t\u001a\u00020\u000f2\u0006\u0010u\u001a\u00020\u000fH\u0016J\u0010\u0010v\u001a\u00020\u000f2\u0006\u0010*\u001a\u00020+H\u0016J\u0010\u0010w\u001a\u00020\u00162\u0006\u0010x\u001a\u00020yH\u0016J\u0010\u0010z\u001a\u00020\u00162\u0006\u0010x\u001a\u00020yH\u0016J\b\u0010{\u001a\u00020\u000fH\u0016J\b\u0010|\u001a\u00020\u000fH\u0016J\u0010\u0010}\u001a\u00020\u000f2\u0006\u0010*\u001a\u00020UH\u0016J\b\u0010~\u001a\u00020\u000fH\u0016Jz\u0010\u007f\u001a\u00020\u00162\b\u0010\u0080\u0001\u001a\u00030\u0081\u00012Q\u0010\u0082\u0001\u001aL\u0012\u0014\u0012\u00120\u0005¢\u0006\r\bE\u0012\t\bF\u0012\u0005\b\b(\u0084\u0001\u0012\u0014\u0012\u00120\u0005¢\u0006\r\bE\u0012\t\bF\u0012\u0005\b\b(\u0085\u0001\u0012\u0013\u0012\u00110i¢\u0006\f\bE\u0012\b\bF\u0012\u0004\b\b(h\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0083\u00012\u0013\u0010\u001b\u001a\u000f\u0012\u0005\u0012\u00030\u0086\u0001\u0012\u0004\u0012\u00020\u00160\u001cH\u0016J\u001b\u0010\u0087\u0001\u001a\u00030\u0088\u00012\u0006\u0010\u001e\u001a\u00020\u001f2\u0007\u0010\u0089\u0001\u001a\u00020\u0005H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\u008a\u0001"}, d2 = {"Lcom/larus/login/impl/impl/LonginServiceImpl;", "Lcom/larus/login/api/ILoginApi;", "<init>", "()V", "customLogoutMessage", "", "eCommerceAuthConfig", "Lcom/larus/platform/model/ecommerce/ECommerceAuthConfig;", "getECommerceAuthConfig", "()Lcom/larus/platform/model/ecommerce/ECommerceAuthConfig;", "eCommerceAuthConfig$delegate", "Lkotlin/Lazy;", "getTermsOfServiceUrl", "getPrivacyPolicyUrl", "checkPageStatus", "", WidgetService.PARAM_FRAGMENT, "Landroidx/fragment/app/Fragment;", "createMultiAccountUiController", "Lcom/larus/platform/api/MultiAccountUiController;", "hostFragment", "switchAccountFromAccountManagement", "", "secUid", "trackInfo", "", "", "callback", "Lkotlin/Function1;", "addAccountFromAccountManagement", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "multiAccountFeatureAvailable", "profileFeatureAvailable", "getAccountRiskImpl", "Lcom/larus/login/api/IAccountRiskApi;", "doAccountBanned", "canShowAppealDialog", "goMainActivity", "isTouristMode", "isFromVerificationCode", "pendingDeeplinkSchema", "activity", "Landroidx/fragment/app/FragmentActivity;", "openLogoutDialog", "confirmCallback", "Lkotlin/Function0;", "cancelCallback", "businessScene", "customTips", "setCustomLogoutMessage", "message", "openLogoutChooseDialog", "logoutCallback", "logoutAllCallback", "confirmLogoutAllCallback", "cancelLogoutAllCallback", "cleanLoginFailedInfo", "requestLaunchInfo", "from", "completeLoginForActiveAppPage", "goToSwitchBind", "switchBindLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "switchBindParam", "Lcom/larus/login/api/SwitchBindParam;", "onResult", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "success", "latestError", "goToChangeBind", "errorMsg", "authToken", "profileKey", "", "errorCode", "popupForceBind", "bundle", "Landroid/os/Bundle;", "doAfterBind", "needForceBindDouyinExp", "needSaveActivityWhenFinishAll", "Landroid/app/Activity;", "isForceBindDialogShow", "doLogoutAll", "Lcom/larus/login/api/callback/LogoutCallBack;", "doLogout", "observerLaunchInfoData", "viewLifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "dialog", "Lcom/larus/common_ui/dialog/CommonLoadDialog;", "countDownTimer", "Landroid/os/CountDownTimer;", "removeObserverLaunchInfoData", "showNotifyBinderDialog", "Lcom/larus/login/api/INotifyBinderDialog;", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "binderConfig", "Lcom/larus/login/api/BinderConfig;", "dialogType", "Lcom/larus/login/api/NotifyBinderDialogType;", "jumpToBindPhoneNumber", "fromH5", "jumpToChangePhoneNumber", "setNeedRegister", "need", "(Ljava/lang/Boolean;)V", "getNeedRegister", "startCommonSwitchBinder", "Lcom/larus/login/api/SwitchBindCallback;", "intConfig", "canSkipCheckTourist", "isActivityEntrance", "showAccountReusedTips", "addLoginShutdownStateListener", "listener", "Lcom/larus/platform/api/ILoginShutdownListener;", "removeLoginShutdownStateListener", "getCurrentShutdownState", "isAccountReusedShowing", "isAppSupportDouyinAuthorization", "isHitLoginDialogNewStyle", "tryToBindDouYinForPurchase", "params", "Lcom/larus/platform/model/ecommerce/ECBindDouYinParams;", "onDialogShow", "Lkotlin/Function3;", "page", "source", "Lcom/larus/platform/model/ecommerce/ECBindDouYinResult;", "generateLearnMoreSpan", "Landroid/text/SpannableStringBuilder;", "checkDescText", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LonginServiceImpl implements ILoginApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f357774a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f357775b;

    public static boolean c() {
        AppHost.Companion r100 = AppHost.f326268a;
        if (r100.isOversea() == false) goto L5;
    L11:
        return false;
    L5:
        if (r100.isPlugin() == true) goto L11;
        if (x1.f365857a.a() == true) goto L11;
        if (z2.f365865a.g1() == false) goto L11;
        return true;
    }

    @Override // com.larus.login.api.ILoginApi
    public final void B() {
        Intrinsics.checkNotNullParameter("oneLogin", "from");
        AccountUtils r100 = AccountUtils.f357130a;
        AccountUtils.s("oneLogin");
    }

    @Override // com.larus.login.api.ILoginApi
    public final boolean L() {
        AccountUtils r100 = AccountUtils.f357130a;
        return true;
    }

    @Override // com.larus.login.api.ILoginApi
    public final boolean P() {
        Lazy r100 = uj9.d.f550448a;
        return uj9.d.d();
    }

    @Override // com.larus.login.api.ILoginApi
    public final String b() {
        AccountUtils r100 = AccountUtils.f357130a;
        HttpConst.f359979a.getClass();
        return HttpConst.L;
    }

    @Override // com.larus.login.api.ILoginApi
    public final void e() {
        com.larus.login.impl.utils.c r100 = k.f358324a;
        k.f358324a = null;
    }

    @Override // com.larus.login.api.ILoginApi
    public final String getPrivacyPolicyUrl() {
        AccountUtils r100 = AccountUtils.f357130a;
        HttpConst.f359979a.getClass();
        return HttpConst.M;
    }

    @Override // com.larus.login.api.ILoginApi
    public final boolean k() {
        com.larus.login.impl.downgrade.b r100 = com.larus.login.impl.downgrade.b.f357660a;
        return com.larus.login.impl.downgrade.b.f357664e;
    }

    @Override // com.larus.login.api.ILoginApi
    public final boolean l() {
        return ((Boolean) j.f358321a.getValue()).booleanValue();
    }

    @Override // com.larus.login.api.ILoginApi
    public final void n() {
        com.larus.login.impl.downgrade.b r100 = com.larus.login.impl.downgrade.b.f357660a;
        PollingConfigService r101 = PollingConfigService.f326423a;
        boolean r102 = Intrinsics.areEqual(r101.f("login_dg"), "1");
        com.larus.login.impl.downgrade.b.f357664e = r102;
        if (r102 == false) goto L5;
        com.larus.login.impl.downgrade.a.c(0, 5);
    L5:
        r101.j(new FlowLoginQuotaManager$init$1());
        int r103 = h.f358117a;
        ILoginService.a.c(ILoginService.f286097a, new com.larus.login.impl.multiaccount.f());
    }

    @Override // com.larus.login.api.ILoginApi
    public final void t() {
        AccountUtils r100 = AccountUtils.f357130a;
        AccountUtils.g(710012008);
    }

    @Override // com.larus.login.api.ILoginApi
    public final boolean y() {
        AccountUtils r100 = AccountUtils.f357130a;
        return AccountUtils.f357133d;
    }

    public LonginServiceImpl() {
        this.f357775b = LazyKt.lazy(new a());
    }

    @Override // com.larus.login.api.ILoginApi
    public final f0 A() {
        return AccountRiskControlHelper.f358209a;
    }

    @Override // com.larus.login.api.ILoginApi
    public final boolean O() {
        return com.larus.login.impl.downgrade.b.f357664e;
    }

    @Override // com.larus.login.api.ILoginApi
    public final void E(Boolean r100) {
        AccountUtils r101 = AccountUtils.f357130a;
        if (r100 == null) goto L5;
        boolean r102 = r100.booleanValue();
    L6:
        AccountUtils.f357133d = r102;
        return;
    L5:
        r102 = true;
        goto L6
    }

    @Override // com.larus.login.api.ILoginApi
    public final boolean I(FragmentActivity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r100, "activity");
        return com.bytedance.sdk.open.douyin.a.create(r100).isAppSupportAuthorization();
    }

    @Override // com.larus.login.api.ILoginApi
    public final void J(LifecycleOwner r100) {
        Intrinsics.checkNotNullParameter(r100, "viewLifecycleOwner");
        AccountUtils r101 = AccountUtils.f357130a;
        AccountUtils.r(r100);
    }

    @Override // com.larus.login.api.ILoginApi
    public final void N(String r100) {
        this.f357774a = r100;
    }

    @Override // com.larus.login.api.ILoginApi
    public final boolean a(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        if (BdauthService.f356936a.a(r100) == false) goto L5;
    L10:
        return true;
    L5:
        if ((r100 instanceof AccountLoginActivity) == true) goto L7;
    L9:
        return false;
    L7:
        if (o0.d(((AccountLoginActivity) r100).getIntent().getStringExtra("key_trigger_app_id")) == false) goto L9;
        goto L9
    }

    @Override // com.larus.login.api.ILoginApi
    public final void f(r0 r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        com.larus.login.impl.downgrade.b r101 = com.larus.login.impl.downgrade.b.f357660a;
        Intrinsics.checkNotNullParameter(r100, "listener");
        CopyOnWriteArrayList<r0> r102 = com.larus.login.impl.downgrade.b.f357662c;
        if (r102.contains(r100) == false) goto L6;
        r102.remove(r100);
        return;
    }

    @Override // com.larus.login.api.ILoginApi
    public final n4 h(CommonSettingFragment r100) {
        Intrinsics.checkNotNullParameter(r100, "hostFragment");
        if (c() == true) goto L5;
        return null;
    L5:
        if (r100.isAdded() == true) goto L8;
        return null;
    L8:
        return new com.larus.login.impl.multiaccount.o0(r100);
    }

    @Override // com.larus.login.api.ILoginApi
    public final boolean i(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        AccountUtils r101 = AccountUtils.f357130a;
        return AccountUtils.o(r100);
    }

    @Override // com.larus.login.api.ILoginApi
    public final void j(r0 r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        com.larus.login.impl.downgrade.b r101 = com.larus.login.impl.downgrade.b.f357660a;
        Intrinsics.checkNotNullParameter(r100, "listener");
        CopyOnWriteArrayList<r0> r102 = com.larus.login.impl.downgrade.b.f357662c;
        if (r102.contains(r100) == true) goto L7;
        r102.add(r100);
        return;
    }

    @Override // com.larus.login.api.ILoginApi
    public final boolean s(SettingAccountInfoFragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        AccountUtils r101 = AccountUtils.f357130a;
        return AccountUtils.e(r100);
    }

    @Override // com.larus.login.api.ILoginApi
    public final void v(FragmentActivity r100) {
        AccountUtils r101 = AccountUtils.f357130a;
        AccountUtils.k(r100, null, false, false, null);
    }

    @Override // com.larus.login.api.ILoginApi
    public final void G(ActivityResultLauncher<Intent> r100, SwitchBindParam r101) {
        Intrinsics.checkNotNullParameter(r100, "switchBindLauncher");
        Intrinsics.checkNotNullParameter(r101, "switchBindParam");
        AccountUtils r102 = AccountUtils.f357130a;
        Intrinsics.checkNotNullParameter(r100, "switchBindLauncher");
        Intrinsics.checkNotNullParameter(r101, "switchBindParam");
        FLogger r103 = FLogger.f375446a;
        StringBuilder r104 = new StringBuilder("goToSwitchBind(switchBindLauncher) start, previousPage=");
        r104.append(r101.f356998e);
        r104.append(", enterMethod=");
        r104.append(r101.f356997d);
        r104.append(", scene=");
        r104.append(r101.f356999f);
        r104.append(", platformAppIdPresent=");
        String r105 = r101.f356995b;
        boolean r106 = false;
        if (r105 != null) goto L5;
    L8:
        boolean r107 = true;
    L9:
        r104.append(!r107);
        r104.append(", platformPresent=");
        String r108 = r101.f356996c;
        if (r108 != null) goto L12;
    L15:
        boolean r109 = true;
    L16:
        r104.append(!r109);
        r104.append(", profileKeyPresent=");
        String r110 = r101.f356994a;
        if (r110 != null) goto L19;
    L20:
        r106 = true;
    L21:
        r104.append(!r106);
        r103.i("AccountUtils", r104.toString());
        Context r111 = AppHost.f326268a.getApplication().getApplicationContext();
        Intent r112 = new Intent();
        r112.setClass(r111, SwitchBindActivity.class);
        r112.putExtra("key_switch_bind_param", r101);
        r100.launch(r112);
        r103.i("AccountUtils", "goToSwitchBind(switchBindLauncher) launched SwitchBindActivity");
        return;
    L19:
        if (r110.length() != 0) goto L21;
    L12:
        if (r108.length() == 0) goto L15;
        r109 = false;
        goto L16
    L5:
        if (r105.length() == 0) goto L8;
        r107 = false;
        goto L9
    }

    @Override // com.larus.login.api.ILoginApi
    public final boolean K(FragmentActivity r100, Map r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (c() == true) goto L6;
        return false;
    L6:
        if ((r100 instanceof Activity) == true) goto L9;
        r100 = null;
    L9:
        if (r100 != null) goto L12;
        return false;
    L12:
        if (r100.isFinishing() == false) goto L14;
    L18:
        return false;
    L14:
        if (r100.isDestroyed() == true) goto L18;
        CoroutineScope r102 = MultiAccountOperationCoordinator.f358095a;
        return MultiAccountOperationCoordinator.b(r100, r101, null);
    }

    @Override // com.larus.login.api.ILoginApi
    public final SpannableStringBuilder g(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "checkDescText");
        IECommerceService r102 = (IECommerceService) ServiceManager.get().getService(IECommerceService.class);
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
        AccountUtils r102 = AccountUtils.f357130a;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AccountUtils.t(r100, r100.getString(R.string.larus_bind_phone_enter_number), null, r101, null);
    }

    @Override // com.larus.login.api.ILoginApi
    public final void w(Context r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AccountUtils r102 = AccountUtils.f357130a;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (AppHost.f326268a.isOversea() == true) goto L7;
        e10 r103 = e10.f368561a;
        if (e10.G().a() == false) goto L7;
        ILoginService.f286097a.G(new w(r100, r101));
        return;
    L7:
        AccountUtils.t(r100, r100.getString(R.string.larus_change_phone_current_number), null, r101, "show_popup_change_phone");
    }

    @Override // com.larus.login.api.ILoginApi
    public final void D(Fragment r100, Bundle r101, i0 r102) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r102, "doAfterBind");
        AccountUtils r103 = AccountUtils.f357130a;
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r102, "doAfterBind");
        if (r100.isAdded() == true) goto L6;
        FLogger.f375446a.w("AccountUtils", "popupForceBind skip, fragment not added: ".concat(r100.getClass().getSimpleName()));
        return;
    L6:
        if (AccountUtils.o(r100) == true) goto L19;
        int r104 = AccountForceBindFragment.f357677h;
        Intrinsics.checkNotNullParameter(r102, "doAfterBind");
        AccountForceBindFragment r105 = new AccountForceBindFragment();
        r105.setArguments(r101);
        Intrinsics.checkNotNullParameter(r102, "doAfterBind");
        r105.f357681g = r102;
        FragmentManager r106 = r100.getChildFragmentManager();
        LandscapeRestrictionOperation r107 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r105, "AccountForceBindFragment", r107);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r106, r105, r107) == false) goto L16;
    L13:
        Unit r108 = Unit.INSTANCE;
        int r109 = i.f357709a;
        JSONObject r110 = new JSONObject();
        Intrinsics.checkNotNullParameter(r110, "params");
        r110.put("current_page", "chat");
        r110.put("source", "new_reg_required_bind_douyin_tel");
        TrackParams r111 = new TrackParams().merge(r110);
        by7.a r112 = new by7.a("bind_douyin_popup_show");
        r112.f21463a.merge(r111);
        r112.b();
        return;
    L16:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L15
    L12:
        r105.show(r106, "AccountForceBindFragment");
        goto L13
    }

    @Override // com.larus.login.api.ILoginApi
    public final void F(final FragmentActivity r100, final SwitchBindParam r101, final Function2<? super Boolean, ? super String, Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "switchBindParam");
        Intrinsics.checkNotNullParameter(r102, "onResult");
        AccountUtils r103 = AccountUtils.f357130a;
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "switchBindParam");
        Intrinsics.checkNotNullParameter(r102, "onResult");
        FLogger r104 = FLogger.f375446a;
        StringBuilder r105 = new StringBuilder("goToSwitchBind(activity) start, previousPage=");
        r105.append(r101.f356998e);
        r105.append(", enterMethod=");
        r105.append(r101.f356997d);
        r105.append(", scene=");
        r105.append(r101.f356999f);
        r105.append(", platformAppIdPresent=");
        String r106 = r101.f356995b;
        boolean r107 = false;
        if (r106 != null) goto L5;
    L8:
        boolean r108 = true;
    L9:
        r105.append(!r108);
        r105.append(", platformPresent=");
        String r109 = r101.f356996c;
        if (r109 != null) goto L12;
    L15:
        boolean r110 = true;
    L16:
        r105.append(!r110);
        r105.append(", profileKeyPresent=");
        String r111 = r101.f356994a;
        if (r111 != null) goto L19;
    L20:
        r107 = true;
    L21:
        r105.append(!r107);
        r104.i("AccountUtils", r105.toString());
        t0.f375468a.post(new p(r100, r101, r102));
        return;
    L19:
        if (r111.length() != 0) goto L21;
    L12:
        if (r109.length() == 0) goto L15;
        r110 = false;
        goto L16
    L5:
        if (r106.length() == 0) goto L8;
        r108 = false;
        goto L9
    }

    @Override // com.larus.login.api.ILoginApi
    public final void H(Activity r100, String r101, s r110) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain(), null, new LonginServiceImpl$doLogoutAll$1(r101, r100, r110, null), 2, null);
    }

    @Override // com.larus.login.api.ILoginApi
    public final g0 M(FragmentManager r110, com.larus.login.api.h r111, NotifyBinderDialogType r112) {
        Intrinsics.checkNotNullParameter(r110, "fragmentManager");
        Intrinsics.checkNotNullParameter(r111, "binderConfig");
        Intrinsics.checkNotNullParameter(r112, "dialogType");
        if (r110.isStateSaved() == false) goto L5;
    L23:
        return null;
    L5:
        if (r110.isDestroyed() == true) goto L23;
        int r100 = NotifyBinderDialogFragment.f357691h;
        Intrinsics.checkNotNullParameter(r111, "binderConfig");
        NotifyBinderDialogFragment r101 = new NotifyBinderDialogFragment();
        Intrinsics.checkNotNullParameter(r111, "binderConfig");
        r101.f357693e = r111;
        if (r101.getDialog() == null) goto L12;
        Dialog r102 = r101.getDialog();
        if (r102 == null) goto L12;
        r102.setCanceledOnTouchOutside(r111.f357037a.f357049h);
    L12:
        r101.S90();
        LandscapeRestrictionOperation r113 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r101, "NotifyBinderDialogFragment", r113);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r110, r101, r113) == true) goto L18;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L24
    L16:
        r101.show(r110, "NotifyBinderDialogFragment");
    L18:
        if (((uq9.f) this.f357775b.getValue()).a() == true) goto L20;
    L22:
        return r101;
    L20:
        if (r112 != NotifyBinderDialogType.CheckNeedBinder) goto L22;
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new LonginServiceImpl$showNotifyBinderDialog$1(null), 2, null);
        goto L22
    }

    @Override // com.larus.login.api.ILoginApi
    public final void m(uq9.d r110, final com.larus.login.api.ecommerce.f r111, final com.larus.login.api.ecommerce.g r112) {
        Intrinsics.checkNotNullParameter(r110, "params");
        Intrinsics.checkNotNullParameter(r112, "callback");
        IECommerceService r100 = (IECommerceService) ServiceManager.get().getService(IECommerceService.class);
        if (r100 == null) goto L6;
        r100.r(new com.larus.e_commerce.api.b(r110.getActivity(), r110.f551335b, r110.f551336c, r110.f551337d, r110.f551338e, r110.f551339f), new b(r111), new c(r112));
        return;
    }

    @Override // com.larus.login.api.ILoginApi
    public final void o(Activity r100, String r101, t r102) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        if ((!Intrinsics.areEqual(r101, "logout_by_jsb_app_logout_method")) == false) goto L5;
        l0 r103 = new l0(r100, 0.0f, false, 6);
    L6:
        if (r103 != null) goto L8;
    L12:
        ILoginService.f286097a.x(false, new d(r103, r100, r102), r101);
        return;
    L8:
        if (DialogLancet.shouldBlockDialogShow(r103) == false) goto L15;
        DialogLancet.handleBlockedDialogShow(r103);
        goto L12
    L15:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L14
    L11:
        DialogLancet.beforeDialogShow(r103);
        r103.show();
        DialogLancet.afterDialogShow(r103);
        goto L12
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.larus.login.api.ILoginApi
    public final void p(TraceFragment r100, boolean r101, boolean r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        AccountUtils r104 = AccountUtils.f357130a;
        AccountUtils.j(r100, r101, r102, r103);
    }

    @Override // com.larus.login.api.ILoginApi
    public final void u(Fragment r110, String r111, Map r112, com.larus.xbridge.custom.f0 r113) {
        Intrinsics.checkNotNullParameter(r110, "hostFragment");
        Intrinsics.checkNotNullParameter(r111, "secUid");
        Intrinsics.checkNotNullParameter(r113, "callback");
        if (c() == true) goto L6;
        r113.invoke(Boolean.FALSE);
        return;
    L6:
        Iterator<T> r100 = IMultiAccountService.f286100a.g().iterator();
    L7:
        String r101 = null;
        if (r100.hasNext() == false) goto L12;
        Object r102 = r100.next();
        if (Intrinsics.areEqual(((q38.b) r102).g(), r111) == false) goto L7;
    L13:
        q38.b r103 = (q38.b) r102;
        if (r103 != null) goto L16;
    L44:
        r113.invoke(Boolean.FALSE);
        return;
    L16:
        if (r103.k() == true) goto L44;
        if (com.larus.login.impl.multiaccount.b.a(r110) == false) goto L44;
        if (r112 == null) goto L22;
        Object r114 = r112.get("enter_method");
    L24:
        if ((r114 instanceof String) == false) goto L26;
        String r104 = (String) r114;
    L27:
        CoroutineScope r115 = MultiAccountOperationCoordinator.f358095a;
        AccountSwitchReason.Companion.getClass();
        if (MultiAccountOperationCoordinator.c(r103, AccountSwitchReason.a.a(r104), r110, r113) == false) goto L49;
        if (r112 == null) goto L31;
        Object r116 = r112.get("current_page");
    L33:
        if ((r116 instanceof String) == false) goto L35;
        r101 = (String) r116;
    L35:
        String r105 = r101;
        String r106 = r103.j();
        if (r103.l() == false) goto L38;
        String r117 = "enterprise";
    L39:
        String r107 = r117;
        if (r112 != null) goto L42;
        r112 = MapsKt.emptyMap();
    L42:
        g2.c(r105, "switch_account", r106, r107, r104, new JSONObject(r112), 64);
        return;
    L38:
        r117 = WikiSpaceType.PERSONAL;
        goto L39
    L31:
        r116 = null;
        goto L33
    L49:
        return;
    L26:
        r104 = null;
        goto L27
    L22:
        r114 = null;
        goto L24
    L12:
        r102 = null;
        goto L13
    }

    @Override // com.larus.login.api.ILoginApi
    public final void x(FragmentActivity r100, Function0 r101, Function0 r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "confirmCallback");
        Intrinsics.checkNotNullParameter(r102, "cancelCallback");
        CommonDialog.a r104 = new CommonDialog.a();
        r104.i(r100.getString(R.string.larus_logout_double_confirmation_title));
        if (r103 != null) goto L7;
        r103 = this.f357774a;
        if (r103 != null) goto L7;
        r103 = r100.getString(R.string.larus_logout_double_confirmation_text);
    L7:
        r104.g(r103);
        CommonDialog.a.f(r104, new e(r100, r101, this), r100.getString(R.string.larus_logout_double_confirmation_logout), false, 12);
        CommonDialog.a.e(r104, new f(r102), r100.getString(R.string.larus_logout_double_confirmation_cancel), 4);
        CommonDialog r105 = r104.a();
        FragmentManager r106 = r100.getSupportFragmentManager();
        LandscapeRestrictionOperation r107 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r105, null, r107);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r106, r105, r107) == true) goto L16;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L13
    L11:
        r105.show(r106, null);
        return;
    }

    @Override // com.larus.login.api.ILoginApi
    public final void z(LifecycleOwner r110, Fragment r111, boolean r112, String r113) {
        Intrinsics.checkNotNullParameter(r110, "viewLifecycleOwner");
        Intrinsics.checkNotNullParameter(r111, WidgetService.PARAM_FRAGMENT);
        AccountUtils.p(r110, r111, null, null, r112, r113, null, null, null, BDVideoUploaderBase.KeyIsDynamicSliceLowSize);
    }

    @Override // com.larus.login.api.ILoginApi
    public final boolean r(FragmentActivity r100, String r101, String r102, String r110, final CommonDouYinLoginUtil.f r111) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "errorMsg");
        Intrinsics.checkNotNullParameter(r102, "authToken");
        Intrinsics.checkNotNullParameter(r110, "profileKey");
        Intrinsics.checkNotNullParameter(r111, "onResult");
        AccountUtils r103 = AccountUtils.f357130a;
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "errorMsg");
        Intrinsics.checkNotNullParameter(r102, "authToken");
        Intrinsics.checkNotNullParameter(r110, "profileKey");
        Intrinsics.checkNotNullParameter(r111, "onResult");
        FLogger r104 = FLogger.f375446a;
        StringBuilder r105 = new StringBuilder("goToChangeBind start, errorMsgLen=");
        r105.append(r101.length());
        r105.append(", authTokenPresent=");
        if (r102.length() <= 0) goto L5;
        boolean r106 = true;
    L6:
        r105.append(r106);
        r105.append(", profileKeyPresent=");
        if (r110.length() <= 0) goto L9;
        boolean r107 = true;
    L10:
        r105.append(r107);
        r104.i("AccountUtils", r105.toString());
        if (r100.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.RESUMED) == true) goto L13;
    L20:
        r104.w("AccountUtils", "goToChangeBind aborted: invalid Activity state");
        return false;
    L13:
        if (r100.isFinishing() == true) goto L20;
        if (r100.isDestroyed() == true) goto L20;
        if (r100.getSupportFragmentManager().isStateSaved() == true) goto L20;
        CommonDialog.a r108 = new CommonDialog.a();
        r108.i(r100.getString(R.string.larus_rebind_douyin_title_cn));
        Intrinsics.checkNotNullParameter(r101, "message");
        r108.f327180i = r101;
        CommonDialog.a.f(r108, new com.larus.login.impl.t(r102, r110, r111), r100.getString(R.string.larus_rebind_douyin_confirmWindow_confirm_cn), false, 12);
        CommonDialog.a.e(r108, new u(r111), r100.getString(R.string.larus_rebind_douyin_confirmWindow_cancel_cn), 4);
        v r109 = new v(r111);
        Intrinsics.checkNotNullParameter(r109, "listener");
        r108.f327193v = r109;
        Function0<Boolean> r112 = new q(r111);
        Intrinsics.checkNotNullParameter(r112, "callback");
        r108.B = r112;
        r108.a().T90(r100.getSupportFragmentManager(), null);
        return true;
    L9:
        r107 = false;
        goto L10
    L5:
        r106 = false;
        goto L6
    }

    @Override // com.larus.login.api.ILoginApi
    public final void C(FragmentActivity r100, Function0 r101, Function0 r102, Function0 r103, Function0 r104, Function0 r105) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "cancelCallback");
        Intrinsics.checkNotNullParameter(r102, "logoutCallback");
        Intrinsics.checkNotNullParameter(r103, "logoutAllCallback");
        Intrinsics.checkNotNullParameter(r104, "confirmLogoutAllCallback");
        Intrinsics.checkNotNullParameter(r105, "cancelLogoutAllCallback");
        LogoutDialogFragment r106 = new LogoutDialogFragment();     // Catch: Exception -> L9
        r106.f357164e = r100;     // Catch: Exception -> L9
        r106.f357165f = "logout_by_user";     // Catch: Exception -> L9
        r106.f357166g = r101;     // Catch: Exception -> L9
        r106.f357167h = r102;     // Catch: Exception -> L9
        r106.f357168i = r103;     // Catch: Exception -> L9
        r106.f357169j = r104;     // Catch: Exception -> L9
        r106.f357170k = r105;     // Catch: Exception -> L9
        FragmentManager r107 = r100.getSupportFragmentManager();     // Catch: Exception -> L9
        LandscapeRestrictionOperation r108 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;     // Catch: Exception -> L9
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r106, null, r108);     // Catch: Exception -> L9
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r107, r106, r108) == true) goto L17;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L7:
        r106.show(r107, null);     // Catch: Exception -> L9
        return;
    L17:
        return;
    L9:
        e = move-exception;
        FLogger.f375446a.e("openLogoutChooseDialog", "There have something wrong when show e=" + e.getMessage());
    }
}
