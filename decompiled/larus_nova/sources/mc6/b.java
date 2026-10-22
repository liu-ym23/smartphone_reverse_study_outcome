package mc6;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.tools.kcp.aio.runtime.BindsRpc;
import com.bytedance.tools.kcp.aio.runtime.BindsService;
import com.bytedance.tools.kcp.aio.runtime.RpcParam;
import kc6.j;

/* JADX INFO: loaded from: classes19.dex */
@BindsService(serviceFullName = "webcast.revenue.biz.gift.GiftDataService")
public interface b extends uh7.a {
    @BindsRpc(rpcName = "CheckGiftResourceReadyById")
    kc6.d checkGiftResourceReadyById(@RpcParam(paramName = ILiveRoomPlayFragmentConstant.ENTER_LIVE_GITF_ID) long r100);

    @BindsRpc(rpcName = "GetGiftById")
    j getGiftById(@RpcParam(paramName = ILiveRoomPlayFragmentConstant.ENTER_LIVE_GITF_ID) long r100);
}
