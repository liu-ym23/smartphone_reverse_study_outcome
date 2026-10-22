package he3;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006¨\u0006\r"}, d2 = {"Lhe3/i;", "", "", "recReasonPrefix", "Ljava/lang/String;", "getRecReasonPrefix", "()Ljava/lang/String;", "timingText", "getTimingText", "recReasonIcon", "getRecReasonIcon", "expiredText", "getExpiredText", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class i {

    @SerializedName("expired_text")
    private final String expiredText;

    @SerializedName("rec_reason_icon")
    private final String recReasonIcon;

    @SerializedName("rec_reason_prefix")
    private final String recReasonPrefix;

    @SerializedName("timing_text")
    private final String timingText;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof i) == false) goto L14;
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.recReasonPrefix, r101.recReasonPrefix) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.timingText, r101.timingText) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.recReasonIcon, r101.recReasonIcon) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.expiredText, r101.expiredText) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        String r100 = this.recReasonPrefix;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.timingText;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.recReasonIcon;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.expiredText;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "DeepFeedCouponApplyExtra(recReasonPrefix=" + this.recReasonPrefix + ", timingText=" + this.timingText + ", recReasonIcon=" + this.recReasonIcon + ", expiredText=" + this.expiredText + ")";
    }

    public i() {
        this.recReasonPrefix = null;
        this.timingText = null;
        this.recReasonIcon = null;
        this.expiredText = null;
    }
}
