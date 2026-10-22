package com.bytedance.android.window.shop.repository.dto;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/window/shop/repository/dto/c1;", "", "", "recommendText", "Ljava/lang/String;", "getRecommendText", "()Ljava/lang/String;", "setRecommendText", "(Ljava/lang/String;)V", "storeName", "a", "setStoreName", "storeUrl", "c", "setStoreUrl", "", "storeProductCount", "Ljava/lang/Integer;", "b", "()Ljava/lang/Integer;", "setStoreProductCount", "(Ljava/lang/Integer;)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c1 {

    @SerializedName("recommend_text")
    private String recommendText;

    @SerializedName("store_name")
    private String storeName;

    @SerializedName("store_product_count")
    private Integer storeProductCount;

    @SerializedName("store_url")
    private String storeUrl;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof c1) == false) goto L14;
        c1 r4 = (c1) r3;
        if (Intrinsics.areEqual(this.recommendText, r4.recommendText) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.storeName, r4.storeName) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.storeUrl, r4.storeUrl) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.storeProductCount, r4.storeProductCount) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        String r0 = this.recommendText;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.storeName;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.storeUrl;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        Integer r10 = this.storeProductCount;
        if (r10 == null) goto L18;
        r1 = r10.hashCode();
    L18:
        return r9 + r1;
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "WindowStoreEntranceDTO(recommendText=" + this.recommendText + ", storeName=" + this.storeName + ", storeUrl=" + this.storeUrl + ", storeProductCount=" + this.storeProductCount + ")";
    }

    public c1() {
        this.recommendText = null;
        this.storeName = null;
        this.storeUrl = null;
        this.storeProductCount = null;
    }

    public final String a() {
        return this.storeName;
    }

    public final Integer b() {
        return this.storeProductCount;
    }

    public final String c() {
        return this.storeUrl;
    }
}
