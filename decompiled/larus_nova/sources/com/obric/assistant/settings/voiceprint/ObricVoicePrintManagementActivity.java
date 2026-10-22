package com.obric.assistant.settings.voiceprint;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.crash.Npth;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.larus.nova.R;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.api.IKeyguardStateKt;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.obric.assistant.settings.ObricSettingBaseActivity;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 12\u00020\u0001:\u000201B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0014J\b\u0010\u001a\u001a\u00020\u0017H\u0014J\b\u0010\u001b\u001a\u00020\u0017H\u0014J\b\u0010\u001c\u001a\u00020\u0017H\u0014J\b\u0010\u001d\u001a\u00020\u0017H\u0014J\b\u0010\u001e\u001a\u00020\u0017H\u0002J\b\u0010\u001f\u001a\u00020\u0017H\u0002J\b\u0010 \u001a\u00020\u0017H\u0002J\u0010\u0010!\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020\u0005H\u0002J\b\u0010#\u001a\u00020\u0017H\u0002J\b\u0010$\u001a\u00020\u0017H\u0002J\b\u0010%\u001a\u00020\u0017H\u0002J\u0018\u0010&\u001a\u00020\u00172\u0006\u0010'\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u0005H\u0002J\b\u0010(\u001a\u00020\u0017H\u0002J\b\u0010)\u001a\u00020\u0017H\u0002J\b\u0010*\u001a\u00020\u0017H\u0002J\u0016\u0010+\u001a\u00020\u00172\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00170-H\u0002J\n\u0010.\u001a\u0004\u0018\u00010/H\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0094D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/obric/assistant/settings/voiceprint/ObricVoicePrintManagementActivity;", "Lcom/obric/assistant/settings/ObricSettingBaseActivity;", "<init>", "()V", "adaptSettingNavigationBarPadding", "", "getAdaptSettingNavigationBarPadding", "()Z", "authState", "Lcom/obric/assistant/settings/voiceprint/ObricVoicePrintManagementActivity$AuthState;", "pendingReAuthOnResume", "screenOffReceiver", "Landroid/content/BroadcastReceiver;", "requestAuthenticationJob", "Lkotlinx/coroutines/Job;", "waitDeviceUnlockJob", "currentAuthRequestId", "", "isStarted", "foregroundScope", "Lkotlinx/coroutines/CoroutineScope;", "hasLaunchedDeviceCredential", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", WidgetCostModule.TYPE_ON_START, "onStop", "onResume", LiveCommonConstants.REASON_ON_DEDTROY, "startAuthentication", "showManagementContent", "hideSensitiveContent", "clearSensitiveContent", "removeFragment", "registerScreenOffReceiver", "unregisterScreenOffReceiver", "finishForAuthenticationExit", "resetAuthenticationState", "requireReAuth", "waitForDeviceUnlockThenStartAuthentication", "cancelWaitDeviceUnlockJob", "finishSafely", "runOnMainThread", "block", "Lkotlin/Function0;", "fragmentContainer", "Landroid/view/View;", "AuthState", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricVoicePrintManagementActivity extends ObricSettingBaseActivity {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ int f392409q = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public AuthState f392410h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f392411i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ObricVoicePrintManagementActivity$registerScreenOffReceiver$receiver$1 f392412j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Job f392413k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Job f392414l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f392415m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f392416n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public CoroutineScope f392417o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f392418p;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/assistant/settings/voiceprint/ObricVoicePrintManagementActivity$AuthState;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "AUTHENTICATING", "PASSED", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum AuthState extends Enum<AuthState> {
        public static final AuthState AUTHENTICATING = null;
        public static final AuthState IDLE = null;
        public static final AuthState PASSED = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ AuthState[] f392419a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f392420b = null;

        public static EnumEntries<AuthState> getEntries() {
            return f392420b;
        }

        static {
            AuthState r100 = new AuthState("IDLE", 0);
            IDLE = r100;
            AuthState r101 = new AuthState("AUTHENTICATING", 1);
            AUTHENTICATING = r101;
            AuthState r102 = new AuthState("PASSED", 2);
            PASSED = r102;
            AuthState[] r103 = {r100, r101, r102};
            f392419a = r103;
            f392420b = EnumEntriesKt.enumEntries(r103);
        }

        public static AuthState[] values() {
            return (AuthState[]) f392419a.clone();
        }

        public static AuthState valueOf(String r100) {
            return (AuthState) r27.a.a(AuthState.class, r100);
        }

        public AuthState(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    static {
    }

    @Override // com.obric.assistant.settings.ObricSettingBaseActivity
    public final boolean O1() {
        return false;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStop() {
        this.f392416n = false;
        Job r100 = this.f392414l;
        if (r100 == null) goto L5;
        Job.DefaultImpls.cancel$default(r100, null, 1, null);
    L5:
        this.f392414l = null;
        CoroutineScope r101 = this.f392417o;
        if (r101 == null) goto L8;
        CoroutineScopeKt.cancel$default(r101, null, 1, null);
    L8:
        this.f392417o = null;
        super.onStop();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L20;
        View r102 = getWindow().getDecorView();     // Catch: Throwable -> L17
        if (com.larus.home.impl.utils.c.f346345e == false) goto L15;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");     // Catch: Throwable -> L17
        Thread r103 = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L17
        if (r103 == com.larus.home.impl.utils.c.f346341a) goto L15;
        com.larus.home.impl.utils.c.a(r103, "getDecorView");     // Catch: Throwable -> L17
    L15:
        r102.getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L17
        return;
    L21:
        return;
    }

    public final void X1() {
        AuthState r100 = this.f392410h;
        AuthState r101 = AuthState.AUTHENTICATING;
        if (r100 != r101) goto L5;
        return;
    L5:
        if (isFinishing() == false) goto L7;
        return;
    L7:
        if (isDestroyed() == false) goto L10;
        return;
    L10:
        if (this.f392416n == true) goto L14;
        FLogger.f375446a.i("[ObricVoicePrintManagementActivity]", "startAuthentication: skip, activity is not started (in background)");
        this.f392411i = true;
        return;
    L14:
        if (IKeyguardStateKt.getKeyguardState().isDeviceSecure() == true) goto L18;
        FLogger.f375446a.i("[ObricVoicePrintManagementActivity]", "startAuthentication: device is not secure, show content directly");
        this.f392410h = AuthState.PASSED;
        this.f392411i = false;
        W1();
        return;
    L18:
        if (IKeyguardStateKt.getKeyguardState().isDeviceLocked() == false) goto L21;
        FLogger.f375446a.i("[ObricVoicePrintManagementActivity]", "startAuthentication: device still locked, wait for unlock");
        U1(true, false);
        Y1();
        return;
    L21:
        long r102 = SystemClock.elapsedRealtimeNanos();
        this.f392415m = r102;
        this.f392410h = r101;
        S1(false);
        Job r103 = this.f392413k;
        if (r103 == null) goto L24;
        Job.DefaultImpls.cancel$default(r103, null, 1, null);
    L24:
        this.f392413k = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new ObricVoicePrintManagementActivity$startAuthentication$1(this, r102, null), 2, null);
    }

    public final void Y1() {
        Job r100 = this.f392414l;
        boolean r101 = false;
        if (r100 != null) goto L5;
    L7:
        if (r101 == false) goto L9;
        return;
    L9:
        CoroutineScope r102 = this.f392417o;
        if (this.f392416n == false) goto L15;
        if (r102 == null) goto L15;
        this.f392414l = BuildersKt.launch$default(r102, null, null, new ObricVoicePrintManagementActivity$waitForDeviceUnlockThenStartAuthentication$1(this, null), 3, null);
        return;
    L15:
        FLogger.f375446a.i("[ObricVoicePrintManagementActivity]", "waitForDeviceUnlockThenStartAuthentication: skip because activity is not started");
        return;
    L5:
        if (r100.isActive() != true) goto L7;
        r101 = true;
        goto L7
    }

    @Override // com.obric.assistant.settings.ObricSettingBaseActivity, com.larus.common_ui.activity.FlowCommonAppCompatActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(ObricVoicePrintManagementActivity.class.getName()));
    L5:
        Job r100 = this.f392413k;
        if (r100 == null) goto L8;
        Job.DefaultImpls.cancel$default(r100, null, 1, null);
    L8:
        Job r101 = this.f392414l;
        if (r101 == null) goto L11;
        Job.DefaultImpls.cancel$default(r101, null, 1, null);
    L11:
        this.f392414l = null;
        ObricVoicePrintManagementActivity$registerScreenOffReceiver$receiver$1 r102 = this.f392412j;
        if (r102 != null) goto L34;
    L30:
        super.onDestroy();
        return;
    L34:
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L24
        ReceiverRegisterLancet.loge(r102, false);     // Catch: Throwable -> L24
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L32;
        unregisterReceiver(r102);     // Catch: Throwable -> L24
    L22:
        Object r104 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L24
    L26:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L29;
        FLogger.f375446a.w("[ObricVoicePrintManagementActivity]", "unregisterScreenOffReceiver failed", r105);
    L29:
        this.f392412j = null;
        goto L30
    L32:
    L19:
        e = move-exception;
        Npth.addTag("unregisterReceiver", r102.toString());     // Catch: Throwable -> L24
        e.printStackTrace();     // Catch: Throwable -> L24
        goto L22
    L16:
        if (ReceiverRegisterAnrOptimizer.unregisterReceiverHasNonScreenFilter(r102, this) == false) goto L22;
        unregisterReceiver(r102);     // Catch: Exception -> L19 Throwable -> L24
    L24:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L26
    }

    public ObricVoicePrintManagementActivity() {
        this.f392410h = AuthState.IDLE;
    }

    public final void T1() {
        View r100 = findViewById(R.id.fragment_container);
        if (r100 == null) goto L6;
        r100.setVisibility(4);
        return;
    }

    public final void W1() {
        if (isFinishing() == false) goto L5;
        return;
    L5:
        if (isDestroyed() == true) goto L20;
        View r100 = findViewById(R.id.fragment_container);
        if (r100 == null) goto L11;
        r100.setVisibility(0);
    L11:
        if (getSupportFragmentManager().findFragmentByTag("obric_voice_print_management_fragment") != null) goto L19;
        ObricVoicePrintManagementMainFragment r101 = new ObricVoicePrintManagementMainFragment();
        r101.setArguments(getIntent().getExtras());
        FragmentTransaction r102 = getSupportFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r102, r101, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, "obric_voice_print_management_fragment", R.id.fragment_container) == true) goto L16;
        r102 = r102.replace(R.id.fragment_container, r101, "obric_voice_print_management_fragment");
    L16:
        r102.commitAllowingStateLoss();
        return;
    L19:
        return;
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0106 */
    @Override // com.obric.assistant.settings.ObricSettingBaseActivity, com.larus.common_ui.activity.FlowCommonAppCompatActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r100 = FLogger.f375446a;
        r100.i("ActivityLancet", "finish ".concat(ObricVoicePrintManagementActivity.class.getName()));
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
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.slide_out_right);     // Catch: Throwable -> L39
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
        if (IKeyguardStateKt.getKeyguardState().isDeviceSecure() == true) goto L6;
        this.f392410h = AuthState.PASSED;
        this.f392411i = false;
        W1();
        return;
    L6:
        AuthState r100 = this.f392410h;
        AuthState r101 = AuthState.AUTHENTICATING;
        if (r100 != r101) goto L13;
        if (this.f392418p == false) goto L13;
        FLogger.f375446a.i("[ObricVoicePrintManagementActivity]", "onResume: device credential UI already launched, wait for its callback");
        T1();
        return;
    L13:
        if (IKeyguardStateKt.getKeyguardState().isDeviceLocked() == false) goto L16;
        FLogger.f375446a.i("[ObricVoicePrintManagementActivity]", "onResume: device still locked, wait for device unlock before re-auth");
        U1(true, false);
        T1();
        Y1();
        return;
    L16:
        Job r102 = this.f392414l;
        if (r102 == null) goto L19;
        Job.DefaultImpls.cancel$default(r102, null, 1, null);
    L19:
        this.f392414l = null;
        AuthState r103 = this.f392410h;
        AuthState r104 = AuthState.PASSED;
        if (r103 == r104) goto L22;
        T1();
    L22:
        AuthState r105 = this.f392410h;
        if (r105 == r101) goto L29;
        if (r105 == r104) goto L26;
    L27:
        this.f392411i = false;
        X1();
        return;
    L26:
        if (this.f392411i == true) goto L27;
        return;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStart() {
        super.onStart();
        this.f392416n = true;
        if (this.f392417o != null) goto L6;
        this.f392417o = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        return;
    }

    public final void S1(boolean r100) {
        T1();
        if (r100 == true) goto L5;
        return;
    L5:
        Fragment r101 = getSupportFragmentManager().findFragmentByTag("obric_voice_print_management_fragment");
        if (r101 != null) goto L8;
        return;
    L8:
        getSupportFragmentManager().beginTransaction().remove(r101).commitAllowingStateLoss();
    }

    /* JADX WARN: Type inference failed for: r4v4, types: [com.obric.assistant.settings.voiceprint.ObricVoicePrintManagementActivity$registerScreenOffReceiver$receiver$1] */
    @Override // com.obric.assistant.settings.ObricSettingBaseActivity, com.larus.common_ui.activity.FlowCommonAppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle r100) {
        if (z2.f365865a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (v19.f.f(this) == false) goto L10;
        v19.f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        super.onCreate(r100);
        setContentView(R.layout.larus_activity_fragment_container);
        ObricSettingBaseActivity.N1(this);
        S1(true);
        if (this.f392412j != null) goto L30;
        ?? r101 = new ObricVoicePrintManagementActivity$registerScreenOffReceiver$receiver$1(this);
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L16
        IntentFilter r103 = new IntentFilter();     // Catch: Throwable -> L16
        r103.addAction("android.intent.action.SCREEN_OFF");     // Catch: Throwable -> L16
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L16
        Object r105 = Result.m9449constructorimpl(R1(this, r101, r103));     // Catch: Throwable -> L16
    L19:
        if (Result.m9456isSuccessimpl(r105) == false) goto L21;
        Intent r106 = (Intent) r105;
        this.f392412j = r101;
    L21:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r105);
        if (r107 == null) goto L29;
        FLogger.f375446a.w("[ObricVoicePrintManagementActivity]", "registerScreenOffReceiver failed", r107);
        return;
    L29:
        return;
    L16:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L19
    }

    public final void U1(boolean r100, boolean r101) {
        FLogger.f375446a.i("[ObricVoicePrintManagementActivity]", "resetAuthenticationState, " + r100 + ", " + r101);
        this.f392415m = 0;
        Job r102 = this.f392413k;
        if (r102 == null) goto L5;
        Job.DefaultImpls.cancel$default(r102, null, 1, null);
    L5:
        this.f392413k = null;
        this.f392418p = false;
        this.f392410h = AuthState.IDLE;
        this.f392411i = r100;
        if (r101 == false) goto L9;
        S1(true);
        return;
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static Intent R1(ObricVoicePrintManagementActivity r100, ObricVoicePrintManagementActivity$registerScreenOffReceiver$receiver$1 r110, IntentFilter r111) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L32;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L32:
    L26:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L30;
        throw e;
    L30:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r110, r111, "android.permission.WRITE_SETTINGS", null);
    L7:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L25;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r111) == false) goto L25;
        ReceiverRegisterAnrOptimizer.ResultWrapper r101 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r110, r111, 0, "android.permission.WRITE_SETTINGS", null, 4, r100);     // Catch: Exception -> L26
        int r102 = r101.result;     // Catch: Exception -> L26
        if (r102 == 1) goto L23;
        if (r102 == 2) goto L21;
        if (r102 == 3) goto L19;
        return r100.registerReceiver(r110, r111, "android.permission.WRITE_SETTINGS", null);
    L19:
        return r101.intent;
    L21:
        return new Intent();
    L23:
        return r100.registerReceiver(r110, r111, "android.permission.WRITE_SETTINGS", null);
    L25:
        return r100.registerReceiver(r110, r111, "android.permission.WRITE_SETTINGS", null);
    }
}
