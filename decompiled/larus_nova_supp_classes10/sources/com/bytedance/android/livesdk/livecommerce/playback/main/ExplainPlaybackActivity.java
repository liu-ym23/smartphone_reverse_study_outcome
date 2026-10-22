package com.bytedance.android.livesdk.livecommerce.playback.main;

import android.R;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.adapter.api.j;
import com.bytedance.android.ec.monitor.duration.i;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.ies.uikit.base.AbsActivity;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/playback/main/ExplainPlaybackActivity;", "Lcom/bytedance/ies/uikit/base/AbsActivity;", "<init>", "()V", "a", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ExplainPlaybackActivity extends AbsActivity {
    public static final /* synthetic */ int k = 0;
    public ExplainPlaybackFragment j;

    public static final class a {
    }

    static {
    }

    /* JADX INFO: Removed unreachable split cross block B:51:0x0104 */
    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(ExplainPlaybackActivity.class.getName()));
        long r3 = SystemClock.uptimeMillis();
        Map r5 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r5);
        Long r6 = (Long) r5.get(this);     // Catch: Throwable -> L45
        if (r6 != null) goto L10;
    L13:
        r5.put(this, Long.valueOf(r3));     // Catch: Throwable -> L45
        monitor-exit(r5);     // Catch: Throwable -> L45
    L42:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
    L48:
        return;
    L16:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L19;
        r2.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L42
        goto L48
    L19:
        if (isFinishing() == true) goto L22;
        r2.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L42
        goto L48
    L22:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L25;
        r2.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L42
        goto L48
    L25:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L28;
        r2.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L42
        goto L48
    L28:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L31;
        r2.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L42
        goto L48
    L31:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L33;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L42
        goto L48
    L33:
        Intent r1 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L42
        if (r1 == null) goto L48;
        r1.addFlags(268435456);     // Catch: Throwable -> L42
        r1.addFlags(2097152);     // Catch: Throwable -> L42
        r2.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L42
        startActivity(r1);     // Catch: Throwable -> L39
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L42
        goto L48
    L10:
        if ((r3 - r6.longValue()) >= 800) goto L13;
        monitor-exit(r5);     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        throw th;
    }

    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(ExplainPlaybackActivity.class.getName()));
    L5:
        super.onDestroy();
    }

    public final void onBackPressed() {
        super/*androidx.activity.ComponentActivity*/.onBackPressed();
        ExplainPlaybackFragment r0 = this.j;
        if (r0 == null) goto L7;
        ExplainPlaybackViewModel r1 = r0.e;
        if (r1 == null) goto L7;
        r1.setClosePageByUser(true);
    L7:
        cj2.c r2 = cj2.a.a;
        HashMap r3 = new HashMap();
        r3.put("ecom_entrance_form", "replay_popup_card");
        cj2.a.a("livesdk_explain_replay_return_swipe", r3, null, null);
    }

    public final void onStart() {
        super.onStart();
        int r0 = ECSdk.a;
        IAdapterService r1 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r1 == null) goto L8;
        j r2 = r1.getLiveWindowService();
        if (r2 == null) goto L9;
        r2.stopShowNow();
        return;
    L9:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onStop() {
        super.onStop();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L14;
        View r0 = getWindow().getDecorView();     // Catch: Throwable -> L11
        if (com.larus.home.impl.utils.c.e == false) goto L9;
        FLogger.a.i("DecorViewLancet", "getDecorView");     // Catch: Throwable -> L11
        Thread r1 = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L11
        if (r1 == com.larus.home.impl.utils.c.a) goto L9;
        com.larus.home.impl.utils.c.a(r1, "getDecorView");     // Catch: Throwable -> L11
    L9:
        r0.getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L11
        return;
    L15:
        return;
    }

    public ExplainPlaybackActivity() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r6) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (v19.f.f(this) == false) goto L10;
        v19.f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        super.onCreate(r6);
        setContentView(2131560690);
        boolean r0 = true;
        findViewById(2131387825).setDisllowInterceptEnabled(true);
        String r7 = getIntent().getStringExtra("key_explain_play_back_schema");
        if (r7 == null) goto L34;
        ExplainPlaybackFragment.a r2 = ExplainPlaybackFragment.j;
        Bundle r3 = new Bundle();
        r3.putString("key_explain_play_back_schema", r7);
        Unit r8 = Unit.INSTANCE;
        r2.getClass();
        ExplainPlaybackFragment r9 = new ExplainPlaybackFragment();
        r9.setArguments(r3);
        i r1 = i.a;
        String r4 = r1.create("ec_perf_duration_b3390");
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        ExplainPlaybackFragment.i = r4;
        if (cj2.b.e == false) goto L15;
    L23:
        String r5 = r1.create("ec_perf_duration_replay");
        cj2.b.a = r5;
        com.bytedance.android.ec.monitor.duration.d r10 = r1.get(r5);
        if (r10 == null) goto L26;
        r10.a("initial");
    L26:
        com.bytedance.android.ec.monitor.duration.d r11 = r1.get(cj2.b.a);
        if (r11 == null) goto L29;
        r11.b("monitor_key", cj2.b.a);
    L29:
        cj2.b.f(BDLocationException.ERROR_TIMEOUT);
        cj2.b.b = SystemClock.elapsedRealtime();
        cj2.b.c = false;
        cj2.b.d = false;
        cj2.b.e = false;
        cj2.b.f = false;
        FragmentTransaction r12 = getSupportFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r12, r9, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, 2131370817) == true) goto L33;
        r12 = r12.replace(2131370817, r9);
    L33:
        r12.commitAllowingStateLoss();
        this.j = r9;
        goto L34
    L15:
        if (cj2.b.a.length() > 0) goto L18;
        r0 = false;
    L18:
        if (r0 == false) goto L23;
        cj2.b.c();
        com.bytedance.android.ec.monitor.duration.d r13 = r1.get(cj2.b.a);
        if (r13 == null) goto L22;
        r13.b("not_complete_load_reason", "other");
    L22:
        cj2.b.e(false);
    L34:
        int r14 = ECSdk.a;
        IAdapterService r15 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r15 == null) goto L42;
        j r16 = r15.getLiveWindowService();
        if (r16 == null) goto L43;
        r16.stopShowFloatInNextLifecycle();
        return;
    L43:
        return;
    }
}
