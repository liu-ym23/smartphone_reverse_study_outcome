package com.bytedance.android.shopping.store.aggregate.datasource;

import androidx.paging.PositionalDataSource;
import com.bytedance.android.ec.store.api.StoreV2Api;
import com.bytedance.android.ec.store.common.param.StoreV2RequestParam;
import com.bytedance.android.ec.store.monitor.ErrorCode;
import com.bytedance.android.ec.store.monitor.ErrorDomain;
import com.bytedance.android.ec.store.repository.dto.StoreV2ProductListResponseDTO;
import com.bytedance.android.ec.store.repository.vo.StoreV2ProductItemVO;
import com.bytedance.android.ec.store.repository.vo.StoreV2ProductListResponseVO;
import com.bytedance.android.ec.store.repository.vo.p;
import com.bytedance.android.ec.store.repository.vo.q;
import com.bytedance.android.ec.store.repository.vo.r;
import com.bytedance.android.ec.store.shopping.paging.ListStatusPositionalDataSource;
import com.bytedance.android.ec.store.shopping.paging.ListStatusPositionalLoadInitialCallback;
import com.bytedance.android.ec.store.shopping.paging.ListStatusPositionalLoadRangeCallback;
import com.bytedance.android.ec.store.shopping.paging.LoadStatus;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/store/aggregate/datasource/ShopAggregatePageProductListDataSource;", "Lcom/bytedance/android/ec/store/shopping/paging/ListStatusPositionalDataSource;", "Lcom/bytedance/android/ec/store/repository/vo/StoreV2ProductItemVO;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShopAggregatePageProductListDataSource extends ListStatusPositionalDataSource<StoreV2ProductItemVO> {
    public final StoreV2RequestParam b;
    public final StoreV2ProductListResponseVO c;
    public final jm.a<List<q>> d;
    public final jm.a<List<r>> e;
    public final jm.a<String> f;
    public final com.bytedance.android.ec.core.async.b g;
    public final Function1<StoreV2ProductListResponseVO, Unit> h;
    public final jm.a<p> i;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ ShopAggregatePageProductListDataSource a;
        public final /* synthetic */ ListStatusPositionalLoadInitialCallback b;

        public a(ShopAggregatePageProductListDataSource r1, ListStatusPositionalLoadInitialCallback r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            StoreV2ProductListResponseDTO r5 = (StoreV2ProductListResponseDTO) r4;
            if (r5.getStatusCode() == 0) goto L5;
            ListStatusPositionalLoadInitialCallback r0 = this.b;
            ErrorDomain.NET.getCode();
            r5.getStatusCode();
            r5.getStatusMsg();
            r0.a();
            return;
        L5:
            StoreV2ProductListResponseVO.Companion.getClass();
            StoreV2ProductListResponseVO r6 = StoreV2ProductListResponseVO.a.a(r5, false);
            this.a.b.setCursor(Long.valueOf(r6.getCursor()));
            this.a.h(r6, this.b);
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ ListStatusPositionalLoadInitialCallback a;

        public b(ListStatusPositionalLoadInitialCallback r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            ListStatusPositionalLoadInitialCallback r0 = this.a;
            ErrorDomain.NATIVE.getCode();
            ErrorCode.NATIVE_COMMON.getCode();
            ((Throwable) r3).getMessage();
            r0.a();
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ ShopAggregatePageProductListDataSource a;
        public final /* synthetic */ ListStatusPositionalLoadRangeCallback b;

        public c(ShopAggregatePageProductListDataSource r1, ListStatusPositionalLoadRangeCallback r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            StoreV2ProductListResponseDTO r5 = (StoreV2ProductListResponseDTO) r4;
            if (r5.getStatusCode() == 0) goto L5;
            this.b.a();
            return;
        L5:
            StoreV2ProductListResponseVO.Companion.getClass();
            StoreV2ProductListResponseVO r6 = StoreV2ProductListResponseVO.a.a(r5, false);
            Function1<StoreV2ProductListResponseVO, Unit> r0 = this.a.h;
            if (r0 == null) goto L8;
            Unit r1 = (Unit) r0.invoke(r6);
        L8:
            ArrayList r2 = new ArrayList();
            r2.addAll(r6.getProducts());
            this.b.onResult(r2);
            this.a.b.setHasMore(r6.getHasMore());
            this.a.b.setCursor(Long.valueOf(r6.getCursor()));
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ ListStatusPositionalLoadRangeCallback a;

        public d(ListStatusPositionalLoadRangeCallback r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
            this.a.a();
        }
    }

    public final void f(PositionalDataSource.LoadInitialParams r21, ListStatusPositionalLoadInitialCallback<StoreV2ProductItemVO> r22) {
        Intrinsics.checkNotNullParameter(r21, "params");
        Intrinsics.checkNotNullParameter(r22, "callback");
        StoreV2ProductListResponseVO r3 = this.c;
        if (r3 != null) goto L5;
    L10:
        StoreV2Api.a.getClass();
        StoreV2Api r4 = StoreV2Api.a.a;
        if (r4 == null) goto L14;
        Observable r1 = r4.getProductList(this.b.getSecAuthorId(), this.b.getMaterialId(), this.b.getGoodsType(), this.b.getSortType(), this.b.getKeyWord(), 0L, r21.pageSize, this.b.getTmpId(), this.b.getToken(), Boolean.valueOf(this.b.isCustom()), "product_list", (String) this.b.getPassThroughParam("pass_through_api"), this.b.getCustomIds(), this.b.getCustomIdType());
        if (r1 == null) goto L14;
    L15:
        Disposable r2 = r1.subscribe(new a(this, r22), new b(r22));
        if (r2 == null) goto L20;
        com.bytedance.android.ec.core.async.a.a(r2, this.g);
        return;
    L20:
        return;
    L14:
        r1 = Observable.error(new Throwable());
        goto L15
    L5:
        if (this.b.getFirstInit() == true) goto L8;
        r3 = null;
    L8:
        if (r3 == null) goto L10;
        this.b.setFirstInit(false);
        h(this.c, r22);
    }

    public final void g(PositionalDataSource.LoadRangeParams r21, ListStatusPositionalLoadRangeCallback<StoreV2ProductItemVO> r22) {
        Intrinsics.checkNotNullParameter(r21, "params");
        Intrinsics.checkNotNullParameter(r22, "callback");
        if (this.b.getHasMore() == false) goto L12;
        StoreV2Api.a.getClass();
        StoreV2Api r4 = StoreV2Api.a.a;
        if (r4 == null) goto L8;
        Observable r1 = r4.getProductList(this.b.getSecAuthorId(), this.b.getMaterialId(), this.b.getGoodsType(), this.b.getSortType(), this.b.getKeyWord(), this.b.getCursor(), r21.loadSize, this.b.getTmpId(), this.b.getToken(), Boolean.valueOf(this.b.isCustom()), "product_list", (String) this.b.getPassThroughParam("pass_through_api"), this.b.getCustomIds(), this.b.getCustomIdType());
        if (r1 == null) goto L8;
    L9:
        Disposable r2 = r1.subscribe(new c(this, r22), new d(r22));
        if (r2 == null) goto L14;
        com.bytedance.android.ec.core.async.a.a(r2, this.g);
        return;
    L14:
        return;
    L8:
        r1 = Observable.error(new Throwable());
        goto L9
    L12:
        r22.onResult(new ArrayList());
    }

    public final void h(StoreV2ProductListResponseVO r8, ListStatusPositionalLoadInitialCallback<StoreV2ProductItemVO> r9) {
        Function1<StoreV2ProductListResponseVO, Unit> r0 = this.h;
        if (r0 == null) goto L5;
        Unit r1 = (Unit) r0.invoke(r8);
    L5:
        r9.onResult(com.bytedance.android.shopping.store.aggregate.datasource.a.a(r8, this.d, this.e, this.f, this.i, false), 0);
        this.b.setHasMore(r8.getHasMore());
        StoreV2RequestParam r10 = this.b;
        List r2 = r8.getGoodTypes();
        Object r3 = null;
        if (r2 == null) goto L17;
        Iterator r4 = r2.iterator();
    L9:
        if (r4.hasNext() == false) goto L13;
        Object r5 = r4.next();
        if (((q) r5).b == false) goto L9;
    L14:
        q r6 = (q) r5;
        if (r6 == null) goto L17;
        Long r7 = Long.valueOf(r6.a);
    L18:
        r10.setGoodsType(r7);
        StoreV2RequestParam r11 = this.b;
        List r12 = r8.getSortTypes();
        if (r12 == null) goto L29;
        Iterator r13 = r12.iterator();
    L22:
        if (r13.hasNext() == false) goto L26;
        Object r14 = r13.next();
        if (((r) r14).c == false) goto L22;
        r3 = r14;
    L26:
        r r15 = (r) r3;
        if (r15 == null) goto L29;
        long r16 = r15.a;
    L30:
        r11.setSortType(Long.valueOf(r16));
        return;
    L29:
        r16 = 0;
        goto L30
    L13:
        r5 = null;
    L17:
        r7 = null;
        goto L18
    }

    public ShopAggregatePageProductListDataSource(StoreV2RequestParam r2, StoreV2ProductListResponseVO r3, jm.a<List<q>> r4, jm.a<List<r>> r5, QLiveData<LoadStatus> r6, jm.a<String> r7, com.bytedance.android.ec.core.async.b r8, Function1<? super StoreV2ProductListResponseVO, Unit> r9, jm.a<p> r10) {
        Intrinsics.checkNotNullParameter(r2, "reqParam");
        Intrinsics.checkNotNullParameter(r6, "loadStatus");
        Intrinsics.checkNotNullParameter(r8, "disposableScope");
        super(r6);
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
    }
}
