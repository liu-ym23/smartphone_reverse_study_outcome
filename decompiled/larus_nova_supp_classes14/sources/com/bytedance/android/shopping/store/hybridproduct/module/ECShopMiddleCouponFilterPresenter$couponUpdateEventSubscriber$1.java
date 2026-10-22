package com.bytedance.android.shopping.store.hybridproduct.module;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECShopMiddleCouponFilterPresenter$couponUpdateEventSubscriber$1 implements ti.j {
    public final /* synthetic */ ECShopMiddleCouponFilterPresenter a;

    public ECShopMiddleCouponFilterPresenter$couponUpdateEventSubscriber$1(ECShopMiddleCouponFilterPresenter r1) {
        this.a = r1;
    }

    public final void a(JSONObject r3) {
        Intrinsics.checkNotNullParameter(r3, "params");
        this.a.x.fetchActivityDataForMiddleCoupon(new ECShopMiddleCouponFilterPresenter$couponUpdateEventSubscriber$1$onReceiveJsEvent$1(this), ECShopMiddleCouponFilterPresenter$couponUpdateEventSubscriber$1$onReceiveJsEvent$2.INSTANCE);
    }
}
