package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card;

import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.livesdk.livecommerce.opt.ECLivePerformanceMonitor;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContext;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class x<T> implements Consumer {
    public final /* synthetic */ t a;
    public final /* synthetic */ ECContext b;

    public x(t r1, ECContext r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r2) {
        Throwable r3 = (Throwable) r2;
        ((ECLivePerformanceMonitor) this.b.getEcLivePerformanceMonitor().getValue()).i();
        this.a.c = false;
        Function1<? super ECUIPromotion, Unit> r4 = this.a.d;
        if (r4 == null) goto L5;
        Unit r5 = (Unit) r4.invoke(null);
    L5:
        this.a.d = null;
    }
}
