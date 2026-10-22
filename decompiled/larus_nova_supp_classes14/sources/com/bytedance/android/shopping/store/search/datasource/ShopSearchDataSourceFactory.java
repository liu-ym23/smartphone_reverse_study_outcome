package com.bytedance.android.shopping.store.search.datasource;

import androidx.paging.DataSource;
import com.bytedance.android.ec.core.async.b;
import com.bytedance.android.ec.store.common.param.StoreV2RequestParam;
import com.bytedance.android.ec.store.repository.vo.StoreV2ProductListResponseVO;
import com.bytedance.android.ec.store.repository.vo.q;
import com.bytedance.android.ec.store.repository.vo.r;
import com.bytedance.android.ec.store.search.datasource.SearchResultDataSourceFactory;
import com.bytedance.android.ec.store.shopping.paging.LoadStatus;
import com.bytedance.android.shopping.store.search.router.ECShopSearchParam;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;
import java.util.List;
import jm.a;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/store/search/datasource/ShopSearchDataSourceFactory;", "Lcom/bytedance/android/ec/store/search/datasource/SearchResultDataSourceFactory;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShopSearchDataSourceFactory extends SearchResultDataSourceFactory {
    public final QLiveData<ShopSearchProductListDataSource> a;
    public final StoreV2RequestParam b;
    public final ECShopSearchParam c;
    public final a<List<q>> d;
    public final a<List<r>> e;
    public final QLiveData<LoadStatus> f;
    public final a<String> g;
    public final b h;
    public final Function1<StoreV2ProductListResponseVO, Unit> i;

    public final void a() {
        ShopSearchProductListDataSource r0 = (ShopSearchProductListDataSource) this.a.a();
        if (r0 == null) goto L6;
        r0.invalidate();
        return;
    }

    public final DataSource<Integer, en.b> create() {
        ShopSearchProductListDataSource r9 = new ShopSearchProductListDataSource(this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i);
        this.a.e(r9);
        return r9;
    }

    public ShopSearchDataSourceFactory(StoreV2RequestParam r2, ECShopSearchParam r3, a<List<q>> r4, a<List<r>> r5, QLiveData<LoadStatus> r6, a<String> r7, b r8, Function1<? super StoreV2ProductListResponseVO, Unit> r9) {
        Intrinsics.checkNotNullParameter(r2, "reqParam");
        Intrinsics.checkNotNullParameter(r3, "searchParam");
        Intrinsics.checkNotNullParameter(r6, "loadStatus");
        Intrinsics.checkNotNullParameter(r8, "disposableScope");
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
        this.a = new QLiveData();
    }
}
