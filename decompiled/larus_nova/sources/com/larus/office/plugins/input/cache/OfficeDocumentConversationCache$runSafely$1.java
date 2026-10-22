package com.larus.office.plugins.input.cache;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.office.plugins.input.cache.OfficeDocumentConversationCache", f = "OfficeDocumentConversationCache.kt", i = {0}, l = {413}, m = "runSafely", n = {"defaultValue"}, s = {"L$0"})
public final class OfficeDocumentConversationCache$runSafely$1<T> extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OfficeDocumentConversationCache this$0;

    public OfficeDocumentConversationCache$runSafely$1(OfficeDocumentConversationCache r100, Continuation<? super OfficeDocumentConversationCache$runSafely$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        OfficeDocumentConversationCache r101 = this.this$0;
        OfficeDocumentConversationCache r102 = OfficeDocumentConversationCache.f362464a;
        return r101.k(null, null, this);
    }
}
