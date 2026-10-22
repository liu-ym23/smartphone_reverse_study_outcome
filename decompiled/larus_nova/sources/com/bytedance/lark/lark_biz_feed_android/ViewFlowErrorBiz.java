package com.bytedance.lark.lark_biz_feed_android;

import com.bytedance.ee.bear.doc.follow.impl.rn.RNParamRegisterEventHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/lark/lark_biz_feed_android/ViewFlowErrorBiz;", "Lcom/bytedance/lark/lark_biz_feed_android/ViewFlowError;", RNParamRegisterEventHandler.SRC_INNER, "Lcom/bytedance/lark/lark_biz_feed_android/BizError;", "(Lcom/bytedance/lark/lark_biz_feed_android/BizError;)V", "getInner", "()Lcom/bytedance/lark/lark_biz_feed_android/BizError;", "lark_biz_feed_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ViewFlowErrorBiz extends ViewFlowError {
    private final d inner;

    public final d getInner() {
        return this.inner;
    }

    public ViewFlowErrorBiz(d r100) {
        Intrinsics.checkNotNullParameter(r100, RNParamRegisterEventHandler.SRC_INNER);
        super(null);
        this.inner = r100;
    }
}
