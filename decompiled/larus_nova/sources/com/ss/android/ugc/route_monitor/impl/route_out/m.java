package com.ss.android.ugc.route_monitor.impl.route_out;

import android.content.Intent;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;

/* JADX INFO: loaded from: classes40.dex */
public final class m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l f454724a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f454725b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f454726c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Intent f454727d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f454728e;

    public m(l r100, long r101, long r102, Intent r103, String r104) {
        this.f454724a = r100;
        this.f454725b = r101;
        this.f454726c = r102;
        this.f454727d = r103;
        this.f454728e = r104;
    }

    public final void a() {
        l r100 = this.f454724a;
        r100.f454709f = this.f454725b;
        r100.f454713j = this.f454726c - r100.f454708e;
        o r101 = o.f454736h;
        g r102 = new g(r100);
        String r103 = this.f454728e;
        Intent r104 = this.f454727d;
        r102.f454692f = r103;
        r102.f454693g = r104;
        r101.getClass();
        monitor-enter("RouteOutMonitor");
        p.f454737c.d(r102.f454687a, "route_back_monitor_result", r102.a());     // Catch: Throwable -> L8
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L8
        monitor-exit("RouteOutMonitor");
        l r106 = this.f454724a;
        ihc.a r107 = new ihc.a(r106.f454705b, r106.f454707d, r106.f454717n, r106.f454709f);
        o.f454732d.b(new n(r107));
        o.f454729a = null;
        o.f454735g = null;
        return;
    L8:
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
}
