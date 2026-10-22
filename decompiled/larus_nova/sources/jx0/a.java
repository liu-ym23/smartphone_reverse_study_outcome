package jx0;

import com.bytedance.tools.kcp.aio.runtime.BindsRpc;
import com.bytedance.tools.kcp.aio.runtime.BindsService;

/* JADX INFO: loaded from: classes47.dex */
@BindsService(serviceFullName = "webcast.revenue.biz.recharge.trace.RechargePanelSessionService")
public interface a extends uh7.a {
    @BindsRpc(rpcName = "ReportEvent")
    void reportEvent(c r100);
}
