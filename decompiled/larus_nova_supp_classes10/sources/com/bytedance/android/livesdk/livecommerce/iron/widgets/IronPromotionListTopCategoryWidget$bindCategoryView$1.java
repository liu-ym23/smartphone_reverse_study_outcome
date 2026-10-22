package com.bytedance.android.livesdk.livecommerce.iron.widgets;

import com.bytedance.android.livesdk.livecommerce.network.response.PromotionCategory;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "view", "Lcom/bytedance/android/livesdk/livecommerce/iron/widgets/TopCategoryView;", "category", "Lcom/bytedance/android/livesdk/livecommerce/network/response/PromotionCategory;", "invoke"}, k = 3, mv = {1, 4, 3})
final class IronPromotionListTopCategoryWidget$bindCategoryView$1 extends Lambda implements Function2<TopCategoryView, PromotionCategory, Unit> {
    final /* synthetic */ IronPromotionListTopCategoryWidget this$0;

    public IronPromotionListTopCategoryWidget$bindCategoryView$1(IronPromotionListTopCategoryWidget r1) {
        this.this$0 = r1;
        super(2);
    }

    public final void invoke(TopCategoryView r2, PromotionCategory r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "category");
        if ((!Intrinsics.areEqual(r2, this.this$0.c)) == false) goto L12;
        TopCategoryView r4 = this.this$0.c;
        if (r4 == null) goto L7;
        r4.b(false);
    L7:
        IronPromotionListTopCategoryWidget r5 = this.this$0;
        if (r5.c == null) goto L10;
        r5.getClass();
    L10:
        this.this$0.c = r2;
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((TopCategoryView) r1, (PromotionCategory) r2);
        return Unit.INSTANCE;
    }
}
