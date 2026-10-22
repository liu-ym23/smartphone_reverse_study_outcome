package com.lynx.tasm;

import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.TraceEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes32.dex */
public final class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f383326a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f383327b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f383328c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList<e0> f383329d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ArrayList<r0> f383330e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.lynx.tasm.base.e<f0> f383331f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f383332g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f383333h;

    public final void a(LynxMemoryCollectionStatus r110) {
        if (this.f383333h == false) goto L5;
        return;
    L5:
        TraceEvent.beginSection("GlobalMemoryUsage.finish");
        this.f383333h = true;
        n0 r100 = n0.f383491c;
        long r101 = System.currentTimeMillis();
        long r102 = this.f383326a;
        long r103 = r101 - r102;
        p0 r104 = p0.a(r102, r110, r103, this.f383327b, this.f383328c, n0.a(), this.f383330e);
        if (TraceEvent.isTracingStarted() == false) goto L8;
        HashMap r105 = new HashMap();
        r105.put("status", r110.name());
        r105.put("duration_ms", String.valueOf(r103));
        r105.put("expected_instances", String.valueOf(this.f383328c));
        r105.put("completed_fetchers", String.valueOf(this.f383332g));
        TraceEvent.instant(0, "GlobalMemoryUsage.total", r105);
    L8:
        ArrayList r111 = new ArrayList(this.f383329d);
        this.f383329d.clear();
        com.lynx.tasm.base.e<f0> r106 = this.f383331f;
        this.f383331f = null;
        if (r106 == null) goto L11;
        r106.accept(this);
    L11:
        Iterator r112 = r111.iterator();
    L13:
        if (r112.hasNext() == false) goto L15;
        b((e0) r112.next(), r104);
        goto L13
    L15:
        TraceEvent.endSection("GlobalMemoryUsage.finish");
    }

    public static void b(e0 r100, p0 r101) {
        r100.onResult(r101);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        LLog.e("LynxMemoryUsageContext", "Failed to deliver Lynx memory usage result: " + th.getMessage());
    }

    public f0(long r100, long r101, int r102, e0 r103) {
        ArrayList<e0> r104 = new ArrayList();
        this.f383329d = r104;
        this.f383330e = new ArrayList();
        this.f383326a = r100;
        this.f383327b = r101;
        this.f383328c = r102;
        if (this.f383333h == true) goto L8;
        if (r103 == null) goto L9;
        r104.add(r103);
        return;
    L9:
        return;
    }
}
