package com.bytedance.ies.uikit.base;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import androidx.lifecycle.Lifecycle;
import com.bytedance.common.utility.ICustomToast;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import v19.f;

/* JADX INFO: loaded from: classes19.dex */
public class SSActivity extends AbsActivity implements ICustomToast {
    @Override // android.app.Activity
    public final void overridePendingTransition(int r100, int r101) {
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0109 */
    @Override // com.bytedance.ies.uikit.base.AbsActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void finish() {
        super.finish();
        a.a(this);
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

    @Override // com.bytedance.ies.uikit.base.AbsActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(getClass().getName()));
    L5:
        super.onDestroy();
    }

    public final k56.b z1() {
        k56.b r100 = new k56.b(this);
        r100.f501849c = 17;
        r100.f501869w = false;
        r100.f501860n = false;
        Object r101 = r100.f501851e;
        if (r101 != null) goto L5;
        r101 = r100.f501848b;
    L5:
        AnimatorSet r102 = new AnimatorSet();
        r102.playTogether(new Animator[]{ObjectAnimator.ofFloat(r101, "alpha", new float[]{0.0f, 1.0f})});
        r102.setDuration(300);
        Object r103 = r100.f501851e;
        if (r103 != null) goto L8;
        r103 = r100.f501848b;
    L8:
        AnimatorSet r104 = new AnimatorSet();
        r104.playTogether(new Animator[]{ObjectAnimator.ofFloat(r103, "alpha", new float[]{1.0f, 0.0f})});
        r104.setDuration(300);
        r100.f501853g = r102;
        r100.f501854h = r104;
        return r100;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final void onBackPressed() {
        super.onBackPressed();     // Catch: IllegalStateException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
        finish();
    }

    @Override // com.bytedance.ies.uikit.base.AbsActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onPause() {
        Iterator r100 = ((ConcurrentLinkedQueue) k56.c.b().f501872a).iterator();
    L4:
        if (r100.hasNext() == false) goto L10;
        k56.b r101 = (k56.b) r100.next();
        if (r101 == null) goto L4;
        if (r101.getContext() != this) goto L4;
        r101.f501857k = true;
        goto L4
    L10:
        super.onPause();
    }

    @Override // com.bytedance.ies.uikit.base.AbsActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
        k56.c.b().d(this);
    }

    @Override // com.bytedance.ies.uikit.base.AbsActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStop() {
        super.onStop();
        k56.c r100 = k56.c.b();
        r100.removeMessages(1929);
        int r101 = ((ConcurrentLinkedQueue) r100.f501872a).size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L15;
        k56.b r103 = (k56.b) ((ConcurrentLinkedQueue) r100.f501872a).poll();
        if (r103 == null) goto L13;
        if (r103.getContext() != this) goto L12;
        r100.removeMessages(1110, r103);
        r103.b();
        r103.f501851e.clearAnimation();
        r103.f501847a = null;
        k56.c r104 = k56.c.b();
        ((ConcurrentLinkedQueue) r104.f501872a).remove(r103);
    L10:
        if (((ConcurrentLinkedQueue) r104.f501872a).contains(r103) == false) goto L13;
        ((ConcurrentLinkedQueue) r104.f501872a).remove(r103);
        goto L10
    L12:
        ((ConcurrentLinkedQueue) r100.f501872a).add(r103);
    L13:
        r102 = r102 + 1;
        goto L3
    L15:
        if (((ConcurrentLinkedQueue) r100.f501872a).isEmpty() == true) goto L17;
        r100.sendEmptyMessage(1929);
    L17:
        r100.f501873b = false;
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L33;
        View r105 = getWindow().getDecorView();     // Catch: Throwable -> L26
        if (com.larus.home.impl.utils.c.f346345e == false) goto L24;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");     // Catch: Throwable -> L26
        Thread r106 = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L26
        if (r106 == com.larus.home.impl.utils.c.f346341a) goto L24;
        com.larus.home.impl.utils.c.a(r106, "getDecorView");     // Catch: Throwable -> L26
    L24:
        r105.getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L26
        return;
    L34:
        return;
    }

    public SSActivity() {
    }

    @Override // com.bytedance.ies.uikit.base.AbsActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle r100) {
        if (z2.f365865a.enableGlobalActivityTheme() == false) goto L6;
        f.a(getTheme());     // Catch: Throwable -> L10
    L6:
        if (f.f(this) == false) goto L8;
        f.c(getTheme());     // Catch: Throwable -> L10
    L8:
        super.onCreate(r100);
        a.b(this, 0);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final void onWindowFocusChanged(boolean r100) {
        super.onWindowFocusChanged(r100);
    }

    @Override // com.bytedance.common.utility.ICustomToast
    public final void showCustomToast(String r100) {
        if ((!this.f248944b) == true) goto L5;
        return;
    L5:
        k56.b r101 = z1();
        r101.f501851e = r101.c();
        r101.e(r100, -1);
        k56.c.b().a(r101);
    }

    public final void A1(int r100, int r101) {
        super.overridePendingTransition(r100, r101);
    }

    @Override // com.bytedance.common.utility.ICustomToast
    public final void showCustomLongToast(int r100, String r101) {
        if ((!this.f248944b) == true) goto L5;
        return;
    L5:
        k56.b r102 = z1();
        r102.f501851e = r102.c();
        r102.e(r101, r100);
        k56.c.b().a(r102);
    }

    @Override // com.bytedance.ies.uikit.base.AbsActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public final void onActivityResult(int r100, int r101, Intent r102) {
        k56.c.b().d(this);
        super.onActivityResult(r100, r101, r102);
    }

    @Override // com.bytedance.common.utility.ICustomToast
    public final void showCustomToast(int r100, String r101, int r102, int r103) {
        if ((!this.f248944b) == true) goto L5;
        return;
    L5:
        k56.b r104 = z1();
        r104.f501855i = r102;
        r104.f501849c = r103;
        r104.f501851e = r104.c();
        r104.e(r101, r100);
        k56.c.b().a(r104);
    }
}
