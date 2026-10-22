package com.larus.dora.impl.ota.check;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "Lcom/larus/dora/api/ota/model/DoraOTAResponseWrapper;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.ota.check.DoraOTACheckRepository$checkUpdate$3$normalResponseDeferred$1", f = "DoraOTACheckRepository.kt", i = {}, l = {61}, m = "invokeSuspend", n = {}, s = {})
public final class DoraOTACheckRepository$checkUpdate$3$normalResponseDeferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends e49.a>>, Object> {
    final /* synthetic */ String $buildTime;
    final /* synthetic */ String $buildType;
    final /* synthetic */ d $dataSource;
    final /* synthetic */ String $model;
    final /* synthetic */ String $osVersion;
    final /* synthetic */ String $pkgType;
    final /* synthetic */ String $product;
    final /* synthetic */ String $romVersion;
    final /* synthetic */ String $sn;
    int label;

    public DoraOTACheckRepository$checkUpdate$3$normalResponseDeferred$1(d r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, String r108, Continuation<? super DoraOTACheckRepository$checkUpdate$3$normalResponseDeferred$1> r110) {
        this.$dataSource = r100;
        this.$product = r101;
        this.$model = r102;
        this.$sn = r103;
        this.$osVersion = r104;
        this.$romVersion = r105;
        this.$buildTime = r106;
        this.$pkgType = r107;
        this.$buildType = r108;
        super(2, r110);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r110, Continuation<?> r111) {
        return new DoraOTACheckRepository$checkUpdate$3$normalResponseDeferred$1(this.$dataSource, this.$product, this.$model, this.$sn, this.$osVersion, this.$romVersion, this.$buildTime, this.$pkgType, this.$buildType, r111);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Result<? extends e49.a>> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Result<e49.a>> r101) {
        return ((DoraOTACheckRepository$checkUpdate$3$normalResponseDeferred$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 == 0) goto L8;
        if (r101 != 1) goto L7;
        ResultKt.throwOnFailure(r110);
        Object r111 = ((Result) r110).m9458unboximpl();
    L12:
        return Result.m9448boximpl(r111);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r110);
        d r102 = this.$dataSource;
        String r112 = this.$product;
        String r103 = this.$model;
        String r104 = this.$sn;
        String r105 = this.$osVersion;
        String r106 = this.$romVersion;
        String r107 = this.$buildTime;
        String r108 = this.$pkgType;
        String r109 = this.$buildType;
        this.label = 1;
        r111 = r102.a(r112, r103, r104, r105, r106, r107, r108, r109, this);
        if (r111 != r100) goto L12;
        return r100;
    }
}
