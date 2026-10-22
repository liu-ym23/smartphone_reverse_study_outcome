package nv6;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u001a\u0010\u000e\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006¨\u0006\u0010"}, d2 = {"Lnv6/r0;", "", "", "totalShowTimes", "I", "c", "()I", "", "period", "Ljava/lang/Long;", "b", "()Ljava/lang/Long;", "isNaturalTime", "d", "canCancelShow", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final class r0 {

    @SerializedName("can_cancel_show")
    private final int canCancelShow;

    @SerializedName("is_natural_time")
    private final int isNaturalTime;

    @SerializedName("period")
    private final Long period;

    @SerializedName("total_show_times")
    private final int totalShowTimes;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof r0) == true) goto L8;
        return false;
    L8:
        r0 r101 = (r0) r100;
        if (this.totalShowTimes == r101.totalShowTimes) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.period, r101.period) == true) goto L15;
        return false;
    L15:
        if (this.isNaturalTime == r101.isNaturalTime) goto L18;
        return false;
    L18:
        if (this.canCancelShow == r101.canCancelShow) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = this.totalShowTimes * 31;
        Long r101 = this.period;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return ((((r100 + r102) * 31) + this.isNaturalTime) * 31) + this.canCancelShow;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "ShowStrategy(totalShowTimes=" + this.totalShowTimes + ", period=" + this.period + ", isNaturalTime=" + this.isNaturalTime + ", canCancelShow=" + this.canCancelShow + ')';
    }

    public r0() {
        this.totalShowTimes = 0;
        this.period = null;
        this.isNaturalTime = 1;
        this.canCancelShow = 0;
    }

    public final int a() {
        return this.canCancelShow;
    }

    public final Long b() {
        return this.period;
    }

    public final int c() {
        return this.totalShowTimes;
    }

    public final int d() {
        return this.isNaturalTime;
    }
}
