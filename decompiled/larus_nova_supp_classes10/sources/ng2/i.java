package ng2;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u0011\u0010\u000b¨\u0006\u0012"}, d2 = {"Lng2/i;", "", "", "enable", "Ljava/lang/Boolean;", "getEnable", "()Ljava/lang/Boolean;", "", "corePoolSize", "Ljava/lang/Integer;", "getCorePoolSize", "()Ljava/lang/Integer;", "maxPoolSize", "getMaxPoolSize", "interval", "getInterval", "delayTime", "getDelayTime", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class i {

    @SerializedName("corePoolSize")
    private final Integer corePoolSize;

    @SerializedName("delayTime")
    private final Integer delayTime;

    @SerializedName("enable")
    private final Boolean enable;

    @SerializedName("interval")
    private final Integer interval;

    @SerializedName("maxPoolSize")
    private final Integer maxPoolSize;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof i) == false) goto L16;
        i r4 = (i) r3;
        if (Intrinsics.areEqual(this.enable, r4.enable) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.corePoolSize, r4.corePoolSize) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.maxPoolSize, r4.maxPoolSize) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.interval, r4.interval) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.delayTime, r4.delayTime) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        Boolean r0 = this.enable;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.corePoolSize;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.maxPoolSize;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        Integer r10 = this.interval;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        Integer r13 = this.delayTime;
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
        return "TobSuperThreadConfig(enable=" + this.enable + ", corePoolSize=" + this.corePoolSize + ", maxPoolSize=" + this.maxPoolSize + ", interval=" + this.interval + ", delayTime=" + this.delayTime + ")";
    }

    public i() {
        this.enable = Boolean.TRUE;
        this.corePoolSize = 30;
        this.maxPoolSize = 50;
        this.interval = 100;
        this.delayTime = 0;
    }
}
