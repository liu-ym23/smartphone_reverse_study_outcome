package com.ss.android.lark.officesdk.minutes.ui.record.speaker;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.speaker.MmSpeakerMarkViewModel", f = "MmSpeakerMarkViewModel.kt", i = {}, l = {182}, m = "createSpeaker-gIAlu-s", n = {}, s = {})
public final class MmSpeakerMarkViewModel$createSpeaker$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmSpeakerMarkViewModel this$0;

    public MmSpeakerMarkViewModel$createSpeaker$1(MmSpeakerMarkViewModel r100, Continuation<? super MmSpeakerMarkViewModel$createSpeaker$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        Object r101 = MmSpeakerMarkViewModel.m8652access$createSpeakergIAlus(this.this$0, null, this);
        if (r101 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r101;
    L6:
        return Result.m9448boximpl(r101);
    }
}
