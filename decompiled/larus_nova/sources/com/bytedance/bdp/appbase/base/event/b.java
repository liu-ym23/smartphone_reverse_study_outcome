package com.bytedance.bdp.appbase.base.event;

import com.bytedance.bdp.bdpbase.util.i;
import com.larus.apm.impl.protector.RunnableProtector;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c.InterfaceC2890c f200547a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f200548b;

    public final void a() {
        c r100 = this.f200548b;
        r100.getClass();
        JSONObject r101 = new JSONObject();
        c.g[] r102 = r100.f200552c;     // Catch: Throwable -> L11
        int r103 = r102.length;     // Catch: Throwable -> L11
        int r104 = 0;
    L4:
        if (r104 >= r103) goto L9;
        c.g r105 = r102[r104];     // Catch: Throwable -> L11
        if (r105 == null) goto L8;
        c.b(r101, r105.getParams());     // Catch: Throwable -> L11
    L8:
        r104 = r104 + 1;     // Catch: Throwable -> L11
        goto L4
    L9:
        r101.put(BdpAppEventConstant.PARAMS_TIMESTAMP, r100.f200550a);     // Catch: Throwable -> L11
    L13:
        c.InterfaceC2890c r106 = this.f200547a;
        if (r106 == null) goto L16;
    L31:
        r106.sendEvent(this.f200548b.f200551b, r101);
        return;
    L16:
        if (c.f200549d == null) goto L18;
    L30:
        r106 = c.f200549d;
        goto L31
    L18:
        monitor-enter(c.class);
    L27:
        th = move-exception;
        throw th;
    L20:
        if (c.f200549d == null) goto L22;
    L25:
        monitor-exit(c.class);     // Catch: Throwable -> L27
        goto L30
    L22:
        if (i.d(z84.a.a()) == false) goto L24;
        c.f200549d = new c.e();     // Catch: Throwable -> L27
        goto L25
    L24:
        c.f200549d = new c.b();     // Catch: Throwable -> L27
    L11:
        th = move-exception;
        g94.b.c().Y1(th);
        goto L13
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

    public b(c r100) {
        this.f200548b = r100;
        this.f200547a = null;
    }
}
