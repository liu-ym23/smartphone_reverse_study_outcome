package com.bytedance.android.window.shop.home;

import android.os.SystemClock;
import com.bytedance.android.ec.core.monitor.MetricNames;
import com.bytedance.android.ec.core.monitor.MonitorScenes;
import com.bytedance.android.ec.core.monitor.r;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010$\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\t\u001a\u00020\u0007J\u0006\u0010\n\u001a\u00020\u0007J\u0006\u0010\u000b\u001a\u00020\u0007J\u0006\u0010\f\u001a\u00020\u0007J\u0006\u0010\r\u001a\u00020\u0007J\u0006\u0010\u000e\u001a\u00020\u0007J\u001a\u0010\u000f\u001a\u00020\u00072\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0011R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/window/shop/home/WindowMonitor;", "Ljava/io/Serializable;", "()V", "liveMonitorId", "", "shopMonitorId", "addRenderMetric", "", "startDurationMonitor", "startFirstFrameTimeMonitor", "startHeaderDurationMonitor", "startTabDurationMonitor", "stopFirstFrameTimeMonitor", "stopHeaderDurationMonitor", "stopTabDurationMonitor", "stopWindowDurationMonitor", "categories", "", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowMonitor implements Serializable {
    private String liveMonitorId;
    private final String shopMonitorId;

    public final void addRenderMetric() {
        Map r0 = com.bytedance.android.ec.core.monitor.c.a;
        String r1 = this.shopMonitorId;
        MetricNames r2 = MetricNames.HEADER_DURATION;
        MetricNames r3 = MetricNames.HEADER_RENDER_DURATION;
        Intrinsics.checkNotNullParameter(r2, "apiDurationMetricName");
        Intrinsics.checkNotNullParameter(r3, "renderDurationMetricName");
        com.bytedance.android.ec.core.monitor.a r4 = (com.bytedance.android.ec.core.monitor.a) ((HashMap) com.bytedance.android.ec.core.monitor.c.a).get(r1);
        if (r4 == null) goto L10;
        String r5 = r2.getMetricNames();
        String r6 = r3.getMetricNames();
        Intrinsics.checkNotNullParameter(r5, "apiDurationMetricName");
        Intrinsics.checkNotNullParameter(r6, "renderDurationMetricName");
        Long r7 = (Long) ((HashMap) r4.a).get(r5);
        if (r7 == null) goto L11;
        long r8 = r7.longValue();
        long r9 = SystemClock.elapsedRealtime() - r8;
        if (r9 <= 0) goto L12;
        Map r10 = r4.b;
        HashMap r11 = (HashMap) r10;
        r11.put(r6, Long.valueOf(r9));
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void startDurationMonitor() {
        Map r0 = com.bytedance.android.ec.core.monitor.c.a;
        com.bytedance.android.ec.core.monitor.c.h(this.shopMonitorId, MetricNames.DURATION, null);
    }

    public final void startFirstFrameTimeMonitor() {
        Map r0 = com.bytedance.android.ec.core.monitor.c.a;
        String r1 = com.bytedance.android.ec.core.monitor.c.c(MonitorScenes.EC_STORE_LIVE_FIRST_FRAME_MONITOR, null);
        this.liveMonitorId = r1;
        com.bytedance.android.ec.core.monitor.c.h(r1, MetricNames.FIRST_FRAME_TIME, null);
    }

    public final void startHeaderDurationMonitor() {
        Map r0 = com.bytedance.android.ec.core.monitor.c.a;
        com.bytedance.android.ec.core.monitor.c.h(this.shopMonitorId, MetricNames.HEADER_DURATION, null);
    }

    public final void startTabDurationMonitor() {
        Map r0 = com.bytedance.android.ec.core.monitor.c.a;
        com.bytedance.android.ec.core.monitor.c.h(this.shopMonitorId, MetricNames.TAB_DURATION, null);
    }

    public final void stopFirstFrameTimeMonitor() {
        String r0 = this.liveMonitorId;
        if (r0 != null) goto L5;
        return;
    L5:
        Map r1 = com.bytedance.android.ec.core.monitor.c.a;
        com.bytedance.android.ec.core.monitor.c.j(r0, MetricNames.FIRST_FRAME_TIME);
        com.bytedance.android.ec.core.monitor.c.e(this.liveMonitorId, "store_type", "window");
        com.bytedance.android.ec.core.monitor.c.e(this.liveMonitorId, "flag_live_optimize", String.valueOf(yq3.a.c()));
        com.bytedance.android.ec.core.monitor.c.d(this.liveMonitorId);
    }

    public final void stopHeaderDurationMonitor() {
        Map r0 = com.bytedance.android.ec.core.monitor.c.a;
        com.bytedance.android.ec.core.monitor.c.j(this.shopMonitorId, MetricNames.HEADER_DURATION);
    }

    public final void stopTabDurationMonitor() {
        Map r0 = com.bytedance.android.ec.core.monitor.c.a;
        com.bytedance.android.ec.core.monitor.c.j(this.shopMonitorId, MetricNames.TAB_DURATION);
    }

    public WindowMonitor() {
        Map r0 = com.bytedance.android.ec.core.monitor.c.a;
        this.shopMonitorId = com.bytedance.android.ec.core.monitor.c.c(MonitorScenes.EC_WINDOW_NEW_MONITOR, new r(CollectionsKt.listOf(new MetricNames[]{MetricNames.HEADER_DURATION, MetricNames.TAB_DURATION})));
    }

    public final void stopWindowDurationMonitor(Map<String, String> r5) {
        Intrinsics.checkNotNullParameter(r5, "categories");
        String r0 = this.shopMonitorId;
        Map r1 = com.bytedance.android.ec.core.monitor.c.a;
        com.bytedance.android.ec.core.monitor.c.j(r0, MetricNames.DURATION);
        Iterator<Map.Entry<String, String>> r6 = r5.entrySet().iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        Map.Entry<String, String> r2 = r6.next();
        String r3 = r2.getKey();
        String r4 = r2.getValue();
        Map r7 = com.bytedance.android.ec.core.monitor.c.a;
        com.bytedance.android.ec.core.monitor.c.e(r0, r3, r4);
        goto L4
    L6:
        Map r8 = com.bytedance.android.ec.core.monitor.c.a;
        String r9 = null;
        kc.a r10 = com.bytedance.android.bcm.api.b.c(null, CollectionsKt.arrayListOf(new String[]{"ecom_entrance"}));
        if (r10 == null) goto L15;
        List r11 = r10.a;
        if (r11 == null) goto L15;
        List r12 = r11;
        ArrayList r13 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10));
        Iterator r14 = r12.iterator();
    L12:
        if (r14.hasNext() == false) goto L14;
        r13.add(((kc.a.a) r14.next()).c);
        goto L12
    L14:
        r9 = com.bytedance.android.ec.hybrid.list.util.k.d(r13);
    L15:
        if (r9 != null) goto L17;
        r9 = "";
    L17:
        com.bytedance.android.ec.core.monitor.c.e(r0, "btm_list", r9);
        Map r15 = com.bytedance.android.ec.core.monitor.c.a;
        com.bytedance.android.ec.core.monitor.c.d(r0);
    }
}
