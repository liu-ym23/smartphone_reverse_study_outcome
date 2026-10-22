package com.bytedance.android.window.shop.home.tab;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.window.shop.home.BaseWindowTabViewModel;
import com.bytedance.android.window.shop.home.tab.common.CategoryRequestParamKey;
import com.bytedance.android.window.shop.home.tab.tabplugin.TabNavigationParams;
import com.bytedance.android.window.shop.home.tab.tabplugin.WindowNavigationParam;
import com.bytedance.android.window.shop.repository.ShopRepository;
import com.bytedance.android.window.shop.repository.api.ECWindowApi;
import com.bytedance.android.window.shop.repository.api.WindowProductTabRequestParam;
import com.bytedance.android.window.shop.repository.dto.WindowTabDataListResponseDTODeprecated;
import com.bytedance.android.window.shop.repository.tab.datasource.ShopWindowDataSourceConfig;
import com.bytedance.android.window.shop.repository.tab.datasource.mapping.WindowDataMapper;
import com.bytedance.android.window.shop.repository.tab.entity.WindowLayoutType;
import com.bytedance.android.window.shop.repository.tab.entity.m0;
import com.bytedance.android.window.shop.repository.tab.entity.s;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bZ\u0010[Jg\u0010\u0011\u001a\u00020\u00102\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u000e\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0017J\b\u0010\u001a\u001a\u00020\u0010H\u0016J\u0010\u0010\u001d\u001a\u00020\u00102\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bJ\u000e\u0010\u001e\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u000bJ\u0016\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bJ9\u0010 \u001a\u00020\u00102\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000b2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001f¢\u0006\u0004\b \u0010!JC\u0010 \u001a\u00020\u00102\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\"\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\u000b2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001f¢\u0006\u0004\b \u0010#J\"\u0010(\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u00042\b\u0010%\u001a\u0004\u0018\u00010\u00042\b\u0010'\u001a\u0004\u0018\u00010&J\u0006\u0010)\u001a\u00020\u0010JP\u00101\u001a\u00020\u00102\u0006\u0010*\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u00042\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040+2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00040-2\b\u0010%\u001a\u0004\u0018\u00010\u00042\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u00100/J\u0014\u00104\u001a\b\u0012\u0004\u0012\u000203022\u0006\u0010*\u001a\u00020\u0004J\u000e\u00107\u001a\u0002062\u0006\u00105\u001a\u000203J\b\u00108\u001a\u00020\u0010H\u0014R0\u0010:\u001a\u0010\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020\u0013\u0018\u0001098\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R<\u0010A\u001a\u001c\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000402\u0018\u00010@8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bA\u0010;\u001a\u0004\bB\u0010=\"\u0004\bC\u0010?R\u0018\u0010D\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010ER\u0018\u0010F\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010GR\u0018\u0010H\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010IR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010JR\u0014\u0010L\u001a\u00020K8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010O\u001a\u00020N8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010PR\"\u0010Q\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR&\u0010X\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u000203020W8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bX\u0010Y¨\u0006\\"}, d2 = {"Lcom/bytedance/android/window/shop/home/tab/WindowTabViewModel;", "Lcom/bytedance/android/window/shop/home/BaseWindowTabViewModel;", "Lcom/bytedance/android/window/shop/repository/tab/datasource/ShopWindowDataSourceConfig;", "config", "", "categoryId", "subcategoryId", "", "id", "", "ascend", "Lcom/bytedance/android/window/shop/repository/tab/entity/WindowLayoutType;", "layoutType", "isFirstRequest", "forceInsertInfo", "targetFilterType", "", "tryFillDataSourceConfig", "(Lcom/bytedance/android/window/shop/repository/tab/datasource/ShopWindowDataSourceConfig;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Boolean;Lcom/bytedance/android/window/shop/repository/tab/entity/WindowLayoutType;ZLjava/lang/String;Ljava/lang/String;)V", "", "tabType", "prepareDataSource", "(Ljava/lang/String;Ljava/lang/Integer;)V", "Lcom/bytedance/android/window/shop/repository/tab/datasource/c;", "cb", "setCallback", "loadData", "Lcom/bytedance/android/window/shop/home/tab/tabplugin/TabNavigationParams;", "naviParams", "fillNaviParam", "refreshAndLoadData", "Lcom/bytedance/android/window/shop/home/tab/tabplugin/WindowNavigationParam;", "refreshSubTabs", "(Ljava/lang/Long;Ljava/lang/Boolean;Lcom/bytedance/android/window/shop/repository/tab/entity/WindowLayoutType;Lcom/bytedance/android/window/shop/home/tab/tabplugin/WindowNavigationParam;)V", "subCategoryId", "(Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/String;Lcom/bytedance/android/window/shop/repository/tab/entity/WindowLayoutType;Lcom/bytedance/android/window/shop/home/tab/tabplugin/WindowNavigationParam;)V", "secAuthorId", "passThroughParam", "Lcom/bytedance/android/window/shop/repository/dto/WindowTabDataListResponseDTODeprecated;", "initCache", "init", "clearDataSource", "holderUniqueKey", "", "requestParams", "", "excludedList", "Lkotlin/Function0;", "resultNotifier", "prefetchInsertData", "", "Lcom/bytedance/android/window/shop/repository/tab/entity/f;", "consumeTabInsertData", "vo", "Lip3/b;", "makeItemClickedEvent", "onCleared", "Lkotlin/reflect/KFunction1;", "nearestDynamicInsertDistanceFetcher", "Lkotlin/reflect/KFunction;", "getNearestDynamicInsertDistanceFetcher", "()Lkotlin/reflect/KFunction;", "setNearestDynamicInsertDistanceFetcher", "(Lkotlin/reflect/KFunction;)V", "Lkotlin/reflect/KFunction2;", "surroundedItemFetcher", "getSurroundedItemFetcher", "setSurroundedItemFetcher", "lastId", "Ljava/lang/Long;", "lastAscend", "Ljava/lang/Boolean;", "lastForceInsertInfo", "Ljava/lang/String;", "Ljava/lang/Integer;", "Lio/reactivex/disposables/CompositeDisposable;", "ignorableDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "Lqq3/c;", "dataSource", "Lqq3/c;", "lifecycleMonitorId", "J", "getLifecycleMonitorId", "()J", "setLifecycleMonitorId", "(J)V", "Ljava/util/concurrent/ConcurrentHashMap;", "tabResultCache", "Ljava/util/concurrent/ConcurrentHashMap;", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowTabViewModel extends BaseWindowTabViewModel {
    private qq3.c dataSource;
    private final CompositeDisposable ignorableDisposable;
    private Boolean lastAscend;
    private String lastForceInsertInfo;
    private Long lastId;
    private long lifecycleMonitorId;
    private KFunction<Integer> nearestDynamicInsertDistanceFetcher;
    private KFunction<? extends List<String>> surroundedItemFetcher;
    private final ConcurrentHashMap<String, List<com.bytedance.android.window.shop.repository.tab.entity.f>> tabResultCache;
    private Integer tabType;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ WindowTabViewModel a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Function0 c;

        public a(WindowTabViewModel r1, String r2, Function0 r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r3) {
            Map<Integer, com.bytedance.android.window.shop.repository.tab.datasource.mapping.f> r0 = WindowDataMapper.a;
            List r4 = WindowDataMapper.c(((WindowTabDataListResponseDTODeprecated) r3).getMixFullCards());
            if ((!((ArrayList) r4).isEmpty()) == false) goto L6;
            WindowTabViewModel.access$getTabResultCache$p(this.a).put(this.b, r4);
            this.c.invoke();
            return;
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
            ECExceptionMonitor.e((Throwable) r1);
        }
    }

    public final void clearDataSource() {
        qq3.c r0 = this.dataSource;
        r0.c = null;
        r0.b();
    }

    @Override // com.bytedance.android.window.shop.home.tab.BaseTabViewModel
    public void loadData() {
        this.dataSource.h();
    }

    public WindowTabViewModel() {
        this.ignorableDisposable = new CompositeDisposable();
        qq3.c r0 = new qq3.c();
        r0.a(getInterceptors());
        Unit r1 = Unit.INSTANCE;
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

    public final long getLifecycleMonitorId() {
        return this.lifecycleMonitorId;
    }

    public final KFunction<Integer> getNearestDynamicInsertDistanceFetcher() {
        return this.nearestDynamicInsertDistanceFetcher;
    }

    public final KFunction<List<String>> getSurroundedItemFetcher() {
        return this.surroundedItemFetcher;
    }

    public static final /* synthetic */ String access$getLastForceInsertInfo$p(WindowTabViewModel r0) {
        return r0.lastForceInsertInfo;
    }

    public static final /* synthetic */ ConcurrentHashMap access$getTabResultCache$p(WindowTabViewModel r0) {
        return r0.tabResultCache;
    }

    public final List<com.bytedance.android.window.shop.repository.tab.entity.f> consumeTabInsertData(String r2) {
        Intrinsics.checkNotNullParameter(r2, "holderUniqueKey");
        List<com.bytedance.android.window.shop.repository.tab.entity.f> r3 = this.tabResultCache.remove(r2);
        if (r3 == null) goto L5;
        return r3;
    L5:
        return CollectionsKt.emptyList();
    }

    public final void fillNaviParam(TabNavigationParams r3) {
        qq3.c r0 = this.dataSource;
        if (r3 != null) goto L5;
        r0.getClass();
    L9:
        if (r3 == null) goto L13;
        WindowNavigationParam<String> r4 = r3.getForceInsertInfo();
        if (r4 == null) goto L13;
        WindowNavigationParam.a r1 = WindowNavigationParam.Companion;
        String r2 = this.lastForceInsertInfo;
        r1.getClass();
        String r5 = (String) WindowNavigationParam.a.a(r4, r2);
    L14:
        this.lastForceInsertInfo = r5;
        return;
    L13:
        r5 = null;
        goto L14
    L5:
        com.bytedance.android.window.shop.repository.tab.datasource.impl.a<? extends mq3.a, ? extends ShopWindowDataSourceConfig<? extends mq3.a>> r6 = r0.d;
        if (r6 == null) goto L9;
        ((mq3.a) r6.e.b()).fillWithNaviParams(r3);
        goto L9
    }

    public final ip3.b makeItemClickedEvent(com.bytedance.android.window.shop.repository.tab.entity.f r12) {
        Intrinsics.checkNotNullParameter(r12, "vo");
        Function2 r0 = this.surroundedItemFetcher;
        Integer r1 = null;
        if (r0 == null) goto L7;
        List r2 = (List) r0.invoke(r12, 10);
        if (r2 == null) goto L7;
        String r3 = CollectionsKt.joinToString$default(r2, ",", null, null, 0, null, null, 62, null);
    L8:
        Function1 r4 = this.nearestDynamicInsertDistanceFetcher;
        if (r4 == null) goto L11;
        r1 = (Integer) r4.invoke(r12);
    L11:
        String r8 = getLastCategoryId();
        if (r3 != null) goto L14;
        r3 = "";
    L14:
        String r7 = r3;
        if (r1 == null) goto L17;
        int r9 = r1.intValue();
    L18:
        Intrinsics.checkNotNullParameter(r12, "$this$getVoGenericData");
        Intrinsics.checkNotNullParameter(r8, "categoryId");
        Intrinsics.checkNotNullParameter(r7, "surroundedProductIds");
        String r5 = s.a(r12);
        if (r5 != null) goto L31;
        Intrinsics.checkNotNullParameter(r12, "$this$generateUniqueId");
        r5 = r12.c;
        if (r5 != null) goto L31;
        com.bytedance.android.window.shop.repository.tab.entity.g r6 = com.bytedance.android.window.shop.repository.tab.entity.g.b;
        monitor-enter(r6);
        com.bytedance.android.window.shop.repository.tab.entity.g.a++;     // Catch: Throwable -> L28
        long r10 = com.bytedance.android.window.shop.repository.tab.entity.g.a;     // Catch: Throwable -> L28
        monitor-exit(r6);
        r5 = String.valueOf(r10);
        r12.f.d(m0.c, r5);
    L28:
        th = move-exception;
        throw th;
    L31:
        String r11 = r5;
        int r13 = r12.i;
        Intrinsics.checkNotNullParameter(r12, "$this$removeInsertRequestKey");
        Map r14 = (Map) r12.f.c(m0.a);
        if (r14 == null) goto L34;
        r12.f.d(m0.b, r14);
    L34:
        if (r14 != null) goto L36;
        Map r15 = MapsKt.emptyMap();
    L38:
        return new ip3.b(new ip3.a(r13, r11, r15, r7, r8, r9));
    L36:
        r15 = r14;
        goto L38
    L17:
        r9 = Integer.MAX_VALUE;
    L7:
        r3 = null;
        goto L8
    }

    @Override // com.bytedance.android.window.shop.home.BaseWindowTabViewModel
    public void prepareDataSource(String r4) {
        Intrinsics.checkNotNullParameter(r4, "categoryId");
        setLastCategoryId(r4);
        this.dataSource.g(new CategoryRequestParamKey(getLastCategoryId(), this.tabType), null);
    }

    public final void refreshAndLoadData(WindowLayoutType r8) {
        Intrinsics.checkNotNullParameter(r8, "layoutType");
        refreshSubTabs(this.lastId, this.lastAscend, getLastSubCategoryId(), r8, null);
    }

    public final void setCallback(com.bytedance.android.window.shop.repository.tab.datasource.c r2) {
        Intrinsics.checkNotNullParameter(r2, "cb");
        this.dataSource.c = r2;
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

    public static final /* synthetic */ void access$setLastForceInsertInfo$p(WindowTabViewModel r0, String r1) {
        r0.lastForceInsertInfo = r1;
    }

    public final void prepareDataSource(String r3, Integer r4) {
        Intrinsics.checkNotNullParameter(r3, "categoryId");
        this.tabType = r4;
        if (r4 != null) goto L5;
        prepareDataSource(r3);
        return;
    L5:
        setLastCategoryId(r3);
        this.dataSource.g(new CategoryRequestParamKey(getLastCategoryId(), r4), null);
    }

    public final void refreshAndLoadData(String r8, WindowLayoutType r9) {
        Intrinsics.checkNotNullParameter(r8, "subcategoryId");
        Intrinsics.checkNotNullParameter(r9, "layoutType");
        refreshSubTabs(this.lastId, this.lastAscend, r8, r9, null);
    }

    public final void init(String r3, String r4, WindowTabDataListResponseDTODeprecated r5) {
        Intrinsics.checkNotNullParameter(r3, "secAuthorId");
        this.dataSource.i(r5, r3, null, r4);
    }

    public final void refreshSubTabs(Long r8, Boolean r9, WindowLayoutType r10, WindowNavigationParam<String> r11) {
        Intrinsics.checkNotNullParameter(r10, "layoutType");
        refreshSubTabs(r8, r9, getLastSubCategoryId(), r10, r11);
    }

    public final void refreshSubTabs(final Long r14, final Boolean r15, String r16, final WindowLayoutType r17, final WindowNavigationParam<String> r18) {
        Intrinsics.checkNotNullParameter(r17, "layoutType");
        this.lastId = r14;
        this.lastAscend = r15;
        if (r16 != null) goto L5;
        String r0 = "";
    L6:
        setLastSubCategoryId(r0);
        this.dataSource.b();
        qq3.c r1 = this.dataSource;
        final com.bytedance.android.window.shop.repository.tab.datasource.c r4 = r1.c;
        r1.c = null;
        final String r2 = r1.a;
        final String r3 = r1.b;
        qq3.c r10 = new qq3.c();
        r10.a = r2;
        r10.b = r3;
        r10.c = r4;
        r10.g(new CategoryRequestParamKey(getLastCategoryId(), this.tabType), new WindowTabViewModel$refreshSubTabs$$inlined$apply$lambda$1(this, r2, r3, r4, r14, r15, r17, r18));
        r10.a(getInterceptors());
        Unit r5 = Unit.INSTANCE;
        this.dataSource = r10;
        loadData();
        return;
    L5:
        r0 = r16;
        goto L6
    }

    public final void prefetchInsertData(String r21, String r22, Map<String, String> r23, Set<String> r24, String r25, Function0<Unit> r26) {
        Intrinsics.checkNotNullParameter(r21, "holderUniqueKey");
        Intrinsics.checkNotNullParameter(r22, "secAuthorId");
        Intrinsics.checkNotNullParameter(r23, "requestParams");
        Intrinsics.checkNotNullParameter(r24, "excludedList");
        Intrinsics.checkNotNullParameter(r26, "resultNotifier");
        ShopRepository r9 = ShopRepository.a;
        String r10 = getLastCategoryId();
        r9.getClass();
        Intrinsics.checkNotNullParameter(r22, "secAuthorId");
        Intrinsics.checkNotNullParameter(r10, "category");
        Intrinsics.checkNotNullParameter(r23, "requestParams");
        Intrinsics.checkNotNullParameter(r24, "excludedList");
        int r11 = kq3.a.a;
        Intrinsics.checkNotNullParameter(r22, "secAuthorId");
        Intrinsics.checkNotNullParameter(r10, "category");
        Intrinsics.checkNotNullParameter(r23, "requestParams");
        Intrinsics.checkNotNullParameter(r24, "excludedList");
        ECWindowApi.a.getClass();
        ECWindowApi r4 = ECWindowApi.a.a;
        if (r4 == null) goto L6;
        Observable<WindowTabDataListResponseDTODeprecated> r2 = r4.getShopTabInsertData(r22, r10, CollectionsKt.joinToString$default(r24, null, null, null, 0, null, null, 63, null), r25, r23);
        if (r2 == null) goto L6;
    L7:
        Disposable r1 = bg4.b.b(r2).subscribe(new a(this, r21, r26), b.a);
        this.ignorableDisposable.add(r1);
        return;
    L6:
        r2 = Observable.error(new Throwable("ECNetworkService not init"));
        goto L7
    }

    private final void tryFillDataSourceConfig(ShopWindowDataSourceConfig<?> r1, String r2, String r3, Long r4, Boolean r5, WindowLayoutType r6, boolean r7, String r8, String r9) {
        if ((r1 instanceof com.bytedance.android.window.shop.repository.tab.datasource.g) == false) goto L13;
        com.bytedance.android.window.shop.repository.tab.datasource.g r10 = (com.bytedance.android.window.shop.repository.tab.datasource.g) r1;
        r10.getClass();
        r10.d = r7;
        r10.b().setTargetFilterType(k.j(r9));
        r10.b().setForceInsertInfo(r8);
        WindowProductTabRequestParam r11 = r10.b();
        if (r2 != null) goto L7;
        r2 = "-1";
    L7:
        r11.setTargetCategory(r2);
        WindowProductTabRequestParam r12 = r10.b();
        if (r3 != null) goto L10;
        r3 = "";
    L10:
        r12.setTargetSubCategory(r3);
        r10.b().setSortType(r4);
        r10.b().setSort(com.bytedance.android.window.shop.repository.tab.datasource.a.a(r5));
        return;
    L13:
        if ((r1 instanceof com.bytedance.android.window.shop.repository.tab.datasource.b) == false) goto L16;
        ((com.bytedance.android.window.shop.repository.tab.datasource.b) r1).b().setForceInsertInfo(r8);
        return;
    }

    public static final /* synthetic */ void access$tryFillDataSourceConfig(WindowTabViewModel r0, ShopWindowDataSourceConfig r1, String r2, String r3, Long r4, Boolean r5, WindowLayoutType r6, boolean r7, String r8, String r9) {
        r0.tryFillDataSourceConfig(r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }
}
