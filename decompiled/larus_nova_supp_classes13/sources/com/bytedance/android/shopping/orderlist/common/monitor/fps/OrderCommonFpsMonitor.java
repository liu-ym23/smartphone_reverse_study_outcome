package com.bytedance.android.shopping.orderlist.common.monitor.fps;

import com.bytedance.android.ec.core.monitor.MonitorScenes;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class OrderCommonFpsMonitor {
    public String a;
    public boolean b;
    public final Lazy c;
    public final Lazy d;
    public final MonitorScenes e;

    public OrderCommonFpsMonitor(MonitorScenes r2) {
        Intrinsics.checkNotNullParameter(r2, "monitorScenes");
        this.e = r2;
        this.a = "yata";
        this.c = LazyKt.lazy(OrderCommonFpsMonitor$eventParams$2.INSTANCE);
        this.d = LazyKt.lazy(new OrderCommonFpsMonitor$fpsTracker$2(this));
    }
}
