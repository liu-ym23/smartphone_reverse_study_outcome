package he3;

import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lhe3/p;", "", "", "Lhe3/o;", "text", "Ljava/util/List;", "b", "()Ljava/util/List;", "", "prefix", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class p {

    @SerializedName("prefix")
    private final String prefix;

    @SerializedName(BitableAnalytic.LocationClickType.WORDS)
    private final List<o> text;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof p) == false) goto L10;
        p r101 = (p) r100;
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.prefix, r101.prefix) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        List<o> r100 = this.text;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.prefix;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "DeepFeedImpressionWordInfo(text=" + this.text + ", prefix=" + this.prefix + ")";
    }

    public p() {
        this.text = null;
        this.prefix = null;
    }

    public final String a() {
        return this.prefix;
    }

    public final List<o> b() {
        return this.text;
    }
}
