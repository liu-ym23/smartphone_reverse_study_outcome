package com.bytedance.android.window.shop.holder;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.window.shop.holder.presenter.ECWindowHolderBaseFragmentPresenter;
import com.bytedance.android.window.shop.repository.tab.entity.a0;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0003\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/window/shop/holder/WindowProductEmptyWithAnchorNoticeHolder;", "Lcom/bytedance/android/window/shop/holder/ShopWindowGenericHolder;", "Lcom/bytedance/android/window/shop/repository/tab/entity/a0;", "AnchorPresenter", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowProductEmptyWithAnchorNoticeHolder extends ShopWindowGenericHolder<a0> {

    public static final class AnchorPresenter extends ECWindowHolderBaseFragmentPresenter {
        public final Lazy i;

        public AnchorPresenter(Fragment r2) {
            Intrinsics.checkNotNullParameter(r2, "fragment");
            super(r2);
            this.i = LazyKt.lazy(new WindowProductEmptyWithAnchorNoticeHolder$AnchorPresenter$bindOnce$2(this));
        }

        public final void b0(QModel r1) {
            Unit r2 = (Unit) this.i.getValue();
        }
    }

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.window.shop.holder.ShopWindowItemHolder
    public final boolean s4() {
        return true;
    }

    public WindowProductEmptyWithAnchorNoticeHolder(Fragment r5) {
        Intrinsics.checkNotNullParameter(r5, "fragment");
        ShoppingAsyncInflater.a r0 = ShoppingAsyncInflater.e;
        Context r1 = r5.requireContext();
        r0.getClass();
        super(r5, com.bytedance.android.ec.opt.asyncInflate.c.a(ShoppingAsyncInflater.a.a(r1), 2131560909, null, 4));
    }

    @Override // com.bytedance.android.window.shop.holder.ShopWindowGenericHolder
    public final QIPresenter u4(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        return new AnchorPresenter(r2);
    }
}
