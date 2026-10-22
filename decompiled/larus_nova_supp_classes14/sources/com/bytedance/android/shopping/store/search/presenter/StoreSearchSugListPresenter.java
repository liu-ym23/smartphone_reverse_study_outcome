package com.bytedance.android.shopping.store.search.presenter;

import android.os.SystemClock;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.store.search.recyclerview.searchsug.adapter.SearchSugListAdapter;
import com.bytedance.android.shopping.store.home.presenter.ShopSearchBasePresenter;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/store/search/presenter/StoreSearchSugListPresenter;", "Lcom/bytedance/android/shopping/store/home/presenter/ShopSearchBasePresenter;", "Landroidx/lifecycle/LifecycleObserver;", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class StoreSearchSugListPresenter extends ShopSearchBasePresenter {
    public RecyclerView f;
    public SearchSugListAdapter g;
    public long h;

    public StoreSearchSugListPresenter() {
        this.h = SystemClock.elapsedRealtime();
    }

    public final void A(QModel r5) {
        this.f = w().b(2131385603).f();
        this.g = new SearchSugListAdapter(E(), u());
        RecyclerView r6 = this.f;
        if (r6 == null) goto L5;
        r6.setLayoutManager(new LinearLayoutManager(u().c(), 1, false));
        r6.setAdapter(this.g);
        r6.addOnScrollListener(new StoreSearchSugListPresenter$initRecyclerView$$inlined$apply$lambda$1(this));
    L5:
        ECQuickUtilKt.a(u()).getLifecycle().addObserver(this);
        E().getSearchContent().b(ECQuickUtilKt.a(u()), new k0(this));
        E().getStoreSearchHistories().b(ECQuickUtilKt.a(u()), new l0(this));
        E().getSugListResponseData().b(ECQuickUtilKt.a(u()), new m0(this));
    }
}
