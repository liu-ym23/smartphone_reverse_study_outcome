package com.bytedance.bdp.appbase.base.bdptask;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.concurrent.PriorityBlockingQueue;

/* JADX INFO: loaded from: classes11.dex */
public final class e extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BdpPoolExecutor f200495a;

    @Override // android.os.Handler
    public final void handleMessage(Message r100) {
        b r101 = (b) ((PriorityBlockingQueue) this.f200495a.f200425g).poll();
        if (r101 != null) goto L5;
        return;
    L5:
        BdpTask r102 = r101.f200485e;
        if (r102 == null) goto L39;
        if (this.f200495a.b(r102) == false) goto L40;
        return;
    L40:
        Thread.interrupted();     // Catch: Throwable -> L30
        this.f200495a.f200421c.set(r102);     // Catch: Throwable -> L30
        if (BdpTrace.ENABLE == false) goto L24;
        k.f200515b.set(r101.f200488h);     // Catch: Throwable -> L30
        String r103 = "";
        if (r101.f200488h.size() <= 0) goto L18;
        TracePoint r104 = r101.f200488h.getFirst();     // Catch: Throwable -> L30
        if (r104.event != 3) goto L18;
        String r105 = r104.getEventKey();     // Catch: Throwable -> L30
    L19:
        String r106 = String.valueOf(BdpTask.TaskType.LOGIC);     // Catch: Throwable -> L30
        String r107 = r102.trace;     // Catch: Throwable -> L30
        if (r107 == null) goto L23;
        r103 = r107;
    L23:
        TracePoint r108 = new TracePoint(r103, r105 + '#' + r106, 1);     // Catch: Throwable -> L30
        k.d(r108);     // Catch: Throwable -> L30
        k.b(r101.f200488h, r108);     // Catch: Throwable -> L30
    L18:
        r105 = "";
    L24:
        r101.run();     // Catch: Throwable -> L30
        if (BdpTrace.ENABLE == false) goto L28;
        k.e();
        k.f200515b.remove();
    L28:
        this.f200495a.f200421c.remove();
        Thread.interrupted();
        this.f200495a.a(r102);
        return;
    L30:
        th = move-exception;
        throw th;     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        if (BdpTrace.ENABLE == false) goto L36;
        k.e();
        k.f200515b.remove();
    L36:
        this.f200495a.f200421c.remove();
        Thread.interrupted();
        this.f200495a.a(r102);
        throw th;
    L39:
        throw new IllegalArgumentException("BdpTask can not be null!!!");
    }

    public e(BdpPoolExecutor r100, Looper r101) {
        this.f200495a = r100;
        super(r101);
    }
}
