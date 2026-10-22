package com.bytedance.android.livesdk.livecommerce.intro.model.resp;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u001a\u0010\u0011\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/w;", "", "", "price", "J", "b", "()J", "d", "(J)V", "", "suffix", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "hidePrice", "a", "", "adaptiveSize", "Z", "getAdaptiveSize", "()Z", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class w {

    @SerializedName("adaptive_size")
    private final boolean adaptiveSize;

    @SerializedName("hide_price")
    private final String hidePrice;

    @SerializedName("price")
    private long price;

    @SerializedName("suffix")
    private final String suffix;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof w) == false) goto L14;
        w r7 = (w) r6;
        if (this.price == r7.price) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.suffix, r7.suffix) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.hidePrice, r7.hidePrice) == true) goto L12;
        return false;
    L12:
        if (this.adaptiveSize == r7.adaptiveSize) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r1v6, types: [int] */
    public final int hashCode() {
        long r0 = this.price;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        String r2 = this.suffix;
        int r3 = 0;
        if (r2 == null) goto L5;
        int r4 = r2.hashCode();
    L6:
        int r5 = (r1 + r4) * 31;
        String r6 = this.hidePrice;
        if (r6 == null) goto L9;
        r3 = r6.hashCode();
    L9:
        int r7 = (r5 + r3) * 31;
        boolean r8 = this.adaptiveSize;
        ?? r9 = r8;
        if (r8 == false) goto L13;
        r9 = 1;
    L13:
        return r7 + r9;
    L5:
        r4 = 0;
        goto L6
    }

    public final String toString() {
        return "IntroMinPrice(price=" + this.price + ", suffix=" + this.suffix + ", hidePrice=" + this.hidePrice + ", adaptiveSize=" + this.adaptiveSize + ")";
    }

    public w() {
        this.price = 0;
        this.suffix = null;
        this.hidePrice = null;
        this.adaptiveSize = false;
    }

    public final String a() {
        return this.hidePrice;
    }

    public final long b() {
        return this.price;
    }

    public final String c() {
        return this.suffix;
    }

    public final void d(long r1) {
        this.price = r1;
    }
}
