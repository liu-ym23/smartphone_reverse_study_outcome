package com.bytedance.apm;

import bt3.b;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import vr3.h;
import ykc.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class ApmAgent$w implements Runnable {
    public final /* synthetic */ String a;

    public final void a() {
        h r0 = h.c.a;
        String r1 = this.a;
        if (r0.g == false) goto L22;
        Object r2 = r0.l;
        monitor-enter(r2);
    L17:
        th = move-exception;
        throw th;
    L8:
        if (r1.equals(r0.j) == true) goto L11;
        monitor-exit(r2);     // Catch: Throwable -> L17
        return;
    L11:
        r0.j = null;     // Catch: Throwable -> L17
        b.d.a.i(r0);     // Catch: Throwable -> L17
        PthreadHandlerThreadV2 r3 = a.a;     // Catch: Throwable -> L17
        if (r3 == null) goto L14;
        r3.quit();     // Catch: Throwable -> L17
        a.c.a.j();     // Catch: Throwable -> L17
        a.a = null;     // Catch: Throwable -> L17
        a.b = null;     // Catch: Throwable -> L17
        a.c = null;     // Catch: Throwable -> L17
    L14:
        r0.j();     // Catch: Throwable -> L17
        monitor-exit(r2);     // Catch: Throwable -> L17
        return;
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

    public ApmAgent$w(String r1) {
        this.a = r1;
    }
}
