package com.bytedance.android.window.shop.widget.category;

import android.content.res.Resources;
import com.bytedance.android.shopping.yata.business.function.ScrollPosition;
import com.bytedance.android.window.shop.repository.tab.entity.WindowProductCategoryVODeprecated;
import com.bytedance.android.window.shop.repository.tab.entity.x;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\t\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/bytedance/android/window/shop/repository/tab/entity/WindowProductCategoryVODeprecated$a;", "<anonymous parameter 0>", "", "currentIndex", "width", ScrollPosition.POSITION_LEFT, "", "invoke", "(Lcom/bytedance/android/window/shop/repository/tab/entity/WindowProductCategoryVODeprecated$a;III)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class CategoryScrollView$bindData$1 extends Lambda implements Function4<WindowProductCategoryVODeprecated.a, Integer, Integer, Integer, Unit> {
    final /* synthetic */ x $vo;
    final /* synthetic */ CategoryScrollView this$0;

    public CategoryScrollView$bindData$1(CategoryScrollView r1, x r2) {
        this.this$0 = r1;
        this.$vo = r2;
        super(4);
    }

    public final void invoke(WindowProductCategoryVODeprecated.a r2, int r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "<anonymous parameter 0>");
        this.$vo.j = r3;
        CategoryScrollView r6 = this.this$0;
        int r7 = CategoryScrollView.d;
        Resources r8 = r6.getResources();
        r6.smoothScrollTo(r5 - ((WindowDisplayMetricsOverride.apply(r8, r8.getDisplayMetrics()).widthPixels - r4) / 2), 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3, Object r4) {
        invoke((WindowProductCategoryVODeprecated.a) r1, ((Number) r2).intValue(), ((Number) r3).intValue(), ((Number) r4).intValue());
        return Unit.INSTANCE;
    }
}
