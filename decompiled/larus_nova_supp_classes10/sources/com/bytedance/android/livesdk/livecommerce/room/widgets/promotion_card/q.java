package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card;

import com.bytedance.android.ec.model.response.ECCurrentPromotion;
import com.bytedance.android.ec.model.response.ECPromotion;
import io.reactivex.functions.BiFunction;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class q<T1, T2, R> implements BiFunction {
    public static final q a = null;

    static {
        a = new q();
    }

    public q() {
    }

    public final Object apply(Object r3, Object r4) {
        ECCurrentPromotion r5 = (ECCurrentPromotion) r3;
        ECCurrentPromotion r6 = (ECCurrentPromotion) r4;
        Intrinsics.checkNotNullParameter(r5, "explainCardResp");
        Intrinsics.checkNotNullParameter(r6, "relatedCardResp");
        ECPromotion r7 = com.bytedance.android.livesdk.livecommerce.utils.k.c(r5);
        Boolean r1 = Boolean.TRUE;
        return new p.a(com.bytedance.android.livesdk.livecommerce.utils.k.e(r7, r1), com.bytedance.android.livesdk.livecommerce.utils.k.e(com.bytedance.android.livesdk.livecommerce.utils.k.c(r6), r1));
    }
}
