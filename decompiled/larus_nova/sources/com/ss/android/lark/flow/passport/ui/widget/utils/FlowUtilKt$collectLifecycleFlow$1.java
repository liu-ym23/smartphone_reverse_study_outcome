package com.ss.android.lark.flow.passport.ui.widget.utils;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.flow.passport.ui.widget.utils.FlowUtilKt$collectLifecycleFlow$1", f = "FlowUtil.kt", i = {}, l = {23}, m = "invokeSuspend", n = {}, s = {})
public final class FlowUtilKt$collectLifecycleFlow$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<T, Continuation<? super Unit>, Object> $collect;
    final /* synthetic */ Flow<T> $flow;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public FlowUtilKt$collectLifecycleFlow$1(Flow<? extends T> r100, Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> r101, Continuation<? super FlowUtilKt$collectLifecycleFlow$1> r102) {
        this.$flow = r100;
        this.$collect = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new FlowUtilKt$collectLifecycleFlow$1(this.$flow, this.$collect, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((FlowUtilKt$collectLifecycleFlow$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type kotlin.coroutines.Continuation to com.ss.android.lark.flow.passport.ui.widget.utils.FlowUtilKt$collectLifecycleFlow$1 for r4v1 'this'  kotlin.coroutines.Continuation
        	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
        	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
        	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r5) {
        java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = r4.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L6;
        kotlin.ResultKt.throwOnFailure(r5);
    L11:
        kotlin.Unit r5 = kotlin.Unit.INSTANCE;
        return r5;
    L6:
        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw r5;
    L8:
        kotlin.ResultKt.throwOnFailure(r5);
        kotlinx.coroutines.flow.Flow<T> r5 = r4.$flow;
        kotlin.jvm.functions.Function2<T, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> r3 = r4.$collect;
        com.ss.android.lark.flow.passport.ui.widget.utils.FlowUtilKt.a r1 = new com.ss.android.lark.flow.passport.ui.widget.utils.FlowUtilKt.a(r3);
        r4.label = 1;
        com.ss.android.lark.flow.passport.ui.widget.utils.FlowUtilKt.a r1 = r1;
        kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation<? super kotlin.Unit>) r4;
        java.lang.Object r5 = r5.collect(r1, r4);
        if (r5 != r0) goto L11;
        return r0;
    }
}
