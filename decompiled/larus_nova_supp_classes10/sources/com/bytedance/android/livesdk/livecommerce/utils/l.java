package com.bytedance.android.livesdk.livecommerce.utils;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.ec.model.promotion.ECUIPromotionV2;
import com.google.gson.Gson;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class l {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static ql.a a(ql.a r3) {
        Object r1 = null;
        if ((r3 instanceof ECUIPromotion) == false) goto L10;
        Gson r0 = new Gson();     // Catch: Exception -> L6
        r1 = r0.fromJson(r0.toJson(r3), ECUIPromotion.class);     // Catch: Exception -> L6
    L21:
        return (ql.a) r1;
    L6:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L21
    L10:
        if ((r3 instanceof ECUIPromotionV2) == false) goto L22;
        Gson r2 = new Gson();     // Catch: Exception -> L13
        r1 = r2.fromJson(r2.toJson(r3), ECUIPromotionV2.class);     // Catch: Exception -> L13
    L16:
        return (ql.a) r1;
    L13:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L16
    L22:
        return null;
    }
}
