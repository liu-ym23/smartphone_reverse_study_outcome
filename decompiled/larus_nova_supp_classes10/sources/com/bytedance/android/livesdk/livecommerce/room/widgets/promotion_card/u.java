package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card;

import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class u implements Runnable {
    public final /* synthetic */ t a;

    @Override // java.lang.Runnable
    public final void run() {
        t r0 = this.a;     // Catch: Throwable -> L6
        Function1<? super ECUIPromotion, Unit> r1 = r0.d;     // Catch: Throwable -> L6
        if (r1 == null) goto L9;
        Unit r2 = (Unit) r1.invoke(r0.a);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }

    public u(t r1) {
        this.a = r1;
    }
}
