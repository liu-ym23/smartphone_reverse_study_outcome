package m93;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\fR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\fR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006¨\u0006\u0013"}, d2 = {"Lm93/y;", "", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Ljava/lang/Long;", "getType", "()Ljava/lang/Long;", "type", "", "rankId", "Ljava/lang/String;", "getRankId", "()Ljava/lang/String;", "typeName", "getTypeName", "sellingPointsInfo", "getSellingPointsInfo", "rankNo", "getRankNo", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Long f512636a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f512637b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f512638c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f512639d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f512640e;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_RANK_ID)
    private final String rankId;

    @SerializedName("rank_no")
    private final Long rankNo;

    @SerializedName("selling_points_info")
    private final String sellingPointsInfo;

    @SerializedName("type_name")
    private final String typeName;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof y) == false) goto L24;
        y r101 = (y) r100;
        if (Intrinsics.areEqual(this.f512636a, r101.f512636a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f512637b, r101.f512637b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f512638c, r101.f512638c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.rankId, r101.rankId) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f512639d, r101.f512639d) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.typeName, r101.typeName) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.sellingPointsInfo, r101.sellingPointsInfo) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.rankNo, r101.rankNo) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f512640e, r101.f512640e) == true) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    public final int hashCode() {
        Long r100 = this.f512636a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f512637b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        d r107 = this.f512638c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.rankId;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f512639d;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.typeName;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.sellingPointsInfo;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        Long r122 = this.rankNo;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.f512640e;
        if (r125 == null) goto L38;
        r101 = r125.hashCode();
    L38:
        return r124 + r101;
    L33:
        r123 = 0;
        goto L34
    L29:
        r120 = 0;
        goto L30
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "RecReason(type=" + this.f512636a + ", content=" + this.f512637b + ", cover=" + this.f512638c + ", rankId=" + this.rankId + ", uid=" + this.f512639d + ", typeName=" + this.typeName + ", sellingPointsInfo=" + this.sellingPointsInfo + ", rankNo=" + this.rankNo + ", link=" + this.f512640e + ")";
    }

    public y() {
        this.f512636a = null;
        this.f512637b = null;
        this.f512638c = null;
        this.rankId = null;
        this.f512639d = null;
        this.typeName = null;
        this.sellingPointsInfo = null;
        this.rankNo = null;
        this.f512640e = null;
    }

    public final Long getType() {
        return this.f512636a;
    }
}
