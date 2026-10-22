package com.larus.office.card.doc.download;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.office.card.doc.download.DocExportChooseDialog", f = "DocExportChooseDialog.kt", i = {}, l = {325}, m = "resolveExportResource", n = {}, s = {})
final class DocExportChooseDialog$resolveExportResource$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DocExportChooseDialog this$0;

    public DocExportChooseDialog$resolveExportResource$1(DocExportChooseDialog r100, Continuation<? super DocExportChooseDialog$resolveExportResource$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return DocExportChooseDialog.S90(this.this$0, this);
    }
}
