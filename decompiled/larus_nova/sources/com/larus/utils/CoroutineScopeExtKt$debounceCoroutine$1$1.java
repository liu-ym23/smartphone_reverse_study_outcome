package com.larus.utils;

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
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.utils.CoroutineScopeExtKt$debounceCoroutine$1$1", f = "CoroutineScopeExt.kt", i = {}, l = {25, 26}, m = "invokeSuspend", n = {}, s = {})
final class CoroutineScopeExtKt$debounceCoroutine$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Continuation<? super Unit>, Object> $block;
    final /* synthetic */ long $delayMillis;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public CoroutineScopeExtKt$debounceCoroutine$1$1(long r100, Function1<? super Continuation<? super Unit>, ? extends Object> r101, Continuation<? super CoroutineScopeExtKt$debounceCoroutine$1$1> r102) {
        this.$delayMillis = r100;
        this.$block = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new CoroutineScopeExtKt$debounceCoroutine$1$1(this.$delayMillis, this.$block, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((CoroutineScopeExtKt$debounceCoroutine$1$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L10;
        if (r102 == 1) goto L9;
        if (r102 != 2) goto L8;
        ResultKt.throwOnFailure(r100);
    L17:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r100);
    L13:
        Function1<Continuation<? super Unit>, Object> r103 = this.$block;
        this.label = 2;
        if (r103.invoke(this) != r101) goto L17;
        return r101;
    L10:
        ResultKt.throwOnFailure(r100);
        long r104 = this.$delayMillis;
        this.label = 1;
        if (DelayKt.delay(r104, this) != r101) goto L13;
        return r101;
    }
}
