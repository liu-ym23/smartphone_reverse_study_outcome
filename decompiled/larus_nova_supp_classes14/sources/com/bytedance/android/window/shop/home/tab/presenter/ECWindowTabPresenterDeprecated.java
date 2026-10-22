package com.bytedance.android.window.shop.home.tab.presenter;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bytedance.android.ec.window.base.status.WindowLazyStatusView;
import com.bytedance.android.window.shop.holder.footer.FooterStatus;
import com.bytedance.android.window.shop.home.tab.WindowTabViewModelDeprecated;
import com.bytedance.android.window.shop.home.tab.tabplugin.ECWindowPlayAbilityPlugin;
import com.bytedance.android.window.shop.home.tab.tabplugin.ECWindowTabNewProductPlugin;
import com.bytedance.android.window.shop.home.viewmodel.ECWindowViewModel;
import com.bytedance.android.window.shop.product.pinrecyclerview.ECRecyclerViewPinnableLayout;
import com.bytedance.android.window.shop.repository.compat.WindowTabInfoProvider;
import com.bytedance.android.window.shop.repository.dto.WindowTabDataListResponseDTODeprecated;
import com.bytedance.android.window.shop.repository.tab.datasource.ShopWindowVODataType;
import com.bytedance.android.window.shop.repository.tab.entity.WindowProductCategoryVODeprecated;
import com.bytedance.android.window.shop.repository.tab.entity.e0;
import com.bytedance.android.window.shop.repository.tab.entity.g0;
import com.bytedance.android.window.shop.repository.tab.entity.n0;
import com.bytedance.android.window.shop.widget.ECShopRecyclerView;
import com.bytedance.android.window.shop.widget.WindowTypeSeparatedAdapter;
import com.bytedance.android.window.shop.widget.category.CategoryBarView;
import com.bytedance.android.window.shop.widget.category.CategoryScrollView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
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
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/window/shop/home/tab/presenter/ECWindowTabPresenterDeprecated;", "Lcom/ss/android/ugc/aweme/kiwi/presenter/QFragmentPresenter;", "Lcom/bytedance/android/window/shop/repository/tab/datasource/c;", "Landroidx/lifecycle/LifecycleEventObserver;", "Lcom/bytedance/android/window/shop/product/pinrecyclerview/ECRecyclerViewPinnableLayout$b;", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECWindowTabPresenterDeprecated extends QFragmentPresenter implements com.bytedance.android.window.shop.repository.tab.datasource.c, LifecycleEventObserver, ECRecyclerViewPinnableLayout.b {
    public static final /* synthetic */ int x = 0;
    public boolean f;
    public final Lazy g;
    public final Lazy h;
    public final Lazy i;
    public WindowLazyStatusView j;
    public ECShopRecyclerView k;
    public ECRecyclerViewPinnableLayout l;
    public final List<Runnable> m;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public final com.bytedance.android.window.shop.home.tab.tabplugin.f q;
    public final WindowTypeSeparatedAdapter r;
    public RecyclerView.ItemAnimator s;
    public final ECWindowTabPresenterDeprecated$scrollLoadMoreListener$1 t;
    public final ECWindowTabPresenterDeprecated$scrollListener$1 u;
    public final View v;
    public final Fragment w;

    public static final class a {
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ ECWindowTabPresenterDeprecated a;

        public b(ECWindowTabPresenterDeprecated r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            if (this.a.w.getLifecycle().getCurrentState() != Lifecycle.State.RESUMED) goto L11;
            ECRecyclerViewPinnableLayout r3 = this.a.l;
            if (r3 != null) goto L7;
            Intrinsics.throwUninitializedPropertyAccessException("recyclerViewPinLayout");
        L7:
            r3.f();
            ECShopRecyclerView r4 = ECWindowTabPresenterDeprecated.d0(this.a);
            int r0 = ECShopRecyclerView.d;
            r4.stopScroll();
            StaggeredGridLayoutManager r5 = r4.m965getLayoutManager();
            if (r5 == null) goto L12;
            r5.scrollToPositionWithOffset(0, 0);
            return;
        L12:
            return;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ ECWindowTabPresenterDeprecated a;
        public final /* synthetic */ n0 b;
        public final /* synthetic */ ShopWindowVODataType c;

        public c(ECWindowTabPresenterDeprecated r1, n0 r2, ShopWindowVODataType r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ECWindowTabPresenterDeprecated r0 = this.a;     // Catch: Throwable -> L4
            n0 r1 = this.b;     // Catch: Throwable -> L4
            ShopWindowVODataType r2 = this.c;     // Catch: Throwable -> L4
            int r3 = ECWindowTabPresenterDeprecated.x;     // Catch: Throwable -> L4
            r0.m0(r1, r2);     // Catch: Throwable -> L4
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
        public final /* synthetic */ ECWindowTabPresenterDeprecated a;

        public d(ECWindowTabPresenterDeprecated r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ECWindowTabPresenterDeprecated r0 = this.a;     // Catch: Throwable -> L4
            int r1 = ECWindowTabPresenterDeprecated.x;     // Catch: Throwable -> L4
            r0.h0();     // Catch: Throwable -> L4
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

    @Override // com.bytedance.android.window.shop.repository.tab.datasource.e
    public final void V(String r1, int r2, long r3, Long r5) {
    }

    @Override // com.bytedance.android.window.shop.repository.tab.datasource.c
    public final void e() {
    }

    public final WindowTypeSeparatedAdapter i0() {
        return (WindowTypeSeparatedAdapter) this.p.getValue();
    }

    public final ECWindowViewModel j0() {
        return (ECWindowViewModel) this.g.getValue();
    }

    public final WindowTabViewModelDeprecated k0() {
        return (WindowTabViewModelDeprecated) this.h.getValue();
    }

    public final synchronized void l0() {
        monitor-enter(this);
    L12:
    L9:
        th = move-exception;
        throw th;
    L4:
        if ((!this.m.isEmpty()) == false) goto L7;
        ((Runnable) ListProtector.remove(this.m, 0)).run();     // Catch: Throwable -> L9
        goto L12
    L7:
        monitor-exit(this);
    }

    public final void c0() {
        this.q.b();
    }

    public final void h0() {
        i0().A2();
        if (i0().getBasicItemCount() != 0) goto L8;
        WindowLazyStatusView r0 = this.j;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("statusView");
    L7:
        r0.b(com.bytedance.android.ec.window.base.status.c.b.a);
    L12:
        i0().E2(FooterStatus.NO_MORE);
        ECWindowTabPresenterDeprecated$scrollLoadMoreListener$1 r1 = this.t;
        r1.b = false;
        r1.c = true;
        return;
    L8:
        WindowLazyStatusView r2 = this.j;
        if (r2 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("statusView");
    L11:
        r2.a();
        goto L12
    }

    public static final /* synthetic */ ECShopRecyclerView d0(ECWindowTabPresenterDeprecated r1) {
        ECShopRecyclerView r2 = r1.k;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L5:
        return r2;
    }

    public final void b0(QModel r6) {
        k0().init(j0().getShopParam().getSecAuthorId(), (String) j0().getShopParam().getPassThroughParam("pass_through_api"), j0().getHeaderSubTabsParam().b, (WindowTabDataListResponseDTODeprecated) j0().getHeaderSubTabsParam().c.getValue());
        Unit r7 = (Unit) this.i.getValue();
        RecyclerView r8 = this.k;
        if (r8 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L5:
        r8.setBackgroundResource(2131101858);
        this.w.getLifecycle().removeObserver(this);
        this.w.getLifecycle().addObserver(this);
        j0().getGoTopEventReceiver().observe(this.w, new b(this));
        this.q.a(new com.bytedance.android.window.shop.home.tab.tabplugin.e[]{(ECWindowPlayAbilityPlugin) this.n.getValue(), new ECWindowTabNewProductPlugin(j0(), k0().getShopWindowItemType(), new ECWindowTabPresenterDeprecated$onBind$2(this))});
    }

    @Override // com.bytedance.android.window.shop.repository.tab.datasource.c
    public final void c(com.bytedance.android.window.shop.repository.tab.datasource.impl.a<?, ?> r2) {
        if (((ArrayList) this.m).isEmpty() == false) goto L5;
        h0();
        return;
    L5:
        List<Runnable> r3 = this.m;
        ArrayList r4 = (ArrayList) r3;
        r4.add(new d(this));
    }

    public final void n0(FooterStatus r5) {
        ECWindowTabPresenterDeprecated$scrollLoadMoreListener$1 r0 = this.t;
        r0.c = false;
        r0.b = false;
        i0().E2(r5);
        i0().H2();
        i0().F2(new g0(i0().g, k0().getShopWindowItemType()));
        ECRecyclerViewPinnableLayout r6 = this.l;
        if (r6 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerViewPinLayout");
    L5:
        int r7 = r6.c();
        if ((-1) == r7) goto L14;
        ECShopRecyclerView r1 = this.k;
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

    public final void o0(List<? extends com.bytedance.android.window.shop.repository.tab.entity.f> r5) {
        com.bytedance.android.window.shop.c r0 = k0().getShopWindowItemType();
        ConcurrentHashMap<Integer, com.bytedance.android.window.shop.c> r1 = com.bytedance.android.window.shop.c.b;
        if ((!Intrinsics.areEqual(r0, com.bytedance.android.window.shop.c.c)) == false) goto L5;
        return;
    L5:
        int r2 = 0;
        if (r5.size() == 1) goto L8;
    L10:
        Iterator<? extends com.bytedance.android.window.shop.repository.tab.entity.f> r3 = r5.iterator();
        int r4 = 0;
    L12:
        if (r3.hasNext() == false) goto L17;
        if ((r3.next() instanceof e0) == true) goto L18;
        r4 = r4 + 1;
    L18:
        Iterator<T> r6 = r5.iterator();
    L20:
        if (r6.hasNext() == false) goto L28;
        Object r7 = r6.next();
        int r8 = r2 + 1;
        if (r2 >= 0) goto L24;
        CollectionsKt.throwIndexOverflow();
    L24:
        com.bytedance.android.window.shop.repository.tab.entity.f r9 = (com.bytedance.android.window.shop.repository.tab.entity.f) r7;
        if (r2 <= r4) goto L27;
        int r10 = r9.i;
    L27:
        r2 = r8;
        goto L20
    L28:
        return;
    L17:
        r4 = -1;
        goto L18
    L8:
        if (Intrinsics.areEqual(ListProtector.get(r5, 0).getClass(), com.bytedance.android.window.shop.repository.tab.entity.x.class) == false) goto L10;
    }

    @Override // com.bytedance.android.window.shop.repository.tab.datasource.c
    public final void onError(String r3) {
        Intrinsics.checkNotNullParameter("", "msg");
        i0().A2();
        if (i0().getBasicItemCount() != 0) goto L11;
        RecyclerView r4 = this.k;
        if (r4 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L7:
        r4.setVisibility(8);
        WindowLazyStatusView r5 = this.j;
        if (r5 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("statusView");
    L10:
        r5.b(com.bytedance.android.ec.window.base.status.c.c.a);
    L15:
        this.t.b = false;
        return;
    L11:
        WindowLazyStatusView r6 = this.j;
        if (r6 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("statusView");
    L14:
        r6.a();
        goto L15
    }

    /* JADX WARN: Type inference failed for: r4v17, types: [com.bytedance.android.window.shop.home.tab.presenter.ECWindowTabPresenterDeprecated$scrollLoadMoreListener$1] */
    /* JADX WARN: Type inference failed for: r4v18, types: [com.bytedance.android.window.shop.home.tab.presenter.ECWindowTabPresenterDeprecated$scrollListener$1] */
    public ECWindowTabPresenterDeprecated(View r4, Fragment r5) {
        Intrinsics.checkNotNullParameter(r4, "rootView");
        Intrinsics.checkNotNullParameter(r5, "tabFragment");
        super(r5);
        this.v = r4;
        this.w = r5;
        this.f = true;
        this.g = LazyKt.lazy(new ECWindowTabPresenterDeprecated$shopViewModel$2(this));
        this.h = LazyKt.lazy(new ECWindowTabPresenterDeprecated$viewModel$2(this));
        this.i = LazyKt.lazy(new ECWindowTabPresenterDeprecated$initOnceHelper$2(this));
        this.m = new ArrayList();
        this.n = LazyKt.lazy(new ECWindowTabPresenterDeprecated$playAbilityPlugin$2(this));
        this.o = LazyKt.lazy(new ECWindowTabPresenterDeprecated$dataBufferItemTypes$2(this));
        this.p = LazyKt.lazy(new ECWindowTabPresenterDeprecated$adapter$2(this));
        this.q = new com.bytedance.android.window.shop.home.tab.tabplugin.f();
        this.r = new WindowTypeSeparatedAdapter(r5, CollectionsKt.emptyList(), ECWindowTabPresenterDeprecated$pinAdapter$1.INSTANCE, ECWindowTabPresenterDeprecated$pinAdapter$2.INSTANCE);
        this.t = new ECWindowTabPresenterDeprecated$scrollLoadMoreListener$1(this);
        final Function1<Integer, Unit> r6 = new ECWindowTabPresenterDeprecated$scrollListener$2(this);
        final Function1<Boolean, Unit> r0 = new ECWindowTabPresenterDeprecated$scrollListener$3(this);
        this.u = new ECWindowTabPresenterDeprecated$scrollListener$1(r6, r0);
    }

    public static final void e0(final ECWindowTabPresenterDeprecated r2, CategoryScrollView r3) {
        WindowTabDataListResponseDTODeprecated r0 = (WindowTabDataListResponseDTODeprecated) r2.j0().getHeaderSubTabsParam().c.getValue();
        if (r0 == null) goto L7;
        List<com.bytedance.android.window.shop.repository.dto.i> r1 = r0.getTabs();
        if (r1 == null) goto L7;
        int r4 = r1.size();
    L9:
        if (r4 > 1) goto L11;
        wg.a.d(r3, com.bytedance.android.shopping.extensions.b.b(42));
    L11:
        final CategoryBarView r5 = r3.getCategoryBarView();
        if (r5 == null) goto L16;
        Function4<WindowProductCategoryVODeprecated.a, Integer, Integer, Integer, Unit> r6 = new ECWindowTabPresenterDeprecated$onCategoryInitialized$1(r2, r5);
        Intrinsics.checkNotNullParameter(r6, "cb");
        ((ArrayList) r5.a).add(r6);
        return;
    L16:
        return;
    L7:
        r4 = 0;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.window.shop.product.pinrecyclerview.ECRecyclerViewPinnableLayout.b
    public final void S(ECRecyclerViewPinnableLayout.InnerRecyclerView r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "recyclerView");
        if (Intrinsics.areEqual(ListProtector.get(i0().h, r4).getClass(), e0.class) == false) goto L6;
        r3.post(new u(this, r3));
        return;
    L6:
        if (Intrinsics.areEqual(ListProtector.get(i0().h, r4).getClass(), com.bytedance.android.window.shop.repository.tab.entity.x.class) == false) goto L10;
        r3.post(new v(this, r3));
        return;
    }

    @Override // com.bytedance.android.window.shop.repository.tab.datasource.e
    public final void f(WindowTabInfoProvider r3, mq3.a r4) {
        Intrinsics.checkNotNullParameter(r3, "dto");
        Intrinsics.checkNotNullParameter(r4, "reqParam");
        Intrinsics.checkNotNullParameter(r3, "dto");
        Intrinsics.checkNotNullParameter(r4, "reqParam");
        Intrinsics.checkNotNullParameter(r3, "dto");
        Intrinsics.checkNotNullParameter(r4, "reqParam");
    }

    public final void m0(n0 r7, ShopWindowVODataType r8) {
        i0().A2();
        if (r8 != ShopWindowVODataType.PIN) goto L15;
        Iterator<T> r9 = r7.a.iterator();
        int r0 = 0;
    L7:
        if (r9.hasNext() == false) goto L15;
        Object r2 = r9.next();
        int r3 = r0 + 1;
        if (r0 >= 0) goto L11;
        CollectionsKt.throwIndexOverflow();
    L11:
        com.bytedance.android.window.shop.repository.tab.entity.f r4 = (com.bytedance.android.window.shop.repository.tab.entity.f) r2;
        ECRecyclerViewPinnableLayout r5 = this.l;
        if (r5 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerViewPinLayout");
    L14:
        r5.b(((ArrayList) i0().h).size() + r0);
        r0 = r3;
    L15:
        RecyclerView r10 = this.k;
        if (r10 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L18:
        r10.setVisibility(0);
        if (i0().getBasicItemCount() >= 10) goto L21;
        boolean r11 = true;
    L22:
        WindowProductCategoryVODeprecated.a r6 = null;
        if (r11 == false) goto L33;
        ECShopRecyclerView r12 = this.k;
        if (r12 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L27:
        RecyclerView.ItemAnimator r13 = r12.getItemAnimator();
        if (r13 == null) goto L33;
        this.s = r13;
        ECShopRecyclerView r14 = this.k;
        if (r14 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L32:
        r14.setItemAnimator(null);
    L33:
        RecyclerView r15 = this.k;
        if (r15 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L36:
        r15.postDelayed(new w(this), 100);
        o0(r7.a);
        WindowTypeSeparatedAdapter r16 = i0();
        monitor-enter(r16);
        Intrinsics.checkNotNullParameter(r7, "dataWrapper");     // Catch: Throwable -> L73
        r16.D2(r7.a);     // Catch: Throwable -> L73
        monitor-exit(r16);
        if (Intrinsics.areEqual(ListProtector.get(r7.a, 0).getClass(), com.bytedance.android.window.shop.repository.tab.entity.x.class) == true) goto L43;
    L59:
        com.bytedance.android.window.shop.repository.tab.entity.f r17 = (com.bytedance.android.window.shop.repository.tab.entity.f) CollectionsKt.firstOrNull(r7.a);
        if (r17 != null) goto L63;
    L68:
        WindowLazyStatusView r18 = this.j;
        if (r18 != null) goto L71;
        Intrinsics.throwUninitializedPropertyAccessException("statusView");
    L71:
        r18.a();
        this.t.b = false;
        return;
    L63:
        if ((r17 instanceof e0) == false) goto L68;
        j0().getHeaderSubTabsParam().b = ((e0) r17).k;
        RecyclerView r19 = this.k;
        if (r19 != null) goto L67;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L67:
        r19.post(new y(this));
        goto L68
    L43:
        if (k0().getCategory() != null) goto L55;
        Object r20 = ListProtector.get(r7.a, 0);
        if ((r20 instanceof com.bytedance.android.window.shop.repository.tab.entity.x) == true) goto L47;
        r20 = null;
    L47:
        com.bytedance.android.window.shop.repository.tab.entity.x r21 = (com.bytedance.android.window.shop.repository.tab.entity.x) r20;
        if (r21 == null) goto L54;
        WindowProductCategoryVODeprecated r22 = r21.k;
        if (r22 == null) goto L54;
        List<WindowProductCategoryVODeprecated.a> r23 = r22.j;
        if (r23 == null) goto L54;
        r6 = (WindowProductCategoryVODeprecated.a) CollectionsKt.getOrNull(r23, 0);
    L54:
        k0().setCategory(r6);
    L55:
        RecyclerView r24 = this.k;
        if (r24 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L58:
        r24.post(new x(this));
    L73:
        th = move-exception;
        throw th;
    L21:
        r11 = false;
        goto L22
    }

    public final void onStateChanged(LifecycleOwner r2, Lifecycle.Event r3) {
        Intrinsics.checkNotNullParameter(r2, "source");
        Intrinsics.checkNotNullParameter(r3, "event");
        int r4 = t.a[r3.ordinal()];
        if (r4 != 1) goto L5;
        k0().clearDataSource();
        return;
    L5:
        if (r4 != 2) goto L14;
        l0();
        ECWindowTabPresenterDeprecated$scrollListener$1 r5 = this.u;
        ECShopRecyclerView r6 = this.k;
        if (r6 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L10:
        r5.j(r6.r());
        return;
    }

    @Override // com.bytedance.android.window.shop.repository.tab.datasource.c
    public final void y(n0 r3, ShopWindowVODataType r4) {
        Intrinsics.checkNotNullParameter(r3, "data");
        Intrinsics.checkNotNullParameter(r4, "dataType");
        if (this.w.getLifecycle().getCurrentState() != Lifecycle.State.RESUMED) goto L5;
        l0();
        m0(r3, r4);
        return;
    L5:
        List<Runnable> r0 = this.m;
        ArrayList r1 = (ArrayList) r0;
        r1.add(new c(this, r3, r4));
    }
}
