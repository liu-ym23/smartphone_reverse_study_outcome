package com.larus.avlink.gallery.executor;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.avlink.gallery.executor.MediaDownloadExecutor", f = "MediaDownloadExecutor.kt", i = {0, 1, 1, 2, 2, 3, 3}, l = {165, 177, 201, 208}, m = "recoverIncompleteDownloads", n = {"recoveredMediaIds", "recoveredMediaIds", "metadata", "recoveredMediaIds", "metadata", "recoveredMediaIds", "metadata"}, s = {"L$0", "L$0", "L$2", "L$0", "L$2", "L$0", "L$2"})
public final class MediaDownloadExecutor$recoverIncompleteDownloads$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MediaDownloadExecutor this$0;

    public MediaDownloadExecutor$recoverIncompleteDownloads$1(MediaDownloadExecutor r100, Continuation<? super MediaDownloadExecutor$recoverIncompleteDownloads$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.l(this);
    }
}
