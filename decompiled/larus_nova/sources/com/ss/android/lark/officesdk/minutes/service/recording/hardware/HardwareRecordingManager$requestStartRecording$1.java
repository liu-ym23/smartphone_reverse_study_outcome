package com.ss.android.lark.officesdk.minutes.service.recording.hardware;

import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.hardware.HardwareRecordingManager", f = "HardwareRecordingManager.kt", i = {0, 0, 1}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_RTC_ENABLE_RTC_UNINIT_LOCK_FREE, 115}, m = "requestStartRecording", n = {"request", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$0"})
final class HardwareRecordingManager$requestStartRecording$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ d this$0;

    public HardwareRecordingManager$requestStartRecording$1(d r100, Continuation<? super HardwareRecordingManager$requestStartRecording$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        d r101 = this.this$0;
        r101.getClass();
        int r102 = this.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r102 - Integer.MIN_VALUE;
        HardwareRecordingManager$requestStartRecording$1 r103 = this;
    L6:
        Object r104 = r103.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r103.label;
        if (r106 != 0) goto L9;
        ResultKt.throwOnFailure(r104);
        r103.L$0 = null;
        r103.L$1 = null;
        r103.label = 1;
        throw null;
    L9:
        if (r106 == 1) goto L18;
        if (r106 != 2) goto L17;
        kotlinx.coroutines.sync.a r107 = (kotlinx.coroutines.sync.a) r103.L$0;
        ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L14
    L23:
        r105 = (h) r104;     // Catch: Throwable -> L14
        r107.unlock(null);
    L25:
        return r105;
    L14:
        Throwable th10 = th;
        kotlinx.coroutines.sync.a r108 = r107;
    L29:
        r108.unlock(null);
        throw th10;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        r108 = (kotlinx.coroutines.sync.a) r103.L$1;
        g r109 = (g) r103.L$0;
        ResultKt.throwOnFailure(r104);
        r103.L$0 = r108;     // Catch: Throwable -> L27
        r103.L$1 = null;     // Catch: Throwable -> L27
        r103.label = 2;     // Catch: Throwable -> L27
        r104 = r101.m(r109, true, r103);     // Catch: Throwable -> L27
        if (r104 == r105) goto L25;
        r107 = r108;
    L27:
        th = move-exception;
        th10 = th;
        goto L29
    L5:
        r103 = new HardwareRecordingManager$requestStartRecording$1(r101, this);
        goto L6
    }
}
