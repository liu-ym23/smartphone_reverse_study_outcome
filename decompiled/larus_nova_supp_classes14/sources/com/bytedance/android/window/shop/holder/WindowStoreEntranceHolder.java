package com.bytedance.android.window.shop.holder;

import android.view.LayoutInflater;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.window.shop.holder.presenter.WindowProductStoreEntryPresenter;
import com.bytedance.android.window.shop.repository.tab.entity.h0;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/window/shop/holder/WindowStoreEntranceHolder;", "Lcom/bytedance/android/window/shop/holder/ShopWindowGenericHolder;", "Lcom/bytedance/android/window/shop/repository/tab/entity/h0;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowStoreEntranceHolder extends ShopWindowGenericHolder<h0> {
    @Override // com.bytedance.android.window.shop.holder.ShopWindowItemHolder
    public final boolean s4() {
        return true;
    }

    public WindowStoreEntranceHolder(Fragment r5) {
        Intrinsics.checkNotNullParameter(r5, "fragment");
        View r0 = LayoutInflater.from(r5.requireContext()).inflate(2131560876, null);
        r0.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        Unit r1 = Unit.INSTANCE;
        super(r5, r0);
    }

    @Override // com.bytedance.android.window.shop.holder.ShopWindowGenericHolder
    public final QIPresenter u4(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        return new WindowProductStoreEntryPresenter();
    }
}
