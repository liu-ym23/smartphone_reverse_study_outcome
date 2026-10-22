package com.bytedance.ee.bear.facade.common;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import com.bytedance.ee.bear.facade.common.extension.ActivityTitleBarReporter;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import ib5.d;
import java.util.Iterator;
import java.util.Map;
import sa5.t;
import tt5.a;
import v19.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class BaseActivity extends BaseCommonActivity {
    public void B1(Bundle r1) {
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0106 */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.facade.common.BaseCommonActivity, com.bytedance.ee.bear.facade.common.LifeCycleActivity
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

    @Override // com.bytedance.ee.bear.facade.common.BaseCommonActivity, com.bytedance.ee.bear.facade.common.LifeCycleActivity
    public void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L20;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(getClass().getName()));
    L20:
        super.onDestroy();     // Catch: IllegalStateException -> L7
        return;
    L7:
        e = move-exception;
        Iterator r1 = getSupportFragmentManager().getFragments().iterator();     // Catch: Exception -> L15
    L10:
        if (r1.hasNext() == false) goto L17;
        Fragment r2 = (Fragment) r1.next();     // Catch: Exception -> L15
        if (r2.getLifecycle().getCurrentState() != Lifecycle.State.INITIALIZED) goto L10;
        a.e(getClass().getSimpleName(), "no event down from INITIALIZED fragment :" + r2, e, true);     // Catch: Exception -> L15
    L17:
        throw e;
    L15:
        e = move-exception;
        a.e(getClass().getSimpleName(), "try catch ", e, false);
        goto L17
    }

    public BaseActivity() {
    }

    public final void attachBaseContext(Context r2) {
        dw4.a.InterfaceC0214a r0 = dw4.a.a;
        if (r0 == null) goto L5;
        r2 = ((d) r0).a(r2);
    L5:
        super/*androidx.appcompat.app.AppCompatActivity*/.attachBaseContext(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.facade.common.LifeCycleActivity
    public final void onCreate(Bundle r3) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (f.f(this) == false) goto L11;
        f.c(getTheme());     // Catch: Throwable -> L9
    L11:
        if (km4.a.a == true) goto L16;
        if (r3 == null) goto L16;
        Bundle r0 = r3.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key");
        if (r0 == null) goto L16;
        r0.remove("android:support:fragments");
    L16:
        A1(r3);
        Xi(new ActivityTitleBarReporter(this));
        super.onCreate(r3);
        if (km4.a.a == false) goto L19;
        B1(r3);
        t.a();
        return;
    L19:
        a.c("Doc sdk hasn't initialized! please call SdkInitChecker.checkAndInit() first!");
        finish();
    }
}
