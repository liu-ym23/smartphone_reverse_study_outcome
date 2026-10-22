package com.bytedance.android.shopping.searchsimilar.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.utils.y;
import com.bytedance.android.shopping.searchsimilar.model.ProductFrame;
import com.bytedance.android.shopping.searchsimilar.view.SimilarProductFrameView;
import com.bytedance.android.shopping.searchsimilar.view.d;
import com.bytedance.android.shopping.searchsimilar.viewholder.SimilarProductFrameVH;
import com.bytedance.android.shopping.searchsimilar.viewmodel.SimilarProductVM;
import com.bytedance.android.shopping.widget.legacy.SquareImageView;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/searchsimilar/adapter/SimilarProductFrameAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SimilarProductFrameAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public String a;
    public final List<ProductFrame> b;
    public final Set<String> c;
    public int d;
    public int e;
    public final b f;
    public final SimilarProductVM g;

    public static final class a {
    }

    public static final class b implements SimilarProductFrameVH.b {
        public final /* synthetic */ SimilarProductFrameAdapter a;

        public b(SimilarProductFrameAdapter r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.shopping.searchsimilar.viewholder.SimilarProductFrameVH.b
        public final void a(int r3) {
            SimilarProductFrameAdapter r0 = this.a;
            r0.e = r3;
            r0.notifyItemChanged(r0.d, 1);
            SimilarProductFrameAdapter r4 = this.a;
            r4.notifyItemChanged(r4.e, 1);
            SimilarProductFrameAdapter r5 = this.a;
            r5.d = r5.e;
        }
    }

    static {
    }

    public final int getItemCount() {
        return ((ArrayList) this.b).size();
    }

    public SimilarProductFrameAdapter(SimilarProductVM r2) {
        Intrinsics.checkNotNullParameter(r2, "vm");
        this.g = r2;
        this.a = "";
        this.b = new ArrayList();
        this.c = new LinkedHashSet();
        this.f = new b(this);
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r12, int r13) {
        Intrinsics.checkNotNullParameter(r12, "holder");
        if ((r12 instanceof SimilarProductFrameVH) == true) goto L5;
        r12 = null;
    L5:
        SimilarProductFrameVH r14 = (SimilarProductFrameVH) r12;
        if (r14 == null) goto L28;
        ProductFrame r5 = (ProductFrame) CollectionsKt.getOrNull(this.b, r13);
        SimilarProductVM r7 = this.g;
        if (r13 != this.e) goto L10;
        boolean r2 = true;
    L11:
        b r8 = this.f;
        Intrinsics.checkNotNullParameter(r7, "vm");
        Intrinsics.checkNotNullParameter(r8, "selectedChangeListener");
        View r15 = ((RecyclerView.ViewHolder) r14).itemView;
        if ((r15 instanceof SimilarProductFrameView) == true) goto L14;
        r15 = null;
    L14:
        SimilarProductFrameView r16 = (SimilarProductFrameView) r15;
        if (r16 == null) goto L28;
        Intrinsics.checkNotNullParameter(r7, "vm");
        Intrinsics.checkNotNullParameter(r8, "selectedChangeListener");
        r16.f = r5;
        r16.g = Integer.valueOf(r13);
        r16.h = r7;
        SquareImageView r3 = r16.c;
        if (r5 == null) goto L19;
        String r4 = r5.getUrl();
    L20:
        y.e(r3, r4, th.a.f(r16.getContext()).getDimensionPixelOffset(2131165720), th.a.f(r16.getContext()).getDimensionPixelOffset(2131165720), null);
        SquareImageView r6 = r16.d;
        if (r5 == null) goto L23;
        String r9 = r5.getUrl();
    L24:
        y.e(r6, r9, th.a.f(r16.getContext()).getDimensionPixelOffset(2131165721), th.a.f(r16.getContext()).getDimensionPixelOffset(2131165721), null);
        r16.a(r2);
        FrameLayout r1 = r16.a;
        if (r1 == null) goto L28;
        r1.setOnClickListener(new d(r16, r5, r13, r7, r8));
        goto L28
    L23:
        r9 = null;
        goto L24
    L19:
        r4 = null;
        goto L20
    L10:
        r2 = false;
    L28:
        if (this.g.getIsFirstBind() == false) goto L31;
        com.bytedance.android.shopping.monitor.d.f(this.a).h();
        this.g.setIsFirstBind(false);
        return;
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "parent");
        return new SimilarProductFrameVH(new SimilarProductFrameView(r5.getContext(), null, 6, 0), this.c);
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r3, int r4, List<Object> r5) {
        Intrinsics.checkNotNullParameter(r3, "holder");
        Intrinsics.checkNotNullParameter(r5, "payloads");
        boolean r0 = true;
        if (r5.contains(1) == false) goto L20;
        View r1 = null;
        if ((r3 instanceof SimilarProductFrameVH) == true) goto L7;
        r3 = null;
    L7:
        SimilarProductFrameVH r6 = (SimilarProductFrameVH) r3;
        if (r6 != null) goto L10;
        return;
    L10:
        if (r4 == this.e) goto L13;
        r0 = false;
    L13:
        View r7 = ((RecyclerView.ViewHolder) r6).itemView;
        if ((r7 instanceof SimilarProductFrameView) == false) goto L17;
        r1 = r7;
    L17:
        SimilarProductFrameView r2 = (SimilarProductFrameView) r1;
        if (r2 == null) goto L23;
        r2.a(r0);
        return;
    L23:
        return;
    L20:
        onBindViewHolder(r3, r4);
    }
}
