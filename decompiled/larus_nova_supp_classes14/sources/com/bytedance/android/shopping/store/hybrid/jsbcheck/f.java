package com.bytedance.android.shopping.store.hybrid.jsbcheck;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R(\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/shopping/store/hybrid/jsbcheck/f;", "", "", "perfMetricDuration", "I", "a", "()I", "", "", "shopList", "Ljava/util/Map;", "b", "()Ljava/util/Map;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class f {

    @SerializedName("perf_metric_duration")
    private final int perfMetricDuration;

    @SerializedName("shop_list")
    private final Map<String, Integer> shopList;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof f) == false) goto L10;
        f r4 = (f) r3;
        if (this.perfMetricDuration == r4.perfMetricDuration) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.shopList, r4.shopList) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        int r0 = this.perfMetricDuration * 31;
        Map<String, Integer> r1 = this.shopList;
        if (r1 == null) goto L5;
        int r2 = r1.hashCode();
    L7:
        return r0 + r2;
    L5:
        r2 = 0;
        goto L7
    }

    public final String toString() {
        return "ShopPreviewPerfConfig(perfMetricDuration=" + this.perfMetricDuration + ", shopList=" + this.shopList + ")";
    }

    public f() {
        this.perfMetricDuration = 0;
        this.shopList = null;
    }

    public final int a() {
        return this.perfMetricDuration;
    }

    public final Map<String, Integer> b() {
        return this.shopList;
    }
}
