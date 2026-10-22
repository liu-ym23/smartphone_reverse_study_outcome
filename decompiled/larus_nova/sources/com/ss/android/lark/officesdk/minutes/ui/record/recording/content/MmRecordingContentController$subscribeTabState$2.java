package com.ss.android.lark.officesdk.minutes.ui.record.recording.content;

import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.meta.MmRecordingUITab;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "currentTab", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/meta/MmRecordingUITab;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.content.MmRecordingContentController$subscribeTabState$2", f = "MmRecordingContentController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MmRecordingContentController$subscribeTabState$2 extends SuspendLambda implements Function2<MmRecordingUITab, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MmRecordingContentController this$0;

    public MmRecordingContentController$subscribeTabState$2(MmRecordingContentController r100, Continuation<? super MmRecordingContentController$subscribeTabState$2> r101) {
        this.this$0 = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        MmRecordingContentController$subscribeTabState$2 r102 = new MmRecordingContentController$subscribeTabState$2(this.this$0, r101);
        r102.L$0 = r100;
        return r102;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(MmRecordingUITab r100, Continuation<? super Unit> r101) {
        return ((MmRecordingContentController$subscribeTabState$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(MmRecordingUITab r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        MmRecordingUITab r101 = (MmRecordingUITab) this.L$0;
        MmRecordingContentController r102 = this.this$0;
        int r103 = MmRecordingContentController.f436298p;
        r102.f(r101, "state");
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
