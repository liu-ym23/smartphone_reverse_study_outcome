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
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.hardware.HardwareRecordingManager", f = "HardwareRecordingManager.kt", i = {0, 1}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_RTC_ENABLE_RTC_UNINIT_LOCK_FREE, 609}, m = "finishAfterDeferredDeviceCompletion", n = {"$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$0"})
final class HardwareRecordingManager$finishAfterDeferredDeviceCompletion$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ d this$0;

    public HardwareRecordingManager$finishAfterDeferredDeviceCompletion$1(d r100, Continuation<? super HardwareRecordingManager$finishAfterDeferredDeviceCompletion$1> r101) {
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
        HardwareRecordingManager$finishAfterDeferredDeviceCompletion$1 r103 = this;
    L6:
        Object r104 = r103.result;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r103.label;
        if (r105 == 0) goto L36;
        if (r105 != 1) goto L10;
        kotlinx.coroutines.sync.a r106 = (kotlinx.coroutines.sync.a) r103.L$0;
        ResultKt.throwOnFailure(r104);
        e r107 = r101.f435552a;     // Catch: Throwable -> L30
        if (r107 != null) goto L27;
        kotlinx.coroutines.sync.a r108 = r106;
    L22:
        Unit r109 = Unit.INSTANCE;     // Catch: Throwable -> L14
        r108.unlock(null);
        return Unit.INSTANCE;
    L14:
        th = move-exception;
        r106 = r108;
        th = th;
    L34:
        r106.unlock(null);
        throw th;
    L27:
        if (r107.f435557e == HardwareRecordingSessionState.RECORDING) goto L32;
        lvb.a.e(null, "[finishAfterDeferredDeviceCompletion] ignore session=" + r107);     // Catch: Throwable -> L30
        throw null;     // Catch: Throwable -> L30
    L32:
        lvb.a.e(null, "[finishAfterDeferredDeviceCompletion] session=" + r107);     // Catch: Throwable -> L30
        throw null;     // Catch: Throwable -> L30
    L30:
        th = th;
        goto L34
    L10:
        if (r105 != 2) goto L17;
        r108 = (kotlinx.coroutines.sync.a) r103.L$0;
        ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L14
        goto L22
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L36:
        ResultKt.throwOnFailure(r104);
        r103.L$0 = null;
        r103.label = 1;
        throw null;
    L5:
        r103 = new HardwareRecordingManager$finishAfterDeferredDeviceCompletion$1(r101, this);
        goto L6
    }
}
