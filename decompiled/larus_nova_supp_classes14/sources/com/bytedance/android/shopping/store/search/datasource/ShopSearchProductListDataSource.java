package com.bytedance.android.shopping.store.search.datasource;

import androidx.paging.PositionalDataSource;
import bk3.c;
import bk3.d;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.store.common.param.StoreV2RequestParam;
import com.bytedance.android.ec.store.repository.dto.StoreV2ProductListResponseDTO;
import com.bytedance.android.ec.store.repository.vo.StoreV2ProductListResponseVO;
import com.bytedance.android.ec.store.repository.vo.q;
import com.bytedance.android.ec.store.repository.vo.r;
import com.bytedance.android.ec.store.search.datasource.SearchProductListDataSource;
import com.bytedance.android.ec.store.shopping.paging.ListStatusPositionalLoadInitialCallback;
import com.bytedance.android.ec.store.shopping.paging.ListStatusPositionalLoadRangeCallback;
import com.bytedance.android.ec.store.shopping.paging.LoadStatus;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.store.home.api.ECStoreApi;
import com.bytedance.android.shopping.store.repository.api.StoreSearchV3Api;
import com.bytedance.android.shopping.store.repository.dto.StoreV3SearchResponseExpDTO;
import com.bytedance.android.shopping.store.search.router.ECShopSearchParam;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;
import en.b;
import io.reactivex.Observable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import qm.a;
import s83.g;
import sj3.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/store/search/datasource/ShopSearchProductListDataSource;", "Lcom/bytedance/android/ec/store/search/datasource/SearchProductListDataSource;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShopSearchProductListDataSource extends SearchProductListDataSource {
    public static final /* synthetic */ int p = 0;
    public final Gson n;
    public final StoreV2RequestParam o;

    public final void f(PositionalDataSource.LoadInitialParams r10, ListStatusPositionalLoadInitialCallback<b> r11) {
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r11, "callback");
        if (this.o.getShowCoupon() == true) goto L10;
        Integer r0 = this.o.getCustomIdType();
        if (r0 == null) goto L10;
        if (r0.intValue() != 1) goto L10;
        this.o.setCustomIds(null);
        this.o.setCustomIdType(null);
    L10:
        Map r1 = a.a;
        a.a("ec_perf_duration_shop_search_result", "request_start", System.currentTimeMillis());
        boolean r2 = ECServiceManager.a;
        String r3 = ((g) ECServiceManager.c(g.class)).getCurrentBcmChain();
        if (k.c(r3) == false) goto L13;
        String r8 = r3;
    L14:
        com.bytedance.android.ec.core.async.a.a(m(0L, r10.pageSize, null, r8).subscribe(new c(this, r11), new d(r11)), ((SearchProductListDataSource) this).k);
        return;
    L13:
        r8 = null;
        goto L14
    }

    public final void g(PositionalDataSource.LoadRangeParams r8, ListStatusPositionalLoadRangeCallback<b> r9) {
        Intrinsics.checkNotNullParameter(r8, "params");
        Intrinsics.checkNotNullParameter(r9, "callback");
        if (this.o.getShowCoupon() == true) goto L11;
        Integer r0 = this.o.getCustomIdType();
        if (r0 == null) goto L11;
        if (r0.intValue() != 1) goto L11;
        this.o.setCustomIds(null);
        this.o.setCustomIdType(null);
    L11:
        if (this.o.getHasMore() == false) goto L13;
        com.bytedance.android.ec.core.async.a.a(m(this.o.getCursor(), r8.loadSize, this.o.getSearchId(), null).subscribe(new bk3.a(this, r9, r8), new bk3.b(r9)), ((SearchProductListDataSource) this).k);
        return;
    L13:
        r9.onResult(new ArrayList());
    }

    public final String h(Integer r4, Integer r5) {
        if (r4 == null) goto L19;
        if (r5 != null) goto L7;
        return "";
    L7:
        if (r4.intValue() != 0) goto L10;
        return "general";
    L10:
        if (r4.intValue() != 1) goto L13;
        return "sales";
    L13:
        if (r4.intValue() == 2) goto L15;
        return "";
    L15:
        if (r5.intValue() != 0) goto L17;
        return "price_descend";
    L17:
        return "price_ascend";
    L19:
        return "";
    }

    public final Observable<StoreV2ProductListResponseDTO> l(Long r20, long r21) {
        ECStoreApi.a.getClass();
        ECStoreApi r2 = ECStoreApi.a.a;
        if (r2 == null) goto L13;
        String r3 = this.o.getSecShopId();
        String r4 = this.o.getMaterialId();
        Long r5 = this.o.getGoodsType();
        Long r1 = this.o.getSortType();
        if (r1 != null) goto L8;
    L10:
        Observable<StoreV2ProductListResponseDTO> r6 = r2.getProductListSearchExpByPost(r3, r4, r5, r1, this.o.getSort(), this.o.getKeyWord(), r20, r21, this.o.getTmpId(), this.o.getToken(), this.o.getEntrances(), (String) this.o.getPassThroughParam("pass_through_api"), this.o.getCustomIds(), this.o.getCustomIdType(), this.o.getFilterProductIds());
        if (r6 == null) goto L13;
        return r6;
    L8:
        if (r1.longValue() != 2) goto L10;
        r1 = 3L;
    L13:
        return Observable.error(new Throwable());
    }

    public final Observable<StoreV3SearchResponseExpDTO> m(Long r17, long r18, String r20, String r21) {
        StoreSearchV3Api.a.getClass();
        StoreSearchV3Api r2 = StoreSearchV3Api.a.a;
        if (r2 == null) goto L24;
        if (r17 == null) goto L6;
        long r3 = r17.longValue();
    L7:
        int r5 = this.o.getSize();
        String r6 = this.o.getKeyWord();
        String r8 = this.o.getSecShopId();
        int r1 = f.a;
        String r4 = String.valueOf(this.o.getSortType());
        Integer r7 = this.o.getSort();
        Intrinsics.checkNotNullParameter(r4, "id");
        String r10 = null;
        if (r7 != null) goto L11;
        f r11 = null;
    L18:
        if (r11 == null) goto L21;
        r10 = GsonProtectorUtils.toJson(this.n, r11);
    L21:
        Observable<StoreV3SearchResponseExpDTO> r9 = r2.getSearchV3ProductList(r3, r5, r6, r20, r8, r10, "store_page", this.o.getSearchSource(), 1, "ecom_goods_shop", (String) this.o.getPassThroughParam("pass_through_api"), r21);
        if (r9 == null) goto L24;
        return r9;
    L11:
        if (r7.intValue() != 0) goto L14;
        int r12 = 2;
    L17:
        r11 = new f(new sj3.g(r4, r12));
        goto L18
    L14:
        if (r7.intValue() != 1) goto L16;
        r12 = 1;
        goto L17
    L16:
        r12 = 0;
        goto L17
    L6:
        r3 = 0;
    L24:
        return Observable.error(new Throwable("ECNetworkService not init"));
    }

    public ShopSearchProductListDataSource(StoreV2RequestParam r2, ECShopSearchParam r3, jm.a<List<q>> r4, jm.a<List<r>> r5, QLiveData<LoadStatus> r6, jm.a<String> r7, com.bytedance.android.ec.core.async.b r8, Function1<? super StoreV2ProductListResponseVO, Unit> r9) {
        Intrinsics.checkNotNullParameter(r2, "reqParam");
        Intrinsics.checkNotNullParameter(r3, "searchParam");
        Intrinsics.checkNotNullParameter(r6, "loadStatus");
        Intrinsics.checkNotNullParameter(r8, "disposableScope");
        super(r2, r3, r4, r5, r6, r7, r8, r9);
        this.o = r2;
        this.n = new Gson();
    }
}
