package com.bytedance.flow.search.kmp.impl.provider.ser;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.flow.search.kmp.impl.provider.ser.RemoteFilterDataSourceProvider$search$2", f = "RemoteFilterDataSourceProvider.kt", i = {}, l = {24}, m = "invokeSuspend", n = {}, s = {})
public final class RemoteFilterDataSourceProvider$search$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $scene;
    int label;
    final /* synthetic */ RemoteFilterDataSourceProvider this$0;

    public RemoteFilterDataSourceProvider$search$2(RemoteFilterDataSourceProvider r100, String r101, Continuation<? super RemoteFilterDataSourceProvider$search$2> r102) {
        this.this$0 = r100;
        this.$scene = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new RemoteFilterDataSourceProvider$search$2(this.this$0, this.$scene, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((RemoteFilterDataSourceProvider$search$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
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
        RemoteFilterDataSourceProvider r103 = this.this$0;
        String r104 = this.$scene;
        this.label = 1;
        int r105 = RemoteFilterDataSourceProvider.f243651b;
        if (r103.b(r104, this) != r101) goto L12;
        return r101;
    }
}
