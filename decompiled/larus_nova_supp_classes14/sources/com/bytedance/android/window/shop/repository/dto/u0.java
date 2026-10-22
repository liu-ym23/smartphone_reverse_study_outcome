package com.bytedance.android.window.shop.repository.dto;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/window/shop/repository/dto/u0;", "", "Lcom/bytedance/android/window/shop/repository/dto/t0;", "latestDTO", "Lcom/bytedance/android/window/shop/repository/dto/t0;", "b", "()Lcom/bytedance/android/window/shop/repository/dto/t0;", "", "Lcom/bytedance/android/window/shop/repository/dto/m0;", "productList", "Ljava/util/List;", "c", "()Ljava/util/List;", "", "fold", "Ljava/lang/Boolean;", "a", "()Ljava/lang/Boolean;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class u0 {

    @SerializedName("is_fold")
    private final Boolean fold;

    @SerializedName("latest_info")
    private final t0 latestDTO;

    @SerializedName("product_list")
    private final List<m0> productList;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof u0) == false) goto L12;
        u0 r4 = (u0) r3;
        if (Intrinsics.areEqual(this.latestDTO, r4.latestDTO) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.productList, r4.productList) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.fold, r4.fold) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        t0 r0 = this.latestDTO;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        List<m0> r4 = this.productList;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Boolean r7 = this.fold;
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

    public final String toString() {
        return "WindowLiveHotLatestProductListDTO(latestDTO=" + this.latestDTO + ", productList=" + this.productList + ", fold=" + this.fold + ")";
    }

    public u0() {
        this.latestDTO = null;
        this.productList = null;
        this.fold = null;
    }

    public final Boolean a() {
        return this.fold;
    }

    public final t0 b() {
        return this.latestDTO;
    }

    public final List<m0> c() {
        return this.productList;
    }
}
