package com.douyin.janna.platform;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import com.douyin.janna.api.CapabilityType;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes22.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f273598a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f273599b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f273600c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f273601d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f273602e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f273603f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f273604g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Set<CapabilityType> f273605h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Map<Integer, List<fs7.b>> f273606i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public WeakReference<Activity> f273607j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public PowerManager f273608k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public com.douyin.janna.platform.b f273609l;

    /* JADX INFO: renamed from: com.douyin.janna.platform.a$a, reason: collision with other inner class name */
    public class RunnableC3823a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ fs7.a f273610a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f273611b;

        public final void a() {
            a r100 = this.f273611b;
            fs7.a r101 = this.f273610a;
            Map<Integer, List<fs7.b>> r102 = r100.f273606i;
            monitor-enter(r102);
            Map<Integer, List<fs7.b>> r103 = r100.f273606i;     // Catch: Throwable -> L12
            HashMap r104 = (HashMap) r103;     // Catch: Throwable -> L12
            List r105 = (List) r104.get(Integer.valueOf(r101.f478662a));     // Catch: Throwable -> L12
            if (r105 == null) goto L10;
            Iterator r106 = r105.iterator();     // Catch: Throwable -> L12
        L8:
            if (r106.hasNext() == false) goto L10;
            ((fs7.b) r106.next()).onEvent(r101);     // Catch: Throwable -> L12
        L10:
            monitor-exit(r102);     // Catch: Throwable -> L12
            return;
        L12:
            th = move-exception;
            throw th;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public RunnableC3823a(a r100, fs7.a r101) {
            this.f273611b = r100;
            this.f273610a = r101;
        }
    }

    public class b implements Application.ActivityLifecycleCallbacks {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f273612a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f273613b;

        public b(a r100) {
            this.f273613b = r100;
            this.f273612a = new Object();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity r100) {
            r100.getClass();
            r100.toString();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity r100) {
            r100.getClass();
            r100.toString();
            Object r101 = this.f273612a;
            monitor-enter(r101);
            WeakReference<Activity> r102 = this.f273613b.f273607j;     // Catch: Throwable -> L13
            if (r102 != null) goto L7;
        L11:
            monitor-exit(r101);     // Catch: Throwable -> L13
            return;
        L7:
            if (r102.get() == null) goto L11;
            if (r100 != this.f273613b.f273607j.get()) goto L11;
            this.f273613b.f273607j = null;     // Catch: Throwable -> L13
        L13:
            th = move-exception;
            throw th;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity r100) {
            r100.getClass();
            r100.toString();
            Object r101 = this.f273612a;
            monitor-enter(r101);
            a r102 = this.f273613b;     // Catch: Throwable -> L7
            r102.f273607j = new WeakReference(r100);     // Catch: Throwable -> L7
            monitor-exit(r101);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity r100) {
            r100.getClass();
            r100.toString();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity r100) {
            r100.getClass();
            r100.toString();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity r100, Bundle r101) {
            r100.getClass();
            r100.toString();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity r100, Bundle r101) {
            r100.getClass();
            r100.toString();
        }
    }

    public class c extends Handler {
        public c(Looper r100) {
            super(r100);
        }
    }

    public void f() {
    }

    public float b() {
        return this.f273601d;
    }

    public int c() {
        return this.f273602e;
    }

    public a(Context r100) {
        this.f273600c = false;
        this.f273601d = -99.0f;
        this.f273602e = -1;
        this.f273603f = 0;
        this.f273604g = -1;
        this.f273605h = new HashSet();
        this.f273606i = new HashMap();
        new ArrayList();
        this.f273607j = null;
        b r101 = new b(this);
        this.f273598a = r100;
        PthreadHandlerThreadV2 r102 = new PthreadHandlerThreadV2("janna");
        ThreadMethodProxy.start(r102);
        this.f273599b = new c(r102.getLooper());
        if ((r100 instanceof Application) == false) goto L5;
        ((Application) r100).registerActivityLifecycleCallbacks(r101);
    L5:
        boolean r103 = hq7.a.f486512a;
    }

    public static fs7.a a(int r100) {
        Bundle r101 = new Bundle();
        r101.putInt("open", r100);
        return new fs7.a(11, r101);
    }

    public final boolean d(CapabilityType r100) {
        return ((HashSet) this.f273605h).contains(r100);
    }

    public final boolean e(int r100) {
        Map<Integer, List<fs7.b>> r101 = this.f273606i;
        monitor-enter(r101);
        Map<Integer, List<fs7.b>> r102 = this.f273606i;     // Catch: Throwable -> L12
        HashMap r103 = (HashMap) r102;     // Catch: Throwable -> L12
        List r104 = (List) r103.get(Integer.valueOf(r100));     // Catch: Throwable -> L12
        if (r104 != null) goto L7;
    L9:
        boolean r105 = false;
    L10:
        monitor-exit(r101);     // Catch: Throwable -> L12
        return r105;
    L7:
        if (r104.isEmpty() == true) goto L9;
        r105 = true;
    L12:
        th = move-exception;
        throw th;
    }

    public final void g(fs7.a r100) {
        Objects.toString(r100);
        boolean r101 = hq7.a.f486512a;
        this.f273599b.post(new RunnableC3823a(this, r100));
    }

    public void h(fs7.b r100, List<Integer> r101) {
        Iterator<Integer> r102 = r101.iterator();
        boolean r103 = false;
    L4:
        if (r102.hasNext() == false) goto L22;
        Integer r104 = r102.next();
        Map<Integer, List<fs7.b>> r105 = this.f273606i;
        monitor-enter(r105);
        List r106 = (List) ((HashMap) this.f273606i).get(r104);     // Catch: Throwable -> L19
        if (r106 != null) goto L11;
        r106 = new ArrayList();     // Catch: Throwable -> L19
    L11:
        if (r106.contains(r100) == true) goto L13;
        r106.add(r100);     // Catch: Throwable -> L19
        ((HashMap) this.f273606i).put(r104, r106);     // Catch: Throwable -> L19
    L13:
        if (r104 != null) goto L15;
    L17:
        monitor-exit(r105);     // Catch: Throwable -> L19
        goto L4
    L15:
        if (r104.equals(0) == false) goto L17;
        r103 = true;
    L19:
        th = move-exception;
        throw th;
    L22:
        if (r103 == true) goto L24;
        return;
    L24:
        if (this.f273600c == false) goto L31;
        r100.onEvent(new fs7.a(0, null));
        return;
    }

    public void i(fs7.b r100, List<Integer> r101) {
        Iterator<Integer> r102 = r101.iterator();
    L4:
        if (r102.hasNext() == false) goto L19;
        Integer r103 = r102.next();
        Map<Integer, List<fs7.b>> r104 = this.f273606i;
        monitor-enter(r104);
        List r105 = (List) ((HashMap) this.f273606i).get(r103);     // Catch: Throwable -> L16
        if (r105 == null) goto L9;
        if (r105.contains(r100) == false) goto L14;
        r105.remove(r100);     // Catch: Throwable -> L16
        ((HashMap) this.f273606i).put(r103, r105);     // Catch: Throwable -> L16
    L14:
        monitor-exit(r104);     // Catch: Throwable -> L16
        goto L4
    L9:
        monitor-exit(r104);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    }
}
