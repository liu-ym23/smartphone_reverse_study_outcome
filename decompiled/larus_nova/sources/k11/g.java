package k11;

import com.bytedance.tools.kcp.aio.runtime.BindsRpc;
import com.bytedance.tools.kcp.aio.runtime.BindsService;
import com.bytedance.tools.kcp.aio.runtime.RpcParam;
import java.util.Map;

/* JADX INFO: loaded from: classes47.dex */
@BindsService(serviceFullName = "webcast.revenue.biz.revlink.LoadLinkerService")
public interface g extends uh7.a {
    @BindsRpc(rpcName = "LoadLinker")
    void loadLinker(@RpcParam(paramName = "scene") long r100, @RpcParam(paramName = "channel_id") long r101, @RpcParam(paramName = "is_starter") boolean r102, @RpcParam(paramName = "log_info") k r103);

    @BindsRpc(rpcName = "UnloadLinker")
    void unloadLinker(@RpcParam(paramName = "scene") long r100, @RpcParam(paramName = "source") String r101);

    @BindsRpc(rpcName = "UpdateLinkInfo")
    void updateLinkInfo(@RpcParam(paramName = "log_map") Map<String, String> r100, @RpcParam(paramName = "channel_id") long r101, @RpcParam(paramName = "battle_params") Map<String, String> r102);
}
