package com.larus.dora.impl.guide.service;

import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.guide.service.DoraGuideServiceImpl$waitInitReady$2", f = "DoraGuideServiceImpl.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_GET_CACHE_TIMESTAMP}, m = "invokeSuspend", n = {}, s = {})
public final class DoraGuideServiceImpl$waitInitReady$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ long $checkIntervalMs;
    int label;
    final /* synthetic */ DoraGuideServiceImpl this$0;

    public DoraGuideServiceImpl$waitInitReady$2(DoraGuideServiceImpl r100, long r101, Continuation<? super DoraGuideServiceImpl$waitInitReady$2> r102) {
        this.this$0 = r100;
        this.$checkIntervalMs = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new DoraGuideServiceImpl$waitInitReady$2(this.this$0, this.$checkIntervalMs, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Boolean> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Boolean> r101) {
        return ((DoraGuideServiceImpl$waitInitReady$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 == 1) goto L8;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
    L10:
        if (this.this$0.f335952b == true) goto L15;
        long r103 = this.$checkIntervalMs;
        this.label = 1;
        if (DelayKt.delay(r103, this) != r101) goto L10;
        return r101;
    L15:
        return Boxing.boxBoolean(true);
    }
}
