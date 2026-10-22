package com.ss.android.lark.officesdk.minutes.ui.record.recording.toolbar;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mwb.f;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "title", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.toolbar.MmRecordingTitleNameView$initVMStateObserver$2", f = "MmRecordingTitleNameView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MmRecordingTitleNameView$initVMStateObserver$2 extends SuspendLambda implements Function2<String, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MmRecordingTitleNameView this$0;

    public MmRecordingTitleNameView$initVMStateObserver$2(MmRecordingTitleNameView r100, Continuation<? super MmRecordingTitleNameView$initVMStateObserver$2> r101) {
        this.this$0 = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        MmRecordingTitleNameView$initVMStateObserver$2 r102 = new MmRecordingTitleNameView$initVMStateObserver$2(this.this$0, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(String r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(String r100, Continuation<? super Unit> r101) {
        return ((MmRecordingTitleNameView$initVMStateObserver$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r100);
        String r101 = (String) this.L$0;
        f r102 = this.this$0.f436641a;
        if (r102 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r102 = null;
    L7:
        r102.f516064d.setText(r101);
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
