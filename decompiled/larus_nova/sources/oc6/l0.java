package oc6;

import com.bytedance.tools.kcp.aio.runtime.RpcMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u0018R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Loc6/l0;", "", "", "touchPositionsStr", "Ljava/lang/String;", "getTouchPositionsStr", "()Ljava/lang/String;", "c", "(Ljava/lang/String;)V", "", "needShowDetail", "Ljava/lang/Boolean;", "getNeedShowDetail", "()Ljava/lang/Boolean;", "b", "(Ljava/lang/Boolean;)V", "Loc6/k0;", "entranceInfo", "Loc6/k0;", "getEntranceInfo", "()Loc6/k0;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "(Loc6/k0;)V", "<init>", "()V", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
@RpcMessage(messageName = "webcast.revenue.biz.gift.dialog.top.ProfitTouchPositionInfo")
public final class l0 {

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO)
    private k0 entranceInfo;

    @SerializedName("need_show_detail")
    private Boolean needShowDetail;

    @SerializedName("touch_positions_str")
    private String touchPositionsStr;

    public l0() {
        this.needShowDetail = Boolean.FALSE;
    }

    public final void a(k0 r100) {
        this.entranceInfo = r100;
    }

    public final void b(Boolean r100) {
        this.needShowDetail = r100;
    }

    public final void c(String r100) {
        this.touchPositionsStr = r100;
    }
}
