package tl7;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.bytedance.ug.sdk.luckydog.api.log.d;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: classes22.dex */
public final class b implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LinkedList<a> f546638a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicBoolean f546639b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f546640c = null;

    public b() {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity r100) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity r100) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity r100) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity r100, Bundle r101) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity r100) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity r100) {
    }

    static {
        f546640c = new b();
        f546638a = new LinkedList();
        f546639b = new AtomicBoolean(false);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity r100, Bundle r101) {
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L8
        Iterator<T> r103 = f546638a.iterator();     // Catch: Throwable -> L8
    L4:
        if (r103.hasNext() == false) goto L6;
        a r104 = (a) r103.next();     // Catch: Throwable -> L8
        d.a("LuckyRouteMonitor", "className = " + r100.getComponentName().getClassName());     // Catch: Throwable -> L8
        r104.onActivityCreate(r100);     // Catch: Throwable -> L8
        goto L4
    L6:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPreCreated(Activity r100, Bundle r101) {
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L8
        Iterator<T> r103 = f546638a.iterator();     // Catch: Throwable -> L8
    L4:
        if (r103.hasNext() == false) goto L6;
        a r104 = (a) r103.next();     // Catch: Throwable -> L8
        d.a("LuckyRouteMonitor", "className = " + r100.getComponentName().getClassName());     // Catch: Throwable -> L8
        r104.i(r100);     // Catch: Throwable -> L8
        goto L4
    L6:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }
}
