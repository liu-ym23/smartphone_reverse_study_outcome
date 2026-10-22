package com.ss.android.lark.mention.base.impl.atselector.doubaoview;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.mention.base.impl.atselector.doubaoview.DoubaoMentionRecommendDataLoader", f = "DoubaoMentionRecommendDataLoader.kt", i = {0}, l = {56}, m = "search-0E7RQCE", n = {"keyword"}, s = {"L$0"})
public final class DoubaoMentionRecommendDataLoader$search$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DoubaoMentionRecommendDataLoader this$0;

    public DoubaoMentionRecommendDataLoader$search$1(DoubaoMentionRecommendDataLoader r100, Continuation<? super DoubaoMentionRecommendDataLoader$search$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        Object r101 = this.this$0.b(null, null, this);
        if (r101 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r101;
    L6:
        return Result.m9448boximpl(r101);
    }
}
