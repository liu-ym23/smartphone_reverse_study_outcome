package com.bytedance.android.livesdk.livecommerce.intro.model.resp;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/p0;", "", "", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/IntroBenefit;", "data", "Ljava/util/List;", "a", "()Ljava/util/List;", "", "maxLine", "J", "getMaxLine", "()J", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class p0 {

    @SerializedName("data")
    private final List<IntroBenefit> data;

    @SerializedName("max_line")
    private final long maxLine;

    public final boolean equals(Object r5) {
        if (this != r5) goto L4;
        return true;
    L4:
        if ((r5 instanceof p0) == false) goto L10;
        p0 r6 = (p0) r5;
        if (Intrinsics.areEqual(this.data, r6.data) == true) goto L8;
        return false;
    L8:
        if (this.maxLine == r6.maxLine) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        List<IntroBenefit> r0 = this.data;
        if (r0 == null) goto L5;
        int r1 = r0.hashCode();
    L6:
        long r2 = this.maxLine;
        return (r1 * 31) + ((int) (r2 ^ (r2 >>> 32)));
    L5:
        r1 = 0;
        goto L6
    }

    public final String toString() {
        return "LineIntroBenefit(data=" + this.data + ", maxLine=" + this.maxLine + ")";
    }

    public p0() {
        this.data = null;
        this.maxLine = 0;
    }

    public final List<IntroBenefit> a() {
        return this.data;
    }
}
