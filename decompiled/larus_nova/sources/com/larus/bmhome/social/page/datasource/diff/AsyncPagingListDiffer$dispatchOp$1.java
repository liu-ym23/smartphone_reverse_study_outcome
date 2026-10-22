package com.larus.bmhome.social.page.datasource.diff;

import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.social.page.datasource.diff.AsyncPagingListDiffer", f = "PagingListDiffer.kt", i = {0, 0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_VIEW_WIDTH}, m = "dispatchOp", n = {"op", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1"})
final class AsyncPagingListDiffer$dispatchOp$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AsyncPagingListDiffer<Object> this$0;

    public AsyncPagingListDiffer$dispatchOp$1(AsyncPagingListDiffer<Object> r100, Continuation<? super AsyncPagingListDiffer$dispatchOp$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        AsyncPagingListDiffer<Object> r101 = this.this$0;
        int r102 = AsyncPagingListDiffer.f314004e;
        r101.l(null, this);
        throw null;
    }
}
