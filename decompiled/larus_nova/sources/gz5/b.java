package gz5;

import com.google.gson.annotations.SerializedName;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R \u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0005\u001a\u0004\b\t\u0010\u0007R\u001a\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lgz5/b;", "", "", "", "endWithDomains", "Ljava/util/Set;", "getEndWithDomains", "()Ljava/util/Set;", "startWithPaths", "getStartWithPaths", "invokeType", "Ljava/lang/String;", "getInvokeType", "()Ljava/lang/String;", "api_release"}, k = 1, mv = {1, 4, 0})
public final class b {

    @SerializedName("end_with_domains")
    private final Set<String> endWithDomains;

    @SerializedName("invoke_type")
    private final String invokeType;

    @SerializedName("start_with_paths")
    private final Set<String> startWithPaths;

    public b() {
        this(null, 7);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L12;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.endWithDomains, r101.endWithDomains) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.startWithPaths, r101.startWithPaths) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.invokeType, r101.invokeType) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        Set<String> r100 = this.endWithDomains;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Set<String> r104 = this.startWithPaths;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.invokeType;
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
        return "AllowNetworkApiConfig(endWithDomains=" + this.endWithDomains + ", startWithPaths=" + this.startWithPaths + ", invokeType=" + this.invokeType + ")";
    }

    public b(Set r100, int r101) {
        String r102 = null;
        if ((r101 & 1) == 0) goto L5;
        Set<String> r103 = SetsKt.emptySet();
    L7:
        if ((r101 & 2) == 0) goto L10;
        r100 = SetsKt.emptySet();
    L10:
        if ((r101 & 4) == 0) goto L12;
        r102 = "around";
    L12:
        this.endWithDomains = r103;
        this.startWithPaths = r100;
        this.invokeType = r102;
        return;
    L5:
        r103 = null;
        goto L7
    }
}
