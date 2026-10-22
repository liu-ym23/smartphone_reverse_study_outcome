package cu3;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import uu3.c;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements Application.ActivityLifecycleCallbacks, uu3.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<c> f465423a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WeakReference<Activity> f465424b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f465425c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f465426d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile boolean f465427e;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity r100) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity r100, Bundle r101) {
    }

    @Override // uu3.a
    public final String c() {
        WeakReference<Activity> r100 = this.f465424b;
        if (r100 != null) goto L5;
        return "";
    L5:
        Activity r101 = r100.get();
        if (r101 != null) goto L8;
        return "";
    L8:
        return r101.getClass().getCanonicalName();
    }

    public final Object[] d() {
        ArrayList<c> r100 = this.f465423a;
        monitor-enter(r100);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.f465423a.size() <= 0) goto L7;
        Object[] r101 = this.f465423a.toArray();     // Catch: Throwable -> L13
    L8:
        monitor-exit(r100);     // Catch: Throwable -> L13
        if (r101 == null) goto L11;
        return r101;
    L11:
        return new Object[0];
    L7:
        r101 = null;
        goto L8
    }

    public a() {
        this.f465423a = new ArrayList();
        Application r100 = xu3.a.getContext();
        r100.unregisterActivityLifecycleCallbacks(this);
        r100.registerActivityLifecycleCallbacks(this);
    }

    @Override // uu3.a
    public final boolean isForeground() {
        return this.f465427e;
    }

    @Override // uu3.a
    public final void a(c r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        ArrayList<c> r101 = this.f465423a;
        monitor-enter(r101);
        this.f465423a.add(r100);     // Catch: Throwable -> L9
        monitor-exit(r101);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // uu3.a
    public final void b(uu3.b r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        ArrayList<c> r101 = this.f465423a;
        monitor-enter(r101);
        this.f465423a.remove(r100);     // Catch: Throwable -> L9
        monitor-exit(r101);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity r100) {
        Object[] r101 = d();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        ((c) r101[r103]).onActivityPause(r100);
        r103 = r103 + 1;
        goto L3
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity r100) {
        this.f465424b = new WeakReference(r100);
        Object[] r101 = d();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        ((c) r101[r103]).onActivityResume(r100);
        r103 = r103 + 1;
        goto L3
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity r100) {
        Object[] r101 = d();
        int r102 = r101.length;
        int r103 = 0;
        int r104 = 0;
    L3:
        if (r104 >= r102) goto L6;
        ((c) r101[r104]).onActivityStarted(r100);
        r104 = r104 + 1;
        goto L3
    L6:
        if (this.f465425c == false) goto L9;
        this.f465425c = false;
        return;
    L9:
        int r105 = this.f465426d + 1;
        this.f465426d = r105;
        if (r105 != 1) goto L14;
        this.f465427e = true;
        Object[] r106 = d();
        int r107 = r106.length;
    L12:
        if (r103 >= r107) goto L17;
        ((c) r106[r103]).onFront(r100);
        r103 = r103 + 1;
        goto L12
    L17:
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity r100) {
        if (r100.isChangingConfigurations() == false) goto L6;
        this.f465425c = true;
        return;
    L6:
        int r101 = this.f465426d - 1;
        this.f465426d = r101;
        if (r101 != 0) goto L11;
        int r102 = 0;
        this.f465427e = false;
        Object[] r103 = d();
        int r104 = r103.length;
    L9:
        if (r102 >= r104) goto L13;
        ((c) r103[r102]).onBackground(r100);
        r102 = r102 + 1;
        goto L9
    L13:
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity r100, Bundle r101) {
        Object[] r102 = d();
        int r103 = r102.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L5;
        ((c) r102[r104]).onActivityCreated(r100);
        r104 = r104 + 1;
        goto L3
    }
}
