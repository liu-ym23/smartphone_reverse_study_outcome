package com.bytedance.android.shopping.deepfeed.slice.view.list;

import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager;
import com.bytedance.android.ecom.arch.slice.render.widget.yoga.SlcItemView;
import com.bytedance.android.shopping.inflow.cardui.product.header.vh.BannerFooterVH;
import com.bytedance.android.shopping.inflow.common.utils.Contants$InflowType;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0003\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/slice/view/list/DeepFeedSlcListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/shopping/deepfeed/slice/view/list/DeepFeedSlcListVH;", "a", "b", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DeepFeedSlcListAdapter extends RecyclerView.Adapter<DeepFeedSlcListVH> {
    public List<a> a;
    public Map<String, ? extends Object> b;
    public final int c;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;
    public final SlcTemplateContext h;
    public final List<SlcElement> i;

    public static final class a {
        public final int a;
        public final SlcElement b;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof a) == false) goto L10;
            a r4 = (a) r3;
            if (this.a == r4.a) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r4.b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            int r0 = this.a * 31;
            SlcElement r1 = this.b;
            if (r1 == null) goto L5;
            int r2 = r1.hashCode();
        L7:
            return r0 + r2;
        L5:
            r2 = 0;
            goto L7
        }

        public final String toString() {
            return "ListElementData(viewType=" + this.a + ", element=" + this.b + ")";
        }

        public a(int r2, SlcElement r3) {
            Intrinsics.checkNotNullParameter(r3, "element");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class b extends DiffUtil.Callback {
        public final List<a> a;
        public final List<a> b;

        public final boolean areContentsTheSame(int r1, int r2) {
            return false;
        }

        public final int getNewListSize() {
            return this.b.size();
        }

        public final int getOldListSize() {
            return this.a.size();
        }

        public b(List<a> r2, List<a> r3) {
            Intrinsics.checkNotNullParameter(r2, "oldList");
            Intrinsics.checkNotNullParameter(r3, "newList");
            this.a = r2;
            this.b = r3;
        }

        public final boolean areItemsTheSame(int r3, int r4) {
            a r5 = (a) CollectionsKt.getOrNull(this.a, r3);
            if (r5 != null) goto L5;
            return false;
        L5:
            a r6 = (a) CollectionsKt.getOrNull(this.b, r4);
            if (r6 != null) goto L8;
            return false;
        L8:
            Intrinsics.checkNotNullParameter(r5.b, "$this$itemKey");
            Intrinsics.checkNotNullParameter(r6.b, "$this$itemKey");
            return true;
        }
    }

    public final int getItemCount() {
        if (this.a.isEmpty() == false) goto L7;
        return 0;
    L7:
        if (this.e == true) goto L14;
        if (this.d == true) goto L14;
        return this.a.size() + 1;
    L14:
        return this.a.size() + 2;
    }

    public final int getItemViewType(int r4) {
        if (this.f == true) goto L5;
    L6:
        if (r4 == 1) goto L8;
    L10:
        boolean r0 = false;
    L11:
        this.g = r0;
        if (this.f == true) goto L28;
        if (r4 != this.a.size()) goto L20;
        a r5 = (a) CollectionsKt.getOrNull(this.a, 0);
        if (r5 == null) goto L37;
        return r5.a;
    L37:
        return this.c;
    L20:
        if (r4 == (this.a.size() + 1)) goto L38;
        a r6 = (a) CollectionsKt.getOrNull(this.a, r4);
        if (r6 == null) goto L26;
        return r6.a;
    L26:
        return this.c;
    L38:
        return this.c;
    L28:
        if (r4 >= this.a.size()) goto L35;
        a r7 = (a) CollectionsKt.getOrNull(this.a, r4);
        if (r7 == null) goto L33;
        return r7.a;
    L33:
        return this.c;
    L35:
        return this.c;
    L8:
        if (this.d == true) goto L10;
    L9:
        r0 = true;
        goto L11
    L5:
        if (r4 == (getItemCount() - 1)) goto L9;
        goto L6
    }

    public DeepFeedSlcListAdapter(SlcTemplateContext r2, List<SlcElement> r3) {
        Intrinsics.checkNotNullParameter(r2, "templateContext");
        this.h = r2;
        this.i = r3;
        this.a = CollectionsKt.emptyList();
        this.b = MapsKt.emptyMap();
        this.c = 2147482647;
        this.d = true;
        this.e = true;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r3, int r4) {
        DeepFeedSlcListVH r5 = (DeepFeedSlcListVH) r3;
        Intrinsics.checkNotNullParameter(r5, "holder");
        if (r4 < this.a.size()) goto L5;
        return;
    L5:
        if ((r5 instanceof DeepFeedSlcElementVH) == true) goto L7;
        r5 = null;
    L7:
        DeepFeedSlcElementVH r6 = (DeepFeedSlcElementVH) r5;
        a r7 = (a) CollectionsKt.getOrNull(this.a, r4);
        if (r7 == null) goto L25;
        SlcElement r8 = r7.b;
        if (r8 == null) goto L29;
        if (r6 == null) goto L16;
        SlcItemView r0 = r6.a;
        if (r0 == null) goto L16;
        r0.g(this.h, r8);
    L16:
        Map<String, ? extends Object> r1 = this.b;
        Intrinsics.checkNotNullParameter(r8, "$this$dyMergeDataFromConfig");
        Intrinsics.checkNotNullParameter(r1, "dataCtx");
        Map r9 = MapsKt.emptyMap();
        if (r6 == null) goto L26;
        SlcItemView r10 = r6.a;
        if (r10 == null) goto L27;
        BaseSlcViewManager r11 = r10.f;
        if (r11 == null) goto L28;
        r11.x(r9);
        return;
    L28:
        return;
    L27:
        return;
    L26:
        return;
    L29:
        return;
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        if (r3 != this.c) goto L7;
        int r4 = BannerFooterVH.b;
        BannerFooterVH r5 = BannerFooterVH.a.a(r2);
        r5.T3(Contants$InflowType.INFEED_PRODUCT);
        if (this.g == false) goto L9;
        ((RecyclerView.ViewHolder) r5).itemView.setVisibility(8);
        ((RecyclerView.ViewHolder) r5).itemView.getLayoutParams().width = 0;
        this.g = false;
        return r5;
    L9:
        return r5;
    L7:
        SlcItemView r6 = new SlcItemView(r2.getContext(), null);
        r6.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        return new DeepFeedSlcElementVH(r6);
    }
}
