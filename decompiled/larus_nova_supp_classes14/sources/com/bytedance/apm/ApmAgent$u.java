package com.bytedance.apm;

import android.text.TextUtils;
import bt3.b;
import com.larus.apm.impl.protector.RunnableProtector;
import ss3.a;
import vr3.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class ApmAgent$u implements Runnable {
    public final /* synthetic */ String a;

    public final void a() {
        h r0 = h.c.a;
        String r1 = this.a;
        if (r0.g == true) goto L5;
        return;
    L5:
        if (((a) r0).b == false) goto L7;
        return;
    L7:
        if (r0.q == true) goto L25;
        Object r2 = r0.l;
        monitor-enter(r2);
        ykc.a.a(d.getContext(), r0.t, r0.h);     // Catch: Throwable -> L17
        if (TextUtils.isEmpty(r0.j) == false) goto L14;
        b.d.a.a(r0);     // Catch: Throwable -> L17
    L14:
        r0.j = r1;     // Catch: Throwable -> L17
        r0.j();     // Catch: Throwable -> L17
        monitor-exit(r2);     // Catch: Throwable -> L17
        return;
    L17:
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

    public ApmAgent$u(String r1) {
        this.a = r1;
    }
}
