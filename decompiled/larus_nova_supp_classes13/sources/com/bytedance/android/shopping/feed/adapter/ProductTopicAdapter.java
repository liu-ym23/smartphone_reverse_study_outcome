package com.bytedance.android.shopping.feed.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.utils.y;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.response.anchorv3.TopicItemInfo;
import com.bytedance.android.shopping.anchorv3.AnchorV3Param;
import com.bytedance.android.shopping.feed.event.FeedProductEventTracker;
import com.bytedance.android.shopping.feed.viewholder.ProductTopicItemVH;
import com.bytedance.android.shopping.feed.widget.ProductTopicItemView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/feed/adapter/ProductTopicAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/shopping/feed/viewholder/ProductTopicItemVH;", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ProductTopicAdapter extends RecyclerView.Adapter<ProductTopicItemVH> {
    public final List<TopicItemInfo> a;
    public Set<String> b;
    public final List<String> c;
    public final AnchorV3Param d;

    public final int getItemCount() {
        return ((ArrayList) this.a).size();
    }

    public final void onViewAttachedToWindow(RecyclerView.ViewHolder r4) {
        ProductTopicItemVH r5 = (ProductTopicItemVH) r4;
        Intrinsics.checkNotNullParameter(r5, "holder");
        super.onViewAttachedToWindow(r5);
        if (r5.getAdapterPosition() >= 0) goto L5;
        return;
    L5:
        if (r5.getAdapterPosition() >= ((ArrayList) this.a).size()) goto L16;
        String r0 = ((TopicItemInfo) ListProtector.get(this.a, r5.getAdapterPosition())).getId();
        Set<String> r1 = this.b;
        if (r1 != null) goto L9;
    L10:
        Set<String> r2 = this.b;
        if (r2 == null) goto L13;
        r2.add(r0);
    L13:
        FeedProductEventTracker r3 = FeedProductEventTracker.a;
        Context r6 = ((RecyclerView.ViewHolder) r5).itemView.getContext();
        TopicItemInfo r7 = (TopicItemInfo) ListProtector.get(this.a, r5.getAdapterPosition());
        r3.getClass();
        FeedProductEventTracker.G(r6, "label_show", r7);
        return;
    L9:
        if (r1.contains(r0) != true) goto L10;
        return;
    }

    public ProductTopicAdapter(List<String> r2, AnchorV3Param r3) {
        Intrinsics.checkNotNullParameter(r2, "filterProductIds");
        this.c = r2;
        this.d = r3;
        this.a = new ArrayList();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r9, int r10) {
        ProductTopicItemVH r11 = (ProductTopicItemVH) r9;
        Intrinsics.checkNotNullParameter(r11, "holder");
        List<TopicItemInfo> r0 = this.a;
        List<String> r1 = this.c;
        AnchorV3Param r2 = this.d;
        r11.getClass();
        Intrinsics.checkNotNullParameter(r0, "topicItemList");
        Intrinsics.checkNotNullParameter(r1, "filterProductIds");
        ProductTopicItemView r12 = r11.a;
        TopicItemInfo r4 = (TopicItemInfo) ListProtector.get(r0, r10);
        r12.getClass();
        Intrinsics.checkNotNullParameter(r4, "tagInfo");
        Intrinsics.checkNotNullParameter(r1, "filterProductIds");
        r12.d = r4;
        if (r0 == null) goto L11;
        Iterator r3 = ((ArrayList) r0).iterator();
    L6:
        if (r3.hasNext() == false) goto L11;
        TopicItemInfo r5 = (TopicItemInfo) r3.next();
        if (Intrinsics.areEqual(r5.getId(), r4.getId()) == true) goto L9;
        r5.setSelected("0");
        goto L6
    L9:
        r5.setSelected("1");
    L11:
        r12.f = r0;
        r12.g = r2;
        r12.e = r1;
        ECUrlModel r6 = r4.getIcon();
        if (r6 == null) goto L14;
        y.a(r12.a, r6);
    L14:
        TextView r7 = r12.b;
        String r8 = r4.getName();
        if (r8 != null) goto L18;
        r8 = "";
    L18:
        r7.setText(r8);
        if (r10 >= (((ArrayList) r0).size() - 1)) goto L21;
        Resources r13 = Resources.getSystem();
        r12.setMarginRight(MathKt.roundToInt(TypedValue.applyDimension(1, 8, WindowDisplayMetricsOverride.apply(r13, r13.getDisplayMetrics()))));
        return;
    L21:
        Resources r14 = Resources.getSystem();
        r12.setMarginRight(MathKt.roundToInt(TypedValue.applyDimension(1, 12, WindowDisplayMetricsOverride.apply(r14, r14.getDisplayMetrics()))));
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        return new ProductTopicItemVH(new ProductTopicItemView(r3.getContext(), null));
    }
}
