package com.bytedance.android.window.shop.repository.dto;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/window/shop/repository/dto/m0;", "", "", "itemType", "Ljava/lang/Integer;", "getItemType", "()Ljava/lang/Integer;", "setItemType", "(Ljava/lang/Integer;)V", "Lcom/bytedance/android/window/shop/repository/dto/n0;", "product", "Lcom/bytedance/android/window/shop/repository/dto/n0;", "a", "()Lcom/bytedance/android/window/shop/repository/dto/n0;", "setProduct", "(Lcom/bytedance/android/window/shop/repository/dto/n0;)V", "rank", "I", "b", "()I", "setRank", "(I)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class m0 {

    @SerializedName("item_type")
    private Integer itemType;

    @SerializedName("product")
    private n0 product;

    @SerializedName("rank")
    private int rank;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof m0) == false) goto L12;
        m0 r4 = (m0) r3;
        if (Intrinsics.areEqual(this.itemType, r4.itemType) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.product, r4.product) == true) goto L10;
        return false;
    L10:
        if (this.rank == r4.rank) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        Integer r0 = this.itemType;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        n0 r4 = this.product;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return ((r3 + r1) * 31) + this.rank;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "WindowHotLiveProductDTO(itemType=" + this.itemType + ", product=" + this.product + ", rank=" + this.rank + ")";
    }

    public m0() {
        this.itemType = null;
        this.product = null;
        this.rank = 0;
    }

    public final n0 a() {
        return this.product;
    }

    public final int b() {
        return this.rank;
    }
}
