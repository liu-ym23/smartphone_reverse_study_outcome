package com.larus.chat.gallery.impl.preview.datasource;

import com.bytedance.locallife.dito.data.DitoNode;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.chat.gallery.impl.preview.datasource.PreviewCreationRecordDataSource", f = "PreviewCreationRecordDataSource.kt", i = {0}, l = {120}, m = DitoNode.LOAD_MORE, n = {"currentSize"}, s = {"I$0"})
final class PreviewCreationRecordDataSource$loadMore$1 extends ContinuationImpl {
    int I$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PreviewCreationRecordDataSource this$0;

    public PreviewCreationRecordDataSource$loadMore$1(PreviewCreationRecordDataSource r100, Continuation<? super PreviewCreationRecordDataSource$loadMore$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.p(this);
    }
}
