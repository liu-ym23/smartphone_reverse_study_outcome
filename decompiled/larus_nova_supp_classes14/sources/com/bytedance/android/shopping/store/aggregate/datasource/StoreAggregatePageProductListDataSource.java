package com.bytedance.android.shopping.store.aggregate.datasource;

import androidx.paging.PositionalDataSource;
import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.ec.core.utils.w0;
import com.bytedance.android.ec.store.common.param.StoreV2RequestParam;
import com.bytedance.android.ec.store.monitor.ErrorCode;
import com.bytedance.android.ec.store.monitor.ErrorDomain;
import com.bytedance.android.ec.store.repository.dto.StoreV2CartsInfoDTO;
import com.bytedance.android.ec.store.repository.dto.StoreV2ProductListResponseDTO;
import com.bytedance.android.ec.store.repository.dto.k;
import com.bytedance.android.ec.store.repository.dto.l;
import com.bytedance.android.ec.store.repository.dto.m;
import com.bytedance.android.ec.store.repository.vo.StoreV2ProductItemVO;
import com.bytedance.android.ec.store.repository.vo.StoreV2ProductListResponseVO;
import com.bytedance.android.ec.store.repository.vo.n;
import com.bytedance.android.ec.store.repository.vo.p;
import com.bytedance.android.ec.store.repository.vo.q;
import com.bytedance.android.ec.store.repository.vo.r;
import com.bytedance.android.ec.store.shopping.paging.ListStatusPositionalDataSource;
import com.bytedance.android.ec.store.shopping.paging.ListStatusPositionalLoadInitialCallback;
import com.bytedance.android.ec.store.shopping.paging.ListStatusPositionalLoadRangeCallback;
import com.bytedance.android.ec.store.shopping.paging.LoadStatus;
import com.bytedance.android.shopping.store.home.api.ECStoreApi;
import com.bytedance.android.shopping.store.home.entity.ECStoreProductListConfig;
import com.bytedance.android.shopping.store.settings.ECShopABSettings;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/store/aggregate/datasource/StoreAggregatePageProductListDataSource;", "Lcom/bytedance/android/ec/store/shopping/paging/ListStatusPositionalDataSource;", "Lcom/bytedance/android/ec/store/repository/vo/StoreV2ProductItemVO;", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class StoreAggregatePageProductListDataSource extends ListStatusPositionalDataSource<StoreV2ProductItemVO> {
    public boolean b;
    public String c;
    public boolean d;
    public final StoreV2RequestParam e;
    public final StoreV2ProductListResponseVO f;
    public final jm.a<List<q>> g;
    public final jm.a<List<r>> h;
    public final jm.a<String> i;
    public final boolean j;
    public final com.bytedance.android.ec.core.async.b k;
    public final Function1<StoreV2ProductListResponseVO, Unit> l;
    public final jm.a<p> m;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ StoreAggregatePageProductListDataSource a;
        public final /* synthetic */ ListStatusPositionalLoadInitialCallback b;

        public b(StoreAggregatePageProductListDataSource r1, ListStatusPositionalLoadInitialCallback r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r7) {
            StoreV2ProductListResponseDTO r8 = (StoreV2ProductListResponseDTO) r7;
            if (r8.getStatusCode() == 0) goto L6;
            ListStatusPositionalLoadInitialCallback r0 = this.b;
            ErrorDomain.NET.getCode();
            r8.getStatusCode();
            r8.getStatusMsg();
            r0.a();
            return;
        L6:
            if (this.a.j == false) goto L8;
            Map r1 = qm.a.a;
            qm.a.a("ec_perf_duration_shop_classification", "request_end", System.currentTimeMillis());
        L10:
            if (this.a.j == false) goto L12;
            StoreV2ProductListResponseVO r9 = StoreV2ProductListResponseVO.a.b(StoreV2ProductListResponseVO.Companion, r8);
        L13:
            this.a.e.setCursor(Long.valueOf(r9.getCursor()));
            this.a.h(r9, this.b);
            if (this.a.j == false) goto L19;
            if (r9.getHasMore() == true) goto L19;
            ((ListStatusPositionalDataSource) this.a).a.e(LoadStatus.LoadMoreIn);
        L19:
            if (this.a.j == false) goto L21;
            qm.a.a("ec_perf_duration_shop_classification", "render_start", System.currentTimeMillis());
            return;
        L21:
            qm.a.a("ec_perf_duration_live_store", "render_start", System.currentTimeMillis());
            return;
        L12:
            StoreV2ProductListResponseVO.Companion.getClass();
            r9 = StoreV2ProductListResponseVO.a.a(r8, false);
            goto L13
        L8:
            Map r2 = qm.a.a;
            qm.a.a("ec_perf_duration_live_store", "request_end", System.currentTimeMillis());
            goto L10
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ ListStatusPositionalLoadInitialCallback a;

        public c(ListStatusPositionalLoadInitialCallback r1) {
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

    public static final class d<T> implements Consumer {
        public final /* synthetic */ StoreAggregatePageProductListDataSource a;
        public final /* synthetic */ ListStatusPositionalLoadRangeCallback b;

        public d(StoreAggregatePageProductListDataSource r1, ListStatusPositionalLoadRangeCallback r2) {
            this.a = r1;
            this.b = r2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r8v13, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r8v14, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r8v15, types: [java.util.ArrayList] */
        /* JADX WARN: Type inference failed for: r8v4, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r8v5, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r8v6, types: [java.util.ArrayList] */
        public final void accept(Object r19) {
            StoreV2ProductListResponseDTO r1 = (StoreV2ProductListResponseDTO) r19;
            if (r1.getStatusCode() == 0) goto L5;
            this.b.a();
            return;
        L5:
            StoreAggregatePageProductListDataSource r2 = this.a;
            if (r2.b == false) goto L72;
            p r3 = null;
            if (r2.j == false) goto L42;
            int r4 = com.bytedance.android.shopping.store.aggregate.c.a;
            Intrinsics.checkNotNullParameter(r1, "dto");
            StoreV2ProductListResponseVO r5 = new StoreV2ProductListResponseVO();
            List r7 = r1.getGoodTypes();
            if (r7 == null) goto L15;
            List r8 = r7;
            ArrayList r9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
            Iterator<T> r10 = r8.iterator();
        L13:
            if (r10.hasNext() == false) goto L16;
            k r11 = (k) r10.next();
            int r12 = q.c;
            r9.add(q.a.a(r11));
        L16:
            r5.setGoodTypes(r9);
            List r13 = r1.getSortTypes();
            if (r13 == null) goto L22;
            List r14 = r13;
            ArrayList r15 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10));
            Iterator<T> r16 = r14.iterator();
        L20:
            if (r16.hasNext() == false) goto L23;
            m r17 = (m) r16.next();
            int r18 = r.t;
            r15.add(r.a.a(r17));
        L23:
            r5.setSortTypes(r15);
            List r20 = r1.getProducts();
            if (r20 == null) goto L33;
            List r21 = r20;
            ?? r22 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r21, 10));
            Iterator<T> r6 = r21.iterator();
        L27:
            if (r6.hasNext() == false) goto L34;
            l r23 = (l) r6.next();
            int r24 = pj3.c.R;
            Intrinsics.checkNotNullParameter(r23, "dto");
            StoreV2ProductItemVO.a r25 = StoreV2ProductItemVO.Q;
            pj3.c r110 = new pj3.c();
            r25.getClass();
            StoreV2ProductItemVO.a.c(r23, r110);
            l.c r26 = r23.k();
            if (r26 == null) goto L31;
            String r27 = r26.a();
        L32:
            ((StoreV2ProductItemVO) r110).I = StoreV2ProductItemVO.a.a(r27);
            r22.add(r110);
            goto L27
        L31:
            r27 = null;
        L34:
            r5.setProducts(r22);
            r5.setCursor(r1.getCursor());
            r5.setHasMore(r1.getHasMore());
            r5.setMaterialTitle(r1.getMaterialTitle());
            StoreV2CartsInfoDTO r28 = r1.getCartsInfo();
            if (r28 == null) goto L37;
            int r29 = p.b;
            r3 = p.a.a(r28);
        L37:
            r5.setCartsInfo(r3);
            r5.setLayoutType(r1.getLayout());
            Integer r30 = r1.getRecommendModuleType();
            if (r30 == null) goto L40;
            int r31 = r30.intValue();
        L41:
            r5.setRecommendModuleType(r31);
            r5.setBottomModuleParams(r1.getBottomModuleParams());
            r5.setInnerflowSchema(r1.getInnerflowSchema());
            int r32 = n.b;
            List r33 = r1.getSelectButtons();
            n r34 = new n();
            r34.a = r33;
            r5.setDiscountFilterButtons(r34);
            r5.setNextPageParams(r1.getNextPageParams());
            r5.setStyleType(r1.getStyleType());
        L75:
            Function1<StoreV2ProductListResponseVO, Unit> r35 = this.a.l;
            if (r35 == null) goto L78;
            Unit r36 = (Unit) r35.invoke(r5);
        L78:
            ArrayList r37 = new ArrayList();
            StoreAggregatePageProductListDataSource r38 = this.a;
            if (r38.j == true) goto L81;
        L92:
            StoreAggregatePageProductListDataSource r39 = this.a;
            if (r39.j == true) goto L95;
        L108:
            StoreV2RequestParam r40 = this.a.e;
            r40.setTabVisitHis(r40.getTabVisitHis() + CollectionsKt.joinToString$default(r5.getProducts(), ",", null, null, 0, null, StoreAggregatePageProductListDataSource$onLoadRange$1$2.INSTANCE, 30, null));
            r37.addAll(r5.getProducts());
            this.a.e.setHasMore(r5.getHasMore());
            this.a.e.setCursor(Long.valueOf(r5.getCursor()));
            this.a.e.setPageParam(r5.getNextPageParams());
            StoreAggregatePageProductListDataSource r41 = this.a;
            if (r41.j == true) goto L111;
        L115:
            this.b.onResult(r37);
            return;
        L111:
            if (r41.b == true) goto L115;
            if (r5.getHasMore() == true) goto L115;
            StoreAggregatePageProductListDataSource r42 = this.a;
            r42.b = true;
            r42.e.setHasMore(true);
            this.a.e.setCursor(0L);
            StoreAggregatePageProductListDataSource r43 = this.a;
            r43.e.setPageParam(r43.c);
            goto L115
        L95:
            if (r39.b == false) goto L108;
            Long r44 = r39.e.getCursor();
            if (r44 == null) goto L108;
            if (r44.longValue() != 0) goto L108;
            if (this.a.d == true) goto L108;
            if (r5.getProducts().isEmpty() == false) goto L108;
            if (r5.getHasMore() == true) goto L108;
            ((ListStatusPositionalDataSource) this.a).a.e(LoadStatus.InitializeEmpty);
            this.a.e.setHasMore(false);
            return;
        L81:
            if (r38.b == false) goto L92;
            Long r45 = r38.e.getCursor();
            if (r45 == null) goto L92;
            if (r45.longValue() != 0) goto L92;
            if (this.a.d == false) goto L92;
            if ((!r5.getProducts().isEmpty()) == false) goto L92;
            pj3.b r46 = new pj3.b();
            String r47 = ag4.a.d(2131896862);
            Intrinsics.checkNotNullParameter(r47, "<set-?>");
            r46.S = r47;
            r46.T = false;
            Unit r48 = Unit.INSTANCE;
            r37.add(r46);
            goto L92
        L40:
            r31 = 0;
            goto L41
        L33:
            r22 = CollectionsKt.emptyList();
            goto L34
        L22:
            r15 = null;
            goto L23
        L15:
            r9 = null;
            goto L16
        L42:
            int r49 = com.bytedance.android.shopping.store.aggregate.c.a;
            Intrinsics.checkNotNullParameter(r1, "dto");
            r5 = new StoreV2ProductListResponseVO();
            List r50 = r1.getGoodTypes();
            if (r50 == null) goto L48;
            List r51 = r50;
            ArrayList r52 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r51, 10));
            Iterator<T> r53 = r51.iterator();
        L46:
            if (r53.hasNext() == false) goto L49;
            k r54 = (k) r53.next();
            int r111 = q.c;
            r52.add(q.a.a(r54));
        L49:
            r5.setGoodTypes(r52);
            List r55 = r1.getSortTypes();
            if (r55 == null) goto L55;
            List r56 = r55;
            ArrayList r57 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r56, 10));
            Iterator<T> r58 = r56.iterator();
        L53:
            if (r58.hasNext() == false) goto L56;
            m r59 = (m) r58.next();
            int r112 = r.t;
            r57.add(r.a.a(r59));
        L56:
            r5.setSortTypes(r57);
            List r60 = r1.getProducts();
            if (r60 == null) goto L62;
            List r61 = r60;
            ?? r62 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r61, 10));
            Iterator<T> r63 = r61.iterator();
        L60:
            if (r63.hasNext() == false) goto L63;
            l r64 = (l) r63.next();
            int r65 = pj3.c.R;
            Intrinsics.checkNotNullParameter(r64, "dto");
            StoreV2ProductItemVO.a r66 = StoreV2ProductItemVO.Q;
            pj3.c r113 = new pj3.c();
            r66.getClass();
            StoreV2ProductItemVO.a.c(r64, r113);
            r62.add(r113);
        L63:
            r5.setProducts(r62);
            r5.setCursor(r1.getCursor());
            r5.setHasMore(r1.getHasMore());
            r5.setMaterialTitle(r1.getMaterialTitle());
            StoreV2CartsInfoDTO r67 = r1.getCartsInfo();
            if (r67 == null) goto L66;
            int r68 = p.b;
            r3 = p.a.a(r67);
        L66:
            r5.setCartsInfo(r3);
            r5.setLayoutType(r1.getLayout());
            Integer r69 = r1.getRecommendModuleType();
            if (r69 == null) goto L69;
            int r70 = r69.intValue();
        L70:
            r5.setRecommendModuleType(r70);
            r5.setBottomModuleParams(r1.getBottomModuleParams());
            r5.setInnerflowSchema(r1.getInnerflowSchema());
            int r71 = n.b;
            List r72 = r1.getSelectButtons();
            n r73 = new n();
            r73.a = r72;
            r5.setDiscountFilterButtons(r73);
            r5.setNextPageParams(r1.getNextPageParams());
            r5.setStyleType(r1.getStyleType());
            goto L75
        L69:
            r70 = 0;
            goto L70
        L62:
            r62 = CollectionsKt.emptyList();
            goto L63
        L55:
            r57 = null;
            goto L56
        L48:
            r52 = null;
            goto L49
        L72:
            if (r2.j == false) goto L74;
            r5 = StoreV2ProductListResponseVO.a.b(StoreV2ProductListResponseVO.Companion, r1);
            goto L75
        L74:
            StoreV2ProductListResponseVO.Companion.getClass();
            r5 = StoreV2ProductListResponseVO.a.a(r1, false);
            goto L75
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ ListStatusPositionalLoadRangeCallback a;

        public e(ListStatusPositionalLoadRangeCallback r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
            this.a.a();
        }
    }

    static {
    }

    public final void f(PositionalDataSource.LoadInitialParams r6, ListStatusPositionalLoadInitialCallback<StoreV2ProductItemVO> r7) {
        Intrinsics.checkNotNullParameter(r6, "params");
        Intrinsics.checkNotNullParameter(r7, "callback");
        StoreV2ProductListResponseVO r0 = this.f;
        String r1 = null;
        if (r0 != null) goto L5;
    L10:
        this.c = this.e.getPageParam();
        if (this.j == false) goto L13;
        Map r2 = qm.a.a;
        qm.a.a("ec_perf_duration_shop_classification", "request_start", System.currentTimeMillis());
    L14:
        long r3 = r6.pageSize;
        if (this.j == false) goto L17;
        r1 = "201";
    L17:
        Disposable r8 = bg4.b.b(i(r3, r1)).subscribe(new b(this, r7), new c(r7));
        if (r8 == null) goto L22;
        com.bytedance.android.ec.core.async.a.a(r8, this.k);
        return;
    L22:
        return;
    L13:
        Map r4 = qm.a.a;
        qm.a.a("ec_perf_duration_live_store", "request_start", System.currentTimeMillis());
        goto L14
    L5:
        if (this.e.getFirstInit() == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L10;
        this.e.setFirstInit(false);
        h(this.f, r7);
    }

    public final void g(PositionalDataSource.LoadRangeParams r3, ListStatusPositionalLoadRangeCallback<StoreV2ProductItemVO> r4) {
        Intrinsics.checkNotNullParameter(r3, "params");
        Intrinsics.checkNotNullParameter(r4, "callback");
        if (this.e.getHasMore() == true) goto L5;
        r4.onResult(new ArrayList());
        return;
    L5:
        if (this.b == false) goto L7;
        Observable<StoreV2ProductListResponseDTO> r5 = i(r3.loadSize, "202");
    L12:
        Disposable r6 = r5.subscribe(new d(this, r4), new e(r4));
        if (r6 == null) goto L17;
        com.bytedance.android.ec.core.async.a.a(r6, this.k);
        return;
    L17:
        return;
    L7:
        long r0 = r3.loadSize;
        if (this.j == false) goto L10;
        String r7 = "201";
    L11:
        r5 = i(r0, r7);
        goto L12
    L10:
        r7 = null;
        goto L11
    }

    public final void h(StoreV2ProductListResponseVO r14, ListStatusPositionalLoadInitialCallback<StoreV2ProductItemVO> r15) {
        Function1<StoreV2ProductListResponseVO, Unit> r0 = this.l;
        if (r0 == null) goto L5;
        Unit r1 = (Unit) r0.invoke(r14);
    L5:
        List<StoreV2ProductItemVO> r2 = com.bytedance.android.shopping.store.aggregate.datasource.a.a(r14, this.g, this.h, this.i, this.m, true);
        StoreV2RequestParam r3 = this.e;
        r3.setTabVisitHis(r3.getTabVisitHis() + CollectionsKt.joinToString$default(r14.getProducts(), ",", null, null, 0, null, StoreAggregatePageProductListDataSource$initData$1.INSTANCE, 30, null));
        this.e.setHasMore(r14.getHasMore());
        StoreV2RequestParam r4 = this.e;
        List r5 = r14.getGoodTypes();
        Object r6 = null;
        if (r5 == null) goto L17;
        Iterator r7 = r5.iterator();
    L9:
        if (r7.hasNext() == false) goto L13;
        Object r8 = r7.next();
        if (((q) r8).b == false) goto L9;
    L14:
        q r9 = (q) r8;
        if (r9 == null) goto L17;
        Long r10 = Long.valueOf(r9.a);
    L18:
        r4.setGoodsType(r10);
        StoreV2RequestParam r11 = this.e;
        List r12 = r14.getSortTypes();
        if (r12 == null) goto L29;
        Iterator r13 = r12.iterator();
    L22:
        if (r13.hasNext() == false) goto L26;
        Object r16 = r13.next();
        if (((r) r16).c == false) goto L22;
        r6 = r16;
    L26:
        r r17 = (r) r6;
        if (r17 == null) goto L29;
        long r18 = r17.a;
    L30:
        r11.setSortType(Long.valueOf(r18));
        if (this.j == true) goto L33;
    L38:
        r15.onResult(r2, 0);
        return;
    L33:
        if (r14.getHasMore() == true) goto L38;
        boolean r19 = !r14.getProducts().isEmpty();
        this.d = r19;
        if (r19 == true) goto L37;
        r2.add(new pj3.d());
        pj3.b r110 = new pj3.b();
        String r20 = ag4.a.d(2131896862);
        Intrinsics.checkNotNullParameter(r20, "<set-?>");
        r110.S = r20;
        r110.T = false;
        Unit r21 = Unit.INSTANCE;
        r2.add(r110);
    L37:
        this.b = true;
        this.e.setHasMore(true);
        this.e.setCursor(0L);
        this.e.setPageParam(this.c);
    L29:
        r18 = 0;
        goto L30
    L13:
        r8 = null;
    L17:
        r10 = null;
        goto L18
    }

    public final Observable<StoreV2ProductListResponseDTO> i(long r12, String r14) {
        int r0 = w0.a;
        ECStoreProductListConfig.a r1 = ECStoreProductListConfig.Companion;
        StoreV2RequestParam r2 = this.e;
        String r3 = CollectionsKt.joinToString$default(com.bytedance.android.ec.store.utils.c.b, ",", null, null, 0, null, null, 62, null);
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "reqParam");
        ECStoreProductListConfig r4 = new ECStoreProductListConfig();
        r4.setMaterialId(r2.getMaterialId());
        r4.setGoodsType(r2.getGoodsType());
        r4.setSortType(r2.getSortType());
        r4.setSort(r2.getSort());
        r4.setKeyWord(r2.getKeyWord());
        r4.setCursor(r2.getCursor());
        r4.setSize(Long.valueOf(r12));
        r4.setTmpId(r2.getTmpId());
        r4.setToken(r2.getToken());
        r4.setPassThroughApi((String) r2.getPassThroughParam("pass_through_api"));
        r4.setEntrances(r2.getEntrances());
        r4.setCustomIds(r2.getCustomIds());
        r4.setCustomIdType(r2.getCustomIdType());
        r4.setSelectParams(r2.getSelectParams());
        r4.setClickProducts(r3);
        r4.setShuffleProductIds(r2.getShuffleProductIds());
        r4.setPickType(r2.getPickType());
        r4.setTabVisitHis(r2.getTabVisitHis());
        String r13 = u0.d(r4);
        if ((!Intrinsics.areEqual(r13, "{}")) == true) goto L6;
        r13 = null;
    L6:
        Map r15 = w0.a(r13);
        if (r15 == null) goto L10;
        Map r16 = MapsKt.toMutableMap(r15);
        if (r16 == null) goto L10;
    L11:
        Map r17 = this.e.getExtraParamMap();
        if (r17 == null) goto L14;
        r16.putAll(r17);
    L14:
        ECStoreApi.a.getClass();
        ECStoreApi r5 = ECStoreApi.a.a;
        if (r5 == null) goto L19;
        Observable<StoreV2ProductListResponseDTO> r18 = r5.getProductListByPost(this.e.getSecShopId(), (HashMap) r16, this.e.getPageParam(), r14, com.bytedance.android.ec.hybrid.list.util.k.d(ECShopABSettings.k.b()));
        if (r18 == null) goto L19;
        return r18;
    L19:
        return Observable.error(new Throwable());
    L10:
        r16 = new LinkedHashMap();
        goto L11
    }

    public StoreAggregatePageProductListDataSource(StoreV2RequestParam r2, StoreV2ProductListResponseVO r3, jm.a<List<q>> r4, jm.a<List<r>> r5, QLiveData<LoadStatus> r6, jm.a<String> r7, boolean r8, com.bytedance.android.ec.core.async.b r9, Function1<? super StoreV2ProductListResponseVO, Unit> r10, jm.a<p> r11) {
        Intrinsics.checkNotNullParameter(r2, "reqParam");
        Intrinsics.checkNotNullParameter(r6, "loadStatus");
        Intrinsics.checkNotNullParameter(r9, "disposableScope");
        super(r6);
        this.e = r2;
        this.f = r3;
        this.g = r4;
        this.h = r5;
        this.i = r7;
        this.j = r8;
        this.k = r9;
        this.l = r10;
        this.m = r11;
        this.d = true;
    }
}
