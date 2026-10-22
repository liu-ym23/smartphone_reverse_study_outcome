package com.larus.security.api;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.security.api.TTCNPAHelper", f = "TTCNPAHelper.kt", i = {0}, l = {176, 191}, m = "writeMetadataManually", n = {"params"}, s = {"L$0"})
public final class TTCNPAHelper$writeMetadataManually$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TTCNPAHelper this$0;

    public TTCNPAHelper$writeMetadataManually$1(TTCNPAHelper r100, Continuation<? super TTCNPAHelper$writeMetadataManually$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.d(null, this);
    }
}
