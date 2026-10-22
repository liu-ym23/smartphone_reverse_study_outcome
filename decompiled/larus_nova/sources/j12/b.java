package j12;

import com.bytedance.tools.kcp.aio.runtime.BindsRpc;
import com.bytedance.tools.kcp.aio.runtime.BindsService;
import com.bytedance.tools.kcp.aio.runtime.RpcParam;
import java.util.Map;

/* JADX INFO: loaded from: classes9.dex */
@BindsService(serviceFullName = "webcast.revenue.biz.gift.dialog.tab.GiftTabActionUseCase")
public interface b extends uh7.a {
    @BindsRpc(rpcName = "ClickTab")
    void clickTab(@RpcParam(paramName = "tab_index") int r100, @RpcParam(paramName = "tab_type") int r101, @RpcParam(paramName = "log_extra") Map<String, String> r102, @RpcParam(paramName = "order_rule") int r103, @RpcParam(paramName = "related_topic_id") long r104);
}
