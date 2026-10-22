package com.larus.community.impl.share;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.community.impl.share.SharePuzzleImageItemViewHolder", f = "SharePuzzleImageItemViewHolder.kt", i = {0, 0}, l = {199}, m = "fetchBitmap", n = {"cacheKey", "closeableHolder"}, s = {"L$0", "L$1"})
final class SharePuzzleImageItemViewHolder$fetchBitmap$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SharePuzzleImageItemViewHolder this$0;

    public SharePuzzleImageItemViewHolder$fetchBitmap$1(SharePuzzleImageItemViewHolder r100, Continuation<? super SharePuzzleImageItemViewHolder$fetchBitmap$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return SharePuzzleImageItemViewHolder.T3(this.this$0, null, null, null, this);
    }
}
