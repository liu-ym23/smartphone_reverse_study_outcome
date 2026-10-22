package com.bytedance.android.shopping.deepfeed.weights;

import android.os.Handler;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class n implements Runnable {
    public final /* synthetic */ DeepFeedProductInfoExtraView a;

    public n(DeepFeedProductInfoExtraView r1) {
        this.a = r1;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [android.view.ViewGroup, com.bytedance.android.shopping.deepfeed.weights.DeepFeedProductInfoMarqueeView] */
    public final void a() {
        ?? r0 = this.a.j;
        int r1 = r0.c;
        if (r1 > 0) goto L6;
        r1 = r0.getHeight();
    L6:
        if (r1 <= 0) goto L13;
        r0.c = r1;
        r0.U5();
        Runnable r2 = r0.e;
        if (r2 == null) goto L11;
        r0.f.removeCallbacks(r2);
    L11:
        r0.j = true;
        p r3 = new p(r0);
        r0.e = r3;
        Handler r4 = r0.f;
        Intrinsics.checkNotNull(r3);
        r4.postDelayed(r3, 3000);
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
