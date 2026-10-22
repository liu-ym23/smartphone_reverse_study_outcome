package com.bytedance.android.shopping.store.hybridproduct;

import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R6\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/store/hybridproduct/j0;", "", "Ljava/util/HashMap;", "", "Lcom/bytedance/android/shopping/store/hybridproduct/i0;", "Lkotlin/collections/HashMap;", "configMap", "Ljava/util/HashMap;", "getConfigMap", "()Ljava/util/HashMap;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class j0 {

    @SerializedName("layout_config")
    private final HashMap<String, i0> configMap;

    public final boolean equals(Object r2) {
        if (this != r2) goto L4;
        return true;
    L4:
        if ((r2 instanceof j0) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.configMap, ((j0) r2).configMap) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        HashMap<String, i0> r0 = this.configMap;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    public final String toString() {
        return "ProductLayoutConfig(configMap=" + this.configMap + ")";
    }

    public j0() {
        HashMap<String, i0> r0 = new HashMap();
        Intrinsics.checkNotNullParameter(r0, "configMap");
        this.configMap = r0;
    }
}
