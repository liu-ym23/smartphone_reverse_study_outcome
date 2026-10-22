package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.related;

import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.livesdk.livecommerce.opt.ECLivePerformanceMonitor;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContext;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class l<T> implements Consumer {
    public final /* synthetic */ PromotionCardLoadOptUtils a;
    public final /* synthetic */ ECContext b;

    public l(PromotionCardLoadOptUtils r1, ECContext r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r2) {
        Throwable r3 = (Throwable) r2;
        this.a.m.b((ECLivePerformanceMonitor) this.b.getEcLivePerformanceMonitor().getValue());
        this.a.a = false;
        Function1<? super ECUIPromotion, Unit> r4 = this.a.g;
        if (r4 == null) goto L5;
        Unit r5 = (Unit) r4.invoke(null);
    L5:
        this.a.g = null;
    }
}
