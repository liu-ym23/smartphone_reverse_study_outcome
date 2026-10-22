package com.bytedance.android.shopping.sameproduct.viewholder;

import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.anchorv3.detail.StaggeredGridDoubleColumnDecoration;
import com.bytedance.android.shopping.feed.productcard.doublefeedproductcard.view.DoubleFeedSameProductCardView;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.bytedance.android.shopping.product.flow.view.info.ProductFlowCardTitleView;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/sameproduct/viewholder/DoubleSimilarProductCardVH;", "Lcom/bytedance/android/shopping/sameproduct/viewholder/BaseSimilarProductCardVH;", "Lrd3/a;", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DoubleSimilarProductCardVH extends BaseSimilarProductCardVH<rd3.a> {
    public final void onDestroy() {
        View r0 = ((RecyclerView.ViewHolder) this).itemView;
        if ((r0 instanceof DoubleFeedSameProductCardView) == true) goto L5;
        r0 = null;
    L5:
        DoubleFeedSameProductCardView r1 = (DoubleFeedSameProductCardView) r0;
        if (r1 == null) goto L13;
        ProductFlowCardTitleView r2 = r1.getProductTitle();
        if (r2 == null) goto L14;
        Disposable r3 = r2.c;
        if (r3 == null) goto L15;
        r3.dispose();
        return;
    L15:
        return;
    L14:
        return;
    }

    public final void T3() {
        super/*com.bytedance.jedi.ext.adapter.JediViewHolder*/.T3();
        int r0 = dh3.d.a;
        dh3.d.b(((RecyclerView.ViewHolder) this).itemView.getContext(), d4(), (rd3.a) getItem());
    }

    public final void a4(Object r4) {
        rd3.a r5 = (rd3.a) r4;
        Intrinsics.checkNotNullParameter(r5, "item");
        this.l = r5;
        r5.f = getAdapterPosition() - 1;
        View r0 = ((RecyclerView.ViewHolder) this).itemView;
        View r2 = null;
        if ((r0 instanceof DoubleFeedSameProductCardView) == true) goto L5;
        r0 = null;
    L5:
        DoubleFeedSameProductCardView r1 = (DoubleFeedSameProductCardView) r0;
        if (r1 == null) goto L8;
        r1.setBuyButtonClickListener(this.n);
    L8:
        View r3 = ((RecyclerView.ViewHolder) this).itemView;
        if ((r3 instanceof DoubleFeedSameProductCardView) == true) goto L11;
        r3 = null;
    L11:
        DoubleFeedSameProductCardView r6 = (DoubleFeedSameProductCardView) r3;
        if (r6 == null) goto L14;
        r6.setEnterProductDetailListener(this.o);
    L14:
        View r7 = ((RecyclerView.ViewHolder) this).itemView;
        if ((r7 instanceof DoubleFeedSameProductCardView) == false) goto L18;
        r2 = r7;
    L18:
        DoubleFeedSameProductCardView r8 = (DoubleFeedSameProductCardView) r2;
        if (r8 == null) goto L22;
        r8.a(r5);
        return;
    }

    @Override // com.bytedance.android.shopping.sameproduct.viewholder.BaseSimilarProductCardVH
    public final void c4(View r2) {
        Intrinsics.checkNotNullParameter(r2, FreqActions.ACTION_VIEW);
        e4((rd3.a) getItem());
    }

    @Override // com.bytedance.android.shopping.sameproduct.viewholder.BaseSimilarProductCardVH
    public final void f4(View r2) {
        Intrinsics.checkNotNullParameter(r2, FreqActions.ACTION_VIEW);
        Intrinsics.checkNotNullParameter(r2, FreqActions.ACTION_VIEW);
        int r3 = dh3.d.a;
        dh3.d.a(((RecyclerView.ViewHolder) this).itemView.getContext(), this.l);
    }

    public DoubleSimilarProductCardVH(Fragment r5, ViewGroup r6) {
        Intrinsics.checkNotNullParameter(r5, "fragment");
        Intrinsics.checkNotNullParameter(r6, "viewGroup");
        super(r5, new DoubleFeedSameProductCardView(r6.getContext(), null, 6, 0));
        StaggeredGridDoubleColumnDecoration.a r7 = StaggeredGridDoubleColumnDecoration.g;
        View r8 = ((RecyclerView.ViewHolder) this).itemView;
        r7.getClass();
        StaggeredGridDoubleColumnDecoration.a.b(r8, true);
        this.q.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
    }
}
