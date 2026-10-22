package com.larus.im.internal.network.link.impl.rtc.smartnetwork;

import com.ss.ttm.player.MediaPlayer;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.im.internal.network.link.impl.rtc.smartnetwork.L2NetworkEvaluate$startGetStaOfApThreadOnce$1$1", f = "L2NetworkEvaluate.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_RTC_PRELOADING}, m = "invokeSuspend", n = {}, s = {})
final class L2NetworkEvaluate$startGetStaOfApThreadOnce$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<Job> $jobs;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public L2NetworkEvaluate$startGetStaOfApThreadOnce$1$1(List<? extends Job> r100, Continuation<? super L2NetworkEvaluate$startGetStaOfApThreadOnce$1$1> r101) {
        this.$jobs = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new L2NetworkEvaluate$startGetStaOfApThreadOnce$1$1(this.$jobs, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((L2NetworkEvaluate$startGetStaOfApThreadOnce$1$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        List<Job> r103 = this.$jobs;
        this.label = 1;
        if (AwaitKt.c(r103, this) != r101) goto L12;
        return r101;
    }
}
