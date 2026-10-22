package com.ss.android.lark.integrator.security.compliance;

import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.ss.android.lark.utils.LarkContext;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes36.dex */
public final class d {
    static {
    }

    public static void a() {
        ConcurrentHashMap<String, Boolean> r100 = com.ss.android.lark.security.compliance.infra.util.c.f440479a;
        Boolean r101 = r100.get("lark.security.screenshot-protection_enabled_doubao");
        if (r101 != null) goto L5;
        boolean r102 = FeatureGatingModule.getFeatureGatingService().isEnable("lark.security.screenshot-protection_enabled_doubao");
        r100.put("lark.security.screenshot-protection_enabled_doubao", Boolean.valueOf(r102));
    L6:
        int r103 = ScsLogger.f440428a;
        ScsLogger.d("FGAction", "executeFG lark.security.screenshot-protection_enabled_doubao, value: " + r102);
        if (r102 == false) goto L9;
        ((com.ss.android.lark.screenprotect.userscope.a) e0c.k.a(LarkContext.getApplication(), com.ss.android.lark.screenprotect.userscope.a.class)).init();
        return;
    L9:
        ScsLogger.d("OfficeSDKScreenProtectModule", "Doubao FG off, skip init");
        return;
    L5:
        r102 = r101.booleanValue();
        goto L6
    }
}
