package jm9;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.bytedance.frameworks.baselib.network.http.cronet.TTAppStateManager;
import com.larus.network.quota.AppStartState;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class d implements Application.ActivityLifecycleCallbacks, hhc.b {
    public static final d a = null;
    public static volatile boolean b;
    public static volatile int c;
    public static volatile boolean d;
    public static volatile boolean e;
    public static volatile boolean f;
    public static volatile AppStartState g;
    public static final CopyOnWriteArraySet<Function1<AppStartState, Unit>> h = null;

    public d() {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "outState");
    }

    static {
        a = new d();
        g = AppStartState.NormalStart;
        h = new CopyOnWriteArraySet();
    }

    @Override // hhc.b
    public final int a() {
        return g.getValue();
    }

    public static void b(AppStartState r3) {
        g = r3;
        Iterator<Function1<AppStartState, Unit>> r0 = h.iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        Function1<AppStartState, Unit> r1 = r0.next();
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L8
        r1.invoke(r3);     // Catch: Throwable -> L8
        Object r4 = Result.m49constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Result.m52exceptionOrNullimpl(r4);
    L8:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r4 = Result.m49constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        if (c > 0) goto L6;
        e = false;
        f = true;
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity r4) {
        Intrinsics.checkNotNullParameter(r4, "activity");
        if (c <= 0) goto L5;
        boolean r5 = true;
    L6:
        c++;
        if (r5 == false) goto L9;
        return;
    L9:
        if (d == true) goto L12;
        FLogger.a.i("AppStartManager", "onActivityStarted: ColdStart");
        AppStartState r6 = null;
    L17:
        d = true;
        if (r6 == null) goto L22;
        b(r6);
        return;
    L22:
        return;
    L12:
        if (e == true) goto L14;
    L16:
        TTAppStateManager.setAppStartUpState(TTAppStateManager.AppStartState.HotStart);
        FLogger.a.i("AppStartManager", "onActivityStarted: HotStart");
        r6 = AppStartState.HotStart;
        goto L17
    L14:
        if (f == false) goto L16;
        f = false;
        TTAppStateManager.setAppStartUpState(TTAppStateManager.AppStartState.WarmStart);
        FLogger.a.i("AppStartManager", "onActivityStarted: WarmStart");
        r6 = AppStartState.WarmStart;
        goto L17
    L5:
        r5 = false;
        goto L6
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        c--;
        if (c > 0) goto L6;
        c = 0;
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity r1, Bundle r2) {
        Intrinsics.checkNotNullParameter(r1, "activity");
        e = true;
    }
}
