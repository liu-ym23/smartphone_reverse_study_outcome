package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card;

import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.livesdk.livecommerce.opt.ECLivePerformanceMonitor;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContext;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class w<T> implements Consumer {
    public final /* synthetic */ t a;
    public final /* synthetic */ ECContext b;

    public w(t r1, ECContext r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r3) {
        pk2.f r4 = (pk2.f) r3;
        if (t.h == true) goto L8;
        ((ECLivePerformanceMonitor) this.b.getEcLivePerformanceMonitor().getValue()).i();
        this.a.c = false;
        t r0 = this.a;
        r0.a = com.bytedance.android.livesdk.livecommerce.utils.k.e(com.bytedance.android.livesdk.livecommerce.utils.k.c(r4.a), Boolean.TRUE);
        this.a.b = true;
        t r5 = this.a;
        Function1<? super ECUIPromotion, Unit> r1 = r5.d;
        if (r1 == null) goto L9;
        Unit r6 = (Unit) r1.invoke(r5.a);
        return;
    L9:
        return;
    }
}
