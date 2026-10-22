package com.bytedance.android.window.shop.home.tab.presenter;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bytedance.android.ec.core.utils.s0;
import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import com.bytedance.android.ec.window.base.status.WindowLazyStatusView;
import com.bytedance.android.window.shop.WindowLaunchTask;
import com.bytedance.android.window.shop.holder.footer.FooterStatus;
import com.bytedance.android.window.shop.holder.presenter.WindowCouponPresenter;
import com.bytedance.android.window.shop.home.WindowTabExtViewModel;
import com.bytedance.android.window.shop.home.presenter.plugin.ECWindowSoundChangedNotifierPlugin;
import com.bytedance.android.window.shop.home.tab.WindowTabViewModel;
import com.bytedance.android.window.shop.home.tab.tabplugin.ECWindowPlayAbilityPlugin;
import com.bytedance.android.window.shop.home.tab.tabplugin.ECWindowTabCardListOperationPlugin;
import com.bytedance.android.window.shop.home.tab.tabplugin.ECWindowTabNewProductPlugin;
import com.bytedance.android.window.shop.home.tabcard.ECWindowTabCardViewModel;
import com.bytedance.android.window.shop.home.viewmodel.ECWindowViewModel;
import com.bytedance.android.window.shop.lifecycle.WindowBusinessMonitor;
import com.bytedance.android.window.shop.product.pinrecyclerview.ECRecyclerViewPinnableLayout;
import com.bytedance.android.window.shop.repository.compat.WindowTabInfoProvider;
import com.bytedance.android.window.shop.repository.dto.WindowTabDataListResponseDTODeprecated;
import com.bytedance.android.window.shop.repository.tab.datasource.ShopWindowVODataType;
import com.bytedance.android.window.shop.repository.tab.entity.CardPosition;
import com.bytedance.android.window.shop.repository.tab.entity.WindowLayoutType;
import com.bytedance.android.window.shop.repository.tab.entity.e0;
import com.bytedance.android.window.shop.repository.tab.entity.g0;
import com.bytedance.android.window.shop.repository.tab.entity.i0;
import com.bytedance.android.window.shop.repository.tab.entity.n0;
import com.bytedance.android.window.shop.widget.ECShopRecyclerView;
import com.bytedance.android.window.shop.widget.ECWindowTabLayout;
import com.bytedance.android.window.shop.widget.SortBarView;
import com.bytedance.android.window.shop.widget.SubCategoryView;
import com.bytedance.android.window.shop.widget.ToolBarView;
import com.bytedance.android.window.shop.widget.WindowTypeSeparatedAdapter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;
import io.reactivex.Observable;
import io.reactivex.subjects.ReplaySubject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/window/shop/home/tab/presenter/ECWindowTabPresenter;", "Lcom/ss/android/ugc/aweme/kiwi/presenter/QFragmentPresenter;", "Lcom/bytedance/android/window/shop/repository/tab/datasource/c;", "Landroidx/lifecycle/LifecycleEventObserver;", "Lcom/bytedance/android/window/shop/product/pinrecyclerview/ECRecyclerViewPinnableLayout$b;", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECWindowTabPresenter extends QFragmentPresenter implements com.bytedance.android.window.shop.repository.tab.datasource.c, LifecycleEventObserver, ECRecyclerViewPinnableLayout.b {
    public static final /* synthetic */ int C = 0;
    public final Fragment A;
    public final QLiveData<com.bytedance.android.window.shop.home.tab.b> B;
    public boolean f;
    public final Lazy g;
    public final Lazy h;
    public final Lazy i;
    public final Lazy j;
    public final Lazy k;
    public WindowLazyStatusView l;
    public ECShopRecyclerView m;
    public ECRecyclerViewPinnableLayout n;
    public ToolBarView o;
    public SubCategoryView p;
    public final List<Runnable> q;
    public final ReplaySubject<ToolBarView> r;
    public final Lazy s;
    public final Lazy t;
    public final Lazy u;
    public final com.bytedance.android.window.shop.home.tab.tabplugin.f v;
    public final WindowTypeSeparatedAdapter w;
    public final ECWindowTabPresenter$scrollLoadMoreListener$1 x;
    public final ECWindowTabPresenter$scrollListener$1 y;
    public final View z;

    public static final class a {
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ ECWindowTabPresenter a;

        public b(ECWindowTabPresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            if (this.a.A.getLifecycle().getCurrentState() != Lifecycle.State.RESUMED) goto L14;
            ECRecyclerViewPinnableLayout r3 = this.a.n;
            if (r3 != null) goto L7;
            Intrinsics.throwUninitializedPropertyAccessException("recyclerViewPinLayout");
        L7:
            r3.f();
            ECShopRecyclerView r4 = this.a.m;
            if (r4 != null) goto L10;
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        L10:
            int r0 = ECShopRecyclerView.d;
            r4.stopScroll();
            StaggeredGridLayoutManager r5 = r4.m965getLayoutManager();
            if (r5 == null) goto L15;
            r5.scrollToPositionWithOffset(0, 0);
            return;
        L15:
            return;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ ECWindowTabPresenter a;
        public final /* synthetic */ n0 b;
        public final /* synthetic */ ShopWindowVODataType c;

        public c(ECWindowTabPresenter r1, n0 r2, ShopWindowVODataType r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ECWindowTabPresenter r0 = this.a;     // Catch: Throwable -> L4
            n0 r1 = this.b;     // Catch: Throwable -> L4
            ShopWindowVODataType r2 = this.c;     // Catch: Throwable -> L4
            int r3 = ECWindowTabPresenter.C;     // Catch: Throwable -> L4
            r0.k0(r1, r2);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ ECWindowTabPresenter a;

        public d(ECWindowTabPresenter r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ECWindowTabPresenter r0 = this.a;     // Catch: Throwable -> L4
            int r1 = ECWindowTabPresenter.C;     // Catch: Throwable -> L4
            r0.d0();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    @Override // com.bytedance.android.window.shop.product.pinrecyclerview.ECRecyclerViewPinnableLayout.b
    public final void A(ECRecyclerViewPinnableLayout.InnerRecyclerView r2) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
    }

    @Override // com.bytedance.android.window.shop.repository.tab.datasource.e
    public final void F(int r1, long r2, Long r4) {
    }

    @Override // com.bytedance.android.window.shop.product.pinrecyclerview.ECRecyclerViewPinnableLayout.b
    public final void S(ECRecyclerViewPinnableLayout.InnerRecyclerView r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "recyclerView");
    }

    @Override // com.bytedance.android.window.shop.repository.tab.datasource.e
    public final void V(String r1, int r2, long r3, Long r5) {
    }

    @Override // com.bytedance.android.window.shop.repository.tab.datasource.c
    public final void e() {
    }

    public final WindowTypeSeparatedAdapter e0() {
        return (WindowTypeSeparatedAdapter) this.u.getValue();
    }

    public final ECWindowViewModel h0() {
        return (ECWindowViewModel) this.g.getValue();
    }

    public final WindowTabViewModel i0() {
        return (WindowTabViewModel) this.h.getValue();
    }

    public final synchronized void j0() {
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
        this.v.b();
    }

    public final void d0() {
        e0().A2();
        if (e0().getBasicItemCount() != 0) goto L8;
        WindowLazyStatusView r0 = this.l;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("statusView");
    L7:
        r0.b(com.bytedance.android.ec.window.base.status.c.b.a);
    L12:
        e0().E2(FooterStatus.NO_MORE);
        ECWindowTabPresenter$scrollLoadMoreListener$1 r1 = this.x;
        r1.b = false;
        r1.c = true;
        return;
    L8:
        WindowLazyStatusView r2 = this.l;
        if (r2 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("statusView");
    L11:
        r2.a();
        goto L12
    }

    public final void b0(QModel r8) {
        QLiveData<com.bytedance.android.window.shop.home.tab.b> r9 = this.B;
        if (r9 == null) goto L5;
        r9.g(new q(this));
    L5:
        i0().init(h0().getShopParam().getSecAuthorId(), (String) h0().getShopParam().getPassThroughParam("pass_through_api"), (WindowTabDataListResponseDTODeprecated) h0().getHeaderSubTabsParam().c.getValue());
        Unit r10 = (Unit) this.k.getValue();
        this.A.getLifecycle().removeObserver(this);
        this.A.getLifecycle().addObserver(this);
        h0().getGoTopEventReceiver().observe(this.A, new b(this));
        com.bytedance.android.window.shop.c r11 = i0().getShopWindowItemType();
        com.bytedance.android.window.shop.c r0 = com.bytedance.android.window.shop.c.c;
        if (Intrinsics.areEqual(r11, r0) == false) goto L12;
        com.bytedance.android.window.shop.home.tab.tabplugin.f r12 = this.v;
        com.bytedance.android.window.shop.home.tab.tabplugin.e[] r1 = new com.bytedance.android.window.shop.home.tab.tabplugin.e[5];
        r1[0] = (ECWindowPlayAbilityPlugin) this.s.getValue();
        ECWindowViewModel r3 = h0();
        ECShopRecyclerView r4 = this.m;
        if (r4 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L10:
        r1[1] = new ECWindowSoundChangedNotifierPlugin(r3, null, r4);
        ReplaySubject<ToolBarView> r5 = this.r;
        zn.a<Boolean> r6 = h0().getShowPopupWindowLiveData();
        ECWindowTabPresenter$onBind$2 r7 = ECWindowTabPresenter$onBind$2.INSTANCE;
        Intrinsics.checkNotNullParameter(r6, "source");
        Intrinsics.checkNotNullParameter(r7, "transformer");
        r1[2] = new com.bytedance.android.window.shop.home.tab.tabplugin.b(r5, new ECWindowTabPresenter$observableSourceFromLiveData$1(this, r6, r7));
        r1[3] = new ECWindowTabCardListOperationPlugin(h0(), i0().getLastCategoryId(), new ECWindowTabPresenter$onBind$3(this), new ECWindowTabPresenter$onBind$4(this));
        r1[4] = new ECWindowTabNewProductPlugin(h0(), r0, new ECWindowTabPresenter$onBind$5(this));
        r12.a(r1);
        return;
    }

    @Override // com.bytedance.android.window.shop.repository.tab.datasource.c
    public final void c(com.bytedance.android.window.shop.repository.tab.datasource.impl.a<?, ?> r2) {
        if (((ArrayList) this.q).isEmpty() == false) goto L5;
        d0();
        return;
    L5:
        List<Runnable> r3 = this.q;
        ArrayList r4 = (ArrayList) r3;
        r4.add(new d(this));
    }

    public final void l0(FooterStatus r5) {
        ECWindowTabPresenter$scrollLoadMoreListener$1 r0 = this.x;
        r0.c = false;
        r0.b = false;
        e0().E2(r5);
        e0().H2();
        e0().F2(new g0(e0().g, i0().getShopWindowItemType()));
        ECRecyclerViewPinnableLayout r6 = this.n;
        if (r6 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerViewPinLayout");
    L5:
        int r7 = r6.c();
        if ((-1) == r7) goto L14;
        ECShopRecyclerView r1 = this.m;
        if (r1 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L10:
        StaggeredGridLayoutManager r2 = r1.m965getLayoutManager();
        if (r2 == null) goto L15;
        r2.scrollToPositionWithOffset(r7, 0);
        return;
    L15:
        return;
    }

    public final void m0(WindowLayoutType r3) {
        WindowLazyStatusView r0 = this.l;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("statusView");
    L6:
        if (r3.isSingleColumn() == false) goto L8;
        com.bytedance.android.ec.window.base.status.c.e r4 = com.bytedance.android.ec.window.base.status.c.e.a;
    L9:
        r0.b(r4);
        n0(e0().h);
        e0().notifyDataSetChanged();
        return;
    L8:
        r4 = com.bytedance.android.ec.window.base.status.c.a.a;
        goto L9
    }

    public final void n0(List<? extends com.bytedance.android.window.shop.repository.tab.entity.f> r9) {
        com.bytedance.android.window.shop.c r0 = i0().getShopWindowItemType();
        ConcurrentHashMap<Integer, com.bytedance.android.window.shop.c> r1 = com.bytedance.android.window.shop.c.b;
        if ((!Intrinsics.areEqual(r0, com.bytedance.android.window.shop.c.c)) == false) goto L5;
        return;
    L5:
        int r2 = 0;
        if (r9.size() == 1) goto L8;
    L10:
        Iterator<? extends com.bytedance.android.window.shop.repository.tab.entity.f> r3 = r9.iterator();
        int r4 = 0;
    L12:
        if (r3.hasNext() == false) goto L17;
        if ((r3.next() instanceof e0) == true) goto L18;
        r4 = r4 + 1;
    L18:
        Iterator<T> r10 = r9.iterator();
    L20:
        if (r10.hasNext() == false) goto L44;
        Object r5 = r10.next();
        int r6 = r2 + 1;
        if (r2 >= 0) goto L24;
        CollectionsKt.throwIndexOverflow();
    L24:
        com.bytedance.android.window.shop.repository.tab.entity.f r7 = (com.bytedance.android.window.shop.repository.tab.entity.f) r5;
        if (r2 != r4) goto L41;
        boolean r8 = r7 instanceof e0;
        com.bytedance.android.window.shop.repository.tab.entity.f r11 = null;
        if (r8 == true) goto L29;
        com.bytedance.android.window.shop.repository.tab.entity.f r12 = null;
    L30:
        e0 r13 = (e0) r12;
        if (r13 == null) goto L33;
        h0().setServerLayoutType(r13.k);
    L33:
        WindowLayoutType r14 = h0().getHeaderSubTabsParam().b;
        if (r14 == null) goto L41;
        if (r8 == false) goto L38;
        r11 = r7;
    L38:
        e0 r15 = (e0) r11;
        if (r15 == null) goto L41;
        Intrinsics.checkNotNullParameter(r14, "<set-?>");
        r15.k = r14;
        goto L41
    L29:
        r12 = r7;
    L41:
        if (r2 <= r4) goto L43;
        int r16 = r7.i;
    L43:
        r2 = r6;
        goto L20
    L44:
        return;
    L17:
        r4 = -1;
        goto L18
    L8:
        if (Intrinsics.areEqual(ListProtector.get(r9, 0).getClass(), com.bytedance.android.window.shop.repository.tab.entity.x.class) == false) goto L10;
    }

    @Override // com.bytedance.android.window.shop.repository.tab.datasource.c
    public final void onError(String r3) {
        Intrinsics.checkNotNullParameter("", "msg");
        e0().A2();
        if (e0().getBasicItemCount() != 0) goto L11;
        RecyclerView r4 = this.m;
        if (r4 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L7:
        r4.setVisibility(8);
        WindowLazyStatusView r5 = this.l;
        if (r5 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("statusView");
    L10:
        r5.b(com.bytedance.android.ec.window.base.status.c.c.a);
    L15:
        this.x.b = false;
        return;
    L11:
        WindowLazyStatusView r6 = this.l;
        if (r6 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("statusView");
    L14:
        r6.a();
        goto L15
    }

    @Override // com.bytedance.android.window.shop.repository.tab.datasource.e
    public final void f(WindowTabInfoProvider r2, mq3.a r3) {
        Intrinsics.checkNotNullParameter(r2, "dto");
        Intrinsics.checkNotNullParameter(r3, "reqParam");
        int r0 = WindowBusinessMonitor.a;
        WindowBusinessMonitor.b(h0(), r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [android.view.View, com.bytedance.android.window.shop.widget.ToolBarView, java.lang.Object] */
    public final void k0(n0 r7, ShopWindowVODataType r8) {
        ConcurrentHashMap<Long, com.bytedance.android.window.shop.lifecycle.f> r0 = com.bytedance.android.window.shop.lifecycle.c.a;
        com.bytedance.android.window.shop.lifecycle.f r1 = com.bytedance.android.window.shop.lifecycle.c.a(i0().getLifecycleMonitorId());
        if (r1 == null) goto L5;
        r1.a();
    L5:
        Object r2 = CollectionsKt.firstOrNull(r7.a);
        Object r3 = null;
        if ((r2 instanceof i0) == true) goto L8;
        r2 = null;
    L8:
        i0 r4 = (i0) r2;
        if (r4 == null) goto L15;
        i0().setLastSubCategoryId(r4.l);
        SubCategoryView r9 = (SubCategoryView) Z().b(2131371211).f();
        r9.a(r4);
        s r10 = new s(this);
        Intrinsics.checkNotNullParameter(r10, "listener");
        ECWindowTabLayout r5 = r9.a;
        if (r5 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("subCategoryTab");
    L13:
        r5.addOnTabSelectedListener(r10);
        r9.b(i0().getLastSubCategoryId());
        r9.setVisibility(0);
        Unit r11 = Unit.INSTANCE;
        this.p = r9;
        return;
    L15:
        e0().A2();
        if (r8 != ShopWindowVODataType.PIN) goto L28;
        Iterator<T> r12 = r7.a.iterator();
        int r6 = 0;
    L20:
        if (r12.hasNext() == false) goto L28;
        Object r13 = r12.next();
        int r14 = r6 + 1;
        if (r6 >= 0) goto L24;
        CollectionsKt.throwIndexOverflow();
    L24:
        com.bytedance.android.window.shop.repository.tab.entity.f r15 = (com.bytedance.android.window.shop.repository.tab.entity.f) r13;
        ECRecyclerViewPinnableLayout r16 = this.n;
        if (r16 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerViewPinLayout");
    L27:
        r16.b(((ArrayList) e0().h).size() + r6);
        r6 = r14;
    L28:
        RecyclerView r17 = this.m;
        if (r17 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L31:
        r17.setVisibility(0);
        n0(r7.a);
        com.bytedance.android.ec.window.base.common.taskgraph.b<?> r18 = h0().getPipeline();
        if (r18 == null) goto L34;
        r18.c(WindowLaunchTask.g);
    L34:
        WindowTypeSeparatedAdapter r19 = e0();
        monitor-enter(r19);
        Intrinsics.checkNotNullParameter(r7, "dataWrapper");     // Catch: Throwable -> L64
        r19.D2(r7.a);     // Catch: Throwable -> L64
        monitor-exit(r19);
        Object r20 = CollectionsKt.firstOrNull(r7.a);
        if ((r20 instanceof e0) == true) goto L41;
        r20 = null;
    L41:
        e0 r21 = (e0) r20;
        if (r21 == null) goto L59;
        FrameLayout r22 = (FrameLayout) a0().findViewById(2131371230);
        View r23 = LayoutInflater.from(a0().getContext()).inflate(2131561044, null);
        if ((r23 instanceof ToolBarView) == false) goto L48;
        r3 = r23;
    L48:
        final ?? r24 = (ToolBarView) r3;
        if (r24 == 0) goto L59;
        bg4.b.b(Observable.just(r24)).subscribe(this.r);
        this.o = r24;
        r22.removeAllViews();
        int r25 = com.bytedance.android.ec.hybrid.list.util.c.a;
        r22.addView(r24, -1, com.bytedance.android.ec.hybrid.list.util.c.d(36));
        r24.setLifecycleOwner(((QFragmentPresenter) this).e);
        r24.setDoEventAction(new ECWindowTabPresenter$initToolBar$1(this));
        r24.S5(r21);
        SortBarView r26 = r24.getSortBarView();
        if (r26 == null) goto L55;
        r26.a("resort", new ECWindowTabPresenter$onSortBarInitialized$1(this));
    L55:
        WindowLayoutType r27 = h0().getHeaderSubTabsParam().b;
        if (r27 != null) goto L58;
        r27 = r24.getCurrentLayoutType();
    L58:
        r24.U5(r27);
        r24.setLayoutChangeCallback(new ECWindowTabPresenter$onLayoutControlInitialized$1(this, r24));
        r24.setFilterTypeChangeCB(new ECWindowTabPresenter$onLayoutControlInitialized$2(this));
    L59:
        WindowLazyStatusView r28 = this.l;
        if (r28 != null) goto L62;
        Intrinsics.throwUninitializedPropertyAccessException("statusView");
    L62:
        r28.a();
        this.x.b = false;
        return;
    L64:
        th = move-exception;
        throw th;
    }

    public final void onStateChanged(LifecycleOwner r3, Lifecycle.Event r4) {
        Intrinsics.checkNotNullParameter(r3, "source");
        Intrinsics.checkNotNullParameter(r4, "event");
        int r5 = m.a[r4.ordinal()];
        if (r5 != 1) goto L5;
        i0().clearDataSource();
        return;
    L5:
        if (r5 != 2) goto L7;
        j0();
        WindowLayoutType r6 = h0().getHeaderSubTabsParam().b;
        if (r6 != null) goto L21;
        ToolBarView r7 = this.o;
        if (r7 == null) goto L19;
        r6 = r7.getCurrentLayoutType();
        goto L21
    L19:
        r6 = null;
    L21:
        if (r6 != null) goto L24;
    L36:
        ECWindowTabPresenter$scrollListener$1 r8 = this.y;
        ECShopRecyclerView r0 = this.m;
        if (r0 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L39:
        r8.j(r0.r());
        return;
    L24:
        if (r6 == e0().g) goto L36;
        ECShopRecyclerView r1 = this.m;
        if (r1 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L29:
        int r2 = r1.r();
        ToolBarView r9 = this.o;
        if (r9 == null) goto L32;
        r9.U5(r6);
    L32:
        e0().G2(r6);
        m0(r6);
        ECShopRecyclerView r10 = this.m;
        if (r10 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L35:
        r10.scrollToPosition(r2);
        goto L36
    L7:
        if (r5 != 3) goto L46;
        ToolBarView r11 = this.o;
        if (r11 == null) goto L42;
        WindowLayoutType r12 = r11.getCurrentLayoutType();
        if (r12 == null) goto L43;
        h0().getHeaderSubTabsParam().b = r12;
        return;
    L43:
        return;
    L42:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [com.bytedance.android.window.shop.home.WindowTabExtViewModel] */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r7v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r7v3, types: [java.util.ArrayList] */
    @Override // com.bytedance.android.window.shop.repository.tab.datasource.c
    public final void y(n0 r10, ShopWindowVODataType r11) {
        Intrinsics.checkNotNullParameter(r10, "data");
        Intrinsics.checkNotNullParameter(r11, "dataType");
        Iterator r0 = r10.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        Object r1 = r0.next();
        if (((com.bytedance.android.window.shop.repository.tab.entity.f) r1).i != 102) goto L8;
        boolean r5 = true;
    L9:
        if (r5 == false) goto L4;
    L13:
        if ((r1 instanceof tq3.a) == true) goto L15;
        r1 = null;
    L15:
        tq3.a r2 = (tq3.a) r1;
        if (r2 == null) goto L19;
        h0().getOverallData().b(tq3.a.k, r2);
        s0.a(new WindowCouponPresenter.a(h0().getShopParam().getSecAuthorId()));
    L19:
        List<com.bytedance.android.window.shop.repository.tab.entity.f> r3 = r10.a;
        ArrayList r4 = new ArrayList();
        Iterator r6 = r3.iterator();
    L21:
        if (r6.hasNext() == false) goto L28;
        Object r7 = r6.next();
        if (((com.bytedance.android.window.shop.repository.tab.entity.f) r7).e != CardPosition.GLOBAL) goto L25;
        boolean r8 = true;
    L26:
        if (r8 == false) goto L21;
        r4.add(r7);
        goto L21
    L25:
        r8 = false;
        goto L26
    L28:
        Iterator r9 = r4.iterator();
    L30:
        if (r9.hasNext() == false) goto L32;
        ((ECWindowTabCardViewModel) this.j.getValue()).provide((com.bytedance.android.window.shop.repository.tab.entity.f) r9.next());
        goto L30
    L32:
        ?? r12 = (WindowTabExtViewModel) this.i.getValue();
        String r13 = h0().getShopParam().getSecAuthorId();
        String r14 = (String) h0().getShopParam().getPassThroughParam("pass_through_api");
        if (r14 != null) goto L35;
        r14 = "";
    L35:
        List<com.bytedance.android.window.shop.repository.tab.entity.f> r15 = r10.a;
        if (r15 == null) goto L43;
        ?? r16 = new ArrayList();
        Iterator r17 = r15.iterator();
    L39:
        if (r17.hasNext() == false) goto L44;
        WindowV2ProductItemVO r18 = ((com.bytedance.android.window.shop.repository.tab.entity.f) r17.next()).c();
        if (r18 == null) goto L39;
        r16.add(r18);
    L44:
        r12.loadProductExtData(r13, r14, r16);
        List<com.bytedance.android.window.shop.repository.tab.entity.f> r19 = r10.a;
        ArrayList r20 = new ArrayList();
        Iterator r21 = r19.iterator();
    L46:
        if (r21.hasNext() == false) goto L53;
        Object r22 = r21.next();
        if (((com.bytedance.android.window.shop.repository.tab.entity.f) r22).e != CardPosition.NORMAL) goto L50;
        boolean r23 = true;
    L51:
        if (r23 == false) goto L46;
        r20.add(r22);
        goto L46
    L50:
        r23 = false;
        goto L51
    L53:
        n0 r24 = new n0(r20, r10.getType(), null, 12);
        if (this.A.getLifecycle().getCurrentState() != Lifecycle.State.RESUMED) goto L56;
        j0();
        k0(r24, r11);
        return;
    L56:
        ((ArrayList) this.q).add(new c(this, r24, r11));
        return;
    L43:
        r16 = CollectionsKt.emptyList();
        goto L44
    L8:
        r5 = false;
        goto L9
    L11:
        r1 = null;
        goto L13
    }

    /* JADX WARN: Type inference failed for: r3v22, types: [com.bytedance.android.window.shop.home.tab.presenter.ECWindowTabPresenter$scrollLoadMoreListener$1] */
    /* JADX WARN: Type inference failed for: r3v23, types: [com.bytedance.android.window.shop.home.tab.presenter.ECWindowTabPresenter$scrollListener$1] */
    public ECWindowTabPresenter(View r3, Fragment r4, QLiveData<com.bytedance.android.window.shop.home.tab.b> r5) {
        Intrinsics.checkNotNullParameter(r3, "rootView");
        Intrinsics.checkNotNullParameter(r4, "tabFragment");
        super(r4);
        this.z = r3;
        this.A = r4;
        this.B = r5;
        this.f = true;
        this.g = LazyKt.lazy(new ECWindowTabPresenter$shopViewModel$2(this));
        this.h = LazyKt.lazy(new ECWindowTabPresenter$viewModel$2(this));
        this.i = LazyKt.lazy(new ECWindowTabPresenter$tabExtViewModel$2(this));
        this.j = LazyKt.lazy(new ECWindowTabPresenter$tabCardViewModel$2(this));
        this.k = LazyKt.lazy(new ECWindowTabPresenter$initOnceHelper$2(this));
        this.q = new ArrayList();
        this.r = ReplaySubject.a();
        this.s = LazyKt.lazy(new ECWindowTabPresenter$playAbilityPlugin$2(this));
        this.t = LazyKt.lazy(new ECWindowTabPresenter$dataBufferItemTypes$2(this));
        this.u = LazyKt.lazy(new ECWindowTabPresenter$adapter$2(this));
        this.v = new com.bytedance.android.window.shop.home.tab.tabplugin.f();
        this.w = new WindowTypeSeparatedAdapter(r4, CollectionsKt.emptyList(), ECWindowTabPresenter$pinAdapter$1.INSTANCE, ECWindowTabPresenter$pinAdapter$2.INSTANCE);
        this.x = new ECWindowTabPresenter$scrollLoadMoreListener$1(this);
        final Function1<Integer, Unit> r6 = new ECWindowTabPresenter$scrollListener$2(this);
        final Function1<Boolean, Unit> r7 = new ECWindowTabPresenter$scrollListener$3(this);
        this.y = new ECWindowTabPresenter$scrollListener$1(r6, r7);
    }
}
