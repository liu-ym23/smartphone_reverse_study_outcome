package com.bytedance.android.window.shop.innerflow.entity.dto;

import com.bytedance.android.ec.model.api.CommerceBaseResponse;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import up3.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u0015\u0010\u0005\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002HÆ\u0001J\t\u0010\u0007\u001a\u00020\u0006HÖ\u0001J\t\u0010\t\u001a\u00020\bHÖ\u0001J\u0013\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/window/shop/innerflow/entity/dto/ECShopInnerFlowCartInfoDTO;", "Lcom/bytedance/android/ec/model/api/CommerceBaseResponse;", "Lup3/a;", "component1", "shopCartInfoDTO", "copy", "", "toString", "", "hashCode", "", "other", "", "equals", "Lup3/a;", "getShopCartInfoDTO", "()Lup3/a;", "<init>", "(Lup3/a;)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECShopInnerFlowCartInfoDTO extends CommerceBaseResponse {

    @SerializedName("shop_cart")
    private final a shopCartInfoDTO;

    public ECShopInnerFlowCartInfoDTO() {
        a r0 = null;
        this(r0, 1, r0);
    }

    public static /* synthetic */ ECShopInnerFlowCartInfoDTO copy$default(ECShopInnerFlowCartInfoDTO r0, a r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.shopCartInfoDTO;
    L6:
        return r0.copy(r1);
    }

    public final a component1() {
        return this.shopCartInfoDTO;
    }

    public final ECShopInnerFlowCartInfoDTO copy(a r2) {
        return new ECShopInnerFlowCartInfoDTO(r2);
    }

    public boolean equals(Object r2) {
        if (this != r2) goto L4;
        return true;
    L4:
        if ((r2 instanceof ECShopInnerFlowCartInfoDTO) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.shopCartInfoDTO, ((ECShopInnerFlowCartInfoDTO) r2).shopCartInfoDTO) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public int hashCode() {
        a r0 = this.shopCartInfoDTO;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    public String toString() {
        return "ECShopInnerFlowCartInfoDTO(shopCartInfoDTO=" + this.shopCartInfoDTO + ")";
    }

    public final a getShopCartInfoDTO() {
        return this.shopCartInfoDTO;
    }

    public ECShopInnerFlowCartInfoDTO(a r1) {
        this.shopCartInfoDTO = r1;
    }

    public /* synthetic */ ECShopInnerFlowCartInfoDTO(a r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        this(r1);
    }
}
