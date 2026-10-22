package qb4;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes3.dex */
public final class r implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s f532381a;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity r100, Bundle r101) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity r100, Bundle r101) {
    }

    public r(s r100) {
        this.f532381a = r100;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity r100) {
        WeakReference<Activity> r101 = this.f532381a.f532385b;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.get() != r100) goto L18;
        s r102 = this.f532381a;
        Object r103 = r102.f532386c;
        monitor-enter(r103);
        r102.f532385b = null;     // Catch: Throwable -> L12
        r102.f532386c.notifyAll();     // Catch: Throwable -> L12
        monitor-exit(r103);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity r100) {
        WeakReference<Activity> r101 = this.f532381a.f532385b;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.get() != r100) goto L18;
        s r102 = this.f532381a;
        Object r103 = r102.f532386c;
        monitor-enter(r103);
        r102.f532385b = null;     // Catch: Throwable -> L12
        r102.f532386c.notifyAll();     // Catch: Throwable -> L12
        monitor-exit(r103);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity r100) {
        s r101 = this.f532381a;
        WeakReference<Activity> r102 = new WeakReference(r100);
        Object r103 = r101.f532386c;
        monitor-enter(r103);
        r101.f532385b = r102;     // Catch: Throwable -> L7
        r101.f532386c.notifyAll();     // Catch: Throwable -> L7
        monitor-exit(r103);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity r100) {
        cc4.g r101 = cc4.g.d();
        int r102 = r101.f23278a + 1;
        r101.f23278a = r102;
        if (r102 != 1) goto L5;
        r101.f23279b = false;
    L5:
        r101.h(r100, r101.f23280c);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity r100) {
        cc4.g r101 = cc4.g.d();
        int r102 = r101.f23278a - 1;
        r101.f23278a = r102;
        if (r102 != 0) goto L6;
        r101.f23279b = true;
    L6:
        if (r101.f23281d == false) goto L12;
        if (r100 == null) goto L9;
        String r103 = r100.getClass().getName();
    L10:
        rb4.d.b().a(new cc4.g.a(r103, 2));
        return;
    L9:
        r103 = "";
        goto L10
    }
}
