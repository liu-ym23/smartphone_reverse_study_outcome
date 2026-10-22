package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.statessync;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.statessync.MmRecordingObjectReadyCoordinator$awaitRecordingId$3", f = "MmRecordingObjectReadyCoordinator.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MmRecordingObjectReadyCoordinator$awaitRecordingId$3 extends SuspendLambda implements Function2<String, Continuation<? super Boolean>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MmRecordingObjectReadyCoordinator this$0;

    public MmRecordingObjectReadyCoordinator$awaitRecordingId$3(MmRecordingObjectReadyCoordinator r100, Continuation<? super MmRecordingObjectReadyCoordinator$awaitRecordingId$3> r101) {
        this.this$0 = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        MmRecordingObjectReadyCoordinator$awaitRecordingId$3 r102 = new MmRecordingObjectReadyCoordinator$awaitRecordingId$3(this.this$0, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(String r100, Continuation<? super Boolean> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(String r100, Continuation<? super Boolean> r101) {
        return ((MmRecordingObjectReadyCoordinator$awaitRecordingId$3) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        String r101 = (String) this.L$0;
        this.this$0.getClass();
        return Boxing.boxBoolean(MmRecordingObjectReadyCoordinator.b(r101));
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
