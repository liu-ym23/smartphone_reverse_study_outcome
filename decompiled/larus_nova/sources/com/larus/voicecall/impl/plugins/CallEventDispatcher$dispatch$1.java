package com.larus.voicecall.impl.plugins;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.plugins.CallEventDispatcher$dispatch$1", f = "CallEventDispatcher.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class CallEventDispatcher$dispatch$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<com.larus.voicecall.impl.scene.a, Unit> $block;
    int label;
    final /* synthetic */ CallEventDispatcher this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public CallEventDispatcher$dispatch$1(CallEventDispatcher r100, Function1<? super com.larus.voicecall.impl.scene.a, Unit> r101, Continuation<? super CallEventDispatcher$dispatch$1> r102) {
        this.this$0 = r100;
        this.$block = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new CallEventDispatcher$dispatch$1(this.this$0, this.$block, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((CallEventDispatcher$dispatch$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L11;
        ResultKt.throwOnFailure(r100);
        CopyOnWriteArrayList<com.larus.voicecall.impl.scene.a> r101 = this.this$0.f378414a;
        Function1<com.larus.voicecall.impl.scene.a, Unit> r102 = this.$block;
        Iterator<T> r103 = r101.iterator();
    L6:
        if (r103.hasNext() == false) goto L9;
        com.larus.voicecall.impl.scene.a r104 = (com.larus.voicecall.impl.scene.a) r103.next();
        Intrinsics.checkNotNull(r104);
        r102.invoke(r104);
        goto L6
    L9:
        return Unit.INSTANCE;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
