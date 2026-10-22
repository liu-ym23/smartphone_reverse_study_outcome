package zm7;

import com.amap.api.col.s.ce;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R.\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u000e\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0017\u001a\u00020\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u000f\u001a\u0004\b\u001c\u0010\u0011R\"\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u0005\u001a\u0004\b\u001e\u0010\u0007¨\u0006\u001f"}, d2 = {"Lzm7/q;", "", "", "", SlcCommonAction.KEY_ACTIONS, "Ljava/util/List;", "b", "()Ljava/util/List;", "", "timerRules", "Ljava/util/Map;", ce.f26391f, "()Ljava/util/Map;", "", "targetTs", "I", "f", "()I", "ackedTs", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "h", "(I)V", "", "expireAt", "J", "c", "()J", "reportIntervalTs", "e", "millstonesTs", "d", "luckyhost-api_release"}, k = 1, mv = {1, 4, 0})
public final class q {

    @SerializedName("acked_ts")
    private int ackedTs;

    @SerializedName(SlcCommonAction.KEY_ACTIONS)
    private final List<String> actions;

    @SerializedName("expire_at")
    private final long expireAt;

    @SerializedName("millstones_ts")
    private final List<Integer> millstonesTs;

    @SerializedName("report_interval_ts")
    private final int reportIntervalTs;

    @SerializedName("target_ts")
    private final int targetTs;

    @SerializedName("timer_rules")
    private final Map<String, List<String>> timerRules;

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
    L34:
        return true;
    L5:
        if ((r100 instanceof q) == false) goto L33;
        q r101 = (q) r100;
        if (Intrinsics.areEqual(this.actions, r101.actions) == false) goto L33;
        if (Intrinsics.areEqual(this.timerRules, r101.timerRules) == false) goto L33;
        if (this.targetTs != r101.targetTs) goto L13;
        boolean r102 = true;
    L14:
        if (r102 == false) goto L33;
        if (this.ackedTs != r101.ackedTs) goto L18;
        boolean r103 = true;
    L19:
        if (r103 == false) goto L33;
        if (this.expireAt != r101.expireAt) goto L23;
        boolean r104 = true;
    L24:
        if (r104 == false) goto L33;
        if (this.reportIntervalTs != r101.reportIntervalTs) goto L28;
        boolean r105 = true;
    L29:
        if (r105 == false) goto L33;
        if (Intrinsics.areEqual(this.millstonesTs, r101.millstonesTs) == false) goto L33;
    L28:
        r105 = false;
        goto L29
    L23:
        r104 = false;
        goto L24
    L18:
        r103 = false;
        goto L19
    L13:
        r102 = false;
    L33:
        return false;
    }

    public final int hashCode() {
        List<String> r100 = this.actions;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Map<String, List<String>> r104 = this.timerRules;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (((((r103 + r105) * 31) + this.targetTs) * 31) + this.ackedTs) * 31;
        long r107 = this.expireAt;
        int r108 = (((r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31) + this.reportIntervalTs) * 31;
        List<Integer> r109 = this.millstonesTs;
        if (r109 == null) goto L14;
        r101 = r109.hashCode();
    L14:
        return r108 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "TimerConfig(actions=" + this.actions + ", timerRules=" + this.timerRules + ", targetTs=" + this.targetTs + ", ackedTs=" + this.ackedTs + ", expireAt=" + this.expireAt + ", reportIntervalTs=" + this.reportIntervalTs + ", millstonesTs=" + this.millstonesTs + ")";
    }

    public final int a() {
        return this.ackedTs;
    }

    public final List<String> b() {
        return this.actions;
    }

    public final long c() {
        return this.expireAt;
    }

    public final List<Integer> d() {
        return this.millstonesTs;
    }

    public final int e() {
        return this.reportIntervalTs;
    }

    public final int f() {
        return this.targetTs;
    }

    public final Map<String, List<String>> g() {
        return this.timerRules;
    }

    public final void h(int r100) {
        this.ackedTs = r100;
    }
}
