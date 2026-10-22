package com.bytedance.locallife.groupon.struct;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0087\b\u0018\u00002\u00020\u0001B[\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b%\u0010&J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u000b\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004Jd\u0010\u0014\u001a\u00020\u00132\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0002HÖ\u0001J\u0013\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u001b\u001a\u0004\b\u001c\u0010\u0004R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001d\u001a\u0004\b \u0010\u001fR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001d\u001a\u0004\b!\u0010\u001fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001d\u001a\u0004\b\"\u0010\u001fR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001d\u001a\u0004\b#\u0010\u001fR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u001b\u001a\u0004\b$\u0010\u0004¨\u0006'"}, d2 = {"com/bytedance/locallife/groupon/struct/NearbyTabPinTopConfig$CouponInfo", "", "", "component1", "()Ljava/lang/Integer;", "", "component2", "component3", "component4", "component5", "component6", "component7", "amount", "couponDesc", "transCouponData", "tittle", "couponId", "couponType", "barAmount", "Lcom/bytedance/locallife/groupon/struct/NearbyTabPinTopConfig$CouponInfo;", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/bytedance/locallife/groupon/struct/NearbyTabPinTopConfig$CouponInfo;", "toString", "hashCode", "other", "", "equals", "Ljava/lang/Integer;", "getAmount", "Ljava/lang/String;", "getCouponDesc", "()Ljava/lang/String;", "getTransCouponData", "getTittle", "getCouponId", "getCouponType", "getBarAmount", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3})
public final class NearbyTabPinTopConfig$CouponInfo {

    @SerializedName("amount")
    private final Integer amount;

    @SerializedName("bar_amount")
    private final Integer barAmount;

    @SerializedName("coupon_desc")
    private final String couponDesc;

    @SerializedName("coupon_id")
    private final String couponId;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_COUPON_TYPE)
    private final String couponType;

    @SerializedName("title")
    private final String tittle;

    @SerializedName("trans_coupon_data")
    private final String transCouponData;

    public NearbyTabPinTopConfig$CouponInfo() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ NearbyTabPinTopConfig$CouponInfo copy$default(NearbyTabPinTopConfig$CouponInfo r100, Integer r101, String r102, String r103, String r104, String r110, String r111, Integer r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.amount;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.couponDesc;
    L8:
        String r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.transCouponData;
    L11:
        String r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.tittle;
    L14:
        String r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.couponId;
    L17:
        String r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.couponType;
    L20:
        String r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.barAmount;
    L23:
        Integer r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    public final Integer component1() {
        return this.amount;
    }

    public final String component2() {
        return this.couponDesc;
    }

    public final String component3() {
        return this.transCouponData;
    }

    public final String component4() {
        return this.tittle;
    }

    public final String component5() {
        return this.couponId;
    }

    public final String component6() {
        return this.couponType;
    }

    public final Integer component7() {
        return this.barAmount;
    }

    public final NearbyTabPinTopConfig$CouponInfo copy(Integer r110, String r111, String r112, String r113, String r114, String r115, Integer r116) {
        return new NearbyTabPinTopConfig$CouponInfo(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof NearbyTabPinTopConfig$CouponInfo) == true) goto L8;
        return false;
    L8:
        NearbyTabPinTopConfig$CouponInfo r101 = (NearbyTabPinTopConfig$CouponInfo) r100;
        if (Intrinsics.areEqual(this.amount, r101.amount) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.couponDesc, r101.couponDesc) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.transCouponData, r101.transCouponData) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.tittle, r101.tittle) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.couponId, r101.couponId) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.couponType, r101.couponType) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.barAmount, r101.barAmount) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        Integer r100 = this.amount;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.couponDesc;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.transCouponData;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.tittle;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.couponId;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.couponType;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Integer r119 = this.barAmount;
        if (r119 == null) goto L31;
        r101 = r119.hashCode();
    L31:
        return r118 + r101;
    L25:
        r117 = r116.hashCode();
        goto L26
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

    public String toString() {
        return "CouponInfo(amount=" + this.amount + ", couponDesc=" + this.couponDesc + ", transCouponData=" + this.transCouponData + ", tittle=" + this.tittle + ", couponId=" + this.couponId + ", couponType=" + this.couponType + ", barAmount=" + this.barAmount + ')';
    }

    public final Integer getAmount() {
        return this.amount;
    }

    public final Integer getBarAmount() {
        return this.barAmount;
    }

    public final String getCouponDesc() {
        return this.couponDesc;
    }

    public final String getCouponId() {
        return this.couponId;
    }

    public final String getCouponType() {
        return this.couponType;
    }

    public final String getTittle() {
        return this.tittle;
    }

    public final String getTransCouponData() {
        return this.transCouponData;
    }

    public NearbyTabPinTopConfig$CouponInfo(Integer r100, String r101, String r102, String r103, String r104, String r105, Integer r106) {
        this.amount = r100;
        this.couponDesc = r101;
        this.transCouponData = r102;
        this.tittle = r103;
        this.couponId = r104;
        this.couponType = r105;
        this.barAmount = r106;
    }

    public /* synthetic */ NearbyTabPinTopConfig$CouponInfo(Integer r100, String r101, String r102, String r110, String r111, String r112, Integer r113, int r114, DefaultConstructorMarker r115) {
        if ((r114 & 1) == 0) goto L5;
        Integer r116 = null;
    L7:
        if ((r114 & 2) == 0) goto L9;
        String r103 = null;
    L11:
        if ((r114 & 4) == 0) goto L13;
        String r104 = null;
    L15:
        if ((r114 & 8) == 0) goto L17;
        String r105 = null;
    L19:
        if ((r114 & 16) == 0) goto L21;
        String r106 = null;
    L23:
        if ((r114 & 32) == 0) goto L25;
        String r107 = null;
    L27:
        if ((r114 & 64) == 0) goto L29;
        Integer r117 = null;
    L30:
        this(r116, r103, r104, r105, r106, r107, r117);
        return;
    L29:
        r117 = r113;
        goto L30
    L25:
        r107 = r112;
        goto L27
    L21:
        r106 = r111;
        goto L23
    L17:
        r105 = r110;
        goto L19
    L13:
        r104 = r102;
        goto L15
    L9:
        r103 = r101;
        goto L11
    L5:
        r116 = r100;
        goto L7
    }
}
