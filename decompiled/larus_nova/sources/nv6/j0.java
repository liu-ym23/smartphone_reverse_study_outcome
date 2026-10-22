package nv6;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006¨\u0006\u000b"}, d2 = {"Lnv6/j0;", "", "", "startColor", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "centerColor", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "endColor", "b", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final class j0 {

    @SerializedName("center_color")
    private final String centerColor;

    @SerializedName("end_color")
    private final String endColor;

    @SerializedName("start_color")
    private final String startColor;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j0) == true) goto L8;
        return false;
    L8:
        j0 r101 = (j0) r100;
        if (Intrinsics.areEqual(this.startColor, r101.startColor) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.centerColor, r101.centerColor) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.endColor, r101.endColor) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r100 = this.startColor;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.centerColor;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.endColor;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ProductRewardGradientBg(startColor=" + this.startColor + ", centerColor=" + this.centerColor + ", endColor=" + this.endColor + ')';
    }

    public j0() {
        this.startColor = null;
        this.centerColor = null;
        this.endColor = null;
    }

    public final String a() {
        return this.centerColor;
    }

    public final String b() {
        return this.endColor;
    }

    public final String c() {
        return this.startColor;
    }
}
