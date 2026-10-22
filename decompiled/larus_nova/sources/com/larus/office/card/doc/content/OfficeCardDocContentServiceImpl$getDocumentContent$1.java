package com.larus.office.card.doc.content;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.office.card.doc.content.OfficeCardDocContentServiceImpl", f = "OfficeCardDocContentServiceImpl.kt", i = {}, l = {19}, m = "getDocumentContent", n = {}, s = {})
public final class OfficeCardDocContentServiceImpl$getDocumentContent$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OfficeCardDocContentServiceImpl this$0;

    public OfficeCardDocContentServiceImpl$getDocumentContent$1(OfficeCardDocContentServiceImpl r100, Continuation<? super OfficeCardDocContentServiceImpl$getDocumentContent$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(null, 0, this);
    }
}
