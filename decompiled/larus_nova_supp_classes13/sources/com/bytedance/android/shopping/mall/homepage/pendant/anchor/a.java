package com.bytedance.android.shopping.mall.homepage.pendant.anchor;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Lazy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a implements Runnable {
    public final /* synthetic */ AnchorPendant a;

    public a(AnchorPendant r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AnchorPendant r0 = this.a;     // Catch: Throwable -> L4
        Lazy r1 = AnchorPendant.u;     // Catch: Throwable -> L4
        r0.k();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
