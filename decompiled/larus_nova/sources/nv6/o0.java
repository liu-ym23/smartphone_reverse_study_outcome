package nv6;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R*\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lnv6/o0;", "", "", "", "extra", "Ljava/util/Map;", "getExtra", "()Ljava/util/Map;", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final class o0 {

    @SerializedName("extra")
    private final Map<String, Object> extra;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof o0) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.extra, ((o0) r100).extra) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        Map<String, Object> r100 = this.extra;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public final String toString() {
        return "ShelfParams(extra=" + this.extra + ')';
    }

    public o0() {
        this.extra = null;
    }
}
