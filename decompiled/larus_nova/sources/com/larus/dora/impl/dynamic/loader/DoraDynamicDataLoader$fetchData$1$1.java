package com.larus.dora.impl.dynamic.loader;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.dynamic.loader.DoraDynamicDataLoader$fetchData$1$1", f = "DoraDynamicDataLoader.kt", i = {}, l = {61}, m = "invokeSuspend", n = {}, s = {})
final class DoraDynamicDataLoader$fetchData$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ a.b $callback;
    final /* synthetic */ String $key;
    final /* synthetic */ String $model;
    final /* synthetic */ String $pageKey;
    final /* synthetic */ Integer $productId;
    int label;
    final /* synthetic */ a this$0;

    public DoraDynamicDataLoader$fetchData$1$1(a r100, Integer r101, String r102, String r103, String r104, a.b r105, Continuation<? super DoraDynamicDataLoader$fetchData$1$1> r106) {
        this.this$0 = r100;
        this.$productId = r101;
        this.$model = r102;
        this.$pageKey = r103;
        this.$key = r104;
        this.$callback = r105;
        super(2, r106);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r110) {
        return new DoraDynamicDataLoader$fetchData$1$1(this.this$0, this.$productId, this.$model, this.$pageKey, this.$key, this.$callback, r110);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((DoraDynamicDataLoader$fetchData$1$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        a r103 = this.this$0;
        Integer r104 = this.$productId;
        String r105 = this.$model;
        String r106 = this.$pageKey;
        String r107 = this.$key;
        a.b r108 = this.$callback;
        this.label = 1;
        if (a.a(r103, r104, r105, r106, r107, r108, this) != r101) goto L12;
        return r101;
    }
}
