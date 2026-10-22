package com.ss.android.lark.mention.base.impl.atselector.doubaoview;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.mention.base.impl.atselector.doubaoview.DoubaoMentionRecommendDataLoaderKt", f = "DoubaoMentionRecommendDataLoader.kt", i = {}, l = {165}, m = "requestClosestChatters", n = {}, s = {})
final class DoubaoMentionRecommendDataLoaderKt$requestClosestChatters$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;

    public DoubaoMentionRecommendDataLoaderKt$requestClosestChatters$1(Continuation<? super DoubaoMentionRecommendDataLoaderKt$requestClosestChatters$1> r100) {
        super(r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        Object r101 = g.a(this);
        if (r101 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r101;
    L6:
        return Result.m9448boximpl(r101);
    }
}
