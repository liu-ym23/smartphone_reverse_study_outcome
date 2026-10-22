package com.obric.aiagent.ipc.control;

import com.obric.aiagent.ipc.utils.e;
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
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiagent.ipc.control.BinderControl$scheduleRebind$1", f = "BinderControl.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_VIDEO_QUERY}, m = "invokeSuspend", n = {}, s = {})
public final class BinderControl$scheduleRebind$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $delay;
    final /* synthetic */ int $reason;
    int label;
    final /* synthetic */ BinderControl this$0;

    public BinderControl$scheduleRebind$1(long r100, BinderControl r101, int r102, Continuation<? super BinderControl$scheduleRebind$1> r103) {
        this.$delay = r100;
        this.this$0 = r101;
        this.$reason = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new BinderControl$scheduleRebind$1(this.$delay, this.this$0, this.$reason, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((BinderControl$scheduleRebind$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L11:
        BinderControl r103 = this.this$0;
        long r104 = this.$delay;
        int r105 = this.$reason;
        monitor-enter(r103);
    L22:
        th = move-exception;
        throw th;
    L14:
        if (r103.f384678f == null) goto L18;
        e.a("IPCControl", "scheduleRebind: instance is not null, abort");     // Catch: Throwable -> L22
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L22
        monitor-exit(r103);
        return r106;
    L18:
        int r107 = e.f384738a;     // Catch: Throwable -> L22
        e.a("IPCControl", "pendingRebind in " + r104 + "ms (lastDelay=" + r104 + "ms)");     // Catch: Throwable -> L22
        BinderControl.d(r103, r105);     // Catch: Throwable -> L22
        r103.h();     // Catch: Throwable -> L22
        monitor-exit(r103);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        long r108 = this.$delay;
        this.label = 1;
        if (DelayKt.delay(r108, this) != r101) goto L11;
        return r101;
    }
}
