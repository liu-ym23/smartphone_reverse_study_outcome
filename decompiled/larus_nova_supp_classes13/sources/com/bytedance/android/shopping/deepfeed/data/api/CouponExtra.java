package com.bytedance.android.shopping.deepfeed.data.api;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\bJ&\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/data/api/CouponExtra;", "Ljava/io/Serializable;", "exchangeType", "", "exchangeAmount", "", "(Ljava/lang/String;Ljava/lang/Long;)V", "getExchangeAmount", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getExchangeType", "()Ljava/lang/String;", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Long;)Lcom/bytedance/android/shopping/deepfeed/data/api/CouponExtra;", "equals", "", "other", "", "hashCode", "", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CouponExtra implements Serializable {

    @SerializedName("exchange_amount")
    private final Long exchangeAmount;

    @SerializedName("exchange_type")
    private final String exchangeType;

    /* JADX WARN: Multi-variable type inference failed */
    public CouponExtra() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ CouponExtra copy$default(CouponExtra r0, String r1, Long r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.exchangeType;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.exchangeAmount;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.exchangeType;
    }

    public final Long component2() {
        return this.exchangeAmount;
    }

    public final CouponExtra copy(String r2, Long r3) {
        return new CouponExtra(r2, r3);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof CouponExtra) == false) goto L10;
        CouponExtra r4 = (CouponExtra) r3;
        if (Intrinsics.areEqual(this.exchangeType, r4.exchangeType) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.exchangeAmount, r4.exchangeAmount) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        String r0 = this.exchangeType;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Long r4 = this.exchangeAmount;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "CouponExtra(exchangeType=" + this.exchangeType + ", exchangeAmount=" + this.exchangeAmount + ")";
    }

    public final Long getExchangeAmount() {
        return this.exchangeAmount;
    }

    public final String getExchangeType() {
        return this.exchangeType;
    }

    public CouponExtra(String r1, Long r2) {
        this.exchangeType = r1;
        this.exchangeAmount = r2;
    }

    public /* synthetic */ CouponExtra(String r2, Long r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }
}
