package com.larus.home.impl.sdk;

import com.larus.enterprise.api.IEnterpriseService;
import com.larus.enterprise.api.IEnterpriseWhiteListService;
import com.larus.platform.api.m2;
import com.larus.platform.api.n2;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.jvm.internal.Intrinsics;
import q97.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class o1 implements m2 {
    public static final o1 a = null;

    static {
        a = new o1();
    }

    public o1() {
    }

    @Override // com.larus.platform.api.m2
    public final a a() {
        IEnterpriseService r0 = (IEnterpriseService) ServiceManager.get().getService(IEnterpriseService.class);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a();
    }

    @Override // com.larus.platform.api.m2
    public final boolean b() {
        IEnterpriseService r0 = (IEnterpriseService) ServiceManager.get().getService(IEnterpriseService.class);
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.b() != true) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.larus.platform.api.m2
    public final n2 c() {
        IEnterpriseWhiteListService r0 = (IEnterpriseWhiteListService) ServiceManager.get().getService(IEnterpriseWhiteListService.class);
        if (r0 == null) goto L5;
        r0.c();
        return b99.a.a;
    L5:
        return null;
    }

    public final void d(String r3) {
        Intrinsics.checkNotNullParameter(r3, "scene");
        IEnterpriseService r0 = (IEnterpriseService) ServiceManager.get().getService(IEnterpriseService.class);
        if (r0 == null) goto L6;
        r0.c(r3);
        return;
    }
}
