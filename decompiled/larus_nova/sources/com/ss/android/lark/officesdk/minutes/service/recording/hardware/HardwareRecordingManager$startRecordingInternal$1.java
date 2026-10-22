package com.ss.android.lark.officesdk.minutes.service.recording.hardware;

import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.hardware.HardwareRecordingManager", f = "HardwareRecordingManager.kt", i = {0, 0, 0, 0, 0, 2, 2, 2}, l = {484, TTVideoEngineInterface.PLAYER_OPTION_DISABLE_HWDEC_SEAMLESS, 493}, m = "startRecordingInternal", n = {"adapter", "sceneInstanceId", "initialPlaybackState", AppbrandHostConstants.SCHEMA_INSPECT.SESSION, "restoreLegacyRecordingOnFailure", "sceneInstanceId", "hookResult", "restoreLegacyRecordingOnFailure"}, s = {"L$0", "L$1", "L$2", "L$3", "Z$0", "L$0", "L$1", "Z$0"})
final class HardwareRecordingManager$startRecordingInternal$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ d this$0;

    public HardwareRecordingManager$startRecordingInternal$1(d r100, Continuation<? super HardwareRecordingManager$startRecordingInternal$1> r101) {
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
        HardwareRecordingManager$startRecordingInternal$1 r103 = this;
    L6:
        Object r104 = r103.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r103.label;
        if (r106 != 0) goto L42;
        ResultKt.throwOnFailure(r104);
        throw null;
    L42:
        if (r106 == 1) goto L19;
        if (r106 != 2) goto L12;
        ResultKt.throwOnFailure(r104);
    L25:
        return r104;
    L12:
        if (r106 != 3) goto L17;
        f r107 = (f) r103.L$1;
        String r108 = (String) r103.L$0;
        ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L30
        Object r109 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L30
    L32:
        Throwable r110 = Result.m9452exceptionOrNullimpl(r109);
        if (r110 != null) goto L36;
        r101.f435552a = null;
        throw null;
    L36:
        lvb.a.b(null, "[audioFeatureStatus] clear failed, error=" + r110);
        throw null;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        e r111 = (e) r103.L$3;
        HardwarePlaybackState r112 = (HardwarePlaybackState) r103.L$2;
        String r113 = (String) r103.L$1;
        b r114 = (b) r103.L$0;
        ResultKt.throwOnFailure(r104);
        f r115 = (f) r104;
        if ((r115 instanceof f.b) == false) goto L27;
        ((f.b) r115).getClass();
        e r116 = e.a(r111, null, null, 223);
        r103.L$0 = null;
        r103.L$1 = null;
        r103.L$2 = null;
        r103.L$3 = null;
        r103.label = 2;
        r104 = r101.o(r116, r103);
        if (r104 != r105) goto L25;
        return r105;
    L27:
        if ((r115 instanceof f.a) == false) goto L39;
        Result.Companion r117 = Result.Companion;     // Catch: Throwable -> L30
        throw null;     // Catch: Throwable -> L30
    L39:
        throw new NoWhenBranchMatchedException();
    L30:
        th = move-exception;
        Result.Companion r118 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L32
    L5:
        r103 = new HardwareRecordingManager$startRecordingInternal$1(r101, this);
        goto L6
    }
}
