package m93;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\fR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\fR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006¨\u0006\u0013"}, d2 = {"Lm93/y;", "", "", "a", "Ljava/lang/Long;", "getType", "()Ljava/lang/Long;", "type", "", "rankId", "Ljava/lang/String;", "getRankId", "()Ljava/lang/String;", "typeName", "getTypeName", "sellingPointsInfo", "getSellingPointsInfo", "rankNo", "getRankNo", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class y {
    public final Long a;
    public final String b;
    public final d c;
    public final String d;
    public final String e;

    @SerializedName("rank_id")
    private final String rankId;

    @SerializedName("rank_no")
    private final Long rankNo;

    @SerializedName("selling_points_info")
    private final String sellingPointsInfo;

    @SerializedName("type_name")
    private final String typeName;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof y) == false) goto L24;
        y r4 = (y) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.rankId, r4.rankId) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.d, r4.d) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.typeName, r4.typeName) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.sellingPointsInfo, r4.sellingPointsInfo) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.rankNo, r4.rankNo) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.e, r4.e) == true) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    public final int hashCode() {
        Long r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        d r7 = this.c;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.rankId;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.d;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.typeName;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.sellingPointsInfo;
        if (r19 == null) goto L29;
        int r20 = r19.hashCode();
    L30:
        int r21 = (r18 + r20) * 31;
        Long r22 = this.rankNo;
        if (r22 == null) goto L33;
        int r23 = r22.hashCode();
    L34:
        int r24 = (r21 + r23) * 31;
        String r25 = this.e;
        if (r25 == null) goto L38;
        r1 = r25.hashCode();
    L38:
        return r24 + r1;
    L33:
        r23 = 0;
        goto L34
    L29:
        r20 = 0;
        goto L30
    L25:
        r17 = 0;
        goto L26
    L21:
        r14 = 0;
        goto L22
    L17:
        r11 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "RecReason(type=" + this.a + ", content=" + this.b + ", cover=" + this.c + ", rankId=" + this.rankId + ", uid=" + this.d + ", typeName=" + this.typeName + ", sellingPointsInfo=" + this.sellingPointsInfo + ", rankNo=" + this.rankNo + ", link=" + this.e + ")";
    }

    public y() {
        this.a = null;
        this.b = null;
        this.c = null;
        this.rankId = null;
        this.d = null;
        this.typeName = null;
        this.sellingPointsInfo = null;
        this.rankNo = null;
        this.e = null;
    }

    public final Long getType() {
        return this.a;
    }
}
