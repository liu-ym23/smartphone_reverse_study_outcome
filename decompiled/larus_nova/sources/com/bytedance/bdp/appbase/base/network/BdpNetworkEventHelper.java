package com.bytedance.bdp.appbase.base.network;

import android.app.Application;
import com.bytedance.bdp.appbase.base.bdptask.BdpPool;
import com.bytedance.bdp.bdpbase.manager.BdpManager;
import com.bytedance.bdp.bdpbase.schema.SchemaInfo;
import com.bytedance.bdp.serviceapi.hostimpl.info.BdpContextService;

/* JADX INFO: loaded from: classes11.dex */
public final class BdpNetworkEventHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f200619a = 0;

    public BdpNetworkEventHelper() {
    }

    static {
    }

    public static void b(final com.bytedance.bdp.appbase.core.a r210, final SchemaInfo r211, final String r212, final String r213, final String r214, final String r215, final Integer r216, final String r217, final Integer r218, final String r219, final String r310, final String r311, final String r312, final String r313, final Float r314, final String r315, final Integer r316, final String r317) {
        BdpPool.executeQuickly(new BdpNetworkEventHelper$mpNetworkFailMonitor$1(r210, r211, r317, r213, r212, r214, r215, r216, r217, r218, r219, r310, r311, r312, r313, r314, r315, r316));
    }

    public static void a(final int r210, final int r211, final int r310, final int r311, final int r312, final int r313, final int r314, final int r315, final String r316, final String r317, final String r318, final String r319, final int r410, final String r411, final Throwable r412, final String r413, final Boolean r414, final String r415, final String r416, final String r417) {
        final SchemaInfo r100 = null;
        final int r110 = 0;
        final Boolean r212 = null;
        final Integer r213 = null;
        final String r214 = "";
        final Application r101 = ((BdpContextService) BdpManager.getInst().getService(BdpContextService.class)).getHostApplication();
        BdpPool.executeQuickly(new BdpNetworkEventHelper$mpNetMonitor$2(r316, r101, r412, r410, r411, r100, r317, r318, r319, r413, r210, r211, r310, r311, r312, r313, r314, r110, r315, r414, r212, r415, r416, r213, r417, r214));
    }
}
