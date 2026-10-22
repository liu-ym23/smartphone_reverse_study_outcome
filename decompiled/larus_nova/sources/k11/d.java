package k11;

import com.bytedance.android.livesdk.link.model.IBattlePrecisionMatcher;
import com.bytedance.android.livesdk.link.model.h0;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.tools.kcp.aio.runtime.BindsRpc;
import com.bytedance.tools.kcp.aio.runtime.BindsService;
import com.bytedance.tools.kcp.aio.runtime.RpcParam;

/* JADX INFO: loaded from: classes47.dex */
@BindsService(serviceFullName = "webcast.revenue.biz.revlink.AutoMatchService")
public interface d extends uh7.a {
    @BindsRpc(rpcName = "UpdateAutoMatchPredictWaitTime")
    void updateAutoMatchPredictWaitTime(@RpcParam(paramName = ILiveRoomPlayFragmentConstant.EXTRA_LOG_MATCH_TYPE) long r100, @RpcParam(paramName = "predict_wait_time") long r101, @RpcParam(paramName = "waited_time") long r102, @RpcParam(paramName = "preview_user") h0 r103);

    @BindsRpc(rpcName = "UpdateAutoMatchState")
    void updateAutoMatchState(@RpcParam(paramName = ILiveRoomPlayFragmentConstant.EXTRA_LOG_MATCH_TYPE) long r100, @RpcParam(paramName = "event") int r101);

    @BindsRpc(rpcName = "UpdateMatchBell")
    void updateMatchBell(@RpcParam(paramName = ILiveRoomPlayFragmentConstant.EXTRA_LOG_MATCH_TYPE) long r100, @RpcParam(paramName = "precision_match_id_str") String r101, @RpcParam(paramName = "flex_activity_id") long r102, @RpcParam(paramName = "remain_time") long r103, @RpcParam(paramName = "source") int r104, @RpcParam(paramName = "ownerAnchor") IBattlePrecisionMatcher r105, @RpcParam(paramName = "oppositeAnchor") IBattlePrecisionMatcher r110);
}
