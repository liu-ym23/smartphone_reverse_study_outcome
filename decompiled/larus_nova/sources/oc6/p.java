package oc6;

import com.bytedance.tools.kcp.aio.runtime.BindsRpc;
import com.bytedance.tools.kcp.aio.runtime.BindsService;
import com.bytedance.tools.kcp.aio.runtime.RpcParam;
import com.larksuite.component.card.plugin.ReportCardMonitorPlugin;
import java.util.Map;

/* JADX INFO: loaded from: classes19.dex */
@BindsService(serviceFullName = "webcast.revenue.biz.gift.dialog.top.GiftGroupCardActionUseCase")
public interface p extends uh7.a {
    @BindsRpc(rpcName = "SelectGroupCard")
    void selectGroupCard(@RpcParam(paramName = "group_count") int r100, @RpcParam(paramName = "group_text") String r101, @RpcParam(paramName = "select_gift_id") long r102);

    @BindsRpc(rpcName = "sendLog")
    void sendLog(@RpcParam(paramName = ReportCardMonitorPlugin.EVENT_NAME) String r100, @RpcParam(paramName = "params") Map<String, String> r101);
}
