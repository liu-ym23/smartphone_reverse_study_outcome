package tt3;

import com.bytedance.apm6.cpu.collect.CpuCacheItem;
import com.bytedance.apm6.cpu.collect.b;
import com.bytedance.monitor.collector.c;
import com.larus.apm.impl.protector.RunnableProtector;
import cv3.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d extends a {
    public final /* synthetic */ b d;

    public final void a() {
        if (com.bytedance.apm.d.j() == false) goto L5;
        av3.b.a("APM-CPU", "run: " + this.d.d);
    L5:
        b r0 = this.d;
        boolean r2 = c.a.a.b();
        ut3.a r3 = r0.h;
        if (r2 == false) goto L8;
        long r4 = r3.c;
    L9:
        r0.d = r4 * 1000;
        if (r2 == false) goto L12;
        long r5 = r3.f;
    L13:
        r0.e = r5 * 1000;
        b r1 = this.d;
        if (r1.j == true) goto L65;
        long r6 = System.currentTimeMillis();
        if ((r6 - r1.f) < r1.d) goto L64;
        r1.f = r6;
        int r7 = com.bytedance.apm.util.b.b();
        if (r7 <= 0) goto L64;
        long r8 = c.e().a();
        long r9 = c.e().d(r7);
        Thread.sleep(360);     // Catch: InterruptedException -> L24
        boolean r10 = false;
    L25:
        if (r10 == true) goto L64;
        long r11 = c.e().a();
        long r12 = c.e().d(r7) - r9;
        if (r12 <= 0) goto L30;
        double r13 = (r11 - r8) / r12;
    L31:
        double r14 = (r11 - r8) * 1000.0d;
        double r15 = (r14 / (System.currentTimeMillis() - r6)) / com.bytedance.apm.util.b.f();
        if (com.bytedance.apm.d.j() == false) goto L35;
        av3.b.a("APM-CPU", String.valueOf(r14) + " " + (System.currentTimeMillis() - r6) + " " + com.bytedance.apm.util.b.f());
    L35:
        if (com.bytedance.apm.d.j() == false) goto L67;
        av3.b.a("APM-CPU", "collect cpu data, rate: " + r13 + " speed: " + r15);
    L67:
        r1.i.d.a();     // Catch: Throwable -> L39
        aq7.c.a r16 = r1.i.b();     // Catch: Throwable -> L39
    L41:
        if (r1.a.a.get() == false) goto L63;
        com.bytedance.apm6.cpu.collect.a r17 = r1.a;
        if (r17.a.get() == false) goto L59;
        String r18 = ou3.a.a().e();
        if (xu3.a.a() == false) goto L49;
        av3.b.a("APM-CPU", r18);
    L49:
        monitor-enter(com.bytedance.apm6.cpu.collect.a.class);
    L60:
        th = move-exception;
        throw th;
    L51:
        if (c.a.a.b() == false) goto L53;
        CpuCacheItem.CpuDataType r19 = CpuCacheItem.CpuDataType.FRONT;     // Catch: Throwable -> L60
    L54:
        CpuCacheItem.CpuDataType r110 = r19;
        CpuCacheItem r111 = com.bytedance.apm6.cpu.collect.a.d(r110, r17.c(r110, r18), r13, r15);     // Catch: Throwable -> L60
        r17.a(r110, r18, r111);     // Catch: Throwable -> L60
        if (xu3.a.a() == false) goto L57;
        av3.b.a("APM-CPU", "after add cache data: " + r111);     // Catch: Throwable -> L60
    L57:
        CpuCacheItem.CpuDataType r20 = CpuCacheItem.CpuDataType.MIX;     // Catch: Throwable -> L60
        r17.a(r20, r18, com.bytedance.apm6.cpu.collect.a.d(r20, r17.c(r20, r18), r13, r15));     // Catch: Throwable -> L60
        monitor-exit(com.bytedance.apm6.cpu.collect.a.class);     // Catch: Throwable -> L60
        goto L59
    L53:
        r19 = CpuCacheItem.CpuDataType.BACK;     // Catch: Throwable -> L60
    L59:
        r1.a.e(r16);
    L63:
        xt3.a r21 = xt3.a.C0186a.a;
        r21.a = r13;
        r21.b = r15;
        c.a.a.getClass();
    L39:
        r16 = null;
        goto L41
    L30:
        r13 = -1.0d;
    L24:
        r10 = true;
    L64:
        b.a(this.d);
    L65:
        this.d.j = false;
        return;
    L12:
        r5 = r3.g;
        goto L13
    L8:
        r4 = r3.d;
        goto L9
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

    public d(b r3) {
        this.d = r3;
        super(30000, 30000);
    }
}
