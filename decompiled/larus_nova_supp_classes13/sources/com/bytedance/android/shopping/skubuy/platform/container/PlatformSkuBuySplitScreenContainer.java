package com.bytedance.android.shopping.skubuy.platform.container;

import ai3.j;
import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.model.live.LiveClearScreenMode;
import com.bytedance.android.ec.model.live.LiveScreenMoveMode;
import com.bytedance.android.ec.model.live.s;
import com.bytedance.android.shopping.abscontainer.arch.core.lifecycle.LifecycleEnum;
import com.bytedance.android.shopping.abscontainer.arch.core.starter.PageInfo;
import com.bytedance.android.shopping.abscontainer.arch.platform.container.PlatformSplitScreenContainer;
import com.bytedance.android.shopping.abscontainer.common_biz.custom_event.SelfJsBridgeEvent;
import com.bytedance.android.shopping.abscontainer.common_biz.custom_event.a0;
import com.bytedance.android.shopping.abscontainer.common_biz.custom_event.b0;
import com.bytedance.android.shopping.abscontainer.common_biz.custom_event.c0;
import com.bytedance.android.shopping.abscontainer.common_biz.custom_event.e0;
import com.bytedance.android.shopping.abscontainer.common_biz.custom_event.f;
import com.bytedance.android.shopping.abscontainer.common_biz.custom_event.f0;
import com.bytedance.android.shopping.abscontainer.common_biz.custom_event.g;
import com.bytedance.android.shopping.abscontainer.common_biz.custom_event.g0;
import com.bytedance.android.shopping.abscontainer.common_biz.custom_event.h;
import com.bytedance.android.shopping.abscontainer.common_biz.custom_event.h0;
import com.bytedance.android.shopping.abscontainer.common_biz.custom_event.i;
import com.bytedance.android.shopping.abscontainer.common_biz.custom_event.i0;
import com.bytedance.android.shopping.abscontainer.common_biz.custom_event.j0;
import com.bytedance.android.shopping.abscontainer.common_biz.custom_event.k;
import com.bytedance.android.shopping.abscontainer.common_biz.custom_event.k0;
import com.bytedance.android.shopping.abscontainer.common_biz.custom_event.l;
import com.bytedance.android.shopping.abscontainer.common_biz.custom_event.l0;
import com.bytedance.android.shopping.abscontainer.common_biz.custom_event.m;
import com.bytedance.android.shopping.abscontainer.common_biz.custom_event.m0;
import com.bytedance.android.shopping.abscontainer.common_biz.custom_event.n;
import com.bytedance.android.shopping.abscontainer.common_biz.custom_event.n0;
import com.bytedance.android.shopping.abscontainer.common_biz.custom_event.o0;
import com.bytedance.android.shopping.abscontainer.common_biz.custom_event.p;
import com.bytedance.android.shopping.abscontainer.common_biz.custom_event.p0;
import com.bytedance.android.shopping.abscontainer.common_biz.custom_event.q;
import com.bytedance.android.shopping.abscontainer.common_biz.custom_event.q0;
import com.bytedance.android.shopping.abscontainer.common_biz.custom_event.r;
import com.bytedance.android.shopping.abscontainer.common_biz.custom_event.r0;
import com.bytedance.android.shopping.abscontainer.common_biz.custom_event.s0;
import com.bytedance.android.shopping.abscontainer.common_biz.custom_event.t;
import com.bytedance.android.shopping.abscontainer.common_biz.custom_event.t0;
import com.bytedance.android.shopping.abscontainer.common_biz.custom_event.u;
import com.bytedance.android.shopping.abscontainer.common_biz.custom_event.u0;
import com.bytedance.android.shopping.abscontainer.common_biz.custom_event.v;
import com.bytedance.android.shopping.abscontainer.common_biz.custom_event.v0;
import com.bytedance.android.shopping.abscontainer.common_biz.custom_event.x0;
import com.bytedance.android.shopping.abscontainer.common_biz.custom_event.y;
import com.bytedance.android.shopping.abscontainer.common_biz.custom_event.z;
import com.bytedance.android.shopping.abscontainer.common_biz.module.CheckPayScene;
import com.bytedance.android.shopping.abscontainer.common_biz.module.CreateOrderModule;
import com.bytedance.android.shopping.abscontainer.common_biz.module.ElevatorGuideModule;
import com.bytedance.android.shopping.abscontainer.common_biz.module.QuitPageModule;
import com.bytedance.android.shopping.abscontainer.common_biz.module.hybrid_event.CheckWhenContinueCloseModule;
import com.bytedance.android.shopping.abscontainer.common_biz.module.hybrid_event.CloseSizeAssistantModule;
import com.bytedance.android.shopping.skubuy.ability.SkuBuyUiAbility;
import com.bytedance.android.shopping.skubuy.constant.SkuBuyModuleName;
import com.bytedance.android.shopping.skubuy.module.PopupAdjustModule;
import com.bytedance.android.shopping.skubuy.module.SkuBuyCoreFlowModule;
import com.bytedance.android.shopping.skubuy.module.TopBannerModule;
import com.bytedance.android.shopping.skubuy.module.monitor.PerformanceModule;
import com.bytedance.android.shopping.skubuy.platform.data.api.PlatformSkuBuyRepository;
import com.bytedance.android.shopping.skubuy.platform.data.api.SkuBuyApi;
import com.bytedance.android.shopping.skubuy.platform.helper.b;
import com.bytedance.android.shopping.skubuy.platform.module.StyleAdjustModule;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import yh3.a;
import yh3.c;
import yh3.d;
import yh3.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/shopping/skubuy/platform/container/PlatformSkuBuySplitScreenContainer;", "Lcom/bytedance/android/shopping/abscontainer/arch/platform/container/PlatformSplitScreenContainer;", "Lyh3/c;", "Lyh3/a;", "Lcom/bytedance/android/ec/model/live/s;", "<init>", "()V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PlatformSkuBuySplitScreenContainer extends PlatformSplitScreenContainer<c, a> implements s {
    public final String h;
    public p33.a i;

    public final d kR() {
        return new d();
    }

    public final c rf() {
        return new c(0);
    }

    public PlatformSkuBuySplitScreenContainer() {
        this.h = "sku_buy";
    }

    public final Set<Object> jf() {
        b.c();
        return SetsKt.emptySet();
    }

    public final LiveScreenMoveMode AC() {
        return LiveScreenMoveMode.LIVE_SCREEN_MOVE_UP;
    }

    public final String S90() {
        return this.h;
    }

    public final LiveClearScreenMode cy() {
        return LiveClearScreenMode.CLEAR_SCREEN_MODE_FULL;
    }

    public final p33.a IU(ConstraintLayout r4) {
        Intrinsics.checkNotNullParameter(r4, "rootView");
        FragmentActivity r1 = getActivity();
        if (r1 == null) goto L5;
        Window r2 = r1.getWindow();
    L6:
        p33.a r5 = new zh3.a(r2, false).a(r4);
        this.i = r5;
        return r5;
    L5:
        r2 = null;
        goto L6
    }

    public final a Jq(PageInfo r14) {
        Intrinsics.checkNotNullParameter(r14, "pageInfo");
        r33.a r2 = new r33.a(r14.getSchemaModel().getQueryParam("source_btm_token"));
        String r0 = r14.getSchemaModel().getQueryParam("height_percent");
        if (r0 == null) goto L7;
        Integer r1 = StringsKt.toIntOrNull(r0);
        if (r1 == null) goto L7;
        int r3 = r1.intValue();
    L8:
        float r4 = r3 / 100.0f;
        String r5 = r14.getSchemaModel().getQueryParam("mask_alpha");
        if (r5 == null) goto L13;
        Float r6 = StringsKt.toFloatOrNull(r5);
        if (r6 == null) goto L13;
        float r7 = r6.floatValue();
    L14:
        e r8 = new e(r4, Float.valueOf(r7), false);
        List r9 = ECSettingKeys.l0().getExtendFields();
        ConcurrentHashMap r10 = a43.a.a;
        Intrinsics.areEqual(l43.a.a("ec_sku_buy_disable_compress"), 1);
        u33.c r11 = new u33.c(r9);
        v33.b r12 = new v33.b(b.b(r14.getInSplitScreen()), new v33.a(b.a()));
        String r13 = r14.getSchemaModel().getQueryParam("id");
        if (r13 != null) goto L17;
        String r15 = "";
    L18:
        String r16 = r14.getSchemaModel().getQueryParam("sku_session_id");
        if (r16 != null) goto L21;
        String r17 = "";
    L23:
        return new a(r2, r14, r8, r11, r12, new u33.b(MapsKt.emptyMap()), r15, r17, Boolean.parseBoolean(r14.getSchemaModel().getQueryParam("split_screen_half_mode")), UUID.randomUUID().toString(), 64);
    L21:
        r17 = r16;
        goto L23
    L17:
        r15 = r13;
    L13:
        r7 = 0.5f;
    L7:
        r3 = 73;
        goto L8
    }

    public final void dY(l33.c r3) {
        Intrinsics.checkNotNullParameter(r3, "platformContainerDelegate");
        Intrinsics.checkNotNullParameter(r3, "platformContainerDelegate");
        int r0 = j.a;
        Activity r4 = r3.getContainerContext();
        if (r4 == null) goto L7;
        Intrinsics.checkNotNullParameter(r4, "activity");
        ShoppingAsyncInflater.e.getClass();
        ShoppingAsyncInflater.a.a(r4).a().a(2131559218, 1).a(2131559217, 1).commit();
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    }

    public final Set<m33.a<c, a>> gO(l33.b<c, a> r4) {
        Intrinsics.checkNotNullParameter(r4, "containerContext");
        SkuBuyApi r2 = PlatformSkuBuyRepository.a;
        return SetsKt.setOf(new m33.a[]{new h(r4), new n0(r4), new v(r4), new a0(r4), new l0(r4), new n(r4), new com.bytedance.android.shopping.abscontainer.common_biz.custom_event.s(r4), new f(r4), new o0(r4), new g(r4), new s0(r4), new i0(r4), new g0(r4), new p(r4), new t(r4), new c0(r4), new b0(r4), new p0(r4), new j0(r4), new q0(r4), new h0(r4), new r0(r4), new com.bytedance.android.shopping.abscontainer.common_biz.custom_event.j(r4), new l(r4), new z(r4), new e0(r4), new SelfJsBridgeEvent(r4), new x0(r4), new m(r4), new v0(r4), new k0(r4), new com.bytedance.android.shopping.abscontainer.common_biz.custom_event.a(r4), new u0(r4), new t0(r4), new i(r4), new com.bytedance.android.shopping.abscontainer.common_biz.custom_event.d(r4), new f0(r4), new com.bytedance.android.shopping.abscontainer.common_biz.custom_event.c(r4), new r(r4), new u(r4), new k(r4), new q(r4), new y(r4), new m0(r4)});
    }

    public final void onCreate(Bundle r1) {
        super.onCreate(r1);
        if (r1 == null) goto L6;
        is();
        return;
    }

    public final i33.c wR(AndroidYaTaInstance r4) {
        Intrinsics.checkNotNullParameter(r4, "yataInstance");
        return new i33.c(new SkuBuyUiAbility(this, this.i, r4));
    }

    public final s33.a<c, a> zE(l33.b<c, a> r5) {
        Intrinsics.checkNotNullParameter(r5, "containerContext");
        Map r0 = MapsKt.mapOf(TuplesKt.to(LifecycleEnum.FLOW_QUERY_FETCH_SUCCEED, new s33.c(CollectionsKt.listOf(SkuBuyModuleName.PAGE_LIFECYCLE_TRACK_MODULE.getRawValue()), 2)));
        ArrayList r1 = new ArrayList();
        r1.add(new SkuBuyCoreFlowModule(r5));
        r1.add(new com.bytedance.android.shopping.abscontainer.common_biz.module.a(r5, CheckPayScene.BUY));
        r1.add(new StyleAdjustModule(r5));
        r1.add(new QuitPageModule(r5));
        r1.add(new com.bytedance.android.shopping.skubuy.platform.module.a(r5));
        r1.add(new com.bytedance.android.shopping.skubuy.module.d(r5));
        r1.add(new com.bytedance.android.shopping.skubuy.module.a(r5));
        r1.add(new ElevatorGuideModule(r5));
        r1.add(new PopupAdjustModule(r5));
        r1.add(new TopBannerModule(r5));
        r1.add(new com.bytedance.android.shopping.abscontainer.common_biz.module.hybrid_event.f(r5));
        r1.add(new com.bytedance.android.shopping.abscontainer.common_biz.module.hybrid_event.g(r5));
        r1.add(new com.bytedance.android.shopping.abscontainer.common_biz.module.hybrid_event.h(r5));
        r1.add(new com.bytedance.android.shopping.abscontainer.common_biz.module.hybrid_event.i(r5));
        r1.add(new com.bytedance.android.shopping.abscontainer.common_biz.module.hybrid_event.e(r5));
        r1.add(new com.bytedance.android.shopping.abscontainer.common_biz.module.hybrid_event.b(r5));
        r1.add(new com.bytedance.android.shopping.abscontainer.common_biz.platform.module.b(r5));
        r1.add(new com.bytedance.android.shopping.abscontainer.common_biz.module.c(r5));
        r1.add(new CloseSizeAssistantModule(r5));
        r1.add(new com.bytedance.android.shopping.abscontainer.common_biz.module.hybrid_event.c(r5));
        r1.add(new com.bytedance.android.shopping.abscontainer.common_biz.module.hybrid_event.d(r5));
        r1.add(new com.bytedance.android.shopping.abscontainer.common_biz.module.e(r5));
        r1.add(new PerformanceModule(r5));
        r1.add(new CreateOrderModule(r5));
        r1.add(new CheckWhenContinueCloseModule(r5));
        r1.add(new com.bytedance.android.shopping.abscontainer.common_biz.module.hybrid_event.a(r5));
        r1.add(new com.bytedance.android.shopping.abscontainer.common_biz.module.d(r5));
        return new s33.a(r0, r1);
    }
}
