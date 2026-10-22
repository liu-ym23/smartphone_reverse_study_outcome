package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.upload;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/core/service/upload/MmRecordingUploadResponse;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.upload.MmRecordingUploadTask$execute$1", f = "MmRecordingUploadTask.kt", i = {}, l = {29, 29}, m = "invokeSuspend", n = {}, s = {})
final class MmRecordingUploadTask$execute$1 extends SuspendLambda implements Function2<FlowCollector<? super MmRecordingUploadResponse>, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a $userContext;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MmRecordingUploadTask this$0;

    public MmRecordingUploadTask$execute$1(MmRecordingUploadTask r100, com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a r101, Continuation<? super MmRecordingUploadTask$execute$1> r102) {
        this.this$0 = r100;
        this.$userContext = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        MmRecordingUploadTask$execute$1 r102 = new MmRecordingUploadTask$execute$1(this.this$0, this.$userContext, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super MmRecordingUploadResponse> r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(FlowCollector<? super MmRecordingUploadResponse> r100, Continuation<? super Unit> r101) {
        return ((MmRecordingUploadTask$execute$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L10;
        if (r102 == 1) goto L9;
        if (r102 != 2) goto L8;
        ResultKt.throwOnFailure(r100);
    L17:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        FlowCollector r103 = (FlowCollector) this.L$0;
        ResultKt.throwOnFailure(r100);
    L13:
        this.L$0 = null;
        this.label = 2;
        if (r103.emit(r100, this) != r101) goto L17;
        return r101;
    L10:
        ResultKt.throwOnFailure(r100);
        r103 = (FlowCollector) this.L$0;
        MmRecordingUploadTask r104 = this.this$0;
        com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a r105 = this.$userContext;
        this.L$0 = r103;
        this.label = 1;
        r100 = MmRecordingUploadTask.a(r104, r105, this);
        if (r100 != r101) goto L13;
        return r101;
    }
}
