package com.bytedance.android.livesdk.livecommerce.promotionlist;

import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class LivePromotionListFragment$subscriberDelegate$1$getRootView$1 extends MutablePropertyReference0Impl {
    public LivePromotionListFragment$subscriberDelegate$1$getRootView$1(LivePromotionListFragment r7) {
        super(r7, LivePromotionListFragment.class, "rootView", "getRootView()Landroid/view/ViewGroup;", 0);
    }

    public Object get() {
        ViewGroup r0 = ((LivePromotionListFragment) ((CallableReference) this).receiver).k;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L5:
        return r0;
    }

    public void set(Object r2) {
        ViewGroup r3 = (ViewGroup) r2;
        ((LivePromotionListFragment) ((CallableReference) this).receiver).k = r3;
    }
}
