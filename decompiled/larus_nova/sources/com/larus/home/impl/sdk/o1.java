package com.larus.home.impl.sdk;

import com.larus.enterprise.api.IEnterpriseService;
import com.larus.enterprise.api.IEnterpriseWhiteListService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class o1 implements com.larus.platform.api.m2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o1 f346209a = null;

    static {
        f346209a = new o1();
    }

    public o1() {
    }

    @Override // com.larus.platform.api.m2
    public final q97.a a() {
        IEnterpriseService r100 = (IEnterpriseService) ServiceManager.get().getService(IEnterpriseService.class);
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.a();
    }

    @Override // com.larus.platform.api.m2
    public final boolean b() {
        IEnterpriseService r100 = (IEnterpriseService) ServiceManager.get().getService(IEnterpriseService.class);
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.b() != true) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.larus.platform.api.m2
    public final com.larus.platform.api.n2 c() {
        IEnterpriseWhiteListService r100 = (IEnterpriseWhiteListService) ServiceManager.get().getService(IEnterpriseWhiteListService.class);
        if (r100 == null) goto L5;
        r100.c();
        return b99.a.f18345a;
    L5:
        return null;
    }

    public final void d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        IEnterpriseService r101 = (IEnterpriseService) ServiceManager.get().getService(IEnterpriseService.class);
        if (r101 == null) goto L6;
        r101.c(r100);
        return;
    }
}
