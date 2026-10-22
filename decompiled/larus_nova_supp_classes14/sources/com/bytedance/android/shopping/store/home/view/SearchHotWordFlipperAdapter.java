package com.bytedance.android.shopping.store.home.view;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.shopping.store.repository.vo.SearchSuggestWord;
import com.bytedance.android.ui.base.widget.viewflipper.ECViewFlipper;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/store/home/view/SearchHotWordFlipperAdapter;", "Lcom/bytedance/android/ui/base/widget/viewflipper/ECViewFlipper$ECViewFlipperAdapter;", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SearchHotWordFlipperAdapter extends ECViewFlipper.ECViewFlipperAdapter {
    public List<SearchSuggestWord> a;

    @Override // com.bytedance.android.ui.base.widget.viewflipper.ECViewFlipper.ECViewFlipperAdapter
    public final int getFlipperItemCount() {
        return this.a.size();
    }

    public SearchHotWordFlipperAdapter() {
        this.a = CollectionsKt.emptyList();
    }

    public final SearchSuggestWord y2(int r2) {
        return (SearchSuggestWord) CollectionsKt.getOrNull(this.a, r2);
    }

    @Override // com.bytedance.android.ui.base.widget.viewflipper.ECViewFlipper.ECViewFlipperAdapter
    public final void onBindViewFlipperHolder(ECViewFlipper.ECViewFlipperHolder r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "holder");
        SearchSuggestWord r12 = (SearchSuggestWord) CollectionsKt.getOrNull(this.a, r11);
        if (r12 != null) goto L5;
        return;
    L5:
        View r13 = ((RecyclerView.ViewHolder) r10).itemView;
        if (r13 == null) goto L12;
        HotWordFlipperItemView r14 = (HotWordFlipperItemView) r13;
        Intrinsics.checkNotNullParameter(r12, "suggestWord");
        r14.a.setText(r12.getWord());
        if (r12.getIcon() == null) goto L13;
        h0.d(r14.b, r12.getIcon(), null, null, null, null, null, 120);
        return;
    L13:
        return;
    L12:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.store.home.view.HotWordFlipperItemView");
    }

    @Override // com.bytedance.android.ui.base.widget.viewflipper.ECViewFlipper.ECViewFlipperAdapter
    public final ECViewFlipper.ECViewFlipperHolder onCreateViewFlipperHolder(ViewGroup r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "parent");
        return new ECViewFlipper.ECViewFlipperHolder(new HotWordFlipperItemView(r1.getContext()));
    }
}
