package com.obric.assistant.interaction.impl.essentialtask;

import android.os.SystemClock;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.interaction.impl.essentialtask.EssentialTaskServiceImpl$executePendingTaskWhenFinished$1$2$1$1", f = "EssentialTaskServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class EssentialTaskServiceImpl$executePendingTaskWhenFinished$1$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Runnable $task;
    int label;

    public EssentialTaskServiceImpl$executePendingTaskWhenFinished$1$2$1$1(Runnable r100, Continuation<? super EssentialTaskServiceImpl$executePendingTaskWhenFinished$1$2$1$1> r101) {
        this.$task = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new EssentialTaskServiceImpl$executePendingTaskWhenFinished$1$2$1$1(this.$task, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((EssentialTaskServiceImpl$executePendingTaskWhenFinished$1$2$1$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r110);
        FLogger r111 = FLogger.f375446a;
        r111.i("EssentialTaskService", "start execute io pending task: " + this.$task);
        TaskUtils r100 = TaskUtils.INSTANCE;
        TaskUtils.systemLog$default(r100, "EssentialTaskService", "start execute io pending task: " + this.$task, null, 4, null);
        long r101 = SystemClock.elapsedRealtime();
        this.$task.run();
        long r102 = SystemClock.elapsedRealtime() - r101;
        r111.i("EssentialTaskService", "finish execute io pending task: " + this.$task + ", usedTime: " + r102);
        TaskUtils.systemLog$default(r100, "EssentialTaskService", "finish execute io pending task: " + this.$task + ", usedTime: " + r102, null, 4, null);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
