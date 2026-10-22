package com.bytedance.awemeopen.apps.framework.utils;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public static final LinkedList<Activity> a = null;
    public static final q0<Activity> b = null;
    public static boolean c;
    public static final C0105a d = null;
    public static final q0<b> e = null;

    /* JADX INFO: renamed from: com.bytedance.awemeopen.apps.framework.utils.a$a, reason: collision with other inner class name */
    public static class C0105a implements Application.ActivityLifecycleCallbacks {
        public C0105a() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity r1) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity r1, Bundle r2) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity r3) {
            monitor-enter(a.class);
            a.a.remove(r3);     // Catch: Throwable -> L7
            monitor-exit(a.class);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity r3) {
            monitor-enter(a.class);
        L16:
            th = move-exception;
            throw th;
        L5:
            if (a.c == false) goto L14;
            a.c = false;     // Catch: Throwable -> L16
            q0<b> r0 = a.e;     // Catch: Throwable -> L16
            if (r0.a.isEmpty() == true) goto L14;
            Iterator<b> r1 = r0.iterator();     // Catch: Throwable -> L16
        L10:
            if (r1.hasNext() == false) goto L14;
            b r2 = r1.next();     // Catch: Throwable -> L16
            if (r2 == null) goto L10;
            r2.onAppForeground();     // Catch: Throwable -> L16
        L14:
            monitor-exit(a.class);     // Catch: Throwable -> L16
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity r4) {
            monitor-enter(a.class);
            q0<Activity> r1 = a.b;     // Catch: Throwable -> L10
            if (r4 != null) goto L7;
            r1.a.size();     // Catch: Throwable -> L10
        L8:
            monitor-exit(a.class);     // Catch: Throwable -> L10
            return;
        L7:
            r1.a.put(r4, r1.b);     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            throw th;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity r4) {
            monitor-enter(a.class);
            q0<Activity> r1 = a.b;     // Catch: Throwable -> L22
            if (r4 != null) goto L7;
            r1.a.size();     // Catch: Throwable -> L22
        L9:
            if (a.c == false) goto L11;
        L20:
            monitor-exit(a.class);     // Catch: Throwable -> L22
            return;
        L11:
            if (r1.a.isEmpty() == false) goto L20;
            a.c = true;     // Catch: Throwable -> L22
            q0<b> r5 = a.e;     // Catch: Throwable -> L22
            if (r5.a.isEmpty() == true) goto L20;
            Iterator<b> r6 = r5.iterator();     // Catch: Throwable -> L22
        L16:
            if (r6.hasNext() == false) goto L20;
            b r2 = r6.next();     // Catch: Throwable -> L22
            if (r2 == null) goto L16;
            r2.onAppBackground();     // Catch: Throwable -> L22
            goto L16
        L7:
            r1.a.remove(r4);     // Catch: Throwable -> L22
        L22:
            th = move-exception;
            throw th;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity r2, Bundle r3) {
            monitor-enter(a.class);
            LinkedList<Activity> r0 = a.a;     // Catch: Throwable -> L7
            r0.remove(r2);     // Catch: Throwable -> L7
            r0.add(r2);     // Catch: Throwable -> L7
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
        a = new LinkedList();
        b = new q0();
        c = true;
        d = new C0105a();
        e = new q0();
    }

    public static synchronized Activity b() {
        monitor-enter(a.class);
        LinkedList<Activity> r1 = a;     // Catch: Throwable -> L10
        if (r1.isEmpty() == false) goto L7;
        Activity r2 = null;
    L8:
        monitor-exit(a.class);
        return r2;
    L7:
        r2 = r1.getLast();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public static synchronized void a(b r3) {
        monitor-enter(a.class);
        q0<b> r1 = e;     // Catch: Throwable -> L9
        if (r1.a.containsKey(r3) == true) goto L7;
        r1.a.put(r3, r1.b);     // Catch: Throwable -> L9
    L7:
        monitor-exit(a.class);
        return;
    L9:
        th = move-exception;
        throw th;
    }
}
