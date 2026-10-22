package gz5;

import com.google.gson.annotations.SerializedName;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\"\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lgz5/d;", "", "", "", "apiIds", "Ljava/util/Set;", "getApiIds", "()Ljava/util/Set;", "", "invokeType", "Ljava/lang/String;", "getInvokeType", "()Ljava/lang/String;", "api_release"}, k = 1, mv = {1, 4, 0})
public final class d {

    @SerializedName("api_ids")
    private final Set<Integer> apiIds;

    @SerializedName("invoke_type")
    private final String invokeType;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L10;
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.apiIds, r101.apiIds) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.invokeType, r101.invokeType) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        Set<Integer> r100 = this.apiIds;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.invokeType;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "AllowNetworkIdConfig(apiIds=" + this.apiIds + ", invokeType=" + this.invokeType + ")";
    }

    public d() {
        this(SetsKt.emptySet(), "around");
    }

    public d(Set<Integer> r100, String r101) {
        this.apiIds = r100;
        this.invokeType = r101;
    }
}
