package com.larus.im.internal.core.message;

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

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.im.internal.core.message.AddLocalMessageProcessor$singleRun$1", f = "AddLocalMessageProcessor.kt", i = {0, 1}, l = {93, 64}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$0"})
final class AddLocalMessageProcessor$singleRun$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Continuation<? super Unit>, Object> $block;
    Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public AddLocalMessageProcessor$singleRun$1(Function1<? super Continuation<? super Unit>, ? extends Object> r100, Continuation<? super AddLocalMessageProcessor$singleRun$1> r101) {
        this.$block = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new AddLocalMessageProcessor$singleRun$1(this.$block, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((AddLocalMessageProcessor$singleRun$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L14;
        if (r102 == 1) goto L13;
        if (r102 != 2) goto L12;
        kotlinx.coroutines.sync.a r103 = (kotlinx.coroutines.sync.a) this.L$0;
        ResultKt.throwOnFailure(r100);     // Catch: Throwable -> L9
    L21:
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L9
        r103.unlock(null);
        return Unit.INSTANCE;
    L9:
        th = move-exception;
        kotlinx.coroutines.sync.a r105 = r103;
        th = th;
        kotlinx.coroutines.sync.a r106 = r105;
    L26:
        r106.unlock(null);
        throw th;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L13:
        Function1<Continuation<? super Unit>, Object> r107 = (Function1) this.L$1;
        kotlinx.coroutines.sync.a r108 = (kotlinx.coroutines.sync.a) this.L$0;
        ResultKt.throwOnFailure(r100);
        r106 = r108;
    L30:
        this.L$0 = r106;     // Catch: Throwable -> L25
        this.L$1 = null;     // Catch: Throwable -> L25
        this.label = 2;     // Catch: Throwable -> L25
        if (r107.invoke(this) != r101) goto L20;
        return r101;
    L20:
        r103 = r106;
    L25:
        th = th;
        goto L26
    L14:
        ResultKt.throwOnFailure(r100);
        r106 = AddLocalMessageProcessor.f347725d;
        r107 = this.$block;
        this.L$0 = r106;
        this.L$1 = r107;
        this.label = 1;
        if (r106.a(null, this) != r101) goto L30;
        return r101;
    }
}
