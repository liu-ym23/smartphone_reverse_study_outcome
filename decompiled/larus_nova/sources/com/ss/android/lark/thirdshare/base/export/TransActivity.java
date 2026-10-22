package com.ss.android.lark.thirdshare.base.export;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.home.impl.utils.c;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import f06.b;
import f06.d;
import g06.a;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import v19.f;

/* JADX INFO: loaded from: classes38.dex */
public class TransActivity extends AppCompatActivity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<TransActivity, TransActivityDelegate> f441214a = null;

    public static abstract class TransActivityDelegate implements Serializable {
        public TransActivityDelegate() {
        }

        public boolean dispatchTouchEvent(TransActivity r100, MotionEvent r101) {
            return false;
        }

        public void onActivityResult(TransActivity r100, int r101, int r102, Intent r103) {
        }

        public void onCreateBefore(TransActivity r100, Bundle r101) {
        }

        public void onCreated(TransActivity r100, Bundle r101) {
        }

        public void onDestroy(TransActivity r100) {
        }

        public void onPaused(TransActivity r100) {
        }

        public void onRequestPermissionsResult(TransActivity r100, int r101, String[] r102, int[] r103) {
        }

        public void onResumed(TransActivity r100) {
        }

        public void onSaveInstanceState(TransActivity r100, Bundle r101) {
        }

        public void onStarted(TransActivity r100) {
        }

        public void onStopped(TransActivity r100) {
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onPause() {
        overridePendingTransition(0, 0);
        super.onPause();
        TransActivityDelegate r100 = (TransActivityDelegate) ((HashMap) f441214a).get(this);
        if (r100 != null) goto L10;
        return;
    L10:
        r100.onPaused(this);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        finish();
        Log.e("ThirdShare", e);
    }

    static {
        f441214a = new HashMap();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(getClass().getName()));
    L5:
        super.onDestroy();
        HashMap r100 = (HashMap) f441214a;
        TransActivityDelegate r101 = (TransActivityDelegate) r100.get(this);
        if (r101 == null) goto L16;
        r100.remove(this);
        r101.onDestroy(this);     // Catch: Exception -> L11
        return;
    L11:
        e = move-exception;
        Log.e("ThirdShare", e);
        return;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L56;
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

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
        TransActivityDelegate r100 = (TransActivityDelegate) ((HashMap) f441214a).get(this);
        if (r100 != null) goto L10;
        return;
    L10:
        r100.onResumed(this);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        finish();
        Log.e("ThirdShare", e);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStart() {
        super.onStart();
        TransActivityDelegate r100 = (TransActivityDelegate) ((HashMap) f441214a).get(this);
        if (r100 != null) goto L10;
        return;
    L10:
        r100.onStarted(this);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        finish();
        Log.e("ThirdShare", e);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStop() {
        super.onStop();
        TransActivityDelegate r100 = (TransActivityDelegate) ((HashMap) f441214a).get(this);
        if (r100 == null) goto L10;
        r100.onStopped(this);     // Catch: Exception -> L7
    L7:
        e = move-exception;
        finish();
        Log.e("ThirdShare", e);
    L10:
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L23;
        View r101 = getWindow().getDecorView();     // Catch: Throwable -> L18
        if (c.f346345e == false) goto L16;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");     // Catch: Throwable -> L18
        Thread r102 = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L18
        if (r102 == c.f346341a) goto L16;
        c.a(r102, "getDecorView");     // Catch: Throwable -> L18
    L16:
        r101.getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L18
        return;
    L24:
        return;
    }

    public TransActivity() {
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        TransActivityDelegate r101 = (TransActivityDelegate) ((HashMap) f441214a).get(this);
        if (r101 != null) goto L7;
        return super.dispatchTouchEvent(r100);
    L7:
        if (r101.dispatchTouchEvent(this, r100) == false) goto L11;
        return true;
    L11:
        return super.dispatchTouchEvent(r100);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle r100) {
        if (z2.f365865a.enableGlobalActivityTheme() == false) goto L6;
        f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (f.f(this) == false) goto L10;
        f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        overridePendingTransition(0, 0);
        Serializable r101 = getIntent().getSerializableExtra("extra_delegate");
        if ((r101 instanceof TransActivityDelegate) == true) goto L13;
        super.onCreate(r100);
        finish();
        return;
    L13:
        TransActivityDelegate r102 = (TransActivityDelegate) r101;
        ((HashMap) f441214a).put(this, r102);
        r102.onCreateBefore(this, r100);
        super.onCreate(r100);
        r102.onCreated(this, r100);     // Catch: Exception -> L16
        return;
    L16:
        e = move-exception;
        finish();
        Log.e("ThirdShare", e);
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onSaveInstanceState(Bundle r100) {
        super.onSaveInstanceState(r100);
        TransActivityDelegate r101 = (TransActivityDelegate) ((HashMap) f441214a).get(this);
        if (r101 != null) goto L10;
        return;
    L10:
        r101.onSaveInstanceState(this, r100);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        finish();
        Log.e("ThirdShare", e);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public final void onActivityResult(int r100, int r101, Intent r102) {
        super.onActivityResult(r100, r101, r102);
        TransActivityDelegate r103 = (TransActivityDelegate) ((HashMap) f441214a).get(this);
        if (r103 != null) goto L10;
        return;
    L10:
        r103.onActivityResult(this, r100, r101, r102);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        finish();
        Log.e("ThirdShare", e);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public final void onRequestPermissionsResult(int r210, String[] r211, int[] r212) {
        ArrayList r110 = new ArrayList();
        Object[] r111 = {Integer.valueOf(r210), r211, r212};
        b r112 = new b();
        a r100 = ApiHookConfig.f245611b.get(102611);
        if (r100 == null) goto L5;
        f06.a[] r101 = r100.f479473i;
    L6:
        f06.a[] r102 = r101;
        int r103 = r102.length;
        int r104 = 0;
    L8:
        if (r104 >= r103) goto L15;
        f06.a r105 = r102[r104];
        int r113 = r104;
        int r114 = r103;
        f06.a[] r213 = r102;
        d r106 = r105.preInvoke(102611, "androidx/appcompat/app/AppCompatActivity", "onRequestPermissionsResult", this, r111, "void", r112);     // Catch: Exception -> L29
        if (r106.f474982a == true) goto L17;
        r110.add(r105);     // Catch: Exception -> L29
    L17:
        if (r106.f474982a == true) goto L20;
        super.onRequestPermissionsResult(r210, r211, r212);
    L20:
        TransActivityDelegate r107 = (TransActivityDelegate) ((HashMap) f441214a).get(this);
        if (r107 != null) goto L30;
        return;
    L30:
        r107.onRequestPermissionsResult(this, r210, r211, r212);     // Catch: Exception -> L26
        return;
    L26:
        e = move-exception;
        finish();
        Log.e("ThirdShare", e);
        return;
    L14:
        r104 = r113 + 1;
        r103 = r114;
        r102 = r213;
        goto L8
    L15:
        r106 = new d(false, null);
        goto L17
    L5:
        r101 = ApiHookConfig.f245613d;
        goto L6
    }
}
