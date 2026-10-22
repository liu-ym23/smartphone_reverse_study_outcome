package oc6;

import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.tools.kcp.aio.runtime.RpcMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R*\u0010\u0004\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Loc6/k0;", "", "Lcom/bytedance/android/live/base/model/message/a5;", "Lcom/bytedance/android/live/base/model/message/ITextKt;", "touchPositionsStr", "Lcom/bytedance/android/live/base/model/message/a5;", "getTouchPositionsStr", "()Lcom/bytedance/android/live/base/model/message/a5;", "b", "(Lcom/bytedance/android/live/base/model/message/a5;)V", "", "needShowDetail", "Ljava/lang/String;", "getNeedShowDetail", "()Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "(Ljava/lang/String;)V", "<init>", "()V", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
@RpcMessage(messageName = "webcast.revenue.biz.gift.dialog.top.PrivilegeEntranceInfo")
public final class k0 {

    @SerializedName("panel_url")
    private String needShowDetail;

    @SerializedName("panel_detail")
    private a5 touchPositionsStr;

    public k0() {
    }

    public final void b() {
        this.touchPositionsStr = null;
    }

    public final void a(String r100) {
        this.needShowDetail = r100;
    }
}
