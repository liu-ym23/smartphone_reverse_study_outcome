package oc6;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.tools.kcp.aio.runtime.BindsRpc;
import com.bytedance.tools.kcp.aio.runtime.BindsService;
import com.bytedance.tools.kcp.aio.runtime.RpcParam;

/* JADX INFO: loaded from: classes19.dex */
@BindsService(serviceFullName = "webcast.revenue.biz.gift.dialog.top.MostlyUsedActionUseCase")
public interface w extends uh7.a {
    @BindsRpc(rpcName = "ChangePinMostlyUsedPage")
    void changePinMostlyUsedPage();

    @BindsRpc(rpcName = "ClickEditMostlyUsed")
    void clickEditMostlyUsed(@RpcParam(paramName = ILiveRoomPlayFragmentConstant.ENTER_LIVE_GITF_ID) long r100, @RpcParam(paramName = "page_type") int r101);
}
