package com.bytedance.android.shopping.store.tabkit.mixframe.impl;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.BtmSDKWrapper;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.btm.api.model.n;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.monitor.ECMonitorService;
import com.bytedance.android.ec.store.shopping.paging.LoadStatus;
import com.bytedance.android.ec.store.utils.h;
import com.bytedance.android.shopping.store.mall.follows.apidata.FollowStoreApiDataCacheKey;
import com.bytedance.android.shopping.store.mall.follows.basic.BaseFollowRefreshPresenter;
import com.bytedance.android.shopping.store.mall.follows.basic.BaseFollowStoreListBgPresenter;
import com.bytedance.android.shopping.store.mall.follows.basic.BaseFollowStorePlayControlPresenter;
import com.bytedance.android.shopping.store.mall.follows.basic.BaseFollowStorePresenter;
import com.bytedance.android.shopping.store.mall.follows.basic.BaseFollowStoreStatusPresenter;
import com.bytedance.android.shopping.store.mall.follows.basic.BaseFollowStoreViewModel;
import com.bytedance.android.shopping.store.mall.follows.basic.l;
import com.bytedance.android.shopping.store.mall.follows.basic.o;
import com.bytedance.android.shopping.store.tabkit.TabKitViewModel;
import com.bytedance.android.shopping.store.tabkit.mixframe.c;
import com.bytedance.android.shopping.store.tabkit.router.TabKitRouterParams;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import com.google.gson.Gson;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import hj3.e;
import hj3.g;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import s83.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECTabKitMixFrameFollowImpl implements c {
    public final Lazy b;
    public final Lazy c;
    public final Map<String, String> d;
    public final Fragment e;

    public static final class a {
    }

    static {
    }

    public final TabKitViewModel c() {
        return (TabKitViewModel) this.c.getValue();
    }

    public final ECTabKitMixFrameFollowViewModel d() {
        return (ECTabKitMixFrameFollowViewModel) this.b.getValue();
    }

    @Override // com.bytedance.android.shopping.store.tabkit.mixframe.c
    public final void destroy() {
    }

    @Override // com.bytedance.android.shopping.store.tabkit.mixframe.c
    public final View a() {
        return LayoutInflater.from(this.e.requireContext()).inflate(2131560913, null);
    }

    @Override // com.bytedance.android.shopping.store.tabkit.mixframe.c
    public final void init() {
        Bundle r0 = this.e.getArguments();
        if (r0 != null) goto L5;
        r0 = Bundle.EMPTY;
    L5:
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("tab_id", String.valueOf(r0.getInt("tab_id", -1)));
        TabKitViewModel r2 = c();
        if (r2 == null) goto L11;
        TabKitRouterParams r3 = r2.getRouterParams();
        if (r3 == null) goto L11;
        String r4 = r3.getBtmAB();
        if (r4 == null) goto L11;
    L12:
        r1.put(BaseFollowStoreViewModel.KEY_BTM_KEY, r4);
        TabKitViewModel r5 = c();
        Long r6 = null;
        if (r5 == null) goto L17;
        TabKitRouterParams r7 = r5.getRouterParams();
        if (r7 == null) goto L17;
        String r8 = r7.getEntranceLocation();
    L18:
        String r9 = "";
        if (r8 != null) goto L21;
        r8 = "";
    L21:
        r1.put(BaseFollowStoreViewModel.KEY_PREVIOUS_PAGE, r8);
        TabKitViewModel r10 = c();
        if (r10 == null) goto L26;
        TabKitRouterParams r11 = r10.getRouterParams();
        if (r11 == null) goto L26;
        String r12 = r11.getEcomSceneId();
    L27:
        if (r12 != null) goto L29;
        r12 = "";
    L29:
        r1.put(BaseFollowStoreViewModel.KEY_ECOM_SCENE_ID, r12);
        dm.a.a("FollowStore").i("init pageParams：" + r1);
        Object r13 = r1.get(BaseFollowStoreViewModel.KEY_BTM_KEY);
        if (r13 == null) goto L36;
        String r14 = r13.toString();
        if (r14 == null) goto L36;
        r9 = r14;
    L36:
        if ((!StringsKt.isBlank(r9)) == false) goto L44;
        TabKitViewModel r15 = c();
        if (r15 == null) goto L42;
        TabKitRouterParams r16 = r15.getRouterParams();
        if (r16 == null) goto L42;
        String r17 = r16.getSourceBtmToken();
    L43:
        Lazy r18 = BtmSDKWrapper.a;
        BtmSDKWrapper.b(this.e, r9, r17);
    L42:
        r17 = null;
    L44:
        JSONObject r19 = new JSONObject();
        Result.Companion r20 = Result.Companion;     // Catch: Throwable -> L47
        Object r21 = Result.constructor-impl(r19.put("page_name", "follow_shop_page"));     // Catch: Throwable -> L47
    L50:
        if (Result.isFailure-impl(r21) == false) goto L52;
        r21 = null;
    L52:
        FollowStoreApiDataCacheKey r22 = new FollowStoreApiDataCacheKey("first_mix_feed_cache", "first_mix_feed_cache_time", "mall_follow_tab_feed_follow_data");
        d().init(r1, this.d, (JSONObject) r21, r22);
        e r23 = d().getPerfMonitor();
        if (r23 == null) goto L72;
        Bundle r24 = this.e.getArguments();
        if (r24 == null) goto L67;
        String r25 = r24.getString("tab_id");
        if (r25 == null) goto L67;
        Integer r26 = StringsKt.toIntOrNull(r25);
        if (r26 == null) goto L67;
        int r27 = r26.intValue();
        TabKitViewModel r28 = c();
        if (r28 == null) goto L65;
        ok3.a r29 = r28.getTabKitMonitor();
        if (r29 == null) goto L65;
        r6 = (Long) r29.c(r27).get("t_tab_init");
    L65:
        if (r6 == null) goto L67;
        long r30 = r6.longValue();
    L68:
        r23.a = Long.valueOf(r30);
        return;
    L67:
        r30 = System.currentTimeMillis();
        goto L68
    L72:
        return;
    L47:
        th = move-exception;
        Result.Companion r31 = Result.Companion;
        r21 = Result.constructor-impl(ResultKt.createFailure(th));
    L26:
        r12 = null;
    L17:
        r8 = null;
    L11:
        r4 = "a1.b479155";
        goto L12
    }

    public ECTabKitMixFrameFollowImpl(Fragment r3) {
        Intrinsics.checkNotNullParameter(r3, "fragment");
        this.e = r3;
        BaseFollowStoreViewModel.Companion.getClass();
        if (ECSettingKeys.h0() == 1) goto L20;
    L18:
        this.b = LazyKt.lazy(new ECTabKitMixFrameFollowImpl$viewModel$2(this));
        this.c = LazyKt.lazy(new ECTabKitMixFrameFollowImpl$tabKitViewModel$2(this));
        JSONObject r4 = new JSONObject();
        r4.put("entrance_location", "106");
        Unit r0 = Unit.INSTANCE;
        this.d = MapsKt.mapOf(TuplesKt.to("pass_through_api", r4.toString()));
        return;
    L20:
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L6
        int r6 = h.a;     // Catch: Throwable -> L6
        Object r7 = Result.constructor-impl((g) new Gson().fromJson(ECSettingKeys.u0(), new o().getType()));     // Catch: Throwable -> L6
    L9:
        if (Result.isFailure-impl(r7) == false) goto L11;
        r7 = null;
    L11:
        g r8 = (g) r7;
        if (r8 == null) goto L18;
        String r9 = r8.j();
        if (r9 == null) goto L18;
        boolean r1 = ECServiceManager.a;
        b r2 = ((s83.g) ECServiceManager.c(s83.g.class)).x();
        if (r2 == null) goto L18;
        r2.b(CollectionsKt.listOf(r9));
    L6:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L9
    }

    @Override // com.bytedance.android.shopping.store.tabkit.mixframe.c
    public final List<QIPresenter> b(View r5) {
        Intrinsics.checkNotNullParameter(r5, "rootView");
        TabKitViewModel r0 = c();
        if (r0 == null) goto L7;
        TabKitRouterParams r1 = r0.getRouterParams();
        if (r1 == null) goto L7;
        Integer r2 = r1.getPageModal();
    L9:
        if (r2 != null) goto L12;
    L14:
        boolean r3 = false;
    L15:
        ArrayList r4 = new ArrayList();
        r4.add(new BaseFollowStorePresenter(this.e, ECTabKitMixFrameFollowViewModel.class));
        r4.add(new BaseFollowStorePlayControlPresenter(this.e, ECTabKitMixFrameFollowViewModel.class));
        r4.add(new BaseFollowStoreStatusPresenter(this.e, ECTabKitMixFrameFollowViewModel.class));
        r4.add(new BaseFollowStoreListBgPresenter(this.e, ECTabKitMixFrameFollowViewModel.class));
        r4.add(new l(this.e, ECTabKitMixFrameFollowViewModel.class));
        r4.add(new BaseFollowRefreshPresenter(this.e, ECTabKitMixFrameFollowViewModel.class, !r3));
        return r4;
    L12:
        if (r2.intValue() != 1) goto L14;
        r3 = true;
    L7:
        r2 = null;
        goto L9
    }

    @Override // com.bytedance.android.shopping.store.tabkit.mixframe.c
    public final void onHide(boolean r7) {
        if (r7 == false) goto L17;
        e r8 = d().getPerfMonitor();
        if (r8 == null) goto L18;
        int r0 = ECMonitorService.b;
        JSONObject r1 = new JSONObject();
        if (r8.f == null) goto L8;
    L10:
        String r2 = CommentScene.COMMENTSCENE_NO_AWEME;
    L11:
        r1.put("page_showed", r2);
        Unit r3 = Unit.INSTANCE;
        JSONObject r4 = new JSONObject();
        long r5 = System.currentTimeMillis();
        Long r6 = r8.b;
        if (r6 == null) goto L14;
        long r9 = r6.longValue();
    L15:
        r4.put("stay_duration", r5 - r9);
        ECMonitorService.a.a("ec_perf_shop_follow_destroy", r1, r4, r8.g);
        return;
    L14:
        r9 = 0;
        goto L15
    L8:
        if (r8.e != null) goto L10;
        r2 = "0";
        goto L11
    L18:
        return;
    }

    @Override // com.bytedance.android.shopping.store.tabkit.mixframe.c
    public final void onShow(boolean r9) {
        if (r9 == false) goto L8;
        e r10 = d().getPerfMonitor();
        if (r10 == null) goto L6;
        r10.b = Long.valueOf(System.currentTimeMillis());
    L6:
        BaseFollowStoreViewModel.loadData$default(d(), LoadStatus.Initialize, this.e.getContext(), true, null, 8, null);
        BtmSDK r11 = BtmSDK.INSTANCE;
        Fragment r0 = this.e;
        com.bytedance.android.btm.api.model.o r1 = new com.bytedance.android.btm.api.model.o();
        ((n) r1).a = true;
        Unit r3 = Unit.INSTANCE;
        r11.onPageShow(r0, null, r1);
        com.bytedance.android.btm.api.model.c r2 = new BtmItemBuilder("", Boolean.FALSE).withBtmPage(this.e).build();
        d().doEventAction("xtab_follow_page_show", new Pair[]{TuplesKt.to("entrance_location", "follow_shop_page"), TuplesKt.to(BaseFollowStoreViewModel.KEY_PREVIOUS_PAGE, String.valueOf(d().getPageParams().get(BaseFollowStoreViewModel.KEY_PREVIOUS_PAGE))), TuplesKt.to("btm_id", r11.obtainEventBtmParams(r2))});
        return;
    }
}
