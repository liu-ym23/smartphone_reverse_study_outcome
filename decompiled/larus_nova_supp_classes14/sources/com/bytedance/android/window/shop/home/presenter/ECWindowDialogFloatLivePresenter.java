package com.bytedance.android.window.shop.home.presenter;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.window.base.common.headlive.WindowV3LiveRoomVO;
import com.bytedance.android.ec.window.base.shopping.floatlive.FloatScene;
import com.bytedance.android.window.shop.home.ECWindowDialogFragment;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\tB\u0007¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0004\u001a\u00020\u0003H\u0007J\b\u0010\u0005\u001a\u00020\u0003H\u0007J\b\u0010\u0006\u001a\u00020\u0003H\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/android/window/shop/home/presenter/ECWindowDialogFloatLivePresenter;", "Lcom/bytedance/android/window/shop/home/presenter/AbsECWindowPresenter;", "Landroidx/lifecycle/LifecycleObserver;", "", "onResume", "onStop", "onDestroy", "<init>", "()V", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECWindowDialogFloatLivePresenter extends AbsECWindowPresenter implements LifecycleObserver {
    public static final /* synthetic */ int o = 0;
    public Float m;
    public final Lazy n;

    public static final class a {
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ ECWindowDialogFloatLivePresenter a;

        public b(ECWindowDialogFloatLivePresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r4) {
            Float r5 = (Float) r4;
            if ((!Intrinsics.areEqual(r5, this.a.m)) == true) goto L5;
        L8:
            this.a.m = r5;
            return;
        L5:
            if (r5.floatValue() <= 0.75f) goto L7;
            yn.d.i(this.a.O().getLiveManager(), false, 3);
            goto L8
        L7:
            yn.d r0 = this.a.O().getLiveManager();
            int r1 = yn.d.q;
            r0.b(false);
            goto L8
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ ECWindowDialogFloatLivePresenter a;

        public c(ECWindowDialogFloatLivePresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r19) {
            Boolean r0 = (Boolean) r19;
            ECWindowDialogFloatLivePresenter r1 = this.a;
            int r2 = ECWindowDialogFloatLivePresenter.o;
            yn.d r3 = r1.O().getLiveManager();
            FloatScene r4 = FloatScene.WINDOW;
            WindowV3LiveRoomVO r6 = (WindowV3LiveRoomVO) r1.O().getLiveInfo().getValue();
            boolean r7 = r1.O().getShopParam().getLiveDefaultMute();
            Context r9 = r1.u().c();
            Fragment r10 = ECQuickUtilKt.b(r1.u(), ECWindowDialogFragment.class);
            View r8 = r1.X();
            if ((r8 instanceof FrameLayout) == true) goto L5;
            r8 = null;
        L5:
            yn.d.d(r3, r4, true, r6, r7, new yn.m(r9, r10, (FrameLayout) r8, (WindowV3LiveRoomVO) r1.O().getLiveInfo().getValue(), r1.O().getPassThroughLogData(), "1004", r1.O().getShopParam().getSearchParams(), ((Number) r1.n.getValue()).intValue(), r1.O().getShopParam().getAuthorId()), false, null, 224);
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ ECWindowDialogFloatLivePresenter a;

        public d(ECWindowDialogFloatLivePresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r4) {
            Integer r5 = (Integer) r4;
            ECWindowDialogFloatLivePresenter r6 = this.a;
            int r0 = ECWindowDialogFloatLivePresenter.o;
            r6.Z(false);
            if (this.a.T() == false) goto L6;
            int r7 = com.bytedance.android.ec.window.base.utils.i.a;
            com.bytedance.android.ec.window.base.utils.i.d(this.a.O().getEntranceInfoJsonObject(), "shop_window_ad", "click_expansion", 8);
            return;
        }
    }

    static {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        int r0 = ECSdk.a;
        IAdapterService r1 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r1 == null) goto L6;
        r1.cancelMuteLiveRoom();
        return;
    }

    public ECWindowDialogFloatLivePresenter() {
        this.n = LazyKt.lazy(new ECWindowDialogFloatLivePresenter$floatLiveBottomMargin$2(this));
    }

    public final void C() {
        yn.d r0 = O().getLiveManager();
        int r1 = yn.d.q;
        r0.b(false);
        U().getLifecycle().removeObserver(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        if (T() == false) goto L8;
        yn.d r0 = O().getLiveManager();
        if (r0.e() == false) goto L7;
        yn.d.i(r0, true, 2);
    L9:
        Z(true);
        return;
    L7:
        r0.b(true);
        goto L9
    L8:
        O().getLiveManager().b(true);
        goto L9
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public final void onStop() {
        if (T() == false) goto L5;
        return;
    L5:
        if (Q() == true) goto L9;
        yn.d r0 = O().getLiveManager();
        int r1 = yn.d.q;
        r0.g(false);
        return;
    }

    public final void A(QModel r4) {
        O().getCollapseProgress().observe(U(), new b(this));
        O().isLiveOn().a(U(), new c(this), false);
        O().getCroppedState().observe(U(), new d(this));
        U().getLifecycle().addObserver(this);
    }

    public final void Z(boolean r3) {
        boolean r0 = T();
        if (r0 == false) goto L5;
        O().getLiveManager().g(r3);
    L5:
        if (r0 == true) goto L8;
        O().getLiveManager().a();
        return;
    }
}
