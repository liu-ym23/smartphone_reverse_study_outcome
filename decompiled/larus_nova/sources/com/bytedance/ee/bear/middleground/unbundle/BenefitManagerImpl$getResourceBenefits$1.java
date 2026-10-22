package com.bytedance.ee.bear.middleground.unbundle;

import com.bytedance.ee.bear.unbundle.BenefitManagerAPI;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ee.bear.middleground.unbundle.BenefitManagerImpl$getResourceBenefits$1", f = "BenefitManagerImpl.kt", i = {}, l = {110}, m = "invokeSuspend", n = {}, s = {})
final class BenefitManagerImpl$getResourceBenefits$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BenefitManagerAPI.CacheType $cacheType;
    final /* synthetic */ String $ownerID;
    final /* synthetic */ String $token;
    final /* synthetic */ int $type;
    int label;
    final /* synthetic */ BenefitManagerImpl this$0;

    public BenefitManagerImpl$getResourceBenefits$1(BenefitManagerImpl r100, String r101, int r102, String r103, BenefitManagerAPI.CacheType r104, Continuation<? super BenefitManagerImpl$getResourceBenefits$1> r105) {
        this.this$0 = r100;
        this.$token = r101;
        this.$type = r102;
        this.$ownerID = r103;
        this.$cacheType = r104;
        super(2, r105);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new BenefitManagerImpl$getResourceBenefits$1(this.this$0, this.$token, this.$type, this.$ownerID, this.$cacheType, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((BenefitManagerImpl$getResourceBenefits$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 == 0) goto L8;
        if (r101 != 1) goto L7;
        ResultKt.throwOnFailure(r110);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r110);
        BenefitManagerImpl r102 = this.this$0;
        String r111 = this.$token;
        int r103 = this.$type;
        String r104 = this.$ownerID;
        BenefitManagerAPI.CacheType r105 = this.$cacheType;
        this.label = 1;
        if (BenefitManagerImpl.a(r102, r111, r103, r104, r105, false, this, 16) != r100) goto L12;
        return r100;
    }
}
