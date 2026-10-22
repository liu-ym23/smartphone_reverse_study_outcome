package com.bytedance.reparo;

import com.bytedance.reparo.core.o;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes6.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ReparoInfoActivity f267455a;

    @Override // java.lang.Runnable
    public final void run() {
        Map<c97.h, d97.d> r100 = o.c().e();     // Catch: Throwable -> L4
        this.f267455a.f267297b.clear();     // Catch: Throwable -> L4
        this.f267455a.f267297b.addAll(((ConcurrentHashMap) r100).values());     // Catch: Throwable -> L4
        this.f267455a.f267296a.notifyDataSetChanged();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public h(ReparoInfoActivity r100) {
        this.f267455a = r100;
    }
}
