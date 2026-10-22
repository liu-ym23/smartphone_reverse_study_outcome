package com.obric.assistant.impl;

import com.larus.bmhome.instruction.g;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import laa.j;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.impl.ObricSpecialInputServiceImpl$closeSpecialInputBeforeMicOn$1", f = "ObricSpecialInputServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ObricSpecialInputServiceImpl$closeSpecialInputBeforeMicOn$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ g $instructionInputAbility;
    final /* synthetic */ Boolean $instructionOpen;
    final /* synthetic */ Boolean $isObricSpecialInputOpen;
    final /* synthetic */ j $obricSpecialInputAbility;
    int label;

    public ObricSpecialInputServiceImpl$closeSpecialInputBeforeMicOn$1(Boolean r100, Boolean r101, j r102, g r103, Continuation<? super ObricSpecialInputServiceImpl$closeSpecialInputBeforeMicOn$1> r104) {
        this.$instructionOpen = r100;
        this.$isObricSpecialInputOpen = r101;
        this.$obricSpecialInputAbility = r102;
        this.$instructionInputAbility = r103;
        super(2, r104);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new ObricSpecialInputServiceImpl$closeSpecialInputBeforeMicOn$1(this.$instructionOpen, this.$isObricSpecialInputOpen, this.$obricSpecialInputAbility, this.$instructionInputAbility, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((ObricSpecialInputServiceImpl$closeSpecialInputBeforeMicOn$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L13;
        ResultKt.throwOnFailure(r100);
        if (Intrinsics.areEqual(this.$instructionOpen, Boxing.boxBoolean(true)) == false) goto L11;
        if (Intrinsics.areEqual(this.$isObricSpecialInputOpen, Boxing.boxBoolean(true)) == false) goto L9;
        this.$obricSpecialInputAbility.e90();
        goto L11
    L9:
        this.$instructionInputAbility.A1();
    L11:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
