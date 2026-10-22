package com.bytedance.android.shopping.store.shopfeed.list;

import androidx.paging.DataSource;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListStyleDTO;
import com.bytedance.android.ec.store.shopping.paging.LoadStatus;
import com.bytedance.android.shopping.store.shopfeed.ShopFeedParam;
import com.bytedance.android.shopping.store.shopfeed.f;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/store/shopfeed/list/ShopFeedDataSourceFactory;", "Landroidx/paging/DataSource$Factory;", "", "Lcom/bytedance/android/shopping/store/shopfeed/list/a;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShopFeedDataSourceFactory extends DataSource.Factory<Integer, a> {
    public final jm.a<ShopFeedLynxCardDataSource> a;
    public final ShopFeedParam b;
    public final f c;
    public final QLiveData<LoadStatus> d;
    public final QLiveData<fk3.a> e;
    public final jm.a<ECHybridListStyleDTO> f;
    public final com.bytedance.android.shopping.store.slicecard.b g;
    public final com.bytedance.android.ec.core.async.b h;

    public final DataSource<Integer, a> create() {
        ShopFeedLynxCardDataSource r8 = new ShopFeedLynxCardDataSource(this.b, this.c, this.h, this.d, this.e, this.f, this.g);
        this.a.c(r8);
        return r8;
    }

    public ShopFeedDataSourceFactory(ShopFeedParam r2, f r3, QLiveData<LoadStatus> r4, QLiveData<fk3.a> r5, jm.a<ECHybridListStyleDTO> r6, com.bytedance.android.shopping.store.slicecard.b r7, com.bytedance.android.ec.core.async.b r8) {
        Intrinsics.checkNotNullParameter(r3, "reqParam");
        Intrinsics.checkNotNullParameter(r4, "loadStatus");
        Intrinsics.checkNotNullParameter(r5, "topInfo");
        Intrinsics.checkNotNullParameter(r6, "listStyle");
        Intrinsics.checkNotNullParameter(r7, "sliceService");
        Intrinsics.checkNotNullParameter(r8, "disposableScope");
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.a = new jm.a(7);
    }
}
