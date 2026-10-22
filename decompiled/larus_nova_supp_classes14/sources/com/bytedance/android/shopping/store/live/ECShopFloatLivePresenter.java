package com.bytedance.android.shopping.store.live;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.adapter.api.j;
import com.bytedance.android.ec.adapter.api.player.IECLivePlayerClient;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.core.utils.l0;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.store.common.const.LiveStyles;
import com.bytedance.android.ec.store.common.headlive.StoreV3LiveRoomVO;
import com.bytedance.android.ec.store.shopping.floatlive.FloatScene;
import com.bytedance.android.livesdk.ec.adapter.api.FloatWindowState;
import com.bytedance.android.livesdk.ec.adapter.api.LiveVolume;
import com.bytedance.android.livesdk.ec.adapter.api.Scene;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.store.home.entity.n;
import com.bytedance.android.shopping.store.home.presenter.ECShopBasePresenter;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import im.o;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import s83.f;
import s83.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0003H\u0007J\b\u0010\u0005\u001a\u00020\u0003H\u0007J\b\u0010\u0006\u001a\u00020\u0003H\u0007¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/shopping/store/live/ECShopFloatLivePresenter;", "Lcom/bytedance/android/shopping/store/home/presenter/ECShopBasePresenter;", "Landroidx/lifecycle/LifecycleObserver;", "", "onResume", "onPause", "onDestroy", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECShopFloatLivePresenter extends ECShopBasePresenter implements LifecycleObserver {
    public boolean u;

    public static final class a<T> implements Observer {
        public final /* synthetic */ ECShopFloatLivePresenter a;
        public final /* synthetic */ Ref.BooleanRef b;

        public a(ECShopFloatLivePresenter r1, Ref.BooleanRef r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onChanged(Object r18) {
            StoreV3LiveRoomVO r10 = (StoreV3LiveRoomVO) r18;
            im.b r11 = this.a.T().getLiveManager();
            FloatScene r12 = FloatScene.SHOP;
            boolean r13 = this.a.T().isCroppedStyle();
            boolean r14 = this.b.element;
            Context r2 = this.a.u().c();
            DialogFragment r3 = this.a.S();
            View r1 = this.a.o0();
            wu1.a r16 = null;
            if ((r1 instanceof FrameLayout) == true) goto L5;
            r1 = null;
        L5:
            im.b.c(r11, r12, r13, r10, r14, new o(r2, r3, (FrameLayout) r1, r10, this.a.T().getPassThroughLogData(), this.a.T().getStoreParam().getSearchParams(), th.a.e(this.a.u().c(), true).getResources().getDimensionPixelSize(2131166433), this.a.T().getStoreParam().getShopId()), true, this.a.T().getStoreParam().getStoreUIParam().getCanShowFloatLive(), 128);
            int r4 = ECSdk.a;
            IAdapterService r5 = (IAdapterService) ECSdk.a(IAdapterService.class);
            if (r5 == null) goto L8;
            r16 = r5.getECLiveStateController();
        L8:
            wu1.a r6 = r16;
            if (r10 == null) goto L11;
            r10.getRoomId();
        L11:
            if (r6 == null) goto L14;
            FloatWindowState r7 = FloatWindowState.OPEN;
            Scene r8 = Scene.LIVE;
            r6.b(r7);
            return;
        }
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ ECShopFloatLivePresenter a;

        public b(ECShopFloatLivePresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r6) {
            Float r7 = (Float) r6;
            Integer r0 = this.a.T().getLiveStyle();
            int r1 = LiveStyles.LIVE_ICON_AND_FLOATWINDOW.getType();
            if (r0 != null) goto L6;
        L17:
            Integer r2 = this.a.T().getLiveStyle();
            int r3 = LiveStyles.LIVE_MODULE_AND_FLOATWINDOW.getType();
            if (r2 != null) goto L21;
            return;
        L21:
            if (r2.intValue() == r3) goto L23;
            return;
        L23:
            if (r7.floatValue() <= 0.95f) goto L28;
            if (this.a.T().getLiveManager().d() == true) goto L32;
            im.b.i(this.a.T().getLiveManager(), false, false, 3);
            return;
        L32:
            return;
        L28:
            if (this.a.T().getLiveManager().d() == false) goto L34;
            this.a.o0().post(new com.bytedance.android.shopping.store.live.b(this));
            return;
        L34:
            return;
        L6:
            if (r0.intValue() != r1) goto L17;
            if (r7.floatValue() >= 0.05f) goto L13;
            if (this.a.T().getLiveManager().d() == true) goto L17;
            im.b.i(this.a.T().getLiveManager(), false, false, 3);
            goto L17
        L13:
            if (r7.floatValue() <= 0.95f) goto L17;
            if (this.a.T().getLiveManager().d() == false) goto L17;
            this.a.o0().post(new com.bytedance.android.shopping.store.live.a(this));
            goto L17
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ ECShopFloatLivePresenter a;

        public c(ECShopFloatLivePresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            n r4 = (n) r3;
            if (k.d((Float) this.a.T().getUpglideFactor().getValue()) >= 0.05f) goto L10;
            Integer r5 = this.a.T().getLiveStyle();
            int r1 = LiveStyles.LIVE_ICON_AND_FLOATWINDOW.getType();
            if (r5 == null) goto L10;
            if (r5.intValue() != r1) goto L10;
            this.a.T().getLiveManager().j();
        L10:
            Integer r6 = this.a.T().getLiveStyle();
            int r2 = LiveStyles.LIVE_MODULE_AND_FLOATWINDOW.getType();
            if (r6 != null) goto L14;
            return;
        L14:
            if (r6.intValue() == r2) goto L16;
            return;
        L16:
            if (k.d((Float) this.a.T().getUpglideFactor().getValue()) >= 0.05f) goto L20;
            im.b r7 = this.a.T().getLiveManager();
            int r0 = im.b.q;
            r7.a(false);
            return;
        }
    }

    public ECShopFloatLivePresenter() {
        super(null);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void onPause() {
        boolean r0 = ECServiceManager.a;
        f r1 = ((g) ECServiceManager.c(g.class)).p();
        if (r1 == null) goto L6;
        r1.k();
    L6:
        if (Intrinsics.areEqual((Boolean) T().isBrandShop().getValue(), Boolean.TRUE) == true) goto L19;
        im.b r2 = T().getLiveManager();
        if (r2.d() == false) goto L10;
        boolean r3 = r2.j;
    L11:
        int r4 = ECSdk.a;
        IAdapterService r5 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r5 == null) goto L19;
        wu1.a r6 = r5.getECLiveStateController();
        if (r6 == null) goto L19;
        if (r3 == false) goto L17;
        LiveVolume r7 = LiveVolume.MUTE;
    L18:
        Scene r8 = Scene.LIVE;
        r6.d(r7);
        goto L19
    L17:
        r7 = LiveVolume.UNMUTE;
        goto L18
    L10:
        r3 = r2.e();
    L19:
        im.b r9 = T().getLiveManager();
        int r10 = im.b.q;
        r9.a(false);
        this.u = true;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        im.k.a();
        k0().removeObserver(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        im.b r0 = T().getLiveManager();
        if (r0.l == false) goto L6;
        r0.l = false;
        r0.a(false);
    L6:
        if (this.u == false) goto L31;
        im.b r1 = T().getLiveManager();
        r1.getClass();
        int r2 = ECSdk.a;
        IAdapterService r3 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r3 == null) goto L30;
        wu1.a r4 = r3.getECLiveStateController();
        if (r4 == null) goto L30;
        r4.a(Scene.SHOP);
        FloatWindowState r5 = (FloatWindowState) r4.c().getFirst();
        if (r5 == null) goto L22;
        int r6 = im.c.a[r5.ordinal()];
        if (r6 == 1) goto L20;
        if (r6 != 2) goto L22;
        r1.a(true);
        goto L22
    L20:
        im.b.i(r1, true, false, 2);
    L22:
        if (r1.d() == true) goto L30;
        if (r1.e() == false) goto L26;
        r1.g();
        goto L30
    L26:
        IECLivePlayerClient r7 = r1.c;
        if (r7 == null) goto L29;
        r7.unmute();
    L29:
        r1.m.g(Boolean.FALSE);
    L30:
        this.u = false;
    L31:
        boolean r8 = ECServiceManager.a;
        f r9 = ((g) ECServiceManager.c(g.class)).p();
        if (r9 == null) goto L35;
        r9.k();
        return;
    }

    public ECShopFloatLivePresenter(Fragment r1) {
        super(r1);
    }

    public final void A(QModel r4) {
        k0().addObserver(this);
        Set r5 = jn.a.a;
        Activity r6 = l0.b(u().c());
        DialogFragment r0 = S();
        View r1 = o0();
        if ((r1 instanceof FrameLayout) == true) goto L5;
        r1 = null;
    L5:
        FrameLayout r2 = (FrameLayout) r1;
        if (r6 == null) goto L16;
        int r3 = ECSdk.a;
        IAdapterService r7 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r7 == null) goto L16;
        j r8 = r7.getLiveWindowService();
        if (r8 == null) goto L16;
        if (r0 == null) goto L15;
        if (r2 == null) goto L15;
        r8.g(r0, r2);
    L15:
        r8.b(r6);
    L16:
        Ref.BooleanRef r9 = new Ref.BooleanRef();
        r9.element = T().getStoreParam().getStoreUIParam().getLiveDefaultMute();
        T().getLiveInfo().a(W(), new a(this, r9), false);
        T().getUpglideFactor().a(W(), new b(this), false);
        T().getHeaderArea().a(W(), new c(this), false);
    }
}
