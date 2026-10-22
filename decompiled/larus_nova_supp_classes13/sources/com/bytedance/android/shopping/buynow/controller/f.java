package com.bytedance.android.shopping.buynow.controller;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.shopping.anchorv3.utils.a0;
import com.bytedance.android.shopping.buynow.container.BuyNowFragment;
import com.bytedance.android.shopping.buynow.data.model.PageType;
import com.bytedance.android.shopping.buynow.viewmodel.BuyNowViewModel;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class f {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean d(AndroidYaTaInstance r11) {
        Object r0 = null;
        if (r11 == null) goto L5;
        Object r1 = r11.i("side_slip");
    L7:
        if ((r1 instanceof Map) == true) goto L9;
        r1 = null;
    L9:
        Map r2 = (Map) r1;
        if (r2 == null) goto L12;
        Object r3 = r2.get("target_component_name");
    L14:
        if ((r3 instanceof String) == true) goto L16;
        r3 = null;
    L16:
        String r4 = (String) r3;
        if (r2 == null) goto L19;
        Object r5 = r2.get("target_yata_key");
    L21:
        if ((r5 instanceof String) == true) goto L23;
        r5 = null;
    L23:
        String r6 = (String) r5;
        if (r2 == null) goto L26;
        Object r7 = r2.get("quit_event_name");
    L28:
        if ((r7 instanceof String) == false) goto L31;
        r0 = r7;
    L31:
        String r8 = (String) r0;
        if (r4 == null) goto L41;
        if (r6 == null) goto L41;
        if (r8 == null) goto L41;
        com.bytedance.kmp.ec.yata.store.node.c r9 = com.bytedance.android.shopping.buynow.utils.h.a(r11, r4, r6);
        if (r9 != null) goto L39;
        return false;
    L39:
        r11.k().d(com.bytedance.kmp.ec.yata.event.common.e.a.a(r11, null, r9.getKey(), r8, null, "onBackKeyPressed"));
        return true;
    L41:
        return false;
    L26:
        r7 = null;
        goto L28
    L19:
        r5 = null;
        goto L21
    L12:
        r3 = null;
        goto L14
    L5:
        r1 = null;
        goto L7
    }

    public static void a(Context r2, BuyNowFragment r3) {
        Intrinsics.checkNotNullParameter(r3, "fragment");
        boolean r0 = r2 instanceof com.bytedance.android.shopping.buynow.container.o;
        Fragment r1 = null;
        Object r4 = r2;
        if (r0 == true) goto L5;
        r4 = null;
    L5:
        com.bytedance.android.shopping.buynow.container.o r5 = (com.bytedance.android.shopping.buynow.container.o) r4;
        if (r5 != null) goto L12;
        Fragment r6 = r3.getParentFragment();
        if ((r6 instanceof com.bytedance.android.shopping.buynow.container.o) == false) goto L11;
        r1 = r6;
    L11:
        r5 = (com.bytedance.android.shopping.buynow.container.o) r1;
    L12:
        if (r5 == null) goto L14;
        r5.close();
        return;
    L14:
        com.bytedance.android.shopping.buynow.monitor.error.a.b(r3.W90().getTracker(), "runtime_error", "context and parentFragment is not IBuyNowContainer");
    }

    public static void c(BuyNowViewModel r14, String r15) {
        Intrinsics.checkNotNullParameter(r14, "viewModel");
        Intrinsics.checkNotNullParameter(r15, "closeMethod");
        long r0 = r14.getStaticState().e;
        Pair[] r2 = new Pair[6];
        a0 r3 = a0.a;
        r2[0] = TuplesKt.to("page_hidden", Integer.valueOf(com.bytedance.android.shopping.extensions.k.q(Boolean.FALSE)));
        r2[1] = TuplesKt.to("return_method", r15);
        r2[2] = TuplesKt.to("startup_status", r14.getPageStartupStatus());
        r2[3] = TuplesKt.to("popup_codes", CollectionsKt.joinToString$default(r14.getCurrentShownPopupCodes(), ",", null, null, 0, null, null, 62, null));
        r2[4] = TuplesKt.to("duration", Long.valueOf(System.currentTimeMillis() - r0));
        Long r16 = r14.getAsyncTwoStageController().e;
        if (r16 == null) goto L5;
        long r1 = r16.longValue();
    L6:
        r2[5] = TuplesKt.to("stage2_delay", Long.valueOf(r1));
        Map<String, ? extends Object> r17 = MapsKt.mapOf(r2);
        com.bytedance.android.shopping.buynow.tracker.a r4 = r14.getTracker();
        r4.getClass();
        Intrinsics.checkNotNullParameter(r17, "params");
        r4.c("order_submit_return", r17);
        if (r4.h.getStaticState().b() == false) goto L10;
        r4.c("wallet_cashier_back_click", MapsKt.emptyMap());
    L10:
        if (r14.isPageLoading() == false) goto L15;
        com.bytedance.android.shopping.buynow.tracker.a r18 = r14.getTracker();
        int r5 = com.bytedance.android.shopping.buynow.monitor.error.b.a;
        if (r18 == null) goto L15;
        r18.b("buynow_error_monitor", MapsKt.mapOf(TuplesKt.to("type", "close_with_loading")));
    L15:
        if (r14.getHasReportDismiss() == true) goto L27;
        r14.setHasReportDismiss(true);
        String r6 = null;
        if ((!Intrinsics.areEqual(r14.getStaticState().g, PageType.CONTINUEPAY)) == false) goto L22;
        JSONObject r19 = new JSONObject();
        nl.c r7 = r14.getStaticState().a;
        if (r7 == null) goto L21;
        r6 = r7.getQueryParam("pre_session_id");
    L21:
        KtSafeMethodExtensionKt.safePut(r19, "pre_session_id", r6);
        KtSafeMethodExtensionKt.safePut(r19, "buynow_session_id", r14.getStaticState().b);
        KtSafeMethodExtensionKt.safePut(r19, "page_scene", Integer.valueOf(!Intrinsics.areEqual(r14.getStaticState().g, PageType.BUYNOW) ? 1 : 0));
        Unit r110 = Unit.INSTANCE;
        ECLiveHybridUtil.f("ecom.buynow.dismiss", r19);
        return;
    L22:
        JSONObject r111 = new JSONObject();
        nl.c r8 = r14.getStaticState().a;
        if (r8 == null) goto L25;
        r6 = r8.getQueryParam("pre_session_id");
    L25:
        KtSafeMethodExtensionKt.safePut(r111, "pre_session_id", r6);
        KtSafeMethodExtensionKt.safePut(r111, "buynow_session_id", r14.getStaticState().b);
        KtSafeMethodExtensionKt.safePut(r111, "has_check", Boolean.valueOf(r14.getHasCheck()));
        Unit r112 = Unit.INSTANCE;
        ECLiveHybridUtil.f("ecom.continue_pay.dismiss", r111);
        return;
    L27:
        return;
    L5:
        r1 = 0;
        goto L6
    }

    @JvmStatic
    public static final void b(Context r1, String r2, BuyNowFragment r3) {
        Intrinsics.checkNotNullParameter(r2, "closeMethod");
        Intrinsics.checkNotNullParameter(r3, "fragment");
        c(r3.W90(), r2);
        a(r1, r3);
    }
}
