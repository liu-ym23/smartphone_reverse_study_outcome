package com.bytedance.android.shopping.sameproduct.viewholder;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.anchorv3.detail.StaggeredGridDoubleColumnDecoration;
import com.bytedance.android.shopping.anchorv3.detail.viewholder.AbsFullSpanVH;
import com.bytedance.android.shopping.anchorv3.repository.dto.InnerFlowPageStyleDTO;
import com.bytedance.android.shopping.anchorv3.repository.dto.PageStyle;
import com.bytedance.android.shopping.sameproduct.viewmodel.SameProductViewModel;
import com.bytedance.android.shopping.sameproduct.widget.SameProductTitleView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/sameproduct/viewholder/SameProductTitleVH;", "Lcom/bytedance/android/shopping/anchorv3/detail/viewholder/AbsFullSpanVH;", "Leh3/b;", "Lcom/bytedance/android/shopping/sameproduct/viewholder/a;", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SameProductTitleVH extends AbsFullSpanVH<eh3.b> implements a {
    public final Lazy m;

    public SameProductTitleVH(ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r3, "viewGroup");
        super(new SameProductTitleView(r3.getContext(), null), false);
        final KClass r4 = Reflection.getOrCreateKotlinClass(SameProductViewModel.class);
        this.m = LazyKt.lazy(new SameProductTitleVH$$special$$inlined$hostViewModel$1(this, r4, r4));
        StaggeredGridDoubleColumnDecoration.a r5 = StaggeredGridDoubleColumnDecoration.g;
        View r0 = ((RecyclerView.ViewHolder) this).itemView;
        r5.getClass();
        StaggeredGridDoubleColumnDecoration.a.b(r0, true);
    }

    public final void a4(Object r4) {
        Intrinsics.checkNotNullParameter((eh3.b) r4, "item");
        View r5 = ((RecyclerView.ViewHolder) this).itemView;
        Integer r1 = null;
        if ((r5 instanceof SameProductTitleView) == true) goto L5;
        r5 = null;
    L5:
        SameProductTitleView r6 = (SameProductTitleView) r5;
        if (r6 == null) goto L23;
        InnerFlowPageStyleDTO r0 = ((SameProductViewModel) this.m.getValue()).getInnerFlowPageStyle();
        if (r0 == null) goto L13;
        PageStyle r2 = r0.getPageStyle();
        if (r2 == null) goto L13;
        r1 = r2.getAuthorCommissionSwitch();
    L13:
        if (r1 == null) goto L18;
        boolean r3 = true;
        if (r1.intValue() != 1) goto L18;
    L19:
        if (r3 == false) goto L21;
        r6.a.setVisibility(0);
        r6.b.setVisibility(0);
        return;
    L21:
        r6.a.setVisibility(8);
        r6.b.setVisibility(8);
        return;
    L18:
        r3 = false;
        goto L19
    }
}
