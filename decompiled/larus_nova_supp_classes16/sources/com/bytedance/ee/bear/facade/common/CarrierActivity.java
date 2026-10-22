package com.bytedance.ee.bear.facade.common;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import com.bytedance.sysoptimizer.BadParcelableCrashOptimizer;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.Map;
import tt5.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class CarrierActivity extends BaseActivity {
    public BaseFragment c;
    public Class<?> d;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.facade.common.BaseActivity, com.bytedance.ee.bear.facade.common.BaseCommonActivity, com.bytedance.ee.bear.facade.common.LifeCycleActivity
    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
        if ((this instanceof ChatWindowActivity) == true) goto L56;
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
    L53:
        return;
    L16:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L19;
        r2.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L42
    L48:
        goto L53
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

    @Override // com.bytedance.ee.bear.facade.common.BaseActivity, com.bytedance.ee.bear.facade.common.BaseCommonActivity, com.bytedance.ee.bear.facade.common.LifeCycleActivity
    public void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(getClass().getName()));
    L5:
        super.onDestroy();
    }

    public CarrierActivity() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.facade.common.BaseActivity
    public void B1(Bundle r6) {
        setContentView(2131561085);
        Intent r0 = getIntent();
        if (r0 != null) goto L5;
    L19:
        Object r2 = null;
    L20:
        a.d("CarrierActivity", "parseIntent fail, invalid input. object: " + r2);
        finish();
    L22:
        if (this.d != null) goto L24;
        return;
    L24:
        if (this.c == null) goto L38;
        if (r6 != null) goto L32;
        FragmentTransaction r7 = getSupportFragmentManager().beginTransaction();
        BaseFragment r1 = this.c;
        String r3 = this.d.getName();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r7, r1, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, r3, 2131367794) == true) goto L30;
        r7 = r7.replace(2131367794, r1, r3);
    L30:
        r7.commitAllowingStateLoss();
        return;
    L32:
        if (getSupportFragmentManager().findFragmentByTag(this.d.getName()) != null) goto L40;
        finish();
        return;
    L40:
        return;
    L38:
        return;
    L5:
        if (r0.getExtras() == null) goto L19;
        r2 = r0.getExtras().get("class_fragment_content");
        Bundle r4 = r0.getBundleExtra("class_fragment_extras");
        Context r5 = BadParcelableCrashOptimizer.getContext();
        if (r4 == null) goto L11;
        if (r5 == null) goto L11;
        r4.setClassLoader(r5.getClassLoader());
    L11:
        if ((r2 instanceof Class) == false) goto L20;
        Class<?> r8 = (Class) r2;
        if (BaseFragment.class.isAssignableFrom(r8) == false) goto L20;
        this.d = r8;
        BaseFragment r9 = (BaseFragment) r8.newInstance();     // Catch: Exception -> L17
        this.c = r9;     // Catch: Exception -> L17
        r9.setArguments(r4);     // Catch: Exception -> L17
    L17:
        e = move-exception;
        a.d("CarrierActivity", "initialize content fragment error, msg: " + e.getMessage());
        goto L20
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseCommonActivity
    public final void onActivityResult(int r1, int r2, Intent r3) {
        super.onActivityResult(r1, r2, r3);
    }
}
