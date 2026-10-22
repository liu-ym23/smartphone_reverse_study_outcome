package com.larus.bmhome.chat.map;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.map.ImageCacheLoader", f = "ImageExpireNewLoader.kt", i = {0}, l = {107}, m = "requestNewUrl", n = {"url"}, s = {"L$0"})
final class ImageCacheLoader$requestNewUrl$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ b this$0;

    public ImageCacheLoader$requestNewUrl$1(b r100, Continuation<? super ImageCacheLoader$requestNewUrl$1> r101) {
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
