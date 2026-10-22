package com.bytedance.android.shopping.mall.homepage.card.common.feedback;

import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "feedbackData", "Lcom/bytedance/android/shopping/mall/homepage/card/common/feedback/FeedbackData;", "invoke"}, k = 3, mv = {1, 4, 3})
final class NegFeedBackWidget$onReceiveFeedbackGlobalEvent$1 extends Lambda implements Function1<FeedbackData, Unit> {
    final /* synthetic */ BaseViewHolder $this_onReceiveFeedbackGlobalEvent;
    final /* synthetic */ int $triggerBy;

    public NegFeedBackWidget$onReceiveFeedbackGlobalEvent$1(BaseViewHolder r1, int r2) {
        this.$this_onReceiveFeedbackGlobalEvent = r1;
        this.$triggerBy = r2;
        super(1);
    }

    public final void invoke(FeedbackData r3) {
        Intrinsics.checkNotNullParameter(r3, "feedbackData");
        int r0 = this.$triggerBy;
        if (r0 != 1) goto L6;
        d.c(this.$this_onReceiveFeedbackGlobalEvent, r3, "3");
        return;
    L6:
        if (r0 != 2) goto L10;
        d.c(this.$this_onReceiveFeedbackGlobalEvent, r3, "4");
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((FeedbackData) r1);
        return Unit.INSTANCE;
    }
}
