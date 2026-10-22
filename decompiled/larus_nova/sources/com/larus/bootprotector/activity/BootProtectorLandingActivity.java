package com.larus.bootprotector.activity;

import android.R;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.view.View;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.news.common.settings.SettingsManager;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.larus.applog.api.IApplog;
import com.larus.bootprotector.IBootProtectorLauncher;
import com.larus.bootprotector.activity.dialog.BootProtectorConfirmDialog;
import com.larus.bootprotector.entity.BaseExceptionInfo;
import com.larus.bootprotector.entity.LastException;
import com.larus.bootprotector.hotfix.IBootProtectorHotPatch;
import com.larus.common.apphost.AppHost;
import com.larus.platform.service.z2;
import com.larus.settings.provider.bootprotector.BootProtectorConfig;
import com.larus.settings.provider.bootprotector.CrashPortrait;
import com.larus.settings.provider.bootprotector.PreciseFixStategy;
import com.larus.settings.provider.bootprotector.UrgentCmd;
import com.larus.settings.value.e10;
import com.larus.utils.logger.FLogger;
import com.larus.utils.u;
import com.lynx.tasm.LynxError;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.obric.assistant.spi.bootprotector.ObricBootProtectorSPIServiceDelegate;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0016\u0018\u0000 *2\u00020\u0001:\u0001*B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0014J\u0012\u0010\n\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0014J\b\u0010\r\u001a\u00020\u0007H\u0002J\b\u0010\u000e\u001a\u00020\u0007H\u0002J\b\u0010\u000f\u001a\u00020\u0007H\u0002J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0007H\u0002J\u0010\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0005H\u0002J\b\u0010\u0018\u001a\u00020\u0007H\u0002J\b\u0010\u0019\u001a\u00020\u0007H\u0002J\u0016\u0010\u001a\u001a\u00020\u00072\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0002J\u0010\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001cH\u0002J\b\u0010\u001f\u001a\u00020\u0007H\u0002J\b\u0010 \u001a\u00020\u0007H\u0002J\b\u0010!\u001a\u00020\u0007H\u0002J\b\u0010\"\u001a\u00020\u0007H\u0002J\b\u0010#\u001a\u00020\u0007H\u0002J\b\u0010$\u001a\u00020\u0007H\u0002J\u0010\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u0011H\u0002J\b\u0010'\u001a\u00020\u0007H\u0014J\b\u0010(\u001a\u00020\u0007H\u0002J\b\u0010)\u001a\u00020\u0007H\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/larus/bootprotector/activity/BootProtectorLandingActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "lastDownloadClickTime", "", "attachBaseContext", "", "newBase", "Landroid/content/Context;", WidgetCostModule.TYPE_ON_CREATE, "savedInstanceState", "Landroid/os/Bundle;", "initBootProtectorLandingPageDependency", "showBootProtectorDialog", "onDownloadBtnClick", "gotoMarket", "", PerfLog.PARAM_KEY_CONTEXT_ID, "packageName", "", "onOptimizeBtnClick", "executeUrgentCmdTaskWithDelay", "delayMs", "executeUrgentCmdTaskImmediately", "executeAggressiveCleaning", "executePreciseCleaning", "urgentCmds", "", "Lcom/larus/settings/provider/bootprotector/UrgentCmd;", "matchLastExceptionWithPortrait", "requestHotFixPatch", "requestHotFixPatchInternal", "requestSettingInBootProtector", "requestSettingInBootProtectorInternal", "reportEnterBootProtectorPage", "reportClickOpt", "reportClickDownload", "success", "onStop", "skipBootProtectorPageOnNextLaunch", LiveCommonConstants.REASON_ON_DEDTROY, "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class BootProtectorLandingActivity extends AppCompatActivity {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f317605b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f317606a;

    public static final class a {
    }

    static {
    }

    public static void A1() {
        nu8.a.e("BootProtectorLandingAct", "executeUrgentCmdTaskImmediately");
        IBootProtectorLauncher.f317602a.getClass();
        IBootProtectorLauncher.a.b().b();
    }

    public static List B1() {
        e10 r100 = e10.f368561a;
        BootProtectorConfig r101 = e10.C();
        if (r101 == null) goto L25;
        List<PreciseFixStategy> r102 = r101.getPreciseFixStrategies();
        if (r102 == null) goto L25;
        LastException r103 = hu8.e.h();
        if (r103 != null) goto L10;
        return null;
    L10:
        Iterator<T> r104 = r102.iterator();
    L12:
        if (r104.hasNext() == false) goto L24;
        PreciseFixStategy r105 = (PreciseFixStategy) r104.next();
        if (r105 == null) goto L16;
        CrashPortrait r106 = r105.getCrashPortrait();
    L17:
        if (r106 == null) goto L12;
        if (ku8.a.c(r103, r106) == false) goto L12;
        nu8.a.h("BootProtectorLandingAct", "matchLastExceptionWithPortrait: MATCHED !");
        List<UrgentCmd> r107 = r105.getUrgentCmds();
        if (r107 != null) goto L23;
        return null;
    L23:
        return CollectionsKt.filterNotNull(r107);
    L16:
        r106 = null;
        goto L17
    L24:
        nu8.a.e("BootProtectorLandingAct", "matchLastExceptionWithPortrait: NOT MATCHED !");
    L25:
        return null;
    }

    public static void y1() {
        BaseExceptionInfo.Type r100 = null;
        String r101 = hu8.e.d();     // Catch: Throwable -> L5
        nu8.a.a("BootProtectorSettings", "getClearCacheWhiteList json string: ".concat(r101));     // Catch: Throwable -> L5
        List<String> r102 = (List) new Gson().fromJson(r101, new hu8.b().getType());     // Catch: Throwable -> L5
    L7:
        nu8.a.g(mu8.d.a(r102), "[setting] whiteList files path:");
        List<String> r103 = r102;
        if (r103 != null) goto L10;
    L13:
        boolean r104 = true;
    L14:
        if (r104 == false) goto L16;
        r102 = au8.a.f16317a;
    L16:
        nu8.a.g(mu8.d.a(r102), "[final] whiteList files path:");
        ju8.a.f500503a.a(r102);
        LastException r105 = hu8.e.h();
        if (r105 == null) goto L20;
        String r106 = r105.getExceptionStackTrace();
        if (r106 == null) goto L20;
    L21:
        LastException r107 = hu8.e.h();
        if (r107 == null) goto L24;
        r100 = r107.getCrashType();
    L24:
        int r108 = au8.b.f16318a;
        au8.b.a("bootprotector_execute_clean", com.larus.utils.f.c(new Pair[]{TuplesKt.to(BdpAppEventConstant.PARAMS_STRATEGY_NAME, "aggressive"), TuplesKt.to("white_list", hu8.e.d()), TuplesKt.to("crash_type", r100), TuplesKt.to("crash_stack", StringsKt.take(r106, 4000))}));
        return;
    L20:
        r106 = "";
        goto L21
    L10:
        if (r103.isEmpty() == true) goto L13;
        r104 = false;
    L5:
        th = move-exception;
        nu8.a.f("BootProtectorSettings", th, "getClearCacheWhiteList failed");
        r102 = null;
        goto L7
    }

    public final void C1() {
        nu8.a.e("BootProtectorLandingAct", "requestHotFixPatchInternal start");
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L11
        int r101 = fu8.b.f478914a;     // Catch: Throwable -> L11
        Application r102 = getApplication();     // Catch: Throwable -> L11
        Intrinsics.checkNotNullParameter(r102, "application");     // Catch: Throwable -> L11
        nu8.a.e("BootProtectorHotPatch", "initHotFix");     // Catch: Throwable -> L11
        IBootProtectorHotPatch r103 = (IBootProtectorHotPatch) ServiceManager.get().getService(IBootProtectorHotPatch.class);     // Catch: Throwable -> L11
        if (r103 == null) goto L6;
        r103.b(r102);     // Catch: Throwable -> L11
    L6:
        nu8.a.e("BootProtectorHotPatch", "requestHotPatch");     // Catch: Throwable -> L11
        IBootProtectorHotPatch r104 = (IBootProtectorHotPatch) ServiceManager.get().getService(IBootProtectorHotPatch.class);     // Catch: Throwable -> L11
        if (r104 == null) goto L9;
        r104.a();     // Catch: Throwable -> L11
    L9:
        nu8.a.e("BootProtectorLandingAct", "requestHotFixPatchInternal end");     // Catch: Throwable -> L11
        hu8.a.b("bootprotector_hotfix", 1);     // Catch: Throwable -> L11
        Object r105 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L13:
        Throwable r106 = Result.m9452exceptionOrNullimpl(r105);
        if (r106 == null) goto L19;
        nu8.a.e("BootProtectorLandingAct", "requestHotFixPatch fail " + r106);
        hu8.a.b("bootprotector_hotfix", 0);
        return;
    L19:
        return;
    L11:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L13
    }

    public final void D1() {
        nu8.a.e("BootProtectorLandingAct", "requestSettingInBootProtectorInternal: start");
        SettingsManager.updateSettings(true);
        e10 r100 = e10.f368561a;
        final BootProtectorConfig r101 = e10.C();
        nu8.a.a("BootProtectorLandingAct", "[requestSettingInBootProtectorInternal]#current bootProtectorConfig: " + r101);
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new BootProtectorLandingActivity$requestSettingInBootProtectorInternal$1(null), 3, null);
        SettingsManager.registerListener(new c(r101, this), false);
        nu8.a.e("BootProtectorLandingAct", "requestSettingInBootProtectorInternal: end");
    }

    public final void F1() {
        int r100 = hu8.e.f487260a;
        Intrinsics.checkNotNullParameter(this, "baseContext");
        hu8.e.a(this, false, "enter_boot_protector");
        hu8.a.b("current_crash_count", 0);
        nu8.a.a("BootProtectorSettings", "clearCrashCount to 0");
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(getClass().getName()));
    L5:
        super.onDestroy();
        ObricBootProtectorSPIServiceDelegate.f392853b.a();
        Intrinsics.checkNotNullParameter(this, "<this>");
        nu8.a.e("ProcessUtils", "killAllPackageProcesses");
        Intrinsics.checkNotNullParameter(this, "<this>");
        nu8.a.e("ProcessUtils", "killOtherProcesses");
        int r100 = Process.myPid();
        Object r101 = getSystemService("activity");     // Catch: Throwable -> L18
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type android.app.ActivityManager");     // Catch: Throwable -> L18
        List<ActivityManager.RunningAppProcessInfo> r102 = ((ActivityManager) r101).getRunningAppProcesses();     // Catch: Throwable -> L18
        if (r102 != null) goto L9;
        r102 = CollectionsKt.emptyList();     // Catch: Throwable -> L18
    L9:
        String r103 = getPackageName();     // Catch: Throwable -> L18
        Iterator<ActivityManager.RunningAppProcessInfo> r104 = r102.iterator();     // Catch: Throwable -> L18
    L10:
        if (r104.hasNext() == false) goto L22;
        ActivityManager.RunningAppProcessInfo r105 = r104.next();     // Catch: Throwable -> L18
        String r106 = r105.processName;     // Catch: Throwable -> L18
        Intrinsics.checkNotNull(r103);     // Catch: Throwable -> L18
        if (StringsKt.startsWith$default(r106, r103, false, 2, null) == false) goto L10;
        if (r105.pid == r100) goto L10;
        nu8.a.d("Kill: " + r105.processName + " pid: " + r105.pid);     // Catch: Throwable -> L18
        Process.killProcess(r105.pid);     // Catch: Throwable -> L18
    L22:
        iu8.a.b();
        throw null;
    L18:
        th = move-exception;
        Intrinsics.checkNotNullParameter("Kill", "text");
        Intrinsics.checkNotNullParameter(th, LynxError.LYNX_THROWABLE);
        FLogger r107 = FLogger.f375446a;
        if (r107.a() == false) goto L22;
        r107.e("bootprotector", "Kill", th);
        goto L22
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0108 */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r100 = FLogger.f375446a;
        r100.i("ActivityLancet", "finish ".concat(getClass().getName()));
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
    L50:
        return;
    L16:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L19;
        r100.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L42
        goto L50
    L19:
        if (isFinishing() == true) goto L22;
        r100.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L42
        goto L50
    L22:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L25;
        r100.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L42
        goto L50
    L25:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L28;
        r100.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L42
        goto L50
    L28:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L31;
        r100.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L42
        goto L50
    L31:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L33;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L42
        goto L50
    L33:
        Intent r104 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L42
        if (r104 == null) goto L50;
        r104.addFlags(268435456);     // Catch: Throwable -> L42
        r104.addFlags(2097152);     // Catch: Throwable -> L42
        r100.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L42
        startActivity(r104);     // Catch: Throwable -> L39
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L42
        goto L50
    L10:
        if ((r101 - r103.longValue()) >= 800) goto L13;
        monitor-exit(r102);     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        throw th;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStop() {
        super.onStop();
        F1();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L14;
        View r100 = getWindow().getDecorView();     // Catch: Throwable -> L11
        if (com.larus.home.impl.utils.c.f346345e == false) goto L9;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");     // Catch: Throwable -> L11
        Thread r101 = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L11
        if (r101 == com.larus.home.impl.utils.c.f346341a) goto L9;
        com.larus.home.impl.utils.c.a(r101, "getDecorView");     // Catch: Throwable -> L11
    L9:
        r100.getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L11
        return;
    L15:
        return;
    }

    public BootProtectorLandingActivity() {
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public final void attachBaseContext(Context r100) {
        super.attachBaseContext(r100);
        nu8.a.e("BootProtectorLandingAct", "attachBaseContext");
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle r110) {
        if (z2.f365865a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (v19.f.f(this) == false) goto L10;
        v19.f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        v19.f.a(getTheme());
        super.onCreate(r110);
        nu8.a.e("BootProtectorLandingAct", WidgetCostModule.TYPE_ON_CREATE);
        if (Intrinsics.areEqual("auto_test", AppHost.f326268a.getBuildChannel()) == false) goto L13;
        finish();
        return;
    L13:
        overridePendingTransition(0, 0);
        ActionBar r100 = getSupportActionBar();
        if (r100 == null) goto L17;
        r100.hide();
    L17:
        if ((getResources().getConfiguration().uiMode & 48) != 32) goto L19;
        boolean r101 = true;
    L20:
        u.e(this, true, r101);
        u.d(this);
        setContentView(com.larus.nova.R.layout.larus_activity_boot_protector);
        IBootProtectorLauncher.f317602a.getClass();
        IBootProtectorLauncher.a.b().a(getApplication().getBaseContext());
        IApplog.Companion r102 = IApplog.f287053a;
        if (r102.getDeviceId().length() <= 0) goto L23;
        boolean r103 = true;
    L24:
        if (r103 == false) goto L26;
        C1();
    L28:
        if (r102.getDeviceId().length() <= 0) goto L30;
        boolean r104 = true;
    L31:
        if (r104 == false) goto L33;
        D1();
    L34:
        ThreadMethodProxy.start(new PthreadThreadV2(new d(this), "BootProtectorLandingActivity"));
        onPostResume();
        ObricBootProtectorSPIServiceDelegate r111 = ObricBootProtectorSPIServiceDelegate.f392853b;
        String r105 = r111.e();
        if (r105 != null) goto L37;
        r105 = getResources().getString(com.larus.nova.R.string.larus_boot_protector_dialog_message);
    L37:
        String r106 = r111.d();
        if (r106 != null) goto L40;
        r106 = getString(com.larus.nova.R.string.larus_boot_protector_dialog_btn_download);
    L40:
        Intrinsics.checkNotNullParameter(r105, "message");
        String r107 = getString(com.larus.nova.R.string.larus_boot_protector_dialog_title);
        Intrinsics.checkNotNullParameter(r107, "title");
        j r108 = new j(this);
        Intrinsics.checkNotNullParameter(r108, "listener");
        boolean r112 = !r111.b();
        k r109 = new k(this);
        String r113 = getString(com.larus.nova.R.string.larus_boot_protector_dialog_btn_opt);
        Intrinsics.checkNotNullParameter(r109, "listener");
        int r114 = ContextCompat.getColor(this, com.larus.nova.R.color.larus_primary_50);
        Function0<Boolean> r115 = new b(this);
        Intrinsics.checkNotNullParameter(r115, "callback");
        BootProtectorConfirmDialog r116 = new BootProtectorConfirmDialog();
        r116.f317614e = r107;
        r116.f317616g = r105;
        r116.f317617h = r106;
        r116.f317618i = r108;
        r116.f317619j = r112;
        r116.f317620k = r113;
        r116.f317621l = r114;
        r116.f317622m = r109;
        r116.f317623n = r115;
        FragmentManager r117 = getSupportFragmentManager();
        LandscapeRestrictionOperation r118 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        BaseExceptionInfo.Type r119 = null;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r116, null, r118);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r117, r116, r118) == false) goto L56;
    L45:
        Unit r120 = Unit.INSTANCE;
        hu8.a.b("enter_bootprotector_page", 1);
        LastException r121 = hu8.e.h();
        if (r121 == null) goto L49;
        String r122 = r121.getExceptionStackTrace();
        if (r122 == null) goto L49;
    L50:
        LastException r123 = hu8.e.h();
        if (r123 == null) goto L53;
        r119 = r123.getCrashType();
    L53:
        int r124 = au8.b.f16318a;
        au8.b.a("enter_bootprotector_page", com.larus.utils.f.c(new Pair[]{TuplesKt.to("crash_count", Integer.valueOf(hu8.e.g())), TuplesKt.to("crash_type", r119), TuplesKt.to("crash_stack", StringsKt.take(r122, 4000))}));
        ObricBootProtectorSPIServiceDelegate.f392853b.g();
        return;
    L49:
        r122 = "";
        goto L50
    L56:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L55
    L44:
        r116.show(r117, null);
        goto L45
    L33:
        nu8.a.b("BootProtectorLandingAct", "requestSettingInBootProtector: did is empty");
        r102.j(new i(this));
        goto L34
    L30:
        r104 = false;
        goto L31
    L26:
        nu8.a.b("BootProtectorLandingAct", "requestHotFixPatch did is empty");
        r102.j(new h(this));
        goto L28
    L23:
        r103 = false;
        goto L24
    L19:
        r101 = false;
        goto L20
    }

    public final void z1(List<UrgentCmd> r100) {
        String r101 = mu8.d.a(r100);
        nu8.a.e("BootProtectorLandingAct", "executePreciseCleaning: " + r101);
        JsonElement r102 = new JsonParser().parse(r101);     // Catch: Exception -> L7
        if (r102.isJsonArray() == false) goto L9;
        JsonArray r103 = r102.getAsJsonArray();     // Catch: Exception -> L7
        IBootProtectorLauncher.a r104 = IBootProtectorLauncher.f317602a;     // Catch: Exception -> L7
        Intrinsics.checkNotNull(r103);     // Catch: Exception -> L7
        r104.getClass();     // Catch: Exception -> L7
        IBootProtectorLauncher.a.a(this, r103);     // Catch: Exception -> L7
    L9:
        LastException r105 = hu8.e.h();
        if (r105 == null) goto L13;
        String r106 = r105.getExceptionStackTrace();
        if (r106 == null) goto L13;
    L14:
        LastException r107 = hu8.e.h();
        if (r107 == null) goto L17;
        BaseExceptionInfo.Type r108 = r107.getCrashType();
    L18:
        int r109 = au8.b.f16318a;
        au8.b.a("bootprotector_execute_clean", com.larus.utils.f.c(new Pair[]{TuplesKt.to(BdpAppEventConstant.PARAMS_STRATEGY_NAME, "precise"), TuplesKt.to("white_list", hu8.e.d()), TuplesKt.to("crash_type", r108), TuplesKt.to("crash_stack", StringsKt.take(r106, 4000))}));
        return;
    L17:
        r108 = null;
    L13:
        r106 = "";
    L7:
        e = move-exception;
        nu8.a.b("BootProtectorLandingAct", "executePreciseCleaning error: " + e.getMessage());
        goto L9
    }
}
