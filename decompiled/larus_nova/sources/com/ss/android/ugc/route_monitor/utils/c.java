package com.ss.android.ugc.route_monitor.utils;

import android.app.Activity;
import android.os.Bundle;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes40.dex */
public final class c extends k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f454749a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final j<n> f454750b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final j<m> f454751c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final j<com.ss.android.ugc.route_monitor.utils.a> f454752d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static WeakReference<Activity> f454753e;

    public static final class a implements j.a<com.ss.android.ugc.route_monitor.utils.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f454754a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Bundle f454755b;

        public void call(com.ss.android.ugc.route_monitor.utils.a r100) {
            r100.onActivityCreated(this.f454754a, this.f454755b);
        }

        @Override // com.ss.android.ugc.route_monitor.utils.j.a
        public /* bridge */ /* synthetic */ void call(j.b r100) {
            call((com.ss.android.ugc.route_monitor.utils.a) r100);
        }

        public a(Activity r100, Bundle r101) {
            this.f454754a = r100;
            this.f454755b = r101;
        }
    }

    public static final class b implements j.a<com.ss.android.ugc.route_monitor.utils.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f454756a;

        public b(Activity r100) {
            this.f454756a = r100;
        }

        public void call(com.ss.android.ugc.route_monitor.utils.a r100) {
            r100.onActivityDestroyed(this.f454756a);
        }

        @Override // com.ss.android.ugc.route_monitor.utils.j.a
        public /* bridge */ /* synthetic */ void call(j.b r100) {
            call((com.ss.android.ugc.route_monitor.utils.a) r100);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.ugc.route_monitor.utils.c$c, reason: collision with other inner class name */
    public static final class C5452c implements j.a<com.ss.android.ugc.route_monitor.utils.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f454757a;

        public C5452c(Activity r100) {
            this.f454757a = r100;
        }

        public void call(com.ss.android.ugc.route_monitor.utils.a r100) {
            r100.onActivityPaused(this.f454757a);
        }

        @Override // com.ss.android.ugc.route_monitor.utils.j.a
        public /* bridge */ /* synthetic */ void call(j.b r100) {
            call((com.ss.android.ugc.route_monitor.utils.a) r100);
        }
    }

    public static final class d implements j.a<com.ss.android.ugc.route_monitor.utils.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f454758a;

        public d(Activity r100) {
            this.f454758a = r100;
        }

        public void call(com.ss.android.ugc.route_monitor.utils.a r100) {
            r100.onActivityResumed(this.f454758a);
        }

        @Override // com.ss.android.ugc.route_monitor.utils.j.a
        public /* bridge */ /* synthetic */ void call(j.b r100) {
            call((com.ss.android.ugc.route_monitor.utils.a) r100);
        }
    }

    public static final class e implements j.a<com.ss.android.ugc.route_monitor.utils.a> {
        @Override // com.ss.android.ugc.route_monitor.utils.j.a
        public /* bridge */ /* synthetic */ void call(j.b r100) {
            call((com.ss.android.ugc.route_monitor.utils.a) r100);
        }

        public void call(com.ss.android.ugc.route_monitor.utils.a r100) {
            r100.getClass();
        }

        public e(Activity r100, Bundle r101) {
        }
    }

    public static final class f implements j.a<n> {
        public f(Activity r100) {
        }

        @Override // com.ss.android.ugc.route_monitor.utils.j.a
        public /* bridge */ /* synthetic */ void call(j.b r100) {
            call((n) r100);
        }

        public void call(n r100) {
            r100.enterForeground();
        }
    }

    public static final class g implements j.a<com.ss.android.ugc.route_monitor.utils.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f454759a;

        public g(Activity r100) {
            this.f454759a = r100;
        }

        public void call(com.ss.android.ugc.route_monitor.utils.a r100) {
            r100.onActivityStarted(this.f454759a);
        }

        @Override // com.ss.android.ugc.route_monitor.utils.j.a
        public /* bridge */ /* synthetic */ void call(j.b r100) {
            call((com.ss.android.ugc.route_monitor.utils.a) r100);
        }
    }

    public static final class h implements j.a<m> {
        public h(Activity r100) {
        }

        @Override // com.ss.android.ugc.route_monitor.utils.j.a
        public /* bridge */ /* synthetic */ void call(j.b r100) {
            call((m) r100);
        }

        public void call(m r100) {
            r100.enterBackground();
        }
    }

    public static final class i implements j.a<com.ss.android.ugc.route_monitor.utils.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f454760a;

        public i(Activity r100) {
            this.f454760a = r100;
        }

        public void call(com.ss.android.ugc.route_monitor.utils.a r100) {
            r100.onActivityStopped(this.f454760a);
        }

        @Override // com.ss.android.ugc.route_monitor.utils.j.a
        public /* bridge */ /* synthetic */ void call(j.b r100) {
            call((com.ss.android.ugc.route_monitor.utils.a) r100);
        }
    }

    static {
        f454750b = new j();
        f454751c = new j();
        f454752d = new j();
    }

    public static boolean t() {
        if (f454749a <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.ss.android.ugc.route_monitor.utils.k, android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity r100) {
        f454752d.b(new b(r100));
    }

    @Override // com.ss.android.ugc.route_monitor.utils.k, android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity r100) {
        f454752d.b(new C5452c(r100));
    }

    @Override // com.ss.android.ugc.route_monitor.utils.k, android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity r100) {
        f454753e = new WeakReference(r100);
        f454752d.b(new d(r100));
    }

    @Override // com.ss.android.ugc.route_monitor.utils.k, android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity r100) {
        int r101 = f454749a + 1;
        f454749a = r101;
        if (r101 != 1) goto L5;
        f454750b.b(new f(r100));
    L5:
        f454752d.b(new g(r100));
    }

    @Override // com.ss.android.ugc.route_monitor.utils.k, android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity r100) {
        int r101 = f454749a - 1;
        f454749a = r101;
        if (r101 > 0) goto L5;
        f454749a = 0;
        f454751c.b(new h(r100));
    L5:
        f454752d.b(new i(r100));
    }

    @Override // com.ss.android.ugc.route_monitor.utils.k, android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity r100, Bundle r101) {
        f454752d.b(new a(r100, r101));
    }

    @Override // com.ss.android.ugc.route_monitor.utils.k, android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity r100, Bundle r101) {
        f454752d.b(new e(r100, r101));
    }
}
