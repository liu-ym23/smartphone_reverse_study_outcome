package oc6;

import com.bytedance.tools.kcp.aio.runtime.BindsRpc;
import com.bytedance.tools.kcp.aio.runtime.BindsService;

/* JADX INFO: loaded from: classes19.dex */
@BindsService(serviceFullName = "webcast.revenue.biz.gift.dialog.expansion_controls.RechargeActionUseCase")
public interface z extends uh7.a {
    @BindsRpc(rpcName = "OpenRechargeDialog")
    void openRechargeDialog();
}
