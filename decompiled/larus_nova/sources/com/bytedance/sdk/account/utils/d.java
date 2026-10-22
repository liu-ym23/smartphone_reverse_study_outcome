package com.bytedance.sdk.account.utils;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.SystemClock;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile int f269537a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LinkedList<Activity> f269538b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final HashSet<b> f269539c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile long f269540d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final AtomicBoolean f269541e = null;

    public static class a implements Application.ActivityLifecycleCallbacks {
        public a() {
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
        public final void onActivityDestroyed(Activity r100) {
            d.f269538b.remove(r100);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity r100) {
            d.f269537a++;
            if (d.f269537a != 1) goto L8;
            tb7.a.a("AccountActivityStack", "notifyForeground");
            Iterator<b> r101 = d.f269539c.iterator();
        L6:
            if (r101.hasNext() == false) goto L10;
            r101.next().a();
            goto L6
        L10:
            return;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity r100) {
            d.f269537a--;
            if (d.f269537a != 0) goto L8;
            tb7.a.a("AccountActivityStack", "notifyForeground");
            Iterator<b> r101 = d.f269539c.iterator();
        L6:
            if (r101.hasNext() == false) goto L10;
            r101.next().getClass();
            goto L6
        L10:
            return;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity r100, Bundle r101) {
            d.f269538b.add(r100);
        }
    }

    public static class b {
        public b() {
        }

        public void a() {
        }
    }

    static {
        f269538b = new LinkedList();
        f269539c = new HashSet();
        f269540d = 0;
        f269541e = new AtomicBoolean(false);
    }

    public static long a() {
        if (f269540d > 0) goto L7;
        return -1;
    L7:
        return SystemClock.elapsedRealtime() - f269540d;
    }

    public static Activity b() {
        LinkedList<Activity> r100 = f269538b;
        if (r100.isEmpty() == false) goto L6;
        return null;
    L6:
        return r100.getLast();
    }

    public static boolean d() {
        if (f269537a <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static void c(Application r100) {
        if (f269541e.compareAndSet(false, true) == true) goto L6;
        return;
    L6:
        if (f269540d > 0) goto L9;
        f269540d = SystemClock.elapsedRealtime();
    L9:
        r100.registerActivityLifecycleCallbacks(new a());
    }
}
