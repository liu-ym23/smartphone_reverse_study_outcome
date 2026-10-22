package com.bytedance.caijing.sdk.infra.base.impl.container.ttpay_container.common.lifecycle;

import cd4.g;
import com.ss.ttm.player.MediaPlayer;
import kd4.b;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.bytedance.caijing.sdk.infra.base.impl.container.ttpay_container.common.lifecycle.TTPayAnniePageLifecycleService$useEventReleaseLoadingBlock$2$1$1$1", f = "TTPayAnniePageLifecycleService.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_READ_MODE}, m = "invokeSuspend", n = {}, s = {})
final class TTPayAnniePageLifecycleService$useEventReleaseLoadingBlock$2$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $blockLoadingTime;
    final /* synthetic */ g $eventHelper;
    final /* synthetic */ Function1<b, Unit> $subscriber;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public TTPayAnniePageLifecycleService$useEventReleaseLoadingBlock$2$1$1$1(long r100, g r101, Function1<? super b, Unit> r102, Continuation<? super TTPayAnniePageLifecycleService$useEventReleaseLoadingBlock$2$1$1$1> r103) {
        this.$blockLoadingTime = r100;
        this.$eventHelper = r101;
        this.$subscriber = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new TTPayAnniePageLifecycleService$useEventReleaseLoadingBlock$2$1$1$1(this.$blockLoadingTime, this.$eventHelper, this.$subscriber, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((TTPayAnniePageLifecycleService$useEventReleaseLoadingBlock$2$1$1$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L11:
        this.$eventHelper.a("cj_release_loading_block", this.$subscriber);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        long r103 = this.$blockLoadingTime;
        this.label = 1;
        if (DelayKt.delay(r103, this) != r101) goto L11;
        return r101;
    }
}
