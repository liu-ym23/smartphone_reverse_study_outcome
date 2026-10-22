package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.MmRecordingLanguageRepo$opt$2$1", f = "MmRecordingLanguageRepo.kt", i = {0, 0, 0}, l = {384, 401}, m = "executeAutomaticSetting", n = {"action", "commit", "expectedManualRevision"}, s = {"L$0", "L$1", "J$0"})
final class MmRecordingLanguageRepo$opt$2$1$executeAutomaticSetting$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmRecordingLanguageRepo$opt$2.AnonymousClass1 this$0;

    public MmRecordingLanguageRepo$opt$2$1$executeAutomaticSetting$1(MmRecordingLanguageRepo$opt$2.AnonymousClass1 r100, Continuation<? super MmRecordingLanguageRepo$opt$2$1$executeAutomaticSetting$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return MmRecordingLanguageRepo$opt$2.AnonymousClass1.T0(this.this$0, null, 0, null, null, this);
    }
}
