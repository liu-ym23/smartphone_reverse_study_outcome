package com.larus.avlink.performance;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.avlink.performance.DoraSceneStateNormalizer$scheduleOverlapTimeout$1", f = "DoraSceneStateNormalizer.kt", i = {}, l = {110}, m = "invokeSuspend", n = {}, s = {})
public final class DoraSceneStateNormalizer$scheduleOverlapTimeout$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DoraSceneStateNormalizer this$0;

    public DoraSceneStateNormalizer$scheduleOverlapTimeout$1(DoraSceneStateNormalizer r100, Continuation<? super DoraSceneStateNormalizer$scheduleOverlapTimeout$1> r101) {
        this.this$0 = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new DoraSceneStateNormalizer$scheduleOverlapTimeout$1(this.this$0, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((DoraSceneStateNormalizer$scheduleOverlapTimeout$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L11:
        DoraSceneStateNormalizer r103 = this.this$0;
        int r104 = DoraSceneStateNormalizer.f293520g;
        monitor-enter(r103);
    L26:
        th = move-exception;
        throw th;
    L14:
        if (r103.f293525e == null) goto L22;
        if (r103.f293526f.size() <= 1) goto L22;
        r103.e();     // Catch: Throwable -> L26
        monitor-exit(r103);
    L25:
        return Unit.INSTANCE;
    L22:
        r103.f293524d = null;     // Catch: Throwable -> L26
        monitor-exit(r103);
        goto L25
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        this.label = 1;
        if (DelayKt.delay(1000, this) != r101) goto L11;
        return r101;
    }
}
