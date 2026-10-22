package com.bytedance.android.shopping.store.home.presenter;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.store.utils.taskmanager.ECTaskManager;
import com.bytedance.android.ec.store.utils.taskmanager.TaskPriority;
import com.bytedance.android.shopping.store.home.event.ChangeStateType;
import com.bytedance.android.shopping.store.home.frame.container.ShopContainerType;
import com.bytedance.android.shopping.store.home.view.ECStoreHeaderFrameLayout;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import com.bytedance.android.shopping.store.viewmodel.ShopStatus;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\tJ\b\u0010\u0004\u001a\u00020\u0003H\u0007J\b\u0010\u0005\u001a\u00020\u0003H\u0007J\b\u0010\u0006\u001a\u00020\u0003H\u0007J\b\u0010\u0007\u001a\u00020\u0003H\u0007J\b\u0010\b\u001a\u00020\u0003H\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/store/home/presenter/ECShopAutoCollapsePresenter;", "Lcom/bytedance/android/shopping/store/home/presenter/ECShopBasePresenter;", "Landroidx/lifecycle/LifecycleObserver;", "", "onCreate", "onResume", "onPause", "onStop", "onDestroy", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECShopAutoCollapsePresenter extends ECShopBasePresenter implements LifecycleObserver {
    public static final /* synthetic */ int C = 0;
    public final b A;
    public boolean B;
    public Disposable u;
    public boolean v;
    public ShopStatus w;
    public final Set<String> x;
    public final Lazy y;
    public final c z;

    public static final class a {
    }

    public static final class b implements ti.j {
        public final /* synthetic */ ECShopAutoCollapsePresenter a;

        public b(ECShopAutoCollapsePresenter r1) {
            this.a = r1;
        }

        public final void a(JSONObject r4) {
            Intrinsics.checkNotNullParameter(r4, "params");
            dm.a.b r0 = dm.a.a;
            int r1 = ECShopAutoCollapsePresenter.C;
            dm.a.a("ECShopAutoCollapsePresenter").i("lynxDialogCloseEventListener, onReceiveJsEvent() called with: params = " + r4);
            ECShopAutoCollapsePresenter.q0(this.a, r4.optString("dialog_name"), false);
        }
    }

    public static final class c implements ti.j {
        public final /* synthetic */ ECShopAutoCollapsePresenter a;

        public c(ECShopAutoCollapsePresenter r1) {
            this.a = r1;
        }

        public final void a(JSONObject r4) {
            Intrinsics.checkNotNullParameter(r4, "params");
            dm.a.b r0 = dm.a.a;
            int r1 = ECShopAutoCollapsePresenter.C;
            dm.a.a("ECShopAutoCollapsePresenter").i("lynxDialogShowEventListener, onReceiveJsEvent() called with: params = " + r4);
            ECShopAutoCollapsePresenter.q0(this.a, r4.optString("dialog_name"), true);
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ ECShopAutoCollapsePresenter a;

        public d(ECShopAutoCollapsePresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            Boolean r3 = (Boolean) r2;
            this.a.B = true;
        }
    }

    public static final class e<T> implements Observer {
        public final /* synthetic */ ECShopAutoCollapsePresenter a;

        public e(ECShopAutoCollapsePresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            uj3.j r4 = (uj3.j) r3;
            ECShopAutoCollapsePresenter r5 = this.a;
            r5.B = false;
            r5.t0(((com.bytedance.android.ec.store.setting.e) r5.y.getValue()).c());
        }
    }

    public static final class f<T> implements Observer {
        public final /* synthetic */ ECShopAutoCollapsePresenter a;

        public f(ECShopAutoCollapsePresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r9) {
            ShopStatus r10 = (ShopStatus) r9;
            if (r10 != ShopStatus.PREVIEW_COLLAPSE) goto L19;
            ECShopAutoCollapsePresenter r0 = this.a;
            if (r0.w == r10) goto L19;
            if (r0.T().getSlideByAuto() == true) goto L9;
            int r1 = ECShopAutoCollapsePresenter.C;
        L17:
            String r2 = "hand";
        L18:
            this.a.T().doAnyEventActionWithBtm("a1.b6269.c0.d0", PageFinder.via(this.a.y()), "store_head_live_fade", null, new Pair[]{TuplesKt.to("fade_type", r2)});
            goto L19
        L9:
            ui3.c r3 = (ui3.c) this.a.T().getChangeStateEvent().getValue();
            if (r3 == null) goto L12;
            ChangeStateType r4 = r3.b;
        L14:
            if (r4 != ChangeStateType.AUTO) goto L16;
            int r5 = ECShopAutoCollapsePresenter.C;
            r2 = "auto";
            goto L18
        L16:
            int r6 = ECShopAutoCollapsePresenter.C;
            goto L17
        L12:
            r4 = null;
        L19:
            this.a.w = r10;
        }
    }

    public static final class g<T> implements Observer {
        public final /* synthetic */ ECShopAutoCollapsePresenter a;

        public g(ECShopAutoCollapsePresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r9) {
            if (((Float) r9).floatValue() >= 1.0f) goto L5;
            return;
        L5:
            if (this.a.T().getUpglideFactorChangeByUser() == false) goto L7;
            int r10 = ECShopAutoCollapsePresenter.C;
            String r11 = "hand";
        L8:
            ECStoreViewModel r1 = this.a.T();
            PageFinder r3 = PageFinder.via(this.a.y());
            Pair<String, ? extends Object>[] r6 = new Pair[2];
            uj3.j r0 = this.a.T().getCurrentTab();
            if (r0 == null) goto L11;
            String r2 = r0.b();
        L12:
            r6[0] = TuplesKt.to("tab_name", r2);
            r6[1] = TuplesKt.to("fade_type", r11);
            r1.doAnyEventActionWithBtm("a1.b6269.c0.d0", r3, "store_head_info_fade", null, r6);
            return;
        L11:
            r2 = null;
            goto L12
        L7:
            int r12 = ECShopAutoCollapsePresenter.C;
            r11 = "auto";
            goto L8
        }
    }

    static {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public final void onCreate() {
    }

    public final void C() {
        ECLiveHybridUtil.p("ecom_shop_lynx_dialog_show", this.z);
        ECLiveHybridUtil.p("ecom_shop_lynx_dialog_close", this.A);
        s0();
        k0().removeObserver(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        ECLiveHybridUtil.p("ecom_shop_lynx_dialog_show", this.z);
        ECLiveHybridUtil.p("ecom_shop_lynx_dialog_close", this.A);
    }

    public final void r0() {
        boolean r1 = true;
        if ((!this.x.isEmpty()) == false) goto L5;
        return;
    L5:
        dm.a.b r0 = dm.a.a("ECShopAutoCollapsePresenter");
        StringBuilder r2 = new StringBuilder("collapseHeaderIfNeed: changeStatus:");
        ui3.c r3 = (ui3.c) T().getChangeStateEvent().getValue();
        if (r3 == null) goto L8;
        ShopStatus r4 = r3.c;
    L9:
        r2.append(r4);
        r2.append(", currentStatus:");
        r2.append((ShopStatus) T().getShopStatus().getValue());
        r2.append(",upglide=");
        r2.append((Float) T().getUpglideFactor().getValue());
        r0.a(r2.toString());
        if (((ShopStatus) T().getShopStatus().getValue()) != ShopStatus.PREVIEW_EXPANDED) goto L12;
        T().onImmediateCollapseChangeStateUpdate(new ui3.c(3, ChangeStateType.AUTO, ShopStatus.PREVIEW_COLLAPSE));
        boolean r5 = true;
    L14:
        if (com.bytedance.android.shopping.extensions.k.d((Float) T().getUpglideFactor().getValue()) >= 1) goto L16;
        T().onImmediateCollapseHeaderStateUpdate(new ui3.e(1, ChangeStateType.AUTO));
    L17:
        if (r1 == false) goto L20;
        T().onLynxEvent("ecom.shop_info_area.close_prompt_bubble", null);
        return;
    L20:
        return;
    L16:
        r1 = r5;
        goto L17
    L12:
        r5 = false;
        goto L14
    L8:
        r4 = null;
        goto L9
    }

    public final void s0() {
        Disposable r0 = this.u;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isDisposed() == true) goto L12;
        Disposable r1 = this.u;
        if (r1 == null) goto L9;
        r1.dispose();
    L9:
        this.u = null;
        return;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        T().setEnterOtherPageCollaspeHeader(false);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public final void onStop() {
        uj3.j r0 = T().getCurrentTab();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.i() == true) goto L7;
        return;
    L7:
        if (T().getEnterOtherPageCollaspeHeader() == false) goto L12;
        r0();
        return;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void onPause() {
        s0();
    }

    public ECShopAutoCollapsePresenter(Fragment r1) {
        super(r1);
        this.w = ShopStatus.NORMAL;
        this.x = new LinkedHashSet();
        this.y = LazyKt.lazy(ECShopAutoCollapsePresenter$animationConfig$2.INSTANCE);
        this.z = new c(this);
        this.A = new b(this);
    }

    public final void A(QModel r6) {
        k0().addObserver(this);
        ECLiveHybridUtil.n("ecom_shop_lynx_dialog_show", this.z);
        ECLiveHybridUtil.n("ecom_shop_lynx_dialog_close", this.A);
        View r7 = T().findContainer(ShopContainerType.LIVE_PREVIEW_CONTAINER);
        if (r7 == null) goto L5;
        r7.setOnTouchListener(new h(this));
    L5:
        ECStoreViewModel r8 = T();
        ShopContainerType r0 = ShopContainerType.SHOP_INFO_CONTAINER;
        View r9 = r8.findContainer(r0);
        if (r9 == null) goto L8;
        r9.setOnTouchListener(new i(this));
    L8:
        View r10 = T().findContainer(r0);
        if ((r10 instanceof ECStoreHeaderFrameLayout) == true) goto L11;
        r10 = null;
    L11:
        ECStoreHeaderFrameLayout r11 = (ECStoreHeaderFrameLayout) r10;
        if (r11 == null) goto L14;
        r11.setOnClickContentListener(new j(this));
    L14:
        T().getSlideOrTouchByUserEvent().a(W(), new d(this), false);
        Lazy r12 = ECTaskManager.b;
        ECTaskManager.a.a().a(T().getStoreParam().getLifecycleMonitorId(), TaskPriority.AFTER_FIRST_SCREEN, new ECShopAutoCollapsePresenter$onBind$2(this));
        T().getCurrentTabLiveData().a(W(), new e(this), false);
        T().getShopStatus().a(W(), new f(this), false);
        T().getUpglideFactor().a(W(), new g(this), false);
    }

    public final void t0(long r3) {
        if (this.v == true) goto L5;
        return;
    L5:
        if ((!this.x.isEmpty()) == true) goto L17;
        uj3.j r0 = T().getCurrentTab();
        if (r0 == null) goto L12;
        if (r0.i() != true) goto L12;
    L13:
        s0();
        this.u = bg4.b.b(Observable.timer(r3, TimeUnit.MILLISECONDS)).subscribe(new com.bytedance.android.shopping.store.home.presenter.f(this), com.bytedance.android.shopping.store.home.presenter.g.a);
        return;
    L12:
        if (com.bytedance.android.shopping.store.settings.a.a() == true) goto L13;
        return;
    }

    public static final void q0(ECShopAutoCollapsePresenter r3, String r4, boolean r5) {
        if (r5 == false) goto L4;
        r3.x.add(r4);
        r3.s0();
    L5:
        dm.a.a("ECShopAutoCollapsePresenter").a("handleLynxDialogVisibilityChange dialogName=" + r4 + " isShow=" + r5 + " activeDialogs=" + r3.x);
        return;
    L4:
        r3.x.remove(r4);
        r3.t0(((com.bytedance.android.ec.store.setting.e) r3.y.getValue()).b());
        goto L5
    }
}
