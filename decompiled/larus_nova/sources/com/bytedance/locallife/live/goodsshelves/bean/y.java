package com.bytedance.locallife.live.goodsshelves.bean;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/bytedance/locallife/live/goodsshelves/bean/y;", "", "", "stock", "Ljava/lang/Long;", "getStock", "()Ljava/lang/Long;", "roomSoldCount", "getRoomSoldCount", "roomSoldStartTime", "getRoomSoldStartTime", "soldCount30Days", "getSoldCount30Days", "roomOrderNum", "getRoomOrderNum", "", "soldMagnitude30Days", "Ljava/lang/Integer;", "getSoldMagnitude30Days", "()Ljava/lang/Integer;", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final class y {

    @SerializedName("room_order_num")
    private final Long roomOrderNum;

    @SerializedName("room_sold_count")
    private final Long roomSoldCount;

    @SerializedName("room_sold_start_time")
    private final Long roomSoldStartTime;

    @SerializedName("sold_count_30_days")
    private final Long soldCount30Days;

    @SerializedName("sold_magnitude_30_days")
    private final Integer soldMagnitude30Days;

    @SerializedName("stock")
    private final Long stock;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof y) == true) goto L8;
        return false;
    L8:
        y r101 = (y) r100;
        if (Intrinsics.areEqual(this.stock, r101.stock) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.roomSoldCount, r101.roomSoldCount) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.roomSoldStartTime, r101.roomSoldStartTime) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.soldCount30Days, r101.soldCount30Days) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.roomOrderNum, r101.roomOrderNum) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.soldMagnitude30Days, r101.soldMagnitude30Days) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        Long r100 = this.stock;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Long r104 = this.roomSoldCount;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Long r107 = this.roomSoldStartTime;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Long r110 = this.soldCount30Days;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Long r113 = this.roomOrderNum;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Integer r116 = this.soldMagnitude30Days;
        if (r116 == null) goto L27;
        r101 = r116.hashCode();
    L27:
        return r115 + r101;
    L21:
        r114 = r113.hashCode();
        goto L22
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
        return "LiveLifeBFFCardSalesData(stock=" + this.stock + ", roomSoldCount=" + this.roomSoldCount + ", roomSoldStartTime=" + this.roomSoldStartTime + ", soldCount30Days=" + this.soldCount30Days + ", roomOrderNum=" + this.roomOrderNum + ", soldMagnitude30Days=" + this.soldMagnitude30Days + ')';
    }
}
