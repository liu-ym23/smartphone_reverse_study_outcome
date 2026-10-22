package com.bytedance.android.livesdk.livecommerce.room.controller;

import com.bytedance.android.ec.model.response.ECCurrentPromotion;
import com.bytedance.android.ec.model.response.ECPromotion;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import vi2.v0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class j<T> implements Consumer {
    public final /* synthetic */ String a;
    public final /* synthetic */ v0 b;

    public j(com.bytedance.android.livesdk.livecommerce.room.controller.business.n.b r2) {
        this.a = null;
        this.b = r2;
    }

    public final void accept(Object r3) {
        ECCurrentPromotion r4 = (ECCurrentPromotion) r3;
        Intrinsics.checkNotNullParameter(r4, "apiData");
        if (r4.a().size() <= 0) goto L7;
        ECPromotion r5 = com.bytedance.android.livesdk.livecommerce.utils.k.c(r4);
        if (r5 == null) goto L8;
        r5.opType = this.a;
    L8:
        if (r5 != null) goto L10;
    L14:
        v0 r6 = this.b;
        if (r6 == null) goto L20;
        r6.onError(null);
        return;
    L20:
        return;
    L10:
        if (((com.bytedance.android.ec.model.g) r5).statusCode != 0) goto L14;
        v0 r0 = this.b;
        if (r0 == null) goto L18;
        r0.onSuccess(r5);
        return;
    L18:
        return;
    L7:
        r5 = null;
        goto L8
    }
}
