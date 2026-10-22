package com.larus.dora.o.impl.diary;

import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.o.impl.diary.DoraODiaryRepo", f = "DoraODiaryRepo.kt", i = {0, 0}, l = {132}, m = "submitFeedback", n = {"diaryId", ReportConstant.COMMON_ACTION_TYPE}, s = {"L$0", "I$0"})
public final class DoraODiaryRepo$submitFeedback$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DoraODiaryRepo this$0;

    public DoraODiaryRepo$submitFeedback$1(DoraODiaryRepo r100, Continuation<? super DoraODiaryRepo$submitFeedback$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.i(null, 0, null, null, null, null, this);
    }
}
