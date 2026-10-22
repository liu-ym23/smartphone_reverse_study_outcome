package com.bytedance.android.shopping.store.mall.follows.basic;

import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.core.utils.s0;
import com.bytedance.android.ec.hybrid.card.bridge.ECBridgeMethodFinder;
import com.bytedance.android.ec.hybrid.card.event.ECEventCenter;
import com.bytedance.android.ec.hybrid.list.ECHybridListEngine;
import com.bytedance.android.ec.hybrid.list.ability.k0;
import com.bytedance.android.ec.hybrid.list.ability.l0;
import com.bytedance.android.ec.hybrid.list.ability.m0;
import com.bytedance.android.ec.hybrid.list.bridge.ECLynxCardGetListDataBridge;
import com.bytedance.android.ec.hybrid.list.bridge.ECLynxCardSetListDataBridge;
import com.bytedance.android.ec.hybrid.list.view.ECHybridListContainer;
import com.bytedance.android.shopping.store.mall.follows.basic.BaseFollowStoreViewModel;
import com.bytedance.android.shopping.store.mall.follows.bridge.ECLynxCardGetDisplayTypeBridge;
import com.bytedance.android.ui.ec.widget.toast.ECToast;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class BaseFollowStorePresenter<T extends BaseFollowStoreViewModel> extends QFragmentPresenter {
    public final Lazy f;
    public List<? extends IDLXBridgeMethod> g;
    public final Class<T> h;

    public final T d0() {
        return (T) this.f.getValue();
    }

    public final void c0() {
        s0.e(this);
        Iterator<T> r0 = this.g.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        IDLXBridgeMethod r1 = (IDLXBridgeMethod) r0.next();
        ECBridgeMethodFinder.a r2 = ECBridgeMethodFinder.h;
        String r3 = d0().getSceneId();
        String r4 = r1.getName();
        r2.getClass();
        ECBridgeMethodFinder.a.b(r3, r4);
        goto L4
    }

    public final void b0(QModel r10) {
        s0.c(this);
        ECHybridListContainer r11 = Z().b(2131370738).f();
        ECHybridListEngine.a r0 = new ECHybridListEngine.a(Y().c(), d0().getSceneId());
        Intrinsics.checkNotNullParameter(r11, "view");
        r0.b = r11;
        r0.b(ECQuickUtilKt.a(Y()));
        r0.d = 2;
        com.bytedance.android.ec.hybrid.monitor.h r2 = new com.bytedance.android.ec.hybrid.monitor.h("ec_perf_shop_follow_fps", null, 6);
        Intrinsics.checkNotNullParameter(r2, "sceneWrapper");
        r0.e = r2;
        r0.a(new BaseFollowStorePresenter$initEngine$engine$1(this));
        r0.d(k0.class, new i(this));
        r0.d(m0.class, new j(this));
        r0.d(l0.class, new k(this));
        com.bytedance.android.ec.hybrid.list.util.l r3 = d0().getHybridListSession();
        Intrinsics.checkNotNullParameter(r3, "loadSession");
        r0.f = r3;
        hj3.g r4 = d0().getMomentConfig();
        if (r4 == null) goto L5;
        int r5 = r4.g();
    L6:
        r0.d = r5;
        ECHybridListEngine r1 = r0.c();
        LinkedHashMap r6 = new LinkedHashMap();
        hj3.g r7 = d0().getMomentConfig();
        if (r7 == null) goto L18;
        List<String> r8 = r7.f();
        if (r8 == null) goto L18;
        Iterator<T> r9 = r8.iterator();
    L12:
        if (r9.hasNext() == false) goto L18;
        String r12 = (String) r9.next();
        hj3.g r13 = d0().getMomentConfig();
        if (r13 == null) goto L16;
        Integer r14 = Integer.valueOf(r13.e());
    L17:
        r6.put(r12, Integer.valueOf(com.bytedance.android.shopping.extensions.k.g(r14, 1)));
        goto L12
    L16:
        r14 = null;
    L18:
        ECHybridListEngine.k(r1, r6);
        r11.setEngine(r1);
        r1.b.E();
        r1.b.addOnScrollListener(new BaseFollowStorePresenter$initEngine$1());
        d0().getResponse().b(ECQuickUtilKt.a(Y()), new h(this, r1));
        List<? extends IDLXBridgeMethod> r15 = CollectionsKt.listOf(new IDLXBridgeMethod[]{new ECLynxCardSetListDataBridge(r1), new ECLynxCardGetListDataBridge(r1), new ECLynxCardGetDisplayTypeBridge(r1), new com.bytedance.android.shopping.store.tabkit.mixframe.a(new BaseFollowStorePresenter$registerBridge$1(this))});
        this.g = r15;
        Iterator<T> r16 = r15.iterator();
    L20:
        if (r16.hasNext() == false) goto L22;
        IDLXBridgeMethod r17 = (IDLXBridgeMethod) r16.next();
        ECBridgeMethodFinder.a r18 = ECBridgeMethodFinder.h;
        String r19 = d0().getSceneId();
        String r20 = r17.getName();
        r18.getClass();
        ECBridgeMethodFinder.a.a(r19, r20, r17);
        goto L20
    L22:
        return;
    L5:
        r5 = 0;
        goto L6
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onItemMissEvent(hj3.f r11) {
        Intrinsics.checkNotNullParameter(r11, "itemMissEvent");
        if (com.bytedance.android.shopping.extensions.k.c(r11.b) == false) goto L6;
        ECToast.showToast$default(ECToast.INSTANCE, Y().c(), r11.b, null, 4, null);
    L6:
        if (com.bytedance.android.shopping.extensions.k.c(r11.a) == false) goto L9;
        ECEventCenter.c(new com.bytedance.android.ec.hybrid.card.event.b("ec.shop.cardDismiss", System.currentTimeMillis(), d0().getSceneId(), false, MapsKt.mapOf(TuplesKt.to("item_id", r11.a)), false, 32));
        return;
    }

    public BaseFollowStorePresenter(Fragment r2, Class<T> r3) {
        Intrinsics.checkNotNullParameter(r2, "f");
        Intrinsics.checkNotNullParameter(r3, "vmClazz");
        super(r2);
        this.h = r3;
        this.f = LazyKt.lazy(new BaseFollowStorePresenter$viewModel$2(this));
        this.g = CollectionsKt.emptyList();
    }
}
