package yi3;

import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.shopping.store.home.e0;
import com.bytedance.android.shopping.store.home.entity.n;
import com.bytedance.android.shopping.store.home.event.ChangeStateType;
import com.bytedance.android.shopping.store.home.presenter.ECShopBasePresenter;
import com.bytedance.android.shopping.store.home.presenter.e4;
import com.bytedance.android.shopping.store.home.view.MoveDelegateFrameLayout;
import com.bytedance.android.shopping.store.home.view.TopSheetLayout;
import com.bytedance.android.shopping.store.live.event.ShopLiveState;
import com.bytedance.android.shopping.store.repository.vo.TabEnum;
import com.bytedance.android.shopping.store.settings.ECShopABSettings;
import com.bytedance.android.shopping.store.tabkit.container.TabKitBottomSheetBehavior;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import com.bytedance.android.shopping.store.viewmodel.ShopStatus;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class b extends ECShopBasePresenter implements com.bytedance.android.shopping.store.viewmodel.e {
    public final a A;
    public final j B;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public TabKitBottomSheetBehavior<View> f567898u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public TopSheetLayout f567899v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Integer f567900w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f567901x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f567902y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public ui3.e f567903z;

    public static final class a implements TopSheetLayout.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f567904a;

        @Override // com.bytedance.android.shopping.store.home.view.TopSheetLayout.b
        public final void a(View r100) {
            Intrinsics.checkNotNullParameter(r100, "sheetView");
        }

        public a(b r100) {
            this.f567904a = r100;
        }

        @Override // com.bytedance.android.shopping.store.home.view.TopSheetLayout.b
        public final void b(float r100, boolean r101) {
            this.f567904a.T().setUpglideFactor(r100, r101);
            if (r101 == false) goto L6;
            this.f567904a.T().hasSlideOrTouchByUser();
            return;
        }
    }

    /* JADX INFO: renamed from: yi3.b$b, reason: collision with other inner class name */
    public static final class C8345b implements TabKitBottomSheetBehavior.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f567905a;

        public C8345b(b r100) {
            this.f567905a = r100;
        }

        @Override // com.bytedance.android.shopping.store.tabkit.container.TabKitBottomSheetBehavior.a
        public final void a(View r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "bottomSheet");
            if (r101 != 3) goto L5;
            b.r0(this.f567905a).setEnableSheetScroll(true);
        L8:
            if (this.f567905a.T().getLandingState() != 0) goto L15;
            Integer r102 = this.f567905a.f567900w;
            if (r102 == null) goto L15;
            if (r101 != r102.intValue()) goto L15;
            this.f567905a.T().setLandingState(1);
        L15:
            this.f567905a.T().getBehaviorState().setValue(Integer.valueOf(r101));
            if (r101 == 3) goto L18;
            if (r101 == 4) goto L18;
        L24:
            if (r101 != 3) goto L29;
            b r103 = this.f567905a;
            if (r103.f567901x == false) goto L28;
            r103.T().getShopStatus().c(ShopStatus.PREVIEW_COLLAPSE);
            return;
        L28:
            r103.T().getShopStatus().c(ShopStatus.NORMAL);
            return;
        L29:
            ShopStatus r104 = ShopStatus.PREVIEW_EXPANDED;
            if (r101 != r104.getValue()) goto L32;
        L38:
            jm.a<ShopStatus> r105 = this.f567905a.T().getShopStatus();
            ShopStatus.Companion.getClass();
            if (r101 != 0) goto L41;
            r104 = ShopStatus.NORMAL;
        L51:
            r105.c(r104);
            return;
        L41:
            if (r101 == 2) goto L49;
            if (r101 == 3) goto L48;
            if (r101 == 4) goto L51;
            if (r101 == 5) goto L47;
            r104 = ShopStatus.NORMAL;
            goto L51
        L47:
            r104 = ShopStatus.HIDE;
            goto L51
        L48:
            r104 = ShopStatus.PREVIEW_COLLAPSE;
            goto L51
        L49:
            r104 = ShopStatus.IN_PROGRESS;
            goto L51
        L32:
            if (r101 == ShopStatus.HIDE.getValue()) goto L38;
            if (r101 >= ShopStatus.PREVIEW_COLLAPSE.getValue()) goto L37;
            this.f567905a.T().getShopStatus().c(ShopStatus.IN_PROGRESS);
            return;
        L37:
            dm.a.a("shop_frame").w("onStateChanged, invalid status:" + r101, null);
            return;
        L18:
            if (r101 != 3) goto L20;
            float r106 = 1.0f;
        L21:
            dm.a.a("ECStoreInteractionPresenter").a("onStateChanged try update factor, newFactor=" + r106 + ", currentFactor=" + this.f567905a.T().getCollapseFactor().getValue());
            if ((true ^ Intrinsics.areEqual(r106, this.f567905a.T().getCollapseFactor().getValue())) == false) goto L24;
            this.f567905a.T().setCollapseFactor(r106);
            goto L24
        L20:
            r106 = 0.0f;
            goto L21
        L5:
            if (r101 != 4) goto L8;
            b.r0(this.f567905a).setEnableSheetScroll(false);
            goto L8
        }

        @Override // com.bytedance.android.shopping.store.tabkit.container.TabKitBottomSheetBehavior.a
        public final void b(View r100, float r101) {
            Intrinsics.checkNotNullParameter(r100, "bottomSheet");
            Intrinsics.checkNotNullParameter(r100, "bottomSheet");
        }

        @Override // com.bytedance.android.shopping.store.tabkit.container.TabKitBottomSheetBehavior.a
        public final void c(View r100, float r101, int r102, int r103, int r104) {
            Intrinsics.checkNotNullParameter(r100, "bottomSheet");
            dm.a.a("上滑动距离").a("onSlide:" + r102 + ",slideOffset:" + r101 + ", slideByAuto:" + b.q0(this.f567905a).f186666i);
            ECStoreViewModel r105 = this.f567905a.T();
            if (r103 <= 0) goto L5;
            int r106 = 1;
        L6:
            r105.setSlideDirection(r106);
            this.f567905a.T().setSlideByAuto(b.q0(this.f567905a).f186666i);
            this.f567905a.T().setCollapseFactor(r101);
            this.f567905a.T().setSlideDistance(r102);
            this.f567905a.T().getBehaviorState().setValue(Integer.valueOf(r104));
            ECStoreViewModel r107 = this.f567905a.T();
            if (r104 != 1) goto L9;
            boolean r108 = true;
        L10:
            r107.setDragging(r108);
            if (r104 != 1) goto L14;
            this.f567905a.T().hasSlideOrTouchByUser();
            return;
        L14:
            return;
        L9:
            r108 = false;
            goto L10
        L5:
            r106 = -1;
            goto L6
        }
    }

    public static final class c<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f567906a;

        public c(b r100) {
            this.f567906a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r110) {
            n r111 = (n) r110;
            b r112 = this.f567906a;
            b.q0(r112);
            e4 r100 = r112.T().getFrameConfig();
            if (r100 != null) goto L5;
            dm.a.a("shop_frame").b("initBottomSheetBehavior, frameConfig is invalid", null);
            r100 = null;
        L5:
            if (r100 == null) goto L50;
            TabKitBottomSheetBehavior<View> r101 = r112.f567898u;
            if (r101 != null) goto L10;
            Intrinsics.throwUninitializedPropertyAccessException("behavior");
        L10:
            r101.setPeekHeight(r100.f184158b);
            TabKitBottomSheetBehavior<View> r102 = r112.f567898u;
            if (r102 != null) goto L13;
            Intrinsics.throwUninitializedPropertyAccessException("behavior");
        L13:
            r102.f186663f = r100.f184157a;
            TabKitBottomSheetBehavior<View> r103 = r112.f567898u;
            if (r103 != null) goto L16;
            Intrinsics.throwUninitializedPropertyAccessException("behavior");
        L16:
            r103.setState(r100.f184159c);
            TabKitBottomSheetBehavior<View> r104 = r112.f567898u;
            if (r104 != null) goto L19;
            Intrinsics.throwUninitializedPropertyAccessException("behavior");
        L19:
            r104.f186668k = r100.f184160d;
            TabKitBottomSheetBehavior<View> r105 = r112.f567898u;
            if (r105 != null) goto L22;
            Intrinsics.throwUninitializedPropertyAccessException("behavior");
        L22:
            int r106 = e0.f183628a;
            ECShopABSettings r107 = ECShopABSettings.f186148k;
            boolean r108 = false;
            if (r107.getEC_SHOP_HEADER_UI_OPT() < 1) goto L25;
            boolean r109 = true;
        L26:
            if (r109 == true) goto L28;
        L32:
            boolean r113 = false;
        L33:
            r105.f186665h = r113;
            TabKitBottomSheetBehavior<View> r114 = r112.f567898u;
            if (r114 != null) goto L37;
            Intrinsics.throwUninitializedPropertyAccessException("behavior");
        L37:
            if (r107.getEC_SHOP_HEADER_UI_OPT() < 1) goto L39;
            boolean r115 = true;
        L40:
            if (r115 == true) goto L42;
        L46:
            r114.f186664g = !r108;
            TabKitBottomSheetBehavior<View> r116 = r112.f567898u;
            if (r116 != null) goto L49;
            Intrinsics.throwUninitializedPropertyAccessException("behavior");
        L49:
            r112.f567901x = r116.f186663f;
            dm.a.a("shop_frame").w("initBottomSheetBehavior, frameConfig=" + r100, null);
            goto L50
        L42:
            if (Intrinsics.areEqual(r112.T().isBrandShop().getValue(), Boolean.TRUE) == false) goto L46;
            if (r112.T().isCroppedStyle() == true) goto L46;
            r108 = true;
            goto L46
        L39:
            r115 = false;
            goto L40
        L28:
            if (Intrinsics.areEqual(r112.T().isBrandShop().getValue(), Boolean.TRUE) == false) goto L32;
            if (r112.T().isCroppedStyle() == true) goto L32;
            r113 = true;
            goto L33
        L25:
            r109 = false;
        L50:
            MoveDelegateFrameLayout r117 = (MoveDelegateFrameLayout) r112.y().findViewById(R.id.ec_store_live_container_lowest);
            View r118 = r112.y().findViewById(R.id.ec_store_coordinator_layout);
            r118.post(new yi3.a(r112, r117, r118));
        }
    }

    public static final class d<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f567907a;

        public d(b r100) {
            this.f567907a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            if (((ShopLiveState) r100).f185518a != ShopLiveState.PlayState.ERROR) goto L6;
            this.f567907a.v0(ShopStatus.NORMAL);
            return;
        }
    }

    public static final class e<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f567908a;

        public e(b r100) {
            this.f567908a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            TopSheetLayout r101 = b.r0(this.f567908a);
            if (((uj3.j) r100).f550300d != TabEnum.PRODUCT_TAB.getType()) goto L5;
            boolean r102 = true;
        L6:
            r101.setEnableSetNestedScrollView(r102);
            TopSheetLayout r103 = b.r0(this.f567908a);
            RecyclerView r104 = r103.f184679r;
            if (r104 == null) goto L9;
            r104.removeOnScrollListener(r103.f184682u);
        L9:
            r103.f184679r = null;
            return;
        L5:
            r102 = false;
            goto L6
        }
    }

    public static final class f<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f567909a;

        public f(b r100) {
            this.f567909a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            ui3.c r101 = (ui3.c) r100;
            dm.a.a("点击进直播间").b("ChangeStateEvent" + r101.f550146a, new Exception("changeStateEvent"));
            this.f567909a.T().getLandingState();
            int r102 = b.q0(this.f567909a).f186658a;
            ShopStatus r103 = r101.f550148c;
            if (r103 == null) goto L5;
            this.f567909a.v0(r103);
            return;
        L5:
            this.f567909a.t0(r101.f550146a);
        }
    }

    public static final class g<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f567910a;

        public g(b r100) {
            this.f567910a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Boolean r101 = (Boolean) r100;
            TabKitBottomSheetBehavior r102 = b.q0(this.f567910a);
            if (r101.booleanValue() == true) goto L5;
        L7:
            boolean r103 = false;
        L8:
            r102.f186663f = r103;
            b.r0(this.f567910a).setEnableInternalScroll(r101.booleanValue());
            return;
        L5:
            if (this.f567910a.f567901x == false) goto L7;
            r103 = true;
            goto L8
        }
    }

    public static final class h<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f567911a;

        public h(b r100) {
            this.f567911a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            b r101 = this.f567911a;
            r101.u0((ui3.e) r100);
        }
    }

    public static final class i<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f567912a;

        public i(b r100) {
            this.f567912a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            if (Intrinsics.areEqual((Float) r100, 1.0f) == false) goto L16;
            b r101 = this.f567912a;
            if (r101.f567902y == true) goto L7;
            return;
        L7:
            if (r101.s0(r101.f567903z) == false) goto L9;
            b.r0(this.f567912a).post(new yi3.c(this));
        L14:
            this.f567912a.f567902y = false;
            return;
        L9:
            TopSheetLayout r102 = b.r0(this.f567912a);
            if (this.f567912a.f567903z.f550151b != ChangeStateType.HAND) goto L12;
            boolean r103 = true;
        L13:
            r102.a(r103);
            goto L14
        L12:
            r103 = false;
            goto L13
        }
    }

    public static final class j implements TopSheetLayout.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f567913a;

        public j(b r100) {
            this.f567913a = r100;
        }

        @Override // com.bytedance.android.shopping.store.home.view.TopSheetLayout.a
        public final void onScrollStateChanged(int r100) {
            this.f567913a.T().getScrollState().setValue(Integer.valueOf(r100));
        }
    }

    public static final class k implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f567914a;

        public k(b r100) {
            this.f567914a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            b.r0(this.f567914a).b();     // Catch: Throwable -> L4
            this.f567914a.T().getSkipHeaderCollapseAnimOnce().setValue(Boolean.FALSE);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QPresenter
    public final void C() {
        T().removeImmediateCollapseStateListener(this);
    }

    public b(Fragment r100) {
        super(r100);
        this.f567903z = new ui3.e(0, ChangeStateType.HAND);
        this.A = new a(this);
        this.B = new j(this);
    }

    public static final /* synthetic */ TabKitBottomSheetBehavior q0(b r100) {
        TabKitBottomSheetBehavior<View> r101 = r100.f567898u;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("behavior");
    L5:
        return r101;
    }

    public static final /* synthetic */ TopSheetLayout r0(b r100) {
        TopSheetLayout r101 = r100.f567899v;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("topSheetLayout");
    L5:
        return r101;
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QPresenter
    public final void A(QModel r100) {
        TopSheetLayout r101 = (TopSheetLayout) y().findViewById(R.id.ec_store_content_container);
        this.f567899v = r101;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("topSheetLayout");
    L5:
        ViewGroup.LayoutParams r102 = r101.getLayoutParams();
        if (r102 == null) goto L39;
        CoordinatorLayout.Behavior r103 = ((CoordinatorLayout.LayoutParams) r102).getBehavior();
        if (r103 == null) goto L37;
        this.f567898u = (TabKitBottomSheetBehavior) r103;
        TopSheetLayout r104 = this.f567899v;
        if (r104 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("topSheetLayout");
    L12:
        r104.setOnTopSheetOffsetChangeListener(this.A);
        TopSheetLayout r105 = this.f567899v;
        if (r105 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("topSheetLayout");
    L15:
        r105.setScrollListener(this.B);
        TabKitBottomSheetBehavior<View> r106 = this.f567898u;
        if (r106 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("behavior");
    L18:
        r106.setHideable(true);
        TabKitBottomSheetBehavior<View> r107 = this.f567898u;
        if (r107 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("behavior");
    L21:
        r107.f186668k = true;
        if (T().isCroppedStyle() == false) goto L27;
        TabKitBottomSheetBehavior<View> r108 = this.f567898u;
        if (r108 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("behavior");
    L26:
        r108.setState(4);
        T().setCollapseFactor(0.0f);
        T().getBehaviorState().setValue(4);
        T().getShopStatus().setValue(ShopStatus.PREVIEW_EXPANDED);
    L31:
        TabKitBottomSheetBehavior<View> r109 = this.f567898u;
        if (r109 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("behavior");
    L34:
        C8345b r110 = new C8345b(this);
        r109.getClass();
        Intrinsics.checkNotNullParameter(r110, "callback");
        r109.E.add(r110);
        T().getHeaderArea().a(ECQuickUtilKt.a(u()), new c(this), false);
        T().getLiveState().a(u().e(), new d(this), false);
        T().getCurrentTabLiveData().a(ECQuickUtilKt.a(u()), new e(this), false);
        T().getChangeStateEvent().a(u().e(), new f(this), false);
        T().getChangeScrollEvent().a(u().e(), new g(this), false);
        T().getHeaderStateEvent().a(W(), new h(this), false);
        T().addImmediateCollapseStateListener(this);
        T().getCollapseFactor().a(W(), new i(this), false);
        return;
    L27:
        TabKitBottomSheetBehavior<View> r111 = this.f567898u;
        if (r111 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("behavior");
    L30:
        r111.setState(3);
        T().setCollapseFactor(1.0f);
        T().getBehaviorState().setValue(3);
        T().getShopStatus().setValue(ShopStatus.NORMAL);
        goto L31
    L37:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.store.tabkit.container.TabKitBottomSheetBehavior<android.view.View>");
    L39:
        throw new NullPointerException("null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
    }

    @Override // com.bytedance.android.shopping.store.viewmodel.e
    public final void n(ui3.c r100) {
        Intrinsics.checkNotNullParameter(r100, "changeStateEvent");
        ShopStatus r101 = r100.f550148c;
        if (r101 == null) goto L5;
        v0(r101);
        return;
    L5:
        t0(r100.f550146a);
    }

    @Override // com.bytedance.android.shopping.store.viewmodel.e
    public final void p(ui3.e r100) {
        Intrinsics.checkNotNullParameter(r100, "headerStateEvent");
        u0(r100);
    }

    public final boolean s0(ui3.e r100) {
        if (r100.f550150a == 1) goto L6;
        return false;
    L6:
        if (r100.f550151b == ChangeStateType.AUTO) goto L9;
        return false;
    L9:
        return Intrinsics.areEqual(T().getSkipHeaderCollapseAnimOnce().getValue(), Boolean.TRUE);
    }

    public final void t0(int r100) {
        if (T().getLandingState() != 0) goto L14;
        TabKitBottomSheetBehavior<View> r101 = this.f567898u;
        if (r101 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("behavior");
    L8:
        if (r101.f186658a != r100) goto L10;
        T().setLandingState(1);
        return;
    L10:
        TabKitBottomSheetBehavior<View> r102 = this.f567898u;
        if (r102 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("behavior");
    L13:
        r102.setState(r100);
        this.f567900w = Integer.valueOf(r100);
        return;
    L14:
        TabKitBottomSheetBehavior<View> r103 = this.f567898u;
        if (r103 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("behavior");
    L17:
        r103.setState(r100);
    }

    public final void u0(ui3.e r100) {
        this.f567903z = r100;
        int r101 = r100.f550150a;
        if (r101 == 0) goto L24;
        boolean r102 = true;
        if (r101 == 1) goto L8;
        return;
    L8:
        if (Intrinsics.areEqual(T().getCollapseFactor().getValue(), 1.0f) == true) goto L10;
        t0(3);
        this.f567902y = true;
        return;
    L10:
        if (s0(r100) == false) goto L15;
        TopSheetLayout r103 = this.f567899v;
        if (r103 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("topSheetLayout");
    L14:
        r103.post(new k(this));
        return;
    L15:
        TopSheetLayout r104 = this.f567899v;
        if (r104 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("topSheetLayout");
    L19:
        if (r100.f550151b == ChangeStateType.HAND) goto L22;
        r102 = false;
    L22:
        r104.a(r102);
        return;
    L24:
        TopSheetLayout r105 = this.f567899v;
        if (r105 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("topSheetLayout");
    L27:
        r105.f184664c.abortAnimation();
        r105.f184686y = r105.getScrollY();
        r105.f184664c.startScroll(0, r105.getScrollY(), 0, -r105.getScrollY(), r105.f184683v);
        r105.invalidate();
        r105.c();
    }

    public final void v0(ShopStatus r100) {
        if (r100 != ShopStatus.NORMAL) goto L9;
        t0(3);
        TabKitBottomSheetBehavior<View> r101 = this.f567898u;
        if (r101 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("behavior");
    L7:
        r101.f186663f = false;
        return;
    L9:
        if (r100.getValue() >= ShopStatus.PREVIEW_COLLAPSE.getValue()) goto L11;
    L13:
        dm.a.a("shop_frame").w("updateShopStatus, ignore", null);
        return;
    L11:
        if (r100.getValue() > ShopStatus.HIDE.getValue()) goto L13;
        t0(r100.getValue());
    }
}
