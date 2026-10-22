package oa4;

import com.bytedance.bdp.bdpbase.manager.BdpManager;
import com.bytedance.bdp.serviceapi.defaults.thread.BdpThreadService;

/* JADX INFO: loaded from: classes11.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final BdpThreadService f522543a = null;

    static {
        f522543a = (BdpThreadService) BdpManager.getInst().getService(BdpThreadService.class);
    }
}
