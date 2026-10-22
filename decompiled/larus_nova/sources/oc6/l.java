package oc6;

import com.bytedance.tools.kcp.aio.runtime.BindsRpc;
import com.bytedance.tools.kcp.aio.runtime.BindsService;
import com.bytedance.tools.kcp.aio.runtime.RpcParam;

/* JADX INFO: loaded from: classes19.dex */
@BindsService(serviceFullName = "webcast.revenue.biz.gift.kmp.dialog.GiftAIAgentDialogUseCase")
public interface l extends uh7.a {
    @BindsRpc(rpcName = "GetAllGiftAIAgentDataByDimension")
    i0 getAllGiftAIAgentDataByDimension(@RpcParam(paramName = "dimension_key") String r100);

    @BindsRpc(rpcName = "GetCurrentAISortInfo")
    c getCurrentAISortInfo();

    @BindsRpc(rpcName = "PushSingleGiftAIAgentData")
    i0 pushSingleGiftAIAgentData(@RpcParam(paramName = "dimension_key") String r100, @RpcParam(paramName = "query_id") String r101, @RpcParam(paramName = "data") String r102);

    @BindsRpc(rpcName = "RemoveSingleGiftAIAgentData")
    i0 removeSingleGiftAIAgentData(@RpcParam(paramName = "dimension_key") String r100, @RpcParam(paramName = "query_id") String r101);

    @BindsRpc(rpcName = "UpdateSingleGiftAIAgentData")
    i0 updateSingleGiftAIAgentData(@RpcParam(paramName = "dimension_key") String r100, @RpcParam(paramName = "query_id") String r101, @RpcParam(paramName = "data") String r102);
}
