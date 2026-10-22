package com.bytedance.applog.log;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class h extends n {
    public h() {
    }

    @Override // com.bytedance.applog.log.c
    public final void v(int r4, int r5, List<String> r6, Throwable r7, String r8, Object... r9) {
        if (l.a.isEmpty() == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        if (r0 == false) goto L10;
        return;
    L10:
        k r1 = new k();
        r1.g = System.currentTimeMillis();
        r1.d = r4;
        r1.c = r5;
        r1.b = ThreadMethodProxy.currentThread().getName();
        r1.h = r7;
        if (r6 != null) goto L13;
    L15:
        List r10 = this.b;
    L16:
        r1.e = r10;
        r1.f = c.u(r8, r9);
        l.a(r1);
        Iterator r11 = ((ConcurrentHashMap) l.b).values().iterator();
    L18:
        if (r11.hasNext() == false) goto L20;
        ((j) r11.next()).a(r1);
        goto L18
    L20:
        return;
    L13:
        if (r6.size() <= 0) goto L15;
        ArrayList r12 = new ArrayList();
        r12.addAll(this.b);
        r12.addAll(r6);
        r10 = r12;
        goto L16
    L5:
        if (((ConcurrentHashMap) l.b).isEmpty() == false) goto L7;
        r0 = true;
        goto L8
    }
}
