package com.bytedance.android.shopping.sameproduct.viewholder;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.anchorv3.detail.StaggeredGridDoubleColumnDecoration;
import com.bytedance.android.shopping.sameproduct.widget.NoMoreSameProductView;
import com.bytedance.jedi.ext.adapter.JediSimpleViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/sameproduct/viewholder/NoMoreSimilarProductDataVH;", "Lcom/bytedance/jedi/ext/adapter/JediSimpleViewHolder;", "Leh3/a;", "Lcom/bytedance/android/shopping/sameproduct/viewholder/a;", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class NoMoreSimilarProductDataVH extends JediSimpleViewHolder<eh3.a> implements a {
    public NoMoreSimilarProductDataVH(ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r4, "viewGroup");
        super(new NoMoreSameProductView(r4.getContext(), null));
        StaggeredGridDoubleColumnDecoration.a r5 = StaggeredGridDoubleColumnDecoration.g;
        View r0 = ((RecyclerView.ViewHolder) this).itemView;
        r5.getClass();
        StaggeredGridDoubleColumnDecoration.a.b(r0, false);
        ((RecyclerView.ViewHolder) this).itemView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
    }

    public final void a4(Object r2) {
        Intrinsics.checkNotNullParameter((eh3.a) r2, "item");
    }
}
