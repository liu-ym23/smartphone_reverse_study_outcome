package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.MmRecordingAutoTranslationCoordinator", f = "MmRecordingAutoTranslationCoordinator.kt", i = {}, l = {345}, m = "deliverCompletion", n = {}, s = {})
public final class MmRecordingAutoTranslationCoordinator$deliverCompletion$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmRecordingAutoTranslationCoordinator this$0;

    public MmRecordingAutoTranslationCoordinator$deliverCompletion$1(MmRecordingAutoTranslationCoordinator r100, Continuation<? super MmRecordingAutoTranslationCoordinator$deliverCompletion$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        MmRecordingAutoTranslationCoordinator r101 = this.this$0;
        int r102 = MmRecordingAutoTranslationCoordinator.f435254k;
        return r101.d(null, this);
    }
}
