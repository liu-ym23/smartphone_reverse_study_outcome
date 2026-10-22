package com.ss.android.lark.feed.molten.cache.user;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.feed.molten.cache.user.FeedUserHolderLocalCache", f = "FeedUserHolderLocalCache.kt", i = {0, 0}, l = {353}, m = "persistPlan", n = {"plan", "mark$iv$iv"}, s = {"L$0", "J$0"})
public final class FeedUserHolderLocalCache$persistPlan$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FeedUserHolderLocalCache this$0;

    public FeedUserHolderLocalCache$persistPlan$1(FeedUserHolderLocalCache r100, Continuation<? super FeedUserHolderLocalCache$persistPlan$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        FeedUserHolderLocalCache r101 = this.this$0;
        int r102 = FeedUserHolderLocalCache.f421039p;
        return r101.f(null, this);
    }
}
