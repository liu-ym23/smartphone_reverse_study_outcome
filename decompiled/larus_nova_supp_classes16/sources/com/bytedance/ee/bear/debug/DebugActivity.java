package com.bytedance.ee.bear.debug;

import android.R;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.preference.PreferenceActivity;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.bytedance.ee.bear.contract.b0;
import com.bytedance.ee.bear.contract.z;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.List;
import java.util.Map;
import jx4.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class DebugActivity extends BasePreferenceActivity {
    public t a;

    @Override // android.preference.PreferenceActivity
    public final boolean isValidFragment(String r1) {
        return false;
    }

    @Override // android.preference.PreferenceActivity
    public final void onBuildHeaders(List<PreferenceActivity.Header> r1) {
    }

    @Override // android.preference.PreferenceActivity
    public final boolean onIsMultiPane() {
        return false;
    }

    @Override // com.bytedance.ee.bear.debug.BasePreferenceActivity
    public final void a() {
        b0 r0 = (b0) org.koin.java.a.a(b0.class);     // Catch: Exception -> L6
        if (((z) org.koin.java.a.a(z.class)).isDebugEnabled(this) == true) goto L11;
        finish();     // Catch: Exception -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        tt5.a.d("DebugActivity", "onCreate: " + e.getMessage());
        finish();
    }

    /* JADX INFO: Removed unreachable split cross block B:54:0x0112 */
    @Override // com.bytedance.ee.bear.debug.BasePreferenceActivity, android.app.Activity
    public final void finish() {
        super.finish();
        if ((this instanceof FragmentActivity) == true) goto L6;
        return;
    L6:
        if ((this instanceof ChatWindowActivity) == true) goto L59;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(getClass().getName()));
        long r3 = SystemClock.uptimeMillis();
        Map r5 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r5);
        Long r6 = (Long) r5.get(this);     // Catch: Throwable -> L48
        if (r6 != null) goto L13;
    L16:
        r5.put(this, Long.valueOf(r3));     // Catch: Throwable -> L48
        monitor-exit(r5);     // Catch: Throwable -> L48
    L45:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
    L51:
        return;
    L19:
        if (((FragmentActivity) this).getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L22;
        r2.i("ActivityLancet", "quit !resume, current state = " + ((FragmentActivity) this).getLifecycle().getCurrentState());     // Catch: Throwable -> L45
        goto L51
    L22:
        if (isFinishing() == true) goto L25;
        r2.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L45
        goto L51
    L25:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L28;
        r2.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L45
        goto L51
    L28:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L31;
        r2.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L45
        goto L51
    L31:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L34;
        r2.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L45
        goto L51
    L34:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L36;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L45
        goto L51
    L36:
        Intent r1 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L45
        if (r1 == null) goto L51;
        r1.addFlags(268435456);     // Catch: Throwable -> L45
        r1.addFlags(2097152);     // Catch: Throwable -> L45
        r2.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L45
        startActivity(r1);     // Catch: Throwable -> L42
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L45
        goto L51
    L13:
        if ((r3 - r6.longValue()) >= 800) goto L16;
        monitor-exit(r5);     // Catch: Throwable -> L48
    L48:
        th = move-exception;
        throw th;
    }

    @Override // android.preference.PreferenceActivity, android.app.Activity
    public final void onBackPressed() {
        t r0 = this.a;
        if (r0 == null) goto L5;
        r0.getClass();
    L5:
        super.onBackPressed();
    }

    @Override // android.preference.PreferenceActivity, android.app.ListActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        t r0 = this.a;
        if (r0 == null) goto L6;
        r0.e();
        return;
    }

    @Override // android.preference.PreferenceActivity, android.app.Activity
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

    public DebugActivity() {
    }

    @Override // android.app.Activity
    public final void onPostCreate(Bundle r2) {
        super.onPostCreate(r2);
        addPreferencesFromResource(2132082703);
        t r3 = new t(getPreferenceScreen(), this);
        this.a = r3;
        r3.f();
    }
}
