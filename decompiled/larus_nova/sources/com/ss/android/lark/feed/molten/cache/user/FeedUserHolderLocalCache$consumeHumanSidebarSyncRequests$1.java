package com.ss.android.lark.feed.molten.cache.user;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.feed.molten.cache.user.FeedUserHolderLocalCache", f = "FeedUserHolderLocalCache.kt", i = {}, l = {274}, m = "consumeHumanSidebarSyncRequests", n = {}, s = {})
final class FeedUserHolderLocalCache$consumeHumanSidebarSyncRequests$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FeedUserHolderLocalCache this$0;

    public FeedUserHolderLocalCache$consumeHumanSidebarSyncRequests$1(FeedUserHolderLocalCache r100, Continuation<? super FeedUserHolderLocalCache$consumeHumanSidebarSyncRequests$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return FeedUserHolderLocalCache.a(this.this$0, this);
    }
}
