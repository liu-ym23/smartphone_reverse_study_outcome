package com.bytedance.android.shopping.prepurchase.arch.exposure;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.shopping.prepurchase.arch.exposure.Scheduler$startSchedule$1", f = "Scheduler.kt", i = {}, l = {33, 35}, m = "invokeSuspend", n = {}, s = {})
final class Scheduler$startSchedule$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ Scheduler this$0;

    public Scheduler$startSchedule$1(Scheduler r1, Continuation r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        Intrinsics.checkNotNullParameter(r3, "completion");
        return new Scheduler$startSchedule$1(this.this$0, r3);
    }

    public final Object invoke(Object r1, Object r2) {
        return create(r1, (Continuation) r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x003c -> B:11:0x0020). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 == 2) goto L10;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r7);
        Scheduler$startSchedule$1 r8 = this;
    L16:
        Scheduler r2 = r8.this$0;
        r2.e = false;
        long r4 = r2.f;
        r8.label = 2;
        if (DelayKt.delay(r4, r8) == r0) goto L18;
    L11:
        Scheduler r3 = r8.this$0;
        if (r3.e == false) goto L19;
        r8.label = 1;
        if (Scheduler.a(r3, r8) != r0) goto L16;
        return r0;
    L19:
        r3.b = null;
        return Unit.INSTANCE;
    L18:
        return r0;
    L10:
        ResultKt.throwOnFailure(r7);
        r8 = this;
        goto L11
    }
}
