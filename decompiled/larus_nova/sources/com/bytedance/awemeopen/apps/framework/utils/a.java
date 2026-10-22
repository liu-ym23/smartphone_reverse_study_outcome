package com.bytedance.awemeopen.apps.framework.utils;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes14.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LinkedList<Activity> f197665a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final q0<Activity> f197666b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f197667c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C2832a f197668d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final q0<b> f197669e = null;

    /* JADX INFO: renamed from: com.bytedance.awemeopen.apps.framework.utils.a$a, reason: collision with other inner class name */
    public static class C2832a implements Application.ActivityLifecycleCallbacks {
        public C2832a() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity r100) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity r100, Bundle r101) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity r100) {
            monitor-enter(a.class);
            a.f197665a.remove(r100);     // Catch: Throwable -> L7
            monitor-exit(a.class);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity r100) {
            monitor-enter(a.class);
        L16:
            th = move-exception;
            throw th;
        L5:
            if (a.f197667c == false) goto L14;
            a.f197667c = false;     // Catch: Throwable -> L16
            q0<b> r101 = a.f197669e;     // Catch: Throwable -> L16
            if (r101.f197738a.isEmpty() == true) goto L14;
            Iterator<b> r102 = r101.iterator();     // Catch: Throwable -> L16
        L10:
            if (r102.hasNext() == false) goto L14;
            b r103 = r102.next();     // Catch: Throwable -> L16
            if (r103 == null) goto L10;
            r103.onAppForeground();     // Catch: Throwable -> L16
        L14:
            monitor-exit(a.class);     // Catch: Throwable -> L16
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity r100) {
            monitor-enter(a.class);
            q0<Activity> r101 = a.f197666b;     // Catch: Throwable -> L10
            if (r100 != null) goto L7;
            r101.f197738a.size();     // Catch: Throwable -> L10
        L8:
            monitor-exit(a.class);     // Catch: Throwable -> L10
            return;
        L7:
            r101.f197738a.put(r100, r101.f197739b);     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            throw th;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity r100) {
            monitor-enter(a.class);
            q0<Activity> r101 = a.f197666b;     // Catch: Throwable -> L22
            if (r100 != null) goto L7;
            r101.f197738a.size();     // Catch: Throwable -> L22
        L9:
            if (a.f197667c == false) goto L11;
        L20:
            monitor-exit(a.class);     // Catch: Throwable -> L22
            return;
        L11:
            if (r101.f197738a.isEmpty() == false) goto L20;
            a.f197667c = true;     // Catch: Throwable -> L22
            q0<b> r102 = a.f197669e;     // Catch: Throwable -> L22
            if (r102.f197738a.isEmpty() == true) goto L20;
            Iterator<b> r103 = r102.iterator();     // Catch: Throwable -> L22
        L16:
            if (r103.hasNext() == false) goto L20;
            b r104 = r103.next();     // Catch: Throwable -> L22
            if (r104 == null) goto L16;
            r104.onAppBackground();     // Catch: Throwable -> L22
            goto L16
        L7:
            r101.f197738a.remove(r100);     // Catch: Throwable -> L22
        L22:
            th = move-exception;
            throw th;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity r100, Bundle r101) {
            monitor-enter(a.class);
            LinkedList<Activity> r102 = a.f197665a;     // Catch: Throwable -> L7
            r102.remove(r100);     // Catch: Throwable -> L7
            r102.add(r100);     // Catch: Throwable -> L7
            monitor-exit(a.class);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }
    }

    public interface b {
        void onAppBackground();

        void onAppForeground();
    }

    public a() {
    }

    static {
        f197665a = new LinkedList();
        f197666b = new q0();
        f197667c = true;
        f197668d = new C2832a();
        f197669e = new q0();
    }

    public static synchronized Activity b() {
        monitor-enter(a.class);
        LinkedList<Activity> r100 = f197665a;     // Catch: Throwable -> L10
        if (r100.isEmpty() == false) goto L7;
        Activity r101 = null;
    L8:
        monitor-exit(a.class);
        return r101;
    L7:
        r101 = r100.getLast();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public static synchronized void a(b r100) {
        monitor-enter(a.class);
        q0<b> r101 = f197669e;     // Catch: Throwable -> L9
        if (r101.f197738a.containsKey(r100) == true) goto L7;
        r101.f197738a.put(r100, r101.f197739b);     // Catch: Throwable -> L9
    L7:
        monitor-exit(a.class);
        return;
    L9:
        th = move-exception;
        throw th;
    }
}
