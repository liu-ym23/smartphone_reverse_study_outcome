package com.larus.uaigc.helper;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.uaigc.helper.CreationImageReviewHandler", f = "CreationImageNodeHandlers.kt", i = {0}, l = {303}, m = "execute", n = {"uri"}, s = {"L$0"})
public final class CreationImageReviewHandler$execute$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CreationImageReviewHandler this$0;

    public CreationImageReviewHandler$execute$1(CreationImageReviewHandler r100, Continuation<? super CreationImageReviewHandler$execute$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.c(null, this);
    }
}
