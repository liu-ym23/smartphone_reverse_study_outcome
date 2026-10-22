package com.larus.office.plugins.input;

import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class l1 {
    public static final k1 a(ChameleonPluginHost r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        com.larus.office.h r101 = (com.larus.office.h) r100.getHostAbilityOrNull(com.larus.office.h.class);
        if (r101 == null) goto L5;
        com.larus.office.a r102 = r101.Ff();
    L7:
        if ((r102 instanceof k1) == false) goto L9;
        k1 r103 = (k1) r102;
    L10:
        if (r103 != null) goto L15;
        OfficeAIChatContractProviderPlugin r104 = (OfficeAIChatContractProviderPlugin) r100.findPlugin(OfficeAIChatContractProviderPlugin.class);
        if (r104 != null) goto L17;
        return null;
    L17:
        return r104.getContractProvider$impl_mainlandRelease();
    L15:
        return r103;
    L9:
        r103 = null;
        goto L10
    L5:
        r102 = null;
        goto L7
    }
}
