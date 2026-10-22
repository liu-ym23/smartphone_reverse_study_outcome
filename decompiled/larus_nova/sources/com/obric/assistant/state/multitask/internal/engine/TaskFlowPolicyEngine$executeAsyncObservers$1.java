package com.obric.assistant.state.multitask.internal.engine;

import com.obric.assistant.state.multitask.core.TaskFlowAsyncObserver;
import java.util.Iterator;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CopyOnWriteArrayList;
import jha.g;
import jha.q;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.state.multitask.internal.engine.TaskFlowPolicyEngine$executeAsyncObservers$1", f = "TaskFlowPolicyEngine.kt", i = {0}, l = {112}, m = "invokeSuspend", n = {"observer"}, s = {"L$4"})
public final class TaskFlowPolicyEngine$executeAsyncObservers$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ q<?> $event;
    final /* synthetic */ g<?> $id;
    final /* synthetic */ long $sequenceId;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    final /* synthetic */ TaskFlowPolicyEngine this$0;

    public TaskFlowPolicyEngine$executeAsyncObservers$1(TaskFlowPolicyEngine r100, g<?> r101, q<?> r102, long r103, Continuation<? super TaskFlowPolicyEngine$executeAsyncObservers$1> r104) {
        this.this$0 = r100;
        this.$id = r101;
        this.$event = r102;
        this.$sequenceId = r103;
        super(2, r104);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new TaskFlowPolicyEngine$executeAsyncObservers$1(this.this$0, this.$id, this.$event, this.$sequenceId, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((TaskFlowPolicyEngine$executeAsyncObservers$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0076 -> B:29:0x0079). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r210) {
        Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 == 0) goto L14;
        if (r101 != 1) goto L13;
        long r102 = this.J$0;
        TaskFlowAsyncObserver r103 = (TaskFlowAsyncObserver) this.L$4;
        Iterator<TaskFlowAsyncObserver> r104 = (Iterator) this.L$3;
        TaskFlowPolicyEngine r105 = (TaskFlowPolicyEngine) this.L$2;
        q<?> r106 = (q) this.L$1;
        g<?> r110 = (g) this.L$0;
        ResultKt.throwOnFailure(r210);     // Catch: Throwable -> L8 CancellationException -> L10
        TaskFlowAsyncObserver r111 = r103;
        TaskFlowPolicyEngine$executeAsyncObservers$1 r107 = this;
    L29:
        Result.Companion r108 = Result.Companion;     // Catch: CancellationException -> L10 Throwable -> L23
        Object r109 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: CancellationException -> L10 Throwable -> L23
    L25:
        Object r112 = r109;
        TaskFlowAsyncObserver r113 = r111;
        Intrinsics.checkNotNull(r113);
        int r114 = TaskFlowPolicyEngine.f393310e;
        r105.getClass();
        TaskFlowPolicyEngine.c("async_observer", r113, r112, null, r106, r102);
    L16:
        if (r104.hasNext() == false) goto L28;
        r111 = r104.next();
        r107.L$0 = r110;     // Catch: CancellationException -> L10 Throwable -> L23
        r107.L$1 = r106;     // Catch: CancellationException -> L10 Throwable -> L23
        r107.L$2 = r105;     // Catch: CancellationException -> L10 Throwable -> L23
        r107.L$3 = r104;     // Catch: CancellationException -> L10 Throwable -> L23
        r107.L$4 = r111;     // Catch: CancellationException -> L10 Throwable -> L23
        r107.J$0 = r102;     // Catch: CancellationException -> L10 Throwable -> L23
        r107.label = 1;     // Catch: CancellationException -> L10 Throwable -> L23
        if (r111.a(r106) != r100) goto L29;
        return r100;
    L28:
        return Unit.INSTANCE;
    L23:
        Throwable th10 = th;
    L24:
        Result.Companion r115 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th10));
    L10:
        e = move-exception;
        throw e;
    L8:
        th10 = th;
        r111 = r103;
        r107 = this;
        goto L24
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r210);
        TaskFlowPolicyEngine r116 = this.this$0;
        CopyOnWriteArrayList<TaskFlowAsyncObserver> r117 = r116.f393313c;
        g<?> r118 = this.$id;
        q<?> r119 = this.$event;
        long r120 = this.$sequenceId;
        r110 = r118;
        r106 = r119;
        r107 = this;
        r105 = r116;
        r104 = r117.iterator();
        r102 = r120;
        goto L16
    }
}
