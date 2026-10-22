package com.bytedance.android.window.shop.holder;

import android.graphics.Rect;
import androidx.fragment.app.Fragment;
import com.bytedance.android.window.shop.holder.presenter.WindowNoticeBannerItemPresenter;
import com.bytedance.android.window.shop.repository.tab.entity.k0;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/window/shop/holder/WindowProductNoticeBannerHolder;", "Lcom/bytedance/android/window/shop/holder/ShopWindowGenericHolder;", "Lcom/bytedance/android/window/shop/repository/tab/entity/k0;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowProductNoticeBannerHolder extends ShopWindowGenericHolder<k0> {
    @Override // com.bytedance.android.window.shop.holder.ShopWindowItemHolder
    public final boolean s4() {
        return true;
    }

    public WindowProductNoticeBannerHolder(Fragment r6) {
        Intrinsics.checkNotNullParameter(r6, "fragment");
        bp.a r0 = new bp.a(r6.requireContext());
        r0.setPadding(r0.getPaddingLeft(), d.a(16), r0.getPaddingRight(), d.a(12));
        Unit r1 = Unit.INSTANCE;
        super(r6, r0);
    }

    @Override // com.bytedance.android.window.shop.holder.ShopWindowItemHolder
    public final Rect r4(int r2) {
        return new Rect(0, 0, 0, 0);
    }

    @Override // com.bytedance.android.window.shop.holder.ShopWindowGenericHolder
    public final QIPresenter u4(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        return new WindowNoticeBannerItemPresenter(r2);
    }
}
