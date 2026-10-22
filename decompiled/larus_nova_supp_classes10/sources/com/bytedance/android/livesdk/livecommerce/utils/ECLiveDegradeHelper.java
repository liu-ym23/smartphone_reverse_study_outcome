package com.bytedance.android.livesdk.livecommerce.utils;

import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.sdk.ECSdk;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class ECLiveDegradeHelper {
    public static final Lazy a = null;
    public static final Lazy b = null;
    public static final ECLiveDegradeHelper c = null;

    public ECLiveDegradeHelper() {
    }

    public static ECLiveDegradeConfig b() {
        return (ECLiveDegradeConfig) b.getValue();
    }

    static {
        c = new ECLiveDegradeHelper();
        a = LazyKt.lazy(ECLiveDegradeHelper$enableDynamicDegrade$2.INSTANCE);
        b = LazyKt.lazy(ECLiveDegradeHelper$degradeConfig$2.INSTANCE);
    }

    public static int c() {
        return a("shopping_card_animation_degrade", b().getEnableShoppingCardAnimationDegrade());
    }

    public static int a(String r9, Integer r10) {
        String r0 = "live_ecom_dynamic_".concat(r9);
        int r2 = 0;
        if (((Boolean) a.getValue()).booleanValue() == true) goto L26;
        dm.a.a("LiveDegrade").a("get degrade config of [" + r9 + "]: dynamic degrade is forbidden, return null.");
        Integer r1 = null;
    L13:
        if (r1 != null) goto L28;
        hh2.g r3 = hh2.f.a.a;
        if (r3 == null) goto L20;
        Boolean r4 = r3.d();
        if (r4 == null) goto L20;
        boolean r5 = r4.booleanValue();
    L21:
        if (r5 == false) goto L24;
        if (r10 == null) goto L24;
        r2 = r10.intValue();
    L24:
        dm.a.a("LiveDegrade").a("get degrade config of [" + r9 + "]: " + r2 + " by static.");
        return r2;
    L20:
        r5 = true;
        goto L21
    L28:
        return r1.intValue();
    L26:
        int r6 = ECSdk.a;     // Catch: Exception -> L9
        IAdapterService r7 = (IAdapterService) ECSdk.a(IAdapterService.class);     // Catch: Exception -> L9
        if (r7 == null) goto L7;
        r7.getStrategyService();     // Catch: Exception -> L9
    L7:
        Integer r8 = 0;     // Catch: Exception -> L9
        int r11 = r8.intValue();     // Catch: Exception -> L9
    L11:
        dm.a.a("LiveDegrade").a("get degrade config of [" + r9 + "]: " + r11 + " by dynamic. (dynamic_key: " + r0 + ')');
        r1 = Integer.valueOf(r11);
    L9:
        e = move-exception;
        ECExceptionMonitor.e(e);
        r11 = 0;
        goto L11
    }
}
