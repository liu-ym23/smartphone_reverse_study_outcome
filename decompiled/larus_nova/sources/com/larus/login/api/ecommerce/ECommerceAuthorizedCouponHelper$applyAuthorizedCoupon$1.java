package com.larus.login.api.ecommerce;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.login.api.ecommerce.ECommerceAuthorizedCouponHelper", f = "ECommerceAuthorizedCouponHelper.kt", i = {}, l = {16}, m = "applyAuthorizedCoupon", n = {}, s = {})
public final class ECommerceAuthorizedCouponHelper$applyAuthorizedCoupon$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ECommerceAuthorizedCouponHelper this$0;

    public ECommerceAuthorizedCouponHelper$applyAuthorizedCoupon$1(ECommerceAuthorizedCouponHelper r100, Continuation<? super ECommerceAuthorizedCouponHelper$applyAuthorizedCoupon$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, this);
    }
}
