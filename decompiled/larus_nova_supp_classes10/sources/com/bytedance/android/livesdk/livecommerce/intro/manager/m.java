package com.bytedance.android.livesdk.livecommerce.intro.manager;

import com.bytedance.android.livesdk.livecommerce.intro.model.req.IntroCardScene;
import com.bytedance.android.livesdk.livecommerce.opt.ECLivePerformanceMonitor;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContext;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class m implements Runnable {
    public final /* synthetic */ com.bytedance.android.livesdk.livecommerce.intro.controller.b a;
    public final /* synthetic */ Pair b;
    public final /* synthetic */ uh2.a c;
    public final /* synthetic */ boolean d;
    public final /* synthetic */ p e;

    public m(com.bytedance.android.livesdk.livecommerce.intro.controller.b r1, Pair r2, uh2.a r3, boolean r4, p r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    public final void a() {
        Pair r0 = this.b;
        if (r0 == null) goto L16;
        IntroCardScene r1 = (IntroCardScene) r0.getSecond();
        if (r1 == null) goto L16;
        if (sh2.f.b(r1) != true) goto L16;
        ECContext r2 = this.e.a.l.r();
        if (r2 == null) goto L13;
        com.bytedance.live.datacontext.i<ECLivePerformanceMonitor> r3 = r2.getEcLivePerformanceMonitor();
        if (r3 == null) goto L13;
        ECLivePerformanceMonitor r4 = (ECLivePerformanceMonitor) r3.getValue();
    L14:
        if (r4 == null) goto L16;
        ECLivePerformanceMonitor.y(r4, Boolean.TRUE, new gf.a(0));
    L13:
        r4 = null;
    L16:
        this.a.m(this.c, false, this.d);
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
