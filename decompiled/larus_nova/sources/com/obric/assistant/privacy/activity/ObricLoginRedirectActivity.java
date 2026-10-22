package com.obric.assistant.privacy.activity;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.common.mssdk.api.ISecPrivacyService;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.larus.utils.u;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u0000 !2\u00020\u0001:\u0001!B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000e\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014J\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0010H\u0014J\b\u0010\u0013\u001a\u00020\u000bH\u0002J\b\u0010\u0014\u001a\u00020\u000bH\u0002J\u0010\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u000bH\u0002J\b\u0010\u0019\u001a\u00020\u000bH\u0002J\b\u0010\u001a\u001a\u00020\u000bH\u0002J\u0010\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u001a\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u001d\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\u001e\u001a\u00020\u000bH\u0016J\b\u0010\u001f\u001a\u00020\u000bH\u0014J\b\u0010 \u001a\u00020\u000bH\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/obric/assistant/privacy/activity/ObricLoginRedirectActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "oneLoginLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "privacyLauncher", "doubaoLoginLauncher", "initProductSdkDeferred", "Lkotlinx/coroutines/CompletableDeferred;", "", "hasStartLogin", "", WidgetCostModule.TYPE_ON_CREATE, "savedInstanceState", "Landroid/os/Bundle;", "onSaveInstanceState", "outState", "initFeatureConfig", "handleLoginRequest", "handlePrivacyResult", "resultCode", "", "handlePrivacyRefused", "checkLoginStatus", "checkSystemLoginSupport", "handleOneLoginResult", "handleAccountLoginResult", "data", "onBackPressed", LiveCommonConstants.REASON_ON_DEDTROY, "requestPortraitSafely", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricLoginRedirectActivity extends AppCompatActivity {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f391069f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ActivityResultLauncher<Intent> f391070a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ActivityResultLauncher<Intent> f391071b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ActivityResultLauncher<Intent> f391072c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CompletableDeferred<Unit> f391073d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f391074e;

    public static final class a {
    }

    static {
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final void onBackPressed() {
        Intent r100 = new Intent();
        r100.putExtra("extra_error_code", "login_fail");
        setResult(0, r100);
        overridePendingTransition(0, 0);
        finish();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(ObricLoginRedirectActivity.class.getName()));
    L5:
        super.onDestroy();
        FLogger.f375446a.d("TAG_ObricLoginRedirectActivity", this + " onDestroy()");
    }

    public final void y1() {
        if (AccountService.f365697a.isLogin().booleanValue() == false) goto L5;
        FLogger.f375446a.i("TAG_ObricLoginRedirectActivity", this + " User is already logged in");
        setResult(-1);
        overridePendingTransition(0, 0);
        finish();
        return;
    L5:
        FLogger.f375446a.i("TAG_ObricLoginRedirectActivity", this + " User is not logged, checkSystemLoginSupport()");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new ObricLoginRedirectActivity$initFeatureConfig$1(this, null), 2, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getMain(), null, new ObricLoginRedirectActivity$checkSystemLoginSupport$1(this, null), 2, null);
    }

    public ObricLoginRedirectActivity() {
        this.f391073d = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0106 */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r100 = FLogger.f375446a;
        r100.i("ActivityLancet", "finish ".concat(ObricLoginRedirectActivity.class.getName()));
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

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle r100) {
        if (z2.f365865a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (v19.f.f(this) == false) goto L10;
        v19.f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        v19.f.a(getTheme());
        super.onCreate(r100);
        if (Build.VERSION.SDK_INT != 26) goto L13;
        FLogger.f375446a.i("TAG_ObricLoginRedirectActivity", "skip request portrait for translucent activity on Android O");
    L15:
        if ((getResources().getConfiguration().uiMode & 48) != 32) goto L17;
        boolean r101 = true;
    L18:
        u.f(this, !r101);
        FLogger r102 = FLogger.f375446a;
        r102.i("TAG_ObricLoginRedirectActivity", this + " onCreate");
        overridePendingTransition(0, 0);
        this.f391070a = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new com.obric.assistant.privacy.activity.a(this));
        this.f391071b = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new b(this));
        this.f391072c = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new c(this));
        if (r100 == null) goto L21;
        boolean r103 = r100.getBoolean("hasStartLogin", false);
    L22:
        this.f391074e = r103;
        if (r103 == true) goto L34;
        r102.i("TAG_ObricLoginRedirectActivity", this + " onCreate() hasStartLogin: false, call handleLoginRequest()");
        this.f391074e = true;
        ISecPrivacyService.f326368a.getClass();
        ISecPrivacyService r104 = ISecPrivacyService.a.a();
        if (r104 == null) goto L27;
        boolean r105 = r104.h();
    L28:
        if (r105 == true) goto L33;
        r102.i("TAG_ObricLoginRedirectActivity", this + " User has not agreed to privacy policy");
        Intent r106 = new Intent(this, ObricPrivacyAgreeActivity.class);
        r106.putExtra("is_set_result", true);
        r106.putExtra("is_kill_privacy_process", false);
        ActivityResultLauncher<Intent> r107 = this.f391071b;
        if (r107 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("privacyLauncher");
        r107 = null;
    L32:
        r107.launch(r106);
        return;
    L33:
        r102.i("TAG_ObricLoginRedirectActivity", this + " User has agreed to privacy policy, checkLoginStatus");
        y1();
        return;
    L27:
        r105 = false;
        goto L28
    L34:
        r102.i("TAG_ObricLoginRedirectActivity", this + " onCreate() hasStartLogin: true, do nothing");
        return;
    L21:
        r103 = false;
        goto L22
    L17:
        r101 = false;
        goto L18
    L13:
        setRequestedOrientation(1);
        goto L15
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onSaveInstanceState(Bundle r100) {
        Intrinsics.checkNotNullParameter(r100, "outState");
        super.onSaveInstanceState(r100);
        r100.putBoolean("hasStartLogin", this.f391074e);
        FLogger.f375446a.i("TAG_ObricLoginRedirectActivity", this + " onSaveInstanceState() hasStartLogin: " + this.f391074e);
    }
}
