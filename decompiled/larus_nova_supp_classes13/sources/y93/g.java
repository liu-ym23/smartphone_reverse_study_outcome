package y93;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006¨\u0006\u0012"}, d2 = {"Ly93/g;", "", "", "totalCount", "Ljava/lang/Integer;", "c", "()Ljava/lang/Integer;", "successCount", "b", "", "startTime", "Ljava/lang/Long;", "getStartTime", "()Ljava/lang/Long;", "endTime", "getEndTime", "interrupted", "getInterrupted", "ec-hybrid_saasRelease"}, k = 1, mv = {1, 4, 3})
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

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof g) == false) goto L16;
        g r4 = (g) r3;
        if (Intrinsics.areEqual(this.totalCount, r4.totalCount) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.successCount, r4.successCount) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.startTime, r4.startTime) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.endTime, r4.endTime) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.interrupted, r4.interrupted) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
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
        Long r7 = this.startTime;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        Long r10 = this.endTime;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        Integer r13 = this.interrupted;
        if (r13 == null) goto L22;
        r1 = r13.hashCode();
    L22:
        return r12 + r1;
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
        return "PreloadTemplateBean(totalCount=" + this.totalCount + ", successCount=" + this.successCount + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", interrupted=" + this.interrupted + ")";
    }

    public final Integer b() {
        return this.successCount;
    }

    public final Integer c() {
        return this.totalCount;
    }

    public /* synthetic */ g(int r7) {
        this(null, null, null, null, null);
    }

    public static g a(g r6, Integer r7, Integer r8) {
        Long r3 = r6.startTime;
        Long r4 = r6.endTime;
        Integer r5 = r6.interrupted;
        r6.getClass();
        return new g(r7, r8, r3, r4, r5);
    }

    public g(Integer r1, Integer r2, Long r3, Long r4, Integer r5) {
        this.totalCount = r1;
        this.successCount = r2;
        this.startTime = r3;
        this.endTime = r4;
        this.interrupted = r5;
    }
}
