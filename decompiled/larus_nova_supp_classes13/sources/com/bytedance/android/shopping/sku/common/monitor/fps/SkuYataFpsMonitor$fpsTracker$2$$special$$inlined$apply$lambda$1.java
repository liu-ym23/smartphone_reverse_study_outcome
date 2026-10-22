package com.bytedance.android.shopping.sku.common.monitor.fps;

import com.bytedance.android.shopping.sku.common.monitor.error.SkuRunCatchExtKt;
import et3.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class SkuYataFpsMonitor$fpsTracker$2$$special$$inlined$apply$lambda$1 implements c.d {
    public final /* synthetic */ SkuYataFpsMonitor$fpsTracker$2 a;
    public final /* synthetic */ String b;

    public SkuYataFpsMonitor$fpsTracker$2$$special$$inlined$apply$lambda$1(SkuYataFpsMonitor$fpsTracker$2 r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void fpsCallBack(final double r3) {
        SkuRunCatchExtKt.a(this.a.this$0.c.getMonitorId(), "SkuYataFpsMonitor", new AnonymousClass1(this, r3));
    }
}
