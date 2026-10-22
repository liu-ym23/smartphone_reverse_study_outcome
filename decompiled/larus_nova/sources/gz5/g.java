package gz5;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R \u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0014\u0010\u0011R\u001a\u0010\u0016\u001a\u00020\u00158\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001b\u001a\u00020\u001a8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010\u0004\u001a\u0004\b \u0010\u0006¨\u0006!"}, d2 = {"Lgz5/g;", "", "", "enabled", "Z", "getEnabled", "()Z", "Lgz5/a0;", "shareConfig", "Lgz5/a0;", "getShareConfig", "()Lgz5/a0;", "", "Lgz5/r;", "interestBinders", "Ljava/util/List;", "getInterestBinders", "()Ljava/util/List;", "Lgz5/s;", "interestProviders", "getInterestProviders", "Lgz5/i;", "trafficDefenseConfig", "Lgz5/i;", "getTrafficDefenseConfig", "()Lgz5/i;", "Lgz5/u;", "reportFilterConfig", "Lgz5/u;", "getReportFilterConfig", "()Lgz5/u;", "skipHiddenApiExemption", "getSkipHiddenApiExemption", "api_release"}, k = 1, mv = {1, 4, 0})
public final class g {

    @SerializedName("enabled")
    private final boolean enabled;

    @SerializedName("interest_binders")
    private final List<r> interestBinders;

    @SerializedName("interest_providers")
    private final List<s> interestProviders;

    @SerializedName("binder_report_filter")
    private final u reportFilterConfig;

    @SerializedName("share_monitor")
    private final a0 shareConfig;

    @SerializedName("skip_hidden_api_exemption")
    private final boolean skipHiddenApiExemption;

    @SerializedName("binder_traffic")
    private final i trafficDefenseConfig;

    public g() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof g) == false) goto L20;
        g r101 = (g) r100;
        if (this.enabled == r101.enabled) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.shareConfig, r101.shareConfig) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.interestBinders, r101.interestBinders) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.interestProviders, r101.interestProviders) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.trafficDefenseConfig, r101.trafficDefenseConfig) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.reportFilterConfig, r101.reportFilterConfig) == true) goto L18;
        return false;
    L18:
        if (this.skipHiddenApiExemption == r101.skipHiddenApiExemption) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v13, types: [int] */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    public final int hashCode() {
        boolean r100 = this.enabled;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        a0 r104 = this.shareConfig;
        int r105 = 0;
        if (r104 == null) goto L8;
        int r106 = r104.hashCode();
    L9:
        int r107 = (r103 + r106) * 31;
        List<r> r108 = this.interestBinders;
        if (r108 == null) goto L12;
        int r109 = r108.hashCode();
    L13:
        int r110 = (r107 + r109) * 31;
        List<s> r111 = this.interestProviders;
        if (r111 == null) goto L16;
        int r112 = r111.hashCode();
    L17:
        int r113 = (r110 + r112) * 31;
        i r114 = this.trafficDefenseConfig;
        if (r114 == null) goto L20;
        int r115 = r114.hashCode();
    L21:
        int r116 = (r113 + r115) * 31;
        u r117 = this.reportFilterConfig;
        if (r117 == null) goto L24;
        r105 = r117.hashCode();
    L24:
        int r118 = (r116 + r105) * 31;
        boolean r119 = this.skipHiddenApiExemption;
        if (r119 == true) goto L29;
        r101 = r119;
    L29:
        return r118 + r101;
    L20:
        r115 = 0;
        goto L21
    L16:
        r112 = 0;
        goto L17
    L12:
        r109 = 0;
        goto L13
    L8:
        r106 = 0;
        goto L9
    }

    public final String toString() {
        return "BinderConfig(enabled=" + this.enabled + ", shareConfig=" + this.shareConfig + ", interestBinders=" + this.interestBinders + ", interestProviders=" + this.interestProviders + ", trafficDefenseConfig=" + this.trafficDefenseConfig + ", reportFilterConfig=" + this.reportFilterConfig + ", skipHiddenApiExemption=" + this.skipHiddenApiExemption + ")";
    }

    public g(Object r100) {
        a0 r101 = new a0(null);
        List<r> r102 = CollectionsKt.emptyList();
        List<s> r103 = CollectionsKt.emptyList();
        i r104 = new i(null);
        u r105 = new u(null);
        this.enabled = false;
        this.shareConfig = r101;
        this.interestBinders = r102;
        this.interestProviders = r103;
        this.trafficDefenseConfig = r104;
        this.reportFilterConfig = r105;
        this.skipHiddenApiExemption = true;
    }
}
