package com.bytedance.android.livesdk.livecommerce.room.controller;

import com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.LivePromotionListViewModel;
import io.reactivex.functions.Consumer;
import vi2.v0;
import xi2.e0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class q<T> implements Consumer {
    public final /* synthetic */ v0 a;

    public q(LivePromotionListViewModel.h r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        e0 r3 = (e0) r2;
        v0 r0 = this.a;
        if (r0 == null) goto L6;
        r0.onSuccess(r3);
        return;
    }
}
