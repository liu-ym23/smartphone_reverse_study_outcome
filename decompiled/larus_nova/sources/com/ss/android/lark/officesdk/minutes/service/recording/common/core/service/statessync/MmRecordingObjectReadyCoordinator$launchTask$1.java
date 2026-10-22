package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.statessync;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CompletableDeferred;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.statessync.MmRecordingObjectReadyCoordinator$launchTask$1", f = "MmRecordingObjectReadyCoordinator.kt", i = {}, l = {100}, m = "invokeSuspend", n = {}, s = {})
final class MmRecordingObjectReadyCoordinator$launchTask$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Continuation<? super Unit>, Object> $block;
    final /* synthetic */ CompletableDeferred<Unit> $completion;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public MmRecordingObjectReadyCoordinator$launchTask$1(CompletableDeferred<Unit> r100, Function1<? super Continuation<? super Unit>, ? extends Object> r101, Continuation<? super MmRecordingObjectReadyCoordinator$launchTask$1> r102) {
        this.$completion = r100;
        this.$block = r101;
        super(1, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> r100) {
        return new MmRecordingObjectReadyCoordinator$launchTask$1(this.$completion, this.$block, r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Unit> r100) {
        return invoke2(r100);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super Unit> r100) {
        return ((MmRecordingObjectReadyCoordinator$launchTask$1) create(r100)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L13;
        if (r102 != 1) goto L12;
        ResultKt.throwOnFailure(r100);     // Catch: Throwable -> L7 CancellationException -> L9
    L20:
        this.$completion.complete(Unit.INSTANCE);     // Catch: Throwable -> L7 CancellationException -> L9
    L25:
        return Unit.INSTANCE;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L13:
        ResultKt.throwOnFailure(r100);
        if (this.$completion.isActive() == false) goto L16;
        Function1<Continuation<? super Unit>, Object> r103 = this.$block;     // Catch: Throwable -> L7 CancellationException -> L9
        this.label = 1;     // Catch: Throwable -> L7 CancellationException -> L9
        if (r103.invoke(this) != r101) goto L20;
        return r101;
    L16:
        return Unit.INSTANCE;
    L9:
        e = move-exception;
        this.$completion.cancel(e);
    L7:
        th = move-exception;
        this.$completion.completeExceptionally(th);
        goto L25
    }
}
