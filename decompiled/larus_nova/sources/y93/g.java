package y93;

import com.google.gson.annotations.SerializedName;
import com.ss.android.dypay.api.DyPayConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006¨\u0006\u0012"}, d2 = {"Ly93/g;", "", "", "totalCount", "Ljava/lang/Integer;", "c", "()Ljava/lang/Integer;", "successCount", "b", "", DyPayConstant.KEY_START_TIME, "Ljava/lang/Long;", "getStartTime", "()Ljava/lang/Long;", "endTime", "getEndTime", "interrupted", "getInterrupted", "ec-hybrid_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class g {

    @SerializedName("t_preload_schema_end")
    private final Long endTime;

    @SerializedName("preload_interrupted")
    private final Integer interrupted;

    @SerializedName("t_preload_schema_start")
    private final Long startTime;

    @SerializedName("first_lynx_preload_success_count")
    private final Integer successCount;

    @SerializedName("first_lynx_total_count")
    private final Integer totalCount;

    public g() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof g) == false) goto L16;
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.totalCount, r101.totalCount) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.successCount, r101.successCount) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.startTime, r101.startTime) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.endTime, r101.endTime) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.interrupted, r101.interrupted) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
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
        Long r107 = this.startTime;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Long r110 = this.endTime;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.interrupted;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return r112 + r101;
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
        return "PreloadTemplateBean(totalCount=" + this.totalCount + ", successCount=" + this.successCount + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", interrupted=" + this.interrupted + ")";
    }

    public final Integer b() {
        return this.successCount;
    }

    public final Integer c() {
        return this.totalCount;
    }

    public /* synthetic */ g(int r100) {
        this(null, null, null, null, null);
    }

    public static g a(g r100, Integer r101, Integer r102) {
        Long r103 = r100.startTime;
        Long r104 = r100.endTime;
        Integer r105 = r100.interrupted;
        r100.getClass();
        return new g(r101, r102, r103, r104, r105);
    }

    public g(Integer r100, Integer r101, Long r102, Long r103, Integer r104) {
        this.totalCount = r100;
        this.successCount = r101;
        this.startTime = r102;
        this.endTime = r103;
        this.interrupted = r104;
    }
}
