package qe6;

import com.byted.cast.linkcommon.cybergarage.upnp.device.ST;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u000e\u001a\u00020\n¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\bHÆ\u0003J\t\u0010#\u001a\u00020\nHÆ\u0003J\t\u0010$\u001a\u00020\nHÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\nHÆ\u0003J\t\u0010'\u001a\u00020\nHÆ\u0003Jm\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\nHÆ\u0001J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020\bHÖ\u0001J\t\u0010-\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u000b\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0012R\u0016\u0010\r\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019R\u0016\u0010\u000e\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0019¨\u0006."}, d2 = {"Lcom/bytedance/lark/policy/model/trace/SingleValidateCost;", "", ST.UUID_DEVICE, "", "pointKey", "policyType", "resultType", "exprCount", "", "totalCost", "", "averageCost", "exprType", "averageExecCost", "averageParseCost", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IJJLjava/lang/String;JJ)V", "getUuid", "()Ljava/lang/String;", "getPointKey", "getPolicyType", "getResultType", "getExprCount", "()I", "getTotalCost", "()J", "getAverageCost", "getExprType", "getAverageExecCost", "getAverageParseCost", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "", "other", "hashCode", "toString", "policy-engine_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class b {

    @SerializedName("average_cost")
    private final long averageCost;

    @SerializedName("average_exec_cost")
    private final long averageExecCost;

    @SerializedName("average_parse_cost")
    private final long averageParseCost;

    @SerializedName("expr_count")
    private final int exprCount;

    @SerializedName("expr_type")
    private final String exprType;

    @SerializedName("point_key")
    private final String pointKey;

    @SerializedName("policy_type")
    private final String policyType;

    @SerializedName("result_type")
    private final String resultType;

    @SerializedName("total_cost")
    private final long totalCost;

    @SerializedName(ST.UUID_DEVICE)
    private final String uuid;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.uuid, r101.uuid) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.pointKey, r101.pointKey) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.policyType, r101.policyType) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.resultType, r101.resultType) == true) goto L21;
        return false;
    L21:
        if (this.exprCount == r101.exprCount) goto L24;
        return false;
    L24:
        if (this.totalCost == r101.totalCost) goto L27;
        return false;
    L27:
        if (this.averageCost == r101.averageCost) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.exprType, r101.exprType) == true) goto L33;
        return false;
    L33:
        if (this.averageExecCost == r101.averageExecCost) goto L36;
        return false;
    L36:
        if (this.averageParseCost == r101.averageParseCost) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((this.uuid.hashCode() * 31) + this.pointKey.hashCode()) * 31) + this.policyType.hashCode()) * 31) + this.resultType.hashCode()) * 31) + this.exprCount) * 31;
        long r101 = this.totalCost;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = this.averageCost;
        int r104 = (((r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31) + this.exprType.hashCode()) * 31;
        long r105 = this.averageExecCost;
        int r106 = (r104 + ((int) (r105 ^ (r105 >>> 32)))) * 31;
        long r107 = this.averageParseCost;
        return r106 + ((int) (r107 ^ (r107 >>> 32)));
    }

    public final String toString() {
        return "SingleValidateCost(uuid=" + this.uuid + ", pointKey=" + this.pointKey + ", policyType=" + this.policyType + ", resultType=" + this.resultType + ", exprCount=" + this.exprCount + ", totalCost=" + this.totalCost + ", averageCost=" + this.averageCost + ", exprType=" + this.exprType + ", averageExecCost=" + this.averageExecCost + ", averageParseCost=" + this.averageParseCost + ')';
    }

    public b(String r100, String r101, String r102, String r103, int r104, long r105, long r106, String r110, long r111, long r112) {
        Intrinsics.checkNotNullParameter(r100, ST.UUID_DEVICE);
        Intrinsics.checkNotNullParameter(r101, "pointKey");
        Intrinsics.checkNotNullParameter(r102, "policyType");
        Intrinsics.checkNotNullParameter(r103, "resultType");
        Intrinsics.checkNotNullParameter(r110, "exprType");
        this.uuid = r100;
        this.pointKey = r101;
        this.policyType = r102;
        this.resultType = r103;
        this.exprCount = r104;
        this.totalCost = r105;
        this.averageCost = r106;
        this.exprType = r110;
        this.averageExecCost = r111;
        this.averageParseCost = r112;
    }
}
