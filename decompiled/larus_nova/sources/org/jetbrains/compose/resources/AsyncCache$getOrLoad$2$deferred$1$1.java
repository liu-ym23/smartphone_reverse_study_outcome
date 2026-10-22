package org.jetbrains.compose.resources;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes42.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "V", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "org.jetbrains.compose.resources.AsyncCache$getOrLoad$2$deferred$1$1", f = "ResourceCaches.kt", i = {}, l = {23}, m = "invokeSuspend", n = {}, s = {})
public final class AsyncCache$getOrLoad$2$deferred$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<Object>, Object> {
    final /* synthetic */ Function1<Continuation<Object>, Object> $load;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public AsyncCache$getOrLoad$2$deferred$1$1(Function1<? super Continuation<Object>, ? extends Object> r100, Continuation<? super AsyncCache$getOrLoad$2$deferred$1$1> r101) {
        this.$load = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new AsyncCache$getOrLoad$2$deferred$1$1(this.$load, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<Object> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<Object> r101) {
        return ((AsyncCache$getOrLoad$2$deferred$1$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L11:
        return r100;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        Function1<Continuation<Object>, Object> r103 = this.$load;
        this.label = 1;
        r100 = r103.invoke(this);
        if (r100 != r101) goto L11;
        return r101;
    }
}
