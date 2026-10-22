package com.bytedance.android.shopping.ligo.container.event;

import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0013J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\nHÆ\u0003JR\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020\u0003HÖ\u0001J\t\u0010$\u001a\u00020\u0005HÖ\u0001R\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006%"}, d2 = {"Lcom/bytedance/android/shopping/ligo/container/event/LiveLigoCartStatusChangeEventData;", "Ljava/io/Serializable;", "status", "", "productId", "", "skuId", "skuNum", "eventFrom", "cartExtra", "Lcom/bytedance/android/shopping/ligo/container/event/AddCartExtraData;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lcom/bytedance/android/shopping/ligo/container/event/AddCartExtraData;)V", "getCartExtra", "()Lcom/bytedance/android/shopping/ligo/container/event/AddCartExtraData;", "getEventFrom", "()Ljava/lang/String;", "getProductId", "getSkuId", "getSkuNum", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getStatus", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lcom/bytedance/android/shopping/ligo/container/event/AddCartExtraData;)Lcom/bytedance/android/shopping/ligo/container/event/LiveLigoCartStatusChangeEventData;", "equals", "", "other", "", "hashCode", "toString", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveLigoCartStatusChangeEventData implements Serializable {

    @SerializedName("cart_extra")
    private final AddCartExtraData cartExtra;

    @SerializedName("event_from")
    private final String eventFrom;

    @SerializedName(PdpOpenThirdParam.KEY_PRODUCT_ID)
    private final String productId;

    @SerializedName("sku_id")
    private final String skuId;

    @SerializedName("sku_num")
    private final Integer skuNum;

    @SerializedName("status")
    private final int status;

    public static /* synthetic */ LiveLigoCartStatusChangeEventData copy$default(LiveLigoCartStatusChangeEventData r4, int r5, String r6, String r7, Integer r8, String r9, AddCartExtraData r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.status;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.productId;
    L8:
        String r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.skuId;
    L11:
        String r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.skuNum;
    L14:
        Integer r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.eventFrom;
    L17:
        String r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.cartExtra;
    L20:
        int r14 = r5;
        return r4.copy(r14, r13, r0, r1, r2, r10);
    }

    public final int component1() {
        return this.status;
    }

    public final String component2() {
        return this.productId;
    }

    public final String component3() {
        return this.skuId;
    }

    public final Integer component4() {
        return this.skuNum;
    }

    public final String component5() {
        return this.eventFrom;
    }

    public final AddCartExtraData component6() {
        return this.cartExtra;
    }

    public final LiveLigoCartStatusChangeEventData copy(int r9, String r10, String r11, Integer r12, String r13, AddCartExtraData r14) {
        Intrinsics.checkNotNullParameter(r13, "eventFrom");
        return new LiveLigoCartStatusChangeEventData(r9, r10, r11, r12, r13, r14);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof LiveLigoCartStatusChangeEventData) == false) goto L18;
        LiveLigoCartStatusChangeEventData r4 = (LiveLigoCartStatusChangeEventData) r3;
        if (this.status == r4.status) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.productId, r4.productId) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.skuId, r4.skuId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.skuNum, r4.skuNum) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.eventFrom, r4.eventFrom) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.cartExtra, r4.cartExtra) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public int hashCode() {
        int r0 = this.status * 31;
        String r1 = this.productId;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.hashCode();
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.skuId;
        if (r5 == null) goto L9;
        int r6 = r5.hashCode();
    L10:
        int r7 = (r4 + r6) * 31;
        Integer r8 = this.skuNum;
        if (r8 == null) goto L13;
        int r9 = r8.hashCode();
    L14:
        int r10 = (r7 + r9) * 31;
        String r11 = this.eventFrom;
        if (r11 == null) goto L17;
        int r12 = r11.hashCode();
    L18:
        int r13 = (r10 + r12) * 31;
        AddCartExtraData r14 = this.cartExtra;
        if (r14 == null) goto L22;
        r2 = r14.hashCode();
    L22:
        return r13 + r2;
    L17:
        r12 = 0;
        goto L18
    L13:
        r9 = 0;
        goto L14
    L9:
        r6 = 0;
        goto L10
    L5:
        r3 = 0;
        goto L6
    }

    public String toString() {
        return "LiveLigoCartStatusChangeEventData(status=" + this.status + ", productId=" + this.productId + ", skuId=" + this.skuId + ", skuNum=" + this.skuNum + ", eventFrom=" + this.eventFrom + ", cartExtra=" + this.cartExtra + ")";
    }

    public final AddCartExtraData getCartExtra() {
        return this.cartExtra;
    }

    public final String getEventFrom() {
        return this.eventFrom;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final String getSkuId() {
        return this.skuId;
    }

    public final Integer getSkuNum() {
        return this.skuNum;
    }

    public final int getStatus() {
        return this.status;
    }

    public LiveLigoCartStatusChangeEventData(int r2, String r3, String r4, Integer r5, String r6, AddCartExtraData r7) {
        Intrinsics.checkNotNullParameter(r6, "eventFrom");
        this.status = r2;
        this.productId = r3;
        this.skuId = r4;
        this.skuNum = r5;
        this.eventFrom = r6;
        this.cartExtra = r7;
    }

    public /* synthetic */ LiveLigoCartStatusChangeEventData(int r8, String r9, String r10, Integer r11, String r12, AddCartExtraData r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 16) == 0) goto L5;
        r12 = "edit_cart_from_other";
    L5:
        this(r8, r9, r10, r11, r12, r13);
    }
}
