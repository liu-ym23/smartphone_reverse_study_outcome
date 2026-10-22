package com.ss.android.lark.officesdk.minutes.service.recording.hardware;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.EndRecordingReason;
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
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.hardware.HardwareRecordingManager", f = "HardwareRecordingManager.kt", i = {0, 0, 1}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_RTC_ENABLE_RTC_UNINIT_LOCK_FREE, 751}, m = "endAfterInterruptionTimeout", n = {"reason", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$0"})
final class HardwareRecordingManager$endAfterInterruptionTimeout$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ d this$0;

    public HardwareRecordingManager$endAfterInterruptionTimeout$1(d r100, Continuation<? super HardwareRecordingManager$endAfterInterruptionTimeout$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        this.result = r110;
        this.label |= Integer.MIN_VALUE;
        d r111 = this.this$0;
        r111.getClass();
        int r100 = this.label;
        if ((r100 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r100 - Integer.MIN_VALUE;
        HardwareRecordingManager$endAfterInterruptionTimeout$1 r101 = this;
    L6:
        Object r102 = r101.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        if (r104 != 0) goto L9;
        ResultKt.throwOnFailure(r102);
        r101.L$0 = null;
        r101.L$1 = null;
        r101.label = 1;
        throw null;
    L9:
        if (r104 == 1) goto L18;
        if (r104 != 2) goto L17;
        kotlinx.coroutines.sync.a r112 = (kotlinx.coroutines.sync.a) r101.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: Throwable -> L14
    L35:
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L14
        r112.unlock(null);
        return Unit.INSTANCE;
    L14:
        Throwable th10 = th;
        kotlinx.coroutines.sync.a r106 = r112;
    L40:
        r106.unlock(null);
        throw th10;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        r106 = (kotlinx.coroutines.sync.a) r101.L$1;
        EndRecordingReason r107 = (EndRecordingReason) r101.L$0;
        ResultKt.throwOnFailure(r102);
        e r108 = r111.f435552a;     // Catch: Throwable -> L29
        if (r108 == null) goto L34;
        HardwareRecordingSessionState r109 = r108.f435557e;     // Catch: Throwable -> L29
        if (r109 != HardwareRecordingSessionState.WAITING_CALL_RECOVERY) goto L25;
    L31:
        r101.L$0 = r106;     // Catch: Throwable -> L29
        r101.L$1 = null;     // Catch: Throwable -> L29
        r101.label = 2;     // Catch: Throwable -> L29
        if (r111.l(r108, r107, true, r101) != r103) goto L34;
        return r103;
    L25:
        if (r109 == HardwareRecordingSessionState.WAITING_INPUT_RECOVERY) goto L31;
        lvb.a.e(null, "[endAfterInterruptionTimeout] ignore non-waiting session=" + r108);     // Catch: Throwable -> L29
        throw null;     // Catch: Throwable -> L29
    L34:
        r112 = r106;
    L29:
        th = move-exception;
        th10 = th;
        goto L40
    L5:
        r101 = new HardwareRecordingManager$endAfterInterruptionTimeout$1(r111, this);
        goto L6
    }
}
