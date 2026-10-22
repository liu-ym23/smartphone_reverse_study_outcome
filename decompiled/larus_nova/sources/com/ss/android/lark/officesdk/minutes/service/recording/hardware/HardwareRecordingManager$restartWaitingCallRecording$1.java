package com.ss.android.lark.officesdk.minutes.service.recording.hardware;

import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.hardware.HardwareRecordingManager", f = "HardwareRecordingManager.kt", i = {0, 0, 1, 1, 2}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_RTC_ENABLE_RTC_UNINIT_LOCK_FREE, 151, 164}, m = "restartWaitingCallRecording", n = {"request", "$this$withLock_u24default$iv", "request", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0"})
final class HardwareRecordingManager$restartWaitingCallRecording$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ d this$0;

    public HardwareRecordingManager$restartWaitingCallRecording$1(d r100, Continuation<? super HardwareRecordingManager$restartWaitingCallRecording$1> r101) {
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
        HardwareRecordingManager$restartWaitingCallRecording$1 r101 = this;
    L6:
        Object r102 = r101.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        if (r104 == 0) goto L84;
        if (r104 != 1) goto L10;
        kotlinx.coroutines.sync.a r105 = (kotlinx.coroutines.sync.a) r101.L$1;
        g r106 = (g) r101.L$0;
        ResultKt.throwOnFailure(r102);
        e r112 = r111.f435552a;     // Catch: Throwable -> L80
        String r107 = "";
        if (r112 != null) goto L47;
        String r108 = r106.f435565c;     // Catch: Throwable -> L80
        if (r108 == null) goto L44;
        r107 = r108;
    L44:
        d.p(-1, "no active hardware recording to restart", r107);     // Catch: Throwable -> L80
        throw null;     // Catch: Throwable -> L80
    L47:
        if (r112.f435557e == HardwareRecordingSessionState.WAITING_CALL_RECOVERY) goto L54;
        String r113 = "hardware recording is not waiting call recovery: " + r112.f435557e;     // Catch: Throwable -> L80
        String r109 = r106.f435565c;     // Catch: Throwable -> L80
        if (r109 == null) goto L52;
        r107 = r109;
    L52:
        d.p(-1, r113, r107);     // Catch: Throwable -> L80
        throw null;     // Catch: Throwable -> L80
    L54:
        nvb.a r114 = r106.f435563a;     // Catch: Throwable -> L80
        if (r114 == null) goto L57;
        String r115 = r114.f520928a;     // Catch: Throwable -> L80
    L59:
        if (Intrinsics.areEqual(r115, r112.f435554b) == true) goto L71;
        StringBuilder r116 = new StringBuilder("hardware device mismatch, active=");     // Catch: Throwable -> L80
        r116.append(r112.f435554b);     // Catch: Throwable -> L80
        r116.append(", request=");     // Catch: Throwable -> L80
        nvb.a r117 = r106.f435563a;     // Catch: Throwable -> L80
        if (r117 == null) goto L63;
        String r118 = r117.f520928a;     // Catch: Throwable -> L80
    L64:
        r116.append(r118);     // Catch: Throwable -> L80
        String r119 = r116.toString();     // Catch: Throwable -> L80
        String r120 = r106.f435565c;     // Catch: Throwable -> L80
        if (r120 == null) goto L68;
        r107 = r120;
    L68:
        d.p(-1, r119, r107);     // Catch: Throwable -> L80
        throw null;     // Catch: Throwable -> L80
    L63:
        r118 = null;
        goto L64
    L71:
        if (r106.f435567e == HardwarePlaybackState.SYS_CALL) goto L78;
        String r121 = "hardware playback is not SYS_CALL: " + r106.f435567e;     // Catch: Throwable -> L80
        String r122 = r106.f435565c;     // Catch: Throwable -> L80
        if (r122 == null) goto L76;
        r107 = r122;
    L76:
        d.p(-1, r121, r107);     // Catch: Throwable -> L80
        throw null;     // Catch: Throwable -> L80
    L78:
        lvb.a.e(null, "[restartWaitingCallRecording] end waiting session before restart, session=" + r112);     // Catch: Throwable -> L80
        throw null;     // Catch: Throwable -> L80
    L57:
        r115 = null;
    L80:
        th = move-exception;
        Throwable th10 = th;
        kotlinx.coroutines.sync.a r123 = r105;
    L82:
        r123.unlock(null);
        throw th10;
    L10:
        if (r104 == 2) goto L19;
        if (r104 != 3) goto L18;
        kotlinx.coroutines.sync.a r124 = (kotlinx.coroutines.sync.a) r101.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: Throwable -> L15
    L27:
        if ((((h) r102) instanceof h.a) == false) goto L31;
        r103 = (h) r102;     // Catch: Throwable -> L15
        r124.unlock(null);
    L30:
        return r103;
    L31:
        throw null;     // Catch: Throwable -> L15
    L15:
        th10 = th;
        r123 = r124;
        goto L82
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        r123 = (kotlinx.coroutines.sync.a) r101.L$1;
        g r125 = (g) r101.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: Throwable -> L34
        if ((((a) r102) instanceof a.C5196a) == true) goto L33;
        r101.L$0 = r123;     // Catch: Throwable -> L34
        r101.L$1 = null;     // Catch: Throwable -> L34
        r101.label = 3;     // Catch: Throwable -> L34
        r102 = r111.m(r125, false, r101);     // Catch: Throwable -> L34
        if (r102 == r103) goto L30;
        r124 = r123;
        goto L27
    L33:
        throw null;     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        th10 = th;
        goto L82
    L84:
        ResultKt.throwOnFailure(r102);
        r101.L$0 = null;
        r101.L$1 = null;
        r101.label = 1;
        throw null;
    L5:
        r101 = new HardwareRecordingManager$restartWaitingCallRecording$1(r111, this);
        goto L6
    }
}
