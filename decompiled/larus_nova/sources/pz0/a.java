package pz0;

import com.bytedance.tools.kcp.aio.runtime.BindsRpc;
import com.bytedance.tools.kcp.aio.runtime.BindsService;
import com.bytedance.tools.kcp.aio.runtime.RpcParam;

/* JADX INFO: loaded from: classes47.dex */
@BindsService(serviceFullName = "webcast.revenue.biz.foundation.ToastService")
public interface a extends f80.a, uh7.a, dy0.c {
    @BindsRpc(rpcName = "ShowIconToast")
    void showIconToast(@RpcParam(paramName = "text") String r100, @RpcParam(paramName = "status") String r101);

    @BindsRpc(rpcName = "ShowImageToast")
    void showImageToast(@RpcParam(paramName = "text") String r100, @RpcParam(paramName = "image") String r101);

    @BindsRpc(rpcName = "ShowPromptToast")
    void showPromptToast(@RpcParam(paramName = "text") String r100);
}
