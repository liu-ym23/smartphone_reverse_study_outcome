package com.bytedance.android.livesdk.livecommerce.utils;

import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.sdk.ECSdk;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class n {
    public static Boolean a;

    public static boolean a() {
        String r0 = (String) EComABUtils.getLiveSettingValue("live_low_score_degrade_config", "");
        int r1 = m0.a;     // Catch: Exception -> L5
        q0 r2 = (q0) m0.a.a.fromJson(r0, q0.class);     // Catch: Exception -> L5
    L7:
        if (r2 != null) goto L10;
        r2 = new q0();
    L10:
        if (r2.c() == false) goto L24;
        Double r3 = (Double) EComABUtils.getLiveSettingValue("live_device_model_overall_score", Double.valueOf(0.0d));
        double r4 = r2.b();
        double r5 = r2.a();
        if (r3.doubleValue() > 0) goto L14;
    L18:
        boolean r6 = false;
    L19:
        int r7 = ECSdk.a;
        IAdapterService r8 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r8 == null) goto L22;
        r8.getStrategyService();
    L22:
        if (r6 == false) goto L24;
        return true;
    L14:
        if (r4 > r3.doubleValue()) goto L18;
        if (r3.doubleValue() > r5) goto L18;
        r6 = true;
    L24:
        return false;
    L5:
        e = move-exception;
        ECExceptionMonitor.e(e);
        r2 = new q0();
        goto L7
    }

    public static boolean b() {
        String r0 = (String) EComABUtils.getLiveSettingValue("saas_live_rank_score_degrade_config", "");
        int r1 = m0.a;     // Catch: Exception -> L5
        q0 r2 = (q0) m0.a.a.fromJson(r0, q0.class);     // Catch: Exception -> L5
    L7:
        if (r2 != null) goto L9;
        r2 = new q0();
    L9:
        Double r3 = (Double) EComABUtils.getLiveSettingValue("live_device_model_overall_score", Double.valueOf(0.0d));
        double r4 = r2.b();
        double r5 = r2.a();
        if (r3.doubleValue() > 0) goto L12;
    L16:
        boolean r6 = false;
    L18:
        if (r2.c() == false) goto L21;
        if (r6 == false) goto L21;
        return true;
    L21:
        return false;
    L12:
        if (r4 > r3.doubleValue()) goto L16;
        if (r3.doubleValue() > r5) goto L16;
        r6 = true;
    L5:
        e = move-exception;
        ECExceptionMonitor.e(e);
        r2 = new q0();
        goto L7
    }

    @JvmStatic
    public static final boolean c() {
        Boolean r0 = a;
        if (r0 == null) goto L7;
        return r0.booleanValue();
    L7:
        if (b() == false) goto L10;
    L16:
        boolean r1 = true;
    L19:
        if (com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.t.f == false) goto L21;
        a = Boolean.valueOf(r1);
    L21:
        return r1;
    L10:
        if (a() == true) goto L16;
        Boolean r2 = Boolean.FALSE;
        Boolean r3 = (Boolean) EComABUtils.getLiveSettingValue("ecom_cart_anim_degrade_enable", r2);
        Boolean r4 = (Boolean) EComABUtils.getLiveSettingValue("live_ecom_animation_degrade_strategy_switch", r2);
        if (r3.booleanValue() == true) goto L15;
    L17:
        r1 = false;
        goto L19
    L15:
        if (r4.booleanValue() == false) goto L17;
        goto L16
    }

    static {
    }
}
