package com.bytedance.android.shopping.sameproduct.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bytedance.android.ec.core.utils.g1;
import com.bytedance.android.ec.core.utils.y;
import com.bytedance.android.ec.innerflow.jedi.JediBaseMultiTypeAdapter;
import com.bytedance.android.ec.innerflow.jedi.JediBaseRawAdapter;
import com.bytedance.android.ec.innerflow.jedi.LoadMoreRecyclerViewAdapter;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.inflowfeed.Promotion;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductBaseStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.jedi.arch.IReceiver;
import com.bytedance.jedi.arch.ext.list.DiffableAdapter;
import com.bytedance.jedi.ext.adapter.JediViewHolder;
import com.bytedance.jedi.ext.adapter.multitype.ViewHolderFactoryManager;
import com.bytedance.jedi.ext.adapter.multitype.c;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/sameproduct/adapter/SameProductListAdapter;", "Lcom/bytedance/android/ec/innerflow/jedi/JediBaseMultiTypeAdapter;", "", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SameProductListAdapter extends JediBaseMultiTypeAdapter<Object> {
    public final Fragment u;
    public final int v;

    public final void A2(c<JediViewHolder<? extends IReceiver, ?>> r4) {
        Intrinsics.checkNotNullParameter(r4, "registry");
        ViewHolderFactoryManager r5 = (ViewHolderFactoryManager) r4;
        c.a.a(r5, new SameProductListAdapter$registerFactories$1(this), new SameProductListAdapter$registerFactories$2(this), 2);
        c.a.a(r5, new SameProductListAdapter$registerFactories$3(this), SameProductListAdapter$registerFactories$4.INSTANCE, 2);
        c.a.a(r5, new SameProductListAdapter$registerFactories$5(this), new SameProductListAdapter$registerFactories$6(this), 2);
        c.a.a(r5, new SameProductListAdapter$registerFactories$7(this), new SameProductListAdapter$registerFactories$8(this), 2);
        c.a.a(r5, new SameProductListAdapter$registerFactories$9(this), SameProductListAdapter$registerFactories$10.INSTANCE, 2);
        c.a.a(r5, new SameProductListAdapter$registerFactories$11(this), SameProductListAdapter$registerFactories$12.INSTANCE, 2);
    }

    public final int getBasicItemViewType(int r2) {
        return ((JediBaseRawAdapter) this).s.b(r2);
    }

    public final void onViewAttachedToWindow(RecyclerView.ViewHolder r3) {
        Intrinsics.checkNotNullParameter(r3, "holder");
        super/*com.bytedance.android.ec.innerflow.jedi.LoadMoreRecyclerViewAdapter*/.onViewAttachedToWindow(r3);
        if (this.v == 2) goto L5;
        return;
    L5:
        if ((r3 instanceof com.bytedance.android.shopping.sameproduct.viewholder.a) == false) goto L14;
        ViewGroup.LayoutParams r4 = r3.itemView.getLayoutParams();
        if ((r4 instanceof StaggeredGridLayoutManager.LayoutParams) == true) goto L9;
        r4 = null;
    L9:
        StaggeredGridLayoutManager.LayoutParams r5 = (StaggeredGridLayoutManager.LayoutParams) r4;
        if (r5 == null) goto L15;
        r5.setFullSpan(true);
        return;
    L15:
        return;
    }

    public SameProductListAdapter(Fragment r4, RecyclerView r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "fragment");
        Intrinsics.checkNotNullParameter(r5, "recyclerView");
        super(r4, new SameProductDiffer());
        this.u = r4;
        this.v = r6;
        Context r7 = r5.getContext();
        setShowFooter(true);
        Resources r0 = Resources.getSystem();
        int r8 = MathKt.roundToInt(TypedValue.applyDimension(1, 12, WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics())));
        Resources r1 = Resources.getSystem();
        int r9 = MathKt.roundToInt(TypedValue.applyDimension(1, 16, WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics())));
        ((LoadMoreRecyclerViewAdapter) this).i = 0;
        ((LoadMoreRecyclerViewAdapter) this).k = r8;
        ((LoadMoreRecyclerViewAdapter) this).j = 0;
        ((LoadMoreRecyclerViewAdapter) this).h = r9;
        Integer r10 = 14;
        ((LoadMoreRecyclerViewAdapter) this).l = r10;
        TextView r11 = ((LoadMoreRecyclerViewAdapter) this).f;
        if (r11 == null) goto L5;
        Intrinsics.checkNotNull(r10);
        r11.setTextSize(r10.intValue());
    L5:
        int r12 = g1.a;
        ((LoadMoreRecyclerViewAdapter) this).d = g1.a.a(r7, 2131100048);
        ((LoadMoreRecyclerViewAdapter) this).c = g1.a.a(r7, 2131100048);
        String r13 = g1.a.c(r7, 2131913981, new Object[0]);
        TextView r14 = ((LoadMoreRecyclerViewAdapter) this).f;
        if (r14 == null) goto L8;
        r14.setText(r13);
    L8:
        ((LoadMoreRecyclerViewAdapter) this).e = r13;
        resetLoadMoreState();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r4, int r5, List<Object> r6) {
        Intrinsics.checkNotNullParameter(r4, "holder");
        Intrinsics.checkNotNullParameter(r6, "payloads");
        super/*com.bytedance.android.ec.innerflow.jedi.MultiTypeAdapter*/.onBindViewHolder(r4, r5, r6);
        int r7 = 0;
    L4:
        if (r7 > 1) goto L24;
        Object r2 = null;
        Object r0 = DiffableAdapter.DefaultImpls.getItem$default(this, r5 + r7, false, 2, null);
        if ((r0 instanceof rd3.a) == false) goto L9;
        r2 = r0;
    L9:
        rd3.a r3 = (rd3.a) r2;
        if (r3 == null) goto L23;
        Promotion r1 = r3.f();
        if (r1 == null) goto L23;
        PromotionProductStruct r8 = r1.getPromotionInfo();
        if (r8 == null) goto L23;
        PromotionProductBaseStruct r9 = r8.getBaseInfo();
        if (r9 == null) goto L23;
        List r10 = r9.getImages();
        if (r10 == null) goto L23;
        ECUrlModel r11 = (ECUrlModel) CollectionsKt.firstOrNull(r10);
        if (r11 == null) goto L23;
        y.n(r11, new a());
    L23:
        r7 = r7 + 1;
        goto L4
    }
}
