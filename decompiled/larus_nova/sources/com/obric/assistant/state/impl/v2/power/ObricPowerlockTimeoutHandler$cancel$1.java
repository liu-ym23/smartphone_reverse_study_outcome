package com.obric.assistant.state.impl.v2.power;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.state.impl.v2.power.ObricPowerlockTimeoutHandler$cancel$1", f = "ObricPowerlockTimeoutHandler.kt", i = {0}, l = {80}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv"}, s = {"L$0"})
final class ObricPowerlockTimeoutHandler$cancel$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ ObricPowerlockTimeoutHandler this$0;

    public ObricPowerlockTimeoutHandler$cancel$1(ObricPowerlockTimeoutHandler r100, Continuation<? super ObricPowerlockTimeoutHandler$cancel$1> r101) {
        this.this$0 = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new ObricPowerlockTimeoutHandler$cancel$1(this.this$0, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((ObricPowerlockTimeoutHandler$cancel$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ObricPowerlockTimeoutHandler r103 = (ObricPowerlockTimeoutHandler) this.L$1;
        kotlinx.coroutines.sync.a r104 = (kotlinx.coroutines.sync.a) this.L$0;
        ResultKt.throwOnFailure(r100);
    L21:
        Job r105 = r103.f393221f;     // Catch: Throwable -> L18
        if (r105 == null) goto L15;
        Job.DefaultImpls.cancel$default(r105, null, 1, null);     // Catch: Throwable -> L18
    L15:
        r103.f393221f = null;     // Catch: Throwable -> L18
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L18
        r104.unlock(null);
        return Unit.INSTANCE;
    L18:
        th = move-exception;
        r104.unlock(null);
        throw th;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        ObricPowerlockTimeoutHandler r107 = this.this$0;
        r104 = r107.f393220e;
        this.L$0 = r104;
        this.L$1 = r107;
        this.label = 1;
        if (r104.a(null, this) != r101) goto L11;
        return r101;
    L11:
        r103 = r107;
        goto L21
    }
}
