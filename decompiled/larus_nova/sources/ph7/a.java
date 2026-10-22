package ph7;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lph7/a;", "", "", "enable", "Z", "getEnable", "()Z", "", "coldLaunchDurationThreshold", "I", "getColdLaunchDurationThreshold", "()I", "timonbase_release"}, k = 1, mv = {1, 4, 0})
public final class a {

    @SerializedName("cold_launch_duration_threshold")
    private final int coldLaunchDurationThreshold;

    @SerializedName("enable")
    private final boolean enable;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L10;
        a r101 = (a) r100;
        if (this.enable == r101.enable) goto L8;
        return false;
    L8:
        if (this.coldLaunchDurationThreshold == r101.coldLaunchDurationThreshold) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public final int hashCode() {
        boolean r100 = this.enable;
        ?? r101 = r100;
        if (r100 == false) goto L6;
        r101 = 1;
    L6:
        return (r101 * 31) + this.coldLaunchDurationThreshold;
    }

    public final String toString() {
        return "ColdLaunchScene(enable=" + this.enable + ", coldLaunchDurationThreshold=" + this.coldLaunchDurationThreshold + ")";
    }

    public a() {
        this.enable = false;
        this.coldLaunchDurationThreshold = 30000;
    }
}
