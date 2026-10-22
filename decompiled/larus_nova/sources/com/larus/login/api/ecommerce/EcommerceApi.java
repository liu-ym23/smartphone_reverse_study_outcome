package com.larus.login.api.ecommerce;

import com.larus.network.http.HttpExtKt;
import com.larus.network.http.ServiceType;
import com.larus.network.http.y;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes30.dex */
public final class EcommerceApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final EcommerceApi f357018a = null;

    static {
        f357018a = new EcommerceApi();
    }

    public EcommerceApi() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object a(String r110, Continuation<? super c> r111) {
        if ((r111 instanceof EcommerceApi$applyAuthorizedCoupon$1) == false) goto L7;
        EcommerceApi$applyAuthorizedCoupon$1 r100 = (EcommerceApi$applyAuthorizedCoupon$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        EcommerceApi$applyAuthorizedCoupon$1 r112 = r100;
        Object r113 = r112.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r112.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        ResultKt.throwOnFailure(r113);
    L17:
        com.larus.network.http.a r114 = (com.larus.network.http.a) r113;
        if ((r114 instanceof y) == true) goto L22;
        return null;
    L22:
        return (c) ((y) r114).f360135b;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r113);
        JSONObject r104 = new JSONObject();
        r104.put("extra", r110);
        Unit r115 = Unit.INSTANCE;
        r112.label = 1;
        r113 = HttpExtKt.k(ServiceType.ECOMMERCE, c.class, "/alice/e_commerce/apply_authorized_coupon", r104, null, null, false, null, null, null, r112, 1008);
        if (r113 != r102) goto L17;
        return r102;
    L7:
        r100 = new EcommerceApi$applyAuthorizedCoupon$1(this, r111);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object b(ECommerceApiPath$EcommerceDialogScene r110, Continuation<? super Boolean> r111) {
        if ((r111 instanceof EcommerceApi$checkDialog$1) == false) goto L7;
        EcommerceApi$checkDialog$1 r100 = (EcommerceApi$checkDialog$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        EcommerceApi$checkDialog$1 r112 = r100;
        Object r113 = r112.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r112.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        ResultKt.throwOnFailure(r113);
    L17:
        com.larus.network.http.a r114 = (com.larus.network.http.a) r113;
        if ((r114 instanceof y) == false) goto L22;
        a r115 = (a) ((y) r114).f360135b;
        if (r115 == null) goto L22;
        return r115.a();
    L22:
        return null;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r113);
        JSONObject r104 = new JSONObject();
        r104.put("scene", r110.getValue());
        Unit r116 = Unit.INSTANCE;
        r112.label = 1;
        r113 = HttpExtKt.k(ServiceType.ECOMMERCE, a.class, "/alice/e_commerce/dialog/check", r104, null, null, false, null, null, null, r112, 1008);
        if (r113 != r102) goto L17;
        return r102;
    L7:
        r100 = new EcommerceApi$checkDialog$1(this, r111);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object c(ECommerceApiPath$EcommerceTextConfigScene r110, Continuation<? super m> r111) {
        if ((r111 instanceof EcommerceApi$fetchTextConfigMap$1) == false) goto L7;
        EcommerceApi$fetchTextConfigMap$1 r100 = (EcommerceApi$fetchTextConfigMap$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        EcommerceApi$fetchTextConfigMap$1 r112 = r100;
        Object r113 = r112.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r112.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        ResultKt.throwOnFailure(r113);
    L20:
        com.larus.network.http.a r114 = (com.larus.network.http.a) r113;
        if ((r114 instanceof y) == true) goto L25;
        return null;
    L25:
        return (m) ((y) r114).f360135b;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r113);
        JSONObject r104 = new JSONObject();
        if (r110 == null) goto L17;
        r104.put("scene", r110.getValue());
    L17:
        Unit r115 = Unit.INSTANCE;
        r112.label = 1;
        r113 = HttpExtKt.k(ServiceType.ECOMMERCE, m.class, "/alice/e_commerce/text_config", r104, null, null, false, null, null, null, r112, 1008);
        if (r113 != r102) goto L20;
        return r102;
    L7:
        r100 = new EcommerceApi$fetchTextConfigMap$1(this, r111);
        goto L8
    }

    public final Object d(ECommerceApiPath$EcommerceDialogScene r110, Continuation<? super Boolean> r111) {
        if ((r111 instanceof EcommerceApi$reportDialog$1) == false) goto L7;
        EcommerceApi$reportDialog$1 r100 = (EcommerceApi$reportDialog$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        EcommerceApi$reportDialog$1 r112 = r100;
        Object r113 = r112.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r112.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        ResultKt.throwOnFailure(r113);
    L18:
        return Boxing.boxBoolean(((com.larus.network.http.a) r113) instanceof y);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r113);
        JSONObject r104 = new JSONObject();
        r104.put("scene", r110.getValue());
        Unit r114 = Unit.INSTANCE;
        r112.label = 1;
        r113 = HttpExtKt.k(ServiceType.ECOMMERCE, p.class, "/alice/e_commerce/dialog/report", r104, null, null, false, null, null, null, r112, 1008);
        if (r113 != r102) goto L18;
        return r102;
    L7:
        r100 = new EcommerceApi$reportDialog$1(this, r111);
        goto L8
    }
}
