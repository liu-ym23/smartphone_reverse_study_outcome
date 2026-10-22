package com.bytedance.android.shopping.deepfeed.slice.view.viewpage;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager;
import com.bytedance.android.ecom.arch.slice.render.elements.viewpager.SlcViewPager2ItemData;
import com.bytedance.android.ecom.arch.slice.render.widget.yoga.SlcItemView;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/slice/view/viewpage/DeepFeedViewPageAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/shopping/deepfeed/slice/view/viewpage/DeepFeedViewPageAdapter$DeepFeedViewPageViewHolder;", "DeepFeedViewPageViewHolder", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DeepFeedViewPageAdapter extends RecyclerView.Adapter<DeepFeedViewPageViewHolder> {
    public List<SlcViewPager2ItemData> a;
    public final SlcTemplateContext b;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/slice/view/viewpage/DeepFeedViewPageAdapter$DeepFeedViewPageViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class DeepFeedViewPageViewHolder extends RecyclerView.ViewHolder {
        public Object a;
        public final SlcItemView b;

        public DeepFeedViewPageViewHolder(SlcItemView r2) {
            Intrinsics.checkNotNullParameter(r2, "slcItemView");
            super(r2);
            this.b = r2;
        }
    }

    public final int getItemCount() {
        if (this.a.isEmpty() == false) goto L5;
        return 0;
    L5:
        return Integer.MAX_VALUE;
    }

    public DeepFeedViewPageAdapter(SlcTemplateContext r2) {
        Intrinsics.checkNotNullParameter(r2, "templateContext");
        this.b = r2;
        this.a = CollectionsKt.emptyList();
    }

    public final int getItemViewType(int r2) {
        int r0 = this.a.size();
        if (r0 != 0) goto L5;
        Integer r3 = null;
    L6:
        if (r3 == null) goto L10;
        int r4 = r3.intValue();
        SlcViewPager2ItemData r5 = (SlcViewPager2ItemData) CollectionsKt.getOrNull(this.a, r4);
        if (r5 == null) goto L10;
        return r5.a;
    L10:
        return -1;
    L5:
        r3 = Integer.valueOf((r2 + r0) % r0);
        goto L6
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r4, int r5) {
        DeepFeedViewPageViewHolder r6 = (DeepFeedViewPageViewHolder) r4;
        Intrinsics.checkNotNullParameter(r6, "holder");
        int r0 = this.a.size();
        if (r0 != 0) goto L5;
        Integer r7 = null;
    L6:
        if (r7 == null) goto L17;
        int r8 = r7.intValue();
        SlcViewPager2ItemData r9 = (SlcViewPager2ItemData) CollectionsKt.getOrNull(this.a, r8);
        if (r9 == null) goto L19;
        SlcElement r1 = r9.d;
        if (r6.a == r1) goto L13;
        r6.b.g(this.b, r1);
        r6.a = r1;
    L13:
        SlcItemView r10 = r6.b;
        Lazy r11 = r9.b;
        KProperty r2 = SlcViewPager2ItemData.f[0];
        Map r12 = (Map) r11.getValue();
        BaseSlcViewManager r13 = r10.f;
        if (r13 == null) goto L18;
        r13.x(r12);
        return;
    L18:
        return;
    L19:
        return;
    L17:
        return;
    L5:
        r7 = Integer.valueOf((r5 + r0) % r0);
        goto L6
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        SlcItemView r4 = new SlcItemView(r2.getContext(), null);
        r4.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
        Unit r5 = Unit.INSTANCE;
        return new DeepFeedViewPageViewHolder(r4);
    }
}
