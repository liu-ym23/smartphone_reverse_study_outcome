package com.larus.home.impl.sdk;

import com.larus.account.base.api.ILoginService;
import com.larus.appsflyer.api.IAppsflyerService;
import com.larus.common.apphost.AppHost;
import com.larus.facebook.api.IFacebookSdkService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;

/* JADX INFO: loaded from: classes4.dex */
public final class u2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u2 f346250a = null;

    static {
        f346250a = new u2();
    }

    public u2() {
    }

    public final String a() {
        int r100 = com.larus.home.impl.utils.n.f346353a;
        String r101 = null;
        if (ILoginService.f286097a.getAccountInfo().f531528a == false) goto L22;
        IFacebookSdkService r102 = (IFacebookSdkService) ServiceManager.get().getService(IFacebookSdkService.class);
        if (r102 == null) goto L7;
        String r103 = r102.a();
    L8:
        boolean r104 = false;
        if (r103 != null) goto L11;
    L16:
        if (r104 == true) goto L23;
        IAppsflyerService r105 = (IAppsflyerService) ServiceManager.get().getService(IAppsflyerService.class);
        if (r105 == null) goto L22;
        r101 = r105.a();
        goto L22
    L23:
        return r103;
    L11:
        if (r103.length() <= 0) goto L13;
        boolean r106 = true;
    L14:
        if (r106 != true) goto L16;
        r104 = true;
        goto L16
    L13:
        r106 = false;
        goto L14
    L7:
        r103 = null;
    L22:
        return r101;
    }

    public final void b() {
        AppHost.f326268a.isOversea();
    }
}
