package com.ss.android.lark.officesdk.minutes.service.recording.hardware;

import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.hardware.RecordingInterruptionController", f = "RecordingInterruptionController.kt", i = {0, 0, 0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_VIEW_WIDTH, 132}, m = "onPlaybackStateChanged", n = {"state", "action", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$2"})
final class RecordingInterruptionController$onPlaybackStateChanged$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RecordingInterruptionController this$0;

    public RecordingInterruptionController$onPlaybackStateChanged$1(RecordingInterruptionController r100, Continuation<? super RecordingInterruptionController$onPlaybackStateChanged$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        RecordingInterruptionController r101 = this.this$0;
        r101.getClass();
        int r102 = this.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r102 - Integer.MIN_VALUE;
        RecordingInterruptionController$onPlaybackStateChanged$1 r103 = this;
    L6:
        Object r104 = r103.result;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r103.label;
        if (r105 == 0) goto L21;
        if (r105 != 1) goto L10;
        kotlinx.coroutines.sync.a r106 = (kotlinx.coroutines.sync.a) r103.L$2;
        Ref.ObjectRef r107 = (Ref.ObjectRef) r103.L$1;
        HardwarePlaybackState r108 = (HardwarePlaybackState) r103.L$0;
        ResultKt.throwOnFailure(r104);
        HardwarePlaybackState r109 = r101.f435535a;     // Catch: Throwable -> L18
        r101.f435535a = r108;     // Catch: Throwable -> L18
        lvb.a.e(null, "[onPlaybackStateChanged] previous=" + r109 + ", current=" + r108 + ", appCallIdleCandidate=" + r101.f435536b + ", waitingCallRecovery=" + r101.f435537c + ", waitingInputRecovery=" + r101.f435538d + ", inputRecoveryPolicy=" + r101.f435539e + ", pendingNormalCompletion=" + r101.f435540f);     // Catch: Throwable -> L18
        throw null;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        r106.unlock(null);
        throw th;
    L10:
        if (r105 != 2) goto L14;
        ResultKt.throwOnFailure(r104);
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L21:
        ResultKt.throwOnFailure(r104);
        Ref.ObjectRef r110 = new Ref.ObjectRef();
        r103.L$0 = null;
        r103.L$1 = r110;
        r103.L$2 = null;
        r103.label = 1;
        throw null;
    L5:
        r103 = new RecordingInterruptionController$onPlaybackStateChanged$1(r101, this);
        goto L6
    }
}
