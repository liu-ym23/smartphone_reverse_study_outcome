package com.bytedance.locallife.poi.view.mall.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\tHÆ\u0003JJ\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0006HÖ\u0001R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0010\u0010\u000eR\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\f¨\u0006\""}, d2 = {"Lcom/bytedance/locallife/poi/view/mall/model/SpuInfoCell;", "Ljava/io/Serializable;", "originPrice", "", "price", "spuName", "", "discountInfo", "spuActivityStruct", "Lcom/bytedance/locallife/poi/view/mall/model/SpuActivityStruct;", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/locallife/poi/view/mall/model/SpuActivityStruct;)V", "getDiscountInfo", "()Ljava/lang/String;", "getOriginPrice", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getPrice", "getSpuActivityStruct", "()Lcom/bytedance/locallife/poi/view/mall/model/SpuActivityStruct;", "getSpuName", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/locallife/poi/view/mall/model/SpuActivityStruct;)Lcom/bytedance/locallife/poi/view/mall/model/SpuInfoCell;", "equals", "", "other", "", "hashCode", "", "toString", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class SpuInfoCell implements Serializable {

    @SerializedName("discount_info")
    private final String discountInfo;

    @SerializedName("origin_price")
    private final Long originPrice;

    @SerializedName("price")
    private final Long price;

    @SerializedName("spu_activity_struct")
    private final SpuActivityStruct spuActivityStruct;

    @SerializedName("spu_name")
    private final String spuName;

    public SpuInfoCell() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ SpuInfoCell copy$default(SpuInfoCell r100, Long r101, Long r102, String r103, String r104, SpuActivityStruct r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.originPrice;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.price;
    L8:
        Long r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.spuName;
    L11:
        String r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.discountInfo;
    L14:
        String r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.spuActivityStruct;
    L17:
        Long r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final Long component1() {
        return this.originPrice;
    }

    public final Long component2() {
        return this.price;
    }

    public final String component3() {
        return this.spuName;
    }

    public final String component4() {
        return this.discountInfo;
    }

    public final SpuActivityStruct component5() {
        return this.spuActivityStruct;
    }

    public final SpuInfoCell copy(Long r100, Long r101, String r110, String r111, SpuActivityStruct r112) {
        return new SpuInfoCell(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SpuInfoCell) == true) goto L8;
        return false;
    L8:
        SpuInfoCell r101 = (SpuInfoCell) r100;
        if (Intrinsics.areEqual(this.originPrice, r101.originPrice) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.price, r101.price) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.spuName, r101.spuName) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.discountInfo, r101.discountInfo) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.spuActivityStruct, r101.spuActivityStruct) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        Long r100 = this.originPrice;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Long r104 = this.price;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.spuName;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.discountInfo;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        SpuActivityStruct r113 = this.spuActivityStruct;
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

    public String toString() {
        return "SpuInfoCell(originPrice=" + this.originPrice + ", price=" + this.price + ", spuName=" + this.spuName + ", discountInfo=" + this.discountInfo + ", spuActivityStruct=" + this.spuActivityStruct + ')';
    }

    public final String getDiscountInfo() {
        return this.discountInfo;
    }

    public final Long getOriginPrice() {
        return this.originPrice;
    }

    public final Long getPrice() {
        return this.price;
    }

    public final SpuActivityStruct getSpuActivityStruct() {
        return this.spuActivityStruct;
    }

    public final String getSpuName() {
        return this.spuName;
    }

    public SpuInfoCell(Long r100, Long r101, String r102, String r103, SpuActivityStruct r104) {
        this.originPrice = r100;
        this.price = r101;
        this.spuName = r102;
        this.discountInfo = r103;
        this.spuActivityStruct = r104;
    }

    public /* synthetic */ SpuInfoCell(Long r100, Long r101, String r102, String r103, SpuActivityStruct r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        Long r112 = null;
    L7:
        if ((r110 & 2) == 0) goto L9;
        Long r105 = null;
    L11:
        if ((r110 & 4) == 0) goto L13;
        String r106 = null;
    L15:
        if ((r110 & 8) == 0) goto L17;
        String r107 = null;
    L19:
        if ((r110 & 16) == 0) goto L21;
        SpuActivityStruct r113 = null;
    L22:
        this(r112, r105, r106, r107, r113);
        return;
    L21:
        r113 = r104;
        goto L22
    L17:
        r107 = r103;
        goto L19
    L13:
        r106 = r102;
        goto L15
    L9:
        r105 = r101;
        goto L11
    L5:
        r112 = r100;
        goto L7
    }
}
