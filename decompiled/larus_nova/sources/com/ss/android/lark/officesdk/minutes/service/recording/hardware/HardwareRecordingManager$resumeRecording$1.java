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

/* JADX INFO: loaded from: classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.hardware.HardwareRecordingManager", f = "HardwareRecordingManager.kt", i = {0, 0, 1, 1, 1, 2, 2}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_RTC_ENABLE_RTC_UNINIT_LOCK_FREE, 329, 332}, m = "resumeRecording", n = {"$this$withLock_u24default$iv", "timestampSeconds", "$this$withLock_u24default$iv", AppbrandHostConstants.SCHEMA_INSPECT.SESSION, "timestampSeconds", "$this$withLock_u24default$iv", AppbrandHostConstants.SCHEMA_INSPECT.SESSION}, s = {"L$0", "J$0", "L$0", "L$1", "J$0", "L$0", "L$1"})
final class HardwareRecordingManager$resumeRecording$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ d this$0;

    public HardwareRecordingManager$resumeRecording$1(d r100, Continuation<? super HardwareRecordingManager$resumeRecording$1> r101) {
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
        HardwareRecordingManager$resumeRecording$1 r101 = this;
    L6:
        Object r102 = r101.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        if (r104 != 0) goto L9;
        ResultKt.throwOnFailure(r102);
        r101.L$0 = null;
        r101.J$0 = 0;
        r101.label = 1;
        throw null;
    L9:
        if (r104 == 1) goto L29;
        if (r104 != 2) goto L12;
        long r105 = r101.J$0;
        e r112 = (e) r101.L$1;
        kotlinx.coroutines.sync.a r106 = (kotlinx.coroutines.sync.a) r101.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: Throwable -> L27
    L39:
        if (((b) r102) != null) goto L42;
        d.k("resumeRecording", -10002, "hardware recording device is empty: " + r112.f435554b);     // Catch: Throwable -> L27
        throw null;     // Catch: Throwable -> L27
    L42:
        lvb.a.e(null, "[resumeRecording] session=" + r112 + ", timestampSeconds=" + r105);     // Catch: Throwable -> L27
        throw null;     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        Throwable th10 = th;
        kotlinx.coroutines.sync.a r113 = r106;
    L44:
        kotlinx.coroutines.sync.a r107 = r113;
    L47:
        r107.unlock(null);
        throw th10;
    L12:
        if (r104 != 3) goto L23;
        e r114 = (e) r101.L$1;
        r113 = (kotlinx.coroutines.sync.a) r101.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: Throwable -> L20
        cvb.a r108 = (cvb.a) r102;     // Catch: Throwable -> L20
        if ((r108 instanceof cvb.a.C5595a) == false) goto L19;
        ((cvb.a.C5595a) r108).getClass();     // Catch: Throwable -> L20
        ((cvb.a.C5595a) r108).getClass();     // Catch: Throwable -> L20
        d.k("resumeRecording", 0, null);     // Catch: Throwable -> L20
        throw null;     // Catch: Throwable -> L20
    L19:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L20
    L20:
        th10 = th;
        goto L44
    L23:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L29:
        long r115 = r101.J$0;
        r107 = (kotlinx.coroutines.sync.a) r101.L$0;
        ResultKt.throwOnFailure(r102);
        e r109 = r111.f435552a;     // Catch: Throwable -> L45
        if (r109 != null) goto L34;
        r103 = new a.b("no active hardware recording");     // Catch: Throwable -> L45
        r107.unlock(null);
    L36:
        return r103;
    L34:
        r101.L$0 = r107;     // Catch: Throwable -> L45
        r101.L$1 = r109;     // Catch: Throwable -> L45
        r101.J$0 = r115;     // Catch: Throwable -> L45
        r101.label = 2;     // Catch: Throwable -> L45
        Object r116 = r111.n(r109, "resumeRecording", r101);     // Catch: Throwable -> L45
        if (r116 == r103) goto L36;
        r105 = r115;
        r102 = r116;
        r112 = r109;
    L45:
        th = move-exception;
        th10 = th;
        goto L47
    L5:
        r101 = new HardwareRecordingManager$resumeRecording$1(r111, this);
        goto L6
    }
}
