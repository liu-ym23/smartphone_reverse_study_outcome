package com.larus.home.impl;

import android.R;
import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.service.notification.StatusBarNotification;
import android.util.Pair;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.activity.result.ActivityResultCaller;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import com.bytedance.ai.api.AppletService;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.android.livesdkapi.util.ILivePreInflateService;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.common.utility.concurrent.ThreadPlus;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.lego.init.InitScheduler;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.router.SmartRouter;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.flow.performance.quality.appinit.AppLaunchTracer;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.ixigua.lib.track.TrackParams;
import com.larus.account.base.api.IAccountService;
import com.larus.account.base.api.ILoginService;
import com.larus.bmhome.BaseHomeTabFragment;
import com.larus.bmhome.auth.LandingConfig;
import com.larus.bmhome.auth.LaunchCacheDelegate;
import com.larus.bmhome.auth.TouristModeABParam;
import com.larus.bmhome.auth.h1;
import com.larus.bmhome.auth.i1;
import com.larus.bmhome.chat.ChatDoubleTabFragment;
import com.larus.bmhome.chat.ChatFragment;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.immerse.ChatImmersFragment;
import com.larus.bmhome.chat.j4;
import com.larus.bmhome.social.userchat.model.e0;
import com.larus.bmhome.utils.LaunchLandingConfigHelperDelegate;
import com.larus.bmhome.utils.f2;
import com.larus.business.debug.api.IDebugService;
import com.larus.commercecredit.api.ICommerceCreditService;
import com.larus.commercemembership.api.ICommerceMembershipService;
import com.larus.common.apphost.AppHost;
import com.larus.common.mssdk.api.ISecPrivacyService;
import com.larus.common.mssdk.api.SecurityService;
import com.larus.common.zlinksdk.api.IZlinkService;
import com.larus.common_ui.activity.FlowCommonAppCompatActivity;
import com.larus.common_ui.dialog.p0;
import com.larus.community.api.ICommunityService;
import com.larus.deeplink.api.IDeeplinkService;
import com.larus.home.api.main.HomeService;
import com.larus.home.api.privacy.CustomPrivacyService;
import com.larus.home.impl.chat.multi_tab.ChatMultiTabFragment;
import com.larus.home.impl.cloud.CloudTestAdapter;
import com.larus.home.impl.main.maincontainer.MainContainerFragment;
import com.larus.home.impl.main.side_bar.MainSideBarFragment;
import com.larus.home.impl.main.tab.MainTabFragment;
import com.larus.home.impl.main.tab.config.BottomTabConfigManager;
import com.larus.home.impl.privacy.PrivacyAgreeActivity;
import com.larus.home.impl.route.ChatRoutePushInterceptor;
import com.larus.home.impl.route.u0;
import com.larus.home.impl.ug.UGReturnWindowManager;
import com.larus.home.impl.utils.OpenGraceReportHelper;
import com.larus.list.exposex.ExposeXTrackerExtKt;
import com.larus.login.api.LoginService;
import com.larus.login.api.TouristManager;
import com.larus.luckydog.api.ILuckyDogService;
import com.larus.minor.api.IMinorService;
import com.larus.permission.api.IPermissionX;
import com.larus.platform.api.ExternalRouteEntry;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.i3;
import com.larus.platform.service.z2;
import com.larus.receive.api.ReceiveIntentServiceDelegate;
import com.larus.setting.api.SettingService;
import com.larus.settings.value.e10;
import com.larus.settings.value.wn;
import com.larus.update.IBitsUpdate;
import com.larus.utils.i0;
import com.larus.utils.l0;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.larus.utils.y0;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.obric.assistant.spi.interact.ObricInteractDelegate;
import com.obric.assistant.spi.notification.IObricNotificationIslandService;
import com.obric.assistant.spi.update.ObricUpdateSPIServiceDelegate;
import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.quota.BDNetworkTagContextProviderAdapter;
import com.ss.ttvideoengine.log.VideoEventOneOutSync;
import com.ss.ttvideoengine.portrait.PortraitEngine;
import ec9.b0;
import ec9.c0;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;
import v19.i5;
import v19.q5;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u000e*\u0002ad\b\u0007\u0018\u0000 \u0080\u00012\u00020\u00012\u00020\u0002:\u0002\u0080\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u000eH\u0014J\u0010\u0010(\u001a\u00020&2\u0006\u0010)\u001a\u00020\u000eH\u0014J\u0012\u0010*\u001a\u00020&2\b\u0010+\u001a\u0004\u0018\u00010,H\u0014J\b\u0010-\u001a\u00020\u0006H\u0016J\b\u0010.\u001a\u00020\u0006H\u0016J\b\u0010/\u001a\u00020\u0006H\u0016J\r\u00100\u001a\u00020\u0006H\u0000¢\u0006\u0002\b1J\b\u00102\u001a\u00020&H\u0002J\b\u00103\u001a\u00020&H\u0002J\b\u00104\u001a\u00020&H\u0002J\u0012\u00105\u001a\u00020\u00062\b\u00106\u001a\u0004\u0018\u000107H\u0002J\u0010\u00108\u001a\u00020&2\u0006\u00109\u001a\u00020\u000eH\u0002J\b\u0010:\u001a\u00020&H\u0002J\u001a\u0010;\u001a\u00020&2\u0006\u0010<\u001a\u00020\u000e2\b\b\u0002\u0010=\u001a\u00020\u0006H\u0002J\u001a\u0010>\u001a\u00020&2\u0006\u0010<\u001a\u00020\u000e2\b\b\u0002\u0010=\u001a\u00020\u0006H\u0002J\u001a\u0010?\u001a\u00020&2\b\b\u0002\u0010=\u001a\u00020\u00062\u0006\u0010<\u001a\u00020\u000eH\u0002J\u0012\u0010@\u001a\u00020\u00062\b\b\u0002\u0010=\u001a\u00020\u0006H\u0002J\b\u0010A\u001a\u00020&H\u0002J\u0010\u0010B\u001a\u00020&2\u0006\u0010<\u001a\u00020\u000eH\u0002J\b\u0010C\u001a\u00020&H\u0002J\b\u0010D\u001a\u00020&H\u0002J\u0010\u0010E\u001a\u00020&2\u0006\u00109\u001a\u00020\u000eH\u0002J\u0010\u0010F\u001a\u00020&2\u0006\u00109\u001a\u00020\u000eH\u0002J\u0010\u0010G\u001a\u00020&2\u0006\u0010H\u001a\u00020IH\u0014J\u001a\u0010J\u001a\u00020&2\u0006\u0010K\u001a\u00020\u00002\b\u0010H\u001a\u0004\u0018\u00010IH\u0002J\u0010\u0010L\u001a\u00020&2\u0006\u0010M\u001a\u00020NH\u0002J\u001a\u0010O\u001a\u00020P2\u0006\u0010H\u001a\u00020I2\b\b\u0002\u0010=\u001a\u00020\u0006H\u0003J\u0012\u0010Q\u001a\u00020&2\b\u0010R\u001a\u0004\u0018\u00010IH\u0002J\u0010\u0010S\u001a\u00020&2\u0006\u0010H\u001a\u00020IH\u0002J\b\u0010T\u001a\u00020&H\u0002J\u0010\u0010U\u001a\u00020&2\u0006\u00109\u001a\u00020\u000eH\u0002J\u0010\u0010V\u001a\u00020\u00062\u0006\u0010H\u001a\u00020IH\u0002J\u001a\u0010W\u001a\u00020&2\u0006\u0010X\u001a\u00020,2\b\u00109\u001a\u0004\u0018\u00010\u000eH\u0002J\b\u0010Y\u001a\u00020\u0006H\u0002J\b\u0010Z\u001a\u00020PH\u0002J\u001a\u0010[\u001a\u00020&2\u0006\u0010H\u001a\u00020I2\b\u0010'\u001a\u0004\u0018\u00010\u000eH\u0002J\u001c\u0010\\\u001a\u0004\u0018\u00010]2\u0006\u0010H\u001a\u00020I2\b\u0010'\u001a\u0004\u0018\u00010\u000eH\u0002J\b\u0010^\u001a\u00020&H\u0002J\b\u0010f\u001a\u00020&H\u0014J\b\u0010g\u001a\u00020&H\u0016J\b\u0010h\u001a\u00020&H\u0002J\b\u0010i\u001a\u00020&H\u0002J\b\u0010j\u001a\u00020&H\u0014J\u0014\u0010k\u001a\u000e\u0012\u0004\u0012\u00020m\u0012\u0004\u0012\u00020m0lH\u0016J\b\u0010n\u001a\u00020&H\u0002J\u001e\u0010o\u001a\u00020&2\u0006\u0010p\u001a\u00020q2\f\u0010r\u001a\b\u0012\u0004\u0012\u00020]0sH\u0002J\"\u0010t\u001a\u00020&2\u0006\u0010u\u001a\u00020m2\u0006\u0010v\u001a\u00020m2\b\u0010w\u001a\u0004\u0018\u00010IH\u0014J\u000f\u0010x\u001a\u0004\u0018\u00010NH\u0000¢\u0006\u0002\byJ\n\u0010z\u001a\u0004\u0018\u00010NH\u0002J\b\u0010{\u001a\u00020\u0006H\u0016J\b\u0010|\u001a\u00020\u0006H\u0016J\b\u0010}\u001a\u00020\u0006H\u0002J\b\u0010~\u001a\u00020\u0006H\u0002J\b\u0010\u007f\u001a\u00020\u0006H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0017\u001a\u0004\u0018\u00010\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001c\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0016\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010\u001f\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u0016\u001a\u0004\b\u001f\u0010\u001dR\u001b\u0010!\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u0016\u001a\u0004\b!\u0010\u001dR\u0016\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010_\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010`\u001a\u00020aX\u0082\u0004¢\u0006\u0004\n\u0002\u0010bR\u0010\u0010c\u001a\u00020dX\u0082\u0004¢\u0006\u0004\n\u0002\u0010e¨\u0006\u0081\u0001"}, d2 = {"Lcom/larus/home/impl/MainActivity;", "Lcom/larus/common_ui/activity/FlowCommonAppCompatActivity;", "Lcom/larus/bmhome/chat/IMainActivity;", "<init>", "()V", "hasSendClickAppEventWhenColdBoot", "", "hasEnterBackground", "isTouristMode", "savedInstanceStateIsNull", "alreadyInit", "routeEntryForInit", "Lcom/larus/platform/api/ExternalRouteEntry;", "mainFragmentArgs", "Landroid/os/Bundle;", "privacyDialog", "Landroidx/fragment/app/DialogFragment;", "touristLandingController", "Lcom/larus/home/impl/TouristLandingController;", "getTouristLandingController", "()Lcom/larus/home/impl/TouristLandingController;", "touristLandingController$delegate", "Lkotlin/Lazy;", "deeplinkService", "Lcom/larus/deeplink/api/IDeeplinkService;", "getDeeplinkService", "()Lcom/larus/deeplink/api/IDeeplinkService;", "deeplinkService$delegate", "isSideBar", "()Z", "isSideBar$delegate", "isInMinorMode", "isInMinorMode$delegate", "isMainContainerMode", "isMainContainerMode$delegate", "mainSideBarCreated", "Lkotlinx/coroutines/CompletableDeferred;", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "onSaveInstanceState", "outState", "attachBaseContext", "newBase", "Landroid/content/Context;", "hasChatFragment", "hasSideBarFragment", "isMainBotChatPage", "isFlowNativeBotChatVisible", "isFlowNativeBotChatVisible$impl_mainlandRelease", "tryInitWhenOnResume", "insertUpdateInfoProvider", "initTouristModeParams", "canRouterInTouristMode", "uri", "Landroid/net/Uri;", "tryAddToPageArgs", "bundle", "initMainFragmentArgs", "prepareForMainTabFragment", "args", "isTouristLaunch", "tryNavigateToNextPageDependOnProfileSwitch", "tryNavigateToNextPage", "shouldNavigateToAccountLoading", "navigateToAccountLoadingPage", "navigateToMainTabFragment", "observeSideBarFragmentOnce", "tryUpdateVideoCacheConfig", "addOuterArgs", "tryHandleSelectedTabWhenCreate", "onNewIntent", "intent", "Landroid/content/Intent;", "tryClearDialogFragmentAbove", "activity", "handleFragment", WidgetService.PARAM_FRAGMENT, "Landroidx/fragment/app/Fragment;", "handleDeeplink", "Lkotlinx/coroutines/Job;", "tryHandleMembershipRouter", "deliverIntent", "handleReceive", "tryHandleNoticePageDispatch", "tryAddPushEnterMethod", "isFromOuter", "fixState", PerfLog.PARAM_KEY_CONTEXT_ID, "checkCondition", "reportPrivacyWindowEvent", "reportOpenAppEvent", "getBootFromSystem", "", "reportSwitchForegroundAppEvent", "enterSystemPage", "appBackGroundListener", "com/larus/home/impl/MainActivity$appBackGroundListener$1", "Lcom/larus/home/impl/MainActivity$appBackGroundListener$1;", "gotoSystemPageCallback", "com/larus/home/impl/MainActivity$gotoSystemPageCallback$1", "Lcom/larus/home/impl/MainActivity$gotoSystemPageCallback$1;", "onResume", VideoEventOneOutSync.END_TYPE_FINISH, "reportAppFirstFrame", "doResumeInternal", LiveCommonConstants.REASON_ON_DEDTROY, "getFloatViewRestriction", "Landroid/util/Pair;", "", "clearAllNotifications", "tryToKeepAlarms", "notificationManager", "Landroid/app/NotificationManager;", "keepAlarmList", "", "onActivityResult", "requestCode", "resultCode", "data", "getMainFragment", "getMainFragment$impl_mainlandRelease", "getAttachedFragment", "needAdaptNavigationBarPadding", "needAdaptStatusBarPadding", "shouldAdaptActivityPadding", "hasRestoredNonSideBarMainFragment", "needAdaptNavigationBarPaddingWhenIme", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MainActivity extends FlowCommonAppCompatActivity implements j4 {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static boolean f344129x;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f344130g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f344131h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f344132i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f344133j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f344134k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ExternalRouteEntry f344135l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Bundle f344136m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public DialogFragment f344137n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f344138o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f344139p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f344140q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f344141r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Lazy f344142s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public CompletableDeferred<Boolean> f344143t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f344144u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final b f344145v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final c f344146w;

    public static final class a {
    }

    public static final class b implements f09.a.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MainActivity f344147a;

        @Override // f09.a.b
        public final void onAllActivityDestroyed() {
        }

        @Override // f09.a.b
        public final void onAppBackground() {
            MainActivity r100 = this.f344147a;
            r100.f344131h = true;
            if (r100.f344144u == true) goto L5;
            OpenGraceReportHelper.f346337a.getClass();
            OpenGraceReportHelper.f346338b = false;
            OpenGraceReportHelper.f346339c = false;
            HomeService.f344094a.f0(this.f344147a);
        L5:
            AppLaunchTracer r101 = AppLaunchTracer.f274169a;
            Map r102 = MapsKt.mapOf(TuplesKt.to(LocationMonitorConst.IS_BACKGROUND, Boolean.TRUE));
            r101.getClass();
            AppLaunchTracer.e(r102);
        }

        @Override // f09.a.b
        public final void onAppForeground() {
            MainActivity r100 = this.f344147a;
            boolean r101 = MainActivity.f344129x;
            r100.O1();
            MainActivity r102 = this.f344147a;
            Uri r103 = r102.getIntent().getData();
            if (r103 == null) goto L5;
            com.larus.home.impl.ug.n.f346328a.getClass();
            boolean r104 = com.larus.home.impl.ug.n.a(r102, r103);
        L7:
            if (r102.f344131h == false) goto L12;
            if (r104 == false) goto L10;
            OpenGraceReportHelper r105 = OpenGraceReportHelper.f346337a;
            com.larus.home.impl.ug.n.f346328a.getClass();
            String r106 = com.larus.home.impl.ug.n.f346334g;
            r105.getClass();
            OpenGraceReportHelper.c(r106);
        L11:
            OpenGraceReportHelper r107 = OpenGraceReportHelper.f346337a;
            JSONObject r108 = new JSONObject();
            r108.put("enter_method", "switch_background");
            r107.getClass();
            OpenGraceReportHelper.a(r108);
            r102.f344131h = false;
            goto L12
        L10:
            OpenGraceReportHelper.f346337a.getClass();
            OpenGraceReportHelper.b("hot_launch");
        L12:
            this.f344147a.f344144u = false;
            AppHost.Companion r109 = AppHost.f326268a;
            if (r109.isOversea() == false) goto L18;
            if (ILoginService.f286097a.getAccountInfo().f531528a == false) goto L18;
            ap9.a r110 = ap9.a.f15860a;
        L18:
            if (this.f344147a.X1() == true) goto L20;
        L27:
            AppLaunchTracer r111 = AppLaunchTracer.f274169a;
            Map r112 = MapsKt.mapOf(TuplesKt.to(LocationMonitorConst.IS_BACKGROUND, Boolean.FALSE));
            r111.getClass();
            AppLaunchTracer.e(r112);
            return;
        L20:
            if (Intrinsics.areEqual(r109.a().getCurrentActivity(), this.f344147a) == false) goto L27;
            ActivityResultCaller r113 = this.f344147a.S1();
            if ((r113 instanceof com.larus.bmhome.a0) == false) goto L24;
            com.larus.bmhome.a0 r114 = (com.larus.bmhome.a0) r113;
        L25:
            if (r114 == null) goto L27;
            r114.v7(false);
            goto L27
        L24:
            r114 = null;
            goto L25
        L5:
            r104 = false;
            goto L7
        }

        public b(MainActivity r100) {
            this.f344147a = r100;
        }
    }

    public static final class c implements q5 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MainActivity f344148a;

        @Override // v19.q5
        public final void gotoToSystemPage() {
            this.f344148a.f344144u = true;
        }

        public c(MainActivity r100) {
            this.f344148a = r100;
        }
    }

    public static final class d implements p0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MainActivity f344149a;

        @Override // com.larus.common_ui.dialog.p0
        public final void confirm() {
            b0 r100 = b0.f472129a;
            MainActivity r101 = this.f344149a;
            r100.getClass();
            b0.c(r101, true);
            ISecPrivacyService.f326368a.getClass();
            ISecPrivacyService r102 = ISecPrivacyService.a.a();
            if (r102 == null) goto L5;
            r102.e();
        L5:
            ISecPrivacyService r103 = ISecPrivacyService.a.a();
            if (r103 == null) goto L8;
            r103.i(true);
        L8:
            gb9.d.f480736a.set(true);
            InitScheduler.afterPrivacyPopupWindow();
            Lazy r104 = ec9.l.f472142a;
            ec9.l.e(this.f344149a);
            DialogFragment r105 = this.f344149a.f344137n;
            if (r105 != null) goto L21;
        L16:
            final MainActivity r106 = this.f344149a;
            Function0 r107 = new v(r106);
            Intrinsics.checkNotNullParameter(r107, "block");
            if (mga.b.a().isExecuteSucceed() == true) goto L19;
            r107.invoke();
            return;
        L19:
            boolean r108 = MainActivity.f344129x;
            r106.c2();
            Unit r109 = Unit.INSTANCE;
            return;
        L21:
            r105.dismiss();     // Catch: Exception -> L12
        L12:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r110 = DialogFragmentLancet.sLastShowStack;
            if (r110 == null) goto L16;
            com.bytedance.crash.d.d(r110, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            goto L16
        }

        public d(MainActivity r100) {
            this.f344149a = r100;
        }
    }

    public static final class e implements com.larus.common_ui.dialog.u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MainActivity f344150a;

        @Override // com.larus.common_ui.dialog.u
        public final void cancel() {
            b0 r100 = b0.f472129a;
            MainActivity r101 = this.f344150a;
            r100.getClass();
            b0.c(r101, false);
            FLogger.f375446a.i("InitPeriodWrapper", "cancel curMills = " + System.currentTimeMillis() + " pid = " + Process.myPid());
            Process.killProcess(Process.myPid());
        }

        public e(MainActivity r100) {
            this.f344150a = r100;
        }
    }

    public static final class f implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f344151a;

        public f(j r100) {
            Intrinsics.checkNotNullParameter(r100, "function");
            this.f344151a = r100;
        }

        public final boolean equals(Object r100) {
            if ((r100 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r100 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r100).getFunctionDelegate());
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> getFunctionDelegate() {
            return this.f344151a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object r100) {
            this.f344151a.invoke(r100);
        }
    }

    public static final class g extends BDNetworkTagContextProviderAdapter {
        @Override // com.ss.android.ugc.quota.BDNetworkTagContextProviderAdapter, com.ss.android.ugc.quota.IBDNetworkTagContextProvider
        public final int triggerType() {
            return 0;
        }

        public g() {
        }
    }

    static {
        f344129x = true;
    }

    public final void O1() {
        Object r100 = getSystemService("notification");
        List<String> r101 = null;
        if ((r100 instanceof NotificationManager) == false) goto L5;
        NotificationManager r102 = (NotificationManager) r100;
    L6:
        if (r102 == null) goto L38;
        AppletService r103 = (AppletService) ServiceManager.get().getService(AppletService.class);
        if (r103 == null) goto L10;
        List<String> r104 = r103.d();
    L11:
        IObricNotificationIslandService r105 = (IObricNotificationIslandService) ServiceManager.get().getService(IObricNotificationIslandService.class);
        if (r105 == null) goto L14;
        r101 = r105.a();
    L14:
        if (r104 != null) goto L16;
        r104 = CollectionsKt.emptyList();
    L16:
        List<String> r106 = r104;
        if (r101 != null) goto L19;
        r101 = CollectionsKt.emptyList();
    L19:
        List r107 = CollectionsKt.distinct(CollectionsKt.plus(r106, r101));
        if (r107.isEmpty() == false) goto L23;
        r102.cancelAll();
        return;
    L23:
        if (Build.VERSION.SDK_INT >= 26) goto L26;
        r102.cancelAll();
        return;
    L26:
        if ((!r107.isEmpty()) == false) goto L33;
        StatusBarNotification[] r108 = r102.getActiveNotifications();
        Intrinsics.checkNotNull(r108);
        int r109 = r108.length;
        int r110 = 0;
    L28:
        if (r110 >= r109) goto L41;
        StatusBarNotification r111 = r108[r110];
        if (r107.contains(r111.getNotification().getChannelId()) == true) goto L32;
        r102.cancel(r111.getId());
    L32:
        r110 = r110 + 1;
        goto L28
    L41:
        return;
    L33:
        r102.cancelAll();
        return;
    L10:
        r104 = null;
        goto L11
    L38:
        return;
    L5:
        r102 = null;
        goto L6
    }

    public final void P1() {
        AtomicBoolean r100 = com.larus.home.impl.b.f344160a;
        e10 r101 = e10.f368561a;
        qv9.f r102 = e10.U();
        boolean r103 = Intrinsics.areEqual(r102.a(), Boolean.TRUE);
        Long r104 = r102.b();
        if (r104 == null) goto L5;
        long r105 = r104.longValue();
    L6:
        Long r106 = r102.c();
        if (r106 == null) goto L9;
        long r107 = r106.longValue();
    L10:
        com.larus.home.impl.b.a(PortraitEngine.LABEL_FIRST_FRAME, r103, r105, r107, 2000, com.larus.home.impl.b.f344160a, null);
        if (f2.f315011c == true) goto L19;
        f2.f315011c = true;
        Iterator<f2.b> r108 = f2.f315012d.iterator();
    L14:
        if (r108.hasNext() == false) goto L19;
        r108.next().onFirstFrame();     // Catch: Throwable -> L18
    L19:
        AppInitReporter r109 = AppInitReporter.f344102a;
        String r110 = getComponentName().getClassName();
        monitor-enter(r109);
        Intrinsics.checkNotNullParameter(r110, "activityName");     // Catch: Throwable -> L37
        if (AppInitReporter.f344112k == false) goto L25;
        monitor-exit(r109);
    L35:
        SettingService.f367887a.k();
        c2();
        N1(getWindow()).post(new p(this));
        return;
    L25:
        AppInitReporter.f344112k = true;     // Catch: Throwable -> L37
        JSONObject r111 = new JSONObject();     // Catch: Throwable -> L37
        r111.put("launcher_activity", r110);     // Catch: Throwable -> L37
        r111.put("is_cold_launch", 1 ^ (AppInitReporter.a(r110) ? 1 : 0));     // Catch: Throwable -> L37
        Long r112 = AppInitReporter.f344111j;     // Catch: Throwable -> L37
        if (r112 == null) goto L28;
        long r113 = r112.longValue();     // Catch: Throwable -> L37
    L30:
        if (r113 > 0) goto L32;
    L34:
        monitor-exit(r109);
        goto L35
    L32:
        if ((System.currentTimeMillis() - r113) > 30000) goto L34;
        AppInitReporter.c(AppInitReporter.ReportType.FIRST_FRAME, r111);     // Catch: Throwable -> L37
        goto L34
    L28:
        r113 = 0;
    L37:
        th = move-exception;
        throw th;
    L9:
        r107 = 2000;
        goto L10
    L5:
        r105 = 0;
        goto L6
    }

    public final IDeeplinkService R1() {
        return (IDeeplinkService) this.f344139p.getValue();
    }

    public final boolean W1() {
        return ((Boolean) this.f344141r.getValue()).booleanValue();
    }

    public final boolean X1() {
        return ((Boolean) this.f344140q.getValue()).booleanValue();
    }

    @Override // com.larus.common_ui.activity.FlowCommonAppCompatActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void finish() {
        super.finish();
        FLogger r100 = FLogger.f375446a;
        r100.i(ILivePreInflateService.MAIN_ACTIVITY, VideoEventOneOutSync.END_TYPE_FINISH);
        if ((this instanceof ChatWindowActivity) == true) goto L56;
        r100.i("ActivityLancet", "finish ".concat(MainActivity.class.getName()));
        long r101 = SystemClock.uptimeMillis();
        Map<Activity, Long> r102 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r102);
        Long r103 = r102.get(this);     // Catch: Throwable -> L45
        if (r103 != null) goto L10;
    L13:
        r102.put(this, Long.valueOf(r101));     // Catch: Throwable -> L45
        monitor-exit(r102);     // Catch: Throwable -> L45
    L42:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
    L53:
        return;
    L16:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L19;
        r100.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L42
    L48:
        goto L53
    L19:
        if (isFinishing() == true) goto L22;
        r100.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L42
        goto L48
    L22:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L25;
        r100.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L42
        goto L48
    L25:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L28;
        r100.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L42
        goto L48
    L28:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L31;
        r100.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L42
        goto L48
    L31:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L33;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L42
        goto L48
    L33:
        Intent r104 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L42
        if (r104 == null) goto L48;
        r104.addFlags(268435456);     // Catch: Throwable -> L42
        r104.addFlags(2097152);     // Catch: Throwable -> L42
        r100.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L42
        startActivity(r104);     // Catch: Throwable -> L39
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L42
        goto L48
    L10:
        if ((r101 - r103.longValue()) >= 800) goto L13;
        monitor-exit(r102);     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        throw th;
    }

    @Override // com.larus.common_ui.activity.FlowCommonAppCompatActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(MainActivity.class.getName()));
    L5:
        super.onDestroy();
        ExposeXTrackerExtKt.d(this);
        AppHost.f326268a.a().c(this.f344145v);
        List<q5> r100 = v19.a.f552443a;
        c r101 = this.f344146w;
        Intrinsics.checkNotNullParameter(r101, "callback");
        ((ArrayList) v19.a.f552443a).remove(r101);
    }

    @Override // com.larus.common_ui.activity.FlowCommonAppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        Lazy r100 = ec9.l.f472142a;
        ISecPrivacyService.a r101 = ISecPrivacyService.f326368a;
        r101.getClass();
        ISecPrivacyService r102 = ISecPrivacyService.a.a();
        if (r102 == null) goto L5;
        boolean r103 = r102.j();
    L6:
        if (r103 == true) goto L9;
        ec9.l.f(new ec9.b());
    L9:
        super.onResume();
        r101.getClass();
        ISecPrivacyService r104 = ISecPrivacyService.a.a();
        if (r104 == null) goto L12;
        boolean r105 = r104.j();
    L13:
        if (r105 == true) goto L17;
        ec9.l.f(new ec9.k());
    L17:
        if (AppHost.f326268a.isOversea() == true) goto L27;
        r101.getClass();
        ISecPrivacyService r106 = ISecPrivacyService.a.a();
        if (r106 == null) goto L21;
        boolean r107 = r106.h();
    L22:
        if (r107 == true) goto L24;
    L29:
        ICommerceCreditService.f325667a.getClass();
        ICommerceCreditService r108 = ICommerceCreditService.a.a();
        if (r108 == null) goto L34;
        boolean r109 = true;
        if (r108.o("MainActivity_OnResume") != true) goto L34;
    L35:
        if (r109 == false) goto L39;
        ICommerceCreditService r110 = ICommerceCreditService.a.a();
        if (r110 == null) goto L39;
        r110.e("MainActivity_OnResume");
    L39:
        ICommerceCreditService r111 = ICommerceCreditService.a.a();
        if (r111 == null) goto L42;
        r111.f(null, "MainActivity_onResume");
    L42:
        b2(getIntent());
        f344129x = false;
        FLogger.f375446a.w(ILivePreInflateService.MAIN_ACTIVITY, "onResume end curMills = " + System.currentTimeMillis());
        AppInitReporter r112 = AppInitReporter.f344102a;
        if (AppInitReporter.f344108g != 0) goto L46;
        AppInitReporter.f344108g = System.currentTimeMillis();
        return;
    L46:
        return;
    L34:
        r109 = false;
        goto L35
    L24:
        if (mga.b.a().isExecuteSucceed() == false) goto L29;
        P1();
        goto L29
    L21:
        r107 = false;
        goto L22
    L27:
        if (mga.b.a().isExecuteSucceed() == false) goto L29;
        P1();
        goto L29
    L12:
        r105 = false;
        goto L13
    L5:
        r103 = false;
        goto L6
    }

    public MainActivity() {
        this.f344133j = true;
        this.f344135l = ExternalRouteEntry.INITIAL_ACTIVITY;
        this.f344136m = new Bundle();
        this.f344138o = LazyKt.lazy(new h(this));
        this.f344139p = LazyKt.lazy(new k());
        this.f344140q = LazyKt.lazy(new l());
        this.f344141r = LazyKt.lazy(new m());
        this.f344142s = LazyKt.lazy(new n());
        this.f344145v = new b(this);
        this.f344146w = new c(this);
    }

    @Override // com.larus.bmhome.chat.j4
    public final boolean B0() {
        if (X1() == true) goto L5;
    L7:
        return false;
    L5:
        if (W1() == true) goto L7;
        return true;
    }

    @Override // com.larus.common_ui.activity.FlowCommonAppCompatActivity
    public final Pair<Integer, Integer> D1() {
        if (X1() == true) goto L5;
        int r100 = com.larus.utils.u.c(this);
        int r101 = i5.k0() + r100;
        int r102 = (com.larus.utils.i.c(this) + r100) - i5.h0();
        if (getSupportFragmentManager().getFragments().size() <= 0) goto L19;
        Object r103 = ListProtector.get(getSupportFragmentManager().getFragments(), 0);
        BottomNavigationView r104 = null;
        if ((r103 instanceof MainTabFragment) == false) goto L11;
        MainTabFragment r105 = (MainTabFragment) r103;
    L12:
        if (r105 == null) goto L19;
        com.larus.home.impl.main.tab.component.c r106 = r105.f345849w;
        if (r106 == null) goto L16;
        r104 = r106.z8();
    L16:
        if (r104 == null) goto L19;
        int[] r107 = new int[2];
        r104.getLocationOnScreen(r107);
        r102 = r107[1];
        goto L19
    L11:
        r105 = null;
    L19:
        return new Pair(Integer.valueOf(r101), Integer.valueOf(r102));
    L5:
        return super.D1();
    }

    @Override // com.larus.common_ui.activity.FlowCommonAppCompatActivity
    public final boolean H1() {
        return a2();
    }

    @Override // com.larus.common_ui.activity.FlowCommonAppCompatActivity
    public final boolean K1() {
        return a2();
    }

    public final Fragment Q1() {
        ActivityResultCaller r100 = S1();
        if (W1() == false) goto L6;
        return null;
    L6:
        if (W1() == false) goto L9;
        return null;
    L9:
        if (X1() == false) goto L17;
        if ((r100 instanceof MainSideBarFragment) == false) goto L13;
        MainSideBarFragment r101 = (MainSideBarFragment) r100;
    L14:
        if (r101 != null) goto L37;
        return null;
    L37:
        return r101.getCurrentFragment();
    L13:
        r101 = null;
        goto L14
    L17:
        if (((Boolean) this.f344142s.getValue()).booleanValue() == false) goto L25;
        if ((r100 instanceof xq8.a) == false) goto L21;
        xq8.a r102 = (xq8.a) r100;
    L22:
        if (r102 != null) goto L39;
        return null;
    L39:
        return r102.p7();
    L21:
        r102 = null;
        goto L22
    L25:
        if ((r100 instanceof MainTabFragment) == false) goto L27;
        MainTabFragment r103 = (MainTabFragment) r100;
    L28:
        if (r103 == null) goto L30;
        String r104 = MainTabFragment.f345844J;
        BaseHomeTabFragment r105 = r103.IK(null);
    L31:
        if (r105 == null) goto L40;
        FragmentManager r106 = r105.getChildFragmentManager();
        if (r106 == null) goto L41;
        int r107 = BaseHomeTabFragment.f294907i;
        return r106.findFragmentByTag("chat_fragment_tag");
    L41:
        return null;
    L40:
        return null;
    L30:
        r105 = null;
        goto L31
    L27:
        r103 = null;
        goto L28
    }

    public final Fragment S1() {
        if (W1() == false) goto L6;
        return getSupportFragmentManager().findFragmentByTag("tag_main_minor_fragment");
    L6:
        if (X1() == false) goto L9;
        return getSupportFragmentManager().findFragmentByTag("tag_main_side_bar_fragment");
    L9:
        if (((Boolean) this.f344142s.getValue()).booleanValue() == false) goto L12;
        return getSupportFragmentManager().findFragmentByTag("tag_main_container_fragment");
    L12:
        return getSupportFragmentManager().findFragmentByTag("tag_main_tab_fragment");
    }

    public final boolean a2() {
        if (X1() == true) goto L5;
        return true;
    L5:
        if (X1() == true) goto L7;
    L16:
        boolean r100 = false;
    L17:
        if (r100 == true) goto L22;
        return false;
    L22:
        return true;
    L7:
        if (this.f344133j == true) goto L16;
        if (getSupportFragmentManager().findFragmentByTag("tag_main_side_bar_fragment") != null) goto L16;
        Fragment r101 = getSupportFragmentManager().findFragmentByTag("tag_main_tab_fragment");
        Fragment r102 = getSupportFragmentManager().findFragmentByTag("tag_main_container_fragment");
        if (r101 != null) goto L15;
        if (r102 == null) goto L16;
    L15:
        r100 = true;
        goto L17
    }

    @Override // com.larus.bmhome.chat.j4
    public final boolean c0() {
        if (W1() == false) goto L6;
        return false;
    L6:
        if (X1() == false) goto L8;
        return false;
    L8:
        Fragment r100 = S1();
        Fragment r101 = null;
        if ((r100 instanceof MainTabFragment) == false) goto L11;
        MainTabFragment r102 = (MainTabFragment) r100;
    L12:
        if (r102 == null) goto L16;
        String r103 = MainTabFragment.f345844J;
        BaseHomeTabFragment r104 = r102.IK(null);
        if (r104 == null) goto L16;
        r101 = r104.U90();
    L16:
        if (r101 == null) goto L19;
        return true;
    L19:
        return false;
    L11:
        r102 = null;
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v15, types: [com.larus.home.impl.t] */
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
    public final void c2() {
        Uri r100 = getIntent().getData();
        IDebugService r101 = (IDebugService) ServiceManager.get().getService(IDebugService.class);
        boolean r102 = false;
        if (r101 != null) goto L5;
    L7:
        boolean r103 = false;
    L9:
        if (r103 == false) goto L13;
        String r104 = String.valueOf(r100);
        t19.s.j(t19.s.f544207a, this, "fastLoginUrl=".concat(r104), null, false, 28);
        FLogger.f375446a.i(ILivePreInflateService.MAIN_ACTIVITY, "tryInitWhenOnResume fastLoginUri=" + r100);
        ((a0) this.f344138o.getValue()).a();
        Unit r105 = Unit.INSTANCE;
        SmartRouter.buildRoute(this, r104).d();
        return;
    L13:
        if (this.f344134k == false) goto L15;
        return;
    L15:
        AppHost.Companion r106 = AppHost.f326268a;
        if (r106.isOversea() == true) goto L20;
        ISecPrivacyService.f326368a.getClass();
        ISecPrivacyService r107 = ISecPrivacyService.a.a();
        if (r107 == null) goto L20;
        r107.i(false);
    L20:
        Integer r108 = null;
        if (com.larus.network.http.d.f360144e == false) goto L30;
        int r109 = u0.f346102a;
        Uri r110 = getIntent().getData();
        if (r110 == null) goto L25;
        String r111 = r110.toString();
    L27:
        if (Intrinsics.areEqual(u0.a(r111), "//cloud/chat") == false) goto L30;
        CloudTestAdapter.LaunchInfoObserver r112 = CloudTestAdapter.f344226a;
        CloudTestAdapter.a(this, getIntent());
        this.f344134k = true;
        return;
    L25:
        r111 = null;
    L30:
        ThreadPlus.submitRunnable(new i());
        FLogger r113 = FLogger.f375446a;
        r113.i(ILivePreInflateService.MAIN_ACTIVITY, "tryInitWhenOnResume intent -> " + getIntent());
        Object r114 = x.f346385a;
        x.a(getIntent(), "MainActivity_beforeRouteEntry", false);
        int r115 = com.larus.home.impl.c.f344162a;
        com.larus.home.impl.c.a(getIntent(), this.f344135l);
        Uri r116 = getIntent().getData();
        if (r116 != null) goto L33;
    L38:
        Bundle r117 = getIntent().getExtras();
        if (r117 == null) goto L41;
        this.f344136m = r117;
    L41:
        this.f344136m.putBoolean("is_from_outer", U1(getIntent()));
        Bundle r118 = this.f344136m;
        Uri r119 = getIntent().getData();
        if (r119 == null) goto L86;
        String r120 = UriProtector.getQueryParameter(r119, "select_tab");
        if (r120 != null) goto L46;
    L85:
        r118.putString("tag_id", UriProtector.getQueryParameter(r119, "tag_id"));
        goto L86
    L46:
        switch(r120.hashCode()) {
            case -1143492296: goto L80;
            case -1039690024: goto L74;
            case -149664601: goto L70;
            case 3351635: goto L66;
            case 95852938: goto L57;
            case 112202875: goto L53;
            case 882861586: goto L49;
            default: goto L85;
        };
    L49:
        if (r120.equals("community_create") == false) goto L85;
        r118.putString("index", String.valueOf(MainTabFragment.MainTab.COMMUNITY_CREATE.getIndex()));
        goto L85
    L53:
        if (r120.equals("video") == false) goto L85;
        r118.putString("index", String.valueOf(MainTabFragment.MainTab.VIDEO.getIndex()));
        r118.putString("item_id", UriProtector.getQueryParameter(r119, "item_id"));
        r118.putString("is_from_push", UriProtector.getQueryParameter(r119, "is_from_push"));
        goto L85
    L57:
        if (r120.equals("drive") == false) goto L85;
        BottomTabConfigManager r121 = BottomTabConfigManager.f345968a;
        if (BottomTabConfigManager.f345969b == true) goto L63;
        r121.l();
    L63:
        if (BottomTabConfigManager.k("drive") == false) goto L85;
        r118.putString("index", String.valueOf(MainTabFragment.MainTab.DRIVE.getIndex()));
        goto L85
    L66:
        if (r120.equals("mine") == false) goto L85;
        r118.putString("index", String.valueOf(MainTabFragment.MainTab.MINE.getIndex()));
        goto L85
    L70:
        if (r120.equals("home_message") == false) goto L85;
        r118.putString("index", String.valueOf(MainTabFragment.MainTab.CONVERSATION.getIndex()));
        goto L85
    L74:
        if (r120.equals("notice") == false) goto L85;
        if (BottomTabConfigManager.f345968a.j() == false) goto L85;
        r118.putString("index", String.valueOf(MainTabFragment.MainTab.NOTIFY.getIndex()));
        goto L85
    L80:
        if (r120.equals("bot_discovery") == false) goto L85;
        if (z2.f365865a.x3().getHideBottomTabDiscovery() == true) goto L85;
        r118.putString("index", String.valueOf(MainTabFragment.MainTab.DISCOVERY.getIndex()));
    L86:
        Bundle r122 = this.f344136m;
        IDeeplinkService r123 = R1();
        if (r123 != null) goto L89;
    L91:
        boolean r124 = false;
    L93:
        if (r124 == false) goto L95;
        r122.putString("enter_method", "outer_push");
    L95:
        Bundle r125 = this.f344136m;
        Uri r126 = getIntent().getData();
        if (r126 != null) goto L98;
    L100:
        Bundle r127 = this.f344136m;
        String r128 = r127.getString("come_from_login");
        by7.f r129 = new by7.f();
        TrackParams r130 = r129.f21467a;
        if (r128 != null) goto L103;
    L106:
        boolean r131 = true;
    L107:
        if (r131 == false) goto L109;
        r128 = "landing";
    L109:
        r130.put("current_page", r128);
        by7.h.k(r127, r129);
        if (this.f344136m.getBoolean("is_tourist_mode", false) == true) goto L121;
        Intent r132 = getIntent();
        if (r132 == null) goto L116;
        Uri r133 = r132.getData();
        if (r133 == null) goto L116;
        String r134 = UriProtector.getQueryParameter(r133, "is_tourist_mode");
    L118:
        if (Intrinsics.areEqual(r134, "true") == true) goto L121;
        boolean r135 = false;
    L122:
        this.f344132i = r135;
        r113.i(ILivePreInflateService.MAIN_ACTIVITY, "isTouristModeFromPush " + this.f344132i);
        if (this.f344132i == true) goto L200;
        if (ILoginService.f286097a.getAccountInfo().f531528a == true) goto L200;
        Uri r136 = getIntent().getData();
        if (r136 == null) goto L139;
        ILuckyDogService r137 = (ILuckyDogService) ServiceManager.get().getService(ILuckyDogService.class);
        if (r137 != null) goto L131;
    L133:
        boolean r138 = false;
    L134:
        if (r138 == false) goto L139;
        r113.i(ILivePreInflateService.MAIN_ACTIVITY, "preHandleSchema() schema is luckydog scheme，hand lucky dog scheme");
        ILuckyDogService r139 = (ILuckyDogService) ServiceManager.get().getService(ILuckyDogService.class);
        if (r139 == null) goto L138;
        r139.f(y0.k(r136), false);
    L138:
        r113.i(ILivePreInflateService.MAIN_ACTIVITY, "preHandleSchema() hand lucky dog scheme");
        OpenGraceReportHelper.f346337a.getClass();
        OpenGraceReportHelper.f346338b = false;
        OpenGraceReportHelper.f346339c = false;
        OpenGraceReportHelper.b("aweme_red_packet");
        JSONObject r140 = new JSONObject();
        r140.put("enter_method", "outer_link");
        r140.put("enter_url", r136.toString());
        r140.put("open_method", "aweme_red_packet");
        OpenGraceReportHelper.a(r140);
    L147:
        final a0 r141 = (a0) this.f344138o.getValue();
        r141.getClass();
        SecurityService r142 = (SecurityService) ServiceManager.get().getService(SecurityService.class);
        if (r142 != null) goto L150;
    L152:
        boolean r143 = false;
    L154:
        if (r143 == false) goto L157;
        r113.i("TouristLandingController", "checkTouristLaunchPage isBasicMode true  ");
        r141.f344159c.invoke();
    L205:
        if (i3.f365750a.f() == true) goto L207;
    L211:
        r106.a().j(this.f344145v);
        List<q5> r144 = v19.a.f552443a;
        v19.a.a(this.f344146w);
        i0.f375410a.getClass();
        i0.d(true);
        i0.i(new WeakReference(this));
        boolean r145 = com.larus.home.impl.f.f344386b;
        StringBuilder r146 = new StringBuilder("[init] hasInit: ");
        r146.append(com.larus.home.impl.f.f344386b);
        r146.append(", config:");
        Lazy r147 = com.larus.home.impl.f.f344393i;
        r146.append((nr9.b) r147.getValue());
        r113.i("HotLaunchController", r146.toString());
        if (((nr9.b) r147.getValue()).f520244a == true) goto L214;
    L220:
        IPermissionX.f363962a.m(new lb9.b());
        this.f344134k = true;
        z1a.a r148 = z1a.a.f569712a;
        u r149 = new u();
        r148.getClass();
        Intrinsics.checkNotNullParameter(r149, "requestHeaderProvider");
        IBitsUpdate r150 = (IBitsUpdate) ServiceManager.get().getService(IBitsUpdate.class);
        if (r150 == null) goto L223;
        r150.d(r149);
    L223:
        ObricUpdateSPIServiceDelegate r151 = ObricUpdateSPIServiceDelegate.f392918a;
        r151.b(new t());
        r151.a();
        return;
    L214:
        if (((nr9.b) r147.getValue()).f520245b == 0) goto L220;
        if (com.larus.home.impl.f.f344386b == true) goto L220;
        r106.a().e(com.larus.home.impl.f.f344395k);
        r106.a().j(com.larus.home.impl.f.f344394j);
        com.larus.home.impl.f.f344386b = true;
        goto L220
    L207:
        if (z2.f365865a.ugReturnConfig().f486777a == false) goto L211;
        Uri r152 = getIntent().getData();
        if (r152 == null) goto L211;
        UGReturnWindowManager.f346281a.getClass();
        UGReturnWindowManager.c(this, r152);
        goto L211
    L157:
        if (TouristManager.f357001a.f() == true) goto L159;
        r113.i("TouristLandingController", "checkTouristLaunchPage isHitTouristMode false  ");
        r141.a();
        goto L205
    L159:
        i1 r153 = LaunchCacheDelegate.f295726b.e();
        if (r153 == null) goto L162;
        String r154 = r153.f295807a;
    L163:
        if (r153 == null) goto L167;
        TouristModeABParam r155 = r153.f295808b;
        if (r155 == null) goto L167;
        r108 = Integer.valueOf(r155.getLaunchLandingPage());
    L167:
        if (r153 == null) goto L176;
        TouristModeABParam r156 = r153.f295808b;
        if (r156 == null) goto L176;
        Integer r157 = r156.getType();
        if (r157 == null) goto L176;
        if (r157.intValue() != 1) goto L176;
        boolean r158 = true;
    L178:
        if (r158 == false) goto L184;
        if (r108 == null) goto L184;
        if (r108.intValue() != 3) goto L184;
        r113.i("TouristLandingController", "checkTouristLaunchPage reset  lastTouristLandingPage to main bot  ");
        r108 = 2;
    L184:
        r113.i("TouristLandingController", "checkTouristLaunchPage touristLandingPage " + r154 + tb2.c.DEFAULT_TEXT + r108);
        if (r108 != null) goto L188;
    L189:
        if (r108 != null) goto L192;
    L194:
        if (r102 == false) goto L196;
        r141.f344159c.invoke();
    L197:
        if (r102 == false) goto L205;
        AuthModelDelegate.f297134b.a().observeForever(new TouristLandingController$observeRemoteLaunchInfo$1(r141));
        goto L205
    L196:
        r141.a();
        goto L197
    L192:
        if (r108.intValue() != 3) goto L194;
    L193:
        r102 = true;
        goto L194
    L188:
        if (r108.intValue() == 2) goto L193;
    L176:
        r158 = false;
        goto L178
    L162:
        r154 = null;
        goto L163
    L150:
        if (r142.isBasicMode() != true) goto L152;
        r143 = true;
        goto L154
    L131:
        if (r137.d(r136) != true) goto L133;
        r138 = true;
    L139:
        IDeeplinkService r159 = R1();
        if (r159 != null) goto L142;
    L144:
        boolean r160 = false;
    L145:
        if (r160 == false) goto L147;
        OpenGraceReportHelper.f346337a.getClass();
        OpenGraceReportHelper.b("outer_push");
        goto L147
    L142:
        if (r159.k(r136) != true) goto L144;
        r160 = true;
    L200:
        if (this.f344133j == false) goto L202;
    L203:
        r113.i(ILivePreInflateService.MAIN_ACTIVITY, "prepareForMainTabFragment " + this.f344136m);
        Y1(this.f344136m, false);
        goto L205
    L202:
        if (ObricInteractDelegate.f392884b.shouldRecoverMainFragmentAfterRestore(getSupportFragmentManager(), com.larus.nova.R.id.fragment_container) == false) goto L205;
    L116:
        r134 = null;
    L121:
        r135 = true;
        goto L122
    L103:
        if (r128.length() == 0) goto L106;
        r131 = false;
        goto L107
    L98:
        if (o0.d(r126.getHost()) == false) goto L100;
        r125.putString("to_page", r126.getHost());
        goto L100
    L89:
        if (r123.k(getIntent().getData()) != true) goto L91;
        r124 = true;
        goto L93
    L33:
        if (StringsKt.contains$default(r116.toString(), "//flow/notice_page_dispatch", false, 2, null) == false) goto L38;
        if (BottomTabConfigManager.f345968a.j() == false) goto L37;
        getIntent().setData(r116.buildUpon().path("home").appendQueryParameter("select_tab", "notice").build());
        goto L38
    L37:
        getIntent().setData(r116.buildUpon().path("notify_activity").build());
        goto L38
    L5:
        if (r101.r() != true) goto L7;
        r103 = true;
        goto L9
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStop() {
        super.onStop();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L9;
        N1(getWindow()).getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }

    @Override // com.larus.bmhome.chat.j4
    public final boolean s1() {
        Fragment r100 = S1();
        Fragment r101 = null;
        if ((r100 instanceof MainSideBarFragment) == false) goto L5;
        MainSideBarFragment r102 = (MainSideBarFragment) r100;
    L6:
        if (r102 == null) goto L8;
        r101 = r102.getCurrentFragment();
    L8:
        if (r101 != null) goto L10;
    L12:
        return false;
    L10:
        if ((r101 instanceof ChatFragment) == false) goto L12;
        return true;
    L5:
        r102 = null;
        goto L6
    }

    public static View N1(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public static void T1(Fragment r100) {
        if ((r100 instanceof DialogFragment) == true) goto L21;
        Iterator<T> r101 = r100.getChildFragmentManager().getFragments().iterator();
    L16:
        if (r101.hasNext() == false) goto L25;
        Fragment r102 = (Fragment) r101.next();
        Intrinsics.checkNotNull(r102);
        T1(r102);
        goto L16
    L25:
        return;
    L21:
    L13:
        FLogger.f375446a.e(ILivePreInflateService.MAIN_ACTIVITY, "dismissAllowingStateLoss fail");
        return;
    L19:
        ((DialogFragment) r100).dismissAllowingStateLoss();     // Catch: Exception -> L7
    L11:
        FLogger.f375446a.i(ILivePreInflateService.MAIN_ACTIVITY, "tryClearDialogFragmentAbove,".concat(r100.getClass().getSimpleName()));     // Catch: Exception -> L13
        return;
    L7:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");     // Catch: Exception -> L13
        Throwable r103 = DialogFragmentLancet.sLastShowStack;     // Catch: Exception -> L13
        if (r103 == null) goto L11;
        com.bytedance.crash.d.d(r103, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: Exception -> L13
        goto L11
    }

    public final boolean U1(Intent r100) {
        Uri r101 = r100.getData();
        IDeeplinkService r102 = R1();
        if (r102 != null) goto L5;
    L7:
        boolean r103 = false;
    L8:
        if (r103 == true) goto L34;
        IDeeplinkService r104 = R1();
        if (r104 != null) goto L12;
    L14:
        boolean r105 = false;
    L15:
        if (r105 == true) goto L34;
        IDeeplinkService r106 = R1();
        if (r106 != null) goto L19;
    L21:
        boolean r107 = false;
    L22:
        if (r107 == true) goto L34;
        IDeeplinkService r108 = R1();
        if (r108 != null) goto L26;
    L28:
        boolean r109 = false;
    L29:
        if (r109 == true) goto L34;
        if (ReceiveIntentServiceDelegate.f367362b.b(r100) == true) goto L34;
        boolean r110 = com.larus.home.impl.f.f344386b;
        Intrinsics.checkNotNullParameter(r100, "intent");
        if (r100.getBooleanExtra("is_from_hot_launch", false) == true) goto L34;
        return false;
    L26:
        if (r108.g(r101) != true) goto L28;
        r109 = true;
        goto L29
    L19:
        if (r106.f(r101) != true) goto L21;
        r107 = true;
        goto L22
    L12:
        if (r104.a(r101) != true) goto L14;
        r105 = true;
    L34:
        return true;
    L5:
        if (r102.k(r101) != true) goto L7;
        r103 = true;
        goto L8
    }

    @Override // com.larus.common_ui.activity.FlowCommonAppCompatActivity, androidx.appcompat.app.AppCompatActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public final void attachBaseContext(Context r100) {
        super.attachBaseContext(r100);
    }

    public final void b2(Intent r100) {
        if (r100 != null) goto L5;
        r100 = getIntent();
    L5:
        if (AccountService.f365697a.isLogin().booleanValue() == true) goto L22;
        ICommerceMembershipService.f325827a.getClass();
        ICommerceMembershipService r101 = ICommerceMembershipService.a.a();
        String r102 = null;
        if (r101 == null) goto L14;
        if (r100 == null) goto L10;
        String r103 = r100.getDataString();
    L11:
        boolean r104 = r101.l(r103);
        boolean r105 = true;
        if (r104 != true) goto L14;
    L15:
        if (r105 == false) goto L23;
        ICommerceMembershipService r106 = ICommerceMembershipService.a.a();
        if (r106 == null) goto L24;
        if (r100 == null) goto L20;
        r102 = r100.getDataString();
    L20:
        r106.f(r102, "MainActivity_handleDeeplink");
        return;
    L24:
        return;
    L23:
        return;
    L10:
        r103 = null;
    L14:
        r105 = false;
        goto L15
    }

    @Override // com.larus.common_ui.activity.FlowCommonAppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle r110) {
        if (z2.f365865a.enableGlobalActivityTheme() == false) goto L7;
        v19.f.a(getTheme());     // Catch: Throwable -> L180
    L7:
        if (v19.f.f(this) == false) goto L9;
        v19.f.c(getTheme());     // Catch: Throwable -> L180
    L9:
        AppLaunchTracer.f274169a.c("enter_main", null);
        AppInitReporter r100 = AppInitReporter.f344102a;
        if (AppInitReporter.f344107f != 0) goto L12;
        AppInitReporter.f344107f = System.currentTimeMillis();
    L12:
        FLogger.f375446a.i("InitPeriodWrapper", "MainActivity onCreate start curMills = " + System.currentTimeMillis());
        if (Intrinsics.areEqual(getIntent().getAction(), "android.intent.action.MAIN") == true) goto L15;
    L188:
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L40
        ILuckyDogService r102 = (ILuckyDogService) ServiceManager.get().getService(ILuckyDogService.class);     // Catch: Throwable -> L40
        if (r102 == null) goto L37;
        r102.preInit();     // Catch: Throwable -> L40
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L40
    L38:
        Result.m9449constructorimpl(r103);     // Catch: Throwable -> L40
    L42:
        SecurityService r104 = (SecurityService) ServiceManager.get().getService(SecurityService.class);
        boolean r105 = false;
        if (r104 != null) goto L45;
    L47:
        boolean r106 = false;
    L48:
        if (r106 == false) goto L58;
        ISecPrivacyService.f326368a.getClass();
        ISecPrivacyService r107 = ISecPrivacyService.a.a();
        if (r107 == null) goto L52;
        boolean r108 = r107.h();
    L53:
        if (r108 == true) goto L58;
        super.onCreate(r110);
        int r109 = ec9.m.f472143a;
        Class<? extends Activity> r111 = CustomPrivacyService.f344098b.b();
        if (r111 != null) goto L57;
        r111 = PrivacyAgreeActivity.class;
    L57:
        Intent r112 = new Intent(this, r111);
        r112.setFlags(268435456);
        startActivity(r112);
        super.finish();
        return;
    L52:
        r108 = false;
    L58:
        int r113 = com.larus.home.impl.utils.d.f346347a;
        Intent r114 = getIntent();
        boolean r115 = U1(getIntent());
        Intrinsics.checkNotNullParameter(r114, "intent");
        if (com.example.feed_ui.c.f274027a.a(AppHost.f326268a.getApplication(), ILoginService.f286097a.isNewUser()) == false) goto L61;
        e10 r116 = e10.f368561a;
        int r117 = l0.f375430a;
        int r118 = ((Number) l0.a(1, new wn())).intValue();
    L62:
        if (r115 == false) goto L64;
    L67:
        boolean r119 = true;
    L68:
        LaunchLandingConfigHelperDelegate r120 = LaunchLandingConfigHelperDelegate.f314922b;
        LandingConfig r121 = r120.b();
        if (r121 != null) goto L73;
        if (r118 == 3) goto L73;
        if (r119 == true) goto L73;
        e0.b(true);
    L89:
        if (r110 != null) goto L91;
        boolean r122 = true;
    L92:
        this.f344133j = r122;
        ec9.l.c(this);
        if (r110 == null) goto L114;
        String[] r123 = {"RMX2195", "RMX2101"};
        int r124 = Build.VERSION.SDK_INT;
        if (r124 != 29) goto L97;
    L99:
        boolean r125 = ArraysKt.contains(r123, Build.MODEL);
    L100:
        if (r125 == false) goto L114;
        r110.setClassLoader(MainActivity.class.getClassLoader());
        Bundle r126 = r110.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key");
        if (r126 == null) goto L114;
        Set<String> r127 = r126.keySet();
        if (r127 == null) goto L114;
        Iterator<T> r128 = r127.iterator();
    L107:
        if (r128.hasNext() == false) goto L114;
        Object r129 = r126.get((String) r128.next());
        if ((r129 instanceof Bundle) == false) goto L111;
        Bundle r130 = (Bundle) r129;
    L112:
        if (r130 == null) goto L107;
        r130.setClassLoader(MainActivity.class.getClassLoader());
        goto L107
    L111:
        r130 = null;
        goto L112
    L97:
        if (r124 == 28) goto L99;
        r125 = false;
    L114:
        super.onCreate(r110);
        AppletService r131 = (AppletService) ServiceManager.get().getService(AppletService.class);
        if (r131 != null) goto L117;
    L119:
        boolean r132 = false;
    L120:
        if (r132 == true) goto L204;
        List<Activity> r133 = AppHost.f326268a.a().g();
        if ((r133 instanceof Collection) == true) goto L125;
    L127:
        Iterator<T> r134 = r133.iterator();
    L129:
        if (r134.hasNext() == false) goto L138;
        Activity r135 = (Activity) r134.next();
        if (r135 != this) goto L133;
    L135:
        boolean r136 = false;
    L136:
        if (r136 == false) goto L129;
        boolean r137 = true;
    L139:
        if (r137 == false) goto L144;
        Object r138 = x.f346385a;
        x.a(getIntent(), "MainActivity_onCreate", true);
        if (r110 != null) goto L144;
        this.f344135l = ExternalRouteEntry.EXISTING_STACK;
    L144:
        if (AppHost.f326268a.isOversea() == true) goto L156;
        ISecPrivacyService.f326368a.getClass();
        ISecPrivacyService r139 = ISecPrivacyService.a.a();
        if (r139 == null) goto L148;
        boolean r140 = r139.h();
    L149:
        if (r140 == true) goto L156;
        DialogFragment r141 = c0.a(this, new d(this), new e(this), true);
        this.f344137n = r141;
        FragmentManager r142 = getSupportFragmentManager();
        LandscapeRestrictionOperation r143 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r141, null, r143);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r142, r141, r143) == false) goto L186;
    L155:
        b0.f472129a.getClass();
        Result.m9448boximpl(b0.d(this));
    L159:
        Lazy r144 = ec9.l.f472142a;
        ISecPrivacyService.f326368a.getClass();
        ISecPrivacyService r145 = ISecPrivacyService.a.a();
        if (r145 == null) goto L162;
        boolean r146 = r145.j();
    L163:
        if (r146 == true) goto L184;
        ec9.l.f(new ec9.f());
    L184:
        ActionBar r147 = getSupportActionBar();     // Catch: Exception -> L171
        if (r147 == null) goto L169;
        r147.hide();     // Catch: Exception -> L171
    L169:
        FrameLayout r148 = new FrameLayout(this);     // Catch: Exception -> L171
        r148.setId(com.larus.nova.R.id.fragment_container);     // Catch: Exception -> L171
        r148.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));     // Catch: Exception -> L171
        setContentView(r148);     // Catch: Exception -> L171
    L173:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new MainActivity$reportPrivacyWindowEvent$1(this, null), 2, null);
        Z1(getIntent(), r110);
        com.larus.home.impl.f.f344389e = false;
        com.larus.home.impl.f.f344390f = false;
        com.larus.home.impl.f.f344391g = 0;
        boolean r149 = this.f344133j;
        FLogger.f375446a.i("HotLaunchController", "[setRebuild] isFirst:" + r149);
        com.larus.home.impl.f.f344387c = r149 ^ true;
        AppLaunchTracer r150 = AppLaunchTracer.f274169a;
        Map r151 = MapsKt.mapOf(new kotlin.Pair[]{TuplesKt.to("is_tourist_mode", Boolean.valueOf(i3.f365750a.i())), TuplesKt.to("is_login", AccountService.f365697a.isLogin())});
        r150.getClass();
        AppLaunchTracer.e(r151);
        Lazy r152 = ec9.l.f472142a;
        ISecPrivacyService.f326368a.getClass();
        ISecPrivacyService r153 = ISecPrivacyService.a.a();
        if (r153 == null) goto L176;
        r105 = r153.j();
    L176:
        if (r105 == true) goto L205;
        ec9.l.f(new ec9.j());
        return;
    L205:
        return;
    L171:
        e = move-exception;
        FLogger.f375446a.e("FlowCommonAppCompatActivity", "onCreate e: ", e);
        goto L173
    L162:
        r146 = false;
        goto L163
    L186:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L181
    L154:
        r141.show(r142, null);
        goto L155
    L148:
        r140 = false;
    L156:
        Function0 r154 = new o(this);
        Intrinsics.checkNotNullParameter(r154, "block");
        if (mga.b.a().isExecuteSucceed() == true) goto L159;
        r154.invoke();
        goto L159
    L133:
        if ((r135 instanceof OpenAppActivity) == true) goto L135;
        r136 = true;
    L138:
        r137 = false;
        goto L139
    L125:
        if (r133.isEmpty() == false) goto L127;
    L204:
        return;
    L117:
        if (r131.b(this, getIntent().getData(), true) != true) goto L119;
        r132 = true;
        goto L120
    L91:
        r122 = false;
    L73:
        if (r121 == null) goto L87;
        LandingConfig r155 = r120.b();
        if (r155 == null) goto L77;
        String r156 = r155.a();
    L78:
        if (r156 == null) goto L89;
        if (o0.d(r156) == false) goto L89;
        if (StringsKt.contains$default(r156, "conversation_list", false, 2, null) == false) goto L85;
        e0.a(true);
        e0.b(false);
        goto L89
    L85:
        if (StringsKt.contains$default(r156, "discovery", false, 2, null) == false) goto L89;
        e0.a(false);
        e0.b(false);
        goto L89
    L77:
        r156 = null;
        goto L78
    L87:
        if (r118 != 3) goto L89;
        e0.a(true);
        e0.b(false);
        goto L89
    L64:
        if (r114.getBooleanExtra("is_from_outer", false) == true) goto L67;
        r119 = false;
        goto L68
    L61:
        e10 r157 = e10.f368561a;
        r118 = e10.F0();
        goto L62
    L45:
        if (r104.D() != true) goto L47;
        r106 = true;
        goto L48
    L37:
        r103 = null;
    L40:
        th = move-exception;
        Result.Companion r158 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L42
    L15:
        if ((getIntent().getFlags() & 268435456) == 0) goto L188;
        if ((getIntent().getFlags() & 67108864) != 0) goto L188;
        if ((getIntent().getFlags() & 4194304) == 0) goto L188;
        Iterator<T> r159 = AppHost.f326268a.a().g().iterator();
    L22:
        if (r159.hasNext() == false) goto L26;
        Object r160 = r159.next();
        if (Intrinsics.areEqual(((Activity) r160).getClass(), MainActivity.class) == false) goto L22;
    L27:
        Activity r161 = (Activity) r160;
        if (r161 == null) goto L188;
        if (r161.isFinishing() == true) goto L188;
        if (r161.isDestroyed() == true) goto L188;
        FLogger.f375446a.w(ILivePreInflateService.MAIN_ACTIVITY, "MainActivity is already in stack, finish current");
        finish();
        goto L188
    L26:
        r160 = null;
        goto L27
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public final void onNewIntent(Intent r110) {
        Intrinsics.checkNotNullParameter(r110, "intent");
        super.onNewIntent(r110);
        AppletService r100 = (AppletService) ServiceManager.get().getService(AppletService.class);
        if (r100 != null) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == false) goto L11;
        return;
    L11:
        if (AppHost.f326268a.isOversea() == true) goto L19;
        ISecPrivacyService.f326368a.getClass();
        ISecPrivacyService r102 = ISecPrivacyService.a.a();
        if (r102 == null) goto L15;
        boolean r103 = r102.h();
    L16:
        if (r103 == true) goto L19;
        this.f344135l = ExternalRouteEntry.NEW_INTENT;
        setIntent(r110);
        return;
    L15:
        r103 = false;
    L19:
        Uri r104 = r110.getData();
        IDebugService r105 = (IDebugService) ServiceManager.get().getService(IDebugService.class);
        if (r105 != null) goto L22;
    L24:
        boolean r106 = false;
    L26:
        if (r106 == false) goto L30;
        String r111 = String.valueOf(r104);
        t19.s.j(t19.s.f544207a, this, "fastLoginUrl=".concat(r111), null, false, 28);
        FLogger.f375446a.i(ILivePreInflateService.MAIN_ACTIVITY, "onNewIntent fastLoginUri=" + r104);
        ((a0) this.f344138o.getValue()).a();
        Unit r107 = Unit.INSTANCE;
        SmartRouter.buildRoute(this, r111).d();
        return;
    L30:
        if (com.larus.network.http.d.f360144e == false) goto L39;
        int r108 = u0.f346102a;
        Uri r109 = r110.getData();
        if (r109 == null) goto L34;
        String r112 = r109.toString();
    L36:
        if (Intrinsics.areEqual(u0.a(r112), "//cloud/chat") == false) goto L39;
        CloudTestAdapter.a(this, r110);
        return;
    L34:
        r112 = null;
    L39:
        Bundle r113 = r110.getExtras();
        if (r113 != null) goto L42;
    L44:
        boolean r114 = false;
    L45:
        if (r114 == false) goto L47;
        return;
    L47:
        Z1(r110, null);
        x.a(r110, "MainActivity_onNewIntent", true);
        int r115 = com.larus.home.impl.c.f344162a;
        com.larus.home.impl.c.a(r110, ExternalRouteEntry.NEW_INTENT);
        FLogger.f375446a.i(ILivePreInflateService.MAIN_ACTIVITY, "onNewIntent -> " + r110);
        IZlinkService r116 = (IZlinkService) ServiceManager.get().getService(IZlinkService.class);
        if (r116 == null) goto L50;
        r116.a(r110);
    L50:
        b2(r110);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new MainActivity$handleDeeplink$1(this, r110, false, null), 3, null);
        ReceiveIntentServiceDelegate r117 = ReceiveIntentServiceDelegate.f367362b;
        if (r117.b(r110) == false) goto L54;
        com.larus.home.impl.utils.f.a(r110);
        r117.a(this);
    L54:
        if (Intrinsics.areEqual(r110.getStringExtra("clear_dialog_fragment"), "1") == false) goto L59;
        Iterator<T> r118 = getSupportFragmentManager().getFragments().iterator();
    L57:
        if (r118.hasNext() == false) goto L61;
        Fragment r119 = (Fragment) r118.next();
        Intrinsics.checkNotNull(r119);
        T1(r119);
        goto L57
    L61:
        return;
    L59:
        return;
    L42:
        if (r113.getBoolean("key_hook_main_activity_on_new_intent") != true) goto L44;
        r114 = true;
        goto L45
    L22:
        if (r105.r() != true) goto L24;
        r106 = true;
        goto L26
    L5:
        if (r100.b(this, r110.getData(), false) != true) goto L7;
        r101 = true;
        goto L8
    }

    @Override // com.larus.common_ui.activity.FlowCommonAppCompatActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onSaveInstanceState(Bundle r100) {
        Intrinsics.checkNotNullParameter(r100, "outState");
        Fragment r101 = S1();
        if ((r101 instanceof MainSideBarFragment) == false) goto L5;
        MainSideBarFragment r102 = (MainSideBarFragment) r101;
    L6:
        if (r102 == null) goto L8;
        int r103 = r102.ub();
    L9:
        r100.putInt("key_restore_side_bar_page", r103);
        FLogger.f375446a.i(ILivePreInflateService.MAIN_ACTIVITY, "onSaveInstanceState, restoreSideBarPage=" + r103);
        super.onSaveInstanceState(r100);
        return;
    L8:
        r103 = 0;
        goto L9
    L5:
        r102 = null;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r4v2, types: [com.larus.home.impl.j] */
    public final void Y1(Bundle r110, boolean r111) {
        Lazy r100 = uj9.d.f550448a;
        if (uj9.d.d() == false) goto L7;
        if (LoginService.f356989a.y() == true) goto L7;
    L14:
        boolean r101 = true;
    L17:
        if (r101 == true) goto L19;
        FLogger.f375446a.i(ILivePreInflateService.MAIN_ACTIVITY, "navigate to account loading page");
        SmartRouter.buildRoute(AppHost.f326268a.getApplication().getApplicationContext(), "//flow/account_request_loading_page").d();
    L40:
        AuthModelDelegate.f297134b.m().observeForever(new f(new j()));
        Uri r102 = getIntent().getData();
        if (r102 == null) goto L154;
        if (StringsKt.contains$default(r102.toString(), "//flow/home", false, 2, null) == false) goto L45;
    L149:
        IDeeplinkService r103 = R1();
        if (r103 == null) goto L152;
        r103.j(r102);
    L152:
        FLogger.f375446a.i(ILivePreInflateService.MAIN_ACTIVITY, "intent data url is MainActivity, do not jump");
        com.larus.home.impl.deeplink.b r104 = com.larus.home.impl.deeplink.b.f344383a;
        Intent r105 = getIntent();
        r104.getClass();
        com.larus.home.impl.deeplink.b.e(this, r105, r102);
        String r106 = com.larus.home.impl.deeplink.b.b(r102);
        OpenGraceReportHelper.f346337a.getClass();
        OpenGraceReportHelper.b(r106);
        JSONObject r107 = new JSONObject();
        r107.put("enter_method", r106);
        r107.put("enter_url", r102.toString());
        r107.put("open_method", ComplianceResult.JsonKey.MARKET_DEEP_LINK);
        OpenGraceReportHelper.a(r107);
        goto L154
    L45:
        if (StringsKt.contains$default(r102.toString(), "//conversation_list", false, 2, null) == true) goto L149;
        if (StringsKt.contains$default(r102.toString(), "//main_page", false, 2, null) == true) goto L149;
        if (StringsKt.contains$default(r102.toString(), "//main_tab_page", false, 2, null) == true) goto L149;
        if (ILoginService.f286097a.getAccountInfo().f531528a == false) goto L54;
    L69:
        a0 r108 = (a0) this.f344138o.getValue();
        Uri r109 = getIntent().getData();
        r108.getClass();
        FLogger r112 = FLogger.f375446a;
        r112.i("TouristLandingController", "needResetDeepLinkToMainBot " + r109 + ' ');
        if (i3.f365750a.f() == false) goto L121;
        i1 r113 = h1.a();
        if (r113 == null) goto L81;
        TouristModeABParam r114 = r113.f295808b;
        if (r114 == null) goto L81;
        Integer r115 = r114.getType();
        if (r115 == null) goto L81;
        if (r115.intValue() != 1) goto L81;
        boolean r116 = true;
    L82:
        if (r116 == false) goto L121;
        if (r109 == null) goto L118;
        String r117 = r109.toString();
        String r118 = ChatRoutePushInterceptor.f346039a;
        if (ChatRoutePushInterceptor.a.c(r117) == false) goto L118;
        String r119 = ChatRoutePushInterceptor.a.a(r109);
        LaunchCacheDelegate r120 = LaunchCacheDelegate.f295726b;
        i1 r121 = r120.e();
        if (r121 == null) goto L90;
        String r122 = r121.f295809c;
    L91:
        r112.i("TouristLandingController", "isToMainBotChat mainBotId " + r122 + ' ');
        String r123 = UriProtector.getQueryParameter(r109, "conversation_id");
        i1 r124 = r120.e();
        if (r124 == null) goto L94;
        String r125 = r124.f295810d;
    L95:
        r112.i("TouristLandingController", "isToMainBotChat mainConversationId " + r125 + ' ');
        if (o0.d(r119) == false) goto L100;
        if (Intrinsics.areEqual(r122, r119) == false) goto L100;
    L117:
        boolean r126 = true;
    L119:
        if (r126 == true) goto L121;
        boolean r127 = true;
    L122:
        if (r127 == false) goto L148;
        ILuckyDogService r128 = (ILuckyDogService) ServiceManager.get().getService(ILuckyDogService.class);
        if (r128 != null) goto L126;
    L128:
        boolean r129 = false;
    L129:
        if (r129 == true) goto L148;
        ICommunityService r130 = (ICommunityService) ServiceManager.get().getService(ICommunityService.class);
        if (r130 != null) goto L133;
    L135:
        boolean r131 = false;
    L136:
        if (r131 == true) goto L148;
        getIntent().setData(UriProtector.parse("sslocal://chat_page"));
        r112.i(ILivePreInflateService.MAIN_ACTIVITY, "prepareForMainTabFragment tourist mode  reset uri to main bot");
        Intent r132 = getIntent();
        if (r132 != null) goto L140;
    L142:
        boolean r133 = false;
    L143:
        if (r133 == false) goto L148;
        Result.Companion r134 = Result.Companion;     // Catch: Throwable -> L146
        StringCompanionObject r135 = StringCompanionObject.INSTANCE;     // Catch: Throwable -> L146
        String r136 = String.format(getString(com.larus.nova.R.string.larus_iOS_lockscreen_actions_login_toast), Arrays.copyOf(new Object[]{AppHost.f326268a.getAppStringName()}, 1));     // Catch: Throwable -> L146
        t19.s.j(t19.s.f544207a, this, r136, null, false, 28);     // Catch: Throwable -> L146
        r112.i(ILivePreInflateService.MAIN_ACTIVITY, "prepareForMainTabFragment: show toast ".concat(r136));     // Catch: Throwable -> L146
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L146
    L146:
        th = move-exception;
        Result.Companion r137 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L148
    L140:
        if (r132.getBooleanExtra("show_tourist_mode_toast", false) != true) goto L142;
        r133 = true;
        goto L143
    L133:
        if (r130.k1(r102) != true) goto L135;
        r131 = true;
        goto L136
    L126:
        if (r128.d(r102) != true) goto L128;
        r129 = true;
    L148:
        FLogger.f375446a.i(ILivePreInflateService.MAIN_ACTIVITY, "prepareForMainTabFragment handleDeeplink");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new MainActivity$handleDeeplink$1(this, getIntent(), r111, null), 3, null);
    L100:
        if (o0.d(r123) == true) goto L102;
    L103:
        if (r119 != null) goto L105;
    L108:
        boolean r138 = true;
    L109:
        if (r138 == false) goto L118;
        if (r123 != null) goto L112;
    L115:
        boolean r139 = true;
    L116:
        if (r139 == false) goto L118;
    L112:
        if (r123.length() == 0) goto L115;
        r139 = false;
        goto L116
    L105:
        if (r119.length() == 0) goto L108;
        r138 = false;
        goto L109
    L102:
        if (Intrinsics.areEqual(r125, r123) == true) goto L117;
    L94:
        r125 = null;
        goto L95
    L90:
        r122 = null;
    L118:
        r126 = false;
    L81:
        r116 = false;
    L121:
        r127 = false;
        goto L122
    L54:
        if (this.f344132i == true) goto L69;
        ILuckyDogService r140 = (ILuckyDogService) ServiceManager.get().getService(ILuckyDogService.class);
        if (r140 != null) goto L58;
    L60:
        boolean r141 = false;
    L61:
        if (r141 == true) goto L69;
        ICommunityService r142 = (ICommunityService) ServiceManager.get().getService(ICommunityService.class);
        if (r142 != null) goto L65;
    L67:
        boolean r143 = false;
    L68:
        if (r143 == false) goto L154;
    L65:
        if (r142.k1(r102) != true) goto L67;
        r143 = true;
        goto L68
    L58:
        if (r140.d(r102) != true) goto L60;
        r141 = true;
    L154:
        if (X1() == true) goto L156;
    L157:
        Intent r144 = getIntent();
        ReceiveIntentServiceDelegate r145 = ReceiveIntentServiceDelegate.f367362b;
        if (r145.b(r144) == false) goto L160;
        com.larus.home.impl.utils.f.a(r144);
        r145.a(this);
    L160:
        O1();
        return;
    L156:
        if (W1() == false) goto L160;
    L19:
        if (W1() == false) goto L26;
        IMinorService.Companion r146 = IMinorService.f359156a;
        if (r146 == null) goto L23;
        Fragment r147 = r146.h();
    L24:
        kotlin.Pair r148 = TuplesKt.to(r147, "tag_main_minor_fragment");
    L32:
        Fragment r149 = (Fragment) r148.component1();
        String r150 = (String) r148.component2();
        if (r149 == null) goto L40;
        r149.setArguments(r110);
        FragmentTransaction r151 = getSupportFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r151, r149, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, r150, com.larus.nova.R.id.fragment_container) == true) goto L38;
        r151 = r151.replace(com.larus.nova.R.id.fragment_container, r149, r150);
    L38:
        r151.commitAllowingStateLoss();
        goto L40
    L23:
        r147 = null;
        goto L24
    L26:
        if (X1() == false) goto L29;
        FLogger.f375446a.i(ILivePreInflateService.MAIN_ACTIVITY, "create side bar fragment");
        this.f344143t = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        getSupportFragmentManager().registerFragmentLifecycleCallbacks(new MainActivity$observeSideBarFragmentOnce$1(this), false);
        r148 = TuplesKt.to(new MainSideBarFragment(), "tag_main_side_bar_fragment");
        goto L32
    L29:
        if (((Boolean) this.f344142s.getValue()).booleanValue() == false) goto L31;
        FLogger.f375446a.i(ILivePreInflateService.MAIN_ACTIVITY, "create main container fragment");
        r148 = TuplesKt.to(new MainContainerFragment(), "tag_main_container_fragment");
        goto L32
    L31:
        FLogger.f375446a.i(ILivePreInflateService.MAIN_ACTIVITY, "create tab fragment");
        r148 = TuplesKt.to(new MainTabFragment(true), "tag_main_tab_fragment");
    L7:
        if (IAccountService.f286094a.p() == true) goto L9;
    L10:
        if (r111 == true) goto L12;
        boolean r152 = true;
    L13:
        if (r152 == false) goto L14;
        r101 = false;
    L12:
        r152 = false;
        goto L13
    L9:
        if (LoginService.f356989a.y() == false) goto L12;
        goto L10
    }

    public final void Z1(Intent r100, Bundle r101) {
        if (r101 == null) goto L4;
        return;
    L4:
        if (Intrinsics.areEqual(r100.getAction(), "android.intent.action.MAIN") == true) goto L6;
        return;
    L6:
        if (this.f344130g == false) goto L8;
        return;
    L8:
        if (this.f344131h == true) goto L29;
        boolean r102 = com.larus.home.impl.f.f344386b;
        Intrinsics.checkNotNullParameter(r100, "intent");
        boolean r103 = false;
        if (r100.getBooleanExtra("is_from_hot_launch", false) == true) goto L30;
        OpenGraceReportHelper.f346337a.getClass();
        OpenGraceReportHelper.b("app_icon");
        if (r100.hasExtra("HMOS_VERSION") == false) goto L16;
        String r104 = r100.getStringExtra("BOOT_FROM");
        if (r104 == null) goto L16;
    L17:
        JSONObject r105 = new JSONObject();
        r105.put("enter_method", "click_app");
        r105.put("enter_url", String.valueOf(r100.getData()));
        if (r104 != null) goto L20;
    L21:
        r103 = true;
    L22:
        if (r103 == true) goto L24;
        r105.put("boot_from_system", r104);
    L24:
        OpenGraceReportHelper.a(r105);
        this.f344130g = true;
        return;
    L20:
        if (StringsKt.isBlank(r104) == false) goto L22;
    L16:
        r104 = null;
        goto L17
    L30:
        return;
    }

    @Override // com.larus.common_ui.activity.FlowCommonAppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public final void onActivityResult(int r100, int r101, Intent r102) {
        super.onActivityResult(r100, r101, r102);
        FLogger r103 = FLogger.f375446a;
        StringBuilder r104 = new StringBuilder("Router onActivityResult: requestCode -> ");
        r104.append(r100);
        r104.append(" , resultCode -> ");
        r104.append(r101);
        r104.append(" , data: ");
        if (r102 == null) goto L5;
        Bundle r105 = r102.getExtras();
    L6:
        r104.append(r105);
        r103.i(ILivePreInflateService.MAIN_ACTIVITY, r104.toString());
        if (r102 == null) goto L26;
        Bundle r106 = r102.getExtras();
        if (r106 == null) goto L27;
        ActivityResultCaller r107 = Q1();
        if ((r107 instanceof ChatFragment) == false) goto L14;
        ((ChatFragment) r107).Lc(r106, r100, r101);
        return;
    L14:
        if ((r107 instanceof ChatDoubleTabFragment) == false) goto L17;
        ((ChatDoubleTabFragment) r107).Lc(r106, r100, r101);
        return;
    L17:
        if ((r107 instanceof ChatImmersFragment) == false) goto L20;
        ((ChatImmersFragment) r107).onActivityResult(r100, r101, r102);
        return;
    L20:
        if ((r107 instanceof ChatMultiTabFragment) == false) goto L23;
        ((ChatMultiTabFragment) r107).T90(r100, r101, r106);
        return;
    L23:
        if ((r107 instanceof com.larus.bmhome.y) == false) goto L32;
        ((com.larus.bmhome.y) r107).onResult(r106);
        return;
    L32:
        return;
    L27:
        return;
    L26:
        return;
    L5:
        r105 = null;
        goto L6
    }
}
