package com.ss.android.lark.officesdk.minutes.service.recording.hardware;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.hardware.HardwareRecordingManager", f = "HardwareRecordingManager.kt", i = {}, l = {572}, m = "rollbackStartedRecordingSession", n = {}, s = {})
final class HardwareRecordingManager$rollbackStartedRecordingSession$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ d this$0;

    public HardwareRecordingManager$rollbackStartedRecordingSession$1(d r100, Continuation<? super HardwareRecordingManager$rollbackStartedRecordingSession$1> r101) {
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
        HardwareRecordingManager$rollbackStartedRecordingSession$1 r103 = this;
    L6:
        Object r104 = r103.result;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r103.label;
        if (r105 != 0) goto L9;
        ResultKt.throwOnFailure(r104);
        lvb.a.e(null, "[rollbackStartedRecordingSession] session=null");
        throw null;
    L9:
        if (r105 != 1) goto L25;
        ResultKt.throwOnFailure(r104);
        a r106 = (a) r104;
        if (Intrinsics.areEqual(r106, a.c.f435551a) == true) goto L23;
        if ((r106 instanceof a.b) == false) goto L15;
        lvb.a.h(null, "[rollbackStartedRecordingSession] ignored, reason=" + ((a.b) r106).f435550a);
        throw null;
    L15:
        if ((r106 instanceof a.C5196a) == false) goto L19;
        StringBuilder r107 = new StringBuilder("[rollbackStartedRecordingSession] failed, code=");
        a.C5196a r108 = (a.C5196a) r106;
        r107.append(r108.f435548a);
        r107.append(", message=");
        r107.append(r108.f435549b);
        lvb.a.b(null, r107.toString());
        throw null;
    L19:
        throw new NoWhenBranchMatchedException();
    L23:
        return Unit.INSTANCE;
    L25:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L5:
        r103 = new HardwareRecordingManager$rollbackStartedRecordingSession$1(r101, this);
        goto L6
    }
}
