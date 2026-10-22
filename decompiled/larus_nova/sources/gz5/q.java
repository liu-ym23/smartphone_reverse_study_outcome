package gz5;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R \u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0005\u001a\u0004\b\t\u0010\u0007R \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0005\u001a\u0004\b\f\u0010\u0007¨\u0006\r"}, d2 = {"Lgz5/q;", "", "", "", "apiIds", "Ljava/util/List;", "getApiIds", "()Ljava/util/List;", "excludeApiIds", "getExcludeApiIds", "", "dataTypes", "getDataTypes", "api_release"}, k = 1, mv = {1, 4, 0})
public final class q {

    @SerializedName("api_ids")
    private final List<Integer> apiIds;

    @SerializedName("data_types")
    private final List<String> dataTypes;

    @SerializedName("exclude_api_ids")
    private final List<Integer> excludeApiIds;

    public q() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof q) == false) goto L12;
        q r101 = (q) r100;
        if (Intrinsics.areEqual(this.apiIds, r101.apiIds) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.excludeApiIds, r101.excludeApiIds) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.dataTypes, r101.dataTypes) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        List<Integer> r100 = this.apiIds;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<Integer> r104 = this.excludeApiIds;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        List<String> r107 = this.dataTypes;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "GuardRange(apiIds=" + this.apiIds + ", excludeApiIds=" + this.excludeApiIds + ", dataTypes=" + this.dataTypes + ")";
    }

    public q(Object r100) {
        List<Integer> r101 = CollectionsKt.emptyList();
        List<Integer> r102 = CollectionsKt.emptyList();
        List<String> r103 = CollectionsKt.emptyList();
        this.apiIds = r101;
        this.excludeApiIds = r102;
        this.dataTypes = r103;
    }

    public final boolean a(int r100, Set<String> r101) {
        if (this.excludeApiIds.contains(Integer.valueOf(r100)) == false) goto L6;
        return false;
    L6:
        if (this.apiIds.contains(Integer.valueOf(r100)) == false) goto L8;
    L9:
        return true;
    L8:
        if ((!CollectionsKt.intersect(this.dataTypes, r101).isEmpty()) == true) goto L9;
        return false;
    }
}
