package com.larus.larkfeed.impl.gallery;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.larkfeed.impl.gallery.Message2GalleryItemExtKt", f = "Message2GalleryItemExt.kt", i = {0}, l = {132}, m = "toVideoPlayData", n = {"$this$toVideoPlayData"}, s = {"L$0"})
public final class Message2GalleryItemExtKt$toVideoPlayData$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    public Message2GalleryItemExtKt$toVideoPlayData$1(Continuation<? super Message2GalleryItemExtKt$toVideoPlayData$1> r100) {
        super(r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return Message2GalleryItemExtKt.b(null, this);
    }
}
