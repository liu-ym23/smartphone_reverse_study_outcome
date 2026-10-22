package wz0;

import com.bytedance.tools.kcp.aio.runtime.BindsRpc;
import com.bytedance.tools.kcp.aio.runtime.BindsService;
import com.bytedance.tools.kcp.aio.runtime.RpcParam;

/* JADX INFO: loaded from: classes47.dex */
@BindsService(serviceFullName = "webcast.revenue.biz.foundation.StorageService")
public interface c extends uh7.a {
    @BindsRpc(rpcName = "GetStorage")
    a getStorage(@RpcParam(paramName = "key") String r100);

    @BindsRpc(rpcName = "RemoveStorage")
    void removeStorage(@RpcParam(paramName = "key") String r100);

    @BindsRpc(rpcName = "SetStorage")
    void setStorage(@RpcParam(paramName = "key") String r100, @RpcParam(paramName = "value") String r101);
}
