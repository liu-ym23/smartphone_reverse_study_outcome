package zv9;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u001b\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b\u0012\u0012\b\u0002\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\u0013\u0010\u001c\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\bHÆ\u0003J\u0013\u0010\u001d\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\bHÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003JY\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b2\u0012\b\u0002\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b2\b\b\u0002\u0010\u000b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010 \u001a\u00020\u00032\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\u0005HÖ\u0001J\t\u0010#\u001a\u00020\tHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R(\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R \u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0016\u0010\u000b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011¨\u0006$"}, d2 = {"Lcom/larus/settings/provider/security/DTraitDetailConfig;", "", "enable", "", "riskType", "", "timeOut", "allowList", "", "", "dtraitWhiteList", "dTraitEventSimplePercent", "<init>", "(ZIILjava/util/List;Ljava/util/List;I)V", "getEnable", "()Z", "getRiskType", "()I", "getTimeOut", "getAllowList", "()Ljava/util/List;", "setAllowList", "(Ljava/util/List;)V", "getDtraitWhiteList", "getDTraitEventSimplePercent", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class f {

    @SerializedName("allow_list")
    private List<String> allowList;

    @SerializedName("dTrait_event_simple_percent")
    private final int dTraitEventSimplePercent;

    @SerializedName("dtrait_white_list")
    private final List<String> dtraitWhiteList;

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("risk_type")
    private final int riskType;

    @SerializedName("time_out")
    private final int timeOut;

    public f() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (this.enable == r101.enable) goto L12;
        return false;
    L12:
        if (this.riskType == r101.riskType) goto L15;
        return false;
    L15:
        if (this.timeOut == r101.timeOut) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.allowList, r101.allowList) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.dtraitWhiteList, r101.dtraitWhiteList) == true) goto L24;
        return false;
    L24:
        if (this.dTraitEventSimplePercent == r101.dTraitEventSimplePercent) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        if (this.enable == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = ((((r100 * 31) + this.riskType) * 31) + this.timeOut) * 31;
        List<String> r102 = this.allowList;
        int r103 = 0;
        if (r102 != null) goto L9;
        int r104 = 0;
    L10:
        int r105 = (r101 + r104) * 31;
        List<String> r106 = this.dtraitWhiteList;
        if (r106 == null) goto L15;
        r103 = r106.hashCode();
    L15:
        return ((r105 + r103) * 31) + this.dTraitEventSimplePercent;
    L9:
        r104 = r102.hashCode();
        goto L10
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "DTraitDetailConfig(enable=" + this.enable + ", riskType=" + this.riskType + ", timeOut=" + this.timeOut + ", allowList=" + this.allowList + ", dtraitWhiteList=" + this.dtraitWhiteList + ", dTraitEventSimplePercent=" + this.dTraitEventSimplePercent + ')';
    }

    public final List<String> a() {
        return this.allowList;
    }

    public final int b() {
        return this.dTraitEventSimplePercent;
    }

    public final List<String> c() {
        return this.dtraitWhiteList;
    }

    public final boolean d() {
        return this.enable;
    }

    public final int e() {
        return this.riskType;
    }

    public final int f() {
        return this.timeOut;
    }

    public f(Object r100) {
        List<String> r101 = CollectionsKt.listOf("/im/chain/single");
        List<String> r102 = CollectionsKt.listOf(new String[]{"/passport/token/beat/v2/", "/passport/account/info/v2/"});
        this.enable = true;
        this.riskType = 0;
        this.timeOut = 10;
        this.allowList = r101;
        this.dtraitWhiteList = r102;
        this.dTraitEventSimplePercent = 100;
    }
}
