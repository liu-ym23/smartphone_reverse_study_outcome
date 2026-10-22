package he3;

import com.bytedance.android.shopping.infeed.data.idl.InFeedProductV2;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR*\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lhe3/u;", "", "", "Lcom/bytedance/android/shopping/infeed/data/idl/InFeedProductV2;", "cardsV2", "Ljava/util/List;", "a", "()Ljava/util/List;", "Lhe3/z;", "sliceConfig", "Lhe3/z;", "c", "()Lhe3/z;", "", "", "commonLogData", "Ljava/util/Map;", "b", "()Ljava/util/Map;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class u {

    @SerializedName("cards")
    private final List<InFeedProductV2> cardsV2;

    @SerializedName("common_log_data")
    private final Map<String, Object> commonLogData;

    @SerializedName("slice_config")
    private final z sliceConfig;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof u) == false) goto L12;
        u r4 = (u) r3;
        if (Intrinsics.areEqual(this.cardsV2, r4.cardsV2) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.sliceConfig, r4.sliceConfig) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.commonLogData, r4.commonLogData) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        List<InFeedProductV2> r0 = this.cardsV2;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        z r4 = this.sliceConfig;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Map<String, Object> r7 = this.commonLogData;
        if (r7 == null) goto L14;
        r1 = r7.hashCode();
    L14:
        return r6 + r1;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "DeepFeedProductBFF(cardsV2=" + this.cardsV2 + ", sliceConfig=" + this.sliceConfig + ", commonLogData=" + this.commonLogData + ")";
    }

    public u() {
        this.cardsV2 = null;
        this.sliceConfig = null;
        this.commonLogData = null;
    }

    public final List<InFeedProductV2> a() {
        return this.cardsV2;
    }

    public final Map<String, Object> b() {
        return this.commonLogData;
    }

    public final z c() {
        return this.sliceConfig;
    }
}
