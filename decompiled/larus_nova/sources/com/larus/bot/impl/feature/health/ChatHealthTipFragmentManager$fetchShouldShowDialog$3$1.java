package com.larus.bot.impl.feature.health;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.feature.health.ChatHealthTipFragmentManager$fetchShouldShowDialog$3$1", f = "ChatHealthTipFragmentManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ChatHealthTipFragmentManager$fetchShouldShowDialog$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<Boolean, Boolean, Unit> $callback;
    final /* synthetic */ GetSafetyInstructionResponse $it;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public ChatHealthTipFragmentManager$fetchShouldShowDialog$3$1(GetSafetyInstructionResponse r100, Function2<? super Boolean, ? super Boolean, Unit> r101, Continuation<? super ChatHealthTipFragmentManager$fetchShouldShowDialog$3$1> r102) {
        this.$it = r100;
        this.$callback = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new ChatHealthTipFragmentManager$fetchShouldShowDialog$3$1(this.$it, this.$callback, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((ChatHealthTipFragmentManager$fetchShouldShowDialog$3$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L11;
        ResultKt.throwOnFailure(r100);
        if (this.$it.getShowSafetyInstruction() != null) goto L7;
        this.$callback.invoke(Boxing.boxBoolean(false), Boxing.boxBoolean(false));
    L9:
        return Unit.INSTANCE;
    L7:
        this.$callback.invoke(Boxing.boxBoolean(true), this.$it.getShowSafetyInstruction());
        goto L9
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
