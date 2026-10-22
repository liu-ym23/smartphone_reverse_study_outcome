package xi2;

import com.bytedance.android.livesdk.livecommerce.network.response.ECBackgroundAnimationType;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000b¨\u0006\u000e"}, d2 = {"Lxi2/g;", "", "", "type", "I", "getType", "()I", "", "duration", "Ljava/lang/Long;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Long;", "times", "b", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class g {

    @SerializedName("duration")
    private final Long duration;

    @SerializedName("times")
    private final Long times;

    @SerializedName("type")
    private final int type;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof g) == false) goto L12;
        g r101 = (g) r100;
        if (this.type == r101.type) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.duration, r101.duration) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.times, r101.times) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        int r100 = this.type * 31;
        Long r101 = this.duration;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        Long r105 = this.times;
        if (r105 == null) goto L10;
        r102 = r105.hashCode();
    L10:
        return r104 + r102;
    L5:
        r103 = 0;
        goto L6
    }

    public final String toString() {
        return "ECBannerAnimation(type=" + this.type + ", duration=" + this.duration + ", times=" + this.times + ")";
    }

    public g() {
        this.type = ECBackgroundAnimationType.NUMBER.getType();
        this.duration = null;
        this.times = null;
    }

    public final Long a() {
        return this.duration;
    }

    public final Long b() {
        return this.times;
    }

    public final int getType() {
        return this.type;
    }
}
