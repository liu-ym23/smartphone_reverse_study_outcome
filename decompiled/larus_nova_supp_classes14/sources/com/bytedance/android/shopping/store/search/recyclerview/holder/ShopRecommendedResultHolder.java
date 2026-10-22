package com.bytedance.android.shopping.store.search.recyclerview.holder;

import android.view.View;
import ck3.e;
import com.bytedance.android.ec.store.search.recyclerview.vo.SearchResultItemType;
import com.ss.android.ugc.aweme.kiwi.ui.QUIManager;
import en.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/store/search/recyclerview/holder/ShopRecommendedResultHolder;", "Lcom/bytedance/android/shopping/store/search/recyclerview/holder/ShopBaseSearchResultViewHolder;", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShopRecommendedResultHolder extends ShopBaseSearchResultViewHolder {
    public static final /* synthetic */ int d = 0;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.shopping.store.search.recyclerview.holder.ShopBaseSearchResultViewHolder
    public final void T3(b r3) {
        Intrinsics.checkNotNullParameter(r3, "vo");
        QUIManager r0 = this.a;
        if (r0 == null) goto L6;
        r0.c(e.class, ((en.a) r3).b);
        return;
    }

    public ShopRecommendedResultHolder(QUIManager r2, View r3, SearchResultItemType r4) {
        Intrinsics.checkNotNullParameter(r2, "uiManager");
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter(r4, "type");
        super(r2, r3, r4);
    }
}
