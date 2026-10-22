package com.bytedance.android.livesdk.livecommerce.room.controller;

import com.bytedance.android.ec.model.response.ECPromotionCheckResponse;
import com.bytedance.android.livesdk.livecommerce.iron.helper.PromotionJumpDispatcher;
import io.reactivex.functions.Consumer;
import vi2.v0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ v0 a;

    public f(PromotionJumpDispatcher.c r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        ECPromotionCheckResponse r3 = (ECPromotionCheckResponse) r2;
        v0 r0 = this.a;
        if (r0 == null) goto L6;
        r0.onSuccess(r3);
        return;
    }
}
