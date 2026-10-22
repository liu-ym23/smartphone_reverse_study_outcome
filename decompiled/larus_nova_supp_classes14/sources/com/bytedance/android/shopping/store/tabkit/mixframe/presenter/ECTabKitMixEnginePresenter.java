package com.bytedance.android.shopping.store.tabkit.mixframe.presenter;

import android.view.Window;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.core.utils.y1;
import com.bytedance.android.ec.hybrid.card.bridge.ECBridgeMethodFinder;
import com.bytedance.android.ec.hybrid.list.ECHybridListEngine;
import com.bytedance.android.ec.hybrid.list.ability.k0;
import com.bytedance.android.ec.hybrid.list.ability.l0;
import com.bytedance.android.ec.hybrid.list.ability.m0;
import com.bytedance.android.ec.hybrid.list.bridge.ECLynxCardGetListDataBridge;
import com.bytedance.android.ec.hybrid.list.bridge.ECLynxCardSetListDataBridge;
import com.bytedance.android.ec.hybrid.list.util.l;
import com.bytedance.android.ec.hybrid.list.view.ECHybridListContainer;
import com.bytedance.android.ec.hybrid.monitor.HybridMonitorScenes;
import com.bytedance.android.ec.hybrid.monitor.h;
import com.bytedance.android.shopping.store.tabkit.TabKitViewModel;
import com.bytedance.android.shopping.store.tabkit.mixframe.MixFrameViewModel;
import com.bytedance.android.shopping.store.tabkit.model.k;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentServiceId;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.google.gson.Gson;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECTabKitMixEnginePresenter extends QFragmentPresenter {
    public static final /* synthetic */ int j = 0;
    public final Lazy f;
    public final Lazy g;
    public List<? extends IDLXBridgeMethod> h;
    public final k i;

    public static final class a {
    }

    static {
    }

    public final TabKitViewModel e0() {
        return (TabKitViewModel) this.g.getValue();
    }

    public final MixFrameViewModel h0() {
        return (MixFrameViewModel) this.f.getValue();
    }

    public final void c0() {
        Iterator<T> r0 = this.h.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        IDLXBridgeMethod r1 = (IDLXBridgeMethod) r0.next();
        ECBridgeMethodFinder.a r2 = ECBridgeMethodFinder.h;
        String r3 = h0().getSceneId();
        String r4 = r1.getName();
        r2.getClass();
        ECBridgeMethodFinder.a.b(r3, r4);
        goto L4
    L6:
        MixFrameViewModel r5 = h0();
        Pair[] r6 = new Pair[4];
        r6[0] = TuplesKt.to("EVENT_ORIGIN_FEATURE", "TEMAI");
        k r7 = this.i;
        String r8 = null;
        if (r7 == null) goto L11;
        Map<String, String> r9 = r7.h();
        if (r9 == null) goto L11;
        String r10 = r9.get("entrance_location");
    L12:
        r6[1] = TuplesKt.to("entrance_location", r10);
        if (e0().getClickCloseBtn() == false) goto L15;
        String r11 = CommentServiceId.HOT_SPOT;
    L16:
        r6[2] = TuplesKt.to("click_area", r11);
        k r12 = this.i;
        if (r12 == null) goto L21;
        Map<String, String> r13 = r12.h();
        if (r13 == null) goto L21;
        r8 = r13.get("biz_tag");
    L21:
        r6[3] = TuplesKt.to("biz_tag", r8);
        r5.doEventAction("page_leave", r6);
        return;
    L15:
        r11 = "102";
    L11:
        r10 = null;
        goto L12
    }

    public static Fragment d0(Fragment r1) {
        Fragment r2 = r1.requireParentFragment();
        if ((r2 instanceof com.bytedance.android.shopping.store.tabkit.f) == false) goto L5;
        return r2;
    L5:
        return d0(r2);
    }

    public final void b0(QModel r8) {
        JSONObject r9 = cd.a.c(e0().getRouterParams().getParamsMap());
        int r0 = !e0().isAnchorFinished() ? 1 : 0;
        HashMap r2 = new HashMap();
        r2.put("frame_data", GsonProtectorUtils.toJson(new Gson(), e0().getTabResponse().getValue()));
        r2.put("tab_data", GsonProtectorUtils.toJson(new Gson(), this.i));
        r2.put("router_params", r9);
        r2.put("screen_state", e0().getScreenState().getValue());
        r2.put("monitor_enter_type", Integer.valueOf(r0 ^ 1));
        if (r0 == 0) goto L5;
        r2.put("monitor_page_begin_time", com.bytedance.android.shopping.store.tabkit.k.a);
        e0().setAnchorFinished(true);
    L5:
        Long r10 = com.bytedance.android.shopping.store.tabkit.k.a;
        k r11 = this.i;
        Window r1 = null;
        if (r11 == null) goto L8;
        Integer r12 = r11.n();
    L9:
        r2.put("monitor_tab_begin_time", com.bytedance.android.shopping.store.tabkit.k.a(r12));
        HashMap r13 = new HashMap();
        r13.put("meta_info", r2);
        ECHybridListContainer r3 = Z().b(2131371111).f();
        ECHybridListEngine.a r4 = new ECHybridListEngine.a(Y().c(), h0().getSceneId());
        Intrinsics.checkNotNullParameter(r3, "view");
        r4.b = r3;
        r4.b(ECQuickUtilKt.a(Y()));
        r4.d = 2;
        h r5 = new h(HybridMonitorScenes.EC_STORE_FPS, "moments");
        Intrinsics.checkNotNullParameter(r5, "sceneWrapper");
        r4.e = r5;
        r4.a(new ECTabKitMixEnginePresenter$initEngine$engine$1(this));
        r4.d(k0.class, new ECTabKitMixEnginePresenter$initEngine$engine$2(this));
        r4.d(m0.class, new c(this, r13));
        r4.d(l0.class, new d(this));
        l r14 = h0().getHybridListSession();
        Intrinsics.checkNotNullParameter(r14, "loadSession");
        r4.f = r14;
        ECHybridListEngine r15 = r4.c();
        String r6 = ECSettingKeys.a0();
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L12
        int r16 = com.bytedance.android.ec.store.utils.h.a;     // Catch: Throwable -> L12
        Object r17 = Result.constructor-impl((List) new Gson().fromJson(r6, new com.bytedance.android.shopping.store.tabkit.mixframe.presenter.a().getType()));     // Catch: Throwable -> L12
    L15:
        if (Result.isFailure-impl(r17) == false) goto L17;
        r17 = null;
    L17:
        Iterable r18 = (List) r17;
        if (r18 != null) goto L20;
        r18 = new ArrayList();
    L20:
        LinkedHashMap r19 = new LinkedHashMap();
        Iterator r20 = r18.iterator();
    L22:
        if (r20.hasNext() == false) goto L24;
        r19.put((String) r20.next(), 1);
        goto L22
    L24:
        r15.b.E();
        r15.b.addOnScrollListener(new ECTabKitMixEnginePresenter$initEngine$2());
        ECHybridListEngine.k(r15, r19);
        h0().getResponse().b(ECQuickUtilKt.a(Y()), new b(this, r15));
        List<? extends IDLXBridgeMethod> r21 = CollectionsKt.listOf(new IDLXBridgeMethod[]{new ECLynxCardSetListDataBridge(r15), new ECLynxCardGetListDataBridge(r15), new com.bytedance.android.shopping.store.tabkit.mixframe.a(new ECTabKitMixEnginePresenter$initEngine$4(this))});
        this.h = r21;
        Iterator<T> r22 = r21.iterator();
    L26:
        if (r22.hasNext() == false) goto L28;
        IDLXBridgeMethod r23 = (IDLXBridgeMethod) r22.next();
        ECBridgeMethodFinder.a r24 = ECBridgeMethodFinder.h;
        String r25 = h0().getSceneId();
        String r26 = r23.getName();
        r24.getClass();
        ECBridgeMethodFinder.a.a(r25, r26, r23);
        goto L26
    L28:
        FragmentActivity r27 = ((QFragmentPresenter) this).e.getActivity();
        k r28 = this.i;
        if (r28 == null) goto L31;
        String r29 = r28.l();
    L32:
        boolean r30 = Intrinsics.areEqual(r29, "black");
        int r31 = y1.a;
        if (r27 == null) goto L35;
        r1 = r27.getWindow();
    L35:
        y1.c(r27, r1, r30);
        return;
    L31:
        r29 = null;
    L12:
        th = move-exception;
        Result.Companion r32 = Result.Companion;
        r17 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    L8:
        r12 = null;
        goto L9
    }

    public ECTabKitMixEnginePresenter(final Fragment r2, k r3) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2);
        this.i = r3;
        this.f = LazyKt.lazy(new ECTabKitMixEnginePresenter$viewModel$2(this, r2));
        this.g = LazyKt.lazy(new ECTabKitMixEnginePresenter$tabKitViewModel$2(this, r2));
        this.h = CollectionsKt.emptyList();
    }
}
