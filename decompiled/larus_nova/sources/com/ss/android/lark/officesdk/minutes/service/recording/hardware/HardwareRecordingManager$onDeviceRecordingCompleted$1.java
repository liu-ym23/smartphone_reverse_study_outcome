package com.ss.android.lark.officesdk.minutes.service.recording.hardware;

import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.hardware.HardwareRecordingManager", f = "HardwareRecordingManager.kt", i = {0, 0, 0, 1, 2, 2, 3}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_RTC_ENABLE_RTC_UNINIT_LOCK_FREE, MediaPlayer.MEDIA_PLAYER_OPTION_DELAY_BUFFERING_UPDATE, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RENDER_STALL_DURATION_REASON2, MediaPlayer.MEDIA_PLAYER_OPTION_PREPARE_CACHE_MS}, m = "onDeviceRecordingCompleted", n = {"hardwareDeviceId", "validationFailure", "$this$withLock_u24default$iv", "sessionSnapshot", "sessionSnapshot", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$2", "L$0", "L$0", "L$1", "L$0"})
final class HardwareRecordingManager$onDeviceRecordingCompleted$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ d this$0;

    public HardwareRecordingManager$onDeviceRecordingCompleted$1(d r100, Continuation<? super HardwareRecordingManager$onDeviceRecordingCompleted$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v14, types: [T, com.ss.android.lark.officesdk.minutes.service.recording.hardware.a$b] */
    /* JADX WARN: Type inference failed for: r6v4, types: [T, com.ss.android.lark.officesdk.minutes.service.recording.hardware.a$b] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        this.result = r110;
        this.label |= Integer.MIN_VALUE;
        d r111 = this.this$0;
        r111.getClass();
        int r100 = this.label;
        if ((r100 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r100 - Integer.MIN_VALUE;
        HardwareRecordingManager$onDeviceRecordingCompleted$1 r101 = this;
    L6:
        Object r102 = r101.result;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r101.label;
        if (r103 != 0) goto L9;
        ResultKt.throwOnFailure(r102);
        Ref.ObjectRef r112 = new Ref.ObjectRef();
        r101.L$0 = null;
        r101.L$1 = r112;
        r101.L$2 = null;
        r101.label = 1;
        throw null;
    L9:
        if (r103 != 1) goto L11;
        kotlinx.coroutines.sync.a r104 = (kotlinx.coroutines.sync.a) r101.L$2;
        Ref.ObjectRef r105 = (Ref.ObjectRef) r101.L$1;
        nvb.a r106 = (nvb.a) r101.L$0;
        ResultKt.throwOnFailure(r102);
        e r113 = r111.f435552a;     // Catch: Throwable -> L71
        if (r113 != null) goto L58;
        r105.element = new a.b("no active hardware recording");     // Catch: Throwable -> L71
    L62:
        r113 = null;
    L63:
        r104.unlock(null);
        a r107 = (a) r105.element;
        if (r107 != null) goto L83;
        if (r113 == null) goto L68;
        r101.L$0 = r113;
        r101.L$1 = null;
        r101.L$2 = null;
        r101.label = 2;
        throw null;
    L68:
        return new a.b("no active hardware recording");
    L83:
        return r107;
    L58:
        if (r106 == null) goto L63;
        if (Intrinsics.areEqual(r113.f435554b, r106.f520928a) == true) goto L63;
        r105.element = new a.b("hardwareDeviceId mismatch, active=" + r113.f435554b + ", completed=" + r106.f520928a);     // Catch: Throwable -> L71
    L71:
        th = move-exception;
        r104.unlock(null);
        throw th;
    L11:
        if (r103 == 2) goto L47;
        if (r103 != 3) goto L14;
        kotlinx.coroutines.sync.a r108 = (kotlinx.coroutines.sync.a) r101.L$1;
        e r109 = (e) r101.L$0;
        ResultKt.throwOnFailure(r102);
        e r114 = r111.f435552a;     // Catch: Throwable -> L43
        if (r114 != null) goto L28;
        a r115 = new a.b("no active hardware recording after interruption decision");     // Catch: Throwable -> L43
    L26:
        kotlinx.coroutines.sync.a r116 = r108;
    L42:
        r116.unlock(null);
        return r115;
    L28:
        if (Intrinsics.areEqual(r114.f435553a, r109.f435553a) == true) goto L30;
        r115 = new a.b("active session changed, expected=" + r109.f435553a + ", actual=" + r114.f435553a);     // Catch: Throwable -> L43
        goto L26
    L30:
        HardwareRecordingSessionState r117 = r114.f435557e;     // Catch: Throwable -> L43
        if (r117 == HardwareRecordingSessionState.WAITING_CALL_RECOVERY) goto L41;
        if (r117 == HardwareRecordingSessionState.WAITING_INPUT_RECOVERY) goto L41;
        lvb.a.e(null, "[onDeviceRecordingCompleted] session=" + r114);     // Catch: Throwable -> L38
        throw null;     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        th = th;
    L44:
        r116 = r108;
    L45:
        r116.unlock(null);
        throw th;
    L41:
        r115 = new a.b("ignore completed callback while waiting interruption recovery, session=" + r114);     // Catch: Throwable -> L43
    L43:
        th = th;
        goto L44
    L14:
        if (r103 != 4) goto L21;
        r116 = (kotlinx.coroutines.sync.a) r101.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: Throwable -> L18
        r115 = (a) r102;     // Catch: Throwable -> L18
    L18:
        th = th;
        goto L45
    L21:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L47:
        e r118 = (e) r101.L$0;
        ResultKt.throwOnFailure(r102);
        if (((Boolean) r102).booleanValue() == false) goto L51;
        lvb.a.e(null, "[onDeviceRecordingCompleted] deferred for interruption decision, session=" + r118);
        throw null;
    L51:
        r101.L$0 = r118;
        r101.L$1 = null;
        r101.label = 3;
        throw null;
    L5:
        r101 = new HardwareRecordingManager$onDeviceRecordingCompleted$1(r111, this);
        goto L6
    }
}
