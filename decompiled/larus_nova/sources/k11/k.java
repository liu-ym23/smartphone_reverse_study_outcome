package k11;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.tools.kcp.aio.runtime.RpcMessage;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u001a\u0010\u0010\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\rR6\u0010\u0014\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u0012j\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t`\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lk11/k;", "", "", "inviteType", "J", "getInviteType", "()J", "matchType", "getMatchType", "", "inviteeList", "Ljava/lang/String;", "getInviteeList", "()Ljava/lang/String;", "requestId", "getRequestId", "flexActivityId", "getFlexActivityId", "", "Lcom/bytedance/revenue/platform/api/core/KmpMap;", "logMap", "Ljava/util/Map;", "getLogMap", "()Ljava/util/Map;", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
@RpcMessage(messageName = "webcast.revenue.biz.revlink.LinkerLogInfo")
public final class k {

    @SerializedName("flex_activity_id")
    private final String flexActivityId;

    @SerializedName("invite_type")
    private final long inviteType;

    @SerializedName("invitee_list")
    private final String inviteeList;

    @SerializedName("log_map")
    private final Map<String, String> logMap;

    @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_LOG_MATCH_TYPE)
    private final long matchType;

    @SerializedName("request_id")
    private final String requestId;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof k) == false) goto L18;
        k r101 = (k) r100;
        if (this.inviteType == r101.inviteType) goto L8;
        return false;
    L8:
        if (this.matchType == r101.matchType) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.inviteeList, r101.inviteeList) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.requestId, r101.requestId) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.flexActivityId, r101.flexActivityId) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.logMap, r101.logMap) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        long r100 = this.inviteType;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.matchType;
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        String r104 = this.inviteeList;
        int r105 = 0;
        if (r104 == null) goto L5;
        int r106 = r104.hashCode();
    L6:
        int r107 = (r103 + r106) * 31;
        String r108 = this.requestId;
        if (r108 == null) goto L9;
        int r109 = r108.hashCode();
    L10:
        int r110 = (r107 + r109) * 31;
        String r111 = this.flexActivityId;
        if (r111 == null) goto L13;
        int r112 = r111.hashCode();
    L14:
        int r113 = (r110 + r112) * 31;
        Map<String, String> r114 = this.logMap;
        if (r114 == null) goto L18;
        r105 = r114.hashCode();
    L18:
        return r113 + r105;
    L13:
        r112 = 0;
        goto L14
    L9:
        r109 = 0;
        goto L10
    L5:
        r106 = 0;
        goto L6
    }

    public final String toString() {
        return "LinkerLogInfo(inviteType=" + this.inviteType + ", matchType=" + this.matchType + ", inviteeList=" + this.inviteeList + ", requestId=" + this.requestId + ", flexActivityId=" + this.flexActivityId + ", logMap=" + this.logMap + ")";
    }
}
