package com.bytedance.bdp.bdpplatform.service.image;

import com.bytedance.bdp.bdpbase.manager.BdpManager;
import com.bytedance.bdp.serviceapi.defaults.network.BdpNetworkService;
import com.bytedance.bdp.serviceapi.defaults.ui.model.d;
import com.bytedance.bdp.serviceapi.hostimpl.info.BdpContextService;
import com.bytedance.bdp.serviceapi.hostimpl.ui.BdpImageService;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public class BdpImageServiceImpl implements BdpImageService {
    public BdpImageServiceImpl() {
    }

    public static void E2(BdpImageServiceImpl r100, d r101) {
        r100.getClass();
        ((BdpContextService) BdpManager.getInst().getService(BdpContextService.class)).getHostApplication();
        BdpNetworkService r102 = (BdpNetworkService) BdpManager.getInst().getService(BdpNetworkService.class);
        new HashMap();
        String r103 = r101.f201589a;
        r102.request();     // Catch: Throwable -> L5 Exception -> L7
        throw null;     // Catch: Throwable -> L5 Exception -> L7
    L7:
        return;
    L5:
        th = move-exception;
        throw th;
    }
}
