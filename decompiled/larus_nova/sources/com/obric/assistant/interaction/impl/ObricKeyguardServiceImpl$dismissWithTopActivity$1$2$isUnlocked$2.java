package com.obric.assistant.interaction.impl;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.interaction.impl.ObricKeyguardServiceImpl$dismissWithTopActivity$1$2$isUnlocked$2", f = "ObricKeyguardServiceImpl.kt", i = {}, l = {221}, m = "invokeSuspend", n = {}, s = {})
public final class ObricKeyguardServiceImpl$dismissWithTopActivity$1$2$isUnlocked$2 extends SuspendLambda implements Function2<Long, Continuation<? super Unit>, Object> {
    /* synthetic */ long J$0;
    int label;

    public ObricKeyguardServiceImpl$dismissWithTopActivity$1$2$isUnlocked$2(Continuation<? super ObricKeyguardServiceImpl$dismissWithTopActivity$1$2$isUnlocked$2> r100) {
        super(2, r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        ObricKeyguardServiceImpl$dismissWithTopActivity$1$2$isUnlocked$2 r102 = new ObricKeyguardServiceImpl$dismissWithTopActivity$1$2$isUnlocked$2(r101);
        r102.J$0 = ((Number) r100).longValue();
        return r102;
    }

    public final Object invoke(long r100, Continuation<? super Unit> r101) {
        return ((ObricKeyguardServiceImpl$dismissWithTopActivity$1$2$isUnlocked$2) create(Long.valueOf(r100), r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Long r100, Continuation<? super Unit> r101) {
        return invoke(r100.longValue(), r101);
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
        long r103 = this.J$0;
        this.label = 1;
        if (DelayKt.delay(r103, this) != r101) goto L12;
        return r101;
    }
}
