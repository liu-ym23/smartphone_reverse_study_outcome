package com.ss.android.lark.officesdk.minutes.service.recording.hardware;

import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.hardware.HardwareRecordingManager", f = "HardwareRecordingManager.kt", i = {0, 0, 0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_RTC_ENABLE_RTC_UNINIT_LOCK_FREE, MediaPlayer.MEDIA_PLAYER_OPTION_RENDER_STALL_400}, m = "onRecordingInputUnavailable", n = {"hardwareDeviceId", "reason", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$2"})
final class HardwareRecordingManager$onRecordingInputUnavailable$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ d this$0;

    public HardwareRecordingManager$onRecordingInputUnavailable$1(d r100, Continuation<? super HardwareRecordingManager$onRecordingInputUnavailable$1> r101) {
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
        HardwareRecordingManager$onRecordingInputUnavailable$1 r103 = this;
    L6:
        Object r104 = r103.result;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r103.label;
        if (r105 == 0) goto L33;
        if (r105 != 1) goto L10;
        kotlinx.coroutines.sync.a r106 = (kotlinx.coroutines.sync.a) r103.L$2;
        HardwareRecordingInputUnavailableReason r107 = (HardwareRecordingInputUnavailableReason) r103.L$1;
        nvb.a r108 = (nvb.a) r103.L$0;
        ResultKt.throwOnFailure(r104);
    L30:
        th = move-exception;
        r106.unlock(null);
        throw th;
    L17:
        if (r107 == HardwareRecordingInputUnavailableReason.BLUETOOTH_DISCONNECTED) goto L29;
        e r109 = r101.f435552a;     // Catch: Throwable -> L30
        if (r109 == null) goto L21;
        String r110 = r109.f435554b;     // Catch: Throwable -> L30
    L22:
        boolean r111 = Intrinsics.areEqual(r110, r108.f520928a);     // Catch: Throwable -> L30
        r106.unlock(null);
        if (r111 == false) goto L26;
        lvb.a.e(null, "[onRecordingInputUnavailable] device=" + r108 + ", reason=" + r107);
        throw null;
    L26:
        return Unit.INSTANCE;
    L21:
        r110 = null;
        goto L22
    L29:
        throw null;     // Catch: Throwable -> L30
    L10:
        if (r105 != 2) goto L14;
        ResultKt.throwOnFailure(r104);
        goto L26
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L33:
        ResultKt.throwOnFailure(r104);
        r103.L$0 = null;
        r103.L$1 = null;
        r103.L$2 = null;
        r103.label = 1;
        throw null;
    L5:
        r103 = new HardwareRecordingManager$onRecordingInputUnavailable$1(r101, this);
        goto L6
    }
}
