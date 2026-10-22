package com.bytedance.reparo;

import android.app.Application;
import android.os.SystemClock;
import com.bytedance.reparo.core.common.event.Event;
import com.bytedance.reparo.core.exception.PatchException;
import com.bytedance.reparo.secondary.Logger;
import com.bytedance.reparo.secondary.l;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class g {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static long f267440k = 5000;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static volatile g f267441l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile long f267442a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f267443b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.reparo.c f267444c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.bytedance.reparo.core.g f267445d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Application f267446e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f267447f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile boolean f267448g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f267449h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f267450i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile boolean f267451j;

    public class a implements Runnable {
        @Override // java.lang.Runnable
        public final void run() {
            com.bytedance.reparo.secondary.a.a(false, -1);     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            Logger.b("AppMonitorService", "report local patch list failed. ", th);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L12;
            return;
        L12:
            throw th;
        }

        public a() {
        }
    }

    /* JADX INFO: loaded from: classes21.dex */
    public class b implements com.bytedance.reparo.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IReparoConfig f267452a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ g f267453b;

        @Override // com.bytedance.reparo.a
        public final void b() {
        }

        @Override // com.bytedance.reparo.a
        public final void a() {
            if (this.f267453b.f267451j == true) goto L5;
            return;
        L5:
            if (this.f267453b.f267447f == true) goto L7;
            this.f267453b.b(this.f267452a);
        L7:
            this.f267453b.f();
            this.f267453b.f267451j = false;
        }

        @Override // com.bytedance.reparo.a
        public final void c() {
            this.f267453b.f267451j = true;
        }

        public b(g r100, IReparoConfig r101) {
            this.f267453b = r100;
            this.f267452a = r101;
        }
    }

    /* JADX INFO: loaded from: classes21.dex */
    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f267454a;

        @Override // java.lang.Runnable
        public final void run() {
            this.f267454a.e();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public c(g r100) {
            this.f267454a = r100;
        }
    }

    public static g a() {
        if (f267441l != null) goto L15;
        monitor-enter(g.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f267441l != null) goto L9;
        f267441l = new g();     // Catch: Throwable -> L11
    L9:
        monitor-exit(g.class);     // Catch: Throwable -> L11
    L15:
        return f267441l;
    }

    public final void e() {
        if (this.f267447f == true) goto L5;
        return;
    L5:
        long r100 = System.currentTimeMillis();
        Logger.c();
        if ((r100 - this.f267442a) <= f267440k) goto L8;
        this.f267442a = r100;
        this.f267443b.update();
        return;
    L8:
        Logger.c();
    }

    public final void f() {
        if (this.f267447f == true) goto L5;
        return;
    L5:
        this.f267443b.a().execute(new c(this));
    }

    public g() {
        this.f267447f = false;
        this.f267448g = false;
        this.f267449h = true;
        this.f267450i = "https://security.snssdk.com/api/plugin/config/v3/";
        this.f267443b = e.b();
        if (com.bytedance.reparo.c.f267304d == null) goto L5;
    L14:
        this.f267444c = com.bytedance.reparo.c.f267304d;
        return;
    L5:
        monitor-enter(com.bytedance.reparo.c.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (com.bytedance.reparo.c.f267304d != null) goto L9;
        com.bytedance.reparo.c.f267304d = new com.bytedance.reparo.c();     // Catch: Throwable -> L11
    L9:
        monitor-exit(com.bytedance.reparo.c.class);     // Catch: Throwable -> L11
        goto L14
    }

    public final synchronized void b(IReparoConfig r100) {
        monitor-enter(this);
    L31:
        th = move-exception;
        throw th;
    L4:
        if (r100.autoFetchPatch() == false) goto L7;
        c(r100);     // Catch: Throwable -> L31
    L7:
        if (r100.enable() == true) goto L11;
        monitor-exit(this);
        return;
    L11:
        if (r100.autoFailThenSyncMode() == false) goto L13;
        e97.a.f471512g = true;     // Catch: Throwable -> L31
    L13:
        long r101 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L31
        com.bytedance.reparo.secondary.b r102 = new com.bytedance.reparo.secondary.b(r100);     // Catch: Throwable -> L31
        if (r102.isMainProcess() == true) goto L20;
        if (this.f267449h == true) goto L20;
        monitor-exit(this);
        return;
    L20:
        if (this.f267447f == false) goto L35;
        monitor-exit(this);
        return;
    L35:
        d(r102);     // Catch: Throwable -> L27
        this.f267447f = true;     // Catch: Throwable -> L31
        Event r103 = com.bytedance.reparo.secondary.c.b(true);     // Catch: Throwable -> L31
        r103.f267345d = r101;     // Catch: Throwable -> L31
        r103.f267347f = true;     // Catch: Throwable -> L31
        r103.j();     // Catch: Throwable -> L31
        this.f267443b.a().execute(new a());     // Catch: Throwable -> L31
        monitor-exit(this);
        return;
    L27:
        th = move-exception;
        Logger.b("Reparo", "init failed. ", th);     // Catch: Throwable -> L31
        PatchException r104 = new PatchException("init failed. ", th, 0);     // Catch: Throwable -> L31
        Event r105 = com.bytedance.reparo.secondary.c.b(false);     // Catch: Throwable -> L31
        r105.f267345d = r101;     // Catch: Throwable -> L31
        r105.e(r104);     // Catch: Throwable -> L31
        r105.j();     // Catch: Throwable -> L31
    }

    public final synchronized void c(IReparoConfig r100) {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.f267448g == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        com.bytedance.reparo.c r101 = this.f267444c;     // Catch: Throwable -> L10
        Application r102 = r100.getApplication();     // Catch: Throwable -> L10
        r101.getClass();     // Catch: Throwable -> L10
        r102.registerActivityLifecycleCallbacks(new com.bytedance.reparo.b(r101));     // Catch: Throwable -> L10
        com.bytedance.reparo.c r103 = this.f267444c;     // Catch: Throwable -> L10
        b r104 = new b(this, r100);     // Catch: Throwable -> L10
        ((ArrayList) r103.f267306b).add(r104);     // Catch: Throwable -> L10
        this.f267448g = true;     // Catch: Throwable -> L10
        monitor-exit(this);
    }

    public final synchronized void d(com.bytedance.reparo.secondary.b r100) {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (r100.getApplication() == null) goto L18;
        if (r100.getUpdateVersionCode() == null) goto L16;
        Application r101 = r100.getApplication();     // Catch: Throwable -> L13
        this.f267446e = r101;     // Catch: Throwable -> L13
        l.a(r101, r100, this.f267443b.a());     // Catch: Throwable -> L13
        e r102 = this.f267443b;     // Catch: Throwable -> L13
        Application r103 = this.f267446e;     // Catch: Throwable -> L13
        boolean r104 = r100.isMainProcess();     // Catch: Throwable -> L13
        String r105 = r100.getUpdateVersionCode();     // Catch: Throwable -> L13
        if (this.f267445d != null) goto L10;
        this.f267445d = new com.bytedance.reparo.core.g();     // Catch: Throwable -> L13
    L10:
        r102.d(r103, r100, r104, r105, this.f267445d);     // Catch: Throwable -> L13
        monitor-exit(this);
        return;
    L16:
        throw new IllegalArgumentException("IFrankieConfig.getUpdateVersionCode() can not be null!");     // Catch: Throwable -> L13
    L18:
        throw new IllegalArgumentException("IFrankieConfig.getApplication() can not be null!");     // Catch: Throwable -> L13
    }
}
