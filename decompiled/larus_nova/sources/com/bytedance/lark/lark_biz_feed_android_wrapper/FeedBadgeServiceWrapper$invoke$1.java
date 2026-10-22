package com.bytedance.lark.lark_biz_feed_android_wrapper;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.lark.lark_biz_feed_android_wrapper.FeedBadgeServiceWrapper", f = "FeedBadgeServiceWrapper.kt", i = {}, l = {31}, m = "invoke-gIAlu-s", n = {}, s = {})
public final class FeedBadgeServiceWrapper$invoke$1<T> extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FeedBadgeServiceWrapper this$0;

    public FeedBadgeServiceWrapper$invoke$1(FeedBadgeServiceWrapper r100, Continuation<? super FeedBadgeServiceWrapper$invoke$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        Object r101 = this.this$0.lc(null, this);
        if (r101 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r101;
    L6:
        return Result.m9448boximpl(r101);
    }
}
