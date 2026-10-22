package com.bytedance.ee.bear.facade.common;

import android.R;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.MotionEvent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.view.WindowCompat;
import androidx.lifecycle.Lifecycle;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import sa5.e;
import sa5.m;
import ta5.a;
import ta5.b;
import ta5.c;
import ta5.d;
import ta5.f;
import ta5.g;
import ta5.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class BaseCommonActivity extends LifeCycleActivity implements m {
    public final String a;
    public ExtensionActivityImpl b;

    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0106 */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.facade.common.LifeCycleActivity
    public void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(getClass().getName()));
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
    L50:
        return;
    L16:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L19;
        r2.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L42
        goto L50
    L19:
        if (isFinishing() == true) goto L22;
        r2.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L42
        goto L50
    L22:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L25;
        r2.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L42
        goto L50
    L25:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L28;
        r2.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L42
        goto L50
    L28:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L31;
        r2.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L42
        goto L50
    L31:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L33;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L42
        goto L50
    L33:
        Intent r1 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L42
        if (r1 == null) goto L50;
        r1.addFlags(268435456);     // Catch: Throwable -> L42
        r1.addFlags(2097152);     // Catch: Throwable -> L42
        r2.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L42
        startActivity(r1);     // Catch: Throwable -> L39
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L42
        goto L50
    L10:
        if ((r3 - r6.longValue()) >= 800) goto L13;
        monitor-exit(r5);     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        throw th;
    }

    public void onBackPressed() {
        if (this.b.c() == false) goto L5;
        return;
    L5:
        super/*androidx.activity.ComponentActivity*/.onBackPressed();
    }

    @Override // com.bytedance.ee.bear.facade.common.LifeCycleActivity
    public void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(getClass().getName()));
    L5:
        super.onDestroy();
    }

    public BaseCommonActivity() {
        this.a = getClass().getSimpleName();
    }

    public static List<e> z1(AppCompatActivity r3) {
        return Arrays.asList(new e[]{new c(r3), new j(0), new b(r3), new a(r3), new f(r3), new d(), new g(r3)});
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void A1(Bundle r3) {
        if (idb.f.a().isCurrentEnable("ccm_mobile_ccm_at_doubao_reverse_in_feishu") == false) goto L13;
    L11:
        this.b = new ExtensionActivityImpl(this, z1(this));
        return;
    L13:
    L9:
        th = move-exception;
        tt5.a.f(this.a, th, false);
        goto L11
    L6:
        if (getWindow() == null) goto L11;
        getWindow().setStatusBarColor(0);     // Catch: Throwable -> L9
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);     // Catch: Throwable -> L9
        goto L11
    }

    @Override // sa5.o
    public final void Xi(e r2) {
        this.b.Xi(r2);
    }

    public final boolean dispatchKeyEvent(KeyEvent r2) {
        if (this.b.a(r2) == false) goto L7;
        return true;
    L7:
        return super/*androidx.appcompat.app.AppCompatActivity*/.dispatchKeyEvent(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean dispatchTouchEvent(MotionEvent r3) {
    L8:
        e = move-exception;
        tt5.a.f(this.a, e, false);
        return false;
    L3:
        if (this.b.b(r3) == false) goto L6;
        return true;
    L6:
        return super/*android.app.Activity*/.dispatchTouchEvent(r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onConfigurationChanged(Configuration r5) {
        ExtensionActivityImpl r0 = this.b;
        if (r0 == null) goto L5;
        r0.d(r5);
    L5:
        getResources().getConfiguration().orientation = r5.orientation;
        super/*com.larksuite.component.air.AirActivity*/.onConfigurationChanged(r5);
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type android.app.Activity");     // Catch: Throwable -> L17
        if (dc9.d.a() == true) goto L22;
        int r2 = getRequestedOrientation();     // Catch: Throwable -> L17
        Integer r6 = Integer.valueOf(r5.orientation);     // Catch: Throwable -> L17
        if (r6 != null) goto L12;
    L14:
        if (r2 != 3) goto L24;
        setRequestedOrientation(1);     // Catch: Throwable -> L17
        FLogger.a.i("PadLancet", "onConfigurationChanged, phone reset page:" + getClass().getSimpleName() + " portrait");     // Catch: Throwable -> L17
        return;
    L24:
        return;
    L12:
        if (r6.intValue() != r2) goto L14;
        return;
    L22:
        return;
    L17:
        th = move-exception;
        FLogger.a.e("PadLancet", "hook onConfigurationChanged error:" + th, th);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setTheme(int r2) {
        super/*androidx.appcompat.app.AppCompatActivity*/.setTheme(r2);
        getBaseContext().setTheme(r2);
    }

    @Override // sa5.o
    public final e vb(Class r2) {
        return this.b.vb(r2);
    }

    public void onActivityResult(int r3, int r4, Intent r5) {
        super/*androidx.fragment.app.FragmentActivity*/.onActivityResult(r3, r4, r5);
        Iterator r0 = ((ArrayList) this.b.a).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((e) r0.next()).i(r3, r4, r5);
        goto L4
    }
}
