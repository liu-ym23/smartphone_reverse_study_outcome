package m93;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lm93/j;", "", "", "impressionParams", "Ljava/lang/String;", "getImpressionParams", "()Ljava/lang/String;", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class j {

    @SerializedName("impression_params")
    private final String impressionParams;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof j) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.impressionParams, ((j) r100).impressionParams) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        String r100 = this.impressionParams;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "ImpressionData(impressionParams=" + this.impressionParams + ")";
    }

    public j() {
        this.impressionParams = null;
    }
}
