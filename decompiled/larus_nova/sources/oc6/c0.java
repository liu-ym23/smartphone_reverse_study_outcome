package oc6;

import com.bytedance.tools.kcp.aio.runtime.RpcMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR>\u0010\u0006\u001a\u001e\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0018\u00010\u0002j\u000e\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0018\u0001`\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Loc6/c0;", "", "", "", "Lcom/bytedance/revenue/platform/api/core/UnsafeLong;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "switchGiftIds", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "b", "(Ljava/util/List;)V", "<init>", "()V", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
@RpcMessage(messageName = "webcast.revenue.biz.gift.dialog.top.MostlyUsedGiftSwitchingInfo")
public final class c0 {

    @SerializedName("switching_gift_ids")
    private List<Long> switchGiftIds;

    public c0() {
    }

    public final List<Long> a() {
        return this.switchGiftIds;
    }

    public final void b(List<Long> r100) {
        this.switchGiftIds = r100;
    }
}
