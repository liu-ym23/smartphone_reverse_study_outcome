package com.bytedance.android.livesdk.livecommerce.promotion.card.utils;

import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    @JvmStatic
    public static final long a() {
        int r2 = com.bytedance.android.ec.core.opt.ab.o.a;     // Catch: Exception -> L9
        Object r3 = 5L;     // Catch: Exception -> L9
        boolean r4 = ECServiceManager.a;     // Catch: Exception -> L9
        Object r5 = ((IAdapterService) ECServiceManager.c(IAdapterService.class)).getLiveSettingsValue("flicker_icon_duration", r3);     // Catch: Exception -> L9
        if (r5 == null) goto L7;
        r3 = r5;
    L7:
        return ((Number) r3).longValue();
    L9:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return 5;
    }

    @JvmStatic
    public static final boolean b() {
        int r0 = com.bytedance.android.ec.core.opt.ab.o.a;     // Catch: Exception -> L8
        Object r1 = Boolean.TRUE;     // Catch: Exception -> L8
        boolean r2 = ECServiceManager.a;     // Catch: Exception -> L8
        Object r3 = ((IAdapterService) ECServiceManager.c(IAdapterService.class)).getLiveSettingsValue("ec_live_limit_quantity_or_time_enable", r1);     // Catch: Exception -> L8
        if (r3 == null) goto L6;
        r1 = r3;
    L6:
        return ((Boolean) r1).booleanValue();
    L8:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return true;
    }

    static {
    }
}
