package com.bytedance.android.livesdk.livecommerce.intro.model.resp;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/m0;", "", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/w;", "minPrice", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/w;", "b", "()Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/w;", "", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/IntroPriceDescription;", "descriptions", "Ljava/util/List;", "a", "()Ljava/util/List;", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class m0 {

    @SerializedName("descriptions")
    private final List<IntroPriceDescription> descriptions;

    @SerializedName("min_price")
    private final w minPrice;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof m0) == false) goto L10;
        m0 r4 = (m0) r3;
        if (Intrinsics.areEqual(this.minPrice, r4.minPrice) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.descriptions, r4.descriptions) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        w r0 = this.minPrice;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        List<IntroPriceDescription> r4 = this.descriptions;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "IntroShowPrice(minPrice=" + this.minPrice + ", descriptions=" + this.descriptions + ")";
    }

    public m0() {
        this.minPrice = null;
        this.descriptions = null;
    }

    public final List<IntroPriceDescription> a() {
        return this.descriptions;
    }

    public final w b() {
        return this.minPrice;
    }
}
