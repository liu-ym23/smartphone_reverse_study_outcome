package yi3;

import android.view.View;
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
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b extends ECShopBasePresenter implements com.bytedance.android.shopping.store.viewmodel.e {
    public final a A;
    public final j B;
    public TabKitBottomSheetBehavior<View> u;
    public TopSheetLayout v;
    public Integer w;
    public boolean x;
    public boolean y;
    public ui3.e z;

    public static final class a implements TopSheetLayout.b {
        public final /* synthetic */ b a;

        @Override // com.bytedance.android.shopping.store.home.view.TopSheetLayout.b
        public final void a(View r2) {
            Intrinsics.checkNotNullParameter(r2, "sheetView");
        }

        public a(b r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.shopping.store.home.view.TopSheetLayout.b
        public final void b(float r2, boolean r3) {
            this.a.T().setUpglideFactor(r2, r3);
            if (r3 == false) goto L6;
            this.a.T().hasSlideOrTouchByUser();
            return;
        }
    }

    /* JADX INFO: renamed from: yi3.b$b, reason: collision with other inner class name */
    public static final class C0190b implements TabKitBottomSheetBehavior.a {
        public final /* synthetic */ b a;

        public C0190b(b r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.shopping.store.tabkit.container.TabKitBottomSheetBehavior.a
        public final void a(View r7, int r8) {
            Intrinsics.checkNotNullParameter(r7, "bottomSheet");
            if (r8 != 3) goto L5;
            b.r0(this.a).setEnableSheetScroll(true);
        L8:
            if (this.a.T().getLandingState() != 0) goto L15;
            Integer r2 = this.a.w;
            if (r2 == null) goto L15;
            if (r8 != r2.intValue()) goto L15;
            this.a.T().setLandingState(1);
        L15:
            this.a.T().getBehaviorState().setValue(Integer.valueOf(r8));
            if (r8 == 3) goto L18;
            if (r8 == 4) goto L18;
        L24:
            if (r8 != 3) goto L29;
            b r9 = this.a;
            if (r9.x == false) goto L28;
            r9.T().getShopStatus().c(ShopStatus.PREVIEW_COLLAPSE);
            return;
        L28:
            r9.T().getShopStatus().c(ShopStatus.NORMAL);
            return;
        L29:
            ShopStatus r10 = ShopStatus.PREVIEW_EXPANDED;
            if (r8 != r10.getValue()) goto L32;
        L38:
            jm.a<ShopStatus> r3 = this.a.T().getShopStatus();
            ShopStatus.Companion.getClass();
            if (r8 != 0) goto L41;
            r10 = ShopStatus.NORMAL;
        L51:
            r3.c(r10);
            return;
        L41:
            if (r8 == 2) goto L49;
            if (r8 == 3) goto L48;
            if (r8 == 4) goto L51;
            if (r8 == 5) goto L47;
            r10 = ShopStatus.NORMAL;
            goto L51
        L47:
            r10 = ShopStatus.HIDE;
            goto L51
        L48:
            r10 = ShopStatus.PREVIEW_COLLAPSE;
            goto L51
        L49:
            r10 = ShopStatus.IN_PROGRESS;
            goto L51
        L32:
            if (r8 == ShopStatus.HIDE.getValue()) goto L38;
            if (r8 >= ShopStatus.PREVIEW_COLLAPSE.getValue()) goto L37;
            this.a.T().getShopStatus().c(ShopStatus.IN_PROGRESS);
            return;
        L37:
            dm.a.a("shop_frame").w("onStateChanged, invalid status:" + r8, null);
            return;
        L18:
            if (r8 != 3) goto L20;
            float r4 = 1.0f;
        L21:
            dm.a.a("ECStoreInteractionPresenter").a("onStateChanged try update factor, newFactor=" + r4 + ", currentFactor=" + ((Float) this.a.T().getCollapseFactor().getValue()));
            if ((true ^ Intrinsics.areEqual(r4, (Float) this.a.T().getCollapseFactor().getValue())) == false) goto L24;
            this.a.T().setCollapseFactor(r4);
            goto L24
        L20:
            r4 = 0.0f;
            goto L21
        L5:
            if (r8 != 4) goto L8;
            b.r0(this.a).setEnableSheetScroll(false);
            goto L8
        }

        @Override // com.bytedance.android.shopping.store.tabkit.container.TabKitBottomSheetBehavior.a
        public final void b(View r1, float r2) {
            Intrinsics.checkNotNullParameter(r1, "bottomSheet");
            Intrinsics.checkNotNullParameter(r1, "bottomSheet");
        }

        @Override // com.bytedance.android.shopping.store.tabkit.container.TabKitBottomSheetBehavior.a
        public final void c(View r3, float r4, int r5, int r6, int r7) {
            Intrinsics.checkNotNullParameter(r3, "bottomSheet");
            dm.a.a("上滑动距离").a("onSlide:" + r5 + ",slideOffset:" + r4 + ", slideByAuto:" + b.q0(this.a).i);
            ECStoreViewModel r8 = this.a.T();
            if (r6 <= 0) goto L5;
            int r9 = 1;
        L6:
            r8.setSlideDirection(r9);
            this.a.T().setSlideByAuto(b.q0(this.a).i);
            this.a.T().setCollapseFactor(r4);
            this.a.T().setSlideDistance(r5);
            this.a.T().getBehaviorState().setValue(Integer.valueOf(r7));
            ECStoreViewModel r10 = this.a.T();
            if (r7 != 1) goto L9;
            boolean r11 = true;
        L10:
            r10.setDragging(r11);
            if (r7 != 1) goto L14;
            this.a.T().hasSlideOrTouchByUser();
            return;
        L14:
            return;
        L9:
            r11 = false;
            goto L10
        L5:
            r9 = -1;
            goto L6
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ b a;

        public c(b r1) {
            this.a = r1;
        }

        public final void onChanged(Object r11) {
            n r12 = (n) r11;
            b r13 = this.a;
            b.q0(r13);
            e4 r0 = r13.T().getFrameConfig();
            if (r0 != null) goto L5;
            dm.a.a("shop_frame").b("initBottomSheetBehavior, frameConfig is invalid", null);
            r0 = null;
        L5:
            if (r0 == null) goto L50;
            TabKitBottomSheetBehavior<View> r3 = r13.u;
            if (r3 != null) goto L10;
            Intrinsics.throwUninitializedPropertyAccessException("behavior");
        L10:
            r3.setPeekHeight(r0.b);
            TabKitBottomSheetBehavior<View> r4 = r13.u;
            if (r4 != null) goto L13;
            Intrinsics.throwUninitializedPropertyAccessException("behavior");
        L13:
            r4.f = r0.a;
            TabKitBottomSheetBehavior<View> r5 = r13.u;
            if (r5 != null) goto L16;
            Intrinsics.throwUninitializedPropertyAccessException("behavior");
        L16:
            r5.setState(r0.c);
            TabKitBottomSheetBehavior<View> r6 = r13.u;
            if (r6 != null) goto L19;
            Intrinsics.throwUninitializedPropertyAccessException("behavior");
        L19:
            r6.k = r0.d;
            TabKitBottomSheetBehavior<View> r7 = r13.u;
            if (r7 != null) goto L22;
            Intrinsics.throwUninitializedPropertyAccessException("behavior");
        L22:
            int r8 = e0.a;
            ECShopABSettings r9 = ECShopABSettings.k;
            boolean r10 = false;
            if (r9.getEC_SHOP_HEADER_UI_OPT() < 1) goto L25;
            boolean r14 = true;
        L26:
            if (r14 == true) goto L28;
        L32:
            boolean r15 = false;
        L33:
            r7.h = r15;
            TabKitBottomSheetBehavior<View> r16 = r13.u;
            if (r16 != null) goto L37;
            Intrinsics.throwUninitializedPropertyAccessException("behavior");
        L37:
            if (r9.getEC_SHOP_HEADER_UI_OPT() < 1) goto L39;
            boolean r17 = true;
        L40:
            if (r17 == true) goto L42;
        L46:
            r16.g = !r10;
            TabKitBottomSheetBehavior<View> r18 = r13.u;
            if (r18 != null) goto L49;
            Intrinsics.throwUninitializedPropertyAccessException("behavior");
        L49:
            r13.x = r18.f;
            dm.a.a("shop_frame").w("initBottomSheetBehavior, frameConfig=" + r0, null);
            goto L50
        L42:
            if (Intrinsics.areEqual((Boolean) r13.T().isBrandShop().getValue(), Boolean.TRUE) == false) goto L46;
            if (r13.T().isCroppedStyle() == true) goto L46;
            r10 = true;
            goto L46
        L39:
            r17 = false;
            goto L40
        L28:
            if (Intrinsics.areEqual((Boolean) r13.T().isBrandShop().getValue(), Boolean.TRUE) == false) goto L32;
            if (r13.T().isCroppedStyle() == true) goto L32;
            r15 = true;
            goto L33
        L25:
            r14 = false;
        L50:
            MoveDelegateFrameLayout r1 = (MoveDelegateFrameLayout) r13.y().findViewById(2131371107);
            View r2 = r13.y().findViewById(2131371057);
            r2.post(new yi3.a(r13, r1, r2));
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ b a;

        public d(b r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            if (((ShopLiveState) r2).a != ShopLiveState.PlayState.ERROR) goto L6;
            this.a.v0(ShopStatus.NORMAL);
            return;
        }
    }

    public static final class e<T> implements Observer {
        public final /* synthetic */ b a;

        public e(b r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            TopSheetLayout r0 = b.r0(this.a);
            if (((uj3.j) r3).d != TabEnum.PRODUCT_TAB.getType()) goto L5;
            boolean r4 = true;
        L6:
            r0.setEnableSetNestedScrollView(r4);
            TopSheetLayout r5 = b.r0(this.a);
            RecyclerView r1 = r5.r;
            if (r1 == null) goto L9;
            r1.removeOnScrollListener(r5.u);
        L9:
            r5.r = null;
            return;
        L5:
            r4 = false;
            goto L6
        }
    }

    public static final class f<T> implements Observer {
        public final /* synthetic */ b a;

        public f(b r1) {
            this.a = r1;
        }

        public final void onChanged(Object r5) {
            ui3.c r6 = (ui3.c) r5;
            dm.a.a("点击进直播间").b("ChangeStateEvent" + r6.a, new Exception("changeStateEvent"));
            this.a.T().getLandingState();
            int r0 = b.q0(this.a).a;
            ShopStatus r1 = r6.c;
            if (r1 == null) goto L5;
            this.a.v0(r1);
            return;
        L5:
            this.a.t0(r6.a);
        }
    }

    public static final class g<T> implements Observer {
        public final /* synthetic */ b a;

        public g(b r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            Boolean r4 = (Boolean) r3;
            TabKitBottomSheetBehavior r0 = b.q0(this.a);
            if (r4.booleanValue() == true) goto L5;
        L7:
            boolean r1 = false;
        L8:
            r0.f = r1;
            b.r0(this.a).setEnableInternalScroll(r4.booleanValue());
            return;
        L5:
            if (this.a.x == false) goto L7;
            r1 = true;
            goto L8
        }
    }

    public static final class h<T> implements Observer {
        public final /* synthetic */ b a;

        public h(b r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            b r0 = this.a;
            r0.u0((ui3.e) r2);
        }
    }

    public static final class i<T> implements Observer {
        public final /* synthetic */ b a;

        public i(b r1) {
            this.a = r1;
        }

        public final void onChanged(Object r4) {
            if (Intrinsics.areEqual((Float) r4, 1.0f) == false) goto L16;
            b r5 = this.a;
            if (r5.y == true) goto L7;
            return;
        L7:
            if (r5.s0(r5.z) == false) goto L9;
            b.r0(this.a).post(new yi3.c(this));
        L14:
            this.a.y = false;
            return;
        L9:
            TopSheetLayout r6 = b.r0(this.a);
            if (this.a.z.b != ChangeStateType.HAND) goto L12;
            boolean r1 = true;
        L13:
            r6.a(r1);
            goto L14
        L12:
            r1 = false;
            goto L13
        }
    }

    public static final class j implements TopSheetLayout.a {
        public final /* synthetic */ b a;

        public j(b r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.shopping.store.home.view.TopSheetLayout.a
        public final void onScrollStateChanged(int r2) {
            this.a.T().getScrollState().setValue(Integer.valueOf(r2));
        }
    }

    public static final class k implements Runnable {
        public final /* synthetic */ b a;

        public k(b r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            b.r0(this.a).b();     // Catch: Throwable -> L4
            this.a.T().getSkipHeaderCollapseAnimOnce().setValue(Boolean.FALSE);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public final void C() {
        T().removeImmediateCollapseStateListener(this);
    }

    public b(Fragment r3) {
        super(r3);
        this.z = new ui3.e(0, ChangeStateType.HAND);
        this.A = new a(this);
        this.B = new j(this);
    }

    public static final /* synthetic */ TabKitBottomSheetBehavior q0(b r1) {
        TabKitBottomSheetBehavior<View> r2 = r1.u;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("behavior");
    L5:
        return r2;
    }

    public static final /* synthetic */ TopSheetLayout r0(b r1) {
        TopSheetLayout r2 = r1.v;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("topSheetLayout");
    L5:
        return r2;
    }

    public final void A(QModel r4) {
        TopSheetLayout r5 = (TopSheetLayout) y().findViewById(2131371054);
        this.v = r5;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("topSheetLayout");
    L5:
        CoordinatorLayout.LayoutParams r6 = r5.getLayoutParams();
        if (r6 == null) goto L39;
        CoordinatorLayout.Behavior r7 = r6.getBehavior();
        if (r7 == null) goto L37;
        this.u = (TabKitBottomSheetBehavior) r7;
        TopSheetLayout r8 = this.v;
        if (r8 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("topSheetLayout");
    L12:
        r8.setOnTopSheetOffsetChangeListener(this.A);
        TopSheetLayout r9 = this.v;
        if (r9 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("topSheetLayout");
    L15:
        r9.setScrollListener(this.B);
        TabKitBottomSheetBehavior<View> r10 = this.u;
        if (r10 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("behavior");
    L18:
        r10.setHideable(true);
        TabKitBottomSheetBehavior<View> r11 = this.u;
        if (r11 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("behavior");
    L21:
        r11.k = true;
        if (T().isCroppedStyle() == false) goto L27;
        TabKitBottomSheetBehavior<View> r12 = this.u;
        if (r12 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("behavior");
    L26:
        r12.setState(4);
        T().setCollapseFactor(0.0f);
        T().getBehaviorState().setValue(4);
        T().getShopStatus().setValue(ShopStatus.PREVIEW_EXPANDED);
    L31:
        TabKitBottomSheetBehavior<View> r13 = this.u;
        if (r13 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("behavior");
    L34:
        C0190b r0 = new C0190b(this);
        r13.getClass();
        Intrinsics.checkNotNullParameter(r0, "callback");
        r13.E.add(r0);
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
        TabKitBottomSheetBehavior<View> r14 = this.u;
        if (r14 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("behavior");
    L30:
        r14.setState(3);
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
    public final void n(ui3.c r2) {
        Intrinsics.checkNotNullParameter(r2, "changeStateEvent");
        ShopStatus r0 = r2.c;
        if (r0 == null) goto L5;
        v0(r0);
        return;
    L5:
        t0(r2.a);
    }

    @Override // com.bytedance.android.shopping.store.viewmodel.e
    public final void p(ui3.e r2) {
        Intrinsics.checkNotNullParameter(r2, "headerStateEvent");
        u0(r2);
    }

    public final boolean s0(ui3.e r4) {
        if (r4.a == 1) goto L6;
        return false;
    L6:
        if (r4.b == ChangeStateType.AUTO) goto L9;
        return false;
    L9:
        return Intrinsics.areEqual((Boolean) T().getSkipHeaderCollapseAnimOnce().getValue(), Boolean.TRUE);
    }

    public final void t0(int r3) {
        if (T().getLandingState() != 0) goto L14;
        TabKitBottomSheetBehavior<View> r0 = this.u;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("behavior");
    L8:
        if (r0.a != r3) goto L10;
        T().setLandingState(1);
        return;
    L10:
        TabKitBottomSheetBehavior<View> r1 = this.u;
        if (r1 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("behavior");
    L13:
        r1.setState(r3);
        this.w = Integer.valueOf(r3);
        return;
    L14:
        TabKitBottomSheetBehavior<View> r2 = this.u;
        if (r2 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("behavior");
    L17:
        r2.setState(r3);
    }

    public final void u0(ui3.e r8) {
        this.z = r8;
        int r0 = r8.a;
        if (r0 == 0) goto L24;
        boolean r2 = true;
        if (r0 == 1) goto L8;
        return;
    L8:
        if (Intrinsics.areEqual((Float) T().getCollapseFactor().getValue(), 1.0f) == true) goto L10;
        t0(3);
        this.y = true;
        return;
    L10:
        if (s0(r8) == false) goto L15;
        TopSheetLayout r9 = this.v;
        if (r9 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("topSheetLayout");
    L14:
        r9.post(new k(this));
        return;
    L15:
        TopSheetLayout r1 = this.v;
        if (r1 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("topSheetLayout");
    L19:
        if (r8.b == ChangeStateType.HAND) goto L22;
        r2 = false;
    L22:
        r1.a(r2);
        return;
    L24:
        TopSheetLayout r10 = this.v;
        if (r10 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("topSheetLayout");
    L27:
        r10.c.abortAnimation();
        r10.y = r10.getScrollY();
        r10.c.startScroll(0, r10.getScrollY(), 0, -r10.getScrollY(), r10.v);
        r10.invalidate();
        r10.c();
    }

    public final void v0(ShopStatus r3) {
        if (r3 != ShopStatus.NORMAL) goto L9;
        t0(3);
        TabKitBottomSheetBehavior<View> r4 = this.u;
        if (r4 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("behavior");
    L7:
        r4.f = false;
        return;
    L9:
        if (r3.getValue() >= ShopStatus.PREVIEW_COLLAPSE.getValue()) goto L11;
    L13:
        dm.a.a("shop_frame").w("updateShopStatus, ignore", null);
        return;
    L11:
        if (r3.getValue() > ShopStatus.HIDE.getValue()) goto L13;
        t0(r3.getValue());
    }
}
