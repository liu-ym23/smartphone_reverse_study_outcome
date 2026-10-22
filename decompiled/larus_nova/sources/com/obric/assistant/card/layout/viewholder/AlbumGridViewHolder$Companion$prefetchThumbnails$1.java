package com.obric.assistant.card.layout.viewholder;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.card.layout.viewholder.AlbumGridViewHolder$Companion", f = "AlbumGridViewHolder.kt", i = {0}, l = {102}, m = "prefetchThumbnails", n = {"sizePx"}, s = {"I$0"})
public final class AlbumGridViewHolder$Companion$prefetchThumbnails$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AlbumGridViewHolder.Companion this$0;

    public AlbumGridViewHolder$Companion$prefetchThumbnails$1(AlbumGridViewHolder.Companion r100, Continuation<? super AlbumGridViewHolder$Companion$prefetchThumbnails$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.c(0, null, this);
    }
}
