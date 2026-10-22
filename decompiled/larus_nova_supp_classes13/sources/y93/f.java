package y93;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006¨\u0006\u000b"}, d2 = {"Ly93/f;", "", "", "totalCount", "Ljava/lang/Integer;", "b", "()Ljava/lang/Integer;", "successCount", "a", "xmlPreloadCount", "c", "ec-hybrid_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class f {

    @SerializedName("first_native_preload_success_count")
    private final Integer successCount;

    @SerializedName("first_native_total_count")
    private final Integer totalCount;

    @SerializedName("first_native_preload_xml_count")
    private final Integer xmlPreloadCount;

    public f() {
        this(null, null, null);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof f) == false) goto L12;
        f r4 = (f) r3;
        if (Intrinsics.areEqual(this.totalCount, r4.totalCount) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.successCount, r4.successCount) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.xmlPreloadCount, r4.xmlPreloadCount) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        Integer r0 = this.totalCount;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.successCount;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.xmlPreloadCount;
        if (r7 == null) goto L14;
        r1 = r7.hashCode();
    L14:
        return r6 + r1;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "PreloadNativeBean(totalCount=" + this.totalCount + ", successCount=" + this.successCount + ", xmlPreloadCount=" + this.xmlPreloadCount + ")";
    }

    public final Integer a() {
        return this.successCount;
    }

    public final Integer b() {
        return this.totalCount;
    }

    public final Integer c() {
        return this.xmlPreloadCount;
    }

    public f(Integer r1, Integer r2, Integer r3) {
        this.totalCount = r1;
        this.successCount = r2;
        this.xmlPreloadCount = r3;
    }
}
