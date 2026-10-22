package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.related;

import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.ec.model.response.ECCurrentPromotion;
import com.bytedance.android.livesdk.livecommerce.opt.ECLivePerformanceMonitor;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContext;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class k<T> implements Consumer {
    public final /* synthetic */ PromotionCardLoadOptUtils a;
    public final /* synthetic */ ECContext b;

    public k(PromotionCardLoadOptUtils r1, ECContext r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r3) {
        ECCurrentPromotion r4 = (ECCurrentPromotion) r3;
        if (com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.t.h == true) goto L8;
        this.a.m.b((ECLivePerformanceMonitor) this.b.getEcLivePerformanceMonitor().getValue());
        this.a.a = false;
        PromotionCardLoadOptUtils r0 = this.a;
        r0.d = com.bytedance.android.livesdk.livecommerce.utils.k.e(com.bytedance.android.livesdk.livecommerce.utils.k.c(r4), Boolean.TRUE);
        this.a.e = true;
        Function1<? super ECUIPromotion, Unit> r5 = this.a.g;
        if (r5 == null) goto L9;
        Unit r6 = (Unit) r5.invoke(this.a.d);
        return;
    L9:
        return;
    }
}
