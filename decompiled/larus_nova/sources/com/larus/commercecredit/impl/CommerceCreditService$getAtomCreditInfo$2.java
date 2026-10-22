package com.larus.commercecredit.impl;

import com.larus.commercecredit.api.CreditInfoScene;
import com.larus.commercecredit.impl.utils.CommerceCreditConfigManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.commercecredit.impl.CommerceCreditService$getAtomCreditInfo$2", f = "CommerceCreditService.kt", i = {}, l = {80}, m = "invokeSuspend", n = {}, s = {})
public final class CommerceCreditService$getAtomCreditInfo$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<oz8.a, Boolean, Unit> $callback;
    final /* synthetic */ boolean $needTasks;
    final /* synthetic */ CreditInfoScene $scene;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public CommerceCreditService$getAtomCreditInfo$2(CreditInfoScene r100, boolean r101, Function2<? super oz8.a, ? super Boolean, Unit> r102, Continuation<? super CommerceCreditService$getAtomCreditInfo$2> r103) {
        this.$scene = r100;
        this.$needTasks = r101;
        this.$callback = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new CommerceCreditService$getAtomCreditInfo$2(this.$scene, this.$needTasks, this.$callback, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((CommerceCreditService$getAtomCreditInfo$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 == 0) goto L8;
        if (r101 != 1) goto L7;
        ResultKt.throwOnFailure(r110);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r110);
        CommerceCreditConfigManager r111 = CommerceCreditConfigManager.f325801a;
        CreditInfoScene r102 = this.$scene;
        boolean r103 = this.$needTasks;
        final Function2<oz8.a, Boolean, Unit> r112 = this.$callback;
        Function3 r104 = new a(r112);
        this.label = 1;
        if (CommerceCreditConfigManager.b(r102, r103, false, null, null, r104, this, 28) != r100) goto L12;
        return r100;
    }
}
