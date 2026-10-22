package com.bytedance.helios.sdk;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public final class p {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final p f245593n = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ActivityStack f245594a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f245595b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f245596c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f245597d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f245598e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f245599f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AtomicBoolean f245600g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final o f245601h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Long f245602i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final a f245603j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f245604k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final b f245605l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final c f245606m;

    public class a implements Application.ActivityLifecycleCallbacks {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ p f245607a;

        public a(p r100) {
            this.f245607a = r100;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity r100) {
            p r101 = p.f245593n;
            Objects.toString(r100);
            hz5.k.d("Helios-Log-Page-State", r100 + " onDestroyed");
            this.f245607a.f245594a.remove(r100);
            p.c(this.f245607a, r100, "onActivityDestroy");
            if ((r100 instanceof FragmentActivity) == false) goto L6;
            ((FragmentActivity) r100).getSupportFragmentManager().unregisterFragmentLifecycleCallbacks(this.f245607a.f245606m);
            return;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity r100) {
            p r101 = p.f245593n;
            Objects.toString(r100);
            hz5.k.c("Helios-Log-Page-State", r100 + " onPaused");
            this.f245607a.f245594a.add(r100, Lifecycle.Event.ON_PAUSE);
            p.c(this.f245607a, r100, "onActivityPause");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity r100) {
            p r101 = p.f245593n;
            Objects.toString(r100);
            hz5.k.c("Helios-Log-Page-State", r100 + " onResumed");
            this.f245607a.f245594a.add(r100, Lifecycle.Event.ON_RESUME);
            p.b(this.f245607a, r100);
            p.c(this.f245607a, r100, "onActivityResume");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity r100) {
            p r101 = p.f245593n;
            Objects.toString(r100);
            hz5.k.c("Helios-Log-Page-State", r100 + " onStarted");
            this.f245607a.f245594a.add(r100, Lifecycle.Event.ON_START);
            p.b(this.f245607a, r100);
            p.c(this.f245607a, r100, "onActivityStart");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity r100) {
            p r101 = p.f245593n;
            Objects.toString(r100);
            hz5.k.c("Helios-Log-Page-State", r100 + " onStopped");
            this.f245607a.f245594a.add(r100, Lifecycle.Event.ON_STOP);
            if (this.f245607a.f245599f != r100.hashCode()) goto L5;
            p r102 = this.f245607a;
            r102.f245597d = "null";
            r102.f245599f = 0;
        L5:
            p.c(this.f245607a, r100, "onActivityStop");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity r100, Bundle r101) {
            p r102 = p.f245593n;
            Objects.toString(r100);
            hz5.k.d("Helios-Log-Page-State", r100 + " onCreated");
            this.f245607a.f245594a.add(r100, Lifecycle.Event.ON_CREATE);
            p.b(this.f245607a, r100);
            p.c(this.f245607a, r100, "onActivityCreate");
            if ((r100 instanceof FragmentActivity) == false) goto L6;
            ((FragmentActivity) r100).getSupportFragmentManager().registerFragmentLifecycleCallbacks(this.f245607a.f245606m, true);
            return;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity r100, Bundle r101) {
            hz5.k.c("Helios-Log-Page-State", r100 + " onSaveInstanceState");
        }
    }

    public class b implements LifecycleObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ p f245608a;

        @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
        public void onStopped() {
            this.f245608a.f245596c.set(false);
            com.bytedance.helios.common.utils.d.f().postDelayed(this.f245608a.f245601h, HeliosEnvImpl.get().f245470m.j());
            p r100 = this.f245608a;
            r100.f245602i = Long.valueOf(System.currentTimeMillis());
            p r101 = p.f245593n;
            this.f245608a.e();
            hz5.k.d("Helios-Log-Page-State", "EnterBackground");
            Object r102 = this.f245608a.f245595b;
            monitor-enter(r102);
            nz5.b.c("onAppBackground", null);     // Catch: Throwable -> L7
            monitor-exit(r102);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_START)
        public void onStarted() {
            com.bytedance.helios.common.utils.d.f().removeCallbacks(this.f245608a.f245601h);
            this.f245608a.f245596c.set(true);
            this.f245608a.f245600g.set(false);
            p r100 = this.f245608a;
            r100.f245602i = null;
            p r101 = p.f245593n;
            r100.e();
            hz5.k.d("Helios-Log-Page-State", "EnterForeground");
            Object r102 = this.f245608a.f245595b;
            monitor-enter(r102);
            nz5.b.c("onAppForeground", null);     // Catch: Throwable -> L8
            monitor-exit(r102);     // Catch: Throwable -> L8
            e06.b.c();
            return;
        L8:
            th = move-exception;
            throw th;
        }

        public b(p r100) {
            this.f245608a = r100;
        }
    }

    public class c extends FragmentManager.FragmentLifecycleCallbacks {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ p f245609a;

        public c(p r100) {
            this.f245609a = r100;
        }

        @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
        public final void onFragmentDestroyed(FragmentManager r100, Fragment r101) {
            super.onFragmentDestroyed(r100, r101);
            hz5.k.a("Helios-Log-Page-State", r101 + " onFragmentDestroyed");
            p.a(this.f245609a, r101, "onFragmentDestroy");
        }

        @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
        public final void onFragmentPaused(FragmentManager r100, Fragment r101) {
            super.onFragmentPaused(r100, r101);
            hz5.k.a("Helios-Log-Page-State", r101 + " onFragmentPaused");
            p.a(this.f245609a, r101, "onFragmentPause");
        }

        @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
        public final void onFragmentResumed(FragmentManager r100, Fragment r101) {
            super.onFragmentResumed(r100, r101);
            hz5.k.a("Helios-Log-Page-State", r101 + " onFragmentResumed");
            p.a(this.f245609a, r101, "onFragmentResume");
        }

        @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
        public final void onFragmentStarted(FragmentManager r100, Fragment r101) {
            super.onFragmentStarted(r100, r101);
            hz5.k.a("Helios-Log-Page-State", r101 + " onFragmentStarted");
            p.a(this.f245609a, r101, "onFragmentStart");
        }

        @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
        public final void onFragmentStopped(FragmentManager r100, Fragment r101) {
            super.onFragmentStopped(r100, r101);
            hz5.k.a("Helios-Log-Page-State", r101 + " onFragmentStopped");
            p.a(this.f245609a, r101, "onFragmentStop");
        }

        @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
        public final void onFragmentCreated(FragmentManager r100, Fragment r101, Bundle r102) {
            super.onFragmentCreated(r100, r101, r102);
            hz5.k.a("Helios-Log-Page-State", r101 + " onFragmentCreated");
            p.a(this.f245609a, r101, "onFragmentCreate");
        }
    }

    static {
        f245593n = new p();
    }

    public final boolean d() {
        if (this.f245600g.get() == true) goto L5;
    L7:
        return false;
    L5:
        if (e() == true) goto L7;
        return true;
    }

    public final boolean e() {
        return this.f245596c.get();
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [com.bytedance.helios.sdk.o] */
    public p() {
        this.f245594a = new ActivityStack();
        this.f245595b = new Object();
        this.f245596c = new AtomicBoolean(true);
        this.f245597d = "null";
        this.f245598e = "null";
        this.f245599f = 0;
        this.f245600g = new AtomicBoolean(false);
        this.f245601h = new o(this);
        this.f245602i = null;
        this.f245603j = new a(this);
        this.f245604k = 0;
        this.f245605l = new b(this);
        this.f245606m = new c(this);
    }

    public static void b(p r100, Activity r101) {
        r100.getClass();
        String r102 = r101.getClass().getName();
        r100.f245597d = r102;
        r100.f245599f = r101.hashCode();
        r100.f245598e = r102;
        r100.f245604k = r101.hashCode();
    }

    public static void a(p r100, Fragment r101, String r102) {
        r100.getClass();
        long r103 = System.currentTimeMillis();
        Object r104 = r100.f245595b;
        monitor-enter(r104);
        nz5.b.c(r102, r101);     // Catch: Throwable -> L8
        monitor-exit(r104);     // Catch: Throwable -> L8
        rz5.a.a("checkFragmentResource", r103, false);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public static void c(p r100, Activity r101, String r102) {
        r100.getClass();
        long r103 = System.currentTimeMillis();
        Object r104 = r100.f245595b;
        monitor-enter(r104);
        nz5.b.c(r102, r101.getClass().getName());     // Catch: Throwable -> L8
        monitor-exit(r104);     // Catch: Throwable -> L8
        rz5.a.a("checkResource", r103, false);
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
