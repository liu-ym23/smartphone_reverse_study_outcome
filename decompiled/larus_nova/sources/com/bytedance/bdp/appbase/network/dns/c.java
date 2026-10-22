package com.bytedance.bdp.appbase.network.dns;

import com.bytedance.bdp.appbase.network.BdpFromSource;
import com.bytedance.bdp.appbase.network.wrapper.BdpHostCallWrapper;
import com.bytedance.bdp.bdpbase.manager.BdpManager;
import com.bytedance.bdp.serviceapi.defaults.network.BdpNetworkService;

/* JADX INFO: loaded from: classes11.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f200882a = 0;

    static {
    }

    public static void a(String r100, String r101) {
        if (r100 != null) goto L5;
        gb4.c r102 = gb4.c.f480683b;
    L6:
        ((BdpNetworkService) BdpManager.getInst().getService(BdpNetworkService.class)).W0();
        throw null;
    L5:
        gb4.c.a r103 = new gb4.c.a();
        BdpHostCallWrapper.a r104 = BdpHostCallWrapper.f200935e;
        BdpFromSource r105 = BdpFromSource.dns;
        r104.getClass();
        BdpHostCallWrapper.a.a(r103, r100, r105);
        r103.b();
        goto L6
    }
}
