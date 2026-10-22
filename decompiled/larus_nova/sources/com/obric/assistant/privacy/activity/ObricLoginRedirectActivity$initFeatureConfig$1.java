package com.obric.assistant.privacy.activity;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.product.api.IObricProduct;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.privacy.activity.ObricLoginRedirectActivity$initFeatureConfig$1", f = "ObricLoginRedirectActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ObricLoginRedirectActivity$initFeatureConfig$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ObricLoginRedirectActivity this$0;

    public ObricLoginRedirectActivity$initFeatureConfig$1(ObricLoginRedirectActivity r100, Continuation<? super ObricLoginRedirectActivity$initFeatureConfig$1> r101) {
        this.this$0 = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new ObricLoginRedirectActivity$initFeatureConfig$1(this.this$0, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((ObricLoginRedirectActivity$initFeatureConfig$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L15;
        ResultKt.throwOnFailure(r100);
        FLogger r101 = FLogger.f375446a;     // Catch: Exception -> L10
        r101.i("TAG_ObricLoginRedirectActivity", this.this$0 + " Start initProductSdk() asynchronously");     // Catch: Exception -> L10
        IObricProduct.f391167a.getClass();     // Catch: Exception -> L10
        IObricProduct r102 = IObricProduct.a.a();     // Catch: Exception -> L10
        if (r102 == null) goto L8;
        r102.a();     // Catch: Exception -> L10
    L8:
        r101.i("TAG_ObricLoginRedirectActivity", this.this$0 + " initProductSdk() completed successfully");     // Catch: Exception -> L10
        this.this$0.f391073d.complete(Unit.INSTANCE);     // Catch: Exception -> L10
    L13:
        return Unit.INSTANCE;
    L10:
        e = move-exception;
        FLogger.f375446a.e("TAG_ObricLoginRedirectActivity", this.this$0 + " Error in initProductSdk()", e);
        this.this$0.f391073d.completeExceptionally(e);
        goto L13
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
