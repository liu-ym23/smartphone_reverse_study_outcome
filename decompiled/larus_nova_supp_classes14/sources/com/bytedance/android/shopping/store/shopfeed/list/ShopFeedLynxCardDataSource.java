package com.bytedance.android.shopping.store.shopfeed.list;

import androidx.paging.PositionalDataSource;
import com.bytedance.android.ec.core.utils.t0;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListDTO;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListItemDTO;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListSectionDTO;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListStyleDTO;
import com.bytedance.android.ec.store.monitor.ErrorCode;
import com.bytedance.android.ec.store.monitor.ErrorDomain;
import com.bytedance.android.ec.store.shopping.paging.ListStatusPositionalDataSource;
import com.bytedance.android.ec.store.shopping.paging.ListStatusPositionalLoadInitialCallback;
import com.bytedance.android.ec.store.shopping.paging.ListStatusPositionalLoadRangeCallback;
import com.bytedance.android.ec.store.shopping.paging.LoadStatus;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.store.home.api.ECStoreApi;
import com.bytedance.android.shopping.store.hybridproduct.dto.ECShopProductListBffResponseDTO;
import com.bytedance.android.shopping.store.repository.vo.TabEnum;
import com.bytedance.android.shopping.store.settings.ECShopABSettings;
import com.bytedance.android.shopping.store.shopfeed.ShopFeedParam;
import com.bytedance.android.shopping.store.shopfeed.f;
import com.bytedance.android.shopping.store.slicecard.dto.ShopSliceItemConfig;
import com.bytedance.android.shopping.store.slicecard.dto.SliceConfig;
import com.google.gson.Gson;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/store/shopfeed/list/ShopFeedLynxCardDataSource;", "Lcom/bytedance/android/ec/store/shopping/paging/ListStatusPositionalDataSource;", "Lcom/bytedance/android/shopping/store/shopfeed/list/a;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShopFeedLynxCardDataSource extends ListStatusPositionalDataSource<com.bytedance.android.shopping.store.shopfeed.list.a> {
    public final String b;
    public final ShopFeedParam c;
    public final f d;
    public final com.bytedance.android.ec.core.async.b e;
    public final QLiveData<fk3.a> f;
    public final jm.a<ECHybridListStyleDTO> g;
    public final com.bytedance.android.shopping.store.slicecard.b h;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ ShopFeedLynxCardDataSource a;
        public final /* synthetic */ ListStatusPositionalLoadInitialCallback b;
        public final /* synthetic */ PositionalDataSource.LoadInitialParams c;

        public a(ShopFeedLynxCardDataSource r1, ListStatusPositionalLoadInitialCallback r2, PositionalDataSource.LoadInitialParams r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r8) {
            ECShopProductListBffResponseDTO r9 = (ECShopProductListBffResponseDTO) r8;
            if (r9.getStatusCode() == 0) goto L5;
            dm.a.b r0 = dm.a.a;
            dm.a.a(this.a.b).a("onLoadInitial onNetError, code:" + r9.getStatusCode() + " msg: " + r9.getStatusMsg());
            ListStatusPositionalLoadInitialCallback r1 = this.b;
            ErrorDomain.NET.getCode();
            r9.getStatusCode();
            r9.getStatusMsg();
            r1.a();
            return;
        L5:
            ShopFeedLynxCardDataSource r2 = this.a;
            r2.getClass();
            SliceConfig.a r3 = SliceConfig.Companion;
            ECHybridListDTO r4 = r9.getHybridList();
            ECHybridListStyleDTO r5 = null;
            if (r4 == null) goto L8;
            Map r6 = r4.getExtra();
        L9:
            r3.getClass();
            SliceConfig r7 = SliceConfig.a.a(r6);
            if (r7 == null) goto L12;
            Map<String, ShopSliceItemConfig> r10 = r7.getConfigs();
        L13:
            if (r10 == null) goto L15;
            r2.h.d(r7.getConfigs());
        L15:
            ShopFeedLynxCardDataSource r11 = this.a;
            ShopFeedParam r12 = r11.c;
            if (r12 == null) goto L18;
            Integer r13 = r12.getTabType();
        L19:
            int r14 = TabEnum.SHOP_INNER_FLOW_PAGE.getType();
            if (r13 != null) goto L23;
        L129:
            jm.a<ECHybridListStyleDTO> r15 = this.a.g;
            ECHybridListDTO r16 = r9.getHybridList();
            if (r16 == null) goto L132;
            r5 = r16.getListStyle();
        L132:
            r15.setValue(r5);
            List r17 = CollectionsKt.toMutableList(ShopFeedLynxCardDataSource.h(this.a, r9));
            dm.a.b r18 = dm.a.a;
            dm.a.a(this.a.b).a("onLoadInitial lynxData size: " + r17.size());
            ShopFeedLynxCardDataSource r19 = this.a;
            r19.d.f = r9.getPaginationParams();
            r19.d.a = r9.getHasMore();
            if ((!r17.isEmpty()) == false) goto L135;
            ListStatusPositionalLoadInitialCallback r20 = this.b;
            r20.getClass();
            Intrinsics.checkNotNullParameter(r17, "data");
            r20.a.onResult(r17, 0);
            return;
        L135:
            ShopFeedLynxCardDataSource r21 = this.a;
            if (r21.d.a == false) goto L138;
            r21.loadInitial(this.c, this.b);
            return;
        L138:
            this.b.onResult(new ArrayList(), 0);
            return;
        L23:
            if (r13.intValue() != r14) goto L129;
            ECHybridListDTO r22 = r9.getHybridList();
            if (r22 == null) goto L129;
            List r23 = r22.getSections();
            if (r23 == null) goto L129;
            Iterator<T> r24 = r23.iterator();
        L30:
            if (r24.hasNext() == false) goto L34;
            T r25 = r24.next();
            if (Intrinsics.areEqual(((ECHybridListSectionDTO) r25).getSectionId(), "__SHOP_INNER_FLOW_TOPBAR_SECTION__") == false) goto L30;
        L35:
            ECHybridListSectionDTO r26 = (ECHybridListSectionDTO) r25;
            if (r26 == null) goto L129;
            ArrayList r27 = r26.getItems();
            if (r27 == null) goto L129;
            ECHybridListItemDTO r28 = (ECHybridListItemDTO) CollectionsKt.firstOrNull(r27);
            if (r28 == null) goto L129;
            String r29 = r28.getItemData();
            if (r29 == null) goto L129;
            int r30 = fk3.a.f;
            Intrinsics.checkNotNullParameter(r29, "string");
            fk3.a r31 = new fk3.a();
            ShopFeedItemCard r32 = (ShopFeedItemCard) new Gson().fromJson(r29, ShopFeedItemCard.class);     // Catch: Exception -> L127
            Result.Companion r33 = Result.Companion;     // Catch: Throwable -> L58
            int r34 = t0.a;     // Catch: Throwable -> L58
            Gson r35 = t0.a.a;     // Catch: Throwable -> L58
            Map<String, String> r36 = r32.getExtra();     // Catch: Throwable -> L58
            if (r36 == null) goto L49;
            String r37 = r36.get("slice_item_extra");     // Catch: Throwable -> L58
        L50:
            Object r38 = r35.fromJson(r37, Map.class);     // Catch: Throwable -> L58
            if (TypeIntrinsics.isMutableMap(r38) == true) goto L53;
            r38 = null;
        L53:
            Object r39 = (Map) r38;     // Catch: Throwable -> L58
            if (r39 != null) goto L56;
            r39 = new LinkedHashMap();     // Catch: Throwable -> L58
        L56:
            Object r40 = Result.constructor-impl(r39);     // Catch: Throwable -> L58
        L61:
            if (Result.isFailure-impl(r40) == false) goto L63;
            r40 = null;
        L63:
            r31.b = (Map) r40;     // Catch: Exception -> L127
            int r41 = t0.a;     // Catch: Throwable -> L76
            Gson r42 = t0.a.a;     // Catch: Throwable -> L76
            Map<String, String> r43 = r32.getExtra();     // Catch: Throwable -> L76
            if (r43 == null) goto L67;
            String r44 = r43.get("slice_item_actions");     // Catch: Throwable -> L76
        L68:
            Object r45 = r42.fromJson(r44, Map.class);     // Catch: Throwable -> L76
            if (TypeIntrinsics.isMutableMap(r45) == true) goto L71;
            r45 = null;
        L71:
            Object r46 = (Map) r45;     // Catch: Throwable -> L76
            if (r46 != null) goto L74;
            r46 = new LinkedHashMap();     // Catch: Throwable -> L76
        L74:
            Object r47 = Result.constructor-impl(r46);     // Catch: Throwable -> L76
        L79:
            if (Result.isFailure-impl(r47) == false) goto L81;
            r47 = null;
        L81:
            r31.c = (Map) r47;     // Catch: Exception -> L127
            int r48 = t0.a;     // Catch: Throwable -> L94
            Gson r49 = t0.a.a;     // Catch: Throwable -> L94
            Map<String, String> r50 = r32.getExtra();     // Catch: Throwable -> L94
            if (r50 == null) goto L85;
            String r51 = r50.get("slice_item_states");     // Catch: Throwable -> L94
        L86:
            Object r52 = r49.fromJson(r51, Map.class);     // Catch: Throwable -> L94
            if (TypeIntrinsics.isMutableMap(r52) == true) goto L89;
            r52 = null;
        L89:
            Object r53 = (Map) r52;     // Catch: Throwable -> L94
            if (r53 != null) goto L92;
            r53 = new LinkedHashMap();     // Catch: Throwable -> L94
        L92:
            Object r54 = Result.constructor-impl(r53);     // Catch: Throwable -> L94
        L97:
            if (Result.isFailure-impl(r54) == false) goto L99;
            r54 = null;
        L99:
            r31.d = (Map) r54;     // Catch: Exception -> L127
            int r55 = t0.a;     // Catch: Throwable -> L106
            Gson r56 = t0.a.a;     // Catch: Throwable -> L106
            Map<String, String> r57 = r32.getExtra();     // Catch: Throwable -> L106
            if (r57 == null) goto L103;
            String r58 = r57.get("slice_item_config");     // Catch: Throwable -> L106
        L104:
            Object r59 = Result.constructor-impl((ShopSliceItemConfig) r56.fromJson(r58, ShopSliceItemConfig.class));     // Catch: Throwable -> L106
        L109:
            if (Result.isFailure-impl(r59) == false) goto L111;
            r59 = null;
        L111:
            r31.e = (ShopSliceItemConfig) r59;     // Catch: Exception -> L127
            int r60 = t0.a;     // Catch: Throwable -> L120
            Object r61 = t0.a.a.fromJson(r32.getSliceCardData(), Map.class);     // Catch: Throwable -> L120
            if (TypeIntrinsics.isMutableMap(r61) == true) goto L115;
            r61 = null;
        L115:
            Object r62 = (Map) r61;     // Catch: Throwable -> L120
            if (r62 != null) goto L118;
            r62 = new LinkedHashMap();     // Catch: Throwable -> L120
        L118:
            Object r63 = Result.constructor-impl(r62);     // Catch: Throwable -> L120
        L123:
            if (Result.isFailure-impl(r63) == false) goto L125;
            r63 = null;
        L125:
            r31.a = (Map) r63;     // Catch: Exception -> L127
        L128:
            r11.f.g(r31);
        L120:
            th = move-exception;
            Result.Companion r64 = Result.Companion;     // Catch: Exception -> L127
            r63 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Exception -> L127
            goto L123
        L103:
            r58 = null;
        L106:
            th = move-exception;
            Result.Companion r65 = Result.Companion;     // Catch: Exception -> L127
            r59 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Exception -> L127
            goto L109
        L85:
            r51 = null;
        L94:
            th = move-exception;
            Result.Companion r66 = Result.Companion;     // Catch: Exception -> L127
            r54 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Exception -> L127
            goto L97
        L67:
            r44 = null;
        L76:
            th = move-exception;
            Result.Companion r67 = Result.Companion;     // Catch: Exception -> L127
            r47 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Exception -> L127
            goto L79
        L49:
            r37 = null;
        L58:
            th = move-exception;
            Result.Companion r68 = Result.Companion;     // Catch: Exception -> L127
            r40 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Exception -> L127
        L127:
            r31 = new fk3.a();
            goto L128
        L34:
            r25 = null;
            goto L35
        L18:
            r13 = null;
            goto L19
        L12:
            r10 = null;
            goto L13
        L8:
            r6 = null;
            goto L9
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ ShopFeedLynxCardDataSource a;
        public final /* synthetic */ ListStatusPositionalLoadInitialCallback b;

        public b(ShopFeedLynxCardDataSource r1, ListStatusPositionalLoadInitialCallback r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            Throwable r5 = (Throwable) r4;
            dm.a.b r0 = dm.a.a;
            dm.a.a(this.a.b).a("onLoadInitial nativeError, msg:" + r5.getMessage());
            ListStatusPositionalLoadInitialCallback r1 = this.b;
            ErrorDomain.NATIVE.getCode();
            ErrorCode.NATIVE_COMMON.getCode();
            r5.getMessage();
            r1.a();
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ ShopFeedLynxCardDataSource a;
        public final /* synthetic */ ListStatusPositionalLoadRangeCallback b;

        public c(ShopFeedLynxCardDataSource r1, ListStatusPositionalLoadRangeCallback r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r5) {
            ECShopProductListBffResponseDTO r6 = (ECShopProductListBffResponseDTO) r5;
            if (r6.getStatusCode() == 0) goto L5;
            this.b.a();
            return;
        L5:
            List r0 = CollectionsKt.toMutableList(ShopFeedLynxCardDataSource.h(this.a, r6));
            dm.a.b r1 = dm.a.a;
            dm.a.a(this.a.b).a("onLoadRange lynxData size: " + r0.size());
            ShopFeedLynxCardDataSource r2 = this.a;
            r2.d.f = r6.getPaginationParams();
            r2.d.a = r6.getHasMore();
            this.b.onResult(r0);
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

    public static Observable i(f r15) {
        ECStoreApi.a.getClass();
        ECStoreApi r1 = ECStoreApi.a.b;
        if (r1 == null) goto L7;
        Observable<ECShopProductListBffResponseDTO> r16 = r1.getProductListBFFByPost(k.g(r15.b, TabEnum.SHOP_FLOW_PAGE.getType()), r15.c, "", r15.f, null, null, null, null, null, r15.d, r15.e, null, com.bytedance.android.ec.hybrid.list.util.k.d(ECShopABSettings.k.b()));
        if (r16 == null) goto L7;
        return r16;
    L7:
        return Observable.error(new Throwable("getProductListBFF failed : network service not found"));
    }

    public static final List h(ShopFeedLynxCardDataSource r6, ECShopProductListBffResponseDTO r7) {
        r6.getClass();
        ECHybridListDTO r8 = r7.getHybridList();
        if (r8 == null) goto L75;
        List r9 = r8.getSections();
        if (r9 == null) goto L75;
        Iterator r10 = r9.iterator();
    L8:
        if (r10.hasNext() == false) goto L35;
        Object r0 = r10.next();
        String r2 = ((ECHybridListSectionDTO) r0).getSectionId();
        ShopFeedParam r3 = r6.c;
        if (r3 == null) goto L12;
        Integer r4 = r3.getTabType();
    L13:
        int r5 = TabEnum.SHOP_FLOW_PAGE.getType();
        if (r4 != null) goto L17;
    L19:
        int r11 = TabEnum.SHOP_MOMENT_FLOW_PAGE.getType();
        if (r4 != null) goto L23;
    L25:
        int r12 = TabEnum.SHOP_INNER_FLOW_PAGE.getType();
        if (r4 != null) goto L29;
    L31:
        String r13 = "__SHOP_FLOW_SHOP_SECTION__";
    L33:
        if (Intrinsics.areEqual(r2, r13) == false) goto L8;
    L36:
        ECHybridListSectionDTO r1 = (ECHybridListSectionDTO) r0;
        if (r1 == null) goto L75;
        ArrayList r14 = r1.getItems();
        if (r14 == null) goto L75;
        ArrayList r15 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10));
        Iterator r16 = r14.iterator();
    L42:
        if (r16.hasNext() == false) goto L88;
        ShopFeedItemCard r17 = (ShopFeedItemCard) new Gson().fromJson(((ECHybridListItemDTO) r16.next()).getItemData(), ShopFeedItemCard.class);     // Catch: Exception -> L64
        if (r17 == null) goto L47;
        Integer r18 = r17.getItemType();     // Catch: Exception -> L64
    L48:
        int r19 = ShopFeedItemType.SLICE_CARD.getTypeValue();     // Catch: Exception -> L64
        if (r18 != null) goto L52;
    L58:
        ShopFeedParam r20 = r6.c;     // Catch: Exception -> L64
        if (r20 == null) goto L61;
        String r21 = r20.getPassThroughParams();     // Catch: Exception -> L64
    L63:
        com.bytedance.android.shopping.store.shopfeed.list.a r22 = new com.bytedance.android.shopping.store.shopfeed.list.b(r17, k.j(r21));     // Catch: Exception -> L64
    L73:
        r15.add(r22);
        goto L42
    L61:
        r21 = null;
        goto L63
    L52:
        if (r18.intValue() != r19) goto L58;
        int r23 = com.bytedance.android.shopping.store.shopfeed.list.c.h;     // Catch: Exception -> L64
        ShopFeedParam r24 = r6.c;     // Catch: Exception -> L64
        if (r24 == null) goto L56;
        String r25 = r24.getPassThroughParams();     // Catch: Exception -> L64
    L57:
        r22 = com.bytedance.android.shopping.store.shopfeed.list.c.a.a(r17, k.j(r25));     // Catch: Exception -> L64
        goto L73
    L56:
        r25 = null;
        goto L57
    L47:
        r18 = null;
    L64:
        int r26 = com.bytedance.android.shopping.store.shopfeed.list.b.d;
        ShopFeedParam r27 = r6.c;
        if (r27 == null) goto L67;
        String r28 = r27.getPassThroughParams();
    L68:
        String r29 = k.j(r28);
        Intrinsics.checkNotNullParameter("", "jsonStr");
        Intrinsics.checkNotNullParameter(r29, "passThroughParams");
        r22 = new com.bytedance.android.shopping.store.shopfeed.list.b((ShopFeedItemCard) new Gson().fromJson("", ShopFeedItemCard.class), r29);     // Catch: Exception -> L71
    L71:
        e = move-exception;
        dm.a.a("ShopFeedLynxCardVO").b("createFromJsonString", e);
        r22 = new com.bytedance.android.shopping.store.shopfeed.list.b(new ShopFeedItemCard(), "");
        goto L73
    L67:
        r28 = null;
        goto L68
    L88:
        return r15;
    L29:
        if (r4.intValue() != r12) goto L31;
        r13 = "__SHOP_INNER_FLOW_SECTION__";
        goto L33
    L23:
        if (r4.intValue() != r11) goto L25;
        r13 = "__SHOP_MOMENT_INNER_FLOW_SECTION__";
        goto L33
    L17:
        if (r4.intValue() != r5) goto L19;
    L12:
        r4 = null;
        goto L13
    L35:
        r0 = null;
    L75:
        return CollectionsKt.emptyList();
    }

    public final void f(PositionalDataSource.LoadInitialParams r3, ListStatusPositionalLoadInitialCallback<com.bytedance.android.shopping.store.shopfeed.list.a> r4) {
        Intrinsics.checkNotNullParameter(r3, "params");
        Intrinsics.checkNotNullParameter(r4, "callback");
        dm.a.b r0 = dm.a.a;
        dm.a.a(this.b).a("onLoadInitial");
        com.bytedance.android.ec.core.async.a.a(bg4.b.b(i(this.d)).subscribe(new a(this, r4, r3), new b(this, r4)), this.e);
    }

    public final void g(PositionalDataSource.LoadRangeParams r3, ListStatusPositionalLoadRangeCallback<com.bytedance.android.shopping.store.shopfeed.list.a> r4) {
        Intrinsics.checkNotNullParameter(r3, "params");
        Intrinsics.checkNotNullParameter(r4, "callback");
        dm.a.b r5 = dm.a.a;
        dm.a.a(this.b).a("onLoadRange, hasMore: " + this.d.a);
        f r6 = this.d;
        if (r6.a == true) goto L6;
        r4.onResult(new ArrayList());
        return;
    L6:
        com.bytedance.android.ec.core.async.a.a(bg4.b.b(i(r6)).subscribe(new c(this, r4), new d(r4)), this.e);
    }

    public ShopFeedLynxCardDataSource(ShopFeedParam r2, f r3, com.bytedance.android.ec.core.async.b r4, QLiveData<LoadStatus> r5, QLiveData<fk3.a> r6, jm.a<ECHybridListStyleDTO> r7, com.bytedance.android.shopping.store.slicecard.b r8) {
        Intrinsics.checkNotNullParameter(r3, "reqParam");
        Intrinsics.checkNotNullParameter(r4, "disposableScope");
        Intrinsics.checkNotNullParameter(r5, "loadStatus");
        Intrinsics.checkNotNullParameter(r6, "topInfo");
        Intrinsics.checkNotNullParameter(r7, "listStyle");
        Intrinsics.checkNotNullParameter(r8, "sliceService");
        super(r5);
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.b = "ShopFeedLynxCardDataSource";
    }
}
