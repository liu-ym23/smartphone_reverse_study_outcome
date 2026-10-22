package com.bytedance.android.shopping.store.aggregate.datasource;

import androidx.paging.DataSource;
import com.bytedance.android.ec.core.async.b;
import com.bytedance.android.ec.store.common.param.StoreV2RequestParam;
import com.bytedance.android.ec.store.datasource.StoreDataSourceFactory;
import com.bytedance.android.ec.store.repository.vo.StoreV2ProductItemVO;
import com.bytedance.android.ec.store.repository.vo.StoreV2ProductListResponseVO;
import com.bytedance.android.ec.store.repository.vo.p;
import com.bytedance.android.ec.store.repository.vo.q;
import com.bytedance.android.ec.store.repository.vo.r;
import com.bytedance.android.ec.store.shopping.paging.ListStatusPositionalDataSource;
import com.bytedance.android.ec.store.shopping.paging.LoadStatus;
import com.bytedance.android.shopping.store.aggregate.AggregatePageTypes;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/store/aggregate/datasource/StoreAggregatePageDataSourceFactory;", "Lcom/bytedance/android/ec/store/datasource/StoreDataSourceFactory;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class StoreAggregatePageDataSourceFactory extends StoreDataSourceFactory {
    public final QLiveData<ListStatusPositionalDataSource<StoreV2ProductItemVO>> a;
    public final StoreV2RequestParam b;
    public final StoreV2ProductListResponseVO c;
    public final jm.a<List<q>> d;
    public final jm.a<List<r>> e;
    public final QLiveData<LoadStatus> f;
    public final jm.a<String> g;
    public final jm.a<p> h;
    public final String i;
    public final b j;
    public final Function1<StoreV2ProductListResponseVO, Unit> k;

    public final void a() {
        dm.a.a("StoreAggregatePageProductListDataSource").a("invalidate:" + hashCode());
        this.j.clearDisposable();
        ListStatusPositionalDataSource r0 = (ListStatusPositionalDataSource) this.a.a();
        if (r0 == null) goto L6;
        r0.invalidate();
        return;
    }

    public final DataSource<Integer, StoreV2ProductItemVO> create() {
        boolean r1 = Intrinsics.areEqual(this.i, AggregatePageTypes.FOLLOW_COUPON.getType());
        if (r1 != true) goto L5;
        DataSource<Integer, StoreV2ProductItemVO> r2 = new ShopAggregatePageProductListDataSource(this.b, this.c, this.d, this.e, this.f, this.g, this.j, this.k, this.h);
    L7:
        this.a.e(r2);
        return r2;
    L5:
        if (r1 == true) goto L10;
        r2 = new StoreAggregatePageProductListDataSource(this.b, this.c, this.d, this.e, this.f, this.g, Intrinsics.areEqual(this.i, AggregatePageTypes.CLASSIFICATION.getType()), this.j, this.k, this.h);
        goto L7
    L10:
        throw new NoWhenBranchMatchedException();
    }

    public StoreAggregatePageDataSourceFactory(StoreV2RequestParam r2, StoreV2ProductListResponseVO r3, jm.a r4, jm.a r5, QLiveData r6, jm.a r7, String r8, b r9, Function1 r10) {
        Intrinsics.checkNotNullParameter(r2, "reqParam");
        Intrinsics.checkNotNullParameter(r6, "loadStatus");
        Intrinsics.checkNotNullParameter(r9, "disposableScope");
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = null;
        this.h = r7;
        this.i = r8;
        this.j = r9;
        this.k = r10;
        this.a = new QLiveData();
    }
}
