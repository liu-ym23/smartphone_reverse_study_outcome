package com.bytedance.android.shopping.deepfeed.weights;

import com.bytedance.android.shopping.api.mall.common.tools.b0;
import com.bytedance.android.shopping.deepfeed.ui.view.DeepFeedTypewriterTextView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class DeepFeedAiContainerView$loadingInUnder$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ com.bytedance.android.shopping.deepfeed.action.i $parentAbility;
    final /* synthetic */ String $text;
    final /* synthetic */ DeepFeedAiContainerView this$0;

    public DeepFeedAiContainerView$loadingInUnder$1(DeepFeedAiContainerView r1, String r2, com.bytedance.android.shopping.deepfeed.action.i r3) {
        this.this$0 = r1;
        this.$text = r2;
        this.$parentAbility = r3;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m834invoke() {
        b0.n(this.this$0.f);
        b0.n(this.this$0.e);
        DeepFeedAiContainerView r0 = this.this$0;
        DeepFeedTypewriterTextView.y(r0.e, r0.a, this.$text, r0.b, new AnonymousClass1(this));
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m834invoke();
        return Unit.INSTANCE;
    }
}
