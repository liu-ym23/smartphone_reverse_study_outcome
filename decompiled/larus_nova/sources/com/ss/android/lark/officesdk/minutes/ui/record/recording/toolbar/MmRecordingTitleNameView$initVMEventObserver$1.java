package com.ss.android.lark.officesdk.minutes.ui.record.recording.toolbar;

import com.larus.nova.R;
import com.ss.android.lark.officesdk.minutes.ui.record.recording.base.h;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "event", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/base/MmRecordingVMEvent;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.toolbar.MmRecordingTitleNameView$initVMEventObserver$1", f = "MmRecordingTitleNameView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MmRecordingTitleNameView$initVMEventObserver$1 extends SuspendLambda implements Function2<h, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MmRecordingTitleNameView this$0;

    public MmRecordingTitleNameView$initVMEventObserver$1(MmRecordingTitleNameView r100, Continuation<? super MmRecordingTitleNameView$initVMEventObserver$1> r101) {
        this.this$0 = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        MmRecordingTitleNameView$initVMEventObserver$1 r102 = new MmRecordingTitleNameView$initVMEventObserver$1(this.this$0, r101);
        r102.L$0 = r100;
        return r102;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(h r100, Continuation<? super Unit> r101) {
        return ((MmRecordingTitleNameView$initVMEventObserver$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(h r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L14;
        ResultKt.throwOnFailure(r100);
        h r101 = (h) this.L$0;
        if ((r101 instanceof h.C5207h) == false) goto L12;
        h.C5207h r102 = (h.C5207h) r101;
        if (r102.f436236b == false) goto L9;
        com.ss.android.lark.officesdk.minutes.service.foundation.utils.b.f(R.string.MMWeb_G_NoInternetConnectionTryAgainLater);
    L10:
        MmRecordingTitleNameView r103 = this.this$0;
        String r104 = r102.f436235a;
        int r105 = MmRecordingTitleNameView.f436640e;
        r103.U5(r104, "UpdateTitleFailed");
        goto L12
    L9:
        com.ss.android.lark.officesdk.minutes.service.foundation.utils.b.a(R.string.MMWeb_G_UpdateLocation_SthWrongTryLater_Toast);
    L12:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
