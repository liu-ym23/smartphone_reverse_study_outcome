package com.bytedance.android.shopping.store.moments.module.presenter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.ec.core.monitor.MonitorScenes;
import com.bytedance.android.ec.core.monitor.q;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.core.utils.l0;
import com.bytedance.android.ec.hybrid.list.ECHybridListEngine;
import com.bytedance.android.ec.hybrid.list.ECHybridListItemType;
import com.bytedance.android.ec.hybrid.list.ability.k0;
import com.bytedance.android.ec.hybrid.list.ability.m0;
import com.bytedance.android.ec.hybrid.list.view.ECHybridListContainer;
import com.bytedance.android.ec.hybrid.list.view.ECHybridRecyclerView;
import com.bytedance.android.ec.hybrid.monitor.HybridMonitorScenes;
import com.bytedance.android.ec.store.common.headlive.StoreV3LiveRoomVO;
import com.bytedance.android.ec.store.setting.ECStoreSettings;
import com.bytedance.android.ec.store.setting.SettingKeys;
import com.bytedance.android.ec.store.shopping.paging.LoadStatus;
import com.bytedance.android.ec.store.status.DefaultStoreTadLoadingStatusView;
import com.bytedance.android.ec.store.status.LazyStatusView;
import com.bytedance.android.shopping.extensions.ViewExtensionsKt;
import com.bytedance.android.shopping.store.home.api.ECStoreParam;
import com.bytedance.android.shopping.store.hybrid.StoreTabConfig;
import com.bytedance.android.shopping.store.moments.ECStoreMixFragment;
import com.bytedance.android.shopping.store.moments.dto.ECStoreMomentResponse;
import com.bytedance.android.shopping.store.moments.dto.HybridListDTO;
import com.bytedance.android.shopping.store.moments.viewmodel.ECStoreMomentViewModel;
import com.bytedance.android.shopping.store.repository.vo.TabEnum;
import com.bytedance.android.shopping.store.settings.ECShopABSettings;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import com.google.gson.Gson;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/store/moments/module/presenter/ECStoreMomentPresenter;", "Lcom/ss/android/ugc/aweme/kiwi/presenter/QFragmentPresenter;", "Landroidx/lifecycle/LifecycleObserver;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECStoreMomentPresenter extends QFragmentPresenter implements LifecycleObserver {
    public ECHybridListContainer f;
    public ECHybridListEngine g;
    public final Lazy h;
    public final ECStoreViewModel i;
    public final StoreTabConfig j;

    public final ECStoreMomentViewModel d0() {
        return (ECStoreMomentViewModel) this.h.getValue();
    }

    public final void b0(QModel r11) {
        this.f = Z().b(2131371111).f();
        if (this.i.isWhiteBrand() == false) goto L5;
        ViewExtensionsKt.g(a0(), 12.0f, 12.0f, 0.0f, 0.0f);
    L5:
        d0().fetchMomentApi();
        Context r12 = Y().c();
        ViewGroup r0 = (ViewGroup) Z().b(2131387798).f();
        Fragment r2 = null;
        LazyStatusView r1 = new LazyStatusView(r12, null);
        r0.addView(r1);
        boolean r6 = false;
        r1.setCreators(MapsKt.mapOf(new Pair[]{TuplesKt.to(com.bytedance.android.ec.store.status.b.a.a, new com.bytedance.android.ec.store.status.c(new ECStoreMomentPresenter$initOptStatusView$1(this), null, 6)), TuplesKt.to(com.bytedance.android.ec.store.status.b.b.a, new com.bytedance.android.ec.store.status.c(new ECStoreMomentPresenter$initOptStatusView$2(this), null, 6))}));
        r1.a(new DefaultStoreTadLoadingStatusView(r12).a());
        d0().getLoadStatus().b(ECQuickUtilKt.a(Y()), new h(r0, r1));
        Map r13 = MapsKt.toMutableMap(ECStoreParam.getTabMetaInfo$default(this.i.getStoreParam(), Integer.valueOf(TabEnum.MOMENTS_TAB.getType()), null, 2, null));
        StoreV3LiveRoomVO r3 = (StoreV3LiveRoomVO) this.i.getLiveInfo().getValue();
        if (r3 == null) goto L8;
        String r4 = r3.getRoomId();
    L9:
        String r5 = "";
        if (r4 != null) goto L12;
        r4 = "";
    L12:
        r13.put("room_id", r4);
        StoreV3LiveRoomVO r7 = (StoreV3LiveRoomVO) this.i.getLiveInfo().getValue();
        if (r7 == null) goto L15;
        String r8 = r7.getAnchorId();
    L16:
        if (r8 != null) goto L18;
        r8 = "";
    L18:
        r13.put("anchor_id", r8);
        View r9 = a0();
        Intrinsics.checkNotNullParameter(r9, "$this$readEntranceInfoAsString");
        Context r10 = r9.getContext();
        if (r10 == null) goto L23;
        Activity r14 = l0.b(r10);
        if (r14 == null) goto L23;
        String r15 = hm.c.e(r14);
    L24:
        if (r15 != null) goto L26;
        r15 = "";
    L26:
        r13.put("entrance_info", r15);
        ECHybridListEngine.a r16 = new ECHybridListEngine.a(Y().c(), this.i.getSceneId());
        ECHybridListContainer r17 = this.f;
        if (r17 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("container");
    L29:
        Intrinsics.checkNotNullParameter(r17, "view");
        r16.b = r17;
        r16.b(ECQuickUtilKt.a(Y()));
        r16.d = 2;
        com.bytedance.android.ec.hybrid.monitor.h r18 = new com.bytedance.android.ec.hybrid.monitor.h(HybridMonitorScenes.EC_STORE_FPS, "moments");
        Intrinsics.checkNotNullParameter(r18, "sceneWrapper");
        r16.e = r18;
        ECShopABSettings.k.getClass();
        r16.n = ECShopABSettings.i();
        r16.a(new ECStoreMomentPresenter$initEngine$1(this));
        r16.d(k0.class, new e(this));
        r16.d(m0.class, new ECStoreMomentPresenter$initEngine$3(this, r13));
        r16.d(com.bytedance.android.ec.hybrid.list.ability.l0.class, new f(this));
        com.bytedance.android.ec.hybrid.list.util.l r19 = d0().getHybridListSession();
        Intrinsics.checkNotNullParameter(r19, "loadSession");
        r16.f = r19;
        this.g = r16.c();
        String r110 = SettingKeys.getSTORE_MOMENT_TAB_PREFETCH_LYNX_URL();
        Result.Companion r20 = Result.Companion;     // Catch: Throwable -> L32
        int r21 = com.bytedance.android.ec.store.utils.h.a;     // Catch: Throwable -> L32
        Object r111 = Result.constructor-impl((List) new Gson().fromJson(r110, new a().getType()));     // Catch: Throwable -> L32
    L35:
        if (Result.isFailure-impl(r111) == false) goto L37;
        r111 = null;
    L37:
        Iterable r112 = (List) r111;
        if (r112 != null) goto L40;
        r112 = new ArrayList();
    L40:
        LinkedHashMap r22 = new LinkedHashMap();
        Iterator r113 = r112.iterator();
    L42:
        if (r113.hasNext() == false) goto L44;
        r22.put((String) r113.next(), 1);
        goto L42
    L44:
        ECHybridListEngine r114 = this.g;
        if (r114 == null) goto L49;
        ECHybridRecyclerView r115 = r114.b;
        if (r115 == null) goto L49;
        r115.E();
    L49:
        ECHybridListEngine r116 = this.g;
        if (r116 == null) goto L55;
        ECHybridRecyclerView r117 = r116.b;
        if (r117 == null) goto L55;
        r117.addOnScrollListener(new ECStoreMomentPresenter$initEngine$6(this));
    L55:
        if (ECStoreSettings.c() != 0) goto L61;
        ECHybridListEngine r118 = this.g;
        if (r118 == null) goto L61;
        ECHybridRecyclerView r119 = r118.b;
        if (r119 == null) goto L61;
        jh.b.a r23 = jh.b.c;
        q r24 = new q(MonitorScenes.EC_SHOP_FPS, "moments", null);
        r23.getClass();
        jh.b.a.c(r24).c(r119);
    L61:
        ECHybridListEngine r120 = this.g;
        if (r120 == null) goto L64;
        ECHybridListEngine.k(r120, r22);
    L64:
        ECHybridListEngine.Companion r121 = ECHybridListEngine.x;
        ECHybridListEngine r25 = this.g;
        if (r25 == null) goto L67;
        String r26 = r25.s;
    L68:
        if (r26 == null) goto L71;
        r5 = r26;
    L71:
        int r27 = ECHybridListItemType.SHOP_MOMENTS_SHORT_VIDEO_CARD_V2.getType();
        LifecycleOwner r28 = ECQuickUtilKt.a(Y());
        g r29 = new g(this);
        r121.getClass();
        ECHybridListEngine.Companion.c(r5, r27, r28, r29);
        Fragment r122 = Y().a;
        if ((r122 instanceof ECStoreMixFragment) == false) goto L75;
        r2 = r122;
    L75:
        ECStoreMixFragment r30 = (ECStoreMixFragment) r2;
        if (r30 == null) goto L90;
        ECStoreMomentResponse r123 = r30.l;
        if (r123 == null) goto L90;
        HybridListDTO r124 = r123.getHybridList();
        if (r124 == null) goto L90;
        ECHybridListEngine r31 = this.g;
        if (r31 == null) goto L89;
        HybridListDTO.Companion.getClass();
        com.bytedance.android.ec.hybrid.list.entity.k r125 = HybridListDTO.a.a(r124);
        if (this.i.isWhiteBrand() == false) goto L88;
        com.bytedance.android.ec.hybrid.list.entity.j r32 = r125.a;
        if (r32 == null) goto L88;
        r32.i = "#00000000";
    L88:
        Unit r33 = Unit.INSTANCE;
        ECHybridListEngine.p(r31, r125, 6);
    L89:
        d0().getLoadStatus().g(LoadStatus.InitializeSuccess);
    L90:
        d0().getResponse().c(ECQuickUtilKt.a(Y()), new d(this), true);
        this.i.fetchRefresh("shop_moment");
        MutableLiveData<Boolean> r126 = d0().isMute();
        if (this.i.couldLive() == false) goto L93;
    L94:
        r6 = true;
    L95:
        r126.setValue(Boolean.valueOf(r6));
        return;
    L93:
        if (this.i.isFullScreen() == true) goto L95;
    L67:
        r26 = null;
    L32:
        th = move-exception;
        Result.Companion r34 = Result.Companion;
        r111 = Result.constructor-impl(ResultKt.createFailure(th));
    L23:
        r15 = null;
        goto L24
    L15:
        r8 = null;
        goto L16
    L8:
        r4 = null;
        goto L9
    }

    public ECStoreMomentPresenter(ECStoreMixFragment r2, ECStoreViewModel r3, StoreTabConfig r4) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "storeViewModel");
        super(r2);
        this.i = r3;
        this.j = r4;
        this.h = LazyKt.lazy(new ECStoreMomentPresenter$viewModel$2(this));
    }
}
