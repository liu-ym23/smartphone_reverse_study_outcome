package com.bytedance.bdinstall.migrate;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.bytedance.mira.core.opt.res.NewMiraResourcesManager;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.home.impl.utils.c;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class MigrateDetectorActivity extends Activity {
    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public final void attachBaseContext(Context r100) {
        super.attachBaseContext(r100);
        NewMiraResourcesManager.getInstance().installActivity(this);
    }

    /* JADX INFO: Removed unreachable split cross block B:56:0x0117 */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.app.Activity
    public final void finish() {
        super.finish();
        if ((this instanceof FragmentActivity) == true) goto L6;
        return;
    L6:
        if ((this instanceof ChatWindowActivity) == true) goto L59;
        FLogger r100 = FLogger.f375446a;
        r100.i("ActivityLancet", "finish ".concat(MigrateDetectorActivity.class.getName()));
        long r101 = SystemClock.uptimeMillis();
        Map<Activity, Long> r102 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r102);
        Long r103 = r102.get(this);     // Catch: Throwable -> L48
        if (r103 != null) goto L13;
    L16:
        r102.put(this, Long.valueOf(r101));     // Catch: Throwable -> L48
        monitor-exit(r102);     // Catch: Throwable -> L48
    L45:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
    L53:
        return;
    L19:
        if (((FragmentActivity) this).getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L22;
        r100.i("ActivityLancet", "quit !resume, current state = " + ((FragmentActivity) this).getLifecycle().getCurrentState());     // Catch: Throwable -> L45
        goto L53
    L22:
        if (isFinishing() == true) goto L25;
        r100.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L45
        goto L53
    L25:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L28;
        r100.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L45
        goto L53
    L28:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L31;
        r100.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L45
        goto L53
    L31:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L34;
        r100.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L45
        goto L53
    L34:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L36;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L45
        goto L53
    L36:
        Intent r104 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L45
        if (r104 == null) goto L53;
        r104.addFlags(268435456);     // Catch: Throwable -> L45
        r104.addFlags(2097152);     // Catch: Throwable -> L45
        r100.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L45
        startActivity(r104);     // Catch: Throwable -> L42
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L45
        goto L53
    L13:
        if ((r101 - r103.longValue()) >= 800) goto L16;
        monitor-exit(r102);     // Catch: Throwable -> L48
    L48:
        th = move-exception;
        throw th;
    }

    @Override // android.app.Activity
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

    public MigrateDetectorActivity() {
    }
}
