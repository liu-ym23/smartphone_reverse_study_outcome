package com.bytedance.android.livesdk.livecommerce.promotion.cardV2.presenter;

import com.bytedance.android.livesdk.livecommerce.promotion.card.ILivePromotionCardContainerHandler;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class g implements Runnable {
    public final /* synthetic */ h a;

    public g(h r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        h r0 = this.a;     // Catch: Throwable -> L7
        ILivePromotionCardContainerHandler r1 = r0.g.b;     // Catch: Throwable -> L7
        com.bytedance.android.livesdk.livecommerce.promotion.card.h r2 = r0.f;     // Catch: Throwable -> L7
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("promotionCardItem");     // Catch: Throwable -> L7
    L5:
        r1.i(r2.a.a, 1, true);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }
}
