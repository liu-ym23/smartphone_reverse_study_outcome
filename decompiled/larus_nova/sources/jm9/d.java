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

/* JADX INFO: loaded from: classes.dex */
public final class d implements Application.ActivityLifecycleCallbacks, hhc.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f499704a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f499705b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile int f499706c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile boolean f499707d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile boolean f499708e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile boolean f499709f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile AppStartState f499710g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final CopyOnWriteArraySet<Function1<AppStartState, Unit>> f499711h = null;

    public d() {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "outState");
    }

    static {
        f499704a = new d();
        f499710g = AppStartState.NormalStart;
        f499711h = new CopyOnWriteArraySet();
    }

    @Override // hhc.b
    public final int a() {
        return f499710g.getValue();
    }

    public static void b(AppStartState r100) {
        f499710g = r100;
        Iterator<Function1<AppStartState, Unit>> r101 = f499711h.iterator();
    L4:
        if (r101.hasNext() == false) goto L11;
        Function1<AppStartState, Unit> r102 = r101.next();
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L8
        r102.invoke(r100);     // Catch: Throwable -> L8
        Object r104 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Result.m9452exceptionOrNullimpl(r104);
    L8:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        if (f499706c > 0) goto L6;
        f499708e = false;
        f499709f = true;
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        if (f499706c <= 0) goto L5;
        boolean r101 = true;
    L6:
        f499706c++;
        if (r101 == false) goto L9;
        return;
    L9:
        if (f499707d == true) goto L12;
        FLogger.f375446a.i("AppStartManager", "onActivityStarted: ColdStart");
        AppStartState r102 = null;
    L17:
        f499707d = true;
        if (r102 == null) goto L22;
        b(r102);
        return;
    L22:
        return;
    L12:
        if (f499708e == true) goto L14;
    L16:
        TTAppStateManager.setAppStartUpState(TTAppStateManager.AppStartState.HotStart);
        FLogger.f375446a.i("AppStartManager", "onActivityStarted: HotStart");
        r102 = AppStartState.HotStart;
        goto L17
    L14:
        if (f499709f == false) goto L16;
        f499709f = false;
        TTAppStateManager.setAppStartUpState(TTAppStateManager.AppStartState.WarmStart);
        FLogger.f375446a.i("AppStartManager", "onActivityStarted: WarmStart");
        r102 = AppStartState.WarmStart;
        goto L17
    L5:
        r101 = false;
        goto L6
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        f499706c--;
        if (f499706c > 0) goto L6;
        f499706c = 0;
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        f499708e = true;
    }
}
