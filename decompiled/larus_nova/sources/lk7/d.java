package lk7;

import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001a\u0010\u000e\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0010\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u0011\u0010\u000bR\u001a\u0010\u0012\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\t\u001a\u0004\b\u0013\u0010\u000bR\u001a\u0010\u0015\u001a\u00020\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\t\u001a\u0004\b\u001a\u0010\u000bR\u001a\u0010\u001b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006R\u001a\u0010\u001d\u001a\u00020\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u0016\u001a\u0004\b\u001e\u0010\u0018¨\u0006\u001f"}, d2 = {"Llk7/d;", "", "", "fromAid", "I", "getFromAid", "()I", "", "fromDid", "J", "getFromDid", "()J", "fromUid", "getFromUid", "toAid", "getToAid", "toDid", "getToDid", "toUid", "getToUid", "", "domainId", "Ljava/lang/String;", "getDomainId", "()Ljava/lang/String;", "actionTimeStamp", "getActionTimeStamp", ReportConstant.COMMON_ACTION_TYPE, "getActionType", "source", "getSource", "luckydog-api_release"}, k = 1, mv = {1, 4, 0})
public final class d {

    @SerializedName("action_ts")
    private final long actionTimeStamp;

    @SerializedName("action_type")
    private final int actionType;

    @SerializedName("domain_id")
    private final String domainId;

    @SerializedName("source_app_id")
    private final int fromAid;

    @SerializedName("source_device_id")
    private final long fromDid;

    @SerializedName("source_user_id")
    private final long fromUid;

    @SerializedName("source")
    private final String source;

    @SerializedName("target_app_id")
    private final long toAid;

    @SerializedName("target_device_id")
    private final long toDid;

    @SerializedName("target_user_id")
    private final long toUid;

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
    L52:
        return true;
    L5:
        if ((r100 instanceof d) == false) goto L51;
        d r101 = (d) r100;
        if (this.fromAid != r101.fromAid) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == false) goto L51;
        if (this.fromDid != r101.fromDid) goto L14;
        boolean r103 = true;
    L15:
        if (r103 == false) goto L51;
        if (this.fromUid != r101.fromUid) goto L19;
        boolean r104 = true;
    L20:
        if (r104 == false) goto L51;
        if (this.toAid != r101.toAid) goto L24;
        boolean r105 = true;
    L25:
        if (r105 == false) goto L51;
        if (this.toDid != r101.toDid) goto L29;
        boolean r106 = true;
    L30:
        if (r106 == false) goto L51;
        if (this.toUid != r101.toUid) goto L34;
        boolean r107 = true;
    L35:
        if (r107 == false) goto L51;
        if (Intrinsics.areEqual(this.domainId, r101.domainId) == false) goto L51;
        if (this.actionTimeStamp != r101.actionTimeStamp) goto L41;
        boolean r108 = true;
    L42:
        if (r108 == false) goto L51;
        if (this.actionType != r101.actionType) goto L46;
        boolean r109 = true;
    L47:
        if (r109 == false) goto L51;
        if (Intrinsics.areEqual(this.source, r101.source) == false) goto L51;
    L46:
        r109 = false;
        goto L47
    L41:
        r108 = false;
        goto L42
    L34:
        r107 = false;
        goto L35
    L29:
        r106 = false;
        goto L30
    L24:
        r105 = false;
        goto L25
    L19:
        r104 = false;
        goto L20
    L14:
        r103 = false;
        goto L15
    L9:
        r102 = false;
    L51:
        return false;
    }

    public final int hashCode() {
        int r100 = this.fromAid * 31;
        long r101 = this.fromDid;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = this.fromUid;
        int r104 = (r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        long r105 = this.toAid;
        int r106 = (r104 + ((int) (r105 ^ (r105 >>> 32)))) * 31;
        long r107 = this.toDid;
        int r108 = (r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31;
        long r109 = this.toUid;
        int r110 = (r108 + ((int) (r109 ^ (r109 >>> 32)))) * 31;
        String r111 = this.domainId;
        int r112 = 0;
        if (r111 == null) goto L5;
        int r113 = r111.hashCode();
    L6:
        long r114 = this.actionTimeStamp;
        int r115 = (((((r110 + r113) * 31) + ((int) (r114 ^ (r114 >>> 32)))) * 31) + this.actionType) * 31;
        String r116 = this.source;
        if (r116 == null) goto L10;
        r112 = r116.hashCode();
    L10:
        return r115 + r112;
    L5:
        r113 = 0;
        goto L6
    }

    public final String toString() {
        return "source_app_id: " + this.fromAid + ", source_device_id: " + this.fromDid + ", source_user_id: " + this.fromUid + ", target_app_id: " + this.toAid + ", target_device_id: " + this.toDid + ", target_user_id: " + this.toUid + ", domain_id: " + this.domainId + ", action_ts: " + this.actionTimeStamp + ", action_type: " + this.actionType + ", source: " + this.source;
    }
}
