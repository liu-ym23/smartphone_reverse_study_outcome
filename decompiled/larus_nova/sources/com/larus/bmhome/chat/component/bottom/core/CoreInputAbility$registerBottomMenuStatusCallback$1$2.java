package com.larus.bmhome.chat.component.bottom.core;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.core.CoreInputAbility$registerBottomMenuStatusCallback$1$2", f = "CoreInputAbility.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class CoreInputAbility$registerBottomMenuStatusCallback$1$2 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Boolean, Unit> $callback;
    /* synthetic */ boolean Z$0;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public CoreInputAbility$registerBottomMenuStatusCallback$1$2(Function1<? super Boolean, Unit> r100, Continuation<? super CoreInputAbility$registerBottomMenuStatusCallback$1$2> r101) {
        this.$callback = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        CoreInputAbility$registerBottomMenuStatusCallback$1$2 r102 = new CoreInputAbility$registerBottomMenuStatusCallback$1$2(this.$callback, r101);
        r102.Z$0 = ((Boolean) r100).booleanValue();
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Boolean r100, Continuation<? super Unit> r101) {
        return invoke(r100.booleanValue(), r101);
    }

    public final Object invoke(boolean r100, Continuation<? super Unit> r101) {
        return ((CoreInputAbility$registerBottomMenuStatusCallback$1$2) create(Boolean.valueOf(r100), r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        boolean r101 = this.Z$0;
        this.$callback.invoke(Boxing.boxBoolean(r101));
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
