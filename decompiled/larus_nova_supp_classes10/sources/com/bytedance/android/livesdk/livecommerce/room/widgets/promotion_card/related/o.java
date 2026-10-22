package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.related;

import android.os.SystemClock;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class o<T> implements Consumer {
    public final /* synthetic */ PromotionCardLoadOptUtils a;

    public o(PromotionCardLoadOptUtils r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        Throwable r4 = (Throwable) r3;
        PromotionCardLoadOptUtils r5 = this.a;
        r5.c = Long.valueOf(SystemClock.elapsedRealtime());
        this.a.a = false;
        this.a.e = false;
        Function1<? super ECUIPromotion, Unit> r6 = this.a.g;
        if (r6 == null) goto L5;
        Unit r7 = (Unit) r6.invoke(null);
    L5:
        this.a.g = null;
    }
}
