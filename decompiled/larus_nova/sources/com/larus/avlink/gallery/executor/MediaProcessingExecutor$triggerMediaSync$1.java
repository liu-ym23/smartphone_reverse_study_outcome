package com.larus.avlink.gallery.executor;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.avlink.gallery.executor.MediaProcessingExecutor", f = "MediaProcessingExecutor.kt", i = {0, 1}, l = {566, 570}, m = "triggerMediaSync", n = {"uniqId", "uniqId"}, s = {"L$0", "L$0"})
public final class MediaProcessingExecutor$triggerMediaSync$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MediaProcessingExecutor this$0;

    public MediaProcessingExecutor$triggerMediaSync$1(MediaProcessingExecutor r100, Continuation<? super MediaProcessingExecutor$triggerMediaSync$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        MediaProcessingExecutor r101 = this.this$0;
        int r102 = MediaProcessingExecutor.f292540k;
        return r101.h(null, this);
    }
}
