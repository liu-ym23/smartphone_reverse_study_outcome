package com.bytedance.android.shopping.buynow.container;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.shopping.buynow.data.model.BuyNowOrderSchema;
import com.bytedance.android.shopping.buynow.tracker.BuyNowLog;
import com.bytedance.android.shopping.buynow.viewmodel.BuyNowViewModel;
import com.bytedance.ies.uikit.base.AbsActivity;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/shopping/buynow/container/BuyNowFullscreenActivity;", "Lcom/bytedance/ies/uikit/base/AbsActivity;", "Lcom/bytedance/android/shopping/buynow/container/o;", "<init>", "()V", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BuyNowFullscreenActivity extends AbsActivity implements o {
    public static final /* synthetic */ int k = 0;
    public BuyNowFragment j;

    public static final class a {
        public static void a(Context r2, String r3, Uri r4, BuyNowOrderSchema r5, String r6) {
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r3, "sessionId");
            BuyNowLog.a("BuyNowFullscreenActivity", "launch fullscreen");
            Intent r0 = new Intent(r2, BuyNowFullscreenActivity.class);
            r0.putExtra("PrefetchSessionId", r3);
            r0.putExtra("Schema", r4);
            r0.putExtra("OrderSchema", r5);
            r0.putExtra("source_btm_token", r6);
            Unit r7 = Unit.INSTANCE;
            r2.startActivity(r0);
        }
    }

    static {
    }

    @Override // com.bytedance.android.shopping.buynow.container.o
    public final Window Ou() {
        return null;
    }

    @Override // com.bytedance.android.shopping.buynow.container.o
    public final void close() {
        BuyNowFragment r0 = this.j;
        if (r0 == null) goto L7;
        BuyNowViewModel r1 = r0.W90();
        if (r1 == null) goto L7;
        com.bytedance.android.shopping.buynow.tracker.a r2 = r1.getTracker();
    L8:
        com.bytedance.android.shopping.buynow.monitor.error.a.f(r2, "runtime_error", "BuyNowFullscreenActivity-close", new AnonymousClass1(this));
        return;
    L7:
        r2 = null;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
        super.finish();
        overridePendingTransition(0, 2130772248);
        if ((this instanceof ChatWindowActivity) == true) goto L56;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(BuyNowFullscreenActivity.class.getName()));
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

    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(BuyNowFullscreenActivity.class.getName()));
    L5:
        BuyNowFragment r0 = this.j;
        if (r0 == null) goto L10;
        BuyNowViewModel r1 = r0.W90();
        if (r1 == null) goto L10;
        com.bytedance.android.shopping.buynow.tracker.a r2 = r1.getTracker();
    L11:
        com.bytedance.android.shopping.buynow.monitor.error.a.f(r2, "runtime_error", "BuyNowFullscreenActivity-onDestroy", new C02511(this));
        super.onDestroy();
        return;
    L10:
        r2 = null;
        goto L11
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.shopping.buynow.container.o
    public final View G9() {
        Window r0 = getWindow();
        if (r0 != null) goto L7;
        return null;
    L7:
        return z1(r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.shopping.buynow.container.o
    public final Window TR() {
        return getWindow();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onStop() {
        super.onStop();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L9;
        z1(getWindow()).getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.shopping.buynow.container.o
    public final View s7() {
        Window r0 = getWindow();
        if (r0 != null) goto L7;
        return null;
    L7:
        return z1(r0);
    }

    public final void y1() {
        super.y1();
        Function0<Unit> r0 = new BuyNowFullscreenActivity$setStatusBarColor$1(this);
        Intrinsics.checkNotNullParameter("setStatusBarColor", "tag");
        Intrinsics.checkNotNullParameter(r0, "task");
        long r2 = System.currentTimeMillis();
        r0.invoke();
        Lazy r1 = BuyNowLog.a;
        BuyNowLog.a("setStatusBarColor", "tag: setStatusBarColor duration: " + (System.currentTimeMillis() - r2));
    }

    public BuyNowFullscreenActivity() {
    }

    public static View z1(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(final Bundle r4) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (v19.f.f(this) == false) goto L10;
        v19.f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        BuyNowFragment r0 = this.j;
        if (r0 == null) goto L15;
        BuyNowViewModel r1 = r0.W90();
        if (r1 == null) goto L15;
        com.bytedance.android.shopping.buynow.tracker.a r2 = r1.getTracker();
    L16:
        com.bytedance.android.shopping.buynow.monitor.error.a.f(r2, "runtime_error", "BuyNowFullscreenActivity-onCreate", new C02501(this, r4));
        return;
    L15:
        r2 = null;
        goto L16
    }

    public final void onSaveInstanceState(Bundle r2) {
        Intrinsics.checkNotNullParameter(r2, "outState");
        super.onSaveInstanceState(r2);
        BuyNowLog.a("BuyNowFullscreenActivity", "onSaveInstanceState");
    }

    public static final /* synthetic */ void A1(BuyNowFullscreenActivity r0, Bundle r1) {
        super.onCreate(r1);
    }

    public final boolean onKeyDown(int r2, KeyEvent r3) {
        if (r2 != 4) goto L16;
        if (r3 == null) goto L16;
        if (r3.getAction() != 0) goto L16;
        BuyNowFragment r0 = this.j;
        if (r0 == null) goto L10;
        Boolean r1 = Boolean.valueOf(r0.Z90());
    L12:
        if (com.bytedance.android.shopping.extensions.k.i(r1) == false) goto L16;
        return true;
    L10:
        r1 = null;
    L16:
        return super/*androidx.appcompat.app.AppCompatActivity*/.onKeyDown(r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onSaveInstanceState(Bundle r2, PersistableBundle r3) {
        Intrinsics.checkNotNullParameter(r2, "outState");
        Intrinsics.checkNotNullParameter(r3, "outPersistentState");
        super/*android.app.Activity*/.onSaveInstanceState(r2, r3);
        BuyNowLog.a("BuyNowFullscreenActivity", "onSaveInstanceState");
    }
}
