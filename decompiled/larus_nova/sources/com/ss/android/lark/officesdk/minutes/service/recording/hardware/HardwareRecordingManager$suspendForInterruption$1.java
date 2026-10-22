package com.ss.android.lark.officesdk.minutes.service.recording.hardware;

import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.hardware.HardwareRecordingManager", f = "HardwareRecordingManager.kt", i = {0, 0, 0, 1, 1, 1, 1, 2, 3, 3, 3, 3, 4, 4, 4, 4}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_RTC_ENABLE_RTC_UNINIT_LOCK_FREE, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_DNS_START_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_REND_FIRST_FRAME_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_DECODER_OPENED_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_FRAME_DROPPING_TERMINATED_DTS}, m = "suspendForInterruption", n = {"targetState", "interruptionReason", "$this$withLock_u24default$iv", "targetState", "interruptionReason", "$this$withLock_u24default$iv", AppbrandHostConstants.SCHEMA_INSPECT.SESSION, "$this$withLock_u24default$iv", "targetState", "interruptionReason", "$this$withLock_u24default$iv", AppbrandHostConstants.SCHEMA_INSPECT.SESSION, "targetState", "interruptionReason", "$this$withLock_u24default$iv", AppbrandHostConstants.SCHEMA_INSPECT.SESSION}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$0", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3"})
final class HardwareRecordingManager$suspendForInterruption$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ d this$0;

    public HardwareRecordingManager$suspendForInterruption$1(d r100, Continuation<? super HardwareRecordingManager$suspendForInterruption$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        this.result = r110;
        this.label |= Integer.MIN_VALUE;
        d r100 = this.this$0;
        r100.getClass();
        int r101 = this.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r101 - Integer.MIN_VALUE;
        HardwareRecordingManager$suspendForInterruption$1 r102 = this;
    L6:
        Object r103 = r102.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r102.label;
        if (r105 != 0) goto L77;
        ResultKt.throwOnFailure(r103);
        r102.L$0 = null;
        r102.L$1 = null;
        r102.L$2 = null;
        r102.label = 1;
        throw null;
    L77:
        if (r105 != 1) goto L11;
        kotlinx.coroutines.sync.a r106 = (kotlinx.coroutines.sync.a) r102.L$2;
        HardwareRecordingInterruptionReason r107 = (HardwareRecordingInterruptionReason) r102.L$1;
        HardwareRecordingSessionState r108 = (HardwareRecordingSessionState) r102.L$0;
        ResultKt.throwOnFailure(r103);
        e r109 = r100.f435552a;     // Catch: Throwable -> L71
        if (r109 != null) goto L66;
    L63:
        r106.unlock(null);
        return null;
    L66:
        if (r109.f435557e == HardwareRecordingSessionState.RECORDING) goto L69;
        lvb.a.e(null, "[suspendForInterruption] ignore non-recording session=" + r109);     // Catch: Throwable -> L71
        throw null;     // Catch: Throwable -> L71
    L69:
        r102.L$0 = r108;     // Catch: Throwable -> L71
        r102.L$1 = r107;     // Catch: Throwable -> L71
        r102.L$2 = r106;     // Catch: Throwable -> L71
        r102.L$3 = r109;     // Catch: Throwable -> L71
        r102.label = 2;     // Catch: Throwable -> L71
        throw null;     // Catch: Throwable -> L71
    L11:
        if (r105 != 2) goto L13;
        e r111 = (e) r102.L$3;
        kotlinx.coroutines.sync.a r112 = (kotlinx.coroutines.sync.a) r102.L$2;
        HardwareRecordingInterruptionReason r113 = (HardwareRecordingInterruptionReason) r102.L$1;
        HardwareRecordingSessionState r114 = (HardwareRecordingSessionState) r102.L$0;
        ResultKt.throwOnFailure(r103);     // Catch: Throwable -> L36
        a r115 = (a) r103;     // Catch: Throwable -> L36
        if (Intrinsics.areEqual(r115, a.c.f435551a) == false) goto L31;
    L40:
        r102.L$0 = r114;     // Catch: Throwable -> L36
        r102.L$1 = r113;     // Catch: Throwable -> L36
        r102.L$2 = r112;     // Catch: Throwable -> L36
        r102.L$3 = r111;     // Catch: Throwable -> L36
        r102.label = 4;     // Catch: Throwable -> L36
        r103 = r100.n(r111, "suspendForInterruption", r102);     // Catch: Throwable -> L36
        if (r103 == r104) goto L80;
        e r116 = r111;
        kotlinx.coroutines.sync.a r117 = r112;
        HardwareRecordingInterruptionReason r118 = r113;
        HardwareRecordingSessionState r119 = r114;
    L44:
        b r120 = (b) r103;     // Catch: Throwable -> L71
        if (r120 == null) goto L50;
        r102.L$0 = r119;     // Catch: Throwable -> L71
        r102.L$1 = r118;     // Catch: Throwable -> L71
        r102.L$2 = r117;     // Catch: Throwable -> L71
        r102.L$3 = r116;     // Catch: Throwable -> L71
        r102.label = 5;     // Catch: Throwable -> L71
        r103 = r120.pauseRecord();     // Catch: Throwable -> L71
        if (r103 == r104) goto L79;
    L49:
        cvb.a r121 = (cvb.a) r103;     // Catch: Throwable -> L71
    L52:
        if ((r121 instanceof cvb.a.C5595a) == true) goto L58;
        if (r121 != null) goto L57;
        lvb.a.h(null, "[suspendForInterruption] missing hardware adapter, continue waiting, session=" + r116);     // Catch: Throwable -> L71
        throw null;     // Catch: Throwable -> L71
    L57:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L71
    L58:
        lvb.a.h(null, "[suspendForInterruption] pause hardware failed, continue waiting, session=" + r116 + ", result=" + r121);     // Catch: Throwable -> L71
        throw null;     // Catch: Throwable -> L71
    L79:
        return r104;
    L50:
        r121 = null;
        goto L52
    L80:
        return r104;
    L31:
        if ((r115 instanceof a.b) == true) goto L40;
        if ((r115 instanceof a.C5196a) == false) goto L39;
        lvb.a.b(null, "[suspendForInterruption] pause OfficeSDK failed, session=" + r111 + ", result=" + r115);     // Catch: Throwable -> L36
        throw null;     // Catch: Throwable -> L36
    L39:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L36
    L36:
        th = th;
        kotlinx.coroutines.sync.a r122 = r112;
    L73:
        r122.unlock(null);
        throw th;
    L13:
        if (r105 == 3) goto L24;
        if (r105 == 4) goto L21;
        if (r105 != 5) goto L20;
        r116 = (e) r102.L$3;
        kotlinx.coroutines.sync.a r123 = (kotlinx.coroutines.sync.a) r102.L$2;
        HardwareRecordingInterruptionReason r124 = (HardwareRecordingInterruptionReason) r102.L$1;
        HardwareRecordingSessionState r125 = (HardwareRecordingSessionState) r102.L$0;
        ResultKt.throwOnFailure(r103);     // Catch: Throwable -> L71
        goto L49
    L20:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L21:
        r116 = (e) r102.L$3;
        kotlinx.coroutines.sync.a r126 = (kotlinx.coroutines.sync.a) r102.L$2;
        r118 = (HardwareRecordingInterruptionReason) r102.L$1;
        r119 = (HardwareRecordingSessionState) r102.L$0;
        ResultKt.throwOnFailure(r103);     // Catch: Throwable -> L71
        r117 = r126;
        goto L44
    L24:
        r106 = (kotlinx.coroutines.sync.a) r102.L$0;
        ResultKt.throwOnFailure(r103);     // Catch: Throwable -> L71
    L71:
        th = th;
        r122 = "[suspendForInterruption] pause OfficeSDK failed, session=";
        goto L73
    L5:
        r102 = new HardwareRecordingManager$suspendForInterruption$1(r100, this);
        goto L6
    }
}
