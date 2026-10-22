package com.bytedance.android.window.shop.innerflow.repo;

import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002H\u0082@"}, d2 = {"Lcom/bytedance/android/window/shop/innerflow/repo/ECWindowInnerFlowReqParam;", "reqParam", "Lkotlin/coroutines/Continuation;", "Lcom/bytedance/android/window/shop/innerflow/entity/dto/ECShopInnerFlowDTO;", "continuation", "", "getInnerFlowDataSafely"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.window.shop.innerflow.repo.ECWindowInnerFlowRepo", f = "ECWindowInnerFlowRepo.kt", i = {0, 0}, l = {ECDraweeView.SELF_ADJUST_PIXEL, 34}, m = "getInnerFlowDataSafely", n = {"this", "reqParam"}, s = {"L$0", "L$1"})
public final class ECWindowInnerFlowRepo$getInnerFlowDataSafely$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ECWindowInnerFlowRepo this$0;

    public ECWindowInnerFlowRepo$getInnerFlowDataSafely$1(ECWindowInnerFlowRepo r1, Continuation r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.c(null, this);
    }
}
