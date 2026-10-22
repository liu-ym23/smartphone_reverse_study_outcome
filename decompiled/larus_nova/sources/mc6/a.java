package mc6;

import com.bytedance.tools.kcp.aio.runtime.BindsRpc;
import com.bytedance.tools.kcp.aio.runtime.BindsService;
import com.bytedance.tools.kcp.aio.runtime.RpcParam;

/* JADX INFO: loaded from: classes19.dex */
@BindsService(serviceFullName = "webcast.revenue.biz.gift.kmp.dialog.BigGiftComboDialogUseCase")
public interface a extends uh7.a {
    @BindsRpc(rpcName = "ContinueSendGift")
    void continueSendGift(@RpcParam(paramName = "add_combo_num") int r100);

    @BindsRpc(rpcName = "DismissBigGiftComboDialog")
    void dismissBigGiftComboDialog();
}
