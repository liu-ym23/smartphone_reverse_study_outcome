package oa4;

import com.bytedance.bdp.bdpbase.manager.BdpManager;
import com.bytedance.bdp.serviceapi.defaults.platform.BdpPlatformService;

/* JADX INFO: loaded from: classes11.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final BdpPlatformService f522542a = null;

    static {
        f522542a = (BdpPlatformService) BdpManager.getInst().getService(BdpPlatformService.class);
    }
}
