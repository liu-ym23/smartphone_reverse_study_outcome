package com.bytedance.android.shopping.searchsimilar.adapter;

import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.jedi.LoadMoreRecyclerViewAdapter;
import com.bytedance.android.shopping.monitor.d;
import com.bytedance.android.shopping.searchsimilar.view.SimilarProductCardView;
import com.bytedance.android.shopping.searchsimilar.view.SimilarProductFeedbackView;
import com.bytedance.android.shopping.searchsimilar.viewholder.SimilarProductCardVH;
import com.bytedance.android.shopping.searchsimilar.viewmodel.SimilarProductVM;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/searchsimilar/adapter/SimilarProductCardAdapter;", "Lcom/bytedance/android/shopping/jedi/LoadMoreRecyclerViewAdapter;", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SimilarProductCardAdapter extends LoadMoreRecyclerViewAdapter {
    public String u;
    public final List<rd3.a> v;
    public final Set<String> w;
    public final SimilarProductVM x;
    public final RecyclerView y;

    public static final class a {
    }

    static {
    }

    public final int getBasicItemCount() {
        return ((ArrayList) this.v).size();
    }

    public SimilarProductCardAdapter(SimilarProductVM r2, RecyclerView r3) {
        Intrinsics.checkNotNullParameter(r2, "vm");
        this.x = r2;
        this.y = r3;
        this.u = "";
        this.v = new ArrayList();
        this.w = new LinkedHashSet();
    }

    public final void onBindBasicViewHolder(RecyclerView.ViewHolder r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "holder");
        View r1 = null;
        if ((r10 instanceof SimilarProductCardVH) == true) goto L5;
        r10 = null;
    L5:
        SimilarProductCardVH r12 = (SimilarProductCardVH) r10;
        if (r12 == null) goto L15;
        rd3.a r3 = (rd3.a) CollectionsKt.getOrNull(this.v, r11);
        SimilarProductVM r4 = this.x;
        Integer r5 = Integer.valueOf(r11);
        Intrinsics.checkNotNullParameter(r4, "vm");
        View r13 = ((RecyclerView.ViewHolder) r12).itemView;
        if ((r13 instanceof SimilarProductCardView) == false) goto L11;
        r1 = r13;
    L11:
        SimilarProductCardView r2 = (SimilarProductCardView) r1;
        if (r2 == null) goto L15;
        r2.a(r3, r4, r5, r12.b, r12.c, r12.a);
    L15:
        if (this.x.getIsFirstBind() == false) goto L18;
        d.f(this.u).h();
        this.x.setIsFirstBind(false);
        return;
    }

    public final RecyclerView.ViewHolder onCreateBasicViewHolder(ViewGroup r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "parent");
        AttributeSet r3 = null;
        return new SimilarProductCardVH(new SimilarProductCardView(r5.getContext(), r3, 6, 0), this.y, this, this.w);
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r2, int r3, List<Object> r4) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        Intrinsics.checkNotNullParameter(r4, "payloads");
        if (r4.contains(1) == false) goto L18;
        View r5 = null;
        if ((r2 instanceof SimilarProductCardVH) == true) goto L7;
        r2 = null;
    L7:
        SimilarProductCardVH r6 = (SimilarProductCardVH) r2;
        if (r6 == null) goto L20;
        View r7 = ((RecyclerView.ViewHolder) r6).itemView;
        if ((r7 instanceof SimilarProductCardView) == false) goto L13;
        r5 = r7;
    L13:
        SimilarProductCardView r8 = (SimilarProductCardView) r5;
        if (r8 == null) goto L21;
        SimilarProductFeedbackView r9 = r8.h;
        if (r9 == null) goto L22;
        r9.b(false, r8);
        return;
    L22:
        return;
    L21:
        return;
    L20:
        return;
    L18:
        onBindViewHolder(r2, r3);
    }
}
