package com.larus.login.impl.multiaccount;

import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.login.impl.multiaccount.MultiAccountOperationCoordinator$switchAccount$1$1", f = "MultiAccountOperationCoordinator.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MultiAccountOperationCoordinator$switchAccount$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Boolean, Unit> $onSwitchResult;
    final /* synthetic */ boolean $switched;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public MultiAccountOperationCoordinator$switchAccount$1$1(Function1<? super Boolean, Unit> r100, boolean r101, Continuation<? super MultiAccountOperationCoordinator$switchAccount$1$1> r102) {
        this.$onSwitchResult = r100;
        this.$switched = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        MultiAccountOperationCoordinator$switchAccount$1$1 r102 = new MultiAccountOperationCoordinator$switchAccount$1$1(this.$onSwitchResult, this.$switched, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((MultiAccountOperationCoordinator$switchAccount$1$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L19;
        ResultKt.throwOnFailure(r100);
        CoroutineScope r101 = (CoroutineScope) this.L$0;
        Function1<Boolean, Unit> r102 = this.$onSwitchResult;
        boolean r103 = this.$switched;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L11
        if (r103 == false) goto L8;
        boolean r105 = true;
    L9:
        r102.invoke(Boxing.boxBoolean(r105));     // Catch: Throwable -> L11
        Object r106 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L13:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
        if (r107 == null) goto L17;
        FLogger.f375446a.e("MultiAccountOperation", "Account switch result callback failed: " + r107.getMessage());
    L17:
        return Unit.INSTANCE;
    L8:
        r105 = false;
    L11:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L13
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
