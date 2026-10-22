package uq6;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Luq6/i;", "", "", "count", "J", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()J", "c", "(J)V", "funcCost", "b", "d", "startTs", "Ljava/lang/Long;", "getStartTs", "()Ljava/lang/Long;", "f", "(Ljava/lang/Long;)V", "", "label", "Ljava/lang/String;", "getLabel", "()Ljava/lang/String;", "e", "(Ljava/lang/String;)V", "dito-performance-saas_release"}, k = 1, mv = {1, 4, 3})
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient String f551323a;

    @SerializedName("count")
    private long count;

    @SerializedName(ChameleonOpenTracker.ParamKey.COST)
    private long funcCost;

    @SerializedName("label")
    private String label;

    @SerializedName("start_ts")
    private Long startTs;

    public i() {
        this(null, 31);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f551323a, r101.f551323a) == true) goto L12;
        return false;
    L12:
        if (this.count == r101.count) goto L15;
        return false;
    L15:
        if (this.funcCost == r101.funcCost) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.startTs, r101.startTs) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.label, r101.label) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f551323a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        long r103 = this.count;
        int r104 = ((r102 * 31) + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        long r105 = this.funcCost;
        int r106 = (r104 + ((int) (r105 ^ (r105 >>> 32)))) * 31;
        Long r107 = this.startTs;
        if (r107 != null) goto L9;
        int r108 = 0;
    L10:
        int r109 = (r106 + r108) * 31;
        String r110 = this.label;
        if (r110 == null) goto L15;
        r101 = r110.hashCode();
    L15:
        return r109 + r101;
    L9:
        r108 = r107.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "DitoPluginMethodTimingInfo(dataSourceName=" + this.f551323a + ", count=" + this.count + ", funcCost=" + this.funcCost + ", startTs=" + this.startTs + ", label=" + this.label + ')';
    }

    public final long a() {
        return this.count;
    }

    public final long b() {
        return this.funcCost;
    }

    public final void c(long r100) {
        this.count = r100;
    }

    public final void d(long r100) {
        this.funcCost = r100;
    }

    public final void e(String r100) {
        this.label = r100;
    }

    public final void f(Long r100) {
        this.startTs = r100;
    }

    public i(String r100, int r101) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this.f551323a = r100;
        this.count = 0;
        this.funcCost = 0;
        this.startTs = null;
        this.label = null;
    }
}
