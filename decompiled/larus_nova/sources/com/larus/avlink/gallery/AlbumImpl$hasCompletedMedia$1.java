package com.larus.avlink.gallery;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.avlink.gallery.AlbumImpl", f = "IAlbumService.kt", i = {}, l = {59}, m = "hasCompletedMedia", n = {}, s = {})
public final class AlbumImpl$hasCompletedMedia$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AlbumImpl this$0;

    public AlbumImpl$hasCompletedMedia$1(AlbumImpl r100, Continuation<? super AlbumImpl$hasCompletedMedia$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.d(this);
    }
}
