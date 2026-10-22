package com.github.alexzhirkevich.customqrgenerator;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.IntRange;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.github.alexzhirkevich.customqrgenerator.ThreadPolicy$DoubleThread$invoke$2$1$1", f = "QrCodeGenerator.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ThreadPolicy$DoubleThread$invoke$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<IntRange, IntRange, Unit> $block;
    final /* synthetic */ Pair<IntRange, IntRange> $it;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public ThreadPolicy$DoubleThread$invoke$2$1$1(Function2<? super IntRange, ? super IntRange, Unit> r100, Pair<IntRange, IntRange> r101, Continuation<? super ThreadPolicy$DoubleThread$invoke$2$1$1> r102) {
        this.$block = r100;
        this.$it = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new ThreadPolicy$DoubleThread$invoke$2$1$1(this.$block, this.$it, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((ThreadPolicy$DoubleThread$invoke$2$1$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        this.$block.invoke(this.$it.getFirst(), this.$it.getSecond());
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
