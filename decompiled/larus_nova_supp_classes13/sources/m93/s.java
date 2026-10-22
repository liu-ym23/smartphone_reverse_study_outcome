package m93;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lm93/s;", "", "", "switchVersion", "Ljava/lang/Long;", "getSwitchVersion", "()Ljava/lang/Long;", "Lm93/b;", "bizData", "Lm93/b;", "getBizData", "()Lm93/b;", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class s {
    public final Object a;
    public final Object b;

    @SerializedName("biz_data")
    private final b bizData;

    @SerializedName("switch_version")
    private final Long switchVersion;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof s) == false) goto L14;
        s r4 = (s) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.switchVersion, r4.switchVersion) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.bizData, r4.bizData) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        Object r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Object r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Long r7 = this.switchVersion;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        b r10 = this.bizData;
        if (r10 == null) goto L18;
        r1 = r10.hashCode();
    L18:
        return r9 + r1;
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
        return "NewerOneOffItem(items=" + this.a + ", coupons=" + this.b + ", switchVersion=" + this.switchVersion + ", bizData=" + this.bizData + ")";
    }

    public s() {
        this.a = null;
        this.b = null;
        this.switchVersion = null;
        this.bizData = null;
    }
}
