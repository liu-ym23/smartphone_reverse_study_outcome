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
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.hardware.RecordingInterruptionController$scheduleCallRecoveryIdleEndLocked$1", f = "RecordingInterruptionController.kt", i = {1}, l = {251, MediaPlayer.MEDIA_PLAYER_OPTION_VIEW_WIDTH, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_TRAN_CONNECT_TIME}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv"}, s = {"L$0"})
final class RecordingInterruptionController$scheduleCallRecoveryIdleEndLocked$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $generation;
    final /* synthetic */ long $timeoutMs;
    long J$0;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ RecordingInterruptionController this$0;

    public RecordingInterruptionController$scheduleCallRecoveryIdleEndLocked$1(long r100, RecordingInterruptionController r101, long r102, Continuation<? super RecordingInterruptionController$scheduleCallRecoveryIdleEndLocked$1> r103) {
        this.$timeoutMs = r100;
        this.this$0 = r101;
        this.$generation = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new RecordingInterruptionController$scheduleCallRecoveryIdleEndLocked$1(this.$timeoutMs, this.this$0, this.$generation, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((RecordingInterruptionController$scheduleCallRecoveryIdleEndLocked$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        boolean r102 = true;
        if (r101 == 0) goto L39;
        if (r101 != 1) goto L6;
        ResultKt.throwOnFailure(r110);
    L42:
        RecordingInterruptionController r111 = this.this$0;
        int r103 = RecordingInterruptionController.f435534l;
        r111.getClass();
        long r104 = this.$generation;
        RecordingInterruptionController r112 = this.this$0;
        this.L$0 = null;
        this.L$1 = r112;
        this.J$0 = r104;
        this.label = 2;
        throw null;
    L6:
        if (r101 == 2) goto L11;
        if (r101 != 3) goto L10;
        ResultKt.throwOnFailure(r110);
    L33:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        long r105 = this.J$0;
        RecordingInterruptionController r106 = (RecordingInterruptionController) this.L$1;
        kotlinx.coroutines.sync.a r107 = (kotlinx.coroutines.sync.a) this.L$0;
        ResultKt.throwOnFailure(r110);
        boolean r113 = false;
        if (r105 != r106.f435544j) goto L30;
        r106.f435543i = null;     // Catch: Throwable -> L23
        if (r106.f435537c == false) goto L25;
        HardwarePlaybackState r108 = r106.f435535a;     // Catch: Throwable -> L23
        if (r108 == HardwarePlaybackState.APP_CALL) goto L25;
        if (r108 == HardwarePlaybackState.SYS_CALL) goto L25;
        boolean r109 = false;
    L26:
        if (r109 == false) goto L28;
        r102 = false;
    L29:
        r113 = r102;
        goto L30
    L28:
        r106.f435537c = false;     // Catch: Throwable -> L23
    L25:
        r109 = true;
    L30:
        r107.unlock(null);
        if (r113 == false) goto L33;
        this.this$0.getClass();
        this.L$0 = null;
        this.L$1 = null;
        this.label = 3;
        throw null;
    L23:
        th = move-exception;
        r107.unlock(null);
        throw th;
    L39:
        ResultKt.throwOnFailure(r110);
        long r114 = this.$timeoutMs;
        this.label = 1;
        if (DelayKt.delay(r114, this) != r100) goto L42;
        return r100;
    }
}
