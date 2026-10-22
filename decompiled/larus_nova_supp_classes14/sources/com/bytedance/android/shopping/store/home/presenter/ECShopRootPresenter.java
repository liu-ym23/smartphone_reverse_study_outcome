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
import com.bytedance.android.ec.common.api.usertracker.PostActionType;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.store.common.bubble.ECBubbleControllerManager;
import com.bytedance.android.ec.store.setting.ECStoreSettings;
import com.bytedance.android.ec.store.utils.taskmanager.ECTaskManager;
import com.bytedance.android.ec.store.utils.taskmanager.TaskPriority;
import com.bytedance.android.shopping.store.home.entity.ECStoreTabAreaVO;
import com.bytedance.android.shopping.store.tabkit.TabKitFragment;
import com.bytedance.android.shopping.store.tabkit.TabKitPresenter;
import com.bytedance.android.shopping.store.tabkit.view.MixTabLayout;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import com.bytedance.ies.utility.SharedPrefHelper;
import com.gyf.barlibrary.ImmersionBar;
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
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\bJ\b\u0010\u0004\u001a\u00020\u0003H\u0007J\b\u0010\u0005\u001a\u00020\u0003H\u0007J\b\u0010\u0006\u001a\u00020\u0003H\u0007J\b\u0010\u0007\u001a\u00020\u0003H\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/android/shopping/store/home/presenter/ECShopRootPresenter;", "Lcom/bytedance/android/shopping/store/home/presenter/ECShopBasePresenter;", "Landroidx/lifecycle/LifecycleObserver;", "", "onResume", "onStart", "onStop", "onDestroy", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECShopRootPresenter extends ECShopBasePresenter implements LifecycleObserver {
    public static final /* synthetic */ int z = 0;
    public ImmersionBar u;
    public FrameLayout v;
    public ViewGroup w;
    public boolean x;
    public Disposable y;

    public static final class a {
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ ECShopRootPresenter a;

        public b(ECShopRootPresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r6) {
            ECShopRootPresenter r0 = this.a;
            int r1 = ECShopRootPresenter.z;
            r0.getClass();
            com.bytedance.android.shopping.store.home.entity.g r7 = ((com.bytedance.android.shopping.store.home.entity.n) r6).e;
            Context r2 = null;
            if (r7 == null) goto L5;
            String r8 = r7.p;
        L6:
            if (r8 != null) goto L8;
            return;
        L8:
            if (com.bytedance.android.shopping.extensions.k.c(r8) != true) goto L21;
            Context r3 = r0.u().c();
            if ((r3 instanceof Activity) == false) goto L13;
            r2 = r3;
        L13:
            Activity r4 = (Activity) r2;
            if (r4 == null) goto L18;
            Window r5 = r4.getWindow();
            if (r5 == null) goto L18;
            View r9 = new View(r0.u().c());
            r9.setBackgroundColor(-1);
            Unit r10 = Unit.INSTANCE;
            r5.addContentView(r9, new ViewGroup.LayoutParams(-1, -1));
        L18:
            com.bytedance.android.ec.sdk.helper.p.a.openSchema(r0.u().c(), r8);
            r0.Q();
            return;
        L21:
            return;
        L5:
            r8 = null;
            goto L6
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ ECShopRootPresenter a;

        public c(ECShopRootPresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            Boolean r4 = (Boolean) r3;
            boolean r5 = gm.a.a;
            ECShopRootPresenter r6 = this.a;
            int r0 = ECShopRootPresenter.z;
            gm.a.a(r6.u().c(), true, this.a.S());
            gm.a.b("shop_visit_shops_today", PostActionType.DO);
            gm.a.b("shop_visit_seconds", PostActionType.START_DURATION);
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ ECShopRootPresenter a;

        public d(ECShopRootPresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r1) {
            Integer r2 = (Integer) r1;
            ECShopRootPresenter.q0(this.a);
        }
    }

    public static final class e<T> implements Observer {
        public final /* synthetic */ ECShopRootPresenter a;

        public e(ECShopRootPresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r6) {
            Pair r7 = (Pair) r6;
            if (this.a.T().getLastSelectedTabLocation() == null) goto L5;
            boolean r8 = gm.a.a;
            gm.a.b("shop_click_tab", PostActionType.DO);
        L5:
            this.a.getClass();
            final ECShopRootPresenter r9 = this.a;
            r9.getClass();
            Lazy r0 = ECTaskManager.b;
            ECTaskManager.a.a().a(r9.T().getStoreParam().getLifecycleMonitorId(), TaskPriority.AFTER_FIRST_SCREEN, new ECShopRootPresenter$updateImmersiveBarMode$1(r9));
            if (this.a.p0() == false) goto L13;
            ECUrlModel r10 = this.a.c0();
            if (r10 != null) goto L10;
            return;
        L10:
            if (this.a.T().getBigSalePicFinalColor().getValue() != null) goto L15;
            com.bytedance.android.ec.core.utils.p1 r1 = com.bytedance.android.ec.core.utils.p1.d;
            String r11 = r10.getFirstUrl();
            Function1<Integer, Unit> r2 = new ECShopRootPresenter$onBind$6$$special$$inlined$let$lambda$1(this);
            r1.getClass();
            com.bytedance.android.ec.core.utils.p1.f(r11, r2);
            return;
        L15:
            return;
        }
    }

    public static final class f<T> implements Observer {
        public final /* synthetic */ ECShopRootPresenter a;

        public f(ECShopRootPresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r5) {
            ECStoreTabAreaVO r6 = (ECStoreTabAreaVO) r5;
            Lazy r7 = ECTaskManager.b;
            ECTaskManager.a.a().a(this.a.T().getStoreParam().getLifecycleMonitorId(), TaskPriority.AFTER_FIRST_SCREEN, new ECShopRootPresenter$onBind$7$1(this));
            com.bytedance.android.ec.store.common.bubble.c.c(ECBubbleControllerManager.b.a(this.a.W()), this.a.T().getStoreParam().getLifecycleMonitorId());
        }
    }

    static {
    }

    public ECShopRootPresenter() {
        super(null);
    }

    public final void C() {
        ImmersionBar r0 = this.u;
        if (r0 == null) goto L5;
        r0.destroy();
    L5:
        boolean r1 = gm.a.a;
        gm.a.b("shop_visit_seconds", PostActionType.END_DURATION);
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
        Disposable r7 = this.y;
        if (r7 != null) goto L13;
    L17:
        this.y = bg4.b.b(com.bytedance.android.ec.core.rxjava.a.a(0, r6, TimeUnit.SECONDS).map(m1.a)).subscribe(n1.a, o1.a);
        return;
    L13:
        if (r7.isDisposed() == true) goto L17;
        Disposable r8 = this.y;
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
        Disposable r0 = this.y;
        if (r0 == null) goto L6;
        r0.dispose();
        return;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        W().getLifecycle().removeObserver(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        if (G() == true) goto L7;
        if (I() == true) goto L7;
        return;
    L7:
        if (U() == true) goto L11;
        T().setEnterLiveRoom(false);
        return;
    }

    public static final void q0(ECShopRootPresenter r12) {
        if (r12.x == false) goto L5;
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
        r12.y().post(new l1(r13, r16, r12, r4));
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
        r12.x = true;
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
        s0(qc3.a.d(u().c(), 2131101859));
        T().getCurrentTabLiveData().a(W(), new k1(this), false);
        View r0 = y();
        ViewGroup.LayoutParams r1 = null;
        if (r9 == false) goto L5;
        ColorDrawable r2 = null;
    L6:
        qc3.a.e(r0, r2);
        if (T().isKolShop() == true) goto L41;
        if (T().isWhiteBrand() == true) goto L41;
        if (this.u == null) goto L14;
    L30:
        ImmersionBar r3 = this.u;
        if (r3 == null) goto L41;
        if ((!U()) == true) goto L36;
        r3 = null;
    L36:
        if (r3 == null) goto L41;
        ImmersionBar r4 = r3.statusBarDarkFont(true);
        if (r4 == null) goto L41;
        r4.init();
        goto L41
    L14:
        if (T().getStoreParam().getOpenByFragment() == true) goto L20;
        Activity r5 = com.bytedance.android.ec.core.utils.l0.b(u().c());
        if (r5 == null) goto L18;
        ImmersionBar r6 = ImmersionBar.with(r5);
    L19:
        this.u = r6;
        goto L30
    L18:
        r6 = null;
        goto L19
    L20:
        DialogFragment r7 = S();
        if (r7 == null) goto L30;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L24
        Object r11 = Result.constructor-impl(ImmersionBar.with(r7));     // Catch: Throwable -> L24
    L27:
        if (Result.isFailure-impl(r11) == false) goto L29;
        r11 = null;
    L29:
        this.u = (ImmersionBar) r11;
    L24:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
    L41:
        if (T().getStoreParam().isPreview() == false) goto L43;
        View r13 = w().b(2131371208).f();
        r13.setVisibility(0);
        com.bytedance.android.shopping.store.home.view.y r14 = new com.bytedance.android.shopping.store.home.view.y(u().c(), th.a.g(u().c(), 2131914043));
        int r15 = qc3.a.a;
        Intrinsics.checkNotNullParameter(r13, "$this$setBackgroundCompat");
        r13.setBackground(r14);
    L43:
        int r16 = eh.b.b(u().a());
        T().getMarqueeOffset().a(W(), new j1(w().b(2131371062).f(), r16), false);
        this.v = (FrameLayout) w().b(2131371154).f();
        CoordinatorLayout r17 = w().b(2131371057).f();
        ViewGroup.LayoutParams r18 = r17.getLayoutParams();
        if (r18 != null) goto L46;
    L54:
        r17.requestLayout();
        Unit r19 = Unit.INSTANCE;
        ViewGroup r20 = (ViewGroup) w().b(2131371128).f();
        ViewGroup.LayoutParams r21 = r20.getLayoutParams();
        r21.height = e0();
        r20.setLayoutParams(r21);
        r20.setBackgroundColor(qc3.a.d(u().c(), 2131101820));
        this.w = r20;
        T().getHeaderArea().a(W(), new b(this), false);
        T().isLiveOn().a(W(), new c(this), false);
        T().getCroppedState().a(W(), new d(this), false);
        T().getSelectedTabLocation().a(W(), new e(this), false);
        T().getTabArea().a(W(), new f(this), false);
        return;
    L46:
        if ((r18 instanceof ViewGroup.MarginLayoutParams) == false) goto L48;
        r1 = r18;
    L48:
        if (r1 == null) goto L54;
        ViewGroup.MarginLayoutParams r22 = (ViewGroup.MarginLayoutParams) r1;
        if (r9 == true) goto L52;
        int r23 = e0();
    L53:
        r22.bottomMargin = r23;
        goto L54
    L52:
        r23 = 0;
        goto L53
    L5:
        r2 = new ColorDrawable(qc3.a.d(u().c(), 2131101856));
        goto L6
    }

    public final void s0(int r3) {
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

    public static final void r0(ECShopRootPresenter r5, View r6, uj3.j r7) {
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
