package com.ss.android.lark.conditional.access.auth.v2.service;

import com.bytedance.services.apm.api.EnsureManager;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadTimer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes35.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f417908a;

    public h(f r100) {
        this.f417908a = r100;
    }

    public final void a() {
        f r100 = this.f417908a;
        r100.getClass();
        ArrayList<String> r101 = com.ss.android.lark.conditional.access.utils.c.f418483a;
        com.ss.android.lark.conditional.access.utils.c.b("SecurityPolicy_DelayCleanupService", "Clean up triggered", true);
        if (r100.e() >= 1) goto L6;
        com.ss.android.lark.conditional.access.utils.c.a("SecurityPolicy_DelayCleanupService", "IP Config point < 1， return", true);
        return;
    L6:
        if (r100.f417900b != null) goto L15;
        r100.f417900b = new PthreadTimer("DelayCleanupService");
        f.a r102 = new f.a(r100);
        r100.f417901c = r102;
        PthreadTimer r103 = r100.f417900b;     // Catch: Exception -> L12
        if (r103 == null) goto L14;
        long r104 = r100.f417903e;     // Catch: Exception -> L12
        r103.schedule(r102, r104, r104);     // Catch: Exception -> L12
    L14:
        ArrayList<String> r105 = com.ss.android.lark.conditional.access.utils.c.f418483a;
        com.ss.android.lark.conditional.access.utils.c.b("SecurityPolicy_DelayCleanupService", "clean timer is null, start new timer  " + r100.f417900b, true);
    L12:
        e = move-exception;
        r100.f417900b = null;
        EnsureManager.ensureNotReachHere(e, "Cleanup timer schedule task failed");
    L15:
        long r106 = System.currentTimeMillis();
        Iterator<Map.Entry<String, i>> r107 = r100.f417902d.entrySet().iterator();
    L17:
        if (r107.hasNext() == false) goto L33;
        i r108 = r107.next().getValue();
        if (r108.f417909a == false) goto L17;
        if (r108.f417910b != null) goto L17;
        r108.f417910b = Long.valueOf(r106);
        goto L17
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
