package j12;

import com.bytedance.tools.kcp.aio.runtime.BindsRpc;
import com.bytedance.tools.kcp.aio.runtime.BindsService;
import com.bytedance.tools.kcp.aio.runtime.RpcParam;

/* JADX INFO: loaded from: classes9.dex */
@BindsService(serviceFullName = "webcast.revenue.biz.gift.GiftReceiverActionUseCase")
public interface a extends uh7.a {
    @BindsRpc(rpcName = "SelectReceiver")
    void selectReceiver(@RpcParam(paramName = "receiver_id") String r100);
}
