package com.bytedance.android.shopping.feed.viewholder;

import android.view.View;
import android.widget.TextView;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.core.imagex.r;
import com.bytedance.android.shopping.anchorv3.repository.dto.FallbackPage;
import com.bytedance.android.shopping.feed.adapter.ProductFeedAdapter;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.jedi.ext.adapter.JediSimpleViewHolder;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/feed/viewholder/DeletedMainProductCardVH;", "Lcom/bytedance/jedi/ext/adapter/JediSimpleViewHolder;", "Lcom/bytedance/android/shopping/feed/adapter/ProductFeedAdapter$b;", "Lcom/bytedance/android/shopping/anchorv3/repository/dto/FallbackPage;", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DeletedMainProductCardVH extends JediSimpleViewHolder<ProductFeedAdapter.b<FallbackPage>> {
    public final Lazy l;
    public final Lazy m;

    public DeletedMainProductCardVH(View r2) {
        Intrinsics.checkNotNullParameter(r2, FreqActions.ACTION_VIEW);
        super(r2);
        this.l = LazyKt.lazy(new DeletedMainProductCardVH$imageView$2(this));
        this.m = LazyKt.lazy(new DeletedMainProductCardVH$textView$2(this));
    }

    public final void a4(Object r10) {
        ProductFeedAdapter.b r11 = (ProductFeedAdapter.b) r10;
        Intrinsics.checkNotNullParameter(r11, "item");
        FallbackPage r12 = (FallbackPage) r11.b;
        if (r12 == null) goto L7;
        h0.d((ECDraweeView) this.l.getValue(), r12.getIcon(), new r("ec_goods_feed", "ec_goods_feed_default"), null, null, null, null, 120);
        ((TextView) this.m.getValue()).setText(r12.getText());
        return;
    }
}
