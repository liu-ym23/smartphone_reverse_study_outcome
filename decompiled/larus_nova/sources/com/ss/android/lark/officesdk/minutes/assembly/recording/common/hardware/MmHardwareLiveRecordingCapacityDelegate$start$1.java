package com.ss.android.lark.officesdk.minutes.assembly.recording.common.hardware;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingError;
import iub.j;
import iub.k;
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
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.assembly.recording.common.hardware.MmHardwareLiveRecordingCapacityDelegate", f = "MmHardwareLiveRecordingCapacityDelegate.kt", i = {}, l = {28}, m = "start-0E7RQCE", n = {}, s = {})
final class MmHardwareLiveRecordingCapacityDelegate$start$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmHardwareLiveRecordingCapacityDelegate this$0;

    public MmHardwareLiveRecordingCapacityDelegate$start$1(MmHardwareLiveRecordingCapacityDelegate r100, Continuation<? super MmHardwareLiveRecordingCapacityDelegate$start$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        final MmHardwareLiveRecordingCapacityDelegate r101 = this.this$0;
        r101.getClass();
        int r102 = this.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r102 - Integer.MIN_VALUE;
        MmHardwareLiveRecordingCapacityDelegate$start$1 r103 = this;
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
        r107 = ((j) r107).f495845a;
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
        Function1<j, Unit> r108 = new MmHardwareLiveRecordingCapacityDelegate$start$2(r101);
        final k r109 = null;
        final Object[] r110 = 0 == true ? 1 : 0;
        Function1<iub.a<j, ? super MmRecordingError>, Unit> r111 = new MmHardwareLiveRecordingCapacityDelegate$start$3(r101, r109, r110);
        r103.label = 1;
        r107 = r101.a(r108, r111, r103);
        if (r107 != r105) goto L16;
    L5:
        r103 = new MmHardwareLiveRecordingCapacityDelegate$start$1(r101, this);
        goto L6
    }
}
