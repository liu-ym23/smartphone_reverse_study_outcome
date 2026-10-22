package com.bytedance.android.shopping.store.search.recyclerview.holder;

import android.widget.TextView;
import com.bytedance.android.ec.store.search.recyclerview.vo.SearchResultFooterNoticeVO;
import com.bytedance.android.ec.store.search.recyclerview.vo.SearchResultItemType;
import en.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/store/search/recyclerview/holder/ShopSearchResultFooterViewHolder;", "Lcom/bytedance/android/shopping/store/search/recyclerview/holder/ShopBaseSearchResultViewHolder;", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShopSearchResultFooterViewHolder extends ShopBaseSearchResultViewHolder {
    public static final /* synthetic */ int e = 0;
    public final TextView d;

    public static final class a {
    }

    static {
    }

    public ShopSearchResultFooterViewHolder(TextView r3) {
        Intrinsics.checkNotNullParameter(r3, "footerView");
        super(null, r3, SearchResultItemType.FOOTER_VIEW);
        this.d = r3;
    }

    @Override // com.bytedance.android.shopping.store.search.recyclerview.holder.ShopBaseSearchResultViewHolder
    public final void T3(b r2) {
        Intrinsics.checkNotNullParameter(r2, "vo");
        this.d.setText(((SearchResultFooterNoticeVO) r2).b.getDescription());
    }
}
