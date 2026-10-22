package com.bytedance.android.shopping.dto;

import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\u0006\u0010\u0019\u001a\u00020\u0014J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/shopping/dto/TaobaoCouponInfo;", "Ljava/io/Serializable;", "couponAmount", "", "couponWebUrl", "couponOpenUrl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCouponAmount", "()Ljava/lang/String;", "setCouponAmount", "(Ljava/lang/String;)V", "getCouponOpenUrl", "setCouponOpenUrl", "getCouponWebUrl", "setCouponWebUrl", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "isValid", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TaobaoCouponInfo implements Serializable {

    @SerializedName("coupon_amount")
    private String couponAmount;

    @SerializedName("coupon_open_url")
    private String couponOpenUrl;

    @SerializedName("coupon_web_url")
    private String couponWebUrl;

    public TaobaoCouponInfo() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ TaobaoCouponInfo copy$default(TaobaoCouponInfo r0, String r1, String r2, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.couponAmount;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.couponWebUrl;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.couponOpenUrl;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.couponAmount;
    }

    public final String component2() {
        return this.couponWebUrl;
    }

    public final String component3() {
        return this.couponOpenUrl;
    }

    public final TaobaoCouponInfo copy(String r2, String r3, String r4) {
        return new TaobaoCouponInfo(r2, r3, r4);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof TaobaoCouponInfo) == false) goto L12;
        TaobaoCouponInfo r4 = (TaobaoCouponInfo) r3;
        if (Intrinsics.areEqual(this.couponAmount, r4.couponAmount) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.couponWebUrl, r4.couponWebUrl) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.couponOpenUrl, r4.couponOpenUrl) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        String r0 = this.couponAmount;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.couponWebUrl;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.couponOpenUrl;
        if (r7 == null) goto L14;
        r1 = r7.hashCode();
    L14:
        return r6 + r1;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "TaobaoCouponInfo(couponAmount=" + this.couponAmount + ", couponWebUrl=" + this.couponWebUrl + ", couponOpenUrl=" + this.couponOpenUrl + ")";
    }

    public final boolean isValid() {
        if (TextUtils.isEmpty(this.couponAmount) == false) goto L5;
    L9:
        return false;
    L5:
        if (TextUtils.isEmpty(this.couponWebUrl) == true) goto L7;
    L8:
        return true;
    L7:
        if (TextUtils.isEmpty(this.couponOpenUrl) == true) goto L9;
        goto L8
    }

    public final String getCouponAmount() {
        return this.couponAmount;
    }

    public final String getCouponOpenUrl() {
        return this.couponOpenUrl;
    }

    public final String getCouponWebUrl() {
        return this.couponWebUrl;
    }

    public final void setCouponAmount(String r1) {
        this.couponAmount = r1;
    }

    public final void setCouponOpenUrl(String r1) {
        this.couponOpenUrl = r1;
    }

    public final void setCouponWebUrl(String r1) {
        this.couponWebUrl = r1;
    }

    public TaobaoCouponInfo(String r1, String r2, String r3) {
        this.couponAmount = r1;
        this.couponWebUrl = r2;
        this.couponOpenUrl = r3;
    }

    public /* synthetic */ TaobaoCouponInfo(String r2, String r3, String r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = "";
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = "";
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = "";
    L11:
        this(r2, r3, r4);
    }
}
