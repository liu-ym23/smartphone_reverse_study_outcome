package k11;

import com.bytedance.android.livehostapi.business.depend.share.ShareConstants;
import com.bytedance.tools.kcp.aio.runtime.BindsRpc;
import com.bytedance.tools.kcp.aio.runtime.BindsService;
import com.bytedance.tools.kcp.aio.runtime.RpcParam;

/* JADX INFO: loaded from: classes47.dex */
@BindsService(serviceFullName = "webcast.revenue.biz.revlink.RevlinkExtraService")
public interface h extends uh7.a {
    @BindsRpc(rpcName = "DismissNativePanel")
    void dismissNativePanel(@RpcParam(paramName = ShareConstants.KEY_PANEL_TYPE) int r100);

    @BindsRpc(rpcName = "OpenPanel")
    void openPanel(@RpcParam(paramName = ShareConstants.KEY_PANEL_TYPE) int r100);

    @BindsRpc(rpcName = "ShowTipsOnPkIcon")
    void showTipsOnPkIcon(@RpcParam(paramName = "tip_string") String r100);
}
