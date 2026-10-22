package com.bytedance.ee.bear.bitable.statistic.inner;

import android.os.Process;
import com.bytedance.ee.bear.bitable.jsapi.SettingsBitableConfig;
import com.bytedance.ee.bear.bitable.statistic.BitableTraceType;
import com.bytedance.ee.bear.bitable.statistic.f;
import com.bytedance.ee.bear.bitable.statistic.g;
import com.bytedance.ee.bear.bitable.statistic.k;
import com.bytedance.ee.bear.document.offline.file.upload.UploadResult;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.appsetting.api.SettingManager;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b extends BitableInnerTrace implements g {
    public final e k;
    public final lu4.a l;
    public final List<k> m;
    public ScheduledFuture<?> n;
    public final RunnableC0024b o;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.bitable.statistic.inner.b$b, reason: collision with other inner class name */
    public static final class RunnableC0024b implements Runnable {
        public final /* synthetic */ b a;
        public final /* synthetic */ String b;

        public RunnableC0024b(b r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            this.a.getClass();
            int r1 = bv4.a.b;
            int r2 = Process.myPid();
            long r3 = System.currentTimeMillis();
            bv4.b r8 = null;
            if ((r3 - bv4.a.a) >= 1000) goto L5;
            tt5.a.k("BitableCpuUtils", "getPidCpuRate(" + r2 + "), too frequently");
        L20:
            this.a.getClass();
            long r4 = eu5.g.b(Process.myPid());
            tt5.a.h("BitableProcessTracer", "task traceId: " + this.b + " memoryInfo: " + r4 + ", cpuInfo: " + r8);
            b r5 = this.a;
            Iterator r6 = ((CopyOnWriteArrayList) r5.m).iterator();
        L22:
            if (r6.hasNext() == false) goto L24;
            k r7 = (k) r6.next();
            r5.l.getClass();
            r7.a(r8, r4);
            goto L22
        L24:
            this.a.o();
            return;
        L5:
            bv4.a.a = r3;
            int r9 = com.bytedance.apm.util.b.b();
            if (r9 > 0) goto L8;
            tt5.a.k("BitableCpuUtils", "CommonMonitorUtil.getCpuCoreNum() is null");
            r9 = Runtime.getRuntime().availableProcessors();
        L8:
            if (r9 > 0) goto L10;
            tt5.a.k("BitableCpuUtils", "cpuNum is null");
            Integer r10 = null;
        L11:
            if (r10 == null) goto L20;
            int r11 = r10.intValue();
            long r12 = com.bytedance.apm.util.b.d(r2);
            long r13 = com.bytedance.monitor.collector.c.e().d(r11);
            Thread.sleep(360);     // Catch: Throwable -> L26 InterruptedException -> L15
        L15:
            boolean r14 = true;
        L16:
            if (r14 == true) goto L20;
            long r16 = com.bytedance.apm.util.b.d(r2);
            long r17 = com.bytedance.monitor.collector.c.e().d(r11);
            double r0 = ((r16 - r12) * 1.0f) / (r17 - r13);
            tt5.a.h("BitableCpuUtils", "pidCpuRate -> appCpuRate=" + r0 + ". appCpuStat2=" + r16 + " appCpuStat=" + r12 + " totalCpuStat2=" + r17 + " totalCpuStat=" + r13);
            double r18 = (((((double) r16) - ((double) r12)) * ((double) UploadResult.UPLOAD_CACELL)) / ((double) (System.currentTimeMillis() - r3))) / ((double) com.bytedance.apm.util.b.f());
            StringBuilder r19 = new StringBuilder("pidCpuSpeed -> ");
            r19.append(r18);
            tt5.a.h("BitableCpuUtils", r19.toString());
            r8 = new bv4.b(Integer.valueOf(r2), Double.valueOf(r0), Double.valueOf(r18), r11);
        L14:
            r14 = false;
            goto L16
        L10:
            r10 = Integer.valueOf(r9);
            goto L11
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

    static {
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.inner.BitableInnerTrace, com.bytedance.ee.bear.bitable.statistic.n
    public /* bridge */ /* synthetic */ BitableTraceType getType() {
        return f.a(this);
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.g
    public final void e() {
        Iterator<T> r0 = this.m.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((k) r0.next()).e();
        goto L4
    L6:
        o();
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.inner.BitableInnerTrace
    public final void m() {
        ((CopyOnWriteArrayList) this.m).clear();
        o();
    }

    public final boolean n() {
        Iterator<T> r0 = this.m.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        if (((k) r1).c() == false) goto L4;
    L9:
        if (r1 == null) goto L11;
        return true;
    L11:
        return false;
    L8:
        r1 = null;
        goto L9
    }

    public final void o() {
        if (this.n != null) goto L5;
        return;
    L5:
        if (n() == true) goto L18;
        tt5.a.h("BitableProcessTracer", "stopMonitorTask traceId: " + this.a);
        ScheduledFuture<?> r0 = this.n;     // Catch: Exception -> L11
        if (r0 == null) goto L13;
        r0.cancel(true);     // Catch: Exception -> L11
    L13:
        this.n = null;
        return;
    L11:
        e = move-exception;
        tt5.a.e("BitableProcessTracer", "tryStopMonitorTask: ", e, false);
        goto L13
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.g
    public final void a(long r8) {
        Iterator r9 = ((CopyOnWriteArrayList) this.m).iterator();
    L4:
        if (r9.hasNext() == false) goto L7;
        ((k) r9.next()).d();
        goto L4
    L7:
        if (this.n == null) goto L9;
        return;
    L9:
        if (n() == false) goto L14;
        this.l.getClass();
        tt5.a.h("BitableProcessTracer", "startMonitorTask traceId: " + this.a);
        ScheduledExecutorService r0 = CoreThreadPool.getDefault().getScheduleThreadPool();
        RunnableC0024b r1 = this.o;
        this.l.getClass();
        this.n = r0.scheduleWithFixedDelay(r1, 0, 2, TimeUnit.SECONDS);
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.g
    public final void i(k r2) {
        Intrinsics.checkNotNullParameter(r2, "consumer");
        r2.b(this.k.getLogger(), this);
        ((CopyOnWriteArrayList) this.m).add(r2);
    }

    public b(String r2, e r3) {
        Intrinsics.checkNotNullParameter(r3, "mTraceProvider");
        super(r2, r3);
        this.k = r3;
        SettingsBitableConfig r4 = (SettingsBitableConfig) SettingManager.getInstance().get(SettingsBitableConfig.class);
        if (r4 != null) goto L5;
        r4 = new SettingsBitableConfig();
    L5:
        this.l = r4.f();
        this.m = new CopyOnWriteArrayList();
        this.o = new RunnableC0024b(this, r2);
    }
}
