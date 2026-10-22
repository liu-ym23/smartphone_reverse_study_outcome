package nv6;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\rR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006¨\u0006\u000e"}, d2 = {"Lnv6/q;", "", "", "switchCardOperateType", "Ljava/lang/Integer;", "c", "()Ljava/lang/Integer;", "", "sendMsgTimestamp", "Ljava/lang/Long;", "b", "()Ljava/lang/Long;", "cancelRequestType", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final class q {

    @SerializedName("cancel_request_type")
    private final Integer cancelRequestType;

    @SerializedName("send_msg_timestamp")
    private final Long sendMsgTimestamp;

    @SerializedName("switch_card_operate_type")
    private final Integer switchCardOperateType;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof q) == true) goto L8;
        return false;
    L8:
        q r101 = (q) r100;
        if (Intrinsics.areEqual(this.switchCardOperateType, r101.switchCardOperateType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.sendMsgTimestamp, r101.sendMsgTimestamp) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.cancelRequestType, r101.cancelRequestType) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.switchCardOperateType;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Long r104 = this.sendMsgTimestamp;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.cancelRequestType;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "GroupPurchaseCardSwitchStrategy(switchCardOperateType=" + this.switchCardOperateType + ", sendMsgTimestamp=" + this.sendMsgTimestamp + ", cancelRequestType=" + this.cancelRequestType + ')';
    }

    public q() {
        this.switchCardOperateType = null;
        this.sendMsgTimestamp = null;
        this.cancelRequestType = null;
    }

    public final Integer a() {
        return this.cancelRequestType;
    }

    public final Long b() {
        return this.sendMsgTimestamp;
    }

    public final Integer c() {
        return this.switchCardOperateType;
    }
}
