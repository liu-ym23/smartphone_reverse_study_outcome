package com.bytedance.bdp.serviceapi.defaults.permission;

import android.os.Handler;
import com.bytedance.bdp.appbase.base.bdptask.BdpHandler;
import com.bytedance.bdp.bdpbase.manager.BdpManager;
import com.bytedance.bdp.serviceapi.defaults.log.BdpLogService;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes11.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<String> f201578a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f201579b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<BdpPermissionResult> f201580c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Handler f201581d;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f201582a;

        @Override // java.lang.Runnable
        public final void run() {
            b r100 = this.f201582a;     // Catch: Throwable -> L4
            List<BdpPermissionResult> r101 = r100.f201580c;     // Catch: Throwable -> L4
            r100.b();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(b r100) {
            this.f201582a = r100;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.bdp.serviceapi.defaults.permission.b$b, reason: collision with other inner class name */
    public class RunnableC2905b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f201583a;

        @Override // java.lang.Runnable
        public final void run() {
            b r100 = this.f201583a;     // Catch: Throwable -> L4
            List<BdpPermissionResult> r101 = r100.f201580c;     // Catch: Throwable -> L4
            r100.b();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public RunnableC2905b(b r100) {
            this.f201583a = r100;
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f201584a;

        @Override // java.lang.Runnable
        public final void run() {
            this.f201584a.c();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public c(b r100) {
            this.f201584a = r100;
        }
    }

    public abstract void b();

    public abstract void c();

    public final synchronized void f() {
        monitor-enter(this);
        monitor-exit(this);
    }

    public b() {
        this.f201578a = new HashSet(1);
        this.f201579b = false;
        this.f201580c = new ArrayList();
    }

    public b(BdpHandler r100) {
        this.f201578a = new HashSet(1);
        this.f201579b = false;
        this.f201580c = new ArrayList();
        this.f201581d = r100;
    }

    public final synchronized void e(Set<String> r100) {
        monitor-enter(this);
        this.f201578a.addAll(r100);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final boolean a(String r100, BdpPermissionResult.ResultType r101) {
        if (r101 != BdpPermissionResult.ResultType.DENIED) goto L5;
        return true;
    L5:
        monitor-enter(this);
        ((BdpLogService) BdpManager.getInst().getService(BdpLogService.class)).d("PermissionsResultListener", "Permission not found: " + r100);     // Catch: Throwable -> L9
        monitor-exit(this);
        return false;
    L9:
        th = move-exception;
        throw th;
    }

    public final synchronized boolean d(String r100, BdpPermissionResult.ResultType r101, boolean r102) {
        monitor-enter(this);
    L34:
        th = move-exception;
        throw th;
    L5:
        if (((HashSet) this.f201578a).remove(r100) == true) goto L8;
        monitor-exit(this);
        return false;
    L8:
        BdpPermissionResult r103 = new BdpPermissionResult(r101);     // Catch: Throwable -> L34
        ((ArrayList) this.f201580c).add(r103);     // Catch: Throwable -> L34
        boolean r104 = a(r100, r101);     // Catch: Throwable -> L34
        f();     // Catch: Throwable -> L34
        if (r104 == false) goto L16;
        Handler r105 = this.f201581d;     // Catch: Throwable -> L34
        if (r105 == null) goto L13;
        r105.post(new a(this));     // Catch: Throwable -> L34
    L14:
        monitor-exit(this);
        return true;
    L13:
        b();     // Catch: Throwable -> L34
        goto L14
    L16:
        if (r104 == false) goto L19;
        this.f201579b = true;     // Catch: Throwable -> L34
    L19:
        if (((HashSet) this.f201578a).isEmpty() == true) goto L21;
        monitor-exit(this);
        return false;
    L21:
        if (this.f201579b == false) goto L26;
        Handler r106 = this.f201581d;     // Catch: Throwable -> L34
        if (r106 == null) goto L25;
        r106.post(new RunnableC2905b(this));     // Catch: Throwable -> L34
    L30:
        monitor-exit(this);
        return true;
    L25:
        b();     // Catch: Throwable -> L34
        goto L30
    L26:
        Handler r107 = this.f201581d;     // Catch: Throwable -> L34
        if (r107 == null) goto L29;
        r107.post(new c(this));     // Catch: Throwable -> L34
        goto L30
    L29:
        c();     // Catch: Throwable -> L34
        goto L30
    }
}
