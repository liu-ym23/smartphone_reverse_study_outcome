package com.bytedance.assem.arch.reused;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class n implements Runnable {
    public final /* synthetic */ ReusedAssemProxyV1 a;
    public final /* synthetic */ List b;

    public n(ReusedAssemProxyV1 r1, List r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        List r0 = this.b;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        Object r2 = null;
        if (r1 == false) goto L18;
        ReusedUIAssem<? extends com.bytedance.tiktok.proxy.a> r3 = this.a.a;
        if ((r3 instanceof g) == false) goto L15;
        r2 = r3;
    L15:
        g r4 = (g) r2;
        if (r4 == null) goto L26;
        r4.onBind();
        return;
    L26:
        return;
    L18:
        ReusedUIAssem<? extends com.bytedance.tiktok.proxy.a> r5 = this.a.a;
        if ((r5 instanceof g) == false) goto L22;
        r2 = r5;
    L22:
        g r6 = (g) r2;
        if (r6 == null) goto L28;
        r6.b();
        return;
    L28:
        return;
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
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
