package com.ss.android.ugc.aweme.search.common.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/config/ECSearchResultBtmConfig;", "", "", "allBtm", "Ljava/lang/String;", "getAllBtm", "()Ljava/lang/String;", "liveBtm", "getLiveBtm", "newProductBtm", "getNewProductBtm", "saleBtm", "getSaleBtm", "shopBtm", "getShopBtm", "instantBtm", "getInstantBtm", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECSearchResultBtmConfig {

    @SerializedName("goods")
    private final String allBtm;

    @SerializedName("instant")
    private final String instantBtm;

    @SerializedName("ecom_live")
    private final String liveBtm;

    @SerializedName("new_product")
    private final String newProductBtm;

    @SerializedName("ecom_on_sale")
    private final String saleBtm;

    @SerializedName("shop")
    private final String shopBtm;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ECSearchResultBtmConfig) == false) goto L18;
        ECSearchResultBtmConfig r101 = (ECSearchResultBtmConfig) r100;
        if (Intrinsics.areEqual(this.allBtm, r101.allBtm) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.liveBtm, r101.liveBtm) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.newProductBtm, r101.newProductBtm) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.saleBtm, r101.saleBtm) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.shopBtm, r101.shopBtm) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.instantBtm, r101.instantBtm) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        String r100 = this.allBtm;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.liveBtm;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.newProductBtm;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.saleBtm;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.shopBtm;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.instantBtm;
        if (r116 == null) goto L26;
        r101 = r116.hashCode();
    L26:
        return r115 + r101;
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ECSearchResultBtmConfig(allBtm=" + this.allBtm + ", liveBtm=" + this.liveBtm + ", newProductBtm=" + this.newProductBtm + ", saleBtm=" + this.saleBtm + ", shopBtm=" + this.shopBtm + ", instantBtm=" + this.instantBtm + ")";
    }

    public ECSearchResultBtmConfig() {
        this.allBtm = null;
        this.liveBtm = null;
        this.newProductBtm = null;
        this.saleBtm = null;
        this.shopBtm = null;
        this.instantBtm = null;
    }
}
