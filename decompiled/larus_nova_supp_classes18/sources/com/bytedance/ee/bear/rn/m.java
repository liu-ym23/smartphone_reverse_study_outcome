package com.bytedance.ee.bear.rn;

import android.os.Looper;
import com.bytedance.ee.bear.lark.dependency.a0;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.utils.LarkContext;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class m implements Runnable {
    public static final m a = null;

    static {
        a = new m();
    }

    public m() {
    }

    public static void a() {
        RnSyncManager r0 = RnSyncManager.a;
        tt5.a.h("RnSyncManager", "closeSessionInternal");
        t r1 = RnSyncManager.w;
        if (r1 == null) goto L5;
        ((a0) LarkContext.spiByDwarf(a0.class)).k8(r1);
    L5:
        RnSyncManager.w = null;
        wl5.f r2 = RnSyncManager.j;
        if (r2 == null) goto L15;
        Set<wl5.a> r3 = r2.c;
        monitor-enter(r3);
        ((HashSet) r2.c).remove(r0);     // Catch: Throwable -> L12
        monitor-exit(r3);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    L15:
        wl5.f r4 = RnSyncManager.j;
        if (r4 == null) goto L25;
        tt5.a.h("JSModelService-Docs", "JSModelService hashcode: " + r4.hashCode() + "->stop");
        tt5.a.h("JSModelService-Docs", "JSModelService hashcode: " + r4.hashCode() + "->doStopJSClient");
        onb.g r5 = r4.b.a;
        r5.getClass();
        if (Looper.myLooper() != Looper.getMainLooper()) goto L20;
        r5.e();
    L21:
        r4.b.a.f(r4);
        return;
    L20:
        r5.e.post(new onb.f(r5));
        goto L21
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
