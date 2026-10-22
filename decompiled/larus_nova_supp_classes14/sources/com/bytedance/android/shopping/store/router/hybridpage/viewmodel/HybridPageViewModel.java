package com.bytedance.android.shopping.store.router.hybridpage.viewmodel;

import android.content.Context;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListDTO;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListSectionDTO;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListStyleDTO;
import com.bytedance.android.ec.hybrid.list.entity.k;
import com.bytedance.android.ec.store.common.param.StoreAccountParam;
import com.bytedance.android.ec.store.product.holder.LayoutTypes;
import com.bytedance.android.ec.store.shopping.paging.LoadStatus;
import com.bytedance.android.shopping.store.home.presenter.b4;
import com.bytedance.android.shopping.store.home.view.LottieAnimationViewWithPlayCount;
import com.bytedance.android.shopping.store.mall.follows.basic.BaseFollowStoreViewModel;
import com.bytedance.android.shopping.store.router.hybridpage.setting.HybridPageConfigSetting;
import com.bytedance.android.shopping.store.router.hybridpage.slice.HybridPageSlcTemplateManager;
import com.bytedance.android.shopping.store.router.hybridpage.slice.SliceProductCardData;
import com.bytedance.android.shopping.store.search.router.ECShopSearchParam;
import com.bytedance.android.shopping.store.settings.ECShopABSettings;
import com.bytedance.android.shopping.store.slicecard.SliceItemType;
import com.bytedance.android.shopping.store.slicecard.dto.ShopSliceItemConfig;
import com.bytedance.android.shopping.store.slicecard.dto.SliceTemplate;
import com.bytedance.android.shopping.store.slicecard.dto.SliceTemplateType;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import com.bytedance.commerce.base.json.JsonDslUtilKt;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import jm.a;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import vj3.b;
import xm.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000Ð\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\t¢\u0006\u0006\b\u009f\u0001\u0010 \u0001J\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bJ\b\u0010\f\u001a\u0004\u0018\u00010\tJ\u0018\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u000fJ\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\bJ\u0010\u0010\u0015\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013J.\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00162\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00162\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016J\u0006\u0010\u001b\u001a\u00020\u0006J \u0010\u001d\u001a\u00020\u00062\u0018\b\u0002\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\bJ\u0006\u0010\u001e\u001a\u00020\u0006J\b\u0010\u001f\u001a\u00020\u0006H\u0014R\u001b\u0010%\u001a\u00020 8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001b\u0010*\u001a\u00020&8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\"\u001a\u0004\b(\u0010)R\u0017\u0010,\u001a\u00020+8\u0006¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u0017\u00100\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R$\u00104\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R,\u0010<\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010;\u0018\u00010:8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR*\u0010D\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010C0B8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR0\u0010K\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010J8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bK\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR$\u0010Q\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bQ\u00101\u001a\u0004\bR\u00103\"\u0004\bS\u0010TR$\u0010U\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bU\u00101\u001a\u0004\bV\u00103\"\u0004\bW\u0010TR(\u0010Z\u001a\b\u0012\u0004\u0012\u00020Y0X8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bZ\u0010[\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R$\u0010`\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b`\u00101\u001a\u0004\ba\u00103\"\u0004\bb\u0010TR(\u0010d\u001a\b\u0012\u0004\u0012\u00020c0B8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bd\u0010E\u001a\u0004\be\u0010G\"\u0004\bf\u0010IR$\u0010h\u001a\u0004\u0018\u00010g8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bh\u0010i\u001a\u0004\bj\u0010k\"\u0004\bl\u0010mR\u001d\u0010o\u001a\b\u0012\u0004\u0012\u00020n0B8\u0006¢\u0006\f\n\u0004\bo\u0010E\u001a\u0004\bp\u0010GR\u001d\u0010q\u001a\b\u0012\u0004\u0012\u00020n0B8\u0006¢\u0006\f\n\u0004\bq\u0010E\u001a\u0004\br\u0010GR2\u0010u\u001a\u0012\u0012\u0004\u0012\u00020\t0sj\b\u0012\u0004\u0012\u00020\t`t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bu\u0010v\u001a\u0004\bw\u0010x\"\u0004\by\u0010zR&\u0010|\u001a\u0004\u0018\u00010{8\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b|\u0010}\u001a\u0004\b~\u0010\u007f\"\u0006\b\u0080\u0001\u0010\u0081\u0001R+\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0082\u0001\u0010\u0083\u0001\u001a\u0006\b\u0084\u0001\u0010\u0085\u0001\"\u0006\b\u0086\u0001\u0010\u0087\u0001R(\u0010\u0088\u0001\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0088\u0001\u00101\u001a\u0005\b\u0089\u0001\u00103\"\u0005\b\u008a\u0001\u0010TR1\u0010\u008d\u0001\u001a\n\u0012\u0005\u0012\u00030\u008c\u00010\u008b\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u008d\u0001\u0010\u008e\u0001\u001a\u0006\b\u008f\u0001\u0010\u0090\u0001\"\u0006\b\u0091\u0001\u0010\u0092\u0001R,\u0010\u0094\u0001\u001a\u0005\u0018\u00010\u0093\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0094\u0001\u0010\u0095\u0001\u001a\u0006\b\u0096\u0001\u0010\u0097\u0001\"\u0006\b\u0098\u0001\u0010\u0099\u0001R6\u0010\u009a\u0001\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u009a\u0001\u0010L\u001a\u0005\b\u009b\u0001\u0010N\"\u0005\b\u009c\u0001\u0010PR\u001b\u0010\u009d\u0001\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009d\u0001\u0010\u009e\u0001¨\u0006¡\u0001"}, d2 = {"Lcom/bytedance/android/shopping/store/router/hybridpage/viewmodel/HybridPageViewModel;", "Lcom/bytedance/android/shopping/store/router/hybridpage/viewmodel/HybridPageBaseViewModel;", "", "hasDiscountSelected", "Lcom/bytedance/android/shopping/store/home/presenter/b4;", "listener", "", "setLynxCardEventListener", "", "", "", "getAdParams", "getPassThroughLogData", "Landroid/content/Context;", "context", "Lvj3/b;", "configSetting", "initData", "buildRouterQuery", "Lcom/bytedance/android/ec/hybrid/list/entity/dto/ECHybridListDTO;", "dto", "appendHybridListDTO", "", "Lcom/bytedance/android/ec/hybrid/list/entity/dto/ECHybridListSectionDTO;", "originSections", "addSections", "mergeSections", "clearHybridListDTO", "params", "reportInitializeError", "initEventParams", "onCleared", "Lcom/bytedance/android/shopping/store/slicecard/b;", "sliceService$delegate", "Lkotlin/Lazy;", "getSliceService", "()Lcom/bytedance/android/shopping/store/slicecard/b;", "sliceService", "Lcom/bytedance/android/shopping/store/router/hybridpage/slice/b;", "slcCardFactory$delegate", "getSlcCardFactory", "()Lcom/bytedance/android/shopping/store/router/hybridpage/slice/b;", "slcCardFactory", "Lxm/c;", "multiLeveViewCache", "Lxm/c;", "getMultiLeveViewCache", "()Lxm/c;", "sceneId", "Ljava/lang/String;", "getSceneId", "()Ljava/lang/String;", "sliceConfigSetting", "Lvj3/b;", "getSliceConfigSetting", "()Lvj3/b;", "setSliceConfigSetting", "(Lvj3/b;)V", "Ljava/lang/ref/WeakReference;", "Lcom/bytedance/android/shopping/store/home/view/LottieAnimationViewWithPlayCount;", "cartAnimationView", "Ljava/lang/ref/WeakReference;", "getCartAnimationView", "()Ljava/lang/ref/WeakReference;", "setCartAnimationView", "(Ljava/lang/ref/WeakReference;)V", "Ljm/a;", "Lorg/json/JSONObject;", "configJson", "Ljm/a;", "getConfigJson", "()Ljm/a;", "setConfigJson", "(Ljm/a;)V", "", "routeParams", "Ljava/util/Map;", "getRouteParams", "()Ljava/util/Map;", "setRouteParams", "(Ljava/util/Map;)V", "pageCardUrl", "getPageCardUrl", "setPageCardUrl", "(Ljava/lang/String;)V", "configJsonUrl", "getConfigJsonUrl", "setConfigJsonUrl", "Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QLiveData;", "Lcom/bytedance/android/ec/store/shopping/paging/LoadStatus;", "loadStatus", "Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QLiveData;", "getLoadStatus", "()Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QLiveData;", "setLoadStatus", "(Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QLiveData;)V", "loadNoMoreText", "getLoadNoMoreText", "setLoadNoMoreText", "Lcom/bytedance/android/ec/store/product/holder/LayoutTypes;", "layoutType", "getLayoutType", "setLayoutType", "Lcom/bytedance/android/shopping/store/router/hybridpage/slice/SliceProductCardData;", "sliceProductCardData", "Lcom/bytedance/android/shopping/store/router/hybridpage/slice/SliceProductCardData;", "getSliceProductCardData", "()Lcom/bytedance/android/shopping/store/router/hybridpage/slice/SliceProductCardData;", "setSliceProductCardData", "(Lcom/bytedance/android/shopping/store/router/hybridpage/slice/SliceProductCardData;)V", "", "productViewsNum", "getProductViewsNum", "totalProductNum", "getTotalProductNum", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "idRecords", "Ljava/util/HashSet;", "getIdRecords", "()Ljava/util/HashSet;", "setIdRecords", "(Ljava/util/HashSet;)V", "Lcom/bytedance/android/ec/hybrid/list/entity/k;", "hybridListVO", "Lcom/bytedance/android/ec/hybrid/list/entity/k;", "getHybridListVO", "()Lcom/bytedance/android/ec/hybrid/list/entity/k;", "setHybridListVO", "(Lcom/bytedance/android/ec/hybrid/list/entity/k;)V", "hybridListDTO", "Lcom/bytedance/android/ec/hybrid/list/entity/dto/ECHybridListDTO;", "getHybridListDTO", "()Lcom/bytedance/android/ec/hybrid/list/entity/dto/ECHybridListDTO;", "setHybridListDTO", "(Lcom/bytedance/android/ec/hybrid/list/entity/dto/ECHybridListDTO;)V", "sourceBtmToken", "getSourceBtmToken", "setSourceBtmToken", "", "Lcom/bytedance/android/ec/store/repository/dto/c;", "selectButtons", "Ljava/util/List;", "getSelectButtons", "()Ljava/util/List;", "setSelectButtons", "(Ljava/util/List;)V", "Lcom/bytedance/android/shopping/store/search/router/ECShopSearchParam;", "searchParam", "Lcom/bytedance/android/shopping/store/search/router/ECShopSearchParam;", "getSearchParam", "()Lcom/bytedance/android/shopping/store/search/router/ECShopSearchParam;", "setSearchParam", "(Lcom/bytedance/android/shopping/store/search/router/ECShopSearchParam;)V", "routerQuery", "getRouterQuery", "setRouterQuery", "lynxCardEventListener", "Lcom/bytedance/android/shopping/store/home/presenter/b4;", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HybridPageViewModel extends HybridPageBaseViewModel {
    private WeakReference<LottieAnimationViewWithPlayCount> cartAnimationView;
    private a<JSONObject> configJson;
    private String configJsonUrl;
    private ECHybridListDTO hybridListDTO;
    private k hybridListVO;
    private HashSet<String> idRecords;
    private a<LayoutTypes> layoutType;
    private String loadNoMoreText;
    private QLiveData<LoadStatus> loadStatus;
    private b4 lynxCardEventListener;
    private final c multiLeveViewCache;
    private String pageCardUrl;
    private final a<Integer> productViewsNum;
    private Map<String, ? extends Object> routeParams;
    private Map<String, Object> routerQuery;
    private final String sceneId;
    private ECShopSearchParam searchParam;
    private List<com.bytedance.android.ec.store.repository.dto.c> selectButtons;
    private final Lazy slcCardFactory$delegate;
    private b sliceConfigSetting;
    private SliceProductCardData sliceProductCardData;
    private final Lazy sliceService$delegate;
    private String sourceBtmToken;
    private final a<Integer> totalProductNum;

    public HybridPageViewModel() {
        super(null, null, 3, null);
        this.sliceService$delegate = LazyKt.lazy(HybridPageViewModel$sliceService$2.INSTANCE);
        this.slcCardFactory$delegate = LazyKt.lazy(new HybridPageViewModel$slcCardFactory$2(this));
        this.multiLeveViewCache = new c();
        this.sceneId = UUID.randomUUID().toString();
        this.configJson = new a(7);
        this.loadStatus = new QLiveData();
        this.layoutType = new a(7);
        this.productViewsNum = new a(7);
        this.totalProductNum = new a(7);
        this.idRecords = new HashSet();
        this.selectButtons = new ArrayList();
    }

    public final void clearHybridListDTO() {
        this.hybridListDTO = null;
    }

    public final Map<String, Object> getAdParams() {
        Pair[] r0 = new Pair[2];
        SliceProductCardData r1 = this.sliceProductCardData;
        if (r1 == null) goto L5;
        String r2 = r1.getShopId();
    L6:
        if (r2 != null) goto L8;
        r2 = "";
    L8:
        r0[0] = TuplesKt.to("shop_id", r2);
        r0[1] = TuplesKt.to("category", "umeng");
        return MapsKt.mutableMapOf(r0);
    L5:
        r2 = null;
        goto L6
    }

    public final String getPassThroughLogData() {
        com.bytedance.commerce.base.json.a[] r0 = new com.bytedance.commerce.base.json.a[6];
        r0[0] = JsonDslUtilKt.d("store_type", "shop");
        SliceProductCardData r1 = this.sliceProductCardData;
        if (r1 == null) goto L5;
        String r2 = r1.getEntranceLocation();
    L6:
        String r3 = "";
        if (r2 != null) goto L9;
        r2 = "";
    L9:
        r0[1] = JsonDslUtilKt.d("product_source_page", r2);
        SliceProductCardData r4 = this.sliceProductCardData;
        if (r4 == null) goto L13;
        String r5 = r4.getStoreSourcePage();
        if (r5 == null) goto L13;
    L14:
        r0[2] = JsonDslUtilKt.d("store_source_page", r5);
        SliceProductCardData r6 = this.sliceProductCardData;
        if (r6 == null) goto L18;
        String r7 = r6.getStoreSourceMethod();
        if (r7 == null) goto L18;
    L19:
        r0[3] = JsonDslUtilKt.d("store_source_method", r7);
        SliceProductCardData r8 = this.sliceProductCardData;
        if (r8 == null) goto L25;
        String r9 = r8.getStoreGroupType();
        if (r9 == null) goto L25;
        r3 = r9;
    L25:
        r0[4] = JsonDslUtilKt.d("store_group_type", r3);
        r0[5] = JsonDslUtilKt.d(BaseFollowStoreViewModel.KEY_ECOM_SCENE_ID, "1003");
        return JsonDslUtilKt.a(r0).toString();
    L18:
        r7 = "";
    L13:
        r5 = "";
        goto L14
    L5:
        r2 = null;
        goto L6
    }

    public final com.bytedance.android.shopping.store.router.hybridpage.slice.b getSlcCardFactory() {
        return (com.bytedance.android.shopping.store.router.hybridpage.slice.b) this.slcCardFactory$delegate.getValue();
    }

    public final com.bytedance.android.shopping.store.slicecard.b getSliceService() {
        return (com.bytedance.android.shopping.store.slicecard.b) this.sliceService$delegate.getValue();
    }

    public final Map<String, Object> buildRouterQuery() {
        LinkedHashMap r0 = new LinkedHashMap();
        ECShopSearchParam r1 = this.searchParam;
        String r2 = "";
        if (r1 == null) goto L6;
        String r3 = r1.getSearchSource();
        if (r3 == null) goto L6;
    L7:
        r0.put("recent_search_type", r3);
        ECShopSearchParam r4 = this.searchParam;
        Integer r5 = null;
        if (r4 == null) goto L10;
        String r6 = r4.getSearchKeyword();
    L11:
        if (r6 != null) goto L13;
        r6 = "";
    L13:
        r0.put("inbound_search_keyword", r6);
        r0.put("inbound_search_placeholder", "");
        ECShopSearchParam r7 = this.searchParam;
        if (r7 == null) goto L16;
        String r8 = r7.getSourceBtmToken();
    L17:
        if (r8 != null) goto L19;
        r8 = "";
    L19:
        r0.put("source_btm_token", r8);
        ECShopSearchParam r9 = this.searchParam;
        if (r9 == null) goto L22;
        String r10 = r9.getSearchSource();
    L23:
        if (r10 != null) goto L25;
        r10 = "";
    L25:
        r0.put("shop_search_enter_method", r10);
        ECShopSearchParam r11 = this.searchParam;
        if (r11 == null) goto L28;
        String r12 = r11.getHotSearchIconType();
    L29:
        if (r12 != null) goto L31;
        r12 = "";
    L31:
        r0.put("hot_search_icon_type", r12);
        ECShopSearchParam r13 = this.searchParam;
        if (r13 == null) goto L35;
        Map<String, Object> r14 = r13.getUriParams();
        if (r14 == null) goto L35;
    L36:
        r0.putAll(r14);
        LinkedHashMap r15 = new LinkedHashMap();
        ECShopSearchParam r16 = this.searchParam;
        if (r16 == null) goto L39;
        String r17 = r16.getTempId();
    L40:
        if (r17 != null) goto L42;
        r17 = "";
    L42:
        r15.put("temp_id", r17);
        ECShopSearchParam r18 = this.searchParam;
        if (r18 == null) goto L45;
        String r19 = r18.getTabNameSecond();
    L46:
        if (r19 != null) goto L48;
        r19 = "";
    L48:
        r15.put("tab_name_second", r19);
        ECShopSearchParam r20 = this.searchParam;
        if (r20 == null) goto L51;
        String r21 = r20.getTabLabel();
    L52:
        if (r21 != null) goto L54;
        r21 = "";
    L54:
        r15.put("tab_label", r21);
        ECShopSearchParam r22 = this.searchParam;
        if (r22 == null) goto L57;
        String r23 = r22.getTabName();
    L58:
        if (r23 != null) goto L60;
        r23 = "";
    L60:
        r15.put("tab_name", r23);
        r0.putAll(r15);
        r0.put("track_extra_params", r15);
        ECShopSearchParam r24 = this.searchParam;
        if (r24 == null) goto L63;
        String r25 = r24.getShopId();
    L64:
        if (r25 != null) goto L66;
        r25 = "";
    L66:
        r0.put("shop_id", r25);
        ECShopSearchParam r26 = this.searchParam;
        if (r26 == null) goto L71;
        StoreAccountParam r27 = r26.getStoreAccountParam();
        if (r27 == null) goto L71;
        String r28 = r27.getUserId();
    L72:
        if (r28 != null) goto L74;
        r28 = "";
    L74:
        r0.put("anchor_id", r28);
        ECShopSearchParam r29 = this.searchParam;
        if (r29 == null) goto L77;
        Integer r30 = Integer.valueOf(r29.isFromAd());
    L78:
        r0.put("is_form_ad", r30);
        ECShopSearchParam r31 = this.searchParam;
        if (r31 == null) goto L81;
        String r32 = r31.getEnterFrom();
    L82:
        r0.put("enter_from", r32);
        ECShopSearchParam r33 = this.searchParam;
        if (r33 == null) goto L85;
        String r34 = r33.getSecShopId();
    L86:
        r0.put("sec_shop_id", r34);
        ECShopSearchParam r35 = this.searchParam;
        if (r35 == null) goto L89;
        Boolean r36 = Boolean.valueOf(r35.isPreview());
    L90:
        r0.put("is_enter_preview", r36);
        r0.put("brand_verified", "");
        ECShopSearchParam r37 = this.searchParam;
        if (r37 == null) goto L93;
        String r38 = r37.getRoomId();
    L94:
        r0.put("live_window_room_id", r38);
        ECShopSearchParam r39 = this.searchParam;
        if (r39 == null) goto L97;
        String r40 = r39.getEntranceInfo();
    L98:
        r0.put("entrance_info", r40);
        ECShopSearchParam r41 = this.searchParam;
        if (r41 == null) goto L101;
        String r42 = (String) r41.getPassThroughParam("pass_through_api");
    L102:
        if (r42 != null) goto L104;
        r42 = "";
    L104:
        r0.put("pass_through_api", r42);
        r0.put("track_extra_params", r15);
        r0.put("pre_enter_store_params", "");
        LinkedHashMap r43 = new LinkedHashMap();
        ECShopSearchParam r44 = this.searchParam;
        if (r44 == null) goto L107;
        boolean r45 = r44.isEcShare();
    L108:
        r43.put("is_ec_share", Boolean.valueOf(r45));
        ECShopSearchParam r46 = this.searchParam;
        if (r46 == null) goto L111;
        String r47 = r46.getShareContent();
    L112:
        if (r47 == null) goto L115;
        r2 = r47;
    L115:
        r43.put("share_content", r2);
        ECShopSearchParam r48 = this.searchParam;
        if (r48 == null) goto L118;
        String r49 = r48.getShareObject();
    L119:
        r0.put("share_object", r49);
        Unit r50 = Unit.INSTANCE;
        r0.put("ecom_share_track_params", r43);
        ECShopSearchParam r51 = this.searchParam;
        if (r51 == null) goto L124;
        StoreAccountParam r52 = r51.getStoreAccountParam();
        if (r52 == null) goto L124;
        String r53 = r52.getUserId();
    L125:
        r0.put("author_id", r53);
        ECShopSearchParam r54 = this.searchParam;
        if (r54 == null) goto L130;
        StoreAccountParam r55 = r54.getStoreAccountParam();
        if (r55 == null) goto L130;
        String r56 = r55.getSecUserId();
    L131:
        r0.put("sec_author_id", r56);
        ECShopSearchParam r57 = this.searchParam;
        if (r57 == null) goto L134;
        r5 = r57.getFollowStatus();
    L134:
        r0.put("follow_status", r5);
        return r0;
    L130:
        r56 = null;
    L124:
        r53 = null;
        goto L125
    L118:
        r49 = null;
        goto L119
    L111:
        r47 = null;
        goto L112
    L107:
        r45 = false;
        goto L108
    L101:
        r42 = null;
        goto L102
    L97:
        r40 = null;
        goto L98
    L93:
        r38 = null;
        goto L94
    L89:
        r36 = null;
        goto L90
    L85:
        r34 = null;
        goto L86
    L81:
        r32 = null;
        goto L82
    L77:
        r30 = null;
    L71:
        r28 = null;
        goto L72
    L63:
        r25 = null;
        goto L64
    L57:
        r23 = null;
        goto L58
    L51:
        r21 = null;
        goto L52
    L45:
        r19 = null;
        goto L46
    L39:
        r17 = null;
    L35:
        r14 = new LinkedHashMap();
        goto L36
    L28:
        r12 = null;
        goto L29
    L22:
        r10 = null;
        goto L23
    L16:
        r8 = null;
        goto L17
    L10:
        r6 = null;
    L6:
        r3 = "";
        goto L7
    }

    public final boolean hasDiscountSelected() {
        if ((!this.selectButtons.isEmpty()) == false) goto L17;
        List<com.bytedance.android.ec.store.repository.dto.c> r0 = this.selectButtons;
        if ((r0 instanceof Collection) == true) goto L7;
    L9:
        Iterator<T> r1 = r0.iterator();
    L11:
        if (r1.hasNext() == false) goto L8;
        if (Intrinsics.areEqual(((com.bytedance.android.ec.store.repository.dto.c) r1.next()).e(), Boolean.TRUE) == false) goto L11;
        boolean r2 = true;
    L15:
        if (r2 == false) goto L17;
        return true;
    L8:
        r2 = false;
        goto L15
    L7:
        if (r0.isEmpty() == false) goto L9;
    L17:
        return false;
    }

    public final void initEventParams() {
        Pair[] r0 = new Pair[13];
        ECShopSearchParam r1 = this.searchParam;
        String r2 = null;
        if (r1 == null) goto L7;
        StoreAccountParam r3 = r1.getStoreAccountParam();
        if (r3 == null) goto L7;
        String r4 = r3.getUserId();
    L8:
        r0[0] = TuplesKt.to("author_id", r4);
        ECShopSearchParam r5 = this.searchParam;
        if (r5 == null) goto L13;
        StoreAccountParam r6 = r5.getStoreAccountParam();
        if (r6 == null) goto L13;
        String r7 = r6.getSecUserId();
    L14:
        r0[1] = TuplesKt.to("sec_author_id", r7);
        ECShopSearchParam r8 = this.searchParam;
        if (r8 == null) goto L17;
        String r9 = r8.getShopId();
    L18:
        r0[2] = TuplesKt.to("shop_id", r9);
        ECShopSearchParam r10 = this.searchParam;
        if (r10 == null) goto L21;
        String r11 = r10.getSecShopId();
    L22:
        r0[3] = TuplesKt.to("sec_shop_id", r11);
        ECShopSearchParam r12 = this.searchParam;
        if (r12 == null) goto L25;
        String r13 = r12.getEnterFrom();
    L26:
        r0[4] = TuplesKt.to("enter_from", r13);
        ECShopSearchParam r14 = this.searchParam;
        if (r14 == null) goto L29;
        String r15 = r14.getEntranceLocation();
    L30:
        r0[5] = TuplesKt.to("entrance_location", r15);
        ECShopSearchParam r16 = this.searchParam;
        if (r16 == null) goto L33;
        String r17 = r16.getStoreSourcePage();
    L34:
        r0[6] = TuplesKt.to("store_source_page", r17);
        ECShopSearchParam r18 = this.searchParam;
        if (r18 == null) goto L37;
        String r19 = r18.getStoreSourceMethod();
    L38:
        r0[7] = TuplesKt.to("store_source_method", r19);
        ECShopSearchParam r20 = this.searchParam;
        if (r20 == null) goto L41;
        String r21 = r20.getStoreGroupType();
    L42:
        r0[8] = TuplesKt.to("store_group_type", r21);
        ECShopSearchParam r22 = this.searchParam;
        if (r22 == null) goto L45;
        String r23 = r22.getPageName();
    L46:
        r0[9] = TuplesKt.to("page_name", r23);
        ECShopSearchParam r24 = this.searchParam;
        if (r24 == null) goto L49;
        String r25 = r24.getPageName();
    L50:
        r0[10] = TuplesKt.to("source_page", r25);
        ECShopSearchParam r26 = this.searchParam;
        if (r26 == null) goto L55;
        Integer r27 = r26.getFollowStatus();
        if (r27 == null) goto L55;
        r2 = String.valueOf(r27.intValue());
    L55:
        r0[11] = TuplesKt.to("follow_status", r2);
        ECShopSearchParam r28 = this.searchParam;
        if (r28 != null) goto L58;
    L60:
        String r29 = "0";
    L61:
        r0[12] = TuplesKt.to("is_enter_preview", r29);
        initEventContext(MapsKt.mapOf(r0));
        return;
    L58:
        if (r28.isPreview() != true) goto L60;
        r29 = CommentScene.COMMENTSCENE_NO_AWEME;
        goto L61
    L49:
        r25 = null;
        goto L50
    L45:
        r23 = null;
        goto L46
    L41:
        r21 = null;
        goto L42
    L37:
        r19 = null;
        goto L38
    L33:
        r17 = null;
        goto L34
    L29:
        r15 = null;
        goto L30
    L25:
        r13 = null;
        goto L26
    L21:
        r11 = null;
        goto L22
    L17:
        r9 = null;
    L13:
        r7 = null;
    L7:
        r4 = null;
        goto L8
    }

    @Override // com.bytedance.android.shopping.store.router.hybridpage.viewmodel.HybridPageBaseViewModel
    public void onCleared() {
        super.onCleared();
        getSliceService().e();
    }

    public final WeakReference<LottieAnimationViewWithPlayCount> getCartAnimationView() {
        return this.cartAnimationView;
    }

    public final a<JSONObject> getConfigJson() {
        return this.configJson;
    }

    public final String getConfigJsonUrl() {
        return this.configJsonUrl;
    }

    public final ECHybridListDTO getHybridListDTO() {
        return this.hybridListDTO;
    }

    public final k getHybridListVO() {
        return this.hybridListVO;
    }

    public final HashSet<String> getIdRecords() {
        return this.idRecords;
    }

    public final a<LayoutTypes> getLayoutType() {
        return this.layoutType;
    }

    public final String getLoadNoMoreText() {
        return this.loadNoMoreText;
    }

    public final QLiveData<LoadStatus> getLoadStatus() {
        return this.loadStatus;
    }

    public final c getMultiLeveViewCache() {
        return this.multiLeveViewCache;
    }

    public final String getPageCardUrl() {
        return this.pageCardUrl;
    }

    public final a<Integer> getProductViewsNum() {
        return this.productViewsNum;
    }

    public final Map<String, Object> getRouteParams() {
        return this.routeParams;
    }

    public final Map<String, Object> getRouterQuery() {
        return this.routerQuery;
    }

    public final String getSceneId() {
        return this.sceneId;
    }

    public final ECShopSearchParam getSearchParam() {
        return this.searchParam;
    }

    public final List<com.bytedance.android.ec.store.repository.dto.c> getSelectButtons() {
        return this.selectButtons;
    }

    public final b getSliceConfigSetting() {
        return this.sliceConfigSetting;
    }

    public final SliceProductCardData getSliceProductCardData() {
        return this.sliceProductCardData;
    }

    public final String getSourceBtmToken() {
        return this.sourceBtmToken;
    }

    public final a<Integer> getTotalProductNum() {
        return this.totalProductNum;
    }

    public final void appendHybridListDTO(ECHybridListDTO r5) {
        ECHybridListDTO r0 = this.hybridListDTO;
        if (r0 != null) goto L6;
        this.hybridListDTO = r5;
        return;
    L6:
        Map r1 = null;
        if (r0 == null) goto L12;
        if (r5 == null) goto L10;
        ECHybridListStyleDTO r2 = r5.getListStyle();
    L11:
        r0.setListStyle(r2);
        goto L12
    L10:
        r2 = null;
    L12:
        if (r0 == null) goto L18;
        List<ECHybridListSectionDTO> r3 = r0.getSections();
        if (r5 == null) goto L16;
        List<ECHybridListSectionDTO> r4 = r5.getSections();
    L17:
        r0.setSections(mergeSections(r3, r4));
        goto L18
    L16:
        r4 = null;
    L18:
        if (r0 == null) goto L25;
        if (r5 == null) goto L21;
        Map r6 = r5.getItemConfigs();
    L22:
        if (r6 != null) goto L24;
        r6 = MapsKt.emptyMap();
    L24:
        r0.setItemConfigs(r6);
        goto L25
    L21:
        r6 = null;
    L25:
        if (r0 == null) goto L32;
        if (r5 == null) goto L28;
        r1 = r5.getExtra();
    L28:
        if (r1 != null) goto L30;
        r1 = MapsKt.emptyMap();
    L30:
        r0.setExtra(r1);
        return;
    }

    public final void reportInitializeError(Map<String, String> r3) {
        LinkedHashMap r0 = new LinkedHashMap();
        if (r3 != null) goto L5;
        r3 = new LinkedHashMap();
    L5:
        r0.putAll(r3);
        Unit r4 = Unit.INSTANCE;
        doEventAction("search_hybrid_page_load_failed", r0, new Pair[0]);
    }

    public final void setCartAnimationView(WeakReference<LottieAnimationViewWithPlayCount> r1) {
        this.cartAnimationView = r1;
    }

    public final void setConfigJson(a<JSONObject> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.configJson = r2;
    }

    public final void setConfigJsonUrl(String r1) {
        this.configJsonUrl = r1;
    }

    public final void setHybridListDTO(ECHybridListDTO r1) {
        this.hybridListDTO = r1;
    }

    public final void setHybridListVO(k r1) {
        this.hybridListVO = r1;
    }

    public final void setIdRecords(HashSet<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.idRecords = r2;
    }

    public final void setLayoutType(a<LayoutTypes> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.layoutType = r2;
    }

    public final void setLoadNoMoreText(String r1) {
        this.loadNoMoreText = r1;
    }

    public final void setLoadStatus(QLiveData<LoadStatus> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.loadStatus = r2;
    }

    public final void setLynxCardEventListener(b4 r1) {
        this.lynxCardEventListener = r1;
    }

    public final void setPageCardUrl(String r1) {
        this.pageCardUrl = r1;
    }

    public final void setRouteParams(Map<String, ? extends Object> r1) {
        this.routeParams = r1;
    }

    public final void setRouterQuery(Map<String, Object> r1) {
        this.routerQuery = r1;
    }

    public final void setSearchParam(ECShopSearchParam r1) {
        this.searchParam = r1;
    }

    public final void setSelectButtons(List<com.bytedance.android.ec.store.repository.dto.c> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.selectButtons = r2;
    }

    public final void setSliceConfigSetting(b r1) {
        this.sliceConfigSetting = r1;
    }

    public final void setSliceProductCardData(SliceProductCardData r1) {
        this.sliceProductCardData = r1;
    }

    public final void setSourceBtmToken(String r1) {
        this.sourceBtmToken = r1;
    }

    public final void initData(Context r6, b r7) {
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "configSetting");
        this.sliceConfigSetting = r7;
        vj3.a r0 = com.bytedance.android.shopping.store.router.hybridpage.slice.c.d;
        if (r7 == null) goto L5;
        vj3.a r8 = r7.a();
    L6:
        com.bytedance.android.shopping.store.router.hybridpage.slice.c.d = r8;
        com.bytedance.android.shopping.store.slicecard.b r9 = getSliceService();
        boolean r1 = true;
        if (ECShopABSettings.e() == 1) goto L10;
        r1 = false;
    L10:
        r9.b(r6, r1);
        b r10 = this.sliceConfigSetting;
        if (r10 == null) goto L16;
        String r11 = r10.b();
        if (r11 == null) goto L16;
        boolean r12 = ak3.a.a;
        this.pageCardUrl = ak3.a.c(r11, "page_card.js");
        this.configJsonUrl = ak3.a.c(r11, "config.json");
    L16:
        if (HybridPageSlcTemplateManager.e.isEmpty() == false) goto L41;
        long r13 = wh.a.a("ecom_shop_slice_template");
        List<com.bytedance.android.ec.store.setting.k> r2 = HybridPageSlcTemplateManager.a;
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator<T> r4 = r2.iterator();
    L19:
        if (r4.hasNext() == false) goto L21;
        com.bytedance.android.ec.store.setting.k r5 = (com.bytedance.android.ec.store.setting.k) r4.next();
        SliceTemplate r14 = new SliceTemplate();
        r14.setName(r5.a());
        r14.setUrl(r5.c());
        r14.setVersion(String.valueOf(r13));
        r14.setType(SliceTemplateType.GECKO.getType());
        r3.add(r14);
        goto L19
    L21:
        ArrayList r15 = new ArrayList();
        ArrayList r16 = new ArrayList();
        ArrayList r17 = new ArrayList();
        Iterator r18 = r3.iterator();
    L23:
        if (r18.hasNext() == false) goto L33;
        SliceTemplate r19 = (SliceTemplate) r18.next();
        if (CollectionsKt.contains(HybridPageSlcTemplateManager.b, r19.getName()) == false) goto L28;
        r16.add(r19);
    L28:
        if (CollectionsKt.contains(HybridPageSlcTemplateManager.c, r19.getName()) == false) goto L31;
        r17.add(r19);
    L31:
        if (CollectionsKt.contains(HybridPageSlcTemplateManager.d, r19.getName()) == false) goto L23;
        r15.add(r19);
        goto L23
    L33:
        ConcurrentHashMap<String, ShopSliceItemConfig> r20 = HybridPageSlcTemplateManager.e;
        String r21 = SliceItemType.SHOP_PRODUCT_LIST_PRODUCT_CARD_CARDPACK.getType();
        ShopSliceItemConfig r22 = new ShopSliceItemConfig();
        r22.setTemplates(r15);
        Unit r23 = Unit.INSTANCE;
        r20.put(r21, r22);
        String r24 = SliceItemType.SHOP_SEARCH_RESULT_PAGE.getType();
        ShopSliceItemConfig r25 = new ShopSliceItemConfig();
        r25.setTemplates(r16);
        r20.put(r24, r25);
        String r26 = SliceItemType.SHOP_CLASSIFICATION_SECOND_PAGE.getType();
        ShopSliceItemConfig r27 = new ShopSliceItemConfig();
        r27.setTemplates(r17);
        r20.put(r26, r27);
        return;
    L41:
        return;
    L5:
        r8 = null;
        goto L6
    }

    public final List<ECHybridListSectionDTO> mergeSections(List<ECHybridListSectionDTO> r8, List<ECHybridListSectionDTO> r9) {
        if (r8 != null) goto L4;
        return r9;
    L4:
        List<ECHybridListSectionDTO> r0 = CollectionsKt.toMutableList(r8);
        if (r9 == null) goto L30;
        Iterator<T> r10 = r9.iterator();
    L8:
        if (r10.hasNext() == false) goto L30;
        ECHybridListSectionDTO r1 = (ECHybridListSectionDTO) r10.next();
        ArrayList r3 = new ArrayList();
        Iterator<T> r2 = r8.iterator();
    L11:
        if (r2.hasNext() == false) goto L16;
        Object r4 = r2.next();
        if (Intrinsics.areEqual(((ECHybridListSectionDTO) r4).getSectionId(), r1.getSectionId()) == false) goto L11;
        r3.add(r4);
        goto L11
    L16:
        if ((!r3.isEmpty()) == true) goto L19;
        r3 = null;
    L19:
        if (r3 != null) goto L20;
        r0.add(r1);
        goto L8
    L20:
        Iterator r5 = r3.iterator();
    L22:
        if (r5.hasNext() == false) goto L8;
        ArrayList r6 = ((ECHybridListSectionDTO) r5.next()).getItems();
        if (r6 == null) goto L22;
        Collection r7 = r1.getItems();
        if (r7 != null) goto L28;
        r7 = CollectionsKt.emptyList();
    L28:
        r6.addAll(r7);
    L30:
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void reportInitializeError$default(HybridPageViewModel r0, Map r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        r0.reportInitializeError(r1);
    }

    public static void initData$default(HybridPageViewModel r0, Context r1, b r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = (b) HybridPageConfigSetting.a.getValue();
    L5:
        r0.initData(r1, r2);
    }
}
