package com.obric.assistant.privacy.activity;

import android.R;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.view.View;
import android.widget.FrameLayout;
import androidx.lifecycle.Lifecycle;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.common.apphost.AppHost;
import com.larus.common.mssdk.api.ISecPrivacyService;
import com.larus.common.mssdk.api.SecurityService;
import com.larus.common_ui.activity.FlowCommonAppCompatActivity;
import com.larus.home.api.main.HomeService;
import com.larus.home.api.main.HomeServiceV2;
import com.larus.luckydog.api.ILuckyDogService;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import com.obric.aiagent.assistant.idl.IAgentAppIntentIDL;
import com.obric.assistant.interaction.base.util.DeviceUtil;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.assistant.privacy.ObricPrivacyProvider;
import com.obric.assistant.privacy.impl.databinding.ObricActivityPrivacyAgreementBinding;
import com.obric.assistant.t1;
import com.obric.oui.sheet.v2.OSheet;
import com.obric.oui.status.OPageStatus;
import com.obric.update.api.v2.ObricUpdateSettingDelegate;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 )2\u00020\u0001:\u0001)B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0014J\u0012\u0010\u0013\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0014J\b\u0010\u0016\u001a\u00020\u0010H\u0014J\b\u0010\u0017\u001a\u00020\u0010H\u0014J\b\u0010\u0018\u001a\u00020\u0010H\u0002J\b\u0010\u0019\u001a\u00020\u0010H\u0002J\b\u0010\u001a\u001a\u00020\u0010H\u0002J\u0010\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u0012H\u0002J\b\u0010\u001d\u001a\u00020\u0010H\u0002J\b\u0010\u001e\u001a\u00020\u0010H\u0002J\b\u0010\u001f\u001a\u00020\u0010H\u0002J\b\u0010 \u001a\u00020\u0010H\u0002J\b\u0010!\u001a\u00020\u0010H\u0002J\b\u0010$\u001a\u00020\u0010H\u0003J\u0010\u0010%\u001a\u00020\u00102\u0006\u0010&\u001a\u00020\u0007H\u0002J\b\u0010'\u001a\u00020\rH\u0016J\b\u0010(\u001a\u00020\rH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/obric/assistant/privacy/activity/ObricPrivacyAgreeActivity;", "Lcom/larus/common_ui/activity/FlowCommonAppCompatActivity;", "<init>", "()V", "mainProcessPid", "", "luckydogSchema", "", "privacyNextIntent", "Landroid/content/Intent;", "binding", "Lcom/obric/assistant/privacy/impl/databinding/ObricActivityPrivacyAgreementBinding;", "isSetResult", "", "isKillPrivacyProcess", "attachBaseContext", "", "newBase", "Landroid/content/Context;", WidgetCostModule.TYPE_ON_CREATE, "savedInstanceState", "Landroid/os/Bundle;", "onResume", LiveCommonConstants.REASON_ON_DEDTROY, "onPrivacyAccepted", "launchNextIntent", "goMainActivity", "isMainProcessRunning", PerfLog.PARAM_KEY_CONTEXT_ID, "onPrivacyRefuse", "killMainProcess", "killSelfProcess", "killAllProcess", "adaptScreenOrientation", "privacySheet", "Lcom/obric/oui/privacy/OPrivacySheet;", "showPrivacySheet", "clickPrivacyLink", "linkUrl", "needAdaptStatusBarPadding", "needAdaptNavigationBarPadding", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricPrivacyAgreeActivity extends FlowCommonAppCompatActivity {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f391075n = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f391076g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f391077h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Intent f391078i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ObricActivityPrivacyAgreementBinding f391079j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f391080k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f391081l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public com.obric.oui.privacy.c f391082m;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.common_ui.activity.FlowCommonAppCompatActivity
    public final boolean H1() {
        return false;
    }

    @Override // com.larus.common_ui.activity.FlowCommonAppCompatActivity
    public final boolean K1() {
        return false;
    }

    public final void P1() {
        Intent r100 = new Intent();
        r100.setComponent(new ComponentName(this, HomeServiceV2.f344096a.a()));
        r100.setFlags(335544320);
        startActivity(r100);
        if (this.f391081l == false) goto L6;
        Process.killProcess(Process.myPid());
        return;
    }

    public final void Q1() {
        if (Build.VERSION.SDK_INT < 23) goto L7;
        com.obric.oui.privacy.c r100 = this.f391082m;
        if (r100 == null) goto L7;
        r100.b();
    L7:
        ISecPrivacyService.a r101 = ISecPrivacyService.f326368a;
        r101.getClass();
        ISecPrivacyService r102 = ISecPrivacyService.a.a();
        if (r102 == null) goto L10;
        r102.b(this);
    L10:
        HomeService.f344094a.Y(this, true);
        r101.getClass();
        ISecPrivacyService r103 = ISecPrivacyService.a.a();
        if (r103 == null) goto L13;
        r103.e();
    L13:
        Uri r104 = ObricPrivacyProvider.f391064a;
        ObricPrivacyProvider.a.a(this);
        IAgentAppIntentIDL r105 = com.obric.aiagent.assistant.idl.a.a(Reflection.getOrCreateKotlinClass(IAgentAppIntentIDL.class));
        if (r105 == null) goto L16;
        r105.notifyUserAgreePrivacy();
    L16:
        t0.d(new f(this), 300);
    }

    @Override // com.larus.common_ui.activity.FlowCommonAppCompatActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(ObricPrivacyAgreeActivity.class.getName()));
    L5:
        super.onDestroy();
        this.f391079j = null;
    }

    public ObricPrivacyAgreeActivity() {
        this.f391081l = true;
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0106 */
    @Override // com.larus.common_ui.activity.FlowCommonAppCompatActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r100 = FLogger.f375446a;
        r100.i("ActivityLancet", "finish ".concat(ObricPrivacyAgreeActivity.class.getName()));
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

    @Override // com.larus.common_ui.activity.FlowCommonAppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
        ISecPrivacyService.f326368a.getClass();
        ISecPrivacyService r100 = ISecPrivacyService.a.a();
        if (r100 == null) goto L5;
        boolean r101 = r100.h();
    L6:
        if (r101 == false) goto L9;
        Q1();
        return;
    L9:
        return;
    L5:
        r101 = false;
        goto L6
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStop() {
        super.onStop();
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

    public static final void O1(ObricPrivacyAgreeActivity r110) {
        r110.getClass();
        HomeService.f344094a.Y(r110, false);
        if (r110.f391080k == true) goto L5;
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new ObricPrivacyAgreeActivity$onPrivacyRefuse$1(r110, null), 3, null);
        r110.finishAndRemoveTask();
        return;
    L5:
        if (Build.VERSION.SDK_INT < 23) goto L14;
        com.obric.oui.privacy.c r100 = r110.f391082m;
        if (r100 == null) goto L14;
        OSheet r101 = r100.f402471c;     // Catch: Exception -> L17
        if (r101 == null) goto L14;
        r101.f402892s = null;     // Catch: Exception -> L17
        r101.setOnDismissListener(null);     // Catch: Exception -> L17
        if (r101.isShowing() == false) goto L14;
        OSheet.t(r101);     // Catch: Exception -> L17
    L14:
        FLogger.f375446a.i("ObricPrivacyActivity", "External request, return cancel result");
        r110.setResult(0);
        r110.overridePendingTransition(0, 0);
        r110.finishAndRemoveTask();
    }

    @Override // com.larus.common_ui.activity.FlowCommonAppCompatActivity, androidx.appcompat.app.AppCompatActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public final void attachBaseContext(Context r100) {
        super.attachBaseContext(r100);
        FLogger.f375446a.i("ObricPrivacyActivity", "attachBaseContext");
    }

    @Override // com.larus.common_ui.activity.FlowCommonAppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle r210) {
        if (z2.f365865a.enableGlobalActivityTheme() == false) goto L7;
        v19.f.a(getTheme());     // Catch: Throwable -> L10
    L7:
        if (v19.f.f(this) == false) goto L11;
        v19.f.c(getTheme());     // Catch: Throwable -> L10
    L11:
        super.onCreate(r210);
        FLogger r100 = FLogger.f375446a;
        r100.i("ObricPrivacyActivity", WidgetCostModule.TYPE_ON_CREATE);
        if (DeviceUtil.INSTANCE.isHorizontalFoldable() == true) goto L14;
    L16:
        boolean r101 = false;
    L17:
        HomeService r102 = HomeService.f344094a;
        if (r102.isPad() == true) goto L22;
        if (r101 == true) goto L22;
        int r103 = 1;
    L23:
        r100.i("ObricPrivacyActivity", "adaptScreenOrientation orientation: " + r103 + ", isUnfolded: " + r101);
        setRequestedOrientation(r103);
        overridePendingTransition(0, 0);
        View r104 = getLayoutInflater().inflate(com.larus.nova.R.layout.obric_activity_privacy_agreement, null, false);
        OPageStatus r105 = (OPageStatus) ViewBindings.findChildViewById(r104, com.larus.nova.R.id.obric_privacy_loading);
        if (r105 == null) goto L45;
        FrameLayout r106 = (FrameLayout) r104;
        this.f391079j = new ObricActivityPrivacyAgreementBinding(r106, r105);
        setContentView(r106);
        ObricActivityPrivacyAgreementBinding r107 = this.f391079j;
        if (r107 == null) goto L30;
        OPageStatus r108 = r107.f391143b;
        if (r108 == null) goto L30;
        r108.setType(1);
        r108.setLoadingResult(getString(com.larus.nova.R.string.obric_privacy_init));
        r108.b(true);
    L30:
        Uri r109 = getIntent().getData();
        if (r109 == null) goto L40;
        ILuckyDogService r110 = (ILuckyDogService) ServiceManager.get().getService(ILuckyDogService.class);
        if (r110 != null) goto L35;
    L37:
        boolean r111 = false;
    L38:
        if (r111 == false) goto L40;
        this.f391077h = r109.toString();
        goto L40
    L35:
        if (r110.d(r109) != true) goto L37;
        r111 = true;
    L40:
        this.f391078i = (Intent) getIntent().getParcelableExtra("privacy_next_intent");
        this.f391080k = getIntent().getBooleanExtra("is_set_result", false);
        this.f391081l = getIntent().getBooleanExtra("is_kill_privacy_process", true);
        r102.Q(this);
        r102.x(new JSONObject());
        if (Build.VERSION.SDK_INT < 23) goto L48;
        com.obric.oui.privacy.c r112 = new com.obric.oui.privacy.c(this, new com.obric.oui.privacy.h(AppHost.f326268a.getApplication().getPackageName(), getString(com.larus.nova.R.string.doubao_app_name), getString(com.larus.nova.R.string.obric_privacy_app_desc), CollectionsKt.listOf(new com.obric.oui.privacy.j[]{new com.obric.oui.privacy.j.b(getString(com.larus.nova.R.string.obric_enable_wifi), ObricUpdateSettingDelegate.f404037a.a(), new d()), new com.obric.oui.privacy.j.b(getString(com.larus.nova.R.string.obric_enable_auto_upload_image), t1.f393353a.g0(), new e(this)), new com.obric.oui.privacy.j.a(getString(com.larus.nova.R.string.obric_privacy_permission_title), CollectionsKt.listOf(new String[]{getString(com.larus.nova.R.string.obric_privacy_permission_audio), getString(com.larus.nova.R.string.obric_privacy_permission_camera), getString(com.larus.nova.R.string.obric_privacy_permission_media), getString(com.larus.nova.R.string.obric_privacy_permission_location), getString(com.larus.nova.R.string.obric_privacy_permission_calendar), getString(com.larus.nova.R.string.obric_privacy_permission_phone_contacts_sms), getString(com.larus.nova.R.string.obric_privacy_permission_app_list), getString(com.larus.nova.R.string.obric_privacy_permission_call_log), getString(com.larus.nova.R.string.obric_privacy_permission_simulated_click), getString(com.larus.nova.R.string.obric_privacy_permission_phone_operation), getString(com.larus.nova.R.string.obric_privacy_permission_screen_capture), getString(com.larus.nova.R.string.obric_privacy_permission_screen_content), getString(com.larus.nova.R.string.obric_privacy_permission_parse_screen_content), getString(com.larus.nova.R.string.obric_privacy_permission_background_screen_share), getString(com.larus.nova.R.string.obric_privacy_permission_accessibility_service), getString(com.larus.nova.R.string.obric_privacy_permission_physical_activity), getString(com.larus.nova.R.string.obric_privacy_permission_bluetooth), getString(com.larus.nova.R.string.obric_privacy_permission_notification), getString(com.larus.nova.R.string.obric_privacy_permission_manage_wifi), getString(com.larus.nova.R.string.obric_privacy_permission_manage_mobile_network)}))}), getString(com.larus.nova.R.string.obric_privacy_policy), CollectionsKt.listOf(new String[]{getString(com.larus.nova.R.string.obric_privacy_policy_link), getString(com.larus.nova.R.string.obric_privacy_doubao_assistant_special_term_link), getString(com.larus.nova.R.string.obric_privacy_doubao_term_link)}), getString(com.larus.nova.R.string.obric_allow), getString(com.larus.nova.R.string.obric_not_allow_and_quit), true, true, true));
        h r113 = new h(this);
        Intrinsics.checkNotNullParameter(r113, "listener");
        r112.f402473e = r113;
        r112.d();
        this.f391082m = r112;
        return;
    L48:
        return;
    L45:
        throw new NullPointerException("Missing required view with ID: ".concat(r104.getResources().getResourceName(com.larus.nova.R.id.obric_privacy_loading)));
    L22:
        r103 = 13;
        goto L23
    L14:
        if (getResources().getConfiguration().smallestScreenWidthDp < 600) goto L16;
        r101 = true;
        goto L17
    }

    public static final void N1(final ObricPrivacyAgreeActivity r100, final String r101) {
        r100.getClass();
        SecurityService r102 = (SecurityService) ServiceManager.get().getService(SecurityService.class);
        if (r102 == null) goto L6;
        r102.x(r100.getSupportFragmentManager(), new g(r101, r100));
        return;
    }
}
