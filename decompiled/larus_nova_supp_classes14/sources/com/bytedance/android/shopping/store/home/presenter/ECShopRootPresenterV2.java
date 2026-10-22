package com.bytedance.android.shopping.store.home.presenter;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.store.common.bubble.ECBubbleControllerManager;
import com.bytedance.android.ec.store.setting.ECStoreSettings;
import com.bytedance.android.ec.store.utils.taskmanager.ECTaskManager;
import com.bytedance.android.ec.store.utils.taskmanager.TaskPriority;
import com.bytedance.android.shopping.extensions.ViewExtensionsKt;
import com.bytedance.android.shopping.store.home.entity.ECShopBrandHeaderStyleDto;
import com.bytedance.android.shopping.store.home.entity.ECStoreTabAreaVO;
import com.bytedance.android.shopping.store.home.frame.container.ShopContainerType;
import com.bytedance.android.shopping.store.tabkit.TabKitFragment;
import com.bytedance.android.shopping.store.tabkit.TabKitPresenter;
import com.bytedance.android.shopping.store.tabkit.view.MixTabLayout;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import com.bytedance.ies.utility.SharedPrefHelper;
import com.facebook.drawee.view.GenericDraweeView;
import com.gyf.barlibrary.ImmersionBar;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import io.reactivex.disposables.Disposable;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\bJ\b\u0010\u0004\u001a\u00020\u0003H\u0007J\b\u0010\u0005\u001a\u00020\u0003H\u0007J\b\u0010\u0006\u001a\u00020\u0003H\u0007J\b\u0010\u0007\u001a\u00020\u0003H\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/android/shopping/store/home/presenter/ECShopRootPresenterV2;", "Lcom/bytedance/android/shopping/store/home/presenter/ECShopBasePresenter;", "Landroidx/lifecycle/LifecycleObserver;", "", "onResume", "onStart", "onStop", "onDestroy", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECShopRootPresenterV2 extends ECShopBasePresenter implements LifecycleObserver {
    public static final /* synthetic */ int C = 0;
    public boolean A;
    public Disposable B;
    public ImmersionBar u;
    public FrameLayout v;
    public ViewGroup w;
    public ECDraweeView x;
    public boolean y;
    public View z;

    public static final class a {
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ ECShopRootPresenterV2 a;

        public b(ECShopRootPresenterV2 r1) {
            this.a = r1;
        }

        public final void onChanged(Object r4) {
            uj3.j r5 = (uj3.j) r4;
            r5.c();
            JSONObject r0 = new JSONObject();
            r0.put("shop_id", this.a.T().getStoreParam().getShopId());     // Catch: Throwable -> L5
            r0.put("tab_id", r5.d);     // Catch: Throwable -> L5
        L7:
            Unit r6 = Unit.INSTANCE;
            ECLiveHybridUtil.o("ecom.shop.tab_did_change", r0);
            return;
        L5:
            th = move-exception;
            ECExceptionMonitor.e(th);
            goto L7
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ ECShopRootPresenterV2 a;

        public c(ECShopRootPresenterV2 r1) {
            this.a = r1;
        }

        public final void a() {
            ECShopRootPresenterV2 r0 = this.a;
            int r1 = ECShopRootPresenterV2.C;
            r0.t0(qc3.a.d(r0.u().c(), 2131101859));
            r0.T().getCurrentTabLiveData().a(r0.W(), new q1(r0), false);
            ECShopRootPresenterV2 r2 = this.a;
            ImmersionBar r3 = null;
            if (r2.u == null) goto L5;
        L21:
            ImmersionBar r4 = r2.u;
            if (r4 != null) goto L24;
            return;
        L24:
            if ((!r2.U()) == false) goto L26;
            r3 = r4;
        L26:
            if (r3 == null) goto L34;
            ImmersionBar r5 = r3.statusBarDarkFont(true);
            if (r5 == null) goto L35;
            r5.init();
            return;
        L35:
            return;
        L34:
            return;
        L5:
            if (r2.T().getStoreParam().getOpenByFragment() == true) goto L11;
            Activity r6 = com.bytedance.android.ec.core.utils.l0.b(r2.u().c());
            if (r6 == null) goto L9;
            ImmersionBar r7 = ImmersionBar.with(r6);
        L10:
            r2.u = r7;
            goto L21
        L9:
            r7 = null;
            goto L10
        L11:
            DialogFragment r8 = r2.S();
            if (r8 == null) goto L21;
            Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L15
            Object r10 = Result.constructor-impl(ImmersionBar.with(r8));     // Catch: Throwable -> L15
        L18:
            if (Result.isFailure-impl(r10) == false) goto L20;
            r10 = null;
        L20:
            r2.u = (ImmersionBar) r10;
        L15:
            th = move-exception;
            Result.Companion r11 = Result.Companion;
            r10 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L18
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

    public static final class d<T> implements Observer {
        public final /* synthetic */ ECShopRootPresenterV2 a;

        public d(ECShopRootPresenterV2 r1) {
            this.a = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r14v15 */
        /* JADX WARN: Type inference failed for: r14v16 */
        /* JADX WARN: Type inference failed for: r14v4, types: [android.view.View, android.widget.ImageView, com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView] */
        /* JADX WARN: Type inference failed for: r5v1, types: [com.facebook.drawee.view.GenericDraweeView] */
        public final void onChanged(Object r14) {
            com.bytedance.android.shopping.store.home.entity.n r15 = (com.bytedance.android.shopping.store.home.entity.n) r14;
            ECShopRootPresenterV2 r0 = this.a;
            int r1 = ECShopRootPresenterV2.C;
            r0.getClass();
            com.bytedance.android.shopping.store.home.entity.g r2 = r15.e;
            if (r2 == null) goto L5;
            String r3 = r2.p;
        L7:
            if (r3 != null) goto L9;
        L19:
            boolean r4 = false;
        L20:
            if (r4 == true) goto L58;
            ECShopRootPresenterV2 r5 = this.a;
            r5.getClass();
            ECShopBrandHeaderStyleDto r16 = r15.j;
            if (r16 == null) goto L25;
            ECUrlModel r6 = r16.getTabBackgroundMaskImage();
        L26:
            ECDraweeView r17 = r5.x;
            ?? r18 = r17;
            if (r17 != null) goto L29;
            ECDraweeView r19 = (ECDraweeView) r5.w().b(2131371145).f();
            r5.x = r19;
            r18 = r19;
        L29:
            if (r6 == null) goto L31;
            String r7 = r6.getFirstUrl();
        L32:
            if (r7 != null) goto L34;
        L37:
            boolean r8 = true;
        L39:
            if (r8 == false) goto L41;
            r5.y = false;
            r18.setController(null);
            r18.setVisibility(8);
            View r110 = r5.u0();
            ColorDrawable r9 = new ColorDrawable(r5.s0());
            int r10 = qc3.a.a;
            Intrinsics.checkNotNullParameter(r110, "$this$setBackgroundCompat");
            r110.setBackground(r9);
            return;
        L41:
            r5.y = true;
            View r11 = r5.u0();
            ColorDrawable r12 = new ColorDrawable(r5.s0());
            int r13 = qc3.a.a;
            Intrinsics.checkNotNullParameter(r11, "$this$setBackgroundCompat");
            r11.setBackground(r12);
            float r20 = 0.0f;
            if (Intrinsics.areEqual((Boolean) r5.T().isBrandShop().getValue(), Boolean.TRUE) == true) goto L46;
            if (r5.T().isMiddleTabFramework() == true) goto L46;
        L52:
            com.bytedance.android.ec.core.imagex.h0.d(r18, r6, r5.T().getImageCallerContext(), null, null, null, null, 120);
            r18.setAlpha(1.0f);
            r18.setVisibility(0);
            Float r111 = (Float) r5.T().getUpglideFactor().getValue();
            if (r111 == null) goto L55;
            r20 = r111.floatValue();
        L55:
            r5.v0(r20);
            return;
        L46:
            if (r5.j0() == false) goto L48;
            float r21 = 20.0f;
        L49:
            ViewExtensionsKt.g(r5.u0(), r21, r21, 0.0f, 0.0f);
            GenericDraweeView r22 = r5.x;
            if (r22 == null) goto L52;
            ViewExtensionsKt.g(r22, r21, r21, 0.0f, 0.0f);
            goto L52
        L48:
            r21 = 16.0f;
            goto L49
        L34:
            if (r7.length() == 0) goto L37;
            r8 = false;
            goto L39
        L31:
            r7 = null;
            goto L32
        L25:
            r6 = null;
            goto L26
        L58:
            return;
        L9:
            if (com.bytedance.android.shopping.extensions.k.c(r3) != true) goto L19;
            Context r23 = r0.u().c();
            if ((r23 instanceof Activity) == true) goto L13;
            r23 = null;
        L13:
            Activity r24 = (Activity) r23;
            if (r24 == null) goto L18;
            Window r25 = r24.getWindow();
            if (r25 == null) goto L18;
            View r26 = new View(r0.u().c());
            r26.setBackgroundColor(-1);
            Unit r27 = Unit.INSTANCE;
            r25.addContentView(r26, new ViewGroup.LayoutParams(-1, -1));
        L18:
            com.bytedance.android.ec.sdk.helper.p.a.openSchema(r0.u().c(), r3);
            r0.Q();
            r4 = true;
            goto L20
        L5:
            r3 = null;
            goto L7
        }
    }

    public static final class e<T> implements Observer {
        public final /* synthetic */ ECShopRootPresenterV2 a;

        public e(ECShopRootPresenterV2 r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            Float r4 = (Float) r3;
            ECShopRootPresenterV2 r0 = this.a;
            if (r4 == null) goto L5;
            float r5 = r4.floatValue();
        L6:
            int r1 = ECShopRootPresenterV2.C;
            r0.v0(r5);
            return;
        L5:
            r5 = 0.0f;
            goto L6
        }
    }

    public static final class f<T> implements Observer {
        public final /* synthetic */ ECShopRootPresenterV2 a;

        public f(ECShopRootPresenterV2 r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            if (((Boolean) r2).booleanValue() == false) goto L6;
            ECShopRootPresenterV2 r3 = this.a;
            int r0 = ECShopRootPresenterV2.C;
            com.bytedance.android.ec.core.utils.d2.a(r3.w().b(2131371060).f(), com.bytedance.android.shopping.extensions.b.b(86));
            com.bytedance.android.ec.core.utils.d2.a(this.a.w().b(2131371059).f(), com.bytedance.android.shopping.extensions.b.b(150));
            return;
        }
    }

    public static final class g<T> implements Observer {
        public final /* synthetic */ ECShopRootPresenterV2 a;

        public g(ECShopRootPresenterV2 r1) {
            this.a = r1;
        }

        public final void onChanged(Object r1) {
            Integer r2 = (Integer) r1;
            ECShopRootPresenterV2.q0(this.a);
        }
    }

    public static final class h<T> implements Observer {
        public final /* synthetic */ ECShopRootPresenterV2 a;

        public h(ECShopRootPresenterV2 r1) {
            this.a = r1;
        }

        public final void onChanged(Object r6) {
            Pair r7 = (Pair) r6;
            ECShopRootPresenterV2 r8 = this.a;
            int r0 = ECShopRootPresenterV2.C;
            r8.getClass();
            final ECShopRootPresenterV2 r9 = this.a;
            r9.getClass();
            Lazy r1 = ECTaskManager.b;
            ECTaskManager.a.a().a(r9.T().getStoreParam().getLifecycleMonitorId(), TaskPriority.AFTER_FIRST_SCREEN, new ECShopRootPresenterV2$updateImmersiveBarMode$1(r9));
            if (this.a.p0() == false) goto L10;
            ECUrlModel r10 = this.a.c0();
            if (r10 != null) goto L7;
            return;
        L7:
            if (this.a.T().getBigSalePicFinalColor().getValue() != null) goto L12;
            com.bytedance.android.ec.core.utils.p1 r2 = com.bytedance.android.ec.core.utils.p1.d;
            String r11 = r10.getFirstUrl();
            Function1<Integer, Unit> r3 = new ECShopRootPresenterV2$onBind$8$$special$$inlined$let$lambda$1(this);
            r2.getClass();
            com.bytedance.android.ec.core.utils.p1.f(r11, r3);
            return;
        L12:
            return;
        }
    }

    public static final class i<T> implements Observer {
        public final /* synthetic */ ECShopRootPresenterV2 a;

        public i(ECShopRootPresenterV2 r1) {
            this.a = r1;
        }

        public final void onChanged(Object r5) {
            ECStoreTabAreaVO r6 = (ECStoreTabAreaVO) r5;
            Lazy r7 = ECTaskManager.b;
            ECTaskManager.a.a().a(this.a.T().getStoreParam().getLifecycleMonitorId(), TaskPriority.AFTER_FIRST_SCREEN, new ECShopRootPresenterV2$onBind$9$1(this));
            com.bytedance.android.ec.store.common.bubble.c.c(ECBubbleControllerManager.b.a(this.a.W()), this.a.T().getStoreParam().getLifecycleMonitorId());
        }
    }

    static {
    }

    public ECShopRootPresenterV2() {
        super(null);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
    }

    public final void C() {
        ImmersionBar r0 = this.u;
        if (r0 == null) goto L6;
        r0.destroy();
        return;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public final void onStart() {
        dm.a.b r0 = dm.a.a("product_list_pitaya");
        StringBuilder r1 = new StringBuilder("intervalTime=");
        Lazy r2 = ECStoreSettings.a;
        com.bytedance.android.ec.store.setting.d r3 = (com.bytedance.android.ec.store.setting.d) r2.getValue();
        if (r3 == null) goto L5;
        Long r4 = Long.valueOf(r3.b());
    L6:
        r1.append(r4);
        r0.i(r1.toString());
        com.bytedance.android.ec.store.setting.d r5 = (com.bytedance.android.ec.store.setting.d) r2.getValue();
        if (r5 == null) goto L9;
        long r6 = r5.b();
    L10:
        Disposable r7 = this.B;
        if (r7 != null) goto L13;
    L17:
        this.B = bg4.b.b(com.bytedance.android.ec.core.rxjava.a.a(0, r6, TimeUnit.SECONDS).map(s1.a)).subscribe(t1.a, u1.a);
        return;
    L13:
        if (r7.isDisposed() == true) goto L17;
        Disposable r8 = this.B;
        if (r8 == null) goto L17;
        r8.dispose();
        goto L17
    L9:
        r6 = 10;
        goto L10
    L5:
        r4 = null;
        goto L6
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public final void onStop() {
        Disposable r0 = this.B;
        if (r0 == null) goto L6;
        r0.dispose();
        return;
    }

    public final View u0() {
        View r0 = this.z;
        if (r0 != null) goto L6;
        View r1 = w().b(2131371056).f();
        this.z = r1;
        return r1;
    L6:
        return r0;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        W().getLifecycle().removeObserver(this);
    }

    public final int s0() {
        if (Intrinsics.areEqual((Boolean) T().isBrandShop().getValue(), Boolean.TRUE) == false) goto L5;
    L8:
        return -1;
    L5:
        if (T().isMiddleTabFramework() == true) goto L8;
        return qc3.a.d(u().c(), 2131101856);
    }

    public ECShopRootPresenterV2(Fragment r1) {
        super(r1);
    }

    public static final void q0(ECShopRootPresenterV2 r12) {
        if (r12.A == false) goto L5;
        return;
    L5:
        if (r12.V() == false) goto L71;
        ECStoreTabAreaVO r0 = (ECStoreTabAreaVO) r12.T().getTabArea().getValue();
        if (r0 == null) goto L72;
        List<uj3.j> r1 = r0.b;
        List<uj3.j> r2 = r1;
        if (r2 != null) goto L13;
    L16:
        boolean r3 = true;
    L17:
        HorizontalScrollView r4 = null;
        if ((!r3) == true) goto L21;
        r1 = null;
    L21:
        if (r1 == null) goto L73;
        Fragment r5 = r12.h;
        boolean r6 = r5 instanceof TabKitFragment;
        if (r6 == false) goto L34;
        if (r6 == true) goto L27;
        r5 = null;
    L27:
        TabKitFragment r7 = (TabKitFragment) r5;
        if (r7 == null) goto L35;
        TabKitPresenter r8 = r7.Mc();
        if (r8 == null) goto L35;
        MixTabLayout r9 = r8.i;
        if (r9 == null) goto L35;
        r4 = r9.getNativeTabLayout();
    L35:
        Ref.BooleanRef r10 = new Ref.BooleanRef();
        r10.element = false;
        Iterator<T> r11 = r1.iterator();
        int r13 = 0;
    L37:
        if (r11.hasNext() == false) goto L61;
        Object r14 = r11.next();
        int r15 = r13 + 1;
        if (r13 >= 0) goto L41;
        CollectionsKt.throwIndexOverflow();
    L41:
        uj3.j r16 = (uj3.j) r14;
        String r17 = r16.y;
        if (r10.element == true) goto L59;
        if (r17 != null) goto L45;
    L48:
        boolean r18 = true;
    L49:
        if (r18 == true) goto L59;
        int r19 = r16.d;
        String r20 = ((SharedPrefHelper) r12.g.getValue()).j("ec_store_flag_" + r19 + "_hint_displayed_" + ((String) r12.f.getValue()), "-1");
        if (Intrinsics.areEqual(r20, "-1") == false) goto L53;
    L56:
        boolean r21 = true;
    L57:
        if (r21 == false) goto L59;
        r10.element = true;
        r12.y().post(new r1(r13, r16, r12, r4));
        goto L59
    L53:
        if ((!Intrinsics.areEqual(r20, CommentScene.COMMENTSCENE_NO_AWEME)) == true) goto L56;
        r21 = false;
        goto L57
    L45:
        if (StringsKt.isBlank(r17) == true) goto L48;
        r18 = false;
    L59:
        r13 = r15;
        goto L37
    L61:
        if ((!Intrinsics.areEqual((Boolean) r12.T().getShowDynamicHint().getValue(), Boolean.TRUE)) == false) goto L63;
        r12.T().getShowDynamicHint().c(Boolean.FALSE);
    L63:
        r12.A = true;
        return;
    L34:
        r4 = (HorizontalScrollView) r12.w().b(2131371129).f();
        goto L35
    L73:
        return;
    L13:
        if (r2.isEmpty() == true) goto L16;
        r3 = false;
        goto L17
    L72:
        return;
    }

    public final void A(QModel r8) {
        W().getLifecycle().addObserver(this);
        boolean r9 = U();
        y().post(new c(this));
        View r0 = y();
        ViewGroup r1 = null;
        if (r9 == false) goto L5;
        ColorDrawable r2 = null;
    L6:
        qc3.a.e(r0, r2);
        if (T().getStoreParam().isPreview() == false) goto L9;
        View r3 = w().b(2131371208).f();
        r3.setVisibility(0);
        com.bytedance.android.shopping.store.home.view.y r4 = new com.bytedance.android.shopping.store.home.view.y(u().c(), th.a.g(u().c(), 2131914043));
        Intrinsics.checkNotNullParameter(r3, "$this$setBackgroundCompat");
        r3.setBackground(r4);
    L9:
        int r5 = eh.b.b(u().a());
        T().getMarqueeOffset().a(W(), new p1(w().b(2131371062).f(), r5), false);
        this.v = (FrameLayout) w().b(2131371154).f();
        CoordinatorLayout r6 = w().b(2131371057).f();
        ViewGroup.LayoutParams r7 = r6.getLayoutParams();
        if (r7 != null) goto L12;
    L21:
        r6.requestLayout();
        Unit r10 = Unit.INSTANCE;
        ECStoreViewModel r11 = T();
        ShopContainerType r12 = ShopContainerType.BOTTOM_BAR_CONTAINER;
        View r13 = r11.findContainer(r12);
        if ((r13 instanceof ViewGroup) == true) goto L24;
        r13 = null;
    L24:
        ViewGroup r14 = (ViewGroup) r13;
        if (r14 == null) goto L27;
        r14.setBackgroundColor(qc3.a.d(u().c(), 2131101820));
        r1 = r14;
    L27:
        this.w = r1;
        T().updateContainer(r12, new vi3.c(-1, e0()));
        T().getHeaderArea().a(W(), new d(this), false);
        T().getUpglideFactor().a(W(), new e(this), false);
        T().isBrandShop().a(W(), new f(this), false);
        T().getCroppedState().a(W(), new g(this), false);
        T().getSelectedTabLocation().a(W(), new h(this), false);
        T().getTabArea().a(W(), new i(this), false);
        T().getCurrentTabLiveData().a(W(), new b(this), false);
        if (T().getStoreParam().isSplitMode() == false) goto L31;
        y().findViewById(2131371057).setPadding(0, 0, 0, 0);
        return;
    L31:
        return;
    L12:
        if ((r7 instanceof ViewGroup.MarginLayoutParams) == true) goto L15;
        r7 = null;
    L15:
        if (r7 == null) goto L21;
        ViewGroup.MarginLayoutParams r15 = (ViewGroup.MarginLayoutParams) r7;
        if (r9 == true) goto L19;
        int r16 = e0();
    L20:
        r15.bottomMargin = r16;
        goto L21
    L19:
        r16 = 0;
        goto L20
    L5:
        r2 = new ColorDrawable(qc3.a.d(u().c(), 2131101856));
        goto L6
    }

    public final void t0(int r3) {
        Context r0 = u().c();
        if ((r0 instanceof FragmentActivity) == true) goto L5;
        r0 = null;
    L5:
        FragmentActivity r1 = (FragmentActivity) r0;
        if (r1 == null) goto L11;
        Window r2 = r1.getWindow();
        if (r2 == null) goto L12;
        r2.setNavigationBarColor(r3);
        return;
    L12:
        return;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void v0(float r5) {
        if (this.y == true) goto L5;
        return;
    L5:
        GenericDraweeView r0 = this.x;
        if (r0 != null) goto L8;
        return;
    L8:
        float r6 = RangesKt.coerceIn(1.0f - ((RangesKt.coerceIn(r5, 0.0f, 1.0f) - 0.15f) / 0.70000005f), 0.0f, 1.0f);
        r0.setAlpha(r6);
        if (r6 > 0.01f) goto L11;
        int r7 = 8;
    L12:
        r0.setVisibility(r7);
        return;
    L11:
        r7 = 0;
        goto L12
    }

    public static final void r0(ECShopRootPresenterV2 r5, View r6, uj3.j r7) {
        r5.getClass();
        int r0 = r7.d;
        SharedPrefHelper r1 = (SharedPrefHelper) r5.g.getValue();
        r1.l("ec_store_flag_" + r0 + "_hint_displayed_" + ((String) r5.f.getValue()), CommentScene.COMMENTSCENE_NO_AWEME);
        r1.a();
        r5.T().getShowDynamicHint().c(Boolean.TRUE);
        com.bytedance.android.shopping.store.home.view.p r2 = new com.bytedance.android.shopping.store.home.view.p(r6.getContext(), r5.W());
        FrameLayout r3 = r5.v;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("tipsContainer");
    L5:
        String r4 = r7.y;
        if (r4 != null) goto L8;
        r4 = "";
    L8:
        Long r8 = r7.z;
        if (r8 == null) goto L11;
        long r9 = r8.longValue();
    L12:
        Long r10 = Long.valueOf(r9);
        Intrinsics.checkNotNullParameter(r6, "anchor");
        Intrinsics.checkNotNullParameter(r3, "container");
        Intrinsics.checkNotNullParameter(r4, "content");
        r2.g = r6;
        r2.h = r3;
        r2.i = r4;
        r2.j = r10;
        ECBubbleControllerManager.b.a(r5.W()).a(com.bytedance.android.ec.store.common.bubble.a.c, r2);
        return;
    L11:
        r9 = 3000;
        goto L12
    }
}
