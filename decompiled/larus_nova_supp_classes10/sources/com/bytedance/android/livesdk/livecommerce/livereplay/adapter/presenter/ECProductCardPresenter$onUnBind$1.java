package com.bytedance.android.livesdk.livecommerce.livereplay.adapter.presenter;

import cf.r;
import kotlin.Metadata;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class ECProductCardPresenter$onUnBind$1 extends MutablePropertyReference0Impl {
    public ECProductCardPresenter$onUnBind$1(ECProductCardPresenter r7) {
        super(r7, ECProductCardPresenter.class, "promotionItem", "getPromotionItem()Lcom/bytedance/android/ec/common/api/IPromotionListItem;", 0);
    }

    public Object get() {
        r r0 = ((ECProductCardPresenter) ((CallableReference) this).receiver).e;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("promotionItem");
    L5:
        return r0;
    }

    public void set(Object r2) {
        r r3 = (r) r2;
        ((ECProductCardPresenter) ((CallableReference) this).receiver).e = r3;
    }
}
