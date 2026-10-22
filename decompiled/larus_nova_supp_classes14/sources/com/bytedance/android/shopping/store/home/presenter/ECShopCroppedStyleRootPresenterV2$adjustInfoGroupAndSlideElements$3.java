package com.bytedance.android.shopping.store.home.presenter;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class ECShopCroppedStyleRootPresenterV2$adjustInfoGroupAndSlideElements$3 extends MutablePropertyReference0Impl {
    public ECShopCroppedStyleRootPresenterV2$adjustInfoGroupAndSlideElements$3(ECShopCroppedStyleRootPresenterV2 r7) {
        super(r7, ECShopCroppedStyleRootPresenterV2.class, "slideTips", "getSlideTips()Landroid/view/View;", 0);
    }

    public Object get() {
        View r0 = ((ECShopCroppedStyleRootPresenterV2) ((CallableReference) this).receiver).B;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("slideTips");
    L5:
        return r0;
    }

    public void set(Object r2) {
        View r3 = (View) r2;
        ((ECShopCroppedStyleRootPresenterV2) ((CallableReference) this).receiver).B = r3;
    }
}
