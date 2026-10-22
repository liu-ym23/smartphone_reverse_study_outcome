package com.bytedance.lark.lark_biz_feed_android_wrapper;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.lark.lark_biz_feed_android_wrapper.LarkFeedListViewModel", f = "LarkFeedListViewFlowWrapper.kt", i = {}, l = {260}, m = "action-vFDjHp0$suspendImpl", n = {}, s = {})
public final class LarkFeedListViewModel$action$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LarkFeedListViewModel this$0;

    public LarkFeedListViewModel$action$1(LarkFeedListViewModel r100, Continuation<? super LarkFeedListViewModel$action$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        Object r101 = LarkFeedListViewModel.m8373actionvFDjHp0$suspendImpl(this.this$0, null, this);
        if (r101 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r101;
    L6:
        return new com.bytedance.lark.view_flow_wrapper.d(r101);
    }
}
