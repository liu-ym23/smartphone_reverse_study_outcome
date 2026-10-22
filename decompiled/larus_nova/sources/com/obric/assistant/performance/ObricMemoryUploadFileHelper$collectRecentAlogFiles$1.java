package com.obric.assistant.performance;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.performance.ObricMemoryUploadFileHelper", f = "ObricMemoryUploadFileHelper.kt", i = {0, 0}, l = {37}, m = "collectRecentAlogFiles", n = {"endTimeMs", "startTimeMs"}, s = {"J$0", "J$1"})
public final class ObricMemoryUploadFileHelper$collectRecentAlogFiles$1 extends ContinuationImpl {
    long J$0;
    long J$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ObricMemoryUploadFileHelper this$0;

    public ObricMemoryUploadFileHelper$collectRecentAlogFiles$1(ObricMemoryUploadFileHelper r100, Continuation<? super ObricMemoryUploadFileHelper$collectRecentAlogFiles$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.c(0, null, this);
    }
}
