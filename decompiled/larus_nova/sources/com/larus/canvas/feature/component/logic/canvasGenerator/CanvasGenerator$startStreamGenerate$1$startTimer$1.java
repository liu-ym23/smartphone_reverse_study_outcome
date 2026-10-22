package com.larus.canvas.feature.component.logic.canvasGenerator;

import com.larus.canvas.service.bean.CanvasBlock;
import java.util.List;
import java.util.concurrent.TimeoutException;
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

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.canvas.feature.component.logic.canvasGenerator.CanvasGenerator$startStreamGenerate$1$startTimer$1", f = "CanvasImageGenerator.kt", i = {}, l = {74}, m = "invokeSuspend", n = {}, s = {})
final class CanvasGenerator$startStreamGenerate$1$startTimer$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ kotlinx.coroutines.channels.k<k<? extends List<CanvasBlock>>> $$this$callbackFlow;
    final /* synthetic */ long $timeoutMs;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public CanvasGenerator$startStreamGenerate$1$startTimer$1(long r100, kotlinx.coroutines.channels.k<? super k<? extends List<CanvasBlock>>> r101, Continuation<? super CanvasGenerator$startStreamGenerate$1$startTimer$1> r102) {
        this.$timeoutMs = r100;
        this.$$this$callbackFlow = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new CanvasGenerator$startStreamGenerate$1$startTimer$1(this.$timeoutMs, this.$$this$callbackFlow, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((CanvasGenerator$startStreamGenerate$1$startTimer$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L11:
        this.$$this$callbackFlow.close(new TimeoutException("Inactive for " + this.$timeoutMs + "ms"));
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        long r103 = this.$timeoutMs;
        this.label = 1;
        if (DelayKt.delay(r103, this) != r101) goto L11;
        return r101;
    }
}
