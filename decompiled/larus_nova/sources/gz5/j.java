package gz5;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lgz5/j;", "", "", "Lgz5/k;", "cacheGroups", "Ljava/util/List;", "getCacheGroups", "()Ljava/util/List;", "api_release"}, k = 1, mv = {1, 4, 0})
public final class j {

    @SerializedName("cache_groups")
    private final List<k> cacheGroups;

    public j() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof j) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.cacheGroups, ((j) r100).cacheGroups) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        List<k> r100 = this.cacheGroups;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "CacheConfig(cacheGroups=" + this.cacheGroups + ")";
    }

    public j(Object r100) {
        this.cacheGroups = CollectionsKt.emptyList();
    }
}
