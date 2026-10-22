package com.volcengine.zeus.wrapper;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.os.SystemClock;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.home.impl.utils.c;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.volcengine.zeus.PluginContext;
import com.volcengine.zeus.Zeus;
import com.volcengine.zeus.util.FieldUtils;
import java.lang.reflect.Field;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class PluginFragmentActivityWrapper extends GenerateFragmentActivityWrapper {
    boolean hasInit;

    public void com_volcengine_zeus_wrapper_PluginFragmentActivityWrapper__finish$___twin___() {
        super.finish();
    }

    public void com_volcengine_zeus_wrapper_PluginFragmentActivityWrapper__onStop$___twin___() {
        super.onStop();
    }

    @Override // com.volcengine.zeus.wrapper.GenerateFragmentActivityWrapper, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void finish() {
        com_volcengine_zeus_wrapper_PluginFragmentActivityWrapper_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_finish(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_volcengine_zeus_wrapper_PluginFragmentActivityWrapper_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    @Override // com.volcengine.zeus.wrapper.GenerateFragmentActivityWrapper, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.lifecycle.LifecycleOwner
    public Lifecycle getLifecycle() {
        if (this.hasInit == true) goto L8;
        LifecycleRegistry r0 = new LifecycleRegistry(this);     // Catch: Throwable -> L10
        Field r1 = LifecycleRegistry.class.getDeclaredField("mEnforceMainThread");     // Catch: Throwable -> L9
        r1.setAccessible(true);     // Catch: Throwable -> L9
        r1.set(r0, Boolean.FALSE);     // Catch: Throwable -> L9
    L6:
        return r0;
    L8:
        return super.getLifecycle();
    }

    public Activity getOriginActivity() {
        return this.mOriginActivity;
    }

    public static View INVOKEVIRTUAL_com_volcengine_zeus_wrapper_PluginFragmentActivityWrapper_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r3) {
        View r4 = r3.getDecorView();
        if (c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == c.a) goto L7;
        c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public static void com_volcengine_zeus_wrapper_PluginFragmentActivityWrapper_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(PluginFragmentActivityWrapper r1) {
        r1.com_volcengine_zeus_wrapper_PluginFragmentActivityWrapper__onStop$___twin___();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L9;
        INVOKEVIRTUAL_com_volcengine_zeus_wrapper_PluginFragmentActivityWrapper_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r1.getWindow()).getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }

    public static void com_volcengine_zeus_wrapper_PluginFragmentActivityWrapper_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_finish(PluginFragmentActivityWrapper r11) {
        r11.com_volcengine_zeus_wrapper_PluginFragmentActivityWrapper__finish$___twin___();
        if ((r11 instanceof ChatWindowActivity) == false) goto L5;
        return;
    L5:
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(r11.getClass().getName()));
        long r3 = SystemClock.uptimeMillis();
        Map r5 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r5);
        Long r6 = (Long) r5.get(r11);     // Catch: Throwable -> L50
        if (r6 != null) goto L10;
    L13:
        r5.put(r11, Long.valueOf(r3));     // Catch: Throwable -> L50
        monitor-exit(r5);     // Catch: Throwable -> L50
    L47:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
        return;
    L16:
        if (r11.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L20;
        r2.i("ActivityLancet", "quit !resume, current state = " + r11.getLifecycle().getCurrentState());     // Catch: Throwable -> L47
        return;
    L20:
        if (r11.isFinishing() == true) goto L24;
        r2.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L47
        return;
    L24:
        if (ActivityStartBehavior.isInternalActivityConsumed(r11) == true) goto L28;
        r2.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L47
        return;
    L28:
        if (ActivityLancet.isOnlyActivityInTask(r11) == true) goto L32;
        r2.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L47
        return;
    L32:
        if (ActivityLancet.isExcludedActivity(r11) == false) goto L36;
        r2.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L47
        return;
    L36:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L38;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L47
        return;
    L38:
        Intent r1 = r11.getPackageManager().getLaunchIntentForPackage(r11.getPackageName());     // Catch: Throwable -> L47
        if (r1 != null) goto L41;
        return;
    L41:
        r1.addFlags(268435456);     // Catch: Throwable -> L47
        r1.addFlags(2097152);     // Catch: Throwable -> L47
        r2.i("ActivityLancet", "start launcher intent after backPressed, activity=" + r11);     // Catch: Throwable -> L47
        r11.startActivity(r1);     // Catch: Throwable -> L44
        r11.overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L44
    L58:
        return;
    L44:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L47
        return;
    L10:
        if ((r3 - r6.longValue()) >= 800) goto L13;
        monitor-exit(r5);     // Catch: Throwable -> L50
        return;
    L50:
        th = move-exception;
        throw th;
    }

    public PluginFragmentActivityWrapper(Activity r3, PluginContext r4) {
        this.hasInit = true;
        FragmentActivity r0 = (FragmentActivity) r3;
        this.mOriginActivity = r0;
        this.pluginContext = r4;
        if (r0.isDestroyed() == true) goto L17;
        Zeus.getAppApplication().registerActivityLifecycleCallbacks(new a(this));
    L17:
        FieldUtils.writeField(this, "mBase", r4);     // Catch: IllegalAccessException -> L7
    L15:
        FieldUtils.writeField(this, "mApplication", r3.getApplication());     // Catch: IllegalAccessException -> L11
    L13:
        mqc.a.a(this, r3);
        return;
    L11:
        e = move-exception;
        e.printStackTrace();
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L15
    }
}
