package oc6;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.tools.kcp.aio.runtime.BindsRpc;
import com.bytedance.tools.kcp.aio.runtime.BindsService;
import com.bytedance.tools.kcp.aio.runtime.RpcParam;

/* JADX INFO: loaded from: classes19.dex */
@BindsService(serviceFullName = "webcast.revenue.biz.gift.operation.OperationComboService")
public interface n extends uh7.a {
    @BindsRpc(rpcName = "OnChangeGift")
    void onChangeGift(@RpcParam(paramName = ILiveRoomPlayFragmentConstant.ENTER_LIVE_GITF_ID) long r100);

    @BindsRpc(rpcName = "OnClickCombo")
    void onClickCombo(@RpcParam(paramName = "combo_count") long r100);

    @BindsRpc(rpcName = "TriggerDeviceImpact")
    void triggerDeviceImpact();
}
