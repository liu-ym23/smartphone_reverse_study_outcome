package gz5;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lgz5/m;", "", "", "eventTimeOutMills", "J", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()J", "reportDelayedMills", "b", "api_release"}, k = 1, mv = {1, 4, 0})
public final class m {

    @SerializedName("event_timeout_mills")
    private final long eventTimeOutMills;

    @SerializedName("report_delayed_mills")
    private final long reportDelayedMills;

    public m() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof m) == false) goto L10;
        m r101 = (m) r100;
        if (this.eventTimeOutMills == r101.eventTimeOutMills) goto L8;
        return false;
    L8:
        if (this.reportDelayedMills == r101.reportDelayedMills) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        long r100 = this.eventTimeOutMills;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.reportDelayedMills;
        return r101 + ((int) (r102 ^ (r102 >>> 32)));
    }

    public final String toString() {
        return "CrpConfig(eventTimeOutMills=" + this.eventTimeOutMills + ", reportDelayedMills=" + this.reportDelayedMills + ")";
    }

    public final long a() {
        return this.eventTimeOutMills;
    }

    public final long b() {
        return this.reportDelayedMills;
    }

    public m(int r100) {
        this.eventTimeOutMills = 100;
        this.reportDelayedMills = 50;
    }
}
