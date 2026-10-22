package com.larus.bmhome.resource.access;

import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.resource.access.DetachedResourceNodeDispatcher$launch$1", f = "ResourceAccessPipeline.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_MAX_RETRANSMISSION_TIME_MS}, m = "invokeSuspend", n = {}, s = {})
final class DetachedResourceNodeDispatcher$launch$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ h0 $context;
    final /* synthetic */ l0 $node;
    final /* synthetic */ f $task;
    int label;

    public DetachedResourceNodeDispatcher$launch$1(f r100, h0 r101, l0 r102, Continuation<? super DetachedResourceNodeDispatcher$launch$1> r103) {
        this.$task = r100;
        this.$context = r101;
        this.$node = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new DetachedResourceNodeDispatcher$launch$1(this.$task, this.$context, this.$node, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((DetachedResourceNodeDispatcher$launch$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
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
        ResourceNodeRunner r103 = ResourceNodeRunner.f313584a;
        f r104 = this.$task;
        h0 r105 = this.$context;
        l0 r106 = this.$node;
        this.label = 1;
        if (r103.a(r104, r105, r106, false, true, this) != r101) goto L12;
        return r101;
    }
}
