package com.bytedance.kmp.performance.reporter;

import com.bytedance.kmp.performance.platform.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import md6.a0;
import md6.a1;
import md6.b0;
import md6.b1;
import md6.c0;
import md6.c1;
import md6.d0;
import md6.d1;
import md6.e0;
import md6.f0;
import md6.f1;
import md6.g0;
import md6.h0;
import md6.h1;
import md6.i;
import md6.i0;
import md6.j0;
import md6.k;
import md6.k0;
import md6.l;
import md6.l0;
import md6.m;
import md6.m0;
import md6.n;
import md6.n0;
import md6.n1;
import md6.o;
import md6.o0;
import md6.p;
import md6.p0;
import md6.q;
import md6.q0;
import md6.r;
import md6.r0;
import md6.s;
import md6.s0;
import md6.t;
import md6.t0;
import md6.u;
import md6.u0;
import md6.v;
import md6.v0;
import md6.w0;
import md6.x;
import md6.x0;
import md6.y;
import md6.y0;
import md6.z;
import md6.z0;

/* JADX INFO: loaded from: classes19.dex */
public final class SimpleKPerfReporter implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function2<String, Map<String, String>, Map<String, String>> f252833a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function2<String, String, Unit> f252834b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Job f252835c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f252836d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CoroutineScope f252837e;

    public SimpleKPerfReporter(a r100) {
        Intrinsics.checkNotNullParameter(r100, "reporter");
        this.f252833a = null;
        this.f252834b = r100;
        this.f252836d = 1000;
        this.f252837e = CoroutineScopeKt.MainScope();
    }

    @Override // com.bytedance.kmp.performance.reporter.c
    public final void a(n1 r110) {
        Intrinsics.checkNotNullParameter(r110, "data");
        List<d1> r100 = r110.f513391b0;
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L3:
        boolean r103 = true;
        int r104 = 0;
        if (r102.hasNext() == false) goto L13;
        Object r105 = r102.next();
        d1 r106 = (d1) r105;
        double r107 = 1000000.0d / ((double) r106.f513298e);
        int r108 = w.f252811a;
        long r109 = (long) (r107 * ((double) 0.0f));
        if (r106.f513296c <= r109) goto L8;
    L11:
        if (r103 == false) goto L3;
        r101.add(r105);
        goto L3
    L8:
        if (r106.f513297d > r109) goto L11;
        r103 = false;
        goto L11
    L13:
        Intrinsics.checkNotNullParameter(r101, "arr");
        if (r101.isEmpty() == true) goto L37;
        if (r101.isEmpty() == true) goto L35;
        ArrayList r111 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator r112 = r101.iterator();
    L21:
        if (r112.hasNext() == false) goto L23;
        d1 r113 = (d1) r112.next();
        Intrinsics.checkNotNullParameter(r113, "it");
        r111.add(Integer.valueOf(r113.f513298e));
        goto L21
    L23:
        ArrayList r114 = new ArrayList();
        Iterator r115 = r111.iterator();
    L25:
        if (r115.hasNext() == false) goto L33;
        Object r116 = r115.next();
        if (((Number) r116).intValue() <= 0) goto L29;
        boolean r117 = true;
    L30:
        if (r117 == false) goto L25;
        r114.add(r116);
        goto L25
    L29:
        r117 = false;
        goto L30
    L33:
        if ((!r114.isEmpty()) == false) goto L35;
        r104 = (int) CollectionsKt.averageOfInt(r114);
    L35:
        r110.f513298e = r104;
        r110.f513296c = i.a(r101, new l());
        r110.f513297d = i.a(r101, new x());
        r110.f513299f = i.a(r101, new j0());
        r110.f513300g = i.b(r101, new r0());
        r110.f513301h = i.b(r101, new s0());
        r110.f513302i = i.a(r101, new t0());
        r110.f513303j = i.a(r101, new u0());
        r110.f513304k = i.a(r101, new v0());
        r110.f513305l = i.a(r101, new w0());
        r110.f513306m = i.a(r101, new u());
        r110.f513307n = i.b(r101, new f0());
        r110.f513311r = i.a(r101, new q0());
        r110.f513312s = i.a(r101, new x0());
        r110.f513313t = i.a(r101, new y0());
        r110.f513314u = i.a(r101, new z0());
        r110.f513315v = i.a(r101, new a1());
        r110.f513316w = i.a(r101, new b1());
        r110.f513317x = i.a(r101, new c1());
        r110.f513318y = i.b(r101, new k());
        r110.f513319z = i.b(r101, new m());
        r110.A = i.b(r101, new n());
        r110.B = i.b(r101, new o());
        r110.C = i.b(r101, new p());
        r110.D = i.b(r101, new q());
        r110.E = i.b(r101, new r());
        r110.F = i.a(r101, new s());
        r110.G = i.a(r101, new t());
        r110.H = i.a(r101, new v());
        r110.I = i.a(r101, new md6.w());
        r110.f513293J = i.b(r101, new y());
        r110.K = i.a(r101, new z());
        r110.L = i.b(r101, new a0());
        r110.M = i.a(r101, new b0());
        r110.N = i.b(r101, new c0());
        r110.O = i.a(r101, new d0());
        r110.P = i.b(r101, new e0());
        r110.Q = i.b(r101, new g0());
        r110.R = i.a(r101, new h0());
        r110.S = i.a(r101, new i0());
        r110.T = i.a(r101, new k0());
        r110.U = i.a(r101, new l0());
        r110.W = i.a(r101, new m0());
        r110.X = i.b(r101, new n0());
        r110.V = i.a(r101, new o0());
        r110.Y = i.a(r101, new p0());
        r110.d();
    L37:
        if (r110.f513393d0 <= 2) goto L51;
        BuildersKt.launch$default(this.f252837e, null, null, new SimpleKPerfReporter$reportScrollPerformance$$inlined$launchPerformanceReport$1(r110, this, "kmp_compose_scroll_performance", null), 3, null);
        return;
    }

    @Override // com.bytedance.kmp.performance.reporter.c
    public final void b(h1 r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        BuildersKt.launch$default(this.f252837e, null, null, new SimpleKPerfReporter$reportFirstFrame$$inlined$launchPerformanceReport$1(r100, this, "kmp_compose_first_frame_duration", null), 3, null);
    }

    @Override // com.bytedance.kmp.performance.reporter.c
    public final void c(f1 r110) {
        Intrinsics.checkNotNullParameter(r110, "data");
        Job r100 = this.f252835c;
        if (r100 == null) goto L5;
        Job.DefaultImpls.cancel$default(r100, null, 1, null);
    L5:
        this.f252835c = BuildersKt.launch$default(this.f252837e, null, null, new SimpleKPerfReporter$reportMemoryInfoDebounced$1(this, r110, null), 3, null);
    }

    @Override // com.bytedance.kmp.performance.reporter.c
    public final void d(h1 r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        BuildersKt.launch$default(this.f252837e, null, null, new SimpleKPerfReporter$reportUpdateFrame$$inlined$launchPerformanceReport$1(r100, this, "kmp_compose_update_duration", null), 3, null);
    }

    public static final void e(SimpleKPerfReporter r100, md6.c r101, String r102) {
        Function2<String, Map<String, String>, Map<String, String>> r103 = r100.f252833a;
        if (r103 == null) goto L6;
        Map<String, String> r104 = r103.invoke(r102, r101.a());
        if (r104 == null) goto L6;
    L7:
        r101.b(r104);
        return;
    L6:
        r104 = r101.a();
        goto L7
    }
}
