package com.bytedance.android.shopping.anchorv4.voavhs.detailhead;

import com.bytedance.android.shopping.anchorv3.repository.dto.ProductFormatGroup;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J+\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/detailhead/AnchorV4SubProduct;", "Ljava/io/Serializable;", "combineNum", "", "subProductId", "", "productFormatGroup", "Lcom/bytedance/android/shopping/anchorv3/repository/dto/ProductFormatGroup;", "(ILjava/lang/String;Lcom/bytedance/android/shopping/anchorv3/repository/dto/ProductFormatGroup;)V", "getCombineNum", "()I", "getProductFormatGroup", "()Lcom/bytedance/android/shopping/anchorv3/repository/dto/ProductFormatGroup;", "getSubProductId", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4SubProduct implements Serializable {
    private final int combineNum;
    private final ProductFormatGroup productFormatGroup;
    private final String subProductId;

    public AnchorV4SubProduct() {
        this(0, null, null, 7, null);
    }

    public static /* synthetic */ AnchorV4SubProduct copy$default(AnchorV4SubProduct r0, int r1, String r2, ProductFormatGroup r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.combineNum;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.subProductId;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.productFormatGroup;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final int component1() {
        return this.combineNum;
    }

    public final String component2() {
        return this.subProductId;
    }

    public final ProductFormatGroup component3() {
        return this.productFormatGroup;
    }

    public final AnchorV4SubProduct copy(int r2, String r3, ProductFormatGroup r4) {
        return new AnchorV4SubProduct(r2, r3, r4);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof AnchorV4SubProduct) == false) goto L12;
        AnchorV4SubProduct r4 = (AnchorV4SubProduct) r3;
        if (this.combineNum == r4.combineNum) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.subProductId, r4.subProductId) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.productFormatGroup, r4.productFormatGroup) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        int r0 = this.combineNum * 31;
        String r1 = this.subProductId;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.hashCode();
    L6:
        int r4 = (r0 + r3) * 31;
        ProductFormatGroup r5 = this.productFormatGroup;
        if (r5 == null) goto L10;
        r2 = r5.hashCode();
    L10:
        return r4 + r2;
    L5:
        r3 = 0;
        goto L6
    }

    public String toString() {
        return "AnchorV4SubProduct(combineNum=" + this.combineNum + ", subProductId=" + this.subProductId + ", productFormatGroup=" + this.productFormatGroup + ")";
    }

    public final int getCombineNum() {
        return this.combineNum;
    }

    public final ProductFormatGroup getProductFormatGroup() {
        return this.productFormatGroup;
    }

    public final String getSubProductId() {
        return this.subProductId;
    }

    public AnchorV4SubProduct(int r1, String r2, ProductFormatGroup r3) {
        this.combineNum = r1;
        this.subProductId = r2;
        this.productFormatGroup = r3;
    }

    public /* synthetic */ AnchorV4SubProduct(int r1, String r2, ProductFormatGroup r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = 0;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = "";
    L9:
        if ((r4 & 4) == 0) goto L11;
        r3 = null;
    L11:
        this(r1, r2, r3);
    }
}
