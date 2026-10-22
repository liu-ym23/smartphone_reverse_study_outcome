package kc6;

import com.bytedance.tools.kcp.aio.runtime.RpcMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\t\u001a\u00060\u0007j\u0002`\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lkc6/e0;", "", "Lpy/l;", "diamondImage", "Lpy/l;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lpy/l;", "", "Lcom/bytedance/revenue/platform/api/core/UnsafeLong;", "availableDiamonds", "J", "getAvailableDiamonds", "()J", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
@RpcMessage(messageName = "webcast.revenue.biz.gift.kmp.dialog.RechargeIconInfo")
public final class e0 {

    @SerializedName("available_diamonds")
    private final long availableDiamonds;

    @SerializedName("diamond_image")
    private final py.l diamondImage;

    public final py.l a() {
        return this.diamondImage;
    }

    public e0(py.l r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "diamondImage");
        this.diamondImage = r100;
        this.availableDiamonds = r101;
    }
}
