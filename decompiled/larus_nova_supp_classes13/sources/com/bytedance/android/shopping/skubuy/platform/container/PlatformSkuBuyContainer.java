package com.bytedance.android.shopping.skubuy.platform.container;

import ai3.i;
import android.app.Dialog;
import android.os.Bundle;
import android.view.Window;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.model.live.LiveClearScreenMode;
import com.bytedance.android.ec.model.live.LiveScreenMoveMode;
import com.bytedance.android.ec.model.live.s;
import com.bytedance.android.shopping.abscontainer.arch.core.lifecycle.LifecycleEnum;
import com.bytedance.android.shopping.abscontainer.arch.core.starter.PageInfo;
import com.bytedance.android.shopping.abscontainer.arch.platform.container.PlatformPanelContainer;
import com.bytedance.android.shopping.abscontainer.common_biz.custom_event.SelfJsBridgeEvent;
import com.bytedance.android.shopping.abscontainer.common_biz.custom_event.a0;
import com.bytedance.android.shopping.abscontainer.common_biz.custom_event.b0;
import com.bytedance.android.shopping.abscontainer.common_biz.custom_event.c0;
import com.bytedance.android.shopping.abscontainer.common_biz.custom_event.d0;
import com.bytedance.android.shopping.abscontainer.common_biz.custom_event.e0;
import com.bytedance.android.shopping.abscontainer.common_biz.custom_event.f;
import com.bytedance.android.shopping.abscontainer.common_biz.custom_event.f0;
import com.bytedance.android.shopping.abscontainer.common_biz.custom_event.g;
import com.bytedance.android.shopping.abscontainer.common_biz.custom_event.g0;
import com.bytedance.android.shopping.abscontainer.common_biz.custom_event.h;
import com.bytedance.android.shopping.abscontainer.common_biz.custom_event.h0;
import com.bytedance.android.shopping.abscontainer.common_biz.custom_event.i0;
import com.bytedance.android.shopping.abscontainer.common_biz.custom_event.j;
import com.bytedance.android.shopping.abscontainer.common_biz.custom_event.j0;
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
import com.bytedance.android.shopping.extensions.k;
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
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
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
import yh3.a;
import yh3.c;
import yh3.d;
import yh3.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/shopping/skubuy/platform/container/PlatformSkuBuyContainer;", "Lcom/bytedance/android/shopping/abscontainer/arch/platform/container/PlatformPanelContainer;", "Lyh3/c;", "Lyh3/a;", "Lcom/bytedance/android/ec/model/live/s;", "<init>", "()V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PlatformSkuBuyContainer extends PlatformPanelContainer<c, a> implements s {
    public p33.a h;

    public final d kR() {
        return new d();
    }

    public final c rf() {
        return new c(0);
    }

    public final Set<Object> jf() {
        b.c();
        return SetsKt.emptySet();
    }

    public PlatformSkuBuyContainer() {
    }

    public final LiveScreenMoveMode AC() {
        return LiveScreenMoveMode.LIVE_SCREEN_MOVE_UP;
    }

    public final LiveClearScreenMode cy() {
        return LiveClearScreenMode.CLEAR_SCREEN_MODE_FULL;
    }

    public final p33.a IU(ConstraintLayout r4) {
        Intrinsics.checkNotNullParameter(r4, "rootView");
        Dialog r1 = getDialog();
        if (r1 == null) goto L5;
        Window r2 = r1.getWindow();
    L6:
        p33.a r5 = new zh3.a(r2, false).a(r4);
        this.h = r5;
        return r5;
    L5:
        r2 = null;
        goto L6
    }

    public final a Jq(PageInfo r15) {
        Intrinsics.checkNotNullParameter(r15, "pageInfo");
        r33.a r2 = new r33.a(r15.getSchemaModel().getQueryParam("source_btm_token"));
        int r0 = i.a;
        String r1 = r15.getSchemaModel().getQueryParam("height_percent");
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        float r3 = k.r(i.a(r15, r1), 73) / 100.0f;
        e r4 = new e(r3, Float.valueOf(0.8f), false);
        List r5 = ECSettingKeys.l0().getExtendFields();
        ConcurrentHashMap r7 = a43.a.a;
        Intrinsics.areEqual(l43.a.a("ec_sku_buy_disable_compress"), 1);
        u33.c r6 = new u33.c(r5);
        v33.b r8 = new v33.b(b.b(false), new v33.a(b.a()));
        u33.b r9 = new u33.b(MapsKt.mapOf(TuplesKt.to("panel_height_percent", String.valueOf((int) (r3 * 100)))));
        String r10 = r15.getSchemaModel().getQueryParam("id");
        if (r10 != null) goto L8;
        r10 = "";
    L8:
        String r11 = r15.getSchemaModel().getQueryParam("sku_session_id");
        if (r11 != null) goto L11;
        String r12 = "";
    L13:
        return new a(r2, r15, r4, r6, r8, r9, r10, r12, false, UUID.randomUUID().toString(), 576);
    L11:
        r12 = r11;
        goto L13
    }

    public final void dY(l33.c r2) {
        Intrinsics.checkNotNullParameter(r2, "platformContainerDelegate");
        Intrinsics.checkNotNullParameter(r2, "platformContainerDelegate");
    }

    public final Set<m33.a<c, a>> gO(l33.b<c, a> r4) {
        Intrinsics.checkNotNullParameter(r4, "containerContext");
        SkuBuyApi r2 = PlatformSkuBuyRepository.a;
        return SetsKt.setOf(new m33.a[]{new h(r4), new n0(r4), new v(r4), new a0(r4), new l0(r4), new n(r4), new com.bytedance.android.shopping.abscontainer.common_biz.custom_event.s(r4), new f(r4), new o0(r4), new g(r4), new s0(r4), new i0(r4), new g0(r4), new p(r4), new t(r4), new c0(r4), new b0(r4), new p0(r4), new j0(r4), new q0(r4), new h0(r4), new r0(r4), new j(r4), new l(r4), new z(r4), new e0(r4), new SelfJsBridgeEvent(r4), new x0(r4), new m(r4), new v0(r4), new k0(r4), new com.bytedance.android.shopping.abscontainer.common_biz.custom_event.a(r4), new u0(r4), new t0(r4), new com.bytedance.android.shopping.abscontainer.common_biz.custom_event.i(r4), new com.bytedance.android.shopping.abscontainer.common_biz.custom_event.d(r4), new f0(r4), new com.bytedance.android.shopping.abscontainer.common_biz.custom_event.c(r4), new r(r4), new u(r4), new com.bytedance.android.shopping.abscontainer.common_biz.custom_event.k(r4), new q(r4), new y(r4), new m0(r4), new d0(r4), new com.bytedance.android.shopping.abscontainer.common_biz.custom_event.e(r4)});
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        if (r2 != null) goto L13;
        setStyle(0, 2131954120);
        return;
    L13:
        dismissAllowingStateLoss();     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r3 = DialogFragmentLancet.sLastShowStack;
        if (r3 == null) goto L15;
        com.bytedance.crash.d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public final i33.c wR(AndroidYaTaInstance r4) {
        Intrinsics.checkNotNullParameter(r4, "yataInstance");
        return new i33.c(new SkuBuyUiAbility(this, this.h, r4));
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
        r1.add(new com.bytedance.android.shopping.abscontainer.common_biz.platform.module.a(r5));
        r1.add(new CheckWhenContinueCloseModule(r5));
        r1.add(new com.bytedance.android.shopping.abscontainer.common_biz.module.hybrid_event.a(r5));
        r1.add(new com.bytedance.android.shopping.abscontainer.common_biz.module.d(r5));
        return new s33.a(r0, r1);
    }

    public final void show(FragmentManager r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "manager");
        if (r2.isStateSaved() == true) goto L13;
        LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(this, r3, r0);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r2, this, r0) == true) goto L14;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L10
    L8:
        super.show(r2, r3);
        return;
    L14:
        return;
    }
}
