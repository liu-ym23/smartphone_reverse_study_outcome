package y93;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006¨\u0006\u000b"}, d2 = {"Ly93/f;", "", "", "totalCount", "Ljava/lang/Integer;", "b", "()Ljava/lang/Integer;", "successCount", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "xmlPreloadCount", "c", "ec-hybrid_saasRelease"}, k = 1, mv = {1, 4, 3})
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

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f) == false) goto L12;
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.totalCount, r101.totalCount) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.successCount, r101.successCount) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.xmlPreloadCount, r101.xmlPreloadCount) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        Integer r100 = this.totalCount;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.successCount;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.xmlPreloadCount;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
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

    public f(Integer r100, Integer r101, Integer r102) {
        this.totalCount = r100;
        this.successCount = r101;
        this.xmlPreloadCount = r102;
    }
}
