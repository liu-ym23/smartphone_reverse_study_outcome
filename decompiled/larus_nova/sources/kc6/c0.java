package kc6;

import com.bytedance.tools.kcp.aio.runtime.RpcMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lkc6/c0;", "", "", "touchPositionsStr", "Ljava/lang/String;", "getTouchPositionsStr", "()Ljava/lang/String;", "", "needShowDetail", "Ljava/lang/Boolean;", "getNeedShowDetail", "()Ljava/lang/Boolean;", "Lkc6/b0;", "privilegeEntranceInfo", "Lkc6/b0;", "getPrivilegeEntranceInfo", "()Lkc6/b0;", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
@RpcMessage(messageName = "webcast.revenue.biz.gift.kmp.dialog.ProfitTouchPositionInfo")
public final class c0 {

    @SerializedName("need_show_detail")
    private final Boolean needShowDetail;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO)
    private final b0 privilegeEntranceInfo;

    @SerializedName("touch_positions_str")
    private final String touchPositionsStr;

    public c0() {
        Boolean r100 = Boolean.TRUE;
        this.touchPositionsStr = "";
        this.needShowDetail = r100;
        this.privilegeEntranceInfo = null;
    }
}
