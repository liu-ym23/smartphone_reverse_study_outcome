package com.bytedance.ee.bear.search.space;

import android.R;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import com.bytedance.ee.bear.facade.common.BaseActivity;
import com.bytedance.ee.bear.search.picker.SpaceSearchPickerFragment;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.home.impl.utils.c;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import tt5.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class SpaceSearchActivity extends BaseActivity {
    public SpaceSearchPickerFragment c;

    /* JADX INFO: Removed unreachable split cross block B:53:0x0106 */
    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
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

    public final void onBackPressed() {
        SpaceSearchPickerFragment r0 = this.c;
        if (r0 == null) goto L7;
        FragmentActivity r1 = r0.getActivity();
        if (r1 == null) goto L9;
        r1.finish();
        return;
    L9:
        return;
    L7:
        super/*com.bytedance.ee.bear.facade.common.BaseCommonActivity*/.onBackPressed();
    }

    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(getClass().getName()));
    L5:
        super.onDestroy();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onStop() {
        super/*androidx.appcompat.app.AppCompatActivity*/.onStop();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L14;
        View r0 = getWindow().getDecorView();     // Catch: Throwable -> L11
        if (c.e == false) goto L9;
        FLogger.a.i("DecorViewLancet", "getDecorView");     // Catch: Throwable -> L11
        Thread r1 = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L11
        if (r1 == c.a) goto L9;
        c.a(r1, "getDecorView");     // Catch: Throwable -> L11
    L9:
        r0.getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L11
        return;
    L15:
        return;
    }

    public SpaceSearchActivity() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void B1(Bundle r5) {
        setContentView(2131564441);
        SpaceSearchPickerFragment r6 = getSupportFragmentManager().findFragmentById(2131385360);
        this.c = r6;
        if (r6 != null) goto L10;
        int r7 = SpaceSearchPickerFragment.j;
        Bundle r8 = getIntent().getExtras();
        Intrinsics.checkNotNullParameter(this, "context");
        SpaceSearchPickerFragment r9 = Fragment.instantiate(this, SpaceSearchPickerFragment.class.getName(), r8);
        Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type com.bytedance.ee.bear.search.picker.SpaceSearchPickerFragment");
        this.c = r9;
        FragmentTransaction r10 = getSupportFragmentManager().beginTransaction();
        SpaceSearchPickerFragment r1 = this.c;
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r10, r1, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, null, 2131385360) == true) goto L8;
        r10 = r10.add(2131385360, r1);
    L8:
        r10.commitAllowingStateLoss();
        return;
    }

    public final void onActivityResult(int r3, int r4, Intent r5) {
        super/*com.bytedance.ee.bear.facade.common.BaseCommonActivity*/.onActivityResult(r3, r4, r5);
        a.b("SpaceSearchActivity", "onActivityResult(), requestCode = " + r3);
        if (r5 == null) goto L17;
        SpaceSearchPickerFragment r0 = this.c;
        if (r0 != null) goto L8;
        return;
    L8:
        if (r3 != 5) goto L10;
    L15:
        r0.onActivityResult(r3, r4, r5);
        return;
    L10:
        if (r3 == 3) goto L15;
        if (r3 == 4097) goto L15;
        if (r3 == 4098) goto L15;
        return;
    }
}
