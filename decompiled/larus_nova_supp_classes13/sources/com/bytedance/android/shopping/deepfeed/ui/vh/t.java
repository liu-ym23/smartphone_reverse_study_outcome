package com.bytedance.android.shopping.deepfeed.ui.vh;

import com.bytedance.android.shopping.deepfeed.event.DeepFeedProductEventTracker;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class t implements Runnable {
    public final /* synthetic */ DeepFeedProductVH a;
    public final /* synthetic */ uc3.f b;

    public t(DeepFeedProductVH r1, uc3.f r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        uc3.f r0 = this.b;     // Catch: Throwable -> L13
        if (r0 == null) goto L5;
        r0.c(System.currentTimeMillis());     // Catch: Throwable -> L13
    L5:
        uc3.f r1 = this.b;     // Catch: Throwable -> L13
        if (r1 == null) goto L16;
        Map<String, ? extends Object> r2 = r1.a();     // Catch: Throwable -> L13
        if (r2 == null) goto L20;
        DeepFeedProductEventTracker r3 = this.a.i4().getEventTracker();     // Catch: Throwable -> L13
        if (r3 == null) goto L21;
        Intrinsics.checkNotNullParameter(r2, "data");     // Catch: Throwable -> L13
        r3.doEventAction("ec_perf_duration_mall_deep_feed", r2);     // Catch: Throwable -> L13
        return;
    L21:
        return;
    L20:
        return;
    L16:
        return;
    L13:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L22;
        throw th;
    }
}
