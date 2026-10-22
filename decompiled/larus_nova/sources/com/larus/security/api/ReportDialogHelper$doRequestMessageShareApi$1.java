package com.larus.security.api;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.security.api.ReportDialogHelper", f = "ReportDialogHelper.kt", i = {}, l = {137}, m = "doRequestMessageShareApi", n = {}, s = {})
public final class ReportDialogHelper$doRequestMessageShareApi$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ReportDialogHelper this$0;

    public ReportDialogHelper$doRequestMessageShareApi$1(ReportDialogHelper r100, Continuation<? super ReportDialogHelper$doRequestMessageShareApi$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(null, this);
    }
}
