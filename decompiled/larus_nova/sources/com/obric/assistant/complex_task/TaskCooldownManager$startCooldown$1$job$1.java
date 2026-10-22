package com.obric.assistant.complex_task;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.complex_task.TaskCooldownManager$startCooldown$1$job$1", f = "TaskCooldownManager.kt", i = {0}, l = {41}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
final class TaskCooldownManager$startCooldown$1$job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $action;
    final /* synthetic */ String $taskId;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ t this$0;

    public TaskCooldownManager$startCooldown$1$job$1(t r100, String r101, Function0<Unit> r102, Continuation<? super TaskCooldownManager$startCooldown$1$job$1> r103) {
        this.this$0 = r100;
        this.$taskId = r101;
        this.$action = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        TaskCooldownManager$startCooldown$1$job$1 r102 = new TaskCooldownManager$startCooldown$1$job$1(this.this$0, this.$taskId, this.$action, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((TaskCooldownManager$startCooldown$1$job$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L12;
        if (r102 != 1) goto L11;
        CoroutineScope r103 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r100);     // Catch: Throwable -> L8
    L17:
        this.this$0.f387942b.remove(this.$taskId);
        if (CoroutineScopeKt.isActive(r103) == false) goto L21;
        this.$action.invoke();
    L21:
        return Unit.INSTANCE;
    L8:
        Throwable th10 = th;
    L24:
        this.this$0.f387942b.remove(this.$taskId);
        if (CoroutineScopeKt.isActive(r103) == false) goto L27;
        this.$action.invoke();
    L27:
        throw th10;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r100);
        CoroutineScope r104 = (CoroutineScope) this.L$0;
        this.L$0 = r104;     // Catch: Throwable -> L22
        this.label = 1;     // Catch: Throwable -> L22
        if (DelayKt.delay(2000, this) != r101) goto L16;
        return r101;
    L16:
        r103 = r104;
    L22:
        th = move-exception;
        r103 = r104;
        th10 = th;
        goto L24
    }
}
