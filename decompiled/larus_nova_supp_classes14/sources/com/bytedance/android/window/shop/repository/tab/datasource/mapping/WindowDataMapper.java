package com.bytedance.android.window.shop.repository.tab.datasource.mapping;

import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListDTO;
import com.bytedance.android.ec.window.base.repository.dto.WindowV2ProductItemDTO;
import com.bytedance.android.window.shop.holder.factory.WindowDynamicHolderFactory;
import com.bytedance.android.window.shop.repository.dto.WindowHybridTabDataListResponseDTO;
import com.bytedance.android.window.shop.repository.dto.a1;
import com.bytedance.android.window.shop.repository.dto.b0;
import com.bytedance.android.window.shop.repository.dto.c0;
import com.bytedance.android.window.shop.repository.dto.c1;
import com.bytedance.android.window.shop.repository.dto.d1;
import com.bytedance.android.window.shop.repository.dto.f0;
import com.bytedance.android.window.shop.repository.dto.h0;
import com.bytedance.android.window.shop.repository.dto.i0;
import com.bytedance.android.window.shop.repository.dto.k;
import com.bytedance.android.window.shop.repository.dto.m0;
import com.bytedance.android.window.shop.repository.dto.n0;
import com.bytedance.android.window.shop.repository.dto.o0;
import com.bytedance.android.window.shop.repository.dto.p0;
import com.bytedance.android.window.shop.repository.dto.q0;
import com.bytedance.android.window.shop.repository.dto.s;
import com.bytedance.android.window.shop.repository.dto.t;
import com.bytedance.android.window.shop.repository.dto.u;
import com.bytedance.android.window.shop.repository.dto.u0;
import com.bytedance.android.window.shop.repository.dto.v0;
import com.bytedance.android.window.shop.repository.dto.z0;
import com.bytedance.android.window.shop.repository.tab.entity.a0;
import com.bytedance.android.window.shop.repository.tab.entity.e0;
import com.bytedance.android.window.shop.repository.tab.entity.j0;
import com.bytedance.android.window.shop.repository.tab.entity.k0;
import com.bytedance.android.window.shop.repository.tab.entity.l0;
import com.bytedance.android.window.shop.repository.tab.entity.q;
import com.bytedance.android.window.shop.repository.tab.entity.r;
import com.bytedance.android.window.shop.repository.tab.entity.v;
import com.bytedance.android.window.shop.repository.tab.entity.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class WindowDataMapper {
    public static final Map<Integer, f> a = null;
    public static final Map<Integer, f> b = null;
    public static final Map<Integer, f> c = null;
    public static final Map<Integer, f> d = null;
    public static final Map<Integer, f> e = null;
    public static final Map<Integer, f> f = null;
    public static final ConcurrentHashMap<Integer, f> g = null;
    public static final Map<Integer, Pair<Class<?>, Function1<Object, List<com.bytedance.android.window.shop.repository.tab.entity.f>>>> h = null;

    static {
        int r3 = f.c;
        a = MapsKt.mapOf(new Pair[]{TuplesKt.to(3005, f.a.a(j0.class, new WindowDataMapper$customSingleTransformers$1(k0.m))), TuplesKt.to(3002, f.a.a(r.class, new WindowDataMapper$customSingleTransformers$2(q.n))), TuplesKt.to(2503, f.a.a(l0.class, new WindowDataMapper$customSingleTransformers$3(e0.m))), TuplesKt.to(3003, f.a.a(Object.class, new WindowDataMapper$customSingleTransformers$4(z.j))), TuplesKt.to(3004, f.a.a(Object.class, new WindowDataMapper$customSingleTransformers$5(a0.j)))});
        d r11 = d.a;
        b = MapsKt.mapOf(new Pair[]{TuplesKt.to(101, f.a.a(s.class, new WindowDataMapper$productSingleTransformers$1(r11))), TuplesKt.to(103, f.a.a(s.class, new WindowDataMapper$productSingleTransformers$2(r11))), TuplesKt.to(504, f.a.a(WindowV2ProductItemDTO.class, new WindowDataMapper$productSingleTransformers$3(r11))), TuplesKt.to(505, f.a.a(com.bytedance.android.window.shop.repository.dto.l0.class, new WindowDataMapper$productSingleTransformers$4(tq3.b.k))), TuplesKt.to(501, f.a.a(c1.class, new WindowDataMapper$productSingleTransformers$5(r11))), TuplesKt.to(102, f.a.a(com.bytedance.android.window.shop.repository.dto.q.class, new WindowDataMapper$productSingleTransformers$6(r11)))});
        e r12 = e.a;
        c = MapsKt.mapOf(new Pair[]{TuplesKt.to(201, f.a.a(d1.class, new WindowDataMapper$videoSingleTransformers$1(r12))), TuplesKt.to(202, f.a.a(d1.class, new WindowDataMapper$videoSingleTransformers$2(r12))), TuplesKt.to(203, f.a.a(d1.class, new WindowDataMapper$videoSingleTransformers$3(r12))), TuplesKt.to(204, f.a.a(d1.class, new WindowDataMapper$videoSingleTransformers$4(r12))), TuplesKt.to(205, f.a.a(d1.class, new WindowDataMapper$videoSingleTransformers$5(r12))), TuplesKt.to(206, f.a.a(d1.class, new WindowDataMapper$videoSingleTransformers$6(r12))), TuplesKt.to(207, f.a.a(b0.class, new WindowDataMapper$videoSingleTransformers$7(r12))), TuplesKt.to(208, f.a.a(b0.class, new WindowDataMapper$videoSingleTransformers$8(r12))), TuplesKt.to(209, f.a.a(t.class, new WindowDataMapper$videoSingleTransformers$9(r12))), TuplesKt.to(210, f.a.a(b0.class, new WindowDataMapper$videoSingleTransformers$10(r12)))});
        c r13 = c.a;
        d = MapsKt.mapOf(new Pair[]{TuplesKt.to(303, f.a.a(m0.class, new WindowDataMapper$liveHotSingleTransformers$1(r13))), TuplesKt.to(302, f.a.a(p0.class, new WindowDataMapper$liveHotSingleTransformers$2(r13))), TuplesKt.to(301, f.a.a(com.bytedance.android.window.shop.repository.dto.h.class, new WindowDataMapper$liveHotSingleTransformers$3(r13))), TuplesKt.to(305, f.a.a(n0.class, new WindowDataMapper$liveHotSingleTransformers$4(r13))), TuplesKt.to(308, f.a.a(q0.class, new WindowDataMapper$liveHotSingleTransformers$5(r13))), TuplesKt.to(307, f.a.a(o0.class, new WindowDataMapper$liveHotSingleTransformers$6(r13))), TuplesKt.to(309, f.a.a(k.class, new WindowDataMapper$liveHotSingleTransformers$7(r13)))});
        e = MapsKt.mapOf(TuplesKt.to(402, f.a.a(u.class, new WindowDataMapper$discoverySingleTransformers$1(b.a))));
        h r14 = h.a;
        f = MapsKt.mapOf(new Pair[]{TuplesKt.to(701, f.a.a(c0.class, new WindowDataMapper$headerTransformers$1(r14))), TuplesKt.to(702, f.a.a(i0.class, new WindowDataMapper$headerTransformers$2(r14))), TuplesKt.to(703, f.a.a(h0.class, new WindowDataMapper$headerTransformers$3(r14))), TuplesKt.to(704, f.a.a(f0.class, new WindowDataMapper$headerTransformers$4(r14))), TuplesKt.to(705, f.a.a(com.bytedance.android.window.shop.repository.dto.j0.class, new WindowDataMapper$headerTransformers$5(r14))), TuplesKt.to(998, f.a.a(com.bytedance.android.window.shop.repository.dto.j0.class, new WindowDataMapper$headerTransformers$6(r14))), TuplesKt.to(999, f.a.a(Object.class, new WindowDataMapper$headerTransformers$7(r14)))});
        ConcurrentHashMap r0 = new ConcurrentHashMap();
        WindowDynamicHolderFactory.c.getClass();
        List r1 = (List) WindowDynamicHolderFactory.a.getValue();
        LinkedHashMap r6 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r1, 10)), 16));
        Iterator r2 = r1.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        Object r4 = r2.next();
        Integer r7 = (Integer) r4;
        int r8 = f.c;
        r6.put(r4, f.a.a(com.bytedance.android.window.shop.repository.tab.entity.h.b.class, new WindowDataMapper$dynamicTransformers$1$1$1(d.a)));
        goto L4
    L6:
        r0.putAll(r6);
        ConcurrentHashMap<Integer, f> r5 = new ConcurrentHashMap();
        r5.putAll(a);
        r5.putAll(b);
        r5.putAll(c);
        r5.putAll(d);
        r5.putAll(e);
        r5.putAll(f);
        r5.putAll(r0);
        g = r5;
        a r9 = a.a;
        h = MapsKt.mapOf(new Pair[]{TuplesKt.to(503, new Pair(z0.class, new WindowDataMapper$multiTransformers$1(r9))), TuplesKt.to(306, new Pair(u0.class, new WindowDataMapper$multiTransformers$2(r9)))});
    }

    public static com.bytedance.android.ec.hybrid.list.entity.k b(WindowHybridTabDataListResponseDTO r1) {
        Intrinsics.checkNotNullParameter(r1, "dto");
        if (r1.getFeed() != null) goto L7;
        return new com.bytedance.android.ec.hybrid.list.entity.k();
    L7:
        return ECHybridListDTO.a.e(ECHybridListDTO.Companion, r1.getFeed());
    }

    public static List c(List r4) {
        ArrayList r0 = new ArrayList();
        if (r4 == null) goto L18;
        Iterator r5 = r4.iterator();
    L6:
        if (r5.hasNext() == false) goto L18;
        com.bytedance.android.window.shop.repository.dto.c r1 = (com.bytedance.android.window.shop.repository.dto.c) r5.next();
        Integer r2 = r1.c();
        if (r2 == null) goto L6;
        int r3 = r2.intValue();
        if (g.a(r3) == true) goto L11;
        com.bytedance.android.window.shop.repository.tab.entity.f r6 = f(r1);
        if (r6 != null) goto L16;
        r0.addAll(g(r1));
        goto L6
    L16:
        r0.add(r6);
        goto L6
    L11:
        v r7 = e(r1, r3);
        if (r7 == null) goto L6;
        r0.add(r7);
    L18:
        return r0;
    }

    public static com.bytedance.android.window.shop.repository.tab.entity.f f(com.bytedance.android.window.shop.repository.dto.c r3) {
        Intrinsics.checkNotNullParameter(r3, "item");
        if (r3.h() == false) goto L5;
        return null;
    L5:
        f r0 = g.get(r3.c());
        if (r0 != null) goto L8;
        return null;
    L8:
        Class<?> r2 = r0.a;
        Function1<Object, com.bytedance.android.window.shop.repository.tab.entity.f> r1 = r0.b;
        Object r4 = r3.b(r2);
        if (r4 != null) goto L11;
        return null;
    L11:
        com.bytedance.android.window.shop.repository.tab.entity.f r5 = (com.bytedance.android.window.shop.repository.tab.entity.f) r1.invoke(r4);
        if (r5 == null) goto L15;
        d(r3, r5);
        return r5;
    L15:
        return null;
    }

    public static List g(com.bytedance.android.window.shop.repository.dto.c r2) {
        Intrinsics.checkNotNullParameter(r2, "item");
        if (r2.h() == true) goto L5;
        Pair<Class<?>, Function1<Object, List<com.bytedance.android.window.shop.repository.tab.entity.f>>> r0 = h.get(r2.c());
        if (r0 == null) goto L9;
        Class r1 = (Class) r0.component1();
        Function1 r3 = (Function1) r0.component2();
        Object r4 = r2.b(r1);
        if (r4 != null) goto L15;
        return CollectionsKt.emptyList();
    L15:
        return (List) r3.invoke(r4);
    L9:
        return CollectionsKt.emptyList();
    L5:
        return CollectionsKt.emptyList();
    }

    public static List a(List r5, Function1 r6) {
        Intrinsics.checkNotNullParameter(r5, "sections");
        ArrayList r0 = new ArrayList();
        Iterator r7 = r5.iterator();
    L4:
        if (r7.hasNext() == false) goto L26;
        a1 r1 = (a1) r7.next();
        List<com.bytedance.android.window.shop.repository.dto.c> r2 = r1.a();
        if (r2 == null) goto L4;
        com.bytedance.android.window.shop.repository.dto.c r3 = (com.bytedance.android.window.shop.repository.dto.c) CollectionsKt.getOrNull(r2, 0);
        if (r3 == null) goto L4;
        Integer r4 = r3.c();
        if (r4 == null) goto L4;
        int r8 = r4.intValue();
        if (r6 == null) goto L18;
        if (((Boolean) r6.invoke(r1)).booleanValue() == false) goto L4;
    L18:
        if (g.a(r8) == true) goto L19;
        com.bytedance.android.window.shop.repository.tab.entity.f r9 = f(r3);
        if (r9 != null) goto L24;
        r0.addAll(g(r3));
        goto L4
    L24:
        r9.g = r1.b();
        r0.add(r9);
        goto L4
    L19:
        v r10 = e(r3, r8);
        if (r10 == null) goto L4;
        r10.g = r1.b();
        r0.add(r10);
        goto L4
    L26:
        return r0;
    }

    public static void d(com.bytedance.android.window.shop.repository.dto.c r2, com.bytedance.android.window.shop.repository.tab.entity.f r3) {
        Intrinsics.checkNotNullParameter(r2, "dtoItem");
        Intrinsics.checkNotNullParameter(r3, "vo");
        Integer r0 = r2.a();
        if (r0 != null) goto L5;
        Integer r1 = null;
    L6:
        r3.b = r1;
        r3.c = r2.g();
        r3.d = r2.f();
        Map<String, String> r4 = r2.e();
        if ((!r4.isEmpty()) == false) goto L9;
        Intrinsics.checkNotNullParameter(r3, "$this$saveInsertRequestKey");
        Intrinsics.checkNotNullParameter(r4, "requestParams");
        r3.f.d(com.bytedance.android.window.shop.repository.tab.entity.m0.a, r4);
    L9:
        r3.d();
        return;
    L5:
        r1 = Integer.valueOf(r0.intValue() + 1);
        goto L6
    }

    public static v e(com.bytedance.android.window.shop.repository.dto.c r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "item");
        v0 r0 = (v0) r3.b(v0.class);
        if (r0 != null) goto L6;
        return null;
    L6:
        if (r0.e() == true) goto L8;
        return null;
    L8:
        int r2 = v.n;
        v r5 = v.a.a(r0, r4);
        if (r5 == null) goto L12;
        d(r3, r5);
        return r5;
    L12:
        return null;
    }
}
