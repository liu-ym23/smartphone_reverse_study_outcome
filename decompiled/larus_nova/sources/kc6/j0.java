package kc6;

import com.bytedance.tools.kcp.aio.runtime.RpcMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fR2\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lkc6/j0;", "", "", "Lcom/bytedance/android/livesdk/gift/model/g0;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "extras", "Ljava/util/List;", "getExtras", "()Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "(Ljava/util/List;)V", "<init>", "()V", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
@RpcMessage(messageName = "webcast.revenue.biz.gift.UpdateGiftExtraResponse")
public final class j0 {

    @SerializedName("extras")
    private List<? extends com.bytedance.android.livesdk.gift.model.g0> extras;

    public j0() {
        this.extras = com.bytedance.revenue.platform.api.core.c.a(new com.bytedance.android.livesdk.gift.model.g0[0]);
    }

    public final void a(List<? extends com.bytedance.android.livesdk.gift.model.g0> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.extras = r100;
    }
}
