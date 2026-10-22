package d93;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u001aR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001b"}, d2 = {"Ld93/e;", "", "", "type", "I", "getType", "()I", "setType", "(I)V", "", "timeRange", "J", "getTimeRange", "()J", "setTimeRange", "(J)V", "sampleRange", "getSampleRange", "setSampleRange", "Ld93/g;", "eventRange", "Ld93/g;", "getEventRange", "()Ld93/g;", "setEventRange", "(Ld93/g;)V", "a", "ec-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class e {

    @SerializedName("event_range")
    private g eventRange;

    @SerializedName("sample_range")
    private int sampleRange;

    @SerializedName("time_range")
    private long timeRange;

    @SerializedName("type")
    private int type;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof e) == false) goto L14;
        e r7 = (e) r6;
        if (this.type == r7.type) goto L8;
        return false;
    L8:
        if (this.timeRange == r7.timeRange) goto L10;
        return false;
    L10:
        if (this.sampleRange == r7.sampleRange) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.eventRange, r7.eventRange) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        int r0 = this.type * 31;
        long r1 = this.timeRange;
        int r2 = (((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.sampleRange) * 31;
        g r3 = this.eventRange;
        if (r3 == null) goto L5;
        int r4 = r3.hashCode();
    L7:
        return r2 + r4;
    L5:
        r4 = 0;
        goto L7
    }

    public final String toString() {
        return "EventProcessRangeDsl(type=" + this.type + ", timeRange=" + this.timeRange + ", sampleRange=" + this.sampleRange + ", eventRange=" + this.eventRange + ")";
    }

    public e() {
        this.type = 0;
        this.timeRange = 0;
        this.sampleRange = 0;
        this.eventRange = null;
    }

    public final int getType() {
        return this.type;
    }
}
