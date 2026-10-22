package com.bytedance.android.shopping.store.search.recyclerview.holder;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.ugc.aweme.kiwi.ui.QUIManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/store/search/recyclerview/holder/ShopSearchProductFooterHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShopSearchProductFooterHolder extends RecyclerView.ViewHolder {
    public static final /* synthetic */ int b = 0;
    public final QUIManager a;

    public static final class a {
    }

    static {
    }

    public ShopSearchProductFooterHolder(QUIManager r2, View r3) {
        Intrinsics.checkNotNullParameter(r2, "uiManager");
        Intrinsics.checkNotNullParameter(r3, "itemView");
        super(r3);
        this.a = r2;
        setIsRecyclable(true);
    }
}
