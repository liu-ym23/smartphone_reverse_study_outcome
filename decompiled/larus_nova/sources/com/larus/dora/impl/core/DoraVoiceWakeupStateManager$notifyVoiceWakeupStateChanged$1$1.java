package com.larus.dora.impl.core;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.core.DoraVoiceWakeupStateManager$notifyVoiceWakeupStateChanged$1$1", f = "DoraVoiceWakeupStateManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DoraVoiceWakeupStateManager$notifyVoiceWakeupStateChanged$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ t39.x $it;
    final /* synthetic */ boolean $state;
    private /* synthetic */ Object L$0;
    int label;

    public DoraVoiceWakeupStateManager$notifyVoiceWakeupStateChanged$1$1(t39.x r100, boolean r101, Continuation<? super DoraVoiceWakeupStateManager$notifyVoiceWakeupStateChanged$1$1> r102) {
        this.$it = r100;
        this.$state = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        DoraVoiceWakeupStateManager$notifyVoiceWakeupStateChanged$1$1 r102 = new DoraVoiceWakeupStateManager$notifyVoiceWakeupStateChanged$1$1(this.$it, this.$state, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((DoraVoiceWakeupStateManager$notifyVoiceWakeupStateChanged$1$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L19;
        ResultKt.throwOnFailure(r100);
        CoroutineScope r101 = (CoroutineScope) this.L$0;
        t39.x r102 = this.$it;
        boolean r103 = this.$state;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L11
        long r105 = System.currentTimeMillis();     // Catch: Throwable -> L11
        if (r103 == false) goto L8;
        boolean r106 = true;
    L9:
        r102.a(r106);     // Catch: Throwable -> L11
        g49.d.d("DoraVoiceWakeupStateManager", "notifyVoiceWakeupStateChanged: " + r102 + " consume: " + (System.currentTimeMillis() - r105));     // Catch: Throwable -> L11
        Object r107 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L13:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);
        if (r108 == null) goto L17;
        g49.d.c("DoraVoiceWakeupStateManager", "notifyVoiceWakeupStateChanged: " + r108 + " exception", r108);
    L17:
        return Unit.INSTANCE;
    L8:
        r106 = false;
    L11:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L13
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
