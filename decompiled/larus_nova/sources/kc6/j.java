package kc6;

import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.tools.kcp.aio.runtime.RpcMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lkc6/j;", "", "Lcom/bytedance/android/livesdk/gift/model/h1;", PbRequest.SwitchType.GIFT, "Lcom/bytedance/android/livesdk/gift/model/h1;", "getGift", "()Lcom/bytedance/android/livesdk/gift/model/h1;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "(Lcom/bytedance/android/livesdk/gift/model/h1;)V", "<init>", "()V", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
@RpcMessage(messageName = "webcast.revenue.biz.gift.GetGiftByIdResponse")
public final class j {

    @SerializedName(PbRequest.SwitchType.GIFT)
    private h1 gift;

    public j() {
    }

    public final void a(h1 r100) {
        this.gift = r100;
    }
}
