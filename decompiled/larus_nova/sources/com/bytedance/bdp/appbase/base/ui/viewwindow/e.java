package com.bytedance.bdp.appbase.base.ui.viewwindow;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes11.dex */
public final class e implements Application.ActivityLifecycleCallbacks {
    public e() {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity r100, Bundle r101) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity r100) {
        f.f200650b.put(r100, 6);
        List<WeakReference<g>> r101 = f.f200649a;
        monitor-enter(r101);
        Iterator<WeakReference<g>> r102 = r101.iterator();     // Catch: Throwable -> L20
    L6:
        if (r102.hasNext() == false) goto L18;
        WeakReference<g> r103 = r102.next();     // Catch: Throwable -> L20
        if (r103 == null) goto L9;
        g r104 = r103.get();     // Catch: Throwable -> L20
        if (r104 == null) goto L12;
        if (r104.getActivity() != r100) goto L6;
        throw null;     // Catch: Throwable -> L20
    L12:
        r102.remove();     // Catch: Throwable -> L20
        goto L6
    L9:
        r102.remove();     // Catch: Throwable -> L20
        goto L6
    L18:
        monitor-exit(r101);     // Catch: Throwable -> L20
        return;
    L20:
        th = move-exception;
        throw th;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity r100) {
        f.f200650b.put(r100, 4);
        List<WeakReference<g>> r101 = f.f200649a;
        monitor-enter(r101);
        Iterator<WeakReference<g>> r102 = r101.iterator();     // Catch: Throwable -> L22
    L6:
        if (r102.hasNext() == false) goto L20;
        WeakReference<g> r103 = r102.next();     // Catch: Throwable -> L22
        if (r103 == null) goto L9;
        g r104 = r103.get();     // Catch: Throwable -> L22
        if (r104 == null) goto L12;
        if (r104.getActivity() != r100) goto L6;
        b r105 = (b) CollectionsKt.lastOrNull(null);     // Catch: Throwable -> L22
        if (r105 == null) goto L6;
        if (r105.f200623v == false) goto L6;
        r105.f200623v = false;     // Catch: Throwable -> L22
        goto L6
    L12:
        r102.remove();     // Catch: Throwable -> L22
        goto L6
    L9:
        r102.remove();     // Catch: Throwable -> L22
        goto L6
    L20:
        monitor-exit(r101);     // Catch: Throwable -> L22
        return;
    L22:
        th = move-exception;
        throw th;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity r100) {
        f.f200650b.put(r100, 3);
        List<WeakReference<g>> r101 = f.f200649a;
        monitor-enter(r101);
        Iterator<WeakReference<g>> r102 = r101.iterator();     // Catch: Throwable -> L22
    L6:
        if (r102.hasNext() == false) goto L20;
        WeakReference<g> r103 = r102.next();     // Catch: Throwable -> L22
        if (r103 == null) goto L9;
        g r104 = r103.get();     // Catch: Throwable -> L22
        if (r104 == null) goto L12;
        if (r104.getActivity() != r100) goto L6;
        b r105 = (b) CollectionsKt.lastOrNull(null);     // Catch: Throwable -> L22
        if (r105 == null) goto L6;
        if (r105.f200623v == true) goto L6;
        r105.f200623v = true;     // Catch: Throwable -> L22
        goto L6
    L12:
        r102.remove();     // Catch: Throwable -> L22
        goto L6
    L9:
        r102.remove();     // Catch: Throwable -> L22
        goto L6
    L20:
        monitor-exit(r101);     // Catch: Throwable -> L22
        return;
    L22:
        th = move-exception;
        throw th;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity r100) {
        f.f200650b.put(r100, 2);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity r100) {
        f.f200650b.put(r100, 5);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity r100, Bundle r101) {
        f.f200650b.put(r100, 1);
    }
}
