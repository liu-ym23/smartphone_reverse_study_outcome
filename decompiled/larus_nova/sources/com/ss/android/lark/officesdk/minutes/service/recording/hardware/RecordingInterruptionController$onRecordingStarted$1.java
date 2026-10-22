package com.ss.android.lark.officesdk.minutes.service.recording.hardware;

import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.hardware.RecordingInterruptionController", f = "RecordingInterruptionController.kt", i = {0, 0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_VIEW_WIDTH}, m = "onRecordingStarted", n = {"initialPlaybackState", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1"})
final class RecordingInterruptionController$onRecordingStarted$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RecordingInterruptionController this$0;

    public RecordingInterruptionController$onRecordingStarted$1(RecordingInterruptionController r100, Continuation<? super RecordingInterruptionController$onRecordingStarted$1> r101) {
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
        RecordingInterruptionController$onRecordingStarted$1 r103 = this;
    L6:
        Object r104 = r103.result;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r103.label;
        if (r105 == 0) goto L18;
        if (r105 != 1) goto L17;
        kotlinx.coroutines.sync.a r106 = (kotlinx.coroutines.sync.a) r103.L$1;
        HardwarePlaybackState r107 = (HardwarePlaybackState) r103.L$0;
        ResultKt.throwOnFailure(r104);
        r101.f435535a = r107;     // Catch: Throwable -> L13
        r101.f435536b = false;     // Catch: Throwable -> L13
        r101.getClass();     // Catch: Throwable -> L13
        r101.f435537c = false;     // Catch: Throwable -> L13
        r101.f435538d = false;     // Catch: Throwable -> L13
        r101.f435539e = RecordingInterruptionController.InputRecoveryPolicy.STANDARD;     // Catch: Throwable -> L13
        r101.f435540f = false;     // Catch: Throwable -> L13
        r101.a();     // Catch: Throwable -> L13
        Unit r108 = Unit.INSTANCE;     // Catch: Throwable -> L13
        r106.unlock(null);
        return r108;
    L13:
        th = move-exception;
        r106.unlock(null);
        throw th;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r104);
        r103.L$0 = null;
        r103.L$1 = null;
        r103.label = 1;
        throw null;
    L5:
        r103 = new RecordingInterruptionController$onRecordingStarted$1(r101, this);
        goto L6
    }
}
