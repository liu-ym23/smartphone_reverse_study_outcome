package mz0;

import com.bytedance.tools.kcp.aio.runtime.BindsRpc;
import com.bytedance.tools.kcp.aio.runtime.BindsService;
import com.bytedance.tools.kcp.aio.runtime.RpcParam;
import com.larksuite.component.card.plugin.ReportCardMonitorPlugin;
import java.util.Map;

/* JADX INFO: loaded from: classes47.dex */
@BindsService(serviceFullName = "webcast.revenue.biz.foundation.TeaLogService")
public interface h extends uh7.a, f80.a, dy0.c {
    @BindsRpc(rpcName = "SendLog")
    void sendLog(@RpcParam(paramName = ReportCardMonitorPlugin.EVENT_NAME) String r100, @RpcParam(paramName = "params") Map<String, String> r101);
}
