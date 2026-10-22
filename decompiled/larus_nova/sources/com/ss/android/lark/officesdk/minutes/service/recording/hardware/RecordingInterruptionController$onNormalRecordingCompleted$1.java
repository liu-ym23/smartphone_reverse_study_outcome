package com.ss.android.lark.officesdk.minutes.service.recording.hardware;

import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.hardware.RecordingInterruptionController", f = "RecordingInterruptionController.kt", i = {0, 0, 0, 1}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_VIEW_WIDTH, 176}, m = "onNormalRecordingCompleted", n = {"action", "$this$withLock_u24default$iv", "isPhoneCalling", "handled"}, s = {"L$0", "L$1", "Z$0", "Z$0"})
final class RecordingInterruptionController$onNormalRecordingCompleted$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RecordingInterruptionController this$0;

    public RecordingInterruptionController$onNormalRecordingCompleted$1(RecordingInterruptionController r100, Continuation<? super RecordingInterruptionController$onNormalRecordingCompleted$1> r101) {
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
        RecordingInterruptionController$onNormalRecordingCompleted$1 r103 = this;
    L6:
        Object r104 = r103.result;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r103.label;
        boolean r106 = true;
        if (r105 == 0) goto L25;
        if (r105 != 1) goto L10;
        boolean r107 = r103.Z$0;
        kotlinx.coroutines.sync.a r108 = (kotlinx.coroutines.sync.a) r103.L$1;
        Ref.ObjectRef r109 = (Ref.ObjectRef) r103.L$0;
        ResultKt.throwOnFailure(r104);
        StringBuilder r110 = new StringBuilder("[onNormalRecordingCompleted] latestPlaybackState=");     // Catch: Throwable -> L22
        r110.append(r101.f435535a);     // Catch: Throwable -> L22
        r110.append(", isPhoneCalling=");     // Catch: Throwable -> L22
        if (r107 == true) goto L20;
        r106 = false;
    L20:
        r110.append(r106);     // Catch: Throwable -> L22
        r110.append(", appCallIdleCandidate=");     // Catch: Throwable -> L22
        r110.append(r101.f435536b);     // Catch: Throwable -> L22
        r110.append(", waitingCallRecovery=");     // Catch: Throwable -> L22
        r110.append(r101.f435537c);     // Catch: Throwable -> L22
        r110.append(", waitingInputRecovery=");     // Catch: Throwable -> L22
        r110.append(r101.f435538d);     // Catch: Throwable -> L22
        r110.append(", pendingNormalCompletion=");     // Catch: Throwable -> L22
        r110.append(r101.f435540f);     // Catch: Throwable -> L22
        lvb.a.e(null, r110.toString());     // Catch: Throwable -> L22
        throw null;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        r108.unlock(null);
        throw th;
    L10:
        if (r105 != 2) goto L14;
        boolean r111 = r103.Z$0;
        ResultKt.throwOnFailure(r104);
        return Boxing.boxBoolean(r111);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L25:
        ResultKt.throwOnFailure(r104);
        int r112 = com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler.a.f434578h;
        boolean r113 = com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler.a.C5173a.b();
        r103.L$0 = new Ref.ObjectRef();
        r103.L$1 = null;
        r103.Z$0 = r113;
        r103.label = 1;
        throw null;
    L5:
        r103 = new RecordingInterruptionController$onNormalRecordingCompleted$1(r101, this);
        goto L6
    }
}
