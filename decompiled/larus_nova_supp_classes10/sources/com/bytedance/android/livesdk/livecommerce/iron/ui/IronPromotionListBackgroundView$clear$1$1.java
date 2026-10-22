package com.bytedance.android.livesdk.livecommerce.iron.ui;

import kotlin.Metadata;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class IronPromotionListBackgroundView$clear$1$1 extends MutablePropertyReference0Impl {
    public IronPromotionListBackgroundView$clear$1$1(IronPromotionListBackgroundView r7) {
        super(r7, IronPromotionListBackgroundView.class, "rightInterestView", "getRightInterestView()Lcom/bytedance/android/livesdk/livecommerce/iron/ui/ECCustomizedElementView;", 0);
    }

    public Object get() {
        ECCustomizedElementView r0 = ((IronPromotionListBackgroundView) ((CallableReference) this).receiver).j;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("rightInterestView");
    L5:
        return r0;
    }

    public void set(Object r2) {
        ECCustomizedElementView r3 = (ECCustomizedElementView) r2;
        ((IronPromotionListBackgroundView) ((CallableReference) this).receiver).j = r3;
    }
}
