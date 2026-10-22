package com.bytedance.android.shopping.orderlist.common.monitor.skeleton;

import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.shopping.orderlist.common.utils.OrderCommonLog;
import com.bytedance.android.shopping.orderlist.list.container.OrderListRequestType;
import com.bytedance.ttnet.TTNetInit;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class OrderCommonSkeletonMonitor {
    public final int a;
    public final int b;
    public Disposable c;
    public boolean d;
    public long e;
    public boolean f;
    public OrderSkeletonStatus g;
    public JSONObject h;
    public final WeakReference<com.bytedance.android.shopping.orderlist.common.monitor.error.a> i;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ OrderCommonSkeletonMonitor a;

        public a(OrderCommonSkeletonMonitor r1) {
            this.a = r1;
        }

        public final void accept(Object r9) {
            final Long r10 = (Long) r9;
            Lazy r0 = OrderCommonLog.a;
            OrderCommonLog.c("OrderSkeletonMonitor", new OrderCommonSkeletonMonitor$startMonitor$3$1(r10));
            this.a.a(OrderSkeletonMonitorScene.SCENE_SKELETON_SHOW, (int) (System.currentTimeMillis() - this.a.e), MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("monitor_count", Long.valueOf(r10.longValue() + 1))}));
        }
    }

    public final void b() {
        if (this.f == true) goto L5;
        return;
    L5:
        if (ECSettingKeys.L().getOn() == false) goto L9;
        Lazy r0 = OrderCommonLog.a;
        OrderCommonLog.c("OrderSkeletonMonitor", OrderCommonSkeletonMonitor$reportWhenAppBackground$1.INSTANCE);
        e(OrderSkeletonMonitorScene.SCENE_LAST_APP_BACKGROUND);
        return;
    }

    public final void c() {
        if (this.f == true) goto L5;
        return;
    L5:
        if (ECSettingKeys.L().getOn() == false) goto L9;
        Lazy r0 = OrderCommonLog.a;
        OrderCommonLog.c("OrderSkeletonMonitor", OrderCommonSkeletonMonitor$reportWhenPageLeave$1.INSTANCE);
        e(OrderSkeletonMonitorScene.SCENE_LAST_PAGE_LEAVE);
        return;
    }

    public OrderCommonSkeletonMonitor(WeakReference<com.bytedance.android.shopping.orderlist.common.monitor.error.a> r2) {
        Intrinsics.checkNotNullParameter(r2, "reporter");
        this.i = r2;
        this.a = ECSettingKeys.L().getRenderIntervalThreshold();
        this.b = ECSettingKeys.L().getRevertIntervalThreshold();
        this.d = true;
        this.g = OrderSkeletonStatus.Pending;
        this.h = new JSONObject();
        Lazy r3 = OrderCommonLog.a;
        OrderCommonLog.c("OrderSkeletonMonitor", new AnonymousClass1(this));
    }

    public final void d(final OrderListRequestType r5) {
        Intrinsics.checkNotNullParameter(r5, "type");
        if (this.f == false) goto L5;
        return;
    L5:
        if (ECSettingKeys.L().getOn() == false) goto L19;
        Lazy r0 = OrderCommonLog.a;
        OrderCommonLog.c("OrderSkeletonMonitor", new OrderCommonSkeletonMonitor$startMonitor$1(r5));
        this.e = System.currentTimeMillis();
        int r6 = com.bytedance.android.shopping.orderlist.common.monitor.skeleton.a.a[r5.ordinal()];
        if (r6 != 1) goto L10;
        boolean r7 = true;
    L16:
        this.d = r7;
        this.f = true;
        this.e = System.currentTimeMillis();
        OrderCommonLog.c("OrderSkeletonMonitor", new OrderCommonSkeletonMonitor$startMonitor$2(this));
        this.c = Observable.timer(this.a, TimeUnit.MILLISECONDS).subscribe(new a(this));
        return;
    L10:
        if (r6 != 2) goto L12;
    L14:
        r7 = false;
        goto L16
    L12:
        if (r6 == 3) goto L14;
        return;
    }

    public final void e(OrderSkeletonMonitorScene r5) {
        Intrinsics.checkNotNullParameter(r5, "scene");
        if (this.f == true) goto L5;
        return;
    L5:
        if (ECSettingKeys.L().getOn() == false) goto L13;
        this.f = false;
        Lazy r0 = OrderCommonLog.a;
        OrderCommonLog.c("OrderSkeletonMonitor", OrderCommonSkeletonMonitor$stopMonitor$1.INSTANCE);
        Disposable r1 = this.c;
        if (r1 == null) goto L10;
        r1.dispose();
    L10:
        a(r5, (int) (System.currentTimeMillis() - this.e), new LinkedHashMap());
        return;
    }

    public final void f(Map<String, ? extends Object> r4) {
        Intrinsics.checkNotNullParameter(r4, "params");
        Iterator<Map.Entry<String, ? extends Object>> r5 = r4.entrySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        Map.Entry<String, ? extends Object> r0 = r5.next();
        this.h.put(r0.getKey(), r0.getValue());
        goto L4
    }

    public final void a(final OrderSkeletonMonitorScene r4, int r5, Map<String, ? extends Object> r6) {
        Intrinsics.checkNotNullParameter(r4, "scene");
        Intrinsics.checkNotNullParameter(r6, "params");
        if (r5 >= this.a) goto L6;
        return;
    L6:
        if (r4 != OrderSkeletonMonitorScene.SCENE_SKELETON_SHOW) goto L8;
    L10:
        Pair[] r0 = new Pair[6];
        r0[0] = TuplesKt.to("type", "CUSTOM_ERROR");
        r0[1] = TuplesKt.to("desc", "skeleton_monitor");
        if (this.d == false) goto L13;
        OrderSkeletonType r1 = OrderSkeletonType.FIRST_SCREEN;
    L14:
        r0[2] = TuplesKt.to("skeleton_type", Integer.valueOf(r1.getValue()));
        r0[3] = TuplesKt.to("report_scene", Integer.valueOf(r4.getValue()));
        r0[4] = TuplesKt.to("show_duration", Integer.valueOf(r5));
        r0[5] = TuplesKt.to("render_status", Integer.valueOf(this.g.getValue()));
        final Map<String, ? extends Object> r7 = MapsKt.mutableMapOf(r0);
        r7.putAll(r6);
        Integer r8 = Integer.valueOf(TTNetInit.getEffectiveConnectionType());
        Intrinsics.checkNotNullParameter("network_quality", "key");
        Intrinsics.checkNotNullParameter(r8, "value");
        this.h.put("network_quality", r8);
        r7.put("last_request", this.h.toString());
        Lazy r9 = OrderCommonLog.a;
        OrderCommonLog.c("OrderSkeletonMonitor", new OrderCommonSkeletonMonitor$report$1(r4, r7));
        com.bytedance.android.shopping.orderlist.common.monitor.error.a r10 = this.i.get();
        if (r10 == null) goto L17;
        r10.b("ies_ecommerce_fe_custom_log", r7);
    L17:
        this.g = OrderSkeletonStatus.Pending;
        return;
    L13:
        r1 = OrderSkeletonType.CHANGE_TAB;
        goto L14
    L8:
        if (r5 >= this.b) goto L10;
    }
}
