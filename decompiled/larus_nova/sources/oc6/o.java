package oc6;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.tools.kcp.aio.runtime.BindsRpc;
import com.bytedance.tools.kcp.aio.runtime.BindsService;
import com.bytedance.tools.kcp.aio.runtime.RpcParam;
import io.reactivex.Observable;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes19.dex */
@BindsService(serviceFullName = "webcast.revenue.biz.gift.dialog.GiftDialogService")
public interface o extends uh7.a {
    @BindsRpc(rpcName = "ChangeDialogHeight")
    void changeDialogHeight(@RpcParam(paramName = "height_change") int r100);

    @BindsRpc(rpcName = "DismissGiftDialog")
    void dismissGiftDialog(@RpcParam(paramName = "source") String r100);

    @BindsRpc(rpcName = "GetLogCommonParams")
    lc6.b getLogCommonParams();

    @BindsRpc(rpcName = "locateGiftByConfig")
    void locateGiftById(@RpcParam(paramName = ILiveRoomPlayFragmentConstant.ENTER_LIVE_GITF_ID) long r100);

    @BindsRpc(rpcName = "ObserveClientAIInfoById")
    Observable<lc6.d> observeClientAIInfoById(@RpcParam(paramName = ILiveRoomPlayFragmentConstant.ENTER_LIVE_GITF_ID) long r100);

    @BindsRpc(rpcName = "ObserveCurrentSelectStatus")
    Observable<lc6.s> observeCurrentSelectStatus();

    @BindsRpc(rpcName = "ObserveSearchVisible")
    Observable<lc6.i> observeSearchVisible();

    @BindsRpc(rpcName = "ObserveSelectedGift")
    Observable<lc6.j> observeSelectedGift();

    @BindsRpc(rpcName = "ObserveSelectedInfo")
    Observable<lc6.k> observeSelectedInfo(i57.a r100, @RpcParam(paramName = "extra_pb_definition") String r101, @RpcParam(paramName = "extra_fq_name") String r102);

    @BindsRpc(rpcName = "ObserveSelectedPage")
    Observable<lc6.l> observeSelectedPageInfo(@RpcParam(paramName = "extra_pb_definition") String r100, @RpcParam(paramName = "extra_fq_name") String r101);

    @BindsRpc(rpcName = "ObserveSmallGiftCombo")
    Observable<lc6.a> observeSmallGiftCombo();

    @BindsRpc(rpcName = "ObserveTopViewVisible")
    Observable<lc6.m> observeTopViewVisible();

    @BindsRpc(rpcName = "RequirePanelGiftList")
    lc6.r requirePanelGiftList(@RpcParam(paramName = "gift_ids") List<Long> r100);

    @BindsRpc(rpcName = "SendGiftSpeedLog")
    void sendGiftSpeedLog(@RpcParam(paramName = "params") Map<String, Double> r100);

    @BindsRpc(rpcName = "SendLog")
    void sendLog(@RpcParam(paramName = ILiveRoomPlayFragmentConstant.EXTRA_REPLAY_LOG_PARAMS) List<lc6.t> r100);
}
