package com.bytedance.android.shopping.store.search.viewmodel;

import android.view.View;
import androidx.lifecycle.LiveData;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.core.arch.viewmodel.BaseViewModel;
import com.bytedance.android.ec.store.common.param.StoreV2RequestParam;
import com.bytedance.android.ec.store.product.holder.LayoutTypes;
import com.bytedance.android.ec.store.repository.vo.StoreV2ProductItemVO;
import com.bytedance.android.ec.store.repository.vo.StoreV2ProductListResponseVO;
import com.bytedance.android.ec.store.repository.vo.p;
import com.bytedance.android.ec.store.repository.vo.q;
import com.bytedance.android.ec.store.repository.vo.r;
import com.bytedance.android.ec.store.search.datasource.SearchResultDataSourceFactory;
import com.bytedance.android.ec.store.setting.SettingKeys;
import com.bytedance.android.ec.store.shopping.paging.LoadStatus;
import com.bytedance.android.shopping.store.search.datasource.ShopSearchDataSourceFactory;
import com.bytedance.android.shopping.store.search.router.ECShopSearchParam;
import com.bytedance.apm.constant.UploadTypeInf;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import s83.f;
import s83.g;
import xm.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000Ô\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\t¢\u0006\u0006\b\u0090\u0001\u0010\u0091\u0001J\u0014\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0019\u0010\n\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J \u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0017\u001a\u00020\u0016J\u0006\u0010\u0019\u001a\u00020\u0006J!\u0010\u001d\u001a\u00020\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u001d\u0010\u001eJ\u0006\u0010 \u001a\u00020\u001fJ\u0006\u0010!\u001a\u00020\u0006J\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020#0\"R\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0014\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0017\u0010+\u001a\u00020*8\u0006¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R$\u0010\u0015\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001d\u00106\u001a\b\u0012\u0004\u0012\u000205048\u0006¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109R#\u0010=\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020<0;0:8\u0006¢\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@R#\u0010B\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020A0;0:8\u0006¢\u0006\f\n\u0004\bB\u0010>\u001a\u0004\bC\u0010@R%\u0010E\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060D0:8\u0006¢\u0006\f\n\u0004\bE\u0010>\u001a\u0004\bF\u0010@R#\u0010G\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160D0:8\u0006¢\u0006\f\n\u0004\bG\u0010>\u001a\u0004\bH\u0010@R\u001d\u0010I\u001a\b\u0012\u0004\u0012\u00020\u001f0:8\u0006¢\u0006\f\n\u0004\bI\u0010>\u001a\u0004\bJ\u0010@R\u0016\u0010\u0017\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010KR\"\u0010L\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bL\u0010K\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\u0017\u0010P\u001a\u00020\u001f8\u0006¢\u0006\f\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010SR'\u0010V\u001a\u0012\u0012\u0004\u0012\u00020\u001f0Tj\b\u0012\u0004\u0012\u00020\u001f`U8\u0006¢\u0006\f\n\u0004\bV\u0010W\u001a\u0004\bX\u0010YR?\u0010^\u001a\u001f\u0012\u0013\u0012\u00110\b¢\u0006\f\b[\u0012\b\b\\\u0012\u0004\b\b(]\u0012\u0004\u0012\u00020\u0006\u0018\u00010Z8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b^\u0010_\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR\u001d\u0010e\u001a\b\u0012\u0004\u0012\u00020d0:8\u0006¢\u0006\f\n\u0004\be\u0010>\u001a\u0004\bf\u0010@R$\u0010h\u001a\u0004\u0018\u00010g8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bh\u0010i\u001a\u0004\bj\u0010k\"\u0004\bl\u0010mR\"\u0010n\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bn\u0010K\u001a\u0004\bo\u0010M\"\u0004\bp\u0010OR\"\u0010q\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bq\u0010K\u001a\u0004\br\u0010M\"\u0004\bs\u0010OR\u0017\u0010u\u001a\u00020t8\u0006¢\u0006\f\n\u0004\bu\u0010v\u001a\u0004\bw\u0010xR\u0016\u0010z\u001a\u00020y8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bz\u0010{R0\u0010|\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00028\u0006@\u0006X\u0086.¢\u0006\u0014\n\u0004\b|\u0010}\u001a\u0004\b~\u0010\u007f\"\u0006\b\u0080\u0001\u0010\u0081\u0001R(\u0010\u0082\u0001\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060D0:8\u0006¢\u0006\u000e\n\u0005\b\u0082\u0001\u0010>\u001a\u0005\b\u0083\u0001\u0010@R,\u0010\u0085\u0001\u001a\u0005\u0018\u00010\u0084\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0085\u0001\u0010\u0086\u0001\u001a\u0006\b\u0087\u0001\u0010\u0088\u0001\"\u0006\b\u0089\u0001\u0010\u008a\u0001R \u0010\u008b\u0001\u001a\b\u0012\u0004\u0012\u00020\r0:8\u0006¢\u0006\u000e\n\u0005\b\u008b\u0001\u0010>\u001a\u0005\b\u008c\u0001\u0010@R\u0018\u0010\u008d\u0001\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u008d\u0001\u0010KR&\u0010\u008e\u0001\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u008e\u0001\u0010K\u001a\u0005\b\u008e\u0001\u0010M\"\u0005\b\u008f\u0001\u0010O¨\u0006\u0092\u0001"}, d2 = {"Lcom/bytedance/android/shopping/store/search/viewmodel/ShopSearchFragmentProductViewModel;", "Lcom/bytedance/android/ec/core/arch/viewmodel/BaseViewModel;", "Landroidx/lifecycle/LiveData;", "Landroidx/paging/PagedList;", "Len/b;", "makeLivePageList", "", "initDataSource", "", "typeFromServer", "setLayoutTypeIfNeedOnce", "(Ljava/lang/Integer;)V", "fromServer", "Lcom/bytedance/android/ec/store/product/holder/LayoutTypes;", "getRealLayoutType", "(Ljava/lang/Integer;)Lcom/bytedance/android/ec/store/product/holder/LayoutTypes;", "Lcom/bytedance/android/ec/store/repository/vo/StoreV2ProductListResponseVO;", "response", "getVideoData", "Lcom/bytedance/android/shopping/store/search/router/ECShopSearchParam;", "searchParam", "initialData", "", "showSortBar", "init", "refresh", "", "sortType", "sort", "refreshBySortAndSortType", "(Ljava/lang/Long;Ljava/lang/Integer;)V", "", "getPublicityText", "stopPlayVideo", "", "", "getAdParams", "Lcom/bytedance/android/shopping/store/search/router/ECShopSearchParam;", "getSearchParam", "()Lcom/bytedance/android/shopping/store/search/router/ECShopSearchParam;", "setSearchParam", "(Lcom/bytedance/android/shopping/store/search/router/ECShopSearchParam;)V", "Lcom/bytedance/android/ec/store/common/param/StoreV2RequestParam;", "requestParam", "Lcom/bytedance/android/ec/store/common/param/StoreV2RequestParam;", "getRequestParam", "()Lcom/bytedance/android/ec/store/common/param/StoreV2RequestParam;", "Lcom/bytedance/android/ec/store/repository/vo/StoreV2ProductListResponseVO;", "getInitialData", "()Lcom/bytedance/android/ec/store/repository/vo/StoreV2ProductListResponseVO;", "setInitialData", "(Lcom/bytedance/android/ec/store/repository/vo/StoreV2ProductListResponseVO;)V", "Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QLiveData;", "Lcom/bytedance/android/ec/store/shopping/paging/LoadStatus;", "loadStatus", "Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QLiveData;", "getLoadStatus", "()Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QLiveData;", "Ljm/a;", "", "Lcom/bytedance/android/ec/store/repository/vo/q;", "goodTypes", "Ljm/a;", "getGoodTypes", "()Ljm/a;", "Lcom/bytedance/android/ec/store/repository/vo/r;", "sortTypes", "getSortTypes", "Lrg/a;", "updateVideoDataAction", "getUpdateVideoDataAction", "playVideoAction", "getPlayVideoAction", "materialTitle", "getMaterialTitle", "Z", "isPlayingVideo", "()Z", "setPlayingVideo", "(Z)V", "sessionId", "Ljava/lang/String;", "getSessionId", "()Ljava/lang/String;", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "idRecords", "Ljava/util/HashSet;", "getIdRecords", "()Ljava/util/HashSet;", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", UploadTypeInf.COUNT, "myCartListener", "Lkotlin/jvm/functions/Function1;", "getMyCartListener", "()Lkotlin/jvm/functions/Function1;", "setMyCartListener", "(Lkotlin/jvm/functions/Function1;)V", "Lcom/bytedance/android/ec/store/repository/vo/p;", "cartsInfo", "getCartsInfo", "Landroid/view/View;", "destView", "Landroid/view/View;", "getDestView", "()Landroid/view/View;", "setDestView", "(Landroid/view/View;)V", "observeFlag", "getObserveFlag", "setObserveFlag", "reportFlag", "getReportFlag", "setReportFlag", "Lxm/c;", "tagPools", "Lxm/c;", "getTagPools", "()Lxm/c;", "Lcom/bytedance/android/ec/store/search/datasource/SearchResultDataSourceFactory;", "dataSourceFactory", "Lcom/bytedance/android/ec/store/search/datasource/SearchResultDataSourceFactory;", "products", "Landroidx/lifecycle/LiveData;", "getProducts", "()Landroidx/lifecycle/LiveData;", "setProducts", "(Landroidx/lifecycle/LiveData;)V", "refreshAction", "getRefreshAction", "Lcom/bytedance/android/ec/store/repository/vo/StoreV2ProductItemVO;", "currentPlayingItem", "Lcom/bytedance/android/ec/store/repository/vo/StoreV2ProductItemVO;", "getCurrentPlayingItem", "()Lcom/bytedance/android/ec/store/repository/vo/StoreV2ProductItemVO;", "setCurrentPlayingItem", "(Lcom/bytedance/android/ec/store/repository/vo/StoreV2ProductItemVO;)V", "layoutType", "getLayoutType", "layoutSet", "isExchangeLayout", "setExchangeLayout", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShopSearchFragmentProductViewModel extends BaseViewModel {
    private final jm.a<p> cartsInfo;
    private StoreV2ProductItemVO currentPlayingItem;
    private SearchResultDataSourceFactory dataSourceFactory;
    private View destView;
    private final jm.a<List<q>> goodTypes;
    private final HashSet<String> idRecords;
    private StoreV2ProductListResponseVO initialData;
    private boolean isExchangeLayout;
    private boolean isPlayingVideo;
    private boolean layoutSet;
    private final jm.a<LayoutTypes> layoutType;
    private final QLiveData<LoadStatus> loadStatus;
    private final jm.a<String> materialTitle;
    private Function1<? super Integer, Unit> myCartListener;
    private boolean observeFlag;
    private final jm.a<rg.a<Boolean>> playVideoAction;
    public LiveData<PagedList<en.b>> products;
    private final jm.a<rg.a<Unit>> refreshAction;
    private boolean reportFlag;
    private final StoreV2RequestParam requestParam;
    public ECShopSearchParam searchParam;
    private final String sessionId;
    private boolean showSortBar;
    private final jm.a<List<r>> sortTypes;
    private final c tagPools;
    private final jm.a<rg.a<Unit>> updateVideoDataAction;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ ShopSearchFragmentProductViewModel a;

        public a(ShopSearchFragmentProductViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Boolean r4 = (Boolean) r3;
            this.a.getUpdateVideoDataAction().c(new rg.a(null));
        }
    }

    public static final class b<T> implements Consumer {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final void accept(Object r1) {
            ((Throwable) r1).printStackTrace();
        }
    }

    public ShopSearchFragmentProductViewModel() {
        super(null, null, 3, null);
        this.requestParam = new StoreV2RequestParam();
        this.loadStatus = new QLiveData();
        this.goodTypes = new jm.a(7);
        this.sortTypes = new jm.a(7);
        this.updateVideoDataAction = new jm.a(7);
        this.playVideoAction = new jm.a(7);
        this.materialTitle = new jm.a(7);
        this.showSortBar = true;
        this.sessionId = UUID.randomUUID().toString();
        this.idRecords = new HashSet();
        this.cartsInfo = new jm.a(7);
        this.tagPools = new c();
        this.refreshAction = new jm.a(7);
        jm.a<LayoutTypes> r0 = new jm.a(7);
        r0.setValue(LayoutTypes.RECYCLER_VIEW_ITEM_DOUBLE);
        Unit r1 = Unit.INSTANCE;
        this.layoutType = r0;
    }

    public final Map<String, Object> getAdParams() {
        Pair[] r0 = new Pair[6];
        ECShopSearchParam r1 = this.searchParam;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("searchParam");
    L5:
        r0[0] = TuplesKt.to("shop_id", r1.getShopId());
        r0[1] = TuplesKt.to("category", "umeng");
        ECShopSearchParam r2 = this.searchParam;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("searchParam");
    L8:
        r0[2] = TuplesKt.to("room_id", r2.getRoomId());
        ECShopSearchParam r3 = this.searchParam;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("searchParam");
    L11:
        r0[3] = TuplesKt.to("anchor_id", r3.getAnchorId());
        String r4 = this.requestParam.getSearchId();
        if (r4 != null) goto L14;
        r4 = "";
    L14:
        r0[4] = TuplesKt.to("search_id", r4);
        ECShopSearchParam r5 = this.searchParam;
        if (r5 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("searchParam");
    L17:
        r0[5] = TuplesKt.to("search_keyword", r5.getSearchKeyword());
        return MapsKt.mutableMapOf(r0);
    }

    private final void initDataSource() {
        StoreV2RequestParam r1 = this.requestParam;
        ECShopSearchParam r2 = this.searchParam;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("searchParam");
    L5:
        this.dataSourceFactory = new ShopSearchDataSourceFactory(r1, r2, this.goodTypes, this.sortTypes, this.loadStatus, this.materialTitle, this, new AnonymousClass1(this));
        this.products = makeLivePageList();
    }

    private final LiveData<PagedList<en.b>> makeLivePageList() {
        PagedList.Config.Builder r0 = new PagedList.Config.Builder();
        r0.setPageSize(this.requestParam.getSize());
        r0.setInitialLoadSizeHint(this.requestParam.getSize());
        r0.setPrefetchDistance(this.requestParam.getSize());
        r0.setEnablePlaceholders(false);
        PagedList.Config r1 = r0.build();
        SearchResultDataSourceFactory r2 = this.dataSourceFactory;
        if (r2 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("dataSourceFactory");
    L6:
        return new LivePagedListBuilder(r2, r1).build();
    }

    public final LiveData<PagedList<en.b>> getProducts() {
        LiveData<PagedList<en.b>> r0 = this.products;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("products");
    L5:
        return r0;
    }

    public final ECShopSearchParam getSearchParam() {
        ECShopSearchParam r0 = this.searchParam;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("searchParam");
    L5:
        return r0;
    }

    public final void refresh() {
        this.requestParam.setGoodsType(2L);
        this.refreshAction.setValue(new rg.a(null));
        SearchResultDataSourceFactory r0 = this.dataSourceFactory;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("dataSourceFactory");
    L5:
        r0.a();
        this.idRecords.clear();
        this.requestParam.setHasMore(true);
        stopPlayVideo();
    }

    public final void stopPlayVideo() {
        StoreV2ProductItemVO r0 = this.currentPlayingItem;
        if (r0 == null) goto L8;
        QLiveData r1 = r0.q;
        if (r1 == null) goto L9;
        r1.g(new StoreV2ProductItemVO.b(0));
        return;
    L9:
        return;
    }

    public final String getPublicityText() {
        return StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(SettingKeys.getSTORE_V2_PUBLICITY_TEXT(), "newline_placeholder", "\n", false, 4, null), "\\n", "\n", false, 4, null), "name_placeholder", "", false, 4, null);
    }

    public final jm.a<p> getCartsInfo() {
        return this.cartsInfo;
    }

    public final StoreV2ProductItemVO getCurrentPlayingItem() {
        return this.currentPlayingItem;
    }

    public final View getDestView() {
        return this.destView;
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

    public final jm.a<String> getMaterialTitle() {
        return this.materialTitle;
    }

    public final Function1<Integer, Unit> getMyCartListener() {
        return this.myCartListener;
    }

    public final boolean getObserveFlag() {
        return this.observeFlag;
    }

    public final jm.a<rg.a<Boolean>> getPlayVideoAction() {
        return this.playVideoAction;
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

    public final jm.a<rg.a<Unit>> getUpdateVideoDataAction() {
        return this.updateVideoDataAction;
    }

    public final boolean isExchangeLayout() {
        return this.isExchangeLayout;
    }

    public final boolean isPlayingVideo() {
        return this.isPlayingVideo;
    }

    public static final /* synthetic */ boolean access$getLayoutSet$p(ShopSearchFragmentProductViewModel r0) {
        return r0.layoutSet;
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

    private final void getVideoData(StoreV2ProductListResponseVO r3) {
        List r4 = r3.getProducts();
        ArrayList r0 = new ArrayList();
        Iterator r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        String r1 = ((StoreV2ProductItemVO) r5.next()).l;
        if (r1 == null) goto L4;
        r0.add(r1);
        goto L4
    L8:
        Observable r2 = null;
        if ((!r0.isEmpty()) == true) goto L12;
        r0 = null;
    L12:
        if (r0 != null) goto L14;
        return;
    L14:
        boolean r6 = ECServiceManager.a;
        f r7 = ((g) ECServiceManager.c(g.class)).p();
        if (r7 == null) goto L17;
        r2 = r7.l(r0);
    L17:
        com.bytedance.android.ec.core.async.a.a(Single.fromObservable(r2).subscribeOn(Schedulers.io()).observeOn(Schedulers.io()).subscribe(new a(this), b.a), this);
    }

    private final void setLayoutTypeIfNeedOnce(Integer r2) {
        LayoutTypes r3 = getRealLayoutType(r2);
        if (((LayoutTypes) this.layoutType.getValue()) == r3) goto L6;
        this.layoutType.c(r3);
        return;
    }

    public final void setCurrentPlayingItem(StoreV2ProductItemVO r1) {
        this.currentPlayingItem = r1;
    }

    public final void setDestView(View r1) {
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

    public final void setPlayingVideo(boolean r1) {
        this.isPlayingVideo = r1;
    }

    public final void setProducts(LiveData<PagedList<en.b>> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.products = r2;
    }

    public final void setReportFlag(boolean r1) {
        this.reportFlag = r1;
    }

    public final void setSearchParam(ECShopSearchParam r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.searchParam = r2;
    }

    public static final /* synthetic */ void access$getVideoData(ShopSearchFragmentProductViewModel r0, StoreV2ProductListResponseVO r1) {
        r0.getVideoData(r1);
    }

    public static final /* synthetic */ void access$setLayoutSet$p(ShopSearchFragmentProductViewModel r0, boolean r1) {
        r0.layoutSet = r1;
    }

    public static final /* synthetic */ void access$setLayoutTypeIfNeedOnce(ShopSearchFragmentProductViewModel r0, Integer r1) {
        r0.setLayoutTypeIfNeedOnce(r1);
    }

    public final void refreshBySortAndSortType(Long r2, Integer r3) {
        this.requestParam.setSort(r3);
        this.requestParam.setSortType(r2);
        refresh();
    }

    public final void init(ECShopSearchParam r3, StoreV2ProductListResponseVO r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r3, "searchParam");
        this.searchParam = r3;
        this.initialData = r4;
        this.showSortBar = r5;
        StoreV2RequestParam r6 = this.requestParam;
        r6.setStore(true);
        r6.setSecShopId(r3.getSecShopId());
        r6.setTmpId(r3.getProductBasicRequestParam().getTmpId());
        r6.setToken(r3.getProductBasicRequestParam().getToken());
        r6.setMaterialId(r3.getProductBasicRequestParam().getMaterialId());
        r6.setCustom(r3.getProductBasicRequestParam().isCustom());
        r6.setEntrances(r3.getProductBasicRequestParam().getEntrances());
        r6.setCustomIds(r3.getProductBasicRequestParam().getCustomIds());
        r6.setCustomIdType(r3.getProductBasicRequestParam().getCustomIdType());
        r6.setCursor(Long.valueOf(r3.getProductBasicRequestParam().getCursor()));
        r6.setKeyWord(r3.getSearchKeyword());
        r6.setHistory(r3.isHistory());
        r6.setPassThroughParams(r3.getPassThroughParams());
        r6.setAuthorID(r3.getAuthorId());
        r6.setEntranceInfo(r3.getEntranceInfo());
        Integer r7 = r3.getFollowStatus();
        if (r7 != null) goto L6;
    L8:
        String r8 = CommentScene.COMMENTSCENE_NO_AWEME;
    L9:
        r6.setFollowStatus(r8);
        r6.setFromSug(r3.isFromSug());
        r6.setGroupId(r3.getGroupId());
        r6.setSearchSource(r3.getSearchSource());
        initDataSource();
        this.requestParam.setGoodsType(2L);
        return;
    L6:
        if (r7.intValue() != (-1)) goto L8;
        r8 = "0";
        goto L9
    }
}
