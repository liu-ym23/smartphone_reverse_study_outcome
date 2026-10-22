package com.bytedance.android.shopping.store.aggregate.viewmodel;

import android.view.View;
import androidx.lifecycle.LiveData;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;
import com.bytedance.android.ec.core.arch.viewmodel.BaseViewModel;
import com.bytedance.android.ec.store.common.param.StoreV2RequestParam;
import com.bytedance.android.ec.store.datasource.StoreDataSourceFactory;
import com.bytedance.android.ec.store.product.holder.LayoutTypes;
import com.bytedance.android.ec.store.repository.vo.StoreV2ProductItemVO;
import com.bytedance.android.ec.store.repository.vo.StoreV2ProductListResponseVO;
import com.bytedance.android.ec.store.repository.vo.p;
import com.bytedance.android.ec.store.repository.vo.q;
import com.bytedance.android.ec.store.repository.vo.r;
import com.bytedance.android.ec.store.repository.vo.t;
import com.bytedance.android.ec.store.setting.SettingKeys;
import com.bytedance.android.ec.store.shopping.paging.LoadStatus;
import com.bytedance.android.shopping.store.aggregate.AggregatePageTypes;
import com.bytedance.android.shopping.store.aggregate.CustomIdTypes;
import com.bytedance.android.shopping.store.aggregate.ShopAggregateParam;
import com.bytedance.android.shopping.store.aggregate.datasource.StoreAggregatePageDataSourceFactory;
import com.bytedance.android.shopping.store.utils.z;
import com.bytedance.apm.constant.UploadTypeInf;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;
import java.lang.ref.WeakReference;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.text.StringsKt;
import xm.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000Ê\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\t¢\u0006\u0006\b\u008b\u0001\u0010\u008c\u0001J\u0014\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0002J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\n\u001a\u00020\bH\u0002J\u0019\u0010\r\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0006H\u0002J\u0006\u0010\u0015\u001a\u00020\u0014J\u0018\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018J\u0006\u0010\u001b\u001a\u00020\bJ\u0010\u0010\u001d\u001a\u00020\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0006J!\u0010!\u001a\u00020\b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010 \u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b!\u0010\"J\u0006\u0010#\u001a\u00020\u0006J\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020%0$R\u0016\u0010(\u001a\u00020'8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b(\u0010)R\"\u0010\u0017\u001a\u00020\u00168\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0017\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u0017\u00100\u001a\u00020/8\u0006¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R$\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001d\u0010;\u001a\b\u0012\u0004\u0012\u00020:098\u0006¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>R#\u0010B\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020A0@0?8\u0006¢\u0006\f\n\u0004\bB\u0010C\u001a\u0004\bD\u0010ER#\u0010G\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020F0@0?8\u0006¢\u0006\f\n\u0004\bG\u0010C\u001a\u0004\bH\u0010ER\u0017\u0010I\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\bI\u0010J\u001a\u0004\bK\u0010LR'\u0010O\u001a\u0012\u0012\u0004\u0012\u00020\u00060Mj\b\u0012\u0004\u0012\u00020\u0006`N8\u0006¢\u0006\f\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010RR'\u0010S\u001a\u0012\u0012\u0004\u0012\u00020\u00060Mj\b\u0012\u0004\u0012\u00020\u0006`N8\u0006¢\u0006\f\n\u0004\bS\u0010P\u001a\u0004\bT\u0010RR?\u0010Y\u001a\u001f\u0012\u0013\u0012\u00110\u000b¢\u0006\f\bV\u0012\b\bW\u0012\u0004\b\b(X\u0012\u0004\u0012\u00020\b\u0018\u00010U8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bY\u0010Z\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R\u001d\u0010`\u001a\b\u0012\u0004\u0012\u00020_0?8\u0006¢\u0006\f\n\u0004\b`\u0010C\u001a\u0004\ba\u0010ER,\u0010d\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010c\u0018\u00010b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bd\u0010e\u001a\u0004\bf\u0010g\"\u0004\bh\u0010iR\"\u0010j\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bj\u0010k\u001a\u0004\bl\u0010m\"\u0004\bn\u0010oR\"\u0010p\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bp\u0010k\u001a\u0004\bq\u0010m\"\u0004\br\u0010oR$\u0010s\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bs\u0010J\u001a\u0004\bt\u0010L\"\u0004\bu\u0010vR\u0017\u0010x\u001a\u00020w8\u0006¢\u0006\f\n\u0004\bx\u0010y\u001a\u0004\bz\u0010{R\u001d\u0010|\u001a\b\u0012\u0004\u0012\u00020\u00100?8\u0006¢\u0006\f\n\u0004\b|\u0010C\u001a\u0004\b}\u0010ER\u0016\u0010~\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b~\u0010kR#\u0010\u007f\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0013\n\u0004\b\u007f\u0010k\u001a\u0004\b\u007f\u0010m\"\u0005\b\u0080\u0001\u0010oR \u0010\u0081\u0001\u001a\b\u0012\u0004\u0012\u00020\u000b0?8\u0006¢\u0006\u000e\n\u0005\b\u0081\u0001\u0010C\u001a\u0005\b\u0082\u0001\u0010ER,\u0010\u0087\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00028FX\u0086\u0084\u0002¢\u0006\u0010\n\u0006\b\u0083\u0001\u0010\u0084\u0001\u001a\u0006\b\u0085\u0001\u0010\u0086\u0001R)\u0010\u0089\u0001\u001a\u0011\u0012\r\u0012\u000b\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0088\u00010?8\u0006¢\u0006\u000e\n\u0005\b\u0089\u0001\u0010C\u001a\u0005\b\u008a\u0001\u0010E¨\u0006\u008d\u0001"}, d2 = {"Lcom/bytedance/android/shopping/store/aggregate/viewmodel/ShopAggregatePageProductViewModel;", "Lcom/bytedance/android/ec/core/arch/viewmodel/BaseViewModel;", "Landroidx/lifecycle/LiveData;", "Landroidx/paging/PagedList;", "Lcom/bytedance/android/ec/store/repository/vo/StoreV2ProductItemVO;", "makeLivePageList", "", "entranceInfo", "", "initEventParams", "initDataSource", "", "typeFromServer", "setLayoutTypeIfNeedOnce", "(Ljava/lang/Integer;)V", "fromServer", "Lcom/bytedance/android/ec/store/product/holder/LayoutTypes;", "getRealLayoutType", "(Ljava/lang/Integer;)Lcom/bytedance/android/ec/store/product/holder/LayoutTypes;", "getTagId", "", "isStoreParamInit", "Lcom/bytedance/android/shopping/store/aggregate/ShopAggregateParam;", "storeParam", "Lcom/bytedance/android/ec/store/repository/vo/StoreV2ProductListResponseVO;", "initialData", "init", "refresh", "selectId", "refreshByFilter", "", "sortType", "sort", "refreshBySortAndSortType", "(Ljava/lang/Long;Ljava/lang/Integer;)V", "getPublicityText", "", "", "getAdParams", "Lcom/bytedance/android/ec/store/datasource/StoreDataSourceFactory;", "dataSourceFactory", "Lcom/bytedance/android/ec/store/datasource/StoreDataSourceFactory;", "Lcom/bytedance/android/shopping/store/aggregate/ShopAggregateParam;", "getStoreParam", "()Lcom/bytedance/android/shopping/store/aggregate/ShopAggregateParam;", "setStoreParam", "(Lcom/bytedance/android/shopping/store/aggregate/ShopAggregateParam;)V", "Lcom/bytedance/android/ec/store/common/param/StoreV2RequestParam;", "requestParam", "Lcom/bytedance/android/ec/store/common/param/StoreV2RequestParam;", "getRequestParam", "()Lcom/bytedance/android/ec/store/common/param/StoreV2RequestParam;", "Lcom/bytedance/android/ec/store/repository/vo/StoreV2ProductListResponseVO;", "getInitialData", "()Lcom/bytedance/android/ec/store/repository/vo/StoreV2ProductListResponseVO;", "setInitialData", "(Lcom/bytedance/android/ec/store/repository/vo/StoreV2ProductListResponseVO;)V", "Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QLiveData;", "Lcom/bytedance/android/ec/store/shopping/paging/LoadStatus;", "loadStatus", "Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QLiveData;", "getLoadStatus", "()Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QLiveData;", "Ljm/a;", "", "Lcom/bytedance/android/ec/store/repository/vo/q;", "goodTypes", "Ljm/a;", "getGoodTypes", "()Ljm/a;", "Lcom/bytedance/android/ec/store/repository/vo/r;", "sortTypes", "getSortTypes", "sessionId", "Ljava/lang/String;", "getSessionId", "()Ljava/lang/String;", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "idRecords", "Ljava/util/HashSet;", "getIdRecords", "()Ljava/util/HashSet;", "filterIdRecords", "getFilterIdRecords", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", UploadTypeInf.COUNT, "myCartListener", "Lkotlin/jvm/functions/Function1;", "getMyCartListener", "()Lkotlin/jvm/functions/Function1;", "setMyCartListener", "(Lkotlin/jvm/functions/Function1;)V", "Lcom/bytedance/android/ec/store/repository/vo/p;", "cartsInfo", "getCartsInfo", "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "destView", "Ljava/lang/ref/WeakReference;", "getDestView", "()Ljava/lang/ref/WeakReference;", "setDestView", "(Ljava/lang/ref/WeakReference;)V", "observeFlag", "Z", "getObserveFlag", "()Z", "setObserveFlag", "(Z)V", "reportFlag", "getReportFlag", "setReportFlag", "pageParams", "getPageParams", "setPageParams", "(Ljava/lang/String;)V", "Lxm/c;", "tagPools", "Lxm/c;", "getTagPools", "()Lxm/c;", "layoutType", "getLayoutType", "layoutSet", "isExchangeLayout", "setExchangeLayout", "mmRvScrollY", "getMmRvScrollY", "products$delegate", "Lkotlin/Lazy;", "getProducts", "()Landroidx/lifecycle/LiveData;", "products", "Lrg/a;", "refreshAction", "getRefreshAction", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShopAggregatePageProductViewModel extends BaseViewModel {
    private final jm.a<p> cartsInfo;
    private StoreDataSourceFactory dataSourceFactory;
    private WeakReference<View> destView;
    private final HashSet<String> filterIdRecords;
    private final jm.a<List<q>> goodTypes;
    private final HashSet<String> idRecords;
    private StoreV2ProductListResponseVO initialData;
    private boolean isExchangeLayout;
    private boolean layoutSet;
    private final jm.a<LayoutTypes> layoutType;
    private final QLiveData<LoadStatus> loadStatus;
    private final jm.a<Integer> mmRvScrollY;
    private Function1<? super Integer, Unit> myCartListener;
    private boolean observeFlag;
    private String pageParams;
    private final Lazy products$delegate;
    private final jm.a<rg.a<Unit>> refreshAction;
    private boolean reportFlag;
    private final StoreV2RequestParam requestParam;
    private final String sessionId;
    private final jm.a<List<r>> sortTypes;
    public ShopAggregateParam storeParam;
    private final c tagPools;

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/bytedance/android/shopping/store/aggregate/viewmodel/ShopAggregatePageProductViewModel$a", "Lcom/google/gson/reflect/TypeToken;", "", "Lcom/bytedance/android/ec/store/repository/vo/t;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a extends TypeToken<List<? extends t>> {
        public a() {
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.shopping.store.aggregate.viewmodel.ShopAggregatePageProductViewModel$isStoreParamInit$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    final /* synthetic */ class C01961 extends MutablePropertyReference0Impl {
        public C01961(ShopAggregatePageProductViewModel r7) {
            super(r7, ShopAggregatePageProductViewModel.class, "storeParam", "getStoreParam()Lcom/bytedance/android/shopping/store/aggregate/ShopAggregateParam;", 0);
        }

        public Object get() {
            return ((ShopAggregatePageProductViewModel) ((CallableReference) this).receiver).getStoreParam();
        }

        public void set(Object r2) {
            ((ShopAggregatePageProductViewModel) ((CallableReference) this).receiver).setStoreParam((ShopAggregateParam) r2);
        }
    }

    public ShopAggregatePageProductViewModel() {
        super(null, null, 3, null);
        this.requestParam = new StoreV2RequestParam();
        this.loadStatus = new QLiveData();
        this.goodTypes = new jm.a(7);
        this.sortTypes = new jm.a(7);
        this.sessionId = UUID.randomUUID().toString();
        this.idRecords = new HashSet();
        this.filterIdRecords = new HashSet();
        this.cartsInfo = new jm.a(7);
        this.tagPools = new c();
        jm.a<LayoutTypes> r0 = new jm.a(7);
        r0.setValue(LayoutTypes.RECYCLER_VIEW_ITEM_DOUBLE);
        Unit r2 = Unit.INSTANCE;
        this.layoutType = r0;
        jm.a<Integer> r1 = new jm.a(7);
        r1.setValue(0);
        this.mmRvScrollY = r1;
        this.products$delegate = LazyKt.lazy(new ShopAggregatePageProductViewModel$products$2(this));
        this.refreshAction = new jm.a(7);
    }

    public final Map<String, Object> getAdParams() {
        Pair[] r0 = new Pair[4];
        ShopAggregateParam r1 = this.storeParam;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("storeParam");
    L5:
        String r2 = r1.getShopId();
        if (r2 != null) goto L8;
        r2 = "";
    L8:
        r0[0] = TuplesKt.to("shop_id", r2);
        r0[1] = TuplesKt.to("category", "umeng");
        ShopAggregateParam r3 = this.storeParam;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("storeParam");
    L11:
        r0[2] = TuplesKt.to("room_id", r3.getRoomId());
        ShopAggregateParam r4 = this.storeParam;
        if (r4 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("storeParam");
    L14:
        r0[3] = TuplesKt.to("anchor_id", r4.getAnchorId());
        return MapsKt.mutableMapOf(r0);
    }

    public final LiveData<PagedList<StoreV2ProductItemVO>> getProducts() {
        return (LiveData) this.products$delegate.getValue();
    }

    private final String getTagId() {
        ShopAggregateParam r0 = this.storeParam;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("storeParam");
    L5:
        String r1 = r0.getTagData();
        if (r1 != null) goto L19;
        return null;
    L19:
        Type r3 = new a().getType();     // Catch: Exception -> L18
        List r2 = (List) new Gson().fromJson(r1, r3);     // Catch: Exception -> L18
        if (r2 == null) goto L21;
        ShopAggregateParam r4 = this.storeParam;     // Catch: Exception -> L18
        if (r4 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("storeParam");     // Catch: Exception -> L18
    L13:
        t r5 = (t) CollectionsKt.getOrNull(r2, r4.getSelectIndex());     // Catch: Exception -> L18
        if (r5 == null) goto L22;
        return r5.b();
    L22:
        return null;
    L21:
        return null;
    L23:
        return null;
    }

    private final void initDataSource() {
        StoreV2RequestParam r1 = this.requestParam;
        StoreV2ProductListResponseVO r2 = this.initialData;
        jm.a<List<q>> r3 = this.goodTypes;
        jm.a<List<r>> r4 = this.sortTypes;
        QLiveData<LoadStatus> r5 = this.loadStatus;
        jm.a<p> r6 = this.cartsInfo;
        ShopAggregateParam r0 = this.storeParam;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("storeParam");
    L5:
        this.dataSourceFactory = new StoreAggregatePageDataSourceFactory(r1, r2, r3, r4, r5, r6, r0.getPageType(), this, new AnonymousClass1(this));
    }

    private final LiveData<PagedList<StoreV2ProductItemVO>> makeLivePageList() {
        PagedList.Config.Builder r0 = new PagedList.Config.Builder();
        r0.setPageSize(this.requestParam.getSize());
        r0.setInitialLoadSizeHint(this.requestParam.getSize());
        r0.setPrefetchDistance(this.requestParam.getSize());
        r0.setEnablePlaceholders(false);
        PagedList.Config r1 = r0.build();
        StoreDataSourceFactory r2 = this.dataSourceFactory;
        if (r2 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("dataSourceFactory");
    L6:
        return new LivePagedListBuilder(r2, r1).build();
    }

    public final ShopAggregateParam getStoreParam() {
        ShopAggregateParam r0 = this.storeParam;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("storeParam");
    L5:
        return r0;
    }

    public final boolean isStoreParamInit() {
        if (this.storeParam == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final void refresh() {
        this.refreshAction.setValue(new rg.a(null));
        StoreDataSourceFactory r0 = this.dataSourceFactory;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("dataSourceFactory");
    L5:
        r0.a();
        this.idRecords.clear();
        this.requestParam.setHasMore(true);
        this.requestParam.setPageParam(this.pageParams);
        this.requestParam.setCursor(0L);
        this.requestParam.setTabVisitHis("");
    }

    public final String getPublicityText() {
        return StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(SettingKeys.getSTORE_V2_PUBLICITY_TEXT(), "newline_placeholder", "\n", false, 4, null), "\\n", "\n", false, 4, null), "name_placeholder", "", false, 4, null);
    }

    public final jm.a<p> getCartsInfo() {
        return this.cartsInfo;
    }

    public final WeakReference<View> getDestView() {
        return this.destView;
    }

    public final HashSet<String> getFilterIdRecords() {
        return this.filterIdRecords;
    }

    public final jm.a<List<q>> getGoodTypes() {
        return this.goodTypes;
    }

    public final HashSet<String> getIdRecords() {
        return this.idRecords;
    }

    public final StoreV2ProductListResponseVO getInitialData() {
        return this.initialData;
    }

    public final jm.a<LayoutTypes> getLayoutType() {
        return this.layoutType;
    }

    public final QLiveData<LoadStatus> getLoadStatus() {
        return this.loadStatus;
    }

    public final jm.a<Integer> getMmRvScrollY() {
        return this.mmRvScrollY;
    }

    public final Function1<Integer, Unit> getMyCartListener() {
        return this.myCartListener;
    }

    public final boolean getObserveFlag() {
        return this.observeFlag;
    }

    public final String getPageParams() {
        return this.pageParams;
    }

    public final jm.a<rg.a<Unit>> getRefreshAction() {
        return this.refreshAction;
    }

    public final boolean getReportFlag() {
        return this.reportFlag;
    }

    public final StoreV2RequestParam getRequestParam() {
        return this.requestParam;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final jm.a<List<r>> getSortTypes() {
        return this.sortTypes;
    }

    public final c getTagPools() {
        return this.tagPools;
    }

    public final boolean isExchangeLayout() {
        return this.isExchangeLayout;
    }

    public static final /* synthetic */ boolean access$getLayoutSet$p(ShopAggregatePageProductViewModel r0) {
        return r0.layoutSet;
    }

    public static final /* synthetic */ LiveData access$makeLivePageList(ShopAggregatePageProductViewModel r0) {
        return r0.makeLivePageList();
    }

    private final LayoutTypes getRealLayoutType(Integer r4) {
        LayoutTypes r0 = LayoutTypes.RECYCLER_VIEW_ITEM_SINGLE;
        int r1 = r0.getType();
        if (r4 != null) goto L6;
    L8:
        r0 = LayoutTypes.RECYCLER_VIEW_ITEM_DOUBLE;
        r0.getType();
        if (r4 == null) goto L12;
        r4.intValue();
    L12:
        return r0;
    L6:
        if (r4.intValue() != r1) goto L8;
        goto L8
    }

    private final void initEventParams(String r4) {
        if (isStoreParamInit() == true) goto L5;
        return;
    L5:
        ShopAggregateParam r0 = this.storeParam;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("storeParam");
    L8:
        Pair<String, String>[] r5 = com.bytedance.android.shopping.store.aggregate.viewmodel.a.a(r0, r4);
        initEventContext((Pair[]) Arrays.copyOf(r5, r5.length));
        ShopAggregateParam r6 = this.storeParam;
        if (r6 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("storeParam");
    L12:
        if (Intrinsics.areEqual(r6.getPageName(), "classification_secondary_page") == false) goto L14;
        appendEventParams(new Pair[]{TuplesKt.to("source_page", "store_page")});
    L14:
        ShopAggregateParam r7 = this.storeParam;
        if (r7 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("storeParam");
    L17:
        Intrinsics.checkNotNullParameter(r7, "storeParam");
        appendEventParams((Pair[]) Arrays.copyOf(z.b(r7.getShopId(), r7.getSecShopId()), 2));
    }

    private final void setLayoutTypeIfNeedOnce(Integer r2) {
        LayoutTypes r3 = getRealLayoutType(r2);
        if (((LayoutTypes) this.layoutType.getValue()) == r3) goto L6;
        this.layoutType.c(r3);
        return;
    }

    public final void refreshByFilter(String r2) {
        this.requestParam.setSelectParams(r2);
        refresh();
    }

    public final void setDestView(WeakReference<View> r1) {
        this.destView = r1;
    }

    public final void setExchangeLayout(boolean r1) {
        this.isExchangeLayout = r1;
    }

    public final void setInitialData(StoreV2ProductListResponseVO r1) {
        this.initialData = r1;
    }

    public final void setMyCartListener(Function1<? super Integer, Unit> r1) {
        this.myCartListener = r1;
    }

    public final void setObserveFlag(boolean r1) {
        this.observeFlag = r1;
    }

    public final void setPageParams(String r1) {
        this.pageParams = r1;
    }

    public final void setReportFlag(boolean r1) {
        this.reportFlag = r1;
    }

    public final void setStoreParam(ShopAggregateParam r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.storeParam = r2;
    }

    public static final /* synthetic */ void access$setLayoutSet$p(ShopAggregatePageProductViewModel r0, boolean r1) {
        r0.layoutSet = r1;
    }

    public static final /* synthetic */ void access$setLayoutTypeIfNeedOnce(ShopAggregatePageProductViewModel r0, Integer r1) {
        r0.setLayoutTypeIfNeedOnce(r1);
    }

    public final void init(ShopAggregateParam r4, StoreV2ProductListResponseVO r5) {
        Intrinsics.checkNotNullParameter(r4, "storeParam");
        this.storeParam = r4;
        StoreV2RequestParam r0 = this.requestParam;
        if (Intrinsics.areEqual(r4.getPageType(), AggregatePageTypes.FOLLOW_COUPON.getType()) == false) goto L5;
        String r1 = r4.getStoreAccountParam().getSecUserId();
        Intrinsics.checkNotNull(r1);
        r0.setSecAuthorId(r1);
    L7:
        if (Intrinsics.areEqual(r4.getPageType(), AggregatePageTypes.FULL_DISCOUNT.getType()) == false) goto L9;
        r0.setSelectParams(getTagId());
    L9:
        r0.setStore(r4.isV3Store());
        r0.setTmpId(r4.getProductBasicRequestParam().getTmpId());
        r0.setToken(r4.getProductBasicRequestParam().getToken());
        r0.setCustom(r4.getProductBasicRequestParam().isCustom());
        r0.setEntrances(r4.getProductBasicRequestParam().getEntrances());
        r0.setPassThroughParams(r4.getPassThroughParams());
        if (r4.getShowAddCart() == false) goto L12;
        r0.setMaterialId(null);
        r0.setCustomIds(r4.getProductBasicRequestParam().getMaterialId());
        r0.setCustomIdType(Integer.valueOf(CustomIdTypes.MaterialId.getType()));
    L13:
        r0.setExtraParamMap(r4.getProductBasicRequestParam().getExtraParamMap());
        r0.setCursor(Long.valueOf(r4.getProductBasicRequestParam().getCursor()));
        r0.setPageParam(r4.getPageParams());
        this.initialData = r5;
        this.pageParams = r4.getPageParams();
        if (Intrinsics.areEqual(r4.getPageName(), "classification_secondary_page") == false) goto L16;
        this.reportFlag = true;
    L16:
        initDataSource();
        initEventParams(r4.getEntranceInfo());
        return;
    L12:
        r0.setMaterialId(r4.getProductBasicRequestParam().getMaterialId());
        r0.setCustomIds(r4.getProductBasicRequestParam().getCustomIds());
        r0.setCustomIdType(r4.getProductBasicRequestParam().getCustomIdType());
        goto L13
    L5:
        r0.setSecShopId(r4.getSecShopId());
        goto L7
    }

    public final void refreshBySortAndSortType(Long r2, Integer r3) {
        this.requestParam.setSort(r3);
        this.requestParam.setSortType(r2);
        refresh();
    }
}
