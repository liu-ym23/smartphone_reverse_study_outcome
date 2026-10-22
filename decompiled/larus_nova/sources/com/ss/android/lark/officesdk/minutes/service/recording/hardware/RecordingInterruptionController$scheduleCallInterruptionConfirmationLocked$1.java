package com.ss.android.lark.officesdk.minutes.service.recording.hardware;

import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.hardware.RecordingInterruptionController$scheduleCallInterruptionConfirmationLocked$1", f = "RecordingInterruptionController.kt", i = {1, 1, 1, 2}, l = {290, MediaPlayer.MEDIA_PLAYER_OPTION_VIEW_WIDTH, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_TCP_FAST_OPEN, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_CHECK_PACKET_CORRUPT}, m = "invokeSuspend", n = {"action", "$this$withLock_u24default$iv", "isPhoneCalling", "shouldEndNormally"}, s = {"L$0", "L$1", "Z$0", "Z$0"})
final class RecordingInterruptionController$scheduleCallInterruptionConfirmationLocked$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $confirmationTimeoutMs;
    Object L$0;
    Object L$1;
    Object L$2;
    boolean Z$0;
    int label;
    final /* synthetic */ RecordingInterruptionController this$0;

    public RecordingInterruptionController$scheduleCallInterruptionConfirmationLocked$1(long r100, RecordingInterruptionController r101, Continuation<? super RecordingInterruptionController$scheduleCallInterruptionConfirmationLocked$1> r102) {
        this.$confirmationTimeoutMs = r100;
        this.this$0 = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new RecordingInterruptionController$scheduleCallInterruptionConfirmationLocked$1(this.$confirmationTimeoutMs, this.this$0, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((RecordingInterruptionController$scheduleCallInterruptionConfirmationLocked$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        boolean r103 = true;
        if (r102 == 0) goto L29;
        if (r102 == 1) goto L28;
        if (r102 != 2) goto L7;
        boolean r104 = this.Z$0;
        RecordingInterruptionController r105 = (RecordingInterruptionController) this.L$2;
        kotlinx.coroutines.sync.a r106 = (kotlinx.coroutines.sync.a) this.L$1;
        Ref.ObjectRef r107 = (Ref.ObjectRef) this.L$0;
        ResultKt.throwOnFailure(r100);
        int r108 = RecordingInterruptionController.f435534l;     // Catch: Throwable -> L25
        r105.getClass();     // Catch: Throwable -> L25
        StringBuilder r109 = new StringBuilder("[onCallInterruptionConfirmationTimeout] isPhoneCalling=");     // Catch: Throwable -> L25
        if (r104 == true) goto L23;
        r103 = false;
    L23:
        r109.append(r103);     // Catch: Throwable -> L25
        r109.append(", latestPlaybackState=");     // Catch: Throwable -> L25
        r109.append(r105.f435535a);     // Catch: Throwable -> L25
        r109.append(", appCallIdleCandidate=");     // Catch: Throwable -> L25
        r109.append(r105.f435536b);     // Catch: Throwable -> L25
        r109.append(", pendingNormalCompletion=");     // Catch: Throwable -> L25
        r109.append(r105.f435540f);     // Catch: Throwable -> L25
        lvb.a.e(null, r109.toString());     // Catch: Throwable -> L25
        throw null;     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        r106.unlock(null);
        throw th;
    L7:
        if (r102 == 3) goto L12;
        if (r102 != 4) goto L11;
        ResultKt.throwOnFailure(r100);
    L15:
        return Unit.INSTANCE;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        boolean r110 = this.Z$0;
        ResultKt.throwOnFailure(r100);
        if (r110 == false) goto L15;
        RecordingInterruptionController r111 = this.this$0;
        int r112 = RecordingInterruptionController.f435534l;
        r111.getClass();
        this.L$0 = null;
        this.L$1 = null;
        this.L$2 = null;
        this.label = 4;
        throw null;
    L28:
        ResultKt.throwOnFailure(r100);
    L32:
        int r113 = com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler.a.f434578h;
        boolean r114 = com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler.a.C5173a.b();
        Ref.ObjectRef r115 = new Ref.ObjectRef();
        RecordingInterruptionController r116 = this.this$0;
        int r117 = RecordingInterruptionController.f435534l;
        r116.getClass();
        RecordingInterruptionController r118 = this.this$0;
        this.L$0 = r115;
        this.L$1 = null;
        this.L$2 = r118;
        this.Z$0 = r114;
        this.label = 2;
        throw null;
    L29:
        ResultKt.throwOnFailure(r100);
        long r119 = this.$confirmationTimeoutMs;
        this.label = 1;
        if (DelayKt.delay(r119, this) != r101) goto L32;
        return r101;
    }
}
