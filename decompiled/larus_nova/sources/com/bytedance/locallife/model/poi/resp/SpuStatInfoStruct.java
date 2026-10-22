package com.bytedance.locallife.model.poi.resp;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\bHÆ\u0003JJ\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\bHÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\r\u0010\u000bR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000e\u0010\u000bR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000f\u0010\u000bR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006 "}, d2 = {"Lcom/bytedance/locallife/model/poi/resp/SpuStatInfoStruct;", "Ljava/io/Serializable;", "clickUserCount", "", "lowPrice", "saleCount", "saleCountRecently", "saleCountShow", "", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;)V", "getClickUserCount", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getLowPrice", "getSaleCount", "getSaleCountRecently", "getSaleCountShow", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;)Lcom/bytedance/locallife/model/poi/resp/SpuStatInfoStruct;", "equals", "", "other", "", "hashCode", "", "toString", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class SpuStatInfoStruct implements Serializable {

    @SerializedName("click_user_count")
    private final Long clickUserCount;

    @SerializedName("low_price")
    private final Long lowPrice;

    @SerializedName("sale_count")
    private final Long saleCount;

    @SerializedName("sale_count_l30")
    private final Long saleCountRecently;

    @SerializedName("sale_count_show")
    private final String saleCountShow;

    public SpuStatInfoStruct() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ SpuStatInfoStruct copy$default(SpuStatInfoStruct r100, Long r101, Long r102, Long r103, Long r104, String r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.clickUserCount;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.lowPrice;
    L8:
        Long r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.saleCount;
    L11:
        Long r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.saleCountRecently;
    L14:
        Long r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.saleCountShow;
    L17:
        Long r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final Long component1() {
        return this.clickUserCount;
    }

    public final Long component2() {
        return this.lowPrice;
    }

    public final Long component3() {
        return this.saleCount;
    }

    public final Long component4() {
        return this.saleCountRecently;
    }

    public final String component5() {
        return this.saleCountShow;
    }

    public final SpuStatInfoStruct copy(Long r100, Long r101, Long r110, Long r111, String r112) {
        return new SpuStatInfoStruct(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SpuStatInfoStruct) == true) goto L8;
        return false;
    L8:
        SpuStatInfoStruct r101 = (SpuStatInfoStruct) r100;
        if (Intrinsics.areEqual(this.clickUserCount, r101.clickUserCount) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.lowPrice, r101.lowPrice) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.saleCount, r101.saleCount) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.saleCountRecently, r101.saleCountRecently) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.saleCountShow, r101.saleCountShow) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        Long r100 = this.clickUserCount;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Long r104 = this.lowPrice;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Long r107 = this.saleCount;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Long r110 = this.saleCountRecently;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.saleCountShow;
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
        return "SpuStatInfoStruct(clickUserCount=" + this.clickUserCount + ", lowPrice=" + this.lowPrice + ", saleCount=" + this.saleCount + ", saleCountRecently=" + this.saleCountRecently + ", saleCountShow=" + this.saleCountShow + ')';
    }

    public final Long getClickUserCount() {
        return this.clickUserCount;
    }

    public final Long getLowPrice() {
        return this.lowPrice;
    }

    public final Long getSaleCount() {
        return this.saleCount;
    }

    public final Long getSaleCountRecently() {
        return this.saleCountRecently;
    }

    public final String getSaleCountShow() {
        return this.saleCountShow;
    }

    public SpuStatInfoStruct(Long r100, Long r101, Long r102, Long r103, String r104) {
        this.clickUserCount = r100;
        this.lowPrice = r101;
        this.saleCount = r102;
        this.saleCountRecently = r103;
        this.saleCountShow = r104;
    }

    public /* synthetic */ SpuStatInfoStruct(Long r100, Long r101, Long r102, Long r103, String r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        Long r112 = null;
    L7:
        if ((r110 & 2) == 0) goto L9;
        Long r105 = null;
    L11:
        if ((r110 & 4) == 0) goto L13;
        Long r106 = null;
    L15:
        if ((r110 & 8) == 0) goto L17;
        Long r107 = null;
    L19:
        if ((r110 & 16) == 0) goto L21;
        String r113 = null;
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
