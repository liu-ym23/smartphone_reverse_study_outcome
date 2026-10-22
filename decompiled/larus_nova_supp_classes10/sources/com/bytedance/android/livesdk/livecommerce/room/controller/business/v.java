package com.bytedance.android.livesdk.livecommerce.room.controller.business;

import com.bytedance.android.livesdk.livecommerce.event.g1;
import com.bytedance.android.livesdk.livecommerce.opt.ECLivePerformanceMonitor;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContext;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class v implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ RoomContextController b;

    public v(String r1, RoomContextController r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        g1 r0 = new g1("livesdk_live_list_should_open");
        String r1 = this.a;
        if (r1 != null) goto L5;
        r1 = "other";
    L5:
        r0.f("live_list_from", r1);
        r0.k();
        ECContext r2 = this.b.r();
        if (r2 == null) goto L13;
        com.bytedance.live.datacontext.i<ECLivePerformanceMonitor> r3 = r2.getEcLivePerformanceMonitor();
        if (r3 == null) goto L14;
        ECLivePerformanceMonitor r4 = (ECLivePerformanceMonitor) r3.getValue();
        if (r4 == null) goto L15;
        ECLivePerformanceMonitor.A(r4, true, null, null, 14);
        return;
    L15:
        return;
    L14:
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
}
