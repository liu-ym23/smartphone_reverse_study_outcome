package com.bytedance.android.shopping.feed.activity;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.shopping.feed.utils.f;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.home.impl.utils.c;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.LinkedList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/shopping/feed/activity/LynxTransparentProxyActivity;", "Landroidx/fragment/app/FragmentActivity;", "<init>", "()V", "a", "b", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LynxTransparentProxyActivity extends FragmentActivity {
    public static final LinkedList<Pair<Context, b>> c = null;
    public static final boolean d = false;
    public static boolean e;
    public Context a;
    public final LynxTransparentProxyActivity$fragmentLifeCallBack$1 b;

    public static final class a {
    }

    public interface b {
        void onActivityCreated();
    }

    static {
        c = new LinkedList();
        d = true;
    }

    /* JADX INFO: Removed unreachable split cross block B:51:0x0104 */
    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(LynxTransparentProxyActivity.class.getName()));
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

    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.android.shopping.feed.activity.LynxTransparentProxyActivity$fragmentLifeCallBack$1] */
    public LynxTransparentProxyActivity() {
        new Handler();
        this.b = new LynxTransparentProxyActivity$fragmentLifeCallBack$1(this);
    }

    public final void onPause() {
        super.onPause();
        f r0 = f.b;
        r0.isPlaying();
        if (e == false) goto L5;
        return;
    L5:
        if (d == false) goto L9;
        r0.g();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onStop() {
        super.onStop();
        if (isFinishing() == true) goto L6;
        f.b.e(true, this.a);
    L6:
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L17;
        View r0 = getWindow().getDecorView();     // Catch: Throwable -> L14
        if (c.e == false) goto L12;
        FLogger.a.i("DecorViewLancet", "getDecorView");     // Catch: Throwable -> L14
        Thread r1 = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L14
        if (r1 == c.a) goto L12;
        c.a(r1, "getDecorView");     // Catch: Throwable -> L14
    L12:
        r0.getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L14
        return;
    L18:
        return;
    }

    public final void onResume() {
        super.onResume();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r3) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (v19.f.f(this) == false) goto L10;
        v19.f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        super.onCreate(r3);
        eh.b.c(this);
        e = false;
        if (r3 != null) goto L18;
        Pair<Context, b> r4 = c.poll();
        this.a = (Context) r4.getFirst();
        ((b) r4.getSecond()).onActivityCreated();
        getSupportFragmentManager().registerFragmentLifecycleCallbacks(this.b, false);
        if (d == false) goto L19;
        f r5 = f.b;
        r5.c();
        r5.h();
        return;
    L19:
        return;
    }
}
