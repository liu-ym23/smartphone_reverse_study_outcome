package com.bytedance.ee.bear.middleground.comment.card.aside;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ee.bear.middleground.comment.card.aside.AsidePageAdapter", f = "AsidePageAdapter.kt", i = {0, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3}, l = {185, 186, 221, 223, 231}, m = "switchCurrentItem", n = {"targetItem", "targetItem", "lastCommentId", "commentId", "commentUUID", "commentType", "targetItem", "lastCommentId", "commentId", "commentUUID", "commentType"}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "I$0", "L$0", "L$1", "L$2", "L$3", "I$0"})
public final class AsidePageAdapter$switchCurrentItem$2 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AsidePageAdapter this$0;

    public AsidePageAdapter$switchCurrentItem$2(AsidePageAdapter r100, Continuation<? super AsidePageAdapter$switchCurrentItem$2> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.G2(null, false, null, this);
    }
}
