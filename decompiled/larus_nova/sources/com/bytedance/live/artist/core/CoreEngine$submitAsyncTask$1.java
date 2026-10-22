package com.bytedance.live.artist.core;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 16})
@DebugMetadata(c = "com.bytedance.live.artist.core.CoreEngine$submitAsyncTask$1", f = "CoreEngine.kt", i = {0}, l = {117}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
final class CoreEngine$submitAsyncTask$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Runnable $runnable;
    Object L$0;
    int label;
    private CoroutineScope p$;
    final /* synthetic */ CoreEngine this$0;

    public CoreEngine$submitAsyncTask$1(CoreEngine r100, Runnable r101, Continuation r102) {
        this.this$0 = r100;
        this.$runnable = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        CoreEngine$submitAsyncTask$1 r102 = new CoreEngine$submitAsyncTask$1(this.this$0, this.$runnable, r101);
        r102.p$ = (CoroutineScope) r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((CoreEngine$submitAsyncTask$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        CoroutineScope r103 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r100);
    L14:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        CoroutineScope r104 = this.p$;
        Channel<Runnable> r105 = this.this$0.f254801h;
        if (r105 == null) goto L14;
        Runnable r106 = this.$runnable;
        this.L$0 = r104;
        this.label = 1;
        if (r105.send(r106, this) != r101) goto L14;
        return r101;
    }
}
