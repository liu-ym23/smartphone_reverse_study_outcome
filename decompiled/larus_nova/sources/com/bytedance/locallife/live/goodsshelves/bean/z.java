package com.bytedance.locallife.live.goodsshelves.bean;

import com.google.gson.annotations.SerializedName;
import com.hihonor.honorid.core.data.UserInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/bytedance/locallife/live/goodsshelves/bean/z;", "", "Lcom/bytedance/locallife/live/goodsshelves/bean/y;", "salesData", "Lcom/bytedance/locallife/live/goodsshelves/bean/y;", "getSalesData", "()Lcom/bytedance/locallife/live/goodsshelves/bean/y;", "Lcom/bytedance/locallife/live/goodsshelves/bean/v;", "priceData", "Lcom/bytedance/locallife/live/goodsshelves/bean/v;", "getPriceData", "()Lcom/bytedance/locallife/live/goodsshelves/bean/v;", "Lcom/bytedance/locallife/live/goodsshelves/bean/w;", "productData", "Lcom/bytedance/locallife/live/goodsshelves/bean/w;", "getProductData", "()Lcom/bytedance/locallife/live/goodsshelves/bean/w;", "Lcom/bytedance/locallife/live/goodsshelves/bean/a0;", "serviceData", "Lcom/bytedance/locallife/live/goodsshelves/bean/a0;", "getServiceData", "()Lcom/bytedance/locallife/live/goodsshelves/bean/a0;", "", UserInfo.UPDATE_TIME, "Ljava/lang/Long;", "getUpdateTime", "()Ljava/lang/Long;", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final class z {

    @SerializedName("price_data")
    private final v priceData;

    @SerializedName("product_data")
    private final w productData;

    @SerializedName("sales_data")
    private final y salesData;

    @SerializedName("service_data")
    private final a0 serviceData;

    @SerializedName("update_time")
    private final Long updateTime;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof z) == true) goto L8;
        return false;
    L8:
        z r101 = (z) r100;
        if (Intrinsics.areEqual(this.salesData, r101.salesData) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.priceData, r101.priceData) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.productData, r101.productData) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.serviceData, r101.serviceData) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.updateTime, r101.updateTime) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        y r100 = this.salesData;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        v r104 = this.priceData;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        w r107 = this.productData;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        a0 r110 = this.serviceData;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Long r113 = this.updateTime;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return r112 + r101;
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "LiveLifeBFFCardSellingAtmosInfo(salesData=" + this.salesData + ", priceData=" + this.priceData + ", productData=" + this.productData + ", serviceData=" + this.serviceData + ", updateTime=" + this.updateTime + ')';
    }
}
