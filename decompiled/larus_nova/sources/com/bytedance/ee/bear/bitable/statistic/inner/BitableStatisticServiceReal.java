package com.bytedance.ee.bear.bitable.statistic.inner;

import com.android.ttcjpaysdk.bindcard.base.constants.BindCardPayConfirmConstants;
import com.bytedance.android.livesdkapi.app.AppConstants;
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

/* JADX INFO: loaded from: classes16.dex */
public final class BitableStatisticServiceReal implements m, i, e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Serializable> f215695a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, BitableInnerTrace> f215696b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f215697c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f215698d;

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
        Iterator r100 = ((ConcurrentHashMap) this.f215696b).values().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((BitableInnerTrace) r100.next()).b(Boolean.FALSE);
        goto L4
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.inner.e
    public final String b() {
        String r100 = l0.a().toString();
        if (((ConcurrentHashMap) this.f215696b).containsKey(r100) == true) goto L5;
        return r100;
    L5:
        return b();
    }

    public BitableStatisticServiceReal(Lazy<? extends xw4.a> r100) {
        Intrinsics.checkNotNullParameter(r100, "appLogger");
        this.f215695a = new ConcurrentHashMap();
        this.f215696b = new ConcurrentHashMap();
        this.f215697c = LazyKt.lazy(BitableStatisticServiceReal$fgKeys$2.INSTANCE);
        this.f215698d = r100;
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.inner.e
    public final void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        ((ConcurrentHashMap) this.f215696b).remove(r100);
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.m
    public final com.bytedance.ee.bear.bitable.statistic.c createFpsTrace(String r100) {
        BitableFpsTracer r101 = new BitableFpsTracer(r100, this);
        Map<String, BitableInnerTrace> r102 = this.f215696b;
        ConcurrentHashMap r103 = (ConcurrentHashMap) r102;
        r103.put(r101.f215687h, r101);
        return r101;
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.m
    public final String createNormalTrace(String r100) {
        BitableNormalTrace r101 = new BitableNormalTrace(r100, this);
        Map<String, BitableInnerTrace> r102 = this.f215696b;
        ConcurrentHashMap r103 = (ConcurrentHashMap) r102;
        r103.put(r101.f215687h, r101);
        return r101.f215687h;
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.m
    public final g createProcessTrace(String r100) {
        b r101 = new b(r100, this);
        Map<String, BitableInnerTrace> r102 = this.f215696b;
        ConcurrentHashMap r103 = (ConcurrentHashMap) r102;
        r103.put(r101.f215687h, r101);
        return r101;
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.m
    public final void removeAllConsumer(String r100) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        BitableInnerTrace r101 = a(r100, BitableInnerTrace.class, false);
        if (r101 == null) goto L6;
        r101.m();
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.m
    public final void addFpsConsumer(String r100, h r101) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        Intrinsics.checkNotNullParameter(r101, "consumer");
        BitableFpsTracer r102 = (BitableFpsTracer) a(r100, BitableFpsTracer.class, false);
        if (r102 == null) goto L6;
        r102.d(r101);
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.m
    public final void addNormalConsumer(String r100, j r101) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        Intrinsics.checkNotNullParameter(r101, "consumer");
        BitableNormalTrace r102 = (BitableNormalTrace) a(r100, BitableNormalTrace.class, false);
        if (r102 == null) goto L6;
        Intrinsics.checkNotNullParameter(r101, "consumer");
        ((CopyOnWriteArrayList) r102.f215694o).add(r101);
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.m
    public final void addNormalPoint(String r100, BitableStatisticEventModel$NormalPointModel r101) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        Intrinsics.checkNotNullParameter(r101, "point");
        BitableNormalTrace r102 = (BitableNormalTrace) a(r100, BitableNormalTrace.class, false);
        if (r102 == null) goto L6;
        Intrinsics.checkNotNullParameter(r101, "point");
        r102.f215685f.set(true);
        r102.l().post(new com.bytedance.ee.bear.bitable.statistic.inner.a(r102, r101));
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.m
    public final void addProcessConsumer(String r100, k r101) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        Intrinsics.checkNotNullParameter(r101, "consumer");
        b r102 = (b) a(r100, b.class, false);
        if (r102 == null) goto L6;
        r102.i(r101);
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.m
    public final String createDefaultNormalTrace(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        String r102 = createNormalTrace(r101);
        addNormalConsumer(r102, new DefaultBitableStatisticPerformanceConsumer(r100));
        return r102;
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.m
    public final void removeFpsConsumer(String r100, h r101) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        Intrinsics.checkNotNullParameter(r101, "consumer");
        BitableFpsTracer r102 = (BitableFpsTracer) a(r100, BitableFpsTracer.class, false);
        if (r102 == null) goto L6;
        Intrinsics.checkNotNullParameter(r101, "consumer");
        ((CopyOnWriteArrayList) r102.f215659q).remove(r101);
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.m
    public final void removeNormalConsumer(String r100, j r101) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        Intrinsics.checkNotNullParameter(r101, "consumer");
        BitableNormalTrace r102 = (BitableNormalTrace) a(r100, BitableNormalTrace.class, false);
        if (r102 == null) goto L6;
        Intrinsics.checkNotNullParameter(r101, "consumer");
        ((CopyOnWriteArrayList) r102.f215694o).remove(r101);
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.m
    public final void removeProcessConsumer(String r100, k r101) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        Intrinsics.checkNotNullParameter(r101, "consumer");
        b r102 = (b) a(r100, b.class, false);
        if (r102 == null) goto L6;
        Intrinsics.checkNotNullParameter(r101, "consumer");
        ((CopyOnWriteArrayList) r102.f215703m).remove(r101);
        r102.o();
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.m
    public final void setCommonParams(String r100, Serializable r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        if (r101 != null) goto L5;
        ((ConcurrentHashMap) this.f215695a).remove(r100);
        return;
    L5:
        ((ConcurrentHashMap) this.f215695a).put(r100, r101);
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.m
    public final void stopTrace(String r100, Boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        int r102 = com.bytedance.ee.bear.bitable.statistic.common.e.f215628a;
        tt5.a.h("BitableStatistic", "StatisticServiceImpl " + ("stopTrace " + r100 + " includeChildren:" + r101));
        BitableInnerTrace r103 = a(r100, BitableInnerTrace.class, false);
        if (r103 == null) goto L6;
        r103.b(r101);
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.inner.e
    public final BitableInnerTrace a(String r100, Class r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        Intrinsics.checkNotNullParameter(r101, "clazz");
        BitableInnerTrace r103 = (BitableInnerTrace) ((ConcurrentHashMap) this.f215696b).get(r100);
        if (r103 != null) goto L6;
        int r104 = com.bytedance.ee.bear.bitable.statistic.common.e.f215628a;
        com.bytedance.ee.bear.bitable.statistic.common.e.c("StatisticServiceImpl", "could not find trace " + r100 + ' ' + ExceptionsKt.stackTraceToString(new Throwable()));
        return null;
    L6:
        if (r102 == true) goto L12;
        if (r103.f215688i == false) goto L12;
        int r105 = com.bytedance.ee.bear.bitable.statistic.common.e.f215628a;
        tt5.a.h("BitableStatistic", "StatisticServiceImpl " + ("trace is stop " + r100));
        return null;
    L12:
        if (r101.isInstance(r103) == true) goto L15;
        int r106 = com.bytedance.ee.bear.bitable.statistic.common.e.f215628a;
        com.bytedance.ee.bear.bitable.statistic.common.e.c("StatisticServiceImpl", "trace type not match " + r103 + ' ' + r101);
        return null;
    L15:
        return r103;
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.m
    public final void addTraceExtra(String r100, String r101, Serializable r102) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        Intrinsics.checkNotNullParameter(r101, "key");
        BitableInnerTrace r103 = a(r100, BitableInnerTrace.class, false);
        if (r103 == null) goto L10;
        Map<String, Serializable> r104 = r103.f215683d;
        if (r104 == null) goto L11;
        if (r102 != null) goto L8;
        ((ConcurrentHashMap) r104).remove(r101);
        return;
    L8:
        ((ConcurrentHashMap) r104).put(r101, r102);
        return;
    L11:
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.m
    public final void appendTraceExtraIfNotExist(String r100, String r101, Serializable r102) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        Intrinsics.checkNotNullParameter(r101, "key");
        if (r102 != null) goto L5;
        return;
    L5:
        BitableInnerTrace r103 = a(r100, BitableInnerTrace.class, false);
        if (r103 == null) goto L13;
        Map<String, Serializable> r104 = r103.f215683d;
        if (r104 == null) goto L14;
        ConcurrentHashMap r105 = (ConcurrentHashMap) r104;
        if (r105.get(r101) != null) goto L15;
        r105.put(r101, r102);
        return;
    L15:
        return;
    L14:
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.i
    public final void d(n r100, String r101, Map<String, ? extends Serializable> r102) {
        Intrinsics.checkNotNullParameter(r100, "trace");
        Intrinsics.checkNotNullParameter(r101, "eventName");
        Intrinsics.checkNotNullParameter(r102, "params");
        e(r100, r101, new JSONObject(mu5.b.e(r102)));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        tt5.a.e("StatisticServiceImpl", "sendEvent parse jsonObject error", e, false);
    }

    public final void e(n r100, String r101, JSONObject r102) {
        Intrinsics.checkNotNullParameter(r100, "trace");
        Intrinsics.checkNotNullParameter(r101, "eventName");
        Intrinsics.checkNotNullParameter(r102, "jsonObject");
        Iterator<Map.Entry<String, Serializable>> r103 = r100.c(true).entrySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L9;
        Map.Entry<String, Serializable> r104 = r103.next();
        Object r105 = (Serializable) r104.getValue();
        if ((r105 instanceof IJSONObjectAdapter) == true) goto L7;
        r102.put(r104.getKey(), r105);
        goto L4
    L7:
        r102.put(r104.getKey(), ((IJSONObjectAdapter) r105).convertToOrgJSONObject());
        goto L4
    L9:
        r102.put(BindCardPayConfirmConstants.Key.TRACE_ID, r100.getTraceId());
        String[] r106 = (String[]) ((BitablePerformanceFgKey) this.f215697c.getValue()).get(r101);
        if (r106 == null) goto L14;
        LinkedHashMap r107 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(r106.length), 16));
        int r108 = r106.length;
        int r109 = 0;
    L12:
        if (r109 >= r108) goto L15;
        String r110 = r106[r109];
        int r111 = com.bytedance.ee.bear.bitable.core.usercomponent.d.f210603a;
        Intrinsics.checkNotNullParameter(r110, "key");
        r107.put(r110, Integer.valueOf(com.bytedance.ee.bear.bitable.core.usercomponent.b.d(r110) ? 1 : 0));
        r109 = r109 + 1;
    L15:
        r102.put(AppConstants.APP_FG, r107);
        int r112 = com.bytedance.ee.bear.bitable.statistic.common.e.f215628a;
        String r113 = "SendEvent " + r101 + ' ' + r102;
        if (((Boolean) BitableStatisticConstant$Debug.f215588a.getValue()).booleanValue() == false) goto L18;
        tt5.a.h("BitableStatistic", "StatisticServiceImpl " + r113);
    L18:
        r102.put("parent_trace_id", r100.h());
        ((xw4.a) this.f215698d.getValue()).sendEvent(r101, r102);
        return;
    L14:
        r107 = null;
        goto L15
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.m
    public final void reportError(String r100, String r101, JSONObject r102) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        Intrinsics.checkNotNullParameter(r101, "eventName");
        Intrinsics.checkNotNullParameter(r102, "jsonObject");
        int r103 = com.bytedance.ee.bear.bitable.statistic.common.e.f215628a;
        com.bytedance.ee.bear.bitable.statistic.common.e.e("StatisticServiceImpl", "ReportError " + r101 + ' ' + r102);
        ((xw4.a) this.f215698d.getValue()).sendEvent(r101, r102);
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.m
    public final com.bytedance.ee.bear.bitable.statistic.c createDefaultFpsTrace(String r100, boolean r101, boolean r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        com.bytedance.ee.bear.bitable.statistic.c r104 = createFpsTrace(r103);
        f r105 = new f(r100, r101, r102);
        ((BitableFpsTracer) r104).d(r105);
        return r104;
    }
}
