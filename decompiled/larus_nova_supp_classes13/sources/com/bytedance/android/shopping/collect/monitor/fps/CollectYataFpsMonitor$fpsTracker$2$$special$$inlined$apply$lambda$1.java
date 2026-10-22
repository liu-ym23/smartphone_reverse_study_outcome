package com.bytedance.android.shopping.collect.monitor.fps;

import com.bytedance.android.shopping.collect.monitor.error.CollectRunCatchExtKt;
import et3.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class CollectYataFpsMonitor$fpsTracker$2$$special$$inlined$apply$lambda$1 implements c.d {
    public final /* synthetic */ CollectYataFpsMonitor$fpsTracker$2 a;
    public final /* synthetic */ String b;

    public CollectYataFpsMonitor$fpsTracker$2$$special$$inlined$apply$lambda$1(CollectYataFpsMonitor$fpsTracker$2 r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void fpsCallBack(final double r3) {
        CollectRunCatchExtKt.a(this.a.this$0.c.getMonitorId(), "CollectYataFpsMonitor", new AnonymousClass1(this, r3));
    }
}
