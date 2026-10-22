package com.larus.home.impl.privacy;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.view.View;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.common.mssdk.api.ISecPrivacyService;
import com.larus.common.mssdk.api.SecurityService;
import com.larus.common_ui.dialog.SpanableDialog;
import com.larus.common_ui.dialog.i1;
import com.larus.common_ui.dialog.j1;
import com.larus.home.impl.AppInitReporter;
import com.larus.home.impl.utils.c;
import com.larus.luckydog.api.ILuckyDogService;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import com.larus.utils.u;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import ec9.b0;
import ec9.n;
import ec9.o;
import ec9.p;
import ec9.v;
import ec9.w;
import ec9.x;
import ec9.y;
import ec9.z;
import java.util.Arrays;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONObject;
import v19.f;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014J\u0012\u0010\u000f\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014J\b\u0010\u0012\u001a\u00020\fH\u0002J\b\u0010\u0013\u001a\u00020\fH\u0002J\b\u0010\u0014\u001a\u00020\fH\u0002J\b\u0010\u0015\u001a\u00020\fH\u0002J\b\u0010\u0016\u001a\u00020\fH\u0002J\b\u0010\u0017\u001a\u00020\fH\u0002J\u0010\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u000eH\u0002J\b\u0010\u001a\u001a\u00020\fH\u0002J\b\u0010\u001b\u001a\u00020\fH\u0002J\b\u0010\u001c\u001a\u00020\fH\u0002J\b\u0010\u001d\u001a\u00020\fH\u0002J\b\u0010\u001e\u001a\u00020\fH\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/larus/home/impl/privacy/PrivacyAgreeActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "TAG", "", "needKillProcess", "", "mainProcessPid", "", "luckydogSchema", "attachBaseContext", "", "newBase", "Landroid/content/Context;", WidgetCostModule.TYPE_ON_CREATE, "savedInstanceState", "Landroid/os/Bundle;", "showPreinstallPrivacyDialog", "showBasicModeDialog", "showPrivacyDialog", "clickTermInternal", "clickPrivacyInternal", "onPrivacyAccepted", "isMainProcessRunning", PerfLog.PARAM_KEY_CONTEXT_ID, "onPrivacyRefuse", "killMainProcess", "killSelfProcess", "killAllProcess", LiveCommonConstants.REASON_ON_DEDTROY, "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PrivacyAgreeActivity extends AppCompatActivity {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f346003e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f346004a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f346005b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f346006c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f346007d;

    public final void B1() {
        ISecPrivacyService.a r100 = ISecPrivacyService.f326368a;
        r100.getClass();
        ISecPrivacyService r101 = ISecPrivacyService.a.a();
        if (r101 == null) goto L5;
        r101.b(this);
    L5:
        b0.f472129a.getClass();
        b0.c(this, true);
        r100.getClass();
        ISecPrivacyService r102 = ISecPrivacyService.a.a();
        if (r102 == null) goto L8;
        r102.e();
    L8:
        t0.d(new p(this), 300);
    }

    /* JADX INFO: Removed unreachable split cross block B:51:0x0104 */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r100 = FLogger.f375446a;
        r100.i("ActivityLancet", "finish ".concat(PrivacyAgreeActivity.class.getName()));
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
    L48:
        return;
    L16:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L19;
        r100.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L42
        goto L48
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

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(PrivacyAgreeActivity.class.getName()));
    L5:
        super.onDestroy();
        if (this.f346005b == false) goto L9;
        Process.killProcess(Process.myPid());
        return;
    }

    public PrivacyAgreeActivity() {
        this.f346004a = "PrivacyAgreeActivity";
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStop() {
        super.onStop();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L14;
        View r100 = getWindow().getDecorView();     // Catch: Throwable -> L11
        if (c.f346345e == false) goto L9;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");     // Catch: Throwable -> L11
        Thread r101 = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L11
        if (r101 == c.f346341a) goto L9;
        c.a(r101, "getDecorView");     // Catch: Throwable -> L11
    L9:
        r100.getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L11
        return;
    L15:
        return;
    }

    public static final void A1(final PrivacyAgreeActivity r100) {
        r100.getClass();
        SecurityService r101 = (SecurityService) ServiceManager.get().getService(SecurityService.class);
        if (r101 == null) goto L6;
        r101.x(r100.getSupportFragmentManager(), new n(r100));
        return;
    }

    public static final void z1(final PrivacyAgreeActivity r100) {
        r100.getClass();
        SecurityService r101 = (SecurityService) ServiceManager.get().getService(SecurityService.class);
        if (r101 == null) goto L6;
        r101.x(r100.getSupportFragmentManager(), new o(r100));
        return;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public final void attachBaseContext(Context r100) {
        super.attachBaseContext(r100);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle r110) {
        if (z2.f365865a.enableGlobalActivityTheme() == false) goto L7;
        f.a(getTheme());     // Catch: Throwable -> L10
    L7:
        if (f.f(this) == false) goto L11;
        f.c(getTheme());     // Catch: Throwable -> L10
    L11:
        f.a(getTheme());
        super.onCreate(r110);
        overridePendingTransition(0, 0);
        ActionBar r100 = getSupportActionBar();
        if (r100 == null) goto L15;
        r100.hide();
    L15:
        if ((getResources().getConfiguration().uiMode & 48) != 32) goto L17;
        boolean r101 = true;
    L18:
        u.e(this, true, r101);
        u.d(this);
        setContentView(com.larus.nova.R.layout.larus_activity_privacy_agreement);
        SecurityService r102 = (SecurityService) ServiceManager.get().getService(SecurityService.class);
        if (r102 != null) goto L21;
    L23:
        boolean r103 = false;
    L25:
        if (r103 == false) goto L27;
        String r104 = getString(com.larus.nova.R.string.larus_preinstall_privacy_title);
        Intrinsics.checkNotNullParameter(r104, "title");
        String r105 = getString(com.larus.nova.R.string.larus_preinstall_privacy_msg);
        Intrinsics.checkNotNullParameter(r105, "message");
        j1 r111 = new j1(15, Integer.valueOf(com.larus.nova.R.color.larus_neutral_50), null, null, 28);
        Intrinsics.checkNotNullParameter(r111, "textStyleConfig");
        String r106 = getString(com.larus.nova.R.string.larus_preinstall_privacy_privacy_term);
        Intrinsics.checkNotNullParameter(r106, "message");
        int r107 = (int) getResources().getDimension(v19.c.b(com.larus.nova.R.attr.larus_dp_290, null, com.larus.nova.R.dimen.larus_dp_290));
        ec9.u r108 = new ec9.u(this);
        String r112 = getString(com.larus.nova.R.string.larus_preinstall_privacy_agree);
        Intrinsics.checkNotNullParameter(r108, "listener");
        i1 r113 = new i1(17, Integer.valueOf(com.larus.nova.R.color.larus_neutral_100), 4);
        Intrinsics.checkNotNullParameter(r113, "textStyleConfig");
        v r114 = new v(this);
        Intrinsics.checkNotNullParameter(r114, "listener");
        w r115 = new w(this);
        String r109 = getString(com.larus.nova.R.string.larus_preinstall_privacy_disagree);
        Intrinsics.checkNotNullParameter(r115, "listener");
        i1 r116 = new i1(17, Integer.valueOf(com.larus.nova.R.color.larus_neutral_70), 4);
        Intrinsics.checkNotNullParameter(r116, "textStyleConfig");
        SpanableDialog r117 = new SpanableDialog();
        r117.f327277e = r104;
        r117.f327279g = r105;
        r117.f327280h = r106;
        r117.f327281i = r107;
        r117.f327282j = r112;
        r117.f327283k = r108;
        r117.f327284l = r109;
        r117.f327285m = r115;
        r117.f327286n = r114;
        r117.f327289q = r116;
        r117.f327288p = r113;
        r117.f327287o = r111;
        y1(r117, getSupportFragmentManager());
        PrivacyAgreeActivity r118 = this;
    L28:
        b0.f472129a.getClass();
        b0.d(this);
        AppInitReporter r119 = AppInitReporter.f344102a;
        AppInitReporter.b(new JSONObject());
        Uri r120 = getIntent().getData();
        if (r120 == null) goto L41;
        ILuckyDogService r121 = (ILuckyDogService) ServiceManager.get().getService(ILuckyDogService.class);
        if (r121 == null) goto L35;
        boolean r122 = true;
        if (r121.d(r120) != true) goto L35;
    L36:
        if (r122 == false) goto L42;
        r118.f346007d = r120.toString();
        return;
    L42:
        return;
    L35:
        r122 = false;
        goto L36
    L41:
        return;
    L27:
        r118 = this;
        String r123 = r118.getString(com.larus.nova.R.string.larus_privacy_alert_message_new_cn_android);
        Intrinsics.checkNotNullParameter(r123, "message");
        StringCompanionObject r124 = StringCompanionObject.INSTANCE;
        String r125 = String.format(r118.getString(com.larus.nova.R.string.larus_privacy_alert_title_android), Arrays.copyOf(new Object[]{r118.getString(com.larus.nova.R.string.app_name_replace)}, 1));
        Intrinsics.checkNotNullParameter(r125, "title");
        x r126 = new x(r118);
        String r127 = r118.getString(com.larus.nova.R.string.larus_log_in_tos_confirmation_agree);
        Intrinsics.checkNotNullParameter(r126, "listener");
        y r128 = new y(r118);
        Intrinsics.checkNotNullParameter(r128, "listener");
        z r129 = new z(r118);
        String r130 = r118.getString(com.larus.nova.R.string.larus_log_in_tos_confirmation_disagree);
        Intrinsics.checkNotNullParameter(r129, "listener");
        SpanableDialog r131 = new SpanableDialog();
        r131.f327277e = r125;
        r131.f327279g = r123;
        r131.f327280h = null;
        r131.f327281i = -1;
        r131.f327282j = r127;
        r131.f327283k = r126;
        r131.f327284l = r130;
        r131.f327285m = r129;
        r131.f327286n = r128;
        r131.f327289q = null;
        r131.f327288p = null;
        r131.f327287o = null;
        y1(r131, getSupportFragmentManager());
        goto L28
    L21:
        if (r102.D() != true) goto L23;
        r103 = true;
        goto L25
    L17:
        r101 = false;
        goto L18
    }

    public static void y1(SpanableDialog r100, FragmentManager r101) {
        LandscapeRestrictionOperation r102 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r100, null, r102);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r101, r100, r102) == false) goto L9;
        return;
    L9:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        r100.show(r101, null);
    }
}
