package com.ss.android.lark.officesdk.minutes.assembly.recording.common.hardware;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingError;
import iub.j;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.assembly.recording.common.hardware.MmHardwareLiveRecordingCapacityDelegate", f = "MmHardwareLiveRecordingCapacityDelegate.kt", i = {}, l = {55}, m = "resume-gIAlu-s", n = {}, s = {})
final class MmHardwareLiveRecordingCapacityDelegate$resume$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmHardwareLiveRecordingCapacityDelegate this$0;

    public MmHardwareLiveRecordingCapacityDelegate$resume$1(MmHardwareLiveRecordingCapacityDelegate r100, Continuation<? super MmHardwareLiveRecordingCapacityDelegate$resume$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        final MmHardwareLiveRecordingCapacityDelegate r101 = this.this$0;
        r101.getClass();
        int r102 = this.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r102 - Integer.MIN_VALUE;
        MmHardwareLiveRecordingCapacityDelegate$resume$1 r103 = this;
    L6:
        Object r104 = r103.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r103.label;
        if (r106 == 0) goto L12;
        if (r106 != 1) goto L11;
        ResultKt.throwOnFailure(r104);
        Object r107 = ((Result) r104).m9458unboximpl();
    L16:
        if (Result.m9456isSuccessimpl(r107) == false) goto L18;
        j r108 = (j) r107;
        r107 = Unit.INSTANCE;
    L18:
        r105 = Result.m9449constructorimpl(r107);
    L20:
        if (r105 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L23;
        return r105;
    L23:
        return Result.m9448boximpl(r105);
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r104);
        final String r109 = null;
        Function1<iub.a<j, ? super MmRecordingError>, Unit> r110 = new MmHardwareLiveRecordingCapacityDelegate$resume$2(r101, r109);
        r103.label = 1;
        r107 = r101.a(null, r110, r103);
        if (r107 != r105) goto L16;
    L5:
        r103 = new MmHardwareLiveRecordingCapacityDelegate$resume$1(r101, this);
        goto L6
    }
}
