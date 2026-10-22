package kc6;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.tools.kcp.aio.runtime.RpcMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0087\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\fR&\u0010\u000f\u001a\u00060\rj\u0002`\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lkc6/s;", "", "", "tabPosition", "I", "b", "()I", "giftPosition", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "tabType", "getTabType", "setTabType", "(I)V", "", "Lcom/bytedance/revenue/platform/api/core/UnsafeLong;", "giftId", "J", "getGiftId", "()J", "setGiftId", "(J)V", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
@RpcMessage(messageName = "webcast.revenue.biz.gift.kmp.dialog.GiftPositionInfo")
public final class s {

    @SerializedName(ILiveRoomPlayFragmentConstant.ENTER_LIVE_GITF_ID)
    private long giftId;

    @SerializedName("gift_position")
    private final int giftPosition;

    @SerializedName("tab_position")
    private final int tabPosition;

    @SerializedName("tab_type")
    private int tabType;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof s) == false) goto L14;
        s r101 = (s) r100;
        if (this.tabPosition == r101.tabPosition) goto L8;
        return false;
    L8:
        if (this.giftPosition == r101.giftPosition) goto L10;
        return false;
    L10:
        if (this.tabType == r101.tabType) goto L12;
        return false;
    L12:
        if (this.giftId == r101.giftId) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        int r100 = ((((this.tabPosition * 31) + this.giftPosition) * 31) + this.tabType) * 31;
        long r101 = this.giftId;
        return r100 + ((int) (r101 ^ (r101 >>> 32)));
    }

    public final String toString() {
        return "GiftPositionInfo(tabPosition=" + this.tabPosition + ", giftPosition=" + this.giftPosition + ", tabType=" + this.tabType + ", giftId=" + this.giftId + ")";
    }

    public final int a() {
        return this.giftPosition;
    }

    public final int b() {
        return this.tabPosition;
    }

    public /* synthetic */ s(int r100, int r101) {
        this(r100, r101, 0, 0);
    }

    public s(int r100, int r101, int r102, long r103) {
        this.tabPosition = r100;
        this.giftPosition = r101;
        this.tabType = r102;
        this.giftId = r103;
    }
}
