package he3;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lhe3/m1;", "", "Lhe3/m;", "deepFeedExtendInfo", "Lhe3/m;", "a", "()Lhe3/m;", "b", "(Lhe3/m;)V", "", "", "passThroughInfo", "Ljava/util/Map;", "getPassThroughInfo", "()Ljava/util/Map;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class m1 {

    @SerializedName("deep_feed_extend_info")
    private m deepFeedExtendInfo;

    @SerializedName("pass_through_info")
    private final Map<String, String> passThroughInfo;

    public m1() {
        this(null, 3);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof m1) == false) goto L10;
        m1 r4 = (m1) r3;
        if (Intrinsics.areEqual(this.deepFeedExtendInfo, r4.deepFeedExtendInfo) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.passThroughInfo, r4.passThroughInfo) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        m r0 = this.deepFeedExtendInfo;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Map<String, String> r4 = this.passThroughInfo;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "ProductExtendInfo(deepFeedExtendInfo=" + this.deepFeedExtendInfo + ", passThroughInfo=" + this.passThroughInfo + ")";
    }

    public final m a() {
        return this.deepFeedExtendInfo;
    }

    public final void b(m r1) {
        this.deepFeedExtendInfo = r1;
    }

    public m1(m r2, int r3) {
        if ((r3 & 1) == 0) goto L5;
        r2 = null;
    L5:
        this.deepFeedExtendInfo = r2;
        this.passThroughInfo = null;
    }
}
