package com.bytedance.android.shopping.sameproduct.viewholder;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.anchorv3.detail.StaggeredGridDoubleColumnDecoration;
import com.bytedance.android.shopping.sameproduct.viewmodel.SameProductViewModel;
import com.bytedance.android.shopping.sameproduct.widget.SimilarApiErrorView;
import com.bytedance.jedi.ext.adapter.JediSimpleViewHolder;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/sameproduct/viewholder/SimilarApiErrorVH;", "Lcom/bytedance/jedi/ext/adapter/JediSimpleViewHolder;", "Leh3/c;", "Lcom/bytedance/android/shopping/sameproduct/viewholder/a;", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SimilarApiErrorVH extends JediSimpleViewHolder<eh3.c> implements a {
    public final Lazy l;

    public SimilarApiErrorVH(ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r4, "viewGroup");
        super(new SimilarApiErrorView(r4.getContext(), null));
        final KClass r5 = Reflection.getOrCreateKotlinClass(SameProductViewModel.class);
        this.l = LazyKt.lazy(new SimilarApiErrorVH$$special$$inlined$hostViewModel$1(this, r5, r5));
        StaggeredGridDoubleColumnDecoration.a r6 = StaggeredGridDoubleColumnDecoration.g;
        View r0 = ((RecyclerView.ViewHolder) this).itemView;
        r6.getClass();
        StaggeredGridDoubleColumnDecoration.a.b(r0, false);
        ((RecyclerView.ViewHolder) this).itemView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
    }

    public final void a4(Object r4) {
        Intrinsics.checkNotNullParameter((eh3.c) r4, "item");
        View r5 = ((RecyclerView.ViewHolder) this).itemView;
        if ((r5 instanceof SimilarApiErrorView) == true) goto L5;
        r5 = null;
    L5:
        SimilarApiErrorView r6 = (SimilarApiErrorView) r5;
        if (r6 == null) goto L9;
        SameProductViewModel r0 = (SameProductViewModel) this.l.getValue();
        Intrinsics.checkNotNullParameter(r0, "viewModel");
        r6.setVisibility(0);
        r6.a.setOnClickListener(new eh3.d(r6, r0));
        return;
    }
}
