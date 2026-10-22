package com.bytedance.ee.bear.bitable.statistic.inner;

import com.bytedance.ee.bear.bitable.statistic.BitableStatisticConstant$Debug;
import com.bytedance.ee.bear.bitable.statistic.BitableStatisticEventModel$NormalPointModel;
import com.bytedance.ee.bear.bitable.statistic.business.openfile.main.IJSONObjectAdapter;
import com.bytedance.ee.bear.bitable.statistic.common.DefaultBitableStatisticPerformanceConsumer;
import com.bytedance.ee.bear.bitable.statistic.common.f;
import com.bytedance.ee.bear.bitable.statistic.config.BitablePerformanceFgKey;
import com.bytedance.ee.bear.bitable.statistic.g;
import com.bytedance.ee.bear.bitable.statistic.h;
import com.bytedance.ee.bear.bitable.statistic.i;
import com.bytedance.ee.bear.bitable.statistic.j;
import com.bytedance.ee.bear.bitable.statistic.k;
import com.bytedance.ee.bear.bitable.statistic.m;
import com.bytedance.ee.bear.bitable.statistic.n;
import com.larksuite.framework.utils.l0;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.ExceptionsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class BitableStatisticServiceReal implements m, i, e {
    public final Map<String, Serializable> a;
    public final Map<String, BitableInnerTrace> b;
    public final Lazy c;
    public final Lazy d;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.inner.e
    public final BitableStatisticServiceReal getLogger() {
        return this;
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.m
    public final void stopAllTrace() {
        Iterator r0 = ((ConcurrentHashMap) this.b).values().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((BitableInnerTrace) r0.next()).b(Boolean.FALSE);
        goto L4
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.inner.e
    public final String b() {
        String r0 = l0.a().toString();
        if (((ConcurrentHashMap) this.b).containsKey(r0) == true) goto L5;
        return r0;
    L5:
        return b();
    }

    public BitableStatisticServiceReal(Lazy<? extends xw4.a> r2) {
        Intrinsics.checkNotNullParameter(r2, "appLogger");
        this.a = new ConcurrentHashMap();
        this.b = new ConcurrentHashMap();
        this.c = LazyKt.lazy(BitableStatisticServiceReal$fgKeys$2.INSTANCE);
        this.d = r2;
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.inner.e
    public final void c(String r2) {
        Intrinsics.checkNotNullParameter(r2, "traceId");
        ((ConcurrentHashMap) this.b).remove(r2);
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.m
    public final com.bytedance.ee.bear.bitable.statistic.c createFpsTrace(String r3) {
        BitableFpsTracer r0 = new BitableFpsTracer(r3, this);
        Map<String, BitableInnerTrace> r4 = this.b;
        ConcurrentHashMap r5 = (ConcurrentHashMap) r4;
        r5.put(r0.h, r0);
        return r0;
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.m
    public final String createNormalTrace(String r3) {
        BitableNormalTrace r0 = new BitableNormalTrace(r3, this);
        Map<String, BitableInnerTrace> r4 = this.b;
        ConcurrentHashMap r5 = (ConcurrentHashMap) r4;
        r5.put(r0.h, r0);
        return r0.h;
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.m
    public final g createProcessTrace(String r3) {
        b r0 = new b(r3, this);
        Map<String, BitableInnerTrace> r4 = this.b;
        ConcurrentHashMap r5 = (ConcurrentHashMap) r4;
        r5.put(r0.h, r0);
        return r0;
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.m
    public final void removeAllConsumer(String r3) {
        Intrinsics.checkNotNullParameter(r3, "traceId");
        BitableInnerTrace r4 = a(r3, BitableInnerTrace.class, false);
        if (r4 == null) goto L6;
        r4.m();
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.m
    public final void addFpsConsumer(String r3, h r4) {
        Intrinsics.checkNotNullParameter(r3, "traceId");
        Intrinsics.checkNotNullParameter(r4, "consumer");
        BitableFpsTracer r5 = (BitableFpsTracer) a(r3, BitableFpsTracer.class, false);
        if (r5 == null) goto L6;
        r5.d(r4);
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.m
    public final void addNormalConsumer(String r4, j r5) {
        Intrinsics.checkNotNullParameter(r4, "traceId");
        Intrinsics.checkNotNullParameter(r5, "consumer");
        BitableNormalTrace r6 = (BitableNormalTrace) a(r4, BitableNormalTrace.class, false);
        if (r6 == null) goto L6;
        Intrinsics.checkNotNullParameter(r5, "consumer");
        ((CopyOnWriteArrayList) r6.o).add(r5);
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.m
    public final void addNormalPoint(String r4, BitableStatisticEventModel$NormalPointModel r5) {
        Intrinsics.checkNotNullParameter(r4, "traceId");
        Intrinsics.checkNotNullParameter(r5, "point");
        BitableNormalTrace r6 = (BitableNormalTrace) a(r4, BitableNormalTrace.class, false);
        if (r6 == null) goto L6;
        Intrinsics.checkNotNullParameter(r5, "point");
        r6.f.set(true);
        r6.l().post(new com.bytedance.ee.bear.bitable.statistic.inner.a(r6, r5));
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.m
    public final void addProcessConsumer(String r3, k r4) {
        Intrinsics.checkNotNullParameter(r3, "traceId");
        Intrinsics.checkNotNullParameter(r4, "consumer");
        b r5 = (b) a(r3, b.class, false);
        if (r5 == null) goto L6;
        r5.i(r4);
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.m
    public final String createDefaultNormalTrace(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "eventName");
        String r4 = createNormalTrace(r3);
        addNormalConsumer(r4, new DefaultBitableStatisticPerformanceConsumer(r2));
        return r4;
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.m
    public final void removeFpsConsumer(String r4, h r5) {
        Intrinsics.checkNotNullParameter(r4, "traceId");
        Intrinsics.checkNotNullParameter(r5, "consumer");
        BitableFpsTracer r6 = (BitableFpsTracer) a(r4, BitableFpsTracer.class, false);
        if (r6 == null) goto L6;
        Intrinsics.checkNotNullParameter(r5, "consumer");
        ((CopyOnWriteArrayList) r6.q).remove(r5);
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.m
    public final void removeNormalConsumer(String r4, j r5) {
        Intrinsics.checkNotNullParameter(r4, "traceId");
        Intrinsics.checkNotNullParameter(r5, "consumer");
        BitableNormalTrace r6 = (BitableNormalTrace) a(r4, BitableNormalTrace.class, false);
        if (r6 == null) goto L6;
        Intrinsics.checkNotNullParameter(r5, "consumer");
        ((CopyOnWriteArrayList) r6.o).remove(r5);
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.m
    public final void removeProcessConsumer(String r4, k r5) {
        Intrinsics.checkNotNullParameter(r4, "traceId");
        Intrinsics.checkNotNullParameter(r5, "consumer");
        b r6 = (b) a(r4, b.class, false);
        if (r6 == null) goto L6;
        Intrinsics.checkNotNullParameter(r5, "consumer");
        ((CopyOnWriteArrayList) r6.m).remove(r5);
        r6.o();
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.m
    public final void setCommonParams(String r2, Serializable r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        if (r3 != null) goto L5;
        ((ConcurrentHashMap) this.a).remove(r2);
        return;
    L5:
        ((ConcurrentHashMap) this.a).put(r2, r3);
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.m
    public final void stopTrace(String r4, Boolean r5) {
        Intrinsics.checkNotNullParameter(r4, "traceId");
        int r0 = com.bytedance.ee.bear.bitable.statistic.common.e.a;
        tt5.a.h("BitableStatistic", "StatisticServiceImpl " + ("stopTrace " + r4 + " includeChildren:" + r5));
        BitableInnerTrace r6 = a(r4, BitableInnerTrace.class, false);
        if (r6 == null) goto L6;
        r6.b(r5);
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.inner.e
    public final BitableInnerTrace a(String r5, Class r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r5, "traceId");
        Intrinsics.checkNotNullParameter(r6, "clazz");
        BitableInnerTrace r0 = (BitableInnerTrace) ((ConcurrentHashMap) this.b).get(r5);
        if (r0 != null) goto L6;
        int r8 = com.bytedance.ee.bear.bitable.statistic.common.e.a;
        com.bytedance.ee.bear.bitable.statistic.common.e.c("StatisticServiceImpl", "could not find trace " + r5 + ' ' + ExceptionsKt.stackTraceToString(new Throwable()));
        return null;
    L6:
        if (r7 == true) goto L12;
        if (r0.i == false) goto L12;
        int r9 = com.bytedance.ee.bear.bitable.statistic.common.e.a;
        tt5.a.h("BitableStatistic", "StatisticServiceImpl " + ("trace is stop " + r5));
        return null;
    L12:
        if (r6.isInstance(r0) == true) goto L15;
        int r10 = com.bytedance.ee.bear.bitable.statistic.common.e.a;
        com.bytedance.ee.bear.bitable.statistic.common.e.c("StatisticServiceImpl", "trace type not match " + r0 + ' ' + r6);
        return null;
    L15:
        return r0;
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.m
    public final void addTraceExtra(String r3, String r4, Serializable r5) {
        Intrinsics.checkNotNullParameter(r3, "traceId");
        Intrinsics.checkNotNullParameter(r4, "key");
        BitableInnerTrace r6 = a(r3, BitableInnerTrace.class, false);
        if (r6 == null) goto L10;
        Map<String, Serializable> r7 = r6.d;
        if (r7 == null) goto L11;
        if (r5 != null) goto L8;
        ((ConcurrentHashMap) r7).remove(r4);
        return;
    L8:
        ((ConcurrentHashMap) r7).put(r4, r5);
        return;
    L11:
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.m
    public final void appendTraceExtraIfNotExist(String r3, String r4, Serializable r5) {
        Intrinsics.checkNotNullParameter(r3, "traceId");
        Intrinsics.checkNotNullParameter(r4, "key");
        if (r5 != null) goto L5;
        return;
    L5:
        BitableInnerTrace r6 = a(r3, BitableInnerTrace.class, false);
        if (r6 == null) goto L13;
        Map<String, Serializable> r7 = r6.d;
        if (r7 == null) goto L14;
        ConcurrentHashMap r8 = (ConcurrentHashMap) r7;
        if (r8.get(r4) != null) goto L15;
        r8.put(r4, r5);
        return;
    L15:
        return;
    L14:
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.i
    public final void d(n r2, String r3, Map<String, ? extends Serializable> r4) {
        Intrinsics.checkNotNullParameter(r2, "trace");
        Intrinsics.checkNotNullParameter(r3, "eventName");
        Intrinsics.checkNotNullParameter(r4, "params");
        e(r2, r3, new JSONObject(mu5.b.e(r4)));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        tt5.a.e("StatisticServiceImpl", "sendEvent parse jsonObject error", e, false);
    }

    public final void e(n r7, String r8, JSONObject r9) {
        Intrinsics.checkNotNullParameter(r7, "trace");
        Intrinsics.checkNotNullParameter(r8, "eventName");
        Intrinsics.checkNotNullParameter(r9, "jsonObject");
        Iterator<Map.Entry<String, Serializable>> r0 = r7.c(true).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        Map.Entry<String, Serializable> r1 = r0.next();
        Object r2 = (Serializable) r1.getValue();
        if ((r2 instanceof IJSONObjectAdapter) == true) goto L7;
        r9.put(r1.getKey(), r2);
        goto L4
    L7:
        r9.put(r1.getKey(), ((IJSONObjectAdapter) r2).convertToOrgJSONObject());
        goto L4
    L9:
        r9.put("trace_id", r7.getTraceId());
        String[] r3 = (String[]) ((BitablePerformanceFgKey) this.c.getValue()).get(r8);
        if (r3 == null) goto L14;
        LinkedHashMap r4 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(r3.length), 16));
        int r5 = r3.length;
        int r6 = 0;
    L12:
        if (r6 >= r5) goto L15;
        String r10 = r3[r6];
        int r11 = com.bytedance.ee.bear.bitable.core.usercomponent.d.a;
        Intrinsics.checkNotNullParameter(r10, "key");
        r4.put(r10, Integer.valueOf(com.bytedance.ee.bear.bitable.core.usercomponent.b.d(r10) ? 1 : 0));
        r6 = r6 + 1;
    L15:
        r9.put("fg", r4);
        int r12 = com.bytedance.ee.bear.bitable.statistic.common.e.a;
        String r13 = "SendEvent " + r8 + ' ' + r9;
        if (((Boolean) BitableStatisticConstant$Debug.a.getValue()).booleanValue() == false) goto L18;
        tt5.a.h("BitableStatistic", "StatisticServiceImpl " + r13);
    L18:
        r9.put("parent_trace_id", r7.h());
        ((xw4.a) this.d.getValue()).sendEvent(r8, r9);
        return;
    L14:
        r4 = null;
        goto L15
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.m
    public final void reportError(String r2, String r3, JSONObject r4) {
        Intrinsics.checkNotNullParameter(r2, "traceId");
        Intrinsics.checkNotNullParameter(r3, "eventName");
        Intrinsics.checkNotNullParameter(r4, "jsonObject");
        int r5 = com.bytedance.ee.bear.bitable.statistic.common.e.a;
        com.bytedance.ee.bear.bitable.statistic.common.e.e("StatisticServiceImpl", "ReportError " + r3 + ' ' + r4);
        ((xw4.a) this.d.getValue()).sendEvent(r3, r4);
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.m
    public final com.bytedance.ee.bear.bitable.statistic.c createDefaultFpsTrace(String r2, boolean r3, boolean r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        com.bytedance.ee.bear.bitable.statistic.c r6 = createFpsTrace(r5);
        f r0 = new f(r2, r3, r4);
        ((BitableFpsTracer) r6).d(r0);
        return r6;
    }
}
