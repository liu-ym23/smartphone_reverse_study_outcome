package com.bytedance.android.shopping.buynow.eventcenter.handle;

import android.content.Context;
import com.bytedance.android.ec.hybrid.list.util.ECHybridGsonUtil;
import com.bytedance.android.shopping.buynow.controller.CheckPayStatusController;
import com.bytedance.android.shopping.buynow.data.model.CheckOrderTriggerOrigin;
import com.bytedance.android.shopping.buynow.data.model.CheckPointType;
import com.bytedance.android.shopping.buynow.data.model.CheckStatus;
import com.bytedance.android.shopping.buynow.monitor.param.BuyNowOrderNode;
import com.bytedance.android.shopping.buynow.tracker.BuyNowLog;
import com.bytedance.android.shopping.buynow.viewmodel.BuyNowViewModel;
import com.bytedance.android.shopping.yata.business.function.common.TTPay;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class q extends com.bytedance.kmp.ec.yata.event.common.a {
    public static final /* synthetic */ int g = 0;
    public int a;
    public final List<String> b;
    public final BuyNowViewModel c;
    public final Context d;
    public final CheckPayStatusController e;
    public final pa3.a f;

    public static final class a {
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void c(com.bytedance.kmp.ec.yata.event.core.a r28, Function1 r29) {
        Intrinsics.checkNotNullParameter(r28, "input");
        Intrinsics.checkNotNullParameter(r29, "chainNextCallback");
        BuyNowLog.d("selfPayAndCheck", "selfPayAndCheck starts");
        com.bytedance.android.shopping.buynow.tracker.a r1 = this.c.getTracker();
        r1.getClass();
        r1.b("trade_checkpoint", MapsKt.mapOf(TuplesKt.to("type", CheckPointType.PAY_START)));
        Object r2 = r28.p(Reflection.getOrCreateKotlinClass(Map.class), "check_pay_status_params");
        if ((r2 instanceof Map) == true) goto L5;
        r2 = null;
    L5:
        Map r3 = (Map) r2;
        Object r4 = r28.p(Reflection.getOrCreateKotlinClass(Integer.class), "check_pay_status_times");
        if ((r4 instanceof Integer) == true) goto L8;
        r4 = null;
    L8:
        Integer r5 = (Integer) r4;
        Object r6 = r28.p(Reflection.getOrCreateKotlinClass(List.class), "check_pay_status_times_gaps");
        if ((r6 instanceof List) == true) goto L11;
        r6 = null;
    L11:
        List r7 = (List) r6;
        Object r8 = r28.p(Reflection.getOrCreateKotlinClass(Boolean.class), "skip_sdk");
        if ((r8 instanceof Boolean) == true) goto L14;
        r8 = null;
    L14:
        boolean r9 = com.bytedance.android.shopping.extensions.k.i((Boolean) r8);
        Object r10 = r28.p(Reflection.getOrCreateKotlinClass(Map.class), "pay_params");
        if ((r10 instanceof Map) == true) goto L17;
        r10 = null;
    L17:
        final Map r11 = (Map) r10;
        Object r12 = r28.p(Reflection.getOrCreateKotlinClass(Boolean.class), "pay_with_wechat_or_alipay");
        if ((r12 instanceof Boolean) == true) goto L20;
        r12 = null;
    L20:
        Boolean r13 = (Boolean) r12;
        Object r14 = r28.p(Reflection.getOrCreateKotlinClass(Integer.class), "service");
        if ((r14 instanceof Integer) == true) goto L23;
        r14 = null;
    L23:
        final Integer r15 = (Integer) r14;
        Object r16 = r28.p(Reflection.getOrCreateKotlinClass(Boolean.class), "is_app_pay");
        if ((r16 instanceof Boolean) == true) goto L26;
        r16 = null;
    L26:
        boolean r21 = com.bytedance.android.shopping.extensions.k.i((Boolean) r16);
        Object r17 = r28.p(Reflection.getOrCreateKotlinClass(Boolean.class), "need_show_insufficient_balance_toast");
        if ((r17 instanceof Boolean) == true) goto L29;
        r17 = null;
    L29:
        boolean r22 = com.bytedance.android.shopping.extensions.k.i((Boolean) r17);
        Object r18 = r28.p(Reflection.getOrCreateKotlinClass(Boolean.class), "is_pay_process");
        if ((r18 instanceof Boolean) == true) goto L32;
        r18 = null;
    L32:
        boolean r23 = com.bytedance.android.shopping.extensions.k.i((Boolean) r18);
        Object r19 = r28.p(Reflection.getOrCreateKotlinClass(Boolean.class), "is_quick_pay");
        if ((r19 instanceof Boolean) == true) goto L35;
        r19 = null;
    L35:
        boolean r24 = com.bytedance.android.shopping.extensions.k.i((Boolean) r19);
        Object r110 = r28.p(Reflection.getOrCreateKotlinClass(Integer.class), "pay_type");
        if ((r110 instanceof Integer) == true) goto L38;
        r110 = null;
    L38:
        Integer r111 = (Integer) r110;
        Object r112 = r28.p(Reflection.getOrCreateKotlinClass(Map.class), "order_performance_common_params");
        if ((r112 instanceof Map) == true) goto L41;
        r112 = null;
    L41:
        Map r113 = (Map) r112;
        if (r113 == null) goto L44;
        Object r114 = r113.get("order_type");
    L46:
        if ((r114 instanceof String) == true) goto L48;
        r114 = null;
    L48:
        String r115 = com.bytedance.android.shopping.extensions.k.j((String) r114);
        if (r113 == null) goto L51;
        Object r116 = r113.get("pay_type");
    L53:
        if (r113 == null) goto L55;
        Object r117 = r113.get("involved_pay");
    L56:
        pa3.a r20 = this.f;
        if (r20 == null) goto L61;
        com.bytedance.android.shopping.buynow.monitor.order.a r25 = r20.b;
        if (r25 == null) goto L61;
        r25.c("pay_type", r116);
        r25.c("involved_pay", r117);
        r25.c("order_type", r115);
    L61:
        this.c.updateCheckStatus(CheckStatus.TTPAY);
        this.e.c = false;
        if (r5 == null) goto L64;
        int r26 = r5.intValue();
    L65:
        final b r27 = new b(r3, r26, r7);
        if (r9 == false) goto L69;
        BuyNowLog.d("selfPayAndCheck", "returned because skipSDK == true");
        d(r27, this.a, this.c.getCheckStatus(), r11, Boolean.valueOf(r21), CheckOrderTriggerOrigin.ORDER_SUCCESS);
        return;
    L69:
        Boolean r30 = Boolean.FALSE;
        if (Intrinsics.areEqual(r13, r30) == true) goto L72;
    L76:
        if (r11 != 0) goto L94;
    L92:
        BuyNowLog.d("selfPayAndCheck", "pay_params is null");
        com.bytedance.android.shopping.buynow.monitor.error.a.e(this.c.getTracker(), "selfPayAndCheck", "pay_params is null", r28);
        return;
    L94:
    L82:
        BuyNowLog.d("selfPayAndCheck", "error transforming payParams to JSONObject");
        com.bytedance.android.shopping.buynow.monitor.error.a.e(this.c.getTracker(), "selfPayAndCheck", "error when transform yata fields to JSON", r28);
        JSONObject r118 = null;
    L83:
        if (r118 == null) goto L92;
        BuyNowViewModel r0 = this.c;
        r0.setCurCheckParams(new com.bytedance.android.shopping.buynow.eventcenter.handle.a(r27, this.a, r111, r0.getCheckStatus(), r11, r13, Boolean.valueOf(r21)));
        pa3.a r31 = this.f;
        if (r31 == null) goto L90;
        com.bytedance.android.shopping.buynow.monitor.order.a r32 = r31.b;
        if (r32 == null) goto L90;
        r32.a(BuyNowOrderNode.ORDER_TTPAY_CALL_START, System.currentTimeMillis());
    L90:
        final Boolean r33 = Boolean.valueOf(r21);
        final Boolean r34 = Boolean.valueOf(r22);
        final Boolean r35 = Boolean.valueOf(r23);
        final Boolean r36 = Boolean.valueOf(r24);
        BuyNowLog.d("selfPayAndCheck", "ttPay starts");
        com.bytedance.android.shopping.buynow.tracker.a r37 = this.c.getTracker();
        r37.getClass();
        r37.b("wallet_cashier_ds_by_sdk_yata", MapsKt.mapOf(new Pair[]{TuplesKt.to("payParams", r11), TuplesKt.to("service", r11.get("service"))}));
        int r38 = TTPay.a;
        TTPay.a(this.d, r118, new SelfPayAndCheckFunction$realPay$1(this, r15, r36, r34, r35, r27, r11, r33));
        BuyNowLog.d("selfPayAndCheck", "selfPayAndCheck finishes");
        int r39 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r29.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7));
        return;
    L78:
        if ((r11 instanceof String) == false) goto L80;
        JSONObject r40 = new JSONObject((String) r11);     // Catch: Exception -> L82
    L81:
        r118 = r40;
        goto L83
    L80:
        r40 = tv5.a.a(ECHybridGsonUtil.a(), r11);     // Catch: Exception -> L82
        goto L81
    L72:
        if (Intrinsics.areEqual(this.c.isNoPwdCombined(), r30) == false) goto L76;
        ia3.b r41 = this.e.g;
        if (r41 == null) goto L76;
        r41.c();
        goto L76
    L64:
        r26 = 3;
        goto L65
    L55:
        r117 = null;
        goto L56
    L51:
        r116 = null;
        goto L53
    L44:
        r114 = null;
        goto L46
    }

    public q(BuyNowViewModel r2, Context r3, CheckPayStatusController r4, pa3.a r5) {
        Intrinsics.checkNotNullParameter(r2, "viewModel");
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "checkPayStatusController");
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.f = r5;
        this.b = CollectionsKt.listOf(new String[]{CheckStatus.CHECKING, "success", CheckStatus.FAIL});
    }

    public final void d(b r3, int r4, String r5, Map<String, ? extends Object> r6, Boolean r7, String r8) {
        BuyNowLog.d("selfPayAndCheck", "check starts");
        if (this.b.contains(this.c.getCheckStatus()) == false) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(r7, Boolean.TRUE) == false) goto L7;
    L8:
        this.e.b(r3, r4, r5, r6);
        this.c.getTracker().f(r8);
        return;
    L7:
        if (r4 == 119) goto L8;
    }
}
