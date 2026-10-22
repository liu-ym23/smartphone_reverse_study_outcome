package com.larus.bmhome.bigimg.download;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.bigimg.download.ImageDownloadLoadingMgr", f = "ImageDownloadLoadingMgr.kt", i = {}, l = {63}, m = "collectLoadingStatus", n = {}, s = {})
public final class ImageDownloadLoadingMgr$collectLoadingStatus$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ImageDownloadLoadingMgr this$0;

    public ImageDownloadLoadingMgr$collectLoadingStatus$1(ImageDownloadLoadingMgr r100, Continuation<? super ImageDownloadLoadingMgr$collectLoadingStatus$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, null, this);
    }
}
