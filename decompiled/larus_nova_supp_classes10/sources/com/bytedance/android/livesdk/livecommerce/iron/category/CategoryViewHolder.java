package com.bytedance.android.livesdk.livecommerce.iron.category;

import androidx.recyclerview.widget.RecyclerView;
import cl.d;
import com.bytedance.android.ec.sdk.helper.k;
import com.bytedance.android.livesdk.livecommerce.iron.widgets.TopCategoryView;
import com.bytedance.android.livesdk.livecommerce.network.response.PromotionCategory;
import com.bytedance.android.livesdk.livecommerce.skin.f;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/iron/category/CategoryViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CategoryViewHolder extends RecyclerView.ViewHolder {
    public final TopCategoryView a;

    public CategoryViewHolder(TopCategoryView r2) {
        Intrinsics.checkNotNullParameter(r2, "categoryView");
        super(r2);
        this.a = r2;
    }

    public final void T3(final PromotionCategory r10, final int r11, final String r12, final f r13, final Function0<Unit> r14) {
        Intrinsics.checkNotNullParameter(r10, "category");
        Intrinsics.checkNotNullParameter(r14, "clickListener");
        TopCategoryView r1 = this.a;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r10, "category");
        d r0 = k.a();
        if (r0 == null) goto L5;
        r0.c(r1);
    L5:
        r1.f = r12;
        r1.g = r13;
        r1.h = r10;
        r1.a.setText(r10.getName());
        r1.setContentDescription(r10.getName() + th.a.g(r1.getContext(), 2131896355));
        r1.d(r11);
        r1.b(r10.getSelected());
        if (r10.getSelected() == false) goto L8;
        r1.c(true, true, false);
    L8:
        com.bytedance.android.ec.core.widget.f.c(r1, null, null, new CategoryViewHolder$bindData$$inlined$apply$lambda$1(r10, r11, r12, r13, r14), 3);
    }
}
