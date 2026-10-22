package com.ss.android.lark.officesdk.minutes.ui.record.recording.toolbar;

import com.ss.ttvideoengine.ITTVideoEngineEventSource;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mwb.g;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", ITTVideoEngineEventSource.KEY_VOLUME, ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.toolbar.MmRecordingToolBarView$subscribeAudioVolume$2", f = "MmRecordingToolBarView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MmRecordingToolBarView$subscribeAudioVolume$2 extends SuspendLambda implements Function2<Integer, Continuation<? super Unit>, Object> {
    /* synthetic */ int I$0;
    int label;
    final /* synthetic */ MmRecordingToolBarView this$0;

    public MmRecordingToolBarView$subscribeAudioVolume$2(MmRecordingToolBarView r100, Continuation<? super MmRecordingToolBarView$subscribeAudioVolume$2> r101) {
        this.this$0 = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        MmRecordingToolBarView$subscribeAudioVolume$2 r102 = new MmRecordingToolBarView$subscribeAudioVolume$2(this.this$0, r101);
        r102.I$0 = ((Number) r100).intValue();
        return r102;
    }

    public final Object invoke(int r100, Continuation<? super Unit> r101) {
        return ((MmRecordingToolBarView$subscribeAudioVolume$2) create(Integer.valueOf(r100), r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Integer r100, Continuation<? super Unit> r101) {
        return invoke(r100.intValue(), r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r100);
        int r101 = this.I$0;
        g r102 = this.this$0.f436645a;
        if (r102 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r102 = null;
    L7:
        r102.f516073b.j(r101);
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
