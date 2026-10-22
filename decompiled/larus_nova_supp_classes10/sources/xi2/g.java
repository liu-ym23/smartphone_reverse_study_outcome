package xi2;

import com.bytedance.android.livesdk.livecommerce.network.response.ECBackgroundAnimationType;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000b¨\u0006\u000e"}, d2 = {"Lxi2/g;", "", "", LocationMonitorConst.TYPE, "I", "getType", "()I", "", "duration", "Ljava/lang/Long;", "a", "()Ljava/lang/Long;", "times", "b", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class g {

    @SerializedName("duration")
    private final Long duration;

    @SerializedName("times")
    private final Long times;

    @SerializedName(LocationMonitorConst.TYPE)
    private final int type;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof g) == false) goto L12;
        g r4 = (g) r3;
        if (this.type == r4.type) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.duration, r4.duration) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.times, r4.times) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        int r0 = this.type * 31;
        Long r1 = this.duration;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.hashCode();
    L6:
        int r4 = (r0 + r3) * 31;
        Long r5 = this.times;
        if (r5 == null) goto L10;
        r2 = r5.hashCode();
    L10:
        return r4 + r2;
    L5:
        r3 = 0;
        goto L6
    }

    public final String toString() {
        return "ECBannerAnimation(type=" + this.type + ", duration=" + this.duration + ", times=" + this.times + ")";
    }

    public g() {
        this.type = ECBackgroundAnimationType.NUMBER.getType();
        this.duration = null;
        this.times = null;
    }

    public final Long a() {
        return this.duration;
    }

    public final Long b() {
        return this.times;
    }

    public final int getType() {
        return this.type;
    }
}
