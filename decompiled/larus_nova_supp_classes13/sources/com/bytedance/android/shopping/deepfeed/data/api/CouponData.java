package com.bytedance.android.shopping.deepfeed.data.api;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\tHÆ\u0003J7\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/data/api/CouponData;", "Ljava/io/Serializable;", "coupon", "Lcom/bytedance/android/shopping/deepfeed/data/api/Coupon;", "couponMeta", "Lcom/bytedance/android/shopping/deepfeed/data/api/CouponMeta;", "applied", "", "extra", "Lcom/bytedance/android/shopping/deepfeed/data/api/CouponExtra;", "(Lcom/bytedance/android/shopping/deepfeed/data/api/Coupon;Lcom/bytedance/android/shopping/deepfeed/data/api/CouponMeta;ZLcom/bytedance/android/shopping/deepfeed/data/api/CouponExtra;)V", "getApplied", "()Z", "getCoupon", "()Lcom/bytedance/android/shopping/deepfeed/data/api/Coupon;", "getCouponMeta", "()Lcom/bytedance/android/shopping/deepfeed/data/api/CouponMeta;", "getExtra", "()Lcom/bytedance/android/shopping/deepfeed/data/api/CouponExtra;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "", "toString", "", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CouponData implements Serializable {

    @SerializedName("applied")
    private final boolean applied;

    @SerializedName("coupon")
    private final Coupon coupon;

    @SerializedName("coupon_meta")
    private final CouponMeta couponMeta;

    @SerializedName("extra")
    private final CouponExtra extra;

    public CouponData() {
        this(null, null, false, null, 15, null);
    }

    public static /* synthetic */ CouponData copy$default(CouponData r0, Coupon r1, CouponMeta r2, boolean r3, CouponExtra r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.coupon;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.couponMeta;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.applied;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.extra;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final Coupon component1() {
        return this.coupon;
    }

    public final CouponMeta component2() {
        return this.couponMeta;
    }

    public final boolean component3() {
        return this.applied;
    }

    public final CouponExtra component4() {
        return this.extra;
    }

    public final CouponData copy(Coupon r2, CouponMeta r3, boolean r4, CouponExtra r5) {
        return new CouponData(r2, r3, r4, r5);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof CouponData) == false) goto L14;
        CouponData r4 = (CouponData) r3;
        if (Intrinsics.areEqual(this.coupon, r4.coupon) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.couponMeta, r4.couponMeta) == true) goto L10;
        return false;
    L10:
        if (this.applied == r4.applied) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.extra, r4.extra) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v8 */
    public int hashCode() {
        Coupon r0 = this.coupon;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        CouponMeta r4 = this.couponMeta;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        boolean r7 = this.applied;
        ?? r8 = r7;
        if (r7 == false) goto L13;
        r8 = 1;
    L13:
        int r9 = (r6 + r8) * 31;
        CouponExtra r10 = this.extra;
        if (r10 == null) goto L17;
        r1 = r10.hashCode();
    L17:
        return r9 + r1;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "CouponData(coupon=" + this.coupon + ", couponMeta=" + this.couponMeta + ", applied=" + this.applied + ", extra=" + this.extra + ")";
    }

    public final boolean getApplied() {
        return this.applied;
    }

    public final Coupon getCoupon() {
        return this.coupon;
    }

    public final CouponMeta getCouponMeta() {
        return this.couponMeta;
    }

    public final CouponExtra getExtra() {
        return this.extra;
    }

    public CouponData(Coupon r1, CouponMeta r2, boolean r3, CouponExtra r4) {
        this.coupon = r1;
        this.couponMeta = r2;
        this.applied = r3;
        this.extra = r4;
    }

    public /* synthetic */ CouponData(Coupon r2, CouponMeta r3, boolean r4, CouponExtra r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = false;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = null;
    L14:
        this(r2, r3, r4, r5);
    }
}
