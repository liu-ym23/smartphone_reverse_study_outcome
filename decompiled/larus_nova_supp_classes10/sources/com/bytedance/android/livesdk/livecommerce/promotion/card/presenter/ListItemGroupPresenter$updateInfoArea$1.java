package com.bytedance.android.livesdk.livecommerce.promotion.card.presenter;

import kotlin.Metadata;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class ListItemGroupPresenter$updateInfoArea$1 extends MutablePropertyReference0Impl {
    public ListItemGroupPresenter$updateInfoArea$1(ListItemGroupPresenter r7) {
        super(r7, ListItemGroupPresenter.class, "widgetManager", "getWidgetManager()Lcom/bytedance/android/livesdk/livecommerce/promotion/card/factory/InfoWidgetManager;", 0);
    }

    public Object get() {
        hj2.h r0 = ((ListItemGroupPresenter) ((CallableReference) this).receiver).e;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("widgetManager");
    L5:
        return r0;
    }

    public void set(Object r2) {
        hj2.h r3 = (hj2.h) r2;
        ((ListItemGroupPresenter) ((CallableReference) this).receiver).e = r3;
    }
}
