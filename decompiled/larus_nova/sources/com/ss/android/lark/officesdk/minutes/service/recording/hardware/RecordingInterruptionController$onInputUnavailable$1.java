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
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.hardware.RecordingInterruptionController", f = "RecordingInterruptionController.kt", i = {0, 0, 0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_VIEW_WIDTH, 205}, m = "onInputUnavailable", n = {"reason", "action", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$2"})
final class RecordingInterruptionController$onInputUnavailable$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RecordingInterruptionController this$0;

    public RecordingInterruptionController$onInputUnavailable$1(RecordingInterruptionController r100, Continuation<? super RecordingInterruptionController$onInputUnavailable$1> r101) {
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
        RecordingInterruptionController$onInputUnavailable$1 r103 = this;
    L6:
        Object r104 = r103.result;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r103.label;
        if (r105 == 0) goto L35;
        if (r105 != 1) goto L10;
        kotlinx.coroutines.sync.a r106 = (kotlinx.coroutines.sync.a) r103.L$2;
        Ref.ObjectRef r107 = (Ref.ObjectRef) r103.L$1;
        HardwareRecordingInputUnavailableReason r108 = (HardwareRecordingInputUnavailableReason) r103.L$0;
        ResultKt.throwOnFailure(r104);
    L32:
        th = move-exception;
        r106.unlock(null);
        throw th;
    L18:
        if (r101.f435537c == false) goto L20;
    L30:
        lvb.a.e(null, "[onInputUnavailable] ignored reason=" + r108 + ", waitingCallRecovery=" + r101.f435537c + ", waitingInputRecovery=" + r101.f435538d + ", inputRecoveryPolicy=" + r101.f435539e);     // Catch: Throwable -> L32
        throw null;     // Catch: Throwable -> L32
    L20:
        if (r101.f435538d == true) goto L30;
        r101.f435536b = false;     // Catch: Throwable -> L32
        r101.getClass();     // Catch: Throwable -> L32
        r101.f435540f = false;     // Catch: Throwable -> L32
        Job r109 = r101.f435541g;     // Catch: Throwable -> L32
        if (r109 == null) goto L24;
        Job.DefaultImpls.cancel$default(r109, null, 1, null);     // Catch: Throwable -> L32
    L24:
        r101.f435541g = null;     // Catch: Throwable -> L32
        r101.f435538d = true;     // Catch: Throwable -> L32
        if (r108 != HardwareRecordingInputUnavailableReason.SPEAKER_SWITCHED) goto L27;
        RecordingInterruptionController.InputRecoveryPolicy r110 = RecordingInterruptionController.InputRecoveryPolicy.END_ON_FRESH_IDLE;     // Catch: Throwable -> L32
    L28:
        r101.f435539e = r110;     // Catch: Throwable -> L32
        lvb.a.e(null, "[onInputUnavailable] reason=" + r108 + ", inputRecoveryPolicy=" + r101.f435539e);     // Catch: Throwable -> L32
        throw null;     // Catch: Throwable -> L32
    L27:
        r110 = RecordingInterruptionController.InputRecoveryPolicy.STANDARD;     // Catch: Throwable -> L32
        goto L28
    L10:
        if (r105 != 2) goto L14;
        ResultKt.throwOnFailure(r104);
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L35:
        ResultKt.throwOnFailure(r104);
        Ref.ObjectRef r111 = new Ref.ObjectRef();
        r103.L$0 = null;
        r103.L$1 = r111;
        r103.L$2 = null;
        r103.label = 1;
        throw null;
    L5:
        r103 = new RecordingInterruptionController$onInputUnavailable$1(r101, this);
        goto L6
    }
}
