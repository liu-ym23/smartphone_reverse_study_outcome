package h73;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R(\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lh73/b;", "", "", "", "skuMappings", "Ljava/util/Map;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/Map;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("sku_mappings")
    private final Map<String, String> skuMappings;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.skuMappings, ((b) r100).skuMappings) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        Map<String, String> r100 = this.skuMappings;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "SkuMeta(skuMappings=" + this.skuMappings + ")";
    }

    public b() {
        this.skuMappings = null;
    }

    public final Map<String, String> a() {
        return this.skuMappings;
    }
}
