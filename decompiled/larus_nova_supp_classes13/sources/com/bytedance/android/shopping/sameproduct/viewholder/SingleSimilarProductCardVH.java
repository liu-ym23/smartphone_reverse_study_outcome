package com.bytedance.android.shopping.sameproduct.viewholder;

import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.anchorv3.detail.StaggeredGridDoubleColumnDecoration;
import com.bytedance.android.shopping.feed.widget.FlowTinyProductView;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/sameproduct/viewholder/SingleSimilarProductCardVH;", "Lcom/bytedance/android/shopping/sameproduct/viewholder/BaseSimilarProductCardVH;", "Lrd3/a;", "Lcom/bytedance/android/shopping/sameproduct/viewholder/a;", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SingleSimilarProductCardVH extends BaseSimilarProductCardVH<rd3.a> implements a {
    public final void onDestroy() {
        View r0 = ((RecyclerView.ViewHolder) this).itemView;
        if ((r0 instanceof FlowTinyProductView) == true) goto L5;
        r0 = null;
    L5:
        FlowTinyProductView r1 = (FlowTinyProductView) r0;
        if (r1 == null) goto L11;
        Disposable r2 = r1.c.c;
        if (r2 == null) goto L12;
        r2.dispose();
        return;
    L12:
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
        if ((r0 instanceof FlowTinyProductView) == true) goto L5;
        r0 = null;
    L5:
        FlowTinyProductView r1 = (FlowTinyProductView) r0;
        if (r1 == null) goto L8;
        r1.b(r5);
    L8:
        View r3 = ((RecyclerView.ViewHolder) this).itemView;
        if ((r3 instanceof FlowTinyProductView) == true) goto L11;
        r3 = null;
    L11:
        FlowTinyProductView r6 = (FlowTinyProductView) r3;
        if (r6 == null) goto L16;
        AppCompatButton r7 = r6.getBuyButton();
        if (r7 == null) goto L16;
        r7.setOnClickListener(new d(this, r5));
    L16:
        View r8 = ((RecyclerView.ViewHolder) this).itemView;
        if ((r8 instanceof FlowTinyProductView) == false) goto L20;
        r2 = r8;
    L20:
        FlowTinyProductView r9 = (FlowTinyProductView) r2;
        if (r9 == null) goto L24;
        r9.setOnClickListener(new e(this));
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

    public SingleSimilarProductCardVH(Fragment r5, ViewGroup r6) {
        Intrinsics.checkNotNullParameter(r5, "fragment");
        Intrinsics.checkNotNullParameter(r6, "viewGroup");
        View r3 = null;
        super(r5, new FlowTinyProductView(r6.getContext(), null, 6, 0));
        View r7 = ((RecyclerView.ViewHolder) this).itemView;
        if ((r7 instanceof FlowTinyProductView) == false) goto L6;
        r3 = r7;
    L6:
        FlowTinyProductView r4 = (FlowTinyProductView) r3;
        if (r4 == null) goto L9;
        r4.setStyle(3);
    L9:
        StaggeredGridDoubleColumnDecoration.a r8 = StaggeredGridDoubleColumnDecoration.g;
        View r9 = ((RecyclerView.ViewHolder) this).itemView;
        r8.getClass();
        StaggeredGridDoubleColumnDecoration.a.b(r9, true);
        this.q.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
    }
}
