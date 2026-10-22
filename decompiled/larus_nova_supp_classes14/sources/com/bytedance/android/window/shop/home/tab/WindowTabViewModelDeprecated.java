package com.bytedance.android.window.shop.home.tab;

import com.bytedance.android.window.shop.home.tab.common.TabTypeRequestParamKey;
import com.bytedance.android.window.shop.home.tab.tabplugin.TabNavigationParams;
import com.bytedance.android.window.shop.home.tab.tabplugin.WindowNavigationParam;
import com.bytedance.android.window.shop.repository.dto.WindowTabDataListResponseDTODeprecated;
import com.bytedance.android.window.shop.repository.tab.datasource.ShopWindowDataSourceConfig;
import com.bytedance.android.window.shop.repository.tab.entity.WindowLayoutType;
import com.bytedance.android.window.shop.repository.tab.entity.WindowProductCategoryVODeprecated;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b?\u0010@JS\u0010\u000f\u001a\u00020\u000e2\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0011J\u000e\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0014J\b\u0010\u0017\u001a\u00020\u000eH\u0016J\u0010\u0010\u001a\u001a\u00020\u000e2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018J\u000e\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\nJ\u0016\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nJC\u0010\u001e\u001a\u00020\u000e2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000b\u001a\u00020\n2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001d¢\u0006\u0004\b\u001e\u0010\u001fJ,\u0010$\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u00042\b\u0010!\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010#\u001a\u0004\u0018\u00010\"J\u0006\u0010%\u001a\u00020\u000eR\u0018\u0010&\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010(\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010*\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0018\u0010,\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010+R$\u0010.\u001a\u0004\u0018\u00010-8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u0016\u00105\u001a\u0002048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R\"\u0010\u0012\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u0016\u0010=\u001a\u00020<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>¨\u0006A"}, d2 = {"Lcom/bytedance/android/window/shop/home/tab/WindowTabViewModelDeprecated;", "Lcom/bytedance/android/window/shop/home/tab/BaseTabViewModel;", "Lcom/bytedance/android/window/shop/repository/tab/datasource/ShopWindowDataSourceConfig;", "config", "", "categoryId", "", "id", "", "ascend", "Lcom/bytedance/android/window/shop/repository/tab/entity/WindowLayoutType;", "layoutType", "isFirstRequest", "forceInsertInfo", "", "tryFillDataSourceConfig", "(Lcom/bytedance/android/window/shop/repository/tab/datasource/ShopWindowDataSourceConfig;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Boolean;Lcom/bytedance/android/window/shop/repository/tab/entity/WindowLayoutType;ZLjava/lang/String;)V", "Lcom/bytedance/android/window/shop/c;", "shopWindowItemType", "prepareDataSource", "Lcom/bytedance/android/window/shop/repository/tab/datasource/c;", "cb", "setCallback", "loadData", "Lcom/bytedance/android/window/shop/home/tab/tabplugin/TabNavigationParams;", "naviParams", "fillNaviParam", "refreshAndLoadData", "refreshSubTabsByCategory", "Lcom/bytedance/android/window/shop/home/tab/tabplugin/WindowNavigationParam;", "refreshSubTabs", "(Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/String;Lcom/bytedance/android/window/shop/repository/tab/entity/WindowLayoutType;Lcom/bytedance/android/window/shop/home/tab/tabplugin/WindowNavigationParam;)V", "secAuthorId", "passThroughParam", "Lcom/bytedance/android/window/shop/repository/dto/WindowTabDataListResponseDTODeprecated;", "initCache", "init", "clearDataSource", "lastId", "Ljava/lang/Long;", "lastAscend", "Ljava/lang/Boolean;", "lastCategoryId", "Ljava/lang/String;", "lastForceInsertInfo", "Lcom/bytedance/android/window/shop/repository/tab/entity/WindowProductCategoryVODeprecated$a;", "category", "Lcom/bytedance/android/window/shop/repository/tab/entity/WindowProductCategoryVODeprecated$a;", "getCategory", "()Lcom/bytedance/android/window/shop/repository/tab/entity/WindowProductCategoryVODeprecated$a;", "setCategory", "(Lcom/bytedance/android/window/shop/repository/tab/entity/WindowProductCategoryVODeprecated$a;)V", "Lcom/bytedance/android/window/shop/home/tab/common/TabTypeRequestParamKey;", "currentTabType", "Lcom/bytedance/android/window/shop/home/tab/common/TabTypeRequestParamKey;", "Lcom/bytedance/android/window/shop/c;", "getShopWindowItemType", "()Lcom/bytedance/android/window/shop/c;", "setShopWindowItemType", "(Lcom/bytedance/android/window/shop/c;)V", "Lqq3/a;", "dataSource", "Lqq3/a;", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowTabViewModelDeprecated extends BaseTabViewModel {
    private WindowProductCategoryVODeprecated.a category;
    private TabTypeRequestParamKey currentTabType;
    private qq3.a dataSource;
    private Boolean lastAscend;
    private String lastCategoryId;
    private String lastForceInsertInfo;
    private Long lastId;
    private com.bytedance.android.window.shop.c shopWindowItemType;

    public final void clearDataSource() {
        qq3.a r0 = this.dataSource;
        r0.c = null;
        r0.b();
    }

    @Override // com.bytedance.android.window.shop.home.tab.BaseTabViewModel
    public void loadData() {
        this.dataSource.h();
    }

    public WindowTabViewModelDeprecated() {
        ConcurrentHashMap<Integer, com.bytedance.android.window.shop.c> r1 = com.bytedance.android.window.shop.c.b;
        com.bytedance.android.window.shop.c r2 = com.bytedance.android.window.shop.c.c;
        this.currentTabType = new TabTypeRequestParamKey(r2.getType());
        this.shopWindowItemType = r2;
        qq3.a r0 = new qq3.a();
        r0.a(getInterceptors());
        Unit r3 = Unit.INSTANCE;
        this.dataSource = r0;
    }

    public final WindowProductCategoryVODeprecated.a getCategory() {
        return this.category;
    }

    public final com.bytedance.android.window.shop.c getShopWindowItemType() {
        return this.shopWindowItemType;
    }

    public static final /* synthetic */ Boolean access$getLastAscend$p(WindowTabViewModelDeprecated r0) {
        return r0.lastAscend;
    }

    public static final /* synthetic */ String access$getLastCategoryId$p(WindowTabViewModelDeprecated r0) {
        return r0.lastCategoryId;
    }

    public static final /* synthetic */ String access$getLastForceInsertInfo$p(WindowTabViewModelDeprecated r0) {
        return r0.lastForceInsertInfo;
    }

    public static final /* synthetic */ Long access$getLastId$p(WindowTabViewModelDeprecated r0) {
        return r0.lastId;
    }

    public final void fillNaviParam(TabNavigationParams r3) {
        qq3.a r0 = this.dataSource;
        if (r3 != null) goto L5;
        r0.getClass();
    L9:
        WindowNavigationParam<String> r1 = null;
        if (r3 == null) goto L12;
        Long r2 = r3.getSortType();
    L13:
        if (r2 == null) goto L15;
        this.lastId = r3.getSortType();
    L15:
        WindowNavigationParam.a r4 = WindowNavigationParam.Companion;
        if (r3 == null) goto L18;
        r1 = r3.getForceInsertInfo();
    L18:
        String r5 = this.lastForceInsertInfo;
        r4.getClass();
        this.lastForceInsertInfo = (String) WindowNavigationParam.a.a(r1, r5);
        return;
    L12:
        r2 = null;
        goto L13
    L5:
        com.bytedance.android.window.shop.repository.tab.datasource.impl.a<? extends mq3.a, ? extends ShopWindowDataSourceConfig<? extends mq3.a>> r6 = r0.d;
        if (r6 == null) goto L9;
        ((mq3.a) r6.e.b()).fillWithNaviParams(r3);
        goto L9
    }

    public final void prepareDataSource(com.bytedance.android.window.shop.c r3) {
        Intrinsics.checkNotNullParameter(r3, "shopWindowItemType");
        TabTypeRequestParamKey r0 = new TabTypeRequestParamKey(r3.getType());
        this.currentTabType = r0;
        this.dataSource.g(r0, null);
    }

    public final void refreshAndLoadData(WindowLayoutType r8) {
        Intrinsics.checkNotNullParameter(r8, "layoutType");
        refreshSubTabs(this.lastId, this.lastAscend, this.lastCategoryId, r8, null);
    }

    public final void setCallback(com.bytedance.android.window.shop.repository.tab.datasource.c r2) {
        Intrinsics.checkNotNullParameter(r2, "cb");
        this.dataSource.c = r2;
    }

    public final void setCategory(WindowProductCategoryVODeprecated.a r1) {
        this.category = r1;
    }

    public final void setShopWindowItemType(com.bytedance.android.window.shop.c r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.shopWindowItemType = r2;
    }

    public static final /* synthetic */ void access$setLastAscend$p(WindowTabViewModelDeprecated r0, Boolean r1) {
        r0.lastAscend = r1;
    }

    public static final /* synthetic */ void access$setLastCategoryId$p(WindowTabViewModelDeprecated r0, String r1) {
        r0.lastCategoryId = r1;
    }

    public static final /* synthetic */ void access$setLastForceInsertInfo$p(WindowTabViewModelDeprecated r0, String r1) {
        r0.lastForceInsertInfo = r1;
    }

    public static final /* synthetic */ void access$setLastId$p(WindowTabViewModelDeprecated r0, Long r1) {
        r0.lastId = r1;
    }

    public final void refreshSubTabsByCategory(String r8, WindowLayoutType r9) {
        Intrinsics.checkNotNullParameter(r8, "categoryId");
        Intrinsics.checkNotNullParameter(r9, "layoutType");
        refreshSubTabs(this.lastId, this.lastAscend, r8, r9, null);
    }

    public final void init(String r2, String r3, WindowLayoutType r4, WindowTabDataListResponseDTODeprecated r5) {
        Intrinsics.checkNotNullParameter(r2, "secAuthorId");
        this.dataSource.i(r5, r2, r4, r3);
    }

    public final void refreshSubTabs(Long r8, Boolean r9, String r10, final WindowLayoutType r11, final WindowNavigationParam<String> r12) {
        Intrinsics.checkNotNullParameter(r11, "layoutType");
        if (r8 == null) goto L5;
        this.lastId = r8;
    L5:
        if (r9 == null) goto L7;
        this.lastAscend = r9;
    L7:
        if (r10 == null) goto L9;
        this.lastCategoryId = r10;
    L9:
        this.dataSource.b();
        qq3.a r13 = this.dataSource;
        final com.bytedance.android.window.shop.repository.tab.datasource.c r4 = r13.c;
        r13.c = null;
        final String r2 = r13.a;
        final String r3 = r13.b;
        qq3.a r14 = new qq3.a();
        r14.a = r2;
        r14.b = r3;
        r14.c = r4;
        r14.g(this.currentTabType, new WindowTabViewModelDeprecated$refreshSubTabs$$inlined$apply$lambda$1(this, r2, r3, r4, r11, r12));
        r14.a(getInterceptors());
        Unit r15 = Unit.INSTANCE;
        this.dataSource = r14;
        loadData();
    }

    private final void tryFillDataSourceConfig(ShopWindowDataSourceConfig<?> r2, String r3, Long r4, Boolean r5, WindowLayoutType r6, boolean r7, String r8) {
        if ((r2 instanceof com.bytedance.android.window.shop.repository.tab.datasource.d) == false) goto L7;
        com.bytedance.android.window.shop.repository.tab.datasource.d r9 = (com.bytedance.android.window.shop.repository.tab.datasource.d) r2;
        r9.d = r6;
        r9.e = r7;
        r9.b().setForceInsertInfo(r8);
        r9.b().setTargetCategory(r3);
        r9.b().setSortType(r4);
        r9.b().setSort(com.bytedance.android.window.shop.repository.tab.datasource.a.a(r5));
        return;
    L7:
        if ((r2 instanceof com.bytedance.android.window.shop.repository.tab.datasource.b) == false) goto L10;
        ((com.bytedance.android.window.shop.repository.tab.datasource.b) r2).b().setForceInsertInfo(r8);
        return;
    }

    public static final /* synthetic */ void access$tryFillDataSourceConfig(WindowTabViewModelDeprecated r0, ShopWindowDataSourceConfig r1, String r2, Long r3, Boolean r4, WindowLayoutType r5, boolean r6, String r7) {
        r0.tryFillDataSourceConfig(r1, r2, r3, r4, r5, r6, r7);
    }
}
