package com.larus.livetutor.impl.typing.looper;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.livetutor.impl.typing.looper.TypingLooper$startLoop$1", f = "TypingLooper.kt", i = {}, l = {51, 52}, m = "invokeSuspend", n = {}, s = {})
public final class TypingLooper$startLoop$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ TypingLooper this$0;

    public TypingLooper$startLoop$1(TypingLooper r100, Continuation<? super TypingLooper$startLoop$1> r101) {
        this.this$0 = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new TypingLooper$startLoop$1(this.this$0, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((TypingLooper$startLoop$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L10;
        if (r102 == 1) goto L9;
        if (r102 != 2) goto L8;
        ResultKt.throwOnFailure(r100);
    L22:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r100);
    L15:
        TypingLooper r103 = this.this$0;
        this.label = 2;
        int r104 = TypingLooper.f356605h;
        r103.getClass();
        Object r105 = CoroutineScopeKt.coroutineScope(new TypingLooper$loop$2(r103, null), this);
        if (r105 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L19;
        r105 = Unit.INSTANCE;
    L19:
        if (r105 != r101) goto L22;
        return r101;
    L10:
        ResultKt.throwOnFailure(r100);
        TypingLooper r106 = this.this$0;
        TypingLooper.c r107 = r106.f356609d;
        if (r107 == null) goto L15;
        long r108 = r106.f356610e.getTime();
        this.label = 1;
        if (r107.e(0, r108, this) != r101) goto L15;
        return r101;
    }
}
