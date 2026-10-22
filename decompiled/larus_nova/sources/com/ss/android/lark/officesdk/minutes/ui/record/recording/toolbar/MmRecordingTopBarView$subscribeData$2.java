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
import mwb.h;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "showAudioSaveEntry", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.toolbar.MmRecordingTopBarView$subscribeData$2", f = "MmRecordingTopBarView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MmRecordingTopBarView$subscribeData$2 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
    /* synthetic */ boolean Z$0;
    int label;
    final /* synthetic */ MmRecordingTopBarView this$0;

    public MmRecordingTopBarView$subscribeData$2(MmRecordingTopBarView r100, Continuation<? super MmRecordingTopBarView$subscribeData$2> r101) {
        this.this$0 = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        MmRecordingTopBarView$subscribeData$2 r102 = new MmRecordingTopBarView$subscribeData$2(this.this$0, r101);
        r102.Z$0 = ((Boolean) r100).booleanValue();
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Boolean r100, Continuation<? super Unit> r101) {
        return invoke(r100.booleanValue(), r101);
    }

    public final Object invoke(boolean r100, Continuation<? super Unit> r101) {
        return ((MmRecordingTopBarView$subscribeData$2) create(Boolean.valueOf(r100), r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L19;
        ResultKt.throwOnFailure(r100);
        h r101 = null;
        if (this.Z$0 == false) goto L11;
        h r102 = this.this$0.f436651a;
        if (r102 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L10:
        r101.f516085f.setVisibility(0);
    L17:
        return Unit.INSTANCE;
    L9:
        r101 = r102;
        goto L10
    L11:
        h r103 = this.this$0.f436651a;
        if (r103 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L15:
        r101.f516085f.setVisibility(8);
        goto L17
    L14:
        r101 = r103;
        goto L15
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
