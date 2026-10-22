package com.bytedance.locallife.live.goodsshelves.bean;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u001f\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u0004\u001a\u0004\b\u001e\u0010\u0006R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010\u0004\u001a\u0004\b\u001f\u0010\u0006R\u001c\u0010 \u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b \u0010\u0004\u001a\u0004\b \u0010\u0006¨\u0006!"}, d2 = {"Lcom/bytedance/locallife/live/goodsshelves/bean/b0;", "", "", "liveServiceTagJson", "Ljava/lang/String;", "getLiveServiceTagJson", "()Ljava/lang/String;", "liveDeliveryTime", "getLiveDeliveryTime", "newProductStockType", "getNewProductStockType", "newUserProductType", "getNewUserProductType", "productCardRank", "getProductCardRank", "brandShowSuccess", "getBrandShowSuccess", "specialShowSuccess", "getSpecialShowSuccess", "showPriceType", "getShowPriceType", "shelfProductDeliveryShowType", "getShelfProductDeliveryShowType", "isProductDeliveryAfterBug", "isExplainStatus", "entryType", "getEntryType", "productJoinActivityType", "getProductJoinActivityType", "hasMemberPrice", "getHasMemberPrice", "isMember", "isMemberExclusive", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final class b0 {

    @SerializedName("brand_show_success")
    private final String brandShowSuccess;

    @SerializedName("entry_type")
    private final String entryType;

    @SerializedName("has_member_price")
    private final String hasMemberPrice;

    @SerializedName("is_explain_status")
    private final String isExplainStatus;

    @SerializedName("is_member")
    private final String isMember;

    @SerializedName("is_member_exclusive")
    private final String isMemberExclusive;

    @SerializedName("is_product_delivery_after_bug")
    private final String isProductDeliveryAfterBug;

    @SerializedName("live_delivery_time")
    private final String liveDeliveryTime;

    @SerializedName("live_service_tag_json")
    private final String liveServiceTagJson;

    @SerializedName("new_product_stock_type")
    private final String newProductStockType;

    @SerializedName("new_user_product_type")
    private final String newUserProductType;

    @SerializedName("product_card_rank")
    private final String productCardRank;

    @SerializedName("product_join_activity_type")
    private final String productJoinActivityType;

    @SerializedName("shelf_product_delivery_show_type")
    private final String shelfProductDeliveryShowType;

    @SerializedName("show_price_type")
    private final String showPriceType;

    @SerializedName("special_show_success")
    private final String specialShowSuccess;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b0) == true) goto L8;
        return false;
    L8:
        b0 r101 = (b0) r100;
        if (Intrinsics.areEqual(this.liveServiceTagJson, r101.liveServiceTagJson) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.liveDeliveryTime, r101.liveDeliveryTime) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.newProductStockType, r101.newProductStockType) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.newUserProductType, r101.newUserProductType) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.productCardRank, r101.productCardRank) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.brandShowSuccess, r101.brandShowSuccess) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.specialShowSuccess, r101.specialShowSuccess) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.showPriceType, r101.showPriceType) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.shelfProductDeliveryShowType, r101.shelfProductDeliveryShowType) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.isProductDeliveryAfterBug, r101.isProductDeliveryAfterBug) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.isExplainStatus, r101.isExplainStatus) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.entryType, r101.entryType) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.productJoinActivityType, r101.productJoinActivityType) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.hasMemberPrice, r101.hasMemberPrice) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.isMember, r101.isMember) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.isMemberExclusive, r101.isMemberExclusive) == true) goto L56;
        return false;
    L56:
        return true;
    }

    public final int hashCode() {
        String r100 = this.liveServiceTagJson;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.liveDeliveryTime;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.newProductStockType;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.newUserProductType;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.productCardRank;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.brandShowSuccess;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.specialShowSuccess;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.showPriceType;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.shelfProductDeliveryShowType;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.isProductDeliveryAfterBug;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        String r131 = this.isExplainStatus;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        String r134 = this.entryType;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        String r137 = this.productJoinActivityType;
        if (r137 != null) goto L53;
        int r138 = 0;
    L54:
        int r139 = (r136 + r138) * 31;
        String r140 = this.hasMemberPrice;
        if (r140 != null) goto L57;
        int r141 = 0;
    L58:
        int r142 = (r139 + r141) * 31;
        String r143 = this.isMember;
        if (r143 != null) goto L61;
        int r144 = 0;
    L62:
        int r145 = (r142 + r144) * 31;
        String r146 = this.isMemberExclusive;
        if (r146 == null) goto L67;
        r101 = r146.hashCode();
    L67:
        return r145 + r101;
    L61:
        r144 = r143.hashCode();
        goto L62
    L57:
        r141 = r140.hashCode();
        goto L58
    L53:
        r138 = r137.hashCode();
        goto L54
    L49:
        r135 = r134.hashCode();
        goto L50
    L45:
        r132 = r131.hashCode();
        goto L46
    L41:
        r129 = r128.hashCode();
        goto L42
    L37:
        r126 = r125.hashCode();
        goto L38
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
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

    public final String toString() {
        return "LiveLifeBFFCardSessionInfo(liveServiceTagJson=" + this.liveServiceTagJson + ", liveDeliveryTime=" + this.liveDeliveryTime + ", newProductStockType=" + this.newProductStockType + ", newUserProductType=" + this.newUserProductType + ", productCardRank=" + this.productCardRank + ", brandShowSuccess=" + this.brandShowSuccess + ", specialShowSuccess=" + this.specialShowSuccess + ", showPriceType=" + this.showPriceType + ", shelfProductDeliveryShowType=" + this.shelfProductDeliveryShowType + ", isProductDeliveryAfterBug=" + this.isProductDeliveryAfterBug + ", isExplainStatus=" + this.isExplainStatus + ", entryType=" + this.entryType + ", productJoinActivityType=" + this.productJoinActivityType + ", hasMemberPrice=" + this.hasMemberPrice + ", isMember=" + this.isMember + ", isMemberExclusive=" + this.isMemberExclusive + ')';
    }
}
