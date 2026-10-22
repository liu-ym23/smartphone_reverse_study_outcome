package eu5;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.lifecycle.MutableLiveData;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes19.dex */
public final class a implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static a f474072c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicInteger f474073a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MutableLiveData<Boolean> f474074b;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity r100, Bundle r101) {
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

    public static a a() {
        a r100 = f474072c;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new IllegalStateException("AppVisibleHepler is not initialised - invoke at least once with parameterised init/get");
    }

    public a() {
        this.f474073a = new AtomicInteger(0);
        MutableLiveData<Boolean> r100 = new MutableLiveData();
        this.f474074b = r100;
        r100.postValue(Boolean.FALSE);
    }

    public static void b(Application r100) {
        if (f474072c != null) goto L6;
        a r101 = new a();
        f474072c = r101;
        r100.registerActivityLifecycleCallbacks(r101);
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity r100) {
        if (this.f474073a.incrementAndGet() != 1) goto L6;
        this.f474074b.setValue(Boolean.TRUE);
        tt5.a.b("AppVisibleHelper", "onActivityStarted(): ");
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity r100) {
        if (this.f474073a.decrementAndGet() != 0) goto L6;
        this.f474074b.setValue(Boolean.FALSE);
        tt5.a.b("AppVisibleHelper", "onActivityStopped");
        return;
    }
}
