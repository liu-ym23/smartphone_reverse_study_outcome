package com.bytedance.locallife.live.goodsshelves.bean;

import com.amap.api.col.s.ce;
import com.bytedance.locallife.live.model.LiveLocalLifeRoomInfo;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.passport.signinsdk_api.base.log.UniContext;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0017\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u0013\u001a\u0004\b\u001c\u0010\u0015R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001e\u0010\u001aR\u001c\u0010 \u001a\u0004\u0018\u00010\u001f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u001c\u0010%\u001a\u0004\u0018\u00010$8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u001c\u0010)\u001a\u0004\u0018\u00010$8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b)\u0010&\u001a\u0004\b*\u0010(R\u001c\u0010+\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b+\u0010\u0004\u001a\u0004\b,\u0010\u0006R\u001c\u0010-\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b-\u0010\u0004\u001a\u0004\b.\u0010\u0006R\u001c\u0010/\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b/\u0010\u0004\u001a\u0004\b0\u0010\u0006R\u001c\u00101\u001a\u0004\u0018\u00010$8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b1\u0010&\u001a\u0004\b2\u0010(R\u001c\u00103\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b3\u0010\u0004\u001a\u0004\b4\u0010\u0006R\u001c\u00105\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b5\u0010\u0004\u001a\u0004\b6\u0010\u0006R\u001c\u00107\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b7\u0010\u0004\u001a\u0004\b8\u0010\u0006R\u001c\u00109\u001a\u0004\u0018\u00010$8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b9\u0010&\u001a\u0004\b:\u0010(¨\u0006;"}, d2 = {"Lcom/bytedance/locallife/live/goodsshelves/bean/k;", "", "", "poiId", "Ljava/lang/String;", "h", "()Ljava/lang/String;", "skuId", "getSkuId", "allianceTaskId", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "saleChannel", "getSaleChannel", "userAddressId", "getUserAddressId", "locationId", "getLocationId", "", "cartItemId", "Ljava/lang/Long;", "getCartItemId", "()Ljava/lang/Long;", "", "hasTicketCollected", "Ljava/lang/Boolean;", "f", "()Ljava/lang/Boolean;", "accountId", "getAccountId", "needLogMemberClick", "getNeedLogMemberClick", "Lcom/bytedance/locallife/live/goodsshelves/bean/f0;", "drawTicketParams", "Lcom/bytedance/locallife/live/goodsshelves/bean/f0;", "e", "()Lcom/bytedance/locallife/live/goodsshelves/bean/f0;", "", "clueToolType", "Ljava/lang/Integer;", "d", "()Ljava/lang/Integer;", "clueSourceId", "c", "originExtendData", ce.f26391f, "starTaskId", ce.f26395j, "poiName", RXScreenCaptureService.KEY_INDEX, "storeNumbers", ce.f26396k, "bizCode", "b", "minusSaleId", "getMinusSaleId", "minusActivityId", "getMinusActivityId", "hideInSelectedTab", "getHideInSelectedTab", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final class k {

    @SerializedName("account_id")
    private final Long accountId;

    @SerializedName("alliance_task_id")
    private final String allianceTaskId;

    @SerializedName(UniContext.KEY_OF_BIZ_CODE)
    private final String bizCode;

    @SerializedName("cart_item_id")
    private final Long cartItemId;

    @SerializedName("clue_source_id")
    private final Integer clueSourceId;

    @SerializedName("clue_tool_type")
    private final Integer clueToolType;

    @SerializedName("draw_ticket_params")
    private final f0 drawTicketParams;

    @SerializedName("has_ticket_collected")
    private final Boolean hasTicketCollected;

    @SerializedName("hide_in_selected_tab")
    private final Integer hideInSelectedTab;

    @SerializedName("location_id")
    private final String locationId;

    @SerializedName("minus_activity_id")
    private final String minusActivityId;

    @SerializedName("minus_sale_id")
    private final String minusSaleId;

    @SerializedName("need_log_member_click")
    private final Boolean needLogMemberClick;

    @SerializedName("origin_extend_data")
    private final String originExtendData;

    @SerializedName("poi_id")
    private final String poiId;

    @SerializedName("poi_name")
    private final String poiName;

    @SerializedName(LiveLocalLifeRoomInfo.SALE_CHANNEL)
    private final String saleChannel;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_SKU_ID)
    private final String skuId;

    @SerializedName("star_task_id")
    private final String starTaskId;

    @SerializedName("store_numbers")
    private final Integer storeNumbers;

    @SerializedName("user_address_id")
    private final String userAddressId;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k) == true) goto L8;
        return false;
    L8:
        k r101 = (k) r100;
        if (Intrinsics.areEqual(this.poiId, r101.poiId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.skuId, r101.skuId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.allianceTaskId, r101.allianceTaskId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.saleChannel, r101.saleChannel) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.userAddressId, r101.userAddressId) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.locationId, r101.locationId) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.cartItemId, r101.cartItemId) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.hasTicketCollected, r101.hasTicketCollected) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.accountId, r101.accountId) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.needLogMemberClick, r101.needLogMemberClick) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.drawTicketParams, r101.drawTicketParams) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.clueToolType, r101.clueToolType) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.clueSourceId, r101.clueSourceId) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.originExtendData, r101.originExtendData) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.starTaskId, r101.starTaskId) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.poiName, r101.poiName) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.storeNumbers, r101.storeNumbers) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.bizCode, r101.bizCode) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.minusSaleId, r101.minusSaleId) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.minusActivityId, r101.minusActivityId) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.hideInSelectedTab, r101.hideInSelectedTab) == true) goto L71;
        return false;
    L71:
        return true;
    }

    public final int hashCode() {
        String r100 = this.poiId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.skuId;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.allianceTaskId;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.saleChannel;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.userAddressId;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.locationId;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Long r119 = this.cartItemId;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Boolean r122 = this.hasTicketCollected;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        Long r125 = this.accountId;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        Boolean r128 = this.needLogMemberClick;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        f0 r131 = this.drawTicketParams;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        Integer r134 = this.clueToolType;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        Integer r137 = this.clueSourceId;
        if (r137 != null) goto L53;
        int r138 = 0;
    L54:
        int r139 = (r136 + r138) * 31;
        String r140 = this.originExtendData;
        if (r140 != null) goto L57;
        int r141 = 0;
    L58:
        int r142 = (r139 + r141) * 31;
        String r143 = this.starTaskId;
        if (r143 != null) goto L61;
        int r144 = 0;
    L62:
        int r145 = (r142 + r144) * 31;
        String r146 = this.poiName;
        if (r146 != null) goto L65;
        int r147 = 0;
    L66:
        int r148 = (r145 + r147) * 31;
        Integer r149 = this.storeNumbers;
        if (r149 != null) goto L69;
        int r150 = 0;
    L70:
        int r151 = (r148 + r150) * 31;
        String r152 = this.bizCode;
        if (r152 != null) goto L73;
        int r153 = 0;
    L74:
        int r154 = (r151 + r153) * 31;
        String r155 = this.minusSaleId;
        if (r155 != null) goto L77;
        int r156 = 0;
    L78:
        int r157 = (r154 + r156) * 31;
        String r158 = this.minusActivityId;
        if (r158 != null) goto L81;
        int r159 = 0;
    L82:
        int r160 = (r157 + r159) * 31;
        Integer r161 = this.hideInSelectedTab;
        if (r161 == null) goto L87;
        r101 = r161.hashCode();
    L87:
        return r160 + r101;
    L81:
        r159 = r158.hashCode();
        goto L82
    L77:
        r156 = r155.hashCode();
        goto L78
    L73:
        r153 = r152.hashCode();
        goto L74
    L69:
        r150 = r149.hashCode();
        goto L70
    L65:
        r147 = r146.hashCode();
        goto L66
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
        return "LiveLifeBFFCardExtraParams(poiId=" + this.poiId + ", skuId=" + this.skuId + ", allianceTaskId=" + this.allianceTaskId + ", saleChannel=" + this.saleChannel + ", userAddressId=" + this.userAddressId + ", locationId=" + this.locationId + ", cartItemId=" + this.cartItemId + ", hasTicketCollected=" + this.hasTicketCollected + ", accountId=" + this.accountId + ", needLogMemberClick=" + this.needLogMemberClick + ", drawTicketParams=" + this.drawTicketParams + ", clueToolType=" + this.clueToolType + ", clueSourceId=" + this.clueSourceId + ", originExtendData=" + this.originExtendData + ", starTaskId=" + this.starTaskId + ", poiName=" + this.poiName + ", storeNumbers=" + this.storeNumbers + ", bizCode=" + this.bizCode + ", minusSaleId=" + this.minusSaleId + ", minusActivityId=" + this.minusActivityId + ", hideInSelectedTab=" + this.hideInSelectedTab + ')';
    }

    public final String a() {
        return this.allianceTaskId;
    }

    public final String b() {
        return this.bizCode;
    }

    public final Integer c() {
        return this.clueSourceId;
    }

    public final Integer d() {
        return this.clueToolType;
    }

    public final f0 e() {
        return this.drawTicketParams;
    }

    public final Boolean f() {
        return this.hasTicketCollected;
    }

    public final String g() {
        return this.originExtendData;
    }

    public final String h() {
        return this.poiId;
    }

    public final String i() {
        return this.poiName;
    }

    public final String j() {
        return this.starTaskId;
    }

    public final Integer k() {
        return this.storeNumbers;
    }
}
