package com.larus.login.api.ecommerce;

import com.larus.utils.logger.FLogger;
import java.util.concurrent.CancellationException;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* JADX INFO: loaded from: classes30.dex */
public final class ECommerceAuthorizedCouponHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ECommerceAuthorizedCouponHelper f357015a = null;

    static {
        f357015a = new ECommerceAuthorizedCouponHelper();
    }

    public ECommerceAuthorizedCouponHelper() {
    }

    public final Object a(String r100, Continuation<? super c> r101) {
        if ((r101 instanceof ECommerceAuthorizedCouponHelper$applyAuthorizedCoupon$1) == false) goto L7;
        ECommerceAuthorizedCouponHelper$applyAuthorizedCoupon$1 r102 = (ECommerceAuthorizedCouponHelper$applyAuthorizedCoupon$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L19;
        if (r106 != 1) goto L18;
        ResultKt.throwOnFailure(r104);     // Catch: Exception -> L13 CancellationException -> L15
    L25:
    L32:
        return (c) r104;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        ResultKt.throwOnFailure(r104);
        if (r100 != null) goto L22;
        return null;
    L22:
        EcommerceApi r107 = EcommerceApi.f357018a;     // Catch: Exception -> L13 CancellationException -> L15
        r102.label = 1;     // Catch: Exception -> L13 CancellationException -> L15
        r104 = r107.a(r100, r102);     // Catch: Exception -> L13 CancellationException -> L15
        if (r104 != r105) goto L25;
        return r105;
    L15:
        e = move-exception;
        throw e;
    L13:
        e = move-exception;
        FLogger.f375446a.e("ECommerceAuthorizedCouponHelper", "EcommerceApi.applyAuthorizedCoupon fail", e);
        return null;
    L7:
        r102 = new ECommerceAuthorizedCouponHelper$applyAuthorizedCoupon$1(this, r101);
        goto L8
    }
}
