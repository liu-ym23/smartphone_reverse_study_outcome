package com.bytedance.android.window.shop.home.tab;

import com.bytedance.android.ec.hybrid.list.entity.k;
import com.bytedance.android.window.shop.home.BaseWindowTabViewModel;
import com.bytedance.android.window.shop.home.ECWindowParam;
import com.bytedance.android.window.shop.home.tab.common.CategoryRequestParamKey;
import com.bytedance.android.window.shop.home.tab.tabplugin.TabNavigationParams;
import com.bytedance.android.window.shop.home.tab.tabplugin.WindowNavigationParam;
import com.bytedance.android.window.shop.repository.ShopRepository;
import com.bytedance.android.window.shop.repository.api.ECWindowApi;
import com.bytedance.android.window.shop.repository.api.WindowProductTabRequestParam;
import com.bytedance.android.window.shop.repository.dto.WindowHybridTabDataListResponseDTO;
import com.bytedance.android.window.shop.repository.tab.datasource.ShopWindowDataSourceConfig;
import com.bytedance.android.window.shop.repository.tab.datasource.ShopWindowVODataType;
import com.bytedance.android.window.shop.repository.tab.datasource.impl.WindowTabHybridDataSource;
import com.bytedance.android.window.shop.repository.tab.datasource.mapping.WindowDataMapper;
import com.bytedance.android.window.shop.repository.tab.entity.WindowChildCategoryVO;
import com.bytedance.android.window.shop.repository.tab.entity.WindowLayoutType;
import com.bytedance.android.window.shop.repository.tab.entity.n0;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
import org.json.JSONObject;
import zq3.w1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0010\"\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 }2\u00020\u0001:\u0001~B\u0007¢\u0006\u0004\b{\u0010|J{\u0010\u0013\u001a\u00020\u00122\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u000e\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0016J\b\u0010\u0019\u001a\u00020\u0012H\u0016J\u0010\u0010\u001c\u001a\u00020\u00122\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aJ\u000e\u0010\u001d\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\u000bJ\u0018\u0010\u001d\u001a\u00020\u00122\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\f\u001a\u00020\u000bJ\u0016\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bJ9\u0010!\u001a\u00020\u00122\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000b2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010 ¢\u0006\u0004\b!\u0010\"JU\u0010!\u001a\u00020\u00122\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010#\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\u000b2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010 2\u0010\b\u0002\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010 ¢\u0006\u0004\b!\u0010%J4\u0010.\u001a\u00020\u00122\u0006\u0010&\u001a\u00020\u00042\b\u0010'\u001a\u0004\u0018\u00010\u00042\b\u0010)\u001a\u0004\u0018\u00010(2\u0006\u0010+\u001a\u00020*2\b\u0010-\u001a\u0004\u0018\u00010,J\u0006\u0010/\u001a\u00020\u0012JD\u00105\u001a\u00020(2\u0006\u0010&\u001a\u00020\u00042\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004002\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u0004022\b\u00104\u001a\u0004\u0018\u00010\u00042\b\u0010'\u001a\u0004\u0018\u00010\u0004J\u000e\u00107\u001a\u00020\u00122\u0006\u00106\u001a\u00020(J\b\u00108\u001a\u00020\u0012H\u0014J\u0006\u00109\u001a\u00020\tR0\u0010=\u001a\u0010\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020<\u0018\u00010:8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR<\u0010E\u001a\u001c\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020<\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040D\u0018\u00010C8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bE\u0010>\u001a\u0004\bF\u0010@\"\u0004\bG\u0010BR\u001b\u0010M\u001a\u00020H8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bI\u0010J\u001a\u0004\bK\u0010LR\"\u0010N\u001a\u00020<8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bN\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\"\u0010T\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bT\u0010U\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR\"\u0010Z\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bZ\u0010[\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R\u0018\u0010`\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b`\u0010aR\u0018\u0010b\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bb\u0010cR\u0018\u0010d\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bd\u0010eR$\u0010f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bf\u0010e\u001a\u0004\bg\u0010h\"\u0004\bi\u0010jR\u0014\u0010l\u001a\u00020k8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bl\u0010mR\u001b\u0010p\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bn\u0010J\u001a\u0004\bo\u0010hR\"\u0010q\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bq\u0010U\u001a\u0004\br\u0010W\"\u0004\bs\u0010YR\u0016\u0010u\u001a\u00020t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bu\u0010vR \u0010y\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020x0w8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\by\u0010z¨\u0006\u007f"}, d2 = {"Lcom/bytedance/android/window/shop/home/tab/WindowHybridTabViewModel;", "Lcom/bytedance/android/window/shop/home/BaseWindowTabViewModel;", "Lcom/bytedance/android/window/shop/repository/tab/datasource/ShopWindowDataSourceConfig;", "config", "", "categoryId", "subcategoryId", "", "id", "", "ascend", "Lcom/bytedance/android/window/shop/repository/tab/entity/WindowLayoutType;", "layoutType", "isFirstRequest", "forceInsertInfo", "targetFilterType", "childCategory", "lastCommonPassThroughParam", "", "tryFillDataSourceConfig", "(Lcom/bytedance/android/window/shop/repository/tab/datasource/ShopWindowDataSourceConfig;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Boolean;Lcom/bytedance/android/window/shop/repository/tab/entity/WindowLayoutType;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "prepareDataSource", "Lcom/bytedance/android/window/shop/repository/tab/datasource/c;", "cb", "setCallback", "loadData", "Lcom/bytedance/android/window/shop/home/tab/tabplugin/TabNavigationParams;", "naviParams", "fillNaviParam", "refreshAndLoadData", "Lcom/bytedance/android/window/shop/repository/tab/entity/WindowChildCategoryVO$ChildCategoryVO;", "currentSelected", "Lcom/bytedance/android/window/shop/home/tab/tabplugin/WindowNavigationParam;", "refreshSubTabs", "(Ljava/lang/Long;Ljava/lang/Boolean;Lcom/bytedance/android/window/shop/repository/tab/entity/WindowLayoutType;Lcom/bytedance/android/window/shop/home/tab/tabplugin/WindowNavigationParam;)V", "subCategoryId", "currentChildCategory", "(Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/String;Lcom/bytedance/android/window/shop/repository/tab/entity/WindowLayoutType;Lcom/bytedance/android/window/shop/home/tab/tabplugin/WindowNavigationParam;Lcom/bytedance/android/window/shop/home/tab/tabplugin/WindowNavigationParam;)V", "secAuthorId", "passThroughParam", "Lcom/bytedance/android/window/shop/repository/dto/WindowHybridTabDataListResponseDTO;", "initCache", "Lcom/bytedance/android/window/shop/home/ECWindowParam;", "windowParam", "Lorg/json/JSONObject;", "entranceInfoJsonObject", "init", "clearDataSource", "", "requestParams", "", "excludedList", "exExtra", "prefetchInsertData", "dto", "insertVaneCard", "onCleared", "isFirstScreen", "Lkotlin/reflect/KFunction1;", "Lcom/bytedance/android/window/shop/repository/tab/entity/f;", "", "nearestDynamicInsertDistanceFetcher", "Lkotlin/reflect/KFunction;", "getNearestDynamicInsertDistanceFetcher", "()Lkotlin/reflect/KFunction;", "setNearestDynamicInsertDistanceFetcher", "(Lkotlin/reflect/KFunction;)V", "Lkotlin/reflect/KFunction2;", "", "surroundedItemFetcher", "getSurroundedItemFetcher", "setSurroundedItemFetcher", "Lzq3/w1;", "tabPerformanceWatcher$delegate", "Lkotlin/Lazy;", "getTabPerformanceWatcher", "()Lzq3/w1;", "tabPerformanceWatcher", "lastBindPosition", "I", "getLastBindPosition", "()I", "setLastBindPosition", "(I)V", "tabShowTime", "J", "getTabShowTime", "()J", "setTabShowTime", "(J)V", "firstScreen", "Z", "getFirstScreen", "()Z", "setFirstScreen", "(Z)V", "lastId", "Ljava/lang/Long;", "lastAscend", "Ljava/lang/Boolean;", "lastForceInsertInfo", "Ljava/lang/String;", "lastChildCategory", "getLastChildCategory", "()Ljava/lang/String;", "setLastChildCategory", "(Ljava/lang/String;)V", "Lio/reactivex/disposables/CompositeDisposable;", "ignorableDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "sceneId$delegate", "getSceneId", "sceneId", "lifecycleMonitorId", "getLifecycleMonitorId", "setLifecycleMonitorId", "Lqq3/d;", "dataSource", "Lqq3/d;", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/bytedance/android/ec/hybrid/list/entity/k;", "tabResultCache", "Ljava/util/concurrent/ConcurrentHashMap;", "<init>", "()V", "Companion", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowHybridTabViewModel extends BaseWindowTabViewModel {
    public static final a Companion = null;
    private static final fo.a<Function2<com.bytedance.android.window.shop.repository.tab.entity.f, Integer, Boolean>> DYNAMIC_CARD_CHECKER = null;
    private qq3.d dataSource;
    private boolean firstScreen;
    private final CompositeDisposable ignorableDisposable;
    private Boolean lastAscend;
    private int lastBindPosition;
    private String lastChildCategory;
    private String lastForceInsertInfo;
    private Long lastId;
    private long lifecycleMonitorId;
    private KFunction<Integer> nearestDynamicInsertDistanceFetcher;
    private final Lazy sceneId$delegate;
    private KFunction<? extends List<String>> surroundedItemFetcher;
    private final Lazy tabPerformanceWatcher$delegate;
    private final ConcurrentHashMap<String, k> tabResultCache;
    private long tabShowTime;

    public static final class a {
        public a() {
        }
    }

    public final String getSceneId() {
        return (String) this.sceneId$delegate.getValue();
    }

    public final w1 getTabPerformanceWatcher() {
        return (w1) this.tabPerformanceWatcher$delegate.getValue();
    }

    static {
        Companion = new a();
        DYNAMIC_CARD_CHECKER = new fo.a("window_dynamic_card_range_checker", new Function2[0]);
    }

    public final void clearDataSource() {
        qq3.d r0 = this.dataSource;
        r0.d = null;
        r0.a();
    }

    public final boolean isFirstScreen() {
        if (this.firstScreen == false) goto L6;
        this.firstScreen = false;
        return true;
    L6:
        return false;
    }

    @Override // com.bytedance.android.window.shop.home.tab.BaseTabViewModel
    public void loadData() {
        qq3.d r0 = this.dataSource;
        WindowTabHybridDataSource r1 = r0.e;
        if (r1 != null) goto L6;
        return;
    L6:
        if (r1.c.a == false) goto L8;
        r1.a(r0);
        return;
    L8:
        com.bytedance.android.window.shop.repository.tab.datasource.c r2 = r0.d;
        if (r2 == null) goto L13;
        r2.c(null);
        return;
    }

    public WindowHybridTabViewModel() {
        this.tabPerformanceWatcher$delegate = LazyKt.lazy(new WindowHybridTabViewModel$tabPerformanceWatcher$2(this));
        this.tabShowTime = System.currentTimeMillis();
        this.firstScreen = true;
        this.ignorableDisposable = new CompositeDisposable();
        this.sceneId$delegate = LazyKt.lazy(WindowHybridTabViewModel$sceneId$2.INSTANCE);
        qq3.d r0 = new qq3.d();
        List<pq3.a> r1 = getInterceptors();
        Intrinsics.checkNotNullParameter(r1, "interceptorList");
        r0.f.addAll(r1);
        Unit r2 = Unit.INSTANCE;
        this.dataSource = r0;
        this.tabResultCache = new ConcurrentHashMap();
    }

    @Override // com.bytedance.android.window.shop.home.BaseWindowTabViewModel
    public void onCleared() {
        super.onCleared();
        this.surroundedItemFetcher = null;
        this.nearestDynamicInsertDistanceFetcher = null;
        this.ignorableDisposable.clear();
    }

    public static final /* synthetic */ fo.a access$getDYNAMIC_CARD_CHECKER$cp() {
        return DYNAMIC_CARD_CHECKER;
    }

    public final boolean getFirstScreen() {
        return this.firstScreen;
    }

    public final int getLastBindPosition() {
        return this.lastBindPosition;
    }

    public final String getLastChildCategory() {
        return this.lastChildCategory;
    }

    public final long getLifecycleMonitorId() {
        return this.lifecycleMonitorId;
    }

    public final KFunction<Integer> getNearestDynamicInsertDistanceFetcher() {
        return this.nearestDynamicInsertDistanceFetcher;
    }

    public final KFunction<List<String>> getSurroundedItemFetcher() {
        return this.surroundedItemFetcher;
    }

    public final long getTabShowTime() {
        return this.tabShowTime;
    }

    public static final /* synthetic */ String access$getLastForceInsertInfo$p(WindowHybridTabViewModel r0) {
        return r0.lastForceInsertInfo;
    }

    public final void fillNaviParam(TabNavigationParams r5) {
        qq3.d r0 = this.dataSource;
        if (r5 != null) goto L5;
        r0.getClass();
    L9:
        String r1 = null;
        if (r5 == null) goto L14;
        WindowNavigationParam<String> r2 = r5.getForceInsertInfo();
        if (r2 == null) goto L14;
        WindowNavigationParam.a r3 = WindowNavigationParam.Companion;
        String r4 = this.lastForceInsertInfo;
        r3.getClass();
        String r6 = (String) WindowNavigationParam.a.a(r2, r4);
    L15:
        this.lastForceInsertInfo = r6;
        if (r5 == null) goto L20;
        WindowNavigationParam<String> r7 = r5.getChildCategoryVO();
        if (r7 == null) goto L20;
        WindowNavigationParam.a r8 = WindowNavigationParam.Companion;
        String r9 = this.lastChildCategory;
        r8.getClass();
        r1 = (String) WindowNavigationParam.a.a(r7, r9);
    L20:
        this.lastChildCategory = r1;
        return;
    L14:
        r6 = null;
        goto L15
    L5:
        WindowTabHybridDataSource r10 = r0.e;
        if (r10 == null) goto L9;
        r10.g.b().fillWithNaviParams(r5);
        goto L9
    }

    public final void insertVaneCard(WindowHybridTabDataListResponseDTO r6) {
        Intrinsics.checkNotNullParameter(r6, "dto");
        k r7 = WindowDataMapper.b(r6);
        com.bytedance.android.window.shop.repository.tab.datasource.c r0 = this.dataSource.d;
        if (r0 == null) goto L6;
        r0.y(new n0(CollectionsKt.emptyList(), com.bytedance.android.window.shop.c.c, r7, null), ShopWindowVODataType.NORMAL);
        return;
    }

    @Override // com.bytedance.android.window.shop.home.BaseWindowTabViewModel
    public void prepareDataSource(String r5) {
        Intrinsics.checkNotNullParameter(r5, "categoryId");
        setLastCategoryId(r5);
        this.dataSource.b(new CategoryRequestParamKey(getLastCategoryId(), null, 2, null), null);
    }

    public final void refreshAndLoadData(WindowLayoutType r11) {
        Intrinsics.checkNotNullParameter(r11, "layoutType");
        refreshSubTabs$default(this, this.lastId, this.lastAscend, getLastSubCategoryId(), r11, null, null, 32, null);
    }

    public final void setCallback(com.bytedance.android.window.shop.repository.tab.datasource.c r2) {
        Intrinsics.checkNotNullParameter(r2, "cb");
        this.dataSource.d = r2;
    }

    public final void setFirstScreen(boolean r1) {
        this.firstScreen = r1;
    }

    public final void setLastBindPosition(int r1) {
        this.lastBindPosition = r1;
    }

    public final void setLastChildCategory(String r1) {
        this.lastChildCategory = r1;
    }

    public final void setLifecycleMonitorId(long r1) {
        this.lifecycleMonitorId = r1;
    }

    public final void setNearestDynamicInsertDistanceFetcher(KFunction<Integer> r1) {
        this.nearestDynamicInsertDistanceFetcher = r1;
    }

    public final void setSurroundedItemFetcher(KFunction<? extends List<String>> r1) {
        this.surroundedItemFetcher = r1;
    }

    public final void setTabShowTime(long r1) {
        this.tabShowTime = r1;
    }

    public static final /* synthetic */ void access$setLastForceInsertInfo$p(WindowHybridTabViewModel r0, String r1) {
        r0.lastForceInsertInfo = r1;
    }

    public final void refreshAndLoadData(WindowChildCategoryVO.ChildCategoryVO r9, WindowLayoutType r10) {
        Intrinsics.checkNotNullParameter(r10, "layoutType");
        Long r2 = this.lastId;
        Boolean r3 = this.lastAscend;
        String r4 = getLastSubCategoryId();
        WindowNavigationParam.a r0 = WindowNavigationParam.Companion;
        if (r9 == null) goto L5;
        String r11 = r9.getId();
    L6:
        r0.getClass();
        refreshSubTabs(r2, r3, r4, r10, null, WindowNavigationParam.a.c(r11));
        return;
    L5:
        r11 = null;
        goto L6
    }

    public final void refreshAndLoadData(String r11, WindowLayoutType r12) {
        Intrinsics.checkNotNullParameter(r11, "subcategoryId");
        Intrinsics.checkNotNullParameter(r12, "layoutType");
        refreshSubTabs$default(this, this.lastId, this.lastAscend, r11, r12, null, null, 32, null);
    }

    public final void refreshSubTabs(Long r11, Boolean r12, WindowLayoutType r13, WindowNavigationParam<String> r14) {
        Intrinsics.checkNotNullParameter(r13, "layoutType");
        refreshSubTabs$default(this, r11, r12, getLastSubCategoryId(), r13, r14, null, 32, null);
    }

    public final void init(String r3, String r4, WindowHybridTabDataListResponseDTO r5, ECWindowParam r6, JSONObject r7) {
        Intrinsics.checkNotNullParameter(r3, "secAuthorId");
        Intrinsics.checkNotNullParameter(r6, "windowParam");
        qq3.d r1 = this.dataSource;
        String r8 = zq3.d.a(r6, r7);
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "secAuthorId");
        r1.a = r3;
        r1.c = r4;
        r1.b = r8;
        WindowTabHybridDataSource r9 = r1.e;
        if (r9 == null) goto L14;
        r9.g.b().setSecAuthorId(r3);
        r9.g.b().setPassThroughApi(r4);
        Intrinsics.checkNotNullParameter(r9, "dataSource");
        String r10 = r9.f;
        if (r5 == null) goto L8;
        String r11 = r5.getTargetSelectCategoryId();
    L10:
        if (Intrinsics.areEqual(r10, r11) == false) goto L12;
        r9.g.c = r5;
    L12:
        r9.g.getClass();
        return;
    L8:
        r11 = null;
        goto L10
    }

    public final WindowHybridTabDataListResponseDTO prefetchInsertData(String r18, Map<String, String> r19, Set<String> r20, String r21, String r22) {
        Intrinsics.checkNotNullParameter(r18, "secAuthorId");
        Intrinsics.checkNotNullParameter(r19, "requestParams");
        Intrinsics.checkNotNullParameter(r20, "excludedList");
        ShopRepository r5 = ShopRepository.a;
        String r7 = getLastCategoryId();
        r5.getClass();
        Intrinsics.checkNotNullParameter(r18, "secAuthorId");
        Intrinsics.checkNotNullParameter(r7, "category");
        Intrinsics.checkNotNullParameter(r19, "requestParams");
        Intrinsics.checkNotNullParameter(r20, "excludedList");
        int r8 = kq3.a.a;
        Intrinsics.checkNotNullParameter(r18, "secAuthorId");
        Intrinsics.checkNotNullParameter(r7, "category");
        Intrinsics.checkNotNullParameter(r19, "requestParams");
        Intrinsics.checkNotNullParameter(r20, "excludedList");
        ECWindowApi.a.getClass();
        ECWindowApi r2 = ECWindowApi.a.b;
        if (r2 == null) goto L6;
        Observable<WindowHybridTabDataListResponseDTO> r0 = r2.getShopTabInsertDataBff(r18, r7, CollectionsKt.joinToString$default(r20, null, null, null, 0, null, null, 63, null), r22, r21, r19);
        if (r0 == null) goto L6;
    L8:
        return (WindowHybridTabDataListResponseDTO) r0.blockingFirst();
    L6:
        r0 = Observable.error(new Throwable("ECNetworkService not init"));
        goto L8
    }

    public final void refreshSubTabs(final Long r16, final Boolean r17, String r18, final WindowLayoutType r19, final WindowNavigationParam<String> r20, final WindowNavigationParam<String> r21) {
        Intrinsics.checkNotNullParameter(r19, "layoutType");
        this.lastId = r16;
        this.lastAscend = r17;
        if (r18 != null) goto L5;
        String r0 = "";
    L6:
        setLastSubCategoryId(r0);
        this.dataSource.a();
        qq3.d r1 = this.dataSource;
        final com.bytedance.android.window.shop.repository.tab.datasource.c r4 = r1.d;
        r1.d = null;
        Iterator<com.bytedance.android.window.shop.home.viewmodel.b> r2 = getTabRefreshRegistry().iterator();
    L8:
        if (r2.hasNext() == false) goto L10;
        r2.next().onRefresh();
        goto L8
    L10:
        qq3.d r3 = this.dataSource;
        final String r5 = r3.a;
        final String r6 = r3.c;
        WindowTabHybridDataSource r7 = r3.e;
        if (r7 == null) goto L17;
        com.bytedance.android.window.shop.repository.tab.datasource.g r8 = r7.g;
        if (r8 == null) goto L17;
        WindowProductTabRequestParam r9 = r8.b();
        if (r9 == null) goto L17;
        final String r10 = r9.getCommonPassThroughParam();
    L18:
        qq3.d r12 = new qq3.d();
        r12.a = r5;
        r12.c = r6;
        r12.d = r4;
        r12.b(new CategoryRequestParamKey(getLastCategoryId(), null, 2, null), new WindowHybridTabViewModel$refreshSubTabs$$inlined$apply$lambda$1(this, r5, r6, r4, r16, r17, r19, r20, r21, r10));
        List<pq3.a> r11 = getInterceptors();
        Intrinsics.checkNotNullParameter(r11, "interceptorList");
        r12.f.addAll(r11);
        Unit r13 = Unit.INSTANCE;
        this.dataSource = r12;
        loadData();
        return;
    L17:
        r10 = null;
        goto L18
    L5:
        r0 = r18;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void refreshSubTabs$default(WindowHybridTabViewModel r7, Long r8, Boolean r9, String r10, WindowLayoutType r11, WindowNavigationParam r12, WindowNavigationParam r13, int r14, Object r15) {
        if ((r14 & 32) == 0) goto L5;
        WindowNavigationParam.Companion.getClass();
        r13 = WindowNavigationParam.a.b();
    L5:
        r7.refreshSubTabs(r8, r9, r10, r11, r12, r13);
    }

    private final void tryFillDataSourceConfig(ShopWindowDataSourceConfig<?> r1, String r2, String r3, Long r4, Boolean r5, WindowLayoutType r6, boolean r7, String r8, String r9, String r10, String r11) {
        if ((r1 instanceof com.bytedance.android.window.shop.repository.tab.datasource.g) == false) goto L13;
        com.bytedance.android.window.shop.repository.tab.datasource.g r12 = (com.bytedance.android.window.shop.repository.tab.datasource.g) r1;
        r12.getClass();
        r12.d = r7;
        r12.b().setTargetFilterType(com.bytedance.android.shopping.extensions.k.j(r9));
        r12.b().setForceInsertInfo(r8);
        WindowProductTabRequestParam r13 = r12.b();
        if (r2 != null) goto L7;
        r2 = "-1";
    L7:
        r13.setTargetCategory(r2);
        WindowProductTabRequestParam r14 = r12.b();
        if (r3 != null) goto L10;
        r3 = "";
    L10:
        r14.setTargetSubCategory(r3);
        r12.b().setChildCategory(r10);
        r12.b().setCommonPassThroughParam(r11);
        r12.b().setSortType(r4);
        r12.b().setSort(com.bytedance.android.window.shop.repository.tab.datasource.a.a(r5));
        return;
    L13:
        if ((r1 instanceof com.bytedance.android.window.shop.repository.tab.datasource.b) == false) goto L16;
        ((com.bytedance.android.window.shop.repository.tab.datasource.b) r1).b().setForceInsertInfo(r8);
        return;
    }

    public static final /* synthetic */ void access$tryFillDataSourceConfig(WindowHybridTabViewModel r0, ShopWindowDataSourceConfig r1, String r2, String r3, Long r4, Boolean r5, WindowLayoutType r6, boolean r7, String r8, String r9, String r10, String r11) {
        r0.tryFillDataSourceConfig(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11);
    }
}
