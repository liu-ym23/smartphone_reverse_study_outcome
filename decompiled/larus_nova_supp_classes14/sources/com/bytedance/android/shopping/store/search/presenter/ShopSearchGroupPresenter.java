package com.bytedance.android.shopping.store.search.presenter;

import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.shopping.store.home.presenter.ShopSearchBasePresenter;
import com.bytedance.android.shopping.store.settings.ECShopABSettings;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/store/search/presenter/ShopSearchGroupPresenter;", "Lcom/bytedance/android/shopping/store/home/presenter/ShopSearchBasePresenter;", "Landroidx/lifecycle/LifecycleObserver;", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShopSearchGroupPresenter extends ShopSearchBasePresenter {
    public ShopSearchGroupPresenter() {
    }

    public final void A(QModel r5) {
        ECQuickUtilKt.a(u()).getLifecycle().addObserver(this);
        LinearLayout r6 = (LinearLayout) w().b(2131385538).f();
        if (ECShopABSettings.getEC_SHOP_SEARCH_GUIDE_STYLE() == 0) goto L5;
        qc3.a.i(r6, 20.0f, 20.0f);
    L5:
        RecyclerView r0 = w().b(2131385603).f();
        E().getSearchContent().b(ECQuickUtilKt.a(u()), new a(this, r6, r0));
    }
}
