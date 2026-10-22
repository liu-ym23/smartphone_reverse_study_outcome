package com.larus.canvas.feature.component.base;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.canvas.feature.component.base.AbsUIComponent$sendUIEvent$1", f = "AbsUIComponent.kt", i = {}, l = {37}, m = "invokeSuspend", n = {}, s = {})
public final class AbsUIComponent$sendUIEvent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: Incorrect field signature: TE; */
    final /* synthetic */ c $event;
    int label;
    final /* synthetic */ AbsUIComponent<S, E, A> this$0;

    /* JADX WARN: Incorrect types in method signature: (Lcom/larus/canvas/feature/component/base/AbsUIComponent<TS;TE;TA;>;TE;Lkotlin/coroutines/Continuation<-Lcom/larus/canvas/feature/component/base/AbsUIComponent$sendUIEvent$1;>;)V */
    public AbsUIComponent$sendUIEvent$1(AbsUIComponent r100, c r101, Continuation r102) {
        this.this$0 = r100;
        this.$event = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new AbsUIComponent$sendUIEvent$1(this.this$0, this.$event, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((AbsUIComponent$sendUIEvent$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type kotlin.coroutines.Continuation to com.larus.canvas.feature.component.base.AbsUIComponent$sendUIEvent$1 for r3v1 'this'  kotlin.coroutines.Continuation
        	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
        	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
        	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r4) {
        java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = r3.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L6;
        kotlin.ResultKt.throwOnFailure(r4);
    L11:
        kotlin.Unit r4 = kotlin.Unit.INSTANCE;
        return r4;
    L6:
        java.lang.IllegalStateException r4 = new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw r4;
    L8:
        kotlin.ResultKt.throwOnFailure(r4);
        com.larus.canvas.feature.component.base.AbsUIComponent<S, E, A> r4 = r3.this$0;
        kotlinx.coroutines.flow.MutableSharedFlow<E> r4 = r4.f323038o;
        com.larus.canvas.feature.component.base.c r1 = r3.$event;
        r3.label = 1;
        E r1 = (E) r1;
        kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation<? super kotlin.Unit>) r3;
        java.lang.Object r4 = r4.emit(r1, r3);
        if (r4 != r0) goto L11;
        return r0;
    }
}
