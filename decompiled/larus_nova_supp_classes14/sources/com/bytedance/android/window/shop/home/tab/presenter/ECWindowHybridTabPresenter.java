package com.bytedance.android.window.shop.home.tab.presenter;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.monitor.MonitorScenes;
import com.bytedance.android.ec.core.monitor.RecyclerViewPerformanceMonitor;
import com.bytedance.android.ec.hybrid.list.ECHybridListAdapter;
import com.bytedance.android.ec.hybrid.list.ECHybridListEngine;
import com.bytedance.android.ec.hybrid.list.ability.j0;
import com.bytedance.android.ec.hybrid.list.ability.k0;
import com.bytedance.android.ec.hybrid.list.ability.l0;
import com.bytedance.android.ec.hybrid.list.ability.m0;
import com.bytedance.android.ec.hybrid.list.entity.ECHybridListItemVO;
import com.bytedance.android.ec.hybrid.list.entity.ECItemOperationType;
import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;
import com.bytedance.android.ec.hybrid.list.view.ECHybridRecyclerView;
import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import com.bytedance.android.ec.window.base.status.WindowLazyStatusView;
import com.bytedance.android.window.shop.WindowLaunchTask;
import com.bytedance.android.window.shop.holder.footer.FooterStatus;
import com.bytedance.android.window.shop.home.WindowTabExtViewModel;
import com.bytedance.android.window.shop.home.presenter.plugin.ECWindowSoundChangedNotifierPlugin;
import com.bytedance.android.window.shop.home.tab.WindowHybridTabViewModel;
import com.bytedance.android.window.shop.home.tab.common.CategoryRequestParamKey;
import com.bytedance.android.window.shop.home.tab.common.WindowConstDef;
import com.bytedance.android.window.shop.home.tab.tabplugin.ECWindowPlayAbilityPlugin;
import com.bytedance.android.window.shop.home.tab.tabplugin.ECWindowTabNewProductPlugin;
import com.bytedance.android.window.shop.home.tabcard.ECWindowHybridTabCardViewModel;
import com.bytedance.android.window.shop.home.viewmodel.ECWindowViewModel;
import com.bytedance.android.window.shop.lifecycle.WindowBusinessMonitor;
import com.bytedance.android.window.shop.repository.compat.WindowTabInfoProvider;
import com.bytedance.android.window.shop.repository.dto.WindowHybridTabDataListResponseDTO;
import com.bytedance.android.window.shop.repository.tab.datasource.ShopWindowVODataType;
import com.bytedance.android.window.shop.repository.tab.entity.WindowLayoutType;
import com.bytedance.android.window.shop.repository.tab.entity.n0;
import com.bytedance.android.window.shop.widget.ToolBarView;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import io.reactivex.subjects.ReplaySubject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import zq3.v1;
import zq3.w1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/window/shop/home/tab/presenter/ECWindowHybridTabPresenter;", "Lcom/ss/android/ugc/aweme/kiwi/presenter/QFragmentPresenter;", "Lcom/bytedance/android/window/shop/repository/tab/datasource/c;", "Landroidx/lifecycle/LifecycleEventObserver;", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECWindowHybridTabPresenter extends QFragmentPresenter implements com.bytedance.android.window.shop.repository.tab.datasource.c, LifecycleEventObserver {
    public int A;
    public final ECWindowHybridTabPresenter$scrollListener$1 B;
    public final Fragment C;
    public final fo.b f;
    public com.bytedance.android.window.shop.repository.tab.entity.q g;
    public com.bytedance.android.window.shop.holder.footer.a h;
    public final Lazy i;
    public final Lazy j;
    public final Lazy k;
    public final Lazy l;
    public final Lazy m;
    public final Lazy n;
    public final Lazy o;
    public ToolBarView p;
    public final List<Runnable> q;
    public final Lazy r;
    public final com.bytedance.android.window.shop.home.tab.tabplugin.f s;
    public final ReplaySubject<ToolBarView> t;
    public boolean u;
    public final h v;
    public boolean w;
    public final Lazy x;
    public final d y;
    public final ECWindowHybridTabPresenter$holderBindProcessorManager$1 z;

    public final class a extends com.bytedance.android.ec.hybrid.list.ability.q {
        public final Function2<w1, String, Unit> a;
        public final /* synthetic */ ECWindowHybridTabPresenter b;

        /* JADX WARN: Multi-variable type inference failed */
        public a(ECWindowHybridTabPresenter r2, Function2<? super w1, ? super String, Unit> r3) {
            Intrinsics.checkNotNullParameter(r3, "renderCallback");
            this.b = r2;
            this.a = r3;
        }

        public final void a(BaseViewHolder r4, ECHybridListItemVO r5) {
            Intrinsics.checkNotNullParameter(r4, "holder");
            String r6 = null;
            if (r5 == null) goto L5;
            Object r0 = c0.c(r5);
        L7:
            if ((r0 instanceof com.bytedance.android.window.shop.repository.tab.entity.f) == true) goto L9;
            r0 = null;
        L9:
            com.bytedance.android.window.shop.repository.tab.entity.f r1 = (com.bytedance.android.window.shop.repository.tab.entity.f) r0;
            if (r1 == null) goto L16;
            WindowV2ProductItemVO r2 = r1.c();
            if (r2 == null) goto L16;
            Map r3 = r2.q;
            if (r3 == null) goto L16;
            String r7 = (String) r3.get("request_id");
        L17:
            if (r7 != null) goto L20;
            r7 = "";
        L20:
            if ((!StringsKt.isBlank(r7)) == false) goto L22;
            this.b.l0().registerExtension(com.bytedance.android.window.shop.home.tab.tabplugin.g.f, r7);
        L22:
            Function2<w1, String, Unit> r8 = this.a;
            w1 r9 = this.b.l0().getTabPerformanceWatcher();
            if (r5 == null) goto L25;
            r6 = r5.d;
        L25:
            r8.invoke(r9, r6);
            return;
        L16:
            r7 = null;
            goto L17
        L5:
            r0 = null;
            goto L7
        }
    }

    public static final class b implements com.bytedance.android.window.shop.home.viewmodel.b {
        public final /* synthetic */ ECWindowHybridTabPresenter a;

        @Override // com.bytedance.android.window.shop.home.viewmodel.b
        public final void onRefresh() {
            ((WindowTabExtViewModel) this.a.k.getValue()).dropAll();
            this.a.l0().dropRecords(new fo.a[]{wn.a.n});
        }

        public b(ECWindowHybridTabPresenter r1) {
            this.a = r1;
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ ECWindowHybridTabPresenter a;

        public c(ECWindowHybridTabPresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            Pair r4 = (Pair) r3;
            ECWindowHybridTabPresenter r5 = this.a;
            List<Runnable> r0 = r5.q;
            ArrayList r1 = (ArrayList) r0;
            r1.remove(r5.v);
            ECWindowHybridTabPresenter r6 = this.a;
            ListProtector.add(r6.q, 0, r6.v);
        }
    }

    public static final class d implements com.bytedance.android.ec.hybrid.list.ability.b {
        public final /* synthetic */ ECWindowHybridTabPresenter a;

        public d(ECWindowHybridTabPresenter r1) {
            this.a = r1;
        }

        public final void a(int r3) {
            this.a.l0().setLastBindPosition(RangesKt.coerceAtLeast(this.a.l0().getLastBindPosition(), r3));
        }
    }

    public static final class e<T> implements com.ss.android.ugc.aweme.compat.nullable.Observer {
        public final /* synthetic */ ECWindowHybridTabPresenter a;

        public e(ECWindowHybridTabPresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            if (this.a.C.getLifecycle().getCurrentState() != Lifecycle.State.RESUMED) goto L10;
            this.a.i0().stopScroll();
            LinearLayoutManager r3 = this.a.i0().getLayoutManager();
            if ((r3 instanceof LinearLayoutManager) == true) goto L7;
            r3 = null;
        L7:
            if (r3 == null) goto L11;
            r3.scrollToPosition(0);
            return;
        L11:
            return;
        }
    }

    public static final class f implements Runnable {
        public final /* synthetic */ ECWindowHybridTabPresenter a;
        public final /* synthetic */ n0 b;

        public f(ECWindowHybridTabPresenter r1, n0 r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.p0(this.b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class g implements Runnable {
        public final /* synthetic */ ECWindowHybridTabPresenter a;

        public g(ECWindowHybridTabPresenter r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.d0();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class h implements Runnable {
        public final /* synthetic */ ECWindowHybridTabPresenter a;

        public h(ECWindowHybridTabPresenter r1) {
            this.a = r1;
        }

        public final void a() {
            fo.a<WindowLayoutType> r0 = WindowConstDef.a;
            if (((Boolean) WindowConstDef.x.getValue()).booleanValue() == true) goto L5;
            return;
        L5:
            Pair r1 = (Pair) this.a.j0().getLayoutStatus().getValue();
            if (r1 != null) goto L9;
            return;
        L9:
            if (Intrinsics.areEqual(this.a.l0().getLastCategoryId(), (String) r1.getFirst()) == false) goto L11;
            return;
        L11:
            this.a.s0((WindowLayoutType) r1.getSecond());
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // com.bytedance.android.window.shop.repository.tab.datasource.c
    public final void e() {
    }

    public final ECHybridListEngine e0() {
        return (ECHybridListEngine) this.x.getValue();
    }

    public final ECHybridRecyclerView i0() {
        return (ECHybridRecyclerView) this.o.getValue();
    }

    public final ECWindowViewModel j0() {
        return (ECWindowViewModel) this.i.getValue();
    }

    public final WindowLazyStatusView k0() {
        return (WindowLazyStatusView) this.m.getValue();
    }

    public final WindowHybridTabViewModel l0() {
        return (WindowHybridTabViewModel) this.j.getValue();
    }

    public final synchronized void n0() {
        monitor-enter(this);
    L12:
    L9:
        th = move-exception;
        throw th;
    L4:
        if ((!this.q.isEmpty()) == false) goto L7;
        ((Runnable) ListProtector.remove(this.q, 0)).run();     // Catch: Throwable -> L9
        goto L12
    L7:
        monitor-exit(this);
    }

    public final void c0() {
        this.s.b();
    }

    public final void d0() {
        com.bytedance.android.window.shop.holder.footer.a r0 = this.h;
        if (r0 == null) goto L6;
        r0.J1(FooterStatus.NO_MORE);
    L6:
        if (c0.f(e0().c.g) == false) goto L8;
        k0().b(com.bytedance.android.ec.window.base.status.c.b.a);
        return;
    L8:
        k0().a();
    }

    public final WindowLayoutType h0() {
        WindowLayoutType r0 = j0().getHeaderSubTabsParam().b;
        if (r0 != null) goto L5;
        fo.b r1 = this.f;
        fo.a<WindowLayoutType> r2 = WindowConstDef.a;
        r0 = (WindowLayoutType) r1.a(WindowConstDef.a);
    L5:
        if (r0 == null) goto L7;
        return r0;
    L7:
        return WindowLayoutType.SINGLECOLUMN;
    }

    public final void o0() {
        l0().init(j0().getShopParam().getSecAuthorId(), (String) j0().getShopParam().getPassThroughParam("pass_through_api"), (WindowHybridTabDataListResponseDTO) j0().getHeaderSubTabsParam().d.getValue(), j0().getShopParam(), j0().getEntranceInfoJsonObject());
        l0().fillNaviParam(j0().getShopParam().removeAnchorParam(new CategoryRequestParamKey(l0().getLastCategoryId(), null, 2, null)));
        l0().loadData();
        ConcurrentHashMap<Long, com.bytedance.android.window.shop.lifecycle.f> r0 = com.bytedance.android.window.shop.lifecycle.c.a;
        com.bytedance.android.window.shop.lifecycle.f r1 = com.bytedance.android.window.shop.lifecycle.c.a(l0().getLifecycleMonitorId());
        if (r1 == null) goto L6;
        r1.b();
        return;
    }

    /* JADX WARN: Type inference failed for: r3v26, types: [com.bytedance.android.window.shop.home.tab.presenter.ECWindowHybridTabPresenter$scrollListener$1] */
    public ECWindowHybridTabPresenter(Fragment r3) {
        Intrinsics.checkNotNullParameter(r3, "tabFragment");
        super(r3);
        this.C = r3;
        this.f = new fo.b();
        this.i = LazyKt.lazy(new ECWindowHybridTabPresenter$shopViewModel$2(this));
        this.j = LazyKt.lazy(new ECWindowHybridTabPresenter$viewModel$2(this));
        this.k = LazyKt.lazy(new ECWindowHybridTabPresenter$tabExtViewModel$2(this));
        this.l = LazyKt.lazy(new ECWindowHybridTabPresenter$tabCardViewModel$2(this));
        this.m = LazyKt.lazy(new ECWindowHybridTabPresenter$statusView$2(this));
        this.n = LazyKt.lazy(new ECWindowHybridTabPresenter$recyclerViewContainer$2(this));
        this.o = LazyKt.lazy(new ECWindowHybridTabPresenter$recyclerView$2(this));
        this.q = new ArrayList();
        this.r = LazyKt.lazy(new ECWindowHybridTabPresenter$playAbilityPlugin$2(this));
        this.s = new com.bytedance.android.window.shop.home.tab.tabplugin.f();
        this.t = ReplaySubject.a();
        this.v = new h(this);
        this.x = LazyKt.lazy(new ECWindowHybridTabPresenter$hybridListEngine$2(this));
        this.y = new d(this);
        this.z = new ECWindowHybridTabPresenter$holderBindProcessorManager$1(this);
        final Function1<Integer, Unit> r0 = new ECWindowHybridTabPresenter$scrollListener$2(this);
        final Function1<Boolean, Unit> r1 = new ECWindowHybridTabPresenter$scrollListener$3(this);
        this.B = new ECWindowHybridTabPresenter$scrollListener$1(r0, r1);
    }

    public final void b0(QModel r11) {
        if (this.u == false) goto L6;
        o0();
        return;
    L6:
        this.u = true;
        l0().initEventContext(j0().getBaseParams());
        l0().init(j0().getShopParam().getSecAuthorId(), (String) j0().getShopParam().getPassThroughParam("pass_through_api"), (WindowHybridTabDataListResponseDTO) j0().getHeaderSubTabsParam().d.getValue(), j0().getShopParam(), j0().getEntranceInfoJsonObject());
        l0().appendEventParams(MapsKt.mapOf(new Pair[]{TuplesKt.to("tab_id", l0().getLastCategoryId()), TuplesKt.to("classification_tab", l0().getCategoryName()), TuplesKt.to("classification_tab_id", l0().getLastCategoryId()), TuplesKt.to("classification_sub_tab_id", l0().getLastSubCategoryId())}));
        w1 r1 = l0().getTabPerformanceWatcher();
        ECWindowViewModel r3 = j0();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "windowViewModel");
        r1.b = MapsKt.plus(r3.getWindowMonitorCategories(100), MapsKt.mapOf(new Pair[]{TuplesKt.to("current_category_id", r1.f.getLastCategoryId()), TuplesKt.to("current_category_name", r1.f.getCategoryName()), TuplesKt.to("request_size", 20), TuplesKt.to("request_start_items", Integer.valueOf(WindowConstDef.y))}));
        if (r11 != null) goto L9;
        m0(true);
    L10:
        j0().getGoTopEventReceiver().observe(this.C, new e(this));
        ECHybridRecyclerView r12 = i0();
        MonitorScenes r2 = MonitorScenes.EC_HYBRID_WINDOW_FPS;
        JSONObject r4 = new JSONObject();
        if (j0().getShopParam().getUseLynxCard() == false) goto L13;
        r4.put("flag_use_lynx_card", CommentScene.COMMENTSCENE_NO_AWEME);
    L14:
        Unit r5 = Unit.INSTANCE;
        r12.addOnScrollListener(new RecyclerViewPerformanceMonitor(new com.bytedance.android.ec.core.monitor.q(r2, null, r4)));
        com.bytedance.android.window.shop.home.tab.tabplugin.f r13 = this.s;
        ReplaySubject<ToolBarView> r6 = this.t;
        zn.a<Boolean> r7 = j0().getShowPopupWindowLiveData();
        ECWindowHybridTabPresenter$onBind$3 r8 = ECWindowHybridTabPresenter$onBind$3.INSTANCE;
        Intrinsics.checkNotNullParameter(r7, "source");
        Intrinsics.checkNotNullParameter(r8, "transformer");
        r13.a(new com.bytedance.android.window.shop.home.tab.tabplugin.e[]{(ECWindowPlayAbilityPlugin) this.r.getValue(), new com.bytedance.android.window.shop.home.tab.tabplugin.g(i0(), j0().getShopParam().getSecAuthorId(), l0()), new ECWindowSoundChangedNotifierPlugin(j0(), e0(), null), new com.bytedance.android.window.shop.home.tab.tabplugin.b(r6, new ECWindowHybridTabPresenter$observableSourceFromLiveData$1(this, r7, r8)), new ECWindowTabNewProductPlugin(j0(), com.bytedance.android.window.shop.c.c, new ECWindowHybridTabPresenter$onBind$4(this))});
        return;
    L13:
        r4.put("flag_use_lynx_card", "0");
        goto L14
    L9:
        m0(false);
        goto L10
    }

    @Override // com.bytedance.android.window.shop.repository.tab.datasource.c
    public final void c(com.bytedance.android.window.shop.repository.tab.datasource.impl.a<?, ?> r2) {
        if (((ArrayList) this.q).isEmpty() == false) goto L5;
        d0();
        return;
    L5:
        List<Runnable> r3 = this.q;
        ArrayList r4 = (ArrayList) r3;
        r4.add(new g(this));
    }

    public final void m0(boolean r10) {
        j0().getHeaderSubTabsParam().d.a(Y().e(), new com.bytedance.android.window.shop.home.tab.presenter.b(this), true);
        WindowLazyStatusView r0 = k0();
        com.bytedance.android.ec.window.base.status.c.d r4 = com.bytedance.android.ec.window.base.status.c.d.a;
        r0.setCreators(MapsKt.mapOf(new Pair[]{TuplesKt.to(com.bytedance.android.ec.window.base.status.c.c.a, new com.bytedance.android.ec.window.base.status.d(new ECWindowHybridTabPresenter$initStatusView$1(this), null, null)), TuplesKt.to(com.bytedance.android.ec.window.base.status.c.b.a, new com.bytedance.android.ec.window.base.status.d(new ECWindowHybridTabPresenter$initStatusView$2(this), null, null)), TuplesKt.to(r4, new com.bytedance.android.ec.window.base.status.d(new ECWindowHybridTabPresenter$initStatusView$3(this), null, null))}));
        if (r10 == false) goto L5;
        r0.b(r4);
    L5:
        Set<Integer> r1 = com.bytedance.android.window.shop.holder.factory.d.a;
        com.bytedance.android.window.shop.holder.factory.d.a(((QFragmentPresenter) this).e, this.f, l0().getSceneId());
        Iterator r2 = MapsKt.mapOf(new Pair[]{TuplesKt.to(k0.class, new com.bytedance.android.window.shop.home.tab.presenter.g(this)), TuplesKt.to(l0.class, new ECWindowHybridTabPresenter$windowAbilities$2(this)), TuplesKt.to(m0.class, new com.bytedance.android.window.shop.home.tab.presenter.h(this)), TuplesKt.to(j0.class, new i()), TuplesKt.to(com.bytedance.android.ec.hybrid.list.ability.p.class, this.z)}).entrySet().iterator();
    L7:
        if (r2.hasNext() == false) goto L13;
        Map.Entry r3 = (Map.Entry) r2.next();
        Class r5 = (Class) r3.getKey();
        com.bytedance.android.ec.hybrid.list.ability.s r6 = (com.bytedance.android.ec.hybrid.list.ability.s) r3.getValue();
        ECHybridListEngine r7 = e0();
        if (r5 == null) goto L12;
        r7.b(r5, r6);
        goto L7
    L12:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<com.bytedance.android.ec.hybrid.list.ability.IAbility>");
    L13:
        e0().b.addOnScrollListener(this.B);
        WindowHybridTabViewModel r8 = l0();
        WindowHybridTabViewModel.Companion.getClass();
        r8.registerExtension(WindowHybridTabViewModel.access$getDYNAMIC_CARD_CHECKER$cp(), new ECWindowHybridTabPresenter$initHybridContainer$1(this));
        ECHybridListAdapter r9 = i0().getAdapter();
        d r11 = this.y;
        r9.getClass();
        Intrinsics.checkNotNullParameter(r11, "listener");
        ((ArrayList) r9.h).add(r11);
        this.C.getLifecycle().addObserver(this);
        l0().setCallback(this);
        if (r10 == false) goto L16;
        o0();
    L16:
        com.bytedance.android.window.shop.home.tab.common.a<com.bytedance.android.window.shop.home.viewmodel.b> r12 = l0().getTabRefreshRegistry();
        r12.a.add(new b(this));
        j0().getLayoutStatus().observe(((QFragmentPresenter) this).e, new c(this));
    }

    @Override // com.bytedance.android.window.shop.repository.tab.datasource.c
    public final void onError(String r2) {
        Intrinsics.checkNotNullParameter("", "msg");
        if (c0.f(e0().c.g) == false) goto L5;
        i0().setVisibility(8);
        k0().b(com.bytedance.android.ec.window.base.status.c.c.a);
        return;
    L5:
        k0().a();
    }

    public final void p0(n0 r9) {
        com.bytedance.android.ec.hybrid.list.entity.k r10 = r9.c;
        if (r10 != null) goto L5;
        return;
    L5:
        ConcurrentHashMap<Long, com.bytedance.android.window.shop.lifecycle.f> r0 = com.bytedance.android.window.shop.lifecycle.c.a;
        com.bytedance.android.window.shop.lifecycle.f r1 = com.bytedance.android.window.shop.lifecycle.c.a(l0().getLifecycleMonitorId());
        if (r1 == null) goto L8;
        r1.a();
    L8:
        WindowLayoutType r2 = h0();
        Intrinsics.checkNotNullParameter(r10, "$this$findToolBarVo");
        ArrayList r3 = r10.c;
        Object r4 = null;
        if (r3 == null) goto L31;
        Iterator r5 = r3.iterator();
    L12:
        if (r5.hasNext() == false) goto L16;
        Object r6 = r5.next();
        if (Intrinsics.areEqual(((com.bytedance.android.ec.hybrid.list.entity.i) r6).a, "tool_bar") == false) goto L12;
    L17:
        com.bytedance.android.ec.hybrid.list.entity.i r7 = (com.bytedance.android.ec.hybrid.list.entity.i) r6;
        if (r7 == null) goto L31;
        ArrayList r8 = r7.i;
        if (r8 == null) goto L31;
        Iterator r11 = r8.iterator();
    L23:
        if (r11.hasNext() == false) goto L27;
        Object r12 = r11.next();
        if (Intrinsics.areEqual(((ECHybridListItemVO) r12).d, "3002") == false) goto L23;
    L28:
        ECHybridListItemVO r13 = (ECHybridListItemVO) r12;
        if (r13 == null) goto L31;
        Object r14 = r13.d();
    L33:
        if ((r14 instanceof com.bytedance.android.window.shop.repository.tab.entity.q) == false) goto L36;
        r4 = r14;
    L36:
        com.bytedance.android.window.shop.repository.tab.entity.q r15 = (com.bytedance.android.window.shop.repository.tab.entity.q) r4;
        if (r15 == null) goto L39;
        this.g = r15;
    L39:
        c0.k(r10, r2, this.g);
        c0.a(r10, r2.isSingleColumn());
        c0.b(r10, r2);
        com.bytedance.android.ec.hybrid.list.entity.k r16 = e0().c.g;
        boolean r17 = true;
        if (r16 != null) goto L42;
    L44:
        boolean r18 = false;
    L45:
        com.bytedance.android.ec.hybrid.list.entity.k r19 = e0().c.g;
        if (r19 == null) goto L61;
        ArrayList r20 = r19.c;
        if (r20 == null) goto L61;
        if (r20.isEmpty() == true) goto L58;
        Iterator r21 = r20.iterator();
    L54:
        if (r21.hasNext() == false) goto L58;
        if (Intrinsics.areEqual(((com.bytedance.android.ec.hybrid.list.entity.i) r21.next()).a, "tool_bar") == true) goto L54;
        boolean r22 = false;
    L59:
        if (r22 != true) goto L61;
        boolean r23 = true;
    L62:
        Intrinsics.checkNotNullParameter(r10, "$this$allPathUpdateData");
        ArrayList r24 = r10.c;
        if (r24 != null) goto L65;
    L93:
        r17 = false;
    L94:
        if (r17 == false) goto L102;
        ArrayList r25 = r10.c;
        if (r25 == null) goto L101;
        Iterator r26 = r25.iterator();
    L99:
        if (r26.hasNext() == false) goto L132;
        ECHybridListEngine.s(e0(), (com.bytedance.android.ec.hybrid.list.entity.i) r26.next(), Boolean.FALSE, 4);
        goto L99
    L132:
        return;
    L101:
        return;
    L102:
        if (r18 == true) goto L106;
        if (r23 == true) goto L106;
        e0().c(r10);
    L107:
        e0().b.post(new com.bytedance.android.window.shop.home.tab.presenter.c(this));
        i0().setVisibility(0);
        com.bytedance.android.ec.window.base.common.taskgraph.b<?> r27 = j0().getPipeline();
        if (r27 == null) goto L110;
        r27.c(WindowLaunchTask.g);
    L110:
        k0().a();
        return;
    L106:
        ECHybridListEngine.p(e0(), r10, 6);
        goto L107
    L65:
        if (r24.isEmpty() == true) goto L90;
        Iterator r28 = r24.iterator();
    L69:
        if (r28.hasNext() == false) goto L90;
        ArrayList r29 = ((com.bytedance.android.ec.hybrid.list.entity.i) r28.next()).i;
        if (r29 != null) goto L73;
    L87:
        boolean r30 = false;
    L88:
        if (r30 == true) goto L69;
        boolean r31 = false;
    L91:
        if (r31 != true) goto L93;
    L73:
        if (r29.isEmpty() == true) goto L84;
        Iterator r32 = r29.iterator();
    L77:
        if (r32.hasNext() == false) goto L84;
        if (((ECHybridListItemVO) r32.next()).p != ECItemOperationType.PATH_UPDATE) goto L81;
        boolean r33 = true;
    L82:
        if (r33 == true) goto L77;
        boolean r34 = false;
    L85:
        if (r34 != true) goto L87;
        r30 = true;
        goto L88
    L81:
        r33 = false;
    L84:
        r34 = true;
    L90:
        r31 = true;
    L58:
        r22 = true;
    L61:
        r23 = false;
        goto L62
    L42:
        if (c0.f(r16) != true) goto L44;
        r18 = true;
        goto L45
    L27:
        r12 = null;
        goto L28
    L16:
        r6 = null;
    L31:
        r14 = null;
        goto L33
    }

    public final void q0(FooterStatus r2) {
        com.bytedance.android.window.shop.holder.footer.a r0 = this.h;
        if (r0 == null) goto L5;
        r0.J1(r2);
    L5:
        i0().stopScroll();
        LinearLayoutManager r3 = i0().getLayoutManager();
        if ((r3 instanceof LinearLayoutManager) == true) goto L8;
        r3 = null;
    L8:
        if (r3 == null) goto L11;
        r3.scrollToPosition(0);
        return;
    }

    public final void r0(WindowLayoutType r3) {
        ToolBarView r0 = this.p;
        if (r0 == null) goto L5;
        r0.setCurrentLayoutType(r3);
    L5:
        j0().getHeaderSubTabsParam().b = r3;
        fo.b r1 = this.f;
        fo.a<WindowLayoutType> r2 = WindowConstDef.a;
        r1.d(WindowConstDef.a, r3);
    }

    public final void s0(WindowLayoutType r8) {
        com.bytedance.android.ec.hybrid.list.entity.k r0 = e0().c.g;
        j0().updateUserLayoutType(r8);
        r0(r8);
        ECHybridRecyclerView r1 = i0();
        Intrinsics.checkNotNullParameter(r1, "$this$findFirstCompletelyVisibleItemPosition");
        RecyclerView.LayoutManager r2 = r1.getLayoutManager();
        ArrayList r3 = null;
        if ((r2 instanceof LinearLayoutManager) == true) goto L5;
        r2 = null;
    L5:
        LinearLayoutManager r4 = (LinearLayoutManager) r2;
        if (r4 == null) goto L8;
        int r5 = r4.findFirstCompletelyVisibleItemPosition();
    L9:
        if (r0 == null) goto L11;
        c0.k(r0, r8, this.g);
    L11:
        if (r0 == null) goto L13;
        c0.a(r0, r8.isSingleColumn());
    L13:
        if (r0 == null) goto L33;
        ECHybridListEngine r9 = e0();
        com.bytedance.android.ec.hybrid.list.entity.k r6 = e0().c.g;
        if (r6 == null) goto L24;
        ArrayList r7 = r6.c;
        if (r7 == null) goto L24;
        r3 = new ArrayList();
        Iterator r10 = r7.iterator();
    L20:
        if (r10.hasNext() == false) goto L24;
        Object r11 = r10.next();
        if (Intrinsics.areEqual(((com.bytedance.android.ec.hybrid.list.entity.i) r11).a, "tool_bar") == false) goto L20;
        r3.add(r11);
    L24:
        ECHybridListEngine.p(r9, c0.g(r0, r3), 4);
        ECHybridListEngine.p(e0(), r0, 6);
        if (r5 < 0) goto L34;
        i0().scrollToPosition(r5);
        return;
    L34:
        return;
    L33:
        return;
    L8:
        r5 = -1;
        goto L9
    }

    @Override // com.bytedance.android.window.shop.repository.tab.datasource.e
    public final void f(WindowTabInfoProvider r4, mq3.a r5) {
        Intrinsics.checkNotNullParameter(r4, "dto");
        Intrinsics.checkNotNullParameter(r5, "reqParam");
        if ((r4 instanceof WindowHybridTabDataListResponseDTO) == true) goto L5;
        WindowTabInfoProvider r0 = null;
    L6:
        WindowHybridTabDataListResponseDTO r1 = (WindowHybridTabDataListResponseDTO) r0;
        if (r1 == null) goto L11;
        ConcurrentHashMap<Long, com.bytedance.android.window.shop.lifecycle.f> r2 = com.bytedance.android.window.shop.lifecycle.c.a;
        com.bytedance.android.window.shop.lifecycle.f r3 = com.bytedance.android.window.shop.lifecycle.c.a(l0().getLifecycleMonitorId());
        if (r3 == null) goto L11;
        r3.j(r1);
    L11:
        l0().setLastSubCategoryId(r4.getTargetSelectSubCategoryId());
        j0().setServerLayoutType(r4.getWindowLayoutType());
        WindowLayoutType r6 = j0().getHeaderSubTabsParam().b;
        if (r6 != null) goto L14;
        r6 = r4.getWindowLayoutType();
    L14:
        r0(r6);
        int r7 = WindowBusinessMonitor.a;
        WindowBusinessMonitor.b(j0(), r4, r5);
        return;
    L5:
        r0 = r4;
        goto L6
    }

    public final void onStateChanged(LifecycleOwner r12, Lifecycle.Event r13) {
        Intrinsics.checkNotNullParameter(r12, "source");
        Intrinsics.checkNotNullParameter(r13, "event");
        int r14 = com.bytedance.android.window.shop.home.tab.presenter.a.a[r13.ordinal()];
        boolean r15 = true;
        if (r14 != 1) goto L5;
        ECWindowHybridTabPresenter$holderBindProcessorManager$1 r16 = this.z;
        com.bytedance.android.ec.hybrid.list.ability.r r17 = r16.b;
        com.bytedance.android.window.shop.widget.holderprocessor.d.a r0 = r16.a.f;
        r17.getClass();
        Intrinsics.checkNotNullParameter(r0, "processor");
        r17.a.remove(r0);
        com.bytedance.android.ec.hybrid.list.ability.r r18 = r16.c;
        com.bytedance.android.window.shop.widget.holderprocessor.d.b r19 = r16.a.e;
        r18.getClass();
        Intrinsics.checkNotNullParameter(r19, "processor");
        r18.a.remove(r19);
        l0().clearDataSource();
        return;
    L5:
        if (r14 != 2) goto L7;
        l0().setTabShowTime(System.currentTimeMillis());
        WindowLayoutType r110 = j0().getHeaderSubTabsParam().b;
        LinearLayoutManager r1 = null;
        if (r110 != null) goto L20;
        ToolBarView r111 = this.p;
        if (r111 == null) goto L19;
        r110 = r111.getCurrentLayoutType();
        goto L20
    L19:
        r110 = null;
    L20:
        if (r110 == null) goto L36;
        ToolBarView r2 = this.p;
        if (r2 == null) goto L36;
        WindowLayoutType r3 = r2.getCurrentLayoutType();
        if (r3 == null) goto L36;
        r0(r110);
        if (r3 == r110) goto L30;
        s0(r110);
    L30:
        ToolBarView r4 = this.p;
        if (r4 == null) goto L33;
        r4.U5(r110);
    L33:
        com.bytedance.android.ec.hybrid.list.entity.k r5 = e0().c.g;
        if (r5 == null) goto L36;
        c0.b(r5, r110);
    L36:
        n0();
        ECWindowHybridTabPresenter$scrollListener$1 r112 = this.B;
        ECHybridRecyclerView r6 = i0();
        Intrinsics.checkNotNullParameter(r6, "$this$findFirstCompletelyVisibleItemPosition");
        LinearLayoutManager r7 = r6.getLayoutManager();
        if ((r7 instanceof LinearLayoutManager) == false) goto L40;
        r1 = r7;
    L40:
        LinearLayoutManager r8 = r1;
        if (r8 == null) goto L43;
        int r9 = r8.findFirstCompletelyVisibleItemPosition();
    L44:
        int r10 = r112.a;
        if (r10 <= 0) goto L58;
        if (r9 >= r10) goto L50;
        r15 = false;
    L50:
        r112.c.invoke(Boolean.valueOf(r15));
        return;
    L58:
        return;
    L43:
        r9 = -1;
        goto L44
    L7:
        if (r14 != 3) goto L57;
        l0().doAnyEventActionWithBtm("a1.b7635.c68164.d0", PageFinder.via(a0()), "stay_store_page_tab", MapsKt.mapOf(new Pair[]{TuplesKt.to("duration", String.valueOf(System.currentTimeMillis() - l0().getTabShowTime())), TuplesKt.to("store_source_page", j0().getShopParam().getStoreSourcePage()), TuplesKt.to("store_source_method", j0().getShopParam().getStoreSourceMethod()), TuplesKt.to("store_group_type", j0().getShopParam().getStoreGroupType()), TuplesKt.to("scroll_offset", Integer.valueOf(this.A)), TuplesKt.to("window_bhv_session_id", j0().getShopParam().getWindowSessionId()), TuplesKt.to("category_id", l0().getLastCategoryId()), TuplesKt.to("category_name", l0().getCategoryName()), TuplesKt.to("item_count", Integer.valueOf(l0().getLastBindPosition()))}), new Pair[0]);
        ToolBarView r113 = this.p;
        if (r113 == null) goto L53;
        WindowLayoutType r114 = r113.getCurrentLayoutType();
        if (r114 == null) goto L54;
        r0(r114);
        return;
    L54:
        return;
    L53:
        return;
    }

    @Override // com.bytedance.android.window.shop.repository.tab.datasource.c
    public final void y(n0 r10, ShopWindowVODataType r11) {
        Intrinsics.checkNotNullParameter(r10, "data");
        Intrinsics.checkNotNullParameter(r11, "dataType");
        com.bytedance.android.ec.hybrid.list.entity.k r12 = r10.d;
        if (r12 == null) goto L5;
        ((ECWindowHybridTabCardViewModel) this.l.getValue()).provide(r12);
    L5:
        WindowTabExtViewModel r13 = (WindowTabExtViewModel) this.k.getValue();
        String r0 = j0().getShopParam().getSecAuthorId();
        String r1 = (String) j0().getShopParam().getPassThroughParam("pass_through_api");
        if (r1 != null) goto L8;
        r1 = "";
    L8:
        com.bytedance.android.ec.hybrid.list.entity.k r2 = r10.c;
        if (r2 == null) goto L43;
        ArrayList r3 = r2.c;
        if (r3 == null) goto L43;
        ArrayList r4 = new ArrayList();
        Iterator r5 = r3.iterator();
    L14:
        if (r5.hasNext() == false) goto L32;
        ArrayList r6 = ((com.bytedance.android.ec.hybrid.list.entity.i) r5.next()).i;
        ArrayList r7 = null;
        if (r6 == null) goto L30;
        ArrayList r8 = new ArrayList();
        Iterator r9 = r6.iterator();
    L19:
        if (r9.hasNext() == false) goto L29;
        Object r14 = c0.c((ECHybridListItemVO) r9.next());
        if ((r14 instanceof com.bytedance.android.window.shop.repository.tab.entity.f) == true) goto L23;
        r14 = null;
    L23:
        com.bytedance.android.window.shop.repository.tab.entity.f r15 = (com.bytedance.android.window.shop.repository.tab.entity.f) r14;
        if (r15 == null) goto L26;
        WindowV2ProductItemVO r16 = r15.c();
    L27:
        if (r16 == null) goto L19;
        r8.add(r16);
        goto L19
    L26:
        r16 = null;
        goto L27
    L29:
        r7 = r8;
    L30:
        if (r7 == null) goto L14;
        r4.add(r7);
        goto L14
    L32:
        Iterator r17 = r4.iterator();
        if (r17.hasNext() == false) goto L42;
        Object r18 = r17.next();
    L36:
        if (r17.hasNext() == false) goto L38;
        r18 = CollectionsKt.plus((List) r18, (List) r17.next());
        goto L36
    L38:
        List<? extends WindowV2ProductItemVO> r19 = (List) r18;
        if (r19 == null) goto L43;
    L44:
        r13.loadProductExtData(r0, r1, r19);
        n0 r110 = new n0(CollectionsKt.emptyList(), r10.getType(), r10.c, 8);
        if (this.C.getLifecycle().getCurrentState() != Lifecycle.State.RESUMED) goto L47;
        n0();
        p0(r110);
        return;
    L47:
        ((ArrayList) this.q).add(new f(this, r110));
        return;
    L42:
        throw new UnsupportedOperationException("Empty collection can't be reduced.");
    L43:
        r19 = CollectionsKt.emptyList();
        goto L44
    }

    @Override // com.bytedance.android.window.shop.repository.tab.datasource.e
    public final void F(int r2, long r3, Long r5) {
        l0().getTabPerformanceWatcher().c(new v1.c(r2, r3));
    }

    @Override // com.bytedance.android.window.shop.repository.tab.datasource.e
    public final void V(String r9, int r10, long r11, Long r13) {
        if (r9 != null) goto L4;
        return;
    L4:
        l0().getTabPerformanceWatcher().c(new v1.d(r9, r10, r11, r13));
    }
}
