package com.larus.dora.impl.util;

import com.bytedance.dora.annotation.ProductNameType;
import com.larus.dora.api.DoraEnableScope;
import com.larus.dora.api.IDoraService;
import com.obric.assistant.common.spi.ObricFeatureServiceDelegate;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;

/* JADX INFO: loaded from: classes4.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f338156a = 0;

    static {
    }

    public static boolean a() {
        if (ObricFeatureServiceDelegate.f387839b.b() == false) goto L6;
        return b(DoraEnableScope.G_SERIES);
    L6:
        return b(DoraEnableScope.G1);
    }

    public static boolean b(DoraEnableScope r100) {
        IDoraService r101 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r101 != null) goto L5;
    L7:
        return false;
    L5:
        if (r101.T0(r100) != true) goto L7;
        return true;
    }

    public static boolean c(Integer r100) {
        int r101 = ProductNameType.DORA_G.f204375id;
        if (r100 == null) goto L9;
        if (r100.intValue() != r101) goto L9;
        DoraEnableScope r102 = DoraEnableScope.G1;
    L12:
        if (r102 != DoraEnableScope.G2) goto L17;
        if (ObricFeatureServiceDelegate.f387839b.b() == true) goto L17;
        return false;
    L17:
        return b(r102);
    L9:
        if (o59.a.m(r100) == false) goto L18;
        r102 = DoraEnableScope.G2;
        goto L12
    L18:
        return false;
    }
}
