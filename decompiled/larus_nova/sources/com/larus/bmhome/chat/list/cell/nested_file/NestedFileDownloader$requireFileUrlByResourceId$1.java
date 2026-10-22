package com.larus.bmhome.chat.list.cell.nested_file;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.list.cell.nested_file.NestedFileDownloader", f = "NestedFileDownloader.kt", i = {0}, l = {224}, m = "requireFileUrlByResourceId", n = {"resourceId"}, s = {"L$0"})
public final class NestedFileDownloader$requireFileUrlByResourceId$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NestedFileDownloader this$0;

    public NestedFileDownloader$requireFileUrlByResourceId$1(NestedFileDownloader r100, Continuation<? super NestedFileDownloader$requireFileUrlByResourceId$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        NestedFileDownloader r101 = this.this$0;
        NestedFileDownloader r102 = NestedFileDownloader.f305412a;
        return r101.g(null, this);
    }
}
