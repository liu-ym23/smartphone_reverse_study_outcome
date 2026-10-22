package com.obric.assistant.feedback.upload;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.feedback.upload.ReportUploadWorker", f = "ReportUploadWorker.kt", i = {}, l = {315}, m = "uploadFiles", n = {}, s = {})
public final class ReportUploadWorker$uploadFiles$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ReportUploadWorker this$0;

    public ReportUploadWorker$uploadFiles$1(ReportUploadWorker r100, Continuation<? super ReportUploadWorker$uploadFiles$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        ReportUploadWorker r101 = this.this$0;
        int r102 = ReportUploadWorker.f389276c;
        return r101.f(null, null, null, null, this);
    }
}
