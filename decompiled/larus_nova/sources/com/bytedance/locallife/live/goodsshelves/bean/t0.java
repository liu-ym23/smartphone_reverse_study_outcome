package com.bytedance.locallife.live.goodsshelves.bean;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/bytedance/locallife/live/goodsshelves/bean/t0;", "", "", "productId", "Ljava/lang/String;", "getProductId", "()Ljava/lang/String;", "Lcom/bytedance/locallife/live/goodsshelves/bean/s0;", "productEntry", "Lcom/bytedance/locallife/live/goodsshelves/bean/s0;", "b", "()Lcom/bytedance/locallife/live/goodsshelves/bean/s0;", "intentionVoucherType", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final class t0 {

    @SerializedName("intention_voucher_type")
    private final String intentionVoucherType;

    @SerializedName("product_entry")
    private final s0 productEntry;

    @SerializedName("product_id")
    private final String productId;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof t0) == true) goto L8;
        return false;
    L8:
        t0 r101 = (t0) r100;
        if (Intrinsics.areEqual(this.productId, r101.productId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.productEntry, r101.productEntry) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.intentionVoucherType, r101.intentionVoucherType) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r100 = this.productId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        s0 r104 = this.productEntry;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.intentionVoucherType;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ProductExpression(productId=" + this.productId + ", productEntry=" + this.productEntry + ", intentionVoucherType=" + this.intentionVoucherType + ')';
    }

    public t0() {
        this.productId = null;
        this.productEntry = null;
        this.intentionVoucherType = null;
    }

    public final String a() {
        return this.intentionVoucherType;
    }

    public final s0 b() {
        return this.productEntry;
    }
}
