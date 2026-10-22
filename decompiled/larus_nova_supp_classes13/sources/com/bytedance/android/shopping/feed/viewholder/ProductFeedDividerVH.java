package com.bytedance.android.shopping.feed.viewholder;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.anchorv3.AnchorV3Param;
import com.bytedance.android.shopping.api.anchorv3.ECUIParam;
import com.bytedance.android.shopping.feed.adapter.ProductFeedAdapter;
import com.bytedance.android.shopping.feed.viewmodel.ProductFeedViewModel;
import com.bytedance.android.shopping.feed.widget.ProductFeedDividerView;
import com.bytedance.android.shopping.feed.widget.s;
import com.bytedance.jedi.ext.adapter.JediSimpleViewHolder;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00012\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/feed/viewholder/ProductFeedDividerVH;", "Lcom/bytedance/jedi/ext/adapter/JediSimpleViewHolder;", "Lcom/bytedance/android/shopping/feed/adapter/ProductFeedAdapter$b;", "Lcom/bytedance/android/shopping/feed/widget/s;", "Lcom/bytedance/android/shopping/feed/viewholder/a;", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ProductFeedDividerVH extends JediSimpleViewHolder<ProductFeedAdapter.b<s>> implements a {
    public final Lazy l;
    public boolean m;

    @Override // com.bytedance.android.shopping.feed.viewholder.a
    public final void O(float r1) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a4(Object r4) {
        ProductFeedAdapter.b r5 = (ProductFeedAdapter.b) r4;
        Intrinsics.checkNotNullParameter(r5, "item");
        View r1 = ((RecyclerView.ViewHolder) this).itemView;
        if (r1 == null) goto L34;
        ProductFeedDividerView r2 = (ProductFeedDividerView) r1;
        ProductFeedViewModel r3 = (ProductFeedViewModel) this.l.getValue();
        Intrinsics.checkNotNullParameter(r5, "item");
        Intrinsics.checkNotNullParameter(r3, "viewModel");
        r2.g = r3;
        s r6 = (s) r5.b;
        if (r6 == null) goto L9;
        String r7 = r6.a;
        if (r7 == null) goto L9;
        r2.setCopyWriting(r7);
    L9:
        ProductFeedAdapter r8 = r2.d;
        if (r8 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L12:
        boolean r0 = false;
        if (r8.w == 0) goto L15;
        r2.a(2131378180).setVisibility(0);
    L16:
        r2.b();
        if (this.m == true) goto L35;
        AnchorV3Param r9 = ((ProductFeedViewModel) this.l.getValue()).m907getAnchorV3Param();
        if (r9 == null) goto L23;
        ECUIParam r10 = r9.getUiParam();
        if (r10 == null) goto L23;
        Integer r11 = r10.getShowInternalListStyle();
    L25:
        if (r11 != null) goto L28;
    L29:
        r0 = true;
    L30:
        if (r0 == false) goto L36;
        ((ProductFeedViewModel) this.l.getValue()).isExpandedLiveData().observe(this, new ProductFeedDividerVH$onBind$1(this));
        this.m = true;
        return;
    L36:
        return;
    L28:
        if (r11.intValue() == 0) goto L30;
    L23:
        r11 = null;
        goto L25
    L35:
        return;
    L15:
        r2.a(2131378180).setVisibility(8);
        goto L16
    L34:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.feed.widget.ProductFeedDividerView");
    }

    public ProductFeedDividerVH(ViewGroup r5, ProductFeedAdapter r6) {
        Intrinsics.checkNotNullParameter(r5, "viewGroup");
        Intrinsics.checkNotNullParameter(r6, "adapter");
        ProductFeedDividerView r0 = new ProductFeedDividerView(r5.getContext(), null, 6, 0);
        r0.setAdapter(r6);
        Unit r7 = Unit.INSTANCE;
        super(r0);
        final KClass r8 = Reflection.getOrCreateKotlinClass(ProductFeedViewModel.class);
        this.l = LazyKt.lazy(new ProductFeedDividerVH$$special$$inlined$hostViewModel$1(this, r8, r8));
    }
}
