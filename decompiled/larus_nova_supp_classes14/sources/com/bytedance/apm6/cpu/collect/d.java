package com.bytedance.apm6.cpu.collect;

import com.larus.apm.impl.protector.RunnableProtector;
import cv3.a;
import java.util.LinkedList;
import nu3.b;
import tt3.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d extends a {
    public final /* synthetic */ boolean d;
    public final /* synthetic */ String e;
    public final /* synthetic */ double f;
    public final /* synthetic */ double g;

    public final void a() {
        if (this.d == true) goto L5;
        CpuCacheItem.CpuDataType r0 = CpuCacheItem.CpuDataType.FRONT;
    L6:
        c r1 = new c(r0, this.e, this.f, 0.0d, this.g, 0.0d, null);
        r1.i = ykc.c.c(com.bytedance.apm.d.getContext());
        r1.j = false;
        if (f.c == false) goto L9;
        b.a(r1);
        return;
    L9:
        ((LinkedList) f.b).add(r1);
        return;
    L5:
        r0 = CpuCacheItem.CpuDataType.BACK;
        goto L6
    }

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

    public d(boolean r1, String r2, double r3, double r5) {
        this.d = r1;
        this.e = r2;
        this.f = r3;
        this.g = r5;
    }
}
