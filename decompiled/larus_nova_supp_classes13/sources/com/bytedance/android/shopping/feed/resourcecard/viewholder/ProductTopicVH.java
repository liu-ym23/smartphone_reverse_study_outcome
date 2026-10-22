package com.bytedance.android.shopping.feed.resourcecard.viewholder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.model.response.anchorv3.TopicItemInfo;
import com.bytedance.android.shopping.anchorv3.AnchorV3Param;
import com.bytedance.android.shopping.feed.adapter.ProductFeedAdapter;
import com.bytedance.android.shopping.feed.adapter.ProductTopicAdapter;
import com.bytedance.android.shopping.feed.event.FeedProductEventTracker;
import com.bytedance.android.shopping.feed.event.g;
import com.bytedance.android.shopping.feed.event.q1;
import com.bytedance.android.shopping.feed.viewmodel.ProductFeedViewModel;
import com.bytedance.android.shopping.feed.widget.ProductTopicInfoView;
import com.bytedance.jedi.ext.adapter.JediSimpleViewHolder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import rd3.a;
import yd3.h;
import yd3.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/feed/resourcecard/viewholder/ProductTopicVH;", "Lcom/bytedance/jedi/ext/adapter/JediSimpleViewHolder;", "Lcom/bytedance/android/shopping/feed/adapter/ProductFeedAdapter$b;", "Lrd3/a;", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ProductTopicVH extends JediSimpleViewHolder<ProductFeedAdapter.b<a>> {
    public final Lazy l;
    public final ViewGroup m;
    public final Set<String> n;

    /* JADX WARN: Multi-variable type inference failed */
    public final void T3() {
        super/*com.bytedance.jedi.ext.adapter.JediViewHolder*/.T3();
        ArrayList r0 = new ArrayList();
        a r1 = (a) ((ProductFeedAdapter.b) getItem()).b;
        if (r1 == null) goto L14;
        p r2 = r1.i();
        if (r2 == null) goto L14;
        h r3 = r2.i();
        if (r3 == null) goto L14;
        List<TopicItemInfo> r4 = r3.c();
        if (r4 == null) goto L14;
        Iterator<T> r5 = r4.iterator();
    L12:
        if (r5.hasNext() == false) goto L14;
        TopicItemInfo r6 = (TopicItemInfo) r5.next();
        r0.add(r6.getId() + ":" + r6.getName());
    L14:
        StringBuilder r7 = new StringBuilder();
        Iterator r8 = r0.iterator();
        int r9 = 0;
    L16:
        if (r8.hasNext() == false) goto L29;
        Object r10 = r8.next();
        int r11 = r9 + 1;
        if (r9 >= 0) goto L20;
        CollectionsKt.throwIndexOverflow();
    L20:
        String r12 = (String) r10;
        if (r9 != 0) goto L23;
        r7.append("{");
    L23:
        r7.append(r12);
        if (r9 != (r0.size() - 1)) goto L26;
        r7.append("}");
    L27:
        r9 = r11;
        goto L16
    L26:
        r7.append(",");
        goto L27
    L29:
        if (this.n.contains(r7.toString()) == true) goto L36;
        this.n.add(r7.toString());
        FeedProductEventTracker r13 = FeedProductEventTracker.a;
        Context r14 = this.m.getContext();
        String r15 = r7.toString();
        r13.getClass();
        Intrinsics.checkNotNullParameter(r15, "lableGroupName");
        q1 r16 = new q1();
        r16.a = r15;
        g.c(r16, r14, null);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a4(Object r8) {
        ProductFeedAdapter.b r9 = (ProductFeedAdapter.b) r8;
        Intrinsics.checkNotNullParameter(r9, "item");
        a r10 = (a) r9.b;
        if (r10 == null) goto L18;
        p r11 = r10.i();
        if (r11 == null) goto L19;
        h r12 = r11.i();
        if (r12 == null) goto L20;
        List<TopicItemInfo> r13 = r12.c();
        if (r13 == null) goto L21;
        View r0 = ((RecyclerView.ViewHolder) this).itemView;
        if (r0 == null) goto L17;
        ProductTopicInfoView r1 = (ProductTopicInfoView) r0;
        ArrayList<String> r2 = ((ProductFeedViewModel) this.l.getValue()).getInnerGuessULikeFiltersHelper().b;
        Set<String> r3 = this.n;
        AnchorV3Param r4 = ((ProductFeedViewModel) this.l.getValue()).m907getAnchorV3Param();
        Intrinsics.checkNotNullParameter(r2, "filterProductIds");
        Intrinsics.checkNotNullParameter(r3, "watchList");
        List<TopicItemInfo> r14 = r13;
        if ((!r14.isEmpty()) != true) goto L15;
        r1.setVisibility(0);
        ProductTopicAdapter r5 = new ProductTopicAdapter(r2, r4);
        Intrinsics.checkNotNullParameter(r3, "watchList");
        r5.b = r3;
        ((ArrayList) r5.a).addAll(r14);
        r5.notifyDataSetChanged();
        r1.a.setAdapter(r5);
        return;
    L15:
        r1.setVisibility(8);
        return;
    L17:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.feed.widget.ProductTopicInfoView");
    L21:
        return;
    L20:
        return;
    L19:
        return;
    }

    public ProductTopicVH(ViewGroup r4, Set<String> r5) {
        Intrinsics.checkNotNullParameter(r4, "viewGroup");
        Intrinsics.checkNotNullParameter(r5, "watchList");
        super(new ProductTopicInfoView(r4.getContext(), null));
        this.m = r4;
        this.n = r5;
        final KClass r6 = Reflection.getOrCreateKotlinClass(ProductFeedViewModel.class);
        this.l = LazyKt.lazy(new ProductTopicVH$$special$$inlined$hostViewModel$1(this, r6, r6));
    }
}
