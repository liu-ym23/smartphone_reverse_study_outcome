package com.bytedance.applog.priority.original;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.bytedance.applog.priority.original.Worker$run$4$1$1$1", f = "Worker.kt", i = {}, l = {181}, m = "invokeSuspend", n = {}, s = {})
public final class Worker$run$4$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ i<JSONObject> $header;
    final /* synthetic */ g $it;
    final /* synthetic */ long $runTimeSecs;
    int label;
    final /* synthetic */ Worker this$0;

    public Worker$run$4$1$1$1(Worker r1, g r2, i<JSONObject> r3, long r4, Continuation<? super Worker$run$4$1$1$1> r6) {
        this.this$0 = r1;
        this.$it = r2;
        this.$header = r3;
        this.$runTimeSecs = r4;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new Worker$run$4$1$1$1(this.this$0, this.$it, this.$header, this.$runTimeSecs, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L15:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        Worker r8 = this.this$0;
        g r2 = this.$it;
        i<JSONObject> r3 = this.$header;
        long r4 = this.$runTimeSecs;
        this.label = 1;
        int r5 = Worker.h;
        r8.getClass();
        Object r9 = r2.d(r3, r4, this);
        if (r9 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L12;
        r9 = Unit.INSTANCE;
    L12:
        if (r9 != r0) goto L15;
        return r0;
    }
}
