package com.bytedance.android.shopping.feed.repository.dto;

import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/shopping/feed/repository/dto/SkuSubProductsStruct;", "Ljava/io/Serializable;", "productId", "", "combiningNum", "", "(Ljava/lang/String;I)V", "getCombiningNum", "()I", "getProductId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SkuSubProductsStruct implements Serializable {

    @SerializedName("combining_num")
    private final int combiningNum;

    @SerializedName(PdpOpenThirdParam.KEY_PRODUCT_ID)
    private final String productId;

    public SkuSubProductsStruct() {
        String r2 = null;
        this(r2, 0, 3, r2);
    }

    public static /* synthetic */ SkuSubProductsStruct copy$default(SkuSubProductsStruct r0, String r1, int r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.productId;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.combiningNum;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.productId;
    }

    public final int component2() {
        return this.combiningNum;
    }

    public final SkuSubProductsStruct copy(String r2, int r3) {
        return new SkuSubProductsStruct(r2, r3);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof SkuSubProductsStruct) == false) goto L10;
        SkuSubProductsStruct r4 = (SkuSubProductsStruct) r3;
        if (Intrinsics.areEqual(this.productId, r4.productId) == true) goto L8;
        return false;
    L8:
        if (this.combiningNum == r4.combiningNum) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        String r0 = this.productId;
        if (r0 == null) goto L5;
        int r1 = r0.hashCode();
    L7:
        return (r1 * 31) + this.combiningNum;
    L5:
        r1 = 0;
        goto L7
    }

    public String toString() {
        return "SkuSubProductsStruct(productId=" + this.productId + ", combiningNum=" + this.combiningNum + ")";
    }

    public final int getCombiningNum() {
        return this.combiningNum;
    }

    public final String getProductId() {
        return this.productId;
    }

    public SkuSubProductsStruct(String r1, int r2) {
        this.productId = r1;
        this.combiningNum = r2;
    }

    public /* synthetic */ SkuSubProductsStruct(String r1, int r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = null;
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = 1;
    L8:
        this(r1, r2);
    }
}
