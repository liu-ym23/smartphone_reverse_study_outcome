package com.bytedance.android.shopping.store.hybridproduct.dto;

import com.bytedance.android.ec.model.api.CommerceBaseResponse;
import com.google.gson.annotations.SerializedName;
import dj3.a;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0018\u0010\u0019J\u0011\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003J\u0017\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J3\u0010\n\u001a\u00020\u00002\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\t\u0010\u000b\u001a\u00020\u0006HÖ\u0001J\t\u0010\r\u001a\u00020\fHÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R(\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/shopping/store/hybridproduct/dto/ShopCouponResponseDTO;", "Lcom/bytedance/android/ec/model/api/CommerceBaseResponse;", "", "Ldj3/a;", "component1", "", "", "component2", "couponItemList", "extra", "copy", "toString", "", "hashCode", "", "other", "", "equals", "Ljava/util/List;", "getCouponItemList", "()Ljava/util/List;", "Ljava/util/Map;", "getExtra", "()Ljava/util/Map;", "<init>", "(Ljava/util/List;Ljava/util/Map;)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShopCouponResponseDTO extends CommerceBaseResponse {

    @SerializedName("coupon_resp_item_list")
    private final List<a> couponItemList;

    @SerializedName("extra")
    private final Map<String, String> extra;

    /* JADX WARN: Multi-variable type inference failed */
    public ShopCouponResponseDTO() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ShopCouponResponseDTO copy$default(ShopCouponResponseDTO r0, List r1, Map r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.couponItemList;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.extra;
    L9:
        return r0.copy(r1, r2);
    }

    public final List<a> component1() {
        return this.couponItemList;
    }

    public final Map<String, String> component2() {
        return this.extra;
    }

    public final ShopCouponResponseDTO copy(List<a> r2, Map<String, String> r3) {
        return new ShopCouponResponseDTO(r2, r3);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof ShopCouponResponseDTO) == false) goto L10;
        ShopCouponResponseDTO r4 = (ShopCouponResponseDTO) r3;
        if (Intrinsics.areEqual(this.couponItemList, r4.couponItemList) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.extra, r4.extra) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        List<a> r0 = this.couponItemList;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Map<String, String> r4 = this.extra;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "ShopCouponResponseDTO(couponItemList=" + this.couponItemList + ", extra=" + this.extra + ")";
    }

    public final List<a> getCouponItemList() {
        return this.couponItemList;
    }

    public final Map<String, String> getExtra() {
        return this.extra;
    }

    public ShopCouponResponseDTO(List<a> r1, Map<String, String> r2) {
        this.couponItemList = r1;
        this.extra = r2;
    }

    public /* synthetic */ ShopCouponResponseDTO(List r2, Map r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }
}
