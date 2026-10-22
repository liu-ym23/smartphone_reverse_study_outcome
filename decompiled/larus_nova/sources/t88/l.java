package t88;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u001b\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BK\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000fJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000fJR\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0011\u0010\u000fR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u001a\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0013\u0010\u000fR\u001a\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0014\u0010\u000f¨\u0006\""}, d2 = {"Lcom/larus/avlink/aiproactive/model/ImuCapability;", "", "supportImuSedentary", "", "sedentaryMinThreshold", "", "sedentaryMaxThreshold", "supportImuHeadDown", "headDownMinThreshold", "headDownMaxThreshold", "<init>", "(ZLjava/lang/Integer;Ljava/lang/Integer;ZLjava/lang/Integer;Ljava/lang/Integer;)V", "getSupportImuSedentary", "()Z", "getSedentaryMinThreshold", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSedentaryMaxThreshold", "getSupportImuHeadDown", "getHeadDownMinThreshold", "getHeadDownMaxThreshold", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(ZLjava/lang/Integer;Ljava/lang/Integer;ZLjava/lang/Integer;Ljava/lang/Integer;)Lcom/larus/avlink/aiproactive/model/ImuCapability;", "equals", "other", "hashCode", "toString", "", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class l {

    @SerializedName("head_down_max_threshold")
    private final Integer headDownMaxThreshold;

    @SerializedName("head_down_min_threshold")
    private final Integer headDownMinThreshold;

    @SerializedName("sedentary_max_threshold")
    private final Integer sedentaryMaxThreshold;

    @SerializedName("sedentary_min_threshold")
    private final Integer sedentaryMinThreshold;

    @SerializedName("support_imu_head_down")
    private final boolean supportImuHeadDown;

    @SerializedName("support_imu_sedentary")
    private final boolean supportImuSedentary;

    public l() {
        this(false, null, null, false, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l) == true) goto L8;
        return false;
    L8:
        l r101 = (l) r100;
        if (this.supportImuSedentary == r101.supportImuSedentary) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.sedentaryMinThreshold, r101.sedentaryMinThreshold) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.sedentaryMaxThreshold, r101.sedentaryMaxThreshold) == true) goto L18;
        return false;
    L18:
        if (this.supportImuHeadDown == r101.supportImuHeadDown) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.headDownMinThreshold, r101.headDownMinThreshold) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.headDownMaxThreshold, r101.headDownMaxThreshold) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.supportImuSedentary == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        Integer r103 = this.sedentaryMinThreshold;
        int r104 = 0;
        if (r103 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r102 + r105) * 31;
        Integer r107 = this.sedentaryMaxThreshold;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        if (this.supportImuHeadDown == true) goto L18;
        r100 = 1237;
    L18:
        int r110 = (r109 + r100) * 31;
        Integer r111 = this.headDownMinThreshold;
        if (r111 != null) goto L21;
        int r112 = 0;
    L22:
        int r113 = (r110 + r112) * 31;
        Integer r114 = this.headDownMaxThreshold;
        if (r114 == null) goto L27;
        r104 = r114.hashCode();
    L27:
        return r113 + r104;
    L21:
        r112 = r111.hashCode();
        goto L22
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r103.hashCode();
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "ImuCapability(supportImuSedentary=" + this.supportImuSedentary + ", sedentaryMinThreshold=" + this.sedentaryMinThreshold + ", sedentaryMaxThreshold=" + this.sedentaryMaxThreshold + ", supportImuHeadDown=" + this.supportImuHeadDown + ", headDownMinThreshold=" + this.headDownMinThreshold + ", headDownMaxThreshold=" + this.headDownMaxThreshold + ')';
    }

    public l(boolean r100, Integer r101, Integer r102, boolean r103, Integer r104, Integer r105) {
        this.supportImuSedentary = r100;
        this.sedentaryMinThreshold = r101;
        this.sedentaryMaxThreshold = r102;
        this.supportImuHeadDown = r103;
        this.headDownMinThreshold = r104;
        this.headDownMaxThreshold = r105;
    }
}
