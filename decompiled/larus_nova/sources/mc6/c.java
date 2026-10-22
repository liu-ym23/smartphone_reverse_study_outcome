package mc6;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.tools.kcp.aio.runtime.BindsRpc;
import com.bytedance.tools.kcp.aio.runtime.BindsService;
import com.bytedance.tools.kcp.aio.runtime.RpcParam;
import kc6.g0;
import kc6.n;

/* JADX INFO: loaded from: classes19.dex */
@BindsService(serviceFullName = "webcast.revenue.biz.gift.kmp.dialog.GiftDialogActionUseCase")
public interface c extends uh7.a {
    @BindsRpc(rpcName = "ChangeTab")
    void changeTab(@RpcParam(paramName = "tab_position") int r100);

    @BindsRpc(rpcName = "ComboCountDownFinish")
    void comboCountDownFinish();

    @BindsRpc(rpcName = "ContinueSendGiftOnDialog")
    void continueSendGiftOnDialog(@RpcParam(paramName = "tab_position") int r100, @RpcParam(paramName = "gift_position") int r101, @RpcParam(paramName = "add_combo_num") int r102, @RpcParam(paramName = ILiveRoomPlayFragmentConstant.ENTER_LIVE_GITF_ID) long r103, @RpcParam(paramName = "group_count") int r104, @RpcParam(paramName = "buff_level") int r105, @RpcParam(paramName = "diy_card_info") n r106, @RpcParam(paramName = "prop_params") g0 r107);

    @BindsRpc(rpcName = "DismissGiftDialog")
    void dismissGiftDialog(@RpcParam(paramName = "source") String r100);

    @BindsRpc(rpcName = "EndScrollGiftPanel")
    void endScrollGiftPanel(@RpcParam(paramName = "start_line") int r100, @RpcParam(paramName = "end_line") int r101);

    @BindsRpc(rpcName = "FocusOnGiftDialog")
    void focusOnGiftDialog();

    @BindsRpc(rpcName = "SelectGift")
    void selectGift(@RpcParam(paramName = "tab_position") int r100, @RpcParam(paramName = "gift_position") int r101, @RpcParam(paramName = ILiveRoomPlayFragmentConstant.ENTER_LIVE_GITF_ID) long r102);

    @BindsRpc(rpcName = "StartScrollGiftPanel")
    void startScrollGiftPanel(@RpcParam(paramName = "start_line") int r100, @RpcParam(paramName = "end_line") int r101);

    @BindsRpc(rpcName = "StartSendGiftOnDialog")
    void startSendGiftOnDialog(@RpcParam(paramName = "tab_position") int r100, @RpcParam(paramName = "gift_position") int r101, @RpcParam(paramName = ILiveRoomPlayFragmentConstant.ENTER_LIVE_GITF_ID) long r102, @RpcParam(paramName = "buff_level") int r103, @RpcParam(paramName = "group_count") int r104, @RpcParam(paramName = "diy_card_info") n r105, @RpcParam(paramName = "prop_params") g0 r106);
}
