package com.ss.android.lark.officesdk.minutes.service.foundation.mvi.common;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.foundation.mvi.common.CoroutinesSafe$makeConcurrentSafe$2$1$concurrentJob$1", f = "CoroutinesSafe.kt", i = {}, l = {66}, m = "invokeSuspend", n = {}, s = {})
public final class CoroutinesSafe$makeConcurrentSafe$2$1$concurrentJob$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Continuation<? super T>, Object> $block;
    final /* synthetic */ i<T> $it;
    Object L$0;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public CoroutinesSafe$makeConcurrentSafe$2$1$concurrentJob$1(i<? super T> r100, Function1<? super Continuation<? super T>, ? extends Object> r101, Continuation<? super CoroutinesSafe$makeConcurrentSafe$2$1$concurrentJob$1> r102) {
        this.$it = r100;
        this.$block = r101;
        super(1, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> r100) {
        return new CoroutinesSafe$makeConcurrentSafe$2$1$concurrentJob$1(this.$it, this.$block, r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Unit> r100) {
        return invoke2(r100);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super Unit> r100) {
        return ((CoroutinesSafe$makeConcurrentSafe$2$1$concurrentJob$1) create(r100)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to com.ss.android.lark.officesdk.minutes.service.foundation.mvi.common.CoroutinesSafe$makeConcurrentSafe$2$1$concurrentJob$1 for r3v1 'this'  java.lang.Object
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
        java.lang.Object r0 = r3.L$0;
        kotlin.coroutines.Continuation r0 = (kotlin.coroutines.Continuation) r0;
        kotlin.ResultKt.throwOnFailure(r4);
    L12:
        java.lang.Object r4 = kotlin.Result.m9449constructorimpl(r4);
        r0.resumeWith(r4);
        kotlin.Unit r4 = kotlin.Unit.INSTANCE;
        return r4;
    L6:
        java.lang.IllegalStateException r4 = new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw r4;
    L8:
        kotlin.ResultKt.throwOnFailure(r4);
        kotlin.coroutines.Continuation r4 = r3.$it;
        kotlin.Result.Companion r1 = kotlin.Result.Companion;
        kotlin.jvm.functions.Function1<kotlin.coroutines.Continuation<? super T>, java.lang.Object> r1 = r3.$block;
        r3.L$0 = r4;
        r3.label = 1;
        java.lang.Object r3 = (kotlin.coroutines.Continuation<? super T>) r3;
        java.lang.Object r1 = r1.invoke(r3);
        if (r1 != r0) goto L11;
        return r0;
    L11:
        r0 = r4;
        r4 = r1;
        goto L12
    }
}
