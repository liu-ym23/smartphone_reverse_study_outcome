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
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.hardware.HardwareRecordingManager", f = "HardwareRecordingManager.kt", i = {0, 0, 0, 0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_RTC_ENABLE_RTC_UNINIT_LOCK_FREE, 401}, m = "onRecordingInputStateChanged", n = {"hardwareDeviceId", "playbackState", "$this$withLock_u24default$iv", "earbudsConnected"}, s = {"L$0", "L$1", "L$2", "Z$0"})
final class HardwareRecordingManager$onRecordingInputStateChanged$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ d this$0;

    public HardwareRecordingManager$onRecordingInputStateChanged$1(d r100, Continuation<? super HardwareRecordingManager$onRecordingInputStateChanged$1> r101) {
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
        HardwareRecordingManager$onRecordingInputStateChanged$1 r103 = this;
    L6:
        Object r104 = r103.result;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r103.label;
        if (r105 == 0) goto L30;
        if (r105 != 1) goto L10;
        boolean r106 = r103.Z$0;
        kotlinx.coroutines.sync.a r107 = (kotlinx.coroutines.sync.a) r103.L$2;
        HardwarePlaybackState r108 = (HardwarePlaybackState) r103.L$1;
        nvb.a r109 = (nvb.a) r103.L$0;
        ResultKt.throwOnFailure(r104);
        e r110 = r101.f435552a;     // Catch: Throwable -> L27
        if (r110 == null) goto L19;
        String r111 = r110.f435554b;     // Catch: Throwable -> L27
    L20:
        boolean r112 = Intrinsics.areEqual(r111, r109.f520928a);     // Catch: Throwable -> L27
        r107.unlock(null);
        if (r112 == false) goto L24;
        lvb.a.e(null, "[onRecordingInputStateChanged] device=" + r109 + ", earbudsConnected=" + r106 + ", playbackState=" + r108);
        throw null;
    L24:
        return Unit.INSTANCE;
    L19:
        r111 = null;
    L27:
        th = move-exception;
        r107.unlock(null);
        throw th;
    L10:
        if (r105 != 2) goto L14;
        ResultKt.throwOnFailure(r104);
        goto L24
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L30:
        ResultKt.throwOnFailure(r104);
        r103.L$0 = null;
        r103.L$1 = null;
        r103.L$2 = null;
        r103.Z$0 = false;
        r103.label = 1;
        throw null;
    L5:
        r103 = new HardwareRecordingManager$onRecordingInputStateChanged$1(r101, this);
        goto L6
    }
}
