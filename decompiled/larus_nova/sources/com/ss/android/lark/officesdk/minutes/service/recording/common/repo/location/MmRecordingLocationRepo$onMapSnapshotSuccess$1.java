package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.location;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.location.MmRecordingLocationRepo$onMapSnapshotSuccess$1", f = "MmRecordingLocationRepo.kt", i = {}, l = {299}, m = "invokeSuspend", n = {}, s = {})
final class MmRecordingLocationRepo$onMapSnapshotSuccess$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MmRecordingLocationRepo this$0;

    public MmRecordingLocationRepo$onMapSnapshotSuccess$1(MmRecordingLocationRepo r100, Continuation<? super MmRecordingLocationRepo$onMapSnapshotSuccess$1> r101) {
        this.this$0 = r100;
        super(1, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> r100) {
        return new MmRecordingLocationRepo$onMapSnapshotSuccess$1(this.this$0, r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Unit> r100) {
        return invoke2(r100);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super Unit> r100) {
        return ((MmRecordingLocationRepo$onMapSnapshotSuccess$1) create(r100)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 == 0) goto L8;
        if (r101 != 1) goto L7;
        ResultKt.throwOnFailure(r110);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r110);
        MmRecordingLocationRepo r111 = this.this$0;
        d r102 = d.a((d) r111.h(), null, null, null, true, false, 23);
        this.label = 1;
        if (r111.b(r102, this) != r100) goto L12;
        return r100;
    }
}
