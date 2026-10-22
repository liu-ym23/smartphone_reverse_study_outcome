package com.larus.login.api;

import com.larus.login.api.ecommerce.ECommerceApiPath$EcommerceDialogScene;
import com.larus.login.api.ecommerce.EcommerceApi;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.login.api.CommonDouYinLoginKV$setWalletAndPaymentNotificationPopUp$1", f = "CommonDouYinLoginKV.kt", i = {}, l = {62}, m = "invokeSuspend", n = {}, s = {})
public final class CommonDouYinLoginKV$setWalletAndPaymentNotificationPopUp$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $uid;
    int label;

    public CommonDouYinLoginKV$setWalletAndPaymentNotificationPopUp$1(String r100, Continuation<? super CommonDouYinLoginKV$setWalletAndPaymentNotificationPopUp$1> r101) {
        this.$uid = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new CommonDouYinLoginKV$setWalletAndPaymentNotificationPopUp$1(this.$uid, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((CommonDouYinLoginKV$setWalletAndPaymentNotificationPopUp$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L11:
        Boolean r103 = (Boolean) r100;
        if (r103 == null) goto L17;
        String r104 = this.$uid;
        if (r103.booleanValue() == false) goto L17;
        Lazy r105 = CommonDouYinLoginKV.f356938a;
        CommonDouYinLoginKV.a().storeBoolean("ecom_notify_reported_uid_set_" + r104, true);
    L17:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        EcommerceApi r106 = EcommerceApi.f357018a;
        ECommerceApiPath$EcommerceDialogScene r107 = ECommerceApiPath$EcommerceDialogScene.Notify;
        this.label = 1;
        r100 = r106.d(r107, this);
        if (r100 != r101) goto L11;
        return r101;
    }
}
