package he3;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001R*\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R*\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0005\u001a\u0004\b\t\u0010\u0007R*\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0005\u001a\u0004\b\f\u0010\u0007¨\u0006\r"}, d2 = {"Lhe3/m0;", "", "", "", "trackCommonData", "Ljava/util/Map;", "c", "()Ljava/util/Map;", "realCommonData", "b", "Lhe3/b0;", "eventsData", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class m0 {

    @SerializedName("events_data")
    private final Map<String, b0> eventsData;

    @SerializedName("real_common_data")
    private final Map<String, Object> realCommonData;

    @SerializedName("track_common_data")
    private final Map<String, Object> trackCommonData;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof m0) == false) goto L12;
        m0 r4 = (m0) r3;
        if (Intrinsics.areEqual(this.trackCommonData, r4.trackCommonData) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.realCommonData, r4.realCommonData) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.eventsData, r4.eventsData) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        Map<String, Object> r0 = this.trackCommonData;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Map<String, Object> r4 = this.realCommonData;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Map<String, b0> r7 = this.eventsData;
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
        return "DeepFeedSlcTrackData(trackCommonData=" + this.trackCommonData + ", realCommonData=" + this.realCommonData + ", eventsData=" + this.eventsData + ")";
    }

    public m0() {
        this.trackCommonData = null;
        this.realCommonData = null;
        this.eventsData = null;
    }

    public final Map<String, b0> a() {
        return this.eventsData;
    }

    public final Map<String, Object> b() {
        return this.realCommonData;
    }

    public final Map<String, Object> c() {
        return this.trackCommonData;
    }
}
