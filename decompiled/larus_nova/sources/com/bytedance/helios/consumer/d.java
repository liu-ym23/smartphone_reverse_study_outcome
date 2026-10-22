package com.bytedance.helios.consumer;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes19.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f245422a = null;

    static {
        f245422a = new d();
    }

    public d() {
    }

    public static void a() {
    L2:
        ConcurrentLinkedQueue<c.a> r100 = c.f245413a;
        if ((!r100.isEmpty()) == false) goto L31;
        c.a r101 = r100.poll();
        if (r101 == null) goto L2;
        StringBuilder r102 = new StringBuilder("(");
        int r103 = com.bytedance.helios.common.utils.f.f245398a;
        r102.append(com.bytedance.helios.common.utils.f.a(r101.f245421e));
        r102.append(") ");
        String r104 = r102.toString();
        if (StringsKt.startsWith$default(r101.f245418b, r104, false, 2, null) == true) goto L9;
        r101.f245418b = r104 + r101.f245418b;
    L9:
        int r105 = r101.f245419c;
        if (r105 != 1) goto L11;
        jz5.e r106 = c.f245415c;
        if (r106 == null) goto L2;
        r106.d(r101.f245417a, r101.f245418b, r101.f245420d);
        goto L2
    L11:
        if (r105 != 2) goto L13;
        jz5.e r107 = c.f245415c;
        if (r107 == null) goto L2;
        r107.i(r101.f245417a, r101.f245418b, r101.f245420d);
        goto L2
    L13:
        if (r105 != 3) goto L15;
        jz5.e r108 = c.f245415c;
        if (r108 == null) goto L2;
        r108.w(r101.f245417a, r101.f245418b, r101.f245420d);
        goto L2
    L15:
        if (r105 != 4) goto L16;
        jz5.e r109 = c.f245415c;
        if (r109 == null) goto L2;
        r109.e(r101.f245417a, r101.f245418b, r101.f245420d);
        goto L2
    L16:
        jz5.e r110 = c.f245415c;
        if (r110 == null) goto L2;
        r110.v(r101.f245417a, r101.f245418b, r101.f245420d);
        goto L2
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
