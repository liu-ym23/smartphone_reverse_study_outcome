package com.obric.audio.enroll.recorder;

import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.audio.enroll.recorder.VoicePrintEnrollRecordingsMgr$BluetoothScoController", f = "VoicePrintEnrollRecordingsMgr.kt", i = {0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_DECODE_MS_GAPS}, m = "startAndWaitConnected$attemptConnect", n = {"this$0"}, s = {"L$0"})
public final class VoicePrintEnrollRecordingsMgr$BluetoothScoController$startAndWaitConnected$attemptConnect$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    public VoicePrintEnrollRecordingsMgr$BluetoothScoController$startAndWaitConnected$attemptConnect$1(Continuation<? super VoicePrintEnrollRecordingsMgr$BluetoothScoController$startAndWaitConnected$attemptConnect$1> r100) {
        super(r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return VoicePrintEnrollRecordingsMgr.BluetoothScoController.e(null, null, false, this);
    }
}
